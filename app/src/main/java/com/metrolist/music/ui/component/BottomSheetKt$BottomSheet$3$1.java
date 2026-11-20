package com.metrolist.music.ui.component;

import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1;
import androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.player.QueueKt$Queue$5$1$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetKt$BottomSheet$3$1 implements PointerInputEventHandler {
    public final /* synthetic */ Object $onDismiss;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $state;

    public /* synthetic */ BottomSheetKt$BottomSheet$3$1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$state = obj;
        this.$onDismiss = obj2;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj = this.$onDismiss;
        Object obj2 = this.$state;
        switch (b) {
            case 0:
                VelocityTracker velocityTracker = new VelocityTracker();
                BottomSheetState bottomSheetState = (BottomSheetState) obj2;
                Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new TapGestureDetectorKt$detectTapAndPress$2$1(new BorderKt$$ExternalSyntheticLambda1((byte) 25), new MainActivity$$ExternalSyntheticLambda1((Object) velocityTracker, (Object) bottomSheetState, (byte) 8), new GapComposer$$ExternalSyntheticLambda0(velocityTracker, bottomSheetState, (Function0) obj, (byte) 13), new ComponentRegistry$Builder$$ExternalSyntheticLambda2(velocityTracker, bottomSheetState, (byte) 10), (Continuation) null, (byte) 3), continuation);
                if (objAwaitEachGesture != coroutineSingletons) {
                    objAwaitEachGesture = unit;
                }
                return objAwaitEachGesture == coroutineSingletons ? objAwaitEachGesture : unit;
            case 1:
                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new ClickableTextKt$$ExternalSyntheticLambda1((MutableState) obj2, (Function1) obj, (byte) 1), continuation, 7);
                return objDetectTapGestures$default == coroutineSingletons ? objDetectTapGestures$default : unit;
            default:
                Object objCoroutineScope = AwaitKt.coroutineScope(new QueueKt$Queue$5$1$1((Object) pointerInputScope, obj2, obj, (Continuation) null, (byte) 1), continuation);
                return objCoroutineScope == coroutineSingletons ? objCoroutineScope : unit;
        }
    }
}
