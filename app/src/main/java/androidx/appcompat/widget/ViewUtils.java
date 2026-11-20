package androidx.appcompat.widget;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewUtils {
    public static final boolean SDK_LEVEL_SUPPORTS_AUTOSIZE;
    public static Method sComputeFitSystemWindowsMethod;
    public static boolean sInitComputeFitSystemWindowsMethod;

    static {
        SDK_LEVEL_SUPPORTS_AUTOSIZE = Build.VERSION.SDK_INT >= 27;
    }
}
