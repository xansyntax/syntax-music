package androidx.media3.session;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda48 implements MediaControllerImplBase.RemoteSessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda48(Object obj, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public final void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        int i2 = this.f$2;
        int i3 = this.f$1;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                iMediaSession.setDeviceVolumeWithFlags(((MediaControllerImplBase) obj).controllerStub, i, i3, i2);
                break;
            case 1:
                iMediaSession.moveMediaItem(((MediaControllerImplBase) obj).controllerStub, i, i3, i2);
                break;
            case 2:
                iMediaSession.removeMediaItems(((MediaControllerImplBase) obj).controllerStub, i, i3, i2);
                break;
            default:
                iMediaSession.onSurfaceSizeChanged(MediaControllerImplBase.this.controllerStub, i, i3, i2);
                break;
        }
    }
}
