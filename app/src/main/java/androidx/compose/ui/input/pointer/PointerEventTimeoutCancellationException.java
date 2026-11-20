package androidx.compose.ui.input.pointer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerEventTimeoutCancellationException extends CancellationException {
    public PointerEventTimeoutCancellationException(long j) {
        super(IntIntPair$$ExternalSyntheticOutline0.m(j, "Timed out waiting for ", " ms"));
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(PointerIconKt.EmptyStackTraceElements);
        return this;
    }
}
