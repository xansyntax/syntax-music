package com.google.common.util.concurrent;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import io.ktor.http.LinkHeader;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractFutureState<V> extends InternalFutureFailureAccess implements ListenableFuture {
    private static final AtomicHelper ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    static final Object NULL = new Object();
    static final LazyLogger log = new LazyLogger(AbstractFuture.class);
    volatile AbstractFuture.Listener listenersField;
    volatile Object valueField;
    volatile Waiter waitersField;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static abstract class AtomicHelper {
        public boolean casListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
            Unsafe unsafe = UnsafeAtomicHelper.UNSAFE;
            long j = UnsafeAtomicHelper.LISTENERS_OFFSET;
            while (!unsafe.compareAndSwapObject(abstractFutureState, j, listener, listener2)) {
                if (unsafe.getObject(abstractFutureState, j) != listener) {
                    return false;
                }
            }
            return true;
        }

        public boolean casValue(AbstractFutureState abstractFutureState, Object obj, Object obj2) {
            Unsafe unsafe = UnsafeAtomicHelper.UNSAFE;
            long j = UnsafeAtomicHelper.VALUE_OFFSET;
            while (!unsafe.compareAndSwapObject(abstractFutureState, j, obj, obj2)) {
                if (unsafe.getObject(abstractFutureState, j) != obj) {
                    return false;
                }
            }
            return true;
        }

        public boolean casWaiters(AbstractFutureState abstractFutureState, Waiter waiter, Waiter waiter2) {
            Unsafe unsafe = UnsafeAtomicHelper.UNSAFE;
            long j = UnsafeAtomicHelper.WAITERS_OFFSET;
            while (!unsafe.compareAndSwapObject(abstractFutureState, j, waiter, waiter2)) {
                if (unsafe.getObject(abstractFutureState, j) != waiter) {
                    return false;
                }
            }
            return true;
        }

        public abstract AbstractFuture.Listener gasListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener);

        public abstract Waiter gasWaiters(AbstractFutureState abstractFutureState, Waiter waiter);

        public void putNext(Waiter waiter, Waiter waiter2) {
            UnsafeAtomicHelper.UNSAFE.putObject(waiter, UnsafeAtomicHelper.WAITER_NEXT_OFFSET, waiter2);
        }

        public void putThread(Waiter waiter, Thread thread) {
            UnsafeAtomicHelper.UNSAFE.putObject(waiter, UnsafeAtomicHelper.WAITER_THREAD_OFFSET, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class AtomicReferenceFieldUpdaterAtomicHelper extends AtomicHelper {
        private static final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater = AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread");
        private static final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater = AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, LinkHeader.Rel.Next);
        private static final AtomicReferenceFieldUpdater<? super AbstractFutureState<?>, Waiter> waitersUpdater = AtomicReferenceFieldUpdater.newUpdater(AbstractFutureState.class, Waiter.class, "waitersField");
        private static final AtomicReferenceFieldUpdater<? super AbstractFutureState<?>, AbstractFuture.Listener> listenersUpdater = AtomicReferenceFieldUpdater.newUpdater(AbstractFutureState.class, AbstractFuture.Listener.class, "listenersField");
        private static final AtomicReferenceFieldUpdater<? super AbstractFutureState<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(AbstractFutureState.class, Object.class, "valueField");

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final boolean casListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
            AtomicReferenceFieldUpdater<? super AbstractFutureState<?>, AbstractFuture.Listener> atomicReferenceFieldUpdater = listenersUpdater;
            while (!atomicReferenceFieldUpdater.compareAndSet(abstractFutureState, listener, listener2)) {
                if (atomicReferenceFieldUpdater.get(abstractFutureState) != listener) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final boolean casValue(AbstractFutureState abstractFutureState, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater<? super AbstractFutureState<?>, Object> atomicReferenceFieldUpdater = valueUpdater;
            while (!atomicReferenceFieldUpdater.compareAndSet(abstractFutureState, obj, obj2)) {
                if (atomicReferenceFieldUpdater.get(abstractFutureState) != obj) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final boolean casWaiters(AbstractFutureState abstractFutureState, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater<? super AbstractFutureState<?>, Waiter> atomicReferenceFieldUpdater = waitersUpdater;
            while (!atomicReferenceFieldUpdater.compareAndSet(abstractFutureState, waiter, waiter2)) {
                if (atomicReferenceFieldUpdater.get(abstractFutureState) != waiter) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final AbstractFuture.Listener gasListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener) {
            return listenersUpdater.getAndSet(abstractFutureState, listener);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final Waiter gasWaiters(AbstractFutureState abstractFutureState, Waiter waiter) {
            return waitersUpdater.getAndSet(abstractFutureState, waiter);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final void putNext(Waiter waiter, Waiter waiter2) {
            waiterNextUpdater.lazySet(waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final void putThread(Waiter waiter, Thread thread) {
            waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class UnsafeAtomicHelper extends AtomicHelper {
        static final long LISTENERS_OFFSET;
        static final Unsafe UNSAFE;
        static final long VALUE_OFFSET;
        static final long WAITERS_OFFSET;
        static final long WAITER_NEXT_OFFSET;
        static final long WAITER_THREAD_OFFSET;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (Exception e) {
                    PathKt$$ExternalSyntheticBUOutline0.m("Could not initialize intrinsics", (Throwable) e);
                    return;
                }
            } catch (SecurityException unused) {
                AbstractFutureState$UnsafeAtomicHelper$$ExternalSyntheticLambda0 abstractFutureState$UnsafeAtomicHelper$$ExternalSyntheticLambda0 = new AbstractFutureState$UnsafeAtomicHelper$$ExternalSyntheticLambda0();
                try {
                    unsafe = (Unsafe) Class.forName("java.security.AccessController").getMethod("doPrivileged", PrivilegedExceptionAction.class).invoke(null, abstractFutureState$UnsafeAtomicHelper$$ExternalSyntheticLambda0);
                } catch (Exception unused2) {
                    unsafe = (Unsafe) abstractFutureState$UnsafeAtomicHelper$$ExternalSyntheticLambda0.run();
                }
            }
            try {
                WAITERS_OFFSET = unsafe.objectFieldOffset(AbstractFutureState.class.getDeclaredField("waitersField"));
                LISTENERS_OFFSET = unsafe.objectFieldOffset(AbstractFutureState.class.getDeclaredField("listenersField"));
                VALUE_OFFSET = unsafe.objectFieldOffset(AbstractFutureState.class.getDeclaredField("valueField"));
                WAITER_THREAD_OFFSET = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("thread"));
                WAITER_NEXT_OFFSET = unsafe.objectFieldOffset(Waiter.class.getDeclaredField(LinkHeader.Rel.Next));
                UNSAFE = unsafe;
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final AbstractFuture.Listener gasListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener) {
            AbstractFuture.Listener listener2;
            do {
                listener2 = abstractFutureState.listenersField;
                if (listener == listener2) {
                    break;
                }
            } while (!casListeners(abstractFutureState, listener2, listener));
            return listener2;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        public final Waiter gasWaiters(AbstractFutureState abstractFutureState, Waiter waiter) {
            Waiter waiter2;
            do {
                waiter2 = abstractFutureState.waitersField;
                if (waiter == waiter2) {
                    break;
                }
            } while (!casWaiters(abstractFutureState, waiter2, waiter));
            return waiter2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class Waiter {
        static final Waiter TOMBSTONE = new Waiter();
        volatile Waiter next;
        volatile Thread thread;

        public Waiter() {
            AbstractFutureState.access$000(this, Thread.currentThread());
        }
    }

    static {
        boolean z;
        AtomicHelper atomicReferenceFieldUpdaterAtomicHelper;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        String property = System.getProperty("java.runtime.name", "");
        if (property == null || property.contains("Android")) {
            try {
                atomicReferenceFieldUpdaterAtomicHelper = new UnsafeAtomicHelper();
            } catch (Error | Exception unused2) {
                atomicReferenceFieldUpdaterAtomicHelper = new AtomicReferenceFieldUpdaterAtomicHelper();
            }
        } else {
            atomicReferenceFieldUpdaterAtomicHelper = new AtomicReferenceFieldUpdaterAtomicHelper();
        }
        ATOMIC_HELPER = atomicReferenceFieldUpdaterAtomicHelper;
    }

    public static void access$000(Waiter waiter, Thread thread) {
        ATOMIC_HELPER.putThread(waiter, thread);
    }

    public static void access$100(Waiter waiter, Waiter waiter2) {
        ATOMIC_HELPER.putNext(waiter, waiter2);
    }

    public static boolean casValue(AbstractFutureState abstractFutureState, Object obj, Object obj2) {
        return ATOMIC_HELPER.casValue(abstractFutureState, obj, obj2);
    }

    public final Object blockingGet(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.valueField;
        if ((obj != null) && (!(obj instanceof AbstractFuture.DelegatingToFuture))) {
            return AbstractFuture.getDoneValue$1(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.waitersField;
            if (waiter != Waiter.TOMBSTONE) {
                Waiter waiter2 = new Waiter();
                while (true) {
                    access$100(waiter2, waiter);
                    if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.valueField;
                            if ((obj2 != null) && (!(obj2 instanceof AbstractFuture.DelegatingToFuture))) {
                                return AbstractFuture.getDoneValue$1(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(waiter2);
                        break;
                    }
                    waiter = this.waitersField;
                    if (waiter == Waiter.TOMBSTONE) {
                    }
                }
            }
            Object obj3 = this.valueField;
            Objects.requireNonNull(obj3);
            return AbstractFuture.getDoneValue$1(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.valueField;
            if ((obj4 != null) && (!(obj4 instanceof AbstractFuture.DelegatingToFuture))) {
                return AbstractFuture.getDoneValue$1(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "Waited ", ServerSentEventKt.SPACE);
        sbM.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sbM.toString();
        if (nanos + 1000 < 0) {
            String strConcat = string3.concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strConcat2 = strConcat + jConvert + ServerSentEventKt.SPACE + lowerCase;
                if (z) {
                    strConcat2 = strConcat2.concat(",");
                }
                strConcat = strConcat2.concat(ServerSentEventKt.SPACE);
            }
            if (z) {
                strConcat = IntIntPair$$ExternalSyntheticOutline0.m(nanos2, strConcat, " nanoseconds ");
            }
            string3 = strConcat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(string3.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(IntIntPair$$ExternalSyntheticOutline0.m(string3, " for ", string));
    }

    public final boolean casListeners(AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
        return ATOMIC_HELPER.casListeners(this, listener, listener2);
    }

    public final AbstractFuture.Listener gasListeners(AbstractFuture.Listener listener) {
        return ATOMIC_HELPER.gasListeners(this, listener);
    }

    public Object get() {
        return blockingGet();
    }

    public final void releaseWaiters() {
        for (Waiter waiterGasWaiters = ATOMIC_HELPER.gasWaiters(this, Waiter.TOMBSTONE); waiterGasWaiters != null; waiterGasWaiters = waiterGasWaiters.next) {
            Thread thread = waiterGasWaiters.thread;
            if (thread != null) {
                waiterGasWaiters.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    public final void removeWaiter(Waiter waiter) {
        waiter.thread = null;
        while (true) {
            Waiter waiter2 = this.waitersField;
            if (waiter2 == Waiter.TOMBSTONE) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.next;
                if (waiter2.thread != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.next = waiter4;
                    if (waiter3.thread == null) {
                    }
                } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    public Object get(long j, TimeUnit timeUnit) {
        return blockingGet(j, timeUnit);
    }

    public final Object blockingGet() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.valueField;
            if ((obj2 != null) & (!(obj2 instanceof AbstractFuture.DelegatingToFuture))) {
                return AbstractFuture.getDoneValue$1(obj2);
            }
            Waiter waiter = this.waitersField;
            if (waiter != Waiter.TOMBSTONE) {
                Waiter waiter2 = new Waiter();
                do {
                    access$100(waiter2, waiter);
                    if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.valueField;
                            } else {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof AbstractFuture.DelegatingToFuture))));
                        return AbstractFuture.getDoneValue$1(obj);
                    }
                    waiter = this.waitersField;
                } while (waiter != Waiter.TOMBSTONE);
            }
            Object obj3 = this.valueField;
            Objects.requireNonNull(obj3);
            return AbstractFuture.getDoneValue$1(obj3);
        }
        throw new InterruptedException();
    }
}
