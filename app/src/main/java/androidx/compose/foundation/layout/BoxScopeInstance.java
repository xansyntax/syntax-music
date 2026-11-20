package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BoxScopeInstance implements BoxScope {
    public static final BoxScopeInstance INSTANCE = new BoxScopeInstance();

    @Override // androidx.compose.foundation.layout.BoxScope
    public final Modifier align(Modifier modifier, Alignment alignment) {
        return modifier.then(new BoxChildDataElement(alignment, false));
    }

    public final Modifier matchParentSize() {
        return new BoxChildDataElement(Alignment.Companion.Center, true);
    }
}
