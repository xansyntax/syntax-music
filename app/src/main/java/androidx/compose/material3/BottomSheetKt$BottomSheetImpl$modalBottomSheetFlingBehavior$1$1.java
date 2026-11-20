package androidx.compose.material3;

import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 implements FlingBehavior {
    public final /* synthetic */ SnapFlingBehavior $anchoredDraggableFlingBehavior;
    public final /* synthetic */ Density $density;
    public final /* synthetic */ Function0 $onDismissRequest;
    public final /* synthetic */ SheetState $state;
    public final /* synthetic */ ViewConfiguration $viewConfiguration;

    public BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1(ViewConfiguration viewConfiguration, SheetState sheetState, Density density, SnapFlingBehavior snapFlingBehavior, Function0 function0) {
        this.$viewConfiguration = viewConfiguration;
        this.$state = sheetState;
        this.$density = density;
        this.$anchoredDraggableFlingBehavior = snapFlingBehavior;
        this.$onDismissRequest = function0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1;
        SheetState sheetState = this.$state;
        NodeChain nodeChain = sheetState.anchoredDraggableState;
        if (continuation instanceof BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1) {
            bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 = (BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1) continuation;
            int i = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.label = i - Integer.MIN_VALUE;
            } else {
                bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 = new BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 = new BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1(this, (ContinuationImpl) continuation);
        }
        Object objPerformFling = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.result;
        int i2 = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.label;
        Function0 function0 = this.$onDismissRequest;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objPerformFling);
                float maximumFlingVelocity = this.$viewConfiguration.getMaximumFlingVelocity();
                float fCoerceIn = UuidKt.coerceIn(f, -maximumFlingVelocity, maximumFlingVelocity);
                if (fCoerceIn > CropImageView.DEFAULT_ASPECT_RATIO) {
                    DefaultDraggableAnchors anchors = nodeChain.getAnchors();
                    SheetValue sheetValue = SheetValue.Hidden;
                    if (anchors.hasPositionFor(sheetValue)) {
                        float fMax = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, nodeChain.getAnchors().positionOf(sheetValue) - nodeChain.requireOffset());
                        Density density = this.$density;
                        float fMo81toPx0680j_4 = density.mo81toPx0680j_4(125.0f);
                        if (fMax < fMo81toPx0680j_4) {
                            float f2 = fMax / fMo81toPx0680j_4;
                            fCoerceIn *= f2 * f2;
                            float fMo81toPx0680j_5 = density.mo81toPx0680j_4(125.0f);
                            if (f >= fMo81toPx0680j_5) {
                                fCoerceIn = Math.max(fCoerceIn, fMo81toPx0680j_5);
                            }
                        }
                    }
                }
                SnapFlingBehavior snapFlingBehavior = this.$anchoredDraggableFlingBehavior;
                bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.label = 1;
                objPerformFling = snapFlingBehavior.performFling(scrollScope, fCoerceIn, bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objPerformFling == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objPerformFling);
            }
            float fFloatValue = ((Number) objPerformFling).floatValue();
            if (!sheetState.isVisible()) {
                function0.invoke();
            }
            return new Float(fFloatValue);
        } catch (Throwable th) {
            if (!sheetState.isVisible()) {
                function0.invoke();
            }
            throw th;
        }
    }
}
