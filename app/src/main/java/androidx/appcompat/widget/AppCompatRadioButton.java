package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatRadioButton extends RadioButton {
    public AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public final AppCompatCompoundButtonHelper mCompoundButtonHelper;
    public final AppCompatTextHelper mTextHelper;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.radioButtonStyle);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = new AppCompatCompoundButtonHelper(this);
        this.mCompoundButtonHelper = appCompatCompoundButtonHelper;
        appCompatCompoundButtonHelper.loadFromAttributes(attributeSet, R.attr.radioButtonStyle);
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, R.attr.radioButtonStyle);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().loadFromAttributes(attributeSet, R.attr.radioButtonStyle);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        AppCompatEmojiTextHelper appCompatEmojiTextHelper = this.mAppCompatEmojiTextHelper;
        if (appCompatEmojiTextHelper != null) {
            return appCompatEmojiTextHelper;
        }
        AppCompatEmojiTextHelper appCompatEmojiTextHelper2 = new AppCompatEmojiTextHelper(this);
        this.mAppCompatEmojiTextHelper = appCompatEmojiTextHelper2;
        return appCompatEmojiTextHelper2;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
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

    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.mButtonTintList;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.mButtonTintMode;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
        if (appCompatCompoundButtonHelper != null) {
            if (appCompatCompoundButtonHelper.mSkipNextApply) {
                appCompatCompoundButtonHelper.mSkipNextApply = false;
            } else {
                appCompatCompoundButtonHelper.mSkipNextApply = true;
                appCompatCompoundButtonHelper.applyButtonTint();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((FileSystemsKt) getEmojiTextViewHelper().mEmojiTextViewHelper.delegate).getFilters(inputFilterArr));
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

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.mButtonTintList = colorStateList;
            appCompatCompoundButtonHelper.mHasButtonTint = true;
            appCompatCompoundButtonHelper.applyButtonTint();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.mButtonTintMode = mode;
            appCompatCompoundButtonHelper.mHasButtonTintMode = true;
            appCompatCompoundButtonHelper.applyButtonTint();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintList(colorStateList);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintMode(mode);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(SizeKt.getDrawable(getContext(), i));
    }
}
