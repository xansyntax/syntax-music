package androidx.compose.foundation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.emoji2.text.EmojiProcessor;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeEffectNode$$ExternalSyntheticLambda2;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {
    public StandaloneCoroutine animationJob;
    public int initialDelayMillis;
    public int iterations;
    public GraphicsLayer marqueeLayer;
    public final ParcelableSnapshotMutableState spacing$delegate;
    public final DerivedSnapshotState spacingPx$delegate;
    public float velocity;
    public short delayMillis = 1200;
    public final ParcelableSnapshotMutableIntState contentWidth$delegate = new ParcelableSnapshotMutableIntState(0);
    public final ParcelableSnapshotMutableIntState containerWidth$delegate = new ParcelableSnapshotMutableIntState(0);
    public final ParcelableSnapshotMutableState hasFocus$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public final ParcelableSnapshotMutableState animationMode$delegate = Stack.mutableStateOf$default(new MarqueeAnimationMode());
    public final Animatable offset = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);

    public MarqueeModifierNode(int i, int i2, MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0, float f) {
        this.iterations = i;
        this.initialDelayMillis = i2;
        this.velocity = f;
        this.spacing$delegate = Stack.mutableStateOf$default(marqueeSpacing$Companion$$ExternalSyntheticLambda0);
        this.spacingPx$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new Recomposer$$ExternalSyntheticLambda6((Object) marqueeSpacing$Companion$$ExternalSyntheticLambda0, (Object) this, (byte) 5));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        float intValue;
        float fFloatValue;
        int intValue2;
        long j;
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        int iM795compareTo0680j_4 = Dp.m795compareTo0680j_4(this.velocity, CropImageView.DEFAULT_ASPECT_RATIO);
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.containerWidth$delegate;
        Animatable animatable = this.offset;
        byte b = 1;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = this.contentWidth$delegate;
        if (iM795compareTo0680j_4 > 0) {
            int iOrdinal = layoutNodeDrawScope.getLayoutDirection().ordinal();
            if (iOrdinal == 0) {
                intValue = ((Number) animatable.getValue()).floatValue();
            } else if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            } else {
                fFloatValue = (-((Number) animatable.getValue()).floatValue()) + (parcelableSnapshotMutableIntState2.getIntValue() * 2) + getSpacingPx();
                intValue2 = parcelableSnapshotMutableIntState.getIntValue();
                intValue = fFloatValue - intValue2;
            }
        } else {
            int iOrdinal2 = layoutNodeDrawScope.getLayoutDirection().ordinal();
            if (iOrdinal2 == 0) {
                intValue = (-((Number) animatable.getValue()).floatValue()) + parcelableSnapshotMutableIntState2.getIntValue() + getSpacingPx();
            } else if (iOrdinal2 != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            } else {
                fFloatValue = ((Number) animatable.getValue()).floatValue() + parcelableSnapshotMutableIntState2.getIntValue();
                intValue2 = parcelableSnapshotMutableIntState.getIntValue();
                intValue = fFloatValue - intValue2;
            }
        }
        boolean z = intValue < ((float) parcelableSnapshotMutableIntState2.getIntValue());
        boolean z2 = ((float) parcelableSnapshotMutableIntState.getIntValue()) + intValue > ((float) (getSpacingPx() + parcelableSnapshotMutableIntState2.getIntValue()));
        float spacingPx = getSpacingPx() + parcelableSnapshotMutableIntState2.getIntValue();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L));
        GraphicsLayer graphicsLayer = this.marqueeLayer;
        if (graphicsLayer != null) {
            j = 4294967295L;
            layoutNodeDrawScope.m651recordJVtK1S4((((long) MathKt.roundToInt(fIntBitsToFloat)) & 4294967295L) | (((long) parcelableSnapshotMutableIntState2.getIntValue()) << 32), graphicsLayer, new HazeEffectNode$$ExternalSyntheticLambda2(layoutNodeDrawScope, b));
        } else {
            j = 4294967295L;
        }
        float intValue3 = parcelableSnapshotMutableIntState.getIntValue();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & j));
        EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
        long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
        emojiProcessor.getCanvas().save();
        try {
            ((DrawResult) emojiProcessor.mSpanFactory).m401clipRectN_I0leg(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, intValue3, fIntBitsToFloat2, 1);
            float f = -intValue;
            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(f, CropImageView.DEFAULT_ASPECT_RATIO);
            try {
                GraphicsLayer graphicsLayer2 = this.marqueeLayer;
                if (graphicsLayer2 != null) {
                    if (z) {
                        LifecyclesKt.drawLayer(layoutNodeDrawScope, graphicsLayer2);
                    }
                    if (z2) {
                        ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(spacingPx, CropImageView.DEFAULT_ASPECT_RATIO);
                        try {
                            LifecyclesKt.drawLayer(layoutNodeDrawScope, graphicsLayer2);
                            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-spacingPx, -0.0f);
                        } catch (Throwable th) {
                            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-spacingPx, -0.0f);
                            throw th;
                        }
                    }
                } else {
                    if (z) {
                        layoutNodeDrawScope.drawContent();
                    }
                    if (z2) {
                        ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(spacingPx, CropImageView.DEFAULT_ASPECT_RATIO);
                        try {
                            layoutNodeDrawScope.drawContent();
                            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-spacingPx, -0.0f);
                        } catch (Throwable th2) {
                            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-spacingPx, -0.0f);
                            throw th2;
                        }
                    }
                }
                ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-f, -0.0f);
                IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
            } catch (Throwable th3) {
                ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-f, -0.0f);
                throw th3;
            }
        } catch (Throwable th4) {
            IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
            throw th4;
        }
    }

    public final int getSpacingPx() {
        return ((Number) this.spacingPx$delegate.getValue()).intValue();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return measurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, Integer.MAX_VALUE, 0, 0, 13, j));
        int iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(placeableMo598measureBRTryo0.width, j);
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.containerWidth$delegate;
        parcelableSnapshotMutableIntState.setIntValue(iM792constrainWidthK40F9xA);
        this.contentWidth$delegate.setIntValue(placeableMo598measureBRTryo0.width);
        return measureScope.layout(parcelableSnapshotMutableIntState.getIntValue(), placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 4));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return measurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return 0;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        GraphicsLayer graphicsLayer = this.marqueeLayer;
        GraphicsContext graphicsContext = ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getGraphicsContext();
        if (graphicsLayer != null) {
            graphicsContext.releaseGraphicsLayer(graphicsLayer);
        }
        this.marqueeLayer = graphicsContext.createGraphicsLayer();
        restartAnimation();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        StandaloneCoroutine standaloneCoroutine = this.animationJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.animationJob = null;
        GraphicsLayer graphicsLayer = this.marqueeLayer;
        if (graphicsLayer != null) {
            ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getGraphicsContext().releaseGraphicsLayer(graphicsLayer);
            this.marqueeLayer = null;
        }
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusStateImpl focusStateImpl) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(focusStateImpl.getHasFocus()));
    }

    public final void restartAnimation() {
        StandaloneCoroutine standaloneCoroutine = this.animationJob;
        Continuation continuation = null;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        if (this.isAttached) {
            this.animationJob = AwaitKt.launch$default(getCoroutineScope(), null, null, new SimpleActor$offer$2(standaloneCoroutine, this, continuation, (byte) 1), 3);
        }
    }
}
