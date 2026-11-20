package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFramesUnsafe;
import java.util.Arrays;
import kotlinx.coroutines.EventLoopImplBase;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ThreadSafeHeap {
    public static final /* synthetic */ long _size$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(ThreadSafeHeap.class.getDeclaredField("_size$volatile"));
    private volatile /* synthetic */ int _size$volatile;
    public EventLoopImplBase.DelayedTask[] a;

    public final void addImpl(EventLoopImplBase.DelayedTask delayedTask) {
        delayedTask.setHeap((EventLoopImplBase.DelayedTaskQueue) this);
        EventLoopImplBase.DelayedTask[] delayedTaskArr = this.a;
        if (delayedTaskArr == null) {
            delayedTaskArr = new EventLoopImplBase.DelayedTask[4];
            this.a = delayedTaskArr;
        } else if (getSize() >= delayedTaskArr.length) {
            delayedTaskArr = (EventLoopImplBase.DelayedTask[]) Arrays.copyOf(delayedTaskArr, getSize() * 2);
            this.a = delayedTaskArr;
        }
        int size = getSize();
        ArtificialStackFramesUnsafe.unsafe.putIntVolatile(this, _size$volatile$FU$offset, size + 1);
        delayedTaskArr[size] = delayedTask;
        delayedTask.index = size;
        siftUpFrom(size);
    }

    public final int getSize() {
        return ArtificialStackFramesUnsafe.unsafe.getIntVolatile(this, _size$volatile$FU$offset);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0047  */
    /* JADX WARN: Code duplicated, block: B:14:0x0054  */
    /* JADX WARN: Code duplicated, block: B:17:0x0065  */
    /* JADX WARN: Code duplicated, block: B:21:0x0077 A[LOOP:0: B:9:0x003c->B:21:0x0077, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x007c A[EDGE_INSN: B:24:0x007c->B:22:0x007c BREAK  A[LOOP:0: B:9:0x003c->B:21:0x0077], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x007c A[EDGE_INSN: B:25:0x007c->B:22:0x007c BREAK  A[LOOP:0: B:9:0x003c->B:21:0x0077], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:? A[SYNTHETIC] */
    public final EventLoopImplBase.DelayedTask removeAtImpl(int i) {
        int i2;
        int i3;
        Object[] objArr;
        int i4;
        Comparable comparable;
        Comparable comparable2;
        Comparable comparable3;
        Object obj;
        Object[] objArr2 = this.a;
        objArr2.getClass();
        ArtificialStackFramesUnsafe.unsafe.putIntVolatile(this, _size$volatile$FU$offset, getSize() - 1);
        if (i < getSize()) {
            swap(i, getSize());
            int i5 = (i - 1) / 2;
            if (i > 0) {
                EventLoopImplBase.DelayedTask delayedTask = objArr2[i];
                delayedTask.getClass();
                Object obj2 = objArr2[i5];
                obj2.getClass();
                if (delayedTask.compareTo(obj2) < 0) {
                    swap(i, i5);
                    siftUpFrom(i5);
                } else {
                    while (true) {
                        i2 = i * 2;
                        i3 = i2 + 1;
                        if (i3 >= getSize()) {
                            break;
                        }
                        objArr = this.a;
                        objArr.getClass();
                        i4 = i2 + 2;
                        if (i4 < getSize()) {
                            comparable3 = objArr[i4];
                            comparable3.getClass();
                            obj = objArr[i3];
                            obj.getClass();
                            if (comparable3.compareTo(obj) >= 0) {
                                i4 = i3;
                            }
                        } else {
                            i4 = i3;
                        }
                        comparable = objArr[i];
                        comparable.getClass();
                        comparable2 = objArr[i4];
                        comparable2.getClass();
                        if (comparable.compareTo(comparable2) <= 0) {
                            break;
                        }
                        swap(i, i4);
                        i = i4;
                    }
                }
            } else {
                while (true) {
                    i2 = i * 2;
                    i3 = i2 + 1;
                    if (i3 >= getSize()) {
                        break;
                        break;
                    }
                    objArr = this.a;
                    objArr.getClass();
                    i4 = i2 + 2;
                    if (i4 < getSize()) {
                        comparable3 = objArr[i4];
                        comparable3.getClass();
                        obj = objArr[i3];
                        obj.getClass();
                        if (comparable3.compareTo(obj) >= 0) {
                            i4 = i3;
                        }
                    } else {
                        i4 = i3;
                    }
                    comparable = objArr[i];
                    comparable.getClass();
                    comparable2 = objArr[i4];
                    comparable2.getClass();
                    if (comparable.compareTo(comparable2) <= 0) {
                        break;
                        break;
                    }
                    swap(i, i4);
                    i = i4;
                }
            }
        }
        EventLoopImplBase.DelayedTask delayedTask2 = objArr2[getSize()];
        delayedTask2.getClass();
        delayedTask2.setHeap(null);
        delayedTask2.index = -1;
        objArr2[getSize()] = null;
        return delayedTask2;
    }

    public final void siftUpFrom(int i) {
        while (i > 0) {
            EventLoopImplBase.DelayedTask[] delayedTaskArr = this.a;
            delayedTaskArr.getClass();
            int i2 = (i - 1) / 2;
            EventLoopImplBase.DelayedTask delayedTask = delayedTaskArr[i2];
            delayedTask.getClass();
            EventLoopImplBase.DelayedTask delayedTask2 = delayedTaskArr[i];
            delayedTask2.getClass();
            if (delayedTask.compareTo(delayedTask2) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    public final void swap(int i, int i2) {
        EventLoopImplBase.DelayedTask[] delayedTaskArr = this.a;
        delayedTaskArr.getClass();
        EventLoopImplBase.DelayedTask delayedTask = delayedTaskArr[i2];
        delayedTask.getClass();
        EventLoopImplBase.DelayedTask delayedTask2 = delayedTaskArr[i];
        delayedTask2.getClass();
        delayedTaskArr[i] = delayedTask;
        delayedTaskArr[i2] = delayedTask2;
        delayedTask.index = i;
        delayedTask2.index = i2;
    }
}
