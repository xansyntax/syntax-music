package androidx.media3.exoplayer.source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProgressiveMediaPeriod$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ProgressiveMediaPeriod f$0;

    public /* synthetic */ ProgressiveMediaPeriod$$ExternalSyntheticLambda0(ProgressiveMediaPeriod progressiveMediaPeriod, byte b) {
        this.$r8$classId = b;
        this.f$0 = progressiveMediaPeriod;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        ProgressiveMediaPeriod progressiveMediaPeriod = this.f$0;
        switch (b) {
            case 0:
                progressiveMediaPeriod.isLengthKnown = true;
                break;
            case 1:
                progressiveMediaPeriod.maybeFinishPrepare();
                break;
            default:
                if (!progressiveMediaPeriod.released) {
                    MediaPeriod.Callback callback = progressiveMediaPeriod.callback;
                    callback.getClass();
                    callback.onContinueLoadingRequested(progressiveMediaPeriod);
                }
                break;
        }
    }
}
