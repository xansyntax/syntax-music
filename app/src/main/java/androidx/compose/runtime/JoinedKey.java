package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class JoinedKey {
    public final Integer left;
    public final Object right;

    public JoinedKey(Integer num, Object obj) {
        this.left = num;
        this.right = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JoinedKey)) {
            return false;
        }
        JoinedKey joinedKey = (JoinedKey) obj;
        return this.left.equals(joinedKey.left) && Intrinsics.areEqual(this.right, joinedKey.right);
    }

    public final int hashCode() {
        int iHashCode;
        int iHashCode2 = this.left.hashCode() * 31;
        Object obj = this.right;
        if (obj instanceof Enum) {
            iHashCode = ((Enum) obj).ordinal();
        } else {
            iHashCode = obj != null ? obj.hashCode() : 0;
        }
        return iHashCode + iHashCode2;
    }

    public final String toString() {
        return "JoinedKey(left=" + this.left + ", right=" + this.right + ")";
    }
}
