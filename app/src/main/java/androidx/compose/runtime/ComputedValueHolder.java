package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComputedValueHolder implements ValueHolder {
    public final Function1 compute;

    public ComputedValueHolder(Function1 function1) {
        this.compute = function1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ComputedValueHolder) && Intrinsics.areEqual(this.compute, ((ComputedValueHolder) obj).compute);
    }

    public final int hashCode() {
        return this.compute.hashCode();
    }

    @Override // androidx.compose.runtime.ValueHolder
    public final Object readValue(PersistentCompositionLocalHashMap persistentCompositionLocalHashMap) {
        return this.compute.invoke(persistentCompositionLocalHashMap);
    }

    public final String toString() {
        return "ComputedValueHolder(compute=" + this.compute + ")";
    }
}
