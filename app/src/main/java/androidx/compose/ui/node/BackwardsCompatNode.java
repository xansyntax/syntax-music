package androidx.compose.ui.node;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerState$remeasurementModifier$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasuringIntrinsics$IntrinsicMinMax;
import androidx.compose.ui.layout.MeasuringIntrinsics$IntrinsicWidthHeight;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.EmptyMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda4;
import androidx.sqlite.SQLite;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Function;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalModifierNode, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, OwnerScope, BuildDrawCacheParams {
    public Modifier.Element element;

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public final void applyFocusProperties(FocusProperties focusProperties) {
        Modifier.Element element = this.element;
        InlineClassHelperKt.throwIllegalStateException("applyFocusProperties called on wrong node");
        element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Modifier.Element element = this.element;
        element.getClass();
        SemanticsConfiguration semanticsConfiguration = ((SemanticsModifier) element).getSemanticsConfiguration();
        semanticsPropertyReceiver.getClass();
        SemanticsConfiguration semanticsConfiguration2 = (SemanticsConfiguration) semanticsPropertyReceiver;
        MutableScatterMap mutableScatterMap = semanticsConfiguration2.props;
        if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
            semanticsConfiguration2.isMergingSemanticsOfDescendants = true;
        }
        if (semanticsConfiguration.isClearingSemantics) {
            semanticsConfiguration2.isClearingSemantics = true;
        }
        MutableScatterMap mutableScatterMap2 = semanticsConfiguration.props;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        if (!mutableScatterMap.contains(semanticsPropertyKey)) {
                            mutableScatterMap.set(semanticsPropertyKey, obj2);
                        } else if (obj2 instanceof AccessibilityAction) {
                            Object obj3 = mutableScatterMap.get(semanticsPropertyKey);
                            obj3.getClass();
                            AccessibilityAction accessibilityAction = (AccessibilityAction) obj3;
                            String str = accessibilityAction.label;
                            if (str == null) {
                                str = ((AccessibilityAction) obj2).label;
                            }
                            Function function = accessibilityAction.action;
                            if (function == null) {
                                function = ((AccessibilityAction) obj2).action;
                            }
                            mutableScatterMap.set(semanticsPropertyKey, new AccessibilityAction(str, function));
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        Modifier.Element element = this.element;
        element.getClass();
        layoutNodeDrawScope.drawContent();
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final Density getDensity() {
        return HitTestResultKt.requireLayoutNode(this).density;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final LayoutDirection getLayoutDirection() {
        return HitTestResultKt.requireLayoutNode(this).layoutDirection;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final SQLite getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public final long mo398getSizeNHjbRc() {
        return SizeKt.m876toSizeozmzZPI(HitTestResultKt.m646requireCoordinator64DMado(this, 128).measuredSize);
    }

    public final void initializeModifier(boolean z) {
        if (!this.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("initializeModifier called on unattached node");
        }
        Modifier.Element element = this.element;
        if ((this.kindSet & 4) != 0 && !z) {
            HitTestResultKt.m646requireCoordinator64DMado(this, 2).invalidateLayer();
        }
        if ((this.kindSet & 2) != 0) {
            TailModifierNode tailModifierNode = (TailModifierNode) HitTestResultKt.requireLayoutNode(this).nodes.tail;
            tailModifierNode.getClass();
            if (tailModifierNode.attachHasBeenRun) {
                NodeCoordinator nodeCoordinator = this.coordinator;
                nodeCoordinator.getClass();
                ((LayoutModifierNodeCoordinator) nodeCoordinator).setLayoutModifierNode$ui(this);
                OwnedLayer ownedLayer = nodeCoordinator.layer;
                if (ownedLayer != null) {
                    ((GraphicsLayerOwnerLayer) ownedLayer).invalidate();
                }
            }
            if (!z) {
                HitTestResultKt.m646requireCoordinator64DMado(this, 2).invalidateLayer();
                HitTestResultKt.requireLayoutNode(this).invalidateMeasurements$ui();
            }
        }
        if (element instanceof PagerState$remeasurementModifier$1) {
            PagerState$remeasurementModifier$1 pagerState$remeasurementModifier$1 = (PagerState$remeasurementModifier$1) element;
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
            switch (pagerState$remeasurementModifier$1.$r8$classId) {
                case 0:
                    ((PagerState) pagerState$remeasurementModifier$1.this$0).remeasurement$delegate.setValue(layoutNodeRequireLayoutNode);
                    break;
                case 1:
                    ((LazyListState) pagerState$remeasurementModifier$1.this$0).remeasurement = layoutNodeRequireLayoutNode;
                    break;
                default:
                    ((LazyGridState) pagerState$remeasurementModifier$1.this$0).remeasurement = layoutNodeRequireLayoutNode;
                    break;
            }
        }
        int i = this.kindSet;
        if ((i & 16) != 0 && (element instanceof PointerInteropFilter)) {
            ((PointerInteropFilter) element).pointerInputFilter.executorServiceOrNull = this.coordinator;
        }
        if ((i & 8) != 0) {
            ((AndroidComposeView) HitTestResultKt.requireOwner(this)).onSemanticsChange();
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void interceptOutOfBoundsChildEvents() {
        Modifier.Element element = this.element;
        element.getClass();
        ((PointerInteropFilter) element).pointerInputFilter.getClass();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return this.isAttached;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        Modifier.Element element = this.element;
        element.getClass();
        return ((LayoutModifier) element).mo195measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, MeasuringIntrinsics$IntrinsicMinMax.Max, MeasuringIntrinsics$IntrinsicWidthHeight.Height, (byte) 1), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        Modifier.Element element = this.element;
        element.getClass();
        return ((LayoutModifier) element).mo195measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, MeasuringIntrinsics$IntrinsicMinMax.Max, MeasuringIntrinsics$IntrinsicWidthHeight.Width, (byte) 1), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Modifier.Element element = this.element;
        element.getClass();
        return ((LayoutModifier) element).mo195measure3p2s80s(measureScope, measurable, j);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        Modifier.Element element = this.element;
        element.getClass();
        return ((LayoutModifier) element).mo195measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, MeasuringIntrinsics$IntrinsicMinMax.Min, MeasuringIntrinsics$IntrinsicWidthHeight.Height, (byte) 1), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        Modifier.Element element = this.element;
        element.getClass();
        return ((LayoutModifier) element).mo195measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, MeasuringIntrinsics$IntrinsicMinMax.Min, MeasuringIntrinsics$IntrinsicWidthHeight.Width, (byte) 1), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public final Object modifyParentData(Density density, Object obj) {
        Modifier.Element element = this.element;
        element.getClass();
        return ((ParentDataModifier) element).modifyParentData();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        initializeModifier(true);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        Modifier.Element element = this.element;
        element.getClass();
        Dispatcher dispatcher = ((PointerInteropFilter) element).pointerInputFilter;
        PointerInteropFilter.DispatchToViewState dispatchToViewState = (PointerInteropFilter.DispatchToViewState) dispatcher.readyAsyncCalls;
        PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) dispatcher.runningSyncCalls;
        if (dispatchToViewState == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
            motionEventObtain.setSource(0);
            ((AndroidViewHolder$$ExternalSyntheticLambda4) pointerInteropFilter.getOnTouchEvent()).invoke(motionEventObtain);
            motionEventObtain.recycle();
            dispatcher.readyAsyncCalls = PointerInteropFilter.DispatchToViewState.Unknown;
            pointerInteropFilter.disallowIntercept = false;
            dispatcher.runningAsyncCalls = null;
        }
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onDensityChange() {
        if (this.element instanceof PointerInteropFilter) {
            onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        if (!this.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("unInitializeModifier called on unattached node");
        }
        if ((this.kindSet & 8) != 0) {
            ((AndroidComposeView) HitTestResultKt.requireOwner(this)).onSemanticsChange();
        }
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusStateImpl focusStateImpl) {
        Modifier.Element element = this.element;
        InlineClassHelperKt.throwIllegalStateException("onFocusEvent called on wrong node");
        element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void onMeasureResultChanged() {
        HitTestResultKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        boolean z;
        boolean z2;
        boolean z3;
        Modifier.Element element = this.element;
        element.getClass();
        Dispatcher dispatcher = ((PointerInteropFilter) element).pointerInputFilter;
        PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) dispatcher.runningSyncCalls;
        List list = pointerEvent.changes;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) list.get(i);
            if (PointerIconKt.changedToDownIgnoreConsumed(pointerInputChange) || PointerIconKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                z = false;
                break;
            }
            i++;
        }
        if (!z) {
            z2 = false;
            break;
        }
        int size2 = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size2) {
                z2 = true;
                break;
            } else {
                if (((PointerInputChange) list.get(i2)).isConsumed()) {
                    z2 = false;
                    break;
                }
                i2++;
            }
        }
        if (pointerInteropFilter.disallowIntercept) {
            z3 = true;
            break;
        }
        int size3 = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size3) {
                if (!z2) {
                    z3 = false;
                    break;
                }
                break;
            } else {
                PointerInputChange pointerInputChange2 = (PointerInputChange) list.get(i3);
                if (!PointerIconKt.changedToDownIgnoreConsumed(pointerInputChange2) && !PointerIconKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    i3++;
                }
            }
            z3 = true;
            break;
        }
        PointerInteropFilter.DispatchToViewState dispatchToViewState = (PointerInteropFilter.DispatchToViewState) dispatcher.readyAsyncCalls;
        PointerInteropFilter.DispatchToViewState dispatchToViewState2 = PointerInteropFilter.DispatchToViewState.NotDispatching;
        PointerEventPass pointerEventPass2 = PointerEventPass.Final;
        if (dispatchToViewState != dispatchToViewState2) {
            if (pointerEventPass == PointerEventPass.Initial && z3) {
                dispatcher.runningAsyncCalls = pointerEvent;
                dispatcher.dispatchToView(pointerEvent, !z || pointerInteropFilter.disallowIntercept);
            }
            if (pointerEventPass == PointerEventPass.Main && z && pointerEvent == ((PointerEvent) dispatcher.runningAsyncCalls) && pointerInteropFilter.disallowIntercept) {
                int size4 = list.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    ((PointerInputChange) list.get(i4)).consume();
                }
            }
            if (pointerEventPass == pointerEventPass2 && !z3 && pointerEvent != ((PointerEvent) dispatcher.runningAsyncCalls)) {
                dispatcher.dispatchToView(pointerEvent, true);
            }
        }
        if (pointerEventPass == pointerEventPass2) {
            int size5 = list.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size5) {
                    dispatcher.readyAsyncCalls = PointerInteropFilter.DispatchToViewState.Unknown;
                    ((PointerInteropFilter) dispatcher.runningSyncCalls).disallowIntercept = false;
                    dispatcher.runningAsyncCalls = null;
                    break;
                } else if (!PointerIconKt.changedToUpIgnoreConsumed((PointerInputChange) list.get(i5))) {
                    break;
                } else {
                    i5++;
                }
            }
            if (pointerEvent == ((PointerEvent) dispatcher.runningAsyncCalls) && z) {
                int size6 = list.size();
                for (int i6 = 0; i6 < size6; i6++) {
                    if (((PointerInputChange) list.get(i6)).isConsumed()) {
                        if (pointerInteropFilter.disallowIntercept) {
                            break;
                        }
                        dispatcher.stopDispatching(pointerEvent);
                        return;
                    }
                }
                int size7 = list.size();
                for (int i7 = 0; i7 < size7; i7++) {
                    ((PointerInputChange) list.get(i7)).consume();
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final boolean sharePointerInputWithSiblings() {
        Modifier.Element element = this.element;
        element.getClass();
        ((PointerInteropFilter) element).pointerInputFilter.getClass();
        return true;
    }

    public final String toString() {
        return this.element.toString();
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(LayoutCoordinates layoutCoordinates) {
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode, androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo61onRemeasuredozmzZPI(long j) {
    }
}
