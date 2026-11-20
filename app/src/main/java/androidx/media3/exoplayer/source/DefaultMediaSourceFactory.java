package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.text.CueDecoder;
import coil3.ImageLoader$Builder;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultMediaSourceFactory implements MediaSource$Factory {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final DataSource.Factory dataSourceFactory;
    public final ImageLoader$Builder delegateFactoryLoader;
    public final long liveMaxOffsetMs;
    public final float liveMaxSpeed;
    public final long liveMinOffsetMs;
    public final float liveMinSpeed;
    public final long liveTargetOffsetMs;
    public boolean parseSubtitlesDuringExtraction;
    public CueDecoder subtitleParserFactory;

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        CueDecoder cueDecoder = new CueDecoder((byte) 15);
        this.dataSourceFactory = factory;
        this.subtitleParserFactory = cueDecoder;
        ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(extractorsFactory, cueDecoder);
        this.delegateFactoryLoader = imageLoader$Builder;
        if (factory != ((DataSource.Factory) imageLoader$Builder.diskCacheLazy)) {
            imageLoader$Builder.diskCacheLazy = factory;
            ((HashMap) imageLoader$Builder.defaults).clear();
            ((HashMap) imageLoader$Builder.memoryCacheLazy).clear();
        }
        this.liveTargetOffsetMs = -9223372036854775807L;
        this.liveMinOffsetMs = -9223372036854775807L;
        this.liveMaxOffsetMs = -9223372036854775807L;
        this.liveMinSpeed = -3.4028235E38f;
        this.liveMaxSpeed = -3.4028235E38f;
        this.parseSubtitlesDuringExtraction = true;
    }

    public static MediaSource$Factory newInstance(Class cls, DataSource.Factory factory) {
        try {
            return (MediaSource$Factory) cls.getConstructor(DataSource.Factory.class).newInstance(factory);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource$Factory
    public final BaseMediaSource createMediaSource(MediaItem mediaItem) {
        mediaItem.localConfiguration.getClass();
        String scheme = mediaItem.localConfiguration.uri.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            throw null;
        }
        boolean zEquals = Objects.equals(mediaItem.localConfiguration.mimeType, "application/x-image-uri");
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        if (zEquals) {
            long j = localConfiguration.imageDurationMs;
            String str = Util.DEVICE_DEBUG_INFO;
            throw null;
        }
        int iInferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType);
        if (mediaItem.localConfiguration.imageDurationMs != -9223372036854775807L) {
            ExtractorsFactory extractorsFactory = (ExtractorsFactory) this.delegateFactoryLoader.application;
            if (extractorsFactory instanceof DefaultExtractorsFactory) {
                DefaultExtractorsFactory defaultExtractorsFactory = (DefaultExtractorsFactory) extractorsFactory;
                synchronized (defaultExtractorsFactory) {
                    defaultExtractorsFactory.jpegFlags = true;
                }
            }
            ExtractorsFactory extractorsFactory2 = (ExtractorsFactory) this.delegateFactoryLoader.application;
            if (extractorsFactory2 instanceof DefaultExtractorsFactory) {
                DefaultExtractorsFactory defaultExtractorsFactory2 = (DefaultExtractorsFactory) extractorsFactory2;
                synchronized (defaultExtractorsFactory2) {
                    defaultExtractorsFactory2.heifFlags = true;
                }
            }
        }
        try {
            ImageLoader$Builder imageLoader$Builder = this.delegateFactoryLoader;
            HashMap map = (HashMap) imageLoader$Builder.memoryCacheLazy;
            MediaSource$Factory mediaSource$Factory = (MediaSource$Factory) map.get(Integer.valueOf(iInferContentTypeForUriAndMimeType));
            if (mediaSource$Factory == null) {
                mediaSource$Factory = (MediaSource$Factory) imageLoader$Builder.loadSupplier(iInferContentTypeForUriAndMimeType).get();
                mediaSource$Factory.setSubtitleParserFactory((CueDecoder) imageLoader$Builder.extras);
                mediaSource$Factory.experimentalParseSubtitlesDuringExtraction();
                mediaSource$Factory.experimentalSetCodecsToParseWithinGopSampleDependencies();
                map.put(Integer.valueOf(iInferContentTypeForUriAndMimeType), mediaSource$Factory);
            }
            MediaItem.LiveConfiguration.Builder builderBuildUpon = mediaItem.liveConfiguration.buildUpon();
            MediaItem.LiveConfiguration liveConfiguration = mediaItem.liveConfiguration;
            if (liveConfiguration.targetOffsetMs == -9223372036854775807L) {
                builderBuildUpon.targetOffsetMs = this.liveTargetOffsetMs;
            }
            if (liveConfiguration.minPlaybackSpeed == -3.4028235E38f) {
                builderBuildUpon.minPlaybackSpeed = this.liveMinSpeed;
            }
            if (liveConfiguration.maxPlaybackSpeed == -3.4028235E38f) {
                builderBuildUpon.maxPlaybackSpeed = this.liveMaxSpeed;
            }
            if (liveConfiguration.minOffsetMs == -9223372036854775807L) {
                builderBuildUpon.minOffsetMs = this.liveMinOffsetMs;
            }
            if (liveConfiguration.maxOffsetMs == -9223372036854775807L) {
                builderBuildUpon.maxOffsetMs = this.liveMaxOffsetMs;
            }
            MediaItem.LiveConfiguration liveConfiguration2 = new MediaItem.LiveConfiguration(builderBuildUpon);
            if (!liveConfiguration2.equals(mediaItem.liveConfiguration)) {
                MediaItem.Builder builderBuildUpon2 = mediaItem.buildUpon();
                builderBuildUpon2.liveConfiguration = liveConfiguration2.buildUpon();
                mediaItem = builderBuildUpon2.build();
            }
            BaseMediaSource baseMediaSourceCreateMediaSource = mediaSource$Factory.createMediaSource(mediaItem);
            ImmutableList immutableList = mediaItem.localConfiguration.subtitleConfigurations;
            if (!immutableList.isEmpty()) {
                BaseMediaSource[] baseMediaSourceArr = new BaseMediaSource[immutableList.size() + 1];
                baseMediaSourceArr[0] = baseMediaSourceCreateMediaSource;
                for (int i = 0; i < immutableList.size(); i++) {
                    byte b = 6;
                    if (this.parseSubtitlesDuringExtraction) {
                        Format.Builder builder = new Format.Builder();
                        builder.sampleMimeType = MimeTypes.normalizeMimeType(((MediaItem.SubtitleConfiguration) immutableList.get(i)).mimeType);
                        builder.language = ((MediaItem.SubtitleConfiguration) immutableList.get(i)).language;
                        builder.selectionFlags = ((MediaItem.SubtitleConfiguration) immutableList.get(i)).selectionFlags;
                        builder.roleFlags = ((MediaItem.SubtitleConfiguration) immutableList.get(i)).roleFlags;
                        builder.label = ((MediaItem.SubtitleConfiguration) immutableList.get(i)).label;
                        builder.id = ((MediaItem.SubtitleConfiguration) immutableList.get(i)).id;
                        Format format = new Format(builder);
                        ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.dataSourceFactory, new TextLinkScope$$ExternalSyntheticLambda10(this, format, b));
                        if (this.subtitleParserFactory.supportsFormat(format)) {
                            Format.Builder builderBuildUpon3 = format.buildUpon();
                            builderBuildUpon3.sampleMimeType = MimeTypes.normalizeMimeType("application/x-media3-cues");
                            builderBuildUpon3.codecs = format.sampleMimeType;
                            builderBuildUpon3.cueReplacementBehavior = this.subtitleParserFactory.getCueReplacementBehavior(format);
                            format = new Format(builderBuildUpon3);
                        }
                        factory.singleTrackFormat = format;
                        int i2 = i + 1;
                        String string = ((MediaItem.SubtitleConfiguration) immutableList.get(i)).uri.toString();
                        MediaItem.Builder builder2 = new MediaItem.Builder();
                        builder2.uri = string == null ? null : Uri.parse(string);
                        baseMediaSourceArr[i2] = factory.createMediaSource(builder2.build());
                    } else {
                        DataSource.Factory factory2 = this.dataSourceFactory;
                        factory2.getClass();
                        baseMediaSourceArr[i + 1] = new SingleSampleMediaSource((MediaItem.SubtitleConfiguration) immutableList.get(i), factory2, new CueDecoder((byte) 6));
                    }
                }
                baseMediaSourceCreateMediaSource = new MergingMediaSource(baseMediaSourceArr);
            }
            MediaItem.ClippingProperties clippingProperties = mediaItem.clippingConfiguration;
            if (clippingProperties.startPositionUs != 0 || clippingProperties.endPositionUs != Long.MIN_VALUE || clippingProperties.relativeToDefaultPosition) {
                ClippingMediaSource.Builder builder3 = new ClippingMediaSource.Builder(baseMediaSourceCreateMediaSource);
                long j2 = clippingProperties.startPositionUs;
                UtilsKt.checkArgument(j2 >= 0);
                UtilsKt.checkState(!builder3.buildCalled);
                builder3.startPositionUs = j2;
                long j3 = clippingProperties.endPositionUs;
                UtilsKt.checkState(!builder3.buildCalled);
                builder3.endPositionUs = j3;
                boolean z = !clippingProperties.startsAtKeyFrame;
                UtilsKt.checkState(!builder3.buildCalled);
                builder3.enableInitialDiscontinuity = z;
                boolean z2 = clippingProperties.relativeToLiveWindow;
                UtilsKt.checkState(!builder3.buildCalled);
                builder3.allowDynamicClippingUpdates = z2;
                boolean z3 = clippingProperties.relativeToDefaultPosition;
                UtilsKt.checkState(!builder3.buildCalled);
                builder3.relativeToDefaultPosition = z3;
                boolean z4 = clippingProperties.allowUnseekableMedia;
                UtilsKt.checkState(!builder3.buildCalled);
                builder3.allowUnseekableMedia = z4;
                UtilsKt.checkState(!builder3.buildCalled);
                builder3.buildCalled = true;
                baseMediaSourceCreateMediaSource = new ClippingMediaSource(builder3);
            }
            mediaItem.localConfiguration.getClass();
            if (mediaItem.localConfiguration.adsConfiguration == null) {
                return baseMediaSourceCreateMediaSource;
            }
            Log.w("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return baseMediaSourceCreateMediaSource;
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource$Factory
    public final void experimentalParseSubtitlesDuringExtraction() {
        this.parseSubtitlesDuringExtraction = true;
        ImageLoader$Builder imageLoader$Builder = this.delegateFactoryLoader;
        ((ExtractorsFactory) imageLoader$Builder.application).experimentalSetTextTrackTranscodingEnabled();
        Iterator it = ((HashMap) imageLoader$Builder.memoryCacheLazy).values().iterator();
        while (it.hasNext()) {
            ((MediaSource$Factory) it.next()).experimentalParseSubtitlesDuringExtraction();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource$Factory
    public final void experimentalSetCodecsToParseWithinGopSampleDependencies() {
        ((ExtractorsFactory) this.delegateFactoryLoader.application).experimentalSetCodecsToParseWithinGopSampleDependencies();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource$Factory
    public final void setSubtitleParserFactory(CueDecoder cueDecoder) {
        this.subtitleParserFactory = cueDecoder;
        ImageLoader$Builder imageLoader$Builder = this.delegateFactoryLoader;
        imageLoader$Builder.extras = cueDecoder;
        ((ExtractorsFactory) imageLoader$Builder.application).setSubtitleParserFactory(cueDecoder);
        Iterator it = ((HashMap) imageLoader$Builder.memoryCacheLazy).values().iterator();
        while (it.hasNext()) {
            ((MediaSource$Factory) it.next()).setSubtitleParserFactory(cueDecoder);
        }
    }
}
