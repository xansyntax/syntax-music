package androidx.activity.compose;

import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PredictiveBackHandlerInfo extends UtilsKt {
    public final long compositeKey;
    public final Object owner;

    public PredictiveBackHandlerInfo(long j, Object obj) {
        this.owner = obj;
        this.compositeKey = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PredictiveBackHandlerInfo)) {
            return false;
        }
        PredictiveBackHandlerInfo predictiveBackHandlerInfo = (PredictiveBackHandlerInfo) obj;
        return this.owner.equals(predictiveBackHandlerInfo.owner) && this.compositeKey == predictiveBackHandlerInfo.compositeKey;
    }

    public final int hashCode() {
        return Long.hashCode(this.compositeKey) + (this.owner.hashCode() * 31);
    }

    public final String toString() {
        return "PredictiveBackHandlerInfo(owner=" + this.owner + ", compositeKey=" + this.compositeKey + ')';
    }
}
