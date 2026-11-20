package androidx.media3.exoplayer.drm;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f$0;
    public final /* synthetic */ DrmSessionEventListener f$1;

    public /* synthetic */ DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda2(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, byte b) {
        this.$r8$classId = b;
        this.f$0 = eventDispatcher;
        this.f$1 = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        DrmSessionEventListener drmSessionEventListener = this.f$1;
        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f$0;
        switch (b) {
            case 0:
                drmSessionEventListener.onDrmSessionReleased(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                break;
            default:
                drmSessionEventListener.onDrmKeysRestored(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                break;
        }
    }
}
