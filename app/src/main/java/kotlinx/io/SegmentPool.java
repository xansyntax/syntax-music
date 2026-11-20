package kotlinx.io;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SegmentPool {
    public static final int HASH_BUCKET_COUNT;
    public static final int HASH_BUCKET_COUNT_L2;
    public static final Segment LOCK = new Segment(new byte[0], 0, 0, null);
    public static final int SECOND_LEVEL_POOL_BUCKET_SIZE;
    public static final int SECOND_LEVEL_POOL_TOTAL_SIZE;
    public static final AtomicReferenceArray hashBuckets;
    public static final AtomicReferenceArray hashBucketsL2;

    static {
        int iIntValue;
        int i = 0;
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        int i2 = iHighestOneBit / 2;
        int i3 = i2 >= 1 ? i2 : 1;
        HASH_BUCKET_COUNT_L2 = i3;
        String property = System.getProperty("kotlinx.io.pool.size.bytes", Intrinsics.areEqual(System.getProperty("java.vm.name"), "Dalvik") ? "0" : "4194304");
        property.getClass();
        Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, property);
        if (intOrNull != null && (iIntValue = intOrNull.intValue()) >= 0) {
            i = iIntValue;
        }
        SECOND_LEVEL_POOL_TOTAL_SIZE = i;
        int i4 = i / i3;
        if (i4 < 8192) {
            i4 = 8192;
        }
        SECOND_LEVEL_POOL_BUCKET_SIZE = i4;
        hashBuckets = new AtomicReferenceArray(iHighestOneBit);
        hashBucketsL2 = new AtomicReferenceArray(i3);
    }

    public static final void recycle(Segment segment) {
        Segment segment2 = LOCK;
        segment.getClass();
        if (segment.next != null || segment.prev != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return;
        }
        RefCountingCopyTracker refCountingCopyTracker = segment.copyTracker;
        if (refCountingCopyTracker != null && refCountingCopyTracker.copyCount != 0) {
            int iDecrementAndGet = RefCountingCopyTracker.fieldUpdater.decrementAndGet(refCountingCopyTracker);
            if (iDecrementAndGet >= 0) {
                return;
            }
            if (iDecrementAndGet != -1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(iDecrementAndGet + 1, "Shared copies count is negative: ");
                return;
            }
            refCountingCopyTracker.copyCount = 0;
        }
        AtomicReferenceArray atomicReferenceArray = hashBuckets;
        int id = (int) ((((long) HASH_BUCKET_COUNT) - 1) & Thread.currentThread().getId());
        segment.pos = 0;
        segment.owner = true;
        while (true) {
            Segment segment3 = (Segment) atomicReferenceArray.get(id);
            if (segment3 != segment2) {
                int i = segment3 != null ? segment3.limit : 0;
                if (i < 65536) {
                    segment.next = segment3;
                    segment.limit = i + 8192;
                    while (!atomicReferenceArray.compareAndSet(id, segment3, segment)) {
                        if (atomicReferenceArray.get(id) != segment3) {
                        }
                    }
                    return;
                }
                if (SECOND_LEVEL_POOL_TOTAL_SIZE <= 0) {
                    return;
                }
                segment.pos = 0;
                segment.owner = true;
                int id2 = (int) ((((long) HASH_BUCKET_COUNT_L2) - 1) & Thread.currentThread().getId());
                AtomicReferenceArray atomicReferenceArray2 = hashBucketsL2;
                int i2 = 0;
                while (true) {
                    Segment segment4 = (Segment) atomicReferenceArray2.get(id2);
                    if (segment4 != segment2) {
                        int i3 = (segment4 != null ? segment4.limit : 0) + 8192;
                        if (i3 <= SECOND_LEVEL_POOL_BUCKET_SIZE) {
                            segment.next = segment4;
                            segment.limit = i3;
                            while (!atomicReferenceArray2.compareAndSet(id2, segment4, segment)) {
                                if (atomicReferenceArray2.get(id2) != segment4) {
                                }
                            }
                            return;
                        }
                        int i4 = HASH_BUCKET_COUNT_L2;
                        if (i2 >= i4) {
                            return;
                        }
                        i2++;
                        id2 = (id2 + 1) & (i4 - 1);
                    }
                }
            }
        }
    }

    public static final Segment take() {
        AtomicReferenceArray atomicReferenceArray;
        Segment segment;
        Segment segment2;
        int id = (int) ((((long) HASH_BUCKET_COUNT) - 1) & Thread.currentThread().getId());
        do {
            atomicReferenceArray = hashBuckets;
            segment = LOCK;
            segment2 = (Segment) atomicReferenceArray.getAndSet(id, segment);
        } while (Intrinsics.areEqual(segment2, segment));
        if (segment2 != null) {
            atomicReferenceArray.set(id, segment2.next);
            segment2.next = null;
            segment2.limit = 0;
            return segment2;
        }
        atomicReferenceArray.set(id, null);
        if (SECOND_LEVEL_POOL_TOTAL_SIZE <= 0) {
            return new Segment();
        }
        int i = HASH_BUCKET_COUNT_L2;
        int id2 = (int) (Thread.currentThread().getId() & (((long) i) - 1));
        int i2 = 0;
        while (true) {
            AtomicReferenceArray atomicReferenceArray2 = hashBucketsL2;
            Segment segment3 = (Segment) atomicReferenceArray2.getAndSet(id2, segment);
            if (!Intrinsics.areEqual(segment3, segment)) {
                if (segment3 != null) {
                    atomicReferenceArray2.set(id2, segment3.next);
                    segment3.next = null;
                    segment3.limit = 0;
                    return segment3;
                }
                atomicReferenceArray2.set(id2, null);
                if (i2 >= i) {
                    return new Segment();
                }
                id2 = (id2 + 1) & (i - 1);
                i2++;
            }
        }
    }
}
