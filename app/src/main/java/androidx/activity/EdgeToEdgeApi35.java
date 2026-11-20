package androidx.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$Impl35;
import androidx.core.view.insets.ColorProtection;
import androidx.core.view.insets.Protection$Attributes;
import androidx.core.view.insets.ProtectionLayout;
import androidx.datastore.core.AtomicInt;
import coil3.util.LifecyclesKt;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EdgeToEdgeApi35 extends EdgeToEdgeApi30 {
    @Override // androidx.activity.EdgeToEdgeApi29, androidx.activity.EdgeToEdgeApi26
    public void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z, boolean z2) {
        systemBarStyle.getClass();
        systemBarStyle2.getClass();
        window.getClass();
        view.getClass();
        int i = 0;
        MathKt.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int scrimWithEnforcedContrast$activity = systemBarStyle.getScrimWithEnforcedContrast$activity(z);
        int scrimWithEnforcedContrast$activity2 = systemBarStyle2.getScrimWithEnforcedContrast$activity(z2);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            int i2 = 0;
            while (true) {
                if ((i2 < viewGroup.getChildCount() ? 1 : i) == 0) {
                    if (scrimWithEnforcedContrast$activity != 0 || scrimWithEnforcedContrast$activity2 != 0) {
                        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new ColorProtection[]{new ColorProtection(2, scrimWithEnforcedContrast$activity), new ColorProtection(1, scrimWithEnforcedContrast$activity2), new ColorProtection(4, scrimWithEnforcedContrast$activity2), new ColorProtection(8, scrimWithEnforcedContrast$activity2)});
                        ProtectionLayout protectionLayout = new ProtectionLayout(((ViewGroup) view).getContext(), listListOf);
                        protectionLayout.setTag(listListOf);
                        viewGroup.addView(protectionLayout);
                        break;
                    }
                    break;
                }
                int i3 = i2 + 1;
                View childAt = viewGroup.getChildAt(i2);
                if (childAt == null) {
                    throw new IndexOutOfBoundsException();
                }
                Object tag = childAt.getTag();
                if (tag instanceof List) {
                    List list = (List) tag;
                    if (list.size() == 4 && (list.get(i) instanceof ColorProtection)) {
                        for (Object obj : (Iterable) tag) {
                            if ((obj instanceof ColorProtection ? (ColorProtection) obj : null) != null) {
                                ColorProtection colorProtection = (ColorProtection) obj;
                                byte b = colorProtection.mSide;
                                Protection$Attributes protection$Attributes = colorProtection.mAttributes;
                                ColorDrawable colorDrawable = colorProtection.mDrawable;
                                if (b == 1) {
                                    colorProtection.mHasColor = true;
                                    if (colorProtection.mColor != scrimWithEnforcedContrast$activity2) {
                                        colorProtection.mColor = scrimWithEnforcedContrast$activity2;
                                        colorDrawable.setColor(scrimWithEnforcedContrast$activity2);
                                        protection$Attributes.mDrawable = colorDrawable;
                                        CallbackWrapper callbackWrapper = protection$Attributes.mCallback;
                                        if (callbackWrapper != null) {
                                            ((View) callbackWrapper.mExecutor).setBackground(colorDrawable);
                                        }
                                    }
                                } else if (b == 2) {
                                    colorProtection.mHasColor = true;
                                    if (colorProtection.mColor != scrimWithEnforcedContrast$activity) {
                                        colorProtection.mColor = scrimWithEnforcedContrast$activity;
                                        colorDrawable.setColor(scrimWithEnforcedContrast$activity);
                                        protection$Attributes.mDrawable = colorDrawable;
                                        CallbackWrapper callbackWrapper2 = protection$Attributes.mCallback;
                                        if (callbackWrapper2 != null) {
                                            ((View) callbackWrapper2.mExecutor).setBackground(colorDrawable);
                                        }
                                    }
                                } else if (b == 4) {
                                    colorProtection.mHasColor = true;
                                    if (colorProtection.mColor != scrimWithEnforcedContrast$activity2) {
                                        colorProtection.mColor = scrimWithEnforcedContrast$activity2;
                                        colorDrawable.setColor(scrimWithEnforcedContrast$activity2);
                                        protection$Attributes.mDrawable = colorDrawable;
                                        CallbackWrapper callbackWrapper3 = protection$Attributes.mCallback;
                                        if (callbackWrapper3 != null) {
                                            ((View) callbackWrapper3.mExecutor).setBackground(colorDrawable);
                                        }
                                    }
                                } else if (b == 8) {
                                    colorProtection.mHasColor = true;
                                    if (colorProtection.mColor != scrimWithEnforcedContrast$activity2) {
                                        colorProtection.mColor = scrimWithEnforcedContrast$activity2;
                                        colorDrawable.setColor(scrimWithEnforcedContrast$activity2);
                                        protection$Attributes.mDrawable = colorDrawable;
                                        CallbackWrapper callbackWrapper4 = protection$Attributes.mCallback;
                                        if (callbackWrapper4 != null) {
                                            ((View) callbackWrapper4.mExecutor).setBackground(colorDrawable);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                i2 = i3;
                i = 0;
            }
        }
        window.setNavigationBarContrastEnforced(systemBarStyle2.nightMode == 0);
        AtomicInt atomicInt = new AtomicInt(view);
        int i4 = Build.VERSION.SDK_INT;
        LifecyclesKt windowInsetsControllerCompat$Impl35 = i4 >= 35 ? new WindowInsetsControllerCompat$Impl35(window, atomicInt) : i4 >= 30 ? new WindowInsetsControllerCompat$Impl30(window, atomicInt) : new WindowInsetsControllerCompat$Impl26(window, atomicInt);
        windowInsetsControllerCompat$Impl35.setAppearanceLightStatusBars(!z);
        windowInsetsControllerCompat$Impl35.setAppearanceLightNavigationBars(!z2);
    }
}
