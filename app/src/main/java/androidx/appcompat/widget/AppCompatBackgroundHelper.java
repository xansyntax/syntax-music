package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.EmojiProcessor;
import java.util.WeakHashMap;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatBackgroundHelper {
    public ConnectionSpec.Builder mBackgroundTint;
    public ConnectionSpec.Builder mInternalBackgroundTint;
    public ConnectionSpec.Builder mTmpInfo;
    public final View mView;
    public int mBackgroundResId = -1;
    public final AppCompatDrawableManager mDrawableManager = AppCompatDrawableManager.get();

    public AppCompatBackgroundHelper(View view) {
        this.mView = view;
    }

    public final void applySupportBackgroundTint() {
        View view = this.mView;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.mInternalBackgroundTint != null) {
                ConnectionSpec.Builder builder = this.mTmpInfo;
                if (builder == null) {
                    builder = new ConnectionSpec.Builder();
                    this.mTmpInfo = builder;
                }
                builder.cipherSuites = null;
                builder.supportsTlsExtensions = false;
                builder.tlsVersions = null;
                builder.tls = false;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    builder.supportsTlsExtensions = true;
                    builder.cipherSuites = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    builder.tls = true;
                    builder.tlsVersions = backgroundTintMode;
                }
                if (builder.supportsTlsExtensions || builder.tls) {
                    int[] drawableState = view.getDrawableState();
                    PorterDuff.Mode mode = AppCompatDrawableManager.DEFAULT_MODE;
                    ResourceManagerInternal.tintDrawable(background, builder, drawableState);
                    return;
                }
            }
            ConnectionSpec.Builder builder2 = this.mBackgroundTint;
            if (builder2 != null) {
                int[] drawableState2 = view.getDrawableState();
                PorterDuff.Mode mode2 = AppCompatDrawableManager.DEFAULT_MODE;
                ResourceManagerInternal.tintDrawable(background, builder2, drawableState2);
            } else {
                ConnectionSpec.Builder builder3 = this.mInternalBackgroundTint;
                if (builder3 != null) {
                    int[] drawableState3 = view.getDrawableState();
                    PorterDuff.Mode mode3 = AppCompatDrawableManager.DEFAULT_MODE;
                    ResourceManagerInternal.tintDrawable(background, builder3, drawableState3);
                }
            }
        }
    }

    public final ColorStateList getSupportBackgroundTintList() {
        ConnectionSpec.Builder builder = this.mBackgroundTint;
        if (builder != null) {
            return (ColorStateList) builder.cipherSuites;
        }
        return null;
    }

    public final PorterDuff.Mode getSupportBackgroundTintMode() {
        ConnectionSpec.Builder builder = this.mBackgroundTint;
        if (builder != null) {
            return (PorterDuff.Mode) builder.tlsVersions;
        }
        return null;
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        ColorStateList tintList;
        View view = this.mView;
        Context context = view.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        EmojiProcessor emojiProcessorObtainStyledAttributes = EmojiProcessor.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo;
        View view2 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(view2, view2.getContext(), iArr, attributeSet, (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo, i);
        try {
            if (typedArray.hasValue(0)) {
                this.mBackgroundResId = typedArray.getResourceId(0, -1);
                AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
                Context context2 = view.getContext();
                int i2 = this.mBackgroundResId;
                synchronized (appCompatDrawableManager) {
                    tintList = appCompatDrawableManager.mResourceManager.getTintList(context2, i2);
                }
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            if (typedArray.hasValue(1)) {
                view.setBackgroundTintList(emojiProcessorObtainStyledAttributes.getColorStateList(1));
            }
            if (typedArray.hasValue(2)) {
                view.setBackgroundTintMode(DrawableUtils.parseTintMode(typedArray.getInt(2, -1), null));
            }
            emojiProcessorObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            emojiProcessorObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void onSetBackgroundDrawable() {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public final void onSetBackgroundResource(int i) {
        ColorStateList tintList;
        this.mBackgroundResId = i;
        AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
        if (appCompatDrawableManager != null) {
            Context context = this.mView.getContext();
            synchronized (appCompatDrawableManager) {
                tintList = appCompatDrawableManager.mResourceManager.getTintList(context, i);
            }
        } else {
            tintList = null;
        }
        setInternalBackgroundTint(tintList);
        applySupportBackgroundTint();
    }

    public final void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            ConnectionSpec.Builder builder = this.mInternalBackgroundTint;
            if (builder == null) {
                builder = new ConnectionSpec.Builder();
                this.mInternalBackgroundTint = builder;
            }
            builder.cipherSuites = colorStateList;
            builder.supportsTlsExtensions = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ConnectionSpec.Builder builder = this.mBackgroundTint;
        if (builder == null) {
            builder = new ConnectionSpec.Builder();
            this.mBackgroundTint = builder;
        }
        builder.cipherSuites = colorStateList;
        builder.supportsTlsExtensions = true;
        applySupportBackgroundTint();
    }

    public final void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ConnectionSpec.Builder builder = this.mBackgroundTint;
        if (builder == null) {
            builder = new ConnectionSpec.Builder();
            this.mBackgroundTint = builder;
        }
        builder.tlsVersions = mode;
        builder.tls = true;
        applySupportBackgroundTint();
    }
}
