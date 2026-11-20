package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Painter {
    public BlendModeColorFilter colorFilter;
    public AndroidPaint layerPaint;
    public boolean useLayer;
    public float alpha = 1.0f;
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;

    public boolean applyAlpha(float f) {
        return false;
    }

    public boolean applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        return false;
    }

    /* JADX INFO: renamed from: draw-x_KDEd0, reason: not valid java name */
    public final void m575drawx_KDEd0(LayoutNodeDrawScope layoutNodeDrawScope, long j, float f, BlendModeColorFilter blendModeColorFilter) {
        if (this.alpha != f) {
            if (!applyAlpha(f)) {
                AndroidPaint androidPaintPaint = this.layerPaint;
                if (f == 1.0f) {
                    if (androidPaintPaint != null) {
                        androidPaintPaint.setAlpha(f);
                    }
                    this.useLayer = false;
                } else {
                    if (androidPaintPaint == null) {
                        androidPaintPaint = ColorKt.Paint();
                        this.layerPaint = androidPaintPaint;
                    }
                    androidPaintPaint.setAlpha(f);
                    this.useLayer = true;
                }
            }
            this.alpha = f;
        }
        if (!Intrinsics.areEqual(this.colorFilter, blendModeColorFilter)) {
            if (!applyColorFilter(blendModeColorFilter)) {
                AndroidPaint androidPaintPaint2 = this.layerPaint;
                if (blendModeColorFilter == null) {
                    if (androidPaintPaint2 != null) {
                        androidPaintPaint2.setColorFilter(null);
                    }
                    this.useLayer = false;
                } else {
                    if (androidPaintPaint2 == null) {
                        androidPaintPaint2 = ColorKt.Paint();
                        this.layerPaint = androidPaintPaint2;
                    }
                    androidPaintPaint2.setColorFilter(blendModeColorFilter);
                    this.useLayer = true;
                }
            }
            this.colorFilter = blendModeColorFilter;
        }
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        LayoutDirection layoutDirection = layoutNodeDrawScope.getLayoutDirection();
        if (this.layoutDirection != layoutDirection) {
            applyLayoutDirection(layoutDirection);
            this.layoutDirection = layoutDirection;
        }
        int i = (int) (j >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)) - Float.intBitsToFloat(i);
        int i2 = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) - Float.intBitsToFloat(i2);
        ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).inset(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat, fIntBitsToFloat2);
        if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
            try {
                if (Float.intBitsToFloat(i) > CropImageView.DEFAULT_ASPECT_RATIO && Float.intBitsToFloat(i2) > CropImageView.DEFAULT_ASPECT_RATIO) {
                    if (this.useLayer) {
                        float fIntBitsToFloat3 = Float.intBitsToFloat(i);
                        Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(0L, (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i2))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat3) << 32));
                        Canvas canvas = layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas();
                        AndroidPaint androidPaintPaint3 = this.layerPaint;
                        if (androidPaintPaint3 == null) {
                            androidPaintPaint3 = ColorKt.Paint();
                            this.layerPaint = androidPaintPaint3;
                        }
                        try {
                            canvas.saveLayer(rectM896Recttz77jQw, androidPaintPaint3);
                            onDraw(layoutNodeDrawScope);
                            canvas.restore();
                        } catch (Throwable th) {
                            canvas.restore();
                            throw th;
                        }
                    } else {
                        onDraw(layoutNodeDrawScope);
                    }
                }
            } catch (Throwable th2) {
                ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).inset(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
                throw th2;
            }
        }
        ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).inset(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public abstract long mo573getIntrinsicSizeNHjbRc();

    public abstract void onDraw(LayoutNodeDrawScope layoutNodeDrawScope);

    public void applyLayoutDirection(LayoutDirection layoutDirection) {
    }
}
