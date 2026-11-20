package androidx.media3.session.legacy;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager$RemoteUserInfo {
    public final MediaSessionManager$RemoteUserInfoImplBase impl;

    public MediaSessionManager$RemoteUserInfo(String str, int i, int i2) {
        if (str == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("package shouldn't be null");
            throw null;
        }
        if (TextUtils.isEmpty(str)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("packageName should be nonempty");
            throw null;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.impl = new MediaSessionManager$RemoteUserInfoImplBase(str, i, i2) { // from class: androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfoImplApi28
                {
                    super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
                }

                public static String getPackageName(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
                    return remoteUserInfo.getPackageName();
                }
            };
        } else {
            this.impl = new MediaSessionManager$RemoteUserInfoImplBase(str, i, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionManager$RemoteUserInfo)) {
            return false;
        }
        return this.impl.equals(((MediaSessionManager$RemoteUserInfo) obj).impl);
    }

    public final int hashCode() {
        return this.impl.hashCode();
    }

    public MediaSessionManager$RemoteUserInfo(final MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String packageName = MediaSessionManager$RemoteUserInfoImplApi28.getPackageName(remoteUserInfo);
        if (packageName != null) {
            if (!TextUtils.isEmpty(packageName)) {
                this.impl = new MediaSessionManager$RemoteUserInfoImplBase(remoteUserInfo) { // from class: androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfoImplApi28
                    {
                        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
                    }

                    public static String getPackageName(MediaSessionManager.RemoteUserInfo remoteUserInfo2) {
                        return remoteUserInfo2.getPackageName();
                    }
                };
                return;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("packageName should be nonempty");
                throw null;
            }
        }
        PathKt$$ExternalSyntheticBUOutline0.m("package shouldn't be null");
        throw null;
    }
}
