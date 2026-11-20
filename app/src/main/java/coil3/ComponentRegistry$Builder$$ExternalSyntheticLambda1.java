package coil3;

import coil3.decode.Decoder;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentRegistry$Builder$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Decoder.Factory f$0;

    public /* synthetic */ ComponentRegistry$Builder$$ExternalSyntheticLambda1(Decoder.Factory factory, byte b) {
        this.$r8$classId = b;
        this.f$0 = factory;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Decoder.Factory factory = this.f$0;
        switch (b) {
            case 0:
                break;
        }
        return CollectionsKt__IterablesKt.listOf(factory);
    }
}
