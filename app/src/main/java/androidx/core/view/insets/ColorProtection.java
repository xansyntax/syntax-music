package androidx.core.view.insets;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.graphics.Insets;
import androidx.core.provider.CallbackWrapper;
import com.yalantis.ucrop.view.CropImageView;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorProtection {
    public final Protection$Attributes mAttributes;
    public int mColor;
    public ProtectionGroup mController;
    public final ColorDrawable mDrawable;
    public boolean mHasColor;
    public Insets mInsets;
    public Insets mInsetsIgnoringVisibility;
    public final byte mSide;

    static {
        new PathInterpolator(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        new PathInterpolator(0.6f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        new PathInterpolator(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0.2f, 1.0f);
        new PathInterpolator(0.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ColorProtection(int i, int i2) {
        Protection$Attributes protection$Attributes = new Protection$Attributes();
        protection$Attributes.mWidth = -1;
        protection$Attributes.mHeight = -1;
        Insets insets = Insets.NONE;
        protection$Attributes.mMargin = insets;
        protection$Attributes.mVisible = false;
        protection$Attributes.mDrawable = null;
        protection$Attributes.mTranslationX = CropImageView.DEFAULT_ASPECT_RATIO;
        protection$Attributes.mTranslationY = CropImageView.DEFAULT_ASPECT_RATIO;
        protection$Attributes.mAlpha = 1.0f;
        this.mAttributes = protection$Attributes;
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets;
        this.mController = null;
        if (i != 1 && i != 2 && i != 4 && i != 8) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unexpected side: "));
            throw null;
        }
        this.mSide = i;
        ColorDrawable colorDrawable = new ColorDrawable();
        this.mDrawable = colorDrawable;
        this.mColor = 0;
        this.mHasColor = true;
        if (i2 != 0) {
            this.mColor = i2;
            colorDrawable.setColor(i2);
            protection$Attributes.mDrawable = colorDrawable;
            CallbackWrapper callbackWrapper = protection$Attributes.mCallback;
            if (callbackWrapper != null) {
                ((View) callbackWrapper.mExecutor).setBackground(colorDrawable);
            }
        }
    }

    public final void setSystemAlpha(float f) {
        float f2 = f * 1.0f;
        Protection$Attributes protection$Attributes = this.mAttributes;
        if (protection$Attributes.mAlpha != f2) {
            protection$Attributes.mAlpha = f2;
            CallbackWrapper callbackWrapper = protection$Attributes.mCallback;
            if (callbackWrapper != null) {
                ((View) callbackWrapper.mExecutor).setAlpha(f2);
            }
        }
    }

    public final void setSystemInsetAmount(float f) {
        float f2 = f * 1.0f;
        Protection$Attributes protection$Attributes = this.mAttributes;
        byte b = this.mSide;
        if (b == 1) {
            float f3 = (-(1.0f - f2)) * protection$Attributes.mWidth;
            if (protection$Attributes.mTranslationX != f3) {
                protection$Attributes.mTranslationX = f3;
                CallbackWrapper callbackWrapper = protection$Attributes.mCallback;
                if (callbackWrapper != null) {
                    ((View) callbackWrapper.mExecutor).setTranslationX(f3);
                    return;
                }
                return;
            }
            return;
        }
        if (b == 2) {
            float f4 = (-(1.0f - f2)) * protection$Attributes.mHeight;
            if (protection$Attributes.mTranslationY != f4) {
                protection$Attributes.mTranslationY = f4;
                CallbackWrapper callbackWrapper2 = protection$Attributes.mCallback;
                if (callbackWrapper2 != null) {
                    ((View) callbackWrapper2.mExecutor).setTranslationY(f4);
                    return;
                }
                return;
            }
            return;
        }
        if (b == 4) {
            float f5 = (1.0f - f2) * protection$Attributes.mWidth;
            if (protection$Attributes.mTranslationX != f5) {
                protection$Attributes.mTranslationX = f5;
                CallbackWrapper callbackWrapper3 = protection$Attributes.mCallback;
                if (callbackWrapper3 != null) {
                    ((View) callbackWrapper3.mExecutor).setTranslationX(f5);
                    return;
                }
                return;
            }
            return;
        }
        if (b != 8) {
            return;
        }
        float f6 = (1.0f - f2) * protection$Attributes.mHeight;
        if (protection$Attributes.mTranslationY != f6) {
            protection$Attributes.mTranslationY = f6;
            CallbackWrapper callbackWrapper4 = protection$Attributes.mCallback;
            if (callbackWrapper4 != null) {
                ((View) callbackWrapper4.mExecutor).setTranslationY(f6);
            }
        }
    }
}
