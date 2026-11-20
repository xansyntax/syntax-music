package androidx.media3.session;

import androidx.media3.common.util.Consumer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda0 implements MediaSessionStub.ControllerPlayerTask, MediaSessionStub.MediaItemPlayerTask, Consumer {
    public final /* synthetic */ MediaSessionStub f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda0(MediaSessionStub mediaSessionStub, int i, int i2) {
        this.f$0 = mediaSessionStub;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        MediaSessionStub mediaSessionStub = this.f$0;
        ((MediaLibrarySessionImpl) mediaSessionStub.sessionImpl.get()).getClass();
        MediaSessionStub.SurfaceHolderWithSize surfaceHolderWithSize = mediaSessionStub.surfaceHolderWithSize;
        if (surfaceHolderWithSize != null) {
            surfaceHolderWithSize.setFixedSize(this.f$1, this.f$2);
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
    public void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        MediaSessionStub mediaSessionStub = this.f$0;
        playerWrapper.removeMediaItems(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, this.f$1), mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, this.f$2));
    }

    @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
    public void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo, List list) {
        MediaSessionStub mediaSessionStub = this.f$0;
        playerWrapper.replaceMediaItems(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, this.f$1), mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, this.f$2), list);
    }
}
