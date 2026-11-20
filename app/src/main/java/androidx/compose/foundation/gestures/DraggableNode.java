package androidx.compose.foundation.gestures;

import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.ui.component.LyricsLineKt$WordLevelLyrics$2$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableNode extends DragGestureNode {
    public Function3 onDragStarted;
    public Function3 onDragStopped;
    public boolean reverseDirection;
    public boolean startDragImmediately;
    public DraggableState state;

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final Object drag$1(InnerTube$feedback$2 innerTube$feedback$2, NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1) {
        Object objDrag;
        Orientation orientation = this.orientation;
        return (orientation != null && (objDrag = this.state.drag(new InnerTube$feedback$2((Object) innerTube$feedback$2, (Object) this, (Object) orientation, (Continuation) null, (byte) 2), navHostKt$NavHost$29$1)) == CoroutineSingletons.COROUTINE_SUSPENDED) ? objDrag : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public final void mo65onDragStartedk4lQ0M(long j) {
        if (!this.isAttached || Intrinsics.areEqual(this.onDragStarted, DraggableKt.NoOpOnDragStarted)) {
            return;
        }
        AwaitKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new LyricsLineKt$WordLevelLyrics$2$1(this, j, null), 1);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final void onDragStopped(DragEvent.DragStopped dragStopped) {
        Orientation orientation;
        if (!this.isAttached || Intrinsics.areEqual(this.onDragStopped, DraggableKt.NoOpOnDragStopped) || (orientation = this.orientation) == null) {
            return;
        }
        AwaitKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new InnerTube$feedback$2((Object) this, (Object) dragStopped, (Object) orientation, (Continuation) null, (byte) 3), 1);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final boolean startDragImmediately() {
        return this.startDragImmediately;
    }
}
