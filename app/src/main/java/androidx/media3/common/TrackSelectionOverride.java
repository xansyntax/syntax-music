package androidx.media3.common;

import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TrackSelectionOverride {
    public static final String FIELD_TRACKS;
    public static final String FIELD_TRACK_GROUP;
    public final TrackGroup mediaTrackGroup;
    public final ImmutableList trackIndices;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_TRACK_GROUP = Integer.toString(0, 36);
        FIELD_TRACKS = Integer.toString(1, 36);
    }

    public TrackSelectionOverride(TrackGroup trackGroup, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= trackGroup.length)) {
            throw new IndexOutOfBoundsException();
        }
        this.mediaTrackGroup = trackGroup;
        this.trackIndices = ImmutableList.copyOf((Collection) list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionOverride.class != obj.getClass()) {
            return false;
        }
        TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) obj;
        return this.mediaTrackGroup.equals(trackSelectionOverride.mediaTrackGroup) && this.trackIndices.equals(trackSelectionOverride.trackIndices);
    }

    public final int hashCode() {
        return (this.trackIndices.hashCode() * 31) + this.mediaTrackGroup.hashCode();
    }
}
