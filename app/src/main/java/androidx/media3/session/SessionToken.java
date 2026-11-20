package androidx.media3.session;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;
import com.metrolist.music.playback.MusicService;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionToken {
    public static final String FIELD_IMPL;
    public static final String FIELD_IMPL_TYPE;
    public final SessionTokenImpl impl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SessionTokenImpl {
        Object getBinder();

        ComponentName getComponentName();

        Bundle getExtras();

        int getInterfaceVersion();

        String getPackageName();

        MediaSession.Token getPlatformToken();

        String getServiceName();

        int getType();

        int getUid();

        boolean isLegacySession();

        Bundle toBundle();
    }

    static {
        MediaLibraryInfo.registerModule("media3.session");
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_IMPL_TYPE = Integer.toString(0, 36);
        FIELD_IMPL = Integer.toString(1, 36);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    /* JADX WARN: Code duplicated, block: B:18:0x0051  */
    public SessionToken(MusicService musicService, ComponentName componentName) {
        int i;
        int i2;
        int i3;
        PackageManager packageManager = musicService.getPackageManager();
        try {
            i = packageManager.getApplicationInfo(componentName.getPackageName(), 0).uid;
        } catch (PackageManager.NameNotFoundException unused) {
            i = -1;
        }
        int i4 = i;
        if (!isInterfaceDeclared(packageManager, "androidx.media3.session.MediaLibraryService", componentName)) {
            if (isInterfaceDeclared(packageManager, "androidx.media3.session.MediaSessionService", componentName)) {
                i3 = 1;
            } else {
                if (!isInterfaceDeclared(packageManager, "android.media.browse.MediaBrowserService", componentName)) {
                    throw new IllegalArgumentException("Failed to resolve SessionToken for " + componentName + ". Manifest doesn't declare one of either MediaSessionService, MediaLibraryService, MediaBrowserService or MediaBrowserServiceCompat. Use service's full name.");
                }
                i2 = 101;
            }
            if (i2 != 101) {
                this.impl = new SessionTokenImplBase(i4, i2, 1000000, 0, componentName.getPackageName(), componentName.getClassName(), componentName, null, Bundle.EMPTY, null);
            } else {
                this.impl = new SessionTokenImplLegacy(componentName, i4);
            }
        }
        i3 = 2;
        i2 = i3;
        if (i2 != 101) {
            this.impl = new SessionTokenImplBase(i4, i2, 1000000, 0, componentName.getPackageName(), componentName.getClassName(), componentName, null, Bundle.EMPTY, null);
        } else {
            this.impl = new SessionTokenImplLegacy(componentName, i4);
        }
    }

    public static boolean isInterfaceDeclared(PackageManager packageManager, String str, ComponentName componentName) {
        ServiceInfo serviceInfo;
        Intent intent = new Intent(str);
        intent.setPackage(componentName.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (listQueryIntentServices != null) {
            for (int i = 0; i < listQueryIntentServices.size(); i++) {
                ResolveInfo resolveInfo = listQueryIntentServices.get(i);
                if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && TextUtils.equals(serviceInfo.name, componentName.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SessionToken) {
            return this.impl.equals(((SessionToken) obj).impl);
        }
        return false;
    }

    public final int hashCode() {
        return this.impl.hashCode();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        SessionTokenImpl sessionTokenImpl = this.impl;
        boolean z = sessionTokenImpl instanceof SessionTokenImplBase;
        String str = FIELD_IMPL_TYPE;
        if (z) {
            bundle.putInt(str, 0);
        } else {
            bundle.putInt(str, 1);
        }
        bundle.putBundle(FIELD_IMPL, sessionTokenImpl.toBundle());
        return bundle;
    }

    public final String toString() {
        return this.impl.toString();
    }

    public SessionToken(int i, int i2, int i3, String str, IMediaSession iMediaSession, Bundle bundle, MediaSession.Token token) {
        str.getClass();
        IBinder iBinderAsBinder = iMediaSession.asBinder();
        bundle.getClass();
        this.impl = new SessionTokenImplBase(i, 0, i2, i3, str, "", null, iBinderAsBinder, bundle, token);
    }
}
