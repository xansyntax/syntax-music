package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda10 implements MediaControllerImplBase.RemoteSessionTask, ListenerSet.Event {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaControllerImplBase f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda10(MediaControllerImplBase mediaControllerImplBase, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaControllerImplBase;
        this.f$1 = i;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        int i = this.f$1;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 1:
                listener.onDeviceVolumeChanged(i, mediaControllerImplBase.playerInfo.deviceMuted);
                break;
            case 2:
                listener.onDeviceVolumeChanged(i, mediaControllerImplBase.playerInfo.deviceMuted);
                break;
            case 3:
                listener.onDeviceVolumeChanged(i, mediaControllerImplBase.playerInfo.deviceMuted);
                break;
            case 4:
            case 6:
            case 7:
            default:
                listener.onDeviceVolumeChanged(i, mediaControllerImplBase.playerInfo.deviceMuted);
                break;
            case 5:
                listener.onDeviceVolumeChanged(i, mediaControllerImplBase.playerInfo.deviceMuted);
                break;
            case 8:
                listener.onDeviceVolumeChanged(i, mediaControllerImplBase.playerInfo.deviceMuted);
                break;
        }
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        int i2 = this.f$1;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        switch (b) {
            case 0:
                iMediaSession.decreaseDeviceVolumeWithFlags(mediaControllerImplBase.controllerStub, i, i2);
                break;
            case 4:
                iMediaSession.increaseDeviceVolumeWithFlags(mediaControllerImplBase.controllerStub, i, i2);
                break;
            case 6:
                iMediaSession.setRepeatMode(mediaControllerImplBase.controllerStub, i, i2);
                break;
            case 7:
                iMediaSession.setDeviceVolume(mediaControllerImplBase.controllerStub, i, i2);
                break;
            case 10:
                iMediaSession.seekToDefaultPositionWithMediaItemIndex(mediaControllerImplBase.controllerStub, i, i2);
                break;
            default:
                iMediaSession.removeMediaItem(mediaControllerImplBase.controllerStub, i, i2);
                break;
        }
    }
}
