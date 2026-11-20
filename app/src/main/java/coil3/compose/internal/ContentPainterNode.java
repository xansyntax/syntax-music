package coil3.compose.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.emoji2.text.EmojiProcessor;
import coil3.compose.AsyncImagePainter;
import coil3.compose.ConstraintsSizeResolver;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.EmptyMap;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode, SemanticsModifierNode {
    public Alignment alignment;
    public float alpha = 1.0f;
    public boolean clipToBounds = true;
    public ConstraintsSizeResolver constraintSizeResolver;
    public ContentScale contentScale;
    public final AsyncImagePainter painter;

    public ContentPainterNode(AsyncImagePainter asyncImagePainter, Alignment alignment, ContentScale contentScale, ConstraintsSizeResolver constraintsSizeResolver) {
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.constraintSizeResolver = constraintsSizeResolver;
        this.painter = asyncImagePainter;
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU$1, reason: not valid java name */
    public final long m854calculateScaledSizeE7KxVPU$1(long j) {
        if (Size.m449isEmptyimpl(j)) {
            return 0L;
        }
        long jMo573getIntrinsicSizeNHjbRc = this.painter.mo573getIntrinsicSizeNHjbRc();
        if (jMo573getIntrinsicSizeNHjbRc != 9205357640488583168L) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc >> 32));
            if (Math.abs(fIntBitsToFloat) > Float.MAX_VALUE) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
            }
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc & 4294967295L));
            if (Math.abs(fIntBitsToFloat2) > Float.MAX_VALUE) {
                fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
            }
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
            long jMo597computeScaleFactorH7hwNQA = this.contentScale.mo597computeScaleFactorH7hwNQA(jFloatToRawIntBits, j);
            if (Math.abs(Float.intBitsToFloat((int) (jMo597computeScaleFactorH7hwNQA >> 32))) <= Float.MAX_VALUE && Math.abs(Float.intBitsToFloat((int) (4294967295L & jMo597computeScaleFactorH7hwNQA))) <= Float.MAX_VALUE) {
                return RulerKt.m625timesUQTWf7w(jFloatToRawIntBits, jMo597computeScaleFactorH7hwNQA);
            }
        }
        return j;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jM854calculateScaledSizeE7KxVPU$1 = m854calculateScaledSizeE7KxVPU$1(canvasDrawScope.mo556getSizeNHjbRc());
        long jMo397alignKFBX0sM = this.alignment.mo397alignKFBX0sM(UtilsKt.m856toIntSizeuvyYCjk(jM854calculateScaledSizeE7KxVPU$1), UtilsKt.m856toIntSizeuvyYCjk(canvasDrawScope.mo556getSizeNHjbRc()), layoutNodeDrawScope.getLayoutDirection());
        int i = (int) (jMo397alignKFBX0sM >> 32);
        int i2 = (int) (jMo397alignKFBX0sM & 4294967295L);
        EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
        long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
        emojiProcessor.getCanvas().save();
        try {
            DrawResult drawResult = (DrawResult) emojiProcessor.mSpanFactory;
            if (this.clipToBounds) {
                DrawResult.m400clipRectN_I0leg$default(drawResult, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 31);
            }
            drawResult.translate(i, i2);
            this.painter.m575drawx_KDEd0(layoutNodeDrawScope, jM854calculateScaledSizeE7KxVPU$1, this.alpha, null);
            emojiProcessor.getCanvas().restore();
            emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
            layoutNodeDrawScope.drawContent();
        } catch (Throwable th) {
            IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
            throw th;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m853setConstraintsBRTryo0(jConstraints$default);
        }
        if (this.painter.mo573getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.maxIntrinsicHeight(i);
        }
        long jM855modifyConstraintsZezNO4M$1 = m855modifyConstraintsZezNO4M$1(jConstraints$default);
        return Math.max(Constraints.m785getMinHeightimpl(jM855modifyConstraintsZezNO4M$1), measurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m853setConstraintsBRTryo0(jConstraints$default);
        }
        if (this.painter.mo573getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.maxIntrinsicWidth(i);
        }
        long jM855modifyConstraintsZezNO4M$1 = m855modifyConstraintsZezNO4M$1(jConstraints$default);
        return Math.max(Constraints.m786getMinWidthimpl(jM855modifyConstraintsZezNO4M$1), measurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m853setConstraintsBRTryo0(j);
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(m855modifyConstraintsZezNO4M$1(j));
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 24));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m853setConstraintsBRTryo0(jConstraints$default);
        }
        if (this.painter.mo573getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.minIntrinsicHeight(i);
        }
        long jM855modifyConstraintsZezNO4M$1 = m855modifyConstraintsZezNO4M$1(jConstraints$default);
        return Math.max(Constraints.m785getMinHeightimpl(jM855modifyConstraintsZezNO4M$1), measurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m853setConstraintsBRTryo0(jConstraints$default);
        }
        if (this.painter.mo573getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.minIntrinsicWidth(i);
        }
        long jM855modifyConstraintsZezNO4M$1 = m855modifyConstraintsZezNO4M$1(jConstraints$default);
        return Math.max(Constraints.m786getMinWidthimpl(jM855modifyConstraintsZezNO4M$1), measurable.minIntrinsicWidth(i));
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M$1, reason: not valid java name */
    public final long m855modifyConstraintsZezNO4M$1(long j) {
        float fM786getMinWidthimpl;
        int iM785getMinHeightimpl;
        float f;
        boolean zM782getHasFixedWidthimpl = Constraints.m782getHasFixedWidthimpl(j);
        boolean zM781getHasFixedHeightimpl = Constraints.m781getHasFixedHeightimpl(j);
        if (!zM782getHasFixedWidthimpl || !zM781getHasFixedHeightimpl) {
            boolean z = Constraints.m780getHasBoundedWidthimpl(j) && Constraints.m779getHasBoundedHeightimpl(j);
            AsyncImagePainter asyncImagePainter = this.painter;
            long jMo573getIntrinsicSizeNHjbRc = asyncImagePainter.mo573getIntrinsicSizeNHjbRc();
            if (jMo573getIntrinsicSizeNHjbRc != 9205357640488583168L) {
                if (!z || (!zM782getHasFixedWidthimpl && !zM781getHasFixedHeightimpl)) {
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc >> 32));
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc & 4294967295L));
                    if (Math.abs(fIntBitsToFloat) <= Float.MAX_VALUE) {
                        int i = UtilsKt.$r8$clinit;
                        float fM786getMinWidthimpl2 = Constraints.m786getMinWidthimpl(j);
                        float fM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
                        if (fIntBitsToFloat < fM786getMinWidthimpl2) {
                            fIntBitsToFloat = fM786getMinWidthimpl2;
                        }
                        if (fIntBitsToFloat <= fM784getMaxWidthimpl) {
                            fM784getMaxWidthimpl = fIntBitsToFloat;
                        }
                        fM786getMinWidthimpl = fM784getMaxWidthimpl;
                    } else {
                        fM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
                    }
                    if (Math.abs(fIntBitsToFloat2) <= Float.MAX_VALUE) {
                        int i2 = UtilsKt.$r8$clinit;
                        float fM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
                        float fM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
                        if (fIntBitsToFloat2 < fM785getMinHeightimpl) {
                            fIntBitsToFloat2 = fM785getMinHeightimpl;
                        }
                        if (fIntBitsToFloat2 <= fM783getMaxHeightimpl) {
                            fM783getMaxHeightimpl = fIntBitsToFloat2;
                        }
                        f = fM783getMaxHeightimpl;
                    } else {
                        iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
                    }
                    long jM854calculateScaledSizeE7KxVPU$1 = m854calculateScaledSizeE7KxVPU$1((((long) Float.floatToRawIntBits(f)) & 4294967295L) | (((long) Float.floatToRawIntBits(fM786getMinWidthimpl)) << 32));
                    return Constraints.m777copyZbe2FdA$default(ConstraintsKt.m792constrainWidthK40F9xA(MathKt.roundToInt(Float.intBitsToFloat((int) (jM854calculateScaledSizeE7KxVPU$1 >> 32))), j), 0, ConstraintsKt.m791constrainHeightK40F9xA(MathKt.roundToInt(Float.intBitsToFloat((int) (jM854calculateScaledSizeE7KxVPU$1 & 4294967295L))), j), 0, 10, j);
                }
                fM786getMinWidthimpl = Constraints.m784getMaxWidthimpl(j);
                iM785getMinHeightimpl = Constraints.m783getMaxHeightimpl(j);
                f = iM785getMinHeightimpl;
                long jM854calculateScaledSizeE7KxVPU$2 = m854calculateScaledSizeE7KxVPU$1((((long) Float.floatToRawIntBits(f)) & 4294967295L) | (((long) Float.floatToRawIntBits(fM786getMinWidthimpl)) << 32));
                return Constraints.m777copyZbe2FdA$default(ConstraintsKt.m792constrainWidthK40F9xA(MathKt.roundToInt(Float.intBitsToFloat((int) (jM854calculateScaledSizeE7KxVPU$2 >> 32))), j), 0, ConstraintsKt.m791constrainHeightK40F9xA(MathKt.roundToInt(Float.intBitsToFloat((int) (jM854calculateScaledSizeE7KxVPU$2 & 4294967295L))), j), 0, 10, j);
            }
            if (z && ((AsyncImagePainter.State) asyncImagePainter.state.$$delegate_0.getValue()).getPainter() != null) {
                return Constraints.m777copyZbe2FdA$default(Constraints.m784getMaxWidthimpl(j), 0, Constraints.m783getMaxHeightimpl(j), 0, 10, j);
            }
        }
        return j;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        CoroutineScope coroutineScope = getCoroutineScope();
        AsyncImagePainter asyncImagePainter = this.painter;
        asyncImagePainter.scope = coroutineScope;
        asyncImagePainter.onRemembered();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.painter.onForgotten();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        this.painter.set_input$io_coil_kt_coil3_coil_compose_core(null);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }
}
