package androidx.compose.foundation.text.selection;

import android.view.MotionEvent;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionGestures_androidKt {
    public static final MarqueeSpacing$Companion$$ExternalSyntheticLambda0 FirstLongPressSelectionAdjustment = SelectionAdjustment$Companion.Word;

    public static final boolean isMouseOrTouchPad(PointerEvent pointerEvent) {
        MotionEvent motionEvent;
        List list = pointerEvent.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((PointerInputChange) list.get(i)).type != 2) {
                MotionEvent motionEvent2 = pointerEvent.getMotionEvent();
                if ((motionEvent2 == null || !motionEvent2.isFromSource(8194)) && ((motionEvent = pointerEvent.getMotionEvent()) == null || !motionEvent.isFromSource(1048584))) {
                    return false;
                }
            }
        }
        return true;
    }
}
