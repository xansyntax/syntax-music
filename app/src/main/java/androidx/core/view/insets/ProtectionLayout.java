package androidx.core.view.insets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.graphics.Insets;
import androidx.core.provider.CallbackWrapper;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProtectionLayout extends FrameLayout {
    public static final Object PROTECTION_VIEW = new Object();
    public ProtectionGroup mGroup;
    public final ArrayList mProtections;

    public ProtectionLayout(Context context, List list) {
        super(context);
        this.mProtections = new ArrayList();
        setProtections(list);
    }

    private SystemBarStateMonitor getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            return (SystemBarStateMonitor) tag;
        }
        SystemBarStateMonitor systemBarStateMonitor = new SystemBarStateMonitor(viewGroup);
        viewGroup.setTag(R.id.tag_system_bar_state_monitor, systemBarStateMonitor);
        return systemBarStateMonitor;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x009f  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b3 A[LOOP:0: B:7:0x0028->B:27:0x00b3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc A[SYNTHETIC] */
    public final void addProtectionViews() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams;
        View view;
        CallbackWrapper callbackWrapper;
        ArrayList arrayList = this.mProtections;
        if (arrayList.isEmpty()) {
            removeProtectionViews();
            return;
        }
        SystemBarStateMonitor orInstallSystemBarStateMonitor = getOrInstallSystemBarStateMonitor();
        removeProtectionViews();
        this.mGroup = new ProtectionGroup(orInstallSystemBarStateMonitor, arrayList);
        int childCount = getChildCount();
        int size = this.mGroup.mProtections.size();
        for (int i4 = 0; i4 < size; i4++) {
            ColorProtection colorProtection = (ColorProtection) this.mGroup.mProtections.get(i4);
            Context context = getContext();
            int i5 = i4 + childCount;
            Protection$Attributes protection$Attributes = colorProtection.mAttributes;
            byte b = colorProtection.mSide;
            int i6 = -1;
            if (b != 1) {
                if (b == 2) {
                    i3 = protection$Attributes.mHeight;
                    i2 = 48;
                } else if (b == 4) {
                    i = protection$Attributes.mWidth;
                    i2 = 5;
                } else if (b != 8) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(b, "Unexpected side: "));
                    return;
                } else {
                    i3 = protection$Attributes.mHeight;
                    i2 = 80;
                }
                layoutParams = new FrameLayout.LayoutParams(i6, i3, i2);
                Insets insets = protection$Attributes.mMargin;
                layoutParams.leftMargin = insets.left;
                layoutParams.topMargin = insets.top;
                layoutParams.rightMargin = insets.right;
                layoutParams.bottomMargin = insets.bottom;
                view = new View(context);
                view.setTag(PROTECTION_VIEW);
                view.setTranslationX(protection$Attributes.mTranslationX);
                view.setTranslationY(protection$Attributes.mTranslationY);
                view.setAlpha(protection$Attributes.mAlpha);
                view.setVisibility(protection$Attributes.mVisible ? 0 : 8);
                view.setBackground(protection$Attributes.mDrawable);
                callbackWrapper = new CallbackWrapper(layoutParams, view, (byte) 14);
                if (protection$Attributes.mCallback == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
                    return;
                } else {
                    protection$Attributes.mCallback = callbackWrapper;
                    addView(view, i5, layoutParams);
                }
            } else {
                i = protection$Attributes.mWidth;
                i2 = 3;
            }
            i6 = i;
            i3 = -1;
            layoutParams = new FrameLayout.LayoutParams(i6, i3, i2);
            Insets insets2 = protection$Attributes.mMargin;
            layoutParams.leftMargin = insets2.left;
            layoutParams.topMargin = insets2.top;
            layoutParams.rightMargin = insets2.right;
            layoutParams.bottomMargin = insets2.bottom;
            view = new View(context);
            view.setTag(PROTECTION_VIEW);
            view.setTranslationX(protection$Attributes.mTranslationX);
            view.setTranslationY(protection$Attributes.mTranslationY);
            view.setAlpha(protection$Attributes.mAlpha);
            view.setVisibility(protection$Attributes.mVisible ? 0 : 8);
            view.setBackground(protection$Attributes.mDrawable);
            callbackWrapper = new CallbackWrapper(layoutParams, view, (byte) 14);
            if (protection$Attributes.mCallback == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
                return;
            } else {
                protection$Attributes.mCallback = callbackWrapper;
                addView(view, i5, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getTag() != PROTECTION_VIEW) {
            ProtectionGroup protectionGroup = this.mGroup;
            int childCount = getChildCount() - (protectionGroup != null ? protectionGroup.mProtections.size() : 0);
            if (i > childCount || i < 0) {
                i = childCount;
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        addProtectionViews();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeProtectionViews();
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            SystemBarStateMonitor systemBarStateMonitor = (SystemBarStateMonitor) tag;
            if (systemBarStateMonitor.mCallbacks.isEmpty()) {
                systemBarStateMonitor.mDetector.post(new ActivityCompat$$ExternalSyntheticLambda0((byte) 10, (Object) systemBarStateMonitor));
                viewGroup.setTag(R.id.tag_system_bar_state_monitor, null);
            }
        }
    }

    public final void removeProtectionViews() {
        ProtectionGroup protectionGroup;
        if (this.mGroup != null) {
            removeViews(getChildCount() - this.mGroup.mProtections.size(), this.mGroup.mProtections.size());
            int size = this.mGroup.mProtections.size();
            int i = 0;
            while (true) {
                protectionGroup = this.mGroup;
                if (i >= size) {
                    break;
                }
                ((ColorProtection) protectionGroup.mProtections.get(i)).mAttributes.mCallback = null;
                i++;
            }
            ArrayList arrayList = protectionGroup.mProtections;
            if (!protectionGroup.mDisposed) {
                protectionGroup.mDisposed = true;
                protectionGroup.mMonitor.mCallbacks.remove(protectionGroup);
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    ((ColorProtection) arrayList.get(size2)).mController = null;
                }
                arrayList.clear();
            }
            this.mGroup = null;
        }
    }

    public void setProtections(List<ColorProtection> list) {
        ArrayList arrayList = this.mProtections;
        arrayList.clear();
        arrayList.addAll(list);
        if (isAttachedToWindow()) {
            addProtectionViews();
            requestApplyInsets();
        }
    }
}
