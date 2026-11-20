package androidx.media3.common;

import androidx.compose.ui.text.input.GapBuffer;
import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeviceInfo {
    public static final String FIELD_MAX_VOLUME;
    public static final String FIELD_MIN_VOLUME;
    public static final String FIELD_PLAYBACK_TYPE;
    public static final String FIELD_ROUTING_CONTROLLER_ID;
    public static final DeviceInfo UNKNOWN = new GapBuffer(0).build();
    public final int maxVolume;
    public final int minVolume;
    public final int playbackType;
    public final String routingControllerId;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_PLAYBACK_TYPE = Integer.toString(0, 36);
        FIELD_MIN_VOLUME = Integer.toString(1, 36);
        FIELD_MAX_VOLUME = Integer.toString(2, 36);
        FIELD_ROUTING_CONTROLLER_ID = Integer.toString(3, 36);
    }

    public DeviceInfo(GapBuffer gapBuffer) {
        this.playbackType = gapBuffer.capacity;
        this.minVolume = gapBuffer.gapStart;
        this.maxVolume = gapBuffer.gapEnd;
        this.routingControllerId = (String) gapBuffer.buffer;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.playbackType == deviceInfo.playbackType && this.minVolume == deviceInfo.minVolume && this.maxVolume == deviceInfo.maxVolume && Objects.equals(this.routingControllerId, deviceInfo.routingControllerId);
    }

    public final int hashCode() {
        int i = (((((527 + this.playbackType) * 31) + this.minVolume) * 31) + this.maxVolume) * 31;
        String str = this.routingControllerId;
        return i + (str == null ? 0 : str.hashCode());
    }
}
