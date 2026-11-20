package androidx.navigation.internal;

import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavGraphImpl$iterator$1 implements Iterator, KMappedMarker {
    public int index = -1;
    public final /* synthetic */ NavGraphImpl this$0;
    public boolean wentToNext;

    public NavGraphImpl$iterator$1(NavGraphImpl navGraphImpl) {
        this.this$0 = navGraphImpl;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.index + 1 < ((SparseArrayCompat) this.this$0.nodes).size();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return null;
        }
        this.wentToNext = true;
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.this$0.nodes;
        int i = this.index + 1;
        this.index = i;
        return (NavDestination) sparseArrayCompat.valueAt(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.wentToNext) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You must call next() before you can remove an element");
            return;
        }
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.this$0.nodes;
        ((NavDestination) sparseArrayCompat.valueAt(this.index)).parent = null;
        int i = this.index;
        Object[] objArr = sparseArrayCompat.values;
        Object obj = objArr[i];
        Object obj2 = ArraySetKt.DELETED$1;
        if (obj != obj2) {
            objArr[i] = obj2;
            sparseArrayCompat.garbage = true;
        }
        this.index = i - 1;
        this.wentToNext = false;
    }
}
