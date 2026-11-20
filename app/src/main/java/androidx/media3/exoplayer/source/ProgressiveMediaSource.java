package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Looper;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.text.CueDecoder;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressiveMediaSource extends BaseMediaSource {
    public final DataSource.Factory dataSourceFactory;
    public final DrmSessionManager drmSessionManager;
    public boolean hasSeenNonEstimatedSeekMap;
    public final CueDecoder loadableLoadErrorHandlingPolicy;
    public MediaItem mediaItem;
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 progressiveMediaExtractorFactory;
    public final Format singleTrackFormat;
    public boolean timelineIsLive;
    public boolean timelineIsSeekable;
    public DefaultBandwidthMeter transferListener;
    public boolean timelineIsPlaceholder = true;
    public long timelineDurationUs = -9223372036854775807L;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.source.ProgressiveMediaSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ForwardingTimeline {
        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            super.getPeriod(i, period, z);
            period.isPlaceholder = true;
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            super.getWindow(i, window, j);
            window.isPlaceholder = true;
            return window;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements MediaSource$Factory {
        public final DataSource.Factory dataSourceFactory;
        public final EmojiProcessor drmSessionManagerProvider;
        public final CueDecoder loadErrorHandlingPolicy;
        public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 progressiveMediaExtractorFactory;
        public Format singleTrackFormat;

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 18, (Object) extractorsFactory);
            EmojiProcessor emojiProcessor = new EmojiProcessor((byte) 23);
            CueDecoder cueDecoder = new CueDecoder((byte) 6);
            this.dataSourceFactory = factory;
            this.progressiveMediaExtractorFactory = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
            this.drmSessionManagerProvider = emojiProcessor;
            this.loadErrorHandlingPolicy = cueDecoder;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource$Factory
        public final ProgressiveMediaSource createMediaSource(MediaItem mediaItem) {
            DrmSessionManager drmSessionManager;
            mediaItem.localConfiguration.getClass();
            DataSource.Factory factory = this.dataSourceFactory;
            OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = this.progressiveMediaExtractorFactory;
            EmojiProcessor emojiProcessor = this.drmSessionManagerProvider;
            mediaItem.localConfiguration.getClass();
            MediaItem.DrmConfiguration drmConfiguration = mediaItem.localConfiguration.drmConfiguration;
            if (drmConfiguration == null) {
                drmSessionManager = DrmSessionManager.DRM_UNSUPPORTED;
            } else {
                synchronized (emojiProcessor.mSpanFactory) {
                    try {
                        if (!drmConfiguration.equals((MediaItem.DrmConfiguration) emojiProcessor.mMetadataRepo)) {
                            emojiProcessor.mMetadataRepo = drmConfiguration;
                            emojiProcessor.mGlyphChecker = EmojiProcessor.createManager(drmConfiguration);
                        }
                        drmSessionManager = (DefaultDrmSessionManager) emojiProcessor.mGlyphChecker;
                        drmSessionManager.getClass();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return new ProgressiveMediaSource(mediaItem, factory, onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0, drmSessionManager, this.loadErrorHandlingPolicy, this.singleTrackFormat);
        }
    }

    public ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0, DrmSessionManager drmSessionManager, CueDecoder cueDecoder, Format format) {
        this.mediaItem = mediaItem;
        this.dataSourceFactory = factory;
        this.progressiveMediaExtractorFactory = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        this.drmSessionManager = drmSessionManager;
        this.loadableLoadErrorHandlingPolicy = cueDecoder;
        this.singleTrackFormat = format;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final boolean canUpdateMediaItem(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = getMediaItem().localConfiguration;
        localConfiguration.getClass();
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.localConfiguration;
        return localConfiguration2 != null && localConfiguration2.uri.equals(localConfiguration.uri) && localConfiguration2.imageDurationMs == localConfiguration.imageDurationMs && Objects.equals(localConfiguration2.customCacheKey, localConfiguration.customCacheKey);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, EmojiProcessor emojiProcessor, long j) {
        DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
        DefaultBandwidthMeter defaultBandwidthMeter = this.transferListener;
        if (defaultBandwidthMeter != null) {
            dataSourceCreateDataSource.addTransferListener(defaultBandwidthMeter);
        }
        MediaItem.LocalConfiguration localConfiguration = getMediaItem().localConfiguration;
        localConfiguration.getClass();
        Uri uri = localConfiguration.uri;
        this.playerId.getClass();
        return new ProgressiveMediaPeriod(uri, dataSourceCreateDataSource, new EmojiProcessor((byte) 25, this.progressiveMediaExtractorFactory.f$0), this.drmSessionManager, new DrmSessionEventListener.EventDispatcher(this.drmEventDispatcher.listenerAndHandlers, 0, mediaSource$MediaPeriodId), this.loadableLoadErrorHandlingPolicy, new StatusLine((CopyOnWriteArrayList) this.eventDispatcher.message, 0, mediaSource$MediaPeriodId), this, emojiProcessor, localConfiguration.customCacheKey, this.singleTrackFormat, Util.msToUs(localConfiguration.imageDurationMs), null);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final synchronized MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public final void notifySourceInfoRefreshed() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, this.timelineIsLive, getMediaItem());
        if (this.timelineIsPlaceholder) {
            singlePeriodTimeline = new AnonymousClass1(singlePeriodTimeline);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    public final void onSourceInfoRefreshed(long j, SeekMap seekMap, boolean z) {
        if (this.hasSeenNonEstimatedSeekMap && seekMap.isEstimated()) {
            return;
        }
        this.hasSeenNonEstimatedSeekMap = !seekMap.isEstimated();
        if (j == -9223372036854775807L) {
            j = this.timelineDurationUs;
        }
        boolean zIsSeekable = seekMap.isSeekable();
        if (!this.timelineIsPlaceholder && this.timelineDurationUs == j && this.timelineIsSeekable == zIsSeekable && this.timelineIsLive == z) {
            return;
        }
        this.timelineDurationUs = j;
        this.timelineIsSeekable = zIsSeekable;
        this.timelineIsLive = z;
        this.timelineIsPlaceholder = false;
        notifySourceInfoRefreshed();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void prepareSourceInternal(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.transferListener = defaultBandwidthMeter;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        PlayerId playerId = this.playerId;
        playerId.getClass();
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        drmSessionManager.setPlayer(looperMyLooper, playerId);
        drmSessionManager.prepare();
        notifySourceInfoRefreshed();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void releaseSourceInternal() {
        this.drmSessionManager.release();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final synchronized void updateMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }
}
