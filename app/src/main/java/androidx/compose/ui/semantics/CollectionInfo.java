package androidx.compose.ui.semantics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CollectionInfo {
    public final int columnCount;
    public final int rowCount;

    public CollectionInfo(int i, int i2) {
        this.rowCount = i;
        this.columnCount = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionInfo)) {
            return false;
        }
        CollectionInfo collectionInfo = (CollectionInfo) obj;
        return this.rowCount == collectionInfo.rowCount && this.columnCount == collectionInfo.columnCount;
    }

    public final int hashCode() {
        return Integer.hashCode(this.columnCount) + (Integer.hashCode(this.rowCount) * 31);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.rowCount, "CollectionInfo(rowCount=", ", columnCount=", this.columnCount, ")");
    }
}
