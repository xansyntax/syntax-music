package androidx.compose.ui.graphics.vector;

import android.graphics.Bitmap;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VectorComponent extends VNode {
    public final DrawCache cacheDrawScope;
    public final VectorComponent$$ExternalSyntheticLambda0 drawVectorBlock;
    public final ParcelableSnapshotMutableState intrinsicColorFilter$delegate;
    public Function0 invalidateCallback;
    public boolean isDirty;
    public String name;
    public long previousDrawSize;
    public final GroupComponent root;
    public float rootScaleX;
    public float rootScaleY;
    public BlendModeColorFilter tintFilter;
    public final ParcelableSnapshotMutableState viewportSize$delegate;

    public VectorComponent(GroupComponent groupComponent) {
        this.root = groupComponent;
        groupComponent.invalidateListener = new VectorComponent$$ExternalSyntheticLambda0(this, (byte) 0);
        this.name = "";
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = new TextKt$$ExternalSyntheticLambda3((byte) 20);
        this.intrinsicColorFilter$delegate = Stack.mutableStateOf$default(null);
        this.viewportSize$delegate = Stack.mutableStateOf$default(new Size(0L));
        this.previousDrawSize = 9205357640488583168L;
        this.rootScaleX = 1.0f;
        this.rootScaleY = 1.0f;
        this.drawVectorBlock = new VectorComponent$$ExternalSyntheticLambda0(this, (byte) 1);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003b  */
    /* JADX WARN: Code duplicated, block: B:34:0x005c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x005e  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:51:0x0107  */
    public final void draw(DrawScope drawScope, float f, BlendModeColorFilter blendModeColorFilter) {
        int i;
        BlendModeColorFilter blendModeColorFilter2;
        AndroidImageBitmap androidImageBitmapM488ImageBitmapx__hDU$default;
        char c;
        long j;
        long jColor;
        BlendModeColorFilter blendModeColorFilter3;
        int i2;
        int i3;
        GroupComponent groupComponent = this.root;
        boolean z = groupComponent.isTintable;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.intrinsicColorFilter$delegate;
        if (!z || groupComponent.tintColor == 16) {
            i = 0;
        } else {
            BlendModeColorFilter blendModeColorFilter4 = (BlendModeColorFilter) parcelableSnapshotMutableState.getValue();
            if (!(blendModeColorFilter4 instanceof BlendModeColorFilter) ? blendModeColorFilter4 == null : (i3 = blendModeColorFilter4.blendMode) == 5 || i3 == 3) {
                i = 0;
            } else if (!(blendModeColorFilter instanceof BlendModeColorFilter) ? blendModeColorFilter == null : (i2 = blendModeColorFilter.blendMode) == 5 || i2 == 3) {
                i = 0;
            } else {
                i = 1;
            }
        }
        boolean z2 = this.isDirty;
        DrawCache drawCache = this.cacheDrawScope;
        if (z2 || !Size.m447equalsimpl0(this.previousDrawSize, drawScope.mo556getSizeNHjbRc())) {
            if (i == 1) {
                jColor = groupComponent.tintColor;
                if (Color.m481getAlphaimpl(jColor) != 1.0f) {
                    jColor = ColorKt.Color(Color.m485getRedimpl(jColor), Color.m484getGreenimpl(jColor), Color.m482getBlueimpl(jColor), 1.0f, Color.m483getColorSpaceimpl(jColor));
                }
                blendModeColorFilter2 = new BlendModeColorFilter(jColor, 5);
            } else {
                blendModeColorFilter2 = null;
            }
            this.tintFilter = blendModeColorFilter2;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.viewportSize$delegate;
            this.rootScaleX = fIntBitsToFloat / Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState2.getValue()).packedValue >> 32));
            this.rootScaleY = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) / Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState2.getValue()).packedValue & 4294967295L));
            long jCeil = (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))))) << 32) | (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L))))) & 4294967295L);
            LayoutDirection layoutDirection = drawScope.getLayoutDirection();
            androidImageBitmapM488ImageBitmapx__hDU$default = drawCache.mCachedImage;
            AndroidCanvas androidCanvasActualCanvas = drawCache.cachedCanvas;
            if (androidImageBitmapM488ImageBitmapx__hDU$default != null || androidCanvasActualCanvas == null) {
                c = ' ';
                j = 4294967295L;
            } else {
                int i4 = (int) (jCeil >> 32);
                Bitmap bitmap = androidImageBitmapM488ImageBitmapx__hDU$default.bitmap;
                c = ' ';
                j = 4294967295L;
                if (i4 > bitmap.getWidth() || ((int) (jCeil & 4294967295L)) > bitmap.getHeight() || drawCache.config != i) {
                }
                drawCache.size = jCeil;
                CanvasDrawScope canvasDrawScope = drawCache.cacheScope;
                CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
                long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(jCeil);
                Density density = drawParams.density;
                LayoutDirection layoutDirection2 = drawParams.layoutDirection;
                Canvas canvas = drawParams.canvas;
                long j2 = drawParams.size;
                drawParams.density = drawScope;
                drawParams.layoutDirection = layoutDirection;
                drawParams.canvas = androidCanvasActualCanvas;
                drawParams.size = jM876toSizeozmzZPI;
                androidCanvasActualCanvas.save();
                DrawScope.m550drawRectnJ9OG0$default(canvasDrawScope, -72057594037927936L, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 62);
                this.drawVectorBlock.invoke(canvasDrawScope);
                androidCanvasActualCanvas.restore();
                drawParams.density = density;
                drawParams.layoutDirection = layoutDirection2;
                drawParams.canvas = canvas;
                drawParams.size = j2;
                androidImageBitmapM488ImageBitmapx__hDU$default.bitmap.prepareToDraw();
                this.isDirty = false;
                this.previousDrawSize = drawScope.mo556getSizeNHjbRc();
            }
            androidImageBitmapM488ImageBitmapx__hDU$default = ColorKt.m488ImageBitmapx__hDU$default((int) (jCeil >> c), (int) (jCeil & j), i, 24);
            androidCanvasActualCanvas = AndroidCanvas_androidKt.ActualCanvas(androidImageBitmapM488ImageBitmapx__hDU$default);
            drawCache.mCachedImage = androidImageBitmapM488ImageBitmapx__hDU$default;
            drawCache.cachedCanvas = androidCanvasActualCanvas;
            drawCache.config = i;
            drawCache.size = jCeil;
            CanvasDrawScope canvasDrawScope2 = drawCache.cacheScope;
            CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.drawParams;
            long jM876toSizeozmzZPI2 = SizeKt.m876toSizeozmzZPI(jCeil);
            Density density2 = drawParams2.density;
            LayoutDirection layoutDirection3 = drawParams2.layoutDirection;
            Canvas canvas2 = drawParams2.canvas;
            long j3 = drawParams2.size;
            drawParams2.density = drawScope;
            drawParams2.layoutDirection = layoutDirection;
            drawParams2.canvas = androidCanvasActualCanvas;
            drawParams2.size = jM876toSizeozmzZPI2;
            androidCanvasActualCanvas.save();
            DrawScope.m550drawRectnJ9OG0$default(canvasDrawScope2, -72057594037927936L, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 62);
            this.drawVectorBlock.invoke(canvasDrawScope2);
            androidCanvasActualCanvas.restore();
            drawParams2.density = density2;
            drawParams2.layoutDirection = layoutDirection3;
            drawParams2.canvas = canvas2;
            drawParams2.size = j3;
            androidImageBitmapM488ImageBitmapx__hDU$default.bitmap.prepareToDraw();
            this.isDirty = false;
            this.previousDrawSize = drawScope.mo556getSizeNHjbRc();
        } else {
            AndroidImageBitmap androidImageBitmap = drawCache.mCachedImage;
            if (i != (androidImageBitmap != null ? androidImageBitmap.m459getConfig_sVssgQ() : 0)) {
                if (i == 1) {
                    jColor = groupComponent.tintColor;
                    if (Color.m481getAlphaimpl(jColor) != 1.0f) {
                        jColor = ColorKt.Color(Color.m485getRedimpl(jColor), Color.m484getGreenimpl(jColor), Color.m482getBlueimpl(jColor), 1.0f, Color.m483getColorSpaceimpl(jColor));
                    }
                    blendModeColorFilter2 = new BlendModeColorFilter(jColor, 5);
                } else {
                    blendModeColorFilter2 = null;
                }
                this.tintFilter = blendModeColorFilter2;
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
                ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = this.viewportSize$delegate;
                this.rootScaleX = fIntBitsToFloat2 / Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState3.getValue()).packedValue >> 32));
                this.rootScaleY = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) / Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState3.getValue()).packedValue & 4294967295L));
                long jCeil2 = (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))))) << 32) | (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L))))) & 4294967295L);
                LayoutDirection layoutDirection4 = drawScope.getLayoutDirection();
                androidImageBitmapM488ImageBitmapx__hDU$default = drawCache.mCachedImage;
                AndroidCanvas androidCanvasActualCanvas2 = drawCache.cachedCanvas;
                if (androidImageBitmapM488ImageBitmapx__hDU$default != null) {
                    c = ' ';
                    j = 4294967295L;
                    androidImageBitmapM488ImageBitmapx__hDU$default = ColorKt.m488ImageBitmapx__hDU$default((int) (jCeil2 >> c), (int) (jCeil2 & j), i, 24);
                    androidCanvasActualCanvas2 = AndroidCanvas_androidKt.ActualCanvas(androidImageBitmapM488ImageBitmapx__hDU$default);
                    drawCache.mCachedImage = androidImageBitmapM488ImageBitmapx__hDU$default;
                    drawCache.cachedCanvas = androidCanvasActualCanvas2;
                    drawCache.config = i;
                } else {
                    c = ' ';
                    j = 4294967295L;
                    androidImageBitmapM488ImageBitmapx__hDU$default = ColorKt.m488ImageBitmapx__hDU$default((int) (jCeil2 >> c), (int) (jCeil2 & j), i, 24);
                    androidCanvasActualCanvas2 = AndroidCanvas_androidKt.ActualCanvas(androidImageBitmapM488ImageBitmapx__hDU$default);
                    drawCache.mCachedImage = androidImageBitmapM488ImageBitmapx__hDU$default;
                    drawCache.cachedCanvas = androidCanvasActualCanvas2;
                    drawCache.config = i;
                }
                drawCache.size = jCeil2;
                CanvasDrawScope canvasDrawScope3 = drawCache.cacheScope;
                CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope3.drawParams;
                long jM876toSizeozmzZPI3 = SizeKt.m876toSizeozmzZPI(jCeil2);
                Density density3 = drawParams3.density;
                LayoutDirection layoutDirection5 = drawParams3.layoutDirection;
                Canvas canvas3 = drawParams3.canvas;
                long j4 = drawParams3.size;
                drawParams3.density = drawScope;
                drawParams3.layoutDirection = layoutDirection4;
                drawParams3.canvas = androidCanvasActualCanvas2;
                drawParams3.size = jM876toSizeozmzZPI3;
                androidCanvasActualCanvas2.save();
                DrawScope.m550drawRectnJ9OG0$default(canvasDrawScope3, -72057594037927936L, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 62);
                this.drawVectorBlock.invoke(canvasDrawScope3);
                androidCanvasActualCanvas2.restore();
                drawParams3.density = density3;
                drawParams3.layoutDirection = layoutDirection5;
                drawParams3.canvas = canvas3;
                drawParams3.size = j4;
                androidImageBitmapM488ImageBitmapx__hDU$default.bitmap.prepareToDraw();
                this.isDirty = false;
                this.previousDrawSize = drawScope.mo556getSizeNHjbRc();
            }
        }
        if (blendModeColorFilter != null) {
            blendModeColorFilter3 = blendModeColorFilter;
        } else {
            blendModeColorFilter3 = ((BlendModeColorFilter) parcelableSnapshotMutableState.getValue()) != null ? (BlendModeColorFilter) parcelableSnapshotMutableState.getValue() : this.tintFilter;
        }
        AndroidImageBitmap androidImageBitmap2 = drawCache.mCachedImage;
        if (androidImageBitmap2 == null) {
            InlineClassHelperKt.throwIllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        DrawScope.m544drawImageAZ2fEMs$default(drawScope, androidImageBitmap2, drawCache.size, 0L, f, blendModeColorFilter3, 0, 858);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Params: \tname: ");
        sb.append(this.name);
        sb.append("\n\tviewportWidth: ");
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.viewportSize$delegate;
        sb.append(Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState.getValue()).packedValue >> 32)));
        sb.append("\n\tviewportHeight: ");
        sb.append(Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState.getValue()).packedValue & 4294967295L)));
        sb.append("\n");
        return sb.toString();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        draw(drawScope, 1.0f, null);
    }
}
