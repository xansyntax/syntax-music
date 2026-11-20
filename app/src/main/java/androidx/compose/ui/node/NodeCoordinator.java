package androidx.compose.ui.node;

import android.os.Build;
import android.view.ViewParent;
import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.internal.Lock;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.sqlite.SQLite;
import coil3.size.SizeKt;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates {
    public ButtonKt$$ExternalSyntheticLambda1 _drawBlock;
    public MeasureResult _measureResult;
    public MutableRect _rectCache;
    public Canvas drawBlockCanvas;
    public GraphicsLayer drawBlockParentLayer;
    public GraphicsLayer explicitLayer;
    public Rect graphicsOutlineBoundsCache;
    public final NodeCoordinator$$ExternalSyntheticLambda2 invalidateParentLayer;
    public boolean isClipping;
    public boolean lastClip;
    public boolean lastLayerDrawingWasSkipped;
    public Rect lastOutlineBounds;
    public OwnedLayer layer;
    public Function1 layerBlock;
    public Density layerDensity;
    public LayoutDirection layerLayoutDirection;
    public LayerPositionalProperties layerPositionalProperties;
    public final LayoutNode layoutNode;
    public MutableObjectIntMap oldAlignmentLines;
    public boolean released;
    public boolean wasLayerBlockInvoked;
    public NodeCoordinator wrapped;
    public NodeCoordinator wrappedBy;
    public float zIndex;
    public static final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingLayerParams = new ComposedModifierKt$$ExternalSyntheticLambda0(13);
    public static final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingLayer = new ComposedModifierKt$$ExternalSyntheticLambda0(14);
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    public static final float[] tmpMatrix = Matrix.m507constructorimpl$default();
    public static final NodeCoordinator$Companion$PointerInputSource$1 PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
    public static final ComposeUiNode.Companion SemanticsSource = new ComposeUiNode.Companion();
    public float lastLayerAlpha = 1.0f;
    public long position = 0;
    public Shape lastShape = ColorKt.RectangleShape;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface HitTestSource {
        /* JADX INFO: renamed from: childHitTest-qzLsGqo */
        void mo638childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z);

        /* JADX INFO: renamed from: entityType-OLwlOKw */
        int mo639entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shareWithSiblings(HitTestResult hitTestResult, LayoutNode layoutNode);

        default boolean shouldHitTest(Modifier.Node node) {
            return true;
        }

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
        this.layerDensity = layoutNode.density;
        this.layerLayoutDirection = layoutNode.layoutDirection;
        Rect rect = Rect.Zero;
        this.lastOutlineBounds = rect;
        this.graphicsOutlineBoundsCache = rect;
        this.invalidateParentLayer = new NodeCoordinator$$ExternalSyntheticLambda2(this, (byte) 1);
    }

    public static NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator nodeCoordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (nodeCoordinator = lookaheadLayoutCoordinates.lookaheadDelegate.coordinator) != null) {
            return nodeCoordinator;
        }
        layoutCoordinates.getClass();
        return (NodeCoordinator) layoutCoordinates;
    }

    public final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
        }
        long j = this.position;
        float f = (int) (j >> 32);
        mutableRect.left -= f;
        mutableRect.right -= f;
        float f2 = (int) (j & 4294967295L);
        mutableRect.top -= f2;
        mutableRect.bottom -= f2;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
            float[] fArrM704getInverseMatrix3i98HWw = graphicsLayerOwnerLayer.m704getInverseMatrix3i98HWw();
            if (!graphicsLayerOwnerLayer.isIdentity) {
                if (fArrM704getInverseMatrix3i98HWw == null) {
                    mutableRect.left = CropImageView.DEFAULT_ASPECT_RATIO;
                    mutableRect.top = CropImageView.DEFAULT_ASPECT_RATIO;
                    mutableRect.right = CropImageView.DEFAULT_ASPECT_RATIO;
                    mutableRect.bottom = CropImageView.DEFAULT_ASPECT_RATIO;
                } else {
                    Matrix.m509mapimpl(fArrM704getInverseMatrix3i98HWw, mutableRect);
                }
            }
            if (this.isClipping && z) {
                long j2 = this.measuredSize;
                mutableRect.intersect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (int) (j2 >> 32), (int) (j2 & 4294967295L));
            }
        }
    }

    /* JADX INFO: renamed from: ancestorToLocal-S_NoaFU, reason: not valid java name */
    public final long m663ancestorToLocalS_NoaFU(NodeCoordinator nodeCoordinator, long j) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        return (nodeCoordinator2 == null || Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) ? m666fromParentPosition8S9VItk(j) : m666fromParentPosition8S9VItk(nodeCoordinator2.m663ancestorToLocalS_NoaFU(nodeCoordinator, j));
    }

    /* JADX INFO: renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    public final long m664calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        float measuredWidth;
        float measuredHeight;
        if (getUseOutline()) {
            Rect rect = this.lastOutlineBounds;
            measuredWidth = rect.right - rect.left;
        } else {
            measuredWidth = getMeasuredWidth();
        }
        if (getUseOutline()) {
            Rect rect2 = this.lastOutlineBounds;
            measuredHeight = rect2.bottom - rect2.top;
        } else {
            measuredHeight = getMeasuredHeight();
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - measuredWidth;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - measuredHeight;
        float fMax = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat / 2.0f);
        return (((long) Float.floatToRawIntBits(Math.max(CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat2 / 2.0f))) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32);
    }

    /* JADX INFO: renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    public final float m665distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (getMeasuredWidth() >= Float.intBitsToFloat((int) (j2 >> 32)) && getMeasuredHeight() >= Float.intBitsToFloat((int) (j2 & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jM664calculateMinimumTouchTargetPaddingE7KxVPU = m664calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM664calculateMinimumTouchTargetPaddingE7KxVPU >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM664calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j >> 32));
        float fMax = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat3 < CropImageView.DEFAULT_ASPECT_RATIO ? -fIntBitsToFloat3 : fIntBitsToFloat3 - getMeasuredWidth());
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & 4294967295L));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(Math.max(CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat4 < CropImageView.DEFAULT_ASPECT_RATIO ? -fIntBitsToFloat4 : fIntBitsToFloat4 - getMeasuredHeight()))) & 4294967295L);
        if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO || fIntBitsToFloat2 > CropImageView.DEFAULT_ASPECT_RATIO) {
            int i = (int) (jFloatToRawIntBits >> 32);
            if (Float.intBitsToFloat(i) <= fIntBitsToFloat) {
                int i2 = (int) (jFloatToRawIntBits & 4294967295L);
                if (Float.intBitsToFloat(i2) <= fIntBitsToFloat2) {
                    float fIntBitsToFloat5 = Float.intBitsToFloat(i);
                    float fIntBitsToFloat6 = Float.intBitsToFloat(i2);
                    return (fIntBitsToFloat6 * fIntBitsToFloat6) + (fIntBitsToFloat5 * fIntBitsToFloat5);
                }
            }
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) throws Throwable {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null) {
            long j = this.position;
            float f = (int) (j >> 32);
            float f2 = (int) (j & 4294967295L);
            canvas.translate(f, f2);
            drawContainedDrawModifiers(canvas, graphicsLayer);
            canvas.translate(-f, -f2);
            return;
        }
        GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
        CanvasDrawScope canvasDrawScope = graphicsLayerOwnerLayer.scope;
        graphicsLayerOwnerLayer.updateDisplayList();
        graphicsLayerOwnerLayer.drawnWithEnabledZ = graphicsLayerOwnerLayer.graphicsLayer.impl.getShadowElevation() > CropImageView.DEFAULT_ASPECT_RATIO;
        EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
        emojiProcessor.setCanvas(canvas);
        emojiProcessor.mMetadataRepo = graphicsLayer;
        LifecyclesKt.drawLayer(canvasDrawScope, graphicsLayerOwnerLayer.graphicsLayer);
    }

    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) throws Throwable {
        NodeCoordinator nodeCoordinator;
        Canvas canvas2;
        GraphicsLayer graphicsLayer2;
        Modifier.Node nodeM668headH91voCI = m668headH91voCI(4);
        if (nodeM668headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
            return;
        }
        LayoutNode layoutNode = this.layoutNode;
        layoutNode.getClass();
        LayoutNodeDrawScope sharedDrawScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSharedDrawScope();
        long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(this.measuredSize);
        sharedDrawScope.getClass();
        MutableVector mutableVector = null;
        while (nodeM668headH91voCI != null) {
            if (nodeM668headH91voCI instanceof DrawModifierNode) {
                nodeCoordinator = this;
                canvas2 = canvas;
                graphicsLayer2 = graphicsLayer;
                sharedDrawScope.m650drawDirecteZhPAX0$ui(canvas2, jM876toSizeozmzZPI, nodeCoordinator, (DrawModifierNode) nodeM668headH91voCI, graphicsLayer2);
            } else {
                nodeCoordinator = this;
                canvas2 = canvas;
                graphicsLayer2 = graphicsLayer;
                if ((nodeM668headH91voCI.kindSet & 4) != 0 && (nodeM668headH91voCI instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node node = ((DelegatingNode) nodeM668headH91voCI).delegate; node != null; node = node.child) {
                        if ((node.kindSet & 4) != 0) {
                            i++;
                            if (i == 1) {
                                nodeM668headH91voCI = node;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                }
                                if (nodeM668headH91voCI != null) {
                                    mutableVector.add(nodeM668headH91voCI);
                                    nodeM668headH91voCI = null;
                                }
                                mutableVector.add(node);
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                canvas = canvas2;
                this = nodeCoordinator;
                graphicsLayer = graphicsLayer2;
            }
            nodeM668headH91voCI = HitTestResultKt.pop(mutableVector);
            canvas = canvas2;
            this = nodeCoordinator;
            graphicsLayer = graphicsLayer2;
        }
    }

    public abstract void ensureLookaheadDelegateCreated();

    public final NodeCoordinator findCommonAncestor$ui(NodeCoordinator nodeCoordinator) {
        LayoutNode parent$ui = nodeCoordinator.layoutNode;
        LayoutNode layoutNode = this.layoutNode;
        if (parent$ui == layoutNode) {
            Modifier.Node tail = nodeCoordinator.getTail();
            Modifier.Node tail2 = getTail();
            if (!tail2.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node node = tail2.node.parent; node != null; node = node.parent) {
                if ((node.kindSet & 2) != 0 && node == tail) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (parent$ui.depth > layoutNode.depth) {
            parent$ui = parent$ui.getParent$ui();
            parent$ui.getClass();
        }
        LayoutNode parent$ui2 = layoutNode;
        while (parent$ui2.depth > parent$ui.depth) {
            parent$ui2 = parent$ui2.getParent$ui();
            parent$ui2.getClass();
        }
        while (parent$ui != parent$ui2) {
            parent$ui = parent$ui.getParent$ui();
            parent$ui2 = parent$ui2.getParent$ui();
            if (parent$ui == null || parent$ui2 == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("layouts are not part of the same hierarchy");
                return null;
            }
        }
        if (parent$ui2 != layoutNode) {
            if (parent$ui != nodeCoordinator.layoutNode) {
                return (InnerNodeCoordinator) parent$ui.nodes.innerCoordinator;
            }
            return nodeCoordinator;
        }
        return this;
    }

    /* JADX INFO: renamed from: fromParentPosition-8S9VItk, reason: not valid java name */
    public final long m666fromParentPosition8S9VItk(long j) {
        long j2 = this.position;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - ((int) (j2 >> 32));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
            float[] fArrM704getInverseMatrix3i98HWw = graphicsLayerOwnerLayer.m704getInverseMatrix3i98HWw();
            if (fArrM704getInverseMatrix3i98HWw == null) {
                return 9187343241974906880L;
            }
            if (!graphicsLayerOwnerLayer.isIdentity) {
                return Matrix.m508mapMKHz9U(jFloatToRawIntBits, fArrM704getInverseMatrix3i98HWw);
            }
        }
        return jFloatToRawIntBits;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.layoutNode.density.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.layoutNode.density.getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public final LayoutDirection getLayoutDirection() {
        return this.layoutNode.layoutDirection;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final MeasureResult getMeasureResult$ui() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Asking for measurement result of unmeasured layout modifier");
        return null;
    }

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m667getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo82toSizeXkaWNTQ(this.layoutNode.viewConfiguration.mo649getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui();
        return this.wrappedBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measurable
    public final Object getParentData() {
        LayoutNode layoutNode = this.layoutNode;
        if (!layoutNode.nodes.m662hasH91voCI$ui(64)) {
            return null;
        }
        getTail();
        Object objModifyParentData = null;
        for (Modifier.Node node = (TailModifierNode) layoutNode.nodes.tail; node != null; node = node.parent) {
            if ((node.kindSet & 64) != 0) {
                ?? Pop = node;
                ?? mutableVector = 0;
                while (Pop != 0) {
                    if (Pop instanceof ParentDataModifierNode) {
                        objModifyParentData = ((ParentDataModifierNode) Pop).modifyParentData(layoutNode.density, objModifyParentData);
                    } else if ((Pop.kindSet & 64) != 0 && (Pop instanceof DelegatingNode)) {
                        Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                        int i = 0;
                        Pop = Pop;
                        mutableVector = mutableVector;
                        while (node2 != null) {
                            if ((node2.kindSet & 64) != 0) {
                                i++;
                                if (i == 1) {
                                    mutableVector = mutableVector;
                                    Pop = node2;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Pop != 0) {
                                        mutableVector.add(Pop);
                                        Pop = 0;
                                    }
                                    mutableVector.add(node2);
                                }
                            }
                            node2 = node2.child;
                            Pop = Pop;
                            mutableVector = mutableVector;
                        }
                        if (i == 1) {
                        }
                    }
                    Pop = HitTestResultKt.pop(mutableVector);
                }
            }
        }
        return objModifyParentData;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        boolean z = getTail().isAttached;
        LayoutNode layoutNode = this.layoutNode;
        if (!z) {
            StringBuilder sb = new StringBuilder("LayoutCoordinate operations are only valid when isAttached is true");
            for (LayoutNode parent$ui = layoutNode; parent$ui != null; parent$ui = parent$ui.getParent$ui()) {
                sb.append("\n|");
                sb.append(parent$ui);
                sb.append(" isAttached=");
                sb.append(parent$ui.isAttached$1());
                sb.append(" modifier=");
                sb.append(parent$ui._modifier);
                sb.append(" tail=");
                sb.append(getTail());
            }
            InlineClassHelperKt.throwIllegalStateException(sb.toString());
        }
        onCoordinatesUsed$ui();
        return ((NodeCoordinator) layoutNode.nodes.outerCoordinator).wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* JADX INFO: renamed from: getPosition-nOcc-ac */
    public final long mo654getPositionnOccac() {
        return this.position;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo603getSizeYbymL2g() {
        return this.measuredSize;
    }

    public abstract Modifier.Node getTail();

    public final boolean getUseOutline() {
        return this.lastClip && !this.lastOutlineBounds.isEmpty();
    }

    /* JADX INFO: renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m668headH91voCI(int i) {
        boolean zM678getIncludeSelfInTraversalH91voCI = NodeKindKt.m678getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!zM678getIncludeSelfInTraversalH91voCI && (tail = tail.parent) == null) {
            return null;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM678getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & i) != 0; nodeHeadNode = nodeHeadNode.child) {
            if ((nodeHeadNode.kindSet & i) != 0) {
                return nodeHeadNode;
            }
            if (nodeHeadNode == tail) {
                return null;
            }
        }
        return null;
    }

    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        NodeChain nodeChain = this.layoutNode.nodes;
        if (((NodeCoordinator) nodeChain.outerCoordinator) == this) {
            return (Modifier.Node) nodeChain.head;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (!z) {
            if (nodeCoordinator != null) {
                return nodeCoordinator.getTail();
            }
            return null;
        }
        if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
            return null;
        }
        return tail.child;
    }

    /* JADX INFO: renamed from: hit-5ShdDok, reason: not valid java name */
    public final void m669hit5ShdDok(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        if (node == null) {
            mo647hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
            return;
        }
        if (!hitTestSource.shouldHitTest(node)) {
            m669hit5ShdDok(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z);
            return;
        }
        int i2 = hitTestResult.hitDepth;
        MutableObjectList mutableObjectList = hitTestResult.values;
        hitTestResult.removeNodesInRange(i2 + 1, mutableObjectList._size);
        hitTestResult.hitDepth++;
        mutableObjectList.add(node);
        hitTestResult.distanceFromEdgeAndFlags.add(HitTestResultKt.DistanceAndFlags(-1.0f, z, false));
        m669hit5ShdDok(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z);
        hitTestResult.hitDepth = i2;
    }

    /* JADX INFO: renamed from: hitNear-Fh5PU_I, reason: not valid java name */
    public final void m670hitNearFh5PU_I(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z, float f) {
        if (node == null) {
            mo647hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
            return;
        }
        if (!hitTestSource.shouldHitTest(node)) {
            m670hitNearFh5PU_I(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f);
            return;
        }
        int i2 = hitTestResult.hitDepth;
        MutableObjectList mutableObjectList = hitTestResult.values;
        hitTestResult.removeNodesInRange(i2 + 1, mutableObjectList._size);
        hitTestResult.hitDepth++;
        mutableObjectList.add(node);
        hitTestResult.distanceFromEdgeAndFlags.add(HitTestResultKt.DistanceAndFlags(f, z, false));
        m672outOfBoundsHit8NAm7pk(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f, true);
        hitTestResult.hitDepth = i2;
    }

    /* JADX INFO: renamed from: hitTest-qzLsGqo, reason: not valid java name */
    public final void m671hitTestqzLsGqo(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        boolean z2;
        MutableObjectList mutableObjectList = hitTestResult.values;
        Modifier.Node nodeM668headH91voCI = m668headH91voCI(hitTestSource.mo639entityTypeOLwlOKw());
        boolean z3 = false;
        if (!m677withinLayerBoundsk4lQ0M(j)) {
            if (i == 1) {
                float fM665distanceInMinimumTouchTargettz77jQw = m665distanceInMinimumTouchTargettz77jQw(j, m667getMinimumTouchTargetSizeNHjbRc());
                if ((Float.floatToRawIntBits(fM665distanceInMinimumTouchTargettz77jQw) & Integer.MAX_VALUE) < 2139095040) {
                    if (hitTestResult.hitDepth != mutableObjectList._size - 1) {
                        if (HitTestResultKt.m641compareTo9YPOF3E(hitTestResult.m640findBestHitDistancefn2tFes(), HitTestResultKt.DistanceAndFlags(fM665distanceInMinimumTouchTargettz77jQw, false, false)) <= 0) {
                            return;
                        }
                    }
                    m670hitNearFh5PU_I(nodeM668headH91voCI, hitTestSource, j, hitTestResult, i, false, fM665distanceInMinimumTouchTargettz77jQw);
                    return;
                }
                return;
            }
            return;
        }
        if (nodeM668headH91voCI == null) {
            mo647hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        if (fIntBitsToFloat >= CropImageView.DEFAULT_ASPECT_RATIO && fIntBitsToFloat2 >= CropImageView.DEFAULT_ASPECT_RATIO && fIntBitsToFloat < getMeasuredWidth() && fIntBitsToFloat2 < getMeasuredHeight()) {
            m669hit5ShdDok(nodeM668headH91voCI, hitTestSource, j, hitTestResult, i, z);
            return;
        }
        float fM665distanceInMinimumTouchTargettz77jQw2 = i == 1 ? m665distanceInMinimumTouchTargettz77jQw(j, m667getMinimumTouchTargetSizeNHjbRc()) : Float.POSITIVE_INFINITY;
        if ((Float.floatToRawIntBits(fM665distanceInMinimumTouchTargettz77jQw2) & Integer.MAX_VALUE) < 2139095040) {
            if (hitTestResult.hitDepth == mutableObjectList._size - 1) {
                z2 = z;
            } else {
                z2 = z;
                if (HitTestResultKt.m641compareTo9YPOF3E(hitTestResult.m640findBestHitDistancefn2tFes(), HitTestResultKt.DistanceAndFlags(fM665distanceInMinimumTouchTargettz77jQw2, z2, false)) > 0) {
                }
            }
            z3 = true;
        } else {
            z2 = z;
        }
        m672outOfBoundsHit8NAm7pk(nodeM668headH91voCI, hitTestSource, j, hitTestResult, i, z2, fM665distanceInMinimumTouchTargettz77jQw2, z3);
    }

    /* JADX INFO: renamed from: hitTestChild-qzLsGqo */
    public void mo647hitTestChildqzLsGqo(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m671hitTestqzLsGqo(hitTestSource, nodeCoordinator.m666fromParentPosition8S9VItk(j), hitTestResult, i, z);
        }
    }

    public final void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ((GraphicsLayerOwnerLayer) ownedLayer).invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached$1() {
        return getTail().isAttached;
    }

    public final boolean isTransparent() {
        float alpha;
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            alpha = graphicsLayer.impl.getAlpha();
        } else {
            alpha = this.layer != null ? this.lastLayerAlpha : 1.0f;
        }
        if (alpha <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !this.layoutNode.isAttached$1()) ? false : true;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!layoutCoordinates.isAttached$1()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + layoutCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        MutableRect mutableRect = this._rectCache;
        if (mutableRect == null) {
            mutableRect = new MutableRect();
            this._rectCache = mutableRect;
        }
        mutableRect.left = CropImageView.DEFAULT_ASPECT_RATIO;
        mutableRect.top = CropImageView.DEFAULT_ASPECT_RATIO;
        mutableRect.right = (int) (layoutCoordinates.mo603getSizeYbymL2g() >> 32);
        mutableRect.bottom = (int) (layoutCoordinates.mo603getSizeYbymL2g() & 4294967295L);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui) {
            coordinator.rectInParent$ui(mutableRect, z, false);
            if (mutableRect.isEmpty()) {
                return Rect.Zero;
            }
            coordinator = coordinator.wrappedBy;
            coordinator.getClass();
        }
        ancestorToLocal(nodeCoordinatorFindCommonAncestor$ui, mutableRect, z);
        return new Rect(mutableRect.left, mutableRect.top, mutableRect.right, mutableRect.bottom);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public final long mo604localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo605localPositionOfS_NoaFU(layoutCoordinates, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-S_NoaFU */
    public final long mo605localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadLayoutCoordinates lookaheadLayoutCoordinates = (LookaheadLayoutCoordinates) layoutCoordinates;
            lookaheadLayoutCoordinates.lookaheadDelegate.coordinator.onCoordinatesUsed$ui();
            return lookaheadLayoutCoordinates.mo605localPositionOfS_NoaFU(this, j ^ (-9223372034707292160L)) ^ (-9223372034707292160L);
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui) {
            OwnedLayer ownedLayer = coordinator.layer;
            if (ownedLayer != null) {
                GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
                float[] fArrM705getMatrixsQKQjiQ = graphicsLayerOwnerLayer.m705getMatrixsQKQjiQ();
                if (!graphicsLayerOwnerLayer.isIdentity) {
                    j = Matrix.m508mapMKHz9U(j, fArrM705getMatrixsQKQjiQ);
                }
            }
            j = SQLite.m846plusNvtHpc(j, coordinator.position);
            coordinator = coordinator.wrappedBy;
            coordinator.getClass();
        }
        return m663ancestorToLocalS_NoaFU(nodeCoordinatorFindCommonAncestor$ui, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public final long mo606localToRootMKHz9U(long j) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui();
        while (this != null) {
            LayoutNode layoutNode = this.layoutNode;
            if (this == ((NodeCoordinator) layoutNode.nodes.outerCoordinator) && !layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot) {
                long jM720getOffsetFromRectListForBjo55l4 = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getRectManager().m720getOffsetFromRectListForBjo55l4(layoutNode);
                if (!IntOffset.m804equalsimpl0(jM720getOffsetFromRectListForBjo55l4, 9223372034707292159L)) {
                    return SQLite.m846plusNvtHpc(j, jM720getOffsetFromRectListForBjo55l4);
                }
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
                float[] fArrM705getMatrixsQKQjiQ = graphicsLayerOwnerLayer.m705getMatrixsQKQjiQ();
                if (!graphicsLayerOwnerLayer.isIdentity) {
                    j = Matrix.m508mapMKHz9U(j, fArrM705getMatrixsQKQjiQ);
                }
            }
            j = SQLite.m846plusNvtHpc(j, this.position);
            this = this.wrappedBy;
        }
        return j;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public final long mo607localToScreenMKHz9U(long j) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return ((AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode)).m686localToScreenMKHz9U(mo606localToRootMKHz9U(j));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public final long mo608localToWindowMKHz9U(long j) {
        long jMo606localToRootMKHz9U = mo606localToRootMKHz9U(j);
        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode);
        androidComposeView.recalculateWindowPosition();
        return Matrix.m508mapMKHz9U(jMo606localToRootMKHz9U, androidComposeView.viewToWindowMatrix);
    }

    public final void onCoordinatesUsed$ui() {
        this.layoutNode.layoutDelegate.onCoordinatesUsed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public final void onMeasured() {
        Modifier.Node tail;
        boolean zM678getIncludeSelfInTraversalH91voCI = NodeKindKt.m678getIncludeSelfInTraversalH91voCI(128);
        Modifier.Node nodeHeadNode = headNode(zM678getIncludeSelfInTraversalH91voCI);
        if (nodeHeadNode == null || (nodeHeadNode.node.aggregateChildKindSet & 128) == 0) {
            return;
        }
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (!zM678getIncludeSelfInTraversalH91voCI) {
                tail = getTail().parent;
                if (tail == null) {
                }
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
            tail = getTail();
            for (Modifier.Node nodeHeadNode2 = headNode(zM678getIncludeSelfInTraversalH91voCI); nodeHeadNode2 != null && (nodeHeadNode2.aggregateChildKindSet & 128) != 0; nodeHeadNode2 = nodeHeadNode2.child) {
                if ((nodeHeadNode2.kindSet & 128) != 0) {
                    ?? Pop = nodeHeadNode2;
                    ?? mutableVector = 0;
                    while (Pop != 0) {
                        if (Pop instanceof MeasuredSizeAwareModifierNode) {
                            ((MeasuredSizeAwareModifierNode) Pop).mo61onRemeasuredozmzZPI(this.measuredSize);
                        } else if ((Pop.kindSet & 128) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node node = ((DelegatingNode) Pop).delegate;
                            int i = 0;
                            Pop = Pop;
                            mutableVector = mutableVector;
                            while (node != null) {
                                if ((node.kindSet & 128) != 0) {
                                    i++;
                                    if (i == 1) {
                                        mutableVector = mutableVector;
                                        Pop = node;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (Pop != 0) {
                                            mutableVector.add(Pop);
                                            Pop = 0;
                                        }
                                        mutableVector.add(node);
                                    }
                                }
                                node = node.child;
                                Pop = Pop;
                                mutableVector = mutableVector;
                            }
                            if (i == 1) {
                            }
                        }
                        Pop = HitTestResultKt.pop(mutableVector);
                    }
                }
                if (nodeHeadNode2 == tail) {
                    break;
                }
            }
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        } catch (Throwable th) {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final void onPlaced() {
        boolean zM678getIncludeSelfInTraversalH91voCI = NodeKindKt.m678getIncludeSelfInTraversalH91voCI(4194304);
        Modifier.Node tail = getTail();
        if (!zM678getIncludeSelfInTraversalH91voCI && (tail = tail.parent) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM678getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & 4194304) != 0; nodeHeadNode = nodeHeadNode.child) {
            if ((nodeHeadNode.kindSet & 4194304) != 0) {
                ?? Pop = nodeHeadNode;
                ?? mutableVector = 0;
                while (Pop != 0) {
                    if (Pop instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) Pop).onPlaced(this);
                    } else if ((Pop.kindSet & 4194304) != 0 && (Pop instanceof DelegatingNode)) {
                        Modifier.Node node = ((DelegatingNode) Pop).delegate;
                        int i = 0;
                        Pop = Pop;
                        mutableVector = mutableVector;
                        while (node != null) {
                            if ((node.kindSet & 4194304) != 0) {
                                i++;
                                if (i == 1) {
                                    mutableVector = mutableVector;
                                    Pop = node;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Pop != 0) {
                                        mutableVector.add(Pop);
                                        Pop = 0;
                                    }
                                    mutableVector.add(node);
                                }
                            }
                            node = node.child;
                            Pop = Pop;
                            mutableVector = mutableVector;
                        }
                        if (i == 1) {
                        }
                    }
                    Pop = HitTestResultKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
        if (IntOffset.m804equalsimpl0(this.position, 0L)) {
            return;
        }
        this.layoutNode.onCoordinatorRectChanged$ui(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v4 */
    public final void onUnplaced() {
        boolean zM678getIncludeSelfInTraversalH91voCI = NodeKindKt.m678getIncludeSelfInTraversalH91voCI(ByteChannelKt.CHANNEL_MAX_SIZE);
        Modifier.Node nodeHeadNode = headNode(zM678getIncludeSelfInTraversalH91voCI);
        if (nodeHeadNode == null || (nodeHeadNode.node.aggregateChildKindSet & ByteChannelKt.CHANNEL_MAX_SIZE) == 0) {
            return;
        }
        Modifier.Node tail = getTail();
        if (!zM678getIncludeSelfInTraversalH91voCI && (tail = tail.parent) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode2 = headNode(zM678getIncludeSelfInTraversalH91voCI); nodeHeadNode2 != null && (nodeHeadNode2.aggregateChildKindSet & ByteChannelKt.CHANNEL_MAX_SIZE) != 0; nodeHeadNode2 = nodeHeadNode2.child) {
            if ((nodeHeadNode2.kindSet & ByteChannelKt.CHANNEL_MAX_SIZE) != 0) {
                ?? Pop = nodeHeadNode2;
                ?? mutableVector = 0;
                while (Pop != 0) {
                    if (Pop instanceof UnplacedAwareModifierNode) {
                        ((UnplacedAwareModifierNode) Pop).onUnplaced();
                    } else if ((Pop.kindSet & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 && (Pop instanceof DelegatingNode)) {
                        Modifier.Node node = ((DelegatingNode) Pop).delegate;
                        int i = 0;
                        Pop = Pop;
                        mutableVector = mutableVector;
                        while (node != null) {
                            if ((node.kindSet & ByteChannelKt.CHANNEL_MAX_SIZE) != 0) {
                                i++;
                                if (i == 1) {
                                    mutableVector = mutableVector;
                                    Pop = node;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Pop != 0) {
                                        mutableVector.add(Pop);
                                        Pop = 0;
                                    }
                                    mutableVector.add(node);
                                }
                            }
                            node = node.child;
                            Pop = Pop;
                            mutableVector = mutableVector;
                        }
                        if (i == 1) {
                        }
                    }
                    Pop = HitTestResultKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode2 == tail) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x01d5 A[PHI: r3
      0x01d5: PHI (r3v18 ??) = (r3v1 ??), (r3v1 ??), (r3v20 ??) binds: [B:58:0x019f, B:60:0x01a3, B:74:0x01cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v22, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v18, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX INFO: renamed from: outOfBoundsHit-8NAm7pk, reason: not valid java name */
    public final void m672outOfBoundsHit8NAm7pk(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z, float f, boolean z2) {
        char c;
        int i2;
        ?? Pop;
        MutableObjectList mutableObjectList = hitTestResult.values;
        if (node == null) {
            mo647hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
            return;
        }
        if (!hitTestSource.shouldHitTest(node)) {
            m672outOfBoundsHit8NAm7pk(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f, z2);
            return;
        }
        int i3 = i;
        if (i3 == 3 || i3 == 4) {
            ?? r2 = node;
            ?? mutableVector = 0;
            while (r2 != 0) {
                if (r2 instanceof PointerInputModifierNode) {
                    long jMo212getTouchBoundsExpansionRZrCHBk = ((PointerInputModifierNode) r2).mo212getTouchBoundsExpansionRZrCHBk();
                    int i4 = (int) (j >> 32);
                    float fIntBitsToFloat = Float.intBitsToFloat(i4);
                    LayoutNode layoutNode = this.layoutNode;
                    LayoutDirection layoutDirection = layoutNode.layoutDirection;
                    long j2 = Long.MIN_VALUE & jMo212getTouchBoundsExpansionRZrCHBk;
                    LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                    if (j2 == 0 || layoutDirection == layoutDirection2) {
                        c = 30;
                        i2 = (int) jMo212getTouchBoundsExpansionRZrCHBk;
                    } else {
                        c = 30;
                        i2 = (int) (jMo212getTouchBoundsExpansionRZrCHBk >> 30);
                    }
                    if (fIntBitsToFloat < (-(i2 & 32767))) {
                        break;
                    }
                    if (Float.intBitsToFloat(i4) >= getMeasuredWidth() + (((j2 == 0 || layoutNode.layoutDirection == layoutDirection2) ? (int) (jMo212getTouchBoundsExpansionRZrCHBk >> c) : (int) jMo212getTouchBoundsExpansionRZrCHBk) & 32767)) {
                        break;
                    }
                    int i5 = (int) (j & 4294967295L);
                    if (Float.intBitsToFloat(i5) < (-(((int) (jMo212getTouchBoundsExpansionRZrCHBk >> 15)) & 32767)) || Float.intBitsToFloat(i5) >= getMeasuredHeight() + (((int) (jMo212getTouchBoundsExpansionRZrCHBk >> 45)) & 32767)) {
                        break;
                        break;
                    }
                    MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
                    int i6 = hitTestResult.hitDepth;
                    int i7 = mutableObjectList._size;
                    if (i6 == i7 - 1) {
                        hitTestResult.removeNodesInRange(i6 + 1, i7);
                        hitTestResult.hitDepth++;
                        mutableObjectList.add(node);
                        mutableLongList.add(HitTestResultKt.DistanceAndFlags(CropImageView.DEFAULT_ASPECT_RATIO, z, true));
                        m672outOfBoundsHit8NAm7pk(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i3, z, f, z2);
                        hitTestResult.hitDepth = i6;
                        return;
                    }
                    long jM640findBestHitDistancefn2tFes = hitTestResult.m640findBestHitDistancefn2tFes();
                    int i8 = hitTestResult.hitDepth;
                    if (!HitTestResultKt.m643isInExpandedBoundsimpl(jM640findBestHitDistancefn2tFes)) {
                        if (HitTestResultKt.m642getDistanceimpl(jM640findBestHitDistancefn2tFes) > CropImageView.DEFAULT_ASPECT_RATIO) {
                            int i9 = hitTestResult.hitDepth;
                            hitTestResult.removeNodesInRange(i9 + 1, mutableObjectList._size);
                            hitTestResult.hitDepth++;
                            mutableObjectList.add(node);
                            mutableLongList.add(HitTestResultKt.DistanceAndFlags(CropImageView.DEFAULT_ASPECT_RATIO, z, true));
                            m672outOfBoundsHit8NAm7pk(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f, z2);
                            hitTestResult.hitDepth = i9;
                            return;
                        }
                        return;
                    }
                    int i10 = mutableObjectList._size;
                    int i11 = i10 - 1;
                    hitTestResult.hitDepth = i11;
                    hitTestResult.removeNodesInRange(i10, mutableObjectList._size);
                    hitTestResult.hitDepth++;
                    mutableObjectList.add(node);
                    mutableLongList.add(HitTestResultKt.DistanceAndFlags(CropImageView.DEFAULT_ASPECT_RATIO, z, true));
                    m672outOfBoundsHit8NAm7pk(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f, z2);
                    hitTestResult.hitDepth = i11;
                    if (HitTestResultKt.m642getDistanceimpl(hitTestResult.m640findBestHitDistancefn2tFes()) < CropImageView.DEFAULT_ASPECT_RATIO) {
                        hitTestResult.removeNodesInRange(i8 + 1, hitTestResult.hitDepth + 1);
                    }
                    hitTestResult.hitDepth = i8;
                    return;
                }
                if ((r2.kindSet & 16) == 0 || !(r2 instanceof DelegatingNode)) {
                    Pop = r2;
                    mutableVector = mutableVector;
                    Pop = HitTestResultKt.pop(mutableVector);
                } else {
                    Modifier.Node node2 = ((DelegatingNode) r2).delegate;
                    int i12 = 0;
                    while (node2 != null) {
                        if ((node2.kindSet & 16) != 0) {
                            i12++;
                            if (i12 == 1) {
                                Pop = r2;
                                mutableVector = mutableVector;
                                mutableVector = mutableVector;
                                Pop = node2;
                            } else {
                                if (mutableVector == 0) {
                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                }
                                if (Pop != 0) {
                                    mutableVector.add(Pop);
                                    Pop = 0;
                                }
                                mutableVector.add(node2);
                            }
                        } else {
                            Pop = r2;
                            mutableVector = mutableVector;
                        }
                        node2 = node2.child;
                        Pop = Pop;
                        mutableVector = mutableVector;
                    }
                    if (i12 == 1) {
                        Pop = r2;
                        mutableVector = mutableVector;
                    } else {
                        Pop = r2;
                        mutableVector = mutableVector;
                        Pop = HitTestResultKt.pop(mutableVector);
                    }
                }
                i3 = i;
                r2 = Pop;
                mutableVector = mutableVector;
            }
        }
        if (z2) {
            m670hitNearFh5PU_I(node, hitTestSource, j, hitTestResult, i, z, f);
        } else {
            m674speculativeHitFh5PU_I(node, hitTestSource, j, hitTestResult, i, z, f);
        }
    }

    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) throws Throwable {
        LayoutNode layoutNode = this.layoutNode;
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode);
        MutableVector zSortedChildren = layoutNode.getZSortedChildren();
        Object[] objArr = zSortedChildren.content;
        int i = zSortedChildren.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (layoutNode2.isPlaced()) {
                layoutNode2.draw$ui(canvas, graphicsLayer);
            }
        }
        if (((AndroidComposeView) ownerRequireOwner).getShowLayoutBounds()) {
            AndroidPaint androidPaint = InnerNodeCoordinator.innerBoundsPaint;
            long j = this.measuredSize;
            canvas.drawRect(0.5f, 0.5f, ((int) (j >> 32)) - 0.5f, ((int) (j & 4294967295L)) - 0.5f, androidPaint);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo616placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) throws Throwable {
        m673placeSelfMLgxB_4(j, f, null, graphicsLayer);
        if (this.isShallowPlacing) {
            return;
        }
        this.layoutNode.layoutDelegate.measurePassDelegate.onNodePlaced$ui();
    }

    /* JADX INFO: renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    public final void m673placeSelfMLgxB_4(long j, float f, Function1 function1, GraphicsLayer graphicsLayer) {
        byte b = 0;
        LayoutNode layoutNode = this.layoutNode;
        if (graphicsLayer != null) {
            if (function1 != null) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != graphicsLayer) {
                this.explicitLayer = null;
                updateLayerBlock(null, false);
                this.explicitLayer = graphicsLayer;
            }
            if (this.layer == null) {
                Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode);
                ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda1 = this._drawBlock;
                if (buttonKt$$ExternalSyntheticLambda1 == null) {
                    ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda2 = new ButtonKt$$ExternalSyntheticLambda1(this, new NodeCoordinator$$ExternalSyntheticLambda2(this, b), (byte) 29);
                    this._drawBlock = buttonKt$$ExternalSyntheticLambda2;
                    buttonKt$$ExternalSyntheticLambda1 = buttonKt$$ExternalSyntheticLambda2;
                }
                NodeCoordinator$$ExternalSyntheticLambda2 nodeCoordinator$$ExternalSyntheticLambda2 = this.invalidateParentLayer;
                OwnedLayer ownedLayerCreateLayer = ((AndroidComposeView) ownerRequireOwner).createLayer(buttonKt$$ExternalSyntheticLambda1, nodeCoordinator$$ExternalSyntheticLambda2, graphicsLayer);
                GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayerCreateLayer;
                graphicsLayerOwnerLayer.m707resizeozmzZPI(this.measuredSize);
                graphicsLayerOwnerLayer.m706movegyyYBs(j);
                this.layer = ownedLayerCreateLayer;
                layoutNode.innerLayerCoordinatorIsDirty = true;
                nodeCoordinator$$ExternalSyntheticLambda2.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock(null, false);
            }
            updateLayerBlock(function1, false);
        }
        if (!IntOffset.m804equalsimpl0(this.position, j)) {
            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).voteFrameRate(-4.0f);
            this.position = j;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ((GraphicsLayerOwnerLayer) ownedLayer).m706movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            layoutNode.onCoordinatorRectChanged$ui(this);
            LookaheadCapablePlaceable.invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = layoutNode.owner;
            if (owner != null) {
                ((AndroidComposeView) owner).onLayoutChange(layoutNode);
            }
        }
        this.zIndex = f;
        if (this == ((NodeCoordinator) layoutNode.nodes.outerCoordinator)) {
            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getRectManager().recalculateRectIfDirty(layoutNode);
        }
        if (this.isPlacingForAlignment) {
            return;
        }
        captureRulersIfNeeded$ui(getMeasureResult$ui());
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    public final void rectInParent$ui(MutableRect mutableRect, boolean z, boolean z2) {
        long jFloatToRawIntBits;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long jM667getMinimumTouchTargetSizeNHjbRc = m667getMinimumTouchTargetSizeNHjbRc();
                    float f = mutableRect.left;
                    float f2 = mutableRect.top;
                    if (mutableRect.right >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        long j = this.measuredSize;
                        if (f > ((int) (j >> 32)) || mutableRect.bottom < CropImageView.DEFAULT_ASPECT_RATIO || f2 > ((int) (j & 4294967295L))) {
                            jFloatToRawIntBits = 0;
                        } else {
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (jM667getMinimumTouchTargetSizeNHjbRc >> 32));
                            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM667getMinimumTouchTargetSizeNHjbRc & 4294967295L));
                            float f3 = (fIntBitsToFloat - (mutableRect.right - mutableRect.left)) / 2.0f;
                            if (f3 > CropImageView.DEFAULT_ASPECT_RATIO) {
                                f -= f3;
                            } else {
                                float f4 = (-fIntBitsToFloat) / 2.0f;
                                if (f < f4) {
                                    f = f4;
                                }
                            }
                            float f5 = (fIntBitsToFloat2 - (mutableRect.bottom - mutableRect.top)) / 2.0f;
                            if (f5 > CropImageView.DEFAULT_ASPECT_RATIO) {
                                f2 -= f5;
                            } else {
                                float f6 = (-fIntBitsToFloat2) / 2.0f;
                                if (f2 < f6) {
                                    f2 = f6;
                                }
                            }
                            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L);
                        }
                    } else {
                        jFloatToRawIntBits = 0;
                    }
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
                    long j2 = this.measuredSize;
                    float f7 = (int) (j2 >> 32);
                    int i = (int) (jM667getMinimumTouchTargetSizeNHjbRc >> 32);
                    float f8 = (int) (j2 & 4294967295L);
                    int i2 = (int) (jM667getMinimumTouchTargetSizeNHjbRc & 4294967295L);
                    mutableRect.intersect(fIntBitsToFloat3, fIntBitsToFloat4, Math.min(Float.intBitsToFloat(i) + f7, Math.max(f7, Float.intBitsToFloat(i) + fIntBitsToFloat3)), Math.min(Float.intBitsToFloat(i2) + f8, Math.max(f8, Float.intBitsToFloat(i2) + fIntBitsToFloat4)));
                } else if (z) {
                    long j3 = this.measuredSize;
                    mutableRect.intersect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (int) (j3 >> 32), (int) (j3 & 4294967295L));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
            float[] fArrM705getMatrixsQKQjiQ = graphicsLayerOwnerLayer.m705getMatrixsQKQjiQ();
            if (!graphicsLayerOwnerLayer.isIdentity) {
                if (fArrM705getMatrixsQKQjiQ == null) {
                    mutableRect.left = CropImageView.DEFAULT_ASPECT_RATIO;
                    mutableRect.top = CropImageView.DEFAULT_ASPECT_RATIO;
                    mutableRect.right = CropImageView.DEFAULT_ASPECT_RATIO;
                    mutableRect.bottom = CropImageView.DEFAULT_ASPECT_RATIO;
                } else {
                    Matrix.m509mapimpl(fArrM705getMatrixsQKQjiQ, mutableRect);
                }
            }
        }
        long j4 = this.position;
        float f9 = (int) (j4 >> 32);
        mutableRect.left += f9;
        mutableRect.right += f9;
        float f10 = (int) (j4 & 4294967295L);
        mutableRect.top += f10;
        mutableRect.bottom += f10;
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock(null, false);
            this.layoutNode.requestRelayout$ui(false);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void replace$ui() throws Throwable {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        long j = this.position;
        if (graphicsLayer != null) {
            mo616placeAtf8xVGno(j, this.zIndex, graphicsLayer);
        } else {
            mo602placeAtf8xVGno(j, this.zIndex, this.layerBlock);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public final long mo609screenToLocalMKHz9U(long j) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return mo605localPositionOfS_NoaFU(RulerKt.findRootCoordinates(this), ((AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode)).m690screenToLocalMKHz9U(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [androidx.compose.runtime.collection.MutableVector] */
    public final void setMeasureResult$ui(MeasureResult measureResult) {
        NodeCoordinator nodeCoordinator;
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            LayoutNode layoutNode = this.layoutNode;
            int i = 0;
            if (measureResult2 == null || measureResult.getWidth() != measureResult2.getWidth() || measureResult.getHeight() != measureResult2.getHeight()) {
                int width = measureResult.getWidth();
                int height = measureResult.getHeight();
                OwnedLayer ownedLayer = this.layer;
                if (ownedLayer != null) {
                    ((GraphicsLayerOwnerLayer) ownedLayer).m707resizeozmzZPI((((long) width) << 32) | (((long) height) & 4294967295L));
                } else if (layoutNode.isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
                    nodeCoordinator.invalidateLayer();
                }
                m617setMeasuredSizeozmzZPI((((long) height) & 4294967295L) | (((long) width) << 32));
                if (this.layerBlock != null) {
                    updateLayerParameters(false);
                }
                boolean zM678getIncludeSelfInTraversalH91voCI = NodeKindKt.m678getIncludeSelfInTraversalH91voCI(4);
                Modifier.Node tail = getTail();
                if (zM678getIncludeSelfInTraversalH91voCI || (tail = tail.parent) != null) {
                    for (Modifier.Node nodeHeadNode = headNode(zM678getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & 4) != 0; nodeHeadNode = nodeHeadNode.child) {
                        if ((nodeHeadNode.kindSet & 4) != 0) {
                            ?? Pop = nodeHeadNode;
                            ?? mutableVector = 0;
                            while (Pop != 0) {
                                if (Pop instanceof DrawModifierNode) {
                                    ((DrawModifierNode) Pop).onMeasureResultChanged();
                                } else if ((Pop.kindSet & 4) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node = ((DelegatingNode) Pop).delegate;
                                    int i2 = 0;
                                    Pop = Pop;
                                    mutableVector = mutableVector;
                                    while (node != null) {
                                        if ((node.kindSet & 4) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                mutableVector = mutableVector;
                                                Pop = node;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(node);
                                            }
                                        }
                                        node = node.child;
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                Pop = HitTestResultKt.pop(mutableVector);
                            }
                        }
                        if (nodeHeadNode == tail) {
                            break;
                        }
                    }
                }
                Owner owner = layoutNode.owner;
                if (owner != null) {
                    ((AndroidComposeView) owner).onLayoutChange(layoutNode);
                }
                layoutNode.onCoordinatorRectChanged$ui(this);
            }
            MutableObjectIntMap mutableObjectIntMap = this.oldAlignmentLines;
            if ((mutableObjectIntMap == null || mutableObjectIntMap._size == 0) && measureResult.getAlignmentLines().isEmpty()) {
                return;
            }
            MutableObjectIntMap mutableObjectIntMap2 = this.oldAlignmentLines;
            Map alignmentLines = measureResult.getAlignmentLines();
            if (mutableObjectIntMap2 != null && mutableObjectIntMap2._size == alignmentLines.size()) {
                Object[] objArr = mutableObjectIntMap2.keys;
                int[] iArr = mutableObjectIntMap2.values;
                long[] jArr = mutableObjectIntMap2.metadata;
                int length = jArr.length - 2;
                if (length < 0) {
                    return;
                }
                int i3 = 0;
                loop0: while (true) {
                    long j = jArr[i3];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                        for (int i5 = i; i5 < i4; i5++) {
                            if ((255 & j) < 128) {
                                int i6 = (i3 << 3) + i5;
                                Object obj = objArr[i6];
                                int i7 = iArr[i6];
                                Integer num = (Integer) alignmentLines.get((AlignmentLine) obj);
                                if (num == null || num.intValue() != i7) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i4 != 8) {
                            return;
                        }
                    }
                    if (i3 == length) {
                        return;
                    }
                    i3++;
                    i = 0;
                }
            }
            layoutNode.layoutDelegate.measurePassDelegate.alignmentLines.onAlignmentsChanged();
            MutableObjectIntMap mutableObjectIntMap3 = this.oldAlignmentLines;
            if (mutableObjectIntMap3 == null) {
                MutableObjectIntMap mutableObjectIntMap4 = ObjectIntMapKt.EmptyObjectIntMap;
                mutableObjectIntMap3 = new MutableObjectIntMap();
                this.oldAlignmentLines = mutableObjectIntMap3;
            }
            mutableObjectIntMap3.clear();
            for (Map.Entry entry : measureResult.getAlignmentLines().entrySet()) {
                mutableObjectIntMap3.set(((Number) entry.getValue()).intValue(), entry.getKey());
            }
        }
    }

    /* JADX INFO: renamed from: speculativeHit-Fh5PU_I, reason: not valid java name */
    public final void m674speculativeHitFh5PU_I(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z, float f) {
        int i2;
        MutableObjectList mutableObjectList = hitTestResult.values;
        if (node == null) {
            mo647hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
            return;
        }
        if (!hitTestSource.shouldHitTest(node)) {
            m674speculativeHitFh5PU_I(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f);
            return;
        }
        if (!hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            m672outOfBoundsHit8NAm7pk(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f, false);
            return;
        }
        MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
        int i3 = hitTestResult.hitDepth;
        int i4 = mutableObjectList._size;
        if (i3 != i4 - 1) {
            long jM640findBestHitDistancefn2tFes = hitTestResult.m640findBestHitDistancefn2tFes();
            int i5 = hitTestResult.hitDepth;
            int i6 = mutableObjectList._size;
            int i7 = i6 - 1;
            hitTestResult.hitDepth = i7;
            hitTestResult.removeNodesInRange(i6, mutableObjectList._size);
            hitTestResult.hitDepth++;
            mutableObjectList.add(node);
            mutableLongList.add(HitTestResultKt.DistanceAndFlags(f, z, false));
            m672outOfBoundsHit8NAm7pk(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f, false);
            hitTestResult.hitDepth = i7;
            long jM640findBestHitDistancefn2tFes2 = hitTestResult.m640findBestHitDistancefn2tFes();
            if (hitTestResult.hitDepth + 1 >= mutableObjectList._size - 1 || HitTestResultKt.m641compareTo9YPOF3E(jM640findBestHitDistancefn2tFes, jM640findBestHitDistancefn2tFes2) <= 0) {
                hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, mutableObjectList._size);
            } else {
                int i8 = i5 + 1;
                boolean zM643isInExpandedBoundsimpl = HitTestResultKt.m643isInExpandedBoundsimpl(jM640findBestHitDistancefn2tFes2);
                int i9 = hitTestResult.hitDepth;
                hitTestResult.removeNodesInRange(i8, zM643isInExpandedBoundsimpl ? i9 + 2 : i9 + 1);
            }
            hitTestResult.hitDepth = i5;
            return;
        }
        int i10 = i3 + 1;
        hitTestResult.removeNodesInRange(i10, i4);
        hitTestResult.hitDepth++;
        mutableObjectList.add(node);
        mutableLongList.add(HitTestResultKt.DistanceAndFlags(f, z, false));
        m672outOfBoundsHit8NAm7pk(HitTestResultKt.m645nextUntilhw7D004(node, hitTestSource.mo639entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, i, z, f, false);
        hitTestResult.hitDepth = i3;
        if (i10 == mutableObjectList._size - 1 || HitTestResultKt.m643isInExpandedBoundsimpl(hitTestResult.m640findBestHitDistancefn2tFes())) {
            int i11 = hitTestResult.hitDepth;
            int i12 = i11 + 1;
            mutableObjectList.removeAt(i12);
            if (i12 < 0 || i12 >= (i2 = mutableLongList._size)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
                return;
            }
            long[] jArr = mutableLongList.content;
            long j2 = jArr[i12];
            if (i12 != i2 - 1) {
                ArraysKt.copyInto(jArr, jArr, i12, i11 + 2, i2);
            }
            mutableLongList._size--;
        }
    }

    public final Rect touchBoundsInRoot() {
        if (getTail().isAttached) {
            LayoutCoordinates layoutCoordinatesFindRootCoordinates = RulerKt.findRootCoordinates(this);
            MutableRect mutableRect = this._rectCache;
            if (mutableRect == null) {
                mutableRect = new MutableRect();
                this._rectCache = mutableRect;
            }
            long jM664calculateMinimumTouchTargetPaddingE7KxVPU = m664calculateMinimumTouchTargetPaddingE7KxVPU(m667getMinimumTouchTargetSizeNHjbRc());
            boolean useOutline = getUseOutline();
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            float f2 = useOutline ? this.lastOutlineBounds.left : 0.0f;
            if (getUseOutline()) {
                f = this.lastOutlineBounds.top;
            }
            float measuredWidth = getUseOutline() ? this.lastOutlineBounds.right : getMeasuredWidth();
            float measuredHeight = getUseOutline() ? this.lastOutlineBounds.bottom : getMeasuredHeight();
            int i = (int) (jM664calculateMinimumTouchTargetPaddingE7KxVPU >> 32);
            mutableRect.left = f2 - Float.intBitsToFloat(i);
            int i2 = (int) (jM664calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L);
            mutableRect.top = f - Float.intBitsToFloat(i2);
            mutableRect.right = Float.intBitsToFloat(i) + measuredWidth;
            mutableRect.bottom = Float.intBitsToFloat(i2) + measuredHeight;
            while (this != layoutCoordinatesFindRootCoordinates) {
                this.rectInParent$ui(mutableRect, false, true);
                if (!mutableRect.isEmpty()) {
                    this = this.wrappedBy;
                    this.getClass();
                }
            }
            return new Rect(mutableRect.left, mutableRect.top, mutableRect.right, mutableRect.bottom);
        }
        return Rect.Zero;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public final void mo610transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        Matrix.m510resetimpl(fArr);
        coordinator.m676transformToAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui, fArr);
        m675transformFromAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui, fArr);
    }

    /* JADX INFO: renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    public final void m675transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        float[] fArrM704getInverseMatrix3i98HWw;
        if (Intrinsics.areEqual(nodeCoordinator, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        nodeCoordinator2.getClass();
        nodeCoordinator2.m675transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
        if (!IntOffset.m804equalsimpl0(this.position, 0L)) {
            float[] fArr2 = tmpMatrix;
            Matrix.m510resetimpl(fArr2);
            long j = this.position;
            Matrix.m514translateimpl(fArr2, -((int) (j >> 32)), -((int) (j & 4294967295L)));
            Matrix.m513timesAssign58bKbWc(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || (fArrM704getInverseMatrix3i98HWw = ((GraphicsLayerOwnerLayer) ownedLayer).m704getInverseMatrix3i98HWw()) == null) {
            return;
        }
        Matrix.m513timesAssign58bKbWc(fArr, fArrM704getInverseMatrix3i98HWw);
    }

    /* JADX INFO: renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    public final void m676transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        while (!this.equals(nodeCoordinator)) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                Matrix.m513timesAssign58bKbWc(fArr, ((GraphicsLayerOwnerLayer) ownedLayer).m705getMatrixsQKQjiQ());
            }
            long j = this.position;
            if (!IntOffset.m804equalsimpl0(j, 0L)) {
                float[] fArr2 = tmpMatrix;
                Matrix.m510resetimpl(fArr2);
                Matrix.m514translateimpl(fArr2, (int) (j >> 32), (int) (j & 4294967295L));
                Matrix.m513timesAssign58bKbWc(fArr, fArr2);
            }
            this = this.wrappedBy;
            this.getClass();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public final void mo611transformToScreen58bKbWc(float[] fArr) {
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(this.layoutNode);
        NodeCoordinator coordinator = toCoordinator(RulerKt.findRootCoordinates(this));
        m676transformToAncestorEL8BTi8(coordinator, fArr);
        if (ownerRequireOwner instanceof MatrixPositionCalculator) {
            ((AndroidComposeView) ((MatrixPositionCalculator) ownerRequireOwner)).m685localToScreen58bKbWc(fArr);
            return;
        }
        long jMo607localToScreenMKHz9U = coordinator.mo607localToScreenMKHz9U(0L);
        if ((9223372034707292159L & jMo607localToScreenMKHz9U) != 9205357640488583168L) {
            Matrix.m514translateimpl(fArr, Float.intBitsToFloat((int) (jMo607localToScreenMKHz9U >> 32)), Float.intBitsToFloat((int) (jMo607localToScreenMKHz9U & 4294967295L)));
        }
    }

    public final void updateLayerBlock(Function1 function1, boolean z) {
        Owner owner;
        MutableVector mutableVector;
        Reference referencePoll;
        if (function1 != null && this.explicitLayer != null) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        byte b = 0;
        LayoutNode layoutNode = this.layoutNode;
        boolean z2 = (!z && this.layerBlock == function1 && Intrinsics.areEqual(this.layerDensity, layoutNode.density) && this.layerLayoutDirection == layoutNode.layoutDirection) ? false : true;
        this.layerDensity = layoutNode.density;
        this.layerLayoutDirection = layoutNode.layoutDirection;
        boolean zIsAttached$1 = layoutNode.isAttached$1();
        NodeCoordinator$$ExternalSyntheticLambda2 nodeCoordinator$$ExternalSyntheticLambda2 = this.invalidateParentLayer;
        if (zIsAttached$1 && function1 != null) {
            this.layerBlock = function1;
            if (this.layer != null) {
                if (z2) {
                    updateLayerParameters(true);
                    return;
                }
                return;
            }
            Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode);
            ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda1 = this._drawBlock;
            if (buttonKt$$ExternalSyntheticLambda1 == null) {
                ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda2 = new ButtonKt$$ExternalSyntheticLambda1(this, new NodeCoordinator$$ExternalSyntheticLambda2(this, b), (byte) 29);
                this._drawBlock = buttonKt$$ExternalSyntheticLambda2;
                buttonKt$$ExternalSyntheticLambda1 = buttonKt$$ExternalSyntheticLambda2;
            }
            OwnedLayer ownedLayerCreateLayer = ((AndroidComposeView) ownerRequireOwner).createLayer(buttonKt$$ExternalSyntheticLambda1, nodeCoordinator$$ExternalSyntheticLambda2, null);
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayerCreateLayer;
            graphicsLayerOwnerLayer.m707resizeozmzZPI(this.measuredSize);
            graphicsLayerOwnerLayer.m706movegyyYBs(this.position);
            this.layer = ownedLayerCreateLayer;
            updateLayerParameters(true);
            layoutNode.innerLayerCoordinatorIsDirty = true;
            nodeCoordinator$$ExternalSyntheticLambda2.invoke();
            return;
        }
        this.layerBlock = null;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer2 = (GraphicsLayerOwnerLayer) ownedLayer;
            if (!ColorKt.m492isIdentity58bKbWc(graphicsLayerOwnerLayer2.m705getMatrixsQKQjiQ())) {
                layoutNode.onCoordinatorRectChanged$ui(this);
            }
            graphicsLayerOwnerLayer2.drawBlock = null;
            graphicsLayerOwnerLayer2.invalidateParentLayer = null;
            graphicsLayerOwnerLayer2.isDestroyed = true;
            graphicsLayerOwnerLayer2.setDirty(false);
            GraphicsContext graphicsContext = graphicsLayerOwnerLayer2.context;
            if (graphicsContext != null) {
                graphicsContext.releaseGraphicsLayer(graphicsLayerOwnerLayer2.graphicsLayer);
                AndroidComposeView androidComposeView = graphicsLayerOwnerLayer2.ownerView;
                WeakCache weakCache = androidComposeView.layerCache;
                do {
                    ReferenceQueue referenceQueue = (ReferenceQueue) weakCache.referenceQueue;
                    mutableVector = (MutableVector) weakCache.values;
                    referencePoll = referenceQueue.poll();
                    if (referencePoll != null) {
                        mutableVector.remove(referencePoll);
                    }
                } while (referencePoll != null);
                mutableVector.add(new java.lang.ref.WeakReference(graphicsLayerOwnerLayer2, (ReferenceQueue) weakCache.referenceQueue));
                androidComposeView.dirtyLayers.remove(graphicsLayerOwnerLayer2);
            }
            this.layer = null;
            layoutNode.innerLayerCoordinatorIsDirty = true;
            nodeCoordinator$$ExternalSyntheticLambda2.invoke();
            if (getTail().isAttached && layoutNode.isPlaced() && (owner = layoutNode.owner) != null) {
                ((AndroidComposeView) owner).onLayoutChange(layoutNode);
            }
        }
        this.lastLayerDrawingWasSkipped = false;
    }

    public final void updateLayerParameters(boolean z) {
        float f;
        char c;
        long j;
        boolean z2;
        LayoutNode layoutNode;
        Function0 function0;
        Function0 function1;
        if (this.explicitLayer != null) {
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        Function1 function2 = this.layerBlock;
        if (ownedLayer == null) {
            if (function2 == null) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
            return;
        }
        if (function2 == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m$2("updateLayerParameters requires a non-null layerBlock");
        }
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
        reusableGraphicsLayerScope.reset$1$1();
        LayoutNode layoutNode2 = this.layoutNode;
        reusableGraphicsLayerScope.graphicsDensity = layoutNode2.density;
        reusableGraphicsLayerScope.layoutDirection = layoutNode2.layoutDirection;
        reusableGraphicsLayerScope.size = SizeKt.m876toSizeozmzZPI(this.measuredSize);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode2)).getSnapshotObserver().observer.observeReads(this, onCommitAffectingLayerParams, new GapComposer$$ExternalSyntheticLambda0(function2, this, ref$BooleanRef, (byte) 11));
        LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
        if (layerPositionalProperties == null) {
            layerPositionalProperties = new LayerPositionalProperties();
            this.layerPositionalProperties = layerPositionalProperties;
        }
        LayerPositionalProperties layerPositionalProperties2 = tmpLayerPositionalProperties;
        layerPositionalProperties2.getClass();
        layerPositionalProperties2.scaleX = layerPositionalProperties.scaleX;
        layerPositionalProperties2.scaleY = layerPositionalProperties.scaleY;
        layerPositionalProperties2.translationX = layerPositionalProperties.translationX;
        layerPositionalProperties2.translationY = layerPositionalProperties.translationY;
        layerPositionalProperties2.rotationZ = layerPositionalProperties.rotationZ;
        layerPositionalProperties2.cameraDistance = layerPositionalProperties.cameraDistance;
        layerPositionalProperties2.transformOrigin = layerPositionalProperties.transformOrigin;
        layerPositionalProperties.scaleX = reusableGraphicsLayerScope.scaleX;
        layerPositionalProperties.scaleY = reusableGraphicsLayerScope.scaleY;
        layerPositionalProperties.translationX = reusableGraphicsLayerScope.translationX;
        layerPositionalProperties.translationY = reusableGraphicsLayerScope.translationY;
        layerPositionalProperties.rotationZ = reusableGraphicsLayerScope.rotationZ;
        layerPositionalProperties.cameraDistance = reusableGraphicsLayerScope.cameraDistance;
        layerPositionalProperties.transformOrigin = reusableGraphicsLayerScope.transformOrigin;
        GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
        AndroidComposeView androidComposeView = graphicsLayerOwnerLayer.ownerView;
        int i = reusableGraphicsLayerScope.mutatedFields | graphicsLayerOwnerLayer.mutatedFields;
        graphicsLayerOwnerLayer.layoutDirection = reusableGraphicsLayerScope.layoutDirection;
        Density density = reusableGraphicsLayerScope.graphicsDensity;
        graphicsLayerOwnerLayer.density = density;
        if ((1048576 & i) != 0) {
            GraphicsLayer graphicsLayer = graphicsLayerOwnerLayer.graphicsLayer;
            reusableGraphicsLayerScope.outsets.getClass();
            int iMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
            reusableGraphicsLayerScope.outsets.getClass();
            int iMo75roundToPx0680j_5 = density.mo75roundToPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
            reusableGraphicsLayerScope.outsets.getClass();
            int iMo75roundToPx0680j_6 = density.mo75roundToPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
            reusableGraphicsLayerScope.outsets.getClass();
            int iMo75roundToPx0680j_7 = density.mo75roundToPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
            graphicsLayer.outsetLeft = iMo75roundToPx0680j_4;
            graphicsLayer.outsetTop = iMo75roundToPx0680j_5;
            graphicsLayer.outsetRight = iMo75roundToPx0680j_6;
            graphicsLayer.outsetBottom = iMo75roundToPx0680j_7;
            graphicsLayer.impl.setOutsets(iMo75roundToPx0680j_4, iMo75roundToPx0680j_5, iMo75roundToPx0680j_6, iMo75roundToPx0680j_7);
            graphicsLayerOwnerLayer.invalidate();
        }
        int i2 = i & 4096;
        if (i2 != 0) {
            graphicsLayerOwnerLayer.transformOrigin = reusableGraphicsLayerScope.transformOrigin;
        }
        if ((i & 1) != 0) {
            GraphicsLayer graphicsLayer2 = graphicsLayerOwnerLayer.graphicsLayer;
            float f2 = reusableGraphicsLayerScope.scaleX;
            GraphicsLayerImpl graphicsLayerImpl = graphicsLayer2.impl;
            if (graphicsLayerImpl.getScaleX() != f2) {
                graphicsLayerImpl.setScaleX(f2);
            }
        }
        if ((i & 2) != 0) {
            GraphicsLayer graphicsLayer3 = graphicsLayerOwnerLayer.graphicsLayer;
            float f3 = reusableGraphicsLayerScope.scaleY;
            GraphicsLayerImpl graphicsLayerImpl2 = graphicsLayer3.impl;
            if (graphicsLayerImpl2.getScaleY() != f3) {
                graphicsLayerImpl2.setScaleY(f3);
            }
        }
        if ((i & 4) != 0) {
            graphicsLayerOwnerLayer.graphicsLayer.setAlpha(reusableGraphicsLayerScope.alpha);
        }
        if ((i & 8) != 0) {
            GraphicsLayer graphicsLayer4 = graphicsLayerOwnerLayer.graphicsLayer;
            float f4 = reusableGraphicsLayerScope.translationX;
            GraphicsLayerImpl graphicsLayerImpl3 = graphicsLayer4.impl;
            if (graphicsLayerImpl3.getTranslationX() != f4) {
                graphicsLayerImpl3.setTranslationX(f4);
            }
        }
        if ((i & 16) != 0) {
            GraphicsLayer graphicsLayer5 = graphicsLayerOwnerLayer.graphicsLayer;
            float f5 = reusableGraphicsLayerScope.translationY;
            GraphicsLayerImpl graphicsLayerImpl4 = graphicsLayer5.impl;
            if (graphicsLayerImpl4.getTranslationY() != f5) {
                graphicsLayerImpl4.setTranslationY(f5);
            }
        }
        if ((i & 32) != 0) {
            GraphicsLayer graphicsLayer6 = graphicsLayerOwnerLayer.graphicsLayer;
            float f6 = reusableGraphicsLayerScope.shadowElevation;
            GraphicsLayerImpl graphicsLayerImpl5 = graphicsLayer6.impl;
            if (graphicsLayerImpl5.getShadowElevation() != f6) {
                graphicsLayerImpl5.setShadowElevation(f6);
                graphicsLayer6.outlineDirty = true;
                graphicsLayer6.configureOutlineAndClip();
            }
            if (reusableGraphicsLayerScope.shadowElevation > CropImageView.DEFAULT_ASPECT_RATIO && !graphicsLayerOwnerLayer.drawnWithEnabledZ && (function1 = graphicsLayerOwnerLayer.invalidateParentLayer) != null) {
                function1.invoke();
            }
        }
        if ((i & 64) != 0) {
            GraphicsLayer graphicsLayer7 = graphicsLayerOwnerLayer.graphicsLayer;
            long j2 = reusableGraphicsLayerScope.ambientShadowColor;
            GraphicsLayerImpl graphicsLayerImpl6 = graphicsLayer7.impl;
            f = 0.0f;
            if (!ULong.m1869equalsimpl0(j2, graphicsLayerImpl6.mo559getAmbientShadowColor0d7_KjU())) {
                graphicsLayerImpl6.mo563setAmbientShadowColor8_81llA(j2);
            }
        } else {
            f = 0.0f;
        }
        if ((i & 128) != 0) {
            GraphicsLayer graphicsLayer8 = graphicsLayerOwnerLayer.graphicsLayer;
            long j3 = reusableGraphicsLayerScope.spotShadowColor;
            GraphicsLayerImpl graphicsLayerImpl7 = graphicsLayer8.impl;
            if (!ULong.m1869equalsimpl0(j3, graphicsLayerImpl7.mo562getSpotShadowColor0d7_KjU())) {
                graphicsLayerImpl7.mo569setSpotShadowColor8_81llA(j3);
            }
        }
        if ((i & 1024) != 0) {
            GraphicsLayer graphicsLayer9 = graphicsLayerOwnerLayer.graphicsLayer;
            float f7 = reusableGraphicsLayerScope.rotationZ;
            GraphicsLayerImpl graphicsLayerImpl8 = graphicsLayer9.impl;
            if (graphicsLayerImpl8.getRotationZ() != f7) {
                graphicsLayerImpl8.setRotationZ(f7);
            }
        }
        if ((i & 256) != 0) {
            GraphicsLayerImpl graphicsLayerImpl9 = graphicsLayerOwnerLayer.graphicsLayer.impl;
            if (graphicsLayerImpl9.getRotationX() != f) {
                graphicsLayerImpl9.setRotationX();
            }
        }
        if ((i & 512) != 0) {
            GraphicsLayerImpl graphicsLayerImpl10 = graphicsLayerOwnerLayer.graphicsLayer.impl;
            if (graphicsLayerImpl10.getRotationY() != f) {
                graphicsLayerImpl10.setRotationY();
            }
        }
        if ((i & 2048) != 0) {
            GraphicsLayer graphicsLayer10 = graphicsLayerOwnerLayer.graphicsLayer;
            float f8 = reusableGraphicsLayerScope.cameraDistance;
            GraphicsLayerImpl graphicsLayerImpl11 = graphicsLayer10.impl;
            if (graphicsLayerImpl11.getCameraDistance() != f8) {
                graphicsLayerImpl11.setCameraDistance(f8);
            }
        }
        if (i2 != 0) {
            j = 4294967295L;
            boolean zM519equalsimpl0 = TransformOrigin.m519equalsimpl0(graphicsLayerOwnerLayer.transformOrigin, ColorKt.TransformOrigin(0.5f, 0.5f));
            GraphicsLayer graphicsLayer11 = graphicsLayerOwnerLayer.graphicsLayer;
            if (zM519equalsimpl0) {
                c = ' ';
                if (!Offset.m434equalsimpl0(graphicsLayer11.pivotOffset, 9205357640488583168L)) {
                    graphicsLayer11.pivotOffset = 9205357640488583168L;
                    graphicsLayer11.impl.mo567setPivotOffsetk4lQ0M(9205357640488583168L);
                }
            } else {
                c = ' ';
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (graphicsLayerOwnerLayer.transformOrigin & 4294967295L)) * ((int) (graphicsLayerOwnerLayer.size & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (graphicsLayerOwnerLayer.transformOrigin >> 32)) * ((int) (graphicsLayerOwnerLayer.size >> 32)))) << 32);
                if (!Offset.m434equalsimpl0(graphicsLayer11.pivotOffset, jFloatToRawIntBits)) {
                    graphicsLayer11.pivotOffset = jFloatToRawIntBits;
                    graphicsLayer11.impl.mo567setPivotOffsetk4lQ0M(jFloatToRawIntBits);
                }
            }
        } else {
            c = ' ';
            j = 4294967295L;
        }
        if ((i & 16384) != 0) {
            graphicsLayerOwnerLayer.graphicsLayer.setClip(reusableGraphicsLayerScope.clip);
        }
        if ((131072 & i) != 0) {
            GraphicsLayer graphicsLayer12 = graphicsLayerOwnerLayer.graphicsLayer;
            RenderEffect renderEffect = reusableGraphicsLayerScope.renderEffect;
            GraphicsLayerImpl graphicsLayerImpl12 = graphicsLayer12.impl;
            if (!Intrinsics.areEqual(graphicsLayerImpl12.getRenderEffect(), renderEffect)) {
                graphicsLayerImpl12.setRenderEffect(renderEffect);
            }
        }
        if ((262144 & i) != 0) {
            GraphicsLayerImpl graphicsLayerImpl13 = graphicsLayerOwnerLayer.graphicsLayer.impl;
            if (!Intrinsics.areEqual(graphicsLayerImpl13.getColorFilter(), (Object) null)) {
                graphicsLayerImpl13.setColorFilter();
            }
        }
        if ((524288 & i) != 0) {
            GraphicsLayer graphicsLayer13 = graphicsLayerOwnerLayer.graphicsLayer;
            byte b = reusableGraphicsLayerScope.blendMode;
            GraphicsLayerImpl graphicsLayerImpl14 = graphicsLayer13.impl;
            if (graphicsLayerImpl14.mo560getBlendMode0nO6VwU() != b) {
                graphicsLayerImpl14.mo564setBlendModes9anfk8(b);
            }
        }
        if ((32768 & i) != 0) {
            GraphicsLayerImpl graphicsLayerImpl15 = graphicsLayerOwnerLayer.graphicsLayer.impl;
            if (graphicsLayerImpl15.mo561getCompositingStrategyke2Ky5w() != 0) {
                graphicsLayerImpl15.mo565setCompositingStrategyWpw9cng(0);
            }
        }
        if ((i & 7963) != 0) {
            graphicsLayerOwnerLayer.isMatrixDirty = true;
            graphicsLayerOwnerLayer.isInverseMatrixDirty = true;
        }
        if (Intrinsics.areEqual(graphicsLayerOwnerLayer.outline, reusableGraphicsLayerScope.outline)) {
            layoutNode2 = layoutNode2;
            ref$BooleanRef = ref$BooleanRef;
            z2 = false;
        } else {
            ColorKt colorKt = reusableGraphicsLayerScope.outline;
            graphicsLayerOwnerLayer.outline = colorKt;
            if (colorKt == null) {
                layoutNode2 = layoutNode2;
                ref$BooleanRef = ref$BooleanRef;
            } else {
                GraphicsLayer graphicsLayer14 = graphicsLayerOwnerLayer.graphicsLayer;
                if (colorKt instanceof Outline$Rectangle) {
                    Rect rect = ((Outline$Rectangle) colorKt).rect;
                    char c2 = c;
                    float f9 = rect.left;
                    float f10 = rect.top;
                    graphicsLayer14.m558setRoundRectOutlineTNW_H78((((long) Float.floatToRawIntBits(f9)) << c2) | (((long) Float.floatToRawIntBits(f10)) & j), (((long) Float.floatToRawIntBits(rect.right - rect.left)) << c2) | (((long) Float.floatToRawIntBits(rect.bottom - f10)) & j), CropImageView.DEFAULT_ASPECT_RATIO);
                } else {
                    char c3 = c;
                    if (colorKt instanceof Outline$Generic) {
                        AndroidPath androidPath = ((Outline$Generic) colorKt).path;
                        graphicsLayer14.internalOutline = null;
                        graphicsLayer14.roundRectOutlineSize = 9205357640488583168L;
                        graphicsLayer14.roundRectOutlineTopLeft = 0L;
                        graphicsLayer14.roundRectCornerRadius = CropImageView.DEFAULT_ASPECT_RATIO;
                        graphicsLayer14.outlineDirty = true;
                        graphicsLayer14.usePathForClip = false;
                        graphicsLayer14.outlinePath = androidPath;
                        graphicsLayer14.configureOutlineAndClip();
                    } else {
                        if (!(colorKt instanceof Outline$Rounded)) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return;
                        }
                        Outline$Rounded outline$Rounded = (Outline$Rounded) colorKt;
                        AndroidPath androidPath2 = outline$Rounded.roundRectPath;
                        if (androidPath2 != null) {
                            graphicsLayer14.internalOutline = null;
                            graphicsLayer14.roundRectOutlineSize = 9205357640488583168L;
                            graphicsLayer14.roundRectOutlineTopLeft = 0L;
                            graphicsLayer14.roundRectCornerRadius = CropImageView.DEFAULT_ASPECT_RATIO;
                            graphicsLayer14.outlineDirty = true;
                            graphicsLayer14.usePathForClip = false;
                            graphicsLayer14.outlinePath = androidPath2;
                            graphicsLayer14.configureOutlineAndClip();
                        } else {
                            RoundRect roundRect = outline$Rounded.roundRect;
                            graphicsLayer14.m558setRoundRectOutlineTNW_H78((((long) Float.floatToRawIntBits(roundRect.left)) << c3) | (((long) Float.floatToRawIntBits(roundRect.top)) & j), (((long) Float.floatToRawIntBits(roundRect.getWidth())) << c3) | (((long) Float.floatToRawIntBits(roundRect.getHeight())) & j), Float.intBitsToFloat((int) (roundRect.bottomLeftCornerRadius >> c3)));
                        }
                    }
                    if (Build.VERSION.SDK_INT < 33 && (((colorKt instanceof Outline$Generic) || ((colorKt instanceof Outline$Rounded) && !MathKt.isSimple(((Outline$Rounded) colorKt).roundRect))) && (function0 = graphicsLayerOwnerLayer.invalidateParentLayer) != null)) {
                        function0.invoke();
                    }
                }
                if (Build.VERSION.SDK_INT < 33) {
                    function0.invoke();
                }
            }
            z2 = true;
        }
        graphicsLayerOwnerLayer.mutatedFields = reusableGraphicsLayerScope.mutatedFields;
        if (i != 0 || z2) {
            ViewParent parent = androidComposeView.getParent();
            if (parent != null) {
                parent.onDescendantInvalidated(androidComposeView, androidComposeView);
            }
            if (AndroidComposeView.isArrEnabled$ui()) {
                androidComposeView.voteFrameRate(CropImageView.DEFAULT_ASPECT_RATIO);
            }
        }
        boolean z3 = this.isClipping;
        this.isClipping = reusableGraphicsLayerScope.clip;
        this.lastLayerAlpha = reusableGraphicsLayerScope.alpha;
        boolean z4 = layerPositionalProperties2.scaleX == layerPositionalProperties.scaleX && layerPositionalProperties2.scaleY == layerPositionalProperties.scaleY && layerPositionalProperties2.translationX == layerPositionalProperties.translationX && layerPositionalProperties2.translationY == layerPositionalProperties.translationY && layerPositionalProperties2.rotationZ == layerPositionalProperties.rotationZ && layerPositionalProperties2.cameraDistance == layerPositionalProperties.cameraDistance && TransformOrigin.m519equalsimpl0(layerPositionalProperties2.transformOrigin, layerPositionalProperties.transformOrigin);
        if (!z || (z4 && z3 == this.isClipping && !ref$BooleanRef.element)) {
            layoutNode = layoutNode2;
        } else {
            layoutNode = layoutNode2;
            Owner owner = layoutNode.owner;
            if (owner != null) {
                ((AndroidComposeView) owner).onLayoutChange(layoutNode);
            }
        }
        if (z4) {
            return;
        }
        layoutNode.onCoordinatorRectChanged$ui(this);
        if (layoutNode.globallyPositionedObservers > 0) {
            AndroidComposeView androidComposeView2 = (AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode);
            WeakCache weakCache = (WeakCache) androidComposeView2.measureAndLayoutDelegate.createdAtMillis;
            if (layoutNode.globallyPositionedObservers > 0) {
                ((MutableVector) weakCache.values).add(layoutNode);
                layoutNode.needsOnGloballyPositionedDispatch = true;
            }
            androidComposeView2.scheduleMeasureAndLayout(null);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public final long mo612windowToLocalMKHz9U(long j) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = RulerKt.findRootCoordinates(this);
        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode);
        androidComposeView.recalculateWindowPosition();
        return mo605localPositionOfS_NoaFU(layoutCoordinatesFindRootCoordinates, Offset.m438minusMKHz9U(Matrix.m508mapMKHz9U(j, androidComposeView.windowToViewMatrix), layoutCoordinatesFindRootCoordinates.mo606localToRootMKHz9U(0L)));
    }

    /* JADX WARN: Code duplicated, block: B:62:0x017c  */
    /* JADX INFO: renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    public final boolean m677withinLayerBoundsk4lQ0M(long j) {
        boolean z;
        boolean z2;
        boolean zM710isWithinEllipseVE1yxkc;
        if ((((9187343241974906880L ^ (j & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) != 0) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || !this.isClipping) {
            return true;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        GraphicsLayer graphicsLayer = ((GraphicsLayerOwnerLayer) ownedLayer).graphicsLayer;
        if (graphicsLayer.clip) {
            ColorKt outline = graphicsLayer.getOutline();
            if (outline instanceof Outline$Rectangle) {
                Rect rect = ((Outline$Rectangle) outline).rect;
                if (rect.left > fIntBitsToFloat || fIntBitsToFloat >= rect.right || rect.top > fIntBitsToFloat2 || fIntBitsToFloat2 >= rect.bottom) {
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = true;
            } else if (outline instanceof Outline$Rounded) {
                RoundRect roundRect = ((Outline$Rounded) outline).roundRect;
                float f = roundRect.left;
                long j2 = roundRect.topRightCornerRadius;
                long j3 = roundRect.bottomLeftCornerRadius;
                long j4 = roundRect.bottomRightCornerRadius;
                float f2 = roundRect.bottom;
                float f3 = roundRect.top;
                z = false;
                float f4 = roundRect.right;
                z2 = true;
                long j5 = roundRect.topLeftCornerRadius;
                if (fIntBitsToFloat >= f && fIntBitsToFloat < f4 && fIntBitsToFloat2 >= f3 && fIntBitsToFloat2 < f2) {
                    int i = (int) (j5 >> 32);
                    int i2 = (int) (j2 >> 32);
                    if (Float.intBitsToFloat(i2) + Float.intBitsToFloat(i) <= roundRect.getWidth()) {
                        int i3 = (int) (j3 >> 32);
                        int i4 = (int) (j4 >> 32);
                        if (Float.intBitsToFloat(i4) + Float.intBitsToFloat(i3) <= roundRect.getWidth()) {
                            int i5 = (int) (j5 & 4294967295L);
                            int i6 = (int) (j3 & 4294967295L);
                            if (Float.intBitsToFloat(i6) + Float.intBitsToFloat(i5) <= roundRect.getHeight()) {
                                int i7 = (int) (j2 & 4294967295L);
                                int i8 = (int) (j4 & 4294967295L);
                                if (Float.intBitsToFloat(i8) + Float.intBitsToFloat(i7) <= roundRect.getHeight()) {
                                    float fIntBitsToFloat3 = Float.intBitsToFloat(i) + f;
                                    float fIntBitsToFloat4 = Float.intBitsToFloat(i5) + f3;
                                    float fIntBitsToFloat5 = f4 - Float.intBitsToFloat(i2);
                                    float fIntBitsToFloat6 = Float.intBitsToFloat(i7) + f3;
                                    float fIntBitsToFloat7 = f4 - Float.intBitsToFloat(i4);
                                    float fIntBitsToFloat8 = f2 - Float.intBitsToFloat(i8);
                                    float fIntBitsToFloat9 = f2 - Float.intBitsToFloat(i6);
                                    float fIntBitsToFloat10 = Float.intBitsToFloat(i3) + f;
                                    if (fIntBitsToFloat < fIntBitsToFloat3 && fIntBitsToFloat2 < fIntBitsToFloat4) {
                                        zM710isWithinEllipseVE1yxkc = InvertMatrixKt.m710isWithinEllipseVE1yxkc(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, roundRect.topLeftCornerRadius);
                                    } else if (fIntBitsToFloat < fIntBitsToFloat10 && fIntBitsToFloat2 > fIntBitsToFloat9) {
                                        zM710isWithinEllipseVE1yxkc = InvertMatrixKt.m710isWithinEllipseVE1yxkc(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat10, fIntBitsToFloat9, roundRect.bottomLeftCornerRadius);
                                    } else if (fIntBitsToFloat <= fIntBitsToFloat5 || fIntBitsToFloat2 >= fIntBitsToFloat6) {
                                        zM710isWithinEllipseVE1yxkc = (fIntBitsToFloat <= fIntBitsToFloat7 || fIntBitsToFloat2 <= fIntBitsToFloat8) ? z2 : InvertMatrixKt.m710isWithinEllipseVE1yxkc(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat7, fIntBitsToFloat8, roundRect.bottomRightCornerRadius);
                                    } else {
                                        zM710isWithinEllipseVE1yxkc = InvertMatrixKt.m710isWithinEllipseVE1yxkc(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat5, fIntBitsToFloat6, roundRect.topRightCornerRadius);
                                    }
                                } else {
                                    AndroidPath androidPathPath = AndroidPath_androidKt.Path();
                                    AndroidPath.addRoundRect$default(androidPathPath, roundRect);
                                    zM710isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, androidPathPath);
                                }
                            } else {
                                AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
                                AndroidPath.addRoundRect$default(androidPathPath2, roundRect);
                                zM710isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, androidPathPath2);
                            }
                        } else {
                            AndroidPath androidPathPath3 = AndroidPath_androidKt.Path();
                            AndroidPath.addRoundRect$default(androidPathPath3, roundRect);
                            zM710isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, androidPathPath3);
                        }
                    } else {
                        AndroidPath androidPathPath4 = AndroidPath_androidKt.Path();
                        AndroidPath.addRoundRect$default(androidPathPath4, roundRect);
                        zM710isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, androidPathPath4);
                    }
                }
            } else {
                z = false;
                z2 = true;
                if (!(outline instanceof Outline$Generic)) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return false;
                }
                zM710isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, ((Outline$Generic) outline).path);
            }
            zM710isWithinEllipseVE1yxkc = z;
        } else {
            z = false;
            z2 = true;
        }
        return zM710isWithinEllipseVE1yxkc ? z2 : z;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutCoordinates getCoordinates() {
        return this;
    }
}
