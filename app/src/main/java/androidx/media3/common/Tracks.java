package androidx.media3.common;

import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Tracks {
    public static final Tracks EMPTY;
    public static final String FIELD_TRACK_GROUPS;
    public final ImmutableList groups;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Group {
        public static final String FIELD_ADAPTIVE_SUPPORTED;
        public static final String FIELD_TRACK_GROUP;
        public static final String FIELD_TRACK_SELECTED;
        public static final String FIELD_TRACK_SUPPORT;
        public final boolean adaptiveSupported;
        public final int length;
        public final TrackGroup mediaTrackGroup;
        public final boolean[] trackSelected;
        public final int[] trackSupport;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_TRACK_GROUP = Integer.toString(0, 36);
            FIELD_TRACK_SUPPORT = Integer.toString(1, 36);
            FIELD_TRACK_SELECTED = Integer.toString(3, 36);
            FIELD_ADAPTIVE_SUPPORTED = Integer.toString(4, 36);
        }

        public Group(TrackGroup trackGroup, boolean z, int[] iArr, boolean[] zArr) {
            int i = trackGroup.length;
            this.length = i;
            boolean z2 = false;
            UtilsKt.checkArgument(i == iArr.length && i == zArr.length);
            this.mediaTrackGroup = trackGroup;
            if (z && i > 1) {
                z2 = true;
            }
            this.adaptiveSupported = z2;
            this.trackSupport = (int[]) iArr.clone();
            this.trackSelected = (boolean[]) zArr.clone();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Group.class != obj.getClass()) {
                return false;
            }
            Group group = (Group) obj;
            return this.adaptiveSupported == group.adaptiveSupported && this.mediaTrackGroup.equals(group.mediaTrackGroup) && Arrays.equals(this.trackSupport, group.trackSupport) && Arrays.equals(this.trackSelected, group.trackSelected);
        }

        public final int hashCode() {
            return Arrays.hashCode(this.trackSelected) + ((Arrays.hashCode(this.trackSupport) + (((this.mediaTrackGroup.hashCode() * 31) + (this.adaptiveSupported ? 1 : 0)) * 31)) * 31);
        }
    }

    static {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        EMPTY = new Tracks(RegularImmutableList.EMPTY);
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_TRACK_GROUPS = Integer.toString(0, 36);
    }

    public Tracks(RegularImmutableList regularImmutableList) {
        this.groups = ImmutableList.copyOf((Collection) regularImmutableList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Tracks.class != obj.getClass()) {
            return false;
        }
        return this.groups.equals(((Tracks) obj).groups);
    }

    public final int hashCode() {
        return this.groups.hashCode();
    }

    public final boolean isTypeSelected(int i) {
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.groups;
            if (i2 >= immutableList.size()) {
                return false;
            }
            Group group = (Group) immutableList.get(i2);
            for (boolean z : group.trackSelected) {
                if (z) {
                    if (group.mediaTrackGroup.type != i) {
                        break;
                    }
                    return true;
                }
            }
            i2++;
        }
    }
}
