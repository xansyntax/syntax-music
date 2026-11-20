package androidx.compose.ui.platform;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeView extends AbstractComposeView {
    public final ParcelableSnapshotMutableState content;
    public boolean shouldCreateCompositionOnAttachedToWindow;

    public ComposeView(Context context) {
        super(context);
        this.content = Stack.mutableStateOf$default(null);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(420213850);
        int i2 = (gapComposer.changedInstance(this) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Function2 function2 = (Function2) this.content.getValue();
            if (function2 == null) {
                gapComposer.startReplaceGroup(-1238823553);
            } else {
                gapComposer.startReplaceGroup(98585282);
                function2.invoke(gapComposer, 0);
            }
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ComposerKt$$ExternalSyntheticLambda0(this, i, (byte) 27);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.compose.ui.platform.ComposeView";
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void setContent(Function2 function2) {
        this.shouldCreateCompositionOnAttachedToWindow = true;
        this.content.setValue(function2);
        if (isAttachedToWindow() || getComposeViewContext$ui() != null) {
            createComposition();
        }
    }

    public static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }
}
