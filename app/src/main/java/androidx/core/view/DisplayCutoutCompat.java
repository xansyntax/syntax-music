package androidx.core.view;

import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.graphics.Insets;
import androidx.core.os.BuildCompat;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DisplayCutoutCompat {
    public final DisplayCutout mDisplayCutout;

    public DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.mDisplayCutout = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return this.mDisplayCutout.equals(((DisplayCutoutCompat) obj).mDisplayCutout);
    }

    public final Insets getWaterfallInsets() {
        return Build.VERSION.SDK_INT >= 30 ? Insets.toCompatInsets(BuildCompat.Api30Impl.getWaterfallInsets(this.mDisplayCutout)) : Insets.NONE;
    }

    public final int hashCode() {
        return this.mDisplayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }
}
