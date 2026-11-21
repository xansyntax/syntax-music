package com.metrolist.innertubex.cipher

import java.util.regex.Pattern

object PlayerScriptParser {
    val functionPattern = Regex("""(?:var\s+)?([a-zA-Z_${'$'}][a-zA-Z0-9_${'$'}]*)\s*=\s*function\s*\(\s*a\s*\)\s*\{""")
    val REGEX_PREFIX_KEYWORDS = setOf(
        "await", "case", "delete", "do", "else", "in", "instanceof",
        "new", "of", "return", "throw", "typeof", "void", "yield"
    )
    val CONTROL_PARENTHESIS_KEYWORDS = setOf("catch", "for", "if", "switch", "while", "with")

    data class FunctionMatch(val name: String)

    data class ParseResult(
        val nFunctionCode: String?,
        val nInvoker: String?,
        val sigFunctionCode: String?,
        val sigInvoker: String?,
        val helperFunctions: LinkedHashMap<String, String>,
    )

    enum class ScanState {
        CODE,
        STRING,
        TEMPLATE,
        LINE_COMMENT,
        BLOCK_COMMENT,
        REGEX,
    }

    fun extractFunctionByName(script: String, functionName: String): String? {
        val quoted = Pattern.quote(functionName)
        val patterns = listOf(
            Regex("(?s)var\\s+$quoted\\s*=\\s*function\\s*\\([^)]*\\)\\s*\\{"),
            Regex("(?s)function\\s+$quoted\\s*\\([^)]*\\)\\s*\\{"),
            Regex("(?s)$quoted\\s*=\\s*function\\s*\\([^)]*\\)\\s*\\{"),
        )
        for (pattern in patterns) {
            val match = pattern.find(script)
            if (match != null) {
                val start = match.range.first
                val end = findFunctionEnd(start, script)
                if (end > start) {
                    return script.substring(start, end)
                }
            }
        }
        return null
    }

    fun extractSplitJoinByIndex(index: Int, script: String): Pair<String?, String?> {
        val splitRegex = Regex("""a\s*=\s*a\.split\s*\(\s*""\s*\)""")
        val joinRegex = Regex("""return\s+a\.join\s*\(\s*""\s*\)""")
        val matches = functionPattern.findAll(script).mapNotNull { match ->
            val start = match.range.first
            val end = findFunctionEnd(start, script)
            if (end > start) {
                val body = script.substring(start, end)
                if (splitRegex.containsMatchIn(body) && joinRegex.containsMatchIn(body)) {
                    FunctionMatch(match.groupValues[1])
                } else null
            } else null
        }.toList()

        if (matches.size <= index) {
            return Pair(null, null)
        }
        val name = matches[index].name
        val code = extractFunctionByName(script, name)
        return if (code == null) Pair(null, null) else Pair(code, name)
    }

    fun findFunctionEnd(start: Int, script: String): Int {
        val parenStack = ArrayList<Boolean>()
        val length = script.length
        var state = ScanState.CODE
        var escape = false
        var stringQuote = ' '
        var inCharset = false
        var afterControlParen = false
        var braceDepth = 0
        var i = start

        while (i < length) {
            val c = script[i]
            when (state) {
                ScanState.LINE_COMMENT -> {
                    if (c == '\n') {
                        state = ScanState.CODE
                    }
                }
                ScanState.BLOCK_COMMENT -> {
                    if (c == '*' && script.getOrNull(i + 1) == '/') {
                        state = ScanState.CODE
                        i++
                    }
                }
                ScanState.STRING -> {
                    if (escape) {
                        escape = false
                    } else if (c == '\\') {
                        escape = true
                    } else if (c == stringQuote) {
                        state = ScanState.CODE
                    }
                }
                ScanState.TEMPLATE -> {
                    if (escape) {
                        escape = false
                    } else if (c == '\\') {
                        escape = true
                    } else if (c == '`') {
                        state = ScanState.CODE
                    }
                }
                ScanState.REGEX -> {
                    if (escape) {
                        escape = false
                    } else if (c == '\\') {
                        escape = true
                    } else if (c == '[') {
                        inCharset = true
                    } else if (c == ']') {
                        inCharset = false
                    } else if (c == '/' && !inCharset) {
                        state = ScanState.CODE
                    }
                }
                ScanState.CODE -> {
                    if (c == '/' && script.getOrNull(i + 1) == '/') {
                        state = ScanState.LINE_COMMENT
                    } else if (c == '/' && script.getOrNull(i + 1) == '*') {
                        state = ScanState.BLOCK_COMMENT
                    } else if (c == '"' || c == '\'') {
                        stringQuote = c
                        state = ScanState.STRING
                        escape = false
                    } else if (c == '`') {
                        stringQuote = '`'
                        state = ScanState.TEMPLATE
                        escape = false
                    } else if (c == '/') {
                        var isRegex = false
                        if (!afterControlParen) {
                            var prev = i - 1
                            while (prev >= 0 && script[prev].isWhitespace()) {
                                prev--
                            }
                            if (prev < 0 || "=([{,:;!&|?".contains(script[prev]) ||
                                (script[prev] == '>' && script.getOrNull(prev - 1) == '=')
                            ) {
                                isRegex = true
                            } else if (script[prev].isLetterOrDigit() || "_$".contains(script[prev])) {
                                val endWord = prev + 1
                                while (prev >= 0 && (script[prev].isLetterOrDigit() || "_$".contains(script[prev]))) {
                                    prev--
                                }
                                val word = script.substring(prev + 1, endWord)
                                isRegex = REGEX_PREFIX_KEYWORDS.contains(word)
                            }
                        }
                        if (isRegex) {
                            state = ScanState.REGEX
                            escape = false
                            inCharset = false
                        }
                    } else if (c == '(') {
                        var prev = i
                        while (prev > 0 && script[prev - 1].isWhitespace()) {
                            prev--
                        }
                        var wordStart = prev
                        while (wordStart > 0) {
                            val ch = script[wordStart - 1]
                            if (!ch.isLetterOrDigit() && !"_$".contains(ch)) {
                                break
                            }
                            wordStart--
                        }
                        val word = script.substring(wordStart, prev)
                        parenStack.add(CONTROL_PARENTHESIS_KEYWORDS.contains(word))
                    } else if (c == ')') {
                        afterControlParen = parenStack.removeLastOrNull() == true
                    } else if (c == '{') {
                        braceDepth++
                    } else if (c == '}') {
                        braceDepth--
                        if (braceDepth == 0) {
                            return i + 1
                        }
                    }
                    if (c != ')') {
                        afterControlParen = false
                    }
                }
            }
            i++
        }
        return -1
    }
}
