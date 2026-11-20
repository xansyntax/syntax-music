package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Pair implements Serializable {
    public final Object first;
    public final Object second;

    public Pair(Object obj, Object obj2) {
        this.first = obj;
        this.second = obj2;
    }

    public static Pair copy$default(Pair pair, String str, String str2, int i) {
        Object obj = str;
        if ((i & 1) != 0) {
            obj = pair.first;
        }
        Object obj2 = str2;
        if ((i & 2) != 0) {
            obj2 = pair.second;
        }
        return new Pair(obj, obj2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Intrinsics.areEqual(this.first, pair.first) && Intrinsics.areEqual(this.second, pair.second);
    }

    public final int hashCode() {
        Object obj = this.first;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.second;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}
