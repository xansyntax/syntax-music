package androidx.compose.ui.platform;

import android.content.Context;
import android.view.View;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import io.ktor.client.utils.CIOKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Api24Impl {
    public static final void setPointerIcon(View view, PointerIcon pointerIcon) {
        android.view.PointerIcon androidPointerIcon = toAndroidPointerIcon(view.getContext(), pointerIcon);
        if (Intrinsics.areEqual(view.getPointerIcon(), androidPointerIcon)) {
            return;
        }
        view.setPointerIcon(androidPointerIcon);
    }

    public static final boolean startDragAndDrop(View view, DragAndDropTransferData dragAndDropTransferData, ComposeDragShadowBuilder composeDragShadowBuilder) {
        throw null;
    }

    public static final android.view.PointerIcon toAndroidPointerIcon(Context context, PointerIcon pointerIcon) {
        return pointerIcon instanceof AndroidPointerIconType ? android.view.PointerIcon.getSystemIcon(context, ((AndroidPointerIconType) pointerIcon).type) : android.view.PointerIcon.getSystemIcon(context, CIOKt.DEFAULT_HTTP_POOL_SIZE);
    }
}
