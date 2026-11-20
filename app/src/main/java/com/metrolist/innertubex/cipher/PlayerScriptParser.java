package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlayerScriptParser {
    public static final Regex functionPattern = new Regex("(?:var\\s+)?([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*=\\s*function\\s*\\(\\s*a\\s*\\)\\s*\\{");
    public static final Set REGEX_PREFIX_KEYWORDS = ArraysKt.toSet(new String[]{"await", "case", "delete", "do", "else", "in", "instanceof", "new", "of", "return", "throw", "typeof", "void", "yield"});
    public static final Set CONTROL_PARENTHESIS_KEYWORDS = ArraysKt.toSet(new String[]{"catch", "for", "if", "switch", "while", "with"});

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FunctionMatch {
        public final String name;

        public FunctionMatch(String str) {
            str.getClass();
            this.name = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FunctionMatch) && Intrinsics.areEqual(this.name, ((FunctionMatch) obj).name);
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("FunctionMatch(name=", this.name, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ParseResult {
        public final LinkedHashMap helperFunctions;
        public final String nFunctionCode;
        public final String nInvoker;
        public final String sigFunctionCode;
        public final String sigInvoker;

        public ParseResult(String str, String str2, String str3, String str4, LinkedHashMap linkedHashMap) {
            this.nFunctionCode = str;
            this.nInvoker = str2;
            this.sigFunctionCode = str3;
            this.sigInvoker = str4;
            this.helperFunctions = linkedHashMap;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParseResult)) {
                return false;
            }
            ParseResult parseResult = (ParseResult) obj;
            return Intrinsics.areEqual(this.nFunctionCode, parseResult.nFunctionCode) && Intrinsics.areEqual(this.nInvoker, parseResult.nInvoker) && Intrinsics.areEqual(this.sigFunctionCode, parseResult.sigFunctionCode) && Intrinsics.areEqual(this.sigInvoker, parseResult.sigInvoker) && this.helperFunctions.equals(parseResult.helperFunctions);
        }

        public final int hashCode() {
            String str = this.nFunctionCode;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.nInvoker;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sigFunctionCode;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.sigInvoker;
            return this.helperFunctions.hashCode() + ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ParseResult(nFunctionCode=", this.nFunctionCode, ", nInvoker=", this.nInvoker, ", sigFunctionCode=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.sigFunctionCode, ", sigInvoker=", this.sigInvoker, ", helperFunctions=");
            sbM.append(this.helperFunctions);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ScanState {
        public static final /* synthetic */ ScanState[] $VALUES;
        public static final ScanState BLOCK_COMMENT;
        public static final ScanState CODE;
        public static final ScanState LINE_COMMENT;
        public static final ScanState REGEX;
        public static final ScanState STRING;
        public static final ScanState TEMPLATE;

        static {
            ScanState scanState = new ScanState("CODE", 0);
            CODE = scanState;
            ScanState scanState2 = new ScanState("STRING", 1);
            STRING = scanState2;
            ScanState scanState3 = new ScanState("TEMPLATE", 2);
            TEMPLATE = scanState3;
            ScanState scanState4 = new ScanState("LINE_COMMENT", 3);
            LINE_COMMENT = scanState4;
            ScanState scanState5 = new ScanState("BLOCK_COMMENT", 4);
            BLOCK_COMMENT = scanState5;
            ScanState scanState6 = new ScanState("REGEX", 5);
            REGEX = scanState6;
            $VALUES = new ScanState[]{scanState, scanState2, scanState3, scanState4, scanState5, scanState6};
        }

        public static ScanState valueOf(String str) {
            return (ScanState) Enum.valueOf(ScanState.class, str);
        }

        public static ScanState[] values() {
            return (ScanState[]) $VALUES.clone();
        }
    }

    public static String extractFunctionByName(String str, String str2) {
        int i;
        int iFindFunctionEnd;
        str2.getClass();
        String strQuote = Pattern.quote(str2);
        strQuote.getClass();
        Regex regex = new Regex("(?s)var\\s+" + strQuote + "\\s*=\\s*function\\s*\\([^)]*\\)\\s*\\{");
        String strQuote2 = Pattern.quote(str2);
        strQuote2.getClass();
        Regex regex2 = new Regex("(?s)function\\s+" + strQuote2 + "\\s*\\([^)]*\\)\\s*\\{");
        String strQuote3 = Pattern.quote(str2);
        strQuote3.getClass();
        Iterator it = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{regex, regex2, new Regex("(?s)" + strQuote3 + "\\s*=\\s*function\\s*\\([^)]*\\)\\s*\\{")}).iterator();
        while (it.hasNext()) {
            MatcherMatchResult matcherMatchResultFind$default = Regex.find$default((Regex) it.next(), str);
            if (matcherMatchResultFind$default != null && (iFindFunctionEnd = findFunctionEnd((i = matcherMatchResultFind$default.getRange().first), str)) > i) {
                return str.substring(i, iFindFunctionEnd);
            }
        }
        return null;
    }

    public static Pair extractSplitJoinByIndex(int i, String str) {
        List list = SequencesKt.toList(SequencesKt.mapNotNull(Regex.findAll$default(functionPattern, str), new IconKt$$ExternalSyntheticLambda1(str, (byte) 12)));
        if (list.size() <= i) {
            return new Pair(null, null);
        }
        String str2 = ((FunctionMatch) list.get(i)).name;
        String strExtractFunctionByName = extractFunctionByName(str, str2);
        return strExtractFunctionByName == null ? new Pair(null, null) : new Pair(strExtractFunctionByName, str2);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0163  */
    /* JADX WARN: Code duplicated, block: B:106:0x0167  */
    /* JADX WARN: Code duplicated, block: B:113:0x017c  */
    /* JADX WARN: Code duplicated, block: B:119:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:11:0x002d A[PHI: r18
      0x002d: PHI (r18v3 int) = (r18v0 int), (r18v0 int), (r18v4 int) binds: [B:140:0x01e0, B:42:0x0088, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:121:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:122:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:124:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:125:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:127:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x01e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x006a A[PHI: r7 r9
      0x006a: PHI (r7v2 com.metrolist.innertubex.cipher.PlayerScriptParser$ScanState) = 
      (r7v1 com.metrolist.innertubex.cipher.PlayerScriptParser$ScanState)
      (r7v3 com.metrolist.innertubex.cipher.PlayerScriptParser$ScanState)
      (r7v1 com.metrolist.innertubex.cipher.PlayerScriptParser$ScanState)
     binds: [B:135:0x01d6, B:134:0x01d2, B:29:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r9v2 char) = (r9v1 char), (r9v3 char), (r9v1 char) binds: [B:135:0x01d6, B:134:0x01d2, B:29:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x0071  */
    public static int findFunctionEnd(int i, String str) {
        int i2;
        ScanState scanState;
        char c;
        int i3;
        int i4;
        int i5;
        boolean zContains;
        Character orNull;
        Character orNull2;
        Character orNull3;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        ScanState scanState2 = ScanState.CODE;
        boolean z = false;
        boolean z2 = false;
        char c2 = 0;
        boolean z3 = false;
        boolean zAreEqual = false;
        int i6 = 0;
        int i7 = i;
        ScanState scanState3 = scanState2;
        while (i7 < length) {
            if (z) {
                i2 = length;
                z = false;
            } else {
                char cCharAt = str.charAt(i7);
                ScanState scanState4 = ScanState.LINE_COMMENT;
                if (scanState3 != scanState4) {
                    ScanState scanState5 = ScanState.BLOCK_COMMENT;
                    if (scanState3 != scanState5) {
                        ScanState scanState6 = ScanState.STRING;
                        i2 = length;
                        if (scanState3 != scanState6 && scanState3 != (scanState = ScanState.TEMPLATE)) {
                            ScanState scanState7 = ScanState.REGEX;
                            if (scanState3 != scanState7) {
                                if (cCharAt == '/') {
                                    Character orNull4 = StringsKt.getOrNull(i7 + 1, str);
                                    if (orNull4 == null) {
                                        c = '/';
                                    } else {
                                        c = '/';
                                        if (orNull4.charValue() == '/') {
                                            scanState3 = scanState4;
                                        }
                                    }
                                } else {
                                    c = '/';
                                }
                                if (cCharAt == c && (orNull2 = StringsKt.getOrNull(i7 + 1, str)) != null && orNull2.charValue() == '*') {
                                    scanState3 = scanState5;
                                } else if (cCharAt == '\"' || cCharAt == '\'') {
                                    c2 = cCharAt;
                                    scanState3 = scanState6;
                                    z2 = false;
                                } else {
                                    if (cCharAt == '`') {
                                        c2 = '`';
                                        scanState3 = scanState;
                                        z2 = false;
                                    } else if (cCharAt == '/') {
                                        if (!zAreEqual) {
                                            int i8 = i7 - 1;
                                            while (i8 >= 0 && CharsKt.isWhitespace(str.charAt(i8))) {
                                                i8--;
                                            }
                                            if (i8 < 0 || StringsKt.contains$default("=([{,:;!&|?", str.charAt(i8)) || (str.charAt(i8) == '>' && (orNull = StringsKt.getOrNull(i8 - 1, str)) != null && orNull.charValue() == '=')) {
                                                zContains = true;
                                            } else if (Character.isLetterOrDigit(str.charAt(i8)) || StringsKt.contains$default("_$", str.charAt(i8))) {
                                                int i9 = i8 + 1;
                                                while (i8 >= 0 && (Character.isLetterOrDigit(str.charAt(i8)) || StringsKt.contains$default("_$", str.charAt(i8)))) {
                                                    i8--;
                                                }
                                                zContains = REGEX_PREFIX_KEYWORDS.contains(str.substring(i8 + 1, i9));
                                            } else {
                                                zContains = false;
                                            }
                                            if (!zContains) {
                                                if (cCharAt == '(') {
                                                    i3 = i7;
                                                    while (i3 > 0) {
                                                        i3--;
                                                    }
                                                    i4 = i3;
                                                    while (i4 > 0) {
                                                        i5 = i4 - 1;
                                                        if (Character.isLetterOrDigit(str.charAt(i5))) {
                                                        }
                                                        i4--;
                                                    }
                                                    arrayList.add(Boolean.valueOf(CONTROL_PARENTHESIS_KEYWORDS.contains(str.substring(i4, i3))));
                                                } else if (cCharAt == ')') {
                                                    zAreEqual = Intrinsics.areEqual(CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList), Boolean.TRUE);
                                                } else if (cCharAt == '{') {
                                                    i6++;
                                                } else if (cCharAt == '}') {
                                                    i6--;
                                                    if (i6 == 0) {
                                                        return i7 + 1;
                                                    }
                                                } else if (!CharsKt.isWhitespace(cCharAt)) {
                                                }
                                            }
                                        }
                                        scanState3 = scanState7;
                                        z2 = false;
                                        z3 = false;
                                    } else if (cCharAt == '(') {
                                        i3 = i7;
                                        while (i3 > 0 && CharsKt.isWhitespace(str.charAt(i3 - 1))) {
                                            i3--;
                                        }
                                        i4 = i3;
                                        while (i4 > 0) {
                                            i5 = i4 - 1;
                                            if (Character.isLetterOrDigit(str.charAt(i5)) && !StringsKt.contains$default("_$", str.charAt(i5))) {
                                                break;
                                            }
                                            i4--;
                                        }
                                        arrayList.add(Boolean.valueOf(CONTROL_PARENTHESIS_KEYWORDS.contains(str.substring(i4, i3))));
                                    } else if (cCharAt == ')') {
                                        zAreEqual = Intrinsics.areEqual(CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList), Boolean.TRUE);
                                    } else if (cCharAt == '{') {
                                        i6++;
                                    } else if (cCharAt == '}') {
                                        i6--;
                                        if (i6 == 0) {
                                            return i7 + 1;
                                        }
                                    } else if (!CharsKt.isWhitespace(cCharAt)) {
                                    }
                                    zAreEqual = false;
                                }
                            } else if (z2) {
                                z2 = false;
                            } else if (cCharAt == '\\') {
                                z2 = true;
                            } else if (cCharAt == '[') {
                                z3 = true;
                            } else if (cCharAt == ']') {
                                z3 = false;
                            } else if (cCharAt == '/' && !z3) {
                                scanState3 = scanState2;
                            }
                        } else if (z2) {
                            z2 = false;
                        } else if (cCharAt == '\\') {
                            z2 = true;
                        } else if (cCharAt == c2) {
                            scanState3 = scanState2;
                        }
                    } else if (cCharAt == '*' && (orNull3 = StringsKt.getOrNull(i7 + 1, str)) != null && orNull3.charValue() == '/') {
                        i2 = length;
                        scanState3 = scanState2;
                        z = true;
                    } else {
                        i2 = length;
                    }
                } else if (cCharAt == '\n') {
                    i2 = length;
                    scanState3 = scanState2;
                } else {
                    i2 = length;
                }
            }
            i7++;
            length = i2;
        }
        return -1;
    }
}
