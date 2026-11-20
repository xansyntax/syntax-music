package androidx.media3.session;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda65 implements MediaSessionImpl$RemoteControllerTask, MediaSessionStub.SessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ MediaLibraryService.LibraryParams f$1;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda65(String str, MediaLibraryService.LibraryParams libraryParams, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = libraryParams;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        byte b = this.$r8$classId;
        MediaLibraryService.LibraryParams libraryParams = this.f$1;
        String str = this.f$0;
        switch (b) {
            case 0:
                return mediaLibrarySessionImpl.onSubscribeOnHandler(mediaSession$ControllerInfo, str, libraryParams);
            default:
                return mediaLibrarySessionImpl.onSearchOnHandler(mediaSession$ControllerInfo, str, libraryParams);
        }
    }

    @Override // androidx.media3.session.MediaSessionImpl$RemoteControllerTask
    public void run(MediaSession$ControllerCb mediaSession$ControllerCb, int i) {
        mediaSession$ControllerCb.onSearchResultChanged(i, this.f$0, this.f$1);
    }
}
