package kotlin.text;

import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DelimitedRangesSequence implements Sequence {
    public final Function2 getNextMatch;
    public final CharSequence input;
    public final int limit;

    /* JADX INFO: renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public int counter;
        public int currentStartIndex;
        public IntRange nextItem;
        public int nextSearchIndex;
        public int nextState = -1;

        public AnonymousClass1() {
            int iCoerceIn = UuidKt.coerceIn(0, 0, DelimitedRangesSequence.this.input.length());
            this.currentStartIndex = iCoerceIn;
            this.nextSearchIndex = iCoerceIn;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001c  */
        /* JADX WARN: Code duplicated, block: B:12:0x0022 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:18:0x006f  */
        public final void calcNext$3() {
            Pair pair;
            DelimitedRangesSequence delimitedRangesSequence = DelimitedRangesSequence.this;
            CharSequence charSequence = delimitedRangesSequence.input;
            int i = this.nextSearchIndex;
            if (i < 0) {
                this.nextState = 0;
                this.nextItem = null;
                return;
            }
            int i2 = delimitedRangesSequence.limit;
            if (i2 > 0) {
                int i3 = this.counter + 1;
                this.counter = i3;
                if (i3 >= i2) {
                    this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(charSequence), 1);
                    this.nextSearchIndex = -1;
                } else if (i > charSequence.length() && (pair = (Pair) delimitedRangesSequence.getNextMatch.invoke(charSequence, Integer.valueOf(this.nextSearchIndex))) != null) {
                    int iIntValue = ((Number) pair.first).intValue();
                    int iIntValue2 = ((Number) pair.second).intValue();
                    this.nextItem = UuidKt.until(this.currentStartIndex, iIntValue);
                    int i4 = iIntValue + iIntValue2;
                    this.currentStartIndex = i4;
                    this.nextSearchIndex = i4 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(charSequence), 1);
                    this.nextSearchIndex = -1;
                }
            } else if (i > charSequence.length()) {
                this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(charSequence), 1);
                this.nextSearchIndex = -1;
            } else {
                int iIntValue3 = ((Number) pair.first).intValue();
                int iIntValue4 = ((Number) pair.second).intValue();
                this.nextItem = UuidKt.until(this.currentStartIndex, iIntValue3);
                int i5 = iIntValue3 + iIntValue4;
                this.currentStartIndex = i5;
                this.nextSearchIndex = i5 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.nextState = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.nextState == -1) {
                calcNext$3();
            }
            return this.nextState == 1;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.nextState == -1) {
                calcNext$3();
            }
            if (this.nextState == 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            IntRange intRange = this.nextItem;
            intRange.getClass();
            this.nextItem = null;
            this.nextState = -1;
            return intRange;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public DelimitedRangesSequence(CharSequence charSequence, int i, Function2 function2) {
        charSequence.getClass();
        this.input = charSequence;
        this.limit = i;
        this.getNextMatch = function2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
