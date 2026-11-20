package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupLayout;
import androidx.emoji2.text.EmojiProcessor;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewLayer extends View {
    public static final PopupLayout.AnonymousClass2 LayerOutlineProvider = new PopupLayout.AnonymousClass2((byte) 2);
    public boolean canUseCompositingLayer;
    public final CanvasDrawScope canvasDrawScope;
    public final CanvasHolder canvasHolder;
    public Density density;
    public Function1 drawBlock;
    public boolean isInvalidated;
    public Outline layerOutline;
    public LayoutDirection layoutDirection;
    public float outsetLeft;
    public float outsetTop;
    public final DrawChildContainer ownerView;
    public GraphicsLayer parentLayer;

    public ViewLayer(DrawChildContainer drawChildContainer, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        super(drawChildContainer.getContext());
        this.ownerView = drawChildContainer;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        setOutlineProvider(LayerOutlineProvider);
        this.canUseCompositingLayer = true;
        this.density = DrawContextKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = GraphicsLayerImpl.Companion.DefaultDrawBlock;
        setWillNotDraw(false);
        setClipBounds(null);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
        float f = this.outsetLeft;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        CanvasHolder canvasHolder = this.canvasHolder;
        if (f > CropImageView.DEFAULT_ASPECT_RATIO || this.outsetTop > CropImageView.DEFAULT_ASPECT_RATIO) {
            int iSave = canvas.save();
            canvas.translate(this.outsetLeft, this.outsetTop);
            AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
            Canvas canvas2 = androidCanvas.internalCanvas;
            androidCanvas.internalCanvas = canvas;
            Density density = this.density;
            LayoutDirection layoutDirection = this.layoutDirection;
            float width = getWidth();
            long jFloatToRawIntBits = (4294967295L & ((long) Float.floatToRawIntBits(getHeight()))) | (Float.floatToRawIntBits(width) << 32);
            GraphicsLayer graphicsLayer = this.parentLayer;
            Function1 function1 = this.drawBlock;
            EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
            EmojiProcessor emojiProcessor2 = canvasDrawScope.drawContext;
            Density density2 = emojiProcessor.getDensity();
            LayoutDirection layoutDirection2 = emojiProcessor2.getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvas3 = emojiProcessor2.getCanvas();
            long jM831getSizeNHjbRc = emojiProcessor2.m831getSizeNHjbRc();
            GraphicsLayer graphicsLayer2 = (GraphicsLayer) emojiProcessor2.mMetadataRepo;
            emojiProcessor2.setDensity(density);
            emojiProcessor2.setLayoutDirection(layoutDirection);
            emojiProcessor2.setCanvas(androidCanvas);
            emojiProcessor2.m832setSizeuvyYCjk(jFloatToRawIntBits);
            emojiProcessor2.mMetadataRepo = graphicsLayer;
            androidCanvas.save();
            try {
                function1.invoke(canvasDrawScope);
                androidCanvas.restore();
                emojiProcessor2.setDensity(density2);
                emojiProcessor2.setLayoutDirection(layoutDirection2);
                emojiProcessor2.setCanvas(canvas3);
                emojiProcessor2.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
                emojiProcessor2.mMetadataRepo = graphicsLayer2;
                canvasHolder.androidCanvas.internalCanvas = canvas2;
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                androidCanvas.restore();
                emojiProcessor2.setDensity(density2);
                emojiProcessor2.setLayoutDirection(layoutDirection2);
                emojiProcessor2.setCanvas(canvas3);
                emojiProcessor2.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
                emojiProcessor2.mMetadataRepo = graphicsLayer2;
                throw th;
            }
        } else {
            AndroidCanvas androidCanvas2 = canvasHolder.androidCanvas;
            Canvas canvas4 = androidCanvas2.internalCanvas;
            androidCanvas2.internalCanvas = canvas;
            Density density3 = this.density;
            LayoutDirection layoutDirection3 = this.layoutDirection;
            float width2 = getWidth();
            long jFloatToRawIntBits2 = (4294967295L & ((long) Float.floatToRawIntBits(getHeight()))) | (Float.floatToRawIntBits(width2) << 32);
            GraphicsLayer graphicsLayer3 = this.parentLayer;
            Function1 function2 = this.drawBlock;
            EmojiProcessor emojiProcessor3 = canvasDrawScope.drawContext;
            EmojiProcessor emojiProcessor4 = canvasDrawScope.drawContext;
            Density density4 = emojiProcessor3.getDensity();
            LayoutDirection layoutDirection4 = emojiProcessor4.getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvas5 = emojiProcessor4.getCanvas();
            long jM831getSizeNHjbRc2 = emojiProcessor4.m831getSizeNHjbRc();
            GraphicsLayer graphicsLayer4 = (GraphicsLayer) emojiProcessor4.mMetadataRepo;
            emojiProcessor4.setDensity(density3);
            emojiProcessor4.setLayoutDirection(layoutDirection3);
            emojiProcessor4.setCanvas(androidCanvas2);
            emojiProcessor4.m832setSizeuvyYCjk(jFloatToRawIntBits2);
            emojiProcessor4.mMetadataRepo = graphicsLayer3;
            androidCanvas2.save();
            try {
                function2.invoke(canvasDrawScope);
                androidCanvas2.restore();
                emojiProcessor4.setDensity(density4);
                emojiProcessor4.setLayoutDirection(layoutDirection4);
                emojiProcessor4.setCanvas(canvas5);
                emojiProcessor4.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                emojiProcessor4.mMetadataRepo = graphicsLayer4;
                canvasHolder.androidCanvas.internalCanvas = canvas4;
            } catch (Throwable th2) {
                androidCanvas2.restore();
                emojiProcessor4.setDensity(density4);
                emojiProcessor4.setLayoutDirection(layoutDirection4);
                emojiProcessor4.setCanvas(canvas5);
                emojiProcessor4.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                emojiProcessor4.mMetadataRepo = graphicsLayer4;
                throw th2;
            }
        }
        this.isInvalidated = false;
    }

    public final boolean getCanUseCompositingLayer$ui_graphics() {
        return this.canUseCompositingLayer;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public final View getOwnerView() {
        return this.ownerView;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    @Override // android.view.View
    public final void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        this.isInvalidated = true;
        super.invalidate();
    }

    public final void setCanUseCompositingLayer$ui_graphics(boolean z) {
        if (this.canUseCompositingLayer != z) {
            this.canUseCompositingLayer = z;
            invalidate();
        }
    }

    public final void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    @Override // android.view.View
    public final void forceLayout() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
