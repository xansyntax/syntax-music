package okio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.text.Charsets;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal._ZlibJvmKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class ByteString implements Serializable, Comparable {
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    public final byte[] data;
    public transient int hashCode;
    public transient String utf8;

    public ByteString(byte[] bArr) {
        bArr.getClass();
        this.data = bArr;
    }

    public static int indexOf$default(ByteString byteString, ByteString byteString2) {
        byteString.getClass();
        byteString2.getClass();
        return byteString.indexOf(byteString2.internalArray$okio(), 0);
    }

    public static int lastIndexOf$default(ByteString byteString, ByteString byteString2) {
        int size$okio = byteString.getSize$okio();
        byteString.getClass();
        byteString2.getClass();
        return byteString.lastIndexOf(byteString2.internalArray$okio(), size$okio);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        int i = objectInputStream.readInt();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "byteCount < 0: "));
            return;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = objectInputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        ByteString byteString = new ByteString(bArr);
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    public static ByteString substring$default(ByteString byteString, int i, int i2, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.getSize$okio();
        }
        return byteString.substring(i, i2);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public String base64() {
        byte[] bArr = this.data;
        byte[] bArr2 = Base64.BASE64;
        bArr.getClass();
        bArr2.getClass();
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i + 2;
            byte b2 = bArr[i + 1];
            i += 3;
            byte b3 = bArr[i3];
            bArr3[i2] = bArr2[(b & 255) >> 2];
            bArr3[i2 + 1] = bArr2[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr3[i2 + 2] = bArr2[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr3[i4] = bArr2[b3 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i];
            bArr3[i2] = bArr2[(b4 & 255) >> 2];
            bArr3[i2 + 1] = bArr2[(b4 & 3) << 4];
            bArr3[i2 + 2] = 61;
            bArr3[i2 + 3] = 61;
        } else if (length2 == 2) {
            int i5 = i + 1;
            byte b5 = bArr[i];
            byte b6 = bArr[i5];
            bArr3[i2] = bArr2[(b5 & 255) >> 2];
            bArr3[i2 + 1] = bArr2[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            bArr3[i2 + 2] = bArr2[(b6 & 15) << 2];
            bArr3[i2 + 3] = 61;
        }
        return new String(bArr3, Charsets.UTF_8);
    }

    @Override // java.lang.Comparable
    public final int compareTo(ByteString byteString) {
        byteString.getClass();
        int size$okio = getSize$okio();
        int size$okio2 = byteString.getSize$okio();
        int iMin = Math.min(size$okio, size$okio2);
        for (int i = 0; i < iMin; i++) {
            int iInternalGet$okio = internalGet$okio(i) & 255;
            int iInternalGet$okio2 = byteString.internalGet$okio(i) & 255;
            if (iInternalGet$okio != iInternalGet$okio2) {
                return iInternalGet$okio < iInternalGet$okio2 ? -1 : 1;
            }
        }
        if (size$okio == size$okio2) {
            return 0;
        }
        return size$okio < size$okio2 ? -1 : 1;
    }

    public ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.data, 0, getSize$okio());
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        return new ByteString(bArrDigest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size$okio = byteString.getSize$okio();
            byte[] bArr = this.data;
            if (size$okio == bArr.length && byteString.rangeEquals(0, 0, bArr.length, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int getSize$okio() {
        return this.data.length;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = _ZlibJvmKt.HEX_DIGIT_CHARS;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public int indexOf(byte[] bArr, int i) {
        bArr.getClass();
        int length = this.data.length - bArr.length;
        int iMax = Math.max(i, 0);
        if (iMax > length) {
            return -1;
        }
        while (!HexFormatKt.arrayRangeEquals(iMax, 0, bArr.length, this.data, bArr)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public byte[] internalArray$okio() {
        return this.data;
    }

    public byte internalGet$okio(int i) {
        return this.data[i];
    }

    public int lastIndexOf(byte[] bArr, int i) {
        bArr.getClass();
        for (int iMin = Math.min(i, this.data.length - bArr.length); -1 < iMin; iMin--) {
            if (HexFormatKt.arrayRangeEquals(iMin, 0, bArr.length, this.data, bArr)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i, int i2, int i3, byte[] bArr) {
        bArr.getClass();
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.data;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && HexFormatKt.arrayRangeEquals(i, i2, i3, bArr2, bArr);
    }

    public String string(Charset charset) {
        charset.getClass();
        return new String(this.data, charset);
    }

    public ByteString substring(int i, int i2) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("beginIndex < 0");
            return null;
        }
        byte[] bArr = this.data;
        if (i2 > bArr.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("endIndex > length("), this.data.length, ')'));
            return null;
        }
        if (i2 - i >= 0) {
            return (i == 0 && i2 == bArr.length) ? this : new ByteString(ArraysKt.copyOfRange(bArr, i, i2));
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("endIndex < beginIndex");
        return null;
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i++;
        }
    }

    public byte[] toByteArray() {
        byte[] bArr = this.data;
        return Arrays.copyOf(bArr, bArr.length);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003f A[EDGE_INSN: B:23:0x003f->B:178:0x01ad BREAK  A[LOOP:0: B:7:0x000e->B:239:0x000e]] */
    public String toString() {
        byte b;
        int i;
        ByteString byteString = this;
        byte[] bArr = byteString.data;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i2 < length) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if ((b2 >> 5) != -2) {
                    if ((b2 >> 4) != -2) {
                        if ((b2 >> 3) != -2) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i5 = i2 + 3;
                        if (length > i5) {
                            byte b3 = bArr[i2 + 1];
                            if ((b3 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b4 = bArr[i2 + 2];
                            if ((b4 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b5 = bArr[i5];
                            if ((b5 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i6 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
                            if (i6 <= 1114111) {
                                if (55296 <= i6 && i6 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                                if (i6 >= 65536) {
                                    i = i4 + 1;
                                    if (i4 == 64) {
                                        break;
                                    }
                                    if ((i6 != 10 && i6 != 13 && ((i6 >= 0 && i6 < 32) || (127 <= i6 && i6 < 160))) || i6 == 65533) {
                                        i3 = -1;
                                        break;
                                    }
                                    i3 += i6 < 65536 ? 1 : 2;
                                    i2 += 4;
                                    i4 = i;
                                } else {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        int i7 = i2 + 2;
                        if (length > i7) {
                            byte b6 = bArr[i2 + 1];
                            if ((b6 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b7 = bArr[i7];
                            if ((b7 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i8 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b2 << 12);
                            if (i8 >= 2048) {
                                if (55296 <= i8 && i8 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                                i = i4 + 1;
                                if (i4 == 64) {
                                    break;
                                }
                                if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && i8 < 32) || (127 <= i8 && i8 < 160))) || i8 == 65533) {
                                    i3 = -1;
                                    break;
                                }
                                i3 += i8 < 65536 ? 1 : 2;
                                i2 += 3;
                                i4 = i;
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    }
                } else {
                    int i9 = i2 + 1;
                    if (length > i9) {
                        byte b8 = bArr[i9];
                        if ((b8 & 192) != 128) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i10 = (b8 ^ 3968) ^ (b2 << 6);
                        if (i10 >= 128) {
                            i = i4 + 1;
                            if (i4 == 64) {
                                break;
                            }
                            if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                                i3 = -1;
                                break;
                            }
                            i3 += i10 < 65536 ? 1 : 2;
                            i2 += 2;
                            i4 = i;
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        if (i4 == 64) {
                            break;
                        }
                        i3 = -1;
                        break;
                    }
                }
            } else {
                int i11 = i4 + 1;
                if (i4 == 64) {
                    break;
                }
                if ((b2 == 10 || b2 == 13 || ((b2 < 0 || b2 >= 32) && (127 > b2 || b2 >= 160))) && b2 != 65533) {
                    i3 += b2 < 65536 ? 1 : 2;
                    i2++;
                    while (true) {
                        i4 = i11;
                        if (i2 < length && (b = bArr[i2]) >= 0) {
                            i2++;
                            i11 = i4 + 1;
                            if (i4 == 64) {
                                break loop0;
                            }
                            if ((b == 10 || b == 13 || ((b < 0 || b >= 32) && (127 > b || b >= 160))) && b != 65533) {
                                i3 += b < 65536 ? 1 : 2;
                            }
                        }
                    }
                }
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            String strUtf8 = byteString.utf8();
            String strReplace = StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(strUtf8.substring(0, i3), "\\", "\\\\", false), "\n", "\\n", false), "\r", "\\r", false);
            if (i3 >= strUtf8.length()) {
                return Format$$ExternalSyntheticOutline0.m(']', "[text=", strReplace);
            }
            return "[size=" + byteString.data.length + " text=" + strReplace + "…]";
        }
        if (byteString.data.length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(byteString.data.length);
        sb.append(" hex=");
        byte[] bArr2 = byteString.data;
        if (64 > bArr2.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("endIndex > length("), byteString.data.length, ')'));
            return null;
        }
        if (64 != bArr2.length) {
            byteString = new ByteString(ArraysKt.copyOfRange(bArr2, 0, 64));
        }
        sb.append(byteString.hex());
        sb.append("…]");
        return sb.toString();
    }

    public final String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        byte[] bArrInternalArray$okio = internalArray$okio();
        bArrInternalArray$okio.getClass();
        String str2 = new String(bArrInternalArray$okio, Charsets.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public void write$okio(Buffer buffer, int i) {
        buffer.write(this.data, 0, i);
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2) {
        byteString.getClass();
        return byteString.rangeEquals(0, i, i2, this.data);
    }
}
