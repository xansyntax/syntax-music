package kotlin.sequences;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal.ResourceFileSystem$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SequencesKt extends SequencesKt__SequencesJVMKt {
    public static Sequence asSequence(Iterator it) {
        it.getClass();
        return constrainOnce(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(it, (byte) 0));
    }

    public static Sequence constrainOnce(Sequence sequence) {
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    public static Sequence drop(Sequence sequence, int i) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return sequence;
        }
        return sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).drop(i) : new DropSequence(sequence, i, (byte) 0);
    }

    public static FilteringSequence filter(Sequence sequence, Function1 function1) {
        return new FilteringSequence(sequence, true, function1);
    }

    public static Object firstOrNull(FilteringSequence filteringSequence) {
        FilteringSequence.AnonymousClass1 anonymousClass1 = new FilteringSequence.AnonymousClass1(filteringSequence);
        if (anonymousClass1.hasNext()) {
            return anonymousClass1.next();
        }
        return null;
    }

    public static Sequence generateSequence(Object obj, Function1 function1) {
        function1.getClass();
        return obj == null ? EmptySequence.INSTANCE : new GeneratorSequence(new ResourceFileSystem$$ExternalSyntheticLambda0((byte) 3, obj), function1);
    }

    public static String joinToString$default(Sequence sequence, String str) {
        sequence.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (Object obj : sequence) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) str);
            }
            StringsKt__IndentKt.appendElement(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static Object last(Sequence sequence) {
        sequence.getClass();
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("Sequence is empty.");
            return null;
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static TransformingSequence map(Sequence sequence, Function1 function1) {
        sequence.getClass();
        return new TransformingSequence(sequence, function1);
    }

    public static FilteringSequence mapNotNull(Sequence sequence, Function1 function1) {
        return new FilteringSequence(new TransformingSequence(sequence, function1), false, new InstantKt$$ExternalSyntheticLambda0((byte) 19));
    }

    public static FlatteningSequence plus(Sequence sequence, Sequence sequence2) {
        sequence2.getClass();
        return new FlatteningSequence(new LinesSequence((byte) 1, new Sequence[]{sequence, sequence2}), new InstantKt$$ExternalSyntheticLambda0((byte) 18), new InstantKt$$ExternalSyntheticLambda0((byte) 17));
    }

    public static Sequence take(Sequence sequence, int i) {
        sequence.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return EmptySequence.INSTANCE;
        }
        return sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).take(i) : new DropSequence(sequence, i, (byte) 1);
    }

    public static List toList(Sequence sequence) {
        sequence.getClass();
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return EmptyList.INSTANCE;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt__IterablesKt.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static Set toSet(TransformingSequence transformingSequence) {
        Function1 function1 = transformingSequence.transformer;
        Iterator it = transformingSequence.sequence.iterator();
        if (!it.hasNext()) {
            return EmptySet.INSTANCE;
        }
        Object objInvoke = function1.invoke(it.next());
        if (!it.hasNext()) {
            return CharsKt.setOf(objInvoke);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(objInvoke);
        while (it.hasNext()) {
            linkedHashSet.add(function1.invoke(it.next()));
        }
        return linkedHashSet;
    }
}
