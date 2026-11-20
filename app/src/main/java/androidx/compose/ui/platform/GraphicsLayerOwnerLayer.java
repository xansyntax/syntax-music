package androidx.compose.ui.platform;

import android.view.ViewParent;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerOwnerLayer implements OwnedLayer {
    public final GraphicsContext context;
    public Function2 drawBlock;
    public boolean drawnWithEnabledZ;
    public GraphicsLayer graphicsLayer;
    public Function0 invalidateParentLayer;
    public float[] inverseMatrixCache;
    public boolean isDestroyed;
    public boolean isDirty;
    public boolean isInverseMatrixDirty;
    public boolean isMatrixDirty;
    public int mutatedFields;
    public ColorKt outline;
    public final AndroidComposeView ownerView;
    public long size = 9223372034707292159L;
    public final float[] matrixCache = Matrix.m507constructorimpl$default();
    public Density density = LifecyclesKt.Density$default();
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;
    public final CanvasDrawScope scope = new CanvasDrawScope();
    public long transformOrigin = ColorKt.TransformOrigin(0.5f, 0.5f);
    public boolean isIdentity = true;
    public final DiskLruCache$$ExternalSyntheticLambda0 recordLambda = new DiskLruCache$$ExternalSyntheticLambda0(2, this);

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2 function2, Function0 function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
    }

    /* JADX INFO: renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    public final float[] m704getInverseMatrix3i98HWw() {
        float[] fArrM507constructorimpl$default = this.inverseMatrixCache;
        if (fArrM507constructorimpl$default == null) {
            fArrM507constructorimpl$default = Matrix.m507constructorimpl$default();
            this.inverseMatrixCache = fArrM507constructorimpl$default;
        }
        if (this.isInverseMatrixDirty) {
            this.isInverseMatrixDirty = false;
            float[] fArrM705getMatrixsQKQjiQ = m705getMatrixsQKQjiQ();
            if (this.isIdentity) {
                return fArrM705getMatrixsQKQjiQ;
            }
            if (!InvertMatrixKt.m709invertToJiSxe2E(fArrM705getMatrixsQKQjiQ, fArrM507constructorimpl$default)) {
                fArrM507constructorimpl$default[0] = Float.NaN;
                return null;
            }
        } else if (Float.isNaN(fArrM507constructorimpl$default[0])) {
            return null;
        }
        return fArrM507constructorimpl$default;
    }

    /* JADX INFO: renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    public final float[] m705getMatrixsQKQjiQ() {
        boolean z = this.isMatrixDirty;
        float[] fArr = this.matrixCache;
        if (z) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            long jM881getCenteruvyYCjk = graphicsLayer.pivotOffset;
            GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
            if ((9223372034707292159L & jM881getCenteruvyYCjk) == 9205357640488583168L) {
                jM881getCenteruvyYCjk = FileSystemsKt.m881getCenteruvyYCjk(SizeKt.m876toSizeozmzZPI(this.size));
            }
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jM881getCenteruvyYCjk >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM881getCenteruvyYCjk & 4294967295L));
            float translationX = graphicsLayerImpl.getTranslationX();
            float translationY = graphicsLayerImpl.getTranslationY();
            float rotationX = graphicsLayerImpl.getRotationX();
            float rotationY = graphicsLayerImpl.getRotationY();
            float rotationZ = graphicsLayerImpl.getRotationZ();
            float scaleX = graphicsLayerImpl.getScaleX();
            float scaleY = graphicsLayerImpl.getScaleY();
            double d = ((double) rotationX) * 0.017453292519943295d;
            float fSin = (float) Math.sin(d);
            float fCos = (float) Math.cos(d);
            float f = -fSin;
            float f2 = (translationY * fCos) - (CropImageView.DEFAULT_ASPECT_RATIO * fSin);
            float f3 = (CropImageView.DEFAULT_ASPECT_RATIO * fCos) + (translationY * fSin);
            double d2 = ((double) rotationY) * 0.017453292519943295d;
            float fSin2 = (float) Math.sin(d2);
            float fCos2 = (float) Math.cos(d2);
            float f4 = -fSin2;
            float f5 = fSin * fSin2;
            float f6 = fSin * fCos2;
            float f7 = fCos * fSin2;
            float f8 = fCos * fCos2;
            float f9 = (f3 * fSin2) + (translationX * fCos2);
            float f10 = (f3 * fCos2) + ((-translationX) * fSin2);
            double d3 = ((double) rotationZ) * 0.017453292519943295d;
            float fSin3 = (float) Math.sin(d3);
            float fCos3 = (float) Math.cos(d3);
            float f11 = -fSin3;
            float f12 = (fCos3 * f5) + (f11 * fCos2);
            float f13 = (f5 * fSin3) + (fCos2 * fCos3);
            float f14 = fSin3 * fCos;
            float f15 = f13 * scaleX;
            float f16 = f14 * scaleX;
            float f17 = ((fSin3 * f6) + (fCos3 * f4)) * scaleX;
            float f18 = f12 * scaleY;
            float f19 = fCos * fCos3 * scaleY;
            float f20 = ((fCos3 * f6) + (f11 * f4)) * scaleY;
            float f21 = f7 * 1.0f;
            float f22 = f * 1.0f;
            float f23 = f8 * 1.0f;
            if (fArr.length >= 16) {
                fArr[0] = f15;
                fArr[1] = f16;
                fArr[2] = f17;
                fArr[3] = 0.0f;
                fArr[4] = f18;
                fArr[5] = f19;
                fArr[6] = f20;
                fArr[7] = 0.0f;
                fArr[8] = f21;
                fArr[9] = f22;
                fArr[10] = f23;
                fArr[11] = 0.0f;
                float f24 = -fIntBitsToFloat;
                fArr[12] = ((f15 * f24) - (fIntBitsToFloat2 * f18)) + f9 + fIntBitsToFloat;
                fArr[13] = ((f16 * f24) - (fIntBitsToFloat2 * f19)) + f2 + fIntBitsToFloat2;
                fArr[14] = ((f24 * f17) - (fIntBitsToFloat2 * f20)) + f10;
                fArr[15] = 1.0f;
            }
            this.isMatrixDirty = false;
            this.isIdentity = ColorKt.m492isIdentity58bKbWc(fArr);
        }
        return fArr;
    }

    public final void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    /* JADX INFO: renamed from: move--gyyYBs, reason: not valid java name */
    public final void m706movegyyYBs(long j) {
        boolean zIsArrEnabled$ui = AndroidComposeView.isArrEnabled$ui();
        AndroidComposeView androidComposeView = this.ownerView;
        if (zIsArrEnabled$ui) {
            androidComposeView.voteFrameRate(-4.0f);
        }
        GraphicsLayer graphicsLayer = this.graphicsLayer;
        if (!IntOffset.m804equalsimpl0(graphicsLayer.topLeft, j)) {
            graphicsLayer.topLeft = j;
            graphicsLayer.impl.mo568setPositionH0pRuoY((int) (j >> 32), (int) (j & 4294967295L), graphicsLayer.size);
        }
        ViewParent parent = androidComposeView.getParent();
        if (parent != null) {
            parent.onDescendantInvalidated(androidComposeView, androidComposeView);
        }
    }

    /* JADX INFO: renamed from: resize-ozmzZPI, reason: not valid java name */
    public final void m707resizeozmzZPI(long j) {
        if (IntSize.m810equalsimpl0(j, this.size)) {
            return;
        }
        if (AndroidComposeView.isArrEnabled$ui()) {
            this.ownerView.voteFrameRate(-4.0f);
        }
        this.size = j;
        invalidate();
    }

    public final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            AndroidComposeView androidComposeView = this.ownerView;
            MutableObjectList mutableObjectList = androidComposeView.dirtyLayers;
            boolean z2 = androidComposeView.isDrawingContent;
            if (!z) {
                if (z2) {
                    return;
                }
                mutableObjectList.remove(this);
                MutableObjectList mutableObjectList2 = androidComposeView.postponedDirtyLayers;
                if (mutableObjectList2 != null) {
                    mutableObjectList2.remove(this);
                    return;
                }
                return;
            }
            if (!z2) {
                mutableObjectList.add(this);
                return;
            }
            MutableObjectList mutableObjectList3 = androidComposeView.postponedDirtyLayers;
            if (mutableObjectList3 == null) {
                mutableObjectList3 = new MutableObjectList();
                androidComposeView.postponedDirtyLayers = mutableObjectList3;
            }
            mutableObjectList3.add(this);
        }
    }

    public final void updateDisplayList() {
        AndroidComposeView.isArrEnabled$ui();
        if (this.isDirty) {
            if (!TransformOrigin.m519equalsimpl0(this.transformOrigin, ColorKt.TransformOrigin(0.5f, 0.5f)) && !IntSize.m810equalsimpl0(this.graphicsLayer.size, this.size)) {
                GraphicsLayer graphicsLayer = this.graphicsLayer;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.transformOrigin >> 32)) * ((int) (this.size >> 32));
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (this.transformOrigin & 4294967295L)) * ((int) (this.size & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
                if (!Offset.m434equalsimpl0(graphicsLayer.pivotOffset, jFloatToRawIntBits)) {
                    graphicsLayer.pivotOffset = jFloatToRawIntBits;
                    graphicsLayer.impl.mo567setPivotOffsetk4lQ0M(jFloatToRawIntBits);
                }
            }
            this.graphicsLayer.m557recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }
}
