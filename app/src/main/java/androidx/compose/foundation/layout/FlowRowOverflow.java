package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowRowOverflow implements Arrangement$Horizontal, Arrangement$Vertical {
    public static final FlowRowOverflow Clip = new FlowRowOverflow(0);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ FlowRowOverflow(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
    public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
        byte b = this.$r8$classId;
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        switch (b) {
            case 1:
                if (layoutDirection != layoutDirection2) {
                    OffsetKt.placeCenter$foundation_layout(i, iArr, iArr2, true);
                } else {
                    OffsetKt.placeCenter$foundation_layout(i, iArr, iArr2, false);
                }
                break;
            default:
                if (layoutDirection != layoutDirection2) {
                    OffsetKt.placeSpaceBetween$foundation_layout(i, iArr, iArr2, true);
                } else {
                    OffsetKt.placeSpaceBetween$foundation_layout(i, iArr, iArr2, false);
                }
                break;
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical
    /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
    public float mo112getSpacingD9Ej5fM() {
        switch (this.$r8$classId) {
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                return "Arrangement#Center";
            case 2:
                return "Arrangement#SpaceBetween";
            default:
                return super.toString();
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Vertical
    public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
        switch (this.$r8$classId) {
            case 1:
                OffsetKt.placeCenter$foundation_layout(i, iArr, iArr2, false);
                break;
            default:
                OffsetKt.placeSpaceBetween$foundation_layout(i, iArr, iArr2, false);
                break;
        }
    }
}
