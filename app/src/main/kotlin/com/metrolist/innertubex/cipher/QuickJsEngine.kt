package com.metrolist.innertubex.cipher

import com.dokar.quickjs.QuickJs
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

class QuickJsEngine {
    class Runtime(
        val js: QuickJs,
        val thread: ExecutorCoroutineDispatcher,
    )

    private val mutex = Mutex()
    private var runtime: Runtime? = null

    suspend fun initialize(): Unit = mutex.withLock {
        if (runtime == null) {
            withContext(NonCancellable) {
                val threadCounter = AtomicInteger()
                val executor = Executors.unconfigurableExecutorService(
                    Executors.newScheduledThreadPool(1) { runnable ->
                        Thread(runnable, "quickjs-worker-${threadCounter.incrementAndGet()}").apply {
                            isDaemon = true
                        }
                    }
                )
                val dispatcher = executor.asCoroutineDispatcher()
                try {
                    val js = withContext(dispatcher) {
                        QuickJs.create(jobDispatcher = dispatcher)
                    }
                    runtime = Runtime(js, dispatcher)
                } catch (e: Throwable) {
                    dispatcher.close()
                    throw e
                }
            }
        }
    }

    suspend fun dispose(): Unit = withContext(NonCancellable) {
        mutex.withLock {
            val currentRuntime = runtime ?: return@withLock
            runtime = null
            try {
                withContext(currentRuntime.thread) {
                    currentRuntime.js.close()
                }
            } finally {
                currentRuntime.thread.close()
            }
        }
    }

    suspend fun <T> withRuntime(block: suspend (QuickJs) -> T): T = mutex.withLock {
        val currentRuntime = runtime ?: error("QuickJS not initialized")
        withContext(currentRuntime.thread) {
            block(currentRuntime.js)
        }
    }

    suspend fun execute(script: String) {
        withRuntime { js ->
            js.evaluate<Any?>(script)
            Unit
        }
    }

    suspend fun callFunction(functionName: String, argument: String): String? {
        if (!JS_IDENTIFIER.matches(functionName)) {
            require(false) { "Invalid JavaScript function name" }
            return null
        }
        if (argument.length > 65536) {
            return null
        }
        return withRuntime { js ->
            val script = """
                (function() {
                  const value = $functionName(${argument.jsStringLiteral()});
                  if (value == null) return null;
                  const text = String(value);
                  return text.length <= 262144 ? text : null;
                })()
            """.trimIndent()
            js.evaluate<String?>(script)
        }
    }

    companion object {
        private val JS_IDENTIFIER = Regex("[A-Za-z_\$][A-Za-z0-9_\$]*")
    }
}

internal fun String.jsStringLiteral(): String {
    val sb = StringBuilder(length + 2)
    sb.append('"')
    for (i in 0 until length) {
        val c = this[i]
        when (c) {
            '\t' -> sb.append("\\t")
            '\n' -> sb.append("\\n")
            '\r' -> sb.append("\\r")
            '"' -> sb.append("\\\"")
            '\\' -> sb.append("\\\\")
            else -> {
                if (c < ' ') {
                    val hex = c.code.toString(16).padStart(4, '0')
                    sb.append("\\u$hex")
                } else {
                    sb.append(c)
                }
            }
        }
    }
    sb.append('"')
    return sb.toString()
}
