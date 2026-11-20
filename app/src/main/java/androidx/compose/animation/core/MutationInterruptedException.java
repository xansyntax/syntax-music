package androidx.compose.animation.core;

import androidx.compose.animation.core.internal.PlatformOptimizedCancellationException_jvmAndAndroidKt;
import androidx.compose.runtime.internal.Expect_jvmKt;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutationInterruptedException extends CancellationException {
    public final /* synthetic */ byte $r8$classId = 1;

    public MutationInterruptedException() {
        super("The coroutine was canceled because it left the composition");
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        switch (this.$r8$classId) {
            case 0:
                setStackTrace(PlatformOptimizedCancellationException_jvmAndAndroidKt.EmptyStackTraceElements);
                break;
            default:
                setStackTrace(Expect_jvmKt.EmptyStackTraceElements);
                break;
        }
        return this;
    }

    public /* synthetic */ MutationInterruptedException(String str) {
        super(str);
    }
}
