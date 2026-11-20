package androidx.media3.exoplayer.trackselection;

import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FixedTrackSelection implements ExoTrackSelection {
    public final /* synthetic */ byte $r8$classId;
    public final Format[] formats;
    public final TrackGroup group;
    public int hashCode;
    public final int length;
    public final int[] tracks;

    public FixedTrackSelection(TrackGroup trackGroup, int[] iArr, byte b) {
        Format[] formatArr;
        this.$r8$classId = b;
        UtilsKt.checkState(iArr.length > 0);
        trackGroup.getClass();
        Format[] formatArr2 = trackGroup.formats;
        this.group = trackGroup;
        int length = iArr.length;
        this.length = length;
        this.formats = new Format[length];
        int i = 0;
        while (true) {
            int length2 = iArr.length;
            formatArr = this.formats;
            if (i >= length2) {
                break;
            }
            formatArr[i] = formatArr2[iArr[i]];
            i++;
        }
        Arrays.sort(formatArr, new LayoutNode$$ExternalSyntheticLambda1((byte) 10));
        this.tracks = new int[this.length];
        int i2 = 0;
        while (true) {
            int i3 = this.length;
            if (i2 >= i3) {
                long[] jArr = new long[i3];
                return;
            }
            int[] iArr2 = this.tracks;
            Format format = this.formats[i2];
            int i4 = 0;
            while (true) {
                if (i4 >= formatArr2.length) {
                    i4 = -1;
                    break;
                } else if (format == formatArr2[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
            iArr2[i2] = i4;
            i2++;
        }
    }

    public static void addCheckpoint(ArrayList arrayList, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ImmutableList.Builder builder = (ImmutableList.Builder) arrayList.get(i);
            if (builder != null) {
                builder.add((Object) new AdaptiveTrackSelection$AdaptationCheckpoint(j, jArr[i]));
            }
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void disable() {
        byte b = this.$r8$classId;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void enable() {
        byte b = this.$r8$classId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            FixedTrackSelection fixedTrackSelection = (FixedTrackSelection) obj;
            if (this.group.equals(fixedTrackSelection.group) && Arrays.equals(this.tracks, fixedTrackSelection.tracks)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final Format getFormat(int i) {
        return this.formats[i];
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int getIndexInTrackGroup(int i) {
        return this.tracks[i];
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final Format getSelectedFormat() {
        return this.formats[0];
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[0];
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.tracks) + (System.identityHashCode(this.group) * 31);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.tracks[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void onPlaybackSpeed(float f) {
        byte b = this.$r8$classId;
    }

    private final void disable$androidx$media3$exoplayer$trackselection$AdaptiveTrackSelection() {
    }

    private final void enable$androidx$media3$exoplayer$trackselection$AdaptiveTrackSelection() {
    }

    public final void disable$androidx$media3$exoplayer$trackselection$BaseTrackSelection() {
    }

    public final void enable$androidx$media3$exoplayer$trackselection$BaseTrackSelection() {
    }

    private final void onPlaybackSpeed$androidx$media3$exoplayer$trackselection$AdaptiveTrackSelection(float f) {
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final void onPlayWhenReadyChanged(boolean z) {
    }

    public final void onPlaybackSpeed$androidx$media3$exoplayer$trackselection$BaseTrackSelection(float f) {
    }
}
