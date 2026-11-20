package androidx.media3.session;

import android.os.Bundle;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSession$ControllerInfo {
    public final Bundle connectionHints;
    public final MediaSession$ControllerCb controllerCb;
    public final int interfaceVersion;
    public final int libraryVersion;
    public final MediaSessionManager$RemoteUserInfo remoteUserInfo;

    public MediaSession$ControllerInfo(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, int i, int i2, boolean z, MediaSession$ControllerCb mediaSession$ControllerCb, Bundle bundle) {
        this.remoteUserInfo = mediaSessionManager$RemoteUserInfo;
        this.libraryVersion = i;
        this.interfaceVersion = i2;
        this.controllerCb = mediaSession$ControllerCb;
        this.connectionHints = bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MediaSession$ControllerInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) obj;
        MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
        MediaSession$ControllerCb mediaSession$ControllerCb2 = this.controllerCb;
        return (mediaSession$ControllerCb2 == null && mediaSession$ControllerCb == null) ? this.remoteUserInfo.equals(mediaSession$ControllerInfo.remoteUserInfo) : Objects.equals(mediaSession$ControllerCb2, mediaSession$ControllerCb);
    }

    public final int hashCode() {
        return Objects.hash(this.controllerCb, this.remoteUserInfo);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ControllerInfo {pkg=");
        MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = this.remoteUserInfo;
        sb.append(mediaSessionManager$RemoteUserInfo.impl.packageName);
        sb.append(", uid=");
        return Fragment$5$$ExternalSyntheticOutline0.m(sb, mediaSessionManager$RemoteUserInfo.impl.uid, "}");
    }
}
