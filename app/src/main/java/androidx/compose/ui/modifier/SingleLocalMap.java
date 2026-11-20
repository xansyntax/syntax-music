package androidx.compose.ui.modifier;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.RulerKt;
import androidx.sqlite.SQLite;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleLocalMap extends SQLite {
    public final ParcelableSnapshotMutableState value$delegate = Stack.mutableStateOf$default(null);

    @Override // androidx.sqlite.SQLite
    public final boolean contains$ui(ProvidableModifierLocal providableModifierLocal) {
        return providableModifierLocal == CrossfadeKt.ModifierLocalSharedMutableTransformState;
    }

    @Override // androidx.sqlite.SQLite
    public final Object get$ui() {
        if (RulerKt.ModifierLocalBeyondBoundsLayout != CrossfadeKt.ModifierLocalSharedMutableTransformState) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        Object value = this.value$delegate.getValue();
        if (value == null) {
            return null;
        }
        return value;
    }
}
