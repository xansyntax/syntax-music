package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SuspendAnimationKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sh.calvin.reorderable.DraggableKt$draggable$3$1$1;
import sh.calvin.reorderable.DraggableKt$draggable$3$2$1$1$2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Function2 $onDrag;
    public final /* synthetic */ DraggableKt$draggable$3$2$1$1$2 $onDragCancel;
    public final /* synthetic */ DraggableKt$draggable$3$2$1$1$2 $onDragEnd;
    public final /* synthetic */ DraggableKt$draggable$3$1$1 $onDragStart;
    public /* synthetic */ Object L$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(DraggableKt$draggable$3$1$1 draggableKt$draggable$3$1$1, DraggableKt$draggable$3$2$1$1$2 draggableKt$draggable$3$2$1$1$2, DraggableKt$draggable$3$2$1$1$2 draggableKt$draggable$3$2$1$1$3, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$onDragStart = draggableKt$draggable$3$1$1;
        this.$onDragEnd = draggableKt$draggable$3$2$1$1$2;
        this.$onDragCancel = draggableKt$draggable$3$2$1$1$3;
        this.$onDrag = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0059 A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:32:0x0079, B:34:0x0081, B:36:0x008e, B:38:0x009a, B:39:0x009d, B:40:0x00a0, B:41:0x00a6, B:15:0x0027, B:27:0x0055, B:29:0x0059, B:18:0x002f, B:24:0x0046, B:21:0x003b), top: B:46:0x0009 }] */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r10 == r5) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine;
        PointerInputChange pointerInputChange;
        byte b = this.label;
        DraggableKt$draggable$3$2$1$1$2 draggableKt$draggable$3$2$1$1$2 = this.$onDragCancel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                this.L$0 = pointerEventHandlerCoroutine;
                this.label = (byte) 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine, this, 2);
                if (obj == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (b == 1) {
                pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (b == 2) {
                    pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange != null) {
                        this.$onDragStart.invoke(new Offset(pointerInputChange.position));
                        long j = pointerInputChange.id;
                        SuspendAnimationKt$$ExternalSyntheticLambda6 suspendAnimationKt$$ExternalSyntheticLambda6 = new SuspendAnimationKt$$ExternalSyntheticLambda6(this.$onDrag, (byte) 1);
                        this.L$0 = pointerEventHandlerCoroutine;
                        this.label = (byte) 3;
                        obj = ScrollableKt.m91dragjO51t88(pointerEventHandlerCoroutine, j, suspendAnimationKt$$ExternalSyntheticLambda6, this);
                    }
                    return Unit.INSTANCE;
                }
                if (b != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                List list = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    PointerInputChange pointerInputChange2 = (PointerInputChange) list.get(i);
                    if (PointerIconKt.changedToUp(pointerInputChange2)) {
                        pointerInputChange2.consume();
                    }
                }
                this.$onDragEnd.invoke();
            } else {
                draggableKt$draggable$3$2$1$1$2.invoke();
            }
            return Unit.INSTANCE;
            long j2 = ((PointerInputChange) obj).id;
            this.L$0 = pointerEventHandlerCoroutine;
            this.label = (byte) 2;
            obj = ScrollableKt.m87awaitLongPressOrCancellationrnUCldI(pointerEventHandlerCoroutine, j2, this);
            if (obj != coroutineSingletons) {
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    this.$onDragStart.invoke(new Offset(pointerInputChange.position));
                    long j3 = pointerInputChange.id;
                    SuspendAnimationKt$$ExternalSyntheticLambda6 suspendAnimationKt$$ExternalSyntheticLambda7 = new SuspendAnimationKt$$ExternalSyntheticLambda6(this.$onDrag, (byte) 1);
                    this.L$0 = pointerEventHandlerCoroutine;
                    this.label = (byte) 3;
                    obj = ScrollableKt.m91dragjO51t88(pointerEventHandlerCoroutine, j3, suspendAnimationKt$$ExternalSyntheticLambda7, this);
                }
                return Unit.INSTANCE;
            }
            return coroutineSingletons;
        } catch (CancellationException e) {
            draggableKt$draggable$3$2$1$1$2.invoke();
            throw e;
        }
    }
}
