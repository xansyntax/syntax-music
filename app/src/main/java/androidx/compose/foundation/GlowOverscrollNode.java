package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GlowOverscrollNode extends DelegatingNode implements DrawModifierNode {
    public final EdgeEffectWrapper edgeEffectWrapper;
    public final PaddingValuesImpl glowDrawPadding;
    public final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public GlowOverscrollNode(SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper, PaddingValuesImpl paddingValuesImpl) {
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.glowDrawPadding = paddingValuesImpl;
        delegate(suspendingPointerInputModifierNodeImpl);
    }

    /* JADX INFO: renamed from: drawWithRotationAndOffset-ubNVwUQ, reason: not valid java name */
    public static boolean m37drawWithRotationAndOffsetubNVwUQ(float f, long j, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(f);
        canvas.translate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean zM37drawWithRotationAndOffsetubNVwUQ;
        char c;
        long j;
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jMo556getSizeNHjbRc = canvasDrawScope.mo556getSizeNHjbRc();
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.overscrollEffect;
        androidEdgeEffectOverscrollEffect.m36updateSizeuvyYCjk$foundation(jMo556getSizeNHjbRc);
        if (Size.m449isEmptyimpl(canvasDrawScope.mo556getSizeNHjbRc())) {
            layoutNodeDrawScope.drawContent();
            return;
        }
        layoutNodeDrawScope.drawContent();
        androidEdgeEffectOverscrollEffect.redrawSignal.getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvasDrawScope.drawContext.getCanvas());
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        boolean zIsAnimating = EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect);
        PaddingValuesImpl paddingValuesImpl = this.glowDrawPadding;
        if (zIsAnimating) {
            zM37drawWithRotationAndOffsetubNVwUQ = m37drawWithRotationAndOffsetubNVwUQ(270.0f, (((long) Float.floatToRawIntBits(layoutNodeDrawScope.mo81toPx0680j_4(paddingValuesImpl.mo123calculateLeftPaddingu2uoSUM(layoutNodeDrawScope.getLayoutDirection())))) & 4294967295L) | (((long) Float.floatToRawIntBits(-Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)))) << 32), edgeEffectWrapper.getOrCreateLeftEffect(), nativeCanvas);
        } else {
            zM37drawWithRotationAndOffsetubNVwUQ = false;
        }
        if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
            c = ' ';
            j = 4294967295L;
            zM37drawWithRotationAndOffsetubNVwUQ = m37drawWithRotationAndOffsetubNVwUQ(CropImageView.DEFAULT_ASPECT_RATIO, (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(layoutNodeDrawScope.mo81toPx0680j_4(paddingValuesImpl.top))) & 4294967295L), edgeEffectWrapper.getOrCreateTopEffect(), nativeCanvas) || zM37drawWithRotationAndOffsetubNVwUQ;
        } else {
            c = ' ';
            j = 4294967295L;
        }
        if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
            zM37drawWithRotationAndOffsetubNVwUQ = m37drawWithRotationAndOffsetubNVwUQ(90.0f, (((long) Float.floatToRawIntBits(layoutNodeDrawScope.mo81toPx0680j_4(paddingValuesImpl.mo124calculateRightPaddingu2uoSUM(layoutNodeDrawScope.getLayoutDirection())) + (-((float) MathKt.roundToInt(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> c))))))) & j) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << c), edgeEffectWrapper.getOrCreateRightEffect(), nativeCanvas) || zM37drawWithRotationAndOffsetubNVwUQ;
        }
        if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
            EdgeEffect orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
            zM37drawWithRotationAndOffsetubNVwUQ = m37drawWithRotationAndOffsetubNVwUQ(180.0f, (((long) Float.floatToRawIntBits(-Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> c)))) << c) | (((long) Float.floatToRawIntBits((-Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & j))) + layoutNodeDrawScope.mo81toPx0680j_4(paddingValuesImpl.bottom))) & j), orCreateBottomEffect, nativeCanvas) || zM37drawWithRotationAndOffsetubNVwUQ;
        }
        if (zM37drawWithRotationAndOffsetubNVwUQ) {
            androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
        }
    }
}
