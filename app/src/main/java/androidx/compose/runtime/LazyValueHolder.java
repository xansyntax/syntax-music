package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyValueHolder implements ValueHolder {
    public final SynchronizedLazyImpl current$delegate;

    public LazyValueHolder(Function0 function0) {
        this.current$delegate = new SynchronizedLazyImpl(function0);
    }

    @Override // androidx.compose.runtime.ValueHolder
    public final Object readValue(PersistentCompositionLocalHashMap persistentCompositionLocalHashMap) {
        return this.current$delegate.getValue();
    }
}
