package androidx.compose.material3.internal;

import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BasicTooltipKt$handleGestures$2$1$1 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ CoroutineScope $$this$coroutineScope;
    public final /* synthetic */ TooltipStateImpl $state;
    public /* synthetic */ Object L$0;
    public PointerEventPass L$1;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTooltipKt$handleGestures$2$1$1(CoroutineScope coroutineScope, TooltipStateImpl tooltipStateImpl, Continuation continuation) {
        super(2, continuation);
        this.$$this$coroutineScope = coroutineScope;
        this.$state = tooltipStateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BasicTooltipKt$handleGestures$2$1$1 basicTooltipKt$handleGestures$2$1$1 = new BasicTooltipKt$handleGestures$2$1$1(this.$$this$coroutineScope, this.$state, continuation);
        basicTooltipKt$handleGestures$2$1$1.L$0 = obj;
        return basicTooltipKt$handleGestures$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((BasicTooltipKt$handleGestures$2$1$1) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0030 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    /* JADX WARN: Code duplicated, block: B:17:0x0054  */
    /* JADX WARN: Code duplicated, block: B:19:0x0057  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:12:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = r7.label
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            if (r0 != r2) goto L12
            androidx.compose.ui.input.pointer.PointerEventPass r0 = r7.L$1
            java.lang.Object r3 = r7.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r3 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r3
            kotlin.ResultKt.throwOnFailure(r8)
            goto L31
        L12:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            return r1
        L18:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r8 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r8
            androidx.compose.ui.input.pointer.PointerEventPass r0 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r3 = r8
        L22:
            r7.L$0 = r3
            r7.L$1 = r0
            r7.label = r2
            java.lang.Object r8 = r3.awaitPointerEvent(r0, r7)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r4) goto L31
            return r4
        L31:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.util.List r4 = r8.changes
            r5 = 0
            java.lang.Object r4 = r4.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            int r4 = r4.type
            r5 = 2
            if (r4 != r5) goto L22
            int r8 = r8.type
            r4 = 4
            androidx.compose.material3.TooltipStateImpl r6 = r7.$state
            if (r8 != r4) goto L54
            androidx.compose.material3.internal.BasicTooltipKt$anchorSemantics$1$1$1 r8 = new androidx.compose.material3.internal.BasicTooltipKt$anchorSemantics$1$1$1
            r8.<init>(r6, r1, r5)
            r4 = 3
            kotlinx.coroutines.CoroutineScope r5 = r7.$$this$coroutineScope
            kotlinx.coroutines.AwaitKt.launch$default(r5, r1, r1, r8, r4)
            goto L22
        L54:
            r4 = 5
            if (r8 != r4) goto L22
            r6.getClass()
            r6.dismiss()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
