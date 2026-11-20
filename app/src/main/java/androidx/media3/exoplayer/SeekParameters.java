package androidx.media3.exoplayer;

import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SeekParameters {
    public static final SeekParameters DEFAULT;
    public static final SeekParameters PREVIOUS_SYNC;
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    static {
        SeekParameters seekParameters = new SeekParameters(0L, 0L);
        new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
        PREVIOUS_SYNC = new SeekParameters(Long.MAX_VALUE, 0L);
        new SeekParameters(0L, Long.MAX_VALUE);
        DEFAULT = seekParameters;
    }

    public SeekParameters(long j, long j2) {
        UtilsKt.checkArgument(j >= 0);
        UtilsKt.checkArgument(j2 >= 0);
        this.toleranceBeforeUs = j;
        this.toleranceAfterUs = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SeekParameters.class == obj.getClass()) {
            SeekParameters seekParameters = (SeekParameters) obj;
            if (this.toleranceBeforeUs == seekParameters.toleranceBeforeUs && this.toleranceAfterUs == seekParameters.toleranceAfterUs) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.toleranceBeforeUs) * 31) + ((int) this.toleranceAfterUs);
    }
}
