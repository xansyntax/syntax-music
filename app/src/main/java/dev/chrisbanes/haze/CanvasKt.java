package dev.chrisbanes.haze;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.Surface;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import coil3.size.SizeKt;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CanvasKt {
    /* JADX INFO: renamed from: createScaledContentLayer-wZMzALA, reason: not valid java name */
    public static final GraphicsLayer m1538createScaledContentLayerwZMzALA(LayoutNodeDrawScope layoutNodeDrawScope, HazeEffectNode hazeEffectNode, float f, long j, long j2) {
        long jM870roundToIntSizeuvyYCjk = SizeKt.m870roundToIntSizeuvyYCjk(Size.m450times7Ah8Wj8(j, f));
        if (((int) (jM870roundToIntSizeuvyYCjk >> 32)) <= 0 || ((int) (4294967295L & jM870roundToIntSizeuvyYCjk)) <= 0) {
            return null;
        }
        GraphicsLayer graphicsLayerCreateGraphicsLayer = ((GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext)).createGraphicsLayer();
        layoutNodeDrawScope.m651recordJVtK1S4(jM870roundToIntSizeuvyYCjk, graphicsLayerCreateGraphicsLayer, new BlurEffectKt$$ExternalSyntheticLambda0(hazeEffectNode, f, j2));
        return graphicsLayerCreateGraphicsLayer;
    }

    public static final void drawContentSafely(LayoutNodeDrawScope layoutNodeDrawScope) throws Exception {
        try {
            layoutNodeDrawScope.drawContent();
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            if (!StringsKt.contains(message, "mViewFlags", false) && !StringsKt.contains(message, "LayoutNode", false)) {
                throw e;
            }
        }
    }

    public static final void drawGraphicsLayer(Surface surface, GraphicsLayer graphicsLayer, Density density, CanvasDrawScope canvasDrawScope) {
        Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
        try {
            canvasLockHardwareCanvas.getClass();
            canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
            LayoutDirection layoutDirection = drawParams.layoutDirection;
            Canvas canvas = AndroidCanvas_androidKt.EmptyCanvas;
            AndroidCanvas androidCanvas = new AndroidCanvas();
            androidCanvas.internalCanvas = canvasLockHardwareCanvas;
            float width = canvasLockHardwareCanvas.getWidth();
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(canvasLockHardwareCanvas.getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32);
            Density density2 = drawParams.density;
            LayoutDirection layoutDirection2 = drawParams.layoutDirection;
            androidx.compose.ui.graphics.Canvas canvas2 = drawParams.canvas;
            long j = drawParams.size;
            drawParams.density = density;
            drawParams.layoutDirection = layoutDirection;
            drawParams.canvas = androidCanvas;
            drawParams.size = jFloatToRawIntBits;
            androidCanvas.save();
            LifecyclesKt.drawLayer(canvasDrawScope, graphicsLayer);
            androidCanvas.restore();
            drawParams.density = density2;
            drawParams.layoutDirection = layoutDirection2;
            drawParams.canvas = canvas2;
            drawParams.size = j;
        } finally {
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
        }
    }

    /* JADX INFO: renamed from: drawScaledContent-LF441nw, reason: not valid java name */
    public static final void m1539drawScaledContentLF441nw(DrawScope drawScope, long j, long j2, boolean z, Function1 function1) {
        float fMax = Math.max(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)) / Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) / Float.intBitsToFloat((int) (j2 & 4294967295L)));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L));
        EmojiProcessor drawContext = drawScope.getDrawContext();
        long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawResult drawResult = (DrawResult) drawContext.mSpanFactory;
            if (z) {
                drawResult.m401clipRectN_I0leg(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat, fIntBitsToFloat2, 1);
            }
            if ((((9187343241974906880L ^ (j & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) != 0 || Offset.m434equalsimpl0(j, 0L)) {
                EmojiProcessor drawContext2 = drawScope.getDrawContext();
                long jM831getSizeNHjbRc2 = drawContext2.m831getSizeNHjbRc();
                drawContext2.getCanvas().save();
                try {
                    ((DrawResult) drawContext2.mSpanFactory).m403scale0AR0LA0(fMax, fMax, 0L);
                    function1.invoke(drawScope);
                    drawContext2.getCanvas().restore();
                    drawContext2.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                } catch (Throwable th) {
                    drawContext2.getCanvas().restore();
                    drawContext2.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                    throw th;
                }
            } else {
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j >> 32));
                float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & 4294967295L));
                ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(fIntBitsToFloat3, fIntBitsToFloat4);
                try {
                    EmojiProcessor drawContext3 = drawScope.getDrawContext();
                    long jM831getSizeNHjbRc3 = drawContext3.m831getSizeNHjbRc();
                    drawContext3.getCanvas().save();
                    try {
                        ((DrawResult) drawContext3.mSpanFactory).m403scale0AR0LA0(fMax, fMax, 0L);
                        function1.invoke(drawScope);
                        drawContext3.getCanvas().restore();
                        drawContext3.m832setSizeuvyYCjk(jM831getSizeNHjbRc3);
                        ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                    } catch (Throwable th2) {
                        drawContext3.getCanvas().restore();
                        drawContext3.m832setSizeuvyYCjk(jM831getSizeNHjbRc3);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                    throw th3;
                }
            }
            IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
        } catch (Throwable th4) {
            IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
            throw th4;
        }
    }

    /* JADX INFO: renamed from: drawScrim-DBWKusU, reason: not valid java name */
    public static final void m1540drawScrimDBWKusU(DrawScope drawScope, HazeTint hazeTint, CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, long j, long j2) {
        hazeTint.getClass();
        Brush brush = hazeTint.brush;
        if (brush != null) {
            DrawScope.m549drawRectAsUm42w$default(drawScope, brush, j, drawScope.mo556getSizeNHjbRc(), CropImageView.DEFAULT_ASPECT_RATIO, null, null, hazeTint.blendMode, 56);
        } else {
            DrawScope.m550drawRectnJ9OG0$default(drawScope, hazeTint.color, 0L, j2, CropImageView.DEFAULT_ASPECT_RATIO, hazeTint.blendMode, 58);
        }
    }

    public static Modifier hazeEffect$default(Modifier modifier, HazeState hazeState, Function1 function1) {
        HazeStyle hazeStyle = HazeStyle.Unspecified;
        modifier.getClass();
        hazeStyle.getClass();
        return modifier.then(new HazeEffectNodeElement(hazeState, hazeStyle, function1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [dev.chrisbanes.haze.HazeEffectNode] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v7, types: [dev.chrisbanes.haze.BlurEffect] */
    public static final void updateBlurEffectIfNeeded(HazeEffectNode hazeEffectNode, LayoutNodeDrawScope layoutNodeDrawScope) {
        ?? r4;
        Object failure;
        boolean z = Build.VERSION.SDK_INT >= 31 && AndroidCanvas_androidKt.getNativeCanvas(layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas()).isHardwareAccelerated();
        boolean zResolveBlurEnabled = HazeEffectNodeKt.resolveBlurEnabled(hazeEffectNode);
        if (zResolveBlurEnabled && z) {
            BlurEffect renderEffectBlurEffect = hazeEffectNode.blurEffect;
            if (!(renderEffectBlurEffect instanceof RenderEffectBlurEffect)) {
                renderEffectBlurEffect = new RenderEffectBlurEffect(hazeEffectNode);
            }
            hazeEffectNode.setBlurEffect$haze_release(renderEffectBlurEffect);
            return;
        }
        if (zResolveBlurEnabled) {
            BlurEffect blurEffect = hazeEffectNode.blurEffect;
            if (!(blurEffect instanceof RenderScriptBlurEffect)) {
                Object obj = null;
                if (RenderScriptBlurEffect.isEnabled) {
                    try {
                        r4 = blurEffect;
                        failure = new RenderScriptBlurEffect(hazeEffectNode);
                    } catch (Throwable th) {
                        failure = new Result.Failure(th);
                    }
                    if (Result.m1866exceptionOrNullimpl(failure) != null) {
                        RenderScriptBlurEffect.isEnabled = false;
                    }
                    obj = (RenderScriptBlurEffect) (failure instanceof Result.Failure ? null : failure);
                }
                r4 = blurEffect;
                r4 = obj;
            }
            if (r4 != 0) {
                hazeEffectNode.setBlurEffect$haze_release(r4);
                return;
            }
        }
        if (hazeEffectNode.blurEffect instanceof ScrimBlurEffect) {
            return;
        }
        hazeEffectNode.setBlurEffect$haze_release(new ScrimBlurEffect(hazeEffectNode));
    }
}
