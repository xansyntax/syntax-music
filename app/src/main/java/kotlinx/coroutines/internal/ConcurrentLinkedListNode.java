package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFramesUnsafe;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ConcurrentLinkedListNode {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final /* synthetic */ long _next$volatile$FU$offset;
    public static final /* synthetic */ long _prev$volatile$FU$offset;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        _next$volatile$FU$offset = unsafe.objectFieldOffset(ConcurrentLinkedListNode.class.getDeclaredField("_next$volatile"));
        _prev$volatile$FU$offset = unsafe.objectFieldOffset(ConcurrentLinkedListNode.class.getDeclaredField("_prev$volatile"));
    }

    public ConcurrentLinkedListNode(Segment segment) {
        this._prev$volatile = segment;
    }

    public final void cleanPrev() {
        ArtificialStackFramesUnsafe.unsafe.putObjectVolatile(this, _prev$volatile$FU$offset, (Object) null);
    }

    public final ConcurrentLinkedListNode getNext() {
        Object objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _next$volatile$FU$offset);
        if (objectVolatile == InlineList.CLOSED) {
            return null;
        }
        return (ConcurrentLinkedListNode) objectVolatile;
    }

    public abstract boolean isRemoved();

    public final void remove() {
        ConcurrentLinkedListNode concurrentLinkedListNode;
        Unsafe unsafe;
        if (getNext() == null) {
            return;
        }
        while (true) {
            Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
            long j = _prev$volatile$FU$offset;
            ConcurrentLinkedListNode concurrentLinkedListNode2 = (ConcurrentLinkedListNode) unsafe2.getObjectVolatile(this, j);
            while (concurrentLinkedListNode2 != null && concurrentLinkedListNode2.isRemoved()) {
                concurrentLinkedListNode2 = (ConcurrentLinkedListNode) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(concurrentLinkedListNode2, j);
            }
            ConcurrentLinkedListNode next = getNext();
            next.getClass();
            do {
                concurrentLinkedListNode = next;
                if (!concurrentLinkedListNode.isRemoved()) {
                    break;
                } else {
                    next = concurrentLinkedListNode.getNext();
                }
            } while (next != null);
            while (true) {
                Object objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(concurrentLinkedListNode, j);
                ConcurrentLinkedListNode concurrentLinkedListNode3 = ((ConcurrentLinkedListNode) objectVolatile) == null ? null : concurrentLinkedListNode2;
                while (true) {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    if (unsafe.compareAndSwapObject(concurrentLinkedListNode, _prev$volatile$FU$offset, objectVolatile, concurrentLinkedListNode3)) {
                        break;
                    } else if (unsafe.getObjectVolatile(concurrentLinkedListNode, j) != objectVolatile) {
                    }
                }
            }
            if (concurrentLinkedListNode2 != null) {
                unsafe.putObjectVolatile(concurrentLinkedListNode2, _next$volatile$FU$offset, concurrentLinkedListNode);
            }
            if (!concurrentLinkedListNode.isRemoved() || concurrentLinkedListNode.getNext() == null) {
                if (concurrentLinkedListNode2 == null || !concurrentLinkedListNode2.isRemoved()) {
                    return;
                }
            }
        }
    }
}
