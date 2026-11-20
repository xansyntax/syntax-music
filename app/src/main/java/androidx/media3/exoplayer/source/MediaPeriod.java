package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MediaPeriod extends SequenceableLoader {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Callback {
        void onContinueLoadingRequested(SequenceableLoader sequenceableLoader);

        void onPrepared(MediaPeriod mediaPeriod);
    }

    void discardBuffer(long j);

    long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters);

    TrackGroupArray getTrackGroups();

    void maybeThrowPrepareError();

    void prepare(Callback callback, long j);

    long readDiscontinuity();

    long seekToUs(long j);

    long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);
}
