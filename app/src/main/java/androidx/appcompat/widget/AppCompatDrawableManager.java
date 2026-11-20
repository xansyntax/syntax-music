package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.materialkolor.quantize.QuantizerWu;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDrawableManager {
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static AppCompatDrawableManager INSTANCE;
    public ResourceManagerInternal mResourceManager;

    public static synchronized AppCompatDrawableManager get() {
        try {
            if (INSTANCE == null) {
                preload();
            }
        } catch (Throwable th) {
            throw th;
        }
        return INSTANCE;
    }

    public static synchronized void preload() {
        if (INSTANCE == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            INSTANCE = appCompatDrawableManager;
            appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
            ResourceManagerInternal resourceManagerInternal = INSTANCE.mResourceManager;
            QuantizerWu quantizerWu = new QuantizerWu((byte) 1);
            synchronized (resourceManagerInternal) {
                resourceManagerInternal.mHooks = quantizerWu;
            }
        }
    }

    public final synchronized Drawable getDrawable(Context context, int i) {
        return this.mResourceManager.getDrawable(context, i);
    }
}
