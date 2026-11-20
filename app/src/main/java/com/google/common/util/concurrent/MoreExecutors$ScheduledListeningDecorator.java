package com.google.common.util.concurrent;

import com.google.common.collect.Maps;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MoreExecutors$ScheduledListeningDecorator extends MoreExecutors$ListeningDecorator implements ScheduledExecutorService {
    public final ScheduledExecutorService delegate;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture implements Runnable {
        public final Runnable delegate;

        public NeverSuccessfulListenableFutureTask(Runnable runnable) {
            runnable.getClass();
            this.delegate = runnable;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final String pendingToString() {
            return "task=[" + this.delegate + "]";
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.delegate.run();
            } catch (Throwable th) {
                setException(th);
                throw th;
            }
        }
    }

    public MoreExecutors$ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(Executors.callable(runnable, null));
        return new ListenableScheduledTask(trustedListenableFutureTask, this.delegate.schedule(trustedListenableFutureTask, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
        return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
        return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ListenableScheduledTask extends Maps implements ScheduledFuture, ListenableFuture, Future {
        public final AbstractFuture delegate;
        public final ScheduledFuture scheduledDelegate;

        public ListenableScheduledTask(AbstractFuture abstractFuture, ScheduledFuture scheduledFuture) {
            this.delegate = abstractFuture;
            this.scheduledDelegate = scheduledFuture;
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            this.delegate.addListener(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            boolean zCancel$com$google$common$util$concurrent$ForwardingFuture = cancel$com$google$common$util$concurrent$ForwardingFuture(z);
            if (zCancel$com$google$common$util$concurrent$ForwardingFuture) {
                this.scheduledDelegate.cancel(z);
            }
            return zCancel$com$google$common$util$concurrent$ForwardingFuture;
        }

        public final boolean cancel$com$google$common$util$concurrent$ForwardingFuture(boolean z) {
            return this.delegate.cancel(z);
        }

        @Override // java.lang.Comparable
        public final int compareTo(Delayed delayed) {
            return this.scheduledDelegate.compareTo(delayed);
        }

        @Override // com.google.common.collect.Maps
        public final Object delegate() {
            return this.delegate;
        }

        @Override // java.util.concurrent.Future
        public final Object get() {
            return this.delegate.get();
        }

        @Override // java.util.concurrent.Delayed
        public final long getDelay(TimeUnit timeUnit) {
            return this.scheduledDelegate.getDelay(timeUnit);
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            return this.delegate.isDone();
        }

        @Override // java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) {
            return this.delegate.get(j, timeUnit);
        }
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(callable);
        return new ListenableScheduledTask(trustedListenableFutureTask, this.delegate.schedule(trustedListenableFutureTask, j, timeUnit));
    }
}
