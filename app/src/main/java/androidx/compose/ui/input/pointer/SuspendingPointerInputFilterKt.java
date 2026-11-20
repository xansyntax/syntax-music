package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SuspendingPointerInputFilterKt {
    public static final PointerEvent EmptyPointerEvent = new PointerEvent(EmptyList.INSTANCE, null);

    public static final SuspendingPointerInputModifierNodeImpl SuspendingPointerInputModifierNode(PointerInputEventHandler pointerInputEventHandler) {
        return new SuspendingPointerInputModifierNodeImpl(null, null, pointerInputEventHandler);
    }

    public static final Modifier pointerInput(Modifier modifier, Object obj, PointerInputEventHandler pointerInputEventHandler) {
        return modifier.then(new SuspendPointerInputElement(obj, null, pointerInputEventHandler, 6));
    }
}
