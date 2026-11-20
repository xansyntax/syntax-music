package androidx.compose.runtime;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OpaqueKey {
    public final String key;

    public OpaqueKey(String str) {
        this.key = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpaqueKey) && this.key.equals(((OpaqueKey) obj).key);
    }

    public final int hashCode() {
        return this.key.hashCode();
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("OpaqueKey(key=", this.key, ")");
    }
}
