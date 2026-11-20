package androidx.media3.session;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda3 implements ListenerSet.Event, MediaControllerImplBase.RemoteSessionTask, ListenerSet.IterationFinishedEvent {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaControllerImplBase f$0;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda3(MediaControllerImplBase mediaControllerImplBase, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaControllerImplBase;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 1:
                listener.onAvailableCommandsChanged(mediaControllerImplBase.intersectedPlayerCommands);
                break;
            default:
                listener.onAvailableCommandsChanged(mediaControllerImplBase.intersectedPlayerCommands);
                break;
        }
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        switch (b) {
            case 3:
                iMediaSession.seekForward(mediaControllerImplBase.controllerStub, i);
                break;
            case 4:
                iMediaSession.seekToDefaultPosition(mediaControllerImplBase.controllerStub, i);
                break;
            case 5:
                iMediaSession.seekToPrevious(mediaControllerImplBase.controllerStub, i);
                break;
            case 6:
                iMediaSession.clearMediaItems(mediaControllerImplBase.controllerStub, i);
                break;
            case 7:
                iMediaSession.seekBack(mediaControllerImplBase.controllerStub, i);
                break;
            case 8:
                iMediaSession.pause(mediaControllerImplBase.controllerStub, i);
                break;
            case 9:
                iMediaSession.increaseDeviceVolume(mediaControllerImplBase.controllerStub, i);
                break;
            case 10:
                iMediaSession.stop(mediaControllerImplBase.controllerStub, i);
                break;
            case 11:
                iMediaSession.prepare(mediaControllerImplBase.controllerStub, i);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                int sessionInterfaceVersion = mediaControllerImplBase.getSessionInterfaceVersion();
                MediaControllerStub mediaControllerStub = mediaControllerImplBase.controllerStub;
                if (sessionInterfaceVersion < 6) {
                    iMediaSession.setVolume(mediaControllerStub, i, CropImageView.DEFAULT_ASPECT_RATIO);
                } else {
                    iMediaSession.mute(mediaControllerStub, i);
                }
                break;
            case 13:
                iMediaSession.seekToNextMediaItem(mediaControllerImplBase.controllerStub, i);
                break;
            case 14:
                iMediaSession.decreaseDeviceVolume(mediaControllerImplBase.controllerStub, i);
                break;
            case 15:
                iMediaSession.seekToPreviousMediaItem(mediaControllerImplBase.controllerStub, i);
                break;
            case 16:
                iMediaSession.play(mediaControllerImplBase.controllerStub, i);
                break;
            default:
                iMediaSession.seekToNext(mediaControllerImplBase.controllerStub, i);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void invoke(Object obj, FlagSet flagSet) {
        ((Player.Listener) obj).onEvents(this.f$0.instance, new Player.Events(flagSet));
    }
}
