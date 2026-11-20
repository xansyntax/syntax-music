package androidx.compose.foundation.contextmenu;

import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContextMenuScope {
    public final SnapshotStateList composables = new SnapshotStateList();

    public static void item$default(ContextMenuScope contextMenuScope, Function2 function2, ComposableLambdaImpl composableLambdaImpl, Function0 function0, int i) {
        if ((i & 8) != 0) {
            composableLambdaImpl = null;
        }
        contextMenuScope.composables.add(new ComposableLambdaImpl(true, -1789283891, new SongMenuKt$$ExternalSyntheticLambda34(function2, contextMenuScope, composableLambdaImpl, function0)));
    }

    public final void Content$foundation(ContextMenuColors contextMenuColors, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-798501095);
        byte b = 2;
        int i2 = (gapComposer.changed(contextMenuColors) ? 4 : 2) | i | (gapComposer.changed(this) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            SnapshotStateList snapshotStateList = this.composables;
            int size = snapshotStateList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Function3) snapshotStateList.get(i3)).invoke(contextMenuColors, gapComposer, Integer.valueOf(i2 & 14));
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda1(this, contextMenuColors, i, b);
        }
    }
}
