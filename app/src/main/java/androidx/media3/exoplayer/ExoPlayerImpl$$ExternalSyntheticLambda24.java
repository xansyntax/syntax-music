package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaSession$ControllerCb;
import androidx.media3.session.MediaSessionImpl$RemoteControllerTask;
import androidx.media3.session.PlayerWrapper;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda24 implements ListenerSet.Event, MediaControllerStub.ControllerTask, MediaSessionImpl$RemoteControllerTask, Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda24(int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = i;
        this.f$1 = i2;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        switch (this.$r8$classId) {
            case 4:
                ((PlayerWrapper) obj).setDeviceVolume(this.f$0, this.f$1);
                break;
            default:
                ((PlayerWrapper) obj).moveMediaItem(this.f$0, this.f$1);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((Player.Listener) obj).onSurfaceSizeChanged(this.f$0, this.f$1);
                break;
            default:
                ((Player.Listener) obj).onSurfaceSizeChanged(this.f$0, this.f$1);
                break;
        }
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void run(MediaControllerImplBase mediaControllerImplBase) {
        mediaControllerImplBase.onSurfaceSizeChanged(this.f$0, this.f$1);
    }

    @Override // androidx.media3.session.MediaSessionImpl$RemoteControllerTask
    public void run(MediaSession$ControllerCb mediaSession$ControllerCb, int i) {
        mediaSession$ControllerCb.onSurfaceSizeChanged(i, this.f$0, this.f$1);
    }
}
