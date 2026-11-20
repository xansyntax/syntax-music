package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingTimeline extends Timeline {
    public final Timeline timeline;

    public ForwardingTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override // androidx.media3.common.Timeline
    public final int getFirstWindowIndex(boolean z) {
        return this.timeline.getFirstWindowIndex(z);
    }

    @Override // androidx.media3.common.Timeline
    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    @Override // androidx.media3.common.Timeline
    public final int getLastWindowIndex(boolean z) {
        return this.timeline.getLastWindowIndex(z);
    }

    @Override // androidx.media3.common.Timeline
    public final int getNextWindowIndex(int i, boolean z, int i2) {
        return this.timeline.getNextWindowIndex(i, z, i2);
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        return this.timeline.getPeriod(i, period, z);
    }

    @Override // androidx.media3.common.Timeline
    public final int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    @Override // androidx.media3.common.Timeline
    public final int getPreviousWindowIndex(int i, boolean z, int i2) {
        return this.timeline.getPreviousWindowIndex(i, z, i2);
    }

    @Override // androidx.media3.common.Timeline
    public Object getUidOfPeriod(int i) {
        return this.timeline.getUidOfPeriod(i);
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        return this.timeline.getWindow(i, window, j);
    }

    @Override // androidx.media3.common.Timeline
    public final int getWindowCount() {
        return this.timeline.getWindowCount();
    }
}
