package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda5 implements ListenerSet.Event, MediaControllerImplBase.RemoteSessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaControllerImplBase f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda5(MediaControllerImplBase mediaControllerImplBase, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaControllerImplBase;
        this.f$1 = z;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        boolean z = this.f$1;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 1:
                listener.onDeviceVolumeChanged(mediaControllerImplBase.playerInfo.deviceVolume, z);
                break;
            default:
                listener.onDeviceVolumeChanged(mediaControllerImplBase.playerInfo.deviceVolume, z);
                break;
        }
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        boolean z = this.f$1;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        switch (b) {
            case 0:
                iMediaSession.setPlayWhenReady(mediaControllerImplBase.controllerStub, i, z);
                break;
            case 1:
            default:
                iMediaSession.setDeviceMuted(mediaControllerImplBase.controllerStub, i, z);
                break;
            case 2:
                iMediaSession.setShuffleModeEnabled(mediaControllerImplBase.controllerStub, i, z);
                break;
        }
    }
}
