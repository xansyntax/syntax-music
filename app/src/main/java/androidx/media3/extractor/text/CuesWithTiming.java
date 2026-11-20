package androidx.media3.extractor.text;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CuesWithTiming {
    public final ImmutableList cues;
    public final long durationUs;
    public final long endTimeUs;
    public final long startTimeUs;

    public CuesWithTiming(long j, long j2, List list) {
        this.cues = ImmutableList.copyOf((Collection) list);
        this.startTimeUs = j;
        this.durationUs = j2;
        long j3 = -9223372036854775807L;
        if (j != -9223372036854775807L && j2 != -9223372036854775807L) {
            j3 = j + j2;
        }
        this.endTimeUs = j3;
    }
}
