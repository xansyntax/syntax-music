package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.geometry.Offset;
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
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.core.view.DisplayCompat;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsViewLayer implements GraphicsLayerImpl {
    public static final GraphicsViewLayer$Companion$PlaceholderCanvas$1 PlaceholderCanvas = new GraphicsViewLayer$Companion$PlaceholderCanvas$1();
    public float alpha;
    public long ambientShadowColor;
    public byte blendMode;
    public final CanvasHolder canvasHolder;
    public boolean clipBoundsInvalidated;
    public final Rect clipRect;
    public boolean clipToBounds;
    public int compositingStrategy;
    public final DrawChildContainer layerContainer;
    public Paint layerPaint;
    public boolean outlineIsProvided;
    public int outsetBottom;
    public int outsetLeft;
    public int outsetRight;
    public int outsetTop;
    public long pivotOffset;
    public RenderEffect renderEffect;
    public final Resources resources;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public float shadowElevation;
    public boolean shouldManuallySetCenterPivot;
    public long size;
    public long spotShadowColor;
    public float translationX;
    public float translationY;
    public final ViewLayer viewLayer;
    public int x;
    public int y;

    public GraphicsViewLayer(DrawChildContainer drawChildContainer) {
        CanvasHolder canvasHolder = new CanvasHolder();
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        this.layerContainer = drawChildContainer;
        this.canvasHolder = canvasHolder;
        ViewLayer viewLayer = new ViewLayer(drawChildContainer, canvasHolder, canvasDrawScope);
        this.viewLayer = viewLayer;
        this.resources = drawChildContainer.getResources();
        this.clipRect = new Rect();
        drawChildContainer.addView(viewLayer);
        viewLayer.setClipBounds(null);
        this.size = 0L;
        View.generateViewId();
        this.blendMode = (byte) 3;
        this.compositingStrategy = 0;
        this.alpha = 1.0f;
        this.pivotOffset = 9205357640488583168L;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.ambientShadowColor = -72057594037927936L;
        this.spotShadowColor = -72057594037927936L;
    }

    /* JADX INFO: renamed from: applyCompositingLayer-Wpw9cng, reason: not valid java name */
    public final void m572applyCompositingLayerWpw9cng(int i) {
        Paint paint = this.layerPaint;
        ViewLayer viewLayer = this.viewLayer;
        boolean z = true;
        if (i == 1) {
            viewLayer.setLayerType(2, paint);
        } else if (i == 2) {
            viewLayer.setLayerType(0, paint);
            z = false;
        } else {
            viewLayer.setLayerType(0, paint);
        }
        viewLayer.setCanUseCompositingLayer$ui_graphics(z);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final Matrix calculateMatrix() {
        return this.viewLayer.getMatrix();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void discardDisplayList() {
        this.layerContainer.removeViewInLayout(this.viewLayer);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void draw(Canvas canvas) {
        Rect rect;
        boolean z = this.clipBoundsInvalidated;
        ViewLayer viewLayer = this.viewLayer;
        if (z) {
            if ((this.clipToBounds || viewLayer.getClipToOutline()) && !this.outlineIsProvided) {
                rect = this.clipRect;
                rect.left = 0;
                rect.top = 0;
                rect.right = viewLayer.getWidth();
                rect.bottom = viewLayer.getHeight();
            } else {
                rect = null;
            }
            viewLayer.setClipBounds(rect);
        }
        android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        if (((AndroidCanvas) canvas).internalCanvas.isHardwareAccelerated()) {
            this.layerContainer.drawChild$ui_graphics(canvas, viewLayer, viewLayer.getDrawingTime());
        }
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
        return this.viewLayer.getCameraDistance() / this.resources.getDisplayMetrics().densityDpi;
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

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2) {
        ViewLayer viewLayer = this.viewLayer;
        ViewParent parent = viewLayer.getParent();
        DrawChildContainer drawChildContainer = this.layerContainer;
        if (parent == null) {
            drawChildContainer.addView(viewLayer);
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(this.outsetLeft)) << 32) | (((long) Float.floatToRawIntBits(this.outsetTop)) & 4294967295L);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
        viewLayer.density = density;
        viewLayer.layoutDirection = layoutDirection;
        viewLayer.drawBlock = textKt$$ExternalSyntheticLambda2;
        viewLayer.parentLayer = graphicsLayer;
        viewLayer.outsetLeft = fIntBitsToFloat;
        viewLayer.outsetTop = fIntBitsToFloat2;
        if (viewLayer.isAttachedToWindow()) {
            viewLayer.setVisibility(4);
            viewLayer.setVisibility(0);
            try {
                AndroidCanvas androidCanvas = this.canvasHolder.androidCanvas;
                GraphicsViewLayer$Companion$PlaceholderCanvas$1 graphicsViewLayer$Companion$PlaceholderCanvas$1 = PlaceholderCanvas;
                android.graphics.Canvas canvas = androidCanvas.internalCanvas;
                androidCanvas.internalCanvas = graphicsViewLayer$Companion$PlaceholderCanvas$1;
                drawChildContainer.drawChild$ui_graphics(androidCanvas, viewLayer, viewLayer.getDrawingTime());
                androidCanvas.internalCanvas = canvas;
            } catch (ClassCastException unused) {
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setAlpha(float f) {
        this.alpha = f;
        this.viewLayer.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA */
    public final void mo563setAmbientShadowColor8_81llA(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.ambientShadowColor = j;
            HandlerCompat$Api28Impl.setOutlineAmbientShadowColor(this.viewLayer, ColorKt.m498toArgb8_81llA(j));
        }
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
        paint.setXfermode(new PorterDuffXfermode(CanvasZHelper.m477toPorterDuffModes9anfk8(i)));
        updateLayerProperties$2();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setCameraDistance(float f) {
        this.viewLayer.setCameraDistance(f * this.resources.getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setClip(boolean z) {
        boolean z2 = false;
        this.clipToBounds = z && !this.outlineIsProvided;
        this.clipBoundsInvalidated = true;
        if (z && this.outlineIsProvided) {
            z2 = true;
        }
        this.viewLayer.setClipToOutline(z2);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setColorFilter() {
        Paint paint = this.layerPaint;
        if (paint == null) {
            paint = new Paint();
            this.layerPaint = paint;
        }
        paint.setColorFilter(null);
        updateLayerProperties$2();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng */
    public final void mo565setCompositingStrategyWpw9cng(int i) {
        this.compositingStrategy = i;
        updateLayerProperties$2();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setOutline-O0kMr_c */
    public final void mo566setOutlineO0kMr_c(Outline outline, long j) {
        ViewLayer viewLayer = this.viewLayer;
        viewLayer.layerOutline = outline;
        viewLayer.invalidateOutline();
        if ((this.clipToBounds || viewLayer.getClipToOutline()) && outline != null) {
            viewLayer.setClipToOutline(true);
            if (this.clipToBounds) {
                this.clipToBounds = false;
                this.clipBoundsInvalidated = true;
            }
        }
        this.outlineIsProvided = outline != null;
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
        updateLayerLayout();
        if (z) {
            updatePivot$2();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M */
    public final void mo567setPivotOffsetk4lQ0M(long j) {
        this.pivotOffset = j;
        this.shouldManuallySetCenterPivot = (j & 9223372034707292159L) == 9205357640488583168L;
        updatePivot$2();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPosition-H0pRuoY */
    public final void mo568setPositionH0pRuoY(int i, int i2, long j) {
        if (!IntSize.m810equalsimpl0(this.size, j)) {
            this.x = i;
            this.y = i2;
            this.size = j;
            updateLayerLayout();
            return;
        }
        int i3 = this.x;
        ViewLayer viewLayer = this.viewLayer;
        if (i3 != i) {
            viewLayer.offsetLeftAndRight(i - i3);
        }
        int i4 = this.y;
        if (i4 != i2) {
            viewLayer.offsetTopAndBottom(i2 - i4);
        }
        this.x = i;
        this.y = i2;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            DisplayCompat.setRenderEffect(this.viewLayer, renderEffect);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRotationX() {
        this.viewLayer.setRotationX(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRotationY() {
        this.viewLayer.setRotationY(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRotationZ(float f) {
        this.rotationZ = f;
        this.viewLayer.setRotation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setScaleX(float f) {
        this.scaleX = f;
        this.viewLayer.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setScaleY(float f) {
        this.scaleY = f;
        this.viewLayer.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setShadowElevation(float f) {
        this.shadowElevation = f;
        this.viewLayer.setElevation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA */
    public final void mo569setSpotShadowColor8_81llA(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.spotShadowColor = j;
            HandlerCompat$Api28Impl.setOutlineSpotShadowColor(this.viewLayer, ColorKt.m498toArgb8_81llA(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setTranslationX(float f) {
        this.translationX = f;
        this.viewLayer.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setTranslationY(float f) {
        this.translationY = f;
        this.viewLayer.setTranslationY(f);
    }

    public final void updateLayerLayout() {
        boolean z = this.clipToBounds;
        ViewLayer viewLayer = this.viewLayer;
        if (z || viewLayer.getClipToOutline()) {
            this.clipBoundsInvalidated = true;
        }
        int i = this.x;
        int i2 = i - this.outsetLeft;
        int i3 = this.y;
        int i4 = i3 - this.outsetTop;
        long j = this.size;
        viewLayer.layout(i2, i4, i + ((int) (j >> 32)) + this.outsetRight, i3 + ((int) (j & 4294967295L)) + this.outsetBottom);
    }

    public final void updateLayerProperties$2() {
        int i = this.compositingStrategy;
        if (i != 1 && this.blendMode == 3) {
            m572applyCompositingLayerWpw9cng(i);
        } else {
            m572applyCompositingLayerWpw9cng(1);
        }
    }

    public final void updatePivot$2() {
        boolean z = this.shouldManuallySetCenterPivot;
        ViewLayer viewLayer = this.viewLayer;
        if (z || Offset.m434equalsimpl0(this.pivotOffset, 9205357640488583168L)) {
            viewLayer.setPivotX((((int) (this.size >> 32)) / 2.0f) + this.outsetLeft);
            viewLayer.setPivotY((((int) (this.size & 4294967295L)) / 2.0f) + this.outsetTop);
        } else {
            viewLayer.setPivotX(Float.intBitsToFloat((int) (this.pivotOffset >> 32)) + this.outsetLeft);
            viewLayer.setPivotY(Float.intBitsToFloat((int) (this.pivotOffset & 4294967295L)) + this.outsetTop);
        }
    }
}
