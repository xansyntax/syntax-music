package androidx.media3.extractor;

import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IndexSeekMap implements SeekMap {
    public long durationUs;
    public final LongArray positions;
    public final LongArray timesUs;

    public IndexSeekMap(long j, long[] jArr, long[] jArr2) {
        LongArray longArray;
        LongArray longArray2;
        UtilsKt.checkArgument(jArr.length == jArr2.length);
        int length = jArr2.length;
        if (length <= 0 || jArr2[0] <= 0) {
            longArray = new LongArray(length);
            this.positions = longArray;
            longArray2 = new LongArray(length);
            this.timesUs = longArray2;
        } else {
            int i = length + 1;
            longArray = new LongArray(i);
            this.positions = longArray;
            longArray2 = new LongArray(i);
            this.timesUs = longArray2;
            longArray.add(0L);
            longArray2.add(0L);
        }
        longArray.addAll(jArr);
        longArray2.addAll(jArr2);
        this.durationUs = j;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        LongArray longArray = this.timesUs;
        if (longArray.size == 0) {
            SeekPoint seekPoint = SeekPoint.START;
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        int iBinarySearchFloor = Util.binarySearchFloor(longArray, j);
        long j2 = longArray.get(iBinarySearchFloor);
        LongArray longArray2 = this.positions;
        SeekPoint seekPoint2 = new SeekPoint(j2, longArray2.get(iBinarySearchFloor));
        if (j2 == j || iBinarySearchFloor == longArray.size - 1) {
            return new SeekMap.SeekPoints(seekPoint2, seekPoint2);
        }
        int i = iBinarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(longArray.get(i), longArray2.get(i)));
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean isSeekable() {
        return this.timesUs.size > 0;
    }
}
