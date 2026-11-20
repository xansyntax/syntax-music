package androidx.media3.session;

import android.os.Looper;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.util.concurrent.ImmediateFuture;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda8 implements ListenerSet.Event, MediaControllerStub.ControllerTask, MediaSessionImpl$RemoteControllerTask, Consumer, MediaSessionStub.SessionTask, MediaSessionStub.MediaItemPlayerTask {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda8(Rating rating) {
        this.$r8$classId = (byte) 29;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (this.$r8$classId) {
            case 11:
                playerWrapper.mute();
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                playerWrapper.pause();
                break;
            case 13:
                playerWrapper.seekToNextMediaItem();
                break;
            case 14:
                playerWrapper.increaseDeviceVolume();
                break;
            case 15:
                playerWrapper.seekBack();
                break;
            case 16:
                playerWrapper.seekToPrevious();
                break;
            case 17:
                playerWrapper.seekToPreviousMediaItem();
                break;
            case 18:
                playerWrapper.seekForward();
                break;
            case 19:
                playerWrapper.seekToNext();
                break;
            case 20:
            case 22:
            case 23:
            default:
                playerWrapper.clearMediaItems();
                break;
            case 21:
                playerWrapper.decreaseDeviceVolume();
                break;
            case 24:
                playerWrapper.stop();
                break;
            case 25:
                playerWrapper.unmute();
                break;
            case 26:
                playerWrapper.seekToDefaultPosition();
                break;
            case 27:
                playerWrapper.prepare();
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        switch (this.$r8$classId) {
            case 2:
                ((Player.Listener) obj).onPlaybackStateChanged(1);
                break;
            default:
                ((Player.Listener) obj).onVolumeChanged(CropImageView.DEFAULT_ASPECT_RATIO);
                break;
        }
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void run(MediaControllerImplBase mediaControllerImplBase) {
        switch (this.$r8$classId) {
            case 4:
                if (mediaControllerImplBase.isConnected()) {
                    MediaController mediaController = mediaControllerImplBase.instance;
                    mediaController.getClass();
                    UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                    mediaController.listener.getClass();
                    return;
                }
                return;
            case 5:
                mediaControllerImplBase.listeners.sendEvent(26, new DifferentialMotionFlingController$$ExternalSyntheticLambda0((byte) 29));
                return;
            case 6:
                MediaController mediaController2 = mediaControllerImplBase.instance;
                Objects.requireNonNull(mediaController2);
                mediaController2.runOnApplicationLooper(new MediaSessionService$$ExternalSyntheticLambda3((byte) 2, mediaController2));
                return;
            default:
                throw new ClassCastException();
        }
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda8(byte b) {
        this.$r8$classId = b;
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda8(String str, Rating rating) {
        this.$r8$classId = (byte) 20;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        switch (this.$r8$classId) {
            case 20:
                MediaLibrarySessionCallback mediaLibrarySessionCallback = mediaLibrarySessionImpl.callback$1;
                mediaLibrarySessionImpl.resolveControllerInfoForCallback(mediaSession$ControllerInfo);
                mediaLibrarySessionCallback.getClass();
                break;
            default:
                MediaLibrarySessionCallback mediaLibrarySessionCallback2 = mediaLibrarySessionImpl.callback$1;
                mediaLibrarySessionImpl.resolveControllerInfoForCallback(mediaSession$ControllerInfo);
                mediaLibrarySessionCallback2.getClass();
                break;
        }
        return new ImmediateFuture(new SessionResult(-6));
    }

    @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
    public void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo, List list) {
        switch (this.$r8$classId) {
            case 22:
                playerWrapper.addMediaItems(list);
                break;
            default:
                playerWrapper.addMediaItems(list);
                break;
        }
    }

    @Override // androidx.media3.session.MediaSessionImpl$RemoteControllerTask
    public void run(MediaSession$ControllerCb mediaSession$ControllerCb, int i) {
        switch (this.$r8$classId) {
            case 8:
                mediaSession$ControllerCb.getClass();
                break;
            case 9:
                mediaSession$ControllerCb.getClass();
                break;
            default:
                mediaSession$ControllerCb.onRenderedFirstFrame(i);
                break;
        }
    }
}
