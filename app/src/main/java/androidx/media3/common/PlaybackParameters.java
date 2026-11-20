package androidx.media3.common;

import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public static final String FIELD_PITCH;
    public static final String FIELD_SPEED;
    public final float pitch;
    public final int scaledUsPerMs;
    public final float speed;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_SPEED = Integer.toString(0, 36);
        FIELD_PITCH = Integer.toString(1, 36);
    }

    public PlaybackParameters(float f, float f2) {
        UtilsKt.checkArgument(f > CropImageView.DEFAULT_ASPECT_RATIO);
        UtilsKt.checkArgument(f2 > CropImageView.DEFAULT_ASPECT_RATIO);
        this.speed = f;
        this.pitch = f2;
        this.scaledUsPerMs = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PlaybackParameters.class == obj.getClass()) {
            PlaybackParameters playbackParameters = (PlaybackParameters) obj;
            if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.pitch) + ((Float.floatToRawIntBits(this.speed) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.speed), Float.valueOf(this.pitch)};
        String str = Util.DEVICE_DEBUG_INFO;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }

    public PlaybackParameters(float f) {
        this(f, 1.0f);
    }
}
