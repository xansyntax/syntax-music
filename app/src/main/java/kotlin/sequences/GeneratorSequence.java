package kotlin.sequences;

import androidx.palette.graphics.ColorCutQuantizer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class GeneratorSequence implements Sequence {
    public final /* synthetic */ byte $r8$classId = 0;
    public final Object getInitialValue;
    public final Object getNextValue;

    public GeneratorSequence(GeneratorSequence generatorSequence, Function2 function2) {
        function2.getClass();
        this.getInitialValue = generatorSequence;
        this.getNextValue = function2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new SubSequence.AnonymousClass1(this);
            case 1:
                FilteringSequence filteringSequence = (FilteringSequence) this.getInitialValue;
                ArrayList arrayList = new ArrayList();
                FilteringSequence.AnonymousClass1 anonymousClass1 = new FilteringSequence.AnonymousClass1(filteringSequence);
                while (anonymousClass1.hasNext()) {
                    arrayList.add(anonymousClass1.next());
                }
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, (ColorCutQuantizer.AnonymousClass1) this.getNextValue);
                return arrayList.iterator();
            case 2:
                return new FilteringSequence.AnonymousClass1(this);
            default:
                return new SubSequence.AnonymousClass1(this, (byte) 0);
        }
    }

    public GeneratorSequence(Sequence sequence, Function1 function1) {
        function1.getClass();
        this.getInitialValue = sequence;
        this.getNextValue = function1;
    }

    public GeneratorSequence(Function0 function0, Function1 function1) {
        function1.getClass();
        this.getInitialValue = function0;
        this.getNextValue = function1;
    }

    public GeneratorSequence(FilteringSequence filteringSequence, ColorCutQuantizer.AnonymousClass1 anonymousClass1) {
        this.getInitialValue = filteringSequence;
        this.getNextValue = anonymousClass1;
    }
}
