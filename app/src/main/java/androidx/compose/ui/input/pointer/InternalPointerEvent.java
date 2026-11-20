package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import androidx.emoji2.text.EmojiProcessor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InternalPointerEvent {
    public final LongSparseArray changes;
    public final EmojiProcessor pointerInputEvent;
    public boolean suppressMovementConsumption;

    public InternalPointerEvent(LongSparseArray longSparseArray, EmojiProcessor emojiProcessor) {
        this.changes = longSparseArray;
        this.pointerInputEvent = emojiProcessor;
    }

    /* JADX INFO: renamed from: activeHoverEvent-0FcD4WY, reason: not valid java name */
    public final boolean m586activeHoverEvent0FcD4WY(long j) {
        Object obj;
        ArrayList arrayList = (ArrayList) this.pointerInputEvent.mSpanFactory;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            if (PointerId.m590equalsimpl0(((PointerInputEventData) obj).id, j)) {
                break;
            }
            i++;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        return (pointerInputEventData != null ? pointerInputEventData.activeHover : false) || getActiveGesture() == PointerClassification.Pan;
    }

    public final PointerClassification getActiveGesture() {
        int i;
        EmojiProcessor emojiProcessor = this.pointerInputEvent;
        PointerClassification pointerClassification = (PointerClassification) emojiProcessor.mGlyphChecker;
        PointerClassification pointerClassification2 = PointerClassification.None;
        if (pointerClassification != pointerClassification2) {
            return pointerClassification;
        }
        MotionEvent motionEvent = (MotionEvent) emojiProcessor.mMetadataRepo;
        if (motionEvent != null && (i = Build.VERSION.SDK_INT) >= 29) {
            int classification = motionEvent.getClassification();
            if (classification == 1) {
                return PointerClassification.Ambiguous;
            }
            if (classification == 2) {
                return PointerClassification.DeepPress;
            }
            if (classification != 3) {
                if (classification == 5 && i >= 34) {
                    return PointerClassification.Pinch;
                }
            } else if (i >= 34) {
                return PointerClassification.Pan;
            }
        }
        return pointerClassification2;
    }
}
