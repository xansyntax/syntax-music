package androidx.media3.session;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda33 implements ListenerSet.Event, Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PlaybackParameters f$0;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda33(PlaybackParameters playbackParameters, byte b) {
        this.$r8$classId = b;
        this.f$0 = playbackParameters;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        ((PlayerWrapper) obj).setPlaybackParameters(this.f$0);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        PlaybackParameters playbackParameters = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 1:
                listener.onPlaybackParametersChanged(playbackParameters);
                break;
            default:
                listener.onPlaybackParametersChanged(playbackParameters);
                break;
        }
    }
}
