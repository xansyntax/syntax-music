package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline1;
import androidx.emoji2.text.EmojiProcessor;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StretchOverscrollNode extends DelegatingNode implements DrawModifierNode {
    public RenderNode _renderNode;
    public final EdgeEffectWrapper edgeEffectWrapper;
    public final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public StretchOverscrollNode(SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper) {
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        delegate(suspendingPointerInputModifierNodeImpl);
    }

    public static boolean drawWithRotation(float f, EdgeEffect edgeEffect, Canvas canvas) {
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(f);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01e8 A[PHI: r20
      0x01e8: PHI (r20v2 boolean) = (r20v1 boolean), (r20v11 boolean) binds: [B:92:0x019d, B:100:0x01b8] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean zDrawWithRotation;
        boolean z;
        char c;
        float f;
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jMo556getSizeNHjbRc = canvasDrawScope.mo556getSizeNHjbRc();
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.overscrollEffect;
        androidEdgeEffectOverscrollEffect.m36updateSizeuvyYCjk$foundation(jMo556getSizeNHjbRc);
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvasDrawScope.drawContext.getCanvas());
        androidEdgeEffectOverscrollEffect.redrawSignal.getValue();
        if (Size.m449isEmptyimpl(canvasDrawScope.mo556getSizeNHjbRc())) {
            layoutNodeDrawScope.drawContent();
            return;
        }
        boolean zIsHardwareAccelerated = nativeCanvas.isHardwareAccelerated();
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        if (!zIsHardwareAccelerated) {
            EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
            if (edgeEffect != null) {
                edgeEffect.finish();
            }
            EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
            if (edgeEffect2 != null) {
                edgeEffect2.finish();
            }
            EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
            if (edgeEffect3 != null) {
                edgeEffect3.finish();
            }
            EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
            if (edgeEffect4 != null) {
                edgeEffect4.finish();
            }
            EdgeEffect edgeEffect5 = edgeEffectWrapper.topEffectNegation;
            if (edgeEffect5 != null) {
                edgeEffect5.finish();
            }
            EdgeEffect edgeEffect6 = edgeEffectWrapper.bottomEffectNegation;
            if (edgeEffect6 != null) {
                edgeEffect6.finish();
            }
            EdgeEffect edgeEffect7 = edgeEffectWrapper.leftEffectNegation;
            if (edgeEffect7 != null) {
                edgeEffect7.finish();
            }
            EdgeEffect edgeEffect8 = edgeEffectWrapper.rightEffectNegation;
            if (edgeEffect8 != null) {
                edgeEffect8.finish();
            }
            layoutNodeDrawScope.drawContent();
            return;
        }
        float fMo75roundToPx0680j_4 = canvasDrawScope.mo75roundToPx0680j_4(30.0f);
        boolean z2 = EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffectNegation) || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffectNegation);
        boolean z3 = EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffectNegation) || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffectNegation);
        if (z2 && z3) {
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight());
        } else if (z2) {
            getRenderNode().setPosition(0, 0, (MathKt.roundToInt(fMo75roundToPx0680j_4) * 2) + nativeCanvas.getWidth(), nativeCanvas.getHeight());
        } else {
            if (!z3) {
                layoutNodeDrawScope.drawContent();
                return;
            }
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), (MathKt.roundToInt(fMo75roundToPx0680j_4) * 2) + nativeCanvas.getHeight());
        }
        RecordingCanvas recordingCanvasBeginRecording = getRenderNode().beginRecording();
        boolean zIsStretched = EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffectNegation);
        Orientation orientation = Orientation.Horizontal;
        if (zIsStretched) {
            EdgeEffect edgeEffectCreateEdgeEffect = edgeEffectWrapper.leftEffectNegation;
            if (edgeEffectCreateEdgeEffect == null) {
                edgeEffectCreateEdgeEffect = edgeEffectWrapper.createEdgeEffect(orientation);
                edgeEffectWrapper.leftEffectNegation = edgeEffectCreateEdgeEffect;
            }
            drawWithRotation(90.0f, edgeEffectCreateEdgeEffect, recordingCanvasBeginRecording);
            edgeEffectCreateEdgeEffect.finish();
        }
        if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect)) {
            EdgeEffect orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
            zDrawWithRotation = drawWithRotation(270.0f, orCreateLeftEffect, recordingCanvasBeginRecording);
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect)) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (androidEdgeEffectOverscrollEffect.m31displacementF1C5BW0$foundation() & 4294967295L));
                EdgeEffect edgeEffectCreateEdgeEffect2 = edgeEffectWrapper.leftEffectNegation;
                if (edgeEffectCreateEdgeEffect2 == null) {
                    edgeEffectCreateEdgeEffect2 = edgeEffectWrapper.createEdgeEffect(orientation);
                    edgeEffectWrapper.leftEffectNegation = edgeEffectCreateEdgeEffect2;
                }
                int i = Build.VERSION.SDK_INT;
                float distance = i >= 31 ? Api31Impl.getDistance(orCreateLeftEffect) : CropImageView.DEFAULT_ASPECT_RATIO;
                float f2 = 1.0f - fIntBitsToFloat;
                if (i >= 31) {
                    Api31Impl.onPullDistance(edgeEffectCreateEdgeEffect2, distance, f2);
                } else {
                    edgeEffectCreateEdgeEffect2.onPull(distance, f2);
                }
            }
        } else {
            zDrawWithRotation = false;
        }
        boolean zIsStretched2 = EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffectNegation);
        Orientation orientation2 = Orientation.Vertical;
        if (zIsStretched2) {
            EdgeEffect edgeEffectCreateEdgeEffect3 = edgeEffectWrapper.topEffectNegation;
            if (edgeEffectCreateEdgeEffect3 == null) {
                edgeEffectCreateEdgeEffect3 = edgeEffectWrapper.createEdgeEffect(orientation2);
                edgeEffectWrapper.topEffectNegation = edgeEffectCreateEdgeEffect3;
            }
            drawWithRotation(180.0f, edgeEffectCreateEdgeEffect3, recordingCanvasBeginRecording);
            edgeEffectCreateEdgeEffect3.finish();
        }
        if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
            EdgeEffect orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
            zDrawWithRotation = drawWithRotation(CropImageView.DEFAULT_ASPECT_RATIO, orCreateTopEffect, recordingCanvasBeginRecording) || zDrawWithRotation;
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect)) {
                z = z3;
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (androidEdgeEffectOverscrollEffect.m31displacementF1C5BW0$foundation() >> 32));
                EdgeEffect edgeEffectCreateEdgeEffect4 = edgeEffectWrapper.topEffectNegation;
                if (edgeEffectCreateEdgeEffect4 == null) {
                    edgeEffectCreateEdgeEffect4 = edgeEffectWrapper.createEdgeEffect(orientation2);
                    edgeEffectWrapper.topEffectNegation = edgeEffectCreateEdgeEffect4;
                }
                c = ' ';
                int i2 = Build.VERSION.SDK_INT;
                float distance2 = i2 >= 31 ? Api31Impl.getDistance(orCreateTopEffect) : CropImageView.DEFAULT_ASPECT_RATIO;
                if (i2 >= 31) {
                    Api31Impl.onPullDistance(edgeEffectCreateEdgeEffect4, distance2, fIntBitsToFloat2);
                } else {
                    edgeEffectCreateEdgeEffect4.onPull(distance2, fIntBitsToFloat2);
                }
            } else {
                z = z3;
                c = ' ';
            }
        } else {
            z = z3;
            c = ' ';
        }
        if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffectNegation)) {
            EdgeEffect edgeEffectCreateEdgeEffect5 = edgeEffectWrapper.rightEffectNegation;
            if (edgeEffectCreateEdgeEffect5 == null) {
                edgeEffectCreateEdgeEffect5 = edgeEffectWrapper.createEdgeEffect(orientation);
                edgeEffectWrapper.rightEffectNegation = edgeEffectCreateEdgeEffect5;
            }
            drawWithRotation(270.0f, edgeEffectCreateEdgeEffect5, recordingCanvasBeginRecording);
            edgeEffectCreateEdgeEffect5.finish();
        }
        if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
            EdgeEffect orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
            zDrawWithRotation = drawWithRotation(90.0f, orCreateRightEffect, recordingCanvasBeginRecording) || zDrawWithRotation;
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (androidEdgeEffectOverscrollEffect.m31displacementF1C5BW0$foundation() & 4294967295L));
                EdgeEffect edgeEffectCreateEdgeEffect6 = edgeEffectWrapper.rightEffectNegation;
                if (edgeEffectCreateEdgeEffect6 == null) {
                    edgeEffectCreateEdgeEffect6 = edgeEffectWrapper.createEdgeEffect(orientation);
                    edgeEffectWrapper.rightEffectNegation = edgeEffectCreateEdgeEffect6;
                }
                int i3 = Build.VERSION.SDK_INT;
                float distance3 = i3 >= 31 ? Api31Impl.getDistance(orCreateRightEffect) : CropImageView.DEFAULT_ASPECT_RATIO;
                if (i3 >= 31) {
                    Api31Impl.onPullDistance(edgeEffectCreateEdgeEffect6, distance3, fIntBitsToFloat3);
                } else {
                    edgeEffectCreateEdgeEffect6.onPull(distance3, fIntBitsToFloat3);
                }
            }
        }
        if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffectNegation)) {
            EdgeEffect edgeEffectCreateEdgeEffect7 = edgeEffectWrapper.bottomEffectNegation;
            if (edgeEffectCreateEdgeEffect7 == null) {
                edgeEffectCreateEdgeEffect7 = edgeEffectWrapper.createEdgeEffect(orientation2);
                edgeEffectWrapper.bottomEffectNegation = edgeEffectCreateEdgeEffect7;
            }
            f = CropImageView.DEFAULT_ASPECT_RATIO;
            drawWithRotation(CropImageView.DEFAULT_ASPECT_RATIO, edgeEffectCreateEdgeEffect7, recordingCanvasBeginRecording);
            edgeEffectCreateEdgeEffect7.finish();
        } else {
            f = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
            EdgeEffect orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
            boolean z4 = drawWithRotation(180.0f, orCreateBottomEffect, recordingCanvasBeginRecording) || zDrawWithRotation;
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect)) {
                float fIntBitsToFloat4 = Float.intBitsToFloat((int) (androidEdgeEffectOverscrollEffect.m31displacementF1C5BW0$foundation() >> c));
                EdgeEffect edgeEffectCreateEdgeEffect8 = edgeEffectWrapper.bottomEffectNegation;
                if (edgeEffectCreateEdgeEffect8 == null) {
                    edgeEffectCreateEdgeEffect8 = edgeEffectWrapper.createEdgeEffect(orientation2);
                    edgeEffectWrapper.bottomEffectNegation = edgeEffectCreateEdgeEffect8;
                }
                int i4 = Build.VERSION.SDK_INT;
                float distance4 = i4 >= 31 ? Api31Impl.getDistance(orCreateBottomEffect) : f;
                float f3 = 1.0f - fIntBitsToFloat4;
                if (i4 >= 31) {
                    Api31Impl.onPullDistance(edgeEffectCreateEdgeEffect8, distance4, f3);
                } else {
                    edgeEffectCreateEdgeEffect8.onPull(distance4, f3);
                }
            }
            zDrawWithRotation = z4;
        }
        if (zDrawWithRotation) {
            androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
        }
        float f4 = z ? f : fMo75roundToPx0680j_4;
        if (z2) {
            fMo75roundToPx0680j_4 = f;
        }
        LayoutDirection layoutDirection = layoutNodeDrawScope.getLayoutDirection();
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.internalCanvas = recordingCanvasBeginRecording;
        long jMo556getSizeNHjbRc2 = canvasDrawScope.mo556getSizeNHjbRc();
        Density density = canvasDrawScope.drawContext.getDensity();
        LayoutDirection layoutDirection2 = canvasDrawScope.drawContext.getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvas = canvasDrawScope.drawContext.getCanvas();
        long jM831getSizeNHjbRc = canvasDrawScope.drawContext.m831getSizeNHjbRc();
        EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
        GraphicsLayer graphicsLayer = (GraphicsLayer) emojiProcessor.mMetadataRepo;
        emojiProcessor.setDensity(layoutNodeDrawScope);
        emojiProcessor.setLayoutDirection(layoutDirection);
        emojiProcessor.setCanvas(androidCanvas);
        emojiProcessor.m832setSizeuvyYCjk(jMo556getSizeNHjbRc2);
        emojiProcessor.mMetadataRepo = null;
        androidCanvas.save();
        try {
            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(f4, fMo75roundToPx0680j_4);
            try {
                layoutNodeDrawScope.drawContent();
                float f5 = -f4;
                float f6 = -fMo75roundToPx0680j_4;
                ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(f5, f6);
                androidCanvas.restore();
                EmojiProcessor emojiProcessor2 = canvasDrawScope.drawContext;
                emojiProcessor2.setDensity(density);
                emojiProcessor2.setLayoutDirection(layoutDirection2);
                emojiProcessor2.setCanvas(canvas);
                emojiProcessor2.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
                emojiProcessor2.mMetadataRepo = graphicsLayer;
                getRenderNode().endRecording();
                int iSave = nativeCanvas.save();
                nativeCanvas.translate(f5, f6);
                nativeCanvas.drawRenderNode(getRenderNode());
                nativeCanvas.restoreToCount(iSave);
            } catch (Throwable th) {
                ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-f4, -fMo75roundToPx0680j_4);
                throw th;
            }
        } catch (Throwable th2) {
            androidCanvas.restore();
            EmojiProcessor emojiProcessor3 = canvasDrawScope.drawContext;
            emojiProcessor3.setDensity(density);
            emojiProcessor3.setLayoutDirection(layoutDirection2);
            emojiProcessor3.setCanvas(canvas);
            emojiProcessor3.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
            emojiProcessor3.mMetadataRepo = graphicsLayer;
            throw th2;
        }
    }

    public final RenderNode getRenderNode() {
        RenderNode renderNode = this._renderNode;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNodeM = TypefaceCompat$$ExternalSyntheticApiModelOutline1.m();
        this._renderNode = renderNodeM;
        return renderNodeM;
    }
}
