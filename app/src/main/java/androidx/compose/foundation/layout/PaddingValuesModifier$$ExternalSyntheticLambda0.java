package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PaddingValuesModifier$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Placeable f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ PaddingValuesModifier$$ExternalSyntheticLambda0(int i, Placeable placeable, int i2) {
        this.$r8$classId = (byte) 2;
        this.f$1 = i;
        this.f$0 = placeable;
        this.f$2 = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$2;
        Placeable placeable = this.f$0;
        int i2 = this.f$1;
        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
        switch (b) {
            case 0:
                placementScope.place(placeable, i2, i, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 1:
                placementScope.place(placeable, i2, i, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            default:
                placementScope.place(placeable, MathKt.roundToInt((i2 - placeable.width) / 2.0f), MathKt.roundToInt((i - placeable.height) / 2.0f), CropImageView.DEFAULT_ASPECT_RATIO);
                break;
        }
        return unit;
    }

    public /* synthetic */ PaddingValuesModifier$$ExternalSyntheticLambda0(Placeable placeable, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = placeable;
        this.f$1 = i;
        this.f$2 = i2;
    }
}
