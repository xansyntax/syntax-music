package kotlin.uuid;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Uuid implements Comparable, Serializable {
    public static final Uuid NIL = new Uuid(0, 0);
    public final long leastSignificantBits;
    public final long mostSignificantBits;

    public Uuid(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Uuid uuid = (Uuid) obj;
        uuid.getClass();
        long j = uuid.mostSignificantBits;
        long j2 = this.mostSignificantBits;
        return j2 != j ? Long.compareUnsigned(j2, j) : Long.compareUnsigned(this.leastSignificantBits, uuid.leastSignificantBits);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        return this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits;
    }

    public final int hashCode() {
        return Long.hashCode(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    public final String toString() {
        byte[] bArr = new byte[36];
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 4);
        bArr[8] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 9, 4, 6);
        bArr[13] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 14, 6, 8);
        bArr[18] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, bArr, 19, 0, 2);
        bArr[23] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, bArr, 24, 2, 8);
        return StringsKt__StringsJVMKt.decodeToString(bArr);
    }
}
