package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeoutCancellationException extends CancellationException implements CopyableThrowable {
    public final transient Job coroutine;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.coroutine = job;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
