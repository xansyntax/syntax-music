package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SnackbarHostState.SnackbarDataImpl f$0;

    public /* synthetic */ SnackbarKt$$ExternalSyntheticLambda1(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = snackbarDataImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SnackbarHostState.SnackbarDataImpl snackbarDataImpl = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(snackbarDataImpl.visuals.message, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                }
                break;
            default:
                ComposableLambdaImpl composableLambdaImpl = CardKt.f4lambda$1548712596;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    snackbarDataImpl.getClass();
                    composableLambdaImpl.invoke((Object) snackbarDataImpl, (Object) gapComposer2, (Object) 0);
                }
                break;
        }
        return unit;
    }
}
