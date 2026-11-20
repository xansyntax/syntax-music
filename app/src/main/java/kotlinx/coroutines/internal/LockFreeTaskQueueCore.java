package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFramesUnsafe;
import com.google.common.base.Joiner;
import java.util.concurrent.atomic.AtomicReferenceArray;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class LockFreeTaskQueueCore {
    public static final Joiner REMOVE_FROZEN;
    public static final /* synthetic */ long _next$volatile$FU$offset;
    public static final /* synthetic */ long _state$volatile$FU$offset;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    public final /* synthetic */ AtomicReferenceArray array;
    public final int capacity;
    public final int mask;
    public final boolean singleConsumer;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Placeholder {
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    static {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        _next$volatile$FU$offset = unsafe.objectFieldOffset(LockFreeTaskQueueCore.class.getDeclaredField("_next$volatile"));
        _state$volatile$FU$offset = unsafe.objectFieldOffset(LockFreeTaskQueueCore.class.getDeclaredField("_state$volatile"));
        REMOVE_FROZEN = new Joiner("REMOVE_FROZEN", (byte) 5);
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.capacity = i;
        this.singleConsumer = z;
        int i2 = i - 1;
        this.mask = i2;
        this.array = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            throw null;
        }
        if ((i & i2) == 0) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        throw null;
    }

    public final int addLast(Object obj) {
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _state$volatile$FU$offset;
            long longVolatile = unsafe.getLongVolatile(lockFreeTaskQueueCore, j);
            if ((3458764513820540928L & longVolatile) != 0) {
                return (2305843009213693952L & longVolatile) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & longVolatile);
            int i2 = (int) ((1152921503533105152L & longVolatile) >> 30);
            int i3 = lockFreeTaskQueueCore.mask;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            boolean z = lockFreeTaskQueueCore.singleConsumer;
            AtomicReferenceArray atomicReferenceArray = lockFreeTaskQueueCore.array;
            if (z || atomicReferenceArray.get(i2 & i3) == null) {
                if (unsafe.compareAndSwapLong(lockFreeTaskQueueCore, _state$volatile$FU$offset, longVolatile, ((-1152921503533105153L) & longVolatile) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                    atomicReferenceArray.set(i2 & i3, obj);
                    LockFreeTaskQueueCore next = this;
                    while ((ArtificialStackFramesUnsafe.unsafe.getLongVolatile(next, j) & 1152921504606846976L) != 0) {
                        next = next.next();
                        AtomicReferenceArray atomicReferenceArray2 = next.array;
                        int i4 = next.mask & i2;
                        Object obj2 = atomicReferenceArray2.get(i4);
                        if ((obj2 instanceof Placeholder) && ((Placeholder) obj2).index == i2) {
                            atomicReferenceArray2.set(i4, obj);
                        } else {
                            next = null;
                        }
                        if (next == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
                lockFreeTaskQueueCore = this;
            } else {
                int i5 = lockFreeTaskQueueCore.capacity;
                if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean close() {
        while (true) {
            long longVolatile = ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, _state$volatile$FU$offset);
            if ((longVolatile & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & longVolatile) != 0) {
                return false;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
            if (ArtificialStackFramesUnsafe.unsafe.compareAndSwapLong(lockFreeTaskQueueCore, _state$volatile$FU$offset, longVolatile, longVolatile | 2305843009213693952L)) {
                return true;
            }
            this = lockFreeTaskQueueCore;
        }
    }

    public final LockFreeTaskQueueCore next() {
        Unsafe unsafe;
        long j;
        long longVolatile;
        long j2;
        Unsafe unsafe2;
        do {
            unsafe = ArtificialStackFramesUnsafe.unsafe;
            j = _state$volatile$FU$offset;
            longVolatile = unsafe.getLongVolatile(this, j);
            if ((longVolatile & 1152921504606846976L) != 0) {
                j2 = longVolatile;
                break;
            }
            j2 = 1152921504606846976L | longVolatile;
        } while (!unsafe.compareAndSwapLong(this, j, longVolatile, j2));
        while (true) {
            Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
            long j3 = _next$volatile$FU$offset;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) unsafe3.getObjectVolatile(this, j3);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
            int i = (int) (1073741823 & j2);
            int i2 = (int) ((1152921503533105152L & j2) >> 30);
            while (true) {
                int i3 = this.mask;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object placeholder = this.array.get(i4);
                if (placeholder == null) {
                    placeholder = new Placeholder(i);
                }
                lockFreeTaskQueueCore2.array.set(lockFreeTaskQueueCore2.mask & i, placeholder);
                i++;
            }
            ArtificialStackFramesUnsafe.unsafe.putLongVolatile(lockFreeTaskQueueCore2, _state$volatile$FU$offset, j2 & (-1152921504606846977L));
            do {
                unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                if (unsafe2.compareAndSwapObject(this, _next$volatile$FU$offset, (Object) null, lockFreeTaskQueueCore2)) {
                    break;
                }
            } while (unsafe2.getObjectVolatile(this, j3) == null);
        }
    }

    public final Object removeFirstOrNull() {
        LockFreeTaskQueueCore next = this;
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _state$volatile$FU$offset;
            long longVolatile = unsafe.getLongVolatile(next, j);
            if ((longVolatile & 1152921504606846976L) != 0) {
                return REMOVE_FROZEN;
            }
            int i = (int) (longVolatile & 1073741823);
            int i2 = next.mask;
            int i3 = ((int) ((1152921503533105152L & longVolatile) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 != i4) {
                AtomicReferenceArray atomicReferenceArray = next.array;
                Object obj = atomicReferenceArray.get(i4);
                boolean z = next.singleConsumer;
                if (obj == null) {
                    if (z) {
                    }
                } else if (!(obj instanceof Placeholder)) {
                    long j2 = (i + 1) & 1073741823;
                    if (unsafe.compareAndSwapLong(next, j, longVolatile, (longVolatile & (-1073741824)) | j2)) {
                        atomicReferenceArray.set(i4, null);
                        return obj;
                    }
                    next = this;
                    if (z) {
                        while (true) {
                            Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                            long j3 = _state$volatile$FU$offset;
                            long longVolatile2 = unsafe2.getLongVolatile(next, j3);
                            int i5 = (int) (longVolatile2 & 1073741823);
                            if ((longVolatile2 & 1152921504606846976L) != 0) {
                                next = next.next();
                            } else {
                                if (unsafe2.compareAndSwapLong(next, j3, longVolatile2, (longVolatile2 & (-1073741824)) | j2)) {
                                    next.array.set(next.mask & i5, null);
                                    next = null;
                                } else {
                                    continue;
                                }
                            }
                            if (next == null) {
                                return obj;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
}
