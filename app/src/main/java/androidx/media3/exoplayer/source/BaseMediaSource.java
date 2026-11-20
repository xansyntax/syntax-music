package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.appcompat.widget.Toolbar;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.util.ReleasableExecutor$1;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMediaSource {
    public Looper looper;
    public PlayerId playerId;
    public Timeline timeline;
    public final ArrayList mediaSourceCallers = new ArrayList(1);
    public final HashSet enabledMediaSourceCallers = new HashSet(1);
    public final StatusLine eventDispatcher = new StatusLine(new CopyOnWriteArrayList(), 0, (MediaSource$MediaPeriodId) null);
    public final DrmSessionEventListener.EventDispatcher drmEventDispatcher = new DrmSessionEventListener.EventDispatcher(new CopyOnWriteArrayList(), 0, null);

    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        return false;
    }

    public abstract MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, EmojiProcessor emojiProcessor, long j);

    public final void disable(MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller) {
        HashSet hashSet = this.enabledMediaSourceCallers;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.remove(mediaSource$MediaSourceCaller);
        if (zIsEmpty || !hashSet.isEmpty()) {
            return;
        }
        disableInternal();
    }

    public final void enable(MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller) {
        this.looper.getClass();
        HashSet hashSet = this.enabledMediaSourceCallers;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(mediaSource$MediaSourceCaller);
        if (zIsEmpty) {
            enableInternal();
        }
    }

    public Timeline getInitialTimeline() {
        return null;
    }

    public abstract MediaItem getMediaItem();

    public boolean isSingleWindow() {
        return true;
    }

    public final void prepareSource(MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller, DefaultBandwidthMeter defaultBandwidthMeter, PlayerId playerId) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.looper;
        UtilsKt.checkArgument(looper == null || looper == looperMyLooper);
        this.playerId = playerId;
        Timeline timeline = this.timeline;
        this.mediaSourceCallers.add(mediaSource$MediaSourceCaller);
        if (this.looper == null) {
            this.looper = looperMyLooper;
            this.enabledMediaSourceCallers.add(mediaSource$MediaSourceCaller);
            prepareSourceInternal(defaultBandwidthMeter);
        } else if (timeline != null) {
            enable(mediaSource$MediaSourceCaller);
            mediaSource$MediaSourceCaller.onSourceInfoRefreshed(this, timeline);
        }
    }

    public abstract void prepareSourceInternal(DefaultBandwidthMeter defaultBandwidthMeter);

    public final void refreshSourceInfo(Timeline timeline) {
        this.timeline = timeline;
        ArrayList arrayList = this.mediaSourceCallers;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((MediaSource$MediaSourceCaller) obj).onSourceInfoRefreshed(this, timeline);
        }
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ProgressiveMediaPeriod progressiveMediaPeriod = (ProgressiveMediaPeriod) mediaPeriod;
        if (progressiveMediaPeriod.prepared) {
            for (SampleQueue sampleQueue : progressiveMediaPeriod.sampleQueues) {
                sampleQueue.discardToEnd();
                DrmSession drmSession = sampleQueue.currentDrmSession;
                if (drmSession != null) {
                    drmSession.release(sampleQueue.drmEventDispatcher);
                    sampleQueue.currentDrmSession = null;
                    sampleQueue.downstreamFormat = null;
                }
            }
        }
        Loader loader = progressiveMediaPeriod.loader;
        ReleasableExecutor$1 releasableExecutor$1 = loader.downloadExecutor;
        Loader.LoadTask loadTask = loader.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        releasableExecutor$1.execute(new Toolbar.AnonymousClass2((byte) 6, progressiveMediaPeriod));
        releasableExecutor$1.val$releaseCallback.accept(releasableExecutor$1.val$executor);
        progressiveMediaPeriod.handler.removeCallbacksAndMessages(null);
        progressiveMediaPeriod.callback = null;
        progressiveMediaPeriod.released = true;
    }

    public final void releaseSource(MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller) {
        ArrayList arrayList = this.mediaSourceCallers;
        arrayList.remove(mediaSource$MediaSourceCaller);
        if (!arrayList.isEmpty()) {
            disable(mediaSource$MediaSourceCaller);
            return;
        }
        this.looper = null;
        this.timeline = null;
        this.playerId = null;
        this.enabledMediaSourceCallers.clear();
        releaseSourceInternal();
    }

    public final void removeDrmEventListener(DrmSessionEventListener drmSessionEventListener) {
        CopyOnWriteArrayList<DrmSessionEventListener.EventDispatcher.ListenerAndHandler> copyOnWriteArrayList = this.drmEventDispatcher.listenerAndHandlers;
        for (DrmSessionEventListener.EventDispatcher.ListenerAndHandler listenerAndHandler : copyOnWriteArrayList) {
            if (listenerAndHandler.listener == drmSessionEventListener) {
                copyOnWriteArrayList.remove(listenerAndHandler);
            }
        }
    }

    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        CopyOnWriteArrayList<MediaSourceEventListener$EventDispatcher$ListenerAndHandler> copyOnWriteArrayList = (CopyOnWriteArrayList) this.eventDispatcher.message;
        for (MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler : copyOnWriteArrayList) {
            if (mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener == mediaSourceEventListener) {
                copyOnWriteArrayList.remove(mediaSourceEventListener$EventDispatcher$ListenerAndHandler);
            }
        }
    }

    public void disableInternal() {
    }

    public void enableInternal() {
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void releaseSourceInternal() {
    }

    public void updateMediaItem(MediaItem mediaItem) {
    }
}
