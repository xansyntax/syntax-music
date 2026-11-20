package com.google.common.util.concurrent;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InterruptibleTask$Blocker extends AbstractOwnableSynchronizer implements Runnable {
    public final TrustedListenableFutureTask.TrustedFutureInterruptibleTask task;

    public InterruptibleTask$Blocker(TrustedListenableFutureTask.TrustedFutureInterruptibleTask trustedFutureInterruptibleTask) {
        this.task = trustedFutureInterruptibleTask;
    }

    public final void setOwner(Thread thread) {
        setExclusiveOwnerThread(thread);
    }

    public final String toString() {
        return this.task.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
