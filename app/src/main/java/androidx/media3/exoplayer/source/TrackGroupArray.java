package androidx.media3.exoplayer.source;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TrackGroupArray {
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    public static final String FIELD_TRACK_GROUPS;
    public int hashCode;
    public final int length;
    public final RegularImmutableList trackGroups;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_TRACK_GROUPS = Integer.toString(0, 36);
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        RegularImmutableList regularImmutableListCopyOf = ImmutableList.copyOf(trackGroupArr);
        this.trackGroups = regularImmutableListCopyOf;
        this.length = trackGroupArr.length;
        int i = 0;
        while (i < regularImmutableListCopyOf.size) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < regularImmutableListCopyOf.size; i3++) {
                if (((TrackGroup) regularImmutableListCopyOf.get(i)).equals(regularImmutableListCopyOf.get(i3))) {
                    Log.e("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.length == trackGroupArray.length && this.trackGroups.equals(trackGroupArray.trackGroups);
    }

    public final TrackGroup get(int i) {
        return (TrackGroup) this.trackGroups.get(i);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.trackGroups.hashCode();
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        return this.trackGroups.toString();
    }
}
