package dev.chrisbanes.haze;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidRenderEffect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RenderEffect_androidKt {
    public static Bitmap noiseTexture;

    /* JADX INFO: renamed from: blendWith-moWRBKg, reason: not valid java name */
    public static final RenderEffect m1545blendWithmoWRBKg(RenderEffect renderEffect, RenderEffect renderEffect2, BlendMode blendMode, long j) {
        if ((9223372034707292159L & j) != 9205357640488583168L && !Offset.m434equalsimpl0(j, 0L)) {
            renderEffect2 = RenderEffect.createOffsetEffect(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), renderEffect2);
            renderEffect2.getClass();
        }
        RenderEffect renderEffectCreateBlendModeEffect = RenderEffect.createBlendModeEffect(renderEffect, renderEffect2, blendMode);
        renderEffectCreateBlendModeEffect.getClass();
        return renderEffectCreateBlendModeEffect;
    }

    public static final AndroidRenderEffect createRenderEffect(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, RenderEffectParams renderEffectParams) {
        RenderEffect renderEffectCreateBlurEffect;
        RenderEffect renderEffectCreateColorFilterEffect;
        float f = renderEffectParams.scale;
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        float f2 = renderEffectParams.blurRadius * f;
        if (Dp.m795compareTo0680j_4(f2, CropImageView.DEFAULT_ASPECT_RATIO) < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("blurRadius needs to be equal or greater than 0.dp");
            return null;
        }
        long jM450times7Ah8Wj8 = Size.m450times7Ah8Wj8(renderEffectParams.contentSize, f);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((float) Math.ceil(Float.intBitsToFloat((int) (jM450times7Ah8Wj8 & 4294967295L))))) & 4294967295L) | (((long) Float.floatToRawIntBits((float) Math.ceil(Float.intBitsToFloat((int) (jM450times7Ah8Wj8 >> 32))))) << 32);
        long jM440timestuRUvjQ = Offset.m440timestuRUvjQ(renderEffectParams.contentOffset, f);
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(MathKt.roundToInt(Float.intBitsToFloat((int) (jM440timestuRUvjQ & 4294967295L))))) & 4294967295L) | (((long) Float.floatToRawIntBits(MathKt.roundToInt(Float.intBitsToFloat((int) (jM440timestuRUvjQ >> 32))))) << 32);
        if (Dp.m795compareTo0680j_4(f2, CropImageView.DEFAULT_ASPECT_RATIO) <= 0) {
            renderEffectCreateBlurEffect = RenderEffect.createOffsetEffect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        } else {
            try {
                float fMo81toPx0680j_4 = ((Density) HitTestResultKt.currentValueOf(compositionLocalConsumerModifierNode, CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(f2);
                renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(fMo81toPx0680j_4, fMo81toPx0680j_4, ColorKt.m497toAndroidTileMode0vamqd0(renderEffectParams.blurTileMode));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(IntIntPair$$ExternalSyntheticOutline0.m("Error whilst calling RenderEffect.createBlurEffect. This is likely because this device does not support a blur radius of ", Dp.m797toStringimpl(f2), "dp"), e);
            }
        }
        renderEffectCreateBlurEffect.getClass();
        Context context = (Context) HitTestResultKt.currentValueOf(compositionLocalConsumerModifierNode, AndroidCompositionLocals_androidKt.LocalContext);
        float f3 = renderEffectParams.noiseFactor;
        if (f3 >= 0.005f) {
            if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
                f = 1.0f;
            }
            Bitmap noiseTexture2 = getNoiseTexture(context);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            BitmapShader bitmapShader = new BitmapShader(noiseTexture2, tileMode, tileMode);
            if (Math.abs(f - 1.0f) >= 0.001f) {
                Matrix matrix = new Matrix();
                float f4 = 1.0f / f;
                matrix.setScale(f4, f4);
                bitmapShader.setLocalMatrix(matrix);
            }
            float fCoerceIn = UuidKt.coerceIn(f3, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
            RenderEffect renderEffectCreateShaderEffect = RenderEffect.createShaderEffect(bitmapShader);
            renderEffectCreateShaderEffect.getClass();
            if (fCoerceIn < 1.0f) {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setScale(1.0f, 1.0f, 1.0f, fCoerceIn);
                renderEffectCreateShaderEffect = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix), renderEffectCreateShaderEffect);
            }
            renderEffectCreateShaderEffect.getClass();
            renderEffectCreateBlurEffect = RenderEffect.createBlendModeEffect(renderEffectCreateShaderEffect, renderEffectCreateBlurEffect, BlendMode.DST_ATOP);
            renderEffectCreateBlurEffect.getClass();
        }
        List<HazeTint> list = renderEffectParams.tints;
        float f5 = renderEffectParams.tintAlphaModulate;
        for (HazeTint hazeTint : list) {
            boolean zIsSpecified = hazeTint.isSpecified();
            int i = hazeTint.blendMode;
            if (zIsSpecified) {
                Brush brush = hazeTint.brush;
                Shader shaderMo474createShaderuvyYCjk = (brush == null || !(brush instanceof ShaderBrush)) ? null : ((ShaderBrush) brush).mo474createShaderuvyYCjk(jFloatToRawIntBits);
                if (shaderMo474createShaderuvyYCjk != null) {
                    if (f5 >= 1.0f) {
                        renderEffectCreateColorFilterEffect = RenderEffect.createShaderEffect(shaderMo474createShaderuvyYCjk);
                    } else {
                        TypefaceCompat$$ExternalSyntheticApiModelOutline1.m828m();
                        renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(ColorKt.m498toArgb8_81llA(ColorKt.Color(Color.m485getRedimpl(-72056498821267456L), Color.m484getGreenimpl(-72056498821267456L), Color.m482getBlueimpl(-72056498821267456L), f5, Color.m483getColorSpaceimpl(-72056498821267456L))), BlendMode.SRC_IN), RenderEffect.createShaderEffect(shaderMo474createShaderuvyYCjk));
                    }
                    renderEffectCreateColorFilterEffect.getClass();
                    renderEffectCreateBlurEffect = m1545blendWithmoWRBKg(renderEffectCreateBlurEffect, renderEffectCreateColorFilterEffect, BlendMode_androidKt.m1537toAndroidBlendModes9anfk8(i), jFloatToRawIntBits2);
                } else {
                    long jColor = hazeTint.color;
                    if (f5 < 1.0f) {
                        jColor = ColorKt.Color(Color.m485getRedimpl(jColor), Color.m484getGreenimpl(jColor), Color.m482getBlueimpl(jColor), Color.m481getAlphaimpl(jColor) * f5, Color.m483getColorSpaceimpl(jColor));
                    }
                    if (Color.m481getAlphaimpl(jColor) >= 0.005f) {
                        TypefaceCompat$$ExternalSyntheticApiModelOutline1.m828m();
                        renderEffectCreateBlurEffect = RenderEffect.createColorFilterEffect(TypefaceCompat$$ExternalSyntheticApiModelOutline1.m(ColorKt.m498toArgb8_81llA(jColor), BlendMode_androidKt.m1537toAndroidBlendModes9anfk8(i)), renderEffectCreateBlurEffect);
                        renderEffectCreateBlurEffect.getClass();
                    }
                }
            }
        }
        Brush brush2 = renderEffectParams.mask;
        BlendMode blendMode = BlendMode.DST_IN;
        if (brush2 != null) {
            Shader shaderMo474createShaderuvyYCjk2 = brush2 instanceof ShaderBrush ? ((ShaderBrush) brush2).mo474createShaderuvyYCjk(jFloatToRawIntBits) : null;
            if (shaderMo474createShaderuvyYCjk2 != null) {
                RenderEffect renderEffectCreateShaderEffect2 = RenderEffect.createShaderEffect(shaderMo474createShaderuvyYCjk2);
                renderEffectCreateShaderEffect2.getClass();
                renderEffectCreateBlurEffect = m1545blendWithmoWRBKg(renderEffectCreateBlurEffect, renderEffectCreateShaderEffect2, blendMode, jFloatToRawIntBits2);
            }
        }
        return new AndroidRenderEffect(renderEffectCreateBlurEffect);
    }

    public static final Bitmap getNoiseTexture(Context context) {
        context.getClass();
        Bitmap bitmap = noiseTexture;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.haze_noise);
        noiseTexture = bitmapDecodeResource;
        bitmapDecodeResource.getClass();
        return bitmapDecodeResource;
    }
}
