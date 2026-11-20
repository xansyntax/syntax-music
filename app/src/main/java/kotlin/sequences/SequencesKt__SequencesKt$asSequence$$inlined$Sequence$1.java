package kotlin.sequences;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 implements Sequence {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Iterator $this_asSequence$inlined;

    public /* synthetic */ SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(Iterator it, byte b) {
        this.$r8$classId = b;
        this.$this_asSequence$inlined = it;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        return this.$this_asSequence$inlined;
    }
}
