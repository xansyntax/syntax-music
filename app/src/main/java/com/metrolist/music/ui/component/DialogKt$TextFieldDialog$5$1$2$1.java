package com.metrolist.music.ui.component;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DialogKt$TextFieldDialog$5$1$2$1 implements PointerInputEventHandler {
    public static final DialogKt$TextFieldDialog$5$1$2$1 INSTANCE = new DialogKt$TextFieldDialog$5$1$2$1();

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 8), null, null, continuation, 14);
        return objDetectTapGestures$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objDetectTapGestures$default : Unit.INSTANCE;
    }
}
