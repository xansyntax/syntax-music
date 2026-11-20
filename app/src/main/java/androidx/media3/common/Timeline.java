package androidx.media3.common;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Objects;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Timeline {
    public static final AnonymousClass1 EMPTY = new AnonymousClass1();
    public static final String FIELD_PERIODS;
    public static final String FIELD_SHUFFLED_WINDOW_INDICES;
    public static final String FIELD_WINDOWS;

    /* JADX INFO: renamed from: androidx.media3.common.Timeline$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends Timeline {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Period {
        public static final String FIELD_AD_PLAYBACK_STATE;
        public static final String FIELD_DURATION_US;
        public static final String FIELD_PLACEHOLDER;
        public static final String FIELD_POSITION_IN_WINDOW_US;
        public static final String FIELD_WINDOW_INDEX;
        public AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
        public long durationUs;
        public Object id;
        public boolean isPlaceholder;
        public long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_WINDOW_INDEX = Integer.toString(0, 36);
            FIELD_DURATION_US = Integer.toString(1, 36);
            FIELD_POSITION_IN_WINDOW_US = Integer.toString(2, 36);
            FIELD_PLACEHOLDER = Integer.toString(3, 36);
            FIELD_AD_PLAYBACK_STATE = Integer.toString(4, 36);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Period.class.equals(obj.getClass())) {
                return false;
            }
            Period period = (Period) obj;
            return Objects.equals(this.id, period.id) && Objects.equals(this.uid, period.uid) && this.windowIndex == period.windowIndex && this.durationUs == period.durationUs && this.positionInWindowUs == period.positionInWindowUs && this.isPlaceholder == period.isPlaceholder && this.adPlaybackState.equals(period.adPlaybackState);
        }

        public final long getAdDurationUs(int i, int i2) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(i);
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i2];
            }
            return -9223372036854775807L;
        }

        public final int getAdGroupIndexAfterPositionUs(long j) {
            AdPlaybackState.AdGroup adGroup;
            int i;
            AdPlaybackState adPlaybackState = this.adPlaybackState;
            long j2 = this.durationUs;
            int i2 = adPlaybackState.adGroupCount;
            if (j != Long.MIN_VALUE && (j2 == -9223372036854775807L || j < j2)) {
                int i3 = adPlaybackState.removedAdGroupCount;
                while (i3 < i2 && ((adPlaybackState.getAdGroup(i3).timeUs != Long.MIN_VALUE && adPlaybackState.getAdGroup(i3).timeUs <= j) || ((i = (adGroup = adPlaybackState.getAdGroup(i3)).count) != -1 && adGroup.getNextAdIndexToPlay(-1) >= i))) {
                    i3++;
                }
                if (i3 < i2 && (j2 == -9223372036854775807L || adPlaybackState.getAdGroup(i3).timeUs <= j2)) {
                    return i3;
                }
            }
            return -1;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0024  */
        public final int getAdGroupIndexForPositionUs(long j) {
            int i;
            AdPlaybackState adPlaybackState = this.adPlaybackState;
            long j2 = this.durationUs;
            int i2 = adPlaybackState.adGroupCount;
            int i3 = i2 - 1;
            if (i3 == i2 - 1) {
                AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(i3);
                if (adGroup.isPlaceholder && adGroup.timeUs == Long.MIN_VALUE && adGroup.count == -1) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            int i4 = i3 - i;
            while (i4 >= 0 && j != Long.MIN_VALUE) {
                AdPlaybackState.AdGroup adGroup2 = adPlaybackState.getAdGroup(i4);
                long j3 = adGroup2.timeUs;
                if (j3 != Long.MIN_VALUE) {
                    if (j >= j3) {
                        break;
                    }
                    i4--;
                } else {
                    if (j2 != -9223372036854775807L && ((!adGroup2.isPlaceholder || j3 != Long.MIN_VALUE || adGroup2.count != -1) && j >= j2)) {
                        break;
                    }
                    i4--;
                }
            }
            if (i4 >= 0) {
                AdPlaybackState.AdGroup adGroup3 = adPlaybackState.getAdGroup(i4);
                int i5 = adGroup3.count;
                if (i5 != -1) {
                    for (int i6 = 0; i6 < i5; i6++) {
                        int i7 = adGroup3.states[i6];
                        if (i7 != 0 && i7 != 1) {
                        }
                    }
                }
                return i4;
            }
            return -1;
        }

        public final long getAdGroupTimeUs(int i) {
            return this.adPlaybackState.getAdGroup(i).timeUs;
        }

        public final int getAdState(int i, int i2) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(i);
            if (adGroup.count != -1) {
                return adGroup.states[i2];
            }
            return 0;
        }

        public final int getFirstAdIndexToPlay(int i) {
            return this.adPlaybackState.getAdGroup(i).getNextAdIndexToPlay(-1);
        }

        public final int hashCode() {
            Object obj = this.id;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.uid;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.windowIndex) * 31;
            long j = this.durationUs;
            int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.positionInWindowUs;
            return this.adPlaybackState.hashCode() + ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.isPlaceholder ? 1 : 0)) * 31);
        }

        public final boolean isLivePostrollPlaceholder(int i) {
            AdPlaybackState adPlaybackState = this.adPlaybackState;
            int i2 = adPlaybackState.adGroupCount;
            if (i != i2 - 1 || i != i2 - 1) {
                return false;
            }
            AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(i);
            return adGroup.isPlaceholder && adGroup.timeUs == Long.MIN_VALUE && adGroup.count == -1;
        }

        public final boolean isServerSideInsertedAdGroup(int i) {
            return this.adPlaybackState.getAdGroup(i).isServerSideInserted;
        }

        public final void set(Object obj, Object obj2, int i, long j, long j2, AdPlaybackState adPlaybackState, boolean z) {
            this.id = obj;
            this.uid = obj2;
            this.windowIndex = i;
            this.durationUs = j;
            this.positionInWindowUs = j2;
            this.adPlaybackState = adPlaybackState;
            this.isPlaceholder = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RemotableTimeline extends Timeline {
        public final ImmutableList periods;
        public final int[] shuffledWindowIndices;
        public final int[] windowIndicesInShuffled;
        public final ImmutableList windows;

        public RemotableTimeline(RegularImmutableList regularImmutableList, RegularImmutableList regularImmutableList2, int[] iArr) {
            UtilsKt.checkArgument(regularImmutableList.size == iArr.length);
            this.windows = regularImmutableList;
            this.periods = regularImmutableList2;
            this.shuffledWindowIndices = iArr;
            this.windowIndicesInShuffled = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.windowIndicesInShuffled[iArr[i]] = i;
            }
        }

        @Override // androidx.media3.common.Timeline
        public final int getFirstWindowIndex(boolean z) {
            if (isEmpty()) {
                return -1;
            }
            if (z) {
                return this.shuffledWindowIndices[0];
            }
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public final int getIndexOfPeriod(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.common.Timeline
        public final int getLastWindowIndex(boolean z) {
            if (isEmpty()) {
                return -1;
            }
            ImmutableList immutableList = this.windows;
            if (!z) {
                return immutableList.size() - 1;
            }
            return this.shuffledWindowIndices[immutableList.size() - 1];
        }

        @Override // androidx.media3.common.Timeline
        public final int getNextWindowIndex(int i, boolean z, int i2) {
            if (i2 == 1) {
                return i;
            }
            if (i == getLastWindowIndex(z)) {
                if (i2 == 2) {
                    return getFirstWindowIndex(z);
                }
                return -1;
            }
            if (!z) {
                return i + 1;
            }
            return this.shuffledWindowIndices[this.windowIndicesInShuffled[i] + 1];
        }

        @Override // androidx.media3.common.Timeline
        public final Period getPeriod(int i, Period period, boolean z) {
            Period period2 = (Period) this.periods.get(i);
            period.set(period2.id, period2.uid, period2.windowIndex, period2.durationUs, period2.positionInWindowUs, period2.adPlaybackState, period2.isPlaceholder);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public final int getPeriodCount() {
            return this.periods.size();
        }

        @Override // androidx.media3.common.Timeline
        public final int getPreviousWindowIndex(int i, boolean z, int i2) {
            if (i2 == 1) {
                return i;
            }
            if (i == getFirstWindowIndex(z)) {
                if (i2 == 2) {
                    return getLastWindowIndex(z);
                }
                return -1;
            }
            if (!z) {
                return i - 1;
            }
            return this.shuffledWindowIndices[this.windowIndicesInShuffled[i] - 1];
        }

        @Override // androidx.media3.common.Timeline
        public final Object getUidOfPeriod(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.common.Timeline
        public final Window getWindow(int i, Window window, long j) {
            Window window2 = (Window) this.windows.get(i);
            window.set(window2.uid, window2.mediaItem, window2.presentationStartTimeMs, window2.windowStartTimeMs, window2.elapsedRealtimeEpochOffsetMs, window2.isSeekable, window2.isDynamic, window2.liveConfiguration, window2.defaultPositionUs, window2.durationUs, window2.firstPeriodIndex, window2.lastPeriodIndex, window2.positionInFirstPeriodUs);
            window.isPlaceholder = window2.isPlaceholder;
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public final int getWindowCount() {
            return this.windows.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Window {
        public static final String FIELD_DEFAULT_POSITION_US;
        public static final String FIELD_DURATION_US;
        public static final String FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS;
        public static final String FIELD_FIRST_PERIOD_INDEX;
        public static final String FIELD_IS_DYNAMIC;
        public static final String FIELD_IS_PLACEHOLDER;
        public static final String FIELD_IS_SEEKABLE;
        public static final String FIELD_LAST_PERIOD_INDEX;
        public static final String FIELD_LIVE_CONFIGURATION;
        public static final String FIELD_MEDIA_ITEM;
        public static final String FIELD_POSITION_IN_FIRST_PERIOD_US;
        public static final String FIELD_PRESENTATION_START_TIME_MS;
        public static final String FIELD_WINDOW_START_TIME_MS;
        public static final MediaItem PLACEHOLDER_MEDIA_ITEM;
        public long defaultPositionUs;
        public long durationUs;
        public long elapsedRealtimeEpochOffsetMs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isPlaceholder;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public MediaItem.LiveConfiguration liveConfiguration;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public Object tag;
        public long windowStartTimeMs;
        public static final Object SINGLE_WINDOW_UID = new Object();
        public static final Object FAKE_WINDOW_UID = new Object();
        public Object uid = SINGLE_WINDOW_UID;
        public MediaItem mediaItem = PLACEHOLDER_MEDIA_ITEM;

        static {
            MediaItem.Builder builder = new MediaItem.Builder();
            builder.mediaId = "androidx.media3.common.Timeline";
            builder.uri = Uri.EMPTY;
            PLACEHOLDER_MEDIA_ITEM = builder.build();
            FIELD_MEDIA_ITEM = Integer.toString(1, 36);
            FIELD_PRESENTATION_START_TIME_MS = Integer.toString(2, 36);
            FIELD_WINDOW_START_TIME_MS = Integer.toString(3, 36);
            FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS = Integer.toString(4, 36);
            FIELD_IS_SEEKABLE = Integer.toString(5, 36);
            FIELD_IS_DYNAMIC = Integer.toString(6, 36);
            FIELD_LIVE_CONFIGURATION = Integer.toString(7, 36);
            FIELD_IS_PLACEHOLDER = Integer.toString(8, 36);
            FIELD_DEFAULT_POSITION_US = Integer.toString(9, 36);
            FIELD_DURATION_US = Integer.toString(10, 36);
            FIELD_FIRST_PERIOD_INDEX = Integer.toString(11, 36);
            FIELD_LAST_PERIOD_INDEX = Integer.toString(12, 36);
            FIELD_POSITION_IN_FIRST_PERIOD_US = Integer.toString(13, 36);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Window.class.equals(obj.getClass())) {
                return false;
            }
            Window window = (Window) obj;
            return Objects.equals(this.uid, window.uid) && Objects.equals(this.mediaItem, window.mediaItem) && Objects.equals(this.liveConfiguration, window.liveConfiguration) && this.presentationStartTimeMs == window.presentationStartTimeMs && this.windowStartTimeMs == window.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == window.elapsedRealtimeEpochOffsetMs && this.isSeekable == window.isSeekable && this.isDynamic == window.isDynamic && this.isPlaceholder == window.isPlaceholder && this.defaultPositionUs == window.defaultPositionUs && this.durationUs == window.durationUs && this.firstPeriodIndex == window.firstPeriodIndex && this.lastPeriodIndex == window.lastPeriodIndex && this.positionInFirstPeriodUs == window.positionInFirstPeriodUs;
        }

        public final int hashCode() {
            int iHashCode = (this.mediaItem.hashCode() + ((this.uid.hashCode() + 217) * 31)) * 961;
            MediaItem.LiveConfiguration liveConfiguration = this.liveConfiguration;
            int iHashCode2 = liveConfiguration == null ? 0 : liveConfiguration.hashCode();
            long j = this.presentationStartTimeMs;
            int i = (((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.windowStartTimeMs;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.elapsedRealtimeEpochOffsetMs;
            int i3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + (this.isPlaceholder ? 1 : 0)) * 31;
            long j4 = this.defaultPositionUs;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.durationUs;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.firstPeriodIndex) * 31) + this.lastPeriodIndex) * 31;
            long j6 = this.positionInFirstPeriodUs;
            return i5 + ((int) (j6 ^ (j6 >>> 32)));
        }

        public final boolean isLive() {
            return this.liveConfiguration != null;
        }

        public final void set(Object obj, MediaItem mediaItem, long j, long j2, long j3, boolean z, boolean z2, MediaItem.LiveConfiguration liveConfiguration, long j4, long j5, int i, int i2, long j6) {
            MediaItem.LocalConfiguration localConfiguration;
            this.uid = obj;
            this.mediaItem = mediaItem != null ? mediaItem : PLACEHOLDER_MEDIA_ITEM;
            this.tag = (mediaItem == null || (localConfiguration = mediaItem.localConfiguration) == null) ? null : localConfiguration.tag;
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.elapsedRealtimeEpochOffsetMs = j3;
            this.isSeekable = z;
            this.isDynamic = z2;
            this.liveConfiguration = liveConfiguration;
            this.defaultPositionUs = j4;
            this.durationUs = j5;
            this.firstPeriodIndex = i;
            this.lastPeriodIndex = i2;
            this.positionInFirstPeriodUs = j6;
            this.isPlaceholder = false;
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_WINDOWS = Integer.toString(0, 36);
        FIELD_PERIODS = Integer.toString(1, 36);
        FIELD_SHUFFLED_WINDOW_INDICES = Integer.toString(2, 36);
    }

    public boolean equals(Object obj) {
        int lastWindowIndex;
        if (this != obj) {
            if (obj instanceof Timeline) {
                Timeline timeline = (Timeline) obj;
                if (timeline.getWindowCount() == getWindowCount() && timeline.getPeriodCount() == getPeriodCount()) {
                    Window window = new Window();
                    Period period = new Period();
                    Window window2 = new Window();
                    Period period2 = new Period();
                    for (int i = 0; i < getWindowCount(); i++) {
                        if (getWindow(i, window, 0L).equals(timeline.getWindow(i, window2, 0L))) {
                        }
                    }
                    for (int i2 = 0; i2 < getPeriodCount(); i2++) {
                        if (getPeriod(i2, period, true).equals(timeline.getPeriod(i2, period2, true))) {
                        }
                    }
                    int firstWindowIndex = getFirstWindowIndex(true);
                    if (firstWindowIndex == timeline.getFirstWindowIndex(true) && (lastWindowIndex = getLastWindowIndex(true)) == timeline.getLastWindowIndex(true)) {
                        while (firstWindowIndex != lastWindowIndex) {
                            int nextWindowIndex = getNextWindowIndex(firstWindowIndex, true, 0);
                            if (nextWindowIndex == timeline.getNextWindowIndex(firstWindowIndex, true, 0)) {
                                firstWindowIndex = nextWindowIndex;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int getFirstWindowIndex(boolean z) {
        return isEmpty() ? -1 : 0;
    }

    public int getIndexOfPeriod(Object obj) {
        return -1;
    }

    public int getLastWindowIndex(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i, Period period, Window window, int i2, boolean z) {
        int i3 = getPeriod(i, period, false).windowIndex;
        if (getWindow(i3, window, 0L).lastPeriodIndex != i) {
            return i + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i3, z, i2);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window, 0L).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i, boolean z, int i2) {
        if (i2 == 0) {
            if (i == getLastWindowIndex(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == getLastWindowIndex(z) ? getFirstWindowIndex(z) : i + 1;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m();
        return 0;
    }

    public Period getPeriod(int i, Period period, boolean z) {
        throw new IndexOutOfBoundsException();
    }

    public Period getPeriodByUid(Object obj, Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public int getPeriodCount() {
        return 0;
    }

    public final Pair getPeriodPositionUs(Window window, Period period, int i, long j, long j2) {
        UtilsKt.checkElementIndex(i, getWindowCount());
        getWindow(i, window, j2);
        if (j == -9223372036854775807L) {
            j = window.defaultPositionUs;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = window.firstPeriodIndex;
        getPeriod(i2, period, false);
        while (i2 < window.lastPeriodIndex && period.positionInWindowUs != j) {
            int i3 = i2 + 1;
            if (getPeriod(i3, period, false).positionInWindowUs > j) {
                break;
            }
            i2 = i3;
        }
        getPeriod(i2, period, true);
        long jMin = j - period.positionInWindowUs;
        long j3 = period.durationUs;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(jMin, j3 - 1);
        }
        long jMax = Math.max(0L, jMin);
        Object obj = period.uid;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public int getPreviousWindowIndex(int i, boolean z, int i2) {
        if (i2 == 0) {
            if (i == getFirstWindowIndex(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == getFirstWindowIndex(z) ? getLastWindowIndex(z) : i - 1;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m();
        return 0;
    }

    public Object getUidOfPeriod(int i) {
        throw new IndexOutOfBoundsException();
    }

    public Window getWindow(int i, Window window, long j) {
        throw new IndexOutOfBoundsException();
    }

    public int getWindowCount() {
        return 0;
    }

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int windowCount = getWindowCount() + 217;
        for (int i = 0; i < getWindowCount(); i++) {
            windowCount = (windowCount * 31) + getWindow(i, window, 0L).hashCode();
        }
        int periodCount = getPeriodCount() + (windowCount * 31);
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            periodCount = (periodCount * 31) + getPeriod(i2, period, true).hashCode();
        }
        int firstWindowIndex = getFirstWindowIndex(true);
        while (firstWindowIndex != -1) {
            periodCount = (periodCount * 31) + firstWindowIndex;
            firstWindowIndex = getNextWindowIndex(firstWindowIndex, true, 0);
        }
        return periodCount;
    }

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public final void getWindow(int i, Window window) {
        getWindow(i, window, 0L);
    }

    public final Pair getPeriodPositionUs(Window window, Period period, int i, long j) {
        Pair periodPositionUs = getPeriodPositionUs(window, period, i, j, 0L);
        periodPositionUs.getClass();
        return periodPositionUs;
    }
}
