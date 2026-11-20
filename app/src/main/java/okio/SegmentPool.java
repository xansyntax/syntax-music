package okio;

import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SegmentPool {
    public static final int HASH_BUCKET_COUNT;
    public static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);
    public static final AtomicReference[] hashBuckets;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        hashBuckets = atomicReferenceArr;
    }

    public static final void recycle(Segment segment) {
        segment.getClass();
        if (segment.next != null || segment.prev != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return;
        }
        if (segment.shared) {
            return;
        }
        AtomicReference atomicReference = hashBuckets[(int) (Thread.currentThread().getId() & (((long) HASH_BUCKET_COUNT) - 1))];
        Segment segment2 = LOCK;
        Segment segment3 = (Segment) atomicReference.getAndSet(segment2);
        if (segment3 == segment2) {
            return;
        }
        int i = segment3 != null ? segment3.limit : 0;
        if (i >= 65536) {
            atomicReference.set(segment3);
            return;
        }
        segment.next = segment3;
        segment.pos = 0;
        segment.limit = i + 8192;
        atomicReference.set(segment);
    }

    public static final Segment take() {
        AtomicReference atomicReference = hashBuckets[(int) (Thread.currentThread().getId() & (((long) HASH_BUCKET_COUNT) - 1))];
        Segment segment = LOCK;
        Segment segment2 = (Segment) atomicReference.getAndSet(segment);
        if (segment2 == segment) {
            return new Segment();
        }
        if (segment2 == null) {
            atomicReference.set(null);
            return new Segment();
        }
        atomicReference.set(segment2.next);
        segment2.next = null;
        segment2.limit = 0;
        return segment2;
    }
}
