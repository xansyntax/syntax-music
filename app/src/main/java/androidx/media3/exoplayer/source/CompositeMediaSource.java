package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.extractor.text.CueDecoder;
import coil3.util.UtilsKt;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CompositeMediaSource extends BaseMediaSource {
    public final HashMap childSources = new HashMap();
    public Handler eventHandler;
    public DefaultBandwidthMeter mediaTransferListener;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {
        public DrmSessionEventListener.EventDispatcher drmEventDispatcher;
        public final Object id;
        public StatusLine mediaSourceEventDispatcher;

        public ForwardingEventListener(Object obj) {
            this.mediaSourceEventDispatcher = new StatusLine((CopyOnWriteArrayList) CompositeMediaSource.this.eventDispatcher.message, 0, (MediaSource$MediaPeriodId) null);
            this.drmEventDispatcher = new DrmSessionEventListener.EventDispatcher(CompositeMediaSource.this.drmEventDispatcher.listenerAndHandlers, 0, null);
            this.id = obj;
        }

        public final boolean maybeUpdateEventDispatcher(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            MediaSource$MediaPeriodId mediaPeriodIdForChildMediaPeriodId;
            Object obj = this.id;
            CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
            if (mediaSource$MediaPeriodId != null) {
                mediaPeriodIdForChildMediaPeriodId = compositeMediaSource.getMediaPeriodIdForChildMediaPeriodId(obj, mediaSource$MediaPeriodId);
                if (mediaPeriodIdForChildMediaPeriodId == null) {
                    return false;
                }
            } else {
                mediaPeriodIdForChildMediaPeriodId = null;
            }
            int windowIndexForChildWindowIndex = compositeMediaSource.getWindowIndexForChildWindowIndex(i, obj);
            StatusLine statusLine = this.mediaSourceEventDispatcher;
            if (statusLine.code != windowIndexForChildWindowIndex || !Objects.equals((MediaSource$MediaPeriodId) statusLine.protocol, mediaPeriodIdForChildMediaPeriodId)) {
                this.mediaSourceEventDispatcher = new StatusLine((CopyOnWriteArrayList) compositeMediaSource.eventDispatcher.message, windowIndexForChildWindowIndex, mediaPeriodIdForChildMediaPeriodId);
            }
            DrmSessionEventListener.EventDispatcher eventDispatcher = this.drmEventDispatcher;
            if (eventDispatcher.windowIndex == windowIndexForChildWindowIndex && Objects.equals(eventDispatcher.mediaPeriodId, mediaPeriodIdForChildMediaPeriodId)) {
                return true;
            }
            this.drmEventDispatcher = new DrmSessionEventListener.EventDispatcher(compositeMediaSource.drmEventDispatcher.listenerAndHandlers, windowIndexForChildWindowIndex, mediaPeriodIdForChildMediaPeriodId);
            return true;
        }

        public final FloatTweenSpec maybeUpdateMediaLoadData(FloatTweenSpec floatTweenSpec, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            long j = floatTweenSpec.durationNanos;
            CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
            Object obj = this.id;
            long mediaTimeForChildMediaTime = compositeMediaSource.getMediaTimeForChildMediaTime(j, obj);
            long j2 = floatTweenSpec.delayNanos;
            long mediaTimeForChildMediaTime2 = compositeMediaSource.getMediaTimeForChildMediaTime(j2, obj);
            return (mediaTimeForChildMediaTime == j && mediaTimeForChildMediaTime2 == j2) ? floatTweenSpec : new FloatTweenSpec(floatTweenSpec.duration, (Format) floatTweenSpec.easing, mediaTimeForChildMediaTime, mediaTimeForChildMediaTime2);
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onDownstreamFormatChanged(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, FloatTweenSpec floatTweenSpec) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                StatusLine statusLine = this.mediaSourceEventDispatcher;
                statusLine.dispatchEvent(new TextLinkScope$$ExternalSyntheticLambda10(statusLine, maybeUpdateMediaLoadData(floatTweenSpec, mediaSource$MediaPeriodId), (byte) 7));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmKeysLoaded(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, CueDecoder cueDecoder) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                this.drmEventDispatcher.drmKeysLoaded(cueDecoder);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmKeysRestored(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                this.drmEventDispatcher.drmKeysRestored();
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmSessionAcquired(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, int i2) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                this.drmEventDispatcher.drmSessionAcquired(i2);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmSessionManagerError(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Exception exc) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                this.drmEventDispatcher.drmSessionManagerError(exc);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmSessionReleased(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                this.drmEventDispatcher.drmSessionReleased();
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onLoadCanceled(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                StatusLine statusLine = this.mediaSourceEventDispatcher;
                statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(statusLine, loadEventInfo, maybeUpdateMediaLoadData(floatTweenSpec, mediaSource$MediaPeriodId), (byte) 1));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onLoadCompleted(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                StatusLine statusLine = this.mediaSourceEventDispatcher;
                statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(statusLine, loadEventInfo, maybeUpdateMediaLoadData(floatTweenSpec, mediaSource$MediaPeriodId), (byte) 0));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onLoadError(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, IOException iOException, boolean z) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                StatusLine statusLine = this.mediaSourceEventDispatcher;
                statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3(statusLine, loadEventInfo, maybeUpdateMediaLoadData(floatTweenSpec, mediaSource$MediaPeriodId), iOException, z));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onLoadStarted(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, int i2) {
            if (maybeUpdateEventDispatcher(i, mediaSource$MediaPeriodId)) {
                StatusLine statusLine = this.mediaSourceEventDispatcher;
                statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda1(statusLine, loadEventInfo, maybeUpdateMediaLoadData(floatTweenSpec, mediaSource$MediaPeriodId), i2));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaSourceAndListener {
        public final CompositeMediaSource$$ExternalSyntheticLambda0 caller;
        public final ForwardingEventListener eventListener;
        public final BaseMediaSource mediaSource;

        public MediaSourceAndListener(BaseMediaSource baseMediaSource, CompositeMediaSource$$ExternalSyntheticLambda0 compositeMediaSource$$ExternalSyntheticLambda0, ForwardingEventListener forwardingEventListener) {
            this.mediaSource = baseMediaSource;
            this.caller = compositeMediaSource$$ExternalSyntheticLambda0;
            this.eventListener = forwardingEventListener;
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void disableInternal() {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void enableInternal() {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
        }
    }

    public abstract MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object obj, MediaSource$MediaPeriodId mediaSource$MediaPeriodId);

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public void maybeThrowSourceInfoRefreshError() {
        Iterator it = this.childSources.values().iterator();
        while (it.hasNext()) {
            ((MediaSourceAndListener) it.next()).mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    public abstract void onChildSourceInfoRefreshed(Object obj, BaseMediaSource baseMediaSource, Timeline timeline);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.media3.exoplayer.source.CompositeMediaSource$$ExternalSyntheticLambda0, androidx.media3.exoplayer.source.MediaSource$MediaSourceCaller] */
    public final void prepareChildSource(final Integer num, BaseMediaSource baseMediaSource) {
        HashMap map = this.childSources;
        UtilsKt.checkArgument(!map.containsKey(num));
        ?? r1 = new MediaSource$MediaSourceCaller() { // from class: androidx.media3.exoplayer.source.CompositeMediaSource$$ExternalSyntheticLambda0
            @Override // androidx.media3.exoplayer.source.MediaSource$MediaSourceCaller
            public final void onSourceInfoRefreshed(BaseMediaSource baseMediaSource2, Timeline timeline) {
                this.f$0.onChildSourceInfoRefreshed(num, baseMediaSource2, timeline);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(num);
        map.put(num, new MediaSourceAndListener(baseMediaSource, r1, forwardingEventListener));
        Handler handler = this.eventHandler;
        handler.getClass();
        baseMediaSource.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) baseMediaSource.eventDispatcher.message;
        MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = new MediaSourceEventListener$EventDispatcher$ListenerAndHandler();
        mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler = handler;
        mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener = forwardingEventListener;
        copyOnWriteArrayList.add(mediaSourceEventListener$EventDispatcher$ListenerAndHandler);
        Handler handler2 = this.eventHandler;
        handler2.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = baseMediaSource.drmEventDispatcher.listenerAndHandlers;
        DrmSessionEventListener.EventDispatcher.ListenerAndHandler listenerAndHandler = new DrmSessionEventListener.EventDispatcher.ListenerAndHandler();
        listenerAndHandler.handler = handler2;
        listenerAndHandler.listener = forwardingEventListener;
        copyOnWriteArrayList2.add(listenerAndHandler);
        DefaultBandwidthMeter defaultBandwidthMeter = this.mediaTransferListener;
        PlayerId playerId = this.playerId;
        playerId.getClass();
        baseMediaSource.prepareSource(r1, defaultBandwidthMeter, playerId);
        if (this.enabledMediaSourceCallers.isEmpty()) {
            baseMediaSource.disable(r1);
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public void releaseSourceInternal() {
        HashMap map = this.childSources;
        for (MediaSourceAndListener mediaSourceAndListener : map.values()) {
            BaseMediaSource baseMediaSource = mediaSourceAndListener.mediaSource;
            ForwardingEventListener forwardingEventListener = mediaSourceAndListener.eventListener;
            baseMediaSource.releaseSource(mediaSourceAndListener.caller);
            baseMediaSource.removeEventListener(forwardingEventListener);
            baseMediaSource.removeDrmEventListener(forwardingEventListener);
        }
        map.clear();
    }

    public long getMediaTimeForChildMediaTime(long j, Object obj) {
        return j;
    }

    public int getWindowIndexForChildWindowIndex(int i, Object obj) {
        return i;
    }
}
