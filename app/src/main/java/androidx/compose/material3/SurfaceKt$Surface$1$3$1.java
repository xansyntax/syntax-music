package androidx.compose.material3;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceKt$Surface$1$3$1 implements PointerInputEventHandler {
    public final /* synthetic */ byte $r8$classId;
    public static final SurfaceKt$Surface$1$3$1 INSTANCE$1 = new SurfaceKt$Surface$1$3$1(1);
    public static final SurfaceKt$Surface$1$3$1 INSTANCE = new SurfaceKt$Surface$1$3$1(0);

    public /* synthetic */ SurfaceKt$Surface$1$3$1(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        byte b = this.$r8$classId;
        return Unit.INSTANCE;
    }
}
