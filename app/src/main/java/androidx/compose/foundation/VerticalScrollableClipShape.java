package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VerticalScrollableClipShape implements Shape {
    public final /* synthetic */ byte $r8$classId;
    public static final VerticalScrollableClipShape INSTANCE$1 = new VerticalScrollableClipShape(1);
    public static final VerticalScrollableClipShape INSTANCE = new VerticalScrollableClipShape(0);

    public /* synthetic */ VerticalScrollableClipShape(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public final ColorKt mo56createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        switch (this.$r8$classId) {
            case 0:
                float fMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(30.0f);
                return new Outline$Rectangle(new Rect(-fMo75roundToPx0680j_4, CropImageView.DEFAULT_ASPECT_RATIO, Float.intBitsToFloat((int) (j >> 32)) + fMo75roundToPx0680j_4, Float.intBitsToFloat((int) (j & 4294967295L))));
            default:
                float fMo75roundToPx0680j_5 = density.mo75roundToPx0680j_4(30.0f);
                return new Outline$Rectangle(new Rect(CropImageView.DEFAULT_ASPECT_RATIO, -fMo75roundToPx0680j_5, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)) + fMo75roundToPx0680j_5));
        }
    }
}
