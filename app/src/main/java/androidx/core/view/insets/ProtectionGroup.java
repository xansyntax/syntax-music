package androidx.core.view.insets;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.provider.CallbackWrapper;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProtectionGroup {
    public int mAnimationCount;
    public boolean mDisposed;
    public Insets mInsets;
    public Insets mInsetsIgnoringVisibility;
    public final SystemBarStateMonitor mMonitor;
    public final ArrayList mProtections = new ArrayList();

    public ProtectionGroup(SystemBarStateMonitor systemBarStateMonitor, ArrayList arrayList) {
        Insets insets = Insets.NONE;
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets;
        addProtections(arrayList, false);
        addProtections(arrayList, true);
        ArrayList arrayList2 = systemBarStateMonitor.mCallbacks;
        if (!arrayList2.contains(this)) {
            arrayList2.add(this);
            Insets insets2 = systemBarStateMonitor.mInsets;
            Insets insets3 = systemBarStateMonitor.mInsetsIgnoringVisibility;
            this.mInsets = insets2;
            this.mInsetsIgnoringVisibility = insets3;
            updateInsets();
            onColorHintChanged(systemBarStateMonitor.mColorHint);
        }
        this.mMonitor = systemBarStateMonitor;
    }

    public final void addProtections(List list, boolean z) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ColorProtection colorProtection = (ColorProtection) list.get(i);
            colorProtection.getClass();
            if (true == z) {
                ProtectionGroup protectionGroup = colorProtection.mController;
                if (protectionGroup != null) {
                    throw new IllegalStateException(colorProtection + " (" + (i + 1) + "/" + size + ") is already controlled by " + protectionGroup + " but is still added to " + this);
                }
                colorProtection.mController = this;
                this.mProtections.add(colorProtection);
            }
        }
    }

    public final void onColorHintChanged(int i) {
        ArrayList arrayList = this.mProtections;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ColorProtection colorProtection = (ColorProtection) arrayList.get(size);
            if (!colorProtection.mHasColor) {
                ColorDrawable colorDrawable = colorProtection.mDrawable;
                if (colorProtection.mColor != i) {
                    colorProtection.mColor = i;
                    colorDrawable.setColor(i);
                    Protection$Attributes protection$Attributes = colorProtection.mAttributes;
                    protection$Attributes.mDrawable = colorDrawable;
                    CallbackWrapper callbackWrapper = protection$Attributes.mCallback;
                    if (callbackWrapper != null) {
                        ((View) callbackWrapper.mExecutor).setBackground(colorDrawable);
                    }
                }
            }
        }
    }

    public final void updateInsets() {
        int i;
        Insets insetsOf;
        ArrayList arrayList = this.mProtections;
        Insets insets = Insets.NONE;
        Insets insetsMax = insets;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ColorProtection colorProtection = (ColorProtection) arrayList.get(size);
            Insets insets2 = this.mInsets;
            Insets insets3 = this.mInsetsIgnoringVisibility;
            colorProtection.mInsets = insets2;
            Protection$Attributes protection$Attributes = colorProtection.mAttributes;
            colorProtection.mInsetsIgnoringVisibility = insets3;
            if (!protection$Attributes.mMargin.equals(insetsMax)) {
                protection$Attributes.mMargin = insetsMax;
                CallbackWrapper callbackWrapper = protection$Attributes.mCallback;
                if (callbackWrapper != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) callbackWrapper.mCallback;
                    layoutParams.leftMargin = insetsMax.left;
                    layoutParams.topMargin = insetsMax.top;
                    layoutParams.rightMargin = insetsMax.right;
                    layoutParams.bottomMargin = insetsMax.bottom;
                    ((View) callbackWrapper.mExecutor).setLayoutParams(layoutParams);
                }
            }
            byte b = colorProtection.mSide;
            if (b == 1) {
                i = colorProtection.mInsets.left;
                int i2 = colorProtection.mInsetsIgnoringVisibility.left;
                if (protection$Attributes.mWidth != i2) {
                    protection$Attributes.mWidth = i2;
                    CallbackWrapper callbackWrapper2 = protection$Attributes.mCallback;
                    if (callbackWrapper2 != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) callbackWrapper2.mCallback;
                        layoutParams2.width = i2;
                        ((View) callbackWrapper2.mExecutor).setLayoutParams(layoutParams2);
                    }
                }
                insetsOf = Insets.of(i, 0, 0, 0);
            } else if (b == 2) {
                i = colorProtection.mInsets.top;
                int i3 = colorProtection.mInsetsIgnoringVisibility.top;
                if (protection$Attributes.mHeight != i3) {
                    protection$Attributes.mHeight = i3;
                    CallbackWrapper callbackWrapper3 = protection$Attributes.mCallback;
                    if (callbackWrapper3 != null) {
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) callbackWrapper3.mCallback;
                        layoutParams3.height = i3;
                        ((View) callbackWrapper3.mExecutor).setLayoutParams(layoutParams3);
                    }
                }
                insetsOf = Insets.of(0, i, 0, 0);
            } else if (b == 4) {
                i = colorProtection.mInsets.right;
                int i4 = colorProtection.mInsetsIgnoringVisibility.right;
                if (protection$Attributes.mWidth != i4) {
                    protection$Attributes.mWidth = i4;
                    CallbackWrapper callbackWrapper4 = protection$Attributes.mCallback;
                    if (callbackWrapper4 != null) {
                        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) callbackWrapper4.mCallback;
                        layoutParams4.width = i4;
                        ((View) callbackWrapper4.mExecutor).setLayoutParams(layoutParams4);
                    }
                }
                insetsOf = Insets.of(0, 0, i, 0);
            } else if (b != 8) {
                insetsOf = insets;
                i = 0;
            } else {
                i = colorProtection.mInsets.bottom;
                int i5 = colorProtection.mInsetsIgnoringVisibility.bottom;
                if (protection$Attributes.mHeight != i5) {
                    protection$Attributes.mHeight = i5;
                    CallbackWrapper callbackWrapper5 = protection$Attributes.mCallback;
                    if (callbackWrapper5 != null) {
                        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) callbackWrapper5.mCallback;
                        layoutParams5.height = i5;
                        ((View) callbackWrapper5.mExecutor).setLayoutParams(layoutParams5);
                    }
                }
                insetsOf = Insets.of(0, 0, 0, i);
            }
            boolean z = i > 0;
            if (protection$Attributes.mVisible != z) {
                protection$Attributes.mVisible = z;
                CallbackWrapper callbackWrapper6 = protection$Attributes.mCallback;
                if (callbackWrapper6 != null) {
                    ((View) callbackWrapper6.mExecutor).setVisibility(z ? 0 : 8);
                }
            }
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            colorProtection.setSystemAlpha(i > 0 ? 1.0f : 0.0f);
            if (i > 0) {
                f = 1.0f;
            }
            colorProtection.setSystemInsetAmount(f);
            insetsMax = Insets.max(insetsMax, insetsOf);
        }
    }
}
