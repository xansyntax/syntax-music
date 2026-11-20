package androidx.media3.session;

import android.content.ComponentName;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionTokenImplLegacy implements SessionToken.SessionTokenImpl {
    public static final String FIELD_COMPONENT_NAME;
    public static final String FIELD_EXTRAS;
    public static final String FIELD_LEGACY_TOKEN;
    public static final String FIELD_PACKAGE_NAME;
    public static final String FIELD_TYPE;
    public static final String FIELD_UID;
    public final ComponentName componentName;
    public final String packageName;
    public final int uid;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_LEGACY_TOKEN = Integer.toString(0, 36);
        FIELD_UID = Integer.toString(1, 36);
        FIELD_TYPE = Integer.toString(2, 36);
        FIELD_COMPONENT_NAME = Integer.toString(3, 36);
        FIELD_PACKAGE_NAME = Integer.toString(4, 36);
        FIELD_EXTRAS = Integer.toString(5, 36);
    }

    public SessionTokenImplLegacy(ComponentName componentName, int i) {
        String packageName = componentName.getPackageName();
        Bundle bundle = Bundle.EMPTY;
        UtilsKt.checkArgument((Build.MANUFACTURER.equals("samsung") && Build.VERSION.SDK_INT == 36) || !TextUtils.isEmpty(packageName));
        this.uid = i;
        this.componentName = componentName;
        this.packageName = packageName;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SessionTokenImplLegacy) {
            return this.componentName.equals(((SessionTokenImplLegacy) obj).componentName);
        }
        return false;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Object getBinder() {
        return null;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Bundle getExtras() {
        return new Bundle(Bundle.EMPTY);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int getInterfaceVersion() {
        return 0;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final String getPackageName() {
        return this.packageName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final MediaSession.Token getPlatformToken() {
        return null;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final String getServiceName() {
        return this.componentName.getClassName();
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int getType() {
        return 2;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int getUid() {
        return this.uid;
    }

    public final int hashCode() {
        return Objects.hash(101, this.componentName, null);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final boolean isLegacySession() {
        return true;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(FIELD_LEGACY_TOKEN, null);
        bundle.putInt(FIELD_UID, this.uid);
        bundle.putInt(FIELD_TYPE, 101);
        bundle.putParcelable(FIELD_COMPONENT_NAME, this.componentName);
        bundle.putString(FIELD_PACKAGE_NAME, this.packageName);
        bundle.putBundle(FIELD_EXTRAS, Bundle.EMPTY);
        return bundle;
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m(new StringBuilder("SessionToken {legacy, uid="), this.uid, "}");
    }
}
