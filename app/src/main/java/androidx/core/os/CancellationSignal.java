package androidx.core.os;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CancellationSignal {
    public boolean mCancelInProgress;
    public boolean mIsCanceled;
    public OnCancelListener mOnCancelListener;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface OnCancelListener {
        void onCancel();
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            while (this.mCancelInProgress) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.mOnCancelListener == onCancelListener) {
                return;
            }
            this.mOnCancelListener = onCancelListener;
            if (this.mIsCanceled) {
                onCancelListener.onCancel();
            }
        }
    }
}
