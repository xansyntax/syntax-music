package androidx.media3.session;

import androidx.media3.common.Rating;
import androidx.media3.common.util.Util;
import com.metrolist.music.playback.MediaLibrarySessionCallback;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionLegacyStub$$ExternalSyntheticLambda1 implements MediaSessionLegacyStub.SessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSessionLegacyStub f$0;

    public /* synthetic */ MediaSessionLegacyStub$$ExternalSyntheticLambda1(MediaSessionLegacyStub mediaSessionLegacyStub, Rating rating) {
        this.$r8$classId = (byte) 2;
        this.f$0 = mediaSessionLegacyStub;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public final void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        byte b = this.$r8$classId;
        MediaSessionLegacyStub mediaSessionLegacyStub = this.f$0;
        switch (b) {
            case 0:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.seekToNext();
                break;
            case 1:
                MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaSessionLegacyStub.sessionImpl;
                PlayerWrapper playerWrapper = mediaLibrarySessionImpl.playerWrapper;
                if (!Util.shouldShowPlayButton(playerWrapper, mediaLibrarySessionImpl.playIfSuppressed)) {
                    if (playerWrapper != null && playerWrapper.isCommandAvailable(1)) {
                        playerWrapper.pause();
                        break;
                    }
                } else {
                    Util.handlePlayButtonAction(playerWrapper);
                    break;
                }
                break;
            case 2:
                MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaSessionLegacyStub.sessionImpl;
                if (mediaLibrarySessionImpl2.playerWrapper.getCurrentMediaItemWithCommandCheck() != null) {
                    MediaLibrarySessionCallback mediaLibrarySessionCallback = mediaLibrarySessionImpl2.callback$1;
                    mediaLibrarySessionImpl2.resolveControllerInfoForCallback(mediaSession$ControllerInfo);
                    mediaLibrarySessionCallback.getClass();
                    new SessionResult(-6);
                    break;
                }
                break;
            case 3:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.seekToPrevious();
                break;
            case 4:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.seekToPreviousMediaItem();
                break;
            case 5:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.seekBack();
                break;
            case 6:
                mediaSessionLegacyStub.sessionImpl.handleMediaControllerPlayRequest(mediaSession$ControllerInfo, true);
                break;
            case 7:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.prepare();
                break;
            case 8:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.stop();
                break;
            case 9:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.seekToNextMediaItem();
                break;
            case 10:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.seekForward();
                break;
            default:
                PlayerWrapper playerWrapper2 = mediaSessionLegacyStub.sessionImpl.playerWrapper;
                String str = Util.DEVICE_DEBUG_INFO;
                if (playerWrapper2 != null && playerWrapper2.isCommandAvailable(1)) {
                    playerWrapper2.pause();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ MediaSessionLegacyStub$$ExternalSyntheticLambda1(MediaSessionLegacyStub mediaSessionLegacyStub, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaSessionLegacyStub;
    }
}
