package androidx.media3.exoplayer.text;

import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.extractor.text.CuesWithTiming;
import coil3.util.UtilsKt;
import com.google.common.collect.ByFunctionOrdering;
import com.google.common.collect.CompoundOrdering;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MergingCuesResolver implements CuesResolver {
    public static final CompoundOrdering CUES_DISPLAY_PRIORITY_COMPARATOR = new CompoundOrdering(new ByFunctionOrdering(new Format$$ExternalSyntheticLambda1((byte) 13), NaturalOrdering.INSTANCE), new ByFunctionOrdering(new Format$$ExternalSyntheticLambda1((byte) 14), NaturalOrdering.INSTANCE$1));
    public final ArrayList cuesWithTimingList = new ArrayList();

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final boolean addCues(CuesWithTiming cuesWithTiming, long j) {
        long j2 = cuesWithTiming.startTimeUs;
        UtilsKt.checkArgument(j2 != -9223372036854775807L);
        UtilsKt.checkArgument(cuesWithTiming.durationUs != -9223372036854775807L);
        boolean z = j2 <= j && j < cuesWithTiming.endTimeUs;
        ArrayList arrayList = this.cuesWithTimingList;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (j2 >= ((CuesWithTiming) arrayList.get(size)).startTimeUs) {
                arrayList.add(size + 1, cuesWithTiming);
                return z;
            }
        }
        arrayList.add(0, cuesWithTiming);
        return z;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final void clear() {
        this.cuesWithTimingList.clear();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final void discardCuesBeforeTimeUs(long j) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.cuesWithTimingList;
            if (i >= arrayList.size()) {
                return;
            }
            long j2 = ((CuesWithTiming) arrayList.get(i)).startTimeUs;
            if (j > j2 && j > ((CuesWithTiming) arrayList.get(i)).endTimeUs) {
                arrayList.remove(i);
                i--;
            } else if (j < j2) {
                return;
            }
            i++;
        }
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final ImmutableList getCuesAtTimeUs(long j) {
        ArrayList arrayList = this.cuesWithTimingList;
        if (!arrayList.isEmpty()) {
            if (j >= ((CuesWithTiming) arrayList.get(0)).startTimeUs) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    CuesWithTiming cuesWithTiming = (CuesWithTiming) arrayList.get(i);
                    if (j >= cuesWithTiming.startTimeUs && j < cuesWithTiming.endTimeUs) {
                        arrayList2.add(cuesWithTiming);
                    }
                    if (j < cuesWithTiming.startTimeUs) {
                        break;
                    }
                }
                RegularImmutableList regularImmutableListSortedCopyOf = ImmutableList.sortedCopyOf(CUES_DISPLAY_PRIORITY_COMPARATOR, arrayList2);
                ImmutableList.Builder builder = ImmutableList.builder();
                for (int i2 = 0; i2 < regularImmutableListSortedCopyOf.size; i2++) {
                    builder.addAll(((CuesWithTiming) regularImmutableListSortedCopyOf.get(i2)).cues);
                }
                return builder.build();
            }
        }
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        return RegularImmutableList.EMPTY;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final long getNextCueChangeTimeUs(long j) {
        int i = 0;
        long jMin = -9223372036854775807L;
        while (true) {
            ArrayList arrayList = this.cuesWithTimingList;
            if (i >= arrayList.size()) {
                break;
            }
            long j2 = ((CuesWithTiming) arrayList.get(i)).startTimeUs;
            long j3 = ((CuesWithTiming) arrayList.get(i)).endTimeUs;
            if (j < j2) {
                if (jMin != -9223372036854775807L) {
                    jMin = Math.min(jMin, j2);
                    break;
                }
                jMin = j2;
                break;
            }
            if (j < j3) {
                jMin = jMin == -9223372036854775807L ? j3 : Math.min(jMin, j3);
            }
            i++;
        }
        if (jMin != -9223372036854775807L) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final long getPreviousCueChangeTimeUs(long j) {
        ArrayList arrayList = this.cuesWithTimingList;
        if (arrayList.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j < ((CuesWithTiming) arrayList.get(0)).startTimeUs) {
            return -9223372036854775807L;
        }
        long jMax = ((CuesWithTiming) arrayList.get(0)).startTimeUs;
        for (int i = 0; i < arrayList.size(); i++) {
            long j2 = ((CuesWithTiming) arrayList.get(i)).startTimeUs;
            long j3 = ((CuesWithTiming) arrayList.get(i)).endTimeUs;
            if (j3 > j) {
                if (j2 > j) {
                    break;
                }
                jMax = Math.max(jMax, j2);
            } else {
                jMax = Math.max(jMax, j3);
            }
        }
        return jMax;
    }
}
