package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StaticProvidableCompositionLocal extends ProvidableCompositionLocal {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StaticProvidableCompositionLocal(Function0 function0, byte b) {
        super(function0);
        this.$r8$classId = b;
    }

    @Override // androidx.compose.runtime.ProvidableCompositionLocal
    public final ProvidedValue defaultProvidedValue$runtime(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return new ProvidedValue(this, obj, obj == null, null, null, false);
            default:
                return new ProvidedValue(this, obj, obj == null, NeverEqualPolicy.INSTANCE$3, null, true);
        }
    }
}
