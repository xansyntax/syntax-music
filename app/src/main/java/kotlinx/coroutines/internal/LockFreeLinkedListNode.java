package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFramesUnsafe;
import com.metrolist.music.utils.DataStoreKt$dataStore$2$2;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlinx.coroutines.AwaitKt;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class LockFreeLinkedListNode {
    public static final /* synthetic */ long _next$volatile$FU$offset;
    public static final /* synthetic */ long _prev$volatile$FU$offset;
    public static final /* synthetic */ long _removedRef$volatile$FU$offset;
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        _next$volatile$FU$offset = unsafe.objectFieldOffset(LockFreeLinkedListNode.class.getDeclaredField("_next$volatile"));
        _prev$volatile$FU$offset = unsafe.objectFieldOffset(LockFreeLinkedListNode.class.getDeclaredField("_prev$volatile"));
        _removedRef$volatile$FU$offset = unsafe.objectFieldOffset(LockFreeLinkedListNode.class.getDeclaredField("_removedRef$volatile"));
    }

    public final boolean addLast(LockFreeLinkedListNode lockFreeLinkedListNode, int i) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        LockFreeLinkedListNode lockFreeLinkedListNode3;
        while (true) {
            LockFreeLinkedListNode prevNode = this.getPrevNode();
            if (prevNode instanceof ListClosed) {
                return (((ListClosed) prevNode).forbiddenElementsBitmask & i) == 0 && prevNode.addLast(lockFreeLinkedListNode, i);
            }
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            unsafe.putObjectVolatile(lockFreeLinkedListNode, _prev$volatile$FU$offset, prevNode);
            long j = _next$volatile$FU$offset;
            unsafe.putObjectVolatile(lockFreeLinkedListNode, j, this);
            while (true) {
                Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                lockFreeLinkedListNode2 = this;
                lockFreeLinkedListNode3 = lockFreeLinkedListNode;
                if (unsafe2.compareAndSwapObject(prevNode, _next$volatile$FU$offset, lockFreeLinkedListNode2, lockFreeLinkedListNode3)) {
                    lockFreeLinkedListNode3.finishAdd(lockFreeLinkedListNode2);
                    return true;
                }
                if (unsafe2.getObjectVolatile(prevNode, j) != lockFreeLinkedListNode2) {
                    break;
                }
                this = lockFreeLinkedListNode2;
                lockFreeLinkedListNode = lockFreeLinkedListNode3;
            }
            this = lockFreeLinkedListNode2;
            lockFreeLinkedListNode = lockFreeLinkedListNode3;
        }
    }

    public final LockFreeLinkedListNode correctPrev() {
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _prev$volatile$FU$offset;
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) unsafe.getObjectVolatile(this, j);
            LockFreeLinkedListNode lockFreeLinkedListNode2 = null;
            LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode;
            while (true) {
                if (lockFreeLinkedListNode3 == null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                long j2 = _next$volatile$FU$offset;
                Object objectVolatile = unsafe2.getObjectVolatile(lockFreeLinkedListNode3, j2);
                if (objectVolatile == this) {
                    if (lockFreeLinkedListNode != lockFreeLinkedListNode3) {
                        while (true) {
                            Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
                            LockFreeLinkedListNode lockFreeLinkedListNode4 = this;
                            boolean zCompareAndSwapObject = unsafe3.compareAndSwapObject(lockFreeLinkedListNode4, _prev$volatile$FU$offset, lockFreeLinkedListNode, lockFreeLinkedListNode3);
                            LockFreeLinkedListNode lockFreeLinkedListNode5 = lockFreeLinkedListNode;
                            this = lockFreeLinkedListNode4;
                            if (!zCompareAndSwapObject) {
                                if (unsafe3.getObjectVolatile(this, j) != lockFreeLinkedListNode5) {
                                    break;
                                }
                                this = this;
                                lockFreeLinkedListNode = lockFreeLinkedListNode5;
                            }
                        }
                    }
                    return lockFreeLinkedListNode3;
                }
                lockFreeLinkedListNode = lockFreeLinkedListNode;
                this = this;
                if (this.isRemoved()) {
                    return null;
                }
                if (!(objectVolatile instanceof Removed)) {
                    objectVolatile.getClass();
                    lockFreeLinkedListNode2 = lockFreeLinkedListNode3;
                    lockFreeLinkedListNode3 = (LockFreeLinkedListNode) objectVolatile;
                } else if (lockFreeLinkedListNode2 != null) {
                    LockFreeLinkedListNode lockFreeLinkedListNode6 = ((Removed) objectVolatile).ref;
                    while (true) {
                        LockFreeLinkedListNode lockFreeLinkedListNode7 = lockFreeLinkedListNode3;
                        Unsafe unsafe4 = ArtificialStackFramesUnsafe.unsafe;
                        boolean zCompareAndSwapObject2 = unsafe4.compareAndSwapObject(lockFreeLinkedListNode2, _next$volatile$FU$offset, lockFreeLinkedListNode7, lockFreeLinkedListNode6);
                        lockFreeLinkedListNode3 = lockFreeLinkedListNode7;
                        if (zCompareAndSwapObject2) {
                            lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
                            lockFreeLinkedListNode2 = null;
                            break;
                        }
                        if (unsafe4.getObjectVolatile(lockFreeLinkedListNode2, j2) != lockFreeLinkedListNode3) {
                            break;
                        }
                    }
                } else {
                    if (lockFreeLinkedListNode3 == null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                    lockFreeLinkedListNode3 = (LockFreeLinkedListNode) unsafe2.getObjectVolatile(lockFreeLinkedListNode3, j);
                }
            }
            this = this;
        }
    }

    public final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _prev$volatile$FU$offset;
            LockFreeLinkedListNode lockFreeLinkedListNode3 = (LockFreeLinkedListNode) unsafe.getObjectVolatile(lockFreeLinkedListNode, j);
            if (this.getNext() != lockFreeLinkedListNode) {
                return;
            }
            while (true) {
                Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                lockFreeLinkedListNode2 = this;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = lockFreeLinkedListNode;
                if (unsafe2.compareAndSwapObject(lockFreeLinkedListNode4, _prev$volatile$FU$offset, lockFreeLinkedListNode3, lockFreeLinkedListNode2)) {
                    if (lockFreeLinkedListNode2.isRemoved()) {
                        lockFreeLinkedListNode4.correctPrev();
                        return;
                    }
                    return;
                } else {
                    lockFreeLinkedListNode = lockFreeLinkedListNode4;
                    if (unsafe2.getObjectVolatile(lockFreeLinkedListNode4, j) != lockFreeLinkedListNode3) {
                        break;
                    } else {
                        this = lockFreeLinkedListNode2;
                    }
                }
            }
            this = lockFreeLinkedListNode2;
        }
    }

    public final Object getNext() {
        return ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _next$volatile$FU$offset);
    }

    public final LockFreeLinkedListNode getNextNode() {
        Object next = getNext();
        Removed removed = next instanceof Removed ? (Removed) next : null;
        if (removed != null) {
            return removed.ref;
        }
        next.getClass();
        return (LockFreeLinkedListNode) next;
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode lockFreeLinkedListNodeCorrectPrev = correctPrev();
        if (lockFreeLinkedListNodeCorrectPrev != null) {
            return lockFreeLinkedListNodeCorrectPrev;
        }
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        long j = _prev$volatile$FU$offset;
        Object objectVolatile = unsafe.getObjectVolatile(this, j);
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) objectVolatile;
            if (!lockFreeLinkedListNode.isRemoved()) {
                return lockFreeLinkedListNode;
            }
            objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(lockFreeLinkedListNode, j);
        }
    }

    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public String toString() {
        return new DataStoreKt$dataStore$2$2(this, AwaitKt.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1, (byte) 6) + '@' + AwaitKt.getHexAddress(this);
    }
}
