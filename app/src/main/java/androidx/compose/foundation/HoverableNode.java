package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.UnplacedAwareModifierNode;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HoverableNode extends Modifier.Node implements PointerInputModifierNode, UnplacedAwareModifierNode {
    public HoverInteraction$Enter hoverInteraction;
    public MutableInteractionSourceImpl interactionSource;

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitEnter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public HoverInteraction$Enter L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HoverableNode.this.emitEnter(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitExit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00181 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00181(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HoverableNode.this.emitExit(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitEnter(ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        HoverInteraction$Enter hoverInteraction$Enter;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.hoverInteraction == null) {
                HoverInteraction$Enter hoverInteraction$Enter2 = new HoverInteraction$Enter();
                MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
                anonymousClass1.L$0 = hoverInteraction$Enter2;
                anonymousClass1.label = 1;
                Object objEmit = mutableInteractionSourceImpl.emit(hoverInteraction$Enter2, anonymousClass1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objEmit == coroutineSingletons) {
                    return coroutineSingletons;
                }
                hoverInteraction$Enter = hoverInteraction$Enter2;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        hoverInteraction$Enter = anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        this.hoverInteraction = hoverInteraction$Enter;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitExit(ContinuationImpl continuationImpl) throws Throwable {
        C00181 c00181;
        if (continuationImpl instanceof C00181) {
            c00181 = (C00181) continuationImpl;
            int i = c00181.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00181.label = i - Integer.MIN_VALUE;
            } else {
                c00181 = new C00181(continuationImpl);
            }
        } else {
            c00181 = new C00181(continuationImpl);
        }
        Object obj = c00181.result;
        int i2 = c00181.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
            if (hoverInteraction$Enter != null) {
                HoverInteraction$Exit hoverInteraction$Exit = new HoverInteraction$Exit(hoverInteraction$Enter);
                MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
                c00181.label = 1;
                Object objEmit = mutableInteractionSourceImpl.emit(hoverInteraction$Exit, c00181);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objEmit == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.hoverInteraction = null;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        if (pointerEventPass == PointerEventPass.Main) {
            int i = pointerEvent.type;
            if (i == 4) {
                AwaitKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null, (byte) 0), 3);
            } else if (i == 5) {
                AwaitKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null, (byte) 1), 3);
            }
        }
    }

    @Override // androidx.compose.ui.node.UnplacedAwareModifierNode
    public final void onUnplaced() {
        tryEmitExit();
    }

    public final void tryEmitExit() {
        HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
        if (hoverInteraction$Enter != null) {
            this.interactionSource.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
            this.hoverInteraction = null;
        }
    }
}
