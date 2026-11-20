package kotlin.io.encoding;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class Base64 {
    public static final Default Default;
    public static final Base64 UrlSafe;
    public static final byte[] mimeLineSeparatorSymbols;
    public final boolean isMimeScheme;
    public final boolean isUrlSafe;
    public final int mimeGroupsPerLine;
    public final int mimeLineLength;
    public final PaddingOption paddingOption;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Default extends Base64 {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PaddingOption {
        public static final /* synthetic */ PaddingOption[] $VALUES;
        public static final PaddingOption ABSENT;
        public static final PaddingOption ABSENT_OPTIONAL;
        public static final PaddingOption PRESENT;
        public static final PaddingOption PRESENT_OPTIONAL;

        static {
            PaddingOption paddingOption = new PaddingOption("PRESENT", 0);
            PRESENT = paddingOption;
            PaddingOption paddingOption2 = new PaddingOption("ABSENT", 1);
            ABSENT = paddingOption2;
            PaddingOption paddingOption3 = new PaddingOption("PRESENT_OPTIONAL", 2);
            PRESENT_OPTIONAL = paddingOption3;
            PaddingOption paddingOption4 = new PaddingOption("ABSENT_OPTIONAL", 3);
            ABSENT_OPTIONAL = paddingOption4;
            $VALUES = new PaddingOption[]{paddingOption, paddingOption2, paddingOption3, paddingOption4};
        }

        public static PaddingOption valueOf(String str) {
            return (PaddingOption) Enum.valueOf(PaddingOption.class, str);
        }

        public static PaddingOption[] values() {
            return (PaddingOption[]) $VALUES.clone();
        }
    }

    static {
        PaddingOption paddingOption = PaddingOption.PRESENT;
        Default = new Default(false, false, -1, paddingOption);
        mimeLineSeparatorSymbols = new byte[]{13, 10};
        UrlSafe = new Base64(true, false, -1, paddingOption);
        new Base64(false, true, 76, paddingOption);
        new Base64(false, true, 64, paddingOption);
    }

    public Base64(boolean z, boolean z2, int i, PaddingOption paddingOption) {
        this.isUrlSafe = z;
        this.isMimeScheme = z2;
        this.mimeLineLength = i;
        this.paddingOption = paddingOption;
        if (z && z2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            throw null;
        }
        this.mimeGroupsPerLine = i / 4;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x00fc A[EDGE_INSN: B:125:0x00fc->B:61:0x00fc BREAK  A[LOOP:2: B:56:0x00eb->B:60:0x00f9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00de  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00eb A[ADDED_TO_REGION, LOOP:2: B:56:0x00eb->B:60:0x00f9, LOOP_START, PHI: r14
      0x00eb: PHI (r14v15 int) = (r14v12 int), (r14v16 int) binds: [B:54:0x00e8, B:60:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f9 A[LOOP:2: B:56:0x00eb->B:60:0x00f9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x0111  */
    /* JADX WARN: Code duplicated, block: B:69:0x0119 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0120  */
    /* JADX WARN: Code duplicated, block: B:74:0x0128  */
    /* JADX WARN: Code duplicated, block: B:76:0x0132  */
    /* JADX WARN: Code duplicated, block: B:78:0x0136  */
    /* JADX WARN: Code duplicated, block: B:82:0x016c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0178  */
    /* JADX WARN: Code duplicated, block: B:85:0x0189  */
    public static byte[] decode$default(Base64 base64, byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        char c;
        int i7;
        PaddingOption paddingOption;
        int i8;
        int length = bArr.length;
        boolean z = base64.isMimeScheme;
        boolean z2 = base64.isMimeScheme;
        PaddingOption paddingOption2 = base64.paddingOption;
        StringsKt__IndentKt.checkBoundsIndexes$kotlin_stdlib(0, length, bArr.length);
        int i9 = -2;
        int i10 = 1;
        if (length == 0) {
            i2 = 0;
        } else {
            if (length == 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(length, "Input should have at least 2 symbols for Base64 decoding, startIndex: 0, endIndex: "));
                return null;
            }
            if (z) {
                i = length;
                for (int i11 = 0; i11 < length; i11++) {
                    int i12 = Base64Kt.base64DecodeMap[bArr[i11] & 255];
                    if (i12 < 0) {
                        if (i12 == -2) {
                            i -= length - i11;
                            break;
                        }
                        i--;
                    }
                }
            } else if (bArr[length - 1] == 61) {
                i = length - 1;
                if (bArr[length - 2] == 61) {
                    i = length - 2;
                }
            } else {
                i = length;
            }
            i2 = (int) ((((long) i) * 6) / 8);
        }
        byte[] bArr2 = new byte[i2];
        int[] iArr2 = base64.isUrlSafe ? Base64Kt.base64UrlDecodeMap : Base64Kt.base64DecodeMap;
        int i13 = -8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = -8;
        while (true) {
            i10 = i10;
            if (i15 >= length) {
                i3 = 0;
                break;
            }
            if (i17 == i13) {
                i4 = 8;
                int i18 = i15 + 3;
                if (i18 < length) {
                    int i19 = iArr2[bArr[i15] & 255];
                    iArr = iArr2;
                    int i20 = i15 + 4;
                    int i21 = (iArr[bArr[i15 + 2] & 255] << 6) | (iArr2[bArr[i15 + 1] & 255] << 12) | (i19 << 18) | iArr[bArr[i18] & 255];
                    if (i21 >= 0) {
                        bArr2[i14] = (byte) (i21 >> 16);
                        int i22 = i14 + 2;
                        bArr2[i14 + 1] = (byte) (i21 >> 8);
                        i14 += 3;
                        bArr2[i22] = (byte) i21;
                        iArr2 = iArr;
                        i15 = i20;
                    }
                    i9 = -2;
                    i13 = -8;
                }
                i5 = bArr[i15] & 255;
                i6 = iArr[i5];
                if (i6 < 0) {
                    c = '=';
                    i15++;
                    i16 = (i16 << 6) | i6;
                    i7 = i17 + 6;
                    if (i7 >= 0) {
                        bArr2[i14] = (byte) (i16 >>> i7);
                        i16 &= (i10 << i7) - 1;
                        i17 -= 2;
                        i14++;
                    } else {
                        i17 = i7;
                    }
                } else {
                    if (i6 == -2) {
                        if (i17 != -8) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i15, "Redundant pad character at index "));
                            return null;
                        }
                        paddingOption = PaddingOption.ABSENT;
                        if (i17 != -6) {
                            if (i17 != -4) {
                                if (paddingOption2 != paddingOption) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i15, "The padding option is set to ABSENT, but the input has a pad character at index "));
                                    return null;
                                }
                                i8 = i15 + 1;
                                if (z2) {
                                    while (i8 < length) {
                                        if (Base64Kt.base64DecodeMap[bArr[i8] & 255] != -1) {
                                            break;
                                        }
                                        i8++;
                                    }
                                }
                                if (i8 != length || bArr[i8] != 61) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i8, "Missing one pad character at index "));
                                    return null;
                                }
                                i15 = i8 + 1;
                            } else if (i17 != -2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unreachable");
                                return null;
                            }
                            i3 = i10;
                            i9 = -2;
                            break;
                        }
                        if (paddingOption2 == paddingOption) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i15, "The padding option is set to ABSENT, but the input has a pad character at index "));
                            return null;
                        }
                        i15++;
                        i3 = i10;
                        i9 = -2;
                        break;
                    }
                    c = '=';
                    if (z) {
                        char c2 = (char) i5;
                        CharsKt.checkRadix(i4);
                        String string = Integer.toString(i5, i4);
                        string.getClass();
                        throw new IllegalArgumentException("Invalid symbol '" + c2 + "'(" + string + ") at index " + i15);
                    }
                    i15++;
                }
                iArr2 = iArr;
                i9 = -2;
                i13 = -8;
            } else {
                i4 = 8;
            }
            iArr = iArr2;
            i5 = bArr[i15] & 255;
            i6 = iArr[i5];
            if (i6 < 0) {
                c = '=';
                i15++;
                i16 = (i16 << 6) | i6;
                i7 = i17 + 6;
                if (i7 >= 0) {
                    bArr2[i14] = (byte) (i16 >>> i7);
                    i16 &= (i10 << i7) - 1;
                    i17 -= 2;
                    i14++;
                } else {
                    i17 = i7;
                }
            } else {
                if (i6 == -2) {
                    if (i17 != -8) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i15, "Redundant pad character at index "));
                        return null;
                    }
                    paddingOption = PaddingOption.ABSENT;
                    if (i17 != -6) {
                        if (i17 != -4) {
                            if (paddingOption2 != paddingOption) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i15, "The padding option is set to ABSENT, but the input has a pad character at index "));
                                return null;
                            }
                            i8 = i15 + 1;
                            if (z2) {
                                while (i8 < length) {
                                    if (Base64Kt.base64DecodeMap[bArr[i8] & 255] != -1) {
                                        break;
                                        break;
                                    }
                                    i8++;
                                }
                            }
                            if (i8 != length) {
                            }
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i8, "Missing one pad character at index "));
                            return null;
                        }
                        if (i17 != -2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unreachable");
                            return null;
                        }
                        i3 = i10;
                        i9 = -2;
                        break;
                    }
                    if (paddingOption2 == paddingOption) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i15, "The padding option is set to ABSENT, but the input has a pad character at index "));
                        return null;
                    }
                    i15++;
                    i3 = i10;
                    i9 = -2;
                    break;
                }
                c = '=';
                if (z) {
                    char c3 = (char) i5;
                    CharsKt.checkRadix(i4);
                    String string2 = Integer.toString(i5, i4);
                    string2.getClass();
                    throw new IllegalArgumentException("Invalid symbol '" + c3 + "'(" + string2 + ") at index " + i15);
                }
                i15++;
            }
            iArr2 = iArr;
            i9 = -2;
            i13 = -8;
        }
        if (i17 == i9) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The last unit of input does not have enough bits");
            return null;
        }
        if (i17 != -8 && i3 == 0 && paddingOption2 == PaddingOption.PRESENT) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The padding option is set to PRESENT, but the input is not properly padded");
            return null;
        }
        if (i16 != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The pad bits must be zeros");
            return null;
        }
        if (z2) {
            while (i15 < length) {
                if (Base64Kt.base64DecodeMap[bArr[i15] & 255] != -1) {
                    break;
                }
                i15++;
            }
        }
        if (i15 >= length) {
            if (i14 == i2) {
                return bArr2;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            return null;
        }
        int i23 = bArr[i15] & 255;
        StringBuilder sb = new StringBuilder("Symbol '");
        sb.append((char) i23);
        sb.append("'(");
        CharsKt.checkRadix(8);
        String string3 = Integer.toString(i23, 8);
        string3.getClass();
        sb.append(string3);
        sb.append(") at index ");
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(sb, i15 - 1, " is prohibited after the pad character"));
        return null;
    }

    public static String encode$default(Base64 base64, byte[] bArr) {
        int i;
        int length = bArr.length;
        base64.getClass();
        PaddingOption paddingOption = base64.paddingOption;
        bArr.getClass();
        StringsKt__IndentKt.checkBoundsIndexes$kotlin_stdlib(0, length, bArr.length);
        int iEncodeSize$kotlin_stdlib = base64.encodeSize$kotlin_stdlib(length);
        byte[] bArr2 = new byte[iEncodeSize$kotlin_stdlib];
        StringsKt__IndentKt.checkBoundsIndexes$kotlin_stdlib(0, length, bArr.length);
        int iEncodeSize$kotlin_stdlib2 = base64.encodeSize$kotlin_stdlib(length);
        if (iEncodeSize$kotlin_stdlib < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(iEncodeSize$kotlin_stdlib, "destination offset: 0, destination size: "));
            return null;
        }
        if (iEncodeSize$kotlin_stdlib2 < 0 || iEncodeSize$kotlin_stdlib2 > iEncodeSize$kotlin_stdlib) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(iEncodeSize$kotlin_stdlib, iEncodeSize$kotlin_stdlib2, "The destination array does not have enough capacity, destination offset: 0, destination size: ", ", capacity needed: "));
            return null;
        }
        byte[] bArr3 = base64.isUrlSafe ? Base64Kt.base64UrlEncodeMap : Base64Kt.base64EncodeMap;
        int i2 = base64.isMimeScheme ? base64.mimeGroupsPerLine : Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i3 + 2;
            if (i >= length) {
                break;
            }
            int iMin = Math.min((length - i3) / 3, i2);
            for (int i5 = 0; i5 < iMin; i5++) {
                int i6 = bArr[i3] & 255;
                int i7 = i3 + 2;
                int i8 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i9 = (i8 << 8) | (i6 << 16) | (bArr[i7] & 255);
                bArr2[i4] = bArr3[i9 >>> 18];
                bArr2[i4 + 1] = bArr3[(i9 >>> 12) & 63];
                int i10 = i4 + 3;
                bArr2[i4 + 2] = bArr3[(i9 >>> 6) & 63];
                i4 += 4;
                bArr2[i10] = bArr3[i9 & 63];
            }
            if (iMin == i2 && i3 != length) {
                int i11 = i4 + 1;
                byte[] bArr4 = mimeLineSeparatorSymbols;
                bArr2[i4] = bArr4[0];
                i4 += 2;
                bArr2[i11] = bArr4[1];
            }
        }
        int i12 = length - i3;
        PaddingOption paddingOption2 = PaddingOption.PRESENT_OPTIONAL;
        PaddingOption paddingOption3 = PaddingOption.PRESENT;
        if (i12 == 1) {
            int i13 = i3 + 1;
            int i14 = (bArr[i3] & 255) << 4;
            bArr2[i4] = bArr3[i14 >>> 6];
            int i15 = i4 + 2;
            bArr2[i4 + 1] = bArr3[i14 & 63];
            if (paddingOption == paddingOption3 || paddingOption == paddingOption2) {
                bArr2[i15] = 61;
                bArr2[i4 + 3] = 61;
            }
            i3 = i13;
        } else if (i12 == 2) {
            int i16 = ((bArr[i3 + 1] & 255) << 2) | ((bArr[i3] & 255) << 10);
            bArr2[i4] = bArr3[i16 >>> 12];
            int i17 = i4 + 2;
            bArr2[i4 + 1] = bArr3[(i16 >>> 6) & 63];
            int i18 = i4 + 3;
            bArr2[i17] = bArr3[i16 & 63];
            if (paddingOption == paddingOption3 || paddingOption == paddingOption2) {
                bArr2[i18] = 61;
            }
            i3 = i;
        }
        if (i3 == length) {
            return new String(bArr2, Charsets.ISO_8859_1);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        return null;
    }

    public final int encodeSize$kotlin_stdlib(int i) {
        int i2 = i / 3;
        int i3 = i % 3;
        int i4 = 4;
        int i5 = i2 * 4;
        if (i3 != 0) {
            PaddingOption paddingOption = PaddingOption.PRESENT;
            PaddingOption paddingOption2 = this.paddingOption;
            if (paddingOption2 != paddingOption && paddingOption2 != PaddingOption.PRESENT_OPTIONAL) {
                i4 = i3 + 1;
            }
            i5 += i4;
        }
        if (i5 < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Input is too big");
            return 0;
        }
        if (this.isMimeScheme) {
            i5 += ((i5 - 1) / this.mimeLineLength) * 2;
        }
        if (i5 >= 0) {
            return i5;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Input is too big");
        return 0;
    }

    public final Base64 withPadding(PaddingOption paddingOption) {
        if (this.paddingOption == paddingOption) {
            return this;
        }
        return new Base64(this.isUrlSafe, this.isMimeScheme, this.mimeLineLength, paddingOption);
    }

    public static byte[] decode$default(Base64 base64, CharSequence charSequence, int i, int i2) {
        byte[] bytes;
        int i3 = 0;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int length = charSequence.length();
        base64.getClass();
        charSequence.getClass();
        if (charSequence instanceof String) {
            String str = (String) charSequence;
            StringsKt__IndentKt.checkBoundsIndexes$kotlin_stdlib(i, length, str.length());
            bytes = str.substring(i, length).getBytes(Charsets.ISO_8859_1);
            bytes.getClass();
        } else {
            StringsKt__IndentKt.checkBoundsIndexes$kotlin_stdlib(i, length, charSequence.length());
            byte[] bArr = new byte[length - i];
            while (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt <= 255) {
                    bArr[i3] = (byte) cCharAt;
                    i3++;
                } else {
                    bArr[i3] = 63;
                    i3++;
                }
                i++;
            }
            bytes = bArr;
        }
        return decode$default(base64, bytes);
    }
}
