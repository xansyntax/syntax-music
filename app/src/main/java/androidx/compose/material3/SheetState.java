package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SheetState {
    public final NodeChain anchoredDraggableState;
    public final Function1 confirmValueChange;
    public final Set enabledValues;
    public FiniteAnimationSpec hideMotionSpec;
    public final Function0 positionalThreshold;
    public FiniteAnimationSpec showMotionSpec;
    public final Function0 velocityThreshold;

    public SheetState(Set set, Function0 function0, Function0 function1, SheetValue sheetValue, Function1 function2) {
        this.enabledValues = set;
        this.positionalThreshold = function0;
        this.velocityThreshold = function1;
        this.confirmValueChange = function2;
        if (!set.contains(SheetValue.Expanded)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Expanded must be one of the enabled values.");
            throw null;
        }
        if (!set.contains(sheetValue)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The initial value must be one of the enabled values.");
            throw null;
        }
        int i = SheetDefaultsKt.$r8$clinit;
        NodeChain nodeChain = new NodeChain(sheetValue);
        nodeChain.layoutNode = function2;
        this.anchoredDraggableState = nodeChain;
        this.showMotionSpec = ArcSplineKt.snap$default();
        this.hideMotionSpec = ArcSplineKt.snap$default();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object anchoredDrag$material3(FlingBehavior flingBehavior, float f, ContinuationImpl continuationImpl) {
        SheetState$anchoredDrag$1 sheetState$anchoredDrag$1;
        Ref$FloatRef ref$FloatRef;
        if (continuationImpl instanceof SheetState$anchoredDrag$1) {
            sheetState$anchoredDrag$1 = (SheetState$anchoredDrag$1) continuationImpl;
            int i = sheetState$anchoredDrag$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                sheetState$anchoredDrag$1.label = i - Integer.MIN_VALUE;
            } else {
                sheetState$anchoredDrag$1 = new SheetState$anchoredDrag$1(this, continuationImpl);
            }
        } else {
            sheetState$anchoredDrag$1 = new SheetState$anchoredDrag$1(this, continuationImpl);
        }
        Object obj = sheetState$anchoredDrag$1.result;
        int i2 = sheetState$anchoredDrag$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            SheetState$anchoredDrag$2 sheetState$anchoredDrag$2 = new SheetState$anchoredDrag$2(ref$FloatRef2, flingBehavior, this, f, null);
            sheetState$anchoredDrag$1.L$0 = ref$FloatRef2;
            sheetState$anchoredDrag$1.label = 1;
            Object objAnchoredDrag$default = NodeChain.anchoredDrag$default(this.anchoredDraggableState, sheetState$anchoredDrag$2, sheetState$anchoredDrag$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnchoredDrag$default == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$FloatRef = sheetState$anchoredDrag$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Float(ref$FloatRef.element);
    }

    public final Object animateTo$material3(SheetValue sheetValue, FiniteAnimationSpec finiteAnimationSpec, SuspendLambda suspendLambda) {
        NodeChain nodeChain = this.anchoredDraggableState;
        Object objAnchoredDrag = nodeChain.anchoredDrag(sheetValue, MutatePriority.Default, new AnchoredDraggableKt$animateTo$4(nodeChain, finiteAnimationSpec, null), suspendLambda);
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objAnchoredDrag != coroutineSingletons) {
            objAnchoredDrag = unit;
        }
        return objAnchoredDrag == coroutineSingletons ? objAnchoredDrag : unit;
    }

    public final SheetValue getCurrentValue() {
        return (SheetValue) ((ParcelableSnapshotMutableState) this.anchoredDraggableState.outerCoordinator).getValue();
    }

    public final Object hide(SuspendLambda suspendLambda) {
        Object objAnimateTo$material3;
        Set set = this.enabledValues;
        SheetValue sheetValue = SheetValue.Hidden;
        if (set.contains(sheetValue)) {
            return (((Boolean) this.confirmValueChange.invoke(sheetValue)).booleanValue() && (objAnimateTo$material3 = animateTo$material3(sheetValue, this.hideMotionSpec, suspendLambda)) == CoroutineSingletons.COROUTINE_SUSPENDED) ? objAnimateTo$material3 : Unit.INSTANCE;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.");
        return null;
    }

    public final boolean isVisible() {
        return ((ParcelableSnapshotMutableState) this.anchoredDraggableState.innerCoordinator).getValue() != SheetValue.Hidden;
    }

    public final Object partialExpand(SuspendLambda suspendLambda) {
        Object objAnimateTo$material3;
        Set set = this.enabledValues;
        SheetValue sheetValue = SheetValue.PartiallyExpanded;
        if (set.contains(sheetValue)) {
            return (((Boolean) this.confirmValueChange.invoke(sheetValue)).booleanValue() && (objAnimateTo$material3 = animateTo$material3(sheetValue, this.hideMotionSpec, suspendLambda)) == CoroutineSingletons.COROUTINE_SUSPENDED) ? objAnimateTo$material3 : Unit.INSTANCE;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.");
        return null;
    }

    public final Object show(SuspendLambda suspendLambda) {
        Object objAnimateTo$material3;
        DefaultDraggableAnchors anchors = this.anchoredDraggableState.getAnchors();
        SheetValue sheetValue = SheetValue.PartiallyExpanded;
        if (!anchors.hasPositionFor(sheetValue)) {
            sheetValue = SheetValue.Expanded;
        }
        return (((Boolean) this.confirmValueChange.invoke(sheetValue)).booleanValue() && (objAnimateTo$material3 = animateTo$material3(sheetValue, this.showMotionSpec, suspendLambda)) == CoroutineSingletons.COROUTINE_SUSPENDED) ? objAnimateTo$material3 : Unit.INSTANCE;
    }
}
