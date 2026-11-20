package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import java.util.concurrent.ExecutionException;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AbstractCatchingFuture$CatchingFuture extends FluentFuture.TrustedFuture implements Runnable {
    public Class exceptionType;
    public Object fallback;
    public ListenableFuture inputFuture;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        ListenableFuture listenableFuture = this.inputFuture;
        boolean z = false;
        if ((listenableFuture != null) & (this.valueField instanceof AbstractFuture.Cancellation)) {
            Object obj = this.valueField;
            if ((obj instanceof AbstractFuture.Cancellation) && ((AbstractFuture.Cancellation) obj).wasInterrupted) {
                z = true;
            }
            listenableFuture.cancel(z);
        }
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        String str;
        ListenableFuture listenableFuture = this.inputFuture;
        Class cls = this.exceptionType;
        Object obj = this.fallback;
        String strPendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls == null || obj == null) {
            if (strPendingToString != null) {
                return str.concat(strPendingToString);
            }
            return null;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + obj + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object done;
        ListenableFuture listenableFuture = this.inputFuture;
        Class cls = this.exceptionType;
        Object obj = this.fallback;
        if (((obj == null) || ((listenableFuture == 0) | (cls == null))) || (this.valueField instanceof AbstractFuture.Cancellation)) {
            return;
        }
        this.inputFuture = null;
        try {
            th = listenableFuture instanceof InternalFutureFailureAccess ? ((InternalFutureFailureAccess) listenableFuture).tryInternalFastPathGetFailure() : null;
            done = th == null ? UuidKt.getDone(listenableFuture) : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + listenableFuture.getClass() + " threw " + e.getClass() + " without a cause");
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            set(done);
            return;
        }
        if (!cls.isInstance(th)) {
            setFuture(listenableFuture);
            return;
        }
        try {
            Object objApply = ((Function) obj).apply(th);
            this.exceptionType = null;
            this.fallback = null;
            set(objApply);
        } catch (Throwable th2) {
            try {
                if (th2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                setException(th2);
            } finally {
                this.exceptionType = null;
                this.fallback = null;
            }
        }
    }
}
