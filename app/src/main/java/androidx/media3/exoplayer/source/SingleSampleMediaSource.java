package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.util.ReleasableExecutor$1;
import androidx.media3.extractor.text.CueDecoder;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleSampleMediaSource extends BaseMediaSource {
    public final DataSource.Factory dataSourceFactory;
    public final DataSpec dataSpec;
    public final Format format;
    public final CueDecoder loadErrorHandlingPolicy;
    public final MediaItem mediaItem;
    public final SinglePeriodTimeline timeline;
    public DefaultBandwidthMeter transferListener;

    public SingleSampleMediaSource(MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, CueDecoder cueDecoder) {
        this.dataSourceFactory = factory;
        this.loadErrorHandlingPolicy = cueDecoder;
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.uri = Uri.EMPTY;
        String string = subtitleConfiguration.uri.toString();
        string.getClass();
        builder.mediaId = string;
        builder.subtitleConfigurations = ImmutableList.copyOf((Collection) ImmutableList.of((Object) subtitleConfiguration));
        builder.tag = null;
        MediaItem mediaItemBuild = builder.build();
        this.mediaItem = mediaItemBuild;
        Format.Builder builder2 = new Format.Builder();
        String str = subtitleConfiguration.mimeType;
        builder2.sampleMimeType = MimeTypes.normalizeMimeType(str == null ? "text/x-unknown" : str);
        builder2.language = subtitleConfiguration.language;
        builder2.selectionFlags = subtitleConfiguration.selectionFlags;
        builder2.roleFlags = subtitleConfiguration.roleFlags;
        builder2.label = subtitleConfiguration.label;
        String str2 = subtitleConfiguration.id;
        builder2.id = str2 != null ? str2 : null;
        this.format = new Format(builder2);
        Map map = Collections.EMPTY_MAP;
        Uri uri = subtitleConfiguration.uri;
        UtilsKt.checkNotNull(uri, "The uri must be set.");
        this.dataSpec = new DataSpec(uri, 0L, 1, null, map, 0L, -1L, null, 1);
        this.timeline = new SinglePeriodTimeline(-9223372036854775807L, true, false, mediaItemBuild);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, EmojiProcessor emojiProcessor, long j) {
        return new SingleSampleMediaPeriod(this.dataSpec, this.dataSourceFactory, this.transferListener, this.format, this.loadErrorHandlingPolicy, new StatusLine((CopyOnWriteArrayList) this.eventDispatcher.message, 0, mediaSource$MediaPeriodId), null);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void prepareSourceInternal(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.transferListener = defaultBandwidthMeter;
        refreshSourceInfo(this.timeline);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void releasePeriod(MediaPeriod mediaPeriod) {
        Loader loader = ((SingleSampleMediaPeriod) mediaPeriod).loader;
        ReleasableExecutor$1 releasableExecutor$1 = loader.downloadExecutor;
        Loader.LoadTask loadTask = loader.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        releasableExecutor$1.val$releaseCallback.accept(releasableExecutor$1.val$executor);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void maybeThrowSourceInfoRefreshError() {
    }
}
