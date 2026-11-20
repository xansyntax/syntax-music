package androidx.media3.session;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueTimeline extends Timeline {
    public static final QueueTimeline DEFAULT;
    public static final Object FAKE_WINDOW_UID;
    public final QueuedMediaItem fakeQueuedMediaItem;
    public final ImmutableList queuedMediaItems;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class QueuedMediaItem {
        public final long durationMs;
        public final MediaItem mediaItem;
        public final long queueId;

        public QueuedMediaItem(MediaItem mediaItem, long j, long j2) {
            this.mediaItem = mediaItem;
            this.queueId = j;
            this.durationMs = j2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QueuedMediaItem)) {
                return false;
            }
            QueuedMediaItem queuedMediaItem = (QueuedMediaItem) obj;
            return this.queueId == queuedMediaItem.queueId && this.mediaItem.equals(queuedMediaItem.mediaItem) && this.durationMs == queuedMediaItem.durationMs;
        }

        public final int hashCode() {
            long j = this.queueId;
            int iHashCode = (this.mediaItem.hashCode() + ((217 + ((int) (j ^ (j >>> 32)))) * 31)) * 31;
            long j2 = this.durationMs;
            return iHashCode + ((int) ((j2 >>> 32) ^ j2));
        }
    }

    static {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        DEFAULT = new QueueTimeline(RegularImmutableList.EMPTY, null);
        FAKE_WINDOW_UID = new Object();
    }

    public QueueTimeline(ImmutableList immutableList, QueuedMediaItem queuedMediaItem) {
        this.queuedMediaItems = immutableList;
        this.fakeQueuedMediaItem = queuedMediaItem;
    }

    public final QueueTimeline copyWithNewMediaItems(int i, List list) {
        ImmutableList.Builder builder = new ImmutableList.Builder(4);
        ImmutableList immutableList = this.queuedMediaItems;
        builder.addAll(immutableList.subList(0, i));
        for (int i2 = 0; i2 < list.size(); i2++) {
            builder.add((Object) new QueuedMediaItem((MediaItem) list.get(i2), -1L, -9223372036854775807L));
        }
        builder.addAll(immutableList.subList(i, immutableList.size()));
        return new QueueTimeline(builder.build(), this.fakeQueuedMediaItem);
    }

    @Override // androidx.media3.common.Timeline
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueueTimeline)) {
            return false;
        }
        QueueTimeline queueTimeline = (QueueTimeline) obj;
        return Objects.equals(this.queuedMediaItems, queueTimeline.queuedMediaItems) && Objects.equals(this.fakeQueuedMediaItem, queueTimeline.fakeQueuedMediaItem);
    }

    @Override // androidx.media3.common.Timeline
    public final int getIndexOfPeriod(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        QueuedMediaItem queuedMediaItem = getQueuedMediaItem(i);
        Long lValueOf = Long.valueOf(queuedMediaItem.queueId);
        long jMsToUs = Util.msToUs(queuedMediaItem.durationMs);
        period.getClass();
        period.set(lValueOf, null, i, jMsToUs, 0L, AdPlaybackState.NONE, false);
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public final int getPeriodCount() {
        return getWindowCount();
    }

    public final long getQueueId(int i) {
        if (i < 0) {
            return -1L;
        }
        ImmutableList immutableList = this.queuedMediaItems;
        if (i < immutableList.size()) {
            return ((QueuedMediaItem) immutableList.get(i)).queueId;
        }
        return -1L;
    }

    public final QueuedMediaItem getQueuedMediaItem(int i) {
        QueuedMediaItem queuedMediaItem;
        ImmutableList immutableList = this.queuedMediaItems;
        return (i != immutableList.size() || (queuedMediaItem = this.fakeQueuedMediaItem) == null) ? (QueuedMediaItem) immutableList.get(i) : queuedMediaItem;
    }

    @Override // androidx.media3.common.Timeline
    public final Object getUidOfPeriod(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        QueuedMediaItem queuedMediaItem = getQueuedMediaItem(i);
        window.set(FAKE_WINDOW_UID, queuedMediaItem.mediaItem, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, true, false, null, 0L, Util.msToUs(queuedMediaItem.durationMs), i, i, 0L);
        return window;
    }

    @Override // androidx.media3.common.Timeline
    public final int getWindowCount() {
        return this.queuedMediaItems.size() + (this.fakeQueuedMediaItem == null ? 0 : 1);
    }

    @Override // androidx.media3.common.Timeline
    public final int hashCode() {
        return Objects.hash(this.queuedMediaItems, this.fakeQueuedMediaItem);
    }
}
