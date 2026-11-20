package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$flatMap$2 extends FunctionReferenceImpl implements Function1 {
    public static final SequencesKt___SequencesKt$flatMap$2 INSTANCE = new SequencesKt___SequencesKt$flatMap$2(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Sequence sequence = (Sequence) obj;
        sequence.getClass();
        return sequence.iterator();
    }
}
