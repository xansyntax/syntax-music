package kotlin.sequences;

import io.ktor.util.collections.TreeLike;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SequencesKt__SequencesKt$sequenceOf$1$1 implements Iterator, KMappedMarker {
    public final /* synthetic */ TreeLike $element;
    public boolean _hasNext = true;

    public SequencesKt__SequencesKt$sequenceOf$1$1(TreeLike treeLike) {
        this.$element = treeLike;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this._hasNext;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this._hasNext) {
            this._hasNext = false;
            return this.$element;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
