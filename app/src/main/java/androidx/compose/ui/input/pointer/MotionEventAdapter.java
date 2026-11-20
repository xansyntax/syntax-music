package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.LongSparseArray;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.emoji2.text.EmojiProcessor;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MotionEventAdapter {
    public Offset inferredCursorRawOffset;
    public boolean isAnyPointerDown;
    public boolean isInFakeFingerGesture;
    public boolean isReinterpretingFakeFingerGesture;
    public boolean isTrackpadPanOngoing;
    public long nextId;
    public final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    public final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    public final ArrayList pointers = new ArrayList();
    public final LongSparseArray previousIndirectPointerEventData = new LongSparseArray();
    public int previousToolType = -1;
    public int previousSource = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class IndirectPointerEventData {
        public final long packedValue;

        public /* synthetic */ IndirectPointerEventData(long j) {
            this.packedValue = j;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof IndirectPointerEventData) {
                return this.packedValue == ((IndirectPointerEventData) obj).packedValue;
            }
            return false;
        }

        public final int hashCode() {
            return Long.hashCode(this.packedValue);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.packedValue, "IndirectPointerEventData(packedValue=", ")");
        }
    }

    public final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (sparseLongArray.indexOfKey(pointerId) < 0) {
                long j = this.nextId;
                this.nextId = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (sparseLongArray.indexOfKey(pointerId2) < 0) {
            long j2 = this.nextId;
            this.nextId = 1 + j2;
            sparseLongArray.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    public final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (source == 8194 || source == 1048584) {
            if (source == this.previousSource && (toolType == this.previousToolType || toolType == 3 || toolType == 1)) {
                return;
            }
        } else if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    /* JADX WARN: Code duplicated, block: B:143:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00d8  */
    public final EmojiProcessor convertToPointerInputEvent$ui(MotionEvent motionEvent, AndroidComposeView androidComposeView) {
        int actionIndex;
        EmojiProcessor emojiProcessor;
        int i;
        ArrayList arrayList;
        Offset offset;
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        SparseBooleanArray sparseBooleanArray = this.activeHoverIds;
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            sparseBooleanArray.clear();
            resetFakeFingerGesture();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        if (actionMasked == 0 && (Build.VERSION.SDK_INT < 34 || (motionEvent.getClassification() != 3 && motionEvent.getClassification() != 5))) {
            resetFakeFingerGesture();
        }
        if (actionMasked == 0 || actionMasked == 5) {
            this.isAnyPointerDown = true;
        }
        boolean z2 = false;
        boolean z3 = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        if ((actionMasked == 9 || actionMasked == 10 || (actionMasked == 7 && !this.isAnyPointerDown && !this.isTrackpadPanOngoing)) && (Build.VERSION.SDK_INT < 34 || (motionEvent.getClassification() != 3 && motionEvent.getClassification() != 5))) {
            resetFakeFingerGesture();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34 && motionEvent.getClassification() == 3) {
            this.isTrackpadPanOngoing = true;
        }
        addFreshIds(motionEvent);
        boolean z4 = actionMasked == 8;
        if (z3 && !this.isAnyPointerDown) {
            sparseBooleanArray.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            actionIndex = 0;
        }
        ArrayList arrayList2 = this.pointers;
        arrayList2.clear();
        if (motionEvent.getActionMasked() == 0) {
            boolean z5 = i2 >= 34 && (motionEvent.getClassification() == 3 || motionEvent.getClassification() == 5);
            if (motionEvent.getButtonState() == 0) {
                emojiProcessor = null;
                if (motionEvent.isFromSource(8194) || motionEvent.isFromSource(1048584)) {
                    z = true;
                }
                if (z5 || z) {
                    this.isInFakeFingerGesture = true;
                }
            } else {
                emojiProcessor = null;
            }
            z = false;
            if (z5) {
                this.isInFakeFingerGesture = true;
            } else {
                this.isInFakeFingerGesture = true;
            }
        } else {
            emojiProcessor = null;
        }
        boolean z6 = i2 >= 34 && (motionEvent.getClassification() == 3 || this.isTrackpadPanOngoing);
        if (i2 < 34 || !(z6 || motionEvent.getClassification() == 5)) {
            i = 2;
            this.isReinterpretingFakeFingerGesture = false;
            int pointerCount = motionEvent.getPointerCount();
            int i3 = 0;
            while (i3 < pointerCount) {
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(m587createPointerInputEventDataInuC1xA(androidComposeView, motionEvent, null, i3, (z3 || i3 == actionIndex || (z4 && motionEvent.getButtonState() == 0)) ? z2 : true));
                i3++;
                arrayList2 = arrayList3;
                pointerCount = pointerCount;
                z2 = false;
            }
            arrayList = arrayList2;
        } else {
            if (motionEvent.getClassification() == 5 && motionEvent.getPointerCount() == 1) {
                if (motionEvent.getActionMasked() == 1) {
                    resetFakeFingerGesture();
                }
                removeStaleIds(motionEvent);
                return emojiProcessor;
            }
            this.isReinterpretingFakeFingerGesture = true;
            if (motionEvent.getActionMasked() == 5 && motionEvent.getClassification() == 5 && motionEvent.getPointerCount() == 2) {
                offset = new Offset((((long) Float.floatToRawIntBits((motionEvent.getRawX(1) + motionEvent.getRawX(0)) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits((motionEvent.getRawY(1) + motionEvent.getRawY(0)) / 2.0f)) & 4294967295L));
                this.inferredCursorRawOffset = offset;
            } else if (motionEvent.getActionMasked() == 0 || (offset = this.inferredCursorRawOffset) == null) {
                offset = new Offset((((long) Float.floatToRawIntBits(motionEvent.getRawY(0))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getRawX(0))) << 32));
                this.inferredCursorRawOffset = offset;
            }
            i = 2;
            arrayList2.add(m587createPointerInputEventDataInuC1xA(androidComposeView, motionEvent, offset, 0, false));
            arrayList = arrayList2;
        }
        int i4 = i;
        boolean z7 = this.isTrackpadPanOngoing;
        PointerClassification pointerClassification = PointerClassification.Pan;
        if (!z7) {
            int i5 = Build.VERSION.SDK_INT;
            PointerClassification pointerClassification2 = PointerClassification.None;
            if (i5 < 34) {
                pointerClassification = pointerClassification2;
            } else {
                int classification = motionEvent.getClassification();
                if (classification == 1) {
                    pointerClassification = PointerClassification.Ambiguous;
                } else if (classification == i4) {
                    pointerClassification = PointerClassification.DeepPress;
                } else if (classification != 3) {
                    if (classification != 5) {
                        pointerClassification = pointerClassification2;
                    } else {
                        pointerClassification = PointerClassification.Pinch;
                    }
                }
            }
        }
        boolean z8 = motionEvent.getActionMasked() == 10 && (Build.VERSION.SDK_INT < 34 || motionEvent.getClassification() != 3);
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3 || z8) {
            resetFakeFingerGesture();
        }
        removeStaleIds(motionEvent);
        motionEvent.getEventTime();
        return new EmojiProcessor(arrayList, motionEvent, pointerClassification, (byte) 9);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x00b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:32:0x00be  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:65:0x0180  */
    /* JADX WARN: Code duplicated, block: B:69:0x0192  */
    /* JADX WARN: Code duplicated, block: B:70:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:94:0x0189 A[EDGE_INSN: B:94:0x0189->B:67:0x0189 BREAK  A[LOOP:0: B:43:0x00ea->B:66:0x0181], SYNTHETIC] */
    /* JADX INFO: renamed from: createPointerInputEventData-InuC1xA, reason: not valid java name */
    public final PointerInputEventData m587createPointerInputEventDataInuC1xA(AndroidComposeView androidComposeView, MotionEvent motionEvent, Offset offset, int i, boolean z) {
        long jValueAt;
        char c;
        long j;
        long jM686localToScreenMKHz9U;
        long j2;
        long jFloatToRawIntBits;
        long jM690screenToLocalMKHz9U;
        int toolType;
        int i2;
        int historySize;
        char c2;
        int i3;
        long jFloatToRawIntBits2;
        float fFloatValue;
        int i4;
        long jFloatToRawIntBits3;
        int i5;
        boolean z2;
        Float fValueOf;
        float historicalX;
        int i6;
        int i7;
        int i8 = i;
        int pointerId = motionEvent.getPointerId(i8);
        SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
        int iIndexOfKey = sparseLongArray.indexOfKey(pointerId);
        if (iIndexOfKey >= 0) {
            jValueAt = sparseLongArray.valueAt(iIndexOfKey);
        } else {
            long j3 = this.nextId;
            this.nextId = 1 + j3;
            sparseLongArray.put(pointerId, j3);
            jValueAt = j3;
        }
        float pressure = motionEvent.getPressure(i8);
        long jFloatToRawIntBits4 = (((long) Float.floatToRawIntBits(motionEvent.getY(i8))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getX(i8))) << 32);
        if (i8 != 0) {
            c = ' ';
            j = 4294967295L;
            if (Build.VERSION.SDK_INT >= 29) {
                if (offset != null) {
                    jFloatToRawIntBits = offset.packedValue;
                } else {
                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits(motionEvent.getRawX(i8))) << 32) | (((long) Float.floatToRawIntBits(motionEvent.getRawY(i8))) & 4294967295L);
                }
                jM686localToScreenMKHz9U = jFloatToRawIntBits;
                jM690screenToLocalMKHz9U = androidComposeView.m690screenToLocalMKHz9U(jM686localToScreenMKHz9U);
            } else {
                jM686localToScreenMKHz9U = androidComposeView.m686localToScreenMKHz9U(jFloatToRawIntBits4);
                j2 = jFloatToRawIntBits4;
            }
            toolType = motionEvent.getToolType(i8);
            if (toolType != 0) {
                i7 = 2;
                if (toolType == 1) {
                    i2 = ((!motionEvent.isFromSource(8194) || motionEvent.isFromSource(1048584)) && (!this.isInFakeFingerGesture || this.isReinterpretingFakeFingerGesture)) ? i7 : 1;
                } else if (toolType != 2) {
                    if (toolType != 3) {
                        i7 = 4;
                        if (toolType != 4) {
                            i2 = 0;
                        }
                    }
                } else {
                    i2 = 3;
                }
            } else {
                i2 = 0;
            }
            ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
            historySize = motionEvent.getHistorySize();
            c2 = c;
            i3 = 0;
            while (true) {
                jFloatToRawIntBits2 = 0;
                fFloatValue = 1.0f;
                if (i3 < historySize) {
                    break;
                }
                historicalX = motionEvent.getHistoricalX(i8, i3);
                float historicalY = motionEvent.getHistoricalY(i8, i3);
                if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) < 2139095040 || (Float.floatToRawIntBits(historicalY) & Integer.MAX_VALUE) >= 2139095040) {
                    i6 = i8;
                } else {
                    long jFloatToRawIntBits5 = (((long) Float.floatToRawIntBits(historicalX)) << c2) | (((long) Float.floatToRawIntBits(historicalY)) & j);
                    int i9 = Build.VERSION.SDK_INT;
                    boolean z3 = i9 >= 34 && motionEvent.getClassification() == 3;
                    long historicalEventTime = motionEvent.getHistoricalEventTime(i3);
                    i6 = i;
                    float historicalAxisValue = motionEvent.getHistoricalAxisValue(52, i6, i3);
                    fValueOf = historicalAxisValue > CropImageView.DEFAULT_ASPECT_RATIO ? Float.valueOf(historicalAxisValue) : null;
                    float fFloatValue2 = fValueOf != null ? fValueOf.floatValue() : 1.0f;
                    if (i9 >= 29 && z3) {
                        jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(motionEvent.getHistoricalAxisValue(50, i6, i3))) << c2) | (((long) Float.floatToRawIntBits(motionEvent.getHistoricalAxisValue(51, i6, i3))) & j);
                    }
                    arrayList.add(new HistoricalChange(historicalEventTime, jFloatToRawIntBits5, fFloatValue2, jFloatToRawIntBits2, jFloatToRawIntBits5));
                }
                i3++;
                i8 = i6;
            }
            i4 = i8;
            if (motionEvent.getActionMasked() == 8) {
                jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + CropImageView.DEFAULT_ASPECT_RATIO)) & j) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c2);
            } else {
                jFloatToRawIntBits3 = 0;
            }
            i5 = Build.VERSION.SDK_INT;
            if (i5 >= 29 && motionEvent.getClassification() == 5) {
                float axisValue = motionEvent.getAxisValue(52, i4);
                fValueOf = axisValue > CropImageView.DEFAULT_ASPECT_RATIO ? Float.valueOf(axisValue) : null;
                if (fValueOf != null) {
                    fFloatValue = fValueOf.floatValue();
                }
            }
            if (i5 >= 34 || !(motionEvent.getClassification() == 3 || this.isTrackpadPanOngoing)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (i5 >= 29 && z2) {
                jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(50, i4))) << c2) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(51, i4))) & j);
            }
            return new PointerInputEventData(jValueAt, motionEvent.getEventTime(), jM686localToScreenMKHz9U, j2, z, pressure, i2, this.activeHoverIds.get(motionEvent.getPointerId(i4), false), arrayList, jFloatToRawIntBits3, fFloatValue, jFloatToRawIntBits2, jFloatToRawIntBits4);
        }
        if (offset != null) {
            jM686localToScreenMKHz9U = offset.packedValue;
            c = ' ';
            j = 4294967295L;
        } else {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            long jFloatToRawIntBits6 = Float.floatToRawIntBits(rawX);
            int iFloatToRawIntBits = Float.floatToRawIntBits(rawY);
            c = ' ';
            j = 4294967295L;
            jM686localToScreenMKHz9U = (jFloatToRawIntBits6 << 32) | (((long) iFloatToRawIntBits) & 4294967295L);
        }
        jM690screenToLocalMKHz9U = androidComposeView.m690screenToLocalMKHz9U(jM686localToScreenMKHz9U);
        j2 = jM690screenToLocalMKHz9U;
        toolType = motionEvent.getToolType(i8);
        if (toolType != 0) {
            i7 = 2;
            if (toolType == 1) {
                if (toolType != 2) {
                    if (toolType != 3) {
                        i7 = 4;
                        if (toolType != 4) {
                            i2 = 0;
                        }
                    }
                } else {
                    i2 = 3;
                }
            } else if (motionEvent.isFromSource(8194)) {
            }
        } else {
            i2 = 0;
        }
        ArrayList arrayList2 = new ArrayList(motionEvent.getHistorySize());
        historySize = motionEvent.getHistorySize();
        c2 = c;
        i3 = 0;
        while (true) {
            jFloatToRawIntBits2 = 0;
            fFloatValue = 1.0f;
            if (i3 < historySize) {
                break;
                break;
            }
            historicalX = motionEvent.getHistoricalX(i8, i3);
            float historicalY2 = motionEvent.getHistoricalY(i8, i3);
            if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) < 2139095040) {
                i6 = i8;
            } else {
                i6 = i8;
            }
            i3++;
            i8 = i6;
        }
        i4 = i8;
        if (motionEvent.getActionMasked() == 8) {
            jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + CropImageView.DEFAULT_ASPECT_RATIO)) & j) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c2);
        } else {
            jFloatToRawIntBits3 = 0;
        }
        i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            float axisValue2 = motionEvent.getAxisValue(52, i4);
            if (axisValue2 > CropImageView.DEFAULT_ASPECT_RATIO) {
            }
            if (fValueOf != null) {
                fFloatValue = fValueOf.floatValue();
            }
        }
        if (i5 >= 34) {
            z2 = false;
        } else {
            z2 = false;
        }
        if (i5 >= 29) {
            jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(50, i4))) << c2) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(51, i4))) & j);
        }
        return new PointerInputEventData(jValueAt, motionEvent.getEventTime(), jM686localToScreenMKHz9U, j2, z, pressure, i2, this.activeHoverIds.get(motionEvent.getPointerId(i4), false), arrayList2, jFloatToRawIntBits3, fFloatValue, jFloatToRawIntBits2, jFloatToRawIntBits4);
    }

    public final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        SparseBooleanArray sparseBooleanArray = this.activeHoverIds;
        SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!sparseBooleanArray.get(pointerId, false)) {
                sparseLongArray.delete(pointerId);
                sparseBooleanArray.delete(pointerId);
            }
        }
        if (sparseLongArray.size() > motionEvent.getPointerCount()) {
            for (int size = sparseLongArray.size() - 1; -1 < size; size--) {
                int iKeyAt = sparseLongArray.keyAt(size);
                int pointerCount = motionEvent.getPointerCount();
                int i = 0;
                while (true) {
                    if (i >= pointerCount) {
                        sparseLongArray.removeAt(size);
                        sparseBooleanArray.delete(iKeyAt);
                        break;
                    } else if (motionEvent.getPointerId(i) == iKeyAt) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public final void resetFakeFingerGesture() {
        this.isInFakeFingerGesture = false;
        this.isReinterpretingFakeFingerGesture = false;
        this.inferredCursorRawOffset = null;
        this.isTrackpadPanOngoing = false;
        this.isAnyPointerDown = false;
    }
}
