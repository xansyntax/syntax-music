package androidx.compose.material3;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.platform.AbstractComposeView;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetDialogLayout extends AbstractComposeView {
    public final ParcelableSnapshotMutableState content$delegate;
    public boolean shouldCreateCompositionOnAttachedToWindow;

    public ModalBottomSheetDialogLayout(Context context) {
        super(context);
        this.content$delegate = Stack.mutableStateOf$default(CardKt.f5lambda$91331245);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(576708319);
        int i2 = (gapComposer.changedInstance(this) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            ((Function2) this.content$delegate.getValue()).invoke(gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ComposerKt$$ExternalSyntheticLambda0(this, i, (byte) 16);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }
}
