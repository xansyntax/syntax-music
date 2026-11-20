package com.metrolist.music.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import androidx.room.concurrent.FileLock;
import coil3.memory.RealStrongMemoryCache;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.Thumbnails;
import com.metrolist.innertube.models.response.PlayerResponse$PlaybackTracking;
import com.metrolist.innertube.models.response.PlayerResponse$PlayerConfig$AudioConfig;
import com.metrolist.innertube.models.response.PlayerResponse$StreamingData$Format;
import com.metrolist.innertube.models.response.PlayerResponse$VideoDetails;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.InnerTubeLogEvent;
import com.metrolist.innertubex.InnerTubeLogLevel;
import com.metrolist.innertubex.cipher.RemotePlayerConfigStore;
import com.metrolist.innertubex.cipher.YouTubeCipherService;
import com.metrolist.innertubex.extraction.AudioQuality;
import com.metrolist.innertubex.extraction.ContentHints;
import com.metrolist.innertubex.extraction.ExtractedMediaMetadata;
import com.metrolist.innertubex.extraction.ExtractedStream;
import com.metrolist.innertubex.extraction.InnerTubeExtractor;
import com.metrolist.innertubex.extraction.PlaybackNonceKt;
import com.metrolist.innertubex.extraction.PlaybackTrackingData;
import com.metrolist.innertubex.extraction.StreamResolveException;
import com.metrolist.innertubex.extraction.YtConfigParserImpl;
import com.metrolist.innertubex.models.Thumbnail;
import com.metrolist.music.ui.theme.UiStyleKt$$ExternalSyntheticLambda0;
import io.ktor.client.HttpClient;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.time.Instant;
import kotlin.time.InstantJvmKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeXPlayer {
    public static volatile Context applicationContext;
    public static volatile ExtractionBundle currentBundle;
    public static final InnerTubeXPlayer INSTANCE = new InnerTubeXPlayer();
    public static final MutexImpl bundleMutex = new MutexImpl();
    public static final ConcurrentHashMap streamClientFailures = new ConcurrentHashMap();
    public static final SynchronizedLazyImpl configRepository$delegate = new SynchronizedLazyImpl(new UiStyleKt$$ExternalSyntheticLambda0((byte) 27));
    public static final SynchronizedLazyImpl poTokenGenerator$delegate = new SynchronizedLazyImpl(new UiStyleKt$$ExternalSyntheticLambda0((byte) 28));
    public static final ConnectionPool tokenProvider = new ConnectionPool((byte) 17);
    public static final PathKt$$ExternalSyntheticBUOutline0 logger = new PathKt$$ExternalSyntheticBUOutline0((byte) 19);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AndroidPlayerConfigRepository {
        public final SharedPreferences preferences;

        public AndroidPlayerConfigRepository(Context context) {
            this.preferences = context.getSharedPreferences("innertubex_player_config", 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExtractionBundle {
        public final YouTubeCipherService cipherService;
        public final InnerTubeExtractor extractor;
        public final long transportGeneration;

        public ExtractionBundle(long j, YouTubeCipherService youTubeCipherService, InnerTubeExtractor innerTubeExtractor) {
            this.transportGeneration = j;
            this.cipherService = youTubeCipherService;
            this.extractor = innerTubeExtractor;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ExtractionBundle) {
                ExtractionBundle extractionBundle = (ExtractionBundle) obj;
                return this.transportGeneration == extractionBundle.transportGeneration && this.cipherService == extractionBundle.cipherService && this.extractor == extractionBundle.extractor;
            }
            return false;
        }

        public final int hashCode() {
            return this.extractor.hashCode() + ((this.cipherService.hashCode() + (Long.hashCode(this.transportGeneration) * 31)) * 31);
        }

        public final String toString() {
            return "ExtractionBundle(transportGeneration=" + this.transportGeneration + ", cipherService=" + this.cipherService + ", extractor=" + this.extractor + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FailedStreamClients {
        public final LinkedHashSet clientNames;
        public final long failedAtMs;

        public FailedStreamClients(LinkedHashSet linkedHashSet, long j) {
            this.clientNames = linkedHashSet;
            this.failedAtMs = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FailedStreamClients)) {
                return false;
            }
            FailedStreamClients failedStreamClients = (FailedStreamClients) obj;
            return this.clientNames.equals(failedStreamClients.clientNames) && this.failedAtMs == failedStreamClients.failedAtMs;
        }

        public final int hashCode() {
            return Long.hashCode(this.failedAtMs) + (this.clientNames.hashCode() * 31);
        }

        public final String toString() {
            return "FailedStreamClients(clientNames=" + this.clientNames + ", failedAtMs=" + this.failedAtMs + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlaybackData {
        public final PlayerResponse$PlayerConfig$AudioConfig audioConfig;
        public final PlayerResponse$StreamingData$Format format;
        public final PlayerResponse$PlaybackTracking playbackTracking;
        public final long rangeChunkSizeBytes;
        public final boolean requireBoundedRange;
        public final String streamClient;
        public final int streamExpiresInSeconds;
        public final Map streamHeaders;
        public final String streamUrl;
        public final boolean useRangeChunks;
        public final PlayerResponse$VideoDetails videoDetails;

        public PlaybackData(PlayerResponse$PlayerConfig$AudioConfig playerResponse$PlayerConfig$AudioConfig, PlayerResponse$VideoDetails playerResponse$VideoDetails, PlayerResponse$PlaybackTracking playerResponse$PlaybackTracking, PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format, String str, int i, String str2, Map map, boolean z, long j, boolean z2) {
            str.getClass();
            str2.getClass();
            map.getClass();
            this.audioConfig = playerResponse$PlayerConfig$AudioConfig;
            this.videoDetails = playerResponse$VideoDetails;
            this.playbackTracking = playerResponse$PlaybackTracking;
            this.format = playerResponse$StreamingData$Format;
            this.streamUrl = str;
            this.streamExpiresInSeconds = i;
            this.streamClient = str2;
            this.streamHeaders = map;
            this.requireBoundedRange = z;
            this.rangeChunkSizeBytes = j;
            this.useRangeChunks = z2;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.InnerTubeXPlayer$bundle$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Mutex L$1;
        public RealStrongMemoryCache L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeXPlayer.this.bundle(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.InnerTubeXPlayer$prewarm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01831 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01831(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeXPlayer.this.prewarm(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.InnerTubeXPlayer$refreshAfterStreamRejection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01841 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01841(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeXPlayer.this.refreshAfterStreamRejection(this);
        }
    }

    public static Set failedStreamClients$app$default(InnerTubeXPlayer innerTubeXPlayer, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        innerTubeXPlayer.getClass();
        str.getClass();
        ConcurrentHashMap concurrentHashMap = streamClientFailures;
        FailedStreamClients failedStreamClients = (FailedStreamClients) concurrentHashMap.get(str);
        EmptySet emptySet = EmptySet.INSTANCE;
        if (failedStreamClients == null) {
            return emptySet;
        }
        long j = jCurrentTimeMillis - failedStreamClients.failedAtMs;
        if (0 <= j && j < 300000) {
            return failedStreamClients.clientNames;
        }
        concurrentHashMap.remove(str, failedStreamClients);
        return emptySet;
    }

    public static AudioQuality toInnerTubeX(com.metrolist.music.constants.AudioQuality audioQuality, ConnectivityManager connectivityManager) {
        int iOrdinal = audioQuality.ordinal();
        AudioQuality audioQuality2 = AudioQuality.LOW;
        if (iOrdinal == 0) {
            return connectivityManager.isActiveNetworkMetered() ? audioQuality2 : AudioQuality.AUTO;
        }
        if (iOrdinal == 1) {
            return audioQuality2;
        }
        if (iOrdinal == 2) {
            return AudioQuality.HIGH;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    /* JADX WARN: Code duplicated, block: B:21:0x0048  */
    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x0059  */
    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    /* JADX WARN: Code duplicated, block: B:30:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x0083 A[LOOP:0: B:33:0x007d->B:35:0x0083, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:62:0x010d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0121  */
    /* JADX WARN: Code duplicated, block: B:66:0x0125  */
    public static PlaybackData toPlaybackData(ExtractedStream extractedStream) {
        String str;
        Double d;
        PlayerResponse$PlayerConfig$AudioConfig playerResponse$PlayerConfig$AudioConfig;
        PlayerResponse$PlayerConfig$AudioConfig playerResponse$PlayerConfig$AudioConfig2;
        PlayerResponse$VideoDetails playerResponse$VideoDetails;
        PlayerResponse$PlaybackTracking playerResponse$PlaybackTracking;
        Integer num;
        int iIntValue;
        String strValueOf;
        Instant instant;
        int epochMilliseconds;
        Long l;
        String str2;
        PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl videostatsPlaybackUrl;
        String str3;
        PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl videostatsWatchtimeUrl;
        String str4;
        String str5;
        Long l2;
        String strValueOf2;
        String str6;
        String str7;
        ArrayList arrayList;
        ExtractedMediaMetadata extractedMediaMetadata = extractedStream.mediaMetadata;
        String str8 = extractedStream.mimeType;
        PlaybackTrackingData playbackTrackingData = extractedStream.playbackTracking;
        String str9 = extractedStream.codecs;
        if (str9 == null || StringsKt.isBlank(str9)) {
            if (str8 == null) {
                str = "";
            }
            d = extractedStream.loudnessDb;
            if (d == null || extractedStream.perceptualLoudnessDb != null) {
                playerResponse$PlayerConfig$AudioConfig = new PlayerResponse$PlayerConfig$AudioConfig(d, extractedStream.perceptualLoudnessDb);
            } else {
                playerResponse$PlayerConfig$AudioConfig = null;
            }
            if (extractedMediaMetadata != null) {
                String str10 = extractedStream.videoId;
                String str11 = extractedMediaMetadata.title;
                String str12 = extractedMediaMetadata.author;
                str4 = extractedMediaMetadata.channelId;
                if (str4 == null) {
                    str5 = "";
                } else {
                    str5 = str4;
                }
                l2 = extractedMediaMetadata.durationSeconds;
                if (l2 != null) {
                    strValueOf2 = String.valueOf(l2.longValue());
                } else {
                    strValueOf2 = null;
                }
                if (strValueOf2 == null) {
                    str6 = "";
                } else {
                    str6 = strValueOf2;
                }
                str7 = extractedMediaMetadata.musicVideoType;
                String str13 = extractedMediaMetadata.viewCount;
                List<Thumbnail> list = extractedMediaMetadata.thumbnails;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (Thumbnail thumbnail : list) {
                    arrayList.add(new com.metrolist.innertube.models.Thumbnail(thumbnail.url, thumbnail.width, thumbnail.height));
                    str7 = str7;
                    playerResponse$PlayerConfig$AudioConfig = playerResponse$PlayerConfig$AudioConfig;
                }
                playerResponse$PlayerConfig$AudioConfig2 = playerResponse$PlayerConfig$AudioConfig;
                playerResponse$VideoDetails = new PlayerResponse$VideoDetails(str10, str11, str12, str5, str6, str7, str13, new Thumbnails(arrayList));
            } else {
                playerResponse$PlayerConfig$AudioConfig2 = playerResponse$PlayerConfig$AudioConfig;
                playerResponse$VideoDetails = null;
            }
            if (playbackTrackingData != null) {
                str2 = playbackTrackingData.playbackUrl;
                if (str2 != null) {
                    videostatsPlaybackUrl = new PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl(str2);
                } else {
                    videostatsPlaybackUrl = null;
                }
                str3 = playbackTrackingData.watchtimeUrl;
                if (str3 != null) {
                    videostatsWatchtimeUrl = new PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl(str3);
                } else {
                    videostatsWatchtimeUrl = null;
                }
                playerResponse$PlaybackTracking = new PlayerResponse$PlaybackTracking(videostatsPlaybackUrl, videostatsWatchtimeUrl);
            } else {
                playerResponse$PlaybackTracking = null;
            }
            int i = extractedStream.itag;
            String str14 = extractedStream.audioUrl;
            num = extractedStream.bitrate;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = 0;
            }
            int i2 = iIntValue;
            Long l3 = extractedStream.contentLengthBytes;
            Integer num2 = extractedStream.bitrate;
            if (extractedMediaMetadata != null || (l = extractedMediaMetadata.durationSeconds) == null) {
                strValueOf = null;
            } else {
                strValueOf = String.valueOf(l.longValue() * 1000);
            }
            PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format = new PlayerResponse$StreamingData$Format(i, str14, str, i2, l3, num2, strValueOf, extractedStream.sampleRate, extractedStream.loudnessDb);
            String str15 = extractedStream.audioUrl;
            instant = extractedStream.expiresAt;
            if (instant != null) {
                epochMilliseconds = (int) ((instant.toEpochMilliseconds() - InstantJvmKt.systemClock.now().toEpochMilliseconds()) / 1000);
                if (epochMilliseconds < 1) {
                    epochMilliseconds = 1;
                }
            } else {
                epochMilliseconds = 300;
            }
            return new PlaybackData(playerResponse$PlayerConfig$AudioConfig2, playerResponse$VideoDetails, playerResponse$PlaybackTracking, playerResponse$StreamingData$Format, str15, epochMilliseconds, extractedStream.clientName, extractedStream.headers, extractedStream.requireBoundedRange, extractedStream.rangeChunkSizeBytes, extractedStream.useRangeChunks);
        }
        if (str8 == null) {
            str8 = "";
        }
        str8 = str8 + "; codecs=\"" + str9 + "\"";
        str = str8;
        d = extractedStream.loudnessDb;
        if (d == null) {
            playerResponse$PlayerConfig$AudioConfig = new PlayerResponse$PlayerConfig$AudioConfig(d, extractedStream.perceptualLoudnessDb);
        } else {
            playerResponse$PlayerConfig$AudioConfig = new PlayerResponse$PlayerConfig$AudioConfig(d, extractedStream.perceptualLoudnessDb);
        }
        if (extractedMediaMetadata != null) {
            String str16 = extractedStream.videoId;
            String str17 = extractedMediaMetadata.title;
            String str18 = extractedMediaMetadata.author;
            str4 = extractedMediaMetadata.channelId;
            if (str4 == null) {
                str5 = "";
            } else {
                str5 = str4;
            }
            l2 = extractedMediaMetadata.durationSeconds;
            if (l2 != null) {
                strValueOf2 = String.valueOf(l2.longValue());
            } else {
                strValueOf2 = null;
            }
            if (strValueOf2 == null) {
                str6 = "";
            } else {
                str6 = strValueOf2;
            }
            str7 = extractedMediaMetadata.musicVideoType;
            String str19 = extractedMediaMetadata.viewCount;
            List<Thumbnail> list2 = extractedMediaMetadata.thumbnails;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            while (r7.hasNext()) {
                arrayList.add(new com.metrolist.innertube.models.Thumbnail(thumbnail.url, thumbnail.width, thumbnail.height));
                str7 = str7;
                playerResponse$PlayerConfig$AudioConfig = playerResponse$PlayerConfig$AudioConfig;
            }
            playerResponse$PlayerConfig$AudioConfig2 = playerResponse$PlayerConfig$AudioConfig;
            playerResponse$VideoDetails = new PlayerResponse$VideoDetails(str16, str17, str18, str5, str6, str7, str19, new Thumbnails(arrayList));
        } else {
            playerResponse$PlayerConfig$AudioConfig2 = playerResponse$PlayerConfig$AudioConfig;
            playerResponse$VideoDetails = null;
        }
        if (playbackTrackingData != null) {
            str2 = playbackTrackingData.playbackUrl;
            if (str2 != null) {
                videostatsPlaybackUrl = new PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl(str2);
            } else {
                videostatsPlaybackUrl = null;
            }
            str3 = playbackTrackingData.watchtimeUrl;
            if (str3 != null) {
                videostatsWatchtimeUrl = new PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl(str3);
            } else {
                videostatsWatchtimeUrl = null;
            }
            playerResponse$PlaybackTracking = new PlayerResponse$PlaybackTracking(videostatsPlaybackUrl, videostatsWatchtimeUrl);
        } else {
            playerResponse$PlaybackTracking = null;
        }
        int i3 = extractedStream.itag;
        String str110 = extractedStream.audioUrl;
        num = extractedStream.bitrate;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            iIntValue = 0;
        }
        int i4 = iIntValue;
        Long l4 = extractedStream.contentLengthBytes;
        Integer num3 = extractedStream.bitrate;
        if (extractedMediaMetadata != null) {
            strValueOf = null;
        } else {
            strValueOf = null;
        }
        PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format2 = new PlayerResponse$StreamingData$Format(i3, str110, str, i4, l4, num3, strValueOf, extractedStream.sampleRate, extractedStream.loudnessDb);
        String str111 = extractedStream.audioUrl;
        instant = extractedStream.expiresAt;
        if (instant != null) {
            epochMilliseconds = (int) ((instant.toEpochMilliseconds() - InstantJvmKt.systemClock.now().toEpochMilliseconds()) / 1000);
            if (epochMilliseconds < 1) {
                epochMilliseconds = 1;
            }
        } else {
            epochMilliseconds = 300;
        }
        return new PlaybackData(playerResponse$PlayerConfig$AudioConfig2, playerResponse$VideoDetails, playerResponse$PlaybackTracking, playerResponse$StreamingData$Format2, str111, epochMilliseconds, extractedStream.clientName, extractedStream.headers, extractedStream.requireBoundedRange, extractedStream.rangeChunkSizeBytes, extractedStream.useRangeChunks);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
    
        if (r3 != null) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object bundle(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        ?? r1;
        RealStrongMemoryCache realStrongMemoryCacheExtractionTransport;
        RealStrongMemoryCache realStrongMemoryCache;
        Exception exc;
        String simpleName;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r2 = anonymousClass1.label;
        try {
            try {
                try {
                    if (r2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        YouTube youTube = YouTube.INSTANCE;
                        RealStrongMemoryCache realStrongMemoryCacheExtractionTransport2 = YouTube.extractionTransport();
                        ExtractionBundle extractionBundle = currentBundle;
                        if (extractionBundle != null) {
                            if (extractionBundle.transportGeneration != realStrongMemoryCacheExtractionTransport2.initialMaxSize) {
                                extractionBundle = null;
                            }
                            if (extractionBundle != null) {
                                return extractionBundle;
                            }
                        }
                        MutexImpl mutexImpl = bundleMutex;
                        anonymousClass1.L$1 = mutexImpl;
                        anonymousClass1.label = 1;
                        if (mutexImpl.lock(anonymousClass1) != coroutineSingletons) {
                            r1 = mutexImpl;
                        }
                        return coroutineSingletons;
                    }
                    if (r2 != 1) {
                        if (r2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        realStrongMemoryCache = anonymousClass1.L$2;
                        Mutex mutex = anonymousClass1.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            r2 = mutex;
                        } catch (Exception e) {
                            exc = e;
                            r2 = mutex;
                            PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = logger;
                            InnerTubeLogLevel innerTubeLogLevel = InnerTubeLogLevel.WARN;
                            simpleName = Reflection.getOrCreateKotlinClass(exc.getClass()).getSimpleName();
                            if (simpleName == null) {
                                simpleName = "unknown";
                            }
                            Map mapSingletonMap = Collections.singletonMap("exceptionType", simpleName);
                            mapSingletonMap.getClass();
                            pathKt$$ExternalSyntheticBUOutline0.log(new InnerTubeLogEvent(innerTubeLogLevel, "InnerTubeXPlayer", "old cipher disposal failed", mapSingletonMap));
                        }
                        realStrongMemoryCacheExtractionTransport = realStrongMemoryCache;
                        r1 = r2;
                        HttpClient httpClient = (HttpClient) realStrongMemoryCacheExtractionTransport.cache;
                        AndroidPlayerConfigRepository androidPlayerConfigRepository = (AndroidPlayerConfigRepository) configRepository$delegate.getValue();
                        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1 = logger;
                        RemotePlayerConfigStore remotePlayerConfigStore = new RemotePlayerConfigStore(httpClient, androidPlayerConfigRepository, pathKt$$ExternalSyntheticBUOutline1);
                        YouTubeCipherService youTubeCipherService = new YouTubeCipherService((HttpClient) realStrongMemoryCacheExtractionTransport.cache, remotePlayerConfigStore, pathKt$$ExternalSyntheticBUOutline1);
                        YtConfigParserImpl ytConfigParserImpl = new YtConfigParserImpl((HttpClient) realStrongMemoryCacheExtractionTransport.cache, (InnerTube) realStrongMemoryCacheExtractionTransport.weakMemoryCache, remotePlayerConfigStore, pathKt$$ExternalSyntheticBUOutline1);
                        FileLock fileLock = new FileLock();
                        fileLock.lockChannel = ytConfigParserImpl;
                        fileLock.lockFilename = ytConfigParserImpl;
                        extractionBundle = new ExtractionBundle(realStrongMemoryCacheExtractionTransport.initialMaxSize, youTubeCipherService, new InnerTubeExtractor(fileLock, youTubeCipherService, (InnerTube) realStrongMemoryCacheExtractionTransport.weakMemoryCache, tokenProvider, pathKt$$ExternalSyntheticBUOutline1));
                        currentBundle = extractionBundle;
                        r1.unlock(null);
                        return extractionBundle;
                    }
                    Mutex mutex2 = anonymousClass1.L$1;
                    ResultKt.throwOnFailure(obj);
                    r1 = mutex2;
                    ExtractionBundle extractionBundle2 = currentBundle;
                    r1 = r1;
                    if (extractionBundle2 != null) {
                        YouTubeCipherService youTubeCipherService2 = extractionBundle2.cipherService;
                        anonymousClass1.L$1 = r1;
                        anonymousClass1.L$2 = realStrongMemoryCacheExtractionTransport;
                        anonymousClass1.label = 2;
                        if (youTubeCipherService2.dispose(anonymousClass1) != coroutineSingletons) {
                            realStrongMemoryCache = realStrongMemoryCacheExtractionTransport;
                            r2 = r1;
                            realStrongMemoryCacheExtractionTransport = realStrongMemoryCache;
                            r1 = r2;
                        }
                        return coroutineSingletons;
                    }
                } catch (Exception e2) {
                    realStrongMemoryCache = realStrongMemoryCacheExtractionTransport;
                    exc = e2;
                    r2 = r1;
                    PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline2 = logger;
                    InnerTubeLogLevel innerTubeLogLevel2 = InnerTubeLogLevel.WARN;
                    simpleName = Reflection.getOrCreateKotlinClass(exc.getClass()).getSimpleName();
                    if (simpleName == null) {
                        simpleName = "unknown";
                    }
                    Map mapSingletonMap2 = Collections.singletonMap("exceptionType", simpleName);
                    mapSingletonMap2.getClass();
                    pathKt$$ExternalSyntheticBUOutline2.log(new InnerTubeLogEvent(innerTubeLogLevel2, "InnerTubeXPlayer", "old cipher disposal failed", mapSingletonMap2));
                }
                YouTube youTube2 = YouTube.INSTANCE;
                realStrongMemoryCacheExtractionTransport = YouTube.extractionTransport();
                ExtractionBundle extractionBundle3 = currentBundle;
                if (extractionBundle3 != null) {
                    if (extractionBundle3.transportGeneration != realStrongMemoryCacheExtractionTransport.initialMaxSize) {
                        extractionBundle3 = null;
                    }
                }
                HttpClient httpClient2 = (HttpClient) realStrongMemoryCacheExtractionTransport.cache;
                AndroidPlayerConfigRepository androidPlayerConfigRepository2 = (AndroidPlayerConfigRepository) configRepository$delegate.getValue();
                PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline3 = logger;
                RemotePlayerConfigStore remotePlayerConfigStore2 = new RemotePlayerConfigStore(httpClient2, androidPlayerConfigRepository2, pathKt$$ExternalSyntheticBUOutline3);
                YouTubeCipherService youTubeCipherService3 = new YouTubeCipherService((HttpClient) realStrongMemoryCacheExtractionTransport.cache, remotePlayerConfigStore2, pathKt$$ExternalSyntheticBUOutline3);
                YtConfigParserImpl ytConfigParserImpl2 = new YtConfigParserImpl((HttpClient) realStrongMemoryCacheExtractionTransport.cache, (InnerTube) realStrongMemoryCacheExtractionTransport.weakMemoryCache, remotePlayerConfigStore2, pathKt$$ExternalSyntheticBUOutline3);
                FileLock fileLock2 = new FileLock();
                fileLock2.lockChannel = ytConfigParserImpl2;
                fileLock2.lockFilename = ytConfigParserImpl2;
                extractionBundle3 = new ExtractionBundle(realStrongMemoryCacheExtractionTransport.initialMaxSize, youTubeCipherService3, new InnerTubeExtractor(fileLock2, youTubeCipherService3, (InnerTube) realStrongMemoryCacheExtractionTransport.weakMemoryCache, tokenProvider, pathKt$$ExternalSyntheticBUOutline3));
                currentBundle = extractionBundle3;
                r1.unlock(null);
                return extractionBundle3;
            } catch (Throwable th) {
                r2.unlock(null);
                throw th;
            }
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
    
        if (r0 == r5) goto L28;
     */
    /* JADX INFO: renamed from: playerResponseForPlayback-bMdYcbs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1519playerResponseForPlaybackbMdYcbs(String str, com.metrolist.music.constants.AudioQuality audioQuality, ConnectivityManager connectivityManager, ContentHints contentHints, boolean z, ContinuationImpl continuationImpl) {
        InnerTubeXPlayer$playerResponseForPlayback$1 innerTubeXPlayer$playerResponseForPlayback$1;
        com.metrolist.music.constants.AudioQuality audioQuality2;
        ContentHints contentHints2;
        ConnectivityManager connectivityManager2;
        Set set;
        if (continuationImpl instanceof InnerTubeXPlayer$playerResponseForPlayback$1) {
            innerTubeXPlayer$playerResponseForPlayback$1 = (InnerTubeXPlayer$playerResponseForPlayback$1) continuationImpl;
            int i = innerTubeXPlayer$playerResponseForPlayback$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                innerTubeXPlayer$playerResponseForPlayback$1.label = i - Integer.MIN_VALUE;
            } else {
                innerTubeXPlayer$playerResponseForPlayback$1 = new InnerTubeXPlayer$playerResponseForPlayback$1(this, continuationImpl);
            }
        } else {
            innerTubeXPlayer$playerResponseForPlayback$1 = new InnerTubeXPlayer$playerResponseForPlayback$1(this, continuationImpl);
        }
        InnerTubeXPlayer$playerResponseForPlayback$1 innerTubeXPlayer$playerResponseForPlayback$2 = innerTubeXPlayer$playerResponseForPlayback$1;
        Object objExtract = innerTubeXPlayer$playerResponseForPlayback$2.result;
        int i2 = innerTubeXPlayer$playerResponseForPlayback$2.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExtract);
                ContentHints contentHintsCopy$default = ContentHints.copy$default(ContentHints.copy$default(contentHints, Boolean.valueOf(Intrinsics.areEqual(contentHints.isUploaded, Boolean.TRUE)), null, 2031), null, null, 2047);
                contentHintsCopy$default.allowHls = false;
                contentHintsCopy$default.allowSabr = false;
                contentHintsCopy$default.allowBoundedRange = z;
                Set setFailedStreamClients$app$default = failedStreamClients$app$default(this, str);
                innerTubeXPlayer$playerResponseForPlayback$2.L$0 = str;
                innerTubeXPlayer$playerResponseForPlayback$2.L$2 = audioQuality;
                innerTubeXPlayer$playerResponseForPlayback$2.L$3 = connectivityManager;
                innerTubeXPlayer$playerResponseForPlayback$2.L$5 = contentHintsCopy$default;
                innerTubeXPlayer$playerResponseForPlayback$2.L$6 = setFailedStreamClients$app$default;
                innerTubeXPlayer$playerResponseForPlayback$2.Z$0 = z;
                innerTubeXPlayer$playerResponseForPlayback$2.label = 1;
                Object objBundle = bundle(innerTubeXPlayer$playerResponseForPlayback$2);
                if (objBundle != obj) {
                    objExtract = objBundle;
                    audioQuality2 = audioQuality;
                    contentHints2 = contentHintsCopy$default;
                    connectivityManager2 = connectivityManager;
                    set = setFailedStreamClients$app$default;
                }
                return obj;
            }
            if (i2 == 1) {
                z = innerTubeXPlayer$playerResponseForPlayback$2.Z$0;
                Set set2 = innerTubeXPlayer$playerResponseForPlayback$2.L$6;
                ContentHints contentHints3 = innerTubeXPlayer$playerResponseForPlayback$2.L$5;
                ConnectivityManager connectivityManager3 = innerTubeXPlayer$playerResponseForPlayback$2.L$3;
                com.metrolist.music.constants.AudioQuality audioQuality3 = innerTubeXPlayer$playerResponseForPlayback$2.L$2;
                String str2 = innerTubeXPlayer$playerResponseForPlayback$2.L$0;
                ResultKt.throwOnFailure(objExtract);
                set = set2;
                audioQuality2 = audioQuality3;
                contentHints2 = contentHints3;
                str = str2;
                connectivityManager2 = connectivityManager3;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Set set3 = innerTubeXPlayer$playerResponseForPlayback$2.L$6;
                ResultKt.throwOnFailure(objExtract);
            }
            if (objExtract == null) {
                throw new IllegalArgumentException("InnerTubeX returned no playable stream");
            }
            ExtractedStream extractedStream = (ExtractedStream) objExtract;
            if (extractedStream.sabrBootstrap == null) {
                return toPlaybackData(extractedStream);
            }
            throw new IllegalStateException("SABR is not supported by this playback engine");
            InnerTubeExtractor innerTubeExtractor = ((ExtractionBundle) objExtract).extractor;
            AudioQuality innerTubeX = toInnerTubeX(audioQuality2, connectivityManager2);
            boolean z2 = z;
            String strGenerateClientPlaybackNonce = PlaybackNonceKt.generateClientPlaybackNonce();
            innerTubeXPlayer$playerResponseForPlayback$2.L$0 = null;
            innerTubeXPlayer$playerResponseForPlayback$2.L$2 = null;
            innerTubeXPlayer$playerResponseForPlayback$2.L$3 = null;
            innerTubeXPlayer$playerResponseForPlayback$2.L$5 = null;
            innerTubeXPlayer$playerResponseForPlayback$2.L$6 = null;
            innerTubeXPlayer$playerResponseForPlayback$2.Z$0 = z2;
            innerTubeXPlayer$playerResponseForPlayback$2.label = 2;
            objExtract = innerTubeExtractor.extract(str, contentHints2, set, innerTubeX, strGenerateClientPlaybackNonce, innerTubeXPlayer$playerResponseForPlayback$2);
        } catch (StreamResolveException e) {
            StreamResolveException streamResolveException = e;
            Throwable cause = streamResolveException.getCause();
            if (streamResolveException.reason == StreamResolveException.Reason.NETWORK && cause != null) {
                streamResolveException = cause;
            }
            return new Result.Failure(streamResolveException);
        } catch (CancellationException e2) {
            throw e2;
        } catch (Exception e3) {
            return new Result.Failure(e3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        if (r5.prewarm(r0) == r4) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prewarm(ContinuationImpl continuationImpl) {
        C01831 c01831;
        if (continuationImpl instanceof C01831) {
            c01831 = (C01831) continuationImpl;
            int i = c01831.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01831.label = i - Integer.MIN_VALUE;
            } else {
                c01831 = new C01831(continuationImpl);
            }
        } else {
            c01831 = new C01831(continuationImpl);
        }
        Object objBundle = c01831.result;
        int i2 = c01831.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBundle);
            c01831.label = 1;
            objBundle = bundle(c01831);
            if (objBundle != obj) {
            }
            return obj;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(objBundle);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objBundle);
        }
        return Unit.INSTANCE;
        InnerTubeExtractor innerTubeExtractor = ((ExtractionBundle) objBundle).extractor;
        c01831.label = 2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object refreshAfterStreamRejection(ContinuationImpl continuationImpl) {
        C01841 c01841;
        if (continuationImpl instanceof C01841) {
            c01841 = (C01841) continuationImpl;
            int i = c01841.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01841.label = i - Integer.MIN_VALUE;
            } else {
                c01841 = new C01841(continuationImpl);
            }
        } else {
            c01841 = new C01841(continuationImpl);
        }
        Object objBundle = c01841.result;
        int i2 = c01841.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBundle);
            c01841.label = 1;
            objBundle = bundle(c01841);
            if (objBundle != obj) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objBundle);
                return objBundle;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(objBundle);
        YouTubeCipherService youTubeCipherService = ((ExtractionBundle) objBundle).cipherService;
        c01841.label = 2;
        Object objRefreshAfterStreamRejection = youTubeCipherService.refreshAfterStreamRejection(c01841);
        return objRefreshAfterStreamRejection == obj ? obj : objRefreshAfterStreamRejection;
    }
}
