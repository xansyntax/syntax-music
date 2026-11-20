package androidx.compose.ui.platform;

import android.os.Trace;
import android.view.MotionEvent;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda3(AndroidComposeView androidComposeView, byte b) {
        this.$r8$classId = b;
        this.f$0 = androidComposeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        AndroidComposeView androidComposeView = this.f$0;
        switch (b) {
            case 0:
                ArrayDeque arrayDeque = androidComposeView.outOfFrameQueue;
                Trace.beginSection("AndroidOwner:outOfFrameExecutor");
                while (!arrayDeque.isEmpty()) {
                    try {
                        ((Function0) arrayDeque.removeLast()).invoke();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                Trace.endSection();
                return;
            case 1:
                androidComposeView.hoverExitReceived = false;
                MotionEvent motionEvent = androidComposeView.previousMotionEvent;
                motionEvent.getClass();
                if (motionEvent.getActionMasked() == 10) {
                    androidComposeView.m691sendMotionEvent8iAsVTc(motionEvent);
                    return;
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("The ACTION_HOVER_EXIT event was not cleared.");
                    return;
                }
            case 2:
                AndroidComposeView.invalidateLayers(androidComposeView.getRoot());
                return;
            default:
                AndroidComposeView.invalidateLayers(androidComposeView.getRoot());
                return;
        }
    }
}
