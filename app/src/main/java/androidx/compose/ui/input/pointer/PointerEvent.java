package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.view.MotionEvent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerEvent {
    public final int buttons;
    public final List changes;
    public final int classification;
    public final InternalPointerEvent internalPointerEvent;
    public final int keyboardModifiers;
    public int type;

    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    public PointerEvent(List list, InternalPointerEvent internalPointerEvent) {
        MotionEvent motionEvent;
        this.changes = list;
        this.internalPointerEvent = internalPointerEvent;
        int i = 0;
        this.classification = (Build.VERSION.SDK_INT < 29 || (motionEvent = getMotionEvent()) == null) ? 0 : motionEvent.getClassification();
        MotionEvent motionEvent2 = getMotionEvent();
        this.buttons = motionEvent2 != null ? motionEvent2.getButtonState() : 0;
        MotionEvent motionEvent3 = getMotionEvent();
        this.keyboardModifiers = motionEvent3 != null ? motionEvent3.getMetaState() : 0;
        MotionEvent motionEvent4 = getMotionEvent();
        if (motionEvent4 != null) {
            boolean z = (internalPointerEvent != null ? internalPointerEvent.getActiveGesture() : null) == PointerClassification.Pan;
            boolean z2 = (internalPointerEvent != null ? internalPointerEvent.getActiveGesture() : null) == PointerClassification.Pinch;
            int actionMasked = motionEvent4.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                            case 5:
                                if (z) {
                                    i = 10;
                                } else if (z2) {
                                    i = 7;
                                } else if (!z2) {
                                    i = 1;
                                } else {
                                    i = 8;
                                }
                                break;
                            case 6:
                                if (z) {
                                    i = 12;
                                } else if (z2) {
                                    i = 9;
                                } else if (!z2) {
                                    i = 2;
                                } else {
                                    i = 8;
                                }
                                break;
                            case 7:
                                if (z) {
                                    i = 11;
                                } else if (!z2) {
                                    i = 3;
                                } else {
                                    i = 8;
                                }
                                break;
                            case 8:
                                i = 6;
                                break;
                            case 9:
                                i = 4;
                                break;
                            case 10:
                                i = 5;
                                break;
                        }
                    } else if (z) {
                        i = 11;
                    } else if (!z2) {
                        i = 8;
                    } else {
                        i = 3;
                    }
                } else if (z) {
                    i = 12;
                } else if (!z2 || z2) {
                    i = 2;
                } else {
                    i = 9;
                }
            } else if (z) {
                i = 10;
            } else if (!z2 || z2) {
                i = 1;
            } else {
                i = 7;
            }
        } else {
            int size = list.size();
            while (true) {
                if (i < size) {
                    PointerInputChange pointerInputChange = (PointerInputChange) list.get(i);
                    if (PointerIconKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                        i = 2;
                    } else if (PointerIconKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                        i = 1;
                    } else {
                        i++;
                    }
                } else {
                    i = 3;
                }
            }
        }
        this.type = i;
    }

    public final MotionEvent getMotionEvent() {
        InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            return (MotionEvent) internalPointerEvent.pointerInputEvent.mMetadataRepo;
        }
        return null;
    }
}
