package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GapComposer$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ GapComposer f$0;

    public /* synthetic */ GapComposer$$ExternalSyntheticLambda1(GapComposer gapComposer, MovableContentStateReference movableContentStateReference) {
        this.$r8$classId = (byte) 0;
        this.f$0 = gapComposer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        GapComposer gapComposer = this.f$0;
        switch (b) {
            case 0:
                gapComposer.invokeMovableContentLambda(null, null);
                return Unit.INSTANCE;
            case 1:
                return gapComposer.currentStackTrace();
            default:
                return gapComposer.currentStackTrace();
        }
    }

    public /* synthetic */ GapComposer$$ExternalSyntheticLambda1(GapComposer gapComposer, byte b) {
        this.$r8$classId = b;
        this.f$0 = gapComposer;
    }
}
