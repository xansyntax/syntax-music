package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Outline$Rounded extends ColorKt {
    public final RoundRect roundRect;
    public final AndroidPath roundRectPath;

    public Outline$Rounded(RoundRect roundRect) {
        AndroidPath androidPathPath;
        this.roundRect = roundRect;
        if (MathKt.isSimple(roundRect)) {
            androidPathPath = null;
        } else {
            androidPathPath = AndroidPath_androidKt.Path();
            AndroidPath.addRoundRect$default(androidPathPath, roundRect);
        }
        this.roundRectPath = androidPathPath;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Outline$Rounded) {
            return this.roundRect.equals(((Outline$Rounded) obj).roundRect);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.ColorKt
    public final Rect getBounds() {
        RoundRect roundRect = this.roundRect;
        return new Rect(roundRect.left, roundRect.top, roundRect.right, roundRect.bottom);
    }

    public final int hashCode() {
        return this.roundRect.hashCode();
    }
}
