package androidx.window.layout.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.window.core.Bounds;
import androidx.window.layout.WindowMetrics;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BoundsHelperApi24Impl implements BoundsHelper, DensityCompatHelper, WindowMetricsCompatHelper {
    public static final BoundsHelperApi24Impl INSTANCE = new BoundsHelperApi24Impl(0);
    public static final BoundsHelperApi24Impl INSTANCE$1 = new BoundsHelperApi24Impl(1);
    public static final BoundsHelperApi24Impl INSTANCE$2 = new BoundsHelperApi24Impl(2);
    public static final BoundsHelperApi24Impl INSTANCE$3 = new BoundsHelperApi24Impl(3);
    public static final BoundsHelperApi24Impl INSTANCE$4 = new BoundsHelperApi24Impl(4);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BoundsHelperApi24Impl(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.window.layout.util.BoundsHelper
    public Rect currentWindowBounds(Activity activity) throws Exception {
        DisplayCutout cutoutForDisplay;
        switch (this.$r8$classId) {
            case 0:
                Rect rect = new Rect();
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                defaultDisplay.getRectSize(rect);
                if (!activity.isInMultiWindowMode()) {
                    Point point = new Point();
                    defaultDisplay.getRealSize(point);
                    Resources resources = activity.getResources();
                    int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    int i = rect.bottom + dimensionPixelSize;
                    if (i == point.y) {
                        rect.bottom = i;
                    } else {
                        int i2 = rect.right + dimensionPixelSize;
                        if (i2 == point.x) {
                            rect.right = i2;
                        }
                    }
                }
                return rect;
            case 1:
                Rect rect2 = new Rect();
                Configuration configuration = activity.getResources().getConfiguration();
                try {
                    Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(configuration);
                    if (activity.isInMultiWindowMode()) {
                        Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                        objInvoke.getClass();
                        rect2.set((Rect) objInvoke);
                    } else {
                        Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                        objInvoke2.getClass();
                        rect2.set((Rect) objInvoke2);
                    }
                    break;
                } catch (Exception e) {
                    if (!(e instanceof NoSuchFieldException) && !(e instanceof NoSuchMethodException) && !(e instanceof IllegalAccessException) && !(e instanceof InvocationTargetException)) {
                        throw e;
                    }
                    Log.w("BoundsHelper", e);
                    activity.getWindowManager().getDefaultDisplay().getRectSize(rect2);
                }
                Display defaultDisplay2 = activity.getWindowManager().getDefaultDisplay();
                Point point2 = new Point();
                defaultDisplay2.getRealSize(point2);
                if (!activity.isInMultiWindowMode()) {
                    Resources resources2 = activity.getResources();
                    int identifier2 = resources2.getIdentifier("navigation_bar_height", "dimen", "android");
                    int dimensionPixelSize2 = identifier2 > 0 ? resources2.getDimensionPixelSize(identifier2) : 0;
                    int i3 = rect2.bottom + dimensionPixelSize2;
                    if (i3 == point2.y) {
                        rect2.bottom = i3;
                    } else {
                        int i4 = rect2.right + dimensionPixelSize2;
                        if (i4 == point2.x) {
                            rect2.right = i4;
                        } else if (rect2.left == dimensionPixelSize2) {
                            rect2.left = 0;
                        }
                    }
                }
                if ((rect2.width() < point2.x || rect2.height() < point2.y) && !activity.isInMultiWindowMode() && (cutoutForDisplay = HandlerCompat$Api28Impl.getCutoutForDisplay(defaultDisplay2)) != null) {
                    if (rect2.left == HandlerCompat$Api28Impl.safeInsetLeft(cutoutForDisplay)) {
                        rect2.left = 0;
                    }
                    if (point2.x - rect2.right == HandlerCompat$Api28Impl.safeInsetRight(cutoutForDisplay)) {
                        rect2.right = HandlerCompat$Api28Impl.safeInsetRight(cutoutForDisplay) + rect2.right;
                    }
                    if (rect2.top == HandlerCompat$Api28Impl.safeInsetTop(cutoutForDisplay)) {
                        rect2.top = 0;
                    }
                    if (point2.y - rect2.bottom == HandlerCompat$Api28Impl.safeInsetBottom(cutoutForDisplay)) {
                        rect2.bottom = HandlerCompat$Api28Impl.safeInsetBottom(cutoutForDisplay) + rect2.bottom;
                    }
                }
                return rect2;
            default:
                Configuration configuration2 = activity.getResources().getConfiguration();
                try {
                    Field declaredField2 = Configuration.class.getDeclaredField("windowConfiguration");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(configuration2);
                    Object objInvoke3 = obj2.getClass().getDeclaredMethod("getBounds", null).invoke(obj2, null);
                    objInvoke3.getClass();
                    return new Rect((Rect) objInvoke3);
                } catch (Exception e2) {
                    if (!(e2 instanceof NoSuchFieldException) && !(e2 instanceof NoSuchMethodException) && !(e2 instanceof IllegalAccessException) && !(e2 instanceof InvocationTargetException)) {
                        throw e2;
                    }
                    Log.w("BoundsHelper", e2);
                    return INSTANCE$1.currentWindowBounds(activity);
                }
        }
    }

    @Override // androidx.window.layout.util.WindowMetricsCompatHelper
    public WindowMetrics currentWindowMetrics(Context context, DensityCompatHelper densityCompatHelper) {
        BoundsHelper boundsHelper;
        Context baseContext = context;
        while (true) {
            if (!(baseContext instanceof ContextWrapper)) {
                baseContext = context;
                break;
            }
            if ((baseContext instanceof Activity) || (baseContext instanceof InputMethodService)) {
                break;
            }
            ContextWrapper contextWrapper = (ContextWrapper) baseContext;
            if (contextWrapper.getBaseContext() == null) {
                break;
            }
            baseContext = contextWrapper.getBaseContext();
            baseContext.getClass();
        }
        if (baseContext instanceof Activity) {
            Activity activity = (Activity) baseContext;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                boundsHelper = BoundsHelperApi30Impl.INSTANCE;
            } else if (i >= 29) {
                boundsHelper = INSTANCE$2;
            } else {
                boundsHelper = i >= 28 ? INSTANCE$1 : INSTANCE;
            }
            return new WindowMetrics(new Bounds(boundsHelper.currentWindowBounds(activity)), densityCompatHelper.density(activity));
        }
        if (!(baseContext instanceof InputMethodService) && !(baseContext instanceof Application)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Must provide a UiContext or Application Context");
            return null;
        }
        Object systemService = context.getSystemService("window");
        systemService.getClass();
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        defaultDisplay.getClass();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new WindowMetrics(new Rect(0, 0, point.x, point.y), densityCompatHelper.density(context));
    }

    @Override // androidx.window.layout.util.DensityCompatHelper
    public float density(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }
}
