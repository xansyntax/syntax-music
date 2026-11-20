package androidx.compose.ui.graphics.drawscope;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Stroke extends DrawStyle {
    public final int cap;
    public final int join;
    public final float miter;
    public final float width;

    public Stroke(float f, float f2, int i, int i2, int i3) {
        f = (i3 & 1) != 0 ? CropImageView.DEFAULT_ASPECT_RATIO : f;
        f2 = (i3 & 2) != 0 ? 4.0f : f2;
        i = (i3 & 4) != 0 ? 0 : i;
        i2 = (i3 & 8) != 0 ? 0 : i2;
        this.width = f;
        this.miter = f2;
        this.cap = i;
        this.join = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) obj;
        return this.width == stroke.width && this.miter == stroke.miter && this.cap == stroke.cap && this.join == stroke.join;
    }

    public final int hashCode() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.join, IntIntPair$$ExternalSyntheticOutline0.m(this.cap, IntIntPair$$ExternalSyntheticOutline0.m(this.miter, Float.hashCode(this.width) * 31, 31), 31), 31);
    }

    public final String toString() {
        String str;
        String str2 = "Unknown";
        int i = this.cap;
        if (i == 0) {
            str = "Butt";
        } else if (i == 1) {
            str = "Round";
        } else {
            str = i == 2 ? "Square" : "Unknown";
        }
        int i2 = this.join;
        if (i2 == 0) {
            str2 = "Miter";
        } else if (i2 == 1) {
            str2 = "Round";
        } else if (i2 == 2) {
            str2 = "Bevel";
        }
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Stroke(width=", this.width, ", miter=", this.miter, ", cap="), str, ", join=", str2, ", pathEffect=null)");
    }
}
