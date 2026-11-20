package androidx.media3.exoplayer;

import androidx.datastore.core.AtomicInt;
import com.google.common.collect.ImmutableSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrubbingModeParameters {
    public static final ScrubbingModeParameters DEFAULT;
    public final ImmutableSet disabledTrackTypes;

    static {
        AtomicInt atomicInt = new AtomicInt();
        atomicInt.delegate = ImmutableSet.construct(2, 1, 5);
        DEFAULT = new ScrubbingModeParameters(atomicInt);
    }

    public ScrubbingModeParameters(AtomicInt atomicInt) {
        this.disabledTrackTypes = (ImmutableSet) atomicInt.delegate;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ScrubbingModeParameters) && this.disabledTrackTypes.equals(((ScrubbingModeParameters) obj).disabledTrackTypes);
    }

    public final int hashCode() {
        Boolean bool = Boolean.TRUE;
        return Objects.hash(this.disabledTrackTypes, null, null, bool, bool, bool, bool, bool);
    }
}
