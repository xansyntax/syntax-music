package androidx.compose.ui;

import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CombinedModifier implements Modifier {
    public final Modifier inner;
    public final Modifier outer;

    public CombinedModifier(Modifier modifier, Modifier modifier2) {
        this.outer = modifier;
        this.inner = modifier2;
    }

    @Override // androidx.compose.ui.Modifier
    public final boolean all(Function1 function1) {
        return this.outer.all(function1) && this.inner.all(function1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CombinedModifier)) {
            return false;
        }
        CombinedModifier combinedModifier = (CombinedModifier) obj;
        return this.outer.equals(combinedModifier.outer) && Intrinsics.areEqual(this.inner, combinedModifier.inner);
    }

    @Override // androidx.compose.ui.Modifier
    public final Object foldIn(Object obj, Function2 function2) {
        return this.inner.foldIn(this.outer.foldIn(obj, function2), function2);
    }

    public final int hashCode() {
        return (this.inner.hashCode() * 31) + this.outer.hashCode();
    }

    public final String toString() {
        StringBuilder sb = (StringBuilder) foldIn(new StringBuilder("["), new Updater$$ExternalSyntheticLambda0((byte) 9));
        sb.append("]");
        return sb.toString();
    }
}
