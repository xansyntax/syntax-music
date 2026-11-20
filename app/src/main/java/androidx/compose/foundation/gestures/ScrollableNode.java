package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.GestureNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil3.RealImageLoader;
import coil3.compose.AsyncImagePainter;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableNode extends DragGestureNode implements KeyInputModifierNode, SemanticsModifierNode {
    public final ContentInViewNode contentInViewNode;
    public final DefaultFlingBehavior defaultFlingBehavior;
    public final FocusTargetNode focusTargetModifierNode;
    public MouseWheelScrollingLogicImpl mouseWheelScrollingLogic;
    public final ScrollableNestedScrollConnection nestedScrollConnection;
    public final NestedScrollDispatcher nestedScrollDispatcher;
    public ComposerKt$$ExternalSyntheticLambda0 scrollByAction;
    public ScrollableNode$onKeyEvent$1 scrollByOffsetAction;
    public final ScrollingLogic scrollLogic;
    public TrackpadScrollingLogicImpl trackpadScrollingLogic;

    public ScrollableNode(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, BringIntoViewSpec bringIntoViewSpec, FlingBehavior flingBehavior, Orientation orientation, ScrollableState scrollableState, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, boolean z2) {
        super(AbstractScrollableNodeKt.CanDragCalculation, z, mutableInteractionSourceImpl, orientation);
        this.nestedScrollDispatcher = new NestedScrollDispatcher();
        DefaultFlingBehavior defaultFlingBehavior = new DefaultFlingBehavior(new DecayAnimationSpecImpl(new DrawResult(AbstractScrollableNodeKt.UnityDensity)));
        this.defaultFlingBehavior = defaultFlingBehavior;
        ScrollingLogic scrollingLogic = new ScrollingLogic(scrollableState, androidEdgeEffectOverscrollEffect, flingBehavior == null ? defaultFlingBehavior : flingBehavior, orientation, z2, this.nestedScrollDispatcher, this, new ScrollableNode$$ExternalSyntheticLambda0(this, (byte) 0));
        this.scrollLogic = scrollingLogic;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic, z);
        this.nestedScrollConnection = scrollableNestedScrollConnection;
        FocusTargetNode focusTargetNode = new FocusTargetNode(2, null, 10);
        delegate(focusTargetNode);
        this.focusTargetModifierNode = focusTargetNode;
        ContentInViewNode contentInViewNode = new ContentInViewNode(orientation, scrollingLogic, z2, bringIntoViewSpec, new ScrollableNode$$ExternalSyntheticLambda0(this, (byte) 1));
        delegate(contentInViewNode);
        this.contentInViewNode = contentInViewNode;
        NestedScrollDispatcher nestedScrollDispatcher = this.nestedScrollDispatcher;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = NestedScrollNodeKt.CancelledNestedScope;
        delegate(new NestedScrollNode(scrollableNestedScrollConnection, nestedScrollDispatcher));
        BringIntoViewResponderNode bringIntoViewResponderNode = new BringIntoViewResponderNode();
        bringIntoViewResponderNode.responder = contentInViewNode;
        delegate(bringIntoViewResponderNode);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.enabled && (this.scrollByAction == null || this.scrollByOffsetAction == null)) {
            this.scrollByAction = new ComposerKt$$ExternalSyntheticLambda0((byte) 3, this);
            this.scrollByOffsetAction = new ScrollableNode$onKeyEvent$1(this, null);
        }
        ComposerKt$$ExternalSyntheticLambda0 composerKt$$ExternalSyntheticLambda0 = this.scrollByAction;
        if (composerKt$$ExternalSyntheticLambda0 != null) {
            KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
            semanticsPropertyReceiver.set(SemanticsActions.ScrollBy, new AccessibilityAction(null, composerKt$$ExternalSyntheticLambda0));
        }
        ScrollableNode$onKeyEvent$1 scrollableNode$onKeyEvent$1 = this.scrollByOffsetAction;
        if (scrollableNode$onKeyEvent$1 != null) {
            KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
            semanticsPropertyReceiver.set(SemanticsActions.ScrollByOffset, scrollableNode$onKeyEvent$1);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final Object drag$1(InnerTube$feedback$2 innerTube$feedback$2, NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1) {
        ScrollingLogic scrollingLogic = this.scrollLogic;
        Object objScroll = scrollingLogic.scroll(MutatePriority.UserInput, new RealImageLoader.AnonymousClass2(innerTube$feedback$2, scrollingLogic, null, (byte) 12), navHostKt$NavHost$29$1);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl = this.mouseWheelScrollingLogic;
        if (mouseWheelScrollingLogicImpl != null) {
            mouseWheelScrollingLogicImpl.sessionImpl = HitTestResultKt.requireLayoutNode(this).density;
        }
        TrackpadScrollingLogicImpl trackpadScrollingLogicImpl = this.trackpadScrollingLogic;
        if (trackpadScrollingLogicImpl != null) {
            trackpadScrollingLogicImpl.sessionImpl = HitTestResultKt.requireLayoutNode(this).density;
        }
        if (this.isAttached) {
            Density density = HitTestResultKt.requireLayoutNode(this).density;
            DefaultFlingBehavior defaultFlingBehavior = this.defaultFlingBehavior;
            defaultFlingBehavior.getClass();
            defaultFlingBehavior.flingDecay = new DecayAnimationSpecImpl(new DrawResult(density));
        }
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onDensityChange() {
        onCancelPointerInput();
        MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl = this.mouseWheelScrollingLogic;
        if (mouseWheelScrollingLogicImpl != null) {
            mouseWheelScrollingLogicImpl.sessionImpl = HitTestResultKt.requireLayoutNode(this).density;
        }
        TrackpadScrollingLogicImpl trackpadScrollingLogicImpl = this.trackpadScrollingLogic;
        if (trackpadScrollingLogicImpl != null) {
            trackpadScrollingLogicImpl.sessionImpl = HitTestResultKt.requireLayoutNode(this).density;
        }
        onCancelPointerInput();
        if (this.isAttached) {
            Density density = HitTestResultKt.requireLayoutNode(this).density;
            DefaultFlingBehavior defaultFlingBehavior = this.defaultFlingBehavior;
            defaultFlingBehavior.getClass();
            defaultFlingBehavior.flingDecay = new DecayAnimationSpecImpl(new DrawResult(density));
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final void onDragStopped(DragEvent.DragStopped dragStopped) {
        if (this.isAttached) {
            AwaitKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new SliderState.AnonymousClass2(dragStopped, this, null, (byte) 7), 3);
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    public final boolean mo26onKeyEventZmokQxo(KeyEvent keyEvent) {
        long jFloatToRawIntBits;
        long jFloatToRawIntBits2;
        if (!this.enabled || ((!Key.m579equalsimpl0(Key.m580getKeyZmokQxo(keyEvent), 399431958528L) && !Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 395136991232L)) || Key.m581getTypeZmokQxo(keyEvent) != 2 || keyEvent.isCtrlPressed())) {
            return false;
        }
        boolean z = this.scrollLogic.orientation == Orientation.Vertical;
        ContentInViewNode contentInViewNode = this.contentInViewNode;
        if (z) {
            int iM59getViewportSizeOrZeroYbymL2g$foundation = (int) (contentInViewNode.m59getViewportSizeOrZeroYbymL2g$foundation() & 4294967295L);
            float f = Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 395136991232L) ? iM59getViewportSizeOrZeroYbymL2g$foundation : -iM59getViewportSizeOrZeroYbymL2g$foundation;
            jFloatToRawIntBits = ((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32;
            jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(f)) & 4294967295L;
        } else {
            int iM59getViewportSizeOrZeroYbymL2g$foundation2 = (int) (contentInViewNode.m59getViewportSizeOrZeroYbymL2g$foundation() >> 32);
            jFloatToRawIntBits = ((long) Float.floatToRawIntBits(Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 395136991232L) ? iM59getViewportSizeOrZeroYbymL2g$foundation2 : -iM59getViewportSizeOrZeroYbymL2g$foundation2)) << 32;
            jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L;
        }
        AwaitKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(this, jFloatToRawIntBits | jFloatToRawIntBits2, null, (byte) 0), 3);
        return true;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        ScrollableNode scrollableNode;
        int i;
        ScrollableNode scrollableNode2 = this;
        List list = pointerEvent.changes;
        int size = list.size();
        final byte b = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (((Boolean) scrollableNode2.canDrag.invoke(new PointerType(((PointerInputChange) list.get(i2)).type))).booleanValue()) {
                super.mo27onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
                break;
            }
        }
        if (scrollableNode2.enabled) {
            if (scrollableNode2.pointerInputGestureNode == null) {
                GestureNode gestureNode = new GestureNode(scrollableNode2);
                scrollableNode2.delegate(gestureNode);
                scrollableNode2.pointerInputGestureNode = gestureNode;
            }
            Continuation continuation = null;
            byte b2 = 3;
            PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
            if (pointerEventPass == pointerEventPass2 && pointerEvent.type == 6) {
                MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl = scrollableNode2.mouseWheelScrollingLogic;
                if (mouseWheelScrollingLogicImpl == null) {
                    DrawResult drawResult = new DrawResult((byte) 13, (Object) ViewConfiguration.get(HitTestResultKt.requireView(scrollableNode2).getContext()));
                    ComposableLambdaImpl.AnonymousClass1 anonymousClass1 = new ComposableLambdaImpl.AnonymousClass1(2, scrollableNode2, ScrollableNode.class, "onMouseWheelScrollStopped", "onMouseWheelScrollStopped-TH1AsA0(J)V", 4, (byte) 1);
                    Density density = HitTestResultKt.requireLayoutNode(scrollableNode2).density;
                    final ScrollingLogic scrollingLogic = scrollableNode2.scrollLogic;
                    final byte b3 = 1;
                    ProvidableModifierLocal providableModifierLocal = new ProvidableModifierLocal(new Function0() { // from class: androidx.compose.foundation.gestures.TrackpadScrollingLogicKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b4 = b3;
                            Orientation orientation = Orientation.Vertical;
                            ScrollingLogic scrollingLogic2 = scrollingLogic;
                            switch (b4) {
                                case 0:
                                    return Boolean.valueOf(scrollingLogic2.orientation == orientation);
                                default:
                                    return Boolean.valueOf(scrollingLogic2.orientation == orientation);
                            }
                        }
                    });
                    MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl2 = new MouseWheelScrollingLogicImpl(providableModifierLocal, scrollingLogic, drawResult, anonymousClass1, density, new ScrollingLogic$$ExternalSyntheticLambda0(scrollingLogic, providableModifierLocal, (byte) 1));
                    scrollableNode2.mouseWheelScrollingLogic = mouseWheelScrollingLogicImpl2;
                    scrollableNode2 = scrollableNode2;
                    mouseWheelScrollingLogicImpl = mouseWheelScrollingLogicImpl2;
                }
                CoroutineScope coroutineScope = scrollableNode2.getCoroutineScope();
                if (mouseWheelScrollingLogicImpl.receivingMouseWheelEventsJob == null) {
                    mouseWheelScrollingLogicImpl.receivingMouseWheelEventsJob = AwaitKt.launch$default(coroutineScope, null, null, new SimpleActor$offer$2(mouseWheelScrollingLogicImpl, continuation, b2), 3);
                }
            }
            MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl3 = scrollableNode2.mouseWheelScrollingLogic;
            if (mouseWheelScrollingLogicImpl3 != null) {
                mouseWheelScrollingLogicImpl3.m839onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
            }
            if (pointerEventPass == pointerEventPass2 && ((i = pointerEvent.type) == 10 || i == 11 || i == 12)) {
                TrackpadScrollingLogicImpl trackpadScrollingLogicImpl = scrollableNode2.trackpadScrollingLogic;
                if (trackpadScrollingLogicImpl == null) {
                    ComposableLambdaImpl.AnonymousClass1 anonymousClass2 = new ComposableLambdaImpl.AnonymousClass1(2, scrollableNode2, ScrollableNode.class, "onTrackpadScrollStopped", "onTrackpadScrollStopped-TH1AsA0(J)V", 4, (byte) 2);
                    scrollableNode = scrollableNode2;
                    Density density2 = HitTestResultKt.requireLayoutNode(scrollableNode).density;
                    final ScrollingLogic scrollingLogic2 = scrollableNode.scrollLogic;
                    ProvidableModifierLocal providableModifierLocal2 = new ProvidableModifierLocal(new Function0() { // from class: androidx.compose.foundation.gestures.TrackpadScrollingLogicKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b4 = b;
                            Orientation orientation = Orientation.Vertical;
                            ScrollingLogic scrollingLogic3 = scrollingLogic2;
                            switch (b4) {
                                case 0:
                                    return Boolean.valueOf(scrollingLogic3.orientation == orientation);
                                default:
                                    return Boolean.valueOf(scrollingLogic3.orientation == orientation);
                            }
                        }
                    });
                    TrackpadScrollingLogicImpl trackpadScrollingLogicImpl2 = new TrackpadScrollingLogicImpl(providableModifierLocal2, scrollingLogic2, anonymousClass2, density2, new ScrollingLogic$$ExternalSyntheticLambda0(scrollingLogic2, providableModifierLocal2, (byte) 2));
                    scrollableNode.trackpadScrollingLogic = trackpadScrollingLogicImpl2;
                    trackpadScrollingLogicImpl = trackpadScrollingLogicImpl2;
                } else {
                    scrollableNode = scrollableNode2;
                }
                CoroutineScope coroutineScope2 = scrollableNode.getCoroutineScope();
                if (trackpadScrollingLogicImpl.receivingPanEventsJob == null) {
                    trackpadScrollingLogicImpl.receivingPanEventsJob = AwaitKt.launch$default(coroutineScope2, null, null, new AsyncImagePainter.AnonymousClass1(trackpadScrollingLogicImpl, continuation, b2), 3);
                }
            } else {
                scrollableNode = scrollableNode2;
            }
            TrackpadScrollingLogicImpl trackpadScrollingLogicImpl3 = scrollableNode.trackpadScrollingLogic;
            if (trackpadScrollingLogicImpl3 != null) {
                trackpadScrollingLogicImpl3.m839onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
            }
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    public final boolean mo28onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    public final void update(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, BringIntoViewSpec bringIntoViewSpec, FlingBehavior flingBehavior, Orientation orientation, ScrollableState scrollableState, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        if (this.enabled != z) {
            this.nestedScrollConnection.enabled = z;
            this.scrollByAction = null;
            this.scrollByOffsetAction = null;
            HitTestResultKt.invalidateSemantics(this);
        }
        if (flingBehavior == null) {
            flingBehavior = this.defaultFlingBehavior;
        }
        ScrollingLogic scrollingLogic = this.scrollLogic;
        if (Intrinsics.areEqual(scrollingLogic.scrollableState, scrollableState)) {
            z3 = false;
        } else {
            scrollingLogic.scrollableState = scrollableState;
            z3 = true;
        }
        scrollingLogic.overscrollEffect = androidEdgeEffectOverscrollEffect;
        Orientation orientation2 = scrollingLogic.orientation;
        if (orientation2 != orientation) {
            scrollingLogic.orientation = orientation;
            orientation2 = orientation;
            z3 = true;
        }
        if (scrollingLogic.reverseDirection != z2) {
            scrollingLogic.reverseDirection = z2;
            z4 = true;
        } else {
            z4 = z3;
        }
        scrollingLogic.flingBehavior = flingBehavior;
        scrollingLogic.nestedScrollDispatcher = this.nestedScrollDispatcher;
        ContentInViewNode contentInViewNode = this.contentInViewNode;
        contentInViewNode.orientation = orientation;
        contentInViewNode.reverseDirection = z2;
        contentInViewNode.bringIntoViewSpec = bringIntoViewSpec;
        BorderKt$$ExternalSyntheticLambda1 borderKt$$ExternalSyntheticLambda1 = AbstractScrollableNodeKt.CanDragCalculation;
        Orientation orientation3 = Orientation.Vertical;
        if (orientation2 != orientation3) {
            orientation3 = Orientation.Horizontal;
        }
        update(borderKt$$ExternalSyntheticLambda1, z, mutableInteractionSourceImpl, orientation3, z4);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public final void mo65onDragStartedk4lQ0M(long j) {
    }
}
