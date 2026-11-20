package androidx.media3.session;

import androidx.media3.common.MediaItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda6 implements MediaSessionStub.ControllerPlayerTask, MediaSessionStub.MediaItemPlayerTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSessionStub f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda6(MediaSessionStub mediaSessionStub, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaSessionStub;
        this.f$1 = i;
    }

    @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
    public void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo, List list) {
        byte b = this.$r8$classId;
        int i = this.f$1;
        MediaSessionStub mediaSessionStub = this.f$0;
        switch (b) {
            case 2:
                playerWrapper.addMediaItems(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, i), list);
                break;
            case 3:
                if (list.size() != 1) {
                    playerWrapper.replaceMediaItems(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, i), mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, i + 1), list);
                } else {
                    playerWrapper.replaceMediaItem(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, i), (MediaItem) list.get(0));
                }
                break;
            default:
                playerWrapper.addMediaItems(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, i), list);
                break;
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
    public void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        byte b = this.$r8$classId;
        int i = this.f$1;
        MediaSessionStub mediaSessionStub = this.f$0;
        switch (b) {
            case 0:
                playerWrapper.removeMediaItem(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, i));
                break;
            default:
                playerWrapper.seekToDefaultPosition(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, i));
                break;
        }
    }
}
