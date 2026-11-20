package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.gestures.DraggableGestureConnection;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableKt$NoOpOnDragStarted$1;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.shape.PxCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.LensController;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda13(float f, Ref$BooleanRef ref$BooleanRef) {
        this.$r8$classId = (byte) 2;
        this.f$1 = f;
        this.f$0 = ref$BooleanRef;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0081  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        byte b = this.$r8$classId;
        boolean z2 = false;
        Unit unit = Unit.INSTANCE;
        float f = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                float floatValue = ((ParcelableSnapshotMutableFloatState) ((SheetState) obj2).anchoredDraggableState.head).getFloatValue();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (reusableGraphicsLayerScope.size & 4294967295L));
                if (!Float.isNaN(floatValue) && !Float.isNaN(fIntBitsToFloat) && fIntBitsToFloat != CropImageView.DEFAULT_ASPECT_RATIO) {
                    reusableGraphicsLayerScope.setScaleX(CardKt.calculateSheetPredictiveBackScaleX(reusableGraphicsLayerScope, f));
                    reusableGraphicsLayerScope.setScaleY(CardKt.calculateSheetPredictiveBackScaleY(reusableGraphicsLayerScope, f));
                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, (floatValue + fIntBitsToFloat) / fIntBitsToFloat));
                }
                return unit;
            case 1:
                Transition transition = (Transition) obj2;
                long jLongValue = ((Long) obj).longValue();
                boolean zIsSeeking = transition.isSeeking();
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = transition.startTimeNanos$delegate;
                if (!zIsSeeking) {
                    if (parcelableSnapshotMutableLongState.getLongValue() == Long.MIN_VALUE) {
                        parcelableSnapshotMutableLongState.setLongValue(jLongValue);
                        ((ParcelableSnapshotMutableState) transition.transitionState.output).setValue(Boolean.TRUE);
                    }
                    long longValue = jLongValue - parcelableSnapshotMutableLongState.getLongValue();
                    if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                        longValue = MathKt.roundToLong(longValue / ((double) f));
                    }
                    transition.setPlayTimeNanos(longValue);
                    transition.onFrame$animation_core(longValue, f == CropImageView.DEFAULT_ASPECT_RATIO);
                }
                return unit;
            case 2:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj2;
                DraggableGestureConnection draggableGestureConnection = (DraggableGestureConnection) obj;
                boolean zAreEqual = Intrinsics.areEqual(draggableGestureConnection.mo22getGestureState7meUWtM(), "waiting");
                if (draggableGestureConnection.getOrientation() == null) {
                    z = false;
                } else {
                    Orientation orientation = draggableGestureConnection.getOrientation();
                    orientation.getClass();
                    DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = DraggableKt.NoOpOnDragStarted;
                    if (orientation != Orientation.Horizontal ? f <= 30.0f || f > 90.0f : f > 30.0f) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                if (ref$BooleanRef.element || (zAreEqual && z)) {
                    z2 = true;
                }
                ref$BooleanRef.element = z2;
                return Boolean.valueOf(!z2);
            case 3:
                ((Density) obj).getClass();
                return new IntOffset(((long) MathKt.roundToInt(((Number) ((LensController) obj2).pos.getValue()).floatValue() * f)) << 32);
            default:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope2.getClass();
                float density = reusableGraphicsLayerScope2.graphicsDensity.getDensity() * f * (1.0f - UuidKt.coerceIn(((BottomSheetState) obj2).getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
                reusableGraphicsLayerScope2.setShape(new RoundedCornerShape(new PxCornerSize(density), new PxCornerSize(density), new PxCornerSize(CropImageView.DEFAULT_ASPECT_RATIO), new PxCornerSize(CropImageView.DEFAULT_ASPECT_RATIO)));
                reusableGraphicsLayerScope2.setClip(true);
                return unit;
        }
    }

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda13(Object obj, float f, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = f;
    }
}
