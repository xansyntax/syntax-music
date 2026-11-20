package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.size.SizeKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope {
    public final CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
    public DrawModifierNode drawNode;

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    public final void mo531drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, float f3, DrawStyle drawStyle) {
        this.canvasDrawScope.mo531drawArcyD3GUKo(j, f, f2, j2, j3, f3, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    public final void mo532drawCircleVaOC9Bg(long j, float f, long j2, DrawStyle drawStyle, int i) {
        this.canvasDrawScope.mo532drawCircleVaOC9Bg(j, f, j2, drawStyle, i);
    }

    public final void drawContent() {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
        Canvas canvas = canvasDrawScope.drawContext.getCanvas();
        DelegatableNode delegatableNode = this.drawNode;
        if (delegatableNode == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m$2("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        }
        Modifier.Node node = (Modifier.Node) delegatableNode;
        Modifier.Node nodePop = node.node.child;
        if (nodePop != null && (nodePop.aggregateChildKindSet & 4) != 0) {
            while (true) {
                if (nodePop != null) {
                    int i = nodePop.kindSet;
                    if ((i & 2) == 0) {
                        if ((i & 4) != 0) {
                            break;
                        } else {
                            nodePop = nodePop.child;
                        }
                    }
                }
                nodePop = null;
                break;
            }
        } else {
            nodePop = null;
            break;
        }
        if (nodePop == null) {
            NodeCoordinator nodeCoordinatorM646requireCoordinator64DMado = HitTestResultKt.m646requireCoordinator64DMado(delegatableNode, 4);
            if (nodeCoordinatorM646requireCoordinator64DMado.getTail() == node.node) {
                nodeCoordinatorM646requireCoordinator64DMado = nodeCoordinatorM646requireCoordinator64DMado.wrapped;
                nodeCoordinatorM646requireCoordinator64DMado.getClass();
            }
            nodeCoordinatorM646requireCoordinator64DMado.performDraw(canvas, (GraphicsLayer) emojiProcessor.mMetadataRepo);
            return;
        }
        MutableVector mutableVector = null;
        while (nodePop != null) {
            if (nodePop instanceof DrawModifierNode) {
                DrawModifierNode drawModifierNode = (DrawModifierNode) nodePop;
                GraphicsLayer graphicsLayer = (GraphicsLayer) emojiProcessor.mMetadataRepo;
                NodeCoordinator nodeCoordinatorM646requireCoordinator64DMado2 = HitTestResultKt.m646requireCoordinator64DMado(drawModifierNode, 4);
                long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(nodeCoordinatorM646requireCoordinator64DMado2.measuredSize);
                LayoutNode layoutNode = nodeCoordinatorM646requireCoordinator64DMado2.layoutNode;
                layoutNode.getClass();
                ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSharedDrawScope().m650drawDirecteZhPAX0$ui(canvas, jM876toSizeozmzZPI, nodeCoordinatorM646requireCoordinator64DMado2, drawModifierNode, graphicsLayer);
            } else if ((nodePop.kindSet & 4) != 0 && (nodePop instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                    if ((node2.kindSet & 4) != 0) {
                        i2++;
                        if (i2 == 1) {
                            nodePop = node2;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16]);
                            }
                            if (nodePop != null) {
                                mutableVector.add(nodePop);
                                nodePop = null;
                            }
                            mutableVector.add(node2);
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            nodePop = HitTestResultKt.pop(mutableVector);
        }
    }

    /* JADX INFO: renamed from: drawDirect-eZhPAX0$ui, reason: not valid java name */
    public final void m650drawDirecteZhPAX0$ui(Canvas canvas, long j, NodeCoordinator nodeCoordinator, DrawModifierNode drawModifierNode, GraphicsLayer graphicsLayer) {
        DrawModifierNode drawModifierNode2 = this.drawNode;
        this.drawNode = drawModifierNode;
        LayoutDirection layoutDirection = nodeCoordinator.layoutNode.layoutDirection;
        EmojiProcessor emojiProcessor = this.canvasDrawScope.drawContext;
        Density density = emojiProcessor.getDensity();
        LayoutDirection layoutDirection2 = emojiProcessor.getLayoutDirection();
        Canvas canvas2 = emojiProcessor.getCanvas();
        long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = (GraphicsLayer) emojiProcessor.mMetadataRepo;
        emojiProcessor.setDensity(nodeCoordinator);
        emojiProcessor.setLayoutDirection(layoutDirection);
        emojiProcessor.setCanvas(canvas);
        emojiProcessor.m832setSizeuvyYCjk(j);
        emojiProcessor.mMetadataRepo = graphicsLayer;
        canvas.save();
        try {
            drawModifierNode.draw(this);
            canvas.restore();
            emojiProcessor.setDensity(density);
            emojiProcessor.setLayoutDirection(layoutDirection2);
            emojiProcessor.setCanvas(canvas2);
            emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
            emojiProcessor.mMetadataRepo = graphicsLayer2;
            this.drawNode = drawModifierNode2;
        } catch (Throwable th) {
            canvas.restore();
            emojiProcessor.setDensity(density);
            emojiProcessor.setLayoutDirection(layoutDirection2);
            emojiProcessor.setCanvas(canvas2);
            emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
            emojiProcessor.mMetadataRepo = graphicsLayer2;
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    public final void mo533drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo533drawImageAZ2fEMs(imageBitmap, j, j2, j3, f, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    public final void mo534drawImagegbVJVH8(ImageBitmap imageBitmap, BlendModeColorFilter blendModeColorFilter) {
        this.canvasDrawScope.mo534drawImagegbVJVH8(imageBitmap, blendModeColorFilter);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    public final void mo535drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, int i2) {
        this.canvasDrawScope.mo535drawLineNGM6Ib0(j, j2, j3, f, i, i2);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    public final void mo536drawPathGBMwjPU(AndroidPath androidPath, Brush brush, float f, DrawStyle drawStyle, int i) {
        this.canvasDrawScope.mo536drawPathGBMwjPU(androidPath, brush, f, drawStyle, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI */
    public final void mo537drawPathLG529CI(AndroidPath androidPath, long j, float f, DrawStyle drawStyle) {
        this.canvasDrawScope.mo537drawPathLG529CI(androidPath, j, f, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w */
    public final void mo538drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo538drawRectAsUm42w(brush, j, j2, f, drawStyle, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    public final void mo539drawRectnJ9OG0(long j, long j2, long j3, float f, int i) {
        this.canvasDrawScope.mo539drawRectnJ9OG0(j, j2, j3, f, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    public final void mo540drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle) {
        this.canvasDrawScope.mo540drawRoundRectZuiqVtQ(brush, j, j2, j3, f, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    public final void mo541drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle) {
        this.canvasDrawScope.mo541drawRoundRectuAw5IA(j, j2, j3, j4, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    public final long mo555getCenterF1C5BW0() {
        return this.canvasDrawScope.mo555getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final EmojiProcessor getDrawContext() {
        return this.canvasDrawScope.drawContext;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.drawParams.layoutDirection;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public final long mo556getSizeNHjbRc() {
        return this.canvasDrawScope.mo556getSizeNHjbRc();
    }

    /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
    public final void m651recordJVtK1S4(long j, GraphicsLayer graphicsLayer, Function1 function1) {
        graphicsLayer.m557recordmLhObY(this, getLayoutDirection(), j, new UtilsKt$$ExternalSyntheticLambda0((Object) this, (Object) this.drawNode, (Object) function1, (byte) 23));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public final int mo74roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.mo74roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final int mo75roundToPx0680j_4(float f) {
        return this.canvasDrawScope.mo75roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final float mo76toDpGaN1DYA(long j) {
        return this.canvasDrawScope.mo76toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo77toDpu2uoSUM(float f) {
        return this.canvasDrawScope.mo77toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final long mo79toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.mo79toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final float mo80toPxR2X_6o(long j) {
        return this.canvasDrawScope.mo80toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo81toPx0680j_4(float f) {
        return this.canvasDrawScope.getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final long mo82toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.mo82toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public final long mo83toSp0xMU5do(float f) {
        return this.canvasDrawScope.mo83toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo84toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo84toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo78toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo78toDpu2uoSUM(i);
    }
}
