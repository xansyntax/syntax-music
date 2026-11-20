package androidx.compose.ui.graphics.layer;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.os.BuildCompat;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okhttp3.Cache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayer {
    public Outline androidOutline;
    public boolean clip;
    public final GraphicsLayerImpl impl;
    public ColorKt internalOutline;
    public boolean isReleased;
    public AndroidPath outlinePath;
    public int outsetBottom;
    public int outsetLeft;
    public int outsetRight;
    public int outsetTop;
    public int parentLayerUsages;
    public RectF pathBounds;
    public long pivotOffset;
    public AndroidPath roundRectClipPath;
    public float roundRectCornerRadius;
    public long size;
    public CanvasDrawScope softwareDrawScope;
    public AndroidPaint softwareLayerPaint;
    public long topLeft;
    public boolean usePathForClip;
    public Density density = DrawContextKt.DefaultDensity;
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;
    public Function1 drawBlock = new ComposedModifierKt$$ExternalSyntheticLambda0(5);
    public final TextKt$$ExternalSyntheticLambda2 clipDrawBlock = new TextKt$$ExternalSyntheticLambda2(21, this);
    public boolean outlineDirty = true;
    public long roundRectOutlineTopLeft = 0;
    public long roundRectOutlineSize = 9205357640488583168L;
    public final Cache.RealCacheRequest childDependenciesTracker = new Cache.RealCacheRequest();

    static {
        Intrinsics.areEqual(Build.FINGERPRINT, "robolectric");
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl) {
        this.impl = graphicsLayerImpl;
        graphicsLayerImpl.setClip(false);
        this.topLeft = 0L;
        this.size = 0L;
        this.pivotOffset = 9205357640488583168L;
    }

    public final void configureOutlineAndClip() {
        Outline outline;
        if (this.outlineDirty) {
            boolean z = this.clip;
            Outline outline2 = null;
            GraphicsLayerImpl graphicsLayerImpl = this.impl;
            if (z || graphicsLayerImpl.getShadowElevation() > CropImageView.DEFAULT_ASPECT_RATIO) {
                AndroidPath androidPath = this.outlinePath;
                if (androidPath != null) {
                    RectF rectF = this.pathBounds;
                    if (rectF == null) {
                        rectF = new RectF();
                        this.pathBounds = rectF;
                    }
                    boolean z2 = androidPath instanceof AndroidPath;
                    if (!z2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Path");
                        return;
                    }
                    Path path = androidPath.internalPath;
                    path.computeBounds(rectF, false);
                    int i = Build.VERSION.SDK_INT;
                    if (i > 28 || path.isConvex()) {
                        outline = this.androidOutline;
                        if (outline == null) {
                            outline = new Outline();
                            this.androidOutline = outline;
                        }
                        if (i >= 30) {
                            BuildCompat.Api30Impl.setPath(outline, androidPath);
                        } else {
                            if (!z2) {
                                PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Path");
                                return;
                            }
                            outline.setConvexPath(path);
                        }
                        outline.offset(this.outsetLeft, this.outsetTop);
                        this.usePathForClip = !outline.canClip();
                    } else {
                        Outline outline3 = this.androidOutline;
                        if (outline3 != null) {
                            outline3.setEmpty();
                        }
                        this.usePathForClip = true;
                        outline = null;
                    }
                    this.outlinePath = androidPath;
                    if (outline != null) {
                        outline.setAlpha(graphicsLayerImpl.getAlpha());
                        outline2 = outline;
                    }
                    graphicsLayerImpl.mo566setOutlineO0kMr_c(outline2, (4294967295L & ((long) Math.round(rectF.height()))) | (((long) Math.round(rectF.width())) << 32));
                    if (this.usePathForClip && this.clip) {
                        graphicsLayerImpl.setClip(false);
                        graphicsLayerImpl.discardDisplayList();
                    } else {
                        graphicsLayerImpl.setClip(this.clip);
                    }
                } else {
                    graphicsLayerImpl.setClip(this.clip);
                    Outline outline4 = this.androidOutline;
                    if (outline4 == null) {
                        outline4 = new Outline();
                        this.androidOutline = outline4;
                    }
                    Outline outline5 = outline4;
                    long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(this.size);
                    long j = this.roundRectOutlineTopLeft;
                    long j2 = this.roundRectOutlineSize;
                    long j3 = j2 == 9205357640488583168L ? jM876toSizeozmzZPI : j2;
                    int i2 = (int) (j >> 32);
                    int i3 = (int) (j & 4294967295L);
                    outline5.setRoundRect(Math.round(Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat(i3)), Math.round(Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat((int) (4294967295L & j3)) + Float.intBitsToFloat(i3)), this.roundRectCornerRadius);
                    outline5.setAlpha(graphicsLayerImpl.getAlpha());
                    graphicsLayerImpl.mo566setOutlineO0kMr_c(outline5, SizeKt.m870roundToIntSizeuvyYCjk(j3));
                }
            } else {
                graphicsLayerImpl.setClip(false);
                graphicsLayerImpl.mo566setOutlineO0kMr_c(null, 0L);
            }
        }
        this.outlineDirty = false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x006a A[LOOP:0: B:14:0x002d->B:24:0x006a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x006d A[EDGE_INSN: B:29:0x006d->B:25:0x006d BREAK  A[LOOP:0: B:14:0x002d->B:24:0x006a], SYNTHETIC] */
    public final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            Cache.RealCacheRequest realCacheRequest = this.childDependenciesTracker;
            GraphicsLayer graphicsLayer = (GraphicsLayer) realCacheRequest.editor;
            if (graphicsLayer != null) {
                graphicsLayer.parentLayerUsages--;
                graphicsLayer.discardContentIfReleasedAndHaveNoParentLayerUsages();
                realCacheRequest.editor = null;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) realCacheRequest.body;
            if (mutableScatterSet != null) {
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i != length) {
                                break;
                                break;
                            }
                            i++;
                        } else {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    GraphicsLayer graphicsLayer2 = (GraphicsLayer) objArr[(i << 3) + i3];
                                    graphicsLayer2.parentLayerUsages--;
                                    graphicsLayer2.discardContentIfReleasedAndHaveNoParentLayerUsages();
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            } else if (i != length) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                mutableScatterSet.clear();
            }
            this.impl.discardDisplayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0096 A[LOOP:0: B:20:0x0059->B:30:0x0096, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0099 A[EDGE_INSN: B:34:0x0099->B:31:0x0099 BREAK  A[LOOP:0: B:20:0x0059->B:30:0x0096], SYNTHETIC] */
    public final void drawWithChildTracking(DrawScope drawScope) {
        Cache.RealCacheRequest realCacheRequest = this.childDependenciesTracker;
        realCacheRequest.cacheOut = (GraphicsLayer) realCacheRequest.editor;
        MutableScatterSet mutableScatterSet = (MutableScatterSet) realCacheRequest.body;
        if (mutableScatterSet != null && mutableScatterSet.isNotEmpty()) {
            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) realCacheRequest.this$0;
            if (mutableScatterSet2 == null) {
                MutableScatterSet mutableScatterSet3 = ScatterSetKt.EmptyScatterSet;
                mutableScatterSet2 = new MutableScatterSet();
                realCacheRequest.this$0 = mutableScatterSet2;
            }
            mutableScatterSet2.plusAssign(mutableScatterSet);
            mutableScatterSet.clear();
        }
        realCacheRequest.done = true;
        this.drawBlock.invoke(drawScope);
        realCacheRequest.done = false;
        GraphicsLayer graphicsLayer = (GraphicsLayer) realCacheRequest.cacheOut;
        if (graphicsLayer != null) {
            graphicsLayer.parentLayerUsages--;
            graphicsLayer.discardContentIfReleasedAndHaveNoParentLayerUsages();
        }
        MutableScatterSet mutableScatterSet4 = (MutableScatterSet) realCacheRequest.this$0;
        if (mutableScatterSet4 == null || !mutableScatterSet4.isNotEmpty()) {
            return;
        }
        Object[] objArr = mutableScatterSet4.elements;
        long[] jArr = mutableScatterSet4.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            GraphicsLayer graphicsLayer2 = (GraphicsLayer) objArr[(i << 3) + i3];
                            graphicsLayer2.parentLayerUsages--;
                            graphicsLayer2.discardContentIfReleasedAndHaveNoParentLayerUsages();
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        mutableScatterSet4.clear();
    }

    public final ColorKt getOutline() {
        ColorKt outline$Rectangle;
        ColorKt colorKt = this.internalOutline;
        AndroidPath androidPath = this.outlinePath;
        if (colorKt != null) {
            return colorKt;
        }
        if (androidPath != null) {
            Outline$Generic outline$Generic = new Outline$Generic(androidPath);
            this.internalOutline = outline$Generic;
            return outline$Generic;
        }
        long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(this.size);
        long j = this.roundRectOutlineTopLeft;
        long j2 = this.roundRectOutlineSize;
        if (j2 != 9205357640488583168L) {
            jM876toSizeozmzZPI = j2;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jM876toSizeozmzZPI >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jM876toSizeozmzZPI & 4294967295L)) + fIntBitsToFloat2;
        float f = this.roundRectCornerRadius;
        if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
            outline$Rectangle = new Outline$Rounded(MathKt.m1873RoundRectgG7oq9Y(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, (((long) Float.floatToRawIntBits(f)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(f)))));
        } else {
            outline$Rectangle = new Outline$Rectangle(new Rect(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        }
        this.internalOutline = outline$Rectangle;
        return outline$Rectangle;
    }

    /* JADX INFO: renamed from: record-mL-hObY, reason: not valid java name */
    public final void m557recordmLhObY(Density density, LayoutDirection layoutDirection, long j, Function1 function1) {
        boolean zM810equalsimpl0 = IntSize.m810equalsimpl0(this.size, j);
        GraphicsLayerImpl graphicsLayerImpl = this.impl;
        if (!zM810equalsimpl0) {
            this.size = j;
            long j2 = this.topLeft;
            graphicsLayerImpl.mo568setPositionH0pRuoY((int) (j2 >> 32), (int) (j2 & 4294967295L), j);
            if (this.roundRectOutlineSize == 9205357640488583168L) {
                this.outlineDirty = true;
                configureOutlineAndClip();
            }
        }
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = function1;
        graphicsLayerImpl.record(density, layoutDirection, this, this.clipDrawBlock);
    }

    public final void setAlpha(float f) {
        GraphicsLayerImpl graphicsLayerImpl = this.impl;
        if (graphicsLayerImpl.getAlpha() == f) {
            return;
        }
        graphicsLayerImpl.setAlpha(f);
    }

    public final void setClip(boolean z) {
        if (this.clip != z) {
            this.clip = z;
            this.outlineDirty = true;
            configureOutlineAndClip();
        }
    }

    /* JADX INFO: renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m558setRoundRectOutlineTNW_H78(long j, long j2, float f) {
        float f2 = this.outsetLeft;
        long jM439plusMKHz9U = Offset.m439plusMKHz9U(j, (((long) Float.floatToRawIntBits(this.outsetTop)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        if (Offset.m434equalsimpl0(this.roundRectOutlineTopLeft, jM439plusMKHz9U) && Size.m447equalsimpl0(this.roundRectOutlineSize, j2) && this.roundRectCornerRadius == f && this.outlinePath == null) {
            return;
        }
        this.internalOutline = null;
        this.outlinePath = null;
        this.outlineDirty = true;
        this.usePathForClip = false;
        this.roundRectOutlineTopLeft = jM439plusMKHz9U;
        this.roundRectOutlineSize = j2;
        this.roundRectCornerRadius = f;
        configureOutlineAndClip();
    }
}
