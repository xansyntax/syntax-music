package androidx.compose.ui.internal;

import androidx.compose.foundation.internal.ClipboardUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformOptimizedCancellationException extends CancellationException {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlatformOptimizedCancellationException(String str, byte b) {
        super(str);
        this.$r8$classId = b;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        switch (this.$r8$classId) {
            case 0:
                setStackTrace(PlatformOptimizedCancellationException_jvmAndAndroidKt.EmptyStackTraceElements);
                break;
            default:
                setStackTrace(ClipboardUtils.EmptyStackTraceElements);
                break;
        }
        return this;
    }
}
