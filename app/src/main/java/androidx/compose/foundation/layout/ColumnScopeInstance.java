package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColumnScopeInstance {
    public static final ColumnScopeInstance INSTANCE = new ColumnScopeInstance();

    public final Modifier align(Modifier modifier, BiasAlignment.Horizontal horizontal) {
        return modifier.then(new HorizontalAlignElement(horizontal));
    }

    public final Modifier weight(Modifier modifier, float f, boolean z) {
        if (f <= 0.0d) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
        }
        if (f > Float.MAX_VALUE) {
            f = Float.MAX_VALUE;
        }
        return modifier.then(new LayoutWeightElement(f, z));
    }
}
