package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.exoplayer.StreamVolumeManager$StreamVolumeState;
import com.google.common.base.Function;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Timeline$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;

    public /* synthetic */ Timeline$$ExternalSyntheticLambda0(byte b, int i) {
        this.$r8$classId = b;
        this.f$0 = i;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x012c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0131  */
    /* JADX WARN: Code duplicated, block: B:56:0x013a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0143  */
    /* JADX WARN: Code duplicated, block: B:60:0x0148  */
    /* JADX WARN: Code duplicated, block: B:63:0x0155  */
    /* JADX WARN: Code duplicated, block: B:65:0x015d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0160  */
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        AdPlaybackState adPlaybackState;
        AdPlaybackState.AdGroup[] adGroupArr;
        int i;
        MediaItem[] mediaItemArr;
        MediaItem mediaItemBuild;
        long[] jArr;
        String[] strArr;
        AdPlaybackState.SkipInfo[] skipInfoArr;
        int i2;
        Bundle bundle;
        AdPlaybackState.SkipInfo skipInfo;
        byte b = this.$r8$classId;
        int i3 = this.f$0;
        switch (b) {
            case 0:
                Bundle bundle2 = (Bundle) obj;
                Bundle bundle3 = bundle2.getBundle(Timeline.Window.FIELD_MEDIA_ITEM);
                MediaItem mediaItemFromBundle = bundle3 != null ? MediaItem.fromBundle(i3, bundle3) : MediaItem.EMPTY;
                long j = bundle2.getLong(Timeline.Window.FIELD_PRESENTATION_START_TIME_MS, -9223372036854775807L);
                long j2 = bundle2.getLong(Timeline.Window.FIELD_WINDOW_START_TIME_MS, -9223372036854775807L);
                long j3 = bundle2.getLong(Timeline.Window.FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS, -9223372036854775807L);
                boolean z = bundle2.getBoolean(Timeline.Window.FIELD_IS_SEEKABLE, false);
                boolean z2 = bundle2.getBoolean(Timeline.Window.FIELD_IS_DYNAMIC, false);
                Bundle bundle4 = bundle2.getBundle(Timeline.Window.FIELD_LIVE_CONFIGURATION);
                MediaItem.LiveConfiguration liveConfigurationFromBundle = bundle4 != null ? MediaItem.LiveConfiguration.fromBundle(bundle4) : null;
                boolean z3 = bundle2.getBoolean(Timeline.Window.FIELD_IS_PLACEHOLDER, false);
                long j4 = bundle2.getLong(Timeline.Window.FIELD_DEFAULT_POSITION_US, 0L);
                long j5 = bundle2.getLong(Timeline.Window.FIELD_DURATION_US, -9223372036854775807L);
                int i4 = bundle2.getInt(Timeline.Window.FIELD_FIRST_PERIOD_INDEX, 0);
                int i5 = bundle2.getInt(Timeline.Window.FIELD_LAST_PERIOD_INDEX, 0);
                long j6 = bundle2.getLong(Timeline.Window.FIELD_POSITION_IN_FIRST_PERIOD_US, 0L);
                Timeline.Window window = new Timeline.Window();
                window.set(Timeline.Window.FAKE_WINDOW_UID, mediaItemFromBundle, j, j2, j3, z, z2, liveConfigurationFromBundle, j4, j5, i4, i5, j6);
                window.isPlaceholder = z3;
                return window;
            case 1:
                Bundle bundle5 = (Bundle) obj;
                int i6 = bundle5.getInt(Timeline.Period.FIELD_WINDOW_INDEX, 0);
                long j7 = bundle5.getLong(Timeline.Period.FIELD_DURATION_US, -9223372036854775807L);
                long j8 = bundle5.getLong(Timeline.Period.FIELD_POSITION_IN_WINDOW_US, 0L);
                boolean z4 = bundle5.getBoolean(Timeline.Period.FIELD_PLACEHOLDER, false);
                Bundle bundle6 = bundle5.getBundle(Timeline.Period.FIELD_AD_PLAYBACK_STATE);
                if (bundle6 != null) {
                    ArrayList parcelableArrayList = bundle6.getParcelableArrayList(AdPlaybackState.FIELD_AD_GROUPS);
                    if (parcelableArrayList == null) {
                        adGroupArr = new AdPlaybackState.AdGroup[0];
                    } else {
                        AdPlaybackState.AdGroup[] adGroupArr2 = new AdPlaybackState.AdGroup[parcelableArrayList.size()];
                        for (int i7 = 0; i7 < parcelableArrayList.size(); i7++) {
                            Bundle bundle7 = (Bundle) parcelableArrayList.get(i7);
                            long j9 = bundle7.getLong(AdPlaybackState.AdGroup.FIELD_TIME_US);
                            int i8 = bundle7.getInt(AdPlaybackState.AdGroup.FIELD_COUNT);
                            int i9 = bundle7.getInt(AdPlaybackState.AdGroup.FIELD_ORIGINAL_COUNT);
                            ArrayList parcelableArrayList2 = bundle7.getParcelableArrayList(AdPlaybackState.AdGroup.FIELD_URIS);
                            ArrayList parcelableArrayList3 = bundle7.getParcelableArrayList(AdPlaybackState.AdGroup.FIELD_MEDIA_ITEMS);
                            int[] intArray = bundle7.getIntArray(AdPlaybackState.AdGroup.FIELD_STATES);
                            long[] longArray = bundle7.getLongArray(AdPlaybackState.AdGroup.FIELD_DURATIONS_US);
                            long j10 = bundle7.getLong(AdPlaybackState.AdGroup.FIELD_CONTENT_RESUME_OFFSET_US);
                            boolean z5 = bundle7.getBoolean(AdPlaybackState.AdGroup.FIELD_IS_SERVER_SIDE_INSERTED);
                            ArrayList<String> stringArrayList = bundle7.getStringArrayList(AdPlaybackState.AdGroup.FIELD_IDS);
                            ArrayList parcelableArrayList4 = bundle7.getParcelableArrayList(AdPlaybackState.AdGroup.FIELD_SKIP_INFOS);
                            boolean z6 = bundle7.getBoolean(AdPlaybackState.AdGroup.FIELD_IS_PLACEHOLDER);
                            if (intArray == null) {
                                intArray = new int[0];
                            }
                            int[] iArr = intArray;
                            if (parcelableArrayList3 != null) {
                                MediaItem[] mediaItemArr2 = new MediaItem[parcelableArrayList3.size()];
                                for (int i10 = 0; i10 < parcelableArrayList3.size(); i10++) {
                                    Bundle bundle8 = (Bundle) parcelableArrayList3.get(i10);
                                    mediaItemArr2[i10] = bundle8 == null ? null : MediaItem.fromBundle(i3, bundle8);
                                }
                                mediaItemArr = mediaItemArr2;
                            } else {
                                if (parcelableArrayList2 != null) {
                                    MediaItem[] mediaItemArr3 = new MediaItem[parcelableArrayList2.size()];
                                    for (int i11 = 0; i11 < parcelableArrayList2.size(); i11++) {
                                        Uri uri = (Uri) parcelableArrayList2.get(i11);
                                        if (uri == null) {
                                            mediaItemBuild = null;
                                        } else {
                                            MediaItem mediaItem = MediaItem.EMPTY;
                                            MediaItem.Builder builder = new MediaItem.Builder();
                                            builder.uri = uri;
                                            mediaItemBuild = builder.build();
                                        }
                                        mediaItemArr3[i11] = mediaItemBuild;
                                    }
                                    mediaItemArr = mediaItemArr3;
                                } else {
                                    i = 0;
                                    mediaItemArr = new MediaItem[0];
                                }
                                if (longArray == null) {
                                    jArr = new long[i];
                                } else {
                                    jArr = longArray;
                                }
                                strArr = new String[i];
                                if (stringArrayList != null) {
                                    strArr = (String[]) stringArrayList.toArray(strArr);
                                }
                                String[] strArr2 = strArr;
                                if (parcelableArrayList4 == null) {
                                    skipInfoArr = new AdPlaybackState.SkipInfo[i];
                                } else {
                                    skipInfoArr = new AdPlaybackState.SkipInfo[parcelableArrayList4.size()];
                                    for (i2 = 0; i2 < parcelableArrayList4.size(); i2++) {
                                        bundle = (Bundle) parcelableArrayList4.get(i2);
                                        if (bundle == null) {
                                            skipInfo = null;
                                        } else {
                                            skipInfo = new AdPlaybackState.SkipInfo(bundle.getLong(AdPlaybackState.SkipInfo.FIELD_SKIP_OFFSET_US), bundle.getLong(AdPlaybackState.SkipInfo.FIELD_SKIP_DURATION_US), bundle.getString(AdPlaybackState.SkipInfo.FIELD_LABEL_ID));
                                        }
                                        skipInfoArr[i2] = skipInfo;
                                    }
                                }
                                adGroupArr2[i7] = new AdPlaybackState.AdGroup(j9, i8, i9, iArr, mediaItemArr, jArr, j10, z5, strArr2, skipInfoArr, z6);
                            }
                            i = 0;
                            if (longArray == null) {
                                jArr = new long[i];
                            } else {
                                jArr = longArray;
                            }
                            strArr = new String[i];
                            if (stringArrayList != null) {
                                strArr = (String[]) stringArrayList.toArray(strArr);
                            }
                            String[] strArr3 = strArr;
                            if (parcelableArrayList4 == null) {
                                skipInfoArr = new AdPlaybackState.SkipInfo[i];
                            } else {
                                skipInfoArr = new AdPlaybackState.SkipInfo[parcelableArrayList4.size()];
                                while (i2 < parcelableArrayList4.size()) {
                                    bundle = (Bundle) parcelableArrayList4.get(i2);
                                    if (bundle == null) {
                                        skipInfo = null;
                                    } else {
                                        skipInfo = new AdPlaybackState.SkipInfo(bundle.getLong(AdPlaybackState.SkipInfo.FIELD_SKIP_OFFSET_US), bundle.getLong(AdPlaybackState.SkipInfo.FIELD_SKIP_DURATION_US), bundle.getString(AdPlaybackState.SkipInfo.FIELD_LABEL_ID));
                                    }
                                    skipInfoArr[i2] = skipInfo;
                                }
                            }
                            adGroupArr2[i7] = new AdPlaybackState.AdGroup(j9, i8, i9, iArr, mediaItemArr, jArr, j10, z5, strArr3, skipInfoArr, z6);
                        }
                        adGroupArr = adGroupArr2;
                    }
                    adPlaybackState = new AdPlaybackState(adGroupArr, bundle6.getLong(AdPlaybackState.FIELD_AD_RESUME_POSITION_US, 0L), bundle6.getLong(AdPlaybackState.FIELD_CONTENT_DURATION_US, -9223372036854775807L), bundle6.getInt(AdPlaybackState.FIELD_REMOVED_AD_GROUP_COUNT, 0));
                } else {
                    adPlaybackState = AdPlaybackState.NONE;
                }
                AdPlaybackState adPlaybackState2 = adPlaybackState;
                Timeline.Period period = new Timeline.Period();
                period.set(null, null, i6, j7, j8, adPlaybackState2, z4);
                return period;
            case 2:
                return Integer.valueOf(i3);
            default:
                StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) obj;
                int i12 = streamVolumeManager$StreamVolumeState.streamType;
                int i13 = streamVolumeManager$StreamVolumeState.minVolume;
                return new StreamVolumeManager$StreamVolumeState(i3 == 0, i12, (i3 < i13 || i3 > streamVolumeManager$StreamVolumeState.maxVolume) ? streamVolumeManager$StreamVolumeState.volume : i3, i13, streamVolumeManager$StreamVolumeState.maxVolume);
        }
    }
}
