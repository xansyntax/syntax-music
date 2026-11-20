package coil3.transition;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadeDrawable extends Drawable implements Drawable.Callback, Animatable {
    public final ArrayList callbacks = new ArrayList();
    public final int durationMillis;
    public final Drawable end;
    public final boolean fadeStart;
    public final int intrinsicHeight;
    public final int intrinsicWidth;
    public int maxAlpha;
    public final Scale scale;
    public Drawable start;
    public long startTimeMillis;
    public byte state;

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale, int i, boolean z) {
        this.scale = scale;
        this.durationMillis = i;
        this.fadeStart = z;
        this.intrinsicWidth = computeIntrinsicDimension(drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicWidth()) : null);
        this.intrinsicHeight = computeIntrinsicDimension(drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicHeight()) : null);
        this.maxAlpha = 255;
        this.start = drawable != null ? drawable.mutate() : null;
        Drawable drawableMutate = drawable2 != null ? drawable2.mutate() : null;
        this.end = drawableMutate;
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("durationMillis must be > 0.");
            throw null;
        }
        Drawable drawable3 = this.start;
        if (drawable3 != null) {
            drawable3.setCallback(this);
        }
        if (drawableMutate != null) {
            drawableMutate.setCallback(this);
        }
    }

    public final int computeIntrinsicDimension(Integer num, Integer num2) {
        if (num != null && num.intValue() == -1) {
            return -1;
        }
        if (num2 != null && num2.intValue() == -1) {
            return -1;
        }
        return Math.max(num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable;
        byte b = this.state;
        if (b == 0) {
            Drawable drawable2 = this.start;
            if (drawable2 != null) {
                drawable2.setAlpha(this.maxAlpha);
                int iSave = canvas.save();
                try {
                    drawable2.draw(canvas);
                    return;
                } finally {
                    canvas.restoreToCount(iSave);
                }
            }
            return;
        }
        Drawable drawable3 = this.end;
        if (b == 2) {
            if (drawable3 != null) {
                drawable3.setAlpha(this.maxAlpha);
                int iSave2 = canvas.save();
                try {
                    drawable3.draw(canvas);
                    return;
                } finally {
                    canvas.restoreToCount(iSave2);
                }
            }
            return;
        }
        double dUptimeMillis = (SystemClock.uptimeMillis() - this.startTimeMillis) / ((double) this.durationMillis);
        double dCoerceIn = UuidKt.coerceIn(dUptimeMillis, 0.0d, 1.0d);
        int i = this.maxAlpha;
        int i2 = (int) (dCoerceIn * ((double) i));
        if (this.fadeStart) {
            i -= i2;
        }
        boolean z = dUptimeMillis >= 1.0d;
        if (!z && (drawable = this.start) != null) {
            drawable.setAlpha(i);
            int iSave3 = canvas.save();
            try {
                drawable.draw(canvas);
                canvas.restoreToCount(iSave3);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave3);
                throw th;
            }
        }
        if (drawable3 != null) {
            drawable3.setAlpha(i2);
            int iSave4 = canvas.save();
            try {
                drawable3.draw(canvas);
                canvas.restoreToCount(iSave4);
            } catch (Throwable th2) {
                canvas.restoreToCount(iSave4);
                throw th2;
            }
        }
        if (!z) {
            invalidateSelf();
            return;
        }
        this.state = (byte) 2;
        this.start = null;
        ArrayList arrayList = this.callbacks;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        PathKt$$ExternalSyntheticBUOutline0.m();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.maxAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        byte b = this.state;
        if (b == 0) {
            Drawable drawable = this.start;
            if (drawable != null) {
                return drawable.getColorFilter();
            }
            return null;
        }
        Drawable drawable2 = this.end;
        if (b != 1) {
            if (b == 2 && drawable2 != null) {
                return drawable2.getColorFilter();
            }
            return null;
        }
        if (drawable2 != null && (colorFilter = drawable2.getColorFilter()) != null) {
            return colorFilter;
        }
        Drawable drawable3 = this.start;
        if (drawable3 != null) {
            return drawable3.getColorFilter();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.intrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.intrinsicWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.start;
        byte b = this.state;
        if (b == 0) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        }
        Drawable drawable2 = this.end;
        if (b == 2) {
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        }
        if (drawable != null && drawable2 != null) {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        }
        if (drawable != null) {
            return drawable.getOpacity();
        }
        if (drawable2 != null) {
            return drawable2.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.state == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.start;
        if (drawable != null ? drawable.isStateful() : false) {
            return true;
        }
        Drawable drawable2 = this.end;
        return drawable2 != null ? drawable2.isStateful() : false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.start;
        if (drawable != null) {
            updateBounds$io_coil_kt_coil3_coil_core(drawable, rect);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            updateBounds$io_coil_kt_coil3_coil_core(drawable2, rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.start;
        boolean level = drawable != null ? drawable.setLevel(i) : false;
        Drawable drawable2 = this.end;
        return level || (drawable2 != null ? drawable2.setLevel(i) : false);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.start;
        boolean state = drawable != null ? drawable.setState(iArr) : false;
        Drawable drawable2 = this.end;
        return state || (drawable2 != null ? drawable2.setState(iArr) : false);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (i < 0 || i >= 256) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Invalid alpha: "));
        } else {
            this.maxAlpha = i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTint(i);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.start;
        boolean z3 = drawable != null && drawable.setVisible(z, z2);
        Drawable drawable2 = this.end;
        return visible || z3 || (drawable2 != null && drawable2.setVisible(z, z2));
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Object obj = this.start;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.start();
        }
        Object obj2 = this.end;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.start();
        }
        if (this.state != 0) {
            return;
        }
        this.state = (byte) 1;
        this.startTimeMillis = SystemClock.uptimeMillis();
        ArrayList arrayList = this.callbacks;
        if (arrayList.size() <= 0) {
            invalidateSelf();
        } else {
            arrayList.get(0).getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Object obj = this.start;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.stop();
        }
        Object obj2 = this.end;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.stop();
        }
        if (this.state != 2) {
            this.state = (byte) 2;
            this.start = null;
            ArrayList arrayList = this.callbacks;
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public final void updateBounds$io_coil_kt_coil3_coil_core(Drawable drawable, Rect rect) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        double dComputeSizeMultiplier = SizeKt.computeSizeMultiplier(intrinsicWidth, intrinsicHeight, iWidth, iHeight, this.scale, Size.ORIGINAL);
        int iRoundToInt = MathKt.roundToInt(IntIntPair$$ExternalSyntheticOutline0.m(dComputeSizeMultiplier, intrinsicWidth, iWidth, 2.0d));
        int iRoundToInt2 = MathKt.roundToInt(IntIntPair$$ExternalSyntheticOutline0.m(dComputeSizeMultiplier, intrinsicHeight, iHeight, 2.0d));
        drawable.setBounds(rect.left + iRoundToInt, rect.top + iRoundToInt2, rect.right - iRoundToInt, rect.bottom - iRoundToInt2);
    }
}
