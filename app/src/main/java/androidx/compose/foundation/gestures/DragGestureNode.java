package androidx.compose.foundation.gestures;

import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.GestureNode;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda13;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil3.util.UtilsKt;
import com.metrolist.innertubex.InnerTube$feedback$2;
import dagger.hilt.EntryPoints;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, IndirectPointerInputModifierNode, CompositionLocalConsumerModifierNode, DraggableGestureConnection {
    public DragDetectionState$AwaitDown _awaitDownState;
    public DragDetectionState$AwaitGesturePickup _awaitGesturePickupState;
    public DragDetectionState$AwaitTouchSlop _awaitTouchSlopState;
    public DragDetectionState$Dragging _draggingState;
    public Function1 canDrag;
    public BufferedChannel channel;
    public ScrollableKt currentDragState;
    public DragInteraction$Start dragInteraction;
    public boolean enabled;
    public IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector;
    public GestureNode indirectTouchGestureNode;
    public MutableInteractionSourceImpl interactionSource;
    public boolean isListeningForEvents;
    public boolean isListeningForPointerInputEvents;
    public Orientation orientation;
    public GestureNode pointerInputGestureNode;
    public HeadersReader touchSlopDetector;
    public VelocityTracker velocityTracker;
    public long dragAccumulator = 0;
    public long rootOffset = 0;
    public long previousRootPositionOnScreen = 9205357640488583168L;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DragDetectionState$AwaitDown.AwaitTouchSlop.values().length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragCancel(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00191 extends ContinuationImpl {
        public DragEvent.DragStarted L$0;
        public DragInteraction$Start L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00191(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStart(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00201 extends ContinuationImpl {
        public DragEvent.DragStopped L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00201(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStop(null, this);
        }
    }

    public DragGestureNode(Function1 function1, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, Orientation orientation) {
        this.orientation = orientation;
        this.canDrag = function1;
        this.enabled = z;
        this.interactionSource = mutableInteractionSourceImpl;
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U$default, reason: not valid java name */
    public static void m63moveToAwaitTouchSlopStateaWI9W7U$default(DragGestureNode dragGestureNode, PointerInputChange pointerInputChange, long j, long j2, int i) {
        if ((i & 4) != 0) {
            j2 = 0;
        }
        DragDetectionState$AwaitTouchSlop dragDetectionState$AwaitTouchSlop = dragGestureNode._awaitTouchSlopState;
        if (dragDetectionState$AwaitTouchSlop == null) {
            dragDetectionState$AwaitTouchSlop = new DragDetectionState$AwaitTouchSlop();
            dragDetectionState$AwaitTouchSlop.initialDown = null;
            dragDetectionState$AwaitTouchSlop.pointerId = Long.MAX_VALUE;
            dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
            dragGestureNode._awaitTouchSlopState = dragDetectionState$AwaitTouchSlop;
        }
        dragDetectionState$AwaitTouchSlop.initialDown = pointerInputChange;
        dragDetectionState$AwaitTouchSlop.pointerId = j;
        HeadersReader headersReader = dragGestureNode.touchSlopDetector;
        Orientation orientation = dragGestureNode.orientation;
        if (headersReader == null) {
            dragGestureNode.touchSlopDetector = new HeadersReader(orientation);
        } else {
            headersReader.source = orientation;
            headersReader.headerLimit = j2;
        }
        dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
        dragGestureNode.currentDragState = dragDetectionState$AwaitTouchSlop;
    }

    public final void disposeInteractionSource$1() {
        DragInteraction$Start dragInteraction$Start = this.dragInteraction;
        if (dragInteraction$Start != null) {
            MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
            if (mutableInteractionSourceImpl != null) {
                mutableInteractionSourceImpl.tryEmit(new DragInteraction$Cancel(dragInteraction$Start));
            }
            this.dragInteraction = null;
        }
    }

    public abstract Object drag$1(InnerTube$feedback$2 innerTube$feedback$2, NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1);

    @Override // androidx.compose.foundation.GestureConnection
    /* JADX INFO: renamed from: getGestureState-7meUWtM */
    public final String mo22getGestureState7meUWtM() {
        if (!this.enabled) {
            return "idle";
        }
        ScrollableKt scrollableKt = this.currentDragState;
        if (scrollableKt instanceof DragDetectionState$AwaitDown) {
            return ((DragDetectionState$AwaitDown) scrollableKt).hasSeenInitialEvent ? "waiting" : "idle";
        }
        if ((scrollableKt instanceof DragDetectionState$AwaitTouchSlop) || (scrollableKt instanceof DragDetectionState$AwaitGesturePickup)) {
            return "waiting";
        }
        return scrollableKt instanceof DragDetectionState$Dragging ? "recognized" : "idle";
    }

    @Override // androidx.compose.foundation.gestures.DraggableGestureConnection
    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final void moveToAwaitDownState() {
        this.dragAccumulator = 0L;
        DragDetectionState$AwaitDown dragDetectionState$AwaitDown = this._awaitDownState;
        DragDetectionState$AwaitDown.AwaitTouchSlop awaitTouchSlop = DragDetectionState$AwaitDown.AwaitTouchSlop.NotInitialized;
        if (dragDetectionState$AwaitDown == null) {
            dragDetectionState$AwaitDown = new DragDetectionState$AwaitDown();
            dragDetectionState$AwaitDown.awaitTouchSlop = awaitTouchSlop;
            dragDetectionState$AwaitDown.consumedOnInitial = false;
            dragDetectionState$AwaitDown.hasSeenInitialEvent = false;
            this._awaitDownState = dragDetectionState$AwaitDown;
        }
        dragDetectionState$AwaitDown.awaitTouchSlop = awaitTouchSlop;
        dragDetectionState$AwaitDown.consumedOnInitial = false;
        dragDetectionState$AwaitDown.hasSeenInitialEvent = false;
        this.currentDragState = dragDetectionState$AwaitDown;
    }

    /* JADX INFO: renamed from: moveToAwaitGesturePickupState-rnUCldI, reason: not valid java name */
    public final void m64moveToAwaitGesturePickupStaternUCldI(PointerInputChange pointerInputChange, long j, HeadersReader headersReader) {
        DragDetectionState$AwaitGesturePickup dragDetectionState$AwaitGesturePickup = this._awaitGesturePickupState;
        if (dragDetectionState$AwaitGesturePickup == null) {
            dragDetectionState$AwaitGesturePickup = new DragDetectionState$AwaitGesturePickup();
            dragDetectionState$AwaitGesturePickup.initialDown = null;
            dragDetectionState$AwaitGesturePickup.pointerId = Long.MAX_VALUE;
            this._awaitGesturePickupState = dragDetectionState$AwaitGesturePickup;
        }
        dragDetectionState$AwaitGesturePickup.initialDown = pointerInputChange;
        dragDetectionState$AwaitGesturePickup.pointerId = j;
        headersReader.headerLimit = 0L;
        this.currentDragState = dragDetectionState$AwaitGesturePickup;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onCancelIndirectPointerInput() {
        IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
        if (indirectPointerInputDragCycleDetector != null) {
            indirectPointerInputDragCycleDetector.moveToAwaitDownState$1();
            DragGestureNode dragGestureNode = indirectPointerInputDragCycleDetector.node;
            if (dragGestureNode.isListeningForEvents) {
                dragGestureNode.onDragEvent(DragEvent.DragCancelled.INSTANCE);
            }
            indirectPointerInputDragCycleDetector.velocityTracker = null;
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        if (this.isListeningForPointerInputEvents) {
            moveToAwaitDownState();
            if (this.isListeningForEvents) {
                requireChannel().mo1712trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE);
            }
            this.velocityTracker = null;
        }
        this.isListeningForPointerInputEvents = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource$1();
        this.rootOffset = 0L;
        GestureNode gestureNode = this.indirectTouchGestureNode;
        if (gestureNode != null) {
            undelegate(gestureNode);
        }
        GestureNode gestureNode2 = this.pointerInputGestureNode;
        if (gestureNode2 != null) {
            undelegate(gestureNode2);
        }
        this.indirectTouchGestureNode = null;
        this.pointerInputGestureNode = null;
    }

    public final void onDragEvent(DragEvent dragEvent) {
        if ((dragEvent instanceof DragEvent.DragStarted) && !this.isListeningForEvents) {
            this.isListeningForEvents = true;
            startListeningForEvents();
        }
        requireChannel().mo1712trySendJP2dKIU(dragEvent);
    }

    public void onDragStopped(DragEvent.DragStopped dragStopped) {
        if (this.isAttached) {
            AwaitKt.launch$default(getCoroutineScope(), null, null, new SimpleActor$offer$2(this, dragStopped, null, (byte) 2), 3);
        }
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onIndirectPointerEvent(StatusLine statusLine, PointerEventPass pointerEventPass) {
        Object obj;
        Object obj2;
        Object obj3;
        boolean z;
        Object obj4;
        Object obj5;
        Object obj6;
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
        int i = statusLine.code;
        ArrayList arrayList = (ArrayList) statusLine.protocol;
        if (this.enabled) {
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector == null) {
                indirectPointerInputDragCycleDetector = new IndirectPointerInputDragCycleDetector(this);
                this.indirectPointerInputDragCycleDetector = indirectPointerInputDragCycleDetector;
            }
            if (this.indirectTouchGestureNode == null) {
                GestureNode gestureNode = new GestureNode(indirectPointerInputDragCycleDetector);
                delegate(gestureNode);
                this.indirectTouchGestureNode = gestureNode;
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector2 = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector2 != null) {
                DragGestureNode dragGestureNode = indirectPointerInputDragCycleDetector2.node;
                ScrollableKt scrollableKt = indirectPointerInputDragCycleDetector2.currentDragState;
                if (scrollableKt == null) {
                    IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2 = indirectPointerInputDragCycleDetector2._awaitDownState;
                    if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2 == null) {
                        obj = scrollableKt;
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2;
                        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown3 = new IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown();
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown3.awaitTouchSlop = IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop.NotInitialized;
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown3.consumedOnInitial = false;
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown3.hasSeenInitialEvent = false;
                        indirectPointerInputDragCycleDetector2._awaitDownState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown3;
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown3;
                    }
                    obj = scrollableKt;
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2;
                    indirectPointerInputDragCycleDetector2.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
                    obj = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
                }
                obj = scrollableKt;
                boolean z2 = obj instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
                PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                PointerEventPass pointerEventPass3 = PointerEventPass.Main;
                if (z2) {
                    IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown4 = (IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown) obj;
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        IndirectPointerInputChange indirectPointerInputChange = (IndirectPointerInputChange) arrayList.get(i2);
                        if (indirectPointerInputChange.previousPressed || !indirectPointerInputChange.pressed) {
                            return;
                        }
                    }
                    IndirectPointerInputChange indirectPointerInputChange2 = (IndirectPointerInputChange) CollectionsKt.first((List) arrayList);
                    int i3 = IndirectPointerInputDragCycleDetector.WhenMappings.$EnumSwitchMapping$0[indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown4.awaitTouchSlop.ordinal()];
                    IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop awaitTouchSlop = IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop.No;
                    IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop awaitTouchSlop2 = IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop.Yes;
                    IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop awaitTouchSlop3 = i3 == 1 ? !dragGestureNode.startDragImmediately() ? awaitTouchSlop2 : awaitTouchSlop : indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown4.awaitTouchSlop;
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown4.awaitTouchSlop = awaitTouchSlop3;
                    if (pointerEventPass == pointerEventPass2) {
                        if (awaitTouchSlop3 == awaitTouchSlop) {
                            indirectPointerInputChange2.isConsumed = true;
                            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown4.consumedOnInitial = true;
                        }
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown4.hasSeenInitialEvent = true;
                    }
                    if (pointerEventPass == pointerEventPass3) {
                        if (awaitTouchSlop3 == awaitTouchSlop2) {
                            IndirectPointerInputDragCycleDetector.m69moveToAwaitTouchSlopStateaWI9W7U$default(indirectPointerInputDragCycleDetector2, indirectPointerInputChange2, indirectPointerInputChange2.id, 0L, 12);
                            return;
                        }
                        if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown4.consumedOnInitial) {
                            indirectPointerInputDragCycleDetector2.m72sendDragStart3f7A7Is(indirectPointerInputChange2, indirectPointerInputChange2, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), 0L);
                            indirectPointerInputDragCycleDetector2.m71sendDragEventEu1f8Dk(indirectPointerInputChange2, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), 0L);
                            long j = indirectPointerInputChange2.id;
                            IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging indirectPointerInputDragCycleDetector$DragDetectionState$Dragging = indirectPointerInputDragCycleDetector2._draggingState;
                            if (indirectPointerInputDragCycleDetector$DragDetectionState$Dragging == null) {
                                indirectPointerInputDragCycleDetector$DragDetectionState$Dragging = new IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging();
                                indirectPointerInputDragCycleDetector$DragDetectionState$Dragging.pointerId = Long.MAX_VALUE;
                                indirectPointerInputDragCycleDetector2._draggingState = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging;
                            }
                            indirectPointerInputDragCycleDetector$DragDetectionState$Dragging.pointerId = j;
                            indirectPointerInputDragCycleDetector2.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging;
                            return;
                        }
                        return;
                    }
                    return;
                }
                boolean z3 = obj instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;
                PointerEventPass pointerEventPass4 = PointerEventPass.Final;
                if (!z3) {
                    if (obj instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup) {
                        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup = (IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup) obj;
                        if (pointerEventPass != pointerEventPass4) {
                            return;
                        }
                        int size2 = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size2) {
                                z = true;
                                break;
                            } else {
                                if (((IndirectPointerInputChange) arrayList.get(i4)).isConsumed) {
                                    z = false;
                                    break;
                                }
                                i4++;
                            }
                        }
                        int size3 = arrayList.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (((IndirectPointerInputChange) arrayList.get(i5)).pressed) {
                                if (arrayList.isEmpty()) {
                                    break;
                                }
                                if (z) {
                                    long jM96primaryAxisPosition_bfSUIo = ScrollableKt.m96primaryAxisPosition_bfSUIo((IndirectPointerInputChange) CollectionsKt.first((List) arrayList), dragGestureNode.orientation, new IndirectPointerEventPrimaryDirectionalMotionAxis(i));
                                    IndirectPointerInputChange indirectPointerInputChange3 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.initialDown;
                                    indirectPointerInputChange3.getClass();
                                    long jM438minusMKHz9U = Offset.m438minusMKHz9U(jM96primaryAxisPosition_bfSUIo, ScrollableKt.m96primaryAxisPosition_bfSUIo(indirectPointerInputChange3, dragGestureNode.orientation, new IndirectPointerEventPrimaryDirectionalMotionAxis(i)));
                                    IndirectPointerInputChange indirectPointerInputChange4 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.initialDown;
                                    if (indirectPointerInputChange4 != null) {
                                        IndirectPointerInputDragCycleDetector.m69moveToAwaitTouchSlopStateaWI9W7U$default(indirectPointerInputDragCycleDetector2, indirectPointerInputChange4, indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.pointerId, jM438minusMKHz9U, 8);
                                        return;
                                    } else {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("AwaitGesturePickup.initialDown was not initialized.");
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        indirectPointerInputDragCycleDetector2.moveToAwaitDownState$1();
                        return;
                    }
                    if (!(obj instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging)) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return;
                    }
                    IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging indirectPointerInputDragCycleDetector$DragDetectionState$Dragging2 = (IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging) obj;
                    if (pointerEventPass != pointerEventPass3) {
                        return;
                    }
                    long j2 = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging2.pointerId;
                    int size4 = arrayList.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size4) {
                            obj2 = null;
                            break;
                        }
                        obj2 = arrayList.get(i6);
                        if (PointerId.m590equalsimpl0(((IndirectPointerInputChange) obj2).id, j2)) {
                            break;
                        } else {
                            i6++;
                        }
                    }
                    IndirectPointerInputChange indirectPointerInputChange5 = (IndirectPointerInputChange) obj2;
                    if (indirectPointerInputChange5 == null) {
                        return;
                    }
                    boolean z4 = indirectPointerInputChange5.pressed;
                    boolean z5 = indirectPointerInputChange5.previousPressed;
                    DragEvent.DragCancelled dragCancelled = DragEvent.DragCancelled.INSTANCE;
                    if (!z5 || z4) {
                        if (indirectPointerInputChange5.isConsumed) {
                            dragGestureNode.onDragEvent(dragCancelled);
                            return;
                        } else {
                            indirectPointerInputDragCycleDetector2.m71sendDragEventEu1f8Dk(indirectPointerInputChange5, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), ScrollableKt.m95positionChangeInternalwfG_k4k(indirectPointerInputChange5, dragGestureNode.orientation, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), false));
                            indirectPointerInputChange5.isConsumed = true;
                            return;
                        }
                    }
                    int size5 = arrayList.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size5) {
                            obj3 = null;
                            break;
                        }
                        Object obj7 = arrayList.get(i7);
                        if (((IndirectPointerInputChange) obj7).pressed) {
                            obj3 = obj7;
                            break;
                        }
                        i7++;
                    }
                    IndirectPointerInputChange indirectPointerInputChange6 = (IndirectPointerInputChange) obj3;
                    if (indirectPointerInputChange6 != null) {
                        indirectPointerInputDragCycleDetector$DragDetectionState$Dragging2.pointerId = indirectPointerInputChange6.id;
                        return;
                    }
                    if (indirectPointerInputChange5.isConsumed || !z5 || z4) {
                        dragGestureNode.onDragEvent(dragCancelled);
                    } else {
                        indirectPointerInputDragCycleDetector2.requireVelocityTracker$1().m594addPositionUv8p0NA(indirectPointerInputChange5.uptimeMillis, Offset.m439plusMKHz9U(ScrollableKt.m96primaryAxisPosition_bfSUIo(indirectPointerInputChange5, dragGestureNode.orientation, new IndirectPointerEventPrimaryDirectionalMotionAxis(i)), indirectPointerInputDragCycleDetector2.rootOffset));
                        float maximumFlingVelocity = ((ViewConfiguration) HitTestResultKt.currentValueOf(dragGestureNode, CompositionLocalsKt.LocalViewConfiguration)).getMaximumFlingVelocity();
                        long jM596calculateVelocityAH228Gc = indirectPointerInputDragCycleDetector2.requireVelocityTracker$1().m596calculateVelocityAH228Gc(MathKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
                        indirectPointerInputDragCycleDetector2.requireVelocityTracker$1().resetTracking();
                        dragGestureNode.onDragEvent(new DragEvent.DragStopped(DraggableKt.m68toValidVelocityTH1AsA0(jM596calculateVelocityAH228Gc), true));
                    }
                    indirectPointerInputDragCycleDetector2.moveToAwaitDownState$1();
                    return;
                }
                IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = (IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop) obj;
                if (pointerEventPass == pointerEventPass2) {
                    return;
                }
                int size6 = arrayList.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size6) {
                        obj4 = null;
                        break;
                    }
                    obj4 = arrayList.get(i8);
                    if (PointerId.m590equalsimpl0(((IndirectPointerInputChange) obj4).id, indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId)) {
                        break;
                    } else {
                        i8++;
                    }
                }
                IndirectPointerInputChange indirectPointerInputChange7 = (IndirectPointerInputChange) obj4;
                if (indirectPointerInputChange7 == null) {
                    int size7 = arrayList.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size7) {
                            obj6 = null;
                            break;
                        }
                        obj6 = arrayList.get(i9);
                        if (((IndirectPointerInputChange) obj6).pressed) {
                            break;
                        } else {
                            i9++;
                        }
                    }
                    indirectPointerInputChange7 = (IndirectPointerInputChange) obj6;
                    if (indirectPointerInputChange7 == null) {
                        indirectPointerInputDragCycleDetector2.moveToAwaitDownState$1();
                        return;
                    }
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId = indirectPointerInputChange7.id;
                }
                IndirectPointerInputChange indirectPointerInputChange8 = indirectPointerInputChange7;
                if (pointerEventPass == pointerEventPass3) {
                    if (indirectPointerInputChange8.isConsumed) {
                        IndirectPointerInputChange indirectPointerInputChange9 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown;
                        if (indirectPointerInputChange9 == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("AwaitTouchSlop.initialDown was not initialized");
                            return;
                        }
                        long j3 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId;
                        HeadersReader headersReader = indirectPointerInputDragCycleDetector2.touchSlopDetector;
                        if (headersReader == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("AwaitTouchSlop.touchSlopDetector was not initialized");
                            return;
                        }
                        indirectPointerInputDragCycleDetector2.m70moveToAwaitGesturePickupStaternUCldI(indirectPointerInputChange9, j3, headersReader);
                    } else if (!indirectPointerInputChange8.previousPressed || indirectPointerInputChange8.pressed) {
                        float touchSlop = ((ViewConfiguration) HitTestResultKt.currentValueOf(dragGestureNode, CompositionLocalsKt.LocalViewConfiguration)).getTouchSlop();
                        HeadersReader headersReader2 = indirectPointerInputDragCycleDetector2.touchSlopDetector;
                        if (headersReader2 == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Touch slop detector not initialized.");
                            return;
                        }
                        long jM1911getPostSlopOffsetqto3Fdw$default = HeadersReader.m1911getPostSlopOffsetqto3Fdw$default(headersReader2, ScrollableKt.m95positionChangeInternalwfG_k4k(indirectPointerInputChange8, dragGestureNode.orientation, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), true), touchSlop);
                        if ((9223372034707292159L & jM1911getPostSlopOffsetqto3Fdw$default) != 9205357640488583168L) {
                            indirectPointerInputChange8.isConsumed = true;
                            IndirectPointerInputChange indirectPointerInputChange10 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown;
                            indirectPointerInputChange10.getClass();
                            indirectPointerInputDragCycleDetector2.m72sendDragStart3f7A7Is(indirectPointerInputChange10, indirectPointerInputChange8, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), jM1911getPostSlopOffsetqto3Fdw$default);
                            indirectPointerInputDragCycleDetector2.m71sendDragEventEu1f8Dk(indirectPointerInputChange8, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), jM1911getPostSlopOffsetqto3Fdw$default);
                            long j4 = indirectPointerInputChange8.id;
                            IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3 = indirectPointerInputDragCycleDetector2._draggingState;
                            if (indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3 == null) {
                                indirectPointerInputDragCycleDetector2 = indirectPointerInputDragCycleDetector2;
                                indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3 = new IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging();
                                indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3.pointerId = Long.MAX_VALUE;
                                indirectPointerInputDragCycleDetector2._draggingState = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3;
                            }
                            indirectPointerInputDragCycleDetector2 = indirectPointerInputDragCycleDetector2;
                            indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3.pointerId = j4;
                            indirectPointerInputDragCycleDetector2.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3;
                        } else {
                            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = true;
                        }
                    } else {
                        int size8 = arrayList.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size8) {
                                obj5 = null;
                                break;
                            }
                            Object obj8 = arrayList.get(i10);
                            if (((IndirectPointerInputChange) obj8).pressed) {
                                obj5 = obj8;
                                break;
                            }
                            i10++;
                        }
                        IndirectPointerInputChange indirectPointerInputChange11 = (IndirectPointerInputChange) obj5;
                        if (indirectPointerInputChange11 == null) {
                            indirectPointerInputDragCycleDetector2.moveToAwaitDownState$1();
                        } else {
                            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId = indirectPointerInputChange11.id;
                        }
                    }
                }
                if (pointerEventPass != pointerEventPass4 || !indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass) {
                    indirectPointerInputDragCycleDetector2 = indirectPointerInputDragCycleDetector2;
                    return;
                }
                if (!indirectPointerInputChange8.isConsumed) {
                    indirectPointerInputDragCycleDetector2 = indirectPointerInputDragCycleDetector2;
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
                    return;
                }
                IndirectPointerInputChange indirectPointerInputChange12 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown;
                if (indirectPointerInputChange12 == null) {
                    indirectPointerInputDragCycleDetector2 = indirectPointerInputDragCycleDetector2;
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("AwaitTouchSlop.initialDown was not initialized");
                    return;
                }
                long j5 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId;
                HeadersReader headersReader3 = indirectPointerInputDragCycleDetector2.touchSlopDetector;
                if (headersReader3 != null) {
                    indirectPointerInputDragCycleDetector2 = indirectPointerInputDragCycleDetector2;
                    indirectPointerInputDragCycleDetector2.m70moveToAwaitGesturePickupStaternUCldI(indirectPointerInputChange12, j5, headersReader3);
                } else {
                    indirectPointerInputDragCycleDetector2 = indirectPointerInputDragCycleDetector2;
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("AwaitTouchSlop.touchSlopDetector was not initialized");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c4  */
    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        Object obj;
        Object obj2;
        PointerEventPass pointerEventPass2;
        Object obj3;
        String str;
        boolean z;
        Object obj4;
        Object obj5;
        Object obj6;
        DragDetectionState$AwaitDown dragDetectionState$AwaitDown;
        boolean z2 = true;
        this.isListeningForPointerInputEvents = true;
        if (this.enabled) {
            if (this.pointerInputGestureNode == null) {
                GestureNode gestureNode = new GestureNode(this);
                delegate(gestureNode);
                this.pointerInputGestureNode = gestureNode;
            }
            ScrollableKt scrollableKt = this.currentDragState;
            int i = 0;
            Object obj7 = scrollableKt;
            if (scrollableKt == null) {
                DragDetectionState$AwaitDown dragDetectionState$AwaitDown2 = this._awaitDownState;
                if (dragDetectionState$AwaitDown2 == null) {
                    dragDetectionState$AwaitDown = dragDetectionState$AwaitDown2;
                    DragDetectionState$AwaitDown dragDetectionState$AwaitDown3 = new DragDetectionState$AwaitDown();
                    dragDetectionState$AwaitDown3.awaitTouchSlop = DragDetectionState$AwaitDown.AwaitTouchSlop.NotInitialized;
                    dragDetectionState$AwaitDown3.consumedOnInitial = false;
                    dragDetectionState$AwaitDown3.hasSeenInitialEvent = false;
                    this._awaitDownState = dragDetectionState$AwaitDown3;
                    dragDetectionState$AwaitDown = dragDetectionState$AwaitDown3;
                }
                dragDetectionState$AwaitDown = dragDetectionState$AwaitDown2;
                this.currentDragState = dragDetectionState$AwaitDown;
                obj7 = dragDetectionState$AwaitDown;
            }
            boolean z3 = obj7 instanceof DragDetectionState$AwaitDown;
            PointerEventPass pointerEventPass3 = PointerEventPass.Initial;
            PointerEventPass pointerEventPass4 = PointerEventPass.Main;
            if (z3) {
                DragDetectionState$AwaitDown dragDetectionState$AwaitDown4 = (DragDetectionState$AwaitDown) obj7;
                if (pointerEvent.changes.isEmpty()) {
                    return;
                }
                List list = pointerEvent.changes;
                int size = list.size();
                while (true) {
                    if (i >= size) {
                        obj6 = null;
                        break;
                    }
                    Object obj8 = list.get(i);
                    if (PointerIconKt.changedToDownIgnoreConsumed((PointerInputChange) obj8)) {
                        obj6 = obj8;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange = (PointerInputChange) obj6;
                if (pointerInputChange == null) {
                    return;
                }
                int i2 = WhenMappings.$EnumSwitchMapping$0[dragDetectionState$AwaitDown4.awaitTouchSlop.ordinal()];
                DragDetectionState$AwaitDown.AwaitTouchSlop awaitTouchSlop = DragDetectionState$AwaitDown.AwaitTouchSlop.No;
                DragDetectionState$AwaitDown.AwaitTouchSlop awaitTouchSlop2 = DragDetectionState$AwaitDown.AwaitTouchSlop.Yes;
                DragDetectionState$AwaitDown.AwaitTouchSlop awaitTouchSlop3 = i2 == 1 ? !startDragImmediately() ? awaitTouchSlop2 : awaitTouchSlop : dragDetectionState$AwaitDown4.awaitTouchSlop;
                dragDetectionState$AwaitDown4.awaitTouchSlop = awaitTouchSlop3;
                if (pointerEventPass == pointerEventPass3) {
                    if (awaitTouchSlop3 == awaitTouchSlop) {
                        pointerInputChange.consume();
                        dragDetectionState$AwaitDown4.consumedOnInitial = true;
                    }
                    dragDetectionState$AwaitDown4.hasSeenInitialEvent = true;
                }
                if (pointerEventPass == pointerEventPass4) {
                    if (awaitTouchSlop3 == awaitTouchSlop2) {
                        m63moveToAwaitTouchSlopStateaWI9W7U$default(this, pointerInputChange, pointerInputChange.id, 0L, 12);
                        return;
                    }
                    if (dragDetectionState$AwaitDown4.consumedOnInitial) {
                        m67sendDragStart0AR0LA0(pointerInputChange, pointerInputChange, 0L);
                        m66sendDragEventUv8p0NA(0L, pointerInputChange);
                        long j2 = pointerInputChange.id;
                        DragDetectionState$Dragging dragDetectionState$Dragging = this._draggingState;
                        if (dragDetectionState$Dragging == null) {
                            dragDetectionState$Dragging = new DragDetectionState$Dragging();
                            dragDetectionState$Dragging.pointerId = Long.MAX_VALUE;
                            this._draggingState = dragDetectionState$Dragging;
                        }
                        dragDetectionState$Dragging.pointerId = j2;
                        this.currentDragState = dragDetectionState$Dragging;
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z4 = obj7 instanceof DragDetectionState$AwaitTouchSlop;
            PointerEventPass pointerEventPass5 = PointerEventPass.Final;
            if (!z4) {
                if (obj7 instanceof DragDetectionState$AwaitGesturePickup) {
                    DragDetectionState$AwaitGesturePickup dragDetectionState$AwaitGesturePickup = (DragDetectionState$AwaitGesturePickup) obj7;
                    if (pointerEventPass != pointerEventPass5) {
                        return;
                    }
                    List list2 = pointerEvent.changes;
                    int size2 = list2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        if (((PointerInputChange) list2.get(i3)).isConsumed()) {
                            z2 = false;
                            break;
                        }
                    }
                    int size3 = list2.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        if (((PointerInputChange) list2.get(i4)).pressed) {
                            if (list2.isEmpty()) {
                                break;
                            }
                            if (z2) {
                                long j3 = ((PointerInputChange) CollectionsKt.first(list2)).position;
                                PointerInputChange pointerInputChange2 = dragDetectionState$AwaitGesturePickup.initialDown;
                                pointerInputChange2.getClass();
                                long jM438minusMKHz9U = Offset.m438minusMKHz9U(j3, pointerInputChange2.position);
                                PointerInputChange pointerInputChange3 = dragDetectionState$AwaitGesturePickup.initialDown;
                                if (pointerInputChange3 != null) {
                                    m63moveToAwaitTouchSlopStateaWI9W7U$default(this, pointerInputChange3, dragDetectionState$AwaitGesturePickup.pointerId, jM438minusMKHz9U, 8);
                                    return;
                                } else {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("AwaitGesturePickup.initialDown was not initialized.");
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    moveToAwaitDownState();
                    return;
                }
                if (!(obj7 instanceof DragDetectionState$Dragging)) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                DragDetectionState$Dragging dragDetectionState$Dragging2 = (DragDetectionState$Dragging) obj7;
                if (pointerEventPass != pointerEventPass4) {
                    return;
                }
                long j4 = dragDetectionState$Dragging2.pointerId;
                List list3 = pointerEvent.changes;
                int size4 = list3.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size4) {
                        obj = null;
                        break;
                    }
                    obj = list3.get(i5);
                    if (PointerId.m590equalsimpl0(((PointerInputChange) obj).id, j4)) {
                        break;
                    } else {
                        i5++;
                    }
                }
                PointerInputChange pointerInputChange4 = (PointerInputChange) obj;
                if (pointerInputChange4 == null) {
                    return;
                }
                boolean zChangedToUpIgnoreConsumed = PointerIconKt.changedToUpIgnoreConsumed(pointerInputChange4);
                Object obj9 = DragEvent.DragCancelled.INSTANCE;
                if (!zChangedToUpIgnoreConsumed) {
                    if (pointerInputChange4.isConsumed()) {
                        requireChannel().mo1712trySendJP2dKIU(obj9);
                        return;
                    } else {
                        m66sendDragEventUv8p0NA(PointerIconKt.positionChangeInternal(pointerInputChange4, false), pointerInputChange4);
                        pointerInputChange4.consume();
                        return;
                    }
                }
                List list4 = pointerEvent.changes;
                int size5 = list4.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size5) {
                        obj2 = null;
                        break;
                    }
                    Object obj10 = list4.get(i6);
                    if (((PointerInputChange) obj10).pressed) {
                        obj2 = obj10;
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange5 = (PointerInputChange) obj2;
                if (pointerInputChange5 != null) {
                    dragDetectionState$Dragging2.pointerId = pointerInputChange5.id;
                    return;
                }
                if (pointerInputChange4.isConsumed() || !PointerIconKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                    requireChannel().mo1712trySendJP2dKIU(obj9);
                } else {
                    float maximumFlingVelocity = ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getMaximumFlingVelocity();
                    UtilsKt.m891addPointerInputChange0AR0LA0(requireVelocityTracker(), pointerInputChange4, 0L);
                    long jM596calculateVelocityAH228Gc = requireVelocityTracker().m596calculateVelocityAH228Gc(MathKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
                    requireVelocityTracker().resetTracking();
                    requireChannel().mo1712trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m68toValidVelocityTH1AsA0(jM596calculateVelocityAH228Gc), false));
                    this.isListeningForPointerInputEvents = false;
                }
                moveToAwaitDownState();
                return;
            }
            DragDetectionState$AwaitTouchSlop dragDetectionState$AwaitTouchSlop = (DragDetectionState$AwaitTouchSlop) obj7;
            if (pointerEventPass == pointerEventPass3) {
                return;
            }
            List list5 = pointerEvent.changes;
            int size6 = list5.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size6) {
                    pointerEventPass2 = pointerEventPass5;
                    obj3 = null;
                    break;
                }
                obj3 = list5.get(i7);
                pointerEventPass2 = pointerEventPass5;
                if (PointerId.m590equalsimpl0(((PointerInputChange) obj3).id, dragDetectionState$AwaitTouchSlop.pointerId)) {
                    break;
                }
                i7++;
                pointerEventPass5 = pointerEventPass2;
            }
            PointerInputChange pointerInputChange6 = (PointerInputChange) obj3;
            if (pointerInputChange6 == null) {
                int size7 = list5.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size7) {
                        obj5 = null;
                        break;
                    }
                    obj5 = list5.get(i8);
                    if (((PointerInputChange) obj5).pressed) {
                        break;
                    } else {
                        i8++;
                    }
                }
                pointerInputChange6 = (PointerInputChange) obj5;
                if (pointerInputChange6 == null) {
                    moveToAwaitDownState();
                    return;
                }
                dragDetectionState$AwaitTouchSlop.pointerId = pointerInputChange6.id;
            }
            if (pointerEventPass != pointerEventPass4) {
                str = "AwaitTouchSlop.touchSlopDetector was not initialized";
            } else {
                if (!pointerInputChange6.isConsumed()) {
                    if (PointerIconKt.changedToUpIgnoreConsumed(pointerInputChange6)) {
                        int size8 = list5.size();
                        int i9 = 0;
                        while (true) {
                            if (i9 >= size8) {
                                obj4 = null;
                                break;
                            }
                            Object obj11 = list5.get(i9);
                            if (((PointerInputChange) obj11).pressed) {
                                obj4 = obj11;
                                break;
                            }
                            i9++;
                        }
                        PointerInputChange pointerInputChange7 = (PointerInputChange) obj4;
                        if (pointerInputChange7 == null) {
                            moveToAwaitDownState();
                        } else {
                            dragDetectionState$AwaitTouchSlop.pointerId = pointerInputChange7.id;
                        }
                        str = "AwaitTouchSlop.touchSlopDetector was not initialized";
                    } else {
                        float fM94pointerSlopE8SPZFQ = ScrollableKt.m94pointerSlopE8SPZFQ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration), pointerInputChange6.type);
                        HeadersReader headersReader = this.touchSlopDetector;
                        if (headersReader == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Touch slop detector not initialized.");
                            return;
                        }
                        long jM1911getPostSlopOffsetqto3Fdw$default = HeadersReader.m1911getPostSlopOffsetqto3Fdw$default(headersReader, PointerIconKt.positionChangeInternal(pointerInputChange6, true), fM94pointerSlopE8SPZFQ);
                        if ((9223372034707292159L & jM1911getPostSlopOffsetqto3Fdw$default) != 9205357640488583168L) {
                            str = "AwaitTouchSlop.touchSlopDetector was not initialized";
                            long jM439plusMKHz9U = Offset.m439plusMKHz9U(this.dragAccumulator, PointerIconKt.positionChangeInternal(pointerInputChange6, false));
                            this.dragAccumulator = jM439plusMKHz9U;
                            float fAtan2 = ((float) Math.atan2(Math.abs(Float.intBitsToFloat((int) (this.dragAccumulator & 4294967295L))), Math.abs(Float.intBitsToFloat((int) (jM439plusMKHz9U >> 32))))) * 57.29578f;
                            Orientation orientation = this.orientation;
                            if (orientation == null) {
                                z = true;
                            } else {
                                DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = DraggableKt.NoOpOnDragStarted;
                                if (orientation != Orientation.Horizontal ? fAtan2 <= 30.0f || fAtan2 > 90.0f : fAtan2 > 30.0f) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            }
                            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                            BottomSheetKt$$ExternalSyntheticLambda13 bottomSheetKt$$ExternalSyntheticLambda13 = new BottomSheetKt$$ExternalSyntheticLambda13(fAtan2, ref$BooleanRef);
                            DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$2 = DraggableKt.NoOpOnDragStarted;
                            HitTestResultKt.traverseAncestors(this, GestureNode.TraverseKey, new CodecsKt$$ExternalSyntheticLambda0(new ScrollState$$ExternalSyntheticLambda0((byte) 11, bottomSheetKt$$ExternalSyntheticLambda13), (byte) 6));
                            if (z || !ref$BooleanRef.element) {
                                pointerInputChange6.consume();
                                PointerInputChange pointerInputChange8 = dragDetectionState$AwaitTouchSlop.initialDown;
                                pointerInputChange8.getClass();
                                m67sendDragStart0AR0LA0(pointerInputChange8, pointerInputChange6, jM1911getPostSlopOffsetqto3Fdw$default);
                                m66sendDragEventUv8p0NA(jM1911getPostSlopOffsetqto3Fdw$default, pointerInputChange6);
                                long j5 = pointerInputChange6.id;
                                DragDetectionState$Dragging dragDetectionState$Dragging3 = this._draggingState;
                                if (dragDetectionState$Dragging3 == null) {
                                    dragDetectionState$Dragging3 = new DragDetectionState$Dragging();
                                    dragDetectionState$Dragging3.pointerId = Long.MAX_VALUE;
                                    this._draggingState = dragDetectionState$Dragging3;
                                }
                                dragDetectionState$Dragging3.pointerId = j5;
                                this.currentDragState = dragDetectionState$Dragging3;
                            } else {
                                dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = true;
                            }
                        } else {
                            str = "AwaitTouchSlop.touchSlopDetector was not initialized";
                            dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = true;
                            this.dragAccumulator = Offset.m439plusMKHz9U(this.dragAccumulator, PointerIconKt.positionChangeInternal(pointerInputChange6, true));
                        }
                    }
                    if (pointerEventPass == pointerEventPass2 || !dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass) {
                    }
                    if (!pointerInputChange6.isConsumed()) {
                        dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
                        return;
                    }
                    PointerInputChange pointerInputChange9 = dragDetectionState$AwaitTouchSlop.initialDown;
                    if (pointerInputChange9 == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("AwaitTouchSlop.initialDown was not initialized");
                        return;
                    }
                    long j6 = dragDetectionState$AwaitTouchSlop.pointerId;
                    HeadersReader headersReader2 = this.touchSlopDetector;
                    if (headersReader2 != null) {
                        m64moveToAwaitGesturePickupStaternUCldI(pointerInputChange9, j6, headersReader2);
                        return;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(str);
                        return;
                    }
                }
                str = "AwaitTouchSlop.touchSlopDetector was not initialized";
                PointerInputChange pointerInputChange10 = dragDetectionState$AwaitTouchSlop.initialDown;
                if (pointerInputChange10 == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("AwaitTouchSlop.initialDown was not initialized");
                    return;
                }
                long j7 = dragDetectionState$AwaitTouchSlop.pointerId;
                HeadersReader headersReader3 = this.touchSlopDetector;
                if (headersReader3 == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(str);
                    return;
                }
                m64moveToAwaitGesturePickupStaternUCldI(pointerInputChange10, j7, headersReader3);
            }
            if (pointerEventPass == pointerEventPass2) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processDragCancel(ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction$Start dragInteraction$Start = this.dragInteraction;
            if (dragInteraction$Start != null) {
                MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
                if (mutableInteractionSourceImpl != null) {
                    DragInteraction$Cancel dragInteraction$Cancel = new DragInteraction$Cancel(dragInteraction$Start);
                    anonymousClass1.label = 1;
                    Object objEmit = mutableInteractionSourceImpl.emit(dragInteraction$Cancel, anonymousClass1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objEmit == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            onDragStopped(new DragEvent.DragStopped(0L, false));
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.dragInteraction = null;
        onDragStopped(new DragEvent.DragStopped(0L, false));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processDragStart(DragEvent.DragStarted dragStarted, ContinuationImpl continuationImpl) {
        C00191 c00191;
        MutableInteractionSourceImpl mutableInteractionSourceImpl;
        DragInteraction$Start dragInteraction$Start;
        DragEvent.DragStarted dragStarted2;
        DragInteraction$Start dragInteraction$Start2;
        if (continuationImpl instanceof C00191) {
            c00191 = (C00191) continuationImpl;
            int i = c00191.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00191.label = i - Integer.MIN_VALUE;
            } else {
                c00191 = new C00191(continuationImpl);
            }
        } else {
            c00191 = new C00191(continuationImpl);
        }
        Object obj = c00191.result;
        int i2 = c00191.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction$Start dragInteraction$Start3 = this.dragInteraction;
            if (dragInteraction$Start3 != null && (mutableInteractionSourceImpl = this.interactionSource) != null) {
                DragInteraction$Cancel dragInteraction$Cancel = new DragInteraction$Cancel(dragInteraction$Start3);
                c00191.L$0 = dragStarted;
                c00191.label = 1;
                if (mutableInteractionSourceImpl.emit(dragInteraction$Cancel, c00191) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            this.dragInteraction = dragInteraction$Start;
            mo65onDragStartedk4lQ0M(dragStarted.startPoint);
            return Unit.INSTANCE;
        }
        if (i2 == 1) {
            dragStarted = c00191.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            dragInteraction$Start2 = c00191.L$1;
            dragStarted2 = c00191.L$0;
            ResultKt.throwOnFailure(obj);
        }
        dragInteraction$Start = dragInteraction$Start2;
        dragStarted = dragStarted2;
        this.dragInteraction = dragInteraction$Start;
        mo65onDragStartedk4lQ0M(dragStarted.startPoint);
        return Unit.INSTANCE;
        dragInteraction$Start = new DragInteraction$Start();
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.interactionSource;
        if (mutableInteractionSourceImpl2 != null) {
            c00191.L$0 = dragStarted;
            c00191.L$1 = dragInteraction$Start;
            c00191.label = 2;
            if (mutableInteractionSourceImpl2.emit(dragInteraction$Start, c00191) != coroutineSingletons) {
                dragStarted2 = dragStarted;
                dragInteraction$Start2 = dragInteraction$Start;
                dragInteraction$Start = dragInteraction$Start2;
                dragStarted = dragStarted2;
            }
            return coroutineSingletons;
        }
        this.dragInteraction = dragInteraction$Start;
        mo65onDragStartedk4lQ0M(dragStarted.startPoint);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processDragStop(DragEvent.DragStopped dragStopped, ContinuationImpl continuationImpl) throws Throwable {
        C00201 c00201;
        if (continuationImpl instanceof C00201) {
            c00201 = (C00201) continuationImpl;
            int i = c00201.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00201.label = i - Integer.MIN_VALUE;
            } else {
                c00201 = new C00201(continuationImpl);
            }
        } else {
            c00201 = new C00201(continuationImpl);
        }
        Object obj = c00201.result;
        int i2 = c00201.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction$Start dragInteraction$Start = this.dragInteraction;
            if (dragInteraction$Start != null) {
                MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
                if (mutableInteractionSourceImpl != null) {
                    DragInteraction$Stop dragInteraction$Stop = new DragInteraction$Stop(dragInteraction$Start);
                    c00201.L$0 = dragStopped;
                    c00201.label = 1;
                    Object objEmit = mutableInteractionSourceImpl.emit(dragInteraction$Stop, c00201);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objEmit == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            onDragStopped(dragStopped);
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        dragStopped = c00201.L$0;
        ResultKt.throwOnFailure(obj);
        this.dragInteraction = null;
        onDragStopped(dragStopped);
        return Unit.INSTANCE;
    }

    public final Channel requireChannel() {
        BufferedChannel bufferedChannel = this.channel;
        if (bufferedChannel != null) {
            return bufferedChannel;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Events channel not initialized.");
        return null;
    }

    public final VelocityTracker requireVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Velocity Tracker not initialized.");
        return null;
    }

    /* JADX INFO: renamed from: sendDragEvent-Uv8p0NA, reason: not valid java name */
    public final void m66sendDragEventUv8p0NA(long j, PointerInputChange pointerInputChange) {
        this.dragAccumulator = Offset.m439plusMKHz9U(this.dragAccumulator, j);
        long jMo607localToScreenMKHz9U = RulerKt.findRootCoordinates(HitTestResultKt.requireLayoutCoordinates(this)).mo607localToScreenMKHz9U(0L);
        if (!Offset.m434equalsimpl0(this.previousRootPositionOnScreen, 9205357640488583168L) && !Offset.m434equalsimpl0(jMo607localToScreenMKHz9U, this.previousRootPositionOnScreen)) {
            this.rootOffset = Offset.m439plusMKHz9U(this.rootOffset, Offset.m438minusMKHz9U(jMo607localToScreenMKHz9U, this.previousRootPositionOnScreen));
        }
        this.previousRootPositionOnScreen = jMo607localToScreenMKHz9U;
        UtilsKt.m891addPointerInputChange0AR0LA0(requireVelocityTracker(), pointerInputChange, this.rootOffset);
        requireChannel().mo1712trySendJP2dKIU(new DragEvent.DragDelta(j, false));
    }

    /* JADX INFO: renamed from: sendDragStart-0AR0LA0, reason: not valid java name */
    public final void m67sendDragStart0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }
        UtilsKt.m891addPointerInputChange0AR0LA0(requireVelocityTracker(), pointerInputChange, 0L);
        long jM438minusMKHz9U = Offset.m438minusMKHz9U(pointerInputChange2.position, j);
        this.rootOffset = 0L;
        if (((Boolean) this.canDrag.invoke(new PointerType(pointerInputChange.type))).booleanValue()) {
            if (!this.isListeningForEvents) {
                if (this.channel == null) {
                    this.channel = EntryPoints.Channel$default(Integer.MAX_VALUE, 6, null);
                }
                startListeningForEvents();
            }
            this.previousRootPositionOnScreen = RulerKt.findRootCoordinates(HitTestResultKt.requireLayoutCoordinates(this)).mo607localToScreenMKHz9U(0L);
            requireChannel().mo1712trySendJP2dKIU(new DragEvent.DragStarted(jM438minusMKHz9U));
        }
    }

    public boolean startDragImmediately() {
        ScrollingLogic scrollingLogic = ((ScrollableNode) this).scrollLogic;
        if (scrollingLogic.scrollableState.isScrollInProgress()) {
            return true;
        }
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = scrollingLogic.overscrollEffect;
        return androidEdgeEffectOverscrollEffect != null ? androidEdgeEffectOverscrollEffect.isInProgress() : false;
    }

    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        Continuation continuation = null;
        if (this.channel == null) {
            this.channel = EntryPoints.Channel$default(Integer.MAX_VALUE, 6, null);
        }
        AwaitKt.launch$default(getCoroutineScope(), null, null, new NavHostKt$NavHost$29$1(this, continuation, (byte) 2), 3);
    }

    public final void update(Function1 function1, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, Orientation orientation, boolean z2) {
        this.canDrag = function1;
        boolean z3 = true;
        if (this.enabled != z) {
            this.enabled = z;
            if (!z) {
                GestureNode gestureNode = this.indirectTouchGestureNode;
                if (gestureNode != null) {
                    undelegate(gestureNode);
                }
                GestureNode gestureNode2 = this.pointerInputGestureNode;
                if (gestureNode2 != null) {
                    undelegate(gestureNode2);
                }
                this.indirectTouchGestureNode = null;
                this.pointerInputGestureNode = null;
                disposeInteractionSource$1();
                this.indirectPointerInputDragCycleDetector = null;
            }
            z2 = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, mutableInteractionSourceImpl)) {
            disposeInteractionSource$1();
            this.interactionSource = mutableInteractionSourceImpl;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
        } else {
            z3 = z2;
        }
        if (z3) {
            boolean z4 = this.isListeningForPointerInputEvents;
            DragEvent.DragCancelled dragCancelled = DragEvent.DragCancelled.INSTANCE;
            if (z4) {
                moveToAwaitDownState();
                if (this.isListeningForEvents) {
                    requireChannel().mo1712trySendJP2dKIU(dragCancelled);
                }
                this.velocityTracker = null;
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.moveToAwaitDownState$1();
                DragGestureNode dragGestureNode = indirectPointerInputDragCycleDetector.node;
                if (dragGestureNode.isListeningForEvents) {
                    dragGestureNode.onDragEvent(dragCancelled);
                }
                indirectPointerInputDragCycleDetector.velocityTracker = null;
            }
        }
    }

    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public void mo65onDragStartedk4lQ0M(long j) {
    }
}
