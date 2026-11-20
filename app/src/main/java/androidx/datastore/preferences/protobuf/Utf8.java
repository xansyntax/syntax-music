package androidx.datastore.preferences.protobuf;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.sqlite.SQLite;
import coil3.util.UtilsKt;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    public static final SQLite processor;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SafeProcessor extends SQLite {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ SafeProcessor(byte b) {
            this.$r8$classId = b;
        }

        /* JADX WARN: Code duplicated, block: B:107:0x0064 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:20:0x004a  */
        /* JADX WARN: Code duplicated, block: B:24:0x0057  */
        /* JADX WARN: Code duplicated, block: B:26:0x005b A[LOOP:2: B:23:0x0055->B:26:0x005b, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:31:0x006d  */
        /* JADX WARN: Code duplicated, block: B:44:0x009b  */
        /* JADX WARN: Code duplicated, block: B:61:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:63:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:81:0x0067 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x0050 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:85:0x0093 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:86:0x008e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:87:0x00d9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:88:0x00d4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:93:0x006b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:97:0x0097 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:98:0x0132 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:99:0x012d A[SYNTHETIC] */
        @Override // androidx.sqlite.SQLite
        public final String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            int i3;
            byte b;
            int i4;
            byte b2;
            byte b3;
            byte b4;
            switch (this.$r8$classId) {
                case 0:
                    if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
                    }
                    int i5 = i + i2;
                    char[] cArr = new char[i2];
                    int i6 = 0;
                    while (i < i5) {
                        byte b5 = bArr[i];
                        if (b5 < 0) {
                            while (i < i5) {
                                i3 = i + 1;
                                b = bArr[i];
                                if (b < 0) {
                                    i4 = i6 + 1;
                                    cArr[i6] = (char) b;
                                    while (i3 < i5) {
                                        b2 = bArr[i3];
                                        if (b2 >= 0) {
                                            i3++;
                                            cArr[i4] = (char) b2;
                                            i4++;
                                        } else {
                                            i6 = i4;
                                            i = i3;
                                        }
                                    }
                                    i6 = i4;
                                    i = i3;
                                } else if (b < -32) {
                                    if (i3 < i5) {
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    i += 2;
                                    byte b6 = bArr[i3];
                                    int i7 = i6 + 1;
                                    if (b >= -62 || UtilsKt.isNotTrailingByte(b6)) {
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    cArr[i6] = (char) ((b6 & 63) | ((b & 31) << 6));
                                    i6 = i7;
                                } else {
                                    if (b >= -16) {
                                        if (i3 < i5 - 2) {
                                            throw InvalidProtocolBufferException.invalidUtf8();
                                        }
                                        b4 = bArr[i3];
                                        int i8 = i + 3;
                                        byte b7 = bArr[i + 2];
                                        i += 4;
                                        byte b8 = bArr[i8];
                                        int i9 = i6 + 1;
                                        if (!UtilsKt.isNotTrailingByte(b4)) {
                                            if ((((b4 + 112) + (b << 28)) >> 30) != 0 && !UtilsKt.isNotTrailingByte(b7) && !UtilsKt.isNotTrailingByte(b8)) {
                                                int i10 = ((b4 & 63) << 12) | ((b & 7) << 18) | ((b7 & 63) << 6) | (b8 & 63);
                                                cArr[i6] = (char) ((i10 >>> 10) + 55232);
                                                cArr[i9] = (char) ((i10 & 1023) + 56320);
                                                i6 += 2;
                                            }
                                        }
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    if (i3 < i5 - 1) {
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    int i11 = i + 2;
                                    b3 = bArr[i3];
                                    i += 3;
                                    byte b9 = bArr[i11];
                                    int i12 = i6 + 1;
                                    if (!UtilsKt.isNotTrailingByte(b3) || ((b == -32 && b3 < -96) || ((b == -19 && b3 >= -96) || UtilsKt.isNotTrailingByte(b9)))) {
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    cArr[i6] = (char) (((b3 & 63) << 6) | ((b & 15) << 12) | (b9 & 63));
                                    i6 = i12;
                                }
                            }
                            return new String(cArr, 0, i6);
                        }
                        i++;
                        cArr[i6] = (char) b5;
                        i6++;
                    }
                    while (i < i5) {
                        i3 = i + 1;
                        b = bArr[i];
                        if (b < 0) {
                            if (b < -32) {
                                if (i3 < i5) {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                                i += 2;
                                byte b10 = bArr[i3];
                                int i13 = i6 + 1;
                                if (b >= -62) {
                                }
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            if (b >= -16) {
                                if (i3 < i5 - 1) {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                                int i14 = i + 2;
                                b3 = bArr[i3];
                                i += 3;
                                byte b11 = bArr[i14];
                                int i15 = i6 + 1;
                                if (UtilsKt.isNotTrailingByte(b3)) {
                                }
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            if (i3 < i5 - 2) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            b4 = bArr[i3];
                            int i16 = i + 3;
                            byte b12 = bArr[i + 2];
                            i += 4;
                            byte b13 = bArr[i16];
                            int i17 = i6 + 1;
                            if (!UtilsKt.isNotTrailingByte(b4)) {
                                if ((((b4 + 112) + (b << 28)) >> 30) != 0) {
                                }
                            }
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        i4 = i6 + 1;
                        cArr[i6] = (char) b;
                        while (i3 < i5) {
                            b2 = bArr[i3];
                            if (b2 >= 0) {
                                i3++;
                                cArr[i4] = (char) b2;
                                i4++;
                            } else {
                                i6 = i4;
                                i = i3;
                            }
                        }
                        i6 = i4;
                        i = i3;
                    }
                    return new String(cArr, 0, i6);
                default:
                    Charset charset = Internal.UTF_8;
                    String str = new String(bArr, i, i2, charset);
                    if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i2 + i))) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    return str;
            }
        }

        /* JADX WARN: Code duplicated, block: B:70:0x0180  */
        /* JADX WARN: Code duplicated, block: B:71:0x0184  */
        /* JADX WARN: Code duplicated, block: B:73:0x0187  */
        /* JADX WARN: Code duplicated, block: B:77:0x0199  */
        /* JADX WARN: Code duplicated, block: B:79:0x019d  */
        /* JADX WARN: Code duplicated, block: B:82:0x01b3  */
        /* JADX WARN: Code duplicated, block: B:84:0x01b8  */
        /* JADX WARN: Code duplicated, block: B:86:0x01bd  */
        @Override // androidx.sqlite.SQLite
        public final int encodeUtf8(String str, byte[] bArr, int i, int i2) {
            int i3;
            char cCharAt;
            int i4;
            char cCharAt2;
            int i5;
            char cCharAt3;
            char c = 2048;
            char c2 = 55296;
            switch (this.$r8$classId) {
                case 0:
                    int length = str.length();
                    int i6 = i2 + i;
                    int i7 = 0;
                    while (i7 < length) {
                        int i8 = i7 + i;
                        if (i8 >= i6 || (cCharAt2 = str.charAt(i7)) >= 128) {
                            if (i7 == length) {
                                return i + length;
                            }
                            i3 = i + i7;
                            while (i7 < length) {
                                cCharAt = str.charAt(i7);
                                if (cCharAt >= 128 && i3 < i6) {
                                    bArr[i3] = (byte) cCharAt;
                                    i3++;
                                } else if (cCharAt >= 2048 && i3 <= i6 - 2) {
                                    int i9 = i3 + 1;
                                    bArr[i3] = (byte) ((cCharAt >>> 6) | 960);
                                    i3 += 2;
                                    bArr[i9] = (byte) ((cCharAt & '?') | 128);
                                } else {
                                    if ((cCharAt < 55296 && 57343 >= cCharAt) || i3 > i6 - 3) {
                                        if (i3 > i6 - 4) {
                                            if (55296 <= cCharAt && cCharAt <= 57343 && ((i4 = i7 + 1) == str.length() || !Character.isSurrogatePair(cCharAt, str.charAt(i4)))) {
                                                throw new UnpairedSurrogateException(i7, length);
                                            }
                                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt + " at index " + i3);
                                        }
                                        int i10 = i7 + 1;
                                        if (i10 != str.length()) {
                                            char cCharAt4 = str.charAt(i10);
                                            if (Character.isSurrogatePair(cCharAt, cCharAt4)) {
                                                int codePoint = Character.toCodePoint(cCharAt, cCharAt4);
                                                bArr[i3] = (byte) ((codePoint >>> 18) | 240);
                                                bArr[i3 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                                int i11 = i3 + 3;
                                                bArr[i3 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                                i3 += 4;
                                                bArr[i11] = (byte) ((codePoint & 63) | 128);
                                                i7 = i10;
                                            } else {
                                                i7 = i10;
                                            }
                                        }
                                        throw new UnpairedSurrogateException(i7 - 1, length);
                                    }
                                    bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                                    int i12 = i3 + 2;
                                    bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                                    i3 += 3;
                                    bArr[i12] = (byte) ((cCharAt & '?') | 128);
                                }
                                i7++;
                            }
                            return i3;
                        }
                        bArr[i8] = (byte) cCharAt2;
                        i7++;
                    }
                    if (i7 == length) {
                        return i + length;
                    }
                    i3 = i + i7;
                    while (i7 < length) {
                        cCharAt = str.charAt(i7);
                        if (cCharAt >= 128) {
                            if (cCharAt >= 2048) {
                                if (cCharAt < 55296) {
                                    bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                                    int i13 = i3 + 2;
                                    bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                                    i3 += 3;
                                    bArr[i13] = (byte) ((cCharAt & '?') | 128);
                                } else {
                                    bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                                    int i14 = i3 + 2;
                                    bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                                    i3 += 3;
                                    bArr[i14] = (byte) ((cCharAt & '?') | 128);
                                }
                            } else if (cCharAt < 55296) {
                                bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                                int i15 = i3 + 2;
                                bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                                i3 += 3;
                                bArr[i15] = (byte) ((cCharAt & '?') | 128);
                            } else {
                                bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                                int i16 = i3 + 2;
                                bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                                i3 += 3;
                                bArr[i16] = (byte) ((cCharAt & '?') | 128);
                            }
                        } else if (cCharAt >= 2048) {
                            if (cCharAt < 55296) {
                                bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                                int i17 = i3 + 2;
                                bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                                i3 += 3;
                                bArr[i17] = (byte) ((cCharAt & '?') | 128);
                            } else {
                                bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                                int i18 = i3 + 2;
                                bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                                i3 += 3;
                                bArr[i18] = (byte) ((cCharAt & '?') | 128);
                            }
                        } else if (cCharAt < 55296) {
                            bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                            int i19 = i3 + 2;
                            bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                            i3 += 3;
                            bArr[i19] = (byte) ((cCharAt & '?') | 128);
                        } else {
                            bArr[i3] = (byte) ((cCharAt >>> '\f') | 480);
                            int i110 = i3 + 2;
                            bArr[i3 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                            i3 += 3;
                            bArr[i110] = (byte) ((cCharAt & '?') | 128);
                        }
                        i7++;
                    }
                    return i3;
                default:
                    long j = i;
                    long j2 = ((long) i2) + j;
                    int length2 = str.length();
                    if (length2 > i2 || bArr.length - i2 < i) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length2 - 1) + " at index " + (i + i2));
                    }
                    int i20 = 0;
                    while (i20 < length2 && (cCharAt3 = str.charAt(i20)) < 128) {
                        UnsafeUtil.putByte(bArr, j, (byte) cCharAt3);
                        i20++;
                        j++;
                    }
                    if (i20 != length2) {
                        while (i20 < length2) {
                            char cCharAt5 = str.charAt(i20);
                            if (cCharAt5 < 128 && j < j2) {
                                UnsafeUtil.putByte(bArr, j, (byte) cCharAt5);
                                j++;
                            } else if (cCharAt5 >= c || j > j2 - 2) {
                                int i21 = i20;
                                if ((cCharAt5 >= c2 && 57343 >= cCharAt5) || j > j2 - 3) {
                                    if (j > j2 - 4) {
                                        if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i5 = i21 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i5)))) {
                                            throw new UnpairedSurrogateException(i21, length2);
                                        }
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j);
                                    }
                                    i20 = i21 + 1;
                                    if (i20 != length2) {
                                        char cCharAt6 = str.charAt(i20);
                                        if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                            int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                            UnsafeUtil.putByte(bArr, j, (byte) ((codePoint2 >>> 18) | 240));
                                            UnsafeUtil.putByte(bArr, j + 1, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                            long j3 = j + 3;
                                            UnsafeUtil.putByte(bArr, j + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                            j += 4;
                                            UnsafeUtil.putByte(bArr, j3, (byte) ((codePoint2 & 63) | 128));
                                        }
                                    } else {
                                        i20 = i21;
                                    }
                                    throw new UnpairedSurrogateException(i20 - 1, length2);
                                }
                                UnsafeUtil.putByte(bArr, j, (byte) ((cCharAt5 >>> '\f') | 480));
                                long j4 = j + 2;
                                UnsafeUtil.putByte(bArr, j + 1, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                                j += 3;
                                UnsafeUtil.putByte(bArr, j4, (byte) ((cCharAt5 & '?') | 128));
                                i20 = i21;
                            } else {
                                long j5 = j + 1;
                                UnsafeUtil.putByte(bArr, j, (byte) ((cCharAt5 >>> 6) | 960));
                                j += 2;
                                UnsafeUtil.putByte(bArr, j5, (byte) ((cCharAt5 & '?') | 128));
                                i20 = i20;
                            }
                            i20++;
                            c = 2048;
                            c2 = 55296;
                        }
                    }
                    return (int) j;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i2) {
            super(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "Unpaired surrogate at index ", " of "));
        }
    }

    static {
        processor = (UnsafeUtil.HAS_UNSAFE_ARRAY_OPERATIONS && UnsafeUtil.HAS_UNSAFE_BYTEBUFFER_OPERATIONS && !Android.isOnAndroidDevice()) ? new SafeProcessor((byte) 1) : new SafeProcessor((byte) 0);
    }

    public static int encodedLength(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && str.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= 2048) {
                int length2 = str.length();
                while (i2 < length2) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i2) < 65536) {
                                throw new UnpairedSurrogateException(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
                break;
            }
            i3 += (127 - cCharAt) >>> 31;
            i2++;
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }
}
