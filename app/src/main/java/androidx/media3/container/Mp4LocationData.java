package androidx.media3.container;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Mp4LocationData implements Metadata.Entry {
    public final float latitude;
    public final float longitude;

    public Mp4LocationData(float f, float f2) {
        UtilsKt.checkArgument("Invalid latitude or longitude", f >= -90.0f && f <= 90.0f && f2 >= -180.0f && f2 <= 180.0f);
        this.latitude = f;
        this.longitude = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Mp4LocationData.class == obj.getClass()) {
            Mp4LocationData mp4LocationData = (Mp4LocationData) obj;
            if (this.latitude == mp4LocationData.latitude && this.longitude == mp4LocationData.longitude) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.longitude) + IntIntPair$$ExternalSyntheticOutline0.m(this.latitude, 527, 31);
    }

    public final String toString() {
        return "xyz: latitude=" + this.latitude + ", longitude=" + this.longitude;
    }
}
