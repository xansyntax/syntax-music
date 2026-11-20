package androidx.compose.ui.window;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DialogProperties {
    public final boolean decorFitsSystemWindows;
    public final boolean dismissOnBackPress;
    public final boolean dismissOnClickOutside;
    public final boolean usePlatformDefaultWidth;
    public final String windowTitle;
    public final byte windowType;

    public DialogProperties(boolean z, boolean z2, SecureFlagPolicy secureFlagPolicy, boolean z3) {
        this.dismissOnBackPress = z;
        this.dismissOnClickOutside = z2;
        this.usePlatformDefaultWidth = z3;
        this.decorFitsSystemWindows = true;
        this.windowTitle = "";
        this.windowType = (byte) 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogProperties) {
            DialogProperties dialogProperties = (DialogProperties) obj;
            return this.dismissOnBackPress == dialogProperties.dismissOnBackPress && this.dismissOnClickOutside == dialogProperties.dismissOnClickOutside && this.usePlatformDefaultWidth == dialogProperties.usePlatformDefaultWidth && this.decorFitsSystemWindows == dialogProperties.decorFitsSystemWindows && this.windowType == dialogProperties.windowType && Dp.m796equalsimpl0(Float.NaN, Float.NaN) && Dp.m796equalsimpl0(Float.NaN, Float.NaN) && Float.isNaN(Float.NaN) && Float.isNaN(Float.NaN);
        }
        return false;
    }

    public final int hashCode() {
        return IntIntPair$$ExternalSyntheticOutline0.m(Float.NaN, IntIntPair$$ExternalSyntheticOutline0.m(Float.NaN, IntIntPair$$ExternalSyntheticOutline0.m(Float.NaN, (IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((SecureFlagPolicy.Inherit.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Boolean.hashCode(this.dismissOnBackPress) * 31, this.dismissOnClickOutside, 31)) * 31, this.usePlatformDefaultWidth, 31), this.decorFitsSystemWindows, 31) + this.windowType) * 961, 31), 31), 31);
    }

    public DialogProperties() {
        this(true, true, SecureFlagPolicy.Inherit, true);
    }

    public /* synthetic */ DialogProperties(int i) {
        this(true, true, (i & 4) != 0);
    }

    public DialogProperties(boolean z, boolean z2, boolean z3) {
        this(z, z2, SecureFlagPolicy.Inherit, z3);
    }
}
