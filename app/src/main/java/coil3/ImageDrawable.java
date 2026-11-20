package coil3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageDrawable extends Drawable {
    public final /* synthetic */ byte $r8$classId;
    public final Object image;

    public /* synthetic */ ImageDrawable(byte b, Object obj) {
        this.$r8$classId = b;
        this.image = obj;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        byte b = this.$r8$classId;
        Object obj = this.image;
        switch (b) {
            case 0:
                ((Image) obj).draw(canvas);
                break;
            default:
                ActionBarContainer actionBarContainer = (ActionBarContainer) obj;
                if (actionBarContainer.mIsSplit) {
                    Drawable drawable = actionBarContainer.mSplitBackground;
                    if (drawable != null) {
                        drawable.draw(canvas);
                    }
                    break;
                } else {
                    Drawable drawable2 = actionBarContainer.mBackground;
                    if (drawable2 != null) {
                        drawable2.draw(canvas);
                    }
                    Drawable drawable3 = actionBarContainer.mStackedBackground;
                    if (drawable3 != null && actionBarContainer.mIsStacked) {
                        drawable3.draw(canvas);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        switch (this.$r8$classId) {
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        switch (this.$r8$classId) {
            case 1:
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.image;
                if (!actionBarContainer.mIsSplit) {
                    Drawable drawable = actionBarContainer.mBackground;
                    if (drawable != null) {
                        drawable.getOutline(outline);
                    }
                } else if (actionBarContainer.mSplitBackground != null) {
                    actionBarContainer.mBackground.getOutline(outline);
                }
                break;
            default:
                super.getOutline(outline);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        byte b = this.$r8$classId;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        byte b = this.$r8$classId;
    }

    private final void setAlpha$androidx$appcompat$widget$ActionBarBackgroundDrawable(int i) {
    }

    private final void setAlpha$coil3$ImageDrawable(int i) {
    }

    private final void setColorFilter$androidx$appcompat$widget$ActionBarBackgroundDrawable(ColorFilter colorFilter) {
    }

    private final void setColorFilter$coil3$ImageDrawable(ColorFilter colorFilter) {
    }
}
