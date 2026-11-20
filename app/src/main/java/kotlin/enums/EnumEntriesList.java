package kotlin.enums;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumEntriesList extends AbstractList implements EnumEntries, RandomAccess, Serializable {
    public final Enum[] entries;

    public EnumEntriesList(Enum[] enumArr) {
        enumArr.getClass();
        this.entries = enumArr;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r3 = (Enum) obj;
        return ((Enum) ArraysKt.getOrNull(r3.ordinal(), this.entries)) == r3;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.entries;
        int length = enumArr.length;
        if (i >= 0 && i < length) {
            return enumArr[i];
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, length, "index: ", ", size: "));
        return null;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.entries.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r3 = (Enum) obj;
        int iOrdinal = r3.ordinal();
        if (((Enum) ArraysKt.getOrNull(iOrdinal, this.entries)) == r3) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r3 = (Enum) obj;
        int iOrdinal = r3.ordinal();
        if (((Enum) ArraysKt.getOrNull(iOrdinal, this.entries)) == r3) {
            return iOrdinal;
        }
        return -1;
    }
}
