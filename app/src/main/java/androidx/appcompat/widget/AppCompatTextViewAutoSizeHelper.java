package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatTextViewAutoSizeHelper {
    public static final RectF TEMP_RECTF = new RectF();
    public static final ConcurrentHashMap sTextViewMethodByNameCache = new ConcurrentHashMap();
    public final Context mContext;
    public final Impl mImpl;
    public TextPaint mTempTextPaint;
    public final TextView mTextView;
    public int mAutoSizeTextType = 0;
    public boolean mNeedsAutoSizeText = false;
    public float mAutoSizeStepGranularityInPx = -1.0f;
    public float mAutoSizeMinTextSizeInPx = -1.0f;
    public float mAutoSizeMaxTextSizeInPx = -1.0f;
    public int[] mAutoSizeTextSizesInPx = new int[0];
    public boolean mHasPresetAutoSizeValues = false;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class Impl {
        public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault("getTextDirectionHeuristic", textView, TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }

        public boolean isHorizontallyScrollable(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault("getHorizontallyScrolling", textView, Boolean.FALSE)).booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Impl29 extends Impl {
        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public boolean isHorizontallyScrollable(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29();
        } else {
            this.mImpl = new Impl();
        }
    }

    public static int[] cleanupAutoSizePresetSizes(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i : iArr) {
                if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method getTextViewMethod(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = sTextViewMethodByNameCache;
            Method declaredMethod = (Method) concurrentHashMap.get(str);
            if (declaredMethod != null || (declaredMethod = TextView.class.getDeclaredMethod(str, null)) == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            concurrentHashMap.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    public static Object invokeAndReturnWithDefault(String str, Object obj, Object obj2) {
        try {
            return getTextViewMethod(str).invoke(obj, null);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return obj2;
        }
    }

    public final void autoSizeText() {
        if (isAutoSizeEnabled()) {
            if (this.mNeedsAutoSizeText) {
                if (this.mTextView.getMeasuredHeight() <= 0 || this.mTextView.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.mImpl.isHorizontallyScrollable(this.mTextView) ? ByteChannelKt.CHANNEL_MAX_SIZE : (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = TEMP_RECTF;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fFindLargestTextSizeWhichFits = findLargestTextSizeWhichFits(rectF);
                        if (fFindLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                            setTextSizeInternal(0, fFindLargestTextSizeWhichFits);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.mNeedsAutoSizeText = true;
        }
    }

    public final int findLargestTextSizeWhichFits(RectF rectF) {
        CharSequence transformation;
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No available text sizes to choose from.");
            return 0;
        }
        int i = length - 1;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            int[] iArr = this.mAutoSizeTextSizesInPx;
            if (i3 > i) {
                return iArr[i2];
            }
            int i4 = (i3 + i) / 2;
            int i5 = iArr[i4];
            TextView textView = this.mTextView;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                text = transformation;
            }
            int maxLines = textView.getMaxLines();
            TextPaint textPaint = this.mTempTextPaint;
            if (textPaint == null) {
                this.mTempTextPaint = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.mTempTextPaint.set(textView.getPaint());
            this.mTempTextPaint.setTextSize(i5);
            Layout.Alignment alignment = (Layout.Alignment) invokeAndReturnWithDefault("getLayoutAlignment", textView, Layout.Alignment.ALIGN_NORMAL);
            int iRound = Math.round(rectF.right);
            TextPaint textPaint2 = this.mTempTextPaint;
            Impl impl = this.mImpl;
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(text, 0, text.length(), textPaint2, iRound);
            builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Integer.MAX_VALUE : maxLines);
            try {
                impl.computeAndSetTextDirection(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            StaticLayout staticLayoutBuild = builderObtain.build();
            if ((maxLines == -1 || (staticLayoutBuild.getLineCount() <= maxLines && staticLayoutBuild.getLineEnd(staticLayoutBuild.getLineCount() - 1) == text.length())) && staticLayoutBuild.getHeight() <= rectF.bottom) {
                int i6 = i4 + 1;
                i2 = i3;
                i3 = i6;
            } else {
                i2 = i4 - 1;
                i = i2;
            }
        }
    }

    public final boolean isAutoSizeEnabled() {
        return supportsAutoSizeText() && this.mAutoSizeTextType != 0;
    }

    public final void setTextSizeInternal(int i, float f) {
        Context context = this.mContext;
        float fApplyDimension = TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.mTextView;
        if (fApplyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(fApplyDimension);
            boolean zIsInLayout = textView.isInLayout();
            if (textView.getLayout() != null) {
                this.mNeedsAutoSizeText = false;
                try {
                    Method textViewMethod = getTextViewMethod("nullLayouts");
                    if (textViewMethod != null) {
                        textViewMethod.invoke(textView, null);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (zIsInLayout) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean setupAutoSizeText() {
        if (!supportsAutoSizeText() || this.mAutoSizeTextType != 1) {
            this.mNeedsAutoSizeText = false;
            return false;
        }
        if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
            int iFloor = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
            int[] iArr = new int[iFloor];
            for (int i = 0; i < iFloor; i++) {
                iArr[i] = Math.round((i * this.mAutoSizeStepGranularityInPx) + this.mAutoSizeMinTextSizeInPx);
            }
            this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
        }
        this.mNeedsAutoSizeText = true;
        return true;
    }

    public final boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int[] iArr = this.mAutoSizeTextSizesInPx;
        int length = iArr.length;
        boolean z = length > 0;
        this.mHasPresetAutoSizeValues = z;
        if (z) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = iArr[0];
            this.mAutoSizeMaxTextSizeInPx = iArr[length - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return z;
    }

    public final boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    public final void validateAndSetAutoSizeTextTypeUniformConfiguration(float f, float f2, float f3) {
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("Minimum auto-size text size (", f, "px) is less or equal to (0px)"));
            return;
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= CropImageView.DEFAULT_ASPECT_RATIO) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("The auto-size step granularity (", f3, "px) is less or equal to (0px)"));
            return;
        }
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = f;
        this.mAutoSizeMaxTextSizeInPx = f2;
        this.mAutoSizeStepGranularityInPx = f3;
        this.mHasPresetAutoSizeValues = false;
    }
}
