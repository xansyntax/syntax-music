package com.metrolist.music.ui.component;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.unit.Velocity;
import androidx.sqlite.SQLite;
import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppNavigationKt$$ExternalSyntheticLambda27 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Ref$FloatRef f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ AppNavigationKt$$ExternalSyntheticLambda27(VelocityTracker velocityTracker, Ref$FloatRef ref$FloatRef, float f, LensController lensController) {
        this.$r8$classId = (byte) 0;
        this.f$0 = velocityTracker;
        this.f$1 = ref$FloatRef;
        this.f$2 = f;
        this.f$3 = lensController;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        float fScrollBy = CropImageView.DEFAULT_ASPECT_RATIO;
        float f = this.f$2;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$3;
        Object obj3 = this.f$0;
        Ref$FloatRef ref$FloatRef = this.f$1;
        switch (b) {
            case 0:
                VelocityTracker velocityTracker = (VelocityTracker) obj3;
                LensController lensController = (LensController) obj2;
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                pointerInputChange.getClass();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (PointerIconKt.positionChangeInternal(pointerInputChange, false) >> 32));
                velocityTracker.m594addPositionUv8p0NA(pointerInputChange.uptimeMillis, pointerInputChange.position);
                pointerInputChange.consume();
                float f2 = ref$FloatRef.element;
                float f3 = this.f$2;
                float fCoerceIn = UuidKt.coerceIn((fIntBitsToFloat / f3) + f2, -0.28f, (lensController.n - 1) + 0.28f);
                ref$FloatRef.element = fCoerceIn;
                float f4 = lensController.n - 1;
                if (fCoerceIn < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fCoerceIn *= 0.45f;
                } else if (fCoerceIn > f4) {
                    fCoerceIn = ((fCoerceIn - f4) * 0.45f) + f4;
                }
                AwaitKt.launch$default(lensController.scope, null, null, new AppNavigationKt$lensGesture$3$1(lensController, fCoerceIn, Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M()), f3, null), 3);
                break;
            case 1:
                ScrollScope scrollScope = (ScrollScope) obj3;
                Function1 function1 = (Function1) obj2;
                AnimationScope animationScope = (AnimationScope) obj;
                float fAbs = Math.abs(((Number) animationScope.value$delegate.getValue()).floatValue());
                float fAbs2 = Math.abs(f);
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = animationScope.value$delegate;
                if (fAbs < fAbs2) {
                    SQLite.animateDecay$consumeDelta(animationScope, scrollScope, function1, ((Number) parcelableSnapshotMutableState.getValue()).floatValue() - ref$FloatRef.element);
                    ref$FloatRef.element = ((Number) parcelableSnapshotMutableState.getValue()).floatValue();
                } else {
                    float fCoerceToTarget = SQLite.coerceToTarget(((Number) parcelableSnapshotMutableState.getValue()).floatValue(), f);
                    SQLite.animateDecay$consumeDelta(animationScope, scrollScope, function1, fCoerceToTarget - ref$FloatRef.element);
                    animationScope.cancelAnimation();
                    ref$FloatRef.element = fCoerceToTarget;
                }
                break;
            default:
                ScrollScope scrollScope2 = (ScrollScope) obj3;
                Function1 function2 = (Function1) obj2;
                AnimationScope animationScope2 = (AnimationScope) obj;
                float fCoerceToTarget2 = SQLite.coerceToTarget(((Number) animationScope2.value$delegate.getValue()).floatValue(), f);
                float f5 = fCoerceToTarget2 - ref$FloatRef.element;
                try {
                    fScrollBy = scrollScope2.scrollBy(f5);
                } catch (CancellationException unused) {
                    animationScope2.cancelAnimation();
                }
                function2.invoke(Float.valueOf(fScrollBy));
                if (Math.abs(f5 - fScrollBy) > 0.5f || fCoerceToTarget2 != ((Number) animationScope2.value$delegate.getValue()).floatValue()) {
                    animationScope2.cancelAnimation();
                }
                ref$FloatRef.element += fScrollBy;
                break;
        }
        return unit;
    }

    public /* synthetic */ AppNavigationKt$$ExternalSyntheticLambda27(float f, Ref$FloatRef ref$FloatRef, ScrollScope scrollScope, Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$2 = f;
        this.f$1 = ref$FloatRef;
        this.f$0 = scrollScope;
        this.f$3 = function1;
    }
}
