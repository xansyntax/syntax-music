package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Outline$Generic extends ColorKt {
    public final AndroidPath path;

    public Outline$Generic(AndroidPath androidPath) {
        this.path = androidPath;
    }

    @Override // androidx.compose.ui.graphics.ColorKt
    public final Rect getBounds() {
        return this.path.getBounds();
    }
}
