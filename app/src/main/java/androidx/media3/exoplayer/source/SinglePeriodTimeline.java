package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SinglePeriodTimeline extends Timeline {
    public static final Object UID = new Object();
    public final boolean isSeekable;
    public final MediaItem.LiveConfiguration liveConfiguration;
    public final MediaItem mediaItem;
    public final long periodDurationUs;
    public final long windowDurationUs;

    static {
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.mediaId = "SinglePeriodTimeline";
        builder.uri = Uri.EMPTY;
        builder.build();
    }

    public SinglePeriodTimeline(long j, boolean z, boolean z2, MediaItem mediaItem) {
        MediaItem.LiveConfiguration liveConfiguration = z2 ? mediaItem.liveConfiguration : null;
        this.periodDurationUs = j;
        this.windowDurationUs = j;
        this.isSeekable = z;
        mediaItem.getClass();
        this.mediaItem = mediaItem;
        this.liveConfiguration = liveConfiguration;
    }

    @Override // androidx.media3.common.Timeline
    public final int getIndexOfPeriod(Object obj) {
        return UID != obj ? -1 : 0;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        UtilsKt.checkElementIndex(i, 1);
        Object obj = z ? UID : null;
        period.getClass();
        period.set(null, obj, 0, this.periodDurationUs, 0L, AdPlaybackState.NONE, false);
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public final int getPeriodCount() {
        return 1;
    }

    @Override // androidx.media3.common.Timeline
    public final Object getUidOfPeriod(int i) {
        UtilsKt.checkElementIndex(i, 1);
        return UID;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        UtilsKt.checkElementIndex(i, 1);
        window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.isSeekable, false, this.liveConfiguration, 0L, this.windowDurationUs, 0, 0, 0L);
        return window;
    }

    @Override // androidx.media3.common.Timeline
    public final int getWindowCount() {
        return 1;
    }
}
