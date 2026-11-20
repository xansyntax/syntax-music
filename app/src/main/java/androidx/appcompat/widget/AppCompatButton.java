package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.widget.TextViewCompat$OreoCallback;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatButton extends Button {
    public AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public AppCompatTextHelper.FontVariationSettingsManager mFontVariationSettingsManager;
    public final AppCompatTextHelper mTextHelper;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, R.attr.buttonStyle);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, R.attr.buttonStyle);
        appCompatTextHelper.applyCompoundDrawablesTints();
        getEmojiTextViewHelper().loadFromAttributes(attributeSet, R.attr.buttonStyle);
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

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return Math.round(appCompatTextHelper.mAutoSizeTextHelper.mAutoSizeMaxTextSizeInPx);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return Math.round(appCompatTextHelper.mAutoSizeTextHelper.mAutoSizeMinTextSizeInPx);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return Math.round(appCompatTextHelper.mAutoSizeTextHelper.mAutoSizeStepGranularityInPx);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        return appCompatTextHelper != null ? appCompatTextHelper.mAutoSizeTextHelper.mAutoSizeTextSizesInPx : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.mAutoSizeTextHelper.mAutoSizeTextType;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback customSelectionActionModeCallback = super.getCustomSelectionActionModeCallback();
        return customSelectionActionModeCallback instanceof TextViewCompat$OreoCallback ? ((TextViewCompat$OreoCallback) customSelectionActionModeCallback).mCallback : customSelectionActionModeCallback;
    }

    @Override // android.widget.TextView
    public String getFontVariationSettings() {
        return getFontVariationSettingsManager().mFontVariationSettings;
    }

    public AppCompatTextHelper.FontVariationSettingsManager getFontVariationSettingsManager() {
        AppCompatTextHelper.FontVariationSettingsManager fontVariationSettingsManager = this.mFontVariationSettingsManager;
        if (fontVariationSettingsManager != null) {
            return fontVariationSettingsManager;
        }
        AppCompatTextHelper.FontVariationSettingsManager fontVariationSettingsManager2 = new AppCompatTextHelper.FontVariationSettingsManager(this, new AppCompatButton$$ExternalSyntheticLambda0(this, (byte) 0));
        this.mFontVariationSettingsManager = fontVariationSettingsManager2;
        return fontVariationSettingsManager2;
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

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView
    public Typeface getTypeface() {
        return getFontVariationSettingsManager().mOriginalTypeface;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null || ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return;
        }
        appCompatTextHelper.mAutoSizeTextHelper.autoSizeText();
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = appCompatTextHelper.mAutoSizeTextHelper;
            if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE || !appCompatTextViewAutoSizeHelper.isAutoSizeEnabled()) {
                return;
            }
            appCompatTextViewAutoSizeHelper.autoSizeText();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.setAutoSizeTextTypeWithDefaults(i);
        }
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(IntMath.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((FileSystemsKt) getEmojiTextViewHelper().mEmojiTextViewHelper.delegate).getFilters(inputFilterArr));
    }

    @Override // android.widget.TextView
    public final boolean setFontVariationSettings(String str) {
        return getFontVariationSettingsManager().setFontVariationSettings(str);
    }

    public void setSupportAllCaps(boolean z) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.mView.setAllCaps(z);
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

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, i);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z = ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = appCompatTextHelper.mAutoSizeTextHelper;
            if (z || appCompatTextViewAutoSizeHelper.isAutoSizeEnabled()) {
                return;
            }
            appCompatTextViewAutoSizeHelper.setTextSizeInternal(i, f);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        AppCompatTextHelper.FontVariationSettingsManager fontVariationSettingsManager = getFontVariationSettingsManager();
        fontVariationSettingsManager.mOriginalTypeface = typeface;
        fontVariationSettingsManager.mLastKnownTypefaceSetOnPaint = typeface;
        fontVariationSettingsManager.mTypefaceSetter.accept(typeface);
    }
}
