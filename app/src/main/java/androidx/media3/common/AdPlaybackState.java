package androidx.media3.common;

import android.net.Uri;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AdPlaybackState {
    public static final String FIELD_AD_GROUPS;
    public static final String FIELD_AD_RESUME_POSITION_US;
    public static final String FIELD_CONTENT_DURATION_US;
    public static final String FIELD_REMOVED_AD_GROUP_COUNT;
    public static final AdPlaybackState NONE = new AdPlaybackState(new AdGroup[0], 0, -9223372036854775807L, 0);
    public static final AdGroup REMOVED_AD_GROUP;
    public final int adGroupCount;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;
    public final int removedAdGroupCount;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AdGroup {
        public static final String FIELD_CONTENT_RESUME_OFFSET_US;
        public static final String FIELD_COUNT;
        public static final String FIELD_DURATIONS_US;
        public static final String FIELD_IDS;
        public static final String FIELD_IS_PLACEHOLDER;
        public static final String FIELD_IS_SERVER_SIDE_INSERTED;
        public static final String FIELD_MEDIA_ITEMS;
        public static final String FIELD_ORIGINAL_COUNT;
        public static final String FIELD_SKIP_INFOS;
        public static final String FIELD_STATES;
        public static final String FIELD_TIME_US;
        public static final String FIELD_URIS;
        public final long contentResumeOffsetUs;
        public final int count;
        public final long[] durationsUs;
        public final String[] ids;
        public final boolean isPlaceholder;
        public final boolean isServerSideInserted;
        public final MediaItem[] mediaItems;
        public final int originalCount;
        public final SkipInfo[] skipInfos;
        public final int[] states;
        public final long timeUs;
        public final Uri[] uris;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_TIME_US = Integer.toString(0, 36);
            FIELD_COUNT = Integer.toString(1, 36);
            FIELD_URIS = Integer.toString(2, 36);
            FIELD_STATES = Integer.toString(3, 36);
            FIELD_DURATIONS_US = Integer.toString(4, 36);
            FIELD_CONTENT_RESUME_OFFSET_US = Integer.toString(5, 36);
            FIELD_IS_SERVER_SIDE_INSERTED = Integer.toString(6, 36);
            FIELD_ORIGINAL_COUNT = Integer.toString(7, 36);
            FIELD_MEDIA_ITEMS = Integer.toString(8, 36);
            FIELD_IDS = Integer.toString(9, 36);
            FIELD_IS_PLACEHOLDER = Integer.toString(10, 36);
            FIELD_SKIP_INFOS = Integer.toString(11, 36);
        }

        public AdGroup(long j, int i, int i2, int[] iArr, MediaItem[] mediaItemArr, long[] jArr, long j2, boolean z, String[] strArr, SkipInfo[] skipInfoArr, boolean z2) {
            Uri uri;
            int i3 = 0;
            UtilsKt.checkArgument(iArr.length == mediaItemArr.length);
            UtilsKt.checkArgument(iArr.length == skipInfoArr.length);
            this.timeUs = j;
            this.count = i;
            this.originalCount = i2;
            this.states = iArr;
            this.mediaItems = mediaItemArr;
            this.durationsUs = jArr;
            this.contentResumeOffsetUs = j2;
            this.isServerSideInserted = z;
            this.uris = new Uri[mediaItemArr.length];
            while (true) {
                Uri[] uriArr = this.uris;
                if (i3 >= uriArr.length) {
                    this.ids = strArr;
                    this.skipInfos = skipInfoArr;
                    this.isPlaceholder = z2;
                    return;
                }
                MediaItem mediaItem = mediaItemArr[i3];
                if (mediaItem == null) {
                    uri = null;
                } else {
                    MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
                    localConfiguration.getClass();
                    uri = localConfiguration.uri;
                }
                uriArr[i3] = uri;
                i3++;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            return this.timeUs == adGroup.timeUs && this.count == adGroup.count && this.originalCount == adGroup.originalCount && Arrays.equals(this.mediaItems, adGroup.mediaItems) && Arrays.equals(this.states, adGroup.states) && Arrays.equals(this.durationsUs, adGroup.durationsUs) && this.contentResumeOffsetUs == adGroup.contentResumeOffsetUs && this.isServerSideInserted == adGroup.isServerSideInserted && Arrays.equals(this.ids, adGroup.ids) && Arrays.equals(this.skipInfos, adGroup.skipInfos) && this.isPlaceholder == adGroup.isPlaceholder;
        }

        public final int getNextAdIndexToPlay(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.states;
                if (i3 >= iArr.length || this.isServerSideInserted || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public final int hashCode() {
            int i = ((this.count * 31) + this.originalCount) * 31;
            long j = this.timeUs;
            int iHashCode = (Arrays.hashCode(this.durationsUs) + ((Arrays.hashCode(this.states) + ((Arrays.hashCode(this.mediaItems) + ((i + ((int) (j ^ (j >>> 32)))) * 31)) * 31)) * 31)) * 31;
            long j2 = this.contentResumeOffsetUs;
            return ((Arrays.hashCode(this.skipInfos) + ((((((iHashCode + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.isServerSideInserted ? 1 : 0)) * 31) + Arrays.hashCode(this.ids)) * 31)) * 31) + (this.isPlaceholder ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SkipInfo {
        public static final String FIELD_LABEL_ID;
        public static final String FIELD_SKIP_DURATION_US;
        public static final String FIELD_SKIP_OFFSET_US;
        public final String labelId;
        public final long skipDurationUs;
        public final long skipOffsetUs;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_SKIP_OFFSET_US = Integer.toString(0, 36);
            FIELD_SKIP_DURATION_US = Integer.toString(1, 36);
            FIELD_LABEL_ID = Integer.toString(2, 36);
        }

        public SkipInfo(long j, long j2, String str) {
            UtilsKt.checkArgument((j == -9223372036854775807L && j2 == -9223372036854775807L && str == null) ? false : true);
            this.skipOffsetUs = j == -9223372036854775807L ? 0L : j;
            this.skipDurationUs = j2;
            this.labelId = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SkipInfo.class == obj.getClass()) {
                SkipInfo skipInfo = (SkipInfo) obj;
                if (this.skipOffsetUs == skipInfo.skipOffsetUs && this.skipDurationUs == skipInfo.skipDurationUs && Objects.equals(this.labelId, skipInfo.labelId)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Long.valueOf(this.skipOffsetUs), Long.valueOf(this.skipDurationUs), this.labelId);
        }
    }

    static {
        AdGroup adGroup = new AdGroup(0L, -1, -1, new int[0], new MediaItem[0], new long[0], 0L, false, new String[0], new SkipInfo[0], false);
        int[] iArr = adGroup.states;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = adGroup.durationsUs;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
        MediaItem[] mediaItemArr = (MediaItem[]) Arrays.copyOf(adGroup.mediaItems, 0);
        String[] strArr = (String[]) Arrays.copyOf(adGroup.ids, 0);
        SkipInfo[] skipInfoArr = adGroup.skipInfos;
        REMOVED_AD_GROUP = new AdGroup(adGroup.timeUs, 0, adGroup.originalCount, iArrCopyOf, mediaItemArr, jArrCopyOf, adGroup.contentResumeOffsetUs, adGroup.isServerSideInserted, strArr, (SkipInfo[]) Arrays.copyOf(skipInfoArr, Math.max(0, skipInfoArr.length)), adGroup.isPlaceholder);
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_AD_GROUPS = Integer.toString(1, 36);
        FIELD_AD_RESUME_POSITION_US = Integer.toString(2, 36);
        FIELD_CONTENT_DURATION_US = Integer.toString(3, 36);
        FIELD_REMOVED_AD_GROUP_COUNT = Integer.toString(4, 36);
    }

    public AdPlaybackState(AdGroup[] adGroupArr, long j, long j2, int i) {
        this.adResumePositionUs = j;
        this.contentDurationUs = j2;
        this.adGroupCount = adGroupArr.length + i;
        this.adGroups = adGroupArr;
        this.removedAdGroupCount = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        return this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && this.removedAdGroupCount == adPlaybackState.removedAdGroupCount && Arrays.equals(this.adGroups, adPlaybackState.adGroups);
    }

    public final AdGroup getAdGroup(int i) {
        int i2 = this.removedAdGroupCount;
        return i < i2 ? REMOVED_AD_GROUP : this.adGroups[i - i2];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.adGroups) + (((((((this.adGroupCount * 961) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + this.removedAdGroupCount) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=null, adResumePositionUs=");
        sb.append(this.adResumePositionUs);
        sb.append(", adGroups=[");
        int i = 0;
        while (true) {
            AdGroup[] adGroupArr = this.adGroups;
            if (i >= adGroupArr.length) {
                sb.append("])");
                return sb.toString();
            }
            sb.append("adGroup(timeUs=");
            sb.append(adGroupArr[i].timeUs);
            sb.append(", ads=[");
            for (int i2 = 0; i2 < adGroupArr[i].states.length; i2++) {
                sb.append("ad(state=");
                int i3 = adGroupArr[i].states[i2];
                if (i3 == 0) {
                    sb.append('_');
                } else if (i3 == 1) {
                    sb.append('R');
                } else if (i3 == 2) {
                    sb.append('S');
                } else if (i3 == 3) {
                    sb.append('P');
                } else if (i3 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(adGroupArr[i].durationsUs[i2]);
                sb.append(')');
                if (i2 < adGroupArr[i].states.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i < adGroupArr.length - 1) {
                sb.append(", ");
            }
            i++;
        }
    }
}
