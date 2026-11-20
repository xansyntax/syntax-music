package androidx.compose.ui.draw;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    public Alignment alignment;
    public float alpha;
    public BlendModeColorFilter colorFilter;
    public ContentScale contentScale;
    public Painter painter;
    public boolean sizeToIntrinsics;

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    public static boolean m404hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        return !Size.m447equalsimpl0(j, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    public static boolean m405hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        return !Size.m447equalsimpl0(j, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jMo573getIntrinsicSizeNHjbRc = this.painter.mo573getIntrinsicSizeNHjbRc();
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(m405hasSpecifiedAndFiniteWidthuvyYCjk(jMo573getIntrinsicSizeNHjbRc) ? Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc >> 32)) : Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(m404hasSpecifiedAndFiniteHeightuvyYCjk(jMo573getIntrinsicSizeNHjbRc) ? Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc & 4294967295L)) : Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)))) & 4294967295L);
        long jM625timesUQTWf7w = (Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)) == CropImageView.DEFAULT_ASPECT_RATIO || Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) == CropImageView.DEFAULT_ASPECT_RATIO) ? 0L : RulerKt.m625timesUQTWf7w(jFloatToRawIntBits, this.contentScale.mo597computeScaleFactorH7hwNQA(jFloatToRawIntBits, canvasDrawScope.mo556getSizeNHjbRc()));
        long jMo397alignKFBX0sM = this.alignment.mo397alignKFBX0sM((((long) Math.round(Float.intBitsToFloat((int) (jM625timesUQTWf7w >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (jM625timesUQTWf7w & 4294967295L)))) & 4294967295L), (((long) Math.round(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)))) & 4294967295L), layoutNodeDrawScope.getLayoutDirection());
        float f = (int) (jMo397alignKFBX0sM >> 32);
        float f2 = (int) (jMo397alignKFBX0sM & 4294967295L);
        ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(f, f2);
        try {
            this.painter.m575drawx_KDEd0(layoutNodeDrawScope, jM625timesUQTWf7w, this.alpha, this.colorFilter);
            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-f, -f2);
            layoutNodeDrawScope.drawContent();
        } catch (Throwable th) {
            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-f, -f2);
            throw th;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo573getIntrinsicSizeNHjbRc() != 9205357640488583168L;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicHeight(i);
        }
        long jM406modifyConstraintsZezNO4M = m406modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13));
        return Math.max(Constraints.m785getMinHeightimpl(jM406modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicWidth(i);
        }
        long jM406modifyConstraintsZezNO4M = m406modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        return Math.max(Constraints.m786getMinWidthimpl(jM406modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(m406modifyConstraintsZezNO4M(j));
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 20));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicHeight(i);
        }
        long jM406modifyConstraintsZezNO4M = m406modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13));
        return Math.max(Constraints.m785getMinHeightimpl(jM406modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicWidth(i);
        }
        long jM406modifyConstraintsZezNO4M = m406modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        return Math.max(Constraints.m786getMinWidthimpl(jM406modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    public final long m406modifyConstraintsZezNO4M(long j) {
        boolean z = false;
        boolean z2 = Constraints.m780getHasBoundedWidthimpl(j) && Constraints.m779getHasBoundedHeightimpl(j);
        if (Constraints.m782getHasFixedWidthimpl(j) && Constraints.m781getHasFixedHeightimpl(j)) {
            z = true;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m777copyZbe2FdA$default(Constraints.m784getMaxWidthimpl(j), 0, Constraints.m783getMaxHeightimpl(j), 0, 10, j);
        }
        long jMo573getIntrinsicSizeNHjbRc = this.painter.mo573getIntrinsicSizeNHjbRc();
        int iRound = m405hasSpecifiedAndFiniteWidthuvyYCjk(jMo573getIntrinsicSizeNHjbRc) ? Math.round(Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc >> 32))) : Constraints.m786getMinWidthimpl(j);
        int iRound2 = m404hasSpecifiedAndFiniteHeightuvyYCjk(jMo573getIntrinsicSizeNHjbRc) ? Math.round(Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc & 4294967295L))) : Constraints.m785getMinHeightimpl(j);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(ConstraintsKt.m791constrainHeightK40F9xA(iRound2, j))) & 4294967295L) | (((long) Float.floatToRawIntBits(ConstraintsKt.m792constrainWidthK40F9xA(iRound, j))) << 32);
        if (getUseIntrinsicSize()) {
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(!m405hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo573getIntrinsicSizeNHjbRc()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) : Float.intBitsToFloat((int) (this.painter.mo573getIntrinsicSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(!m404hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo573getIntrinsicSizeNHjbRc()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) : Float.intBitsToFloat((int) (this.painter.mo573getIntrinsicSizeNHjbRc() & 4294967295L)))) & 4294967295L);
            jFloatToRawIntBits = (Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) == CropImageView.DEFAULT_ASPECT_RATIO || Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) == CropImageView.DEFAULT_ASPECT_RATIO) ? 0L : RulerKt.m625timesUQTWf7w(jFloatToRawIntBits2, this.contentScale.mo597computeScaleFactorH7hwNQA(jFloatToRawIntBits2, jFloatToRawIntBits));
        }
        return Constraints.m777copyZbe2FdA$default(ConstraintsKt.m792constrainWidthK40F9xA(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))), j), 0, ConstraintsKt.m791constrainHeightK40F9xA(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L))), j), 0, 10, j);
    }

    public final String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ")";
    }
}
