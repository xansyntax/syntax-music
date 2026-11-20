package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.PlayerWrapper;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda14 implements ListenerSet.Event, Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda14(byte b, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        byte b = this.$r8$classId;
        boolean z = this.f$0;
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (b) {
            case 4:
                playerWrapper.setPlayWhenReady(z);
                break;
            case 5:
                playerWrapper.setDeviceMuted(z);
                break;
            default:
                playerWrapper.setShuffleModeEnabled(z);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        boolean z = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 0:
                listener.onSkipSilenceEnabledChanged(z);
                break;
            case 1:
                listener.onShuffleModeEnabledChanged(z);
                break;
            case 2:
                listener.onSkipSilenceEnabledChanged(z);
                break;
            default:
                listener.onShuffleModeEnabledChanged(z);
                break;
        }
    }
}
