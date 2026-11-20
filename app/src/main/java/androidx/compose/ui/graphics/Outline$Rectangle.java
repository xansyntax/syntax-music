package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Outline$Rectangle extends ColorKt {
    public final Rect rect;

    public Outline$Rectangle(Rect rect) {
        this.rect = rect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Outline$Rectangle) {
            return Intrinsics.areEqual(this.rect, ((Outline$Rectangle) obj).rect);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.ColorKt
    public final Rect getBounds() {
        return this.rect;
    }

    public final int hashCode() {
        return this.rect.hashCode();
    }
}
