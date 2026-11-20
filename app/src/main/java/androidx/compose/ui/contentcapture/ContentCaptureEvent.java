package androidx.compose.ui.contentcapture;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.draw.DrawResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentCaptureEvent {
    public final int id;
    public final DrawResult structureCompat;
    public final long timestamp;
    public final ContentCaptureEventType type;

    public ContentCaptureEvent(int i, long j, ContentCaptureEventType contentCaptureEventType, DrawResult drawResult) {
        this.id = i;
        this.timestamp = j;
        this.type = contentCaptureEventType;
        this.structureCompat = drawResult;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentCaptureEvent)) {
            return false;
        }
        ContentCaptureEvent contentCaptureEvent = (ContentCaptureEvent) obj;
        return this.id == contentCaptureEvent.id && this.timestamp == contentCaptureEvent.timestamp && this.type == contentCaptureEvent.type && Intrinsics.areEqual(this.structureCompat, contentCaptureEvent.structureCompat);
    }

    public final int hashCode() {
        int iHashCode = (this.type.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Integer.hashCode(this.id) * 31, 31, this.timestamp)) * 31;
        DrawResult drawResult = this.structureCompat;
        return iHashCode + (drawResult == null ? 0 : drawResult.hashCode());
    }

    public final String toString() {
        return "ContentCaptureEvent(id=" + this.id + ", timestamp=" + this.timestamp + ", type=" + this.type + ", structureCompat=" + this.structureCompat + ")";
    }
}
