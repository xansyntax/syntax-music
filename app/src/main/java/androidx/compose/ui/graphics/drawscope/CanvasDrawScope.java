package androidx.compose.ui.graphics.drawscope;

import android.graphics.Paint;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {
    public final EmojiProcessor drawContext;
    public final DrawParams drawParams;
    public AndroidPaint fillPaint;
    public AndroidPaint strokePaint;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DrawParams {
        public Canvas canvas;
        public Density density;
        public LayoutDirection layoutDirection;
        public long size;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m447equalsimpl0(this.size, drawParams.size);
        }

        public final int hashCode() {
            return Long.hashCode(this.size) + ((this.canvas.hashCode() + ((this.layoutDirection.hashCode() + (this.density.hashCode() * 31)) * 31)) * 31);
        }

        public final String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + Size.m451toStringimpl(this.size) + ")";
        }
    }

    public CanvasDrawScope() {
        DrawParams drawParams = new DrawParams();
        drawParams.density = DrawContextKt.DefaultDensity;
        drawParams.layoutDirection = LayoutDirection.Ltr;
        drawParams.canvas = EmptyCanvas.INSTANCE;
        drawParams.size = 0L;
        this.drawParams = drawParams;
        this.drawContext = new EmojiProcessor(this);
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    public static AndroidPaint m529configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, int i) {
        AndroidPaint androidPaintSelectPaint = canvasDrawScope.selectPaint(drawStyle);
        if (f != 1.0f) {
            j = ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), Color.m481getAlphaimpl(j) * f, Color.m483getColorSpaceimpl(j));
        }
        if (!ULong.m1869equalsimpl0(androidPaintSelectPaint.m460getColor0d7_KjU(), j)) {
            androidPaintSelectPaint.m464setColor8_81llA(j);
        }
        if (androidPaintSelectPaint.internalShader != null) {
            androidPaintSelectPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(androidPaintSelectPaint.internalColorFilter, (Object) null)) {
            androidPaintSelectPaint.setColorFilter(null);
        }
        if (androidPaintSelectPaint._blendMode != i) {
            androidPaintSelectPaint.m463setBlendModes9anfk8(i);
        }
        if (androidPaintSelectPaint.internalPaint.isFilterBitmap()) {
            return androidPaintSelectPaint;
        }
        androidPaintSelectPaint.m465setFilterQualityvDHp3xo(1);
        return androidPaintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    public final AndroidPaint m530configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
        AndroidPaint androidPaintSelectPaint = selectPaint(drawStyle);
        Paint paint = androidPaintSelectPaint.internalPaint;
        if (brush != null) {
            brush.mo473applyToPq9zytI(f, mo556getSizeNHjbRc(), androidPaintSelectPaint);
        } else {
            if (androidPaintSelectPaint.internalShader != null) {
                androidPaintSelectPaint.setShader(null);
            }
            if (!ULong.m1869equalsimpl0(androidPaintSelectPaint.m460getColor0d7_KjU(), -72057594037927936L)) {
                androidPaintSelectPaint.m464setColor8_81llA(-72057594037927936L);
            }
            if (paint.getAlpha() / 255.0f != f) {
                androidPaintSelectPaint.setAlpha(f);
            }
        }
        if (!Intrinsics.areEqual(androidPaintSelectPaint.internalColorFilter, blendModeColorFilter)) {
            androidPaintSelectPaint.setColorFilter(blendModeColorFilter);
        }
        if (androidPaintSelectPaint._blendMode != i) {
            androidPaintSelectPaint.m463setBlendModes9anfk8(i);
        }
        if (paint.isFilterBitmap() == i2) {
            return androidPaintSelectPaint;
        }
        androidPaintSelectPaint.m465setFilterQualityvDHp3xo(i2);
        return androidPaintSelectPaint;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public final void mo531drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, float f3, DrawStyle drawStyle) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawArc(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat(i2), f, f2, m529configurePaint2qPWKa0$default(this, j, drawStyle, f3, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public final void mo532drawCircleVaOC9Bg(long j, float f, long j2, DrawStyle drawStyle, int i) {
        this.drawParams.canvas.mo455drawCircle9KIMszo(f, j2, m529configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, i));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public final void mo533drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.drawParams.canvas.mo457drawImageRectHPBpro0(imageBitmap, j, j2, j3, m530configurePaintswdJneE(null, Fill.INSTANCE, f, blendModeColorFilter, 3, i));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public final void mo534drawImagegbVJVH8(ImageBitmap imageBitmap, BlendModeColorFilter blendModeColorFilter) {
        this.drawParams.canvas.mo456drawImaged4ec7I(imageBitmap, m530configurePaintswdJneE(null, Fill.INSTANCE, 1.0f, blendModeColorFilter, 3, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public final void mo535drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, int i2) {
        Canvas canvas = this.drawParams.canvas;
        AndroidPaint androidPaintPaint = this.strokePaint;
        if (androidPaintPaint == null) {
            androidPaintPaint = ColorKt.Paint();
            androidPaintPaint.m468setStylek9PVt8s(1);
            this.strokePaint = androidPaintPaint;
        }
        Paint paint = androidPaintPaint.internalPaint;
        if (!ULong.m1869equalsimpl0(androidPaintPaint.m460getColor0d7_KjU(), j)) {
            androidPaintPaint.m464setColor8_81llA(j);
        }
        if (androidPaintPaint.internalShader != null) {
            androidPaintPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(androidPaintPaint.internalColorFilter, (Object) null)) {
            androidPaintPaint.setColorFilter(null);
        }
        if (androidPaintPaint._blendMode != i2) {
            androidPaintPaint.m463setBlendModes9anfk8(i2);
        }
        if (paint.getStrokeWidth() != f) {
            androidPaintPaint.setStrokeWidth(f);
        }
        if (paint.getStrokeMiter() != 4.0f) {
            paint.setStrokeMiter(4.0f);
        }
        if (androidPaintPaint.m461getStrokeCapKaPHkGw() != i) {
            androidPaintPaint.m466setStrokeCapBeK7IIE(i);
        }
        if (androidPaintPaint.m462getStrokeJoinLxFBmk8() != 0) {
            androidPaintPaint.m467setStrokeJoinWw9F2mQ(0);
        }
        if (!paint.isFilterBitmap()) {
            androidPaintPaint.m465setFilterQualityvDHp3xo(1);
        }
        canvas.mo458drawLineWko1d7g(j2, j3, androidPaintPaint);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public final void mo536drawPathGBMwjPU(AndroidPath androidPath, Brush brush, float f, DrawStyle drawStyle, int i) {
        this.drawParams.canvas.drawPath(androidPath, m530configurePaintswdJneE(brush, drawStyle, f, null, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public final void mo537drawPathLG529CI(AndroidPath androidPath, long j, float f, DrawStyle drawStyle) {
        this.drawParams.canvas.drawPath(androidPath, m529configurePaint2qPWKa0$default(this, j, drawStyle, f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public final void mo538drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        this.drawParams.canvas.drawRect(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (4294967295L & j2)) + Float.intBitsToFloat(i3), m530configurePaintswdJneE(brush, drawStyle, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public final void mo539drawRectnJ9OG0(long j, long j2, long j3, float f, int i) {
        int i2 = (int) (j2 >> 32);
        int i3 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawRect(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (4294967295L & j3)) + Float.intBitsToFloat(i3), m529configurePaint2qPWKa0$default(this, j, Fill.INSTANCE, f, i));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public final void mo540drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        this.drawParams.canvas.drawRoundRect(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j2 & 4294967295L)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), m530configurePaintswdJneE(brush, drawStyle, f, null, 3, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public final void mo541drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawRoundRect(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), m529configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.drawParams.density.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final EmojiProcessor getDrawContext() {
        return this.drawContext;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.drawParams.density.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final LayoutDirection getLayoutDirection() {
        return this.drawParams.layoutDirection;
    }

    public final AndroidPaint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            AndroidPaint androidPaint = this.fillPaint;
            if (androidPaint != null) {
                return androidPaint;
            }
            AndroidPaint androidPaintPaint = ColorKt.Paint();
            androidPaintPaint.m468setStylek9PVt8s(0);
            this.fillPaint = androidPaintPaint;
            return androidPaintPaint;
        }
        if (!(drawStyle instanceof Stroke)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        AndroidPaint androidPaintPaint2 = this.strokePaint;
        if (androidPaintPaint2 == null) {
            androidPaintPaint2 = ColorKt.Paint();
            androidPaintPaint2.m468setStylek9PVt8s(1);
            this.strokePaint = androidPaintPaint2;
        }
        Paint paint = androidPaintPaint2.internalPaint;
        float strokeWidth = paint.getStrokeWidth();
        Stroke stroke = (Stroke) drawStyle;
        float f = stroke.width;
        if (strokeWidth != f) {
            androidPaintPaint2.setStrokeWidth(f);
        }
        int iM461getStrokeCapKaPHkGw = androidPaintPaint2.m461getStrokeCapKaPHkGw();
        int i = stroke.cap;
        if (iM461getStrokeCapKaPHkGw != i) {
            androidPaintPaint2.m466setStrokeCapBeK7IIE(i);
        }
        float strokeMiter = paint.getStrokeMiter();
        float f2 = stroke.miter;
        if (strokeMiter != f2) {
            paint.setStrokeMiter(f2);
        }
        int iM462getStrokeJoinLxFBmk8 = androidPaintPaint2.m462getStrokeJoinLxFBmk8();
        int i2 = stroke.join;
        if (iM462getStrokeJoinLxFBmk8 == i2) {
            return androidPaintPaint2;
        }
        androidPaintPaint2.m467setStrokeJoinWw9F2mQ(i2);
        return androidPaintPaint2;
    }
}
