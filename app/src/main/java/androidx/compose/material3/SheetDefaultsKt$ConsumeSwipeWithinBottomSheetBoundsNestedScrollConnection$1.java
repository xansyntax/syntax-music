package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.unit.Velocity;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 implements NestedScrollConnection {
    public final /* synthetic */ FlingBehavior $flingBehavior;
    public final /* synthetic */ SheetState $sheetState;

    public SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(SheetState sheetState, BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1) {
        this.$sheetState = sheetState;
        this.$flingBehavior = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final Object mo99onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1;
        if (continuation instanceof SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) {
            sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = (SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) continuation;
            int i = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, (ContinuationImpl) continuation);
        }
        Object objAnchoredDrag$material3 = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.result;
        int i2 = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAnchoredDrag$material3);
            float fM820getYimpl = Velocity.m820getYimpl(j2);
            sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0 = j;
            sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = 1;
            objAnchoredDrag$material3 = this.$sheetState.anchoredDrag$material3(this.$flingBehavior, fM820getYimpl, sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnchoredDrag$material3 == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0;
            ResultKt.throwOnFailure(objAnchoredDrag$material3);
        }
        return new Velocity(MathKt.Velocity(Velocity.m819getXimpl(j), ((Number) objAnchoredDrag$material3).floatValue()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public final long mo100onPostScrollDzOQY0M(int i, long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (4294967295L & j2));
        if (i != 1 || fIntBitsToFloat == CropImageView.DEFAULT_ASPECT_RATIO) {
            return 0L;
        }
        NodeChain nodeChain = this.$sheetState.anchoredDraggableState;
        float fNewOffsetForDelta$foundation = nodeChain.newOffsetForDelta$foundation(fIntBitsToFloat);
        float fRequireOffset = fNewOffsetForDelta$foundation - nodeChain.requireOffset();
        ((AnchoredDraggableState$anchoredDragScope$1) nodeChain.cachedDiffer).dragTo(fNewOffsetForDelta$foundation, CropImageView.DEFAULT_ASPECT_RATIO);
        return toOffset(fRequireOffset);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public final Object mo326onPreFlingQWom1Mo(long j, Continuation continuation) {
        SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1;
        SheetState sheetState = this.$sheetState;
        NodeChain nodeChain = sheetState.anchoredDraggableState;
        if (continuation instanceof SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) {
            sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = (SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) continuation;
            int i = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, (ContinuationImpl) continuation);
        }
        Object obj = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.result;
        int i2 = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            float fM820getYimpl = Velocity.m820getYimpl(j);
            float fRequireOffset = nodeChain.requireOffset();
            float fMinPosition = nodeChain.getAnchors().minPosition();
            if (fM820getYimpl >= CropImageView.DEFAULT_ASPECT_RATIO || fRequireOffset <= fMinPosition) {
                j = 0;
            } else {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0 = j;
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = 1;
                Object objAnchoredDrag$material3 = sheetState.anchoredDrag$material3(this.$flingBehavior, fM820getYimpl, sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAnchoredDrag$material3 == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Velocity(j);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public final long mo178onPreScrollOzD1aCk(int i, long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L));
        if (fIntBitsToFloat >= CropImageView.DEFAULT_ASPECT_RATIO || i != 1) {
            return 0L;
        }
        NodeChain nodeChain = this.$sheetState.anchoredDraggableState;
        float fNewOffsetForDelta$foundation = nodeChain.newOffsetForDelta$foundation(fIntBitsToFloat);
        float fRequireOffset = fNewOffsetForDelta$foundation - nodeChain.requireOffset();
        ((AnchoredDraggableState$anchoredDragScope$1) nodeChain.cachedDiffer).dragTo(fNewOffsetForDelta$foundation, CropImageView.DEFAULT_ASPECT_RATIO);
        return toOffset(fRequireOffset);
    }

    public final long toOffset(float f) {
        return (((long) Float.floatToRawIntBits(f)) & 4294967295L) | (Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO) << 32);
    }
}
