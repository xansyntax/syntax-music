package androidx.media3.session.legacy;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MediaSessionManager$RemoteUserInfoImplBase {
    public final String packageName;
    public final int pid;
    public final int uid;

    public MediaSessionManager$RemoteUserInfoImplBase(String str, int i, int i2) {
        this.packageName = str;
        this.pid = i;
        this.uid = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionManager$RemoteUserInfoImplBase)) {
            return false;
        }
        MediaSessionManager$RemoteUserInfoImplBase mediaSessionManager$RemoteUserInfoImplBase = (MediaSessionManager$RemoteUserInfoImplBase) obj;
        int i = mediaSessionManager$RemoteUserInfoImplBase.uid;
        String str = mediaSessionManager$RemoteUserInfoImplBase.packageName;
        int i2 = mediaSessionManager$RemoteUserInfoImplBase.pid;
        int i3 = this.uid;
        String str2 = this.packageName;
        int i4 = this.pid;
        if (i4 < 0 || i2 < 0) {
            return TextUtils.equals(str2, str) && i3 == i;
        }
        return TextUtils.equals(str2, str) && i4 == i2 && i3 == i;
    }

    public final int hashCode() {
        return Objects.hash(this.packageName, Integer.valueOf(this.uid));
    }
}
