package okhttp3.internal.url;

import java.io.EOFException;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilCommonKt;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class _UrlKt {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String canonicalize$default(String str, int i, int i2, String str2, int i3) throws EOFException {
        int i4 = (i3 & 1) != 0 ? 0 : i;
        int length = (i3 & 2) != 0 ? str.length() : i2;
        boolean z = (i3 & 8) == 0;
        boolean z2 = (i3 & 16) == 0;
        boolean z3 = (i3 & 32) == 0;
        boolean z4 = (i3 & 64) == 0;
        str.getClass();
        int iCharCount = i4;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i5 = 32;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || StringsKt.contains$default(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z || (z2 && !isPercentEncoded(iCharCount, length, str)))) || (iCodePointAt == 43 && z3)))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(i4, iCharCount, str);
                Buffer buffer2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == i5 && str2 == " !\"#$&'()+,/:;<=>?@[\\]^`{|}~") {
                            buffer.m1915writeUtf8("+");
                        } else if (iCodePointAt2 == 43 && z3) {
                            buffer.m1915writeUtf8(z ? "+" : "%2B");
                        } else {
                            if (iCodePointAt2 >= i5 && iCodePointAt2 != 127) {
                                if ((iCodePointAt2 < 128 || z4) && !StringsKt.contains$default(str2, (char) iCodePointAt2) && (iCodePointAt2 != 37 || (z && (!z2 || isPercentEncoded(iCharCount, length, str))))) {
                                    buffer.writeUtf8CodePoint(iCodePointAt2);
                                }
                            }
                            if (buffer2 == null) {
                                buffer2 = new Buffer();
                            }
                            buffer2.writeUtf8CodePoint(iCodePointAt2);
                            while (!buffer2.exhausted()) {
                                byte b = buffer2.readByte();
                                buffer.m1913writeByte(37);
                                char[] cArr = HEX_DIGITS;
                                buffer.m1913writeByte((int) cArr[((b & 255) >> 4) & 15]);
                                buffer.m1913writeByte((int) cArr[b & 15]);
                            }
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i5 = 32;
                }
                return buffer.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i4, length);
    }

    public static final boolean isPercentEncoded(int i, int i2, String str) {
        str.getClass();
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && _UtilCommonKt.parseHexDigit(str.charAt(i + 1)) != -1 && _UtilCommonKt.parseHexDigit(str.charAt(i3)) != -1;
    }

    public static String percentDecode$default(int i, int i2, int i3, String str) {
        int i4;
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        boolean z = (i3 & 4) == 0;
        str.getClass();
        int iCharCount = i;
        while (iCharCount < i2) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(i, iCharCount, str);
                while (iCharCount < i2) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                        int hexDigit = _UtilCommonKt.parseHexDigit(str.charAt(iCharCount + 1));
                        int hexDigit2 = _UtilCommonKt.parseHexDigit(str.charAt(i4));
                        if (hexDigit == -1 || hexDigit2 == -1) {
                            buffer.writeUtf8CodePoint(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            buffer.m1913writeByte((hexDigit << 4) + hexDigit2);
                            iCharCount = Character.charCount(iCodePointAt) + i4;
                        }
                    } else if (iCodePointAt == 43 && z) {
                        buffer.m1913writeByte(32);
                        iCharCount++;
                    } else {
                        buffer.writeUtf8CodePoint(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return buffer.readUtf8();
            }
            iCharCount++;
        }
        return str.substring(i, i2);
    }
}
