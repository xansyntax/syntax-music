package androidx.media3.session;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionLegacyStub$$ExternalSyntheticLambda10 implements MediaControllerImplBase.RemoteSessionTask, MediaSessionLegacyStub.SessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ MediaSessionLegacyStub$$ExternalSyntheticLambda10(Object obj, float f, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = f;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        float f = this.f$1;
        MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f$0;
        switch (b) {
            case 1:
                iMediaSession.setPlaybackSpeed(mediaControllerImplBase.controllerStub, i, f);
                break;
            case 2:
                iMediaSession.setVolume(mediaControllerImplBase.controllerStub, i, f);
                break;
            default:
                int sessionInterfaceVersion = mediaControllerImplBase.getSessionInterfaceVersion();
                MediaControllerStub mediaControllerStub = mediaControllerImplBase.controllerStub;
                if (sessionInterfaceVersion < 6) {
                    iMediaSession.setVolume(mediaControllerStub, i, f);
                } else {
                    iMediaSession.unmute(mediaControllerStub, i);
                }
                break;
        }
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        ((MediaSessionLegacyStub) this.f$0).sessionImpl.playerWrapper.setPlaybackSpeed(this.f$1);
    }
}
