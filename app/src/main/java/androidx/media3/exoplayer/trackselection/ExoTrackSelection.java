package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ExoTrackSelection {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Definition {
        public final TrackGroup group;
        public final int[] tracks;

        public Definition(TrackGroup trackGroup, int... iArr) {
            if (iArr.length == 0) {
                Log.e("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.group = trackGroup;
            this.tracks = iArr;
        }
    }

    void disable();

    void enable();

    Format getFormat(int i);

    int getIndexInTrackGroup(int i);

    Format getSelectedFormat();

    int getSelectedIndexInTrackGroup();

    TrackGroup getTrackGroup();

    int indexOf(int i);

    int length();

    void onPlayWhenReadyChanged(boolean z);

    void onPlaybackSpeed(float f);

    default void onDiscontinuity() {
    }

    default void onRebuffer() {
    }
}
