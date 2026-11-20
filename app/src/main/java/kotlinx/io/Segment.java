package kotlinx.io;

import kotlin.collections.ArraysKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Segment {
    public RefCountingCopyTracker copyTracker;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.copyTracker = null;
    }

    public final int getRemainingCapacity() {
        return this.data.length - this.limit;
    }

    public final int getSize() {
        return this.limit - this.pos;
    }

    public final byte getUnchecked$kotlinx_io_core(int i) {
        return this.data[this.pos + i];
    }

    public final Segment pop$kotlinx_io_core() {
        Segment segment = this.next;
        Segment segment2 = this.prev;
        if (segment2 != null) {
            segment2.getClass();
            segment2.next = this.next;
        }
        Segment segment3 = this.next;
        if (segment3 != null) {
            segment3.getClass();
            segment3.prev = this.prev;
        }
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final void push$kotlinx_io_core(Segment segment) {
        segment.getClass();
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        if (segment2 != null) {
            segment2.prev = segment;
        }
        this.next = segment;
    }

    public final Segment sharedCopy$kotlinx_io_core() {
        RefCountingCopyTracker refCountingCopyTracker = this.copyTracker;
        if (refCountingCopyTracker == null) {
            Segment segment = SegmentPool.LOCK;
            refCountingCopyTracker = new RefCountingCopyTracker();
            this.copyTracker = refCountingCopyTracker;
        }
        int i = this.pos;
        int i2 = this.limit;
        RefCountingCopyTracker.fieldUpdater.incrementAndGet(refCountingCopyTracker);
        return new Segment(this.data, i, i2, refCountingCopyTracker);
    }

    public final void writeTo$kotlinx_io_core(Segment segment, int i) {
        segment.getClass();
        if (!segment.owner) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("only owner can write");
            return;
        }
        int i2 = segment.limit;
        if (i2 + i > 8192) {
            RefCountingCopyTracker refCountingCopyTracker = segment.copyTracker;
            if (refCountingCopyTracker != null && refCountingCopyTracker.copyCount > 0) {
                Path$$ExternalSyntheticBUOutline0.m();
                return;
            }
            int i3 = segment.limit;
            int i4 = segment.pos;
            if ((i3 + i) - i4 > 8192) {
                Path$$ExternalSyntheticBUOutline0.m();
                return;
            }
            byte[] bArr = segment.data;
            ArraysKt.copyInto$default(bArr, bArr, 0, i4, i3, 2);
            i2 = segment.limit - segment.pos;
            segment.limit = i2;
            segment.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = segment.data;
        int i5 = this.pos;
        ArraysKt.copyInto(i2, i5, i5 + i, bArr2, bArr3);
        segment.limit += i;
        this.pos += i;
    }

    public Segment(byte[] bArr, int i, int i2, RefCountingCopyTracker refCountingCopyTracker) {
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.copyTracker = refCountingCopyTracker;
        this.owner = false;
    }
}
