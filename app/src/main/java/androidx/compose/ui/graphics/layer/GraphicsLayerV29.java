package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CanvasZHelper;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.DisplayCompat;
import androidx.emoji2.text.EmojiProcessor;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerV29 implements GraphicsLayerImpl {
    public float alpha;
    public long ambientShadowColor;
    public byte blendMode;
    public float cameraDistance;
    public final CanvasDrawScope canvasDrawScope;
    public final CanvasHolder canvasHolder;
    public boolean clip;
    public boolean clipToBounds;
    public boolean clipToOutline;
    public int compositingStrategy;
    public Paint layerPaint;
    public Matrix matrix;
    public boolean outlineIsProvided;
    public int outsetBottom;
    public int outsetLeft;
    public int outsetRight;
    public int outsetTop;
    public long pivotOffset;
    public RenderEffect renderEffect;
    public final RenderNode renderNode;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public float shadowElevation;
    public long size;
    public long spotShadowColor;
    public float translationX;
    public float translationY;
    public int x;
    public int y;

    public GraphicsLayerV29() {
        CanvasHolder canvasHolder = new CanvasHolder();
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        RenderNode renderNode = new RenderNode("graphicsLayer");
        this.renderNode = renderNode;
        this.size = 0L;
        renderNode.setClipToBounds(false);
        m571applyCompositingStrategyZ1X6vPc(renderNode, 0);
        this.alpha = 1.0f;
        this.blendMode = (byte) 3;
        this.pivotOffset = 9205357640488583168L;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.ambientShadowColor = -72057594037927936L;
        this.spotShadowColor = -72057594037927936L;
        this.cameraDistance = 8.0f;
        this.compositingStrategy = 0;
    }

    public final void applyClip$1() {
        boolean z = this.clip;
        boolean z2 = false;
        boolean z3 = z && !this.outlineIsProvided;
        if (z && this.outlineIsProvided) {
            z2 = true;
        }
        if (z3 != this.clipToBounds) {
            this.clipToBounds = z3;
            this.renderNode.setClipToBounds(z3);
        }
        if (z2 != this.clipToOutline) {
            this.clipToOutline = z2;
            this.renderNode.setClipToOutline(z2);
        }
    }

    /* JADX INFO: renamed from: applyCompositingStrategy-Z1X6vPc, reason: not valid java name */
    public final void m571applyCompositingStrategyZ1X6vPc(RenderNode renderNode, int i) {
        if (i == 1) {
            renderNode.setUseCompositingLayer(true, this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
            return;
        }
        Paint paint = this.layerPaint;
        if (i == 2) {
            renderNode.setUseCompositingLayer(false, paint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, paint);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final Matrix calculateMatrix() {
        Matrix matrix = this.matrix;
        if (matrix == null) {
            matrix = new Matrix();
            this.matrix = matrix;
        }
        this.renderNode.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void draw(Canvas canvas) {
        android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        ((AndroidCanvas) canvas).internalCanvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU */
    public final long mo559getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getBlendMode-0nO6VwU */
    public final int mo560getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final BlendModeColorFilter getColorFilter() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w */
    public final int mo561getCompositingStrategyke2Ky5w() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getRotationX() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getRotationY() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU */
    public final long mo562getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        RecordingCanvas recordingCanvasBeginRecording = this.renderNode.beginRecording();
        float f = this.outsetLeft;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(this.outsetTop)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
            android.graphics.Canvas canvas = androidCanvas.internalCanvas;
            androidCanvas.internalCanvas = recordingCanvasBeginRecording;
            EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
            emojiProcessor.setDensity(density);
            emojiProcessor.setLayoutDirection(layoutDirection);
            emojiProcessor.mMetadataRepo = graphicsLayer;
            emojiProcessor.m832setSizeuvyYCjk(this.size);
            emojiProcessor.setCanvas(androidCanvas);
            if (this.outsetLeft > CropImageView.DEFAULT_ASPECT_RATIO || this.outsetTop > CropImageView.DEFAULT_ASPECT_RATIO) {
                int i = (int) (jFloatToRawIntBits >> 32);
                int i2 = (int) (jFloatToRawIntBits & 4294967295L);
                androidCanvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                textKt$$ExternalSyntheticLambda2.invoke(canvasDrawScope);
                androidCanvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            } else {
                textKt$$ExternalSyntheticLambda2.invoke(canvasDrawScope);
            }
            canvasHolder.androidCanvas.internalCanvas = canvas;
        } finally {
            this.renderNode.endRecording();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setAlpha(float f) {
        this.alpha = f;
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA */
    public final void mo563setAmbientShadowColor8_81llA(long j) {
        this.ambientShadowColor = j;
        this.renderNode.setAmbientShadowColor(ColorKt.m498toArgb8_81llA(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setBlendMode-s9anfk8 */
    public final void mo564setBlendModes9anfk8(int i) {
        this.blendMode = i;
        Paint paint = this.layerPaint;
        if (paint == null) {
            paint = new Paint();
            this.layerPaint = paint;
        }
        paint.setBlendMode(CanvasZHelper.m476toAndroidBlendModes9anfk8(i));
        updateLayerProperties$1();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setCameraDistance(float f) {
        this.cameraDistance = f;
        this.renderNode.setCameraDistance(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setClip(boolean z) {
        this.clip = z;
        applyClip$1();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setColorFilter() {
        Paint paint = this.layerPaint;
        if (paint == null) {
            paint = new Paint();
            this.layerPaint = paint;
        }
        paint.setColorFilter(null);
        updateLayerProperties$1();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng */
    public final void mo565setCompositingStrategyWpw9cng(int i) {
        this.compositingStrategy = i;
        updateLayerProperties$1();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setOutline-O0kMr_c */
    public final void mo566setOutlineO0kMr_c(Outline outline, long j) {
        this.renderNode.setOutline(outline);
        this.outlineIsProvided = outline != null;
        applyClip$1();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setOutsets(int i, int i2, int i3, int i4) {
        if (!(i >= 0 && i2 >= 0 && i3 >= 0 && i4 >= 0)) {
            StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "Outsets cannot be negative! Left: ", ", Top: ", i2, ", Right: ");
            sbM3m.append(i3);
            sbM3m.append(", Bottom: ");
            sbM3m.append(i4);
            InlineClassHelperKt.throwIllegalArgumentException(sbM3m.toString());
        }
        int i5 = this.outsetLeft;
        if (i == i5 && i2 == this.outsetTop && i3 == this.outsetRight && i4 == this.outsetBottom) {
            return;
        }
        boolean z = (i == i5 && i2 == this.outsetTop) ? false : true;
        this.outsetLeft = i;
        this.outsetTop = i2;
        this.outsetRight = i3;
        this.outsetBottom = i4;
        updatePosition$1();
        if (z) {
            updatePivot$1();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M */
    public final void mo567setPivotOffsetk4lQ0M(long j) {
        this.pivotOffset = j;
        updatePivot$1();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPosition-H0pRuoY */
    public final void mo568setPositionH0pRuoY(int i, int i2, long j) {
        this.x = i;
        this.y = i2;
        boolean zM447equalsimpl0 = Size.m447equalsimpl0(this.size, SizeKt.m876toSizeozmzZPI(j));
        this.size = SizeKt.m876toSizeozmzZPI(j);
        updatePosition$1();
        if (zM447equalsimpl0 || !Offset.m434equalsimpl0(this.pivotOffset, 9205357640488583168L)) {
            return;
        }
        this.renderNode.setPivotX((((int) (j >> 32)) / 2.0f) + this.outsetLeft);
        this.renderNode.setPivotY((((int) (j & 4294967295L)) / 2.0f) + this.outsetTop);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            DisplayCompat.setRenderEffect(this.renderNode, renderEffect);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRotationX() {
        this.renderNode.setRotationX(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRotationY() {
        this.renderNode.setRotationY(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRotationZ(float f) {
        this.rotationZ = f;
        this.renderNode.setRotationZ(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setScaleX(float f) {
        this.scaleX = f;
        this.renderNode.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setScaleY(float f) {
        this.scaleY = f;
        this.renderNode.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setShadowElevation(float f) {
        this.shadowElevation = f;
        this.renderNode.setElevation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA */
    public final void mo569setSpotShadowColor8_81llA(long j) {
        this.spotShadowColor = j;
        this.renderNode.setSpotShadowColor(ColorKt.m498toArgb8_81llA(j));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setTranslationX(float f) {
        this.translationX = f;
        this.renderNode.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setTranslationY(float f) {
        this.translationY = f;
        this.renderNode.setTranslationY(f);
    }

    public final void updateLayerProperties$1() {
        int i = this.compositingStrategy;
        if (i != 1 && this.blendMode == 3 && this.renderEffect == null) {
            m571applyCompositingStrategyZ1X6vPc(this.renderNode, i);
        } else {
            m571applyCompositingStrategyZ1X6vPc(this.renderNode, 1);
        }
    }

    public final void updatePivot$1() {
        long j = this.pivotOffset;
        long j2 = 9223372034707292159L & j;
        RenderNode renderNode = this.renderNode;
        if (j2 == 9205357640488583168L) {
            renderNode.setPivotX((Float.intBitsToFloat((int) (this.size >> 32)) / 2.0f) + this.outsetLeft);
            this.renderNode.setPivotY((Float.intBitsToFloat((int) (this.size & 4294967295L)) / 2.0f) + this.outsetTop);
        } else {
            renderNode.setPivotX(Float.intBitsToFloat((int) (j >> 32)) + this.outsetLeft);
            this.renderNode.setPivotY(Float.intBitsToFloat((int) (this.pivotOffset & 4294967295L)) + this.outsetTop);
        }
    }

    public final void updatePosition$1() {
        RenderNode renderNode = this.renderNode;
        int i = this.x;
        renderNode.setPosition(i - this.outsetLeft, this.y - this.outsetTop, i + ((int) Float.intBitsToFloat((int) (this.size >> 32))) + this.outsetRight, this.y + ((int) Float.intBitsToFloat((int) (this.size & 4294967295L))) + this.outsetBottom);
    }
}
