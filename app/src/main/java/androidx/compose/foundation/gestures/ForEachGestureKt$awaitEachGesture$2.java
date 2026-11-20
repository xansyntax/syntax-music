package androidx.compose.foundation.gestures;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ForEachGestureKt$awaitEachGesture$2 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Object $block;
    public Object $currentContext;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ForEachGestureKt$awaitEachGesture$2(Object obj, Object obj2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$currentContext = obj;
        this.$block = obj2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$block;
        switch (b) {
            case 0:
                ForEachGestureKt$awaitEachGesture$2 forEachGestureKt$awaitEachGesture$2 = new ForEachGestureKt$awaitEachGesture$2((CoroutineContext) this.$currentContext, (Function2) obj2, continuation, (byte) 0);
                forEachGestureKt$awaitEachGesture$2.L$0 = obj;
                return forEachGestureKt$awaitEachGesture$2;
            case 1:
                ForEachGestureKt$awaitEachGesture$2 forEachGestureKt$awaitEachGesture$3 = new ForEachGestureKt$awaitEachGesture$2((PointerEventPass) this.$currentContext, (Ref$ObjectRef) obj2, continuation, (byte) 1);
                forEachGestureKt$awaitEachGesture$3.L$0 = obj;
                return forEachGestureKt$awaitEachGesture$3;
            default:
                ForEachGestureKt$awaitEachGesture$2 forEachGestureKt$awaitEachGesture$4 = new ForEachGestureKt$awaitEachGesture$2((TextDragObserver) obj2, continuation);
                forEachGestureKt$awaitEachGesture$4.L$0 = obj;
                return forEachGestureKt$awaitEachGesture$4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((ForEachGestureKt$awaitEachGesture$2) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:87:0x01a2 A[PHI: r5
      0x01a2: PHI (r5v3 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine) = 
      (r5v1 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
      (r5v2 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
      (r5v4 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
      (r5v8 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
     binds: [B:98:0x01cf, B:93:0x01be, B:86:0x01a1, B:78:0x018b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x01a8 A[Catch: CancellationException -> 0x018f, TRY_ENTER, TryCatch #0 {CancellationException -> 0x018f, blocks: (B:89:0x01a8, B:92:0x01b6, B:78:0x018b, B:83:0x0196), top: B:103:0x0171 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01b6 A[Catch: CancellationException -> 0x018f, PHI: r5
      0x01b6: PHI (r5v2 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine) = 
      (r5v3 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
      (r5v6 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
     binds: [B:90:0x01b3, B:83:0x0196] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {CancellationException -> 0x018f, blocks: (B:89:0x01a8, B:92:0x01b6, B:78:0x018b, B:83:0x0196), top: B:103:0x0171 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0065 -> B:18:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x012a -> B:59:0x012e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x01be -> B:87:0x01a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x01cf -> B:87:0x01a2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForEachGestureKt$awaitEachGesture$2(TextDragObserver textDragObserver, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 2;
        this.$block = textDragObserver;
    }
}
