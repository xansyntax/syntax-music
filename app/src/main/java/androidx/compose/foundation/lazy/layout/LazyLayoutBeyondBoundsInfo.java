package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsInfo {
    public final MutableVector beyondBoundsItems;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Interval {
        public final int end;
        public final int start;

        public Interval(int i, int i2) {
            this.start = i;
            this.end = i2;
            if (!(i >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("negative start index");
            }
            if (i2 >= i) {
                return;
            }
            InlineClassHelperKt.throwIllegalArgumentException("end index greater than start");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.start == interval.start && this.end == interval.end;
        }

        public final int hashCode() {
            return Integer.hashCode(this.end) + (Integer.hashCode(this.start) * 31);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.start, "Interval(start=", ", end=", this.end, ")");
        }
    }

    public LazyLayoutBeyondBoundsInfo(byte b) {
        switch (b) {
            case 1:
                this.beyondBoundsItems = new MutableVector(new ContentInViewNode.Request[16]);
                break;
            default:
                this.beyondBoundsItems = new MutableVector(new Interval[16]);
                break;
        }
    }

    public void cancelAndRemoveAll(CancellationException cancellationException) {
        MutableVector mutableVector = this.beyondBoundsItems;
        int i = mutableVector.size;
        CancellableContinuation[] cancellableContinuationArr = new CancellableContinuation[i];
        for (int i2 = 0; i2 < i; i2++) {
            cancellableContinuationArr[i2] = ((ContentInViewNode.Request) mutableVector.content[i2]).continuation;
        }
        for (int i3 = 0; i3 < i; i3++) {
            cancellableContinuationArr[i3].cancel(cancellationException);
        }
        if (mutableVector.size == 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("uncancelled requests present");
    }

    public void resumeAndRemoveAll() {
        MutableVector mutableVector = this.beyondBoundsItems;
        IntRange intRangeUntil = UuidKt.until(0, mutableVector.size);
        int i = intRangeUntil.first;
        int i2 = intRangeUntil.last;
        if (i <= i2) {
            while (true) {
                ((ContentInViewNode.Request) mutableVector.content[i]).continuation.resumeWith(Unit.INSTANCE);
                if (i == i2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        mutableVector.clear();
    }
}
