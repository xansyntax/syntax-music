package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4 implements ListenerSet.Event {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ VideoSize f$0;

    public /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4(VideoSize videoSize) {
        this.f$0 = videoSize;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((Player.Listener) obj).onVideoSizeChanged(this.f$0);
                break;
            default:
                VideoSize videoSize = this.f$0;
                ((AnalyticsListener) obj).onVideoSizeChanged(videoSize);
                int i = videoSize.width;
                break;
        }
    }

    public /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f$0 = videoSize;
    }
}
