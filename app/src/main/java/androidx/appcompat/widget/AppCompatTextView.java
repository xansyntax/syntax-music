package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.compose.ui.draw.DrawResult;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.widget.TextViewCompat$Api34Impl;
import androidx.core.widget.TextViewCompat$OreoCallback;
import androidx.sqlite.SQLite;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView {
    private static final String TAG = "AppCompatTextView";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private AppCompatEmojiTextHelper mEmojiTextViewHelper;
    private AppCompatTextHelper.FontVariationSettingsManager mFontVariationSettingsManager;
    private boolean mIsSetTypefaceProcessing;
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SuperCaller {
        void setFirstBaselineToTopHeight(int i);

        void setLastBaselineToBottomHeight(int i);

        void setLineHeight(int i, float f);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class SuperCallerApi28 extends DrawResult {
        public SuperCallerApi28() {
            super((byte) 6, (Object) AppCompatTextView.this);
        }

        @Override // androidx.compose.ui.draw.DrawResult, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void setFirstBaselineToTopHeight(int i) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i);
        }

        @Override // androidx.compose.ui.draw.DrawResult, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void setLastBaselineToBottomHeight(int i) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SuperCallerApi34 extends SuperCallerApi28 {
        public SuperCallerApi34() {
            super();
        }

        @Override // androidx.compose.ui.draw.DrawResult, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void setLineHeight(int i, float f) {
            AppCompatTextView.super.setLineHeight(i, f);
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, i);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i);
        appCompatTextHelper.applyCompoundDrawablesTints();
        AppCompatTextClassifierHelper appCompatTextClassifierHelper = new AppCompatTextClassifierHelper();
        appCompatTextClassifierHelper.mTextView = this;
        this.mTextClassifierHelper = appCompatTextClassifierHelper;
        getEmojiTextViewHelper().loadFromAttributes(attributeSet, i);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        AppCompatEmojiTextHelper appCompatEmojiTextHelper = this.mEmojiTextViewHelper;
        if (appCompatEmojiTextHelper != null) {
            return appCompatEmojiTextHelper;
        }
        AppCompatEmojiTextHelper appCompatEmojiTextHelper2 = new AppCompatEmojiTextHelper(this);
        this.mEmojiTextViewHelper = appCompatEmojiTextHelper2;
        return appCompatEmojiTextHelper2;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
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
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
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
        AppCompatTextHelper.FontVariationSettingsManager fontVariationSettingsManager2 = new AppCompatTextHelper.FontVariationSettingsManager(this, new AppCompatButton$$ExternalSyntheticLambda0(this, (byte) 2));
        this.mFontVariationSettingsManager = fontVariationSettingsManager2;
        return fontVariationSettingsManager2;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public SuperCaller getSuperCaller() {
        SuperCaller superCaller = this.mSuperCaller;
        if (superCaller != null) {
            return superCaller;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            SuperCallerApi34 superCallerApi34 = new SuperCallerApi34();
            this.mSuperCaller = superCallerApi34;
            return superCallerApi34;
        }
        if (i >= 28) {
            SuperCallerApi28 superCallerApi28 = new SuperCallerApi28();
            this.mSuperCaller = superCallerApi28;
            return superCallerApi28;
        }
        DrawResult drawResult = new DrawResult((byte) 6, (Object) this);
        this.mSuperCaller = drawResult;
        return drawResult;
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
    public CharSequence getText() {
        Future<PrecomputedTextCompat> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                IntMath.getTextMetricsParams(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = appCompatTextClassifierHelper.mTextClassifier;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) appCompatTextClassifierHelper.mTextView.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return IntMath.getTextMetricsParams(this);
    }

    @Override // android.widget.TextView
    public Typeface getTypeface() {
        return getFontVariationSettingsManager().mOriginalTypeface;
    }

    public boolean isEmojiCompatEnabled() {
        return ((FileSystemsKt) getEmojiTextViewHelper().mEmojiTextViewHelper.delegate).isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.getClass();
        if (Build.VERSION.SDK_INT < 30 && inputConnectionOnCreateInputConnection != null) {
            SQLite.setInitialSurroundingText(editorInfo, getText());
        }
        IntMath.onCreateInputConnection(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null || ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return;
        }
        appCompatTextHelper.mAutoSizeTextHelper.autoSizeText();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Future<PrecomputedTextCompat> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                IntMath.getTextMetricsParams(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null || ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE || !appCompatTextHelper.mAutoSizeTextHelper.isAutoSizeEnabled()) {
            return;
        }
        this.mTextHelper.mAutoSizeTextHelper.autoSizeText();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
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
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
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
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? SizeKt.getDrawable(context, i) : null, i2 != 0 ? SizeKt.getDrawable(context, i2) : null, i3 != 0 ? SizeKt.getDrawable(context, i3) : null, i4 != 0 ? SizeKt.getDrawable(context, i4) : null);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? SizeKt.getDrawable(context, i) : null, i2 != 0 ? SizeKt.getDrawable(context, i2) : null, i3 != 0 ? SizeKt.getDrawable(context, i3) : null, i4 != 0 ? SizeKt.getDrawable(context, i4) : null);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
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
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().setFirstBaselineToTopHeight(i);
        } else {
            IntMath.setFirstBaselineToTopHeight(this, i);
        }
    }

    @Override // android.widget.TextView
    public boolean setFontVariationSettings(String str) {
        return getFontVariationSettingsManager().setFontVariationSettings(str);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().setLastBaselineToBottomHeight(i);
        } else {
            IntMath.setLastBaselineToBottomHeight(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i, float f) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            getSuperCaller().setLineHeight(i, f);
        } else if (i2 >= 34) {
            TextViewCompat$Api34Impl.setLineHeight(this, i, f);
        } else {
            IntMath.setLineHeight(this, Math.round(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics())));
        }
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        IntMath.getTextMetricsParams(this);
        throw null;
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
        this.mTextHelper.setCompoundDrawableTintList(colorStateList);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.setCompoundDrawableTintMode(mode);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            appCompatTextClassifierHelper.mTextClassifier = textClassifier;
        }
    }

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params params) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = params.mTextDir;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i = 7;
            }
        }
        setTextDirection(i);
        getPaint().set(params.mPaint);
        setBreakStrategy(params.mBreakStrategy);
        setHyphenationFrequency(params.mHyphenationFrequency);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
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
    public void setTypeface(Typeface typeface, int i) {
        if (this.mIsSetTypefaceProcessing) {
            return;
        }
        if (typeface != null && i > 0) {
            Context context = getContext();
            SizeKt sizeKt = TypefaceCompat.sTypefaceCompatImpl;
            if (context == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Context cannot be null");
                return;
            }
            typeface = Typeface.create(typeface, i);
        }
        this.mIsSetTypefaceProcessing = true;
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.mIsSetTypefaceProcessing = false;
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        IntMath.setLineHeight(this, i);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        AppCompatTextHelper.FontVariationSettingsManager fontVariationSettingsManager = getFontVariationSettingsManager();
        fontVariationSettingsManager.mOriginalTypeface = typeface;
        fontVariationSettingsManager.mLastKnownTypefaceSetOnPaint = typeface;
        fontVariationSettingsManager.mTypefaceSetter.accept(typeface);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }
}
