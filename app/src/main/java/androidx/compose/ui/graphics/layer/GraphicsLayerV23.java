package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
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
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerV23 implements GraphicsLayerImpl {
    public static final AtomicBoolean needToValidateAccess = new AtomicBoolean(true);
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
    public long outlineSize;
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
    public boolean shouldManuallySetCenterPivot;
    public long size;
    public long spotShadowColor;
    public float translationX;
    public float translationY;
    public int x;
    public int y;

    public GraphicsLayerV23(AndroidComposeView androidComposeView, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        RenderNode renderNodeCreate = RenderNode.create("Compose", androidComposeView);
        this.renderNode = renderNodeCreate;
        this.size = 0L;
        this.outlineSize = 0L;
        if (needToValidateAccess.getAndSet(false)) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            if (Build.VERSION.SDK_INT >= 28) {
                RenderNodeVerificationHelper28.setAmbientShadowColor(renderNodeCreate, RenderNodeVerificationHelper28.getAmbientShadowColor(renderNodeCreate));
                RenderNodeVerificationHelper28.setSpotShadowColor(renderNodeCreate, RenderNodeVerificationHelper28.getSpotShadowColor(renderNodeCreate));
            }
            RenderNodeVerificationHelper24.discardDisplayList(renderNodeCreate);
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
        }
        renderNodeCreate.setClipToBounds(false);
        m570applyCompositingStrategyWpw9cng(0);
        this.compositingStrategy = 0;
        this.blendMode = (byte) 3;
        this.alpha = 1.0f;
        this.pivotOffset = 9205357640488583168L;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.ambientShadowColor = -72057594037927936L;
        this.spotShadowColor = -72057594037927936L;
        this.cameraDistance = 8.0f;
    }

    public final void applyClip() {
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

    /* JADX INFO: renamed from: applyCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m570applyCompositingStrategyWpw9cng(int i) {
        RenderNode renderNode = this.renderNode;
        if (i == 1) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        } else if (i == 2) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
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
        RenderNodeVerificationHelper24.discardDisplayList(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void draw(Canvas canvas) {
        android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        DisplayListCanvas displayListCanvas = ((AndroidCanvas) canvas).internalCanvas;
        displayListCanvas.getClass();
        displayListCanvas.drawRenderNode(this.renderNode);
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
        return this.renderNode.isValid();
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
    public final void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2) throws Throwable {
        DisplayListCanvas displayListCanvas;
        int i;
        int i2;
        Density density2;
        LayoutDirection layoutDirection2;
        Canvas canvas;
        long jM831getSizeNHjbRc;
        GraphicsLayer graphicsLayer2;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
        DisplayListCanvas displayListCanvasStart = this.renderNode.start(Math.max(((int) (this.size >> 32)) + this.outsetLeft + this.outsetRight, (int) (this.outlineSize >> 32)), Math.max(((int) (this.size & 4294967295L)) + this.outsetTop + this.outsetBottom, (int) (this.outlineSize & 4294967295L)));
        float f = this.outsetLeft;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(this.outsetTop)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
        try {
            AndroidCanvas androidCanvas = this.canvasHolder.androidCanvas;
            android.graphics.Canvas canvas2 = androidCanvas.internalCanvas;
            androidCanvas.internalCanvas = (android.graphics.Canvas) displayListCanvasStart;
            try {
                try {
                    if (this.outsetLeft <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        try {
                            if (this.outsetTop <= CropImageView.DEFAULT_ASPECT_RATIO) {
                                long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(this.size);
                                Density density3 = emojiProcessor.getDensity();
                                LayoutDirection layoutDirection3 = emojiProcessor.getLayoutDirection();
                                Canvas canvas3 = emojiProcessor.getCanvas();
                                canvas2 = canvas2;
                                long jM831getSizeNHjbRc2 = emojiProcessor.m831getSizeNHjbRc();
                                displayListCanvasStart = displayListCanvasStart;
                                GraphicsLayer graphicsLayer3 = (GraphicsLayer) emojiProcessor.mMetadataRepo;
                                emojiProcessor.setDensity(density);
                                emojiProcessor.setLayoutDirection(layoutDirection);
                                emojiProcessor.setCanvas(androidCanvas);
                                emojiProcessor.m832setSizeuvyYCjk(jM876toSizeozmzZPI);
                                emojiProcessor.mMetadataRepo = graphicsLayer;
                                androidCanvas.save();
                                try {
                                    textKt$$ExternalSyntheticLambda2.invoke(canvasDrawScope);
                                    androidCanvas.restore();
                                    emojiProcessor.setDensity(density3);
                                    emojiProcessor.setLayoutDirection(layoutDirection3);
                                    emojiProcessor.setCanvas(canvas3);
                                    emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                                    emojiProcessor.mMetadataRepo = graphicsLayer3;
                                } catch (Throwable th) {
                                    androidCanvas.restore();
                                    emojiProcessor.setDensity(density3);
                                    emojiProcessor.setLayoutDirection(layoutDirection3);
                                    emojiProcessor.setCanvas(canvas3);
                                    emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                                    emojiProcessor.mMetadataRepo = graphicsLayer3;
                                    throw th;
                                }
                            }
                            androidCanvas.internalCanvas = canvas2;
                            this.renderNode.end(displayListCanvasStart);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            displayListCanvasStart = displayListCanvasStart;
                            displayListCanvas = displayListCanvasStart;
                            this.renderNode.end(displayListCanvas);
                            throw th;
                        }
                    }
                    textKt$$ExternalSyntheticLambda2.invoke(canvasDrawScope);
                    androidCanvas.restore();
                    emojiProcessor.setDensity(density2);
                    emojiProcessor.setLayoutDirection(layoutDirection2);
                    emojiProcessor.setCanvas(canvas);
                    emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
                    emojiProcessor.mMetadataRepo = graphicsLayer2;
                    androidCanvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
                    androidCanvas.internalCanvas = canvas2;
                    this.renderNode.end(displayListCanvasStart);
                    return;
                } catch (Throwable th3) {
                    displayListCanvas = displayListCanvasStart;
                    try {
                        androidCanvas.restore();
                        emojiProcessor.setDensity(density2);
                        emojiProcessor.setLayoutDirection(layoutDirection2);
                        emojiProcessor.setCanvas(canvas);
                        emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
                        emojiProcessor.mMetadataRepo = graphicsLayer2;
                        throw th3;
                    } catch (Throwable th4) {
                        th = th4;
                        this.renderNode.end(displayListCanvas);
                        throw th;
                    }
                }
                i = (int) (jFloatToRawIntBits >> 32);
                i2 = (int) (jFloatToRawIntBits & 4294967295L);
                androidCanvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                long jM876toSizeozmzZPI2 = SizeKt.m876toSizeozmzZPI(this.size);
                density2 = emojiProcessor.getDensity();
                layoutDirection2 = emojiProcessor.getLayoutDirection();
                canvas = emojiProcessor.getCanvas();
                jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
                graphicsLayer2 = (GraphicsLayer) emojiProcessor.mMetadataRepo;
                emojiProcessor.setDensity(density);
                emojiProcessor.setLayoutDirection(layoutDirection);
                emojiProcessor.setCanvas(androidCanvas);
                emojiProcessor.m832setSizeuvyYCjk(jM876toSizeozmzZPI2);
                emojiProcessor.mMetadataRepo = graphicsLayer;
                androidCanvas.save();
            } catch (Throwable th5) {
                th = th5;
                displayListCanvas = displayListCanvasStart;
                this.renderNode.end(displayListCanvas);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            displayListCanvas = displayListCanvasStart;
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
        if (Build.VERSION.SDK_INT >= 28) {
            this.ambientShadowColor = j;
            RenderNodeVerificationHelper28.setAmbientShadowColor(this.renderNode, ColorKt.m498toArgb8_81llA(j));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setBlendMode-s9anfk8 */
    public final void mo564setBlendModes9anfk8(int i) {
        if (this.blendMode == i) {
            return;
        }
        this.blendMode = i;
        Paint paint = this.layerPaint;
        if (paint == null) {
            paint = new Paint();
            this.layerPaint = paint;
        }
        paint.setXfermode(new PorterDuffXfermode(CanvasZHelper.m477toPorterDuffModes9anfk8(i)));
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setCameraDistance(float f) {
        this.cameraDistance = f;
        this.renderNode.setCameraDistance(-f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setClip(boolean z) {
        this.clip = z;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setColorFilter() {
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng */
    public final void mo565setCompositingStrategyWpw9cng(int i) {
        this.compositingStrategy = i;
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setOutline-O0kMr_c */
    public final void mo566setOutlineO0kMr_c(Outline outline, long j) {
        this.outlineSize = j;
        this.renderNode.setOutline(outline);
        this.outlineIsProvided = outline != null;
        applyClip();
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
        updatePosition();
        if (z) {
            updatePivot();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M */
    public final void mo567setPivotOffsetk4lQ0M(long j) {
        this.pivotOffset = j;
        updatePivot();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPosition-H0pRuoY */
    public final void mo568setPositionH0pRuoY(int i, int i2, long j) {
        this.x = i;
        this.y = i2;
        boolean zM810equalsimpl0 = IntSize.m810equalsimpl0(this.size, j);
        this.size = j;
        updatePosition();
        if (zM810equalsimpl0) {
            return;
        }
        if (this.shouldManuallySetCenterPivot || Offset.m434equalsimpl0(this.pivotOffset, 9205357640488583168L)) {
            this.renderNode.setPivotX((((int) (j >> 32)) / 2.0f) + this.outsetLeft);
            this.renderNode.setPivotY((((int) (j & 4294967295L)) / 2.0f) + this.outsetTop);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
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
        this.renderNode.setRotation(f);
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
        if (Build.VERSION.SDK_INT >= 28) {
            this.spotShadowColor = j;
            RenderNodeVerificationHelper28.setSpotShadowColor(this.renderNode, ColorKt.m498toArgb8_81llA(j));
        }
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

    public final void updateLayerProperties() {
        int i = this.compositingStrategy;
        if (i != 1 && this.blendMode == 3) {
            m570applyCompositingStrategyWpw9cng(i);
        } else {
            m570applyCompositingStrategyWpw9cng(1);
        }
    }

    public final void updatePivot() {
        long j = this.pivotOffset;
        if ((9223372034707292159L & j) == 9205357640488583168L) {
            this.shouldManuallySetCenterPivot = true;
            this.renderNode.setPivotX((((int) (this.size >> 32)) / 2.0f) + this.outsetLeft);
            this.renderNode.setPivotY((((int) (4294967295L & this.size)) / 2.0f) + this.outsetTop);
        } else {
            this.shouldManuallySetCenterPivot = false;
            this.renderNode.setPivotX(Float.intBitsToFloat((int) (j >> 32)) + this.outsetLeft);
            this.renderNode.setPivotY(Float.intBitsToFloat((int) (this.pivotOffset & 4294967295L)) + this.outsetTop);
        }
    }

    public final void updatePosition() {
        RenderNode renderNode = this.renderNode;
        int i = this.x;
        int i2 = i - this.outsetLeft;
        int i3 = this.y;
        int i4 = i3 - this.outsetTop;
        long j = this.size;
        renderNode.setLeftTopRightBottom(i2, i4, i + ((int) (j >> 32)) + this.outsetRight, i3 + ((int) (j & 4294967295L)) + this.outsetBottom);
    }
}
