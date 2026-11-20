package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.fonts.FontVariationAxis;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.LruCache;
import androidx.core.app.NavUtils;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat$Api34Impl;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.util.TimedValueQueue;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Objects;
import okhttp3.ConnectionSpec;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatTextHelper {
    public boolean mAsyncFontPending;
    public final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    public ConnectionSpec.Builder mDrawableBottomTint;
    public ConnectionSpec.Builder mDrawableEndTint;
    public ConnectionSpec.Builder mDrawableLeftTint;
    public ConnectionSpec.Builder mDrawableRightTint;
    public ConnectionSpec.Builder mDrawableStartTint;
    public ConnectionSpec.Builder mDrawableTint;
    public ConnectionSpec.Builder mDrawableTopTint;
    public Typeface mFontTypeface;
    public final TextView mView;
    public int mStyle = 0;
    public int mFontWeight = -1;
    public String mFontVariationSettings = null;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api26Impl {
        public static Paint sPaint;
        public static final LruCache sVariationsCache = new LruCache(30);

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class VarCacheKey {
            public final String mFontVariationSettings;
            public final Typeface mTypeface;
            public final int mWeightAdjustment;

            public VarCacheKey(Typeface typeface, String str, int i) {
                this.mTypeface = typeface;
                this.mFontVariationSettings = str;
                this.mWeightAdjustment = i;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof VarCacheKey)) {
                    return false;
                }
                VarCacheKey varCacheKey = (VarCacheKey) obj;
                return this.mWeightAdjustment == varCacheKey.mWeightAdjustment && Objects.equals(this.mTypeface, varCacheKey.mTypeface) && Objects.equals(this.mFontVariationSettings, varCacheKey.mFontVariationSettings);
            }

            public final int hashCode() {
                return Objects.hash(this.mTypeface, this.mFontVariationSettings, Integer.valueOf(this.mWeightAdjustment));
            }
        }

        public static void setFontVariationSettings(TextView textView, String str) {
            if (Objects.equals(textView.getFontVariationSettings(), str)) {
                textView.setFontVariationSettings("");
            }
            textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FontVariationSettingsManager {
        public String mFontVariationSettings;
        public Typeface mLastKnownTypefaceSetOnPaint;
        public Typeface mOriginalTypeface;
        public final TextView mTextView;
        public final Consumer mTypefaceSetter;

        public FontVariationSettingsManager(TextView textView, Consumer consumer) {
            this.mTextView = textView;
            this.mTypefaceSetter = consumer;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        public final boolean setFontVariationSettings(String str) {
            int i;
            String fontVariationSettings;
            boolean z;
            FontVariationAxis[] fontVariationAxisArrFromFontVariationSettings;
            Typeface typeface = this.mOriginalTypeface;
            TextView textView = this.mTextView;
            TextPaint paint = textView.getPaint();
            if (this.mLastKnownTypefaceSetOnPaint != paint.getTypeface()) {
                Log.w("FontVarSettings", "getPaint().getTypeface() changed unexpectedly. App code should not modify the result of getPaint().");
                typeface = paint.getTypeface();
            }
            if (Build.VERSION.SDK_INT < 31 || (i = textView.getContext().getResources().getConfiguration().fontWeightAdjustment) == Integer.MAX_VALUE) {
                i = 0;
            }
            if (i == Integer.MAX_VALUE) {
                i = 0;
            }
            Api26Impl.VarCacheKey varCacheKey = new Api26Impl.VarCacheKey(typeface, str, i);
            LruCache lruCache = Api26Impl.sVariationsCache;
            Typeface typeface2 = (Typeface) lruCache.get(varCacheKey);
            if (typeface2 != null) {
                z = true;
            } else {
                Paint paint2 = Api26Impl.sPaint;
                if (paint2 == null) {
                    paint2 = new Paint();
                    Api26Impl.sPaint = paint2;
                }
                if (i != 0) {
                    if (TextUtils.isEmpty(str)) {
                        fontVariationAxisArrFromFontVariationSettings = new FontVariationAxis[0];
                    } else {
                        fontVariationAxisArrFromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(str);
                        if (fontVariationAxisArrFromFontVariationSettings == null) {
                            fontVariationSettings = str;
                            z = true;
                        }
                    }
                    int i2 = 0;
                    boolean z2 = false;
                    while (true) {
                        if (i2 >= fontVariationAxisArrFromFontVariationSettings.length) {
                            break;
                        }
                        FontVariationAxis fontVariationAxis = fontVariationAxisArrFromFontVariationSettings[i2];
                        if ("wght".equals(fontVariationAxis.getTag())) {
                            float styleValue = fontVariationAxis.getStyleValue() + i;
                            fontVariationAxisArrFromFontVariationSettings[i2] = new FontVariationAxis("wght", styleValue >= 1.0f ? Math.min(styleValue, 1000.0f) : 1.0f);
                            z2 = true;
                        }
                        i2++;
                    }
                    z = true;
                    if (!z2) {
                        FontVariationAxis[] fontVariationAxisArr = new FontVariationAxis[fontVariationAxisArrFromFontVariationSettings.length + 1];
                        System.arraycopy(fontVariationAxisArrFromFontVariationSettings, 0, fontVariationAxisArr, 0, fontVariationAxisArrFromFontVariationSettings.length);
                        float f = i + 400;
                        fontVariationAxisArr[fontVariationAxisArrFromFontVariationSettings.length] = new FontVariationAxis("wght", f >= 1.0f ? Math.min(f, 1000.0f) : 1.0f);
                        fontVariationAxisArrFromFontVariationSettings = fontVariationAxisArr;
                    }
                    fontVariationSettings = FontVariationAxis.toFontVariationSettings(fontVariationAxisArrFromFontVariationSettings);
                } else {
                    fontVariationSettings = str;
                    z = true;
                }
                if (Objects.equals(paint2.getFontVariationSettings(), fontVariationSettings)) {
                    paint2.setFontVariationSettings(null);
                }
                paint2.setTypeface(typeface);
                if (paint2.setFontVariationSettings(fontVariationSettings)) {
                    typeface2 = paint2.getTypeface();
                    lruCache.put(varCacheKey, typeface2);
                } else {
                    typeface2 = null;
                }
            }
            if (typeface2 == null) {
                return false;
            }
            this.mLastKnownTypefaceSetOnPaint = typeface2;
            this.mTypefaceSetter.accept(typeface2);
            this.mFontVariationSettings = str;
            return z;
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    public static ConnectionSpec.Builder createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList;
        synchronized (appCompatDrawableManager) {
            tintList = appCompatDrawableManager.mResourceManager.getTintList(context, i);
        }
        if (tintList == null) {
            return null;
        }
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
        builder.supportsTlsExtensions = true;
        builder.cipherSuites = tintList;
        return builder;
    }

    public final void applyCompoundDrawableTint(Drawable drawable, ConnectionSpec.Builder builder) {
        if (drawable == null || builder == null) {
            return;
        }
        int[] drawableState = this.mView.getDrawableState();
        PorterDuff.Mode mode = AppCompatDrawableManager.DEFAULT_MODE;
        ResourceManagerInternal.tintDrawable(drawable, builder, drawableState);
    }

    public final void applyCompoundDrawablesTints() {
        ConnectionSpec.Builder builder = this.mDrawableLeftTint;
        TextView textView = this.mView;
        if (builder != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint == null && this.mDrawableEndTint == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
    }

    public final void applyFontAndVariationSettings(boolean z) {
        Typeface typeface = this.mFontTypeface;
        TextView textView = this.mView;
        if (typeface != null) {
            if (this.mFontWeight == -1) {
                textView.setTypeface(typeface, this.mStyle);
            } else {
                textView.setTypeface(typeface);
            }
        } else if (z) {
            textView.setTypeface(null);
        }
        String str = this.mFontVariationSettings;
        if (str != null) {
            Api26Impl.setFontVariationSettings(textView, str);
        }
    }

    public final ColorStateList getCompoundDrawableTintList() {
        ConnectionSpec.Builder builder = this.mDrawableTint;
        if (builder != null) {
            return (ColorStateList) builder.cipherSuites;
        }
        return null;
    }

    public final PorterDuff.Mode getCompoundDrawableTintMode() {
        ConnectionSpec.Builder builder = this.mDrawableTint;
        if (builder != null) {
            return (PorterDuff.Mode) builder.tlsVersions;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:211:0x0366  */
    /* JADX WARN: Code duplicated, block: B:213:0x036b  */
    /* JADX WARN: Code duplicated, block: B:216:0x0372 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:217:0x0374  */
    /* JADX WARN: Code duplicated, block: B:219:0x0379  */
    /* JADX WARN: Code duplicated, block: B:221:0x037f  */
    /* JADX WARN: Code duplicated, block: B:223:0x0383  */
    /* JADX WARN: Code duplicated, block: B:226:? A[RETURN, SYNTHETIC] */
    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String string;
        float dimensionPixelSize;
        int i2;
        ColorStateList colorStateList;
        int resourceId;
        int i3;
        int resourceId2;
        TextView textView = this.mView;
        Context context = textView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        int[] iArr = R$styleable.AppCompatTextHelper;
        EmojiProcessor emojiProcessorObtainStyledAttributes = EmojiProcessor.obtainStyledAttributes(context, attributeSet, iArr, i);
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo, i);
        TypedArray typedArray = (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(2, 0));
        }
        if (typedArray.hasValue(5)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(6, 0));
        }
        emojiProcessorObtainStyledAttributes.recycle();
        boolean z3 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = R$styleable.TextAppearance;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            EmojiProcessor emojiProcessor = new EmojiProcessor(context, typedArrayObtainStyledAttributes);
            if (z3 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z = false;
                z2 = false;
            } else {
                z2 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z = true;
            }
            updateTypefaceAndStyle(context, emojiProcessor);
            string = typedArrayObtainStyledAttributes.hasValue(15) ? typedArrayObtainStyledAttributes.getString(15) : null;
            emojiProcessor.recycle();
        } else {
            z = false;
            z2 = false;
            string = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        EmojiProcessor emojiProcessor2 = new EmojiProcessor(context, typedArrayObtainStyledAttributes2);
        if (!z3 && typedArrayObtainStyledAttributes2.hasValue(14)) {
            z2 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z = true;
        }
        boolean z4 = z2;
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string = typedArrayObtainStyledAttributes2.getString(15);
        }
        if (Build.VERSION.SDK_INT >= 28 && typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, CropImageView.DEFAULT_ASPECT_RATIO);
        }
        updateTypefaceAndStyle(context, emojiProcessor2);
        emojiProcessor2.recycle();
        if (!z3 && z) {
            textView.setAllCaps(z4);
        }
        applyFontAndVariationSettings(false);
        if (string != null) {
            textView.setTextLocales(LocaleList.forLanguageTags(string));
        }
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        Context context2 = appCompatTextViewAutoSizeHelper.mContext;
        int[] iArr3 = R$styleable.AppCompatTextView;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i, 0);
        TextView textView2 = appCompatTextViewAutoSizeHelper.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr4[i4] = typedArrayObtainTypedArray.getDimensionPixelSize(i4, -1);
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArr4);
                appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
        } else if (appCompatTextViewAutoSizeHelper.mAutoSizeTextType == 1) {
            if (!appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i3 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i3 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i3, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(dimension2, dimension3, dimension);
            }
            appCompatTextViewAutoSizeHelper.setupAutoSizeText();
        }
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && appCompatTextViewAutoSizeHelper.mAutoSizeTextType != 0) {
            int[] iArr5 = appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx;
            if (iArr5.length > 0) {
                LruCache lruCache = Api26Impl.sVariationsCache;
                if (textView.getAutoSizeStepGranularity() != -1.0f) {
                    textView.setAutoSizeTextTypeUniformWithConfiguration(Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx), 0);
                } else {
                    textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawable = resourceId4 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawable2 = resourceId5 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawable3 = resourceId6 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawable4 = resourceId7 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawable5 = resourceId8 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawable6 = resourceId9 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId9) : null;
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            } else {
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = NavUtils.getColorStateList(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            textView.setCompoundDrawableTintList(colorStateList);
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            textView.setCompoundDrawableTintMode(DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes4.getInt(12, -1), null));
        }
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, -1);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, -1);
        if (typedArrayObtainStyledAttributes4.hasValue(19)) {
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes4.peekValue(19);
            if (typedValuePeekValue == null || typedValuePeekValue.type != 5) {
                dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, -1);
            } else {
                int i5 = typedValuePeekValue.data;
                i2 = i5 & 15;
                dimensionPixelSize = TypedValue.complexToFloat(i5);
            }
            typedArrayObtainStyledAttributes4.recycle();
            if (dimensionPixelSize2 != -1) {
                IntMath.setFirstBaselineToTopHeight(textView, dimensionPixelSize2);
            }
            if (dimensionPixelSize3 != -1) {
                IntMath.setLastBaselineToBottomHeight(textView, dimensionPixelSize3);
            }
            if (dimensionPixelSize != -1.0f) {
                if (i2 == -1) {
                    IntMath.setLineHeight(textView, (int) dimensionPixelSize);
                } else if (Build.VERSION.SDK_INT >= 34) {
                    TextViewCompat$Api34Impl.setLineHeight(textView, i2, dimensionPixelSize);
                } else {
                    IntMath.setLineHeight(textView, Math.round(TypedValue.applyDimension(i2, dimensionPixelSize, textView.getResources().getDisplayMetrics())));
                }
            }
        }
        dimensionPixelSize = -1.0f;
        i2 = -1;
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize2 != -1) {
            IntMath.setFirstBaselineToTopHeight(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            IntMath.setLastBaselineToBottomHeight(textView, dimensionPixelSize3);
        }
        if (dimensionPixelSize != -1.0f) {
            if (i2 == -1) {
                IntMath.setLineHeight(textView, (int) dimensionPixelSize);
            } else if (Build.VERSION.SDK_INT >= 34) {
                TextViewCompat$Api34Impl.setLineHeight(textView, i2, dimensionPixelSize);
            } else {
                IntMath.setLineHeight(textView, Math.round(TypedValue.applyDimension(i2, dimensionPixelSize, textView.getResources().getDisplayMetrics())));
            }
        }
    }

    public final void onSetTextAppearance(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        EmojiProcessor emojiProcessor = new EmojiProcessor(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.mView;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, CropImageView.DEFAULT_ASPECT_RATIO);
        }
        boolean zUpdateTypefaceAndStyle = updateTypefaceAndStyle(context, emojiProcessor);
        emojiProcessor.recycle();
        applyFontAndVariationSettings(zUpdateTypefaceAndStyle);
    }

    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArrCopyOf);
                if (!appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Arrays.toString(iArr), "None of the preset sizes is valid: ");
                    return;
                }
            } else {
                appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues = false;
            }
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setAutoSizeTextTypeWithDefaults(int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            if (i == 0) {
                appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
                appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = new int[0];
                appCompatTextViewAutoSizeHelper.mNeedsAutoSizeText = false;
                return;
            }
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unknown auto-size text type: "));
                return;
            }
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setCompoundDrawableTintList(ColorStateList colorStateList) {
        ConnectionSpec.Builder builder = this.mDrawableTint;
        if (builder == null) {
            builder = new ConnectionSpec.Builder();
            this.mDrawableTint = builder;
        }
        ConnectionSpec.Builder builder2 = builder;
        builder.cipherSuites = colorStateList;
        builder.supportsTlsExtensions = colorStateList != null;
        this.mDrawableLeftTint = builder2;
        this.mDrawableTopTint = builder2;
        this.mDrawableRightTint = builder2;
        this.mDrawableBottomTint = builder2;
        this.mDrawableStartTint = builder2;
        this.mDrawableEndTint = builder2;
    }

    public final void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        ConnectionSpec.Builder builder = this.mDrawableTint;
        if (builder == null) {
            builder = new ConnectionSpec.Builder();
            this.mDrawableTint = builder;
        }
        ConnectionSpec.Builder builder2 = builder;
        builder.tlsVersions = mode;
        builder.tls = mode != null;
        this.mDrawableLeftTint = builder2;
        this.mDrawableTopTint = builder2;
        this.mDrawableRightTint = builder2;
        this.mDrawableBottomTint = builder2;
        this.mDrawableStartTint = builder2;
        this.mDrawableEndTint = builder2;
    }

    public final boolean updateTypefaceAndStyle(Context context, EmojiProcessor emojiProcessor) {
        String string;
        int i;
        Typeface typeface;
        int i2 = this.mStyle;
        TypedArray typedArray = (TypedArray) emojiProcessor.mMetadataRepo;
        this.mStyle = typedArray.getInt(2, i2);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            int i4 = typedArray.getInt(11, -1);
            this.mFontWeight = i4;
            if (i4 != -1) {
                this.mStyle &= 2;
            }
        }
        if (typedArray.hasValue(13)) {
            this.mFontVariationSettings = typedArray.getString(13);
        }
        if (typedArray.hasValue(10) || typedArray.hasValue(12)) {
            this.mFontTypeface = null;
            int i5 = typedArray.hasValue(12) ? 12 : 10;
            int i6 = this.mFontWeight;
            int i7 = this.mStyle;
            if (!context.isRestricted()) {
                try {
                    Typeface font = emojiProcessor.getFont(i5, this.mStyle, new TimedValueQueue(this, i6, i7, new WeakReference(this.mView)));
                    if (font != null) {
                        if (i3 < 28 || this.mFontWeight == -1) {
                            this.mFontTypeface = font;
                        } else {
                            this.mFontTypeface = HandlerCompat$Api28Impl.create(Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                        }
                    }
                    this.mAsyncFontPending = this.mFontTypeface == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null && (string = typedArray.getString(i5)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                    this.mFontTypeface = Typeface.create(string, this.mStyle);
                } else {
                    this.mFontTypeface = HandlerCompat$Api28Impl.create(Typeface.create(string, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                }
            }
        } else {
            if (!typedArray.hasValue(1)) {
                if (i3 < 28 || (i = this.mFontWeight) == -1 || (typeface = this.mFontTypeface) == null) {
                    return false;
                }
                this.mFontTypeface = HandlerCompat$Api28Impl.create(typeface, i, (this.mStyle & 2) != 0);
                return true;
            }
            this.mAsyncFontPending = false;
            int i8 = typedArray.getInt(1, 1);
            if (i8 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
                return true;
            }
            if (i8 == 2) {
                this.mFontTypeface = Typeface.SERIF;
                return true;
            }
            if (i8 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
                return true;
            }
        }
        return true;
    }
}
