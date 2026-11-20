package androidx.compose.ui.input.pointer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEventData {
    public final boolean activeHover;
    public final boolean down;
    public final ArrayList historical;
    public final long id;
    public final long originalEventPosition;
    public final long panGestureOffset;
    public final long position;
    public final long positionOnScreen;
    public final float pressure;
    public final float scaleGestureFactor;
    public final long scrollDelta;
    public final int type;
    public final long uptime;

    public PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, ArrayList arrayList, long j5, float f2, long j6, long j7) {
        this.id = j;
        this.uptime = j2;
        this.positionOnScreen = j3;
        this.position = j4;
        this.down = z;
        this.pressure = f;
        this.type = i;
        this.activeHover = z2;
        this.historical = arrayList;
        this.scrollDelta = j5;
        this.scaleGestureFactor = f2;
        this.panGestureOffset = j6;
        this.originalEventPosition = j7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        return PointerId.m590equalsimpl0(this.id, pointerInputEventData.id) && this.uptime == pointerInputEventData.uptime && Offset.m434equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m434equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && Float.compare(this.pressure, pointerInputEventData.pressure) == 0 && this.type == pointerInputEventData.type && this.activeHover == pointerInputEventData.activeHover && this.historical.equals(pointerInputEventData.historical) && Offset.m434equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta) && Float.compare(this.scaleGestureFactor, pointerInputEventData.scaleGestureFactor) == 0 && Offset.m434equalsimpl0(this.panGestureOffset, pointerInputEventData.panGestureOffset) && Offset.m434equalsimpl0(this.originalEventPosition, pointerInputEventData.originalEventPosition);
    }

    public final int hashCode() {
        return Long.hashCode(this.originalEventPosition) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.scaleGestureFactor, IntIntPair$$ExternalSyntheticOutline0.m((this.historical.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.type, IntIntPair$$ExternalSyntheticOutline0.m(this.pressure, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.id) * 31, 31, this.uptime), 31, this.positionOnScreen), 31, this.position), this.down, 31), 31), 31), this.activeHover, 31)) * 31, 31, this.scrollDelta), 31), 31, this.panGestureOffset);
    }

    public final String toString() {
        String strM591toStringimpl = PointerId.m591toStringimpl(this.id);
        String strM441toStringimpl = Offset.m441toStringimpl(this.positionOnScreen);
        String strM441toStringimpl2 = Offset.m441toStringimpl(this.position);
        String strM592toStringimpl = PointerType.m592toStringimpl(this.type);
        String strM441toStringimpl3 = Offset.m441toStringimpl(this.scrollDelta);
        String strM441toStringimpl4 = Offset.m441toStringimpl(this.panGestureOffset);
        String strM441toStringimpl5 = Offset.m441toStringimpl(this.originalEventPosition);
        StringBuilder sb = new StringBuilder("PointerInputEventData(id=");
        sb.append(strM591toStringimpl);
        sb.append(", uptime=");
        sb.append(this.uptime);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", positionOnScreen=", strM441toStringimpl, ", position=", strM441toStringimpl2);
        sb.append(", down=");
        sb.append(this.down);
        sb.append(", pressure=");
        sb.append(this.pressure);
        sb.append(", type=");
        sb.append(strM592toStringimpl);
        sb.append(", activeHover=");
        sb.append(this.activeHover);
        sb.append(", historical=");
        sb.append(this.historical);
        sb.append(", scrollDelta=");
        sb.append(strM441toStringimpl3);
        sb.append(", scaleGestureFactor=");
        sb.append(this.scaleGestureFactor);
        sb.append(", panGestureOffset=");
        sb.append(strM441toStringimpl4);
        sb.append(", originalEventPosition=");
        sb.append(strM441toStringimpl5);
        sb.append(")");
        return sb.toString();
    }
}
