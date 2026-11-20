package androidx.media3.exoplayer.analytics;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.material3.FabPlacement;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.HttpDataSource$HttpDataSourceException;
import androidx.media3.datasource.HttpDataSource$InvalidContentTypeException;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.UdpDataSource;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import com.google.common.collect.ImmutableList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaMetricsListener implements AnalyticsListener, PlaybackSessionManager$Listener {
    public String activeSessionId;
    public int audioUnderruns;
    public final Context context;
    public Format currentAudioFormat;
    public Format currentTextFormat;
    public Format currentVideoFormat;
    public int discontinuityReason;
    public int droppedFrames;
    public boolean hasFatalError;
    public boolean ioErrorType;
    public boolean isSeeking;
    public PlaybackMetrics.Builder metricsBuilder;
    public WeakCache pendingAudioFormat;
    public PlaybackException pendingPlayerError;
    public WeakCache pendingTextFormat;
    public WeakCache pendingVideoFormat;
    public final PlaybackSession playbackSession;
    public int playedFrames;
    public boolean reportedEventsForCurrentSession;
    public final DefaultPlaybackSessionManager sessionManager;
    public final Executor backgroundExecutor = Log.get();
    public final Timeline.Window window = new Timeline.Window();
    public final Timeline.Period period = new Timeline.Period();
    public final HashMap bandwidthBytes = new HashMap();
    public final HashMap bandwidthTimeMs = new HashMap();
    public final long startTimeMs = SystemClock.elapsedRealtime();
    public int currentPlaybackState = 0;
    public int currentNetworkType = 0;

    public MediaMetricsListener(Context context, PlaybackSession playbackSession) {
        this.context = context.getApplicationContext();
        this.playbackSession = playbackSession;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.listener = this;
    }

    public static MediaMetricsListener create(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new MediaMetricsListener(context, mediaMetricsManager.createPlaybackSession());
    }

    public final boolean canReportPendingFormatUpdate(WeakCache weakCache) {
        String str;
        if (weakCache == null) {
            return false;
        }
        String str2 = (String) weakCache.referenceQueue;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = this.sessionManager;
        synchronized (defaultPlaybackSessionManager) {
            str = defaultPlaybackSessionManager.currentSessionId;
        }
        return str2.equals(str);
    }

    public final void finishCurrentSession() {
        PlaybackMetrics.Builder builder = this.metricsBuilder;
        if (builder != null && this.reportedEventsForCurrentSession) {
            builder.setAudioUnderrunCount(this.audioUnderruns);
            this.metricsBuilder.setVideoFramesDropped(this.droppedFrames);
            this.metricsBuilder.setVideoFramesPlayed(this.playedFrames);
            Long l = (Long) this.bandwidthTimeMs.get(this.activeSessionId);
            this.metricsBuilder.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.bandwidthBytes.get(this.activeSessionId);
            this.metricsBuilder.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.metricsBuilder.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.backgroundExecutor.execute(new ComponentActivity$$ExternalSyntheticLambda10(this, this.metricsBuilder.build(), (byte) 17));
        }
        this.metricsBuilder = null;
        this.activeSessionId = null;
        this.audioUnderruns = 0;
        this.droppedFrames = 0;
        this.playedFrames = 0;
        this.currentVideoFormat = null;
        this.currentAudioFormat = null;
        this.currentTextFormat = null;
        this.reportedEventsForCurrentSession = false;
    }

    public final LogSessionId getLogSessionId() {
        return this.playbackSession.getSessionId();
    }

    public final /* synthetic */ void lambda$finishCurrentSession$4(PlaybackMetrics playbackMetrics) {
        this.playbackSession.reportPlaybackMetrics(playbackMetrics);
    }

    public final /* synthetic */ void lambda$maybeReportNetworkChange$1(NetworkEvent networkEvent) {
        this.playbackSession.reportNetworkEvent(networkEvent);
    }

    public final /* synthetic */ void lambda$maybeReportPlaybackError$0(PlaybackErrorEvent playbackErrorEvent) {
        this.playbackSession.reportPlaybackErrorEvent(playbackErrorEvent);
    }

    public final /* synthetic */ void lambda$maybeReportPlaybackStateChange$2(PlaybackStateEvent playbackStateEvent) {
        this.playbackSession.reportPlaybackStateEvent(playbackStateEvent);
    }

    public final /* synthetic */ void lambda$reportTrackChangeEvent$3(TrackChangeEvent trackChangeEvent) {
        this.playbackSession.reportTrackChangeEvent(trackChangeEvent);
    }

    public final void maybeUpdateTimelineMetadata(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        int indexOfPeriod;
        PlaybackMetrics.Builder builder = this.metricsBuilder;
        if (mediaSource$MediaPeriodId == null || (indexOfPeriod = timeline.getIndexOfPeriod(mediaSource$MediaPeriodId.periodUid)) == -1) {
            return;
        }
        Timeline.Period period = this.period;
        int i = 0;
        timeline.getPeriod(indexOfPeriod, period, false);
        int i2 = period.windowIndex;
        Timeline.Window window = this.window;
        timeline.getWindow(i2, window);
        MediaItem.LocalConfiguration localConfiguration = window.mediaItem.localConfiguration;
        if (localConfiguration != null) {
            int iInferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType);
            if (iInferContentTypeForUriAndMimeType == 0) {
                i = 3;
            } else if (iInferContentTypeForUriAndMimeType != 1) {
                i = iInferContentTypeForUriAndMimeType != 2 ? 1 : 4;
            } else {
                i = 5;
            }
        }
        builder.setStreamType(i);
        if (window.durationUs != -9223372036854775807L && !window.isPlaceholder && !window.isDynamic && !window.isLive()) {
            builder.setMediaDurationMillis(Util.usToMs(window.durationUs));
        }
        builder.setPlaybackType(window.isLive() ? 2 : 1);
        this.reportedEventsForCurrentSession = true;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = eventTime.mediaPeriodId;
        if (mediaSource$MediaPeriodId != null) {
            String sessionForMediaPeriodId = this.sessionManager.getSessionForMediaPeriodId(eventTime.timeline, mediaSource$MediaPeriodId);
            HashMap map = this.bandwidthBytes;
            Long l = (Long) map.get(sessionForMediaPeriodId);
            HashMap map2 = this.bandwidthTimeMs;
            Long l2 = (Long) map2.get(sessionForMediaPeriodId);
            map.put(sessionForMediaPeriodId, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            map2.put(sessionForMediaPeriodId, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, FloatTweenSpec floatTweenSpec) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = eventTime.mediaPeriodId;
        if (mediaSource$MediaPeriodId == null) {
            return;
        }
        Format format = (Format) floatTweenSpec.easing;
        format.getClass();
        Timeline timeline = eventTime.timeline;
        mediaSource$MediaPeriodId.getClass();
        WeakCache weakCache = new WeakCache(format, this.sessionManager.getSessionForMediaPeriodId(timeline, mediaSource$MediaPeriodId), (byte) 23);
        int i = floatTweenSpec.duration;
        if (i != 0) {
            if (i == 1) {
                this.pendingAudioFormat = weakCache;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.pendingTextFormat = weakCache;
                return;
            }
        }
        this.pendingVideoFormat = weakCache;
    }

    /* JADX WARN: Code duplicated, block: B:311:0x0533  */
    /* JADX WARN: Code duplicated, block: B:314:0x055d  */
    /* JADX WARN: Code duplicated, block: B:329:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onEvents(Player player, CallbackWrapper callbackWrapper) {
        DefaultPlaybackSessionManager defaultPlaybackSessionManager;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        FabPlacement fabPlacement;
        int i8;
        FabPlacement fabPlacement2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        int i14;
        Format format;
        DrmInitData drmInitData;
        int i15;
        FlagSet flagSet = (FlagSet) callbackWrapper.mCallback;
        if (flagSet.flags.size() == 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            int size = flagSet.flags.size();
            defaultPlaybackSessionManager = this.sessionManager;
            if (i16 >= size) {
                break;
            }
            int i17 = flagSet.get(i16);
            AnalyticsListener.EventTime eventTime = callbackWrapper.getEventTime(i17);
            if (i17 == 0) {
                defaultPlaybackSessionManager.updateSessionsWithTimelineChange(eventTime);
            } else if (i17 == 11) {
                defaultPlaybackSessionManager.updateSessionsWithDiscontinuity(this.discontinuityReason, eventTime);
            } else {
                defaultPlaybackSessionManager.updateSessions(eventTime);
            }
            i16++;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (callbackWrapper.contains(0)) {
            AnalyticsListener.EventTime eventTime2 = callbackWrapper.getEventTime(0);
            if (this.metricsBuilder != null) {
                maybeUpdateTimelineMetadata(eventTime2.timeline, eventTime2.mediaPeriodId);
            }
        }
        if (callbackWrapper.contains(2) && this.metricsBuilder != null) {
            ImmutableList.Itr itrListIterator = player.getCurrentTracks().groups.listIterator(0);
            loop1: while (true) {
                if (!itrListIterator.hasNext()) {
                    drmInitData = null;
                    break;
                }
                Tracks.Group group = (Tracks.Group) itrListIterator.next();
                for (int i18 = 0; i18 < group.length; i18++) {
                    if (group.trackSelected[i18] && (drmInitData = group.mediaTrackGroup.formats[i18].drmInitData) != null) {
                        break loop1;
                    }
                }
            }
            if (drmInitData != null) {
                PlaybackMetrics.Builder builder = this.metricsBuilder;
                String str = Util.DEVICE_DEBUG_INFO;
                int i19 = 0;
                while (true) {
                    if (i19 >= drmInitData.schemeDataCount) {
                        i15 = 1;
                        break;
                    }
                    UUID uuid = drmInitData.schemeDatas[i19].uuid;
                    if (uuid.equals(C.WIDEVINE_UUID)) {
                        i15 = 3;
                        break;
                    } else if (uuid.equals(C.PLAYREADY_UUID)) {
                        i15 = 2;
                        break;
                    } else {
                        if (uuid.equals(C.CLEARKEY_UUID)) {
                            i15 = 6;
                            break;
                        }
                        i19++;
                    }
                }
                builder.setDrmType(i15);
            }
        }
        if (callbackWrapper.contains(1011)) {
            this.audioUnderruns++;
        }
        PlaybackException playbackException = this.pendingPlayerError;
        Context context = this.context;
        Executor executor = this.backgroundExecutor;
        long j = this.startTimeMs;
        if (playbackException == null) {
            i11 = 1;
            i7 = 13;
            i2 = 8;
            i3 = 7;
            i4 = 6;
            i5 = 9;
            i6 = 5;
        } else {
            int i20 = playbackException.errorCode;
            boolean z3 = this.ioErrorType == 4;
            if (i20 == 1001) {
                fabPlacement = new FabPlacement(20, 0);
                i7 = 13;
                i2 = 8;
                i3 = 7;
                i4 = 6;
                i5 = 9;
                i6 = 5;
            } else {
                if (playbackException instanceof ExoPlaybackException) {
                    ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
                    z = exoPlaybackException.type == 1;
                    i = exoPlaybackException.rendererFormatSupport;
                } else {
                    z = false;
                    i = 0;
                }
                Throwable cause = playbackException.getCause();
                cause.getClass();
                if (cause instanceof IOException) {
                    if (cause instanceof HttpDataSource$InvalidResponseCodeException) {
                        i6 = 5;
                        fabPlacement = new FabPlacement(5, ((HttpDataSource$InvalidResponseCodeException) cause).responseCode);
                    } else {
                        i6 = 5;
                        if ((cause instanceof HttpDataSource$InvalidContentTypeException) || (cause instanceof ParserException)) {
                            i4 = 6;
                            fabPlacement = new FabPlacement(z3 ? 10 : 11, 0);
                            i3 = 7;
                            i2 = 8;
                        } else {
                            boolean z4 = cause instanceof HttpDataSource$HttpDataSourceException;
                            if (z4 || (cause instanceof UdpDataSource.UdpDataSourceException)) {
                                if (NetworkTypeObserver.getInstance(context).getNetworkType() == 1) {
                                    fabPlacement = new FabPlacement(3, 0);
                                } else {
                                    Throwable cause2 = cause.getCause();
                                    if (cause2 instanceof UnknownHostException) {
                                        fabPlacement = new FabPlacement(6, 0);
                                        i6 = 5;
                                        i4 = 6;
                                        i7 = 13;
                                        i2 = 8;
                                        i3 = 7;
                                    } else {
                                        if (cause2 instanceof SocketTimeoutException) {
                                            i9 = 7;
                                            fabPlacement = new FabPlacement(7, 0);
                                        } else {
                                            i9 = 7;
                                            if (z4 && ((HttpDataSource$HttpDataSourceException) cause).type == 1) {
                                                fabPlacement = new FabPlacement(4, 0);
                                            } else {
                                                fabPlacement = new FabPlacement(8, 0);
                                                i3 = 7;
                                                i2 = 8;
                                                i4 = 6;
                                            }
                                        }
                                        i3 = i9;
                                        i6 = 5;
                                        i4 = 6;
                                        i7 = 13;
                                        i2 = 8;
                                    }
                                }
                                i5 = 9;
                            } else if (i20 == 1002) {
                                fabPlacement = new FabPlacement(21, 0);
                            } else if (cause instanceof DrmSession.DrmSessionException) {
                                Throwable cause3 = cause.getCause();
                                cause3.getClass();
                                if (cause3 instanceof MediaDrm.MediaDrmStateException) {
                                    int errorCodeFromPlatformDiagnosticsInfo = Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) cause3).getDiagnosticInfo());
                                    switch (Util.getErrorCodeForMediaDrmErrorCode(errorCodeFromPlatformDiagnosticsInfo)) {
                                        case 6002:
                                            i10 = 24;
                                            break;
                                        case 6003:
                                            i10 = 28;
                                            break;
                                        case 6004:
                                            i10 = 25;
                                            break;
                                        case 6005:
                                            i10 = 26;
                                            break;
                                        default:
                                            i10 = 27;
                                            break;
                                    }
                                    i6 = 5;
                                    fabPlacement = new FabPlacement(i10, errorCodeFromPlatformDiagnosticsInfo);
                                } else if (cause3 instanceof MediaDrmResetException) {
                                    fabPlacement = new FabPlacement(27, 0);
                                } else if (cause3 instanceof NotProvisionedException) {
                                    fabPlacement = new FabPlacement(24, 0);
                                } else if (cause3 instanceof DeniedByServerException) {
                                    fabPlacement = new FabPlacement(29, 0);
                                } else if (cause3 instanceof UnsupportedDrmException) {
                                    fabPlacement = new FabPlacement(23, 0);
                                } else {
                                    fabPlacement = cause3 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new FabPlacement(28, 0) : new FabPlacement(30, 0);
                                }
                                i7 = 13;
                                i2 = 8;
                                i3 = 7;
                                i4 = 6;
                                i5 = 9;
                            } else if ((cause instanceof FileDataSource.FileDataSourceException) && (cause.getCause() instanceof FileNotFoundException)) {
                                Throwable cause4 = cause.getCause();
                                cause4.getClass();
                                Throwable cause5 = cause4.getCause();
                                fabPlacement = ((cause5 instanceof ErrnoException) && ((ErrnoException) cause5).errno == OsConstants.EACCES) ? new FabPlacement(32, 0) : new FabPlacement(31, 0);
                            } else {
                                fabPlacement = new FabPlacement(9, 0);
                                i5 = 9;
                                i6 = 5;
                                i7 = 13;
                                i2 = 8;
                                i3 = 7;
                                i4 = 6;
                            }
                        }
                        i7 = 13;
                        i5 = 9;
                    }
                    i6 = i6;
                    i7 = 13;
                    i2 = 8;
                    i3 = 7;
                    i4 = 6;
                    i5 = 9;
                } else {
                    i2 = 8;
                    i3 = 7;
                    i4 = 6;
                    i5 = 9;
                    i6 = 5;
                    if (z && (i == 0 || i == 1)) {
                        fabPlacement = new FabPlacement(35, 0);
                    } else if (z && i == 3) {
                        fabPlacement = new FabPlacement(15, 0);
                    } else if (z && i == 2) {
                        fabPlacement = new FabPlacement(23, 0);
                    } else if (cause instanceof MediaCodecRenderer.DecoderInitializationException) {
                        i7 = 13;
                        fabPlacement = new FabPlacement(13, Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaCodecRenderer.DecoderInitializationException) cause).diagnosticInfo));
                    } else {
                        i7 = 13;
                        if (cause instanceof MediaCodecDecoderException) {
                            fabPlacement2 = new FabPlacement(14, ((MediaCodecDecoderException) cause).errorCode);
                        } else if (cause instanceof OutOfMemoryError) {
                            fabPlacement = new FabPlacement(14, 0);
                        } else if (cause instanceof AudioSink.InitializationException) {
                            fabPlacement = new FabPlacement(17, 0);
                        } else if (cause instanceof AudioSink.WriteException) {
                            fabPlacement = new FabPlacement(18, ((AudioSink.WriteException) cause).errorCode);
                        } else if (cause instanceof MediaCodec.CryptoException) {
                            int errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                            switch (Util.getErrorCodeForMediaDrmErrorCode(errorCode)) {
                                case 6002:
                                    i8 = 24;
                                    break;
                                case 6003:
                                    i8 = 28;
                                    break;
                                case 6004:
                                    i8 = 25;
                                    break;
                                case 6005:
                                    i8 = 26;
                                    break;
                                default:
                                    i8 = 27;
                                    break;
                            }
                            fabPlacement2 = new FabPlacement(i8, errorCode);
                        } else {
                            fabPlacement = new FabPlacement(22, 0);
                        }
                        fabPlacement = fabPlacement2;
                    }
                    i7 = 13;
                }
            }
            executor.execute(new ComponentActivity$$ExternalSyntheticLambda10(this, new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - j).setErrorCode(fabPlacement.left).setSubErrorCode(fabPlacement.height).setException(playbackException).build(), (byte) 16));
            i11 = 1;
            this.reportedEventsForCurrentSession = true;
            this.pendingPlayerError = null;
        }
        if (callbackWrapper.contains(2)) {
            Tracks currentTracks = player.getCurrentTracks();
            boolean zIsTypeSelected = currentTracks.isTypeSelected(2);
            boolean zIsTypeSelected2 = currentTracks.isTypeSelected(i11);
            boolean zIsTypeSelected3 = currentTracks.isTypeSelected(3);
            if (zIsTypeSelected || zIsTypeSelected2 || zIsTypeSelected3) {
                if (zIsTypeSelected) {
                    format = null;
                } else {
                    format = null;
                    if (!Objects.equals(this.currentVideoFormat, null)) {
                        this.currentVideoFormat = null;
                        reportTrackChangeEvent(1, jElapsedRealtime, null);
                    }
                }
                if (!zIsTypeSelected2 && !Objects.equals(this.currentAudioFormat, format)) {
                    this.currentAudioFormat = format;
                    reportTrackChangeEvent(0, jElapsedRealtime, format);
                }
                if (!zIsTypeSelected3 && !Objects.equals(this.currentTextFormat, format)) {
                    this.currentTextFormat = format;
                    reportTrackChangeEvent(2, jElapsedRealtime, format);
                }
            }
        }
        if (canReportPendingFormatUpdate(this.pendingVideoFormat)) {
            Format format2 = (Format) this.pendingVideoFormat.values;
            if (format2.height != -1) {
                if (!Objects.equals(this.currentVideoFormat, format2)) {
                    this.currentVideoFormat = format2;
                    reportTrackChangeEvent(1, jElapsedRealtime, format2);
                }
                this.pendingVideoFormat = null;
            }
        }
        if (canReportPendingFormatUpdate(this.pendingAudioFormat)) {
            Format format3 = (Format) this.pendingAudioFormat.values;
            if (!Objects.equals(this.currentAudioFormat, format3)) {
                this.currentAudioFormat = format3;
                reportTrackChangeEvent(0, jElapsedRealtime, format3);
            }
            this.pendingAudioFormat = null;
        }
        if (canReportPendingFormatUpdate(this.pendingTextFormat)) {
            Format format4 = (Format) this.pendingTextFormat.values;
            if (!Objects.equals(this.currentTextFormat, format4)) {
                this.currentTextFormat = format4;
                reportTrackChangeEvent(2, jElapsedRealtime, format4);
            }
            this.pendingTextFormat = null;
        }
        switch (NetworkTypeObserver.getInstance(context).getNetworkType()) {
            case 0:
                i12 = 0;
                break;
            case 1:
                i12 = i5;
                break;
            case 2:
                i12 = 2;
                break;
            case 3:
                i12 = 4;
                break;
            case 4:
                i12 = i6;
                break;
            case 5:
                i12 = i4;
                break;
            case 6:
            case 8:
            default:
                i12 = 1;
                break;
            case 7:
                i12 = 3;
                break;
            case 9:
                i12 = i2;
                break;
            case 10:
                i12 = i3;
                break;
        }
        if (i12 != this.currentNetworkType) {
            this.currentNetworkType = i12;
            executor.execute(new ComponentActivity$$ExternalSyntheticLambda10(this, new NetworkEvent.Builder().setNetworkType(i12).setTimeSinceCreatedMillis(jElapsedRealtime - j).build(), (byte) 15));
        }
        if (player.getPlaybackState() != 2) {
            this.isSeeking = false;
        }
        if (player.getPlayerError() == null) {
            this.hasFatalError = false;
            i13 = 10;
        } else {
            i13 = 10;
            if (callbackWrapper.contains(10)) {
                this.hasFatalError = true;
            }
        }
        int playbackState = player.getPlaybackState();
        if (this.isSeeking) {
            i14 = i6;
        } else if (this.hasFatalError) {
            i14 = i7;
        } else if (playbackState == 4) {
            i14 = 11;
        } else {
            if (playbackState != 2) {
                if (playbackState != 3) {
                    z2 = true;
                    i14 = (playbackState != 1 || this.currentPlaybackState == 0) ? this.currentPlaybackState : 12;
                } else if (player.getPlayWhenReady()) {
                    i14 = player.getPlaybackSuppressionReason() != 0 ? i5 : 3;
                } else {
                    i14 = 4;
                }
                if (this.currentPlaybackState != i14) {
                    this.currentPlaybackState = i14;
                    this.reportedEventsForCurrentSession = z2;
                    executor.execute(new ComponentActivity$$ExternalSyntheticLambda10(this, new PlaybackStateEvent.Builder().setState(this.currentPlaybackState).setTimeSinceCreatedMillis(jElapsedRealtime - j).build(), (byte) 18));
                }
                if (callbackWrapper.contains(1028)) {
                    defaultPlaybackSessionManager.finishAllSessions(callbackWrapper.getEventTime(1028));
                }
            }
            int i21 = this.currentPlaybackState;
            if (i21 == 0 || i21 == 2 || i21 == 12) {
                i14 = 2;
            } else if (player.getPlayWhenReady()) {
                i14 = player.getPlaybackSuppressionReason() != 0 ? i13 : i4;
            } else {
                i14 = i3;
            }
        }
        z2 = true;
        if (this.currentPlaybackState != i14) {
            this.currentPlaybackState = i14;
            this.reportedEventsForCurrentSession = z2;
            executor.execute(new ComponentActivity$$ExternalSyntheticLambda10(this, new PlaybackStateEvent.Builder().setState(this.currentPlaybackState).setTimeSinceCreatedMillis(jElapsedRealtime - j).build(), (byte) 18));
        }
        if (callbackWrapper.contains(1028)) {
            defaultPlaybackSessionManager.finishAllSessions(callbackWrapper.getEventTime(1028));
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onLoadError(FloatTweenSpec floatTweenSpec, IOException iOException) {
        this.ioErrorType = true;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onPlayerError(PlaybackException playbackException) {
        this.pendingPlayerError = playbackException;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, int i) {
        if (i == 1) {
            this.isSeeking = true;
        }
        this.discontinuityReason = i;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener
    public final void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = eventTime.mediaPeriodId;
        if (mediaSource$MediaPeriodId == null || !mediaSource$MediaPeriodId.isAd()) {
            finishCurrentSession();
            this.activeSessionId = str;
            this.metricsBuilder = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.10.1");
            maybeUpdateTimelineMetadata(eventTime.timeline, mediaSource$MediaPeriodId);
        }
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener
    public final void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = eventTime.mediaPeriodId;
        if ((mediaSource$MediaPeriodId == null || !mediaSource$MediaPeriodId.isAd()) && str.equals(this.activeSessionId)) {
            finishCurrentSession();
        }
        this.bandwidthTimeMs.remove(str);
        this.bandwidthBytes.remove(str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        this.droppedFrames += decoderCounters.droppedBufferCount;
        this.playedFrames += decoderCounters.renderedOutputBufferCount;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onVideoSizeChanged(VideoSize videoSize) {
        WeakCache weakCache = this.pendingVideoFormat;
        if (weakCache != null) {
            Format format = (Format) weakCache.values;
            if (format.height == -1) {
                Format.Builder builderBuildUpon = format.buildUpon();
                builderBuildUpon.width = videoSize.width;
                builderBuildUpon.height = videoSize.height;
                this.pendingVideoFormat = new WeakCache(new Format(builderBuildUpon), (String) weakCache.referenceQueue, (byte) 23);
            }
        }
    }

    public final void reportTrackChangeEvent(int i, long j, Format format) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.startTimeMs);
        if (format != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(2);
            String str = format.containerMimeType;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = format.sampleMimeType;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = format.codecs;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i2 = format.bitrate;
            if (i2 != -1) {
                timeSinceCreatedMillis.setBitrate(i2);
            }
            int i3 = format.width;
            if (i3 != -1) {
                timeSinceCreatedMillis.setWidth(i3);
            }
            int i4 = format.height;
            if (i4 != -1) {
                timeSinceCreatedMillis.setHeight(i4);
            }
            int i5 = format.channelCount;
            if (i5 != -1) {
                timeSinceCreatedMillis.setChannelCount(i5);
            }
            int i6 = format.sampleRate;
            if (i6 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i6);
            }
            String str4 = format.language;
            if (str4 != null) {
                String str5 = Util.DEVICE_DEBUG_INFO;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = format.frameRate;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.reportedEventsForCurrentSession = true;
        this.backgroundExecutor.execute(new ComponentActivity$$ExternalSyntheticLambda10(this, timeSinceCreatedMillis.build(), (byte) 14));
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener
    public final void onAdPlaybackStarted(String str) {
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener
    public final void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
    }
}
