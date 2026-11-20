package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PrecisionPointer_androidKt {
    static {
        new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3((byte) 4), (byte) 0);
    }

    public static final void EnsurePrecisionPointerListenersRegistered(ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(442516910);
        if (gapComposer.shouldExecute(i & 1, (i & 3) != 2)) {
            gapComposer.startReplaceGroup(1766838549);
            gapComposer.end(false);
            gapComposer.startReplaceGroup(1767392772);
            composableLambdaImpl.invoke((Object) gapComposer, (Object) 6);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CardKt$$ExternalSyntheticLambda1(composableLambdaImpl, i, (byte) 6);
        }
    }
}
