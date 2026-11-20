package androidx.media3.session;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda41 implements ListenerSet.Event {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PlaybackException f$0;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda41(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.$r8$classId = (byte) 1;
        this.f$0 = playbackException;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        byte b = this.$r8$classId;
        PlaybackException playbackException = this.f$0;
        switch (b) {
            case 0:
                ((Player.Listener) obj).onPlayerErrorChanged(playbackException);
                break;
            case 1:
                ((AnalyticsListener) obj).onPlayerError(playbackException);
                break;
            case 2:
                ((Player.Listener) obj).onPlayerError(playbackException);
                break;
            case 3:
                ((Player.Listener) obj).onPlayerErrorChanged(playbackException);
                break;
            default:
                ((Player.Listener) obj).onPlayerError(playbackException);
                break;
        }
    }

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda41(PlaybackException playbackException, byte b) {
        this.$r8$classId = b;
        this.f$0 = playbackException;
    }
}
