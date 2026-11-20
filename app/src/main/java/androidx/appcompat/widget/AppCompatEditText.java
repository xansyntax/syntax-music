package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat$OreoCallback;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.datastore.core.AtomicInt;
import androidx.sqlite.SQLite;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatEditText extends EditText {
    public final AppCompatProgressBarHelper mAppCompatEmojiEditTextHelper;
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    public AppCompatTextHelper.FontVariationSettingsManager mFontVariationSettingsManager;
    public SuperCaller mSuperCaller;
    public final AppCompatTextClassifierHelper mTextClassifierHelper;
    public final AppCompatTextHelper mTextHelper;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SuperCaller {
        public SuperCaller() {
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        appCompatTextHelper.applyCompoundDrawablesTints();
        AppCompatTextClassifierHelper appCompatTextClassifierHelper = new AppCompatTextClassifierHelper();
        appCompatTextClassifierHelper.mTextView = this;
        this.mTextClassifierHelper = appCompatTextClassifierHelper;
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.mAppCompatEmojiEditTextHelper = appCompatProgressBarHelper;
        appCompatProgressBarHelper.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        boolean zIsClickable = isClickable();
        boolean zIsLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener keyListener2 = appCompatProgressBarHelper.getKeyListener(keyListener);
        if (keyListener2 == keyListener) {
            return;
        }
        super.setKeyListener(keyListener2);
        setRawInputType(inputType);
        setFocusable(zIsFocusable);
        setClickable(zIsClickable);
        setLongClickable(zIsLongClickable);
    }

    private SuperCaller getSuperCaller() {
        SuperCaller superCaller = this.mSuperCaller;
        if (superCaller != null) {
            return superCaller;
        }
        SuperCaller superCaller2 = new SuperCaller();
        this.mSuperCaller = superCaller2;
        return superCaller2;
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
        AppCompatTextHelper.FontVariationSettingsManager fontVariationSettingsManager2 = new AppCompatTextHelper.FontVariationSettingsManager(this, new AppCompatButton$$ExternalSyntheticLambda0(this, (byte) 1));
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

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : getEditableText();
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

    @Override // android.widget.TextView
    public Typeface getTypeface() {
        return getFontVariationSettingsManager().mOriginalTypeface;
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] onReceiveContentMimeTypes;
        final InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.getClass();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 && inputConnectionOnCreateInputConnection != null) {
            SQLite.setInitialSurroundingText(editorInfo, getText());
        }
        IntMath.onCreateInputConnection(editorInfo, inputConnectionOnCreateInputConnection, this);
        if (inputConnectionOnCreateInputConnection != null && i <= 30 && (onReceiveContentMimeTypes = ViewCompat.getOnReceiveContentMimeTypes(this)) != null) {
            editorInfo.contentMimeTypes = onReceiveContentMimeTypes;
            final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 4, (Object) this);
            inputConnectionOnCreateInputConnection = new InputConnectionWrapper(inputConnectionOnCreateInputConnection) { // from class: androidx.core.view.inputmethod.InputConnectionCompat$1
                @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                public final boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
                    Bundle bundle2;
                    ContentInfoCompat.BuilderCompat scrollCapture;
                    AtomicInt atomicInt = inputContentInfo == null ? null : new AtomicInt(new AtomicInt(inputContentInfo));
                    AppCompatEditText appCompatEditText = (AppCompatEditText) onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.f$0;
                    if ((i2 & 1) != 0) {
                        try {
                            ((InputContentInfo) ((AtomicInt) atomicInt.delegate).delegate).requestPermission();
                            InputContentInfo inputContentInfo2 = (InputContentInfo) ((AtomicInt) atomicInt.delegate).delegate;
                            bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                            bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo2);
                        } catch (Exception e) {
                            Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                        }
                    } else {
                        bundle2 = bundle;
                    }
                    InputContentInfo inputContentInfo3 = (InputContentInfo) ((AtomicInt) atomicInt.delegate).delegate;
                    ClipData clipData = new ClipData(inputContentInfo3.getDescription(), new ClipData.Item(inputContentInfo3.getContentUri()));
                    if (Build.VERSION.SDK_INT >= 31) {
                        scrollCapture = new ScrollCapture(clipData, 2);
                    } else {
                        ContentInfoCompat.CompatImpl compatImpl = new ContentInfoCompat.CompatImpl();
                        compatImpl.mClip = clipData;
                        compatImpl.mSource = (byte) 2;
                        scrollCapture = compatImpl;
                    }
                    scrollCapture.setLinkUri(inputContentInfo3.getLinkUri());
                    scrollCapture.setExtras(bundle2);
                    if (ViewCompat.performReceiveContent(appCompatEditText, scrollCapture.build()) == null) {
                        return true;
                    }
                    return super.commitContent(inputContentInfo, i2, bundle);
                }
            };
        }
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        ContentInfoCompat.BuilderCompat scrollCapture;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                activity.requestDragAndDropPermissions(dragEvent);
                int offsetForPosition = getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
                beginBatchEdit();
                try {
                    Selection.setSelection((Spannable) getText(), offsetForPosition);
                    ClipData clipData = dragEvent.getClipData();
                    if (Build.VERSION.SDK_INT >= 31) {
                        scrollCapture = new ScrollCapture(clipData, 3);
                    } else {
                        ContentInfoCompat.CompatImpl compatImpl = new ContentInfoCompat.CompatImpl();
                        compatImpl.mClip = clipData;
                        compatImpl.mSource = (byte) 3;
                        scrollCapture = compatImpl;
                    }
                    ViewCompat.performReceiveContent(this, scrollCapture.build());
                    return true;
                } finally {
                    endBatchEdit();
                }
            }
        }
        return super.onDragEvent(dragEvent);
    }

    public final ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        this.mDefaultOnReceiveContentListener.getClass();
        return TextViewOnReceiveContentListener.onReceiveContent(this, contentInfoCompat);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        ContentInfoCompat.CompatImpl compatImpl;
        ContentInfoCompat.BuilderCompat builderCompat;
        int i2;
        ScrollCapture scrollCapture;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31 || ViewCompat.getOnReceiveContentMimeTypes(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i3 >= 31) {
                scrollCapture = new ScrollCapture(primaryClip, 1);
            } else {
                compatImpl = new ContentInfoCompat.CompatImpl();
                compatImpl.mClip = primaryClip;
                compatImpl.mSource = (byte) 1;
            }
            if (i == 16908322) {
                builderCompat = compatImpl;
                builderCompat = scrollCapture;
                i2 = 0;
            } else {
                builderCompat = compatImpl;
                builderCompat = scrollCapture;
                i2 = 1;
            }
            builderCompat.setFlags(i2);
            ViewCompat.performReceiveContent(this, builderCompat.build());
        }
        return true;
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(IntMath.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(z);
    }

    @Override // android.widget.TextView
    public final boolean setFontVariationSettings(String str) {
        return getFontVariationSettingsManager().setFontVariationSettings(str);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(keyListener));
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
    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            appCompatTextClassifierHelper.mTextClassifier = textClassifier;
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
