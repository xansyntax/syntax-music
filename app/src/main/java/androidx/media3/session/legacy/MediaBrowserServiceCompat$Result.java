package androidx.media3.session.legacy;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat$Result {
    public final Object debug;
    public boolean detachCalled;
    public boolean sendErrorCalled;
    public boolean sendResultCalled;

    public MediaBrowserServiceCompat$Result(Object obj) {
        this.debug = obj;
    }

    public void detach() {
        boolean z = this.detachCalled;
        Object obj = this.debug;
        if (z) {
            PathKt$$ExternalSyntheticBUOutline0.m$1(obj, "detach() called when detach() had already been called for: ");
            return;
        }
        if (this.sendResultCalled) {
            PathKt$$ExternalSyntheticBUOutline0.m$1(obj, "detach() called when sendResult() had already been called for: ");
        } else if (this.sendErrorCalled) {
            PathKt$$ExternalSyntheticBUOutline0.m$1(obj, "detach() called when sendError() had already been called for: ");
        } else {
            this.detachCalled = true;
        }
    }

    public final boolean isDone() {
        return this.detachCalled || this.sendResultCalled || this.sendErrorCalled;
    }

    public void onErrorSent() {
        throw new UnsupportedOperationException("It is not supported to send an error for " + this.debug);
    }

    public abstract void onResultSent(Object obj);

    public final void sendError() {
        if (this.sendResultCalled || this.sendErrorCalled) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.debug, "sendError() called when either sendResult() or sendError() had already been called for: ");
        } else {
            this.sendErrorCalled = true;
            onErrorSent();
        }
    }

    public final void sendResult(Object obj) {
        if (this.sendResultCalled || this.sendErrorCalled) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.debug, "sendResult() called when either sendResult() or sendError() had already been called for: ");
        } else {
            this.sendResultCalled = true;
            onResultSent(obj);
        }
    }
}
