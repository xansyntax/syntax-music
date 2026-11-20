package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusProperties;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();
    public static Boolean canFocusValue;

    @Override // androidx.compose.ui.focus.FocusProperties
    public final boolean getCanFocus() {
        Boolean bool = canFocusValue;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$2("canFocus is read before it is written");
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setCanFocus(boolean z) {
        canFocusValue = Boolean.valueOf(z);
    }
}
