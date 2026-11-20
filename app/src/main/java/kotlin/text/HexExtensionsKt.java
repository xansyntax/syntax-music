package kotlin.text;

import kotlin.ResultKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class HexExtensionsKt {
    public static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    public static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;
    public static final long[] HEX_DIGITS_TO_LONG_DECIMAL;

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = "0123456789abcdef".charAt(i2 & 15) | ("0123456789abcdef".charAt(i2 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr2[i3] = "0123456789ABCDEF".charAt(i3 & 15) | ("0123456789ABCDEF".charAt(i3 >> 4) << '\b');
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr3[i4] = -1;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i5)] = i6;
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i7)] = i8;
            i7++;
            i8++;
        }
        long[] jArr = new long[256];
        for (int i9 = 0; i9 < 256; i9++) {
            jArr[i9] = -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i10)] = i11;
            i10++;
            i11++;
        }
        int i12 = 0;
        while (i < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i)] = i12;
            i++;
            i12++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    public static final int checkFormatLength(long j) {
        if (0 <= j && j <= 2147483647L) {
            return (int) j;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(ResultKt.ulongToString(10, j), "The resulting string length is too big: ");
        return 0;
    }

    public static final int formatByteAt(byte[] bArr, int i, int[] iArr, char[] cArr, int i2) {
        int i3 = iArr[bArr[i] & 255];
        cArr[i2] = (char) (i3 >> 8);
        cArr[i2 + 1] = (char) (i3 & 255);
        return i2 + 2;
    }

    public static final int toCharArrayIfNotEmpty(String str, char[] cArr, int i) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                str.getChars(0, str.length(), cArr, i);
            } else {
                cArr[i] = str.charAt(0);
            }
        }
        return str.length() + i;
    }

    public static String toHexString$default(byte[] bArr) {
        HexFormat hexFormat = HexFormat.Default;
        bArr.getClass();
        hexFormat.getClass();
        int length = bArr.length;
        StringsKt__IndentKt.checkBoundsIndexes$kotlin_stdlib(0, length, bArr.length);
        if (length == 0) {
            return "";
        }
        int[] iArr = hexFormat.upperCase ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytesHexFormat = hexFormat.bytes;
        if (bytesHexFormat.noLineAndGroupSeparator) {
            if (bytesHexFormat.shortByteSeparatorNoPrefixAndSuffix) {
                char[] cArr = new char[checkFormatLength(((long) length) * 2)];
                int byteAt = 0;
                for (int i = 0; i < length; i++) {
                    byteAt = formatByteAt(bArr, i, iArr, cArr, byteAt);
                }
                return new String(cArr);
            }
            if (length <= 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
                return null;
            }
            char[] cArr2 = new char[checkFormatLength(((long) length) * 2)];
            int charArrayIfNotEmpty = toCharArrayIfNotEmpty("", cArr2, formatByteAt(bArr, 0, iArr, cArr2, toCharArrayIfNotEmpty("", cArr2, 0)));
            for (int i2 = 1; i2 < length; i2++) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty("", cArr2, formatByteAt(bArr, i2, iArr, cArr2, toCharArrayIfNotEmpty("", cArr2, toCharArrayIfNotEmpty("", cArr2, charArrayIfNotEmpty))));
            }
            return new String(cArr2);
        }
        if (length <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return null;
        }
        int i3 = (length - 1) / Integer.MAX_VALUE;
        int i4 = length % Integer.MAX_VALUE;
        if (i4 == 0) {
            i4 = Integer.MAX_VALUE;
        }
        int iCheckFormatLength = checkFormatLength((2 * ((long) length)) + (((long) ((i4 - 1) / Integer.MAX_VALUE)) * 2) + ((long) i3));
        char[] cArr3 = new char[iCheckFormatLength];
        int charArrayIfNotEmpty2 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (i5 == Integer.MAX_VALUE) {
                cArr3[charArrayIfNotEmpty2] = '\n';
                i6 = 0;
                charArrayIfNotEmpty2++;
                i5 = 0;
            } else if (i6 == Integer.MAX_VALUE) {
                charArrayIfNotEmpty2 = toCharArrayIfNotEmpty("  ", cArr3, charArrayIfNotEmpty2);
                i6 = 0;
            }
            if (i6 != 0) {
                charArrayIfNotEmpty2 = toCharArrayIfNotEmpty("", cArr3, charArrayIfNotEmpty2);
            }
            charArrayIfNotEmpty2 = toCharArrayIfNotEmpty("", cArr3, formatByteAt(bArr, i7, iArr, cArr3, toCharArrayIfNotEmpty("", cArr3, charArrayIfNotEmpty2)));
            i6++;
            i5++;
        }
        if (charArrayIfNotEmpty2 == iCheckFormatLength) {
            return new String(cArr3);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        return null;
    }
}
