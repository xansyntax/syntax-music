package kotlin.sequences;

import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DistinctIterator extends AbstractIterator {
    public final DatabaseDao_Impl$$ExternalSyntheticLambda7 keySelector;
    public final HashSet observed;
    public final Iterator source;

    public DistinctIterator(Iterator it, DatabaseDao_Impl$$ExternalSyntheticLambda7 databaseDao_Impl$$ExternalSyntheticLambda7) {
        it.getClass();
        this.source = it;
        this.keySelector = databaseDao_Impl$$ExternalSyntheticLambda7;
        this.observed = new HashSet();
    }

    @Override // kotlin.collections.AbstractIterator
    public final void computeNext() throws Exception {
        Object next;
        do {
            Iterator it = this.source;
            if (!it.hasNext()) {
                this.state = (byte) 2;
                return;
            } else {
                next = it.next();
            }
        } while (!this.observed.add(this.keySelector.invoke(next)));
        this.nextValue = next;
        this.state = (byte) 1;
    }
}
