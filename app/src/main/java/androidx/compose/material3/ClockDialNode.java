package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import coil3.size.SizeKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClockDialNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode {
    public AnimationSpec animationSpec;
    public boolean autoSwitchToMinute;
    public final ParcelableSnapshotMutableState center$delegate = Stack.mutableStateOf$default(new IntOffset(0));
    public float offsetX;
    public float offsetY;
    public final SuspendingPointerInputModifierNodeImpl pointerInputDragNode;
    public final SuspendingPointerInputModifierNodeImpl pointerInputTapNode;
    public int selection;
    public AnalogTimePickerState state;

    public ClockDialNode(AnalogTimePickerState analogTimePickerState, boolean z, int i, AnimationSpec animationSpec) {
        this.state = analogTimePickerState;
        this.autoSwitchToMinute = z;
        this.selection = i;
        this.animationSpec = animationSpec;
        final byte b = 0;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler(this) { // from class: androidx.compose.material3.ClockDialNode$pointerInputTapNode$1
            public final /* synthetic */ ClockDialNode this$0;

            /* JADX INFO: renamed from: androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            public final class AnonymousClass1 extends SuspendLambda implements Function3 {
                public /* synthetic */ long J$0;
                public final /* synthetic */ ClockDialNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ClockDialNode clockDialNode, Continuation continuation) {
                    super(3, continuation);
                    this.this$0 = clockDialNode;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    long j = ((Offset) obj2).packedValue;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (Continuation) obj3);
                    anonymousClass1.J$0 = j;
                    Unit unit = Unit.INSTANCE;
                    anonymousClass1.invokeSuspend(unit);
                    return unit;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.J$0;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalFocusManager;
                    ClockDialNode clockDialNode = this.this$0;
                    ((FocusOwnerImpl) ((FocusOwner) HitTestResultKt.currentValueOf(clockDialNode, staticProvidableCompositionLocal))).m409clearFocusI7lrPNg(8, false, true);
                    clockDialNode.offsetX = Float.intBitsToFloat((int) (j >> 32));
                    clockDialNode.offsetY = Float.intBitsToFloat((int) (j & 4294967295L));
                    return Unit.INSTANCE;
                }
            }

            {
                this.this$0 = this;
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                byte b2 = b;
                Unit unit = Unit.INSTANCE;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                ClockDialNode clockDialNode = this.this$0;
                switch (b2) {
                    case 0:
                        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, new AnonymousClass1(clockDialNode, null), new TextKt$$ExternalSyntheticLambda2((byte) 2, clockDialNode), continuation, 3);
                        return objDetectTapGestures$default == coroutineSingletons ? objDetectTapGestures$default : unit;
                    default:
                        Object objDetectDragGestures = ScrollableKt.detectDragGestures(pointerInputScope, new BorderKt$$ExternalSyntheticLambda1((byte) 27), new SliderState$$ExternalSyntheticLambda0((byte) 26, clockDialNode), new ScrollKt$$ExternalSyntheticLambda0((byte) 17), new ComposerKt$$ExternalSyntheticLambda0((byte) 15, clockDialNode), continuation);
                        return objDetectDragGestures == coroutineSingletons ? objDetectDragGestures : unit;
                }
            }
        });
        delegate(suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode);
        this.pointerInputTapNode = suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode;
        final byte b2 = 1;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode2 = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler(this) { // from class: androidx.compose.material3.ClockDialNode$pointerInputTapNode$1
            public final /* synthetic */ ClockDialNode this$0;

            /* JADX INFO: renamed from: androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            public final class AnonymousClass1 extends SuspendLambda implements Function3 {
                public /* synthetic */ long J$0;
                public final /* synthetic */ ClockDialNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ClockDialNode clockDialNode, Continuation continuation) {
                    super(3, continuation);
                    this.this$0 = clockDialNode;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    long j = ((Offset) obj2).packedValue;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (Continuation) obj3);
                    anonymousClass1.J$0 = j;
                    Unit unit = Unit.INSTANCE;
                    anonymousClass1.invokeSuspend(unit);
                    return unit;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.J$0;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalFocusManager;
                    ClockDialNode clockDialNode = this.this$0;
                    ((FocusOwnerImpl) ((FocusOwner) HitTestResultKt.currentValueOf(clockDialNode, staticProvidableCompositionLocal))).m409clearFocusI7lrPNg(8, false, true);
                    clockDialNode.offsetX = Float.intBitsToFloat((int) (j >> 32));
                    clockDialNode.offsetY = Float.intBitsToFloat((int) (j & 4294967295L));
                    return Unit.INSTANCE;
                }
            }

            {
                this.this$0 = this;
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                byte b3 = b2;
                Unit unit = Unit.INSTANCE;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                ClockDialNode clockDialNode = this.this$0;
                switch (b3) {
                    case 0:
                        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, new AnonymousClass1(clockDialNode, null), new TextKt$$ExternalSyntheticLambda2((byte) 2, clockDialNode), continuation, 3);
                        return objDetectTapGestures$default == coroutineSingletons ? objDetectTapGestures$default : unit;
                    default:
                        Object objDetectDragGestures = ScrollableKt.detectDragGestures(pointerInputScope, new BorderKt$$ExternalSyntheticLambda1((byte) 27), new SliderState$$ExternalSyntheticLambda0((byte) 26, clockDialNode), new ScrollKt$$ExternalSyntheticLambda0((byte) 17), new ComposerKt$$ExternalSyntheticLambda0((byte) 15, clockDialNode), continuation);
                        return objDetectDragGestures == coroutineSingletons ? objDetectDragGestures : unit;
                }
            }
        });
        delegate(suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode2);
        this.pointerInputDragNode = suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode2;
    }

    public final float getMaxDist() {
        Density density = HitTestResultKt.requireLayoutNode(this).density;
        MutableIntList mutableIntList = TimePickerKt.Minutes;
        return (density.mo81toPx0680j_4(74.0f) * density.mo75roundToPx0680j_4(this.state.m240getCurrentDiameterD9Ej5fM())) / density.mo75roundToPx0680j_4(256.0f);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        this.pointerInputTapNode.onCancelPointerInput();
        this.pointerInputDragNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.pointerInputTapNode.mo27onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        this.pointerInputDragNode.mo27onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode, androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo61onRemeasuredozmzZPI(long j) {
        this.center$delegate.setValue(new IntOffset(SizeKt.m866getCenterozmzZPI(j)));
        this.state.currentDiameter$delegate.setValue(new Dp(HitTestResultKt.requireLayoutNode(this).density.mo78toDpu2uoSUM((int) (j >> 32))));
    }
}
