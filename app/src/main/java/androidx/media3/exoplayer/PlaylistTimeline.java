package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistTimeline extends Timeline {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final int childCount;
    public final HashMap childIndexByUid;
    public final int[] firstPeriodInChildIndices;
    public final int[] firstWindowInChildIndices;
    public final int periodCount;
    public final ShuffleOrder$DefaultShuffleOrder shuffleOrder;
    public final Timeline[] timelines;
    public final Object[] uids;
    public final int windowCount;

    public PlaylistTimeline(Timeline[] timelineArr, Object[] objArr, ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder) {
        this.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
        this.childCount = shuffleOrder$DefaultShuffleOrder.shuffled.length;
        int length = timelineArr.length;
        this.timelines = timelineArr;
        this.firstPeriodInChildIndices = new int[length];
        this.firstWindowInChildIndices = new int[length];
        this.uids = objArr;
        this.childIndexByUid = new HashMap();
        int length2 = timelineArr.length;
        int i = 0;
        int windowCount = 0;
        int periodCount = 0;
        int i2 = 0;
        while (i < length2) {
            Timeline timeline = timelineArr[i];
            this.timelines[i2] = timeline;
            this.firstWindowInChildIndices[i2] = windowCount;
            this.firstPeriodInChildIndices[i2] = periodCount;
            windowCount += timeline.getWindowCount();
            periodCount += this.timelines[i2].getPeriodCount();
            this.childIndexByUid.put(objArr[i2], Integer.valueOf(i2));
            i++;
            i2++;
        }
        this.windowCount = windowCount;
        this.periodCount = periodCount;
    }

    @Override // androidx.media3.common.Timeline
    public final int getFirstWindowIndex(boolean z) {
        if (this.childCount != 0) {
            int nextChildIndex = 0;
            if (z) {
                int[] iArr = this.shuffleOrder.shuffled;
                nextChildIndex = iArr.length > 0 ? iArr[0] : -1;
            }
            do {
                Timeline[] timelineArr = this.timelines;
                if (!timelineArr[nextChildIndex].isEmpty()) {
                    return timelineArr[nextChildIndex].getFirstWindowIndex(z) + this.firstWindowInChildIndices[nextChildIndex];
                }
                nextChildIndex = getNextChildIndex(nextChildIndex, z);
            } while (nextChildIndex != -1);
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            Integer num = (Integer) this.childIndexByUid.get(obj2);
            int iIntValue = num == null ? -1 : num.intValue();
            if (iIntValue != -1 && (indexOfPeriod = this.timelines[iIntValue].getIndexOfPeriod(obj3)) != -1) {
                return this.firstPeriodInChildIndices[iIntValue] + indexOfPeriod;
            }
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final int getLastWindowIndex(boolean z) {
        int previousChildIndex;
        int i = this.childCount;
        if (i != 0) {
            if (z) {
                int[] iArr = this.shuffleOrder.shuffled;
                previousChildIndex = iArr.length > 0 ? iArr[iArr.length - 1] : -1;
            } else {
                previousChildIndex = i - 1;
            }
            do {
                Timeline[] timelineArr = this.timelines;
                if (!timelineArr[previousChildIndex].isEmpty()) {
                    return timelineArr[previousChildIndex].getLastWindowIndex(z) + this.firstWindowInChildIndices[previousChildIndex];
                }
                previousChildIndex = getPreviousChildIndex(previousChildIndex, z);
            } while (previousChildIndex != -1);
        }
        return -1;
    }

    public final int getNextChildIndex(int i, boolean z) {
        if (!z) {
            if (i < this.childCount - 1) {
                return i + 1;
            }
            return -1;
        }
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = this.shuffleOrder;
        int i2 = shuffleOrder$DefaultShuffleOrder.indexInShuffled[i] + 1;
        int[] iArr = shuffleOrder$DefaultShuffleOrder.shuffled;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final int getNextWindowIndex(int i, boolean z, int i2) {
        int[] iArr = this.firstWindowInChildIndices;
        int iBinarySearchFloor = Util.binarySearchFloor(iArr, i + 1, false, false);
        int i3 = iArr[iBinarySearchFloor];
        Timeline[] timelineArr = this.timelines;
        int nextWindowIndex = timelineArr[iBinarySearchFloor].getNextWindowIndex(i - i3, z, i2 != 2 ? i2 : 0);
        if (nextWindowIndex != -1) {
            return i3 + nextWindowIndex;
        }
        int nextChildIndex = getNextChildIndex(iBinarySearchFloor, z);
        while (nextChildIndex != -1 && timelineArr[nextChildIndex].isEmpty()) {
            nextChildIndex = getNextChildIndex(nextChildIndex, z);
        }
        if (nextChildIndex != -1) {
            return timelineArr[nextChildIndex].getFirstWindowIndex(z) + iArr[nextChildIndex];
        }
        if (i2 == 2) {
            return getFirstWindowIndex(z);
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        int[] iArr = this.firstPeriodInChildIndices;
        int iBinarySearchFloor = Util.binarySearchFloor(iArr, i + 1, false, false);
        int i2 = this.firstWindowInChildIndices[iBinarySearchFloor];
        this.timelines[iBinarySearchFloor].getPeriod(i - iArr[iBinarySearchFloor], period, z);
        period.windowIndex += i2;
        if (z) {
            Object obj = this.uids[iBinarySearchFloor];
            Object obj2 = period.uid;
            obj2.getClass();
            period.uid = Pair.create(obj, obj2);
        }
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        Integer num = (Integer) this.childIndexByUid.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        int i = this.firstWindowInChildIndices[iIntValue];
        this.timelines[iIntValue].getPeriodByUid(obj3, period);
        period.windowIndex += i;
        period.uid = obj;
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getPreviousChildIndex(int i, boolean z) {
        if (!z) {
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = this.shuffleOrder;
        int i2 = shuffleOrder$DefaultShuffleOrder.indexInShuffled[i] - 1;
        if (i2 >= 0) {
            return shuffleOrder$DefaultShuffleOrder.shuffled[i2];
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final int getPreviousWindowIndex(int i, boolean z, int i2) {
        int[] iArr = this.firstWindowInChildIndices;
        int iBinarySearchFloor = Util.binarySearchFloor(iArr, i + 1, false, false);
        int i3 = iArr[iBinarySearchFloor];
        Timeline[] timelineArr = this.timelines;
        int previousWindowIndex = timelineArr[iBinarySearchFloor].getPreviousWindowIndex(i - i3, z, i2 != 2 ? i2 : 0);
        if (previousWindowIndex != -1) {
            return i3 + previousWindowIndex;
        }
        int previousChildIndex = getPreviousChildIndex(iBinarySearchFloor, z);
        while (previousChildIndex != -1 && timelineArr[previousChildIndex].isEmpty()) {
            previousChildIndex = getPreviousChildIndex(previousChildIndex, z);
        }
        if (previousChildIndex != -1) {
            return timelineArr[previousChildIndex].getLastWindowIndex(z) + iArr[previousChildIndex];
        }
        if (i2 == 2) {
            return getLastWindowIndex(z);
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final Object getUidOfPeriod(int i) {
        int[] iArr = this.firstPeriodInChildIndices;
        int iBinarySearchFloor = Util.binarySearchFloor(iArr, i + 1, false, false);
        return Pair.create(this.uids[iBinarySearchFloor], this.timelines[iBinarySearchFloor].getUidOfPeriod(i - iArr[iBinarySearchFloor]));
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        int[] iArr = this.firstWindowInChildIndices;
        int iBinarySearchFloor = Util.binarySearchFloor(iArr, i + 1, false, false);
        int i2 = iArr[iBinarySearchFloor];
        int i3 = this.firstPeriodInChildIndices[iBinarySearchFloor];
        this.timelines[iBinarySearchFloor].getWindow(i - i2, window, j);
        Object objCreate = this.uids[iBinarySearchFloor];
        Object obj = Timeline.Window.SINGLE_WINDOW_UID;
        Object obj2 = window.uid;
        if (obj != obj2) {
            objCreate = Pair.create(objCreate, obj2);
        }
        window.uid = objCreate;
        window.firstPeriodIndex += i3;
        window.lastPeriodIndex += i3;
        return window;
    }

    @Override // androidx.media3.common.Timeline
    public final int getWindowCount() {
        return this.windowCount;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PlaylistTimeline(ArrayList arrayList, ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder) {
        Timeline[] timelineArr = new Timeline[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            timelineArr[i2] = ((MediaSourceInfoHolder) obj).getTimeline();
            i2++;
        }
        Object[] objArr = new Object[arrayList.size()];
        int size2 = arrayList.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj2 = arrayList.get(i4);
            i4++;
            objArr[i] = ((MediaSourceInfoHolder) obj2).getUid();
            i++;
        }
        this(timelineArr, objArr, shuffleOrder$DefaultShuffleOrder);
    }
}
