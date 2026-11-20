package kotlin.text;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsJVMKt {
    public static String concatToString(char[] cArr, int i, int i2) {
        cArr.getClass();
        StringsKt__IndentKt.checkBoundsIndexes$kotlin_stdlib(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    public static String decodeToString(byte[] bArr) {
        bArr.getClass();
        return new String(bArr, Charsets.UTF_8);
    }

    public static String decodeToString$default(int i, int i2, int i3, byte[] bArr) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        bArr.getClass();
        StringsKt__IndentKt.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        return new String(bArr, i, i2 - i, Charsets.UTF_8);
    }

    public static byte[] encodeToByteArray(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        bytes.getClass();
        return bytes;
    }

    public static boolean endsWith(String str, String str2, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.endsWith(str2) : str.regionMatches(true, str.length() - str2.length(), str2, 0, str2.length());
    }

    public static boolean equals(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        return !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final void numberFormatError(String str) {
        str.getClass();
        throw new NumberFormatException(Format$$ExternalSyntheticOutline0.m('\'', "Invalid number format: '", str));
    }

    public static boolean regionMatches(int i, int i2, int i3, String str, String str2, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static String repeat(int i, String str) {
        str.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(i, "Count 'n' must be non-negative, but was ");
            return null;
        }
        if (i == 0) {
            return "";
        }
        int i2 = 1;
        if (i == 1) {
            return str.toString();
        }
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length != 1) {
            StringBuilder sb = new StringBuilder(str.length() * i);
            if (1 <= i) {
                while (true) {
                    sb.append((CharSequence) str);
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            return sb.toString();
        }
        char cCharAt = str.charAt(0);
        char[] cArr = new char[i];
        for (int i3 = 0; i3 < i; i3++) {
            cArr[i3] = cCharAt;
        }
        return new String(cArr);
    }

    public static String replace(String str, String str2, String str3, boolean z) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int i = 0;
        int iIndexOf = StringsKt.indexOf(0, str, str2, z);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str2.length();
        int i2 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iIndexOf);
            sb.append(str3);
            i = iIndexOf + length;
            if (iIndexOf >= str.length()) {
                break;
            }
            iIndexOf = StringsKt.indexOf(iIndexOf + i2, str, str2, z);
        } while (iIndexOf > 0);
        sb.append((CharSequence) str, i, str.length());
        return sb.toString();
    }

    public static String replace$default(String str, char c, char c2) {
        str.getClass();
        String strReplace = str.replace(c, c2);
        strReplace.getClass();
        return strReplace;
    }

    public static String replaceFirst$default(String str, String str2, String str3) {
        str.getClass();
        int iIndexOf$default = StringsKt.indexOf$default(str, str2, 0, false, 2);
        return iIndexOf$default < 0 ? str : StringsKt.replaceRange(str, iIndexOf$default, str2.length() + iIndexOf$default, str3).toString();
    }

    public static boolean startsWith(String str, String str2, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.startsWith(str2) : regionMatches(0, 0, str2.length(), str, str2, z);
    }

    public static Integer toIntOrNull(int i, String str) {
        boolean z;
        int i2;
        int i3;
        str.getClass();
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        if (cCharAt < '0') {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i5 = Integer.MIN_VALUE;
                z = true;
            }
        } else {
            z = false;
            i2 = 0;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), i);
            if (iDigit < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / i))) || (i3 = i4 * i) < i5 + iDigit) {
                return null;
            }
            i4 = i3 - iDigit;
            i2++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static Long toLongOrNull(int i, String str) {
        boolean z;
        str.getClass();
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (cCharAt < '0') {
            z = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
                i2 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j = Long.MIN_VALUE;
                i2 = 1;
            }
        } else {
            z = false;
        }
        long j2 = 0;
        long j3 = -256204778801521550L;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), i);
            if (iDigit < 0) {
                return null;
            }
            if (j2 < j3) {
                if (j3 != -256204778801521550L) {
                    return null;
                }
                j3 = j / ((long) i);
                if (j2 < j3) {
                    return null;
                }
            }
            long j4 = j2 * ((long) i);
            long j5 = iDigit;
            if (j4 < j + j5) {
                return null;
            }
            j2 = j4 - j5;
            i2++;
        }
        return z ? Long.valueOf(j2) : Long.valueOf(-j2);
    }

    public static boolean startsWith(int i, String str, String str2, boolean z) {
        str.getClass();
        if (!z) {
            return str.startsWith(str2, i);
        }
        return regionMatches(i, 0, str2.length(), str, str2, z);
    }

    public static Integer toIntOrNull(String str) {
        str.getClass();
        return toIntOrNull(10, str);
    }

    public static Long toLongOrNull(String str) {
        str.getClass();
        return toLongOrNull(10, str);
    }
}
