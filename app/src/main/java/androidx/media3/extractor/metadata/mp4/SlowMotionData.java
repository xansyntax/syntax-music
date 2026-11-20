package androidx.media3.extractor.metadata.mp4;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SlowMotionData implements Metadata.Entry {
    public final ArrayList segments;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Segment {
        public final long endTimeMs;
        public final int speedDivisor;
        public final long startTimeMs;

        public Segment(int i, long j, long j2) {
            UtilsKt.checkArgument(j < j2);
            this.startTimeMs = j;
            this.endTimeMs = j2;
            this.speedDivisor = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Segment.class == obj.getClass()) {
                Segment segment = (Segment) obj;
                if (this.startTimeMs == segment.startTimeMs && this.endTimeMs == segment.endTimeMs && this.speedDivisor == segment.speedDivisor) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Long.valueOf(this.startTimeMs), Long.valueOf(this.endTimeMs), Integer.valueOf(this.speedDivisor));
        }

        public final String toString() {
            String str = Util.DEVICE_DEBUG_INFO;
            Locale locale = Locale.US;
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(this.startTimeMs, "Segment: startTimeMs=", ", endTimeMs=");
            sbM.append(this.endTimeMs);
            sbM.append(", speedDivisor=");
            sbM.append(this.speedDivisor);
            return sbM.toString();
        }
    }

    public SlowMotionData(ArrayList arrayList) {
        this.segments = arrayList;
        boolean z = false;
        if (!arrayList.isEmpty()) {
            long j = ((Segment) arrayList.get(0)).endTimeMs;
            for (int i = 1; i < arrayList.size(); i++) {
                if (((Segment) arrayList.get(i)).startTimeMs < j) {
                    z = true;
                    break;
                }
                j = ((Segment) arrayList.get(i)).endTimeMs;
            }
        }
        UtilsKt.checkArgument(!z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.segments.equals(((SlowMotionData) obj).segments);
    }

    public final int hashCode() {
        return this.segments.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.segments;
    }
}
