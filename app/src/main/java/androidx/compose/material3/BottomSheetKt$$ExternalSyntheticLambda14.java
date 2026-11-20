package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.layout.Placeable;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda14 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ float f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ float f$2;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda14(float f, float f2, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$0 = f;
        this.f$2 = f2;
        this.f$1 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$1;
        float f = this.f$2;
        float f2 = this.f$0;
        switch (b) {
            case 0:
                DraggableAnchorsConfig draggableAnchorsConfig = (DraggableAnchorsConfig) obj;
                draggableAnchorsConfig.at(f2, SheetValue.Hidden);
                Set set = ((SheetState) obj2).enabledValues;
                SheetValue sheetValue = SheetValue.PartiallyExpanded;
                if (set.contains(sheetValue)) {
                    draggableAnchorsConfig.at(f2 - Math.min(f2 / 2.0f, f), sheetValue);
                }
                if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                    draggableAnchorsConfig.at(Math.max(CropImageView.DEFAULT_ASPECT_RATIO, f2 - f), SheetValue.Expanded);
                }
                break;
            case 1:
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                placementScope.getClass();
                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj2, MathKt.roundToInt(f2 * f), 0);
                break;
            default:
                AnimationScope animationScope = (AnimationScope) obj;
                float fCoerceIn = UuidKt.coerceIn(((Number) animationScope.value$delegate.getValue()).floatValue(), f2, f);
                ((ParcelableSnapshotMutableFloatState) obj2).setFloatValue(fCoerceIn);
                if (((Number) animationScope.value$delegate.getValue()).floatValue() != fCoerceIn) {
                    animationScope.cancelAnimation();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda14(float f, SheetState sheetState, float f2) {
        this.f$0 = f;
        this.f$1 = sheetState;
        this.f$2 = f2;
    }

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda14(Placeable placeable, float f, float f2) {
        this.f$1 = placeable;
        this.f$0 = f;
        this.f$2 = f2;
    }
}
