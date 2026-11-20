package kotlinx.serialization.json.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecodingException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractJsonLexer {
    public final /* synthetic */ byte $r8$classId;
    public final Object configuration;
    public int currentPosition;
    public Object escapedString;
    public final Object path;
    public Object peekedString;

    public AbstractJsonLexer(JsonConfiguration jsonConfiguration) {
        this.$r8$classId = (byte) 0;
        this.configuration = jsonConfiguration;
        this.path = new JsonPath(jsonConfiguration);
        this.escapedString = new StringBuilder();
    }

    public static /* synthetic */ void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i, String str2, int i2) {
        if ((i2 & 2) != 0) {
            i = abstractJsonLexer.currentPosition;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        abstractJsonLexer.fail(i, str, str2);
        throw null;
    }

    public static boolean isValidValueStart(char c) {
        return (c == ',' || c == ':' || c == ']' || c == '}') ? false : true;
    }

    public void advance$1() {
        this.peekedString = (Map.Entry) this.escapedString;
        Iterator it = (Iterator) this.path;
        this.escapedString = it.hasNext() ? (Map.Entry) it.next() : null;
    }

    public int appendHex(CharSequence charSequence, int i) {
        int i2 = i + 4;
        if (i2 < charSequence.length()) {
            ((StringBuilder) this.escapedString).append((char) (fromHexChar(charSequence, i + 3) + (fromHexChar(charSequence, i) << 12) + (fromHexChar(charSequence, i + 1) << 8) + (fromHexChar(charSequence, i + 2) << 4)));
            return i2;
        }
        this.currentPosition = i;
        ensureHaveChars();
        if (this.currentPosition + 4 < charSequence.length()) {
            return appendHex(charSequence, this.currentPosition);
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    public void appendRange(int i, int i2) {
        ((StringBuilder) this.escapedString).append(getSource(), i, i2);
    }

    public abstract boolean canConsumeValue();

    public void consumeBooleanLiteral(int i, String str) {
        if (getSource().length() - i < str.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != (getSource().charAt(i + i2) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.currentPosition = str.length() + i;
    }

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public byte consumeNextToken(byte b) {
        byte bConsumeNextToken = consumeNextToken();
        if (bConsumeNextToken == b) {
            return bConsumeNextToken;
        }
        String str = WriteModeKt.tokenDescription(b);
        int i = this.currentPosition;
        int i2 = i > 0 ? i - 1 : i;
        fail$default(this, Fragment$5$$ExternalSyntheticOutline0.m("Expected ", str, ", but had '", (i == getSource().length() || i2 < 0) ? "EOF" : String.valueOf(getSource().charAt(i2)), "' instead"), i2, null, 4);
        throw null;
    }

    public abstract void consumeNextToken(char c);

    public long consumeNumericLiteral() {
        boolean z;
        boolean z2;
        boolean z3;
        double dPow;
        int iPrefetchOrEof = prefetchOrEof(skipWhitespaces());
        if (iPrefetchOrEof >= getSource().length() || iPrefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6);
            throw null;
        }
        if (getSource().charAt(iPrefetchOrEof) == '\"') {
            iPrefetchOrEof++;
            if (iPrefetchOrEof == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6);
                throw null;
            }
            z = true;
        } else {
            z = false;
        }
        int i = iPrefetchOrEof;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        long j = 0;
        long j2 = 0;
        while (true) {
            if (i == getSource().length()) {
                z = z;
                z2 = z5;
                z3 = z6;
                break;
            }
            char cCharAt = getSource().charAt(i);
            z = z;
            if ((cCharAt != 'e' && cCharAt != 'E') || z5) {
                z2 = z5;
                if (cCharAt == '-' && z2) {
                    if (i == iPrefetchOrEof) {
                        fail$default(this, "Unexpected symbol '-' in numeric literal", i, null, 4);
                        throw null;
                    }
                    i++;
                    z5 = z2;
                    z4 = false;
                } else if (cCharAt != '+' || !z2) {
                    z3 = z6;
                    if (cCharAt != '-') {
                        if (WriteModeKt.charToTokenClass(cCharAt) != 0) {
                            break;
                        }
                        int i2 = i + 1;
                        int i3 = cCharAt - '0';
                        if (i3 < 0 || i3 >= 10) {
                            fail$default(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", i, null, 4);
                            throw null;
                        }
                        if (z2) {
                            j = (j * 10) + ((long) i3);
                        } else {
                            j2 = (j2 * 10) - ((long) i3);
                            if (j2 > 0) {
                                fail$default(this, "Numeric value overflow", 0, null, 6);
                                throw null;
                            }
                        }
                        i = i2;
                        z5 = z2;
                        z6 = z3;
                    } else {
                        if (i != iPrefetchOrEof) {
                            fail$default(this, "Unexpected symbol '-' in numeric literal", i, null, 4);
                            throw null;
                        }
                        i++;
                        z5 = z2;
                        z6 = true;
                    }
                } else {
                    if (i == iPrefetchOrEof) {
                        fail$default(this, "Unexpected symbol '+' in numeric literal", i, null, 4);
                        throw null;
                    }
                    i++;
                    z5 = z2;
                    z4 = true;
                }
            } else {
                if (i == iPrefetchOrEof) {
                    fail$default(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", i, null, 4);
                    throw null;
                }
                i++;
                z4 = true;
                z5 = true;
            }
        }
        boolean z7 = i != iPrefetchOrEof;
        if (iPrefetchOrEof == i || (z3 && iPrefetchOrEof == i - 1)) {
            fail$default(this, "Expected numeric literal", i, null, 4);
            throw null;
        }
        if (z) {
            if (!z7) {
                fail$default(this, "EOF", 0, null, 6);
                throw null;
            }
            if (getSource().charAt(i) != '\"') {
                fail$default(this, "Expected closing quotation mark", i, null, 4);
                throw null;
            }
            i++;
        }
        this.currentPosition = i;
        if (z2) {
            double d = j2;
            if (!z4) {
                dPow = Math.pow(10.0d, -j);
            } else {
                if (!z4) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return 0L;
                }
                dPow = Math.pow(10.0d, j);
            }
            double d2 = d * dPow;
            if (d2 > 9.223372036854776E18d || d2 < -9.223372036854776E18d) {
                fail$default(this, "Numeric value overflow", 0, null, 6);
                throw null;
            }
            if (Math.floor(d2) != d2) {
                fail$default(this, "Can't convert " + d2 + " to Long", 0, null, 6);
                throw null;
            }
            j2 = (long) d2;
        }
        if (z3) {
            return j2;
        }
        if (j2 != Long.MIN_VALUE) {
            return -j2;
        }
        fail$default(this, "Numeric value overflow", 0, null, 6);
        throw null;
    }

    public String consumeString(CharSequence charSequence, int i, int i2) {
        String string;
        StringBuilder sb = (StringBuilder) this.escapedString;
        charSequence.getClass();
        char cCharAt = charSequence.charAt(i2);
        boolean z = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                appendRange(i, i2);
                int iPrefetchOrEof = prefetchOrEof(i2 + 1);
                if (iPrefetchOrEof == -1) {
                    fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                    throw null;
                }
                int iAppendHex = iPrefetchOrEof + 1;
                char cCharAt2 = getSource().charAt(iPrefetchOrEof);
                if (cCharAt2 == 'u') {
                    iAppendHex = appendHex(getSource(), iAppendHex);
                } else {
                    char c = cCharAt2 < 'u' ? CharMappings.ESCAPE_2_CHAR[cCharAt2] : (char) 0;
                    if (c == 0) {
                        fail$default(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                        throw null;
                    }
                    sb.append(c);
                }
                i = prefetchOrEof(iAppendHex);
                if (i == -1) {
                    fail$default(this, "Unexpected EOF", i, null, 4);
                    throw null;
                }
            } else {
                i2++;
                if (i2 >= charSequence.length()) {
                    appendRange(i, i2);
                    i = prefetchOrEof(i2);
                    if (i == -1) {
                        fail$default(this, "Unexpected EOF", i, null, 4);
                        throw null;
                    }
                } else {
                    continue;
                }
                cCharAt = charSequence.charAt(i2);
            }
            i2 = i;
            z = true;
            cCharAt = charSequence.charAt(i2);
        }
        if (z) {
            appendRange(i, i2);
            string = sb.toString();
            sb.setLength(0);
        } else {
            string = substring(i, i2);
        }
        this.currentPosition = i2 + 1;
        return string;
    }

    public String consumeStringLenient() {
        String strSubstring;
        StringBuilder sb = (StringBuilder) this.escapedString;
        String str = (String) this.peekedString;
        if (str != null) {
            str.getClass();
            this.peekedString = null;
            return str;
        }
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= getSource().length() || iSkipWhitespaces == -1) {
            fail$default(this, "EOF", iSkipWhitespaces, null, 4);
            throw null;
        }
        byte bCharToTokenClass = WriteModeKt.charToTokenClass(getSource().charAt(iSkipWhitespaces));
        if (bCharToTokenClass == 1) {
            return consumeString();
        }
        if (bCharToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(iSkipWhitespaces), 0, null, 6);
            throw null;
        }
        boolean z = false;
        while (WriteModeKt.charToTokenClass(getSource().charAt(iSkipWhitespaces)) == 0) {
            iSkipWhitespaces++;
            if (iSkipWhitespaces >= getSource().length()) {
                appendRange(this.currentPosition, iSkipWhitespaces);
                int iPrefetchOrEof = prefetchOrEof(iSkipWhitespaces);
                if (iPrefetchOrEof == -1) {
                    this.currentPosition = iSkipWhitespaces;
                    appendRange(0, 0);
                    String string = sb.toString();
                    sb.setLength(0);
                    return string;
                }
                iSkipWhitespaces = iPrefetchOrEof;
                z = true;
            }
        }
        int i = this.currentPosition;
        if (z) {
            appendRange(i, iSkipWhitespaces);
            String string2 = sb.toString();
            sb.setLength(0);
            strSubstring = string2;
        } else {
            strSubstring = substring(i, iSkipWhitespaces);
        }
        this.currentPosition = iSkipWhitespaces;
        return strSubstring;
    }

    public String consumeStringLenientNotNull() {
        String strConsumeStringLenient = consumeStringLenient();
        if (!Intrinsics.areEqual(strConsumeStringLenient, "null") || getSource().charAt(this.currentPosition - 1) == '\"') {
            return strConsumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
        throw null;
    }

    public void expectEof() {
        if (consumeNextToken() == 10) {
            return;
        }
        fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6);
        throw null;
    }

    public void fail(int i, String str, String str2) {
        String path = ((JsonPath) this.path).getPath();
        CharSequence source = getSource();
        source.getClass();
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(i, str, path, str2, ((JsonConfiguration) this.configuration).exceptionsWithDebugInfo ? WriteModeKt.minify(source, i).toString() : null));
    }

    public int fromHexChar(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        fail$default(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public abstract CharSequence getSource();

    public boolean hasNext() {
        return ((Map.Entry) this.escapedString) != null;
    }

    public String peekLeadingMatchingValue(String str, boolean z) {
        str.getClass();
        return null;
    }

    public byte peekNextToken() {
        CharSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof == -1) {
                this.currentPosition = iPrefetchOrEof;
                return (byte) 10;
            }
            char cCharAt = source.charAt(iPrefetchOrEof);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.currentPosition = iPrefetchOrEof;
                return WriteModeKt.charToTokenClass(cCharAt);
            }
            i = iPrefetchOrEof + 1;
        }
    }

    public String peekString(boolean z) {
        String strConsumeString;
        byte bPeekNextToken = peekNextToken();
        if (z) {
            if (bPeekNextToken != 1 && bPeekNextToken != 0) {
                return null;
            }
            strConsumeString = consumeStringLenient();
        } else {
            if (bPeekNextToken != 1) {
                return null;
            }
            strConsumeString = consumeString();
        }
        this.peekedString = strConsumeString;
        return strConsumeString;
    }

    public abstract int prefetchOrEof(int i);

    public void remove() {
        SnapshotStateMap snapshotStateMap = (SnapshotStateMap) this.configuration;
        if (snapshotStateMap.getReadable$runtime().modification != this.currentPosition) {
            MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
            return;
        }
        Map.Entry entry = (Map.Entry) this.peekedString;
        if (entry == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
            return;
        }
        snapshotStateMap.remove(entry.getKey());
        this.peekedString = null;
        this.currentPosition = snapshotStateMap.getReadable$runtime().modification;
    }

    public abstract int skipWhitespaces();

    public String substring(int i, int i2) {
        return getSource().subSequence(i, i2).toString();
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb = new StringBuilder("JsonReader(source='");
                sb.append((Object) getSource());
                sb.append("', currentPosition=");
                return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.currentPosition, ')');
            default:
                return super.toString();
        }
    }

    public boolean tryConsumeComma() {
        int iSkipWhitespaces = skipWhitespaces();
        CharSequence source = getSource();
        if (iSkipWhitespaces >= source.length() || iSkipWhitespaces == -1 || source.charAt(iSkipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public void unexpectedToken(char c) {
        int i = this.currentPosition;
        if (i > 0 && c == '\"') {
            try {
                this.currentPosition = i - 1;
                String strConsumeStringLenient = consumeStringLenient();
                this.currentPosition = i;
                if (Intrinsics.areEqual(strConsumeStringLenient, "null")) {
                    fail(this.currentPosition - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.currentPosition = i;
                throw th;
            }
        }
        String str = WriteModeKt.tokenDescription(WriteModeKt.charToTokenClass(c));
        int i2 = this.currentPosition;
        int i3 = i2 > 0 ? i2 - 1 : i2;
        fail$default(this, Fragment$5$$ExternalSyntheticOutline0.m("Expected ", str, ", but had '", (i2 == getSource().length() || i3 < 0) ? "EOF" : String.valueOf(getSource().charAt(i3)), "' instead"), i3, null, 4);
        throw null;
    }

    public AbstractJsonLexer(SnapshotStateMap snapshotStateMap, Iterator it) {
        this.$r8$classId = (byte) 1;
        this.configuration = snapshotStateMap;
        this.path = it;
        this.currentPosition = snapshotStateMap.getReadable$runtime().modification;
        advance$1();
    }

    public void ensureHaveChars() {
    }

    public String consumeString() {
        String str = (String) this.peekedString;
        if (str != null) {
            str.getClass();
            this.peekedString = null;
            return str;
        }
        return consumeKeyString();
    }
}
