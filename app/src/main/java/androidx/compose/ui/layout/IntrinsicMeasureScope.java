package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface IntrinsicMeasureScope extends Density {
    LayoutDirection getLayoutDirection();

    default boolean isLookingAhead() {
        return false;
    }
}
