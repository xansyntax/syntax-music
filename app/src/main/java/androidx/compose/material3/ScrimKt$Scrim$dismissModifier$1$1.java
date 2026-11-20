package androidx.compose.material3;

import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode;
import androidx.compose.foundation.text.handwriting.StylusHandwritingNode;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1;
import androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.media3.session.MediaSessionImpl$1;
import coil3.network.NetworkFetcher;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda49;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrimKt$Scrim$dismissModifier$1$1 implements PointerInputEventHandler {
    public final /* synthetic */ Object $onClick;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ScrimKt$Scrim$dismissModifier$1$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.$onClick = obj;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        byte b = this.$r8$classId;
        byte b2 = 2;
        byte b3 = 1;
        Continuation continuation2 = null;
        Object obj = this.$onClick;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AppBarKt$$ExternalSyntheticLambda8((Function0) obj, (byte) 6), continuation, 7);
                return objDetectTapGestures$default == coroutineSingletons ? objDetectTapGestures$default : unit;
            case 1:
                Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new ExposedDropdownMenuKt$expandable$1$1((AndroidEdgeEffectOverscrollEffect) obj, continuation2, b3), continuation);
                return objAwaitEachGesture == coroutineSingletons ? objAwaitEachGesture : unit;
            case 2:
                Object objCoroutineScope = AwaitKt.coroutineScope(new SliderState.AnonymousClass2(pointerInputScope, (PagerState) obj, continuation2, (byte) 8), continuation);
                return objCoroutineScope == coroutineSingletons ? objCoroutineScope : unit;
            case 3:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj;
                MediaSessionImpl$1 mediaSessionImpl$1 = textFieldSelectionManager.mouseSelectionObserver;
                TextFieldSelectionManager$touchSelectionObserver$1 textFieldSelectionManager$touchSelectionObserver$1 = textFieldSelectionManager.touchSelectionObserver;
                SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = (SuspendingPointerInputModifierNodeImpl) pointerInputScope;
                suspendingPointerInputModifierNodeImpl.getClass();
                Object objAwaitEachGesture2 = ScrollableKt.awaitEachGesture(pointerInputScope, new LazyLayoutPagerKt$dragDirectionDetector$1$1$1(new StatusLine(HitTestResultKt.requireLayoutNode(suspendingPointerInputModifierNodeImpl).viewConfiguration), mediaSessionImpl$1, textFieldSelectionManager$touchSelectionObserver$1, null), continuation);
                if (objAwaitEachGesture2 != coroutineSingletons) {
                    objAwaitEachGesture2 = unit;
                }
                return objAwaitEachGesture2 == coroutineSingletons ? objAwaitEachGesture2 : unit;
            case 4:
                Object objAwaitEachGesture3 = ScrollableKt.awaitEachGesture(pointerInputScope, new ExposedDropdownMenuKt$expandable$1$1(new NetworkFetcher.AnonymousClass2(1, (TextContextMenuGestureNode) obj, TextContextMenuGestureNode.class, "tryShowContextMenu", "tryShowContextMenu-k-4lQ0M(J)V", 0, (byte) 3), continuation2, b2), continuation);
                if (objAwaitEachGesture3 != coroutineSingletons) {
                    objAwaitEachGesture3 = unit;
                }
                return objAwaitEachGesture3 == coroutineSingletons ? objAwaitEachGesture3 : unit;
            case 5:
                Object objAwaitEachGesture4 = ScrollableKt.awaitEachGesture(pointerInputScope, new LazyLayoutPagerKt$dragDirectionDetector$1$1$1((StylusHandwritingNode) obj, continuation2, b3), continuation);
                return objAwaitEachGesture4 == coroutineSingletons ? objAwaitEachGesture4 : unit;
            case 6:
                Object objAwaitPointerEventScope = ((SuspendingPointerInputModifierNodeImpl) pointerInputScope).awaitPointerEventScope(new BasicTooltipKt$handleGestures$1.AnonymousClass1.C00001.C00011((CoreTextFieldKt$$ExternalSyntheticLambda1) obj, continuation2, b3), continuation);
                return objAwaitPointerEventScope == coroutineSingletons ? objAwaitPointerEventScope : unit;
            case 7:
                Object objCoroutineScope2 = AwaitKt.coroutineScope(new SyncUtils$createPlaylist$1.AnonymousClass1(pointerInputScope, (TextDragObserver) obj, continuation2, b3), continuation);
                if (objCoroutineScope2 != coroutineSingletons) {
                    objCoroutineScope2 = unit;
                }
                return objCoroutineScope2 == coroutineSingletons ? objCoroutineScope2 : unit;
            case 8:
                Object objAwaitEachGesture5 = ScrollableKt.awaitEachGesture(pointerInputScope, new ExposedDropdownMenuKt$expandable$1$1((PlayerKt$$ExternalSyntheticLambda49) obj, continuation2, (byte) 0), continuation);
                return objAwaitEachGesture5 == coroutineSingletons ? objAwaitEachGesture5 : unit;
            default:
                Object objAwaitPointerEventScope2 = ((SuspendingPointerInputModifierNodeImpl) pointerInputScope).awaitPointerEventScope(new BasicTooltipKt$handleGestures$1.AnonymousClass1.C00001.C00011((MutableState) obj, continuation2, b2), continuation);
                return objAwaitPointerEventScope2 == coroutineSingletons ? objAwaitPointerEventScope2 : unit;
        }
    }
}
