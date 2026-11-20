package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.IndexingIterator;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DropSequence implements Sequence, DropTakeSequence {
    public final /* synthetic */ byte $r8$classId;
    public final int count;
    public final Sequence sequence;

    public DropSequence(Sequence sequence, int i, byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                sequence.getClass();
                this.sequence = sequence;
                this.count = i;
                if (i >= 0) {
                    return;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m(i, "count must be non-negative, but was ");
                throw null;
            default:
                sequence.getClass();
                this.sequence = sequence;
                this.count = i;
                if (i >= 0) {
                    return;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m(i, "count must be non-negative, but was ");
                throw null;
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence drop(int i) {
        byte b = this.$r8$classId;
        Sequence sequence = this.sequence;
        int i2 = this.count;
        switch (b) {
            case 0:
                int i3 = i2 + i;
                return i3 < 0 ? new DropSequence(this, i, (byte) 0) : new DropSequence(sequence, i3, (byte) 0);
            default:
                return i >= i2 ? EmptySequence.INSTANCE : new SubSequence(sequence, i, i2);
        }
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new IndexingIterator(this);
            default:
                return new IndexingIterator(this, (byte) 0);
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence take(int i) {
        switch (this.$r8$classId) {
            case 0:
                int i2 = this.count;
                int i3 = i2 + i;
                return i3 < 0 ? new DropSequence(this, i, (byte) 1) : new SubSequence(this.sequence, i2, i3);
            default:
                return i >= this.count ? this : new DropSequence(this.sequence, i, (byte) 1);
        }
    }
}
