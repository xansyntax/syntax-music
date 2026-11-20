package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoadControl$Parameters {
    public final long bufferedDurationUs;
    public final MediaSource$MediaPeriodId mediaPeriodId;
    public final float playbackSpeed;
    public final PlayerId playerId;
    public final Timeline timeline;

    public LoadControl$Parameters(PlayerId playerId, Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long j, float f, boolean z, long j2) {
        this.playerId = playerId;
        this.timeline = timeline;
        this.mediaPeriodId = mediaSource$MediaPeriodId;
        this.bufferedDurationUs = j;
        this.playbackSpeed = f;
    }
}
