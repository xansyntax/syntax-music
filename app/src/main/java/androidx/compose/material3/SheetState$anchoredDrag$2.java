package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.node.NodeChain;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SheetState$anchoredDrag$2 extends SuspendLambda implements Function3 {
    public final /* synthetic */ Ref$FloatRef $consumedVelocity;
    public final /* synthetic */ FlingBehavior $flingBehavior;
    public final /* synthetic */ float $initialVelocity;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ SheetState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SheetState$anchoredDrag$2(Ref$FloatRef ref$FloatRef, FlingBehavior flingBehavior, SheetState sheetState, float f, Continuation continuation) {
        super(3, continuation);
        this.$consumedVelocity = ref$FloatRef;
        this.$flingBehavior = flingBehavior;
        this.this$0 = sheetState;
        this.$initialVelocity = f;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        SheetState sheetState = this.this$0;
        float f = this.$initialVelocity;
        SheetState$anchoredDrag$2 sheetState$anchoredDrag$2 = new SheetState$anchoredDrag$2(this.$consumedVelocity, this.$flingBehavior, sheetState, f, (Continuation) obj3);
        sheetState$anchoredDrag$2.L$0 = (AnchoredDraggableState$anchoredDragScope$1) obj;
        return sheetState$anchoredDrag$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$FloatRef ref$FloatRef;
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            final AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) this.L$0;
            final SheetState sheetState = this.this$0;
            ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.material3.SheetState$anchoredDrag$2$scrollScope$1
                @Override // androidx.compose.foundation.gestures.ScrollScope
                public final float scrollBy(float f) {
                    NodeChain nodeChain = sheetState.anchoredDraggableState;
                    float fCoerceIn = UuidKt.coerceIn((Float.isNaN(((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue()) ? CropImageView.DEFAULT_ASPECT_RATIO : ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue()) + f, nodeChain.getAnchors().minPosition(), nodeChain.getAnchors().maxPosition());
                    float floatValue = fCoerceIn - ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
                    anchoredDraggableState$anchoredDragScope$1.dragTo(fCoerceIn, CropImageView.DEFAULT_ASPECT_RATIO);
                    return floatValue;
                }
            };
            Ref$FloatRef ref$FloatRef2 = this.$consumedVelocity;
            this.L$0 = ref$FloatRef2;
            this.label = true;
            Object objPerformFling = this.$flingBehavior.performFling(scrollScope, this.$initialVelocity, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objPerformFling == coroutineSingletons) {
                return coroutineSingletons;
            }
            obj = objPerformFling;
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
