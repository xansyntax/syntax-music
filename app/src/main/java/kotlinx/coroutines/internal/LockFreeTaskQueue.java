package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFramesUnsafe;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class LockFreeTaskQueue {
    public static final /* synthetic */ long _cur$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(LockFreeTaskQueue.class.getDeclaredField("_cur$volatile"));
    private volatile /* synthetic */ Object _cur$volatile = new LockFreeTaskQueueCore(8, false);

    public final boolean addLast(Runnable runnable) {
        LockFreeTaskQueue lockFreeTaskQueue;
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _cur$volatile$FU$offset;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) unsafe.getObjectVolatile(this, j);
            int iAddLast = lockFreeTaskQueueCore.addLast(runnable);
            if (iAddLast == 0) {
                return true;
            }
            if (iAddLast == 1) {
                LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
                while (true) {
                    Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                    lockFreeTaskQueue = this;
                    if (unsafe2.compareAndSwapObject(lockFreeTaskQueue, _cur$volatile$FU$offset, lockFreeTaskQueueCore, next) || unsafe2.getObjectVolatile(lockFreeTaskQueue, j) != lockFreeTaskQueueCore) {
                        break;
                    }
                    this = lockFreeTaskQueue;
                }
            } else {
                if (iAddLast == 2) {
                    return false;
                }
                lockFreeTaskQueue = this;
            }
            this = lockFreeTaskQueue;
        }
    }

    public final void close() {
        LockFreeTaskQueue lockFreeTaskQueue;
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _cur$volatile$FU$offset;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) unsafe.getObjectVolatile(this, j);
            if (lockFreeTaskQueueCore.close()) {
                return;
            }
            LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
            while (true) {
                lockFreeTaskQueue = this;
                if (ArtificialStackFramesUnsafe.unsafe.compareAndSwapObject(lockFreeTaskQueue, _cur$volatile$FU$offset, lockFreeTaskQueueCore, next) || ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(lockFreeTaskQueue, j) != lockFreeTaskQueueCore) {
                    break;
                } else {
                    this = lockFreeTaskQueue;
                }
            }
            this = lockFreeTaskQueue;
        }
    }

    public final int getSize() {
        LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _cur$volatile$FU$offset);
        lockFreeTaskQueueCore.getClass();
        long longVolatile = ArtificialStackFramesUnsafe.unsafe.getLongVolatile(lockFreeTaskQueueCore, LockFreeTaskQueueCore._state$volatile$FU$offset);
        return 1073741823 & (((int) ((longVolatile & 1152921503533105152L) >> 30)) - ((int) (1073741823 & longVolatile)));
    }

    public final Object removeFirstOrNull() {
        LockFreeTaskQueue lockFreeTaskQueue;
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _cur$volatile$FU$offset;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) unsafe.getObjectVolatile(this, j);
            Object objRemoveFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
            if (objRemoveFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return objRemoveFirstOrNull;
            }
            LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
            while (true) {
                lockFreeTaskQueue = this;
                if (ArtificialStackFramesUnsafe.unsafe.compareAndSwapObject(lockFreeTaskQueue, _cur$volatile$FU$offset, lockFreeTaskQueueCore, next) || ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(lockFreeTaskQueue, j) != lockFreeTaskQueueCore) {
                    break;
                }
                this = lockFreeTaskQueue;
            }
            this = lockFreeTaskQueue;
        }
    }
}
