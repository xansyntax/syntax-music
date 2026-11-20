package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SheetDefaultsKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Density f$0;

    public /* synthetic */ SheetDefaultsKt$$ExternalSyntheticLambda0(Density density, byte b) {
        this.$r8$classId = b;
        this.f$0 = density;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Density density = this.f$0;
        switch (b) {
            case 0:
                return Float.valueOf(density.mo81toPx0680j_4(56.0f));
            case 1:
                return Float.valueOf(density.mo81toPx0680j_4(125.0f));
            case 2:
                return new Offset((((long) Float.floatToRawIntBits((density.mo75roundToPx0680j_4(80.0f) - density.mo75roundToPx0680j_4(56.0f)) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L));
            default:
                return Float.valueOf(density.mo81toPx0680j_4(125.0f));
        }
    }
}
