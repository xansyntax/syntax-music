package androidx.media3.common.util;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StuckPlayerException extends IllegalStateException {
    public final byte stuckType;
    public final int timeoutMs;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public StuckPlayerException(int i, int i2) {
        String strM;
        if (i == 0) {
            strM = IntIntPair$$ExternalSyntheticOutline0.m(i2, "Player stuck buffering and not loading for ", " ms");
        } else if (i == 1) {
            strM = IntIntPair$$ExternalSyntheticOutline0.m(i2, "Player stuck buffering with no progress for ", " ms");
        } else if (i == 2) {
            strM = IntIntPair$$ExternalSyntheticOutline0.m(i2, "Player stuck playing with no progress for ", " ms");
        } else if (i == 3) {
            strM = IntIntPair$$ExternalSyntheticOutline0.m(i2, "Player stuck playing without ending for ", " ms");
        } else {
            if (i != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                throw null;
            }
            strM = IntIntPair$$ExternalSyntheticOutline0.m(i2, "Player stuck suppressed for ", " ms");
        }
        super(strM);
        this.stuckType = i;
        this.timeoutMs = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StuckPlayerException.class != obj.getClass()) {
            return false;
        }
        StuckPlayerException stuckPlayerException = (StuckPlayerException) obj;
        return this.stuckType == stuckPlayerException.stuckType && this.timeoutMs == stuckPlayerException.timeoutMs;
    }

    public final int hashCode() {
        return ((527 + this.stuckType) * 31) + this.timeoutMs;
    }
}
