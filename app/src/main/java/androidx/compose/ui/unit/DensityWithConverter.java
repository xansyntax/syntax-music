package androidx.compose.ui.unit;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DensityWithConverter implements Density {
    public final FontScaleConverter converter;
    public final float density;
    public final float fontScale;

    public DensityWithConverter(float f, float f2, FontScaleConverter fontScaleConverter) {
        this.density = f;
        this.fontScale = f2;
        this.converter = fontScaleConverter;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DensityWithConverter)) {
            return false;
        }
        DensityWithConverter densityWithConverter = (DensityWithConverter) obj;
        return Float.compare(this.density, densityWithConverter.density) == 0 && Float.compare(this.fontScale, densityWithConverter.fontScale) == 0 && this.converter.equals(densityWithConverter.converter);
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.fontScale;
    }

    public final int hashCode() {
        return this.converter.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.fontScale, Float.hashCode(this.density) * 31, 31);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final float mo76toDpGaN1DYA(long j) {
        if (TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j), 4294967296L)) {
            return this.converter.convertSpToDp(TextUnit.m814getValueimpl(j));
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Only Sp can convert to Px");
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public final long mo83toSp0xMU5do(float f) {
        return IntMath.pack(4294967296L, this.converter.convertDpToSp(f));
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("DensityWithConverter(density=", this.density, ", fontScale=", this.fontScale, ", converter=");
        sbM.append(this.converter);
        sbM.append(")");
        return sbM.toString();
    }
}
