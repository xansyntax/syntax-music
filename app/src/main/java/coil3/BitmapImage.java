package coil3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapImage implements Image {
    public final Bitmap bitmap;

    public BitmapImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override // coil3.Image
    public final void draw(Canvas canvas) {
        canvas.drawBitmap(this.bitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Paint) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BitmapImage) && Intrinsics.areEqual(this.bitmap, ((BitmapImage) obj).bitmap);
    }

    @Override // coil3.Image
    public final int getHeight() {
        return this.bitmap.getHeight();
    }

    @Override // coil3.Image
    public final boolean getShareable() {
        return true;
    }

    @Override // coil3.Image
    public final long getSize() {
        int i;
        int allocationByteCount;
        Bitmap bitmap = this.bitmap;
        if (!bitmap.isRecycled()) {
            try {
                allocationByteCount = bitmap.getAllocationByteCount();
            } catch (Exception unused) {
                int height = bitmap.getHeight() * bitmap.getWidth();
                Bitmap.Config config = bitmap.getConfig();
                if (config == Bitmap.Config.ALPHA_8) {
                    i = 1;
                } else if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
                    i = 2;
                } else {
                    i = config == Bitmap.Config.RGBA_F16 ? 8 : 4;
                }
                allocationByteCount = i * height;
            }
            return allocationByteCount;
        }
        throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap + " [" + bitmap.getWidth() + " x " + bitmap.getHeight() + "] + " + bitmap.getConfig()).toString());
    }

    @Override // coil3.Image
    public final int getWidth() {
        return this.bitmap.getWidth();
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (this.bitmap.hashCode() * 31);
    }

    public final String toString() {
        return "BitmapImage(bitmap=" + this.bitmap + ", shareable=true)";
    }
}
