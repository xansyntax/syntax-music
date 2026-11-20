package androidx.media3.extractor.text;

import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ByFunctionOrdering;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CuesWithTimingSubtitle implements Subtitle {
    public static final ByFunctionOrdering CUES_BY_START_TIME_ASCENDING = new ByFunctionOrdering(new Format$$ExternalSyntheticLambda1((byte) 18), NaturalOrdering.INSTANCE);
    public final ImmutableList eventCues;
    public final long[] eventTimesUs;

    /* JADX WARN: Code duplicated, block: B:37:0x00cf  */
    public CuesWithTimingSubtitle(RegularImmutableList regularImmutableList) {
        int i = regularImmutableList.size;
        long j = -9223372036854775807L;
        int i2 = 0;
        if (i == 1) {
            ImmutableList.Itr itrListIterator = regularImmutableList.listIterator(0);
            Object next = itrListIterator.next();
            if (itrListIterator.hasNext()) {
                StringBuilder sb = new StringBuilder("expected one element but was: <");
                sb.append(next);
                while (i2 < 4 && itrListIterator.hasNext()) {
                    sb.append(", ");
                    sb.append(itrListIterator.next());
                    i2++;
                }
                if (itrListIterator.hasNext()) {
                    sb.append(", ...");
                }
                sb.append('>');
                throw new IllegalArgumentException(sb.toString());
            }
            CuesWithTiming cuesWithTiming = (CuesWithTiming) next;
            long j2 = cuesWithTiming.startTimeUs;
            long j3 = cuesWithTiming.durationUs;
            long j4 = j2 == -9223372036854775807L ? 0L : j2;
            ImmutableList immutableList = cuesWithTiming.cues;
            if (j3 == -9223372036854775807L) {
                this.eventCues = ImmutableList.of((Object) immutableList);
                this.eventTimesUs = new long[]{j4};
                return;
            } else {
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                this.eventCues = ImmutableList.of((Object) immutableList, (Object) RegularImmutableList.EMPTY);
                this.eventTimesUs = new long[]{j4, j3 + j4};
                return;
            }
        }
        long[] jArr = new long[i * 2];
        this.eventTimesUs = jArr;
        Arrays.fill(jArr, Long.MAX_VALUE);
        ArrayList arrayList = new ArrayList();
        RegularImmutableList regularImmutableListSortedCopyOf = ImmutableList.sortedCopyOf(CUES_BY_START_TIME_ASCENDING, regularImmutableList);
        int i3 = 0;
        while (i2 < regularImmutableListSortedCopyOf.size) {
            CuesWithTiming cuesWithTiming2 = (CuesWithTiming) regularImmutableListSortedCopyOf.get(i2);
            long j5 = cuesWithTiming2.startTimeUs;
            long j6 = cuesWithTiming2.durationUs;
            ImmutableList immutableList2 = cuesWithTiming2.cues;
            j5 = j5 == j ? 0L : j5;
            long j7 = j5 + j6;
            if (i3 != 0) {
                int i4 = i3 - 1;
                long j8 = this.eventTimesUs[i4];
                if (j8 < j5) {
                    this.eventTimesUs[i3] = j5;
                    arrayList.add(immutableList2);
                    i3++;
                } else if (j8 == j5 && ((ImmutableList) arrayList.get(i4)).isEmpty()) {
                    arrayList.set(i4, immutableList2);
                } else {
                    Log.w("CuesWithTimingSubtitle", "Truncating unsupported overlapping cues.");
                    this.eventTimesUs[i4] = j5;
                    arrayList.set(i4, immutableList2);
                }
            } else {
                this.eventTimesUs[i3] = j5;
                arrayList.add(immutableList2);
                i3++;
            }
            if (j6 != j) {
                this.eventTimesUs[i3] = j7;
                arrayList.add(RegularImmutableList.EMPTY);
                i3++;
            }
            i2++;
            j = j;
        }
        this.eventCues = ImmutableList.copyOf((Collection) arrayList);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final List getCues(long j) {
        int iBinarySearchFloor = Util.binarySearchFloor(this.eventTimesUs, j, false);
        if (iBinarySearchFloor != -1) {
            return (ImmutableList) this.eventCues.get(iBinarySearchFloor);
        }
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        return RegularImmutableList.EMPTY;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final long getEventTime(int i) {
        UtilsKt.checkArgument(i < this.eventCues.size());
        return this.eventTimesUs[i];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int getEventTimeCount() {
        return this.eventCues.size();
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int getNextEventTimeIndex(long j) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j, false);
        if (iBinarySearchCeil < this.eventCues.size()) {
            return iBinarySearchCeil;
        }
        return -1;
    }
}
