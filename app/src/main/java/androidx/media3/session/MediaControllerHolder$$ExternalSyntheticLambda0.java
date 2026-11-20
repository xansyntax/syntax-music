package androidx.media3.session;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerHolder$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaControllerHolder f$0;
    public final /* synthetic */ MediaController f$1;

    public /* synthetic */ MediaControllerHolder$$ExternalSyntheticLambda0(MediaControllerHolder mediaControllerHolder, MediaController mediaController, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaControllerHolder;
        this.f$1 = mediaController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MediaController mediaController = this.f$1;
        MediaControllerHolder mediaControllerHolder = this.f$0;
        switch (b) {
            case 0:
                if (mediaControllerHolder.isCancelled()) {
                    mediaController.release();
                }
                break;
            default:
                mediaControllerHolder.controller = mediaController;
                if (mediaControllerHolder.accepted) {
                    mediaControllerHolder.set(mediaController);
                }
                mediaControllerHolder.addListener(new MediaControllerHolder$$ExternalSyntheticLambda0(mediaControllerHolder, mediaController, (byte) 0), new MediaControllerHolder$$ExternalSyntheticLambda1((byte) 0, mediaControllerHolder));
                break;
        }
    }
}
