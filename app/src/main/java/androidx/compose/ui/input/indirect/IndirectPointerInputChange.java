package androidx.compose.ui.input.indirect;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerId;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IndirectPointerInputChange {
    public LazyHistoricalChangeList _historical;
    public final long id;
    public boolean isConsumed;
    public final long position;
    public final boolean pressed;
    public final float pressure;
    public final long previousPosition;
    public final boolean previousPressed;
    public final long previousUptimeMillis;
    public final long uptimeMillis;

    public IndirectPointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2) {
        this.id = j;
        this.uptimeMillis = j2;
        this.position = j3;
        this.pressed = z;
        this.pressure = f;
        this.previousUptimeMillis = j4;
        this.previousPosition = j5;
        this.previousPressed = z2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("IndirectPointerInputChange(id=");
        sb.append(new PointerId(this.id));
        sb.append(", uptimeMillis=");
        sb.append(this.uptimeMillis);
        sb.append(", position=");
        sb.append(new Offset(this.position));
        sb.append(", pressed=");
        sb.append(this.pressed);
        sb.append(", pressure=");
        sb.append(this.pressure);
        sb.append(", previousUptimeMillis=");
        sb.append(this.previousUptimeMillis);
        sb.append(", previousPosition=");
        sb.append(new Offset(this.previousPosition));
        sb.append(", previousPressed=");
        sb.append(this.previousPressed);
        sb.append(", historical=");
        Object obj = this._historical;
        if (obj == null) {
            obj = EmptyList.INSTANCE;
        }
        sb.append(obj);
        sb.append(", isConsumed=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.isConsumed, ")");
    }
}
