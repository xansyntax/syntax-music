package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridSpanLayoutProvider {
    public final ArrayList buckets;
    public final ArrayList cachedBucket;
    public int cachedBucketIndex;
    public final LazyGridIntervalContent gridContent;
    public int lastLineIndex;
    public int lastLineStartItemIndex;
    public int lastLineStartKnownSpan;
    public List previousDefaultSpans;
    public int slotsPerLine;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Bucket {
        public final int firstItemIndex;
        public final int firstItemKnownSpan;

        public Bucket(int i, int i2) {
            this.firstItemIndex = i;
            this.firstItemKnownSpan = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LazyGridItemSpanScopeImpl {
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        public static int maxLineSpan;
    }

    public LazyGridSpanLayoutProvider(LazyGridIntervalContent lazyGridIntervalContent) {
        this.gridContent = lazyGridIntervalContent;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Bucket(0, 0));
        this.buckets = arrayList;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = EmptyList.INSTANCE;
    }

    public final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.slotsPerLine))) + 1;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    public final PriorityQueue getLineConfiguration(int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        List list;
        if (!this.gridContent.hasCustomSpans) {
            int i5 = this.slotsPerLine;
            int i6 = i * i5;
            int totalSize = getTotalSize() - i6;
            if (i5 > totalSize) {
                i5 = totalSize;
            }
            if (i5 < 0) {
                i5 = 0;
            }
            if (i5 == this.previousDefaultSpans.size()) {
                list = this.previousDefaultSpans;
            } else {
                ArrayList arrayList = new ArrayList(i5);
                for (int i7 = 0; i7 < i5; i7++) {
                    arrayList.add(new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(1)));
                }
                this.previousDefaultSpans = arrayList;
                list = arrayList;
            }
            return new PriorityQueue(i6, list);
        }
        int bucketSize = i / getBucketSize();
        ArrayList arrayList2 = this.buckets;
        int iMin = Math.min(bucketSize, arrayList2.size() - 1);
        int bucketSize2 = getBucketSize() * iMin;
        int iIntValue = ((Bucket) arrayList2.get(iMin)).firstItemIndex;
        int iSpanOf = ((Bucket) arrayList2.get(iMin)).firstItemKnownSpan;
        int i8 = this.lastLineIndex;
        ArrayList arrayList3 = this.cachedBucket;
        if (bucketSize2 <= i8 && i8 <= i) {
            iIntValue = this.lastLineStartItemIndex;
            iSpanOf = this.lastLineStartKnownSpan;
            bucketSize2 = i8;
        } else if (iMin == this.cachedBucketIndex && (i2 = i - bucketSize2) < arrayList3.size()) {
            iIntValue = ((Number) arrayList3.get(i2)).intValue();
            bucketSize2 = i;
            iSpanOf = 0;
        }
        if (bucketSize2 % getBucketSize() == 0) {
            int i9 = i - bucketSize2;
            z = 2 <= i9 && i9 < getBucketSize();
        }
        if (z) {
            this.cachedBucketIndex = iMin;
            arrayList3.clear();
        }
        if (bucketSize2 > i) {
            InlineClassHelperKt.throwIllegalStateException("currentLine (" + bucketSize2 + ") > lineIndex (" + i + ")");
        }
        while (bucketSize2 < i && iIntValue < getTotalSize()) {
            if (z) {
                arrayList3.add(Integer.valueOf(iIntValue));
            }
            int i10 = 0;
            while (i10 < this.slotsPerLine && iIntValue < getTotalSize()) {
                if (iSpanOf == 0) {
                    i4 = iSpanOf;
                    iSpanOf = spanOf(iIntValue);
                } else {
                    i4 = 0;
                }
                i10 += iSpanOf;
                if (i10 > this.slotsPerLine) {
                    break;
                }
                iIntValue++;
                iSpanOf = i4;
            }
            bucketSize2++;
            if (bucketSize2 % getBucketSize() == 0 && iIntValue < getTotalSize()) {
                if (arrayList2.size() != bucketSize2 / getBucketSize()) {
                    InlineClassHelperKt.throwIllegalStateException("invalid starting point");
                }
                arrayList2.add(new Bucket(iIntValue, iSpanOf));
            }
        }
        this.lastLineIndex = i;
        this.lastLineStartItemIndex = iIntValue;
        this.lastLineStartKnownSpan = iSpanOf;
        ArrayList arrayList4 = new ArrayList();
        int i11 = 0;
        int i12 = iIntValue;
        while (i11 < this.slotsPerLine && i12 < getTotalSize()) {
            if (iSpanOf == 0) {
                int i13 = iSpanOf;
                iSpanOf = spanOf(i12);
                i3 = i13;
            } else {
                i3 = 0;
            }
            i11 += iSpanOf;
            if (i11 > this.slotsPerLine) {
                break;
            }
            i12++;
            arrayList4.add(new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(iSpanOf)));
            iSpanOf = i3;
        }
        return new PriorityQueue(iIntValue, arrayList4);
    }

    public final int getLineIndexOfItem(int i) {
        int i2;
        if (getTotalSize() <= 0) {
            return 0;
        }
        if (i >= getTotalSize()) {
            InlineClassHelperKt.throwIllegalArgumentException("ItemIndex > total count");
        }
        if (!this.gridContent.hasCustomSpans) {
            return i / this.slotsPerLine;
        }
        ArrayList arrayList = this.buckets;
        int size = arrayList.size();
        CollectionsKt__IterablesKt.rangeCheck$CollectionsKt__CollectionsKt(arrayList.size(), size);
        int i3 = size - 1;
        int i4 = 0;
        while (true) {
            if (i4 > i3) {
                i2 = -(i4 + 1);
                break;
            }
            i2 = (i4 + i3) >>> 1;
            int i5 = ((Bucket) arrayList.get(i2)).firstItemIndex - i;
            if (i5 >= 0) {
                if (i5 <= 0) {
                    break;
                }
                i3 = i2 - 1;
            } else {
                i4 = i2 + 1;
            }
        }
        if (i2 < 0) {
            i2 = (-i2) - 2;
        }
        int bucketSize = getBucketSize() * i2;
        int i6 = ((Bucket) arrayList.get(i2)).firstItemIndex;
        if (i6 > i) {
            InlineClassHelperKt.throwIllegalArgumentException("currentItemIndex > itemIndex");
        }
        int i7 = 0;
        while (i6 < i) {
            int i8 = i6 + 1;
            int iSpanOf = spanOf(i6);
            i7 += iSpanOf;
            int i9 = this.slotsPerLine;
            if (i7 >= i9) {
                if (i7 == i9) {
                    bucketSize++;
                    i7 = 0;
                } else {
                    bucketSize++;
                    i7 = iSpanOf;
                }
            }
            if (bucketSize % getBucketSize() == 0 && bucketSize / getBucketSize() >= arrayList.size()) {
                arrayList.add(new Bucket(i8 - (i7 > 0 ? 1 : 0), 0));
            }
            i6 = i8;
        }
        return spanOf(i) + i7 > this.slotsPerLine ? bucketSize + 1 : bucketSize;
    }

    public final int getTotalSize() {
        return this.gridContent.intervals.code;
    }

    public final int spanOf(int i) {
        LazyGridItemSpanScopeImpl.maxLineSpan = this.slotsPerLine;
        IntervalList$Interval intervalList$Interval = this.gridContent.intervals.get(i);
        int i2 = i - intervalList$Interval.startIndex;
        return (int) ((GridItemSpan) ((LazyGridInterval) intervalList$Interval.value).span.invoke(LazyGridItemSpanScopeImpl.INSTANCE, Integer.valueOf(i2))).packedValue;
    }
}
