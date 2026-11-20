package androidx.compose.foundation.layout;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidWindowInsets implements WindowInsets {
    public final ParcelableSnapshotMutableState insets$delegate = Stack.mutableStateOf$default(Insets.NONE);
    public final ParcelableSnapshotMutableState isVisible$delegate = Stack.mutableStateOf$default(Boolean.TRUE);
    public final String name;
    public final short type;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidWindowInsets(int i, String str) {
        this.type = i;
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AndroidWindowInsets) {
            return this.type == ((AndroidWindowInsets) obj).type;
        }
        return false;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        return getInsets$foundation_layout().bottom;
    }

    public final Insets getInsets$foundation_layout() {
        return (Insets) this.insets$delegate.getValue();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        return getInsets$foundation_layout().left;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        return getInsets$foundation_layout().right;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        return getInsets$foundation_layout().top;
    }

    public final int hashCode() {
        return this.type;
    }

    public final void setVisible(boolean z) {
        this.isVisible$delegate.setValue(Boolean.valueOf(z));
    }

    public final String toString() {
        return this.name + "(" + getInsets$foundation_layout().left + ", " + getInsets$foundation_layout().top + ", " + getInsets$foundation_layout().right + ", " + getInsets$foundation_layout().bottom + ")";
    }

    public final void update$foundation_layout(WindowInsetsCompat windowInsetsCompat, int i) {
        short s = this.type;
        if (i == 0 || (i & s) != 0) {
            this.insets$delegate.setValue(windowInsetsCompat.mImpl.getInsets(s));
            setVisible(windowInsetsCompat.mImpl.isVisible(s));
        }
    }
}
