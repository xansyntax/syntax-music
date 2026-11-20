package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TapGestureDetectorKt$awaitSecondDown$2 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Object $firstUp;
    public final /* synthetic */ byte $r8$classId = 1;
    public long J$0;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$awaitSecondDown$2(long j, Ref$LongRef ref$LongRef, Continuation continuation) {
        super(2, continuation);
        this.J$0 = j;
        this.$firstUp = ref$LongRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$firstUp;
        switch (b) {
            case 0:
                TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2 = new TapGestureDetectorKt$awaitSecondDown$2((PointerInputChange) obj2, continuation);
                tapGestureDetectorKt$awaitSecondDown$2.L$0 = obj;
                return tapGestureDetectorKt$awaitSecondDown$2;
            default:
                TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$3 = new TapGestureDetectorKt$awaitSecondDown$2(this.J$0, (Ref$LongRef) obj2, continuation);
                tapGestureDetectorKt$awaitSecondDown$3.L$0 = obj;
                return tapGestureDetectorKt$awaitSecondDown$3;
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
        }
        return ((TapGestureDetectorKt$awaitSecondDown$2) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a8 -> B:32:0x00ac). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x0073
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            byte r0 = r8.$r8$classId
            r1 = 0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            r4 = 1
            java.lang.Object r5 = r8.$firstUp
            switch(r0) {
                case 0: goto L73;
                default: goto Ld;
            }
        Ld:
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref$LongRef) r5
            boolean r0 = r8.label
            if (r0 == 0) goto L21
            if (r0 != r4) goto L1d
            java.lang.Object r8 = r8.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r8 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L40
        L1d:
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r2)
            goto L72
        L21:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r9 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r9
            long r0 = r8.J$0
            androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0 r2 = new androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0
            r6 = 13
            r2.<init>(r6, r5)
            r8.L$0 = r9
            r8.label = r4
            java.lang.Object r8 = androidx.compose.foundation.gestures.ScrollableKt.m88awaitTouchSlopOrCancellationjO51t88(r9, r0, r2, r8)
            if (r8 != r3) goto L3d
            r1 = r3
            goto L72
        L3d:
            r7 = r9
            r9 = r8
            r8 = r7
        L40:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 == 0) goto L58
            long r0 = r5.element
            r2 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            long r0 = r0 & r2
            r2 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 == 0) goto L58
            androidx.compose.foundation.text.selection.DownResolution r1 = androidx.compose.foundation.text.selection.DownResolution.Drag
            goto L72
        L58:
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r8 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
            androidx.compose.ui.input.pointer.PointerEvent r8 = r8.currentEvent
            java.util.List r8 = r8.changes
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r9 = androidx.compose.ui.input.pointer.PointerIconKt.changedToUpIgnoreConsumed(r8)
            if (r9 == 0) goto L70
            r8.consume()
            androidx.compose.foundation.text.selection.DownResolution r1 = androidx.compose.foundation.text.selection.DownResolution.Up
            goto L72
        L70:
            androidx.compose.foundation.text.selection.DownResolution r1 = androidx.compose.foundation.text.selection.DownResolution.Cancel
        L72:
            return r1
        L73:
            boolean r0 = r8.label
            if (r0 == 0) goto L87
            if (r0 != r4) goto L83
            long r0 = r8.J$0
            java.lang.Object r2 = r8.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r2 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lac
        L83:
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r2)
            goto Lb5
        L87:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r9 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r9
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            long r0 = r5.uptimeMillis
            androidx.compose.ui.platform.ViewConfiguration r2 = r9.getViewConfiguration()
            long r5 = r2.getDoubleTapMinTimeMillis()
            long r5 = r5 + r0
            r2 = r9
            r0 = r5
        L9d:
            r8.L$0 = r2
            r8.J$0 = r0
            r8.label = r4
            r9 = 3
            java.lang.Object r9 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r2, r8, r9)
            if (r9 != r3) goto Lac
            r1 = r3
            goto Lb5
        Lac:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            long r5 = r9.uptimeMillis
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 < 0) goto L9d
            r1 = r9
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$awaitSecondDown$2(PointerInputChange pointerInputChange, Continuation continuation) {
        super(2, continuation);
        this.$firstUp = pointerInputChange;
    }
}
