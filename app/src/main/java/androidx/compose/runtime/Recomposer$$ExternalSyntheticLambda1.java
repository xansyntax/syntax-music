package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Recomposer$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Recomposer f$0;

    public /* synthetic */ Recomposer$$ExternalSyntheticLambda1(Recomposer recomposer, byte b) {
        this.$r8$classId = b;
        this.f$0 = recomposer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Recomposer recomposer = this.f$0;
        switch (b) {
            case 0:
                recomposer.onNewFrameAwaiter();
                break;
            default:
                recomposer.onNewFrameAwaiter();
                break;
        }
        return unit;
    }
}
