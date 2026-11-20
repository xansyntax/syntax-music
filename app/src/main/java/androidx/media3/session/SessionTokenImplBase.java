package androidx.media3.session;

import android.content.ComponentName;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionTokenImplBase implements SessionToken.SessionTokenImpl {
    public static final String FIELD_COMPONENT_NAME;
    public static final String FIELD_EXTRAS;
    public static final String FIELD_INTERFACE_VERSION;
    public static final String FIELD_ISESSION;
    public static final String FIELD_LIBRARY_VERSION;
    public static final String FIELD_PACKAGE_NAME;
    public static final String FIELD_PLATFORM_TOKEN;
    public static final String FIELD_SERVICE_NAME;
    public static final String FIELD_TYPE;
    public static final String FIELD_UID;
    public final ComponentName componentName;
    public final Bundle extras;
    public final IBinder iSession;
    public final int interfaceVersion;
    public final int libraryVersion;
    public final String packageName;
    public final MediaSession.Token platformToken;
    public final String serviceName;
    public final int type;
    public final int uid;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_UID = Integer.toString(0, 36);
        FIELD_TYPE = Integer.toString(1, 36);
        FIELD_LIBRARY_VERSION = Integer.toString(2, 36);
        FIELD_PACKAGE_NAME = Integer.toString(3, 36);
        FIELD_SERVICE_NAME = Integer.toString(4, 36);
        FIELD_COMPONENT_NAME = Integer.toString(5, 36);
        FIELD_ISESSION = Integer.toString(6, 36);
        FIELD_EXTRAS = Integer.toString(7, 36);
        FIELD_INTERFACE_VERSION = Integer.toString(8, 36);
        FIELD_PLATFORM_TOKEN = Integer.toString(9, 36);
    }

    public SessionTokenImplBase(int i, int i2, int i3, int i4, String str, String str2, ComponentName componentName, IBinder iBinder, Bundle bundle, MediaSession.Token token) {
        this.uid = i;
        this.type = i2;
        this.libraryVersion = i3;
        this.interfaceVersion = i4;
        this.packageName = str;
        this.serviceName = str2;
        this.componentName = componentName;
        this.iSession = iBinder;
        this.extras = bundle;
        this.platformToken = token;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplBase)) {
            return false;
        }
        SessionTokenImplBase sessionTokenImplBase = (SessionTokenImplBase) obj;
        return this.uid == sessionTokenImplBase.uid && this.type == sessionTokenImplBase.type && this.libraryVersion == sessionTokenImplBase.libraryVersion && this.interfaceVersion == sessionTokenImplBase.interfaceVersion && TextUtils.equals(this.packageName, sessionTokenImplBase.packageName) && TextUtils.equals(this.serviceName, sessionTokenImplBase.serviceName) && Objects.equals(this.componentName, sessionTokenImplBase.componentName) && Objects.equals(this.iSession, sessionTokenImplBase.iSession) && Objects.equals(this.platformToken, sessionTokenImplBase.platformToken);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Object getBinder() {
        return this.iSession;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Bundle getExtras() {
        return new Bundle(this.extras);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int getInterfaceVersion() {
        return this.interfaceVersion;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final String getPackageName() {
        return this.packageName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final MediaSession.Token getPlatformToken() {
        return this.platformToken;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final String getServiceName() {
        return this.serviceName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int getType() {
        return this.type;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int getUid() {
        return this.uid;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.uid), Integer.valueOf(this.type), Integer.valueOf(this.libraryVersion), Integer.valueOf(this.interfaceVersion), this.packageName, this.serviceName, this.componentName, this.iSession, this.platformToken);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final boolean isLegacySession() {
        return false;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_UID, this.uid);
        bundle.putInt(FIELD_TYPE, this.type);
        bundle.putInt(FIELD_LIBRARY_VERSION, this.libraryVersion);
        bundle.putString(FIELD_PACKAGE_NAME, this.packageName);
        bundle.putString(FIELD_SERVICE_NAME, this.serviceName);
        bundle.putBinder(FIELD_ISESSION, this.iSession);
        bundle.putParcelable(FIELD_COMPONENT_NAME, this.componentName);
        bundle.putBundle(FIELD_EXTRAS, this.extras);
        bundle.putInt(FIELD_INTERFACE_VERSION, this.interfaceVersion);
        MediaSession.Token token = this.platformToken;
        if (token != null) {
            bundle.putParcelable(FIELD_PLATFORM_TOKEN, token);
        }
        return bundle;
    }

    public final String toString() {
        return "SessionToken {pkg=" + this.packageName + " type=" + this.type + " libraryVersion=" + this.libraryVersion + " interfaceVersion=" + this.interfaceVersion + " service=" + this.serviceName + " IMediaSession=" + this.iSession + " extras=" + this.extras + "}";
    }
}
