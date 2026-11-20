package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import coil3.size.SizeKt;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mHasLevel;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasLevel = false;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, i);
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.mImageHelper = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.applySupportImageTint();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintMode();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        ConnectionSpec.Builder builder;
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper == null || (builder = appCompatImageHelper.mImageTint) == null) {
            return null;
        }
        return (ColorStateList) builder.cipherSuites;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        ConnectionSpec.Builder builder;
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper == null || (builder = appCompatImageHelper.mImageTint) == null) {
            return null;
        }
        return (PorterDuff.Mode) builder.tlsVersions;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return !(this.mImageHelper.mView.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.applySupportImageTint();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null && drawable != null && !this.mHasLevel) {
            appCompatImageHelper.mLevel = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        AppCompatImageHelper appCompatImageHelper2 = this.mImageHelper;
        if (appCompatImageHelper2 != null) {
            appCompatImageHelper2.applySupportImageTint();
            if (this.mHasLevel) {
                return;
            }
            AppCompatImageHelper appCompatImageHelper3 = this.mImageHelper;
            ImageView imageView = appCompatImageHelper3.mView;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(appCompatImageHelper3.mLevel);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            ImageView imageView = appCompatImageHelper.mView;
            if (i != 0) {
                Drawable drawable = SizeKt.getDrawable(imageView.getContext(), i);
                if (drawable != null) {
                    DrawableUtils.fixDrawable(drawable);
                }
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setImageDrawable(null);
            }
            appCompatImageHelper.applySupportImageTint();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.applySupportImageTint();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            ConnectionSpec.Builder builder = appCompatImageHelper.mImageTint;
            if (builder == null) {
                builder = new ConnectionSpec.Builder();
                appCompatImageHelper.mImageTint = builder;
            }
            builder.cipherSuites = colorStateList;
            builder.supportsTlsExtensions = true;
            appCompatImageHelper.applySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            ConnectionSpec.Builder builder = appCompatImageHelper.mImageTint;
            if (builder == null) {
                builder = new ConnectionSpec.Builder();
                appCompatImageHelper.mImageTint = builder;
            }
            builder.tlsVersions = mode;
            builder.tls = true;
            appCompatImageHelper.applySupportImageTint();
        }
    }
}
