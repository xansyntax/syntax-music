package androidx.compose.foundation.shape;

import androidx.compose.material3.carousel.CarouselItemScopeImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GenericShape implements Shape {
    public final PlayerKt$$ExternalSyntheticLambda82 builder;

    public GenericShape(PlayerKt$$ExternalSyntheticLambda82 playerKt$$ExternalSyntheticLambda82) {
        this.builder = playerKt$$ExternalSyntheticLambda82;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final ColorKt mo56createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        PlayerKt$$ExternalSyntheticLambda82 playerKt$$ExternalSyntheticLambda82 = this.builder;
        CarouselItemScopeImpl carouselItemScopeImpl = (CarouselItemScopeImpl) playerKt$$ExternalSyntheticLambda82.f$0;
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) playerKt$$ExternalSyntheticLambda82.f$1;
        Density density2 = (Density) playerKt$$ExternalSyntheticLambda82.f$2;
        Rect rectIntersect = carouselItemScopeImpl.itemInfo.getMaskRect().intersect(IntMath.m896Recttz77jQw(0L, j));
        ColorKt.addOutline(androidPathPath, roundedCornerShape.mo56createOutlinePq9zytI(rectIntersect.m444getSizeNHjbRc(), layoutDirection, density2));
        float f = rectIntersect.left;
        androidPathPath.m472translatek4lQ0M((((long) Float.floatToRawIntBits(rectIntersect.top)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
        androidPathPath.internalPath.close();
        return new Outline$Generic(androidPathPath);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        GenericShape genericShape = obj instanceof GenericShape ? (GenericShape) obj : null;
        return (genericShape != null ? genericShape.builder : null) == this.builder;
    }

    public final int hashCode() {
        return this.builder.hashCode();
    }
}
