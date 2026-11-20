package com.google.common.util.concurrent;

import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TrustedListenableFutureTask extends FluentFuture.TrustedFuture implements RunnableFuture {
    public volatile TrustedFutureInterruptibleTask task;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TrustedFutureInterruptibleTask extends AtomicReference implements Runnable {
        public static final EmojiCompatInitializer.LoadEmojiCompatRunnable DONE;
        public static final EmojiCompatInitializer.LoadEmojiCompatRunnable PARKED;
        public final Callable callable;

        static {
            byte b = 1;
            DONE = new EmojiCompatInitializer.LoadEmojiCompatRunnable(b);
            PARKED = new EmojiCompatInitializer.LoadEmojiCompatRunnable(b);
        }

        public TrustedFutureInterruptibleTask(Callable callable) {
            callable.getClass();
            this.callable = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Thread threadCurrentThread = Thread.currentThread();
            Object objCall = null;
            if (compareAndSet(null, threadCurrentThread)) {
                TrustedListenableFutureTask trustedListenableFutureTask = TrustedListenableFutureTask.this;
                boolean zIsDone = trustedListenableFutureTask.isDone();
                EmojiCompatInitializer.LoadEmojiCompatRunnable loadEmojiCompatRunnable = DONE;
                if (!zIsDone) {
                    try {
                        objCall = this.callable.call();
                    } catch (Throwable th) {
                        try {
                            if (th instanceof InterruptedException) {
                                Thread.currentThread().interrupt();
                            }
                            if (!compareAndSet(threadCurrentThread, loadEmojiCompatRunnable)) {
                                waitForInterrupt(threadCurrentThread);
                            }
                            if (zIsDone) {
                                return;
                            }
                            trustedListenableFutureTask.setException(th);
                            return;
                        } catch (Throwable th2) {
                            if (!compareAndSet(threadCurrentThread, loadEmojiCompatRunnable)) {
                                waitForInterrupt(threadCurrentThread);
                            }
                            if (!zIsDone) {
                                trustedListenableFutureTask.set(null);
                            }
                            throw th2;
                        }
                    }
                }
                if (!compareAndSet(threadCurrentThread, loadEmojiCompatRunnable)) {
                    waitForInterrupt(threadCurrentThread);
                }
                if (zIsDone) {
                    return;
                }
                trustedListenableFutureTask.set(objCall);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final String toString() {
            String str;
            Runnable runnable = (Runnable) get();
            if (runnable == DONE) {
                str = "running=[DONE]";
            } else if (runnable instanceof InterruptibleTask$Blocker) {
                str = "running=[INTERRUPTED]";
            } else if (runnable instanceof Thread) {
                str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
            } else {
                str = "running=[NOT STARTED YET]";
            }
            return str + ", " + this.callable.toString();
        }

        public final void waitForInterrupt(Thread thread) {
            Runnable runnable = (Runnable) get();
            InterruptibleTask$Blocker interruptibleTask$Blocker = null;
            boolean z = false;
            int i = 0;
            while (true) {
                boolean z2 = runnable instanceof InterruptibleTask$Blocker;
                EmojiCompatInitializer.LoadEmojiCompatRunnable loadEmojiCompatRunnable = PARKED;
                if (!z2 && runnable != loadEmojiCompatRunnable) {
                    break;
                }
                if (z2) {
                    interruptibleTask$Blocker = (InterruptibleTask$Blocker) runnable;
                }
                i++;
                if (i <= 1000) {
                    Thread.yield();
                } else if (runnable == loadEmojiCompatRunnable || compareAndSet(runnable, loadEmojiCompatRunnable)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(interruptibleTask$Blocker);
                }
                runnable = (Runnable) get();
            }
            if (z) {
                thread.interrupt();
            }
        }
    }

    public TrustedListenableFutureTask(Callable callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        TrustedFutureInterruptibleTask trustedFutureInterruptibleTask;
        Object obj = this.valueField;
        if ((obj instanceof AbstractFuture.Cancellation) && ((AbstractFuture.Cancellation) obj).wasInterrupted && (trustedFutureInterruptibleTask = this.task) != null) {
            EmojiCompatInitializer.LoadEmojiCompatRunnable loadEmojiCompatRunnable = TrustedFutureInterruptibleTask.PARKED;
            EmojiCompatInitializer.LoadEmojiCompatRunnable loadEmojiCompatRunnable2 = TrustedFutureInterruptibleTask.DONE;
            Runnable runnable = (Runnable) trustedFutureInterruptibleTask.get();
            if (runnable instanceof Thread) {
                InterruptibleTask$Blocker interruptibleTask$Blocker = new InterruptibleTask$Blocker(trustedFutureInterruptibleTask);
                interruptibleTask$Blocker.setOwner(Thread.currentThread());
                if (trustedFutureInterruptibleTask.compareAndSet(runnable, interruptibleTask$Blocker)) {
                    try {
                        ((Thread) runnable).interrupt();
                        if (((Runnable) trustedFutureInterruptibleTask.getAndSet(loadEmojiCompatRunnable2)) == loadEmojiCompatRunnable) {
                            LockSupport.unpark((Thread) runnable);
                        }
                    } catch (Throwable th) {
                        if (((Runnable) trustedFutureInterruptibleTask.getAndSet(loadEmojiCompatRunnable2)) == loadEmojiCompatRunnable) {
                            LockSupport.unpark((Thread) runnable);
                        }
                        throw th;
                    }
                }
            }
        }
        this.task = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        TrustedFutureInterruptibleTask trustedFutureInterruptibleTask = this.task;
        if (trustedFutureInterruptibleTask == null) {
            return super.pendingToString();
        }
        return "task=[" + trustedFutureInterruptibleTask + "]";
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        TrustedFutureInterruptibleTask trustedFutureInterruptibleTask = this.task;
        if (trustedFutureInterruptibleTask != null) {
            trustedFutureInterruptibleTask.run();
        }
        this.task = null;
    }
}
