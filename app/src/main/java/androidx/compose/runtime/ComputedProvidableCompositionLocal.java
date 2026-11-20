package androidx.compose.runtime;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComputedProvidableCompositionLocal extends ProvidableCompositionLocal {
    public final /* synthetic */ byte $r8$classId = 1;
    public final ComputedValueHolder defaultValueHolder;

    public ComputedProvidableCompositionLocal(Function1 function1) {
        super(new TextKt$$ExternalSyntheticLambda3((byte) 11));
        this.defaultValueHolder = new ComputedValueHolder(function1);
    }

    @Override // androidx.compose.runtime.ProvidableCompositionLocal
    public final ProvidedValue defaultProvidedValue$runtime(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return new ProvidedValue(this, obj, obj == null, null, null, true);
            default:
                return new ProvidedValue(this, obj, obj == null, null, null, false);
        }
    }

    @Override // androidx.compose.runtime.ProvidableCompositionLocal
    public final ValueHolder getDefaultValueHolder$runtime() {
        byte b = this.$r8$classId;
        return this.defaultValueHolder;
    }

    public ComputedProvidableCompositionLocal(SaversKt$$ExternalSyntheticLambda2 saversKt$$ExternalSyntheticLambda2) {
        super(new TextKt$$ExternalSyntheticLambda3((byte) 13));
        this.defaultValueHolder = new ComputedValueHolder(saversKt$$ExternalSyntheticLambda2);
    }
}
