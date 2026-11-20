package androidx.media3.session;

import androidx.media3.common.MediaItem;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda98 implements MediaControllerImplBase.RemoteSessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaControllerImplBase f$0;
    public final /* synthetic */ MediaItem f$1;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda98(MediaControllerImplBase mediaControllerImplBase, MediaItem mediaItem, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaControllerImplBase;
        this.f$1 = mediaItem;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public final void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        MediaItem mediaItem = this.f$1;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        switch (b) {
            case 0:
                iMediaSession.setMediaItem(mediaControllerImplBase.controllerStub, i, mediaItem.toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true));
                break;
            default:
                iMediaSession.setMediaItemWithResetPosition(mediaControllerImplBase.controllerStub, i, mediaItem.toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true), true);
                break;
        }
    }
}
