package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import dagger.hilt.EntryPoints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.sequences.SequenceBuilderIterator;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposePausableCompositionException extends RuntimeException {
    public final MutableObjectList instances;
    public final int lastOperation;
    public final MutableIntList operations;
    public final MutableObjectList reused;

    public ComposePausableCompositionException(MutableObjectList mutableObjectList, MutableObjectList mutableObjectList2, MutableIntList mutableIntList, int i, Exception exc) {
        super(exc);
        this.instances = mutableObjectList;
        this.reused = mutableObjectList2;
        this.operations = mutableIntList;
        this.lastOperation = i;
    }

    @Override // java.lang.Throwable
    public final String getMessage() throws IOException {
        List listListOf;
        SequenceBuilderIterator it = EntryPoints.iterator(new ComposePausableCompositionException$operationsSequence$1(this, null));
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                listListOf = arrayList;
            } else {
                listListOf = CollectionsKt__IterablesKt.listOf(next);
            }
        } else {
            listListOf = EmptyList.INSTANCE;
        }
        return StringsKt__IndentKt.trimMargin$default("\n            |Failed to execute op number " + this.lastOperation + ":\n            |" + CollectionsKt.joinToString$default(CollectionsKt.takeLast(50, listListOf), "\n", null, null, null, 62) + "\n            ");
    }
}
