package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Density {
    float getDensity();

    float getFontScale();

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    default int mo74roundToPxR2X_6o(long j) {
        return Math.round(mo80toPxR2X_6o(j));
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    default int mo75roundToPx0680j_4(float f) {
        float fMo81toPx0680j_4 = mo81toPx0680j_4(f);
        if (Float.isInfinite(fMo81toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fMo81toPx0680j_4);
    }

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    default float mo76toDpGaN1DYA(long j) {
        if (!TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j), 4294967296L)) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        float[] fArr = FontScaleConverterFactory.CommonFontSizes;
        if (getFontScale() < 1.03f) {
            return getFontScale() * TextUnit.m814getValueimpl(j);
        }
        FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.forScale(getFontScale());
        if (fontScaleConverterForScale != null) {
            return fontScaleConverterForScale.convertSpToDp(TextUnit.m814getValueimpl(j));
        }
        return getFontScale() * TextUnit.m814getValueimpl(j);
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo78toDpu2uoSUM(int i) {
        return (i / getDensity()) + CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo79toDpSizekrfVVM(long j) {
        if (j != 9205357640488583168L) {
            return UtilsKt.m890DpSizeYgX7TsA(mo77toDpu2uoSUM(Float.intBitsToFloat((int) (j >> 32))), mo77toDpu2uoSUM(Float.intBitsToFloat((int) (j & 4294967295L))));
        }
        return 9205357640488583168L;
    }

    /* JADX INFO: renamed from: toPx--R2X_6o */
    default float mo80toPxR2X_6o(long j) {
        if (!TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j), 4294967296L)) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        return mo81toPx0680j_4(mo76toDpGaN1DYA(j));
    }

    /* JADX INFO: renamed from: toPx-0680j_4 */
    default float mo81toPx0680j_4(float f) {
        return getDensity() * f;
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo82toSizeXkaWNTQ(long j) {
        if (j == 9205357640488583168L) {
            return 9205357640488583168L;
        }
        float fMo81toPx0680j_4 = mo81toPx0680j_4(DpSize.m802getWidthD9Ej5fM(j));
        float fMo81toPx0680j_5 = mo81toPx0680j_4(DpSize.m801getHeightD9Ej5fM(j));
        return (((long) Float.floatToRawIntBits(fMo81toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo81toPx0680j_5)) & 4294967295L);
    }

    /* JADX INFO: renamed from: toSp-0xMU5do */
    default long mo83toSp0xMU5do(float f) {
        float[] fArr = FontScaleConverterFactory.CommonFontSizes;
        if (getFontScale() < 1.03f) {
            return IntMath.pack(4294967296L, f / getFontScale());
        }
        FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.forScale(getFontScale());
        return IntMath.pack(4294967296L, fontScaleConverterForScale != null ? fontScaleConverterForScale.convertDpToSp(f) : f / getFontScale());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo84toSpkPz2Gy4(float f) {
        return mo83toSp0xMU5do(mo77toDpu2uoSUM(f));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo77toDpu2uoSUM(float f) {
        return (f / getDensity()) + CropImageView.DEFAULT_ASPECT_RATIO;
    }
}
