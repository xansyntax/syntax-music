package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BrushStyle implements TextForegroundStyle {
    public final float alpha;
    public final ShaderBrush value;

    public BrushStyle(ShaderBrush shaderBrush, float f) {
        this.value = shaderBrush;
        this.alpha = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrushStyle)) {
            return false;
        }
        BrushStyle brushStyle = (BrushStyle) obj;
        return this.value.equals(brushStyle.value) && Float.compare(this.alpha, brushStyle.alpha) == 0;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final Brush getBrush() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long mo768getColor0d7_KjU() {
        float[] fArr = ColorSpaces.SrgbPrimaries;
        return ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
    }

    public final int hashCode() {
        return Float.hashCode(this.alpha) + (this.value.hashCode() * 31);
    }

    public final String toString() {
        return "BrushStyle(value=" + this.value + ", alpha=" + this.alpha + ")";
    }
}
