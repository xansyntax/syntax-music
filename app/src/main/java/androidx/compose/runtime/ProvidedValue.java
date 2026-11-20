package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProvidedValue {
    public boolean canOverride = true;
    public final ProvidableCompositionLocal compositionLocal;
    public final Function1 compute;
    public final boolean explicitNull;
    public final boolean isDynamic;
    public final NeverEqualPolicy mutationPolicy;
    public final Object providedValue;

    public ProvidedValue(ProvidableCompositionLocal providableCompositionLocal, Object obj, boolean z, NeverEqualPolicy neverEqualPolicy, Function1 function1, boolean z2) {
        this.compositionLocal = providableCompositionLocal;
        this.explicitNull = z;
        this.mutationPolicy = neverEqualPolicy;
        this.compute = function1;
        this.isDynamic = z2;
        this.providedValue = obj;
    }

    public final Object getEffectiveValue$runtime() {
        if (this.explicitNull) {
            return null;
        }
        Object obj = this.providedValue;
        if (obj != null) {
            return obj;
        }
        ComposerKt.composeRuntimeError("Unexpected form of a provided value");
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return null;
    }
}
