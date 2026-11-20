package androidx.compose.material3;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.node.NodeChain;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SheetState f$0;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda4(SheetState sheetState, byte b) {
        this.$r8$classId = b;
        this.f$0 = sheetState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SheetState sheetState = this.f$0;
        switch (b) {
            case 0:
                ((Float) obj).getClass();
                return Float.valueOf(((Number) sheetState.positionalThreshold.invoke()).floatValue());
            case 1:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                NodeChain nodeChain = sheetState.anchoredDraggableState;
                float floatValue = ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
                float fMinPosition = nodeChain.getAnchors().minPosition();
                float f = floatValue < fMinPosition ? fMinPosition - floatValue : 0.0f;
                reusableGraphicsLayerScope.setScaleY(f > CropImageView.DEFAULT_ASPECT_RATIO ? (Float.intBitsToFloat((int) (reusableGraphicsLayerScope.size & 4294967295L)) + f) / Float.intBitsToFloat((int) (reusableGraphicsLayerScope.size & 4294967295L)) : 1.0f);
                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                return unit;
            default:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                NodeChain nodeChain2 = sheetState.anchoredDraggableState;
                float floatValue2 = ((ParcelableSnapshotMutableFloatState) nodeChain2.head).getFloatValue();
                float fMinPosition2 = nodeChain2.getAnchors().minPosition();
                float f2 = floatValue2 < fMinPosition2 ? fMinPosition2 - floatValue2 : 0.0f;
                reusableGraphicsLayerScope2.setScaleY(f2 > CropImageView.DEFAULT_ASPECT_RATIO ? 1.0f / ((Float.intBitsToFloat((int) (reusableGraphicsLayerScope2.size & 4294967295L)) + f2) / Float.intBitsToFloat((int) (4294967295L & reusableGraphicsLayerScope2.size))) : 1.0f);
                reusableGraphicsLayerScope2.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                return unit;
        }
    }
}
