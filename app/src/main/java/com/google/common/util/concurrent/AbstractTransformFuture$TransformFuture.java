package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AbstractTransformFuture$TransformFuture extends FluentFuture.TrustedFuture implements Runnable {
    public Object function;
    public ListenableFuture inputFuture;

    public static AbstractTransformFuture$TransformFuture create(ListenableFuture listenableFuture, Function function) {
        AbstractTransformFuture$TransformFuture abstractTransformFuture$TransformFuture = new AbstractTransformFuture$TransformFuture();
        listenableFuture.getClass();
        abstractTransformFuture$TransformFuture.inputFuture = listenableFuture;
        abstractTransformFuture$TransformFuture.function = function;
        listenableFuture.addListener(abstractTransformFuture$TransformFuture, DirectExecutor.INSTANCE);
        return abstractTransformFuture$TransformFuture;
    }

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
        this.function = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        String str;
        ListenableFuture listenableFuture = this.inputFuture;
        Object obj = this.function;
        String strPendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (obj == null) {
            if (strPendingToString != null) {
                return str.concat(strPendingToString);
            }
            return null;
        }
        return str + "function=[" + obj + "]";
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.inputFuture;
        Object obj = this.function;
        if (((this.valueField instanceof AbstractFuture.Cancellation) | (listenableFuture == null)) || (obj == null)) {
            return;
        }
        this.inputFuture = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                Object objApply = ((Function) obj).apply(UuidKt.getDone(listenableFuture));
                this.function = null;
                set(objApply);
            } catch (Throwable th) {
                try {
                    if (th instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    setException(th);
                } finally {
                    this.function = null;
                }
            }
        } catch (Error e) {
            setException(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e2) {
            setException(e2.getCause());
        } catch (Exception e3) {
            setException(e3);
        }
    }
}
