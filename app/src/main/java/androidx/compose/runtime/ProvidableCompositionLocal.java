package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProvidableCompositionLocal {
    public final LazyValueHolder defaultValueHolder;

    public ProvidableCompositionLocal(Function0 function0) {
        this.defaultValueHolder = new LazyValueHolder(function0);
    }

    public abstract ProvidedValue defaultProvidedValue$runtime(Object obj);

    public ValueHolder getDefaultValueHolder$runtime() {
        return this.defaultValueHolder;
    }

    public final ProvidedValue providesComputed(Function1 function1) {
        return new ProvidedValue(this, null, false, null, function1, false);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0034 A[PHI: r4
      0x0034: PHI (r4v2 androidx.compose.runtime.ValueHolder) = (r4v6 androidx.compose.runtime.ValueHolder), (r4v7 androidx.compose.runtime.ValueHolder) binds: [B:21:0x0040, B:16:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    public final ValueHolder updatedStateOf$runtime(ProvidedValue providedValue, ValueHolder valueHolder) {
        ComputedValueHolder computedValueHolder;
        ValueHolder valueHolder2;
        StaticValueHolder staticValueHolder;
        DynamicValueHolder dynamicValueHolder;
        ValueHolder valueHolder3 = null;
        valueHolder3 = null;
        valueHolder3 = null;
        valueHolder3 = null;
        valueHolder3 = null;
        valueHolder3 = null;
        if (valueHolder instanceof DynamicValueHolder) {
            if (providedValue.isDynamic) {
                dynamicValueHolder = (DynamicValueHolder) valueHolder;
                dynamicValueHolder.state.setValue(providedValue.getEffectiveValue$runtime());
            }
        } else if (valueHolder instanceof StaticValueHolder) {
            if ((providedValue.explicitNull || providedValue.providedValue != null) && !providedValue.isDynamic) {
                staticValueHolder = (StaticValueHolder) valueHolder;
                if (Intrinsics.areEqual(providedValue.getEffectiveValue$runtime(), staticValueHolder.value)) {
                    valueHolder2 = computedValueHolder;
                    valueHolder2 = staticValueHolder;
                    valueHolder3 = valueHolder2;
                }
            }
        } else if (valueHolder instanceof ComputedValueHolder) {
            computedValueHolder = (ComputedValueHolder) valueHolder;
            if (providedValue.compute == computedValueHolder.compute) {
                valueHolder2 = computedValueHolder;
                valueHolder2 = staticValueHolder;
                valueHolder3 = valueHolder2;
            }
        }
        if (valueHolder3 != null) {
            valueHolder3 = dynamicValueHolder;
            return valueHolder3;
        }
        if (!providedValue.isDynamic) {
            Function1 function1 = providedValue.compute;
            if (function1 != null) {
                valueHolder3 = dynamicValueHolder;
                return new ComputedValueHolder(function1);
            }
            valueHolder3 = dynamicValueHolder;
            return new StaticValueHolder(providedValue.getEffectiveValue$runtime());
        }
        Object obj = providedValue.providedValue;
        NeverEqualPolicy neverEqualPolicy = providedValue.mutationPolicy;
        if (neverEqualPolicy == null) {
            valueHolder3 = dynamicValueHolder;
            neverEqualPolicy = NeverEqualPolicy.INSTANCE$3;
        }
        valueHolder3 = dynamicValueHolder;
        return new DynamicValueHolder(new ParcelableSnapshotMutableState(obj, neverEqualPolicy));
    }
}
