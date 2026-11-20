package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableNode extends DragGestureNode {
    public Density density;
    public FlingBehavior flingBehavior;
    public FlingBehavior resolvedFlingBehavior;
    public NodeChain state;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Ref$FloatRef L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableNode.this.fling(CropImageView.DEFAULT_ASPECT_RATIO, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function3 {
        public final /* synthetic */ Ref$FloatRef $leftoverVelocity;
        public final /* synthetic */ float $velocity;
        public /* synthetic */ Object L$0;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$FloatRef ref$FloatRef, float f, Continuation continuation) {
            super(3, continuation);
            this.$leftoverVelocity = ref$FloatRef;
            this.$velocity = f;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Ref$FloatRef ref$FloatRef = this.$leftoverVelocity;
            float f = this.$velocity;
            AnonymousClass2 anonymousClass2 = AnchoredDraggableNode.this.new AnonymousClass2(ref$FloatRef, f, (Continuation) obj3);
            anonymousClass2.L$0 = (AnchoredDraggableState$anchoredDragScope$1) obj;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref$FloatRef ref$FloatRef;
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) this.L$0;
                AnchoredDraggableNode anchoredDraggableNode = AnchoredDraggableNode.this;
                AnchoredDraggableNode$fling$2$scrollScope$1 anchoredDraggableNode$fling$2$scrollScope$1 = new AnchoredDraggableNode$fling$2$scrollScope$1(anchoredDraggableNode, anchoredDraggableState$anchoredDragScope$1, (byte) 0);
                FlingBehavior flingBehavior = anchoredDraggableNode.resolvedFlingBehavior;
                if (flingBehavior == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolvedFlingBehavior");
                    throw null;
                }
                Ref$FloatRef ref$FloatRef2 = this.$leftoverVelocity;
                this.L$0 = ref$FloatRef2;
                this.label = true;
                obj = flingBehavior.performFling(anchoredDraggableNode$fling$2$scrollScope$1, this.$velocity, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                ref$FloatRef = ref$FloatRef2;
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ref$FloatRef = (Ref$FloatRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ref$FloatRef.element = ((Number) obj).floatValue();
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final Object drag$1(InnerTube$feedback$2 innerTube$feedback$2, NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1) {
        Object objAnchoredDrag$default = NodeChain.anchoredDrag$default(this.state, new AnchoredDraggableNode$drag$2(innerTube$feedback$2, this, (Continuation) null), navHostKt$NavHost$29$1);
        return objAnchoredDrag$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fling(float f, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Ref$FloatRef ref$FloatRef;
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
            this.state.getClass();
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            ref$FloatRef2.element = f;
            NodeChain nodeChain = this.state;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(ref$FloatRef2, f, null);
            anonymousClass1.L$0 = ref$FloatRef2;
            anonymousClass1.label = 2;
            Object objAnchoredDrag$default = NodeChain.anchoredDrag$default(nodeChain, anonymousClass2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnchoredDrag$default == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$FloatRef = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Float(ref$FloatRef.element);
    }

    public final boolean isReverseDirection$1() {
        return HitTestResultKt.requireLayoutNode(this).layoutDirection == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        updateFlingBehavior(this.flingBehavior);
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onDensityChange() {
        onCancelPointerInput();
        if (this.isAttached) {
            Density density = HitTestResultKt.requireLayoutNode(this).density;
            Density density2 = this.density;
            if (density2 == null || !density2.equals(density)) {
                this.density = density;
                updateFlingBehavior(this.flingBehavior);
            }
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final boolean startDragImmediately() {
        return ((ParcelableSnapshotMutableState) this.state.buffers).getValue() != null;
    }

    public final void updateFlingBehavior(FlingBehavior flingBehavior) {
        if (flingBehavior == null) {
            TweenSpec tweenSpec = AnchoredDraggableDefaults.SnapAnimationSpec;
            BorderKt$$ExternalSyntheticLambda1 borderKt$$ExternalSyntheticLambda1 = AnchoredDraggableDefaults.PositionalThreshold;
            Density density = HitTestResultKt.requireLayoutNode(this).density;
            this.density = density;
            NodeChain nodeChain = this.state;
            flingBehavior = new SnapFlingBehavior(new AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1(nodeChain, borderKt$$ExternalSyntheticLambda1, new SheetDefaultsKt$$ExternalSyntheticLambda0(density, (byte) 1), (byte) 0), ScrollableKt.NoOpDecayAnimationSpec, tweenSpec);
        }
        this.resolvedFlingBehavior = flingBehavior;
    }
}
