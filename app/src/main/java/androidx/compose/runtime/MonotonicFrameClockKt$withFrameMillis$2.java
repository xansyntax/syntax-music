package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ReadonlySnapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MonotonicFrameClockKt$withFrameMillis$2 implements Function1 {
    public final /* synthetic */ Function1 $onFrame;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ MonotonicFrameClockKt$withFrameMillis$2(Function1 function1, byte b) {
        this.$r8$classId = b;
        this.$onFrame = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        long j;
        switch (this.$r8$classId) {
            case 0:
                return this.$onFrame.invoke(Long.valueOf(((Number) obj).longValue() / 1000000));
            default:
                SnapshotIdSet snapshotIdSet = (SnapshotIdSet) obj;
                synchronized (SnapshotKt.lock) {
                    j = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = 1 + j;
                }
                return new ReadonlySnapshot(j, snapshotIdSet, this.$onFrame);
        }
    }
}
