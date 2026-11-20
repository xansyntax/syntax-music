package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.style.TextDecoration;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.RealWebSocket$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    public byte backingBlendMode;
    public AndroidPaint backingComposePaint;
    public Brush brush;
    public Size brushSize;
    public DrawStyle drawStyle;
    public Color lastColor;
    public DerivedSnapshotState shaderState;
    public Shadow shadow;
    public TextDecoration textDecoration;

    public final AndroidPaint getComposePaint() {
        AndroidPaint androidPaint = this.backingComposePaint;
        if (androidPaint != null) {
            return androidPaint;
        }
        AndroidPaint androidPaint2 = new AndroidPaint(this);
        this.backingComposePaint = androidPaint2;
        return androidPaint2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m763setBlendModes9anfk8(int i) {
        if (i == this.backingBlendMode) {
            return;
        }
        getComposePaint().m463setBlendModes9anfk8(i);
        this.backingBlendMode = i;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    /* JADX WARN: Code duplicated, block: B:21:0x0040  */
    /* JADX INFO: renamed from: setBrush-12SF9DM, reason: not valid java name */
    public final void m764setBrush12SF9DM(Brush brush, long j, float f) {
        if (brush == null) {
            this.shaderState = null;
            this.brush = null;
            this.brushSize = null;
            setShader(null);
            return;
        }
        if (brush instanceof SolidColor) {
            m765setColor8_81llA(IntMath.m901modulateDxMtmZc(((SolidColor) brush).value, f));
            return;
        }
        if (!(brush instanceof ShaderBrush)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        if (Intrinsics.areEqual(this.brush, brush)) {
            Size size = this.brushSize;
            if (!(size == null ? false : Size.m447equalsimpl0(size.packedValue, j))) {
                if (j != 9205357640488583168L) {
                    this.brush = brush;
                    this.brushSize = new Size(j);
                    this.shaderState = SnapshotStateKt__DerivedStateKt.derivedStateOf(new RealWebSocket$$ExternalSyntheticLambda1(brush, j, (byte) 1));
                }
            }
        } else if (j != 9205357640488583168L) {
            this.brush = brush;
            this.brushSize = new Size(j);
            this.shaderState = SnapshotStateKt__DerivedStateKt.derivedStateOf(new RealWebSocket$$ExternalSyntheticLambda1(brush, j, (byte) 1));
        }
        AndroidPaint composePaint = getComposePaint();
        DerivedSnapshotState derivedSnapshotState = this.shaderState;
        composePaint.setShader(derivedSnapshotState != null ? (Shader) derivedSnapshotState.getValue() : null);
        this.lastColor = null;
        AndroidTextPaint_androidKt.setAlpha(this, f);
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m765setColor8_81llA(long j) {
        Color color = this.lastColor;
        if ((color == null ? false : ULong.m1869equalsimpl0(color.value, j)) || j == 16) {
            return;
        }
        this.lastColor = new Color(j);
        setColor(ColorKt.m498toArgb8_81llA(j));
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        setShader(null);
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (drawStyle.equals(Fill.INSTANCE)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (!(drawStyle instanceof Stroke)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        getComposePaint().m468setStylek9PVt8s(1);
        Stroke stroke = (Stroke) drawStyle;
        getComposePaint().setStrokeWidth(stroke.width);
        AndroidPaint composePaint = getComposePaint();
        composePaint.internalPaint.setStrokeMiter(stroke.miter);
        getComposePaint().m467setStrokeJoinWw9F2mQ(stroke.join);
        getComposePaint().m466setStrokeCapBeK7IIE(stroke.cap);
        getComposePaint().internalPaint.setPathEffect(null);
    }

    public final void setShadow(Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (shadow.equals(Shadow.None)) {
            clearShadowLayer();
            return;
        }
        Shadow shadow2 = this.shadow;
        float f = shadow2.blurRadius;
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            f = Float.MIN_VALUE;
        }
        setShadowLayer(f, Float.intBitsToFloat((int) (shadow2.offset >> 32)), Float.intBitsToFloat((int) (this.shadow.offset & 4294967295L)), ColorKt.m498toArgb8_81llA(this.shadow.color));
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        int i = textDecoration.mask;
        setUnderlineText((i | 1) == i);
        int i2 = this.textDecoration.mask;
        setStrikeThruText((i2 | 2) == i2);
    }
}
