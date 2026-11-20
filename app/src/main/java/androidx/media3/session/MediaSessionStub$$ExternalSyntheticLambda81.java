package androidx.media3.session;

import android.os.Bundle;
import android.os.Handler;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.ResolvingDataSource;
import androidx.media3.datasource.cache.ContentMetadata;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.SettableFuture;
import com.materialkolor.quantize.QuantizerWu;
import com.metrolist.innertube.models.response.PlayerResponse$PlaybackTracking;
import com.metrolist.innertube.models.response.PlayerResponse$PlayerConfig$AudioConfig;
import com.metrolist.innertube.models.response.PlayerResponse$StreamingData$Format;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.playback.CachedStreamUrl;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.MusicService$handleAlarmTrigger$2;
import com.metrolist.music.playback.MusicService$handleAudioRendererError$1;
import com.metrolist.music.playback.StreamUrlCache;
import com.metrolist.music.playback.audio.VolumeNormalizationAudioProcessor;
import com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$7$1$1$1;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.InnerTubeXPlayer;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.ws.RealWebSocket$$ExternalSyntheticLambda2;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda81 implements DefaultTrackSelector.TrackInfo.Factory, ListenerSet.Event, MediaSessionLegacyStub.SessionTask, AsyncFunction, ResolvingDataSource.Resolver {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda81(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public SettableFuture apply(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) obj4;
                Handler handler = mediaLibrarySessionImpl.applicationHandler;
                TransactionExecutor$$ExternalSyntheticLambda0 transactionExecutor$$ExternalSyntheticLambda0 = new TransactionExecutor$$ExternalSyntheticLambda0(mediaLibrarySessionImpl, (MediaSession$ControllerInfo) obj3, new Util$$ExternalSyntheticLambda1((Object) mediaLibrarySessionImpl, obj2, obj, (byte) 19));
                SessionResult sessionResult = new SessionResult(0);
                String str = Util.DEVICE_DEBUG_INFO;
                SettableFuture settableFuture = new SettableFuture();
                Util.postOrRun(handler, new Util$$ExternalSyntheticLambda1((byte) 3, settableFuture, transactionExecutor$$ExternalSyntheticLambda0, sessionResult, false));
                return settableFuture;
            default:
                MediaLibrarySessionImpl mediaLibrarySessionImpl2 = (MediaLibrarySessionImpl) obj4;
                MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) obj3;
                Handler handler2 = mediaLibrarySessionImpl2.applicationHandler;
                TransactionExecutor$$ExternalSyntheticLambda0 transactionExecutor$$ExternalSyntheticLambda1 = new TransactionExecutor$$ExternalSyntheticLambda0(mediaLibrarySessionImpl2, mediaSession$ControllerInfo, new MediaSessionStub$$ExternalSyntheticLambda3(mediaLibrarySessionImpl2, obj2, (Object) mediaSession$ControllerInfo, obj, (byte) 10));
                SessionResult sessionResult2 = new SessionResult(0);
                String str2 = Util.DEVICE_DEBUG_INFO;
                SettableFuture settableFuture2 = new SettableFuture();
                Util.postOrRun(handler2, new Util$$ExternalSyntheticLambda1((byte) 3, settableFuture2, transactionExecutor$$ExternalSyntheticLambda1, sessionResult2, false));
                return settableFuture2;
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo.Factory
    public RegularImmutableList create(int i, TrackGroup trackGroup, int[] iArr) {
        DefaultTrackSelector.Parameters parameters = (DefaultTrackSelector.Parameters) this.f$0;
        String str = (String) this.f$1;
        String str2 = (String) this.f$2;
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i2 = 0; i2 < trackGroup.length; i2++) {
            builder.add((Object) new DefaultTrackSelector.TextTrackInfo(i, trackGroup, i2, parameters, iArr[i2], str, str2));
        }
        return builder.build();
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        QuantizerWu quantizerWu = (QuantizerWu) this.f$0;
        QuantizerWu quantizerWu2 = (QuantizerWu) this.f$1;
        Integer num = (Integer) this.f$2;
        ((Player.Listener) obj).onPositionDiscontinuity(num.intValue(), ((PlayerInfo) quantizerWu.weights).sessionPositionInfo.positionInfo, ((PlayerInfo) quantizerWu2.weights).sessionPositionInfo.positionInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r7v11, types: [kotlin.coroutines.Continuation, kotlinx.coroutines.CoroutineStart] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Double] */
    @Override // androidx.media3.datasource.ResolvingDataSource.Resolver
    public DataSpec resolveDataSpec(DataSpec dataSpec) throws Throwable {
        String str;
        Set set;
        DefaultIoScheduler defaultIoScheduler;
        byte b;
        int i;
        Continuation continuation;
        ConnectionPool connectionPool;
        Object obj;
        final String str2;
        InnerTubeXPlayer.PlaybackData playbackData;
        PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl videostatsPlaybackUrl;
        String str3;
        long j;
        Long lValueOf;
        MusicService musicService = (MusicService) this.f$0;
        ContextScope contextScope = musicService.scope;
        Set set2 = musicService.recoveringSongs;
        VolumeNormalizationAudioProcessor volumeNormalizationAudioProcessor = (VolumeNormalizationAudioProcessor) this.f$1;
        RealWebSocket$$ExternalSyntheticLambda2 realWebSocket$$ExternalSyntheticLambda2 = (RealWebSocket$$ExternalSyntheticLambda2) this.f$2;
        boolean z = MusicService.isRunning;
        dataSpec.getClass();
        String str4 = dataSpec.key;
        if (str4 == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No media id");
            return null;
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
        FormatEntity formatEntity = (FormatEntity) AwaitKt.runBlockingK(defaultIoScheduler2, new MusicService$handleAlarmTrigger$2(musicService, str4, null, (byte) 1));
        Double d = formatEntity != null ? formatEntity.loudnessDb : null;
        Double d2 = formatEntity != null ? formatEntity.perceptualLoudnessDb : null;
        HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
        AwaitKt.runBlockingK(handlerContext.immediate, new QueueMenuKt$QueueMenu$7$1$1$1(realWebSocket$$ExternalSyntheticLambda2, musicService, volumeNormalizationAudioProcessor, str4, true, d, d2, null));
        StateFlowImpl stateFlowImpl = musicService.currentStreamClient;
        StreamUrlCache streamUrlCache = musicService.songUrlCache;
        LinkedHashSet linkedHashSet = musicService.bypassCacheForQualityChange;
        if (!linkedHashSet.contains(str4)) {
            boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.EnableSongCacheKey, Boolean.TRUE)).booleanValue();
            if (formatEntity != null) {
                j = 0;
                lValueOf = Long.valueOf(formatEntity.contentLength);
            } else {
                j = 0;
                long contentLength = ContentMetadata.getContentLength(musicService.getDownloadCache().getContentMetadata(str4));
                lValueOf = Long.valueOf(contentLength);
                if (contentLength <= 0) {
                    lValueOf = null;
                }
            }
            long j2 = dataSpec.length;
            if (j2 >= j) {
                set = set2;
            } else if (lValueOf != null) {
                long jLongValue = lValueOf.longValue();
                set = set2;
                j2 = jLongValue - dataSpec.position;
                if (j2 < 1) {
                    j2 = 1;
                }
            } else {
                set = set2;
                j2 = 524288;
            }
            long j3 = j2;
            b = 1;
            defaultIoScheduler = defaultIoScheduler2;
            i = 0;
            Continuation continuation2 = null;
            str = str4;
            if (musicService.getDownloadCache().isCached(dataSpec.position, j3, str4)) {
                if (set.add(str)) {
                    AwaitKt.launch$default(contextScope, defaultIoScheduler, null, new DataStoreKt$get$2((Object) musicService, (Object) str, (Object) continuation2, continuation2, (byte) 5), 2);
                    return dataSpec;
                }
            } else if (!zBooleanValue || !musicService.getPlayerCache().isCached(dataSpec.position, j3, str)) {
                str = str;
                CachedStreamUrl cachedStreamUrl = streamUrlCache.get(str);
                if (cachedStreamUrl != null) {
                    if (set.add(str)) {
                        AwaitKt.launch$default(contextScope, defaultIoScheduler, null, new DataStoreKt$get$2((Object) musicService, (Object) str, (Object) continuation2, continuation2, (byte) 5), 2);
                    }
                    stateFlowImpl.setValue(cachedStreamUrl.clientName);
                    return RegexKt.withResolvedStream(dataSpec, cachedStreamUrl);
                }
                continuation = null;
            } else if (set.add(str)) {
                str = str;
                AwaitKt.launch$default(contextScope, defaultIoScheduler, null, new DataStoreKt$get$2((Object) musicService, (Object) str, (Object) continuation2, continuation2, (byte) 5), 2);
                return dataSpec;
            }
            str = str;
            return dataSpec;
        }
        str = str4;
        set = set2;
        defaultIoScheduler = defaultIoScheduler2;
        b = 1;
        i = 0;
        continuation = null;
        Timber.Forest.tag("MusicService");
        ConnectionPool.i(new Object[0]);
        long jGeneration = streamUrlCache.generation(str);
        ConnectionPool connectionPool2 = Timber.Forest;
        connectionPool2.tag("MusicService");
        AudioQuality audioQuality = r4.audioQuality;
        if (audioQuality == null) {
            ?? r7 = continuation;
            Intrinsics.throwUninitializedPropertyAccessException("audioQuality");
            throw r7;
        }
        audioQuality.toString();
        ConnectionPool.i(new Object[i]);
        Object obj2 = ((Result) AwaitKt.runBlockingK(defaultIoScheduler, new MusicService$handleAudioRendererError$1(r4, str, continuation, b))).value;
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
        if (thM1866exceptionOrNullimpl != null) {
            if (thM1866exceptionOrNullimpl instanceof PlaybackException) {
                throw thM1866exceptionOrNullimpl;
            }
            if ((thM1866exceptionOrNullimpl instanceof ConnectException) || (thM1866exceptionOrNullimpl instanceof UnknownHostException)) {
                throw new PlaybackException(2001, r4.getString(R.string.error_no_internet), thM1866exceptionOrNullimpl);
            }
            if (thM1866exceptionOrNullimpl instanceof SocketTimeoutException) {
                throw new PlaybackException(2002, r4.getString(R.string.error_timeout), thM1866exceptionOrNullimpl);
            }
            throw new PlaybackException(1001, r4.getString(R.string.error_unknown), thM1866exceptionOrNullimpl);
        }
        final InnerTubeXPlayer.PlaybackData playbackData2 = (InnerTubeXPlayer.PlaybackData) obj2;
        if (playbackData2 == null) {
            String string = r4.getString(R.string.error_unknown);
            string.getClass();
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) string);
            return null;
        }
        final PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format = playbackData2.format;
        PlayerResponse$PlayerConfig$AudioConfig playerResponse$PlayerConfig$AudioConfig = playbackData2.audioConfig;
        final ?? r18 = playerResponse$PlayerConfig$AudioConfig != null ? playerResponse$PlayerConfig$AudioConfig.loudnessDb : continuation;
        final ?? r19 = playerResponse$PlayerConfig$AudioConfig != null ? playerResponse$PlayerConfig$AudioConfig.perceptualLoudnessDb : continuation;
        connectionPool2.tag("MusicService");
        ConnectionPool.d(new Object[i]);
        if (r18 == 0 && r19 == 0) {
            connectionPool2.tag("MusicService");
            "No loudness data available from YouTube for video: ".concat(str);
            ConnectionPool.w(new Object[i]);
        }
        HandlerContext handlerContext2 = handlerContext.immediate;
        String str5 = str;
        AwaitKt.runBlockingK(handlerContext2, new QueueMenuKt$QueueMenu$7$1$1$1(realWebSocket$$ExternalSyntheticLambda2, musicService, volumeNormalizationAudioProcessor, str5, false, r18, r19, null));
        Long l = playerResponse$StreamingData$Format.contentLength;
        if (l != null) {
            final long jLongValue2 = l.longValue();
            connectionPool = connectionPool2;
            str2 = str5;
            obj = null;
            musicService.getDatabase().query(new Function1() { // from class: com.metrolist.music.playback.MusicService$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl videostatsPlaybackUrl2;
                    String str6 = str2;
                    PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format2 = playerResponse$StreamingData$Format;
                    long j4 = jLongValue2;
                    Double d3 = r18;
                    Double d4 = r19;
                    InnerTubeXPlayer.PlaybackData playbackData3 = playbackData2;
                    MusicDatabase musicDatabase = (MusicDatabase) obj3;
                    boolean z2 = MusicService.isRunning;
                    musicDatabase.getClass();
                    int i2 = playerResponse$StreamingData$Format2.itag;
                    String str7 = playerResponse$StreamingData$Format2.mimeType;
                    String strSubstringBefore$default = StringsKt.substringBefore$default(str7, ";");
                    String string2 = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter(str7, "codecs=", ""), ";")).toString();
                    string2.getClass();
                    String strRemoveSurrounding = StringsKt.removeSurrounding(string2, "\"", "\"");
                    int i3 = playerResponse$StreamingData$Format2.bitrate;
                    Integer num = playerResponse$StreamingData$Format2.audioSampleRate;
                    PlayerResponse$PlaybackTracking playerResponse$PlaybackTracking = playbackData3.playbackTracking;
                    musicDatabase.$$delegate_0.upsert(new FormatEntity(str6, i2, strSubstringBefore$default, strRemoveSurrounding, i3, num, j4, d3, d4, (playerResponse$PlaybackTracking == null || (videostatsPlaybackUrl2 = playerResponse$PlaybackTracking.videostatsPlaybackUrl) == null) ? null : videostatsPlaybackUrl2.baseUrl));
                    return Unit.INSTANCE;
                }
            });
        } else {
            connectionPool = connectionPool2;
            obj = null;
            str2 = str5;
            connectionPool.tag("MusicService");
            "Skipping format persistence without content length for ".concat(str2);
            ConnectionPool.w(new Object[0]);
        }
        if (set.add(str2)) {
            ?? r8 = obj;
            playbackData = playbackData2;
            AwaitKt.launch$default(contextScope, defaultIoScheduler, r8, new DataStoreKt$get$2((Object) musicService, (Object) str2, (Object) playbackData, (Continuation) r8, (byte) 5), 2);
        } else {
            playbackData = playbackData2;
        }
        if (linkedHashSet.remove(str2)) {
            connectionPool.tag("MusicService");
            ConnectionPool.d(new Object[0]);
        }
        String str6 = playbackData.streamUrl;
        stateFlowImpl.setValue(playbackData.streamClient);
        musicService.songUrlCache.put(str2, str6, playbackData.streamHeaders, playbackData.streamClient, playbackData.streamExpiresInSeconds, playbackData.requireBoundedRange, playbackData.rangeChunkSizeBytes, playbackData.useRangeChunks, jGeneration);
        PlayerResponse$PlaybackTracking playerResponse$PlaybackTracking = playbackData.playbackTracking;
        if (playerResponse$PlaybackTracking != null && (videostatsPlaybackUrl = playerResponse$PlaybackTracking.videostatsPlaybackUrl) != null && (str3 = videostatsPlaybackUrl.baseUrl) != null) {
            Map map = musicService.playbackUrlCache;
            map.getClass();
            map.put(MusicService.cacheKey(str2), str3);
        }
        return RegexKt.withResolvedStream(dataSpec, new CachedStreamUrl(str6, playbackData.streamHeaders, playbackData.streamClient, playbackData.requireBoundedRange, playbackData.rangeChunkSizeBytes, playbackData.useRangeChunks));
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f$0;
        mediaSessionLegacyStub.sessionImpl.onCustomCommandOnHandler(mediaSession$ControllerInfo, (SessionCommand) this.f$1, (Bundle) this.f$2);
    }
}
