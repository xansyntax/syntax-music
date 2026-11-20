package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FluentFuture extends AbstractFuture {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class TrustedFuture extends FluentFuture implements AbstractFuture.Trusted {
        @Override // com.google.common.util.concurrent.AbstractFutureState, java.util.concurrent.Future
        public final Object get() {
            return blockingGet();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.valueField instanceof AbstractFuture.Cancellation;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState, java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) {
            return blockingGet(j, timeUnit);
        }
    }
}
