package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.HitTestResultKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IndirectPointerInputDragCycleDetector implements DraggableGestureConnection {
    public IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown _awaitDownState;
    public IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup _awaitGesturePickupState;
    public IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop _awaitTouchSlopState;
    public IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging _draggingState;
    public ScrollableKt currentDragState;
    public final DragGestureNode node;
    public HeadersReader touchSlopDetector;
    public VelocityTracker velocityTracker;
    public long rootOffset = 0;
    public long previousRootPositionOnScreen = 9205357640488583168L;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop.values().length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public IndirectPointerInputDragCycleDetector(DragGestureNode dragGestureNode) {
        this.node = dragGestureNode;
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U$default, reason: not valid java name */
    public static void m69moveToAwaitTouchSlopStateaWI9W7U$default(IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector, IndirectPointerInputChange indirectPointerInputChange, long j, long j2, int i) {
        if ((i & 4) != 0) {
            j2 = 0;
        }
        DragGestureNode dragGestureNode = indirectPointerInputDragCycleDetector.node;
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = indirectPointerInputDragCycleDetector._awaitTouchSlopState;
        if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop == null) {
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = new IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop();
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown = null;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId = Long.MAX_VALUE;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
            indirectPointerInputDragCycleDetector._awaitTouchSlopState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;
        }
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown = indirectPointerInputChange;
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId = j;
        HeadersReader headersReader = indirectPointerInputDragCycleDetector.touchSlopDetector;
        Orientation orientation = dragGestureNode.orientation;
        if (headersReader == null) {
            indirectPointerInputDragCycleDetector.touchSlopDetector = new HeadersReader(orientation);
        } else {
            headersReader.source = orientation;
            headersReader.headerLimit = j2;
        }
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
        indirectPointerInputDragCycleDetector.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;
    }

    @Override // androidx.compose.foundation.GestureConnection
    /* JADX INFO: renamed from: getGestureState-7meUWtM */
    public final String mo22getGestureState7meUWtM() {
        ScrollableKt scrollableKt = this.currentDragState;
        if (scrollableKt instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown) {
            return ((IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown) scrollableKt).hasSeenInitialEvent ? "waiting" : "idle";
        }
        if ((scrollableKt instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop) || (scrollableKt instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup)) {
            return "waiting";
        }
        return scrollableKt instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging ? "recognized" : "idle";
    }

    @Override // androidx.compose.foundation.gestures.DraggableGestureConnection
    public final Orientation getOrientation() {
        return this.node.orientation;
    }

    public final void moveToAwaitDownState$1() {
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = this._awaitDownState;
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop awaitTouchSlop = IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.AwaitTouchSlop.NotInitialized;
        if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown == null) {
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = new IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown();
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.awaitTouchSlop = awaitTouchSlop;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.consumedOnInitial = false;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.hasSeenInitialEvent = false;
            this._awaitDownState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
        }
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.awaitTouchSlop = awaitTouchSlop;
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.consumedOnInitial = false;
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.hasSeenInitialEvent = false;
        this.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
    }

    /* JADX INFO: renamed from: moveToAwaitGesturePickupState-rnUCldI, reason: not valid java name */
    public final void m70moveToAwaitGesturePickupStaternUCldI(IndirectPointerInputChange indirectPointerInputChange, long j, HeadersReader headersReader) {
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup = this._awaitGesturePickupState;
        if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup == null) {
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup = new IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup();
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.initialDown = null;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.pointerId = Long.MAX_VALUE;
            this._awaitGesturePickupState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;
        }
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.initialDown = indirectPointerInputChange;
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.pointerId = j;
        headersReader.headerLimit = 0L;
        this.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;
    }

    public final VelocityTracker requireVelocityTracker$1() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Velocity Tracker not initialized.");
        return null;
    }

    /* JADX INFO: renamed from: sendDragEvent-Eu1f8Dk, reason: not valid java name */
    public final void m71sendDragEventEu1f8Dk(IndirectPointerInputChange indirectPointerInputChange, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, long j) {
        DragGestureNode dragGestureNode = this.node;
        long jMo607localToScreenMKHz9U = RulerKt.findRootCoordinates(HitTestResultKt.requireLayoutCoordinates(dragGestureNode)).mo607localToScreenMKHz9U(0L);
        if (!Offset.m434equalsimpl0(this.previousRootPositionOnScreen, 9205357640488583168L) && !Offset.m434equalsimpl0(jMo607localToScreenMKHz9U, this.previousRootPositionOnScreen)) {
            this.rootOffset = Offset.m439plusMKHz9U(this.rootOffset, Offset.m438minusMKHz9U(jMo607localToScreenMKHz9U, this.previousRootPositionOnScreen));
        }
        this.previousRootPositionOnScreen = jMo607localToScreenMKHz9U;
        Orientation orientation = dragGestureNode.orientation;
        orientation.getClass();
        DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = DraggableKt.NoOpOnDragStarted;
        if (Math.abs(Float.intBitsToFloat((int) (orientation == Orientation.Vertical ? 4294967295L & j : j >> 32))) > 2.0f) {
            VelocityTracker velocityTrackerRequireVelocityTracker$1 = requireVelocityTracker$1();
            Orientation orientation2 = dragGestureNode.orientation;
            velocityTrackerRequireVelocityTracker$1.m594addPositionUv8p0NA(indirectPointerInputChange.uptimeMillis, Offset.m439plusMKHz9U(ScrollableKt.m96primaryAxisPosition_bfSUIo(indirectPointerInputChange, orientation2, indirectPointerEventPrimaryDirectionalMotionAxis), this.rootOffset));
            dragGestureNode.onDragEvent(new DragEvent.DragDelta(j, true));
        }
    }

    /* JADX INFO: renamed from: sendDragStart-3f7A7Is, reason: not valid java name */
    public final void m72sendDragStart3f7A7Is(IndirectPointerInputChange indirectPointerInputChange, IndirectPointerInputChange indirectPointerInputChange2, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, long j) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }
        this.rootOffset = 0L;
        VelocityTracker velocityTrackerRequireVelocityTracker$1 = requireVelocityTracker$1();
        DragGestureNode dragGestureNode = this.node;
        Orientation orientation = dragGestureNode.orientation;
        long j2 = this.rootOffset;
        velocityTrackerRequireVelocityTracker$1.m594addPositionUv8p0NA(indirectPointerInputChange.uptimeMillis, Offset.m439plusMKHz9U(ScrollableKt.m96primaryAxisPosition_bfSUIo(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis), j2));
        long jM438minusMKHz9U = Offset.m438minusMKHz9U(ScrollableKt.m96primaryAxisPosition_bfSUIo(indirectPointerInputChange2, dragGestureNode.orientation, indirectPointerEventPrimaryDirectionalMotionAxis), j);
        if (((Boolean) dragGestureNode.canDrag.invoke(new PointerType(1))).booleanValue()) {
            this.previousRootPositionOnScreen = RulerKt.findRootCoordinates(HitTestResultKt.requireLayoutCoordinates(dragGestureNode)).mo607localToScreenMKHz9U(0L);
            dragGestureNode.onDragEvent(new DragEvent.DragStarted(jM438minusMKHz9U));
        }
    }
}
