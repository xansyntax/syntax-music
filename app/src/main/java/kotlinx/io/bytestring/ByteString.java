package kotlinx.io.bytestring;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.date.GMTDateParser;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ByteString implements Comparable {
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    public final byte[] data;
    public int hashCode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteString(byte[] bArr, int i, int i2) {
        this(ArraysKt.copyOfRange(bArr, i, i2));
        bArr.getClass();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ByteString byteString = (ByteString) obj;
        byteString.getClass();
        byte[] bArr = byteString.data;
        if (byteString == this) {
            return 0;
        }
        byte[] bArr2 = this.data;
        int iMin = Math.min(bArr2.length, bArr.length);
        for (int i = 0; i < iMin; i++) {
            int iCompare = Intrinsics.compare(bArr2[i] & 255, bArr[i] & 255);
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Intrinsics.compare(bArr2.length, bArr.length);
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || ByteString.class != obj.getClass()) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        byte[] bArr = byteString.data;
        int length = bArr.length;
        byte[] bArr2 = this.data;
        if (length != bArr2.length) {
            return false;
        }
        int i2 = byteString.hashCode;
        if (i2 == 0 || (i = this.hashCode) == 0 || i2 == i) {
            return Arrays.equals(bArr2, bArr);
        }
        return false;
    }

    public final byte get(int i) {
        byte[] bArr = this.data;
        if (i >= 0 && i < bArr.length) {
            return bArr[i];
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "index (", ") is out of byte string bounds: [0.."), bArr.length, ')'));
        return (byte) 0;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return "ByteString(size=0)";
        }
        String strValueOf = String.valueOf(bArr.length);
        StringBuilder sb = new StringBuilder((bArr.length * 2) + strValueOf.length() + 22);
        sb.append("ByteString(size=");
        sb.append(strValueOf);
        sb.append(" hex=");
        for (byte b : bArr) {
            char[] cArr = HEX_DIGITS;
            sb.append(cArr[(b >>> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ByteString(byte[] bArr, int i) {
        this(bArr, 0, bArr.length);
    }

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }
}
