package okio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.collections.ArraysKt;
import kotlin.text.HexFormatKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal._ZlibJvmKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SegmentedByteString extends ByteString {
    public final transient int[] directory;
    public final transient byte[][] segments;

    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.data);
        this.segments = bArr;
        this.directory = iArr;
    }

    @Override // okio.ByteString
    public final String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public final ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.segments;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            messageDigest.update(bArr[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.getSize$okio() == getSize$okio() && rangeEquals(0, byteString, getSize$okio())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public final int getSize$okio() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.segments;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr2 = bArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public final String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public final int indexOf(byte[] bArr, int i) {
        bArr.getClass();
        return toByteString().indexOf(bArr, i);
    }

    @Override // okio.ByteString
    public final byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public final byte internalGet$okio(int i) {
        byte[][] bArr = this.segments;
        int length = bArr.length - 1;
        int[] iArr = this.directory;
        HexFormatKt.checkOffsetAndCount(iArr[length], i, 1L);
        int iSegment = _ZlibJvmKt.segment(this, i);
        return bArr[iSegment][(i - (iSegment == 0 ? 0 : iArr[iSegment - 1])) + iArr[bArr.length + iSegment]];
    }

    @Override // okio.ByteString
    public final int lastIndexOf(byte[] bArr, int i) {
        bArr.getClass();
        return toByteString().lastIndexOf(bArr, i);
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, int i2, int i3, byte[] bArr) {
        bArr.getClass();
        if (i >= 0 && i <= getSize$okio() - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
            int i4 = i3 + i;
            int iSegment = _ZlibJvmKt.segment(this, i);
            while (i < i4) {
                int[] iArr = this.directory;
                int i5 = iSegment == 0 ? 0 : iArr[iSegment - 1];
                int i6 = iArr[iSegment] - i5;
                byte[][] bArr2 = this.segments;
                int i7 = iArr[bArr2.length + iSegment];
                int iMin = Math.min(i4, i6 + i5) - i;
                if (HexFormatKt.arrayRangeEquals((i - i5) + i7, i2, iMin, bArr2[iSegment], bArr)) {
                    i2 += iMin;
                    i += iMin;
                    iSegment++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // okio.ByteString
    public final String string(Charset charset) {
        charset.getClass();
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public final ByteString substring(int i, int i2) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "beginIndex=", " < 0"));
            return null;
        }
        if (i2 > getSize$okio()) {
            StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i2, "endIndex=", " > length(");
            sbM2m.append(getSize$okio());
            sbM2m.append(')');
            throw new IllegalArgumentException(sbM2m.toString().toString());
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(i2, i, "endIndex=", " < beginIndex="));
            return null;
        }
        if (i == 0 && i2 == getSize$okio()) {
            return this;
        }
        if (i == i2) {
            return ByteString.EMPTY;
        }
        int iSegment = _ZlibJvmKt.segment(this, i);
        int iSegment2 = _ZlibJvmKt.segment(this, i2 - 1);
        byte[][] bArr = this.segments;
        byte[][] bArr2 = (byte[][]) ArraysKt.copyOfRange(bArr, iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.directory;
        if (iSegment <= iSegment2) {
            int i4 = iSegment;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(iArr2[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr2.length] = iArr2[bArr.length + i4];
                if (i4 == iSegment2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = iSegment != 0 ? iArr2[iSegment - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i - i7) + iArr[length];
        return new SegmentedByteString(bArr2, iArr);
    }

    @Override // okio.ByteString
    public final ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public final byte[] toByteArray() {
        byte[] bArr = new byte[getSize$okio()];
        byte[][] bArr2 = this.segments;
        int length = bArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(i3, i4, i4 + i6, bArr2[i], bArr);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public final String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public final void write$okio(Buffer buffer, int i) {
        int iSegment = _ZlibJvmKt.segment(this, 0);
        int i2 = 0;
        while (i2 < i) {
            int[] iArr = this.directory;
            int i3 = iSegment == 0 ? 0 : iArr[iSegment - 1];
            int i4 = iArr[iSegment] - i3;
            byte[][] bArr = this.segments;
            int i5 = iArr[bArr.length + iSegment];
            int iMin = Math.min(i, i4 + i3) - i2;
            int i6 = (i2 - i3) + i5;
            Segment segment = new Segment(bArr[iSegment], i6, i6 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                Segment segment3 = segment2.prev;
                segment3.getClass();
                segment3.push(segment);
            }
            i2 += iMin;
            iSegment++;
        }
        buffer.size += (long) i;
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, ByteString byteString, int i2) {
        byteString.getClass();
        if (i >= 0 && i <= getSize$okio() - i2) {
            int i3 = i2 + i;
            int iSegment = _ZlibJvmKt.segment(this, i);
            int i4 = 0;
            while (i < i3) {
                int[] iArr = this.directory;
                int i5 = iSegment == 0 ? 0 : iArr[iSegment - 1];
                int i6 = iArr[iSegment] - i5;
                byte[][] bArr = this.segments;
                int i7 = iArr[bArr.length + iSegment];
                int iMin = Math.min(i3, i6 + i5) - i;
                if (byteString.rangeEquals(i4, (i - i5) + i7, iMin, bArr[iSegment])) {
                    i4 += iMin;
                    i += iMin;
                    iSegment++;
                }
            }
            return true;
        }
        return false;
    }
}
