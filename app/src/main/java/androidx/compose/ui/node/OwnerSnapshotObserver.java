package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OwnerSnapshotObserver {
    public final SnapshotStateObserver observer;
    public final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingLookaheadMeasure = new ComposedModifierKt$$ExternalSyntheticLambda0(16);
    public final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingMeasure = new ComposedModifierKt$$ExternalSyntheticLambda0(17);
    public final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingSemantics = new ComposedModifierKt$$ExternalSyntheticLambda0(18);
    public final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingLayout = new ComposedModifierKt$$ExternalSyntheticLambda0(19);
    public final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingLayoutModifier = new ComposedModifierKt$$ExternalSyntheticLambda0(20);
    public final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingLayoutModifierInLookahead = new ComposedModifierKt$$ExternalSyntheticLambda0(21);
    public final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingLookahead = new ComposedModifierKt$$ExternalSyntheticLambda0(22);

    public OwnerSnapshotObserver(AndroidComposeView$$ExternalSyntheticLambda0 androidComposeView$$ExternalSyntheticLambda0) {
        this.observer = new SnapshotStateObserver(androidComposeView$$ExternalSyntheticLambda0);
    }
}
