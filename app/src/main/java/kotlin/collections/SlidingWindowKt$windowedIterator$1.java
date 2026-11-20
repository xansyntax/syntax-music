package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Iterator $iterator;
    public final /* synthetic */ int $size;
    public final /* synthetic */ int $step;
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Iterator L$2;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, Continuation continuation) {
        super(2, continuation);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SlidingWindowKt$windowedIterator$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0088  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:48:0x0101  */
    /* JADX WARN: Code duplicated, block: B:51:0x0106  */
    /* JADX WARN: Code duplicated, block: B:52:0x010b  */
    /* JADX WARN: Code duplicated, block: B:62:0x013e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0153  */
    /* JADX WARN: Code duplicated, block: B:66:0x0159  */
    /* JADX WARN: Code duplicated, block: B:70:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0082 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        int i3;
        Iterator it;
        RingBuffer ringBuffer;
        ArrayList arrayList;
        int i4;
        Iterator it2;
        int i5;
        Object next;
        int i6;
        Object[] objArr;
        int i7;
        RingBuffer ringBuffer2;
        Object next2;
        boolean z;
        int i8;
        Object[] array;
        SequenceScope sequenceScope = (SequenceScope) this.L$0;
        byte b = this.label;
        int i9 = this.$step;
        boolean z2 = true;
        int i10 = this.$size;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            int i11 = i10 <= 1024 ? i10 : 1024;
            i = i9 - i10;
            Iterator it3 = this.$iterator;
            if (i >= 0) {
                arrayList = new ArrayList(i11);
                i4 = i11;
                it2 = it3;
                i5 = 0;
                while (it2.hasNext()) {
                    next = it2.next();
                    if (i5 > 0) {
                        i5--;
                    } else {
                        arrayList.add(next);
                        if (arrayList.size() == i10) {
                            this.L$0 = sequenceScope;
                            this.L$1 = arrayList;
                            this.L$2 = it2;
                            this.I$0 = i4;
                            this.I$1 = i;
                            this.label = (byte) 1;
                            sequenceScope.yield(arrayList, this);
                            return coroutineSingletons;
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = i4;
                    this.I$1 = i;
                    this.label = (byte) 2;
                    sequenceScope.yield(arrayList, this);
                    return coroutineSingletons;
                }
            } else {
                RingBuffer ringBuffer3 = new RingBuffer(0, new Object[i11]);
                i2 = i11;
                i3 = i;
                it = it3;
                ringBuffer = ringBuffer3;
                while (true) {
                    i6 = ringBuffer.capacity;
                    objArr = ringBuffer.buffer;
                    if (it.hasNext()) {
                        i7 = i2;
                        ringBuffer2 = ringBuffer;
                        break;
                    }
                    next2 = it.next();
                    z = z2;
                    if (ringBuffer.getSize() != i6) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ring buffer is full");
                        return null;
                    }
                    int i12 = ringBuffer.startIndex;
                    int i13 = ringBuffer.size;
                    objArr[(i12 + i13) % i6] = next2;
                    ringBuffer.size = i13 + 1;
                    if (ringBuffer.getSize() != i6) {
                        if (ringBuffer.size < i10) {
                            ArrayList arrayList2 = new ArrayList(ringBuffer);
                            this.L$0 = sequenceScope;
                            this.L$1 = ringBuffer;
                            this.L$2 = it;
                            this.I$0 = i2;
                            this.I$1 = i3;
                            this.label = (byte) 3;
                            sequenceScope.yield(arrayList2, this);
                            return coroutineSingletons;
                        }
                        i8 = i6 + (i6 >> 1) + 1;
                        if (i8 > i10) {
                            i8 = i10;
                        }
                        if (ringBuffer.startIndex == 0) {
                            array = Arrays.copyOf(objArr, i8);
                        } else {
                            array = ringBuffer.toArray(new Object[i8]);
                        }
                        ringBuffer = new RingBuffer(ringBuffer.size, array);
                    }
                    z2 = z;
                }
                if (ringBuffer2.size > i9) {
                    ArrayList arrayList3 = new ArrayList(ringBuffer2);
                    this.L$0 = sequenceScope;
                    this.L$1 = ringBuffer2;
                    this.L$2 = null;
                    this.I$0 = i7;
                    this.I$1 = i3;
                    this.label = (byte) 4;
                    sequenceScope.yield(arrayList3, this);
                    return coroutineSingletons;
                }
                if (!ringBuffer2.isEmpty()) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = i7;
                    this.I$1 = i3;
                    this.label = (byte) 5;
                    sequenceScope.yield(ringBuffer2, this);
                    return coroutineSingletons;
                }
            }
        } else if (b != 1) {
            if (b != 2) {
                if (b == 3) {
                    i3 = this.I$1;
                    i2 = this.I$0;
                    it = this.L$2;
                    ringBuffer = (RingBuffer) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    ringBuffer.removeFirst(i9);
                    while (true) {
                        i6 = ringBuffer.capacity;
                        objArr = ringBuffer.buffer;
                        if (it.hasNext()) {
                            i7 = i2;
                            ringBuffer2 = ringBuffer;
                            break;
                        }
                        next2 = it.next();
                        z = z2;
                        if (ringBuffer.getSize() != i6) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ring buffer is full");
                            return null;
                        }
                        int i14 = ringBuffer.startIndex;
                        int i15 = ringBuffer.size;
                        objArr[(i14 + i15) % i6] = next2;
                        ringBuffer.size = i15 + 1;
                        if (ringBuffer.getSize() != i6) {
                            if (ringBuffer.size < i10) {
                                ArrayList arrayList4 = new ArrayList(ringBuffer);
                                this.L$0 = sequenceScope;
                                this.L$1 = ringBuffer;
                                this.L$2 = it;
                                this.I$0 = i2;
                                this.I$1 = i3;
                                this.label = (byte) 3;
                                sequenceScope.yield(arrayList4, this);
                                return coroutineSingletons;
                            }
                            i8 = i6 + (i6 >> 1) + 1;
                            if (i8 > i10) {
                                i8 = i10;
                            }
                            if (ringBuffer.startIndex == 0) {
                                array = Arrays.copyOf(objArr, i8);
                            } else {
                                array = ringBuffer.toArray(new Object[i8]);
                            }
                            ringBuffer = new RingBuffer(ringBuffer.size, array);
                        }
                        z2 = z;
                    }
                } else if (b == 4) {
                    i3 = this.I$1;
                    i7 = this.I$0;
                    ringBuffer2 = (RingBuffer) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    ringBuffer2.removeFirst(i9);
                } else {
                    if (b != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                }
                if (ringBuffer2.size > i9) {
                    ArrayList arrayList5 = new ArrayList(ringBuffer2);
                    this.L$0 = sequenceScope;
                    this.L$1 = ringBuffer2;
                    this.L$2 = null;
                    this.I$0 = i7;
                    this.I$1 = i3;
                    this.label = (byte) 4;
                    sequenceScope.yield(arrayList5, this);
                    return coroutineSingletons;
                }
                if (!ringBuffer2.isEmpty()) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = i7;
                    this.I$1 = i3;
                    this.label = (byte) 5;
                    sequenceScope.yield(ringBuffer2, this);
                    return coroutineSingletons;
                }
            }
            ResultKt.throwOnFailure(obj);
        } else {
            i5 = this.I$1;
            i4 = this.I$0;
            it2 = this.L$2;
            ResultKt.throwOnFailure(obj);
            arrayList = new ArrayList(i10);
            i = i5;
            while (it2.hasNext()) {
                next = it2.next();
                if (i5 > 0) {
                    i5--;
                } else {
                    arrayList.add(next);
                    if (arrayList.size() == i10) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayList;
                        this.L$2 = it2;
                        this.I$0 = i4;
                        this.I$1 = i;
                        this.label = (byte) 1;
                        sequenceScope.yield(arrayList, this);
                        return coroutineSingletons;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.I$0 = i4;
                this.I$1 = i;
                this.label = (byte) 2;
                sequenceScope.yield(arrayList, this);
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
