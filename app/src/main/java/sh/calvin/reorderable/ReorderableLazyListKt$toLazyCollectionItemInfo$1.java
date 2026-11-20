package sh.calvin.reorderable;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.sqlite.SQLite;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyListKt$toLazyCollectionItemInfo$1 {
    public final /* synthetic */ Orientation $orientation;
    public final /* synthetic */ LazyListMeasuredItem $this_toLazyCollectionItemInfo;

    public ReorderableLazyListKt$toLazyCollectionItemInfo$1(LazyListMeasuredItem lazyListMeasuredItem, Orientation orientation) {
        this.$this_toLazyCollectionItemInfo = lazyListMeasuredItem;
        this.$orientation = orientation;
    }

    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public final long m1920getOffsetnOccac() {
        int i = this.$this_toLazyCollectionItemInfo.offset;
        int iOrdinal = this.$orientation.ordinal();
        if (iOrdinal == 0) {
            return SQLite.IntOffset(0, i);
        }
        if (iOrdinal == 1) {
            return SQLite.IntOffset(i, 0);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return 0L;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m1921getSizeYbymL2g() {
        int i = this.$this_toLazyCollectionItemInfo.size;
        int iOrdinal = this.$orientation.ordinal();
        if (iOrdinal == 0) {
            return ((long) i) & 4294967295L;
        }
        if (iOrdinal == 1) {
            return ((long) i) << 32;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return 0L;
    }
}
