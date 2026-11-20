package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.LongSparseArray;
import androidx.collection.internal.Lock;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ResourcesCompat$ThemeCompat$Api29Impl;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.room.TransactionExecutor;
import androidx.savedstate.SavedStateRegistry;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashSet;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatActivity extends FragmentActivity implements AppCompatCallback {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        ((ViewGroup) appCompatDelegateImpl.mSubDecor.findViewById(R.id.content)).addView(view, layoutParams);
        appCompatDelegateImpl.mAppCompatWindowCallback.bypassOnContentChanged(appCompatDelegateImpl.mWindow.getCallback());
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0194  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:111:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:117:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:120:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:121:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:125:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:127:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:128:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:139:0x021d A[Catch: all -> 0x0211, TRY_LEAVE, TryCatch #0 {, blocks: (B:130:0x01ff, B:132:0x0203, B:138:0x021b, B:139:0x021d, B:141:0x0221, B:147:0x0231, B:146:0x0228, B:137:0x0214), top: B:157:0x01ff, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0221 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0096  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:66:0x0108  */
    /* JADX WARN: Code duplicated, block: B:69:0x0115  */
    /* JADX WARN: Code duplicated, block: B:72:0x011d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0125  */
    /* JADX WARN: Code duplicated, block: B:78:0x012d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0135  */
    /* JADX WARN: Code duplicated, block: B:84:0x013d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0149  */
    /* JADX WARN: Code duplicated, block: B:90:0x0158  */
    /* JADX WARN: Code duplicated, block: B:93:0x0167  */
    /* JADX WARN: Code duplicated, block: B:96:0x0176  */
    /* JADX WARN: Code duplicated, block: B:99:0x0185  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Configuration configuration;
        Configuration configuration2;
        Configuration configuration3;
        ContextThemeWrapper contextThemeWrapper;
        Resources.Theme theme;
        Method method;
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        LocaleList locales;
        LocaleList locales2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.mBaseContextAttached = true;
        int i41 = appCompatDelegateImpl.mLocalNightMode;
        if (i41 == -100) {
            i41 = AppCompatDelegate.sDefaultNightMode;
        }
        int iMapNightMode = appCompatDelegateImpl.mapNightMode(context, i41);
        byte b = 0;
        if (AppCompatDelegate.isAutoStorageOptedIn(context) && AppCompatDelegate.isAutoStorageOptedIn(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (AppCompatDelegate.sAppLocalesStorageSyncLock) {
                    try {
                        LocaleListCompat localeListCompat = AppCompatDelegate.sRequestedAppLocales;
                        if (localeListCompat == null) {
                            LocaleListCompat localeListCompatForLanguageTags = AppCompatDelegate.sStoredAppLocales;
                            if (localeListCompatForLanguageTags == null) {
                                localeListCompatForLanguageTags = LocaleListCompat.forLanguageTags(NavUtils.readLocales(context));
                                AppCompatDelegate.sStoredAppLocales = localeListCompatForLanguageTags;
                            }
                            if (!localeListCompatForLanguageTags.mImpl.mLocaleList.isEmpty()) {
                                AppCompatDelegate.sRequestedAppLocales = AppCompatDelegate.sStoredAppLocales;
                            }
                        } else if (!localeListCompat.equals(AppCompatDelegate.sStoredAppLocales)) {
                            LocaleListCompat localeListCompat2 = AppCompatDelegate.sRequestedAppLocales;
                            AppCompatDelegate.sStoredAppLocales = localeListCompat2;
                            NavUtils.persistLocales(context, localeListCompat2.mImpl.mLocaleList.toLanguageTags());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else if (!AppCompatDelegate.sIsFrameworkSyncChecked) {
                AppCompatDelegate.sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda0(context, b));
            }
        }
        LocaleListCompat localeListCompatCalculateApplicationLocales = AppCompatDelegateImpl.calculateApplicationLocales(context);
        if (context instanceof android.view.ContextThemeWrapper) {
            try {
                ((android.view.ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false));
            } catch (IllegalStateException unused) {
                if (context instanceof ContextThemeWrapper) {
                    try {
                        ((ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false));
                    } catch (IllegalStateException unused2) {
                        if (AppCompatDelegateImpl.sCanReturnDifferentContext) {
                            Configuration configuration4 = new Configuration();
                            configuration4.uiMode = -1;
                            configuration4.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
                            configuration = context.createConfigurationContext(configuration4).getResources().getConfiguration();
                            configuration2 = context.getResources().getConfiguration();
                            configuration.uiMode = configuration2.uiMode;
                            if (configuration.equals(configuration2)) {
                                configuration3 = null;
                            } else {
                                configuration3 = new Configuration();
                                configuration3.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
                                if (configuration.diff(configuration2) != 0) {
                                    f = configuration.fontScale;
                                    f2 = configuration2.fontScale;
                                    if (f != f2) {
                                        configuration3.fontScale = f2;
                                    }
                                    i = configuration.mcc;
                                    i2 = configuration2.mcc;
                                    if (i != i2) {
                                        configuration3.mcc = i2;
                                    }
                                    i3 = configuration.mnc;
                                    i4 = configuration2.mnc;
                                    if (i3 != i4) {
                                        configuration3.mnc = i4;
                                    }
                                    locales = configuration.getLocales();
                                    locales2 = configuration2.getLocales();
                                    if (!locales.equals(locales2)) {
                                        configuration3.setLocales(locales2);
                                        configuration3.locale = configuration2.locale;
                                    }
                                    i5 = configuration.touchscreen;
                                    i6 = configuration2.touchscreen;
                                    if (i5 != i6) {
                                        configuration3.touchscreen = i6;
                                    }
                                    i7 = configuration.keyboard;
                                    i8 = configuration2.keyboard;
                                    if (i7 != i8) {
                                        configuration3.keyboard = i8;
                                    }
                                    i9 = configuration.keyboardHidden;
                                    i10 = configuration2.keyboardHidden;
                                    if (i9 != i10) {
                                        configuration3.keyboardHidden = i10;
                                    }
                                    i11 = configuration.navigation;
                                    i12 = configuration2.navigation;
                                    if (i11 != i12) {
                                        configuration3.navigation = i12;
                                    }
                                    i13 = configuration.navigationHidden;
                                    i14 = configuration2.navigationHidden;
                                    if (i13 != i14) {
                                        configuration3.navigationHidden = i14;
                                    }
                                    i15 = configuration.orientation;
                                    i16 = configuration2.orientation;
                                    if (i15 != i16) {
                                        configuration3.orientation = i16;
                                    }
                                    i17 = configuration.screenLayout & 15;
                                    i18 = configuration2.screenLayout & 15;
                                    if (i17 != i18) {
                                        configuration3.screenLayout |= i18;
                                    }
                                    i19 = configuration.screenLayout & 192;
                                    i20 = configuration2.screenLayout & 192;
                                    if (i19 != i20) {
                                        configuration3.screenLayout |= i20;
                                    }
                                    i21 = configuration.screenLayout & 48;
                                    i22 = configuration2.screenLayout & 48;
                                    if (i21 != i22) {
                                        configuration3.screenLayout |= i22;
                                    }
                                    i23 = configuration.screenLayout & 768;
                                    i24 = configuration2.screenLayout & 768;
                                    if (i23 != i24) {
                                        configuration3.screenLayout |= i24;
                                    }
                                    i25 = configuration.colorMode & 3;
                                    i26 = configuration2.colorMode & 3;
                                    if (i25 != i26) {
                                        configuration3.colorMode |= i26;
                                    }
                                    i27 = configuration.colorMode & 12;
                                    i28 = configuration2.colorMode & 12;
                                    if (i27 != i28) {
                                        configuration3.colorMode |= i28;
                                    }
                                    i29 = configuration.uiMode & 15;
                                    i30 = configuration2.uiMode & 15;
                                    if (i29 != i30) {
                                        configuration3.uiMode |= i30;
                                    }
                                    i31 = configuration.uiMode & 48;
                                    i32 = configuration2.uiMode & 48;
                                    if (i31 != i32) {
                                        configuration3.uiMode |= i32;
                                    }
                                    i33 = configuration.screenWidthDp;
                                    i34 = configuration2.screenWidthDp;
                                    if (i33 != i34) {
                                        configuration3.screenWidthDp = i34;
                                    }
                                    i35 = configuration.screenHeightDp;
                                    i36 = configuration2.screenHeightDp;
                                    if (i35 != i36) {
                                        configuration3.screenHeightDp = i36;
                                    }
                                    i37 = configuration.smallestScreenWidthDp;
                                    i38 = configuration2.smallestScreenWidthDp;
                                    if (i37 != i38) {
                                        configuration3.smallestScreenWidthDp = i38;
                                    }
                                    i39 = configuration.densityDpi;
                                    i40 = configuration2.densityDpi;
                                    if (i39 != i40) {
                                        configuration3.densityDpi = i40;
                                    }
                                }
                            }
                            Configuration configurationCreateOverrideAppConfiguration = AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, configuration3, true);
                            contextThemeWrapper = new ContextThemeWrapper(context, com.yalantis.ucrop.R.style.Theme_AppCompat_Empty);
                            contextThemeWrapper.applyOverrideConfiguration(configurationCreateOverrideAppConfiguration);
                            try {
                                if (context.getTheme() != null) {
                                    theme = contextThemeWrapper.getTheme();
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        ResourcesCompat$ThemeCompat$Api29Impl.rebase(theme);
                                    } else {
                                        synchronized (CamUtils.sRebaseMethodLock) {
                                            if (CamUtils.sRebaseMethodFetched) {
                                                method = CamUtils.sRebaseMethod;
                                                if (method != null) {
                                                    method.invoke(theme, null);
                                                }
                                            } else {
                                                try {
                                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                                    CamUtils.sRebaseMethod = declaredMethod;
                                                    declaredMethod.setAccessible(true);
                                                } catch (NoSuchMethodException e) {
                                                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                                                }
                                                CamUtils.sRebaseMethodFetched = true;
                                                method = CamUtils.sRebaseMethod;
                                                if (method != null) {
                                                    try {
                                                        method.invoke(theme, null);
                                                    } catch (IllegalAccessException | InvocationTargetException e2) {
                                                        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                                                        CamUtils.sRebaseMethod = null;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (NullPointerException unused3) {
                            }
                            context = contextThemeWrapper;
                        }
                    }
                } else if (AppCompatDelegateImpl.sCanReturnDifferentContext) {
                    Configuration configuration5 = new Configuration();
                    configuration5.uiMode = -1;
                    configuration5.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
                    configuration = context.createConfigurationContext(configuration5).getResources().getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (configuration.equals(configuration2)) {
                        configuration3 = new Configuration();
                        configuration3.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
                        if (configuration.diff(configuration2) != 0) {
                            f = configuration.fontScale;
                            f2 = configuration2.fontScale;
                            if (f != f2) {
                                configuration3.fontScale = f2;
                            }
                            i = configuration.mcc;
                            i2 = configuration2.mcc;
                            if (i != i2) {
                                configuration3.mcc = i2;
                            }
                            i3 = configuration.mnc;
                            i4 = configuration2.mnc;
                            if (i3 != i4) {
                                configuration3.mnc = i4;
                            }
                            locales = configuration.getLocales();
                            locales2 = configuration2.getLocales();
                            if (!locales.equals(locales2)) {
                                configuration3.setLocales(locales2);
                                configuration3.locale = configuration2.locale;
                            }
                            i5 = configuration.touchscreen;
                            i6 = configuration2.touchscreen;
                            if (i5 != i6) {
                                configuration3.touchscreen = i6;
                            }
                            i7 = configuration.keyboard;
                            i8 = configuration2.keyboard;
                            if (i7 != i8) {
                                configuration3.keyboard = i8;
                            }
                            i9 = configuration.keyboardHidden;
                            i10 = configuration2.keyboardHidden;
                            if (i9 != i10) {
                                configuration3.keyboardHidden = i10;
                            }
                            i11 = configuration.navigation;
                            i12 = configuration2.navigation;
                            if (i11 != i12) {
                                configuration3.navigation = i12;
                            }
                            i13 = configuration.navigationHidden;
                            i14 = configuration2.navigationHidden;
                            if (i13 != i14) {
                                configuration3.navigationHidden = i14;
                            }
                            i15 = configuration.orientation;
                            i16 = configuration2.orientation;
                            if (i15 != i16) {
                                configuration3.orientation = i16;
                            }
                            i17 = configuration.screenLayout & 15;
                            i18 = configuration2.screenLayout & 15;
                            if (i17 != i18) {
                                configuration3.screenLayout |= i18;
                            }
                            i19 = configuration.screenLayout & 192;
                            i20 = configuration2.screenLayout & 192;
                            if (i19 != i20) {
                                configuration3.screenLayout |= i20;
                            }
                            i21 = configuration.screenLayout & 48;
                            i22 = configuration2.screenLayout & 48;
                            if (i21 != i22) {
                                configuration3.screenLayout |= i22;
                            }
                            i23 = configuration.screenLayout & 768;
                            i24 = configuration2.screenLayout & 768;
                            if (i23 != i24) {
                                configuration3.screenLayout |= i24;
                            }
                            i25 = configuration.colorMode & 3;
                            i26 = configuration2.colorMode & 3;
                            if (i25 != i26) {
                                configuration3.colorMode |= i26;
                            }
                            i27 = configuration.colorMode & 12;
                            i28 = configuration2.colorMode & 12;
                            if (i27 != i28) {
                                configuration3.colorMode |= i28;
                            }
                            i29 = configuration.uiMode & 15;
                            i30 = configuration2.uiMode & 15;
                            if (i29 != i30) {
                                configuration3.uiMode |= i30;
                            }
                            i31 = configuration.uiMode & 48;
                            i32 = configuration2.uiMode & 48;
                            if (i31 != i32) {
                                configuration3.uiMode |= i32;
                            }
                            i33 = configuration.screenWidthDp;
                            i34 = configuration2.screenWidthDp;
                            if (i33 != i34) {
                                configuration3.screenWidthDp = i34;
                            }
                            i35 = configuration.screenHeightDp;
                            i36 = configuration2.screenHeightDp;
                            if (i35 != i36) {
                                configuration3.screenHeightDp = i36;
                            }
                            i37 = configuration.smallestScreenWidthDp;
                            i38 = configuration2.smallestScreenWidthDp;
                            if (i37 != i38) {
                                configuration3.smallestScreenWidthDp = i38;
                            }
                            i39 = configuration.densityDpi;
                            i40 = configuration2.densityDpi;
                            if (i39 != i40) {
                                configuration3.densityDpi = i40;
                            }
                        }
                    } else {
                        configuration3 = null;
                    }
                    Configuration configurationCreateOverrideAppConfiguration2 = AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, configuration3, true);
                    contextThemeWrapper = new ContextThemeWrapper(context, com.yalantis.ucrop.R.style.Theme_AppCompat_Empty);
                    contextThemeWrapper.applyOverrideConfiguration(configurationCreateOverrideAppConfiguration2);
                    if (context.getTheme() != null) {
                        theme = contextThemeWrapper.getTheme();
                        if (Build.VERSION.SDK_INT >= 29) {
                            ResourcesCompat$ThemeCompat$Api29Impl.rebase(theme);
                        } else {
                            synchronized (CamUtils.sRebaseMethodLock) {
                                if (CamUtils.sRebaseMethodFetched) {
                                    Method declaredMethod2 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    CamUtils.sRebaseMethod = declaredMethod2;
                                    declaredMethod2.setAccessible(true);
                                    CamUtils.sRebaseMethodFetched = true;
                                    method = CamUtils.sRebaseMethod;
                                    if (method != null) {
                                        method.invoke(theme, null);
                                    }
                                } else {
                                    method = CamUtils.sRebaseMethod;
                                    if (method != null) {
                                        method.invoke(theme, null);
                                    }
                                }
                            }
                        }
                    }
                    context = contextThemeWrapper;
                }
            }
        } else if (context instanceof ContextThemeWrapper) {
            ((ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false));
        } else if (AppCompatDelegateImpl.sCanReturnDifferentContext) {
            Configuration configuration6 = new Configuration();
            configuration6.uiMode = -1;
            configuration6.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
            configuration = context.createConfigurationContext(configuration6).getResources().getConfiguration();
            configuration2 = context.getResources().getConfiguration();
            configuration.uiMode = configuration2.uiMode;
            if (configuration.equals(configuration2)) {
                configuration3 = new Configuration();
                configuration3.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
                if (configuration.diff(configuration2) != 0) {
                    f = configuration.fontScale;
                    f2 = configuration2.fontScale;
                    if (f != f2) {
                        configuration3.fontScale = f2;
                    }
                    i = configuration.mcc;
                    i2 = configuration2.mcc;
                    if (i != i2) {
                        configuration3.mcc = i2;
                    }
                    i3 = configuration.mnc;
                    i4 = configuration2.mnc;
                    if (i3 != i4) {
                        configuration3.mnc = i4;
                    }
                    locales = configuration.getLocales();
                    locales2 = configuration2.getLocales();
                    if (!locales.equals(locales2)) {
                        configuration3.setLocales(locales2);
                        configuration3.locale = configuration2.locale;
                    }
                    i5 = configuration.touchscreen;
                    i6 = configuration2.touchscreen;
                    if (i5 != i6) {
                        configuration3.touchscreen = i6;
                    }
                    i7 = configuration.keyboard;
                    i8 = configuration2.keyboard;
                    if (i7 != i8) {
                        configuration3.keyboard = i8;
                    }
                    i9 = configuration.keyboardHidden;
                    i10 = configuration2.keyboardHidden;
                    if (i9 != i10) {
                        configuration3.keyboardHidden = i10;
                    }
                    i11 = configuration.navigation;
                    i12 = configuration2.navigation;
                    if (i11 != i12) {
                        configuration3.navigation = i12;
                    }
                    i13 = configuration.navigationHidden;
                    i14 = configuration2.navigationHidden;
                    if (i13 != i14) {
                        configuration3.navigationHidden = i14;
                    }
                    i15 = configuration.orientation;
                    i16 = configuration2.orientation;
                    if (i15 != i16) {
                        configuration3.orientation = i16;
                    }
                    i17 = configuration.screenLayout & 15;
                    i18 = configuration2.screenLayout & 15;
                    if (i17 != i18) {
                        configuration3.screenLayout |= i18;
                    }
                    i19 = configuration.screenLayout & 192;
                    i20 = configuration2.screenLayout & 192;
                    if (i19 != i20) {
                        configuration3.screenLayout |= i20;
                    }
                    i21 = configuration.screenLayout & 48;
                    i22 = configuration2.screenLayout & 48;
                    if (i21 != i22) {
                        configuration3.screenLayout |= i22;
                    }
                    i23 = configuration.screenLayout & 768;
                    i24 = configuration2.screenLayout & 768;
                    if (i23 != i24) {
                        configuration3.screenLayout |= i24;
                    }
                    i25 = configuration.colorMode & 3;
                    i26 = configuration2.colorMode & 3;
                    if (i25 != i26) {
                        configuration3.colorMode |= i26;
                    }
                    i27 = configuration.colorMode & 12;
                    i28 = configuration2.colorMode & 12;
                    if (i27 != i28) {
                        configuration3.colorMode |= i28;
                    }
                    i29 = configuration.uiMode & 15;
                    i30 = configuration2.uiMode & 15;
                    if (i29 != i30) {
                        configuration3.uiMode |= i30;
                    }
                    i31 = configuration.uiMode & 48;
                    i32 = configuration2.uiMode & 48;
                    if (i31 != i32) {
                        configuration3.uiMode |= i32;
                    }
                    i33 = configuration.screenWidthDp;
                    i34 = configuration2.screenWidthDp;
                    if (i33 != i34) {
                        configuration3.screenWidthDp = i34;
                    }
                    i35 = configuration.screenHeightDp;
                    i36 = configuration2.screenHeightDp;
                    if (i35 != i36) {
                        configuration3.screenHeightDp = i36;
                    }
                    i37 = configuration.smallestScreenWidthDp;
                    i38 = configuration2.smallestScreenWidthDp;
                    if (i37 != i38) {
                        configuration3.smallestScreenWidthDp = i38;
                    }
                    i39 = configuration.densityDpi;
                    i40 = configuration2.densityDpi;
                    if (i39 != i40) {
                        configuration3.densityDpi = i40;
                    }
                }
            } else {
                configuration3 = null;
            }
            Configuration configurationCreateOverrideAppConfiguration3 = AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, configuration3, true);
            contextThemeWrapper = new ContextThemeWrapper(context, com.yalantis.ucrop.R.style.Theme_AppCompat_Empty);
            contextThemeWrapper.applyOverrideConfiguration(configurationCreateOverrideAppConfiguration3);
            if (context.getTheme() != null) {
                theme = contextThemeWrapper.getTheme();
                if (Build.VERSION.SDK_INT >= 29) {
                    ResourcesCompat$ThemeCompat$Api29Impl.rebase(theme);
                } else {
                    synchronized (CamUtils.sRebaseMethodLock) {
                        if (CamUtils.sRebaseMethodFetched) {
                            Method declaredMethod3 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            CamUtils.sRebaseMethod = declaredMethod3;
                            declaredMethod3.setAccessible(true);
                            CamUtils.sRebaseMethodFetched = true;
                            method = CamUtils.sRebaseMethod;
                            if (method != null) {
                                method.invoke(theme, null);
                            }
                        } else {
                            method = CamUtils.sRebaseMethod;
                            if (method != null) {
                                method.invoke(theme, null);
                            }
                        }
                    }
                }
            }
            context = contextThemeWrapper;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.onMenuKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        return (T) appCompatDelegateImpl.mWindow.findViewById(i);
    }

    public AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = this.mDelegate;
        if (appCompatDelegate != null) {
            return appCompatDelegate;
        }
        TransactionExecutor transactionExecutor = AppCompatDelegate.sSerialExecutorForLocalesStorage;
        AppCompatDelegateImpl appCompatDelegateImpl = new AppCompatDelegateImpl(this, null, this, this);
        this.mDelegate = appCompatDelegateImpl;
        return appCompatDelegateImpl;
    }

    public ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        ((AppCompatDelegateImpl) getDelegate()).getClass();
        return new Lock((byte) 1);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        SupportMenuInflater supportMenuInflater = appCompatDelegateImpl.mMenuInflater;
        if (supportMenuInflater == null) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            supportMenuInflater = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : appCompatDelegateImpl.mContext);
            appCompatDelegateImpl.mMenuInflater = supportMenuInflater;
        }
        return supportMenuInflater;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public ActionBar getSupportActionBar() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        return appCompatDelegateImpl.mActionBar;
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHasActionBar && appCompatDelegateImpl.mSubDecorInstalled) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null) {
                actionBar.onConfigurationChanged();
            }
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = appCompatDelegateImpl.mContext;
        synchronized (appCompatDrawableManager) {
            ResourceManagerInternal resourceManagerInternal = appCompatDrawableManager.mResourceManager;
            synchronized (resourceManagerInternal) {
                LongSparseArray longSparseArray = (LongSparseArray) resourceManagerInternal.mDrawableCaches.get(context);
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
        appCompatDelegateImpl.mEffectiveConfiguration = new Configuration(appCompatDelegateImpl.mContext.getResources().getConfiguration());
        appCompatDelegateImpl.applyApplicationSpecificConfig(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = NavUtils.getParentActivityIntent(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(taskStackBuilder.mSourceContext.getPackageManager());
            }
            taskStackBuilder.addParentStack(component);
            taskStackBuilder.mIntents.add(supportParentActivityIntent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((AppCompatDelegateImpl) getDelegate()).ensureSubDecor();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ((AppCompatDelegateImpl) getDelegate()).applyApplicationSpecificConfig(true, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        TaskStackBuilder taskStackBuilder = new TaskStackBuilder(this);
        onCreateSupportNavigateUpTaskStack(taskStackBuilder);
        onPrepareSupportNavigateUpTaskStack(taskStackBuilder);
        taskStackBuilder.startActivities();
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        getDelegate().setContentView(i);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHost instanceof Activity) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar instanceof WindowDecorActionBar) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
                return;
            }
            appCompatDelegateImpl.mMenuInflater = null;
            if (actionBar != null) {
                actionBar.onDestroy();
            }
            appCompatDelegateImpl.mActionBar = null;
            if (toolbar != null) {
                Object obj = appCompatDelegateImpl.mHost;
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : appCompatDelegateImpl.mTitle, appCompatDelegateImpl.mAppCompatWindowCallback);
                appCompatDelegateImpl.mActionBar = toolbarActionBar;
                appCompatDelegateImpl.mAppCompatWindowCallback.mActionBarCallback = toolbarActionBar.mMenuCallback;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                appCompatDelegateImpl.mAppCompatWindowCallback.mActionBarCallback = null;
            }
            appCompatDelegateImpl.invalidateOptionsMenu();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((AppCompatDelegateImpl) getDelegate()).mThemeResId = i;
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return getDelegate().startSupportActionMode(callback);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().requestWindowFeature(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        getDelegate().setContentView(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        getDelegate().setContentView(view, layoutParams);
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements SavedStateRegistry.SavedStateProvider {
        public final /* synthetic */ byte $r8$classId;
        public final Object this$0;

        public AnonymousClass1(SavedStateRegistry savedStateRegistry) {
            this.$r8$classId = (byte) 1;
            this.this$0 = new LinkedHashSet();
            savedStateRegistry.registerSavedStateProvider("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public final Bundle saveState() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    Bundle bundle = new Bundle();
                    ((UCropActivity) obj).getDelegate().getClass();
                    return bundle;
                default:
                    Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    LifecyclesKt.m887putStringListimpl(bundleBundleOf, "classes_to_restore", CollectionsKt.toList((LinkedHashSet) obj));
                    return bundleBundleOf;
            }
        }

        public AnonymousClass1(UCropActivity uCropActivity) {
            this.$r8$classId = (byte) 0;
            this.this$0 = uCropActivity;
        }
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public void onLocalesChanged(LocaleListCompat localeListCompat) {
    }

    public void onNightModeChanged(int i) {
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }
}
