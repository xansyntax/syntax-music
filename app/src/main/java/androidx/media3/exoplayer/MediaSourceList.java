package androidx.media3.exoplayer;

import android.os.Handler;
import android.util.Pair;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.MediaSource$MediaSourceCaller;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$ListenerAndHandler;
import androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda3;
import androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda6;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSourceList {
    public final SystemHandlerWrapper eventHandler;
    public final DefaultAnalyticsCollector eventListener;
    public boolean isPrepared;
    public final ExoPlayerImplInternal mediaSourceListInfoListener;
    public DefaultBandwidthMeter mediaTransferListener;
    public final PlayerId playerId;
    public ShuffleOrder$DefaultShuffleOrder shuffleOrder = new ShuffleOrder$DefaultShuffleOrder();
    public final IdentityHashMap mediaSourceByMediaPeriod = new IdentityHashMap();
    public final HashMap mediaSourceByUid = new HashMap();
    public final ArrayList mediaSourceHolders = new ArrayList();
    public final HashMap childSources = new HashMap();
    public final HashSet enabledMediaSourceHolders = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {
        public final MediaSourceHolder id;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.id = mediaSourceHolder;
        }

        public final Pair getEventParameters(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodIdCopyWithPeriodUid;
            MediaSourceHolder mediaSourceHolder = this.id;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = null;
            if (mediaSource$MediaPeriodId != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= mediaSourceHolder.activeMediaPeriodIds.size()) {
                        mediaSource$MediaPeriodIdCopyWithPeriodUid = null;
                        break;
                    }
                    if (((MediaSource$MediaPeriodId) mediaSourceHolder.activeMediaPeriodIds.get(i2)).windowSequenceNumber == mediaSource$MediaPeriodId.windowSequenceNumber) {
                        Object obj = mediaSource$MediaPeriodId.periodUid;
                        Object obj2 = mediaSourceHolder.uid;
                        int i3 = PlaylistTimeline.$r8$clinit;
                        mediaSource$MediaPeriodIdCopyWithPeriodUid = mediaSource$MediaPeriodId.copyWithPeriodUid(Pair.create(obj2, obj));
                        break;
                    }
                    i2++;
                }
                if (mediaSource$MediaPeriodIdCopyWithPeriodUid == null) {
                    return null;
                }
                mediaSource$MediaPeriodId2 = mediaSource$MediaPeriodIdCopyWithPeriodUid;
            }
            return Pair.create(Integer.valueOf(i + mediaSourceHolder.firstWindowIndexInChild), mediaSource$MediaPeriodId2);
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onDownstreamFormatChanged(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, FloatTweenSpec floatTweenSpec) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new Util$$ExternalSyntheticLambda1((Object) this, (Object) eventParameters, (Object) floatTweenSpec, (byte) 6));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmKeysLoaded(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, CueDecoder cueDecoder) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new Util$$ExternalSyntheticLambda1((Object) this, (Object) eventParameters, (Object) cueDecoder, (byte) 8));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmKeysRestored(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda6(this, eventParameters, (byte) 1));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmSessionAcquired(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, int i2) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, eventParameters, i2, (byte) 1));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmSessionManagerError(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Exception exc) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new Util$$ExternalSyntheticLambda1((Object) this, (Object) eventParameters, (Object) exc, (byte) 7));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void onDrmSessionReleased(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda6(this, eventParameters, (byte) 0));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onLoadCanceled(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda0(this, eventParameters, loadEventInfo, floatTweenSpec, (byte) 0));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onLoadCompleted(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda0(this, eventParameters, loadEventInfo, floatTweenSpec, (byte) 1));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onLoadError(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, IOException iOException, boolean z) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new MediaNotificationManager$$ExternalSyntheticLambda6((byte) 2, this, eventParameters, loadEventInfo, floatTweenSpec, iOException, z));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void onLoadStarted(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, int i2) {
            Pair eventParameters = getEventParameters(i, mediaSource$MediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new MediaControllerImplLegacy$$ExternalSyntheticLambda3(this, eventParameters, loadEventInfo, floatTweenSpec, i2, (byte) 1));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaSourceAndListener {
        public final MediaSourceList$$ExternalSyntheticLambda0 caller;
        public final ForwardingEventListener eventListener;
        public final BaseMediaSource mediaSource;

        public MediaSourceAndListener(BaseMediaSource baseMediaSource, MediaSourceList$$ExternalSyntheticLambda0 mediaSourceList$$ExternalSyntheticLambda0, ForwardingEventListener forwardingEventListener) {
            this.mediaSource = baseMediaSource;
            this.caller = mediaSourceList$$ExternalSyntheticLambda0;
            this.eventListener = forwardingEventListener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaSourceHolder implements MediaSourceInfoHolder {
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final ArrayList activeMediaPeriodIds = new ArrayList();
        public final Object uid = new Object();

        public MediaSourceHolder(BaseMediaSource baseMediaSource, boolean z) {
            this.mediaSource = new MaskingMediaSource(baseMediaSource, z);
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public final Timeline getTimeline() {
            return this.mediaSource.timeline;
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public final Object getUid() {
            return this.uid;
        }
    }

    public MediaSourceList(ExoPlayerImplInternal exoPlayerImplInternal, DefaultAnalyticsCollector defaultAnalyticsCollector, SystemHandlerWrapper systemHandlerWrapper, PlayerId playerId) {
        this.playerId = playerId;
        this.mediaSourceListInfoListener = exoPlayerImplInternal;
        this.eventListener = defaultAnalyticsCollector;
        this.eventHandler = systemHandlerWrapper;
    }

    public final Timeline addMediaSources(int i, ArrayList arrayList, ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder) {
        if (!arrayList.isEmpty()) {
            this.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
            for (int i2 = i; i2 < arrayList.size() + i; i2++) {
                MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) arrayList.get(i2 - i);
                ArrayList arrayList2 = this.mediaSourceHolders;
                if (i2 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = (MediaSourceHolder) arrayList2.get(i2 - 1);
                    mediaSourceHolder.firstWindowIndexInChild = mediaSourceHolder2.mediaSource.timeline.timeline.getWindowCount() + mediaSourceHolder2.firstWindowIndexInChild;
                    mediaSourceHolder.isRemoved = false;
                    mediaSourceHolder.activeMediaPeriodIds.clear();
                } else {
                    mediaSourceHolder.firstWindowIndexInChild = 0;
                    mediaSourceHolder.isRemoved = false;
                    mediaSourceHolder.activeMediaPeriodIds.clear();
                }
                int windowCount = mediaSourceHolder.mediaSource.timeline.timeline.getWindowCount();
                for (int i3 = i2; i3 < arrayList2.size(); i3++) {
                    ((MediaSourceHolder) arrayList2.get(i3)).firstWindowIndexInChild += windowCount;
                }
                arrayList2.add(i2, mediaSourceHolder);
                this.mediaSourceByUid.put(mediaSourceHolder.uid, mediaSourceHolder);
                if (this.isPrepared) {
                    prepareChildSource(mediaSourceHolder);
                    if (this.mediaSourceByMediaPeriod.isEmpty()) {
                        this.enabledMediaSourceHolders.add(mediaSourceHolder);
                    } else {
                        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.childSources.get(mediaSourceHolder);
                        if (mediaSourceAndListener != null) {
                            mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
                        }
                    }
                }
            }
        }
        return createTimeline();
    }

    public final Timeline createTimeline() {
        ArrayList arrayList = this.mediaSourceHolders;
        if (arrayList.isEmpty()) {
            return Timeline.EMPTY;
        }
        int windowCount = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) arrayList.get(i);
            mediaSourceHolder.firstWindowIndexInChild = windowCount;
            windowCount += mediaSourceHolder.mediaSource.timeline.timeline.getWindowCount();
        }
        return new PlaylistTimeline(arrayList, this.shuffleOrder);
    }

    public final void disableUnusedMediaSources() {
        Iterator it = this.enabledMediaSourceHolders.iterator();
        while (it.hasNext()) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) it.next();
            if (mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
                MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.childSources.get(mediaSourceHolder);
                if (mediaSourceAndListener != null) {
                    mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
                }
                it.remove();
            }
        }
    }

    public final void maybeReleaseChildSource(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.childSources.remove(mediaSourceHolder);
            mediaSourceAndListener.getClass();
            ForwardingEventListener forwardingEventListener = mediaSourceAndListener.eventListener;
            BaseMediaSource baseMediaSource = mediaSourceAndListener.mediaSource;
            baseMediaSource.releaseSource(mediaSourceAndListener.caller);
            baseMediaSource.removeEventListener(forwardingEventListener);
            baseMediaSource.removeDrmEventListener(forwardingEventListener);
            this.enabledMediaSourceHolders.remove(mediaSourceHolder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.media3.exoplayer.MediaSourceList$$ExternalSyntheticLambda0, androidx.media3.exoplayer.source.MediaSource$MediaSourceCaller] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void prepareChildSource(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.mediaSource;
        ?? r1 = new MediaSource$MediaSourceCaller() { // from class: androidx.media3.exoplayer.MediaSourceList$$ExternalSyntheticLambda0
            @Override // androidx.media3.exoplayer.source.MediaSource$MediaSourceCaller
            public final void onSourceInfoRefreshed(BaseMediaSource baseMediaSource, Timeline timeline) {
                SystemHandlerWrapper systemHandlerWrapper = this.f$0.mediaSourceListInfoListener.handler;
                systemHandlerWrapper.removeMessages(2);
                systemHandlerWrapper.sendEmptyMessage(22);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.childSources.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, r1, forwardingEventListener));
        Handler handlerCreateHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper(null);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) maskingMediaSource.eventDispatcher.message;
        MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = new MediaSourceEventListener$EventDispatcher$ListenerAndHandler();
        mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler = handlerCreateHandlerForCurrentOrMainLooper;
        mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener = forwardingEventListener;
        copyOnWriteArrayList.add(mediaSourceEventListener$EventDispatcher$ListenerAndHandler);
        Handler handlerCreateHandlerForCurrentOrMainLooper2 = Util.createHandlerForCurrentOrMainLooper(null);
        CopyOnWriteArrayList copyOnWriteArrayList2 = maskingMediaSource.drmEventDispatcher.listenerAndHandlers;
        DrmSessionEventListener.EventDispatcher.ListenerAndHandler listenerAndHandler = new DrmSessionEventListener.EventDispatcher.ListenerAndHandler();
        listenerAndHandler.handler = handlerCreateHandlerForCurrentOrMainLooper2;
        listenerAndHandler.listener = forwardingEventListener;
        copyOnWriteArrayList2.add(listenerAndHandler);
        maskingMediaSource.prepareSource(r1, this.mediaTransferListener, this.playerId);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        IdentityHashMap identityHashMap = this.mediaSourceByMediaPeriod;
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) identityHashMap.remove(mediaPeriod);
        mediaSourceHolder.getClass();
        mediaSourceHolder.mediaSource.releasePeriod(mediaPeriod);
        mediaSourceHolder.activeMediaPeriodIds.remove(((MaskingMediaPeriod) mediaPeriod).id);
        if (!identityHashMap.isEmpty()) {
            disableUnusedMediaSources();
        }
        maybeReleaseChildSource(mediaSourceHolder);
    }

    public final void removeMediaSourcesInternal(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            ArrayList arrayList = this.mediaSourceHolders;
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) arrayList.remove(i3);
            this.mediaSourceByUid.remove(mediaSourceHolder.uid);
            int i4 = -mediaSourceHolder.mediaSource.timeline.timeline.getWindowCount();
            for (int i5 = i3; i5 < arrayList.size(); i5++) {
                ((MediaSourceHolder) arrayList.get(i5)).firstWindowIndexInChild += i4;
            }
            mediaSourceHolder.isRemoved = true;
            if (this.isPrepared) {
                maybeReleaseChildSource(mediaSourceHolder);
            }
        }
    }
}
