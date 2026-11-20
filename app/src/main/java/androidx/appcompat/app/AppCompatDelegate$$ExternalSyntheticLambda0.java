package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.app.NavUtils;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListPlatformWrapper;
import androidx.profileinstaller.Encoding;
import com.metrolist.music.playback.DownloadUtil$$ExternalSyntheticLambda2;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegate$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ AppCompatDelegate$$ExternalSyntheticLambda0(Context context, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    @Override // java.lang.Runnable
    public final void run() {
        LocaleListCompat localeListCompat;
        Object systemService;
        Context context;
        byte b = this.$r8$classId;
        Context context2 = this.f$0;
        switch (b) {
            case 0:
                int i = Build.VERSION.SDK_INT;
                if (i >= 33) {
                    ComponentName componentName = new ComponentName(context2, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context2.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (i >= 33) {
                            ArraySet arraySet = AppCompatDelegate.sActivityDelegates;
                            arraySet.getClass();
                            ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
                            while (true) {
                                if (keyIterator.hasNext()) {
                                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) keyIterator.next()).get();
                                    if (appCompatDelegate != null && (context = ((AppCompatDelegateImpl) appCompatDelegate).mContext) != null) {
                                        systemService = context.getSystemService("locale");
                                    }
                                } else {
                                    systemService = null;
                                }
                            }
                            if (systemService != null) {
                                localeListCompat = new LocaleListCompat(new LocaleListPlatformWrapper(BundleCompat$Api33Impl.localeManagerGetApplicationLocales(systemService)));
                            } else {
                                localeListCompat = LocaleListCompat.sEmptyLocaleList;
                            }
                        } else {
                            localeListCompat = AppCompatDelegate.sRequestedAppLocales;
                            if (localeListCompat == null) {
                                localeListCompat = LocaleListCompat.sEmptyLocaleList;
                            }
                        }
                        if (localeListCompat.mImpl.mLocaleList.isEmpty()) {
                            String locales = NavUtils.readLocales(context2);
                            Object systemService2 = context2.getSystemService("locale");
                            if (systemService2 != null) {
                                BundleCompat$Api33Impl.localeManagerSetApplicationLocales(systemService2, LocaleList.forLanguageTags(locales));
                            }
                        }
                        context2.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    }
                }
                AppCompatDelegate.sIsFrameworkSyncChecked = true;
                break;
            case 1:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new AppCompatDelegate$$ExternalSyntheticLambda0(context2, (byte) 2));
                break;
            default:
                Encoding.writeProfile(context2, new DownloadUtil$$ExternalSyntheticLambda2((byte) 3), Encoding.EMPTY_DIAGNOSTICS, false);
                break;
        }
    }
}
