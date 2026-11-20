package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInputChange {
    public final ArrayList _historical;
    public PointerInputChange consumedDelegate;
    public boolean downChange;
    public final long id;
    public final long originalEventPosition;
    public final long panOffset;
    public final long position;
    public boolean positionChange;
    public final boolean pressed;
    public final float pressure;
    public final long previousPosition;
    public final boolean previousPressed;
    public final long previousUptimeMillis;
    public final float scaleFactor;
    public final long scrollDelta;
    public final int type;
    public final long uptimeMillis;

    public PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, float f2, long j7) {
        this.id = j;
        this.uptimeMillis = j2;
        this.position = j3;
        this.pressed = z;
        this.pressure = f;
        this.previousUptimeMillis = j4;
        this.previousPosition = j5;
        this.previousPressed = z2;
        this.type = i;
        this.scrollDelta = j6;
        this.scaleFactor = f2;
        this.panOffset = j7;
        this.originalEventPosition = 0L;
        this.downChange = z3;
        this.positionChange = z3;
    }

    public final void consume() {
        PointerInputChange pointerInputChange = this.consumedDelegate;
        if (pointerInputChange == null) {
            this.downChange = true;
            this.positionChange = true;
        } else if (pointerInputChange != null) {
            pointerInputChange.consume();
        }
    }

    public final List getHistorical() {
        ArrayList arrayList = this._historical;
        return arrayList == null ? EmptyList.INSTANCE : arrayList;
    }

    public final boolean isConsumed() {
        PointerInputChange pointerInputChange = this.consumedDelegate;
        if (pointerInputChange != null) {
            return pointerInputChange.isConsumed();
        }
        return this.downChange || this.positionChange;
    }

    public final String toString() {
        return "PointerInputChange(id=" + PointerId.m591toStringimpl(this.id) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + Offset.m441toStringimpl(this.position) + ", pressed=" + this.pressed + ", pressure=" + this.pressure + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + Offset.m441toStringimpl(this.previousPosition) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + PointerType.m592toStringimpl(this.type) + ", historical=" + getHistorical() + ", scrollDelta=" + Offset.m441toStringimpl(this.scrollDelta) + ", scaleFactor=" + this.scaleFactor + ", panOffset=" + Offset.m441toStringimpl(this.panOffset) + ")";
    }

    public PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, ArrayList arrayList, long j6, float f2, long j7, long j8) {
        this(j, j2, j3, z, f, j4, j5, z2, false, i, j6, f2, j7);
        this._historical = arrayList;
        this.originalEventPosition = j8;
    }
}
