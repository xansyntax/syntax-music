package com.google.common.util.concurrent;

import coil3.util.UtilsKt;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractFuture<V> extends AbstractFutureState<V> {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED;
        static final Cancellation CAUSELESS_INTERRUPTED;
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractFutureState.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
            } else {
                CAUSELESS_CANCELLED = new Cancellation(null, false);
                CAUSELESS_INTERRUPTED = new Cancellation(null, true);
            }
        }

        public Cancellation(Throwable th, boolean z) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class DelegatingToFuture<V> implements Runnable {
        final ListenableFuture future;
        final AbstractFuture<V> owner;

        public DelegatingToFuture(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
            this.owner = abstractFuture;
            this.future = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.owner.valueField != this) {
                return;
            }
            if (AbstractFutureState.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Trusted<V> extends ListenableFuture {
    }

    public static void complete(AbstractFuture abstractFuture, boolean z) {
        Listener listener = null;
        while (true) {
            abstractFuture.releaseWaiters();
            if (z) {
                z = false;
            }
            abstractFuture.afterDone();
            Listener listener2 = listener;
            Listener listenerGasListeners = abstractFuture.gasListeners(Listener.TOMBSTONE);
            Listener listener3 = listener2;
            while (listenerGasListeners != null) {
                Listener listener4 = listenerGasListeners.next;
                listenerGasListeners.next = listener3;
                listener3 = listenerGasListeners;
                listenerGasListeners = listener4;
            }
            while (listener3 != null) {
                listener = listener3.next;
                Runnable runnable = listener3.task;
                Objects.requireNonNull(runnable);
                if (runnable instanceof DelegatingToFuture) {
                    DelegatingToFuture delegatingToFuture = (DelegatingToFuture) runnable;
                    abstractFuture = delegatingToFuture.owner;
                    if (abstractFuture.valueField != delegatingToFuture || !AbstractFutureState.casValue(abstractFuture, delegatingToFuture, getFutureValue(delegatingToFuture.future))) {
                    }
                } else {
                    Executor executor = listener3.executor;
                    Objects.requireNonNull(executor);
                    executeListener(runnable, executor);
                }
                listener3 = listener;
            }
            return;
        }
    }

    public static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            AbstractFutureState.log.get().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public static Object getDoneValue$1(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(((Cancellation) obj).cause);
            throw cancellationException;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        }
        if (obj == AbstractFutureState.NULL) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object getFutureValue(ListenableFuture listenableFuture) {
        Object obj;
        Throwable thTryInternalFastPathGetFailure;
        if (listenableFuture instanceof Trusted) {
            Object cancellation = ((AbstractFuture) listenableFuture).valueField;
            if (cancellation instanceof Cancellation) {
                Cancellation cancellation2 = (Cancellation) cancellation;
                if (cancellation2.wasInterrupted) {
                    cancellation = cancellation2.cause != null ? new Cancellation(cancellation2.cause, false) : Cancellation.CAUSELESS_CANCELLED;
                }
            }
            Objects.requireNonNull(cancellation);
            return cancellation;
        }
        if ((listenableFuture instanceof InternalFutureFailureAccess) && (thTryInternalFastPathGetFailure = ((InternalFutureFailureAccess) listenableFuture).tryInternalFastPathGetFailure()) != null) {
            return new Failure(thTryInternalFastPathGetFailure);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        boolean z = true;
        if ((!AbstractFutureState.GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            Cancellation cancellation3 = Cancellation.CAUSELESS_CANCELLED;
            Objects.requireNonNull(cancellation3);
            return cancellation3;
        }
        boolean z2 = false;
        while (true) {
            try {
                try {
                    try {
                        obj = listenableFuture.get();
                        break;
                    } catch (Error e) {
                        e = e;
                        return new Failure(e);
                    }
                } catch (InterruptedException unused) {
                    z2 = z;
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (Error | Exception e2) {
                e = e2;
                return new Failure(e);
            } catch (CancellationException e3) {
                if (zIsCancelled) {
                    return new Cancellation(e3, false);
                }
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
            } catch (ExecutionException e4) {
                if (!zIsCancelled) {
                    return new Failure(e4.getCause());
                }
                return new Cancellation(new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e4), false);
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        if (!zIsCancelled) {
            return obj == null ? AbstractFutureState.NULL : obj;
        }
        return new Cancellation(new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture), false);
    }

    public final void addDoneString(StringBuilder sb) {
        V v;
        boolean z = false;
        while (true) {
            try {
                try {
                    v = get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (ExecutionException e) {
                sb.append("FAILURE, cause=[");
                sb.append(e.getCause());
                sb.append("]");
                return;
            } catch (Exception e2) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e2.getClass());
                sb.append(" thrown from get()]");
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        appendResultObject(sb, v);
        sb.append("]");
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        UtilsKt.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (listener = this.listenersField) != Listener.TOMBSTONE) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.next = listener;
                if (casListeners(listener, listener2)) {
                    return;
                } else {
                    listener = this.listenersField;
                }
            } while (listener != Listener.TOMBSTONE);
        }
        executeListener(runnable, executor);
    }

    public final void appendResultObject(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Cancellation cancellation;
        Object obj = this.valueField;
        if (!(obj == null) && !(obj instanceof DelegatingToFuture)) {
            return false;
        }
        if (AbstractFutureState.GENERATE_CANCELLATION_CAUSES) {
            cancellation = new Cancellation(new CancellationException("Future.cancel() was called."), z);
        } else {
            cancellation = z ? Cancellation.CAUSELESS_INTERRUPTED : Cancellation.CAUSELESS_CANCELLED;
            Objects.requireNonNull(cancellation);
        }
        boolean z2 = false;
        while (true) {
            if (AbstractFutureState.casValue(this, obj, cancellation)) {
                complete(this, z);
                if (obj instanceof DelegatingToFuture) {
                    ListenableFuture listenableFuture = ((DelegatingToFuture) obj).future;
                    if (listenableFuture instanceof Trusted) {
                        this = (AbstractFuture) listenableFuture;
                        obj = this.valueField;
                        if ((obj == null) | (obj instanceof DelegatingToFuture)) {
                            z2 = true;
                        }
                    } else {
                        listenableFuture.cancel(z);
                    }
                }
                return true;
            }
            obj = this.valueField;
            if (!(obj instanceof DelegatingToFuture)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.valueField instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.valueField;
        return (!(obj instanceof DelegatingToFuture)) & (obj != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean set(Object obj) {
        if (obj == null) {
            obj = AbstractFutureState.NULL;
        }
        if (!AbstractFutureState.casValue(this, null, obj)) {
            return false;
        }
        complete(this, false);
        return true;
    }

    public boolean setException(Throwable th) {
        if (!AbstractFutureState.casValue(this, null, new Failure(th))) {
            return false;
        }
        complete(this, false);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    public boolean setFuture(ListenableFuture listenableFuture) {
        Failure failure;
        listenableFuture.getClass();
        Object obj = this.valueField;
        if (obj != null) {
            if (obj instanceof Cancellation) {
                listenableFuture.cancel(((Cancellation) obj).wasInterrupted);
            }
        } else if (!listenableFuture.isDone()) {
            DelegatingToFuture delegatingToFuture = new DelegatingToFuture(this, listenableFuture);
            if (AbstractFutureState.casValue(this, null, delegatingToFuture)) {
                try {
                    listenableFuture.addListener(delegatingToFuture, DirectExecutor.INSTANCE);
                    return true;
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Error | Exception unused) {
                        failure = Failure.FALLBACK_INSTANCE;
                    }
                    AbstractFutureState.casValue(this, delegatingToFuture, failure);
                    return true;
                }
            }
            obj = this.valueField;
            if (obj instanceof Cancellation) {
                listenableFuture.cancel(((Cancellation) obj).wasInterrupted);
            }
        } else if (AbstractFutureState.casValue(this, null, getFutureValue(listenableFuture))) {
            complete(this, false);
            return true;
        }
        return false;
    }

    public final String toString() {
        String strPendingToString;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof DelegatingToFuture) {
                sb.append(", setFuture=[");
                ListenableFuture listenableFuture = ((DelegatingToFuture) obj).future;
                try {
                    if (listenableFuture == this) {
                        sb.append("this future");
                    } else {
                        sb.append(listenableFuture);
                    }
                } catch (Throwable th) {
                    if ((th instanceof Error) && !(th instanceof StackOverflowError)) {
                        throw th;
                    }
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append("]");
            } else {
                try {
                    strPendingToString = pendingToString();
                    if (strPendingToString == null || strPendingToString.isEmpty()) {
                        strPendingToString = null;
                    }
                } catch (Throwable th2) {
                    if ((th2 instanceof Error) && !(th2 instanceof StackOverflowError)) {
                        throw th2;
                    }
                    strPendingToString = "Exception thrown from implementation: " + th2.getClass();
                }
                if (strPendingToString != null) {
                    sb.append(", info=[");
                    sb.append(strPendingToString);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                addDoneString(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFutureState, java.util.concurrent.Future
        public Object get() {
            return blockingGet();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return this.valueField instanceof Cancellation;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState, java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) {
            return blockingGet(j, timeUnit);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class Listener {
        static final Listener TOMBSTONE = new Listener();
        final Executor executor;
        Listener next;
        final Runnable task;

        public Listener() {
            this.task = null;
            this.executor = null;
        }

        public Listener(Runnable runnable, Executor executor) {
            this.task = runnable;
            this.executor = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class Failure {
        static final Failure FALLBACK_INSTANCE = new Failure(new AnonymousClass1("Failure occurred while trying to finish a future."));
        final Throwable exception;

        public Failure(Throwable th) {
            th.getClass();
            this.exception = th;
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractFuture$Failure$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public class AnonymousClass1 extends Throwable {
            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        }
    }

    public void afterDone() {
    }
}
