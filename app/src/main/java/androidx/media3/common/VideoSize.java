package androidx.media3.common;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoSize {
    public static final String FIELD_HEIGHT;
    public static final String FIELD_PIXEL_WIDTH_HEIGHT_RATIO;
    public static final String FIELD_WIDTH;
    public static final VideoSize UNKNOWN = new VideoSize(0, 0);
    public final int height;
    public final float pixelWidthHeightRatio;
    public final int width;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_WIDTH = Integer.toString(0, 36);
        FIELD_HEIGHT = Integer.toString(1, 36);
        FIELD_PIXEL_WIDTH_HEIGHT_RATIO = Integer.toString(3, 36);
    }

    public VideoSize(float f, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.pixelWidthHeightRatio = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoSize) {
            VideoSize videoSize = (VideoSize) obj;
            if (this.width == videoSize.width && this.height == videoSize.height && this.pixelWidthHeightRatio == videoSize.pixelWidthHeightRatio) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.pixelWidthHeightRatio) + ((((217 + this.width) * 31) + this.height) * 31);
    }

    public VideoSize(int i, int i2) {
        this(1.0f, i, i2);
    }
}
