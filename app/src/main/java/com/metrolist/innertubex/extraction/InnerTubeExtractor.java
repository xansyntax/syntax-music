package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MutatorMutex;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.DefaultMediaClock;
import androidx.navigation.NavDeepLinkRequest;
import androidx.room.concurrent.FileLock;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.cipher.YouTubeCipherService;
import com.metrolist.innertubex.extraction.strategy.ClientFallbackStrategy;
import com.metrolist.innertubex.extraction.strategy.ClientHealthMonitor;
import com.metrolist.innertubex.extraction.strategy.ClientHealthMonitor$Companion$NONE$1;
import com.metrolist.innertubex.extraction.strategy.ClientRequestCapabilities;
import com.metrolist.innertubex.extraction.strategy.ClientSelectionMode;
import com.metrolist.innertubex.extraction.strategy.ContentAwareFallbackStrategy;
import com.metrolist.innertubex.extraction.strategy.PlaybackClientCatalog;
import com.metrolist.innertubex.extraction.strategy.PlaybackClientManifest;
import com.metrolist.innertubex.extraction.strategy.PlaybackClientOption;
import com.metrolist.innertubex.models.Thumbnails;
import com.metrolist.innertubex.models.YouTubeLocale;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.utils.DataStoreKt$get$2;
import dagger.hilt.EntryPoints;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.Instant;
import kotlin.time.InstantJvmKt;
import kotlin.time.InstantKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeExtractor {
    public static final Regex CODECS_REGEX;
    public static final Regex EXPIRE_REGEX;
    public static final int MAX_PLAYER_REQUESTS_PER_EXTRACTION;
    public static final Regex N_PARAMETER_REGEX;
    public static final long PO_TOKEN_PREFETCH_TIMEOUT;
    public final YouTubeCipherService cipherService;
    public final PlayerClientDirector clientDirector;
    public final FileLock configParser;
    public final InnerTube innerTube;
    public final PathKt$$ExternalSyntheticBUOutline0 logger;
    public final LinkedHashMap playerConfigCache;
    public final MutexImpl playerConfigFetchMutex;
    public final TokenProvider tokenProvider;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CachedPlayerConfig {
        public final long cachedAtMs;
        public final PlayerConfig config;
        public final ConfigIdentity identity;
        public final boolean usedLoginCookies;

        public CachedPlayerConfig(PlayerConfig playerConfig, long j, ConfigIdentity configIdentity, boolean z) {
            playerConfig.getClass();
            configIdentity.getClass();
            this.config = playerConfig;
            this.cachedAtMs = j;
            this.identity = configIdentity;
            this.usedLoginCookies = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CachedPlayerConfig)) {
                return false;
            }
            CachedPlayerConfig cachedPlayerConfig = (CachedPlayerConfig) obj;
            return Intrinsics.areEqual(this.config, cachedPlayerConfig.config) && this.cachedAtMs == cachedPlayerConfig.cachedAtMs && Intrinsics.areEqual(this.identity, cachedPlayerConfig.identity) && this.usedLoginCookies == cachedPlayerConfig.usedLoginCookies;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.usedLoginCookies) + ((this.identity.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.config.hashCode() * 31, 31, this.cachedAtMs)) * 31);
        }

        public final String toString() {
            return "CachedPlayerConfig(config=" + this.config + ", cachedAtMs=" + this.cachedAtMs + ", identity=" + this.identity + ", usedLoginCookies=" + this.usedLoginCookies + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ConfigIdentity {
        public final String cookie;
        public final YouTubeLocale locale;

        public ConfigIdentity(YouTubeLocale youTubeLocale, String str) {
            this.locale = youTubeLocale;
            this.cookie = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConfigIdentity)) {
                return false;
            }
            ConfigIdentity configIdentity = (ConfigIdentity) obj;
            return this.locale.equals(configIdentity.locale) && Intrinsics.areEqual(this.cookie, configIdentity.cookie);
        }

        public final int hashCode() {
            int iHashCode = this.locale.hashCode() * 31;
            String str = this.cookie;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return "ConfigIdentity(locale=" + this.locale + ", cookie=" + this.cookie + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StreamResolveException.Reason.values().length];
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$extract$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public DefaultMediaClock L$5;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeExtractor.this.extract(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$extract$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ AudioQuality $audioQuality;
        public final /* synthetic */ String $clientPlaybackNonce;
        public final /* synthetic */ DefaultMediaClock $diagnostics;
        public final /* synthetic */ Set $excludedClients;
        public final /* synthetic */ ContentHints $hints;
        public final /* synthetic */ long $totalStart;
        public final /* synthetic */ String $videoId;
        public /* synthetic */ Object L$0;
        public DeferredCoroutine L$2;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ContentHints contentHints, String str, Set set, AudioQuality audioQuality, String str2, long j, DefaultMediaClock defaultMediaClock, Continuation continuation) {
            super(2, continuation);
            this.$hints = contentHints;
            this.$videoId = str;
            this.$excludedClients = set;
            this.$audioQuality = audioQuality;
            this.$clientPlaybackNonce = str2;
            this.$totalStart = j;
            this.$diagnostics = defaultMediaClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = InnerTubeExtractor.this.new AnonymousClass2(this.$hints, this.$videoId, this.$excludedClients, this.$audioQuality, this.$clientPlaybackNonce, this.$totalStart, this.$diagnostics, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x0093  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CancellationException cancellationException;
            DeferredCoroutine deferredCoroutineAsync$default;
            DeferredCoroutine deferredCoroutine;
            Object obj2;
            String str;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            boolean z = this.label;
            Continuation continuation = null;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                InnerTubeExtractor innerTubeExtractor = InnerTubeExtractor.this;
                InnerTube.SessionSnapshot sessionSnapshot = innerTubeExtractor.innerTube.sessionSnapshot();
                ContentHints contentHints = this.$hints;
                if (!Intrinsics.areEqual(contentHints.isExplicit, Boolean.TRUE) || contentHints.playbackClientOverrideId != null || (str = sessionSnapshot.visitorData) == null || StringsKt.isBlank(str) || innerTubeExtractor.tokenProvider.getCapabilities().providers.isEmpty()) {
                    cancellationException = null;
                    deferredCoroutineAsync$default = null;
                } else {
                    cancellationException = null;
                    deferredCoroutineAsync$default = AwaitKt.async$default(coroutineScope, null, new InnerTubeExtractor$prewarm$2$tokenWarmup$3$1(innerTubeExtractor, this.$videoId, sessionSnapshot, continuation, (byte) 2), 3);
                }
                try {
                    String str2 = this.$videoId;
                    ContentHints contentHints2 = this.$hints;
                    Set set = this.$excludedClients;
                    AudioQuality audioQuality = this.$audioQuality;
                    String str3 = this.$clientPlaybackNonce;
                    long j = this.$totalStart;
                    DefaultMediaClock defaultMediaClock = this.$diagnostics;
                    this.L$0 = cancellationException;
                    this.L$2 = deferredCoroutineAsync$default;
                    this.label = true;
                    Object objExtractWithDiagnostics = innerTubeExtractor.extractWithDiagnostics(str2, contentHints2, set, audioQuality, str3, j, defaultMediaClock, deferredCoroutineAsync$default, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objExtractWithDiagnostics == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj2 = objExtractWithDiagnostics;
                    deferredCoroutine = deferredCoroutineAsync$default;
                    ExtractedStream extractedStream = (ExtractedStream) obj2;
                    if (deferredCoroutine != null) {
                        deferredCoroutine.cancel(cancellationException);
                    }
                    return extractedStream;
                } catch (Throwable th) {
                    th = th;
                    deferredCoroutine = deferredCoroutineAsync$default;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                deferredCoroutine = this.L$2;
                try {
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    cancellationException = null;
                    try {
                        ExtractedStream extractedStream2 = (ExtractedStream) obj2;
                        if (deferredCoroutine != null) {
                            deferredCoroutine.cancel(cancellationException);
                        }
                        return extractedStream2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cancellationException = null;
                }
            }
            if (deferredCoroutine != null) {
                deferredCoroutine.cancel(cancellationException);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$extractWithCachedConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01191 extends ContinuationImpl {
        public long J$0;
        public long J$1;
        public long J$2;
        public String L$0;
        public ContentHints L$1;
        public Mutex L$10;
        public InnerTubeExtractor L$11;
        public ConfigIdentity L$12;
        public Set L$2;
        public String L$3;
        public AudioQuality L$4;
        public DefaultMediaClock L$5;
        public Deferred L$6;
        public CachedPlayerConfig L$8;
        public Ref$BooleanRef L$9;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C01191(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeExtractor.this.extractWithCachedConfig(null, null, null, null, false, 0L, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$extractWithConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01201 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public int I$2;
        public long J$0;
        public long J$1;
        public long J$2;
        public long J$3;
        public String L$0;
        public ContentHints L$1;
        public List L$10;
        public Iterator L$11;
        public ClientResult L$12;
        public PlayerResponse L$13;
        public PlayerResponse.StreamingData L$14;
        public PlaybackTrackingData L$15;
        public List L$17;
        public PlayerResponse.StreamingData.Format L$18;
        public Object L$19;
        public Set L$2;
        public String L$20;
        public PlayerResponse.StreamingData.Format L$21;
        public PlayerResponse.StreamingData.Format L$25;
        public Serializable L$26;
        public String L$27;
        public List L$28;
        public Instant L$29;
        public String L$3;
        public Map L$30;
        public Long L$31;
        public ArrayList L$32;
        public ArrayList L$33;
        public Ref$ObjectRef L$34;
        public Object L$35;
        public Ref$ObjectRef L$37;
        public PlayerConfig L$4;
        public PlayerResponse.StreamingData.Format L$40;
        public Serializable L$41;
        public String L$42;
        public Instant L$44;
        public Map L$45;
        public Long L$46;
        public AudioQuality L$5;
        public DefaultMediaClock L$6;
        public boolean Z$0;
        public boolean Z$1;
        public boolean Z$2;
        public boolean Z$3;
        public int label;
        public /* synthetic */ Object result;

        public C01201(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeExtractor.this.extractWithConfig(null, null, null, null, null, 0L, false, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$extractWithDiagnostics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01211 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public int I$2;
        public int I$3;
        public int I$4;
        public long J$0;
        public String L$0;
        public ContentHints L$1;
        public Set L$2;
        public AudioQuality L$3;
        public String L$4;
        public DefaultMediaClock L$5;
        public Deferred L$6;
        public int label;
        public /* synthetic */ Object result;

        public C01211(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeExtractor.this.extractWithDiagnostics(null, null, null, null, null, 0L, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$extractWithEmbeddedConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01221 extends ContinuationImpl {
        public long J$0;
        public long J$1;
        public String L$0;
        public ContentHints L$1;
        public Set L$2;
        public String L$3;
        public AudioQuality L$4;
        public DefaultMediaClock L$5;
        public int label;
        public /* synthetic */ Object result;

        public C01221(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeExtractor.this.extractWithEmbeddedConfig(null, null, null, null, 0L, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$extractWithWebKidsFallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01231 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public ContentHints L$1;
        public Set L$2;
        public String L$3;
        public AudioQuality L$4;
        public DefaultMediaClock L$5;
        public int label;
        public /* synthetic */ Object result;

        public C01231(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeExtractor.this.extractWithWebKidsFallback(null, null, null, null, 0L, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$getCachedPlayerConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01241 extends ContinuationImpl {
        public long J$0;
        public MutexImpl L$0;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C01241(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeExtractor.this.getCachedPlayerConfig(false, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.InnerTubeExtractor$prewarm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01251 extends ContinuationImpl {
        public long J$0;
        public String L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01251(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTubeExtractor.this.prewarm(this);
        }
    }

    static {
        Path.Companion companion = Duration.Companion;
        PO_TOKEN_PREFETCH_TIMEOUT = InstantKt.toDuration(18, DurationUnit.SECONDS);
        EXPIRE_REGEX = new Regex("[?&]expire=([0-9]+)");
        N_PARAMETER_REGEX = new Regex("(?:[?&]|%26)n(?:=|%3[dD])", 0);
        CODECS_REGEX = new Regex("codecs=\"([^\"]+)\"");
        MAX_PLAYER_REQUESTS_PER_EXTRACTION = (PlaybackClientCatalog.automaticManifests.size() * 4) + 2;
    }

    public InnerTubeExtractor(FileLock fileLock, YouTubeCipherService youTubeCipherService, InnerTube innerTube, TokenProvider tokenProvider, PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0) {
        ClientHealthMonitor.Companion.getClass();
        innerTube.getClass();
        ClientHealthMonitor$Companion$NONE$1 clientHealthMonitor$Companion$NONE$1 = ClientHealthMonitor.Companion.NONE;
        clientHealthMonitor$Companion$NONE$1.getClass();
        pathKt$$ExternalSyntheticBUOutline0.getClass();
        PlaybackClientCatalog playbackClientCatalog = PlaybackClientCatalog.INSTANCE;
        ContentAwareFallbackStrategy contentAwareFallbackStrategy = new ContentAwareFallbackStrategy();
        UnavailableTokenProvider unavailableTokenProvider = UnavailableTokenProvider.INSTANCE;
        PlayerClientDirector playerClientDirector = new PlayerClientDirector(innerTube, contentAwareFallbackStrategy, tokenProvider == null ? unavailableTokenProvider : tokenProvider, clientHealthMonitor$Companion$NONE$1, pathKt$$ExternalSyntheticBUOutline0);
        tokenProvider = tokenProvider == null ? unavailableTokenProvider : tokenProvider;
        this.configParser = fileLock;
        this.clientDirector = playerClientDirector;
        this.cipherService = youTubeCipherService;
        this.innerTube = innerTube;
        this.tokenProvider = tokenProvider;
        this.logger = pathKt$$ExternalSyntheticBUOutline0;
        this.playerConfigCache = new LinkedHashMap();
        this.playerConfigFetchMutex = new MutexImpl();
    }

    public static /* synthetic */ LinkedHashMap buildHeaders$default(InnerTubeExtractor innerTubeExtractor, String str, String str2) {
        return innerTubeExtractor.buildHeaders(str, str2, null, false);
    }

    public static String extractCodecs(String str) {
        MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(CODECS_REGEX, str);
        if (matcherMatchResultFind$default != null) {
            return (String) CollectionsKt.getOrNull(1, matcherMatchResultFind$default.getGroupValues());
        }
        return null;
    }

    public static Long extractExpire(String str) {
        String str2;
        MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(EXPIRE_REGEX, str);
        if (matcherMatchResultFind$default == null || (str2 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(1)) == null) {
            return null;
        }
        return StringsKt__StringsJVMKt.toLongOrNull(10, str2);
    }

    public static /* synthetic */ Object extractWithConfig$default(InnerTubeExtractor innerTubeExtractor, String str, ContentHints contentHints, Set set, String str2, PlayerConfig playerConfig, long j, boolean z, AudioQuality audioQuality, DefaultMediaClock defaultMediaClock, Deferred deferred, ContinuationImpl continuationImpl, int i) {
        return innerTubeExtractor.extractWithConfig(str, contentHints, set, str2, playerConfig, j, (i & 64) != 0 ? true : z, audioQuality, defaultMediaClock, (i & 512) != 0 ? null : deferred, continuationImpl);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public static final Object extractWithDiagnostics$extractWithWatchConfig(InnerTubeExtractor innerTubeExtractor, String str, ContentHints contentHints, Set set, String str2, long j, AudioQuality audioQuality, DefaultMediaClock defaultMediaClock, Deferred deferred, boolean z, ContinuationImpl continuationImpl) throws Exception {
        InnerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1 innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1;
        InnerTubeExtractor innerTubeExtractor2;
        DefaultMediaClock defaultMediaClock2;
        boolean z2;
        String strM;
        if (continuationImpl instanceof InnerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1) {
            innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1 = (InnerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1) continuationImpl;
            int i = innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1.label = i - Integer.MIN_VALUE;
            } else {
                innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1 = new InnerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1(continuationImpl);
            }
        } else {
            innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1 = new InnerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1(continuationImpl);
        }
        InnerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1 innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2 = innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1;
        Object objExtractWithCachedConfig = innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.result;
        int i2 = innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExtractWithCachedConfig);
                try {
                    innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.L$0 = innerTubeExtractor;
                    innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.L$6 = defaultMediaClock;
                    innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.Z$0 = z;
                    innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.label = 1;
                    objExtractWithCachedConfig = innerTubeExtractor.extractWithCachedConfig(str, contentHints, set, str2, z, j, audioQuality, defaultMediaClock, deferred, innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objExtractWithCachedConfig == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    innerTubeExtractor2 = innerTubeExtractor;
                    defaultMediaClock2 = defaultMediaClock;
                    z2 = z;
                } catch (Exception e) {
                    e = e;
                    innerTubeExtractor2 = innerTubeExtractor;
                    defaultMediaClock2 = defaultMediaClock;
                    z2 = z;
                    if (z2) {
                    }
                    if (z2) {
                        ((ArrayList) defaultMediaClock2.rendererClockSource).add(e);
                        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = innerTubeExtractor2.logger;
                        strM = Format$$ExternalSyntheticOutline0.m(e);
                        if (strM == null) {
                            strM = "unknown";
                        }
                        Map mapSingletonMap = Collections.singletonMap("exceptionType", strM);
                        mapSingletonMap.getClass();
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "authenticated watch config unavailable", mapSingletonMap, 4);
                    }
                    return null;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                z2 = innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.Z$0;
                defaultMediaClock2 = innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.L$6;
                innerTubeExtractor2 = innerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$2.L$0;
                try {
                    ResultKt.throwOnFailure(objExtractWithCachedConfig);
                } catch (Exception e2) {
                    e = e2;
                    if (z2 && !innerTubeExtractor2.innerTube.hasSapCookieAuth()) {
                        throw e;
                    }
                    if (z2) {
                        ((ArrayList) defaultMediaClock2.rendererClockSource).add(e);
                        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1 = innerTubeExtractor2.logger;
                        strM = Format$$ExternalSyntheticOutline0.m(e);
                        if (strM == null) {
                            strM = "unknown";
                        }
                        Map mapSingletonMap2 = Collections.singletonMap("exceptionType", strM);
                        mapSingletonMap2.getClass();
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "authenticated watch config unavailable", mapSingletonMap2, 4);
                    }
                    return null;
                }
            }
            return (ExtractedStream) objExtractWithCachedConfig;
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    public static boolean hasReadyVideoUrl(PlayerResponse.StreamingData.Format format) {
        String str = format.url;
        return (str == null || N_PARAMETER_REGEX.containsMatchIn(str) || !isAllowedMediaUrl(str)) ? false : true;
    }

    public static boolean isAllowedHlsUrl(String str) {
        Object failure;
        try {
            failure = URLUtilsKt.Url(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        Url url = (Url) failure;
        if (url == null || !Intrinsics.areEqual(url.getProtocol(), URLProtocol.INSTANCE.getHTTPS()) || url.getPort() != 443 || url.getUser() != null || url.getPassword() != null) {
            return false;
        }
        if (Intrinsics.areEqual(url.getHost(), "googlevideo.com") || StringsKt__StringsJVMKt.endsWith(url.getHost(), ".googlevideo.com", false) || Intrinsics.areEqual(url.getHost(), "youtube.com") || StringsKt__StringsJVMKt.endsWith(url.getHost(), ".youtube.com", false)) {
            return StringsKt__StringsJVMKt.startsWith(url.getEncodedPath(), "/manifest/", false) || StringsKt__StringsJVMKt.startsWith(url.getEncodedPath(), "/api/manifest/", false);
        }
        return false;
    }

    public static boolean isAllowedMediaUrl(String str) {
        Object failure;
        try {
            failure = URLUtilsKt.Url(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        Url url = (Url) failure;
        if (url != null && Intrinsics.areEqual(url.getProtocol(), URLProtocol.INSTANCE.getHTTPS()) && url.getPort() == 443) {
            return (Intrinsics.areEqual(url.getHost(), "googlevideo.com") || StringsKt__StringsJVMKt.endsWith(url.getHost(), ".googlevideo.com", false) || Intrinsics.areEqual(url.getHost(), "youtube.com") || StringsKt__StringsJVMKt.endsWith(url.getHost(), ".youtube.com", false)) && Intrinsics.areEqual(url.getEncodedPath(), "/videoplayback") && url.getUser() == null && url.getPassword() == null;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a6 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x002f, B:34:0x0099, B:36:0x00a6, B:40:0x00c4, B:41:0x00cb), top: B:46:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c4 A[Catch: all -> 0x0036, TRY_ENTER, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x002f, B:34:0x0099, B:36:0x00a6, B:40:0x00c4, B:41:0x00cb), top: B:46:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object prewarm$fetchConfig(InnerTubeExtractor innerTubeExtractor, boolean z, ContinuationImpl continuationImpl) throws Throwable {
        InnerTubeExtractor$prewarm$fetchConfig$1 innerTubeExtractor$prewarm$fetchConfig$1;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        boolean z2;
        ConfigIdentity configIdentity;
        InnerTubeExtractor innerTubeExtractor2;
        PlayerConfig playerConfig;
        if (continuationImpl instanceof InnerTubeExtractor$prewarm$fetchConfig$1) {
            innerTubeExtractor$prewarm$fetchConfig$1 = (InnerTubeExtractor$prewarm$fetchConfig$1) continuationImpl;
            int i = innerTubeExtractor$prewarm$fetchConfig$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                innerTubeExtractor$prewarm$fetchConfig$1.label = i - Integer.MIN_VALUE;
            } else {
                innerTubeExtractor$prewarm$fetchConfig$1 = new InnerTubeExtractor$prewarm$fetchConfig$1(continuationImpl);
            }
        } else {
            innerTubeExtractor$prewarm$fetchConfig$1 = new InnerTubeExtractor$prewarm$fetchConfig$1(continuationImpl);
        }
        Object obj = innerTubeExtractor$prewarm$fetchConfig$1.result;
        int i2 = innerTubeExtractor$prewarm$fetchConfig$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = innerTubeExtractor.playerConfigFetchMutex;
                innerTubeExtractor$prewarm$fetchConfig$1.L$0 = innerTubeExtractor;
                innerTubeExtractor$prewarm$fetchConfig$1.L$1 = mutex;
                innerTubeExtractor$prewarm$fetchConfig$1.Z$0 = z;
                innerTubeExtractor$prewarm$fetchConfig$1.label = 1;
                if (mutex.lock(innerTubeExtractor$prewarm$fetchConfig$1) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                boolean z3 = innerTubeExtractor$prewarm$fetchConfig$1.Z$0;
                ConfigIdentity configIdentity2 = innerTubeExtractor$prewarm$fetchConfig$1.L$3;
                innerTubeExtractor2 = innerTubeExtractor$prewarm$fetchConfig$1.L$2;
                mutex2 = innerTubeExtractor$prewarm$fetchConfig$1.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    z2 = z3;
                    configIdentity = configIdentity2;
                    playerConfig = (PlayerConfig) obj;
                    if (innerTubeExtractor2.configIdentity(z2).equals(configIdentity)) {
                        throw new CancellationException("InnerTube session changed");
                    }
                    innerTubeExtractor2.playerConfigCache.put(Boolean.valueOf(z2), new CachedPlayerConfig(playerConfig, InstantJvmKt.systemClock.now().toEpochMilliseconds(), configIdentity, z2));
                    mutex = mutex2;
                    PlayerConfig playerConfig2 = playerConfig;
                    mutex.unlock(null);
                    return playerConfig2;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            z = innerTubeExtractor$prewarm$fetchConfig$1.Z$0;
            Mutex mutex3 = innerTubeExtractor$prewarm$fetchConfig$1.L$1;
            InnerTubeExtractor innerTubeExtractor3 = innerTubeExtractor$prewarm$fetchConfig$1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            innerTubeExtractor = innerTubeExtractor3;
            CachedPlayerConfig cachedPlayerConfigLocked = innerTubeExtractor.getCachedPlayerConfigLocked(InstantJvmKt.systemClock.now().toEpochMilliseconds(), z);
            if (cachedPlayerConfigLocked == null || (playerConfig2 = cachedPlayerConfigLocked.config) == null) {
                ConfigIdentity configIdentity3 = innerTubeExtractor.configIdentity(z);
                FileLock fileLock = innerTubeExtractor.configParser;
                innerTubeExtractor$prewarm$fetchConfig$1.L$0 = null;
                innerTubeExtractor$prewarm$fetchConfig$1.L$1 = mutex;
                innerTubeExtractor$prewarm$fetchConfig$1.L$2 = innerTubeExtractor;
                innerTubeExtractor$prewarm$fetchConfig$1.L$3 = configIdentity3;
                innerTubeExtractor$prewarm$fetchConfig$1.Z$0 = z;
                innerTubeExtractor$prewarm$fetchConfig$1.label = 2;
                Object objFetchConfig = fileLock.fetchConfig("dQw4w9WgXcQ", z, innerTubeExtractor$prewarm$fetchConfig$1);
                if (objFetchConfig != coroutineSingletons) {
                    z2 = z;
                    mutex2 = mutex;
                    obj = objFetchConfig;
                    configIdentity = configIdentity3;
                    innerTubeExtractor2 = innerTubeExtractor;
                    playerConfig = (PlayerConfig) obj;
                    if (innerTubeExtractor2.configIdentity(z2).equals(configIdentity)) {
                        throw new CancellationException("InnerTube session changed");
                    }
                    innerTubeExtractor2.playerConfigCache.put(Boolean.valueOf(z2), new CachedPlayerConfig(playerConfig, InstantJvmKt.systemClock.now().toEpochMilliseconds(), configIdentity, z2));
                    mutex = mutex2;
                    PlayerConfig playerConfig3 = playerConfig;
                }
                return coroutineSingletons;
            }
            mutex.unlock(null);
            return playerConfig3;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    public static void throwExtractionFailure(ContentHints contentHints, DefaultMediaClock defaultMediaClock) {
        if (!defaultMediaClock.isUsingStandaloneClock) {
            StreamResolveException.Reason reasonClassifyPlayabilityFailures = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock.listener);
            if (reasonClassifyPlayabilityFailures != null) {
                throw new StreamResolveException(reasonClassifyPlayabilityFailures, WhenMappings.$EnumSwitchMapping$0[reasonClassifyPlayabilityFailures.ordinal()] == 1 ? "This track is age-restricted." : "This track is unavailable.", null, defaultMediaClock.snapshot());
            }
            Throwable th = (Throwable) CollectionsKt.lastOrNull((ArrayList) defaultMediaClock.rendererClockSource);
            if (th != null) {
                throw new StreamResolveException(StreamResolveException.Reason.NETWORK, "Unable to fetch stream data from YouTube.", th, defaultMediaClock.snapshot());
            }
        }
        throw new StreamResolveException(Intrinsics.areEqual(contentHints.isExplicit, Boolean.TRUE) ? StreamResolveException.Reason.EXPLICIT_UNSUPPORTED : StreamResolveException.Reason.NO_PLAYABLE_STREAM, "No playable stream found for this track.", null, defaultMediaClock.snapshot());
    }

    public static PlaybackTrackingData toPlaybackTrackingData(PlayerResponse.PlaybackTracking playbackTracking, String str) {
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl;
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl2;
        return new PlaybackTrackingData(str, (playbackTracking == null || (videostatsUrl2 = playbackTracking.videostatsPlaybackUrl) == null) ? null : videostatsUrl2.baseUrl, (playbackTracking == null || (videostatsUrl = playbackTracking.videostatsWatchtimeUrl) == null) ? null : videostatsUrl.baseUrl, playbackTracking != null ? playbackTracking.videostatsScheduledFlushWalltimeSeconds : null, playbackTracking != null ? playbackTracking.videostatsDefaultFlushIntervalSeconds : null, InstantJvmKt.systemClock.now().toEpochMilliseconds());
    }

    public static String withPoToken(String str, String str2) {
        if (str2 == null || StringsKt.isBlank(str2)) {
            return str;
        }
        if (StringsKt.contains(str, "&pot=", false) || StringsKt.contains(str, "?pot=", false)) {
            return str;
        }
        int iIndexOf$default = StringsKt.indexOf$default(str, '#', 0, 6);
        Integer numValueOf = Integer.valueOf(iIndexOf$default);
        if (iIndexOf$default < 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : str.length();
        int iIndexOf$default2 = StringsKt.indexOf$default(str, '?', 0, 6);
        String str3 = (iIndexOf$default2 < 0 || iIndexOf$default2 >= iIntValue) ? "?" : "&";
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + 6);
        sb.append((CharSequence) str, 0, iIntValue);
        sb.append(str3);
        sb.append("pot=");
        StringBuilder sb2 = new StringBuilder(str2.length());
        for (byte b : StringsKt__StringsJVMKt.encodeToByteArray(str2)) {
            int i = b & 255;
            if ((48 > i || i >= 58) && ((65 > i || i >= 91) && !((97 <= i && i < 123) || i == 45 || i == 46 || i == 95 || i == 126))) {
                sb2.append('%');
                sb2.append("0123456789ABCDEF".charAt(i >>> 4));
                sb2.append("0123456789ABCDEF".charAt(b & 15));
            } else {
                sb2.append((char) i);
            }
        }
        sb.append(sb2.toString());
        sb.append((CharSequence) str, iIntValue, str.length());
        return sb.toString();
    }

    public static void withResponseMetadata(ExtractedStream extractedStream, PlayerResponse playerResponse) {
        PlayerResponse.PlayerConfig.AudioConfig audioConfig;
        PlayerResponse.PlayerConfig playerConfig = playerResponse.playerConfig;
        ExtractedMediaMetadata extractedMediaMetadata = null;
        extractedStream.perceptualLoudnessDb = (playerConfig == null || (audioConfig = playerConfig.audioConfig) == null) ? null : audioConfig.perceptualLoudnessDb;
        PlayerResponse.VideoDetails videoDetails = playerResponse.videoDetails;
        if (videoDetails != null) {
            String str = videoDetails.title;
            String str2 = videoDetails.author;
            String str3 = videoDetails.channelId;
            String str4 = videoDetails.lengthSeconds;
            Long longOrNull = str4 != null ? StringsKt__StringsJVMKt.toLongOrNull(10, str4) : null;
            String str5 = videoDetails.musicVideoType;
            String str6 = videoDetails.viewCount;
            Thumbnails thumbnails = videoDetails.thumbnail;
            List list = thumbnails != null ? thumbnails.thumbnails : null;
            if (list == null) {
                list = EmptyList.INSTANCE;
            }
            extractedMediaMetadata = new ExtractedMediaMetadata(str, str2, str3, longOrNull, str5, str6, list, Intrinsics.areEqual(videoDetails.isLiveContent, Boolean.TRUE));
        }
        extractedStream.mediaMetadata = extractedMediaMetadata;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0070  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final LinkedHashMap buildHeaders(String str, String str2, String str3, boolean z) {
        String str4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean zAreEqual = Intrinsics.areEqual(str, "ANDROID_VR");
        InnerTube innerTube = this.innerTube;
        if (!zAreEqual && !Intrinsics.areEqual(str, "VISIONOS") && !Intrinsics.areEqual(str, "TVHTML5_SIMPLY")) {
            linkedHashMap.put(HttpHeaders.UserAgent, str2);
            linkedHashMap.put(HttpHeaders.Accept, "*/*");
            linkedHashMap.put(HttpHeaders.AcceptLanguage, ((InnerTube.SessionSnapshot) innerTube.session.get()).locale.acceptLanguageHeader$com_github_MetrolistGroup_innertubex());
            switch (str.hashCode()) {
                case -1613591039:
                    if (str.equals("WEB_CREATOR")) {
                        linkedHashMap.put(HttpHeaders.Referrer, "https://studio.youtube.com/");
                        linkedHashMap.put(HttpHeaders.Origin, "https://studio.youtube.com");
                    }
                    break;
                case -1391556002:
                    if (str.equals("WEB_REMIX")) {
                        linkedHashMap.put(HttpHeaders.Referrer, "https://music.youtube.com/");
                        linkedHashMap.put(HttpHeaders.Origin, "https://music.youtube.com");
                    }
                    break;
                case 85812:
                    if (str.equals("WEB")) {
                        linkedHashMap.put(HttpHeaders.Referrer, "https://www.youtube.com/");
                        linkedHashMap.put(HttpHeaders.Origin, "https://www.youtube.com");
                    }
                    break;
                case 2379719:
                    if (str.equals("MWEB")) {
                        linkedHashMap.put(HttpHeaders.Referrer, "https://m.youtube.com/");
                        linkedHashMap.put(HttpHeaders.Origin, "https://m.youtube.com");
                    }
                    break;
                case 1181560619:
                    if (str.equals("WEB_EMBEDDED_PLAYER")) {
                        linkedHashMap.put(HttpHeaders.Referrer, "https://www.youtube.com/");
                        linkedHashMap.put(HttpHeaders.Origin, "https://www.youtube.com");
                    }
                    break;
            }
        }
        if (z && str3 != null && isAllowedMediaUrl(str3) && (str4 = innerTube.sessionSnapshot().cookie) != null) {
            if (StringsKt.isBlank(str4)) {
                str4 = null;
            }
            if (str4 != null) {
                linkedHashMap.put(HttpHeaders.Cookie, str4);
            }
        }
        return linkedHashMap;
    }

    public final ConfigIdentity configIdentity(boolean z) {
        InnerTube.SessionSnapshot sessionSnapshot = this.innerTube.sessionSnapshot();
        YouTubeLocale youTubeLocale = sessionSnapshot.locale;
        String str = sessionSnapshot.cookie;
        if (!z) {
            str = null;
        }
        return new ConfigIdentity(youTubeLocale, str);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0087  */
    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object extract(String str, ContentHints contentHints, Set set, AudioQuality audioQuality, String str2, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        DefaultMediaClock defaultMediaClock;
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
        Object objCoroutineScope = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objCoroutineScope);
                long epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
                DefaultMediaClock defaultMediaClock2 = new DefaultMediaClock(contentHints.playbackClientOverrideId != null ? 1 : MAX_PLAYER_REQUESTS_PER_EXTRACTION);
                try {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(contentHints, str, set, audioQuality, str2, epochMilliseconds, defaultMediaClock2, null);
                    anonymousClass1.L$5 = defaultMediaClock2;
                    anonymousClass1.label = 1;
                    objCoroutineScope = AwaitKt.coroutineScope(anonymousClass2, anonymousClass1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objCoroutineScope == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    defaultMediaClock = defaultMediaClock2;
                } catch (StreamResolveException e) {
                    e = e;
                    defaultMediaClock = defaultMediaClock2;
                    if (e.diagnostics != null) {
                        throw e;
                    }
                    throw new StreamResolveException(e.reason, "Unable to resolve stream data.", e, defaultMediaClock.snapshot());
                } catch (Exception e2) {
                    e = e2;
                    defaultMediaClock = defaultMediaClock2;
                    throw new StreamResolveException(StreamResolveException.Reason.NETWORK, "Unable to fetch stream data from YouTube.", e, defaultMediaClock.snapshot());
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                defaultMediaClock = anonymousClass1.L$5;
                try {
                    ResultKt.throwOnFailure(objCoroutineScope);
                } catch (StreamResolveException e3) {
                    e = e3;
                    if (e.diagnostics != null) {
                        throw e;
                    }
                    throw new StreamResolveException(e.reason, "Unable to resolve stream data.", e, defaultMediaClock.snapshot());
                } catch (Exception e4) {
                    e = e4;
                    throw new StreamResolveException(StreamResolveException.Reason.NETWORK, "Unable to fetch stream data from YouTube.", e, defaultMediaClock.snapshot());
                }
            }
            return (ExtractedStream) objCoroutineScope;
        } catch (CancellationException e5) {
            throw e5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0276 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x0277  */
    /* JADX WARN: Code duplicated, block: B:53:0x0310  */
    /* JADX WARN: Code duplicated, block: B:54:0x0313  */
    /* JADX WARN: Code duplicated, block: B:56:0x031c  */
    /* JADX WARN: Code duplicated, block: B:59:0x032a A[Catch: all -> 0x0332, TryCatch #0 {all -> 0x0332, blocks: (B:74:0x03a9, B:76:0x03b7, B:78:0x03f5, B:79:0x03fc, B:57:0x031e, B:59:0x032a, B:63:0x0338, B:68:0x034c, B:70:0x035e), top: B:93:0x031e }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0336  */
    /* JADX WARN: Code duplicated, block: B:65:0x0346  */
    /* JADX WARN: Code duplicated, block: B:67:0x034b  */
    /* JADX WARN: Code duplicated, block: B:70:0x035e A[Catch: all -> 0x0332, TryCatch #0 {all -> 0x0332, blocks: (B:74:0x03a9, B:76:0x03b7, B:78:0x03f5, B:79:0x03fc, B:57:0x031e, B:59:0x032a, B:63:0x0338, B:68:0x034c, B:70:0x035e), top: B:93:0x031e }] */
    /* JADX WARN: Code duplicated, block: B:72:0x039c  */
    /* JADX WARN: Code duplicated, block: B:73:0x039f  */
    /* JADX WARN: Code duplicated, block: B:76:0x03b7 A[Catch: all -> 0x0332, TryCatch #0 {all -> 0x0332, blocks: (B:74:0x03a9, B:76:0x03b7, B:78:0x03f5, B:79:0x03fc, B:57:0x031e, B:59:0x032a, B:63:0x0338, B:68:0x034c, B:70:0x035e), top: B:93:0x031e }] */
    /* JADX WARN: Code duplicated, block: B:78:0x03f5 A[Catch: all -> 0x0332, TryCatch #0 {all -> 0x0332, blocks: (B:74:0x03a9, B:76:0x03b7, B:78:0x03f5, B:79:0x03fc, B:57:0x031e, B:59:0x032a, B:63:0x0338, B:68:0x034c, B:70:0x035e), top: B:93:0x031e }] */
    /* JADX WARN: Code duplicated, block: B:80:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:83:0x0418 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:86:0x041e  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code duplicated, block: B:90:0x04a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    public final Object extractWithCachedConfig(String str, ContentHints contentHints, Set set, String str2, boolean z, long j, AudioQuality audioQuality, DefaultMediaClock defaultMediaClock, Deferred deferred, ContinuationImpl continuationImpl) throws Throwable {
        C01191 c01191;
        DefaultMediaClock defaultMediaClock2;
        Deferred deferred2;
        Object obj;
        long j2;
        AudioQuality audioQuality2;
        ContentHints contentHints2;
        Set set2;
        String str3;
        boolean z2;
        String str4;
        long j3;
        String str5;
        Object obj2;
        CoroutineSingletons coroutineSingletons;
        Deferred deferred3;
        ContentHints contentHints3;
        DefaultMediaClock defaultMediaClock3;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0;
        long j4;
        boolean z3;
        Set set3;
        String str6;
        String str7;
        long j5;
        AudioQuality audioQuality3;
        CachedPlayerConfig cachedPlayerConfig;
        String str8;
        AudioQuality audioQuality4;
        boolean z4;
        long j6;
        CachedPlayerConfig cachedPlayerConfig2;
        DefaultMediaClock defaultMediaClock4;
        Deferred deferred4;
        long j7;
        Object obj3;
        String str9;
        Set set4;
        ContentHints contentHints4;
        long j8;
        Object obj4;
        CoroutineSingletons coroutineSingletons2;
        long epochMilliseconds;
        Ref$BooleanRef ref$BooleanRef;
        Mutex mutex;
        long j9;
        long j10;
        CoroutineSingletons coroutineSingletons3;
        CachedPlayerConfig cachedPlayerConfig3;
        long j11;
        String str10;
        boolean z5;
        ExtractedStream extractedStream;
        long j12;
        Path.Companion companion;
        CachedPlayerConfig cachedPlayerConfigLocked;
        CoroutineSingletons coroutineSingletons4;
        CachedPlayerConfig cachedPlayerConfig4;
        long j13;
        Set set5;
        boolean z6;
        ConfigIdentity configIdentity;
        long j14;
        Object objFetchConfig;
        CoroutineSingletons coroutineSingletons5;
        Set set6;
        long j15;
        boolean z7;
        InnerTubeExtractor innerTubeExtractor;
        Object obj5;
        ConfigIdentity configIdentity2;
        Mutex mutex2;
        LinkedHashMap linkedHashMap;
        DefaultMediaClock defaultMediaClock5;
        boolean z8;
        CoroutineSingletons coroutineSingletons6;
        Object objExtractWithConfig$default;
        PlayerConfig playerConfig;
        CachedPlayerConfig cachedPlayerConfig5;
        InnerTubeExtractor innerTubeExtractor2 = this;
        LinkedHashMap linkedHashMap2 = innerTubeExtractor2.playerConfigCache;
        if (continuationImpl instanceof C01191) {
            c01191 = (C01191) continuationImpl;
            int i = c01191.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01191.label = i - Integer.MIN_VALUE;
            } else {
                c01191 = innerTubeExtractor2.new C01191(continuationImpl);
            }
        } else {
            c01191 = innerTubeExtractor2.new C01191(continuationImpl);
        }
        C01191 c01192 = c01191;
        Object obj6 = c01192.result;
        int i2 = c01192.label;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1 = innerTubeExtractor2.logger;
        CoroutineSingletons coroutineSingletons7 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj6);
            long epochMilliseconds2 = InstantJvmKt.systemClock.now().toEpochMilliseconds();
            c01192.L$0 = str;
            c01192.L$1 = contentHints;
            c01192.L$2 = set;
            c01192.L$3 = str2;
            c01192.L$4 = audioQuality;
            c01192.L$5 = defaultMediaClock;
            c01192.L$6 = deferred;
            c01192.Z$0 = z;
            c01192.J$0 = j;
            c01192.J$1 = epochMilliseconds2;
            c01192.label = 1;
            Object cachedPlayerConfig6 = innerTubeExtractor2.getCachedPlayerConfig(z, epochMilliseconds2, c01192);
            if (cachedPlayerConfig6 == coroutineSingletons7) {
                return coroutineSingletons7;
            }
            defaultMediaClock2 = defaultMediaClock;
            deferred2 = deferred;
            obj = cachedPlayerConfig6;
            j2 = epochMilliseconds2;
            audioQuality2 = audioQuality;
            contentHints2 = contentHints;
            set2 = set;
            str3 = str;
            z2 = z;
            str4 = str2;
            j3 = j;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    long j16 = c01192.J$1;
                    long j17 = c01192.J$0;
                    boolean z9 = c01192.Z$0;
                    CachedPlayerConfig cachedPlayerConfig7 = c01192.L$8;
                    deferred4 = c01192.L$6;
                    defaultMediaClock4 = c01192.L$5;
                    AudioQuality audioQuality5 = c01192.L$4;
                    z4 = z9;
                    String str11 = c01192.L$3;
                    Set set7 = c01192.L$2;
                    ContentHints contentHints5 = c01192.L$1;
                    str8 = c01192.L$0;
                    ResultKt.throwOnFailure(obj6);
                    j6 = j16;
                    cachedPlayerConfig2 = cachedPlayerConfig7;
                    linkedHashMap2 = linkedHashMap2;
                    pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                    set4 = set7;
                    contentHints4 = contentHints5;
                    obj2 = "authenticated";
                    audioQuality4 = audioQuality5;
                    coroutineSingletons = coroutineSingletons7;
                    j7 = j17;
                    str9 = str11;
                    obj3 = obj6;
                    str10 = str8;
                    z5 = z4;
                    extractedStream = (ExtractedStream) obj3;
                    if (extractedStream != null) {
                        return extractedStream;
                    }
                    Map mapSingletonMap = Collections.singletonMap(obj2, String.valueOf(z5));
                    mapSingletonMap.getClass();
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "watch page cache unusable", mapSingletonMap, 4);
                    str6 = str9;
                    defaultMediaClock3 = defaultMediaClock4;
                    str5 = str10;
                    deferred3 = deferred4;
                    j4 = j7;
                    z3 = z5;
                    contentHints3 = contentHints4;
                    set3 = set4;
                    j5 = j6;
                    cachedPlayerConfig = cachedPlayerConfig2;
                    audioQuality3 = audioQuality4;
                    j8 = j4;
                    obj4 = obj2;
                    coroutineSingletons2 = coroutineSingletons;
                    epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
                    ref$BooleanRef = new Ref$BooleanRef();
                    c01192.L$0 = str5;
                    c01192.L$1 = contentHints3;
                    c01192.L$2 = set3;
                    c01192.L$3 = str6;
                    c01192.L$4 = audioQuality3;
                    c01192.L$5 = defaultMediaClock3;
                    c01192.L$6 = deferred3;
                    c01192.L$8 = cachedPlayerConfig;
                    c01192.L$9 = ref$BooleanRef;
                    mutex = innerTubeExtractor2.playerConfigFetchMutex;
                    c01192.L$10 = mutex;
                    c01192.Z$0 = z3;
                    c01192.J$0 = j8;
                    c01192.J$1 = j5;
                    j9 = j5;
                    c01192.J$2 = epochMilliseconds;
                    c01192.label = 3;
                    if (mutex.lock(c01192) == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                    j10 = epochMilliseconds;
                    cachedPlayerConfig3 = cachedPlayerConfig;
                    j11 = j9;
                    if (cachedPlayerConfig3 != null) {
                        coroutineSingletons3 = coroutineSingletons2;
                        cachedPlayerConfig3 = cachedPlayerConfig5;
                        j12 = j11;
                        linkedHashMap = linkedHashMap2;
                        if (linkedHashMap.get(Boolean.valueOf(z3)) == cachedPlayerConfig3) {
                            linkedHashMap.remove(Boolean.valueOf(z3));
                        }
                    } else {
                        coroutineSingletons3 = coroutineSingletons2;
                        cachedPlayerConfig3 = cachedPlayerConfig5;
                        j12 = j11;
                    }
                    if (((AtomicInteger) ((NavDeepLinkRequest) defaultMediaClock3.standaloneClock).mimeType).get() <= 0) {
                        mutex.unlock(null);
                        return null;
                    }
                    Path.Companion companion2 = InstantJvmKt.systemClock;
                    companion = companion2;
                    cachedPlayerConfigLocked = innerTubeExtractor2.getCachedPlayerConfigLocked(companion2.now().toEpochMilliseconds(), z3);
                    if (cachedPlayerConfigLocked == null) {
                        configIdentity = innerTubeExtractor2.configIdentity(z3);
                        FileLock fileLock = innerTubeExtractor2.configParser;
                        c01192.L$0 = str5;
                        c01192.L$1 = contentHints3;
                        c01192.L$2 = set3;
                        c01192.L$3 = str6;
                        c01192.L$4 = audioQuality3;
                        c01192.L$5 = defaultMediaClock3;
                        c01192.L$6 = deferred3;
                        c01192.L$8 = null;
                        c01192.L$9 = ref$BooleanRef;
                        c01192.L$10 = mutex;
                        c01192.L$11 = innerTubeExtractor2;
                        c01192.L$12 = configIdentity;
                        c01192.Z$0 = z3;
                        c01192.J$0 = j8;
                        long j18 = j12;
                        c01192.J$1 = j18;
                        j12 = j18;
                        j14 = j10;
                        c01192.J$2 = j14;
                        c01192.label = 4;
                        objFetchConfig = fileLock.fetchConfig(str5, z3, c01192);
                        coroutineSingletons5 = coroutineSingletons3;
                        if (objFetchConfig == coroutineSingletons5) {
                            return coroutineSingletons5;
                        }
                        set6 = set3;
                        j15 = j14;
                        z7 = z3;
                        innerTubeExtractor = this;
                        obj5 = objFetchConfig;
                        configIdentity2 = configIdentity;
                        playerConfig = (PlayerConfig) obj5;
                        coroutineSingletons4 = coroutineSingletons5;
                        if (innerTubeExtractor.configIdentity(z7).equals(configIdentity2)) {
                            throw new CancellationException("InnerTube session changed");
                        }
                        ref$BooleanRef.element = true;
                        Path.Companion companion3 = InstantJvmKt.systemClock;
                        boolean z10 = z7;
                        cachedPlayerConfig4 = new CachedPlayerConfig(playerConfig, companion3.now().toEpochMilliseconds(), configIdentity2, z10);
                        z3 = z10;
                        innerTubeExtractor.playerConfigCache.put(Boolean.valueOf(z3), cachedPlayerConfig4);
                        set5 = set6;
                        companion = companion3;
                        z6 = true;
                        j13 = j15;
                    } else {
                        coroutineSingletons4 = coroutineSingletons3;
                        cachedPlayerConfig4 = cachedPlayerConfigLocked;
                        j13 = j10;
                        set5 = set3;
                        z6 = true;
                    }
                    String str12 = str5;
                    String str13 = str6;
                    Mutex mutex3 = mutex;
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    defaultMediaClock5 = defaultMediaClock3;
                    Deferred deferred5 = deferred3;
                    long j19 = j8;
                    AudioQuality audioQuality6 = audioQuality3;
                    long j20 = j12;
                    boolean z11 = cachedPlayerConfig4.usedLoginCookies;
                    mutex3.unlock(null);
                    if (defaultMediaClock5.standaloneClockIsStarted) {
                        z8 = z6;
                    } else {
                        z8 = z6;
                    }
                    defaultMediaClock5.standaloneClockIsStarted = z8;
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "watch page config ready", MapsKt__MapsKt.mapOf(new Pair("fetched", String.valueOf(ref$BooleanRef2.element)), new Pair(obj4, String.valueOf(z11)), new Pair("elapsedMs", String.valueOf(companion.now().toEpochMilliseconds() - j13))), 4);
                    PlayerConfig playerConfig2 = cachedPlayerConfig4.config;
                    c01192.L$0 = null;
                    c01192.L$1 = null;
                    c01192.L$2 = null;
                    c01192.L$3 = null;
                    c01192.L$4 = null;
                    c01192.L$5 = null;
                    c01192.L$6 = null;
                    c01192.L$8 = null;
                    c01192.L$9 = null;
                    c01192.L$10 = null;
                    c01192.L$11 = null;
                    c01192.L$12 = null;
                    c01192.Z$0 = z3;
                    c01192.J$0 = j19;
                    c01192.J$1 = j20;
                    c01192.J$2 = j13;
                    c01192.label = 5;
                    coroutineSingletons6 = coroutineSingletons4;
                    objExtractWithConfig$default = extractWithConfig$default(this, str12, contentHints3, set5, str13, playerConfig2, j19, false, audioQuality6, defaultMediaClock5, deferred5, c01192, 64);
                    if (objExtractWithConfig$default == coroutineSingletons6) {
                        return coroutineSingletons6;
                    }
                    return objExtractWithConfig$default;
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        Set set8 = c01192.L$2;
                        ResultKt.throwOnFailure(obj6);
                        return obj6;
                    }
                    long j21 = c01192.J$2;
                    long j22 = c01192.J$1;
                    long j23 = c01192.J$0;
                    boolean z12 = c01192.Z$0;
                    ConfigIdentity configIdentity3 = c01192.L$12;
                    InnerTubeExtractor innerTubeExtractor3 = c01192.L$11;
                    mutex2 = c01192.L$10;
                    Ref$BooleanRef ref$BooleanRef3 = c01192.L$9;
                    Deferred deferred6 = c01192.L$6;
                    DefaultMediaClock defaultMediaClock6 = c01192.L$5;
                    AudioQuality audioQuality7 = c01192.L$4;
                    String str14 = c01192.L$3;
                    set6 = c01192.L$2;
                    ContentHints contentHints6 = c01192.L$1;
                    String str15 = c01192.L$0;
                    try {
                        ResultKt.throwOnFailure(obj6);
                        j12 = j22;
                        j15 = j21;
                        obj4 = "authenticated";
                        innerTubeExtractor = innerTubeExtractor3;
                        pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                        deferred3 = deferred6;
                        str6 = str14;
                        contentHints3 = contentHints6;
                        str5 = str15;
                        obj5 = obj6;
                        configIdentity2 = configIdentity3;
                        str7 = "InnerTubeExtractor";
                        z7 = z12;
                        ref$BooleanRef = ref$BooleanRef3;
                        mutex = mutex2;
                        j8 = j23;
                        coroutineSingletons5 = coroutineSingletons7;
                        defaultMediaClock3 = defaultMediaClock6;
                        audioQuality3 = audioQuality7;
                        playerConfig = (PlayerConfig) obj5;
                        coroutineSingletons4 = coroutineSingletons5;
                        if (innerTubeExtractor.configIdentity(z7).equals(configIdentity2)) {
                            throw new CancellationException("InnerTube session changed");
                        }
                        ref$BooleanRef.element = true;
                        Path.Companion companion4 = InstantJvmKt.systemClock;
                        boolean z13 = z7;
                        cachedPlayerConfig4 = new CachedPlayerConfig(playerConfig, companion4.now().toEpochMilliseconds(), configIdentity2, z13);
                        z3 = z13;
                        innerTubeExtractor.playerConfigCache.put(Boolean.valueOf(z3), cachedPlayerConfig4);
                        set5 = set6;
                        companion = companion4;
                        z6 = true;
                        j13 = j15;
                        String str16 = str5;
                        String str17 = str6;
                        Mutex mutex4 = mutex;
                        Ref$BooleanRef ref$BooleanRef4 = ref$BooleanRef;
                        defaultMediaClock5 = defaultMediaClock3;
                        Deferred deferred7 = deferred3;
                        long j110 = j8;
                        AudioQuality audioQuality8 = audioQuality3;
                        long j24 = j12;
                        boolean z14 = cachedPlayerConfig4.usedLoginCookies;
                        mutex4.unlock(null);
                        if (defaultMediaClock5.standaloneClockIsStarted || z14) {
                            z8 = z6;
                        } else {
                            z8 = false;
                        }
                        defaultMediaClock5.standaloneClockIsStarted = z8;
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "watch page config ready", MapsKt__MapsKt.mapOf(new Pair("fetched", String.valueOf(ref$BooleanRef4.element)), new Pair(obj4, String.valueOf(z14)), new Pair("elapsedMs", String.valueOf(companion.now().toEpochMilliseconds() - j13))), 4);
                        PlayerConfig playerConfig3 = cachedPlayerConfig4.config;
                        c01192.L$0 = null;
                        c01192.L$1 = null;
                        c01192.L$2 = null;
                        c01192.L$3 = null;
                        c01192.L$4 = null;
                        c01192.L$5 = null;
                        c01192.L$6 = null;
                        c01192.L$8 = null;
                        c01192.L$9 = null;
                        c01192.L$10 = null;
                        c01192.L$11 = null;
                        c01192.L$12 = null;
                        c01192.Z$0 = z3;
                        c01192.J$0 = j110;
                        c01192.J$1 = j24;
                        c01192.J$2 = j13;
                        c01192.label = 5;
                        coroutineSingletons6 = coroutineSingletons4;
                        objExtractWithConfig$default = extractWithConfig$default(this, str16, contentHints3, set5, str17, playerConfig3, j110, false, audioQuality8, defaultMediaClock5, deferred7, c01192, 64);
                        if (objExtractWithConfig$default == coroutineSingletons6) {
                            return coroutineSingletons6;
                        }
                        return objExtractWithConfig$default;
                    } catch (Throwable th) {
                        th = th;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                long j25 = c01192.J$2;
                long j26 = c01192.J$1;
                long j27 = c01192.J$0;
                boolean z15 = c01192.Z$0;
                Mutex mutex5 = c01192.L$10;
                Ref$BooleanRef ref$BooleanRef5 = c01192.L$9;
                cachedPlayerConfig5 = c01192.L$8;
                Deferred deferred8 = c01192.L$6;
                DefaultMediaClock defaultMediaClock7 = c01192.L$5;
                AudioQuality audioQuality9 = c01192.L$4;
                String str18 = c01192.L$3;
                Set set9 = c01192.L$2;
                ContentHints contentHints7 = c01192.L$1;
                String str19 = c01192.L$0;
                ResultKt.throwOnFailure(obj6);
                j10 = j25;
                j11 = j26;
                obj4 = "authenticated";
                coroutineSingletons3 = coroutineSingletons7;
                linkedHashMap2 = linkedHashMap2;
                pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                defaultMediaClock3 = defaultMediaClock7;
                audioQuality3 = audioQuality9;
                str6 = str18;
                str5 = str19;
                ref$BooleanRef = ref$BooleanRef5;
                str7 = "InnerTubeExtractor";
                deferred3 = deferred8;
                mutex = mutex5;
                j8 = j27;
                z3 = z15;
                set3 = set9;
                contentHints3 = contentHints7;
                if (cachedPlayerConfig3 != null) {
                    coroutineSingletons3 = coroutineSingletons2;
                    cachedPlayerConfig3 = cachedPlayerConfig5;
                    j12 = j11;
                    try {
                        linkedHashMap = linkedHashMap2;
                        if (linkedHashMap.get(Boolean.valueOf(z3)) == cachedPlayerConfig3) {
                            linkedHashMap.remove(Boolean.valueOf(z3));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2 = mutex;
                        mutex2.unlock(null);
                        throw th;
                    }
                } else {
                    coroutineSingletons3 = coroutineSingletons2;
                    cachedPlayerConfig3 = cachedPlayerConfig5;
                    j12 = j11;
                }
                if (((AtomicInteger) ((NavDeepLinkRequest) defaultMediaClock3.standaloneClock).mimeType).get() <= 0) {
                    mutex.unlock(null);
                    return null;
                }
                Path.Companion companion5 = InstantJvmKt.systemClock;
                companion = companion5;
                cachedPlayerConfigLocked = innerTubeExtractor2.getCachedPlayerConfigLocked(companion5.now().toEpochMilliseconds(), z3);
                if (cachedPlayerConfigLocked == null) {
                    configIdentity = innerTubeExtractor2.configIdentity(z3);
                    FileLock fileLock2 = innerTubeExtractor2.configParser;
                    c01192.L$0 = str5;
                    c01192.L$1 = contentHints3;
                    c01192.L$2 = set3;
                    c01192.L$3 = str6;
                    c01192.L$4 = audioQuality3;
                    c01192.L$5 = defaultMediaClock3;
                    c01192.L$6 = deferred3;
                    c01192.L$8 = null;
                    c01192.L$9 = ref$BooleanRef;
                    c01192.L$10 = mutex;
                    c01192.L$11 = innerTubeExtractor2;
                    c01192.L$12 = configIdentity;
                    c01192.Z$0 = z3;
                    c01192.J$0 = j8;
                    long j111 = j12;
                    c01192.J$1 = j111;
                    j12 = j111;
                    j14 = j10;
                    c01192.J$2 = j14;
                    c01192.label = 4;
                    objFetchConfig = fileLock2.fetchConfig(str5, z3, c01192);
                    coroutineSingletons5 = coroutineSingletons3;
                    if (objFetchConfig == coroutineSingletons5) {
                        return coroutineSingletons5;
                    }
                    set6 = set3;
                    j15 = j14;
                    z7 = z3;
                    innerTubeExtractor = this;
                    obj5 = objFetchConfig;
                    configIdentity2 = configIdentity;
                    playerConfig = (PlayerConfig) obj5;
                    coroutineSingletons4 = coroutineSingletons5;
                    if (innerTubeExtractor.configIdentity(z7).equals(configIdentity2)) {
                        throw new CancellationException("InnerTube session changed");
                    }
                    ref$BooleanRef.element = true;
                    Path.Companion companion6 = InstantJvmKt.systemClock;
                    boolean z16 = z7;
                    cachedPlayerConfig4 = new CachedPlayerConfig(playerConfig, companion6.now().toEpochMilliseconds(), configIdentity2, z16);
                    z3 = z16;
                    innerTubeExtractor.playerConfigCache.put(Boolean.valueOf(z3), cachedPlayerConfig4);
                    set5 = set6;
                    companion = companion6;
                    z6 = true;
                    j13 = j15;
                } else {
                    coroutineSingletons4 = coroutineSingletons3;
                    cachedPlayerConfig4 = cachedPlayerConfigLocked;
                    j13 = j10;
                    set5 = set3;
                    z6 = true;
                }
                String str110 = str5;
                String str111 = str6;
                Mutex mutex6 = mutex;
                Ref$BooleanRef ref$BooleanRef6 = ref$BooleanRef;
                defaultMediaClock5 = defaultMediaClock3;
                Deferred deferred9 = deferred3;
                long j112 = j8;
                AudioQuality audioQuality10 = audioQuality3;
                long j28 = j12;
                boolean z17 = cachedPlayerConfig4.usedLoginCookies;
                mutex6.unlock(null);
                if (defaultMediaClock5.standaloneClockIsStarted) {
                    z8 = z6;
                } else {
                    z8 = z6;
                }
                defaultMediaClock5.standaloneClockIsStarted = z8;
                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "watch page config ready", MapsKt__MapsKt.mapOf(new Pair("fetched", String.valueOf(ref$BooleanRef6.element)), new Pair(obj4, String.valueOf(z17)), new Pair("elapsedMs", String.valueOf(companion.now().toEpochMilliseconds() - j13))), 4);
                PlayerConfig playerConfig4 = cachedPlayerConfig4.config;
                c01192.L$0 = null;
                c01192.L$1 = null;
                c01192.L$2 = null;
                c01192.L$3 = null;
                c01192.L$4 = null;
                c01192.L$5 = null;
                c01192.L$6 = null;
                c01192.L$8 = null;
                c01192.L$9 = null;
                c01192.L$10 = null;
                c01192.L$11 = null;
                c01192.L$12 = null;
                c01192.Z$0 = z3;
                c01192.J$0 = j112;
                c01192.J$1 = j28;
                c01192.J$2 = j13;
                c01192.label = 5;
                coroutineSingletons6 = coroutineSingletons4;
                objExtractWithConfig$default = extractWithConfig$default(this, str110, contentHints3, set5, str111, playerConfig4, j112, false, audioQuality10, defaultMediaClock5, deferred9, c01192, 64);
                if (objExtractWithConfig$default == coroutineSingletons6) {
                    return coroutineSingletons6;
                }
                return objExtractWithConfig$default;
            }
            long j29 = c01192.J$1;
            long j30 = c01192.J$0;
            boolean z18 = c01192.Z$0;
            Deferred deferred10 = c01192.L$6;
            defaultMediaClock2 = c01192.L$5;
            audioQuality2 = c01192.L$4;
            String str20 = c01192.L$3;
            Set set10 = c01192.L$2;
            ContentHints contentHints8 = c01192.L$1;
            str3 = c01192.L$0;
            ResultKt.throwOnFailure(obj6);
            obj = obj6;
            contentHints2 = contentHints8;
            j2 = j29;
            str4 = str20;
            set2 = set10;
            deferred2 = deferred10;
            j3 = j30;
            z2 = z18;
        }
        CachedPlayerConfig cachedPlayerConfig8 = (CachedPlayerConfig) obj;
        if (cachedPlayerConfig8 != null) {
            Set set11 = set2;
            boolean z19 = cachedPlayerConfig8.usedLoginCookies;
            defaultMediaClock2.standaloneClockIsStarted = defaultMediaClock2.standaloneClockIsStarted || z19;
            long j31 = j2;
            long j32 = j31 - cachedPlayerConfig8.cachedAtMs;
            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "watch page cache hit", MapsKt__MapsKt.mapOf(new Pair("authenticated", String.valueOf(z19)), new Pair("ageMs", String.valueOf(j32))), 4);
            PlayerConfig playerConfig5 = cachedPlayerConfig8.config;
            c01192.L$0 = str3;
            c01192.L$1 = contentHints2;
            c01192.L$2 = set11;
            c01192.L$3 = str4;
            c01192.L$4 = audioQuality2;
            c01192.L$5 = defaultMediaClock2;
            c01192.L$6 = deferred2;
            c01192.L$8 = cachedPlayerConfig8;
            c01192.Z$0 = z2;
            c01192.J$0 = j3;
            c01192.J$1 = j31;
            c01192.J$2 = j32;
            c01192.label = 2;
            str8 = str3;
            audioQuality4 = audioQuality2;
            Deferred deferred11 = deferred2;
            z4 = z2;
            pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
            j6 = j31;
            obj2 = "authenticated";
            coroutineSingletons = coroutineSingletons7;
            innerTubeExtractor2 = this;
            cachedPlayerConfig2 = cachedPlayerConfig8;
            Object objExtractWithConfig$default2 = extractWithConfig$default(innerTubeExtractor2, str8, contentHints2, set11, str4, playerConfig5, j3, false, audioQuality4, defaultMediaClock2, deferred11, c01192, 64);
            if (objExtractWithConfig$default2 == coroutineSingletons) {
                return coroutineSingletons;
            }
            defaultMediaClock4 = defaultMediaClock2;
            deferred4 = deferred11;
            j7 = j3;
            obj3 = objExtractWithConfig$default2;
            str9 = str4;
            set4 = set11;
            contentHints4 = contentHints2;
            str10 = str8;
            z5 = z4;
            extractedStream = (ExtractedStream) obj3;
            if (extractedStream != null) {
                return extractedStream;
            }
            Map mapSingletonMap2 = Collections.singletonMap(obj2, String.valueOf(z5));
            mapSingletonMap2.getClass();
            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "watch page cache unusable", mapSingletonMap2, 4);
            str6 = str9;
            defaultMediaClock3 = defaultMediaClock4;
            str5 = str10;
            deferred3 = deferred4;
            j4 = j7;
            z3 = z5;
            contentHints3 = contentHints4;
            set3 = set4;
            j5 = j6;
            cachedPlayerConfig = cachedPlayerConfig2;
            audioQuality3 = audioQuality4;
        } else {
            boolean z20 = z2;
            long j33 = j2;
            innerTubeExtractor2 = this;
            str5 = str3;
            obj2 = "authenticated";
            AudioQuality audioQuality11 = audioQuality2;
            coroutineSingletons = coroutineSingletons7;
            deferred3 = deferred2;
            contentHints3 = contentHints2;
            defaultMediaClock3 = defaultMediaClock2;
            pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
            j4 = j3;
            z3 = z20;
            set3 = set2;
            str6 = str4;
            str7 = "InnerTubeExtractor";
            j5 = j33;
            audioQuality3 = audioQuality11;
            cachedPlayerConfig = cachedPlayerConfig8;
        }
        j8 = j4;
        obj4 = obj2;
        coroutineSingletons2 = coroutineSingletons;
        epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
        ref$BooleanRef = new Ref$BooleanRef();
        c01192.L$0 = str5;
        c01192.L$1 = contentHints3;
        c01192.L$2 = set3;
        c01192.L$3 = str6;
        c01192.L$4 = audioQuality3;
        c01192.L$5 = defaultMediaClock3;
        c01192.L$6 = deferred3;
        c01192.L$8 = cachedPlayerConfig;
        c01192.L$9 = ref$BooleanRef;
        mutex = innerTubeExtractor2.playerConfigFetchMutex;
        c01192.L$10 = mutex;
        c01192.Z$0 = z3;
        c01192.J$0 = j8;
        c01192.J$1 = j5;
        j9 = j5;
        c01192.J$2 = epochMilliseconds;
        c01192.label = 3;
        if (mutex.lock(c01192) == coroutineSingletons2) {
            return coroutineSingletons2;
        }
        j10 = epochMilliseconds;
        cachedPlayerConfig3 = cachedPlayerConfig;
        j11 = j9;
        if (cachedPlayerConfig3 != null) {
            coroutineSingletons3 = coroutineSingletons2;
            cachedPlayerConfig3 = cachedPlayerConfig5;
            j12 = j11;
            linkedHashMap = linkedHashMap2;
            if (linkedHashMap.get(Boolean.valueOf(z3)) == cachedPlayerConfig3) {
                linkedHashMap.remove(Boolean.valueOf(z3));
            }
        } else {
            coroutineSingletons3 = coroutineSingletons2;
            cachedPlayerConfig3 = cachedPlayerConfig5;
            j12 = j11;
        }
        if (((AtomicInteger) ((NavDeepLinkRequest) defaultMediaClock3.standaloneClock).mimeType).get() <= 0) {
            mutex.unlock(null);
            return null;
        }
        Path.Companion companion7 = InstantJvmKt.systemClock;
        companion = companion7;
        cachedPlayerConfigLocked = innerTubeExtractor2.getCachedPlayerConfigLocked(companion7.now().toEpochMilliseconds(), z3);
        if (cachedPlayerConfigLocked == null) {
            configIdentity = innerTubeExtractor2.configIdentity(z3);
            FileLock fileLock3 = innerTubeExtractor2.configParser;
            c01192.L$0 = str5;
            c01192.L$1 = contentHints3;
            c01192.L$2 = set3;
            c01192.L$3 = str6;
            c01192.L$4 = audioQuality3;
            c01192.L$5 = defaultMediaClock3;
            c01192.L$6 = deferred3;
            c01192.L$8 = null;
            c01192.L$9 = ref$BooleanRef;
            c01192.L$10 = mutex;
            c01192.L$11 = innerTubeExtractor2;
            c01192.L$12 = configIdentity;
            c01192.Z$0 = z3;
            c01192.J$0 = j8;
            long j113 = j12;
            c01192.J$1 = j113;
            j12 = j113;
            j14 = j10;
            c01192.J$2 = j14;
            c01192.label = 4;
            objFetchConfig = fileLock3.fetchConfig(str5, z3, c01192);
            coroutineSingletons5 = coroutineSingletons3;
            if (objFetchConfig == coroutineSingletons5) {
                return coroutineSingletons5;
            }
            set6 = set3;
            j15 = j14;
            z7 = z3;
            innerTubeExtractor = this;
            obj5 = objFetchConfig;
            configIdentity2 = configIdentity;
            playerConfig = (PlayerConfig) obj5;
            coroutineSingletons4 = coroutineSingletons5;
            if (innerTubeExtractor.configIdentity(z7).equals(configIdentity2)) {
                throw new CancellationException("InnerTube session changed");
            }
            ref$BooleanRef.element = true;
            Path.Companion companion8 = InstantJvmKt.systemClock;
            boolean z110 = z7;
            cachedPlayerConfig4 = new CachedPlayerConfig(playerConfig, companion8.now().toEpochMilliseconds(), configIdentity2, z110);
            z3 = z110;
            innerTubeExtractor.playerConfigCache.put(Boolean.valueOf(z3), cachedPlayerConfig4);
            set5 = set6;
            companion = companion8;
            z6 = true;
            j13 = j15;
        } else {
            coroutineSingletons4 = coroutineSingletons3;
            cachedPlayerConfig4 = cachedPlayerConfigLocked;
            j13 = j10;
            set5 = set3;
            z6 = true;
        }
        String str112 = str5;
        String str113 = str6;
        Mutex mutex7 = mutex;
        Ref$BooleanRef ref$BooleanRef7 = ref$BooleanRef;
        defaultMediaClock5 = defaultMediaClock3;
        Deferred deferred12 = deferred3;
        long j114 = j8;
        AudioQuality audioQuality12 = audioQuality3;
        long j210 = j12;
        boolean z111 = cachedPlayerConfig4.usedLoginCookies;
        mutex7.unlock(null);
        if (defaultMediaClock5.standaloneClockIsStarted) {
            z8 = z6;
        } else {
            z8 = z6;
        }
        defaultMediaClock5.standaloneClockIsStarted = z8;
        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "watch page config ready", MapsKt__MapsKt.mapOf(new Pair("fetched", String.valueOf(ref$BooleanRef7.element)), new Pair(obj4, String.valueOf(z111)), new Pair("elapsedMs", String.valueOf(companion.now().toEpochMilliseconds() - j13))), 4);
        PlayerConfig playerConfig6 = cachedPlayerConfig4.config;
        c01192.L$0 = null;
        c01192.L$1 = null;
        c01192.L$2 = null;
        c01192.L$3 = null;
        c01192.L$4 = null;
        c01192.L$5 = null;
        c01192.L$6 = null;
        c01192.L$8 = null;
        c01192.L$9 = null;
        c01192.L$10 = null;
        c01192.L$11 = null;
        c01192.L$12 = null;
        c01192.Z$0 = z3;
        c01192.J$0 = j114;
        c01192.J$1 = j210;
        c01192.J$2 = j13;
        c01192.label = 5;
        coroutineSingletons6 = coroutineSingletons4;
        objExtractWithConfig$default = extractWithConfig$default(this, str112, contentHints3, set5, str113, playerConfig6, j114, false, audioQuality12, defaultMediaClock5, deferred12, c01192, 64);
        if (objExtractWithConfig$default == coroutineSingletons6) {
            return coroutineSingletons6;
        }
        return objExtractWithConfig$default;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:356:0x0fc7 -> B:54:0x06e4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:376:0x1132 -> B:54:0x06e4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:553:0x1944 -> B:554:0x195d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 73821. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object extractWithConfig(java.lang.String r138, com.metrolist.innertubex.extraction.ContentHints r139, java.util.Set r140, java.lang.String r141, com.metrolist.innertubex.extraction.PlayerConfig r142, long r143, boolean r145, com.metrolist.innertubex.extraction.AudioQuality r146, androidx.media3.exoplayer.DefaultMediaClock r147, kotlinx.coroutines.Deferred r148, kotlin.coroutines.jvm.internal.ContinuationImpl r149) {
        /*
            Method dump skipped, instruction units count: 7382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.extraction.InnerTubeExtractor.extractWithConfig(java.lang.String, com.metrolist.innertubex.extraction.ContentHints, java.util.Set, java.lang.String, com.metrolist.innertubex.extraction.PlayerConfig, long, boolean, com.metrolist.innertubex.extraction.AudioQuality, androidx.media3.exoplayer.DefaultMediaClock, kotlinx.coroutines.Deferred, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0363  */
    /* JADX WARN: Code duplicated, block: B:110:0x0399  */
    /* JADX WARN: Code duplicated, block: B:121:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:123:0x03e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:124:0x03e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:128:0x044d  */
    /* JADX WARN: Code duplicated, block: B:131:0x045b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:132:0x045c  */
    /* JADX WARN: Code duplicated, block: B:134:0x046d  */
    /* JADX WARN: Code duplicated, block: B:136:0x048b  */
    /* JADX WARN: Code duplicated, block: B:138:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:139:0x04db  */
    /* JADX WARN: Code duplicated, block: B:142:0x04ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:143:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:144:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:146:0x050c  */
    /* JADX WARN: Code duplicated, block: B:149:0x055f  */
    /* JADX WARN: Code duplicated, block: B:152:0x0572 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:153:0x0573  */
    /* JADX WARN: Code duplicated, block: B:154:0x0580  */
    /* JADX WARN: Code duplicated, block: B:157:0x0593  */
    /* JADX WARN: Code duplicated, block: B:165:0x05f9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:166:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:171:0x061e  */
    /* JADX WARN: Code duplicated, block: B:175:0x062e  */
    /* JADX WARN: Code duplicated, block: B:186:0x0680 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:191:0x068d  */
    /* JADX WARN: Code duplicated, block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:44:0x0209 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x020a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0234  */
    /* JADX WARN: Code duplicated, block: B:76:0x027d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0302 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x0303  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v103 */
    /* JADX WARN: Type inference failed for: r0v104 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v75 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v83 */
    /* JADX WARN: Type inference failed for: r0v86, types: [int] */
    /* JADX WARN: Type inference failed for: r0v92 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r29v0, types: [com.metrolist.innertubex.extraction.InnerTubeExtractor] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v73 */
    public final Object extractWithDiagnostics(String str, ContentHints contentHints, Set set, AudioQuality audioQuality, String str2, long j, DefaultMediaClock defaultMediaClock, DeferredCoroutine deferredCoroutine, ContinuationImpl continuationImpl) throws Exception {
        C01211 c01211;
        String str3;
        int i;
        int i2;
        int i3;
        String str4;
        int i4;
        int i5;
        CoroutineSingletons coroutineSingletons;
        String str5;
        ContentHints contentHints2;
        Set set2;
        AudioQuality audioQuality2;
        String str6;
        long j2;
        DefaultMediaClock defaultMediaClock2;
        Deferred deferred;
        int i6;
        int i7;
        int i8;
        Set set3;
        AudioQuality audioQuality3;
        String str7;
        DefaultMediaClock defaultMediaClock3;
        Deferred deferred2;
        int i9;
        int i10;
        Object obj;
        int i11;
        String str8;
        String str9;
        PlaybackClientOption playbackClientOptionFind;
        Object objExtractWithEmbeddedConfig;
        ContentHints contentHints3;
        ExtractedStream extractedStream;
        int i12;
        Set set4;
        int i13;
        int i14;
        int i15;
        ?? r11;
        Set set5;
        String str10;
        ?? r2;
        Set set6;
        Deferred deferred3;
        long j3;
        int i16;
        int i17;
        DefaultMediaClock defaultMediaClock4;
        int i18;
        Object objExtractWithDiagnostics$extractWithWatchConfig;
        ContentHints contentHints4;
        ExtractedStream extractedStream2;
        ?? r0;
        int i19;
        ExtractedStream extractedStream3;
        String str11;
        long j4;
        Deferred deferred4;
        int i20;
        int i21;
        AudioQuality audioQuality4;
        int i22;
        ?? r18;
        int i23;
        int i24;
        long j5;
        AudioQuality audioQuality5;
        DefaultMediaClock defaultMediaClock5;
        int i25;
        Deferred deferred5;
        Set set7;
        int i26;
        ?? r19;
        DefaultMediaClock defaultMediaClock6;
        Set set8;
        int i27;
        Object objExtractWithConfig$default;
        int i28;
        Object obj2;
        long j6;
        DefaultMediaClock defaultMediaClock7;
        int i29;
        Deferred deferred6;
        int i30;
        ?? r1;
        int i31;
        int i32;
        int i33;
        CoroutineSingletons coroutineSingletons2;
        Set set9;
        String str12;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0;
        int i34;
        CoroutineSingletons coroutineSingletons3;
        AudioQuality audioQuality6;
        int i35;
        Set set10;
        int i36;
        int i37;
        Object objExtractWithDiagnostics$extractWithWatchConfig2;
        String str13;
        int i38;
        ContentHints contentHints5;
        int i39;
        int i40;
        Set set11;
        Object obj3;
        int i41;
        DefaultMediaClock defaultMediaClock8;
        String str14;
        int i42;
        int i43;
        Set set12;
        int i44;
        Object objExtractWithDiagnostics$extractWithWatchConfig3;
        CoroutineSingletons coroutineSingletons4;
        ContentHints contentHints6;
        int i45;
        String str15;
        Set set13;
        int i46;
        int i47;
        Object obj4;
        DefaultMediaClock defaultMediaClock9;
        String str16;
        int i48;
        ExtractedStream extractedStream4;
        ExtractedStream extractedStream5;
        ?? r3;
        String str17;
        AudioQuality audioQuality7;
        String str18;
        Set set14;
        int i49;
        Object obj5;
        int i50;
        Set set15;
        ContentHints contentHints7;
        int i51;
        int i52;
        long j7;
        ExtractedStream extractedStream6;
        ?? r4;
        ContentHints contentHints8;
        DefaultMediaClock defaultMediaClock10;
        Boolean bool;
        Boolean bool2;
        ExtractedStream extractedStream7;
        ExtractedStream extractedStream8;
        DefaultMediaClock defaultMediaClock11 = defaultMediaClock;
        if (continuationImpl instanceof C01211) {
            c01211 = (C01211) continuationImpl;
            int i53 = c01211.label;
            if ((i53 & Integer.MIN_VALUE) != 0) {
                c01211.label = i53 - Integer.MIN_VALUE;
            } else {
                c01211 = new C01211(continuationImpl);
            }
        } else {
            c01211 = new C01211(continuationImpl);
        }
        C01211 c01212 = c01211;
        Object objExtractWithWebKidsFallback = c01212.result;
        int i54 = c01212.label;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1 = this.logger;
        InnerTube innerTube = this.innerTube;
        CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            switch (i54) {
                case 0:
                    ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                    contentHints.getClass();
                    String str19 = contentHints.playbackClientOverrideId;
                    Map mapSingletonMap = Collections.singletonMap("wantVideo", String.valueOf(false));
                    mapSingletonMap.getClass();
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "stream extraction started", mapSingletonMap, 4);
                    if (str19 != null) {
                        PlaybackClientCatalog playbackClientCatalog = PlaybackClientCatalog.INSTANCE;
                        PlaybackClientManifest playbackClientManifestFindManifest = PlaybackClientCatalog.findManifest(str19);
                        if (playbackClientManifestFindManifest == null || !playbackClientManifestFindManifest.request.embedded) {
                            str3 = null;
                        } else {
                            str3 = str19;
                        }
                    } else {
                        str3 = null;
                    }
                    int i55 = str3 != null ? 1 : 0;
                    if (i55 != 0) {
                        c01212.L$0 = null;
                        c01212.L$1 = contentHints;
                        c01212.L$2 = null;
                        c01212.L$3 = null;
                        c01212.L$4 = null;
                        c01212.L$5 = defaultMediaClock11;
                        c01212.L$6 = null;
                        c01212.J$0 = j;
                        c01212.I$0 = i55;
                        c01212.label = 1;
                        objExtractWithEmbeddedConfig = extractWithEmbeddedConfig(str, contentHints, set, str2, j, audioQuality, defaultMediaClock11, c01212);
                        if (objExtractWithEmbeddedConfig == coroutineSingletons5) {
                            return coroutineSingletons5;
                        }
                        contentHints3 = contentHints;
                        extractedStream = (ExtractedStream) objExtractWithEmbeddedConfig;
                        if (extractedStream != null) {
                            return extractedStream;
                        }
                        throwExtractionFailure(contentHints3, defaultMediaClock11);
                        throw null;
                    }
                    if (str19 == null) {
                        Boolean bool3 = contentHints.isExplicit;
                        Boolean bool4 = Boolean.TRUE;
                        if (Intrinsics.areEqual(bool3, bool4) || Intrinsics.areEqual(contentHints.isAgeRestricted, bool4) || Intrinsics.areEqual(contentHints.isUploaded, bool4)) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    } else {
                        i = 0;
                    }
                    if (i == 0 || Intrinsics.areEqual(contentHints.isKidsContent, Boolean.TRUE) || !((str9 = innerTube.sessionSnapshot().visitorData) == null || StringsKt.isBlank(str9))) {
                        i2 = 0;
                    } else {
                        set.getClass();
                        ClientFallbackStrategy clientFallbackStrategy = this.clientDirector.fallbackStrategy;
                        ContentAwareFallbackStrategy contentAwareFallbackStrategy = clientFallbackStrategy instanceof ContentAwareFallbackStrategy ? (ContentAwareFallbackStrategy) clientFallbackStrategy : null;
                        if (contentAwareFallbackStrategy == null || (playbackClientOptionFind = PlaybackClientCatalog.find("VISIONOS_0_1")) == null) {
                            i2 = 0;
                        } else {
                            PlaybackClientManifest playbackClientManifest = playbackClientOptionFind.manifest;
                            if (playbackClientManifest.selectionMode != ClientSelectionMode.PROBE_ONLY || contentAwareFallbackStrategy.isExcluded(playbackClientManifest, set, EmptySet.INSTANCE, false)) {
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                        }
                    }
                    if (i == 0 || i2 != 0) {
                        i3 = i2;
                        pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline1;
                        innerTube = innerTube;
                        str4 = "InnerTubeExtractor";
                        int i56 = i55;
                        i4 = 0;
                        i5 = 1;
                        coroutineSingletons = coroutineSingletons5;
                        str5 = str;
                        contentHints2 = contentHints;
                        set2 = set;
                        audioQuality2 = audioQuality;
                        str6 = str2;
                        j2 = j;
                        defaultMediaClock2 = defaultMediaClock;
                        deferred = deferredCoroutine;
                        i6 = i56;
                        i7 = i;
                        i8 = 0;
                    } else {
                        c01212.L$0 = str;
                        c01212.L$1 = contentHints;
                        c01212.L$2 = set;
                        c01212.L$3 = audioQuality;
                        c01212.L$4 = str2;
                        c01212.L$5 = defaultMediaClock11;
                        c01212.L$6 = deferredCoroutine;
                        c01212.J$0 = j;
                        c01212.I$0 = i55;
                        c01212.I$1 = 0;
                        c01212.I$2 = i;
                        c01212.I$3 = i2;
                        c01212.label = 2;
                        i3 = i2;
                        str4 = "InnerTubeExtractor";
                        int i57 = i55;
                        i4 = 0;
                        coroutineSingletons = coroutineSingletons5;
                        i5 = 1;
                        Object objExtractWithConfig$default2 = extractWithConfig$default(this, str, contentHints, set, str2, new PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null), j, false, audioQuality, defaultMediaClock, null, c01212, 1536);
                        if (objExtractWithConfig$default2 == coroutineSingletons) {
                            c01212 = c01212;
                            return coroutineSingletons;
                        }
                        c01212 = c01212;
                        set3 = set;
                        audioQuality3 = audioQuality;
                        str7 = str2;
                        defaultMediaClock3 = defaultMediaClock;
                        deferred2 = deferredCoroutine;
                        i9 = i57;
                        i10 = i;
                        obj = objExtractWithConfig$default2;
                        i11 = 0;
                        str8 = str;
                        j2 = j;
                        contentHints4 = contentHints;
                        extractedStream2 = (ExtractedStream) obj;
                        if (extractedStream2 != null) {
                            return extractedStream2;
                        }
                        contentHints2 = contentHints4;
                        i7 = i10;
                        i6 = i9;
                        set2 = set3;
                        str6 = str7;
                        i8 = i11;
                        audioQuality2 = audioQuality3;
                        str5 = str8;
                        deferred = deferred2;
                        defaultMediaClock2 = defaultMediaClock3;
                    }
                    i12 = i3;
                    try {
                        try {
                            if (contentHints2.playbackClientOverrideId != null && innerTube.hasSapCookieAuth()) {
                                if (i8 == 0) {
                                    Boolean bool5 = contentHints2.isExplicit;
                                    set4 = set2;
                                    Boolean bool6 = Boolean.TRUE;
                                    if (Intrinsics.areEqual(bool5, bool6) || Intrinsics.areEqual(contentHints2.isAgeRestricted, bool6) || Intrinsics.areEqual(contentHints2.isUploaded, bool6)) {
                                    }
                                    c01212.L$0 = str5;
                                    c01212.L$1 = contentHints2;
                                    c01212.L$2 = set4;
                                    c01212.L$3 = audioQuality2;
                                    c01212.L$4 = str6;
                                    c01212.L$5 = defaultMediaClock2;
                                    c01212.L$6 = deferred;
                                    c01212.J$0 = j2;
                                    c01212.I$0 = i6;
                                    c01212.I$1 = i8;
                                    c01212.I$2 = i7;
                                    c01212.I$3 = i12;
                                    c01212.I$4 = i13;
                                    c01212.label = 3;
                                    i14 = i6;
                                    i15 = i8;
                                    r11 = i13;
                                    set5 = set4;
                                    objExtractWithDiagnostics$extractWithWatchConfig = extractWithDiagnostics$extractWithWatchConfig(this, str5, contentHints2, set5, str6, j2, audioQuality2, defaultMediaClock2, deferred, r11, c01212);
                                    if (objExtractWithDiagnostics$extractWithWatchConfig == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                    str10 = str5;
                                    r2 = r11 == true ? 1 : 0;
                                    set6 = set5;
                                    deferred3 = deferred;
                                    j3 = j2;
                                    i16 = i7;
                                    i17 = i15;
                                    defaultMediaClock4 = defaultMediaClock2;
                                    i18 = i14;
                                    try {
                                        int i58 = i12;
                                        extractedStream3 = (ExtractedStream) objExtractWithDiagnostics$extractWithWatchConfig;
                                        r0 = r2;
                                        str11 = str10;
                                        i19 = i58;
                                    } catch (Exception e) {
                                        e = e;
                                        if (i12 == 0) {
                                            throw e;
                                        }
                                        String str20 = str10;
                                        ((ArrayList) defaultMediaClock4.rendererClockSource).add(e);
                                        r0 = r2;
                                        i19 = i12;
                                        extractedStream3 = null;
                                        str11 = str20;
                                    }
                                    j4 = j3;
                                    deferred4 = deferred3;
                                    i20 = i16;
                                    i21 = i17;
                                    audioQuality4 = audioQuality2;
                                    i22 = i18;
                                    if (extractedStream3 != null) {
                                        return extractedStream3;
                                    }
                                    if (i19 != 0) {
                                        c01212.L$0 = str11;
                                        c01212.L$1 = contentHints2;
                                        c01212.L$2 = set6;
                                        c01212.L$3 = audioQuality4;
                                        c01212.L$4 = str6;
                                        c01212.L$5 = defaultMediaClock4;
                                        c01212.L$6 = deferred4;
                                        c01212.J$0 = j4;
                                        c01212.I$0 = i22;
                                        c01212.I$1 = i21;
                                        c01212.I$2 = i20;
                                        c01212.I$3 = i19;
                                        c01212.I$4 = r0;
                                        c01212.label = 4;
                                        r19 = r0;
                                        C01211 c01213 = c01212;
                                        defaultMediaClock6 = defaultMediaClock4;
                                        i23 = i20;
                                        set8 = set6;
                                        i27 = i19;
                                        objExtractWithConfig$default = extractWithConfig$default(this, str11, contentHints2, set8, str6, new PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null), j4, false, audioQuality4, defaultMediaClock6, null, c01213, 1536);
                                        c01212 = c01213;
                                        if (objExtractWithConfig$default == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        i28 = i27;
                                        obj2 = objExtractWithConfig$default;
                                        j6 = j4;
                                        defaultMediaClock7 = defaultMediaClock6;
                                        i29 = i21;
                                        deferred6 = deferred4;
                                        i30 = i22;
                                        extractedStream4 = (ExtractedStream) obj2;
                                        if (extractedStream4 != null) {
                                            return extractedStream4;
                                        }
                                        set7 = set8;
                                        i26 = i30;
                                        DefaultMediaClock defaultMediaClock12 = defaultMediaClock7;
                                        i24 = i28;
                                        i25 = i29;
                                        j5 = j6;
                                        audioQuality5 = audioQuality4;
                                        deferred5 = deferred6;
                                        defaultMediaClock5 = defaultMediaClock12;
                                        r18 = r19;
                                    } else {
                                        r18 = r0;
                                        i23 = i20;
                                        i24 = i19;
                                        j5 = j4;
                                        audioQuality5 = audioQuality4;
                                        defaultMediaClock5 = defaultMediaClock4;
                                        i25 = i21;
                                        deferred5 = deferred4;
                                        set7 = set6;
                                        i26 = i22;
                                    }
                                    r1 = r18;
                                    i31 = i23;
                                    if (r1 != 0) {
                                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str4, "signed-out watch config fallback", null, 12);
                                        c01212.L$0 = str11;
                                        c01212.L$1 = contentHints2;
                                        c01212.L$2 = set7;
                                        c01212.L$3 = audioQuality5;
                                        c01212.L$4 = str6;
                                        c01212.L$5 = defaultMediaClock5;
                                        c01212.L$6 = null;
                                        c01212.J$0 = j5;
                                        c01212.I$0 = i26;
                                        c01212.I$1 = i25;
                                        c01212.I$2 = i31;
                                        i34 = i24;
                                        c01212.I$3 = i34;
                                        c01212.I$4 = r1 == true ? 1 : 0;
                                        c01212.label = 5;
                                        i43 = i26;
                                        set12 = set7;
                                        i44 = i25;
                                        objExtractWithDiagnostics$extractWithWatchConfig3 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set12, str6, j5, audioQuality5, defaultMediaClock5, deferred5, false, c01212);
                                        coroutineSingletons4 = coroutineSingletons;
                                        if (objExtractWithDiagnostics$extractWithWatchConfig3 == coroutineSingletons4) {
                                            return coroutineSingletons4;
                                        }
                                        contentHints6 = contentHints2;
                                        i45 = i31;
                                        str15 = str11;
                                        set13 = set12;
                                        i46 = i44;
                                        i47 = r1 == true ? 1 : 0;
                                        obj4 = objExtractWithDiagnostics$extractWithWatchConfig3;
                                        audioQuality6 = audioQuality5;
                                        defaultMediaClock9 = defaultMediaClock5;
                                        str16 = str6;
                                        i48 = i43;
                                        extractedStream5 = (ExtractedStream) obj4;
                                        if (extractedStream5 != null) {
                                            return extractedStream5;
                                        }
                                        DefaultMediaClock defaultMediaClock13 = defaultMediaClock9;
                                        i35 = i48;
                                        str6 = str16;
                                        defaultMediaClock5 = defaultMediaClock13;
                                        r3 = i47;
                                        set10 = set13;
                                        str11 = str15;
                                        coroutineSingletons3 = coroutineSingletons4;
                                        i25 = i46;
                                        i36 = i45;
                                        contentHints2 = contentHints6;
                                    } else {
                                        i32 = i26;
                                        i33 = i24;
                                        coroutineSingletons2 = coroutineSingletons;
                                        set9 = set7;
                                        str12 = str4;
                                        pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                                        if (innerTube.hasSapCookieAuth()) {
                                            Map mapSingletonMap2 = Collections.singletonMap("authenticated", "true");
                                            mapSingletonMap2.getClass();
                                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str12, "authenticated watch page retry", mapSingletonMap2, 4);
                                            c01212.L$0 = str11;
                                            c01212.L$1 = contentHints2;
                                            c01212.L$2 = set9;
                                            c01212.L$3 = audioQuality5;
                                            c01212.L$4 = str6;
                                            c01212.L$5 = defaultMediaClock5;
                                            c01212.L$6 = null;
                                            c01212.J$0 = j5;
                                            c01212.I$0 = i32;
                                            c01212.I$1 = i25;
                                            c01212.I$2 = i31;
                                            c01212.I$3 = i33;
                                            c01212.I$4 = r1 == true ? 1 : 0;
                                            c01212.label = 6;
                                            i37 = i25;
                                            coroutineSingletons3 = coroutineSingletons2;
                                            objExtractWithDiagnostics$extractWithWatchConfig2 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set9, str6, j5, audioQuality5, defaultMediaClock5, deferred5, true, c01212);
                                            if (objExtractWithDiagnostics$extractWithWatchConfig2 == coroutineSingletons3) {
                                                return coroutineSingletons3;
                                            }
                                            str13 = str11;
                                            i38 = i33;
                                            contentHints5 = contentHints2;
                                            i39 = i31;
                                            i40 = r1 == true ? 1 : 0;
                                            set11 = set9;
                                            obj3 = objExtractWithDiagnostics$extractWithWatchConfig2;
                                            i41 = i37;
                                            audioQuality6 = audioQuality5;
                                            defaultMediaClock8 = defaultMediaClock5;
                                            str14 = str6;
                                            i42 = i32;
                                            extractedStream6 = (ExtractedStream) obj3;
                                            if (extractedStream6 != null) {
                                                return extractedStream6;
                                            }
                                            DefaultMediaClock defaultMediaClock14 = defaultMediaClock8;
                                            i35 = i42;
                                            str6 = str14;
                                            defaultMediaClock5 = defaultMediaClock14;
                                            r3 = i40;
                                            i25 = i41;
                                            set10 = set11;
                                            i36 = i39;
                                            contentHints2 = contentHints5;
                                            i34 = i38;
                                            str11 = str13;
                                        } else {
                                            i34 = i33;
                                            coroutineSingletons3 = coroutineSingletons2;
                                            audioQuality6 = audioQuality5;
                                            i35 = i32;
                                            set10 = set9;
                                            i36 = i31;
                                            r3 = r1;
                                        }
                                    }
                                    if (contentHints2.playbackClientOverrideId == null || Intrinsics.areEqual(contentHints2.isUploaded, Boolean.TRUE)) {
                                        str17 = str11;
                                        audioQuality7 = audioQuality6;
                                        str18 = str6;
                                        set14 = set10;
                                        r4 = r3;
                                    } else {
                                        c01212.L$0 = str11;
                                        c01212.L$1 = contentHints2;
                                        c01212.L$2 = set10;
                                        c01212.L$3 = audioQuality6;
                                        c01212.L$4 = str6;
                                        c01212.L$5 = defaultMediaClock5;
                                        c01212.L$6 = null;
                                        c01212.J$0 = j5;
                                        c01212.I$0 = i35;
                                        c01212.I$1 = i25;
                                        c01212.I$2 = i36;
                                        c01212.I$3 = i34;
                                        c01212.I$4 = r3 == true ? 1 : 0;
                                        c01212.label = 7;
                                        String str21 = str11;
                                        String str22 = str6;
                                        AudioQuality audioQuality8 = audioQuality6;
                                        Set set16 = set10;
                                        Object objExtractWithEmbeddedConfig2 = extractWithEmbeddedConfig(str21, contentHints2, set16, str22, j5, audioQuality8, defaultMediaClock5, c01212);
                                        str17 = str21;
                                        str18 = str22;
                                        audioQuality7 = audioQuality8;
                                        if (objExtractWithEmbeddedConfig2 == coroutineSingletons3) {
                                            return coroutineSingletons3;
                                        }
                                        i49 = r3 == true ? 1 : 0;
                                        obj5 = objExtractWithEmbeddedConfig2;
                                        i50 = i25;
                                        set15 = set16;
                                        int i59 = i34;
                                        contentHints7 = contentHints2;
                                        i51 = i59;
                                        long j8 = j5;
                                        i52 = i35;
                                        j7 = j8;
                                        extractedStream7 = (ExtractedStream) obj5;
                                        if (extractedStream7 != null) {
                                            return extractedStream7;
                                        }
                                        ContentHints contentHints9 = contentHints7;
                                        i34 = i51;
                                        contentHints2 = contentHints9;
                                        i35 = i52;
                                        j5 = j7;
                                        set14 = set15;
                                        r4 = i49;
                                        i25 = i50;
                                    }
                                    String str23 = str18;
                                    AudioQuality audioQuality9 = audioQuality7;
                                    String str24 = str17;
                                    StreamResolveException.Reason reasonClassifyPlayabilityFailures = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                                    if (contentHints2.playbackClientOverrideId == null && contentHints2.isKidsContent == null) {
                                        bool = contentHints2.isExplicit;
                                        bool2 = Boolean.TRUE;
                                        if (Intrinsics.areEqual(bool, bool2) && !Intrinsics.areEqual(contentHints2.isAgeRestricted, bool2) && !Intrinsics.areEqual(contentHints2.isUploaded, bool2) && reasonClassifyPlayabilityFailures != StreamResolveException.Reason.AGE_RESTRICTED) {
                                            c01212.L$0 = null;
                                            c01212.L$1 = contentHints2;
                                            c01212.L$2 = null;
                                            c01212.L$3 = null;
                                            c01212.L$4 = null;
                                            c01212.L$5 = defaultMediaClock5;
                                            c01212.L$6 = null;
                                            c01212.J$0 = j5;
                                            c01212.I$0 = i35;
                                            c01212.I$1 = i25;
                                            c01212.I$2 = i36;
                                            c01212.I$3 = i34;
                                            c01212.I$4 = r4;
                                            c01212.label = 8;
                                            ContentHints contentHints10 = contentHints2;
                                            DefaultMediaClock defaultMediaClock15 = defaultMediaClock5;
                                            objExtractWithWebKidsFallback = extractWithWebKidsFallback(str24, contentHints10, set14, str23, j5, audioQuality9, defaultMediaClock15, c01212);
                                            contentHints8 = contentHints10;
                                            defaultMediaClock10 = defaultMediaClock15;
                                            if (objExtractWithWebKidsFallback == coroutineSingletons3) {
                                                return coroutineSingletons3;
                                            }
                                            extractedStream8 = (ExtractedStream) objExtractWithWebKidsFallback;
                                            if (extractedStream8 != null) {
                                                return extractedStream8;
                                            }
                                        }
                                        throwExtractionFailure(contentHints8, defaultMediaClock10);
                                        throw null;
                                    }
                                    contentHints8 = contentHints2;
                                    defaultMediaClock10 = defaultMediaClock5;
                                    throwExtractionFailure(contentHints8, defaultMediaClock10);
                                    throw null;
                                }
                                set4 = set2;
                                i13 = i5;
                                c01212.L$0 = str5;
                                c01212.L$1 = contentHints2;
                                c01212.L$2 = set4;
                                c01212.L$3 = audioQuality2;
                                c01212.L$4 = str6;
                                c01212.L$5 = defaultMediaClock2;
                                c01212.L$6 = deferred;
                                c01212.J$0 = j2;
                                c01212.I$0 = i6;
                                c01212.I$1 = i8;
                                c01212.I$2 = i7;
                                c01212.I$3 = i12;
                                c01212.I$4 = i13;
                                c01212.label = 3;
                                i14 = i6;
                                i15 = i8;
                                r11 = i13;
                                set5 = set4;
                                objExtractWithDiagnostics$extractWithWatchConfig = extractWithDiagnostics$extractWithWatchConfig(this, str5, contentHints2, set5, str6, j2, audioQuality2, defaultMediaClock2, deferred, r11, c01212);
                                if (objExtractWithDiagnostics$extractWithWatchConfig == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                str10 = str5;
                                r2 = r11 == true ? 1 : 0;
                                set6 = set5;
                                deferred3 = deferred;
                                j3 = j2;
                                i16 = i7;
                                i17 = i15;
                                defaultMediaClock4 = defaultMediaClock2;
                                i18 = i14;
                                int i510 = i12;
                                extractedStream3 = (ExtractedStream) objExtractWithDiagnostics$extractWithWatchConfig;
                                r0 = r2;
                                str11 = str10;
                                i19 = i510;
                                j4 = j3;
                                deferred4 = deferred3;
                                i20 = i16;
                                i21 = i17;
                                audioQuality4 = audioQuality2;
                                i22 = i18;
                                if (extractedStream3 != null) {
                                    return extractedStream3;
                                }
                                if (i19 != 0) {
                                    c01212.L$0 = str11;
                                    c01212.L$1 = contentHints2;
                                    c01212.L$2 = set6;
                                    c01212.L$3 = audioQuality4;
                                    c01212.L$4 = str6;
                                    c01212.L$5 = defaultMediaClock4;
                                    c01212.L$6 = deferred4;
                                    c01212.J$0 = j4;
                                    c01212.I$0 = i22;
                                    c01212.I$1 = i21;
                                    c01212.I$2 = i20;
                                    c01212.I$3 = i19;
                                    c01212.I$4 = r0;
                                    c01212.label = 4;
                                    r19 = r0;
                                    C01211 c01214 = c01212;
                                    defaultMediaClock6 = defaultMediaClock4;
                                    i23 = i20;
                                    set8 = set6;
                                    i27 = i19;
                                    objExtractWithConfig$default = extractWithConfig$default(this, str11, contentHints2, set8, str6, new PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null), j4, false, audioQuality4, defaultMediaClock6, null, c01214, 1536);
                                    c01212 = c01214;
                                    if (objExtractWithConfig$default == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                    i28 = i27;
                                    obj2 = objExtractWithConfig$default;
                                    j6 = j4;
                                    defaultMediaClock7 = defaultMediaClock6;
                                    i29 = i21;
                                    deferred6 = deferred4;
                                    i30 = i22;
                                    extractedStream4 = (ExtractedStream) obj2;
                                    if (extractedStream4 != null) {
                                        return extractedStream4;
                                    }
                                    set7 = set8;
                                    i26 = i30;
                                    DefaultMediaClock defaultMediaClock16 = defaultMediaClock7;
                                    i24 = i28;
                                    i25 = i29;
                                    j5 = j6;
                                    audioQuality5 = audioQuality4;
                                    deferred5 = deferred6;
                                    defaultMediaClock5 = defaultMediaClock16;
                                    r18 = r19;
                                } else {
                                    r18 = r0;
                                    i23 = i20;
                                    i24 = i19;
                                    j5 = j4;
                                    audioQuality5 = audioQuality4;
                                    defaultMediaClock5 = defaultMediaClock4;
                                    i25 = i21;
                                    deferred5 = deferred4;
                                    set7 = set6;
                                    i26 = i22;
                                }
                                r1 = r18;
                                i31 = i23;
                                if (r1 != 0) {
                                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str4, "signed-out watch config fallback", null, 12);
                                    c01212.L$0 = str11;
                                    c01212.L$1 = contentHints2;
                                    c01212.L$2 = set7;
                                    c01212.L$3 = audioQuality5;
                                    c01212.L$4 = str6;
                                    c01212.L$5 = defaultMediaClock5;
                                    c01212.L$6 = null;
                                    c01212.J$0 = j5;
                                    c01212.I$0 = i26;
                                    c01212.I$1 = i25;
                                    c01212.I$2 = i31;
                                    i34 = i24;
                                    c01212.I$3 = i34;
                                    c01212.I$4 = r1 == true ? 1 : 0;
                                    c01212.label = 5;
                                    i43 = i26;
                                    set12 = set7;
                                    i44 = i25;
                                    objExtractWithDiagnostics$extractWithWatchConfig3 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set12, str6, j5, audioQuality5, defaultMediaClock5, deferred5, false, c01212);
                                    coroutineSingletons4 = coroutineSingletons;
                                    if (objExtractWithDiagnostics$extractWithWatchConfig3 == coroutineSingletons4) {
                                        return coroutineSingletons4;
                                    }
                                    contentHints6 = contentHints2;
                                    i45 = i31;
                                    str15 = str11;
                                    set13 = set12;
                                    i46 = i44;
                                    i47 = r1 == true ? 1 : 0;
                                    obj4 = objExtractWithDiagnostics$extractWithWatchConfig3;
                                    audioQuality6 = audioQuality5;
                                    defaultMediaClock9 = defaultMediaClock5;
                                    str16 = str6;
                                    i48 = i43;
                                    extractedStream5 = (ExtractedStream) obj4;
                                    if (extractedStream5 != null) {
                                        return extractedStream5;
                                    }
                                    DefaultMediaClock defaultMediaClock17 = defaultMediaClock9;
                                    i35 = i48;
                                    str6 = str16;
                                    defaultMediaClock5 = defaultMediaClock17;
                                    r3 = i47;
                                    set10 = set13;
                                    str11 = str15;
                                    coroutineSingletons3 = coroutineSingletons4;
                                    i25 = i46;
                                    i36 = i45;
                                    contentHints2 = contentHints6;
                                } else {
                                    i32 = i26;
                                    i33 = i24;
                                    coroutineSingletons2 = coroutineSingletons;
                                    set9 = set7;
                                    str12 = str4;
                                    pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                                    if (innerTube.hasSapCookieAuth()) {
                                        Map mapSingletonMap3 = Collections.singletonMap("authenticated", "true");
                                        mapSingletonMap3.getClass();
                                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str12, "authenticated watch page retry", mapSingletonMap3, 4);
                                        c01212.L$0 = str11;
                                        c01212.L$1 = contentHints2;
                                        c01212.L$2 = set9;
                                        c01212.L$3 = audioQuality5;
                                        c01212.L$4 = str6;
                                        c01212.L$5 = defaultMediaClock5;
                                        c01212.L$6 = null;
                                        c01212.J$0 = j5;
                                        c01212.I$0 = i32;
                                        c01212.I$1 = i25;
                                        c01212.I$2 = i31;
                                        c01212.I$3 = i33;
                                        c01212.I$4 = r1 == true ? 1 : 0;
                                        c01212.label = 6;
                                        i37 = i25;
                                        coroutineSingletons3 = coroutineSingletons2;
                                        objExtractWithDiagnostics$extractWithWatchConfig2 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set9, str6, j5, audioQuality5, defaultMediaClock5, deferred5, true, c01212);
                                        if (objExtractWithDiagnostics$extractWithWatchConfig2 == coroutineSingletons3) {
                                            return coroutineSingletons3;
                                        }
                                        str13 = str11;
                                        i38 = i33;
                                        contentHints5 = contentHints2;
                                        i39 = i31;
                                        i40 = r1 == true ? 1 : 0;
                                        set11 = set9;
                                        obj3 = objExtractWithDiagnostics$extractWithWatchConfig2;
                                        i41 = i37;
                                        audioQuality6 = audioQuality5;
                                        defaultMediaClock8 = defaultMediaClock5;
                                        str14 = str6;
                                        i42 = i32;
                                        extractedStream6 = (ExtractedStream) obj3;
                                        if (extractedStream6 != null) {
                                            return extractedStream6;
                                        }
                                        DefaultMediaClock defaultMediaClock18 = defaultMediaClock8;
                                        i35 = i42;
                                        str6 = str14;
                                        defaultMediaClock5 = defaultMediaClock18;
                                        r3 = i40;
                                        i25 = i41;
                                        set10 = set11;
                                        i36 = i39;
                                        contentHints2 = contentHints5;
                                        i34 = i38;
                                        str11 = str13;
                                    } else {
                                        i34 = i33;
                                        coroutineSingletons3 = coroutineSingletons2;
                                        audioQuality6 = audioQuality5;
                                        i35 = i32;
                                        set10 = set9;
                                        i36 = i31;
                                        r3 = r1;
                                    }
                                }
                                if (contentHints2.playbackClientOverrideId == null) {
                                }
                                str17 = str11;
                                audioQuality7 = audioQuality6;
                                str18 = str6;
                                set14 = set10;
                                r4 = r3;
                                String str25 = str18;
                                AudioQuality audioQuality10 = audioQuality7;
                                String str26 = str17;
                                StreamResolveException.Reason reasonClassifyPlayabilityFailures2 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                                if (contentHints2.playbackClientOverrideId == null) {
                                    bool = contentHints2.isExplicit;
                                    bool2 = Boolean.TRUE;
                                    if (Intrinsics.areEqual(bool, bool2)) {
                                    }
                                }
                                contentHints8 = contentHints2;
                                defaultMediaClock10 = defaultMediaClock5;
                                throwExtractionFailure(contentHints8, defaultMediaClock10);
                                throw null;
                            }
                            set4 = set2;
                            objExtractWithDiagnostics$extractWithWatchConfig = extractWithDiagnostics$extractWithWatchConfig(this, str5, contentHints2, set5, str6, j2, audioQuality2, defaultMediaClock2, deferred, r11, c01212);
                            if (objExtractWithDiagnostics$extractWithWatchConfig == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            str10 = str5;
                            r2 = r11 == true ? 1 : 0;
                            set6 = set5;
                            deferred3 = deferred;
                            j3 = j2;
                            i16 = i7;
                            i17 = i15;
                            defaultMediaClock4 = defaultMediaClock2;
                            i18 = i14;
                            int i511 = i12;
                            extractedStream3 = (ExtractedStream) objExtractWithDiagnostics$extractWithWatchConfig;
                            r0 = r2;
                            str11 = str10;
                            i19 = i511;
                            j4 = j3;
                            deferred4 = deferred3;
                            i20 = i16;
                            i21 = i17;
                            audioQuality4 = audioQuality2;
                            i22 = i18;
                            if (extractedStream3 != null) {
                                return extractedStream3;
                            }
                            if (i19 != 0) {
                                c01212.L$0 = str11;
                                c01212.L$1 = contentHints2;
                                c01212.L$2 = set6;
                                c01212.L$3 = audioQuality4;
                                c01212.L$4 = str6;
                                c01212.L$5 = defaultMediaClock4;
                                c01212.L$6 = deferred4;
                                c01212.J$0 = j4;
                                c01212.I$0 = i22;
                                c01212.I$1 = i21;
                                c01212.I$2 = i20;
                                c01212.I$3 = i19;
                                c01212.I$4 = r0;
                                c01212.label = 4;
                                r19 = r0;
                                C01211 c01215 = c01212;
                                defaultMediaClock6 = defaultMediaClock4;
                                i23 = i20;
                                set8 = set6;
                                i27 = i19;
                                objExtractWithConfig$default = extractWithConfig$default(this, str11, contentHints2, set8, str6, new PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null), j4, false, audioQuality4, defaultMediaClock6, null, c01215, 1536);
                                c01212 = c01215;
                                if (objExtractWithConfig$default == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                i28 = i27;
                                obj2 = objExtractWithConfig$default;
                                j6 = j4;
                                defaultMediaClock7 = defaultMediaClock6;
                                i29 = i21;
                                deferred6 = deferred4;
                                i30 = i22;
                                extractedStream4 = (ExtractedStream) obj2;
                                if (extractedStream4 != null) {
                                    return extractedStream4;
                                }
                                set7 = set8;
                                i26 = i30;
                                DefaultMediaClock defaultMediaClock19 = defaultMediaClock7;
                                i24 = i28;
                                i25 = i29;
                                j5 = j6;
                                audioQuality5 = audioQuality4;
                                deferred5 = deferred6;
                                defaultMediaClock5 = defaultMediaClock19;
                                r18 = r19;
                            } else {
                                r18 = r0;
                                i23 = i20;
                                i24 = i19;
                                j5 = j4;
                                audioQuality5 = audioQuality4;
                                defaultMediaClock5 = defaultMediaClock4;
                                i25 = i21;
                                deferred5 = deferred4;
                                set7 = set6;
                                i26 = i22;
                            }
                            r1 = r18;
                            i31 = i23;
                            if (r1 != 0) {
                                EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str4, "signed-out watch config fallback", null, 12);
                                c01212.L$0 = str11;
                                c01212.L$1 = contentHints2;
                                c01212.L$2 = set7;
                                c01212.L$3 = audioQuality5;
                                c01212.L$4 = str6;
                                c01212.L$5 = defaultMediaClock5;
                                c01212.L$6 = null;
                                c01212.J$0 = j5;
                                c01212.I$0 = i26;
                                c01212.I$1 = i25;
                                c01212.I$2 = i31;
                                i34 = i24;
                                c01212.I$3 = i34;
                                c01212.I$4 = r1 == true ? 1 : 0;
                                c01212.label = 5;
                                i43 = i26;
                                set12 = set7;
                                i44 = i25;
                                objExtractWithDiagnostics$extractWithWatchConfig3 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set12, str6, j5, audioQuality5, defaultMediaClock5, deferred5, false, c01212);
                                coroutineSingletons4 = coroutineSingletons;
                                if (objExtractWithDiagnostics$extractWithWatchConfig3 == coroutineSingletons4) {
                                    return coroutineSingletons4;
                                }
                                contentHints6 = contentHints2;
                                i45 = i31;
                                str15 = str11;
                                set13 = set12;
                                i46 = i44;
                                i47 = r1 == true ? 1 : 0;
                                obj4 = objExtractWithDiagnostics$extractWithWatchConfig3;
                                audioQuality6 = audioQuality5;
                                defaultMediaClock9 = defaultMediaClock5;
                                str16 = str6;
                                i48 = i43;
                                extractedStream5 = (ExtractedStream) obj4;
                                if (extractedStream5 != null) {
                                    return extractedStream5;
                                }
                                DefaultMediaClock defaultMediaClock110 = defaultMediaClock9;
                                i35 = i48;
                                str6 = str16;
                                defaultMediaClock5 = defaultMediaClock110;
                                r3 = i47;
                                set10 = set13;
                                str11 = str15;
                                coroutineSingletons3 = coroutineSingletons4;
                                i25 = i46;
                                i36 = i45;
                                contentHints2 = contentHints6;
                            } else {
                                i32 = i26;
                                i33 = i24;
                                coroutineSingletons2 = coroutineSingletons;
                                set9 = set7;
                                str12 = str4;
                                pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                                if (innerTube.hasSapCookieAuth()) {
                                    Map mapSingletonMap4 = Collections.singletonMap("authenticated", "true");
                                    mapSingletonMap4.getClass();
                                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str12, "authenticated watch page retry", mapSingletonMap4, 4);
                                    c01212.L$0 = str11;
                                    c01212.L$1 = contentHints2;
                                    c01212.L$2 = set9;
                                    c01212.L$3 = audioQuality5;
                                    c01212.L$4 = str6;
                                    c01212.L$5 = defaultMediaClock5;
                                    c01212.L$6 = null;
                                    c01212.J$0 = j5;
                                    c01212.I$0 = i32;
                                    c01212.I$1 = i25;
                                    c01212.I$2 = i31;
                                    c01212.I$3 = i33;
                                    c01212.I$4 = r1 == true ? 1 : 0;
                                    c01212.label = 6;
                                    i37 = i25;
                                    coroutineSingletons3 = coroutineSingletons2;
                                    objExtractWithDiagnostics$extractWithWatchConfig2 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set9, str6, j5, audioQuality5, defaultMediaClock5, deferred5, true, c01212);
                                    if (objExtractWithDiagnostics$extractWithWatchConfig2 == coroutineSingletons3) {
                                        return coroutineSingletons3;
                                    }
                                    str13 = str11;
                                    i38 = i33;
                                    contentHints5 = contentHints2;
                                    i39 = i31;
                                    i40 = r1 == true ? 1 : 0;
                                    set11 = set9;
                                    obj3 = objExtractWithDiagnostics$extractWithWatchConfig2;
                                    i41 = i37;
                                    audioQuality6 = audioQuality5;
                                    defaultMediaClock8 = defaultMediaClock5;
                                    str14 = str6;
                                    i42 = i32;
                                    extractedStream6 = (ExtractedStream) obj3;
                                    if (extractedStream6 != null) {
                                        return extractedStream6;
                                    }
                                    DefaultMediaClock defaultMediaClock111 = defaultMediaClock8;
                                    i35 = i42;
                                    str6 = str14;
                                    defaultMediaClock5 = defaultMediaClock111;
                                    r3 = i40;
                                    i25 = i41;
                                    set10 = set11;
                                    i36 = i39;
                                    contentHints2 = contentHints5;
                                    i34 = i38;
                                    str11 = str13;
                                } else {
                                    i34 = i33;
                                    coroutineSingletons3 = coroutineSingletons2;
                                    audioQuality6 = audioQuality5;
                                    i35 = i32;
                                    set10 = set9;
                                    i36 = i31;
                                    r3 = r1;
                                }
                            }
                            if (contentHints2.playbackClientOverrideId == null) {
                            }
                            str17 = str11;
                            audioQuality7 = audioQuality6;
                            str18 = str6;
                            set14 = set10;
                            r4 = r3;
                            String str27 = str18;
                            AudioQuality audioQuality11 = audioQuality7;
                            String str28 = str17;
                            StreamResolveException.Reason reasonClassifyPlayabilityFailures3 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                            if (contentHints2.playbackClientOverrideId == null) {
                                bool = contentHints2.isExplicit;
                                bool2 = Boolean.TRUE;
                                if (Intrinsics.areEqual(bool, bool2)) {
                                }
                            }
                            contentHints8 = contentHints2;
                            defaultMediaClock10 = defaultMediaClock5;
                            throwExtractionFailure(contentHints8, defaultMediaClock10);
                            throw null;
                        } catch (Exception e2) {
                            e = e2;
                            str10 = str5;
                            r2 = r11;
                            int i60 = i15;
                            set6 = set5;
                            deferred3 = deferred;
                            j3 = j2;
                            i16 = i7;
                            i17 = i60;
                            defaultMediaClock4 = defaultMediaClock2;
                            i18 = i14;
                            if (i12 == 0) {
                                throw e;
                            }
                            String str29 = str10;
                            ((ArrayList) defaultMediaClock4.rendererClockSource).add(e);
                            r0 = r2;
                            i19 = i12;
                            extractedStream3 = null;
                            str11 = str29;
                            j4 = j3;
                            deferred4 = deferred3;
                            i20 = i16;
                            i21 = i17;
                            audioQuality4 = audioQuality2;
                            i22 = i18;
                            if (extractedStream3 != null) {
                                return extractedStream3;
                            }
                            if (i19 != 0) {
                                c01212.L$0 = str11;
                                c01212.L$1 = contentHints2;
                                c01212.L$2 = set6;
                                c01212.L$3 = audioQuality4;
                                c01212.L$4 = str6;
                                c01212.L$5 = defaultMediaClock4;
                                c01212.L$6 = deferred4;
                                c01212.J$0 = j4;
                                c01212.I$0 = i22;
                                c01212.I$1 = i21;
                                c01212.I$2 = i20;
                                c01212.I$3 = i19;
                                c01212.I$4 = r0;
                                c01212.label = 4;
                                r19 = r0;
                                C01211 c01216 = c01212;
                                defaultMediaClock6 = defaultMediaClock4;
                                i23 = i20;
                                set8 = set6;
                                i27 = i19;
                                objExtractWithConfig$default = extractWithConfig$default(this, str11, contentHints2, set8, str6, new PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null), j4, false, audioQuality4, defaultMediaClock6, null, c01216, 1536);
                                c01212 = c01216;
                                if (objExtractWithConfig$default == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                i28 = i27;
                                obj2 = objExtractWithConfig$default;
                                j6 = j4;
                                defaultMediaClock7 = defaultMediaClock6;
                                i29 = i21;
                                deferred6 = deferred4;
                                i30 = i22;
                                extractedStream4 = (ExtractedStream) obj2;
                                if (extractedStream4 != null) {
                                    return extractedStream4;
                                }
                                set7 = set8;
                                i26 = i30;
                                DefaultMediaClock defaultMediaClock112 = defaultMediaClock7;
                                i24 = i28;
                                i25 = i29;
                                j5 = j6;
                                audioQuality5 = audioQuality4;
                                deferred5 = deferred6;
                                defaultMediaClock5 = defaultMediaClock112;
                                r18 = r19;
                            } else {
                                r18 = r0;
                                i23 = i20;
                                i24 = i19;
                                j5 = j4;
                                audioQuality5 = audioQuality4;
                                defaultMediaClock5 = defaultMediaClock4;
                                i25 = i21;
                                deferred5 = deferred4;
                                set7 = set6;
                                i26 = i22;
                            }
                            r1 = r18;
                            i31 = i23;
                            if (r1 != 0) {
                                EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str4, "signed-out watch config fallback", null, 12);
                                c01212.L$0 = str11;
                                c01212.L$1 = contentHints2;
                                c01212.L$2 = set7;
                                c01212.L$3 = audioQuality5;
                                c01212.L$4 = str6;
                                c01212.L$5 = defaultMediaClock5;
                                c01212.L$6 = null;
                                c01212.J$0 = j5;
                                c01212.I$0 = i26;
                                c01212.I$1 = i25;
                                c01212.I$2 = i31;
                                i34 = i24;
                                c01212.I$3 = i34;
                                c01212.I$4 = r1 == true ? 1 : 0;
                                c01212.label = 5;
                                i43 = i26;
                                set12 = set7;
                                i44 = i25;
                                objExtractWithDiagnostics$extractWithWatchConfig3 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set12, str6, j5, audioQuality5, defaultMediaClock5, deferred5, false, c01212);
                                coroutineSingletons4 = coroutineSingletons;
                                if (objExtractWithDiagnostics$extractWithWatchConfig3 == coroutineSingletons4) {
                                    return coroutineSingletons4;
                                }
                                contentHints6 = contentHints2;
                                i45 = i31;
                                str15 = str11;
                                set13 = set12;
                                i46 = i44;
                                i47 = r1 == true ? 1 : 0;
                                obj4 = objExtractWithDiagnostics$extractWithWatchConfig3;
                                audioQuality6 = audioQuality5;
                                defaultMediaClock9 = defaultMediaClock5;
                                str16 = str6;
                                i48 = i43;
                                extractedStream5 = (ExtractedStream) obj4;
                                if (extractedStream5 != null) {
                                    return extractedStream5;
                                }
                                DefaultMediaClock defaultMediaClock113 = defaultMediaClock9;
                                i35 = i48;
                                str6 = str16;
                                defaultMediaClock5 = defaultMediaClock113;
                                r3 = i47;
                                set10 = set13;
                                str11 = str15;
                                coroutineSingletons3 = coroutineSingletons4;
                                i25 = i46;
                                i36 = i45;
                                contentHints2 = contentHints6;
                            } else {
                                i32 = i26;
                                i33 = i24;
                                coroutineSingletons2 = coroutineSingletons;
                                set9 = set7;
                                str12 = str4;
                                pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                                if (innerTube.hasSapCookieAuth()) {
                                    Map mapSingletonMap5 = Collections.singletonMap("authenticated", "true");
                                    mapSingletonMap5.getClass();
                                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str12, "authenticated watch page retry", mapSingletonMap5, 4);
                                    c01212.L$0 = str11;
                                    c01212.L$1 = contentHints2;
                                    c01212.L$2 = set9;
                                    c01212.L$3 = audioQuality5;
                                    c01212.L$4 = str6;
                                    c01212.L$5 = defaultMediaClock5;
                                    c01212.L$6 = null;
                                    c01212.J$0 = j5;
                                    c01212.I$0 = i32;
                                    c01212.I$1 = i25;
                                    c01212.I$2 = i31;
                                    c01212.I$3 = i33;
                                    c01212.I$4 = r1 == true ? 1 : 0;
                                    c01212.label = 6;
                                    i37 = i25;
                                    coroutineSingletons3 = coroutineSingletons2;
                                    objExtractWithDiagnostics$extractWithWatchConfig2 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set9, str6, j5, audioQuality5, defaultMediaClock5, deferred5, true, c01212);
                                    if (objExtractWithDiagnostics$extractWithWatchConfig2 == coroutineSingletons3) {
                                        return coroutineSingletons3;
                                    }
                                    str13 = str11;
                                    i38 = i33;
                                    contentHints5 = contentHints2;
                                    i39 = i31;
                                    i40 = r1 == true ? 1 : 0;
                                    set11 = set9;
                                    obj3 = objExtractWithDiagnostics$extractWithWatchConfig2;
                                    i41 = i37;
                                    audioQuality6 = audioQuality5;
                                    defaultMediaClock8 = defaultMediaClock5;
                                    str14 = str6;
                                    i42 = i32;
                                    extractedStream6 = (ExtractedStream) obj3;
                                    if (extractedStream6 != null) {
                                        return extractedStream6;
                                    }
                                    DefaultMediaClock defaultMediaClock114 = defaultMediaClock8;
                                    i35 = i42;
                                    str6 = str14;
                                    defaultMediaClock5 = defaultMediaClock114;
                                    r3 = i40;
                                    i25 = i41;
                                    set10 = set11;
                                    i36 = i39;
                                    contentHints2 = contentHints5;
                                    i34 = i38;
                                    str11 = str13;
                                } else {
                                    i34 = i33;
                                    coroutineSingletons3 = coroutineSingletons2;
                                    audioQuality6 = audioQuality5;
                                    i35 = i32;
                                    set10 = set9;
                                    i36 = i31;
                                    r3 = r1;
                                }
                            }
                            if (contentHints2.playbackClientOverrideId == null) {
                            }
                            str17 = str11;
                            audioQuality7 = audioQuality6;
                            str18 = str6;
                            set14 = set10;
                            r4 = r3;
                            String str210 = str18;
                            AudioQuality audioQuality12 = audioQuality7;
                            String str211 = str17;
                            StreamResolveException.Reason reasonClassifyPlayabilityFailures4 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                            if (contentHints2.playbackClientOverrideId == null) {
                                bool = contentHints2.isExplicit;
                                bool2 = Boolean.TRUE;
                                if (Intrinsics.areEqual(bool, bool2)) {
                                }
                            }
                            contentHints8 = contentHints2;
                            defaultMediaClock10 = defaultMediaClock5;
                            throwExtractionFailure(contentHints8, defaultMediaClock10);
                            throw null;
                        }
                        c01212.L$0 = str5;
                        c01212.L$1 = contentHints2;
                        c01212.L$2 = set4;
                        c01212.L$3 = audioQuality2;
                        c01212.L$4 = str6;
                        c01212.L$5 = defaultMediaClock2;
                        c01212.L$6 = deferred;
                        c01212.J$0 = j2;
                        c01212.I$0 = i6;
                        c01212.I$1 = i8;
                        c01212.I$2 = i7;
                        c01212.I$3 = i12;
                        c01212.I$4 = i13;
                        c01212.label = 3;
                        i14 = i6;
                        i15 = i8;
                        r11 = i13;
                        set5 = set4;
                    } catch (Exception e3) {
                        e = e3;
                        i14 = i6;
                        i15 = i8;
                        r11 = i13;
                        set5 = set4;
                    }
                    i13 = i4;
                    break;
                case 1:
                    DefaultMediaClock defaultMediaClock20 = c01212.L$5;
                    Set set17 = c01212.L$2;
                    contentHints3 = c01212.L$1;
                    ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                    defaultMediaClock11 = defaultMediaClock20;
                    objExtractWithEmbeddedConfig = objExtractWithWebKidsFallback;
                    extractedStream = (ExtractedStream) objExtractWithEmbeddedConfig;
                    if (extractedStream != null) {
                        return extractedStream;
                    }
                    throwExtractionFailure(contentHints3, defaultMediaClock11);
                    throw null;
                case 2:
                    int i61 = c01212.I$3;
                    int i62 = c01212.I$2;
                    int i63 = c01212.I$1;
                    int i64 = c01212.I$0;
                    j2 = c01212.J$0;
                    deferred2 = c01212.L$6;
                    defaultMediaClock3 = c01212.L$5;
                    String str30 = c01212.L$4;
                    i4 = 0;
                    audioQuality3 = c01212.L$3;
                    set3 = c01212.L$2;
                    contentHints = c01212.L$1;
                    str8 = c01212.L$0;
                    ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                    i3 = i61;
                    str4 = "InnerTubeExtractor";
                    i5 = 1;
                    i10 = i62;
                    i9 = i64;
                    obj = objExtractWithWebKidsFallback;
                    i11 = i63;
                    str7 = str30;
                    coroutineSingletons = coroutineSingletons5;
                    contentHints4 = contentHints;
                    extractedStream2 = (ExtractedStream) obj;
                    if (extractedStream2 != null) {
                        return extractedStream2;
                    }
                    contentHints2 = contentHints4;
                    i7 = i10;
                    i6 = i9;
                    set2 = set3;
                    str6 = str7;
                    i8 = i11;
                    audioQuality2 = audioQuality3;
                    str5 = str8;
                    deferred = deferred2;
                    defaultMediaClock2 = defaultMediaClock3;
                    i12 = i3;
                    if (contentHints2.playbackClientOverrideId != null) {
                        set4 = set2;
                        i13 = i4;
                    } else {
                        set4 = set2;
                        i13 = i4;
                    }
                    c01212.L$0 = str5;
                    c01212.L$1 = contentHints2;
                    c01212.L$2 = set4;
                    c01212.L$3 = audioQuality2;
                    c01212.L$4 = str6;
                    c01212.L$5 = defaultMediaClock2;
                    c01212.L$6 = deferred;
                    c01212.J$0 = j2;
                    c01212.I$0 = i6;
                    c01212.I$1 = i8;
                    c01212.I$2 = i7;
                    c01212.I$3 = i12;
                    c01212.I$4 = i13;
                    c01212.label = 3;
                    i14 = i6;
                    i15 = i8;
                    r11 = i13;
                    set5 = set4;
                    objExtractWithDiagnostics$extractWithWatchConfig = extractWithDiagnostics$extractWithWatchConfig(this, str5, contentHints2, set5, str6, j2, audioQuality2, defaultMediaClock2, deferred, r11, c01212);
                    if (objExtractWithDiagnostics$extractWithWatchConfig == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    str10 = str5;
                    r2 = r11 == true ? 1 : 0;
                    set6 = set5;
                    deferred3 = deferred;
                    j3 = j2;
                    i16 = i7;
                    i17 = i15;
                    defaultMediaClock4 = defaultMediaClock2;
                    i18 = i14;
                    int i512 = i12;
                    extractedStream3 = (ExtractedStream) objExtractWithDiagnostics$extractWithWatchConfig;
                    r0 = r2;
                    str11 = str10;
                    i19 = i512;
                    j4 = j3;
                    deferred4 = deferred3;
                    i20 = i16;
                    i21 = i17;
                    audioQuality4 = audioQuality2;
                    i22 = i18;
                    if (extractedStream3 != null) {
                        return extractedStream3;
                    }
                    if (i19 != 0) {
                        c01212.L$0 = str11;
                        c01212.L$1 = contentHints2;
                        c01212.L$2 = set6;
                        c01212.L$3 = audioQuality4;
                        c01212.L$4 = str6;
                        c01212.L$5 = defaultMediaClock4;
                        c01212.L$6 = deferred4;
                        c01212.J$0 = j4;
                        c01212.I$0 = i22;
                        c01212.I$1 = i21;
                        c01212.I$2 = i20;
                        c01212.I$3 = i19;
                        c01212.I$4 = r0;
                        c01212.label = 4;
                        r19 = r0;
                        C01211 c01217 = c01212;
                        defaultMediaClock6 = defaultMediaClock4;
                        i23 = i20;
                        set8 = set6;
                        i27 = i19;
                        objExtractWithConfig$default = extractWithConfig$default(this, str11, contentHints2, set8, str6, new PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null), j4, false, audioQuality4, defaultMediaClock6, null, c01217, 1536);
                        c01212 = c01217;
                        if (objExtractWithConfig$default == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        i28 = i27;
                        obj2 = objExtractWithConfig$default;
                        j6 = j4;
                        defaultMediaClock7 = defaultMediaClock6;
                        i29 = i21;
                        deferred6 = deferred4;
                        i30 = i22;
                        extractedStream4 = (ExtractedStream) obj2;
                        if (extractedStream4 != null) {
                            return extractedStream4;
                        }
                        set7 = set8;
                        i26 = i30;
                        DefaultMediaClock defaultMediaClock115 = defaultMediaClock7;
                        i24 = i28;
                        i25 = i29;
                        j5 = j6;
                        audioQuality5 = audioQuality4;
                        deferred5 = deferred6;
                        defaultMediaClock5 = defaultMediaClock115;
                        r18 = r19;
                    } else {
                        r18 = r0;
                        i23 = i20;
                        i24 = i19;
                        j5 = j4;
                        audioQuality5 = audioQuality4;
                        defaultMediaClock5 = defaultMediaClock4;
                        i25 = i21;
                        deferred5 = deferred4;
                        set7 = set6;
                        i26 = i22;
                    }
                    r1 = r18;
                    i31 = i23;
                    if (r1 != 0) {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str4, "signed-out watch config fallback", null, 12);
                        c01212.L$0 = str11;
                        c01212.L$1 = contentHints2;
                        c01212.L$2 = set7;
                        c01212.L$3 = audioQuality5;
                        c01212.L$4 = str6;
                        c01212.L$5 = defaultMediaClock5;
                        c01212.L$6 = null;
                        c01212.J$0 = j5;
                        c01212.I$0 = i26;
                        c01212.I$1 = i25;
                        c01212.I$2 = i31;
                        i34 = i24;
                        c01212.I$3 = i34;
                        c01212.I$4 = r1 == true ? 1 : 0;
                        c01212.label = 5;
                        i43 = i26;
                        set12 = set7;
                        i44 = i25;
                        objExtractWithDiagnostics$extractWithWatchConfig3 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set12, str6, j5, audioQuality5, defaultMediaClock5, deferred5, false, c01212);
                        coroutineSingletons4 = coroutineSingletons;
                        if (objExtractWithDiagnostics$extractWithWatchConfig3 == coroutineSingletons4) {
                            return coroutineSingletons4;
                        }
                        contentHints6 = contentHints2;
                        i45 = i31;
                        str15 = str11;
                        set13 = set12;
                        i46 = i44;
                        i47 = r1 == true ? 1 : 0;
                        obj4 = objExtractWithDiagnostics$extractWithWatchConfig3;
                        audioQuality6 = audioQuality5;
                        defaultMediaClock9 = defaultMediaClock5;
                        str16 = str6;
                        i48 = i43;
                        extractedStream5 = (ExtractedStream) obj4;
                        if (extractedStream5 != null) {
                            return extractedStream5;
                        }
                        DefaultMediaClock defaultMediaClock116 = defaultMediaClock9;
                        i35 = i48;
                        str6 = str16;
                        defaultMediaClock5 = defaultMediaClock116;
                        r3 = i47;
                        set10 = set13;
                        str11 = str15;
                        coroutineSingletons3 = coroutineSingletons4;
                        i25 = i46;
                        i36 = i45;
                        contentHints2 = contentHints6;
                    } else {
                        i32 = i26;
                        i33 = i24;
                        coroutineSingletons2 = coroutineSingletons;
                        set9 = set7;
                        str12 = str4;
                        pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                        if (innerTube.hasSapCookieAuth()) {
                            Map mapSingletonMap6 = Collections.singletonMap("authenticated", "true");
                            mapSingletonMap6.getClass();
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str12, "authenticated watch page retry", mapSingletonMap6, 4);
                            c01212.L$0 = str11;
                            c01212.L$1 = contentHints2;
                            c01212.L$2 = set9;
                            c01212.L$3 = audioQuality5;
                            c01212.L$4 = str6;
                            c01212.L$5 = defaultMediaClock5;
                            c01212.L$6 = null;
                            c01212.J$0 = j5;
                            c01212.I$0 = i32;
                            c01212.I$1 = i25;
                            c01212.I$2 = i31;
                            c01212.I$3 = i33;
                            c01212.I$4 = r1 == true ? 1 : 0;
                            c01212.label = 6;
                            i37 = i25;
                            coroutineSingletons3 = coroutineSingletons2;
                            objExtractWithDiagnostics$extractWithWatchConfig2 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set9, str6, j5, audioQuality5, defaultMediaClock5, deferred5, true, c01212);
                            if (objExtractWithDiagnostics$extractWithWatchConfig2 == coroutineSingletons3) {
                                return coroutineSingletons3;
                            }
                            str13 = str11;
                            i38 = i33;
                            contentHints5 = contentHints2;
                            i39 = i31;
                            i40 = r1 == true ? 1 : 0;
                            set11 = set9;
                            obj3 = objExtractWithDiagnostics$extractWithWatchConfig2;
                            i41 = i37;
                            audioQuality6 = audioQuality5;
                            defaultMediaClock8 = defaultMediaClock5;
                            str14 = str6;
                            i42 = i32;
                            extractedStream6 = (ExtractedStream) obj3;
                            if (extractedStream6 != null) {
                                return extractedStream6;
                            }
                            DefaultMediaClock defaultMediaClock117 = defaultMediaClock8;
                            i35 = i42;
                            str6 = str14;
                            defaultMediaClock5 = defaultMediaClock117;
                            r3 = i40;
                            i25 = i41;
                            set10 = set11;
                            i36 = i39;
                            contentHints2 = contentHints5;
                            i34 = i38;
                            str11 = str13;
                        } else {
                            i34 = i33;
                            coroutineSingletons3 = coroutineSingletons2;
                            audioQuality6 = audioQuality5;
                            i35 = i32;
                            set10 = set9;
                            i36 = i31;
                            r3 = r1;
                        }
                    }
                    if (contentHints2.playbackClientOverrideId == null) {
                        break;
                    }
                    str17 = str11;
                    audioQuality7 = audioQuality6;
                    str18 = str6;
                    set14 = set10;
                    r4 = r3;
                    String str212 = str18;
                    AudioQuality audioQuality13 = audioQuality7;
                    String str213 = str17;
                    StreamResolveException.Reason reasonClassifyPlayabilityFailures5 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                    if (contentHints2.playbackClientOverrideId == null) {
                        bool = contentHints2.isExplicit;
                        bool2 = Boolean.TRUE;
                        if (Intrinsics.areEqual(bool, bool2)) {
                        }
                        break;
                    }
                    contentHints8 = contentHints2;
                    defaultMediaClock10 = defaultMediaClock5;
                    throwExtractionFailure(contentHints8, defaultMediaClock10);
                    throw null;
                case 3:
                    r2 = c01212.I$4;
                    int i65 = c01212.I$3;
                    i16 = c01212.I$2;
                    i17 = c01212.I$1;
                    i18 = c01212.I$0;
                    j3 = c01212.J$0;
                    Deferred deferred7 = c01212.L$6;
                    DefaultMediaClock defaultMediaClock21 = c01212.L$5;
                    String str31 = c01212.L$4;
                    AudioQuality audioQuality14 = c01212.L$3;
                    set6 = c01212.L$2;
                    ContentHints contentHints11 = c01212.L$1;
                    str10 = c01212.L$0;
                    try {
                        ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                        coroutineSingletons = coroutineSingletons5;
                        defaultMediaClock4 = defaultMediaClock21;
                        str4 = "InnerTubeExtractor";
                        pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline1;
                        deferred3 = deferred7;
                        objExtractWithDiagnostics$extractWithWatchConfig = objExtractWithWebKidsFallback;
                        str6 = str31;
                        i12 = i65;
                        innerTube = innerTube;
                        audioQuality2 = audioQuality14;
                        contentHints2 = contentHints11;
                        r2 = r2;
                        int i513 = i12;
                        extractedStream3 = (ExtractedStream) objExtractWithDiagnostics$extractWithWatchConfig;
                        r0 = r2;
                        str11 = str10;
                        i19 = i513;
                    } catch (Exception e4) {
                        e = e4;
                        coroutineSingletons = coroutineSingletons5;
                        defaultMediaClock4 = defaultMediaClock21;
                        str4 = "InnerTubeExtractor";
                        pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline1;
                        innerTube = innerTube;
                        deferred3 = deferred7;
                        str6 = str31;
                        audioQuality2 = audioQuality14;
                        i12 = i65;
                        contentHints2 = contentHints11;
                        if (i12 == 0) {
                            throw e;
                        }
                        String str214 = str10;
                        ((ArrayList) defaultMediaClock4.rendererClockSource).add(e);
                        r0 = r2;
                        i19 = i12;
                        extractedStream3 = null;
                        str11 = str214;
                        j4 = j3;
                        deferred4 = deferred3;
                        i20 = i16;
                        i21 = i17;
                        audioQuality4 = audioQuality2;
                        i22 = i18;
                        if (extractedStream3 != null) {
                            return extractedStream3;
                        }
                        if (i19 != 0) {
                            c01212.L$0 = str11;
                            c01212.L$1 = contentHints2;
                            c01212.L$2 = set6;
                            c01212.L$3 = audioQuality4;
                            c01212.L$4 = str6;
                            c01212.L$5 = defaultMediaClock4;
                            c01212.L$6 = deferred4;
                            c01212.J$0 = j4;
                            c01212.I$0 = i22;
                            c01212.I$1 = i21;
                            c01212.I$2 = i20;
                            c01212.I$3 = i19;
                            c01212.I$4 = r0;
                            c01212.label = 4;
                            r19 = r0;
                            C01211 c01218 = c01212;
                            defaultMediaClock6 = defaultMediaClock4;
                            i23 = i20;
                            set8 = set6;
                            i27 = i19;
                            objExtractWithConfig$default = extractWithConfig$default(this, str11, contentHints2, set8, str6, new PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null), j4, false, audioQuality4, defaultMediaClock6, null, c01218, 1536);
                            c01212 = c01218;
                            if (objExtractWithConfig$default == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            i28 = i27;
                            obj2 = objExtractWithConfig$default;
                            j6 = j4;
                            defaultMediaClock7 = defaultMediaClock6;
                            i29 = i21;
                            deferred6 = deferred4;
                            i30 = i22;
                            extractedStream4 = (ExtractedStream) obj2;
                            if (extractedStream4 != null) {
                                return extractedStream4;
                            }
                            set7 = set8;
                            i26 = i30;
                            DefaultMediaClock defaultMediaClock118 = defaultMediaClock7;
                            i24 = i28;
                            i25 = i29;
                            j5 = j6;
                            audioQuality5 = audioQuality4;
                            deferred5 = deferred6;
                            defaultMediaClock5 = defaultMediaClock118;
                            r18 = r19;
                        } else {
                            r18 = r0;
                            i23 = i20;
                            i24 = i19;
                            j5 = j4;
                            audioQuality5 = audioQuality4;
                            defaultMediaClock5 = defaultMediaClock4;
                            i25 = i21;
                            deferred5 = deferred4;
                            set7 = set6;
                            i26 = i22;
                        }
                        r1 = r18;
                        i31 = i23;
                        if (r1 != 0) {
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str4, "signed-out watch config fallback", null, 12);
                            c01212.L$0 = str11;
                            c01212.L$1 = contentHints2;
                            c01212.L$2 = set7;
                            c01212.L$3 = audioQuality5;
                            c01212.L$4 = str6;
                            c01212.L$5 = defaultMediaClock5;
                            c01212.L$6 = null;
                            c01212.J$0 = j5;
                            c01212.I$0 = i26;
                            c01212.I$1 = i25;
                            c01212.I$2 = i31;
                            i34 = i24;
                            c01212.I$3 = i34;
                            c01212.I$4 = r1 == true ? 1 : 0;
                            c01212.label = 5;
                            i43 = i26;
                            set12 = set7;
                            i44 = i25;
                            objExtractWithDiagnostics$extractWithWatchConfig3 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set12, str6, j5, audioQuality5, defaultMediaClock5, deferred5, false, c01212);
                            coroutineSingletons4 = coroutineSingletons;
                            if (objExtractWithDiagnostics$extractWithWatchConfig3 == coroutineSingletons4) {
                                return coroutineSingletons4;
                            }
                            contentHints6 = contentHints2;
                            i45 = i31;
                            str15 = str11;
                            set13 = set12;
                            i46 = i44;
                            i47 = r1 == true ? 1 : 0;
                            obj4 = objExtractWithDiagnostics$extractWithWatchConfig3;
                            audioQuality6 = audioQuality5;
                            defaultMediaClock9 = defaultMediaClock5;
                            str16 = str6;
                            i48 = i43;
                            extractedStream5 = (ExtractedStream) obj4;
                            if (extractedStream5 != null) {
                                return extractedStream5;
                            }
                            DefaultMediaClock defaultMediaClock119 = defaultMediaClock9;
                            i35 = i48;
                            str6 = str16;
                            defaultMediaClock5 = defaultMediaClock119;
                            r3 = i47;
                            set10 = set13;
                            str11 = str15;
                            coroutineSingletons3 = coroutineSingletons4;
                            i25 = i46;
                            i36 = i45;
                            contentHints2 = contentHints6;
                        } else {
                            i32 = i26;
                            i33 = i24;
                            coroutineSingletons2 = coroutineSingletons;
                            set9 = set7;
                            str12 = str4;
                            pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                            if (innerTube.hasSapCookieAuth()) {
                                Map mapSingletonMap7 = Collections.singletonMap("authenticated", "true");
                                mapSingletonMap7.getClass();
                                EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str12, "authenticated watch page retry", mapSingletonMap7, 4);
                                c01212.L$0 = str11;
                                c01212.L$1 = contentHints2;
                                c01212.L$2 = set9;
                                c01212.L$3 = audioQuality5;
                                c01212.L$4 = str6;
                                c01212.L$5 = defaultMediaClock5;
                                c01212.L$6 = null;
                                c01212.J$0 = j5;
                                c01212.I$0 = i32;
                                c01212.I$1 = i25;
                                c01212.I$2 = i31;
                                c01212.I$3 = i33;
                                c01212.I$4 = r1 == true ? 1 : 0;
                                c01212.label = 6;
                                i37 = i25;
                                coroutineSingletons3 = coroutineSingletons2;
                                objExtractWithDiagnostics$extractWithWatchConfig2 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set9, str6, j5, audioQuality5, defaultMediaClock5, deferred5, true, c01212);
                                if (objExtractWithDiagnostics$extractWithWatchConfig2 == coroutineSingletons3) {
                                    return coroutineSingletons3;
                                }
                                str13 = str11;
                                i38 = i33;
                                contentHints5 = contentHints2;
                                i39 = i31;
                                i40 = r1 == true ? 1 : 0;
                                set11 = set9;
                                obj3 = objExtractWithDiagnostics$extractWithWatchConfig2;
                                i41 = i37;
                                audioQuality6 = audioQuality5;
                                defaultMediaClock8 = defaultMediaClock5;
                                str14 = str6;
                                i42 = i32;
                                extractedStream6 = (ExtractedStream) obj3;
                                if (extractedStream6 != null) {
                                    return extractedStream6;
                                }
                                DefaultMediaClock defaultMediaClock1110 = defaultMediaClock8;
                                i35 = i42;
                                str6 = str14;
                                defaultMediaClock5 = defaultMediaClock1110;
                                r3 = i40;
                                i25 = i41;
                                set10 = set11;
                                i36 = i39;
                                contentHints2 = contentHints5;
                                i34 = i38;
                                str11 = str13;
                            } else {
                                i34 = i33;
                                coroutineSingletons3 = coroutineSingletons2;
                                audioQuality6 = audioQuality5;
                                i35 = i32;
                                set10 = set9;
                                i36 = i31;
                                r3 = r1;
                            }
                        }
                        if (contentHints2.playbackClientOverrideId == null) {
                            break;
                        }
                        str17 = str11;
                        audioQuality7 = audioQuality6;
                        str18 = str6;
                        set14 = set10;
                        r4 = r3;
                        String str215 = str18;
                        AudioQuality audioQuality15 = audioQuality7;
                        String str216 = str17;
                        StreamResolveException.Reason reasonClassifyPlayabilityFailures6 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                        if (contentHints2.playbackClientOverrideId == null) {
                            bool = contentHints2.isExplicit;
                            bool2 = Boolean.TRUE;
                            if (Intrinsics.areEqual(bool, bool2)) {
                            }
                            break;
                        }
                        contentHints8 = contentHints2;
                        defaultMediaClock10 = defaultMediaClock5;
                        throwExtractionFailure(contentHints8, defaultMediaClock10);
                        throw null;
                    }
                    j4 = j3;
                    deferred4 = deferred3;
                    i20 = i16;
                    i21 = i17;
                    audioQuality4 = audioQuality2;
                    i22 = i18;
                    if (extractedStream3 != null) {
                        return extractedStream3;
                    }
                    if (i19 != 0) {
                        c01212.L$0 = str11;
                        c01212.L$1 = contentHints2;
                        c01212.L$2 = set6;
                        c01212.L$3 = audioQuality4;
                        c01212.L$4 = str6;
                        c01212.L$5 = defaultMediaClock4;
                        c01212.L$6 = deferred4;
                        c01212.J$0 = j4;
                        c01212.I$0 = i22;
                        c01212.I$1 = i21;
                        c01212.I$2 = i20;
                        c01212.I$3 = i19;
                        c01212.I$4 = r0;
                        c01212.label = 4;
                        r19 = r0;
                        C01211 c01219 = c01212;
                        defaultMediaClock6 = defaultMediaClock4;
                        i23 = i20;
                        set8 = set6;
                        i27 = i19;
                        objExtractWithConfig$default = extractWithConfig$default(this, str11, contentHints2, set8, str6, new PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null), j4, false, audioQuality4, defaultMediaClock6, null, c01219, 1536);
                        c01212 = c01219;
                        if (objExtractWithConfig$default == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        i28 = i27;
                        obj2 = objExtractWithConfig$default;
                        j6 = j4;
                        defaultMediaClock7 = defaultMediaClock6;
                        i29 = i21;
                        deferred6 = deferred4;
                        i30 = i22;
                        extractedStream4 = (ExtractedStream) obj2;
                        if (extractedStream4 != null) {
                            return extractedStream4;
                        }
                        set7 = set8;
                        i26 = i30;
                        DefaultMediaClock defaultMediaClock1111 = defaultMediaClock7;
                        i24 = i28;
                        i25 = i29;
                        j5 = j6;
                        audioQuality5 = audioQuality4;
                        deferred5 = deferred6;
                        defaultMediaClock5 = defaultMediaClock1111;
                        r18 = r19;
                    } else {
                        r18 = r0;
                        i23 = i20;
                        i24 = i19;
                        j5 = j4;
                        audioQuality5 = audioQuality4;
                        defaultMediaClock5 = defaultMediaClock4;
                        i25 = i21;
                        deferred5 = deferred4;
                        set7 = set6;
                        i26 = i22;
                    }
                    r1 = r18;
                    i31 = i23;
                    if (r1 != 0) {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str4, "signed-out watch config fallback", null, 12);
                        c01212.L$0 = str11;
                        c01212.L$1 = contentHints2;
                        c01212.L$2 = set7;
                        c01212.L$3 = audioQuality5;
                        c01212.L$4 = str6;
                        c01212.L$5 = defaultMediaClock5;
                        c01212.L$6 = null;
                        c01212.J$0 = j5;
                        c01212.I$0 = i26;
                        c01212.I$1 = i25;
                        c01212.I$2 = i31;
                        i34 = i24;
                        c01212.I$3 = i34;
                        c01212.I$4 = r1 == true ? 1 : 0;
                        c01212.label = 5;
                        i43 = i26;
                        set12 = set7;
                        i44 = i25;
                        objExtractWithDiagnostics$extractWithWatchConfig3 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set12, str6, j5, audioQuality5, defaultMediaClock5, deferred5, false, c01212);
                        coroutineSingletons4 = coroutineSingletons;
                        if (objExtractWithDiagnostics$extractWithWatchConfig3 == coroutineSingletons4) {
                            return coroutineSingletons4;
                        }
                        contentHints6 = contentHints2;
                        i45 = i31;
                        str15 = str11;
                        set13 = set12;
                        i46 = i44;
                        i47 = r1 == true ? 1 : 0;
                        obj4 = objExtractWithDiagnostics$extractWithWatchConfig3;
                        audioQuality6 = audioQuality5;
                        defaultMediaClock9 = defaultMediaClock5;
                        str16 = str6;
                        i48 = i43;
                        extractedStream5 = (ExtractedStream) obj4;
                        if (extractedStream5 != null) {
                            return extractedStream5;
                        }
                        DefaultMediaClock defaultMediaClock1112 = defaultMediaClock9;
                        i35 = i48;
                        str6 = str16;
                        defaultMediaClock5 = defaultMediaClock1112;
                        r3 = i47;
                        set10 = set13;
                        str11 = str15;
                        coroutineSingletons3 = coroutineSingletons4;
                        i25 = i46;
                        i36 = i45;
                        contentHints2 = contentHints6;
                    } else {
                        i32 = i26;
                        i33 = i24;
                        coroutineSingletons2 = coroutineSingletons;
                        set9 = set7;
                        str12 = str4;
                        pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                        if (innerTube.hasSapCookieAuth()) {
                            Map mapSingletonMap8 = Collections.singletonMap("authenticated", "true");
                            mapSingletonMap8.getClass();
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str12, "authenticated watch page retry", mapSingletonMap8, 4);
                            c01212.L$0 = str11;
                            c01212.L$1 = contentHints2;
                            c01212.L$2 = set9;
                            c01212.L$3 = audioQuality5;
                            c01212.L$4 = str6;
                            c01212.L$5 = defaultMediaClock5;
                            c01212.L$6 = null;
                            c01212.J$0 = j5;
                            c01212.I$0 = i32;
                            c01212.I$1 = i25;
                            c01212.I$2 = i31;
                            c01212.I$3 = i33;
                            c01212.I$4 = r1 == true ? 1 : 0;
                            c01212.label = 6;
                            i37 = i25;
                            coroutineSingletons3 = coroutineSingletons2;
                            objExtractWithDiagnostics$extractWithWatchConfig2 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set9, str6, j5, audioQuality5, defaultMediaClock5, deferred5, true, c01212);
                            if (objExtractWithDiagnostics$extractWithWatchConfig2 == coroutineSingletons3) {
                                return coroutineSingletons3;
                            }
                            str13 = str11;
                            i38 = i33;
                            contentHints5 = contentHints2;
                            i39 = i31;
                            i40 = r1 == true ? 1 : 0;
                            set11 = set9;
                            obj3 = objExtractWithDiagnostics$extractWithWatchConfig2;
                            i41 = i37;
                            audioQuality6 = audioQuality5;
                            defaultMediaClock8 = defaultMediaClock5;
                            str14 = str6;
                            i42 = i32;
                            extractedStream6 = (ExtractedStream) obj3;
                            if (extractedStream6 != null) {
                                return extractedStream6;
                            }
                            DefaultMediaClock defaultMediaClock1113 = defaultMediaClock8;
                            i35 = i42;
                            str6 = str14;
                            defaultMediaClock5 = defaultMediaClock1113;
                            r3 = i40;
                            i25 = i41;
                            set10 = set11;
                            i36 = i39;
                            contentHints2 = contentHints5;
                            i34 = i38;
                            str11 = str13;
                        } else {
                            i34 = i33;
                            coroutineSingletons3 = coroutineSingletons2;
                            audioQuality6 = audioQuality5;
                            i35 = i32;
                            set10 = set9;
                            i36 = i31;
                            r3 = r1;
                        }
                    }
                    if (contentHints2.playbackClientOverrideId == null) {
                        break;
                    }
                    str17 = str11;
                    audioQuality7 = audioQuality6;
                    str18 = str6;
                    set14 = set10;
                    r4 = r3;
                    String str217 = str18;
                    AudioQuality audioQuality16 = audioQuality7;
                    String str218 = str17;
                    StreamResolveException.Reason reasonClassifyPlayabilityFailures7 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                    if (contentHints2.playbackClientOverrideId == null) {
                        bool = contentHints2.isExplicit;
                        bool2 = Boolean.TRUE;
                        if (Intrinsics.areEqual(bool, bool2)) {
                        }
                        break;
                    }
                    contentHints8 = contentHints2;
                    defaultMediaClock10 = defaultMediaClock5;
                    throwExtractionFailure(contentHints8, defaultMediaClock10);
                    throw null;
                case 4:
                    int i66 = c01212.I$4;
                    int i67 = c01212.I$3;
                    int i68 = c01212.I$2;
                    i29 = c01212.I$1;
                    i30 = c01212.I$0;
                    long j9 = c01212.J$0;
                    deferred6 = c01212.L$6;
                    defaultMediaClock7 = c01212.L$5;
                    String str32 = c01212.L$4;
                    AudioQuality audioQuality17 = c01212.L$3;
                    Set set18 = c01212.L$2;
                    ContentHints contentHints12 = c01212.L$1;
                    String str33 = c01212.L$0;
                    ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                    r19 = i66;
                    i28 = i67;
                    i23 = i68;
                    str4 = "InnerTubeExtractor";
                    pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline1;
                    str6 = str32;
                    set8 = set18;
                    contentHints2 = contentHints12;
                    str11 = str33;
                    coroutineSingletons = coroutineSingletons5;
                    obj2 = objExtractWithWebKidsFallback;
                    innerTube = innerTube;
                    j6 = j9;
                    audioQuality4 = audioQuality17;
                    extractedStream4 = (ExtractedStream) obj2;
                    if (extractedStream4 != null) {
                        return extractedStream4;
                    }
                    set7 = set8;
                    i26 = i30;
                    DefaultMediaClock defaultMediaClock1114 = defaultMediaClock7;
                    i24 = i28;
                    i25 = i29;
                    j5 = j6;
                    audioQuality5 = audioQuality4;
                    deferred5 = deferred6;
                    defaultMediaClock5 = defaultMediaClock1114;
                    r18 = r19;
                    r1 = r18;
                    i31 = i23;
                    if (r1 != 0) {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str4, "signed-out watch config fallback", null, 12);
                        c01212.L$0 = str11;
                        c01212.L$1 = contentHints2;
                        c01212.L$2 = set7;
                        c01212.L$3 = audioQuality5;
                        c01212.L$4 = str6;
                        c01212.L$5 = defaultMediaClock5;
                        c01212.L$6 = null;
                        c01212.J$0 = j5;
                        c01212.I$0 = i26;
                        c01212.I$1 = i25;
                        c01212.I$2 = i31;
                        i34 = i24;
                        c01212.I$3 = i34;
                        c01212.I$4 = r1 == true ? 1 : 0;
                        c01212.label = 5;
                        i43 = i26;
                        set12 = set7;
                        i44 = i25;
                        objExtractWithDiagnostics$extractWithWatchConfig3 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set12, str6, j5, audioQuality5, defaultMediaClock5, deferred5, false, c01212);
                        coroutineSingletons4 = coroutineSingletons;
                        if (objExtractWithDiagnostics$extractWithWatchConfig3 == coroutineSingletons4) {
                            return coroutineSingletons4;
                        }
                        contentHints6 = contentHints2;
                        i45 = i31;
                        str15 = str11;
                        set13 = set12;
                        i46 = i44;
                        i47 = r1 == true ? 1 : 0;
                        obj4 = objExtractWithDiagnostics$extractWithWatchConfig3;
                        audioQuality6 = audioQuality5;
                        defaultMediaClock9 = defaultMediaClock5;
                        str16 = str6;
                        i48 = i43;
                        extractedStream5 = (ExtractedStream) obj4;
                        if (extractedStream5 != null) {
                            return extractedStream5;
                        }
                        DefaultMediaClock defaultMediaClock1115 = defaultMediaClock9;
                        i35 = i48;
                        str6 = str16;
                        defaultMediaClock5 = defaultMediaClock1115;
                        r3 = i47;
                        set10 = set13;
                        str11 = str15;
                        coroutineSingletons3 = coroutineSingletons4;
                        i25 = i46;
                        i36 = i45;
                        contentHints2 = contentHints6;
                    } else {
                        i32 = i26;
                        i33 = i24;
                        coroutineSingletons2 = coroutineSingletons;
                        set9 = set7;
                        str12 = str4;
                        pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                        if (innerTube.hasSapCookieAuth()) {
                            Map mapSingletonMap9 = Collections.singletonMap("authenticated", "true");
                            mapSingletonMap9.getClass();
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str12, "authenticated watch page retry", mapSingletonMap9, 4);
                            c01212.L$0 = str11;
                            c01212.L$1 = contentHints2;
                            c01212.L$2 = set9;
                            c01212.L$3 = audioQuality5;
                            c01212.L$4 = str6;
                            c01212.L$5 = defaultMediaClock5;
                            c01212.L$6 = null;
                            c01212.J$0 = j5;
                            c01212.I$0 = i32;
                            c01212.I$1 = i25;
                            c01212.I$2 = i31;
                            c01212.I$3 = i33;
                            c01212.I$4 = r1 == true ? 1 : 0;
                            c01212.label = 6;
                            i37 = i25;
                            coroutineSingletons3 = coroutineSingletons2;
                            objExtractWithDiagnostics$extractWithWatchConfig2 = extractWithDiagnostics$extractWithWatchConfig(this, str11, contentHints2, set9, str6, j5, audioQuality5, defaultMediaClock5, deferred5, true, c01212);
                            if (objExtractWithDiagnostics$extractWithWatchConfig2 == coroutineSingletons3) {
                                return coroutineSingletons3;
                            }
                            str13 = str11;
                            i38 = i33;
                            contentHints5 = contentHints2;
                            i39 = i31;
                            i40 = r1 == true ? 1 : 0;
                            set11 = set9;
                            obj3 = objExtractWithDiagnostics$extractWithWatchConfig2;
                            i41 = i37;
                            audioQuality6 = audioQuality5;
                            defaultMediaClock8 = defaultMediaClock5;
                            str14 = str6;
                            i42 = i32;
                            extractedStream6 = (ExtractedStream) obj3;
                            if (extractedStream6 != null) {
                                return extractedStream6;
                            }
                            DefaultMediaClock defaultMediaClock1116 = defaultMediaClock8;
                            i35 = i42;
                            str6 = str14;
                            defaultMediaClock5 = defaultMediaClock1116;
                            r3 = i40;
                            i25 = i41;
                            set10 = set11;
                            i36 = i39;
                            contentHints2 = contentHints5;
                            i34 = i38;
                            str11 = str13;
                        } else {
                            i34 = i33;
                            coroutineSingletons3 = coroutineSingletons2;
                            audioQuality6 = audioQuality5;
                            i35 = i32;
                            set10 = set9;
                            i36 = i31;
                            r3 = r1;
                        }
                    }
                    if (contentHints2.playbackClientOverrideId == null) {
                        break;
                    }
                    str17 = str11;
                    audioQuality7 = audioQuality6;
                    str18 = str6;
                    set14 = set10;
                    r4 = r3;
                    String str219 = str18;
                    AudioQuality audioQuality18 = audioQuality7;
                    String str2110 = str17;
                    StreamResolveException.Reason reasonClassifyPlayabilityFailures8 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                    if (contentHints2.playbackClientOverrideId == null) {
                        bool = contentHints2.isExplicit;
                        bool2 = Boolean.TRUE;
                        if (Intrinsics.areEqual(bool, bool2)) {
                        }
                        break;
                    }
                    contentHints8 = contentHints2;
                    defaultMediaClock10 = defaultMediaClock5;
                    throwExtractionFailure(contentHints8, defaultMediaClock10);
                    throw null;
                case 5:
                    int i69 = c01212.I$4;
                    int i70 = c01212.I$3;
                    i45 = c01212.I$2;
                    i46 = c01212.I$1;
                    i48 = c01212.I$0;
                    j5 = c01212.J$0;
                    defaultMediaClock9 = c01212.L$5;
                    str16 = c01212.L$4;
                    audioQuality6 = c01212.L$3;
                    set13 = c01212.L$2;
                    ContentHints contentHints13 = c01212.L$1;
                    str15 = c01212.L$0;
                    ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                    coroutineSingletons4 = coroutineSingletons5;
                    contentHints6 = contentHints13;
                    i34 = i70;
                    i47 = i69;
                    obj4 = objExtractWithWebKidsFallback;
                    extractedStream5 = (ExtractedStream) obj4;
                    if (extractedStream5 != null) {
                        return extractedStream5;
                    }
                    DefaultMediaClock defaultMediaClock1117 = defaultMediaClock9;
                    i35 = i48;
                    str6 = str16;
                    defaultMediaClock5 = defaultMediaClock1117;
                    r3 = i47;
                    set10 = set13;
                    str11 = str15;
                    coroutineSingletons3 = coroutineSingletons4;
                    i25 = i46;
                    i36 = i45;
                    contentHints2 = contentHints6;
                    if (contentHints2.playbackClientOverrideId == null) {
                        break;
                    }
                    str17 = str11;
                    audioQuality7 = audioQuality6;
                    str18 = str6;
                    set14 = set10;
                    r4 = r3;
                    String str2111 = str18;
                    AudioQuality audioQuality19 = audioQuality7;
                    String str2112 = str17;
                    StreamResolveException.Reason reasonClassifyPlayabilityFailures9 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                    if (contentHints2.playbackClientOverrideId == null) {
                        bool = contentHints2.isExplicit;
                        bool2 = Boolean.TRUE;
                        if (Intrinsics.areEqual(bool, bool2)) {
                        }
                        break;
                    }
                    contentHints8 = contentHints2;
                    defaultMediaClock10 = defaultMediaClock5;
                    throwExtractionFailure(contentHints8, defaultMediaClock10);
                    throw null;
                case 6:
                    int i71 = c01212.I$4;
                    i38 = c01212.I$3;
                    i39 = c01212.I$2;
                    i41 = c01212.I$1;
                    i42 = c01212.I$0;
                    j5 = c01212.J$0;
                    defaultMediaClock8 = c01212.L$5;
                    str14 = c01212.L$4;
                    audioQuality6 = c01212.L$3;
                    set11 = c01212.L$2;
                    contentHints5 = c01212.L$1;
                    String str34 = c01212.L$0;
                    ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                    coroutineSingletons3 = coroutineSingletons5;
                    str13 = str34;
                    i40 = i71;
                    obj3 = objExtractWithWebKidsFallback;
                    extractedStream6 = (ExtractedStream) obj3;
                    if (extractedStream6 != null) {
                        return extractedStream6;
                    }
                    DefaultMediaClock defaultMediaClock1118 = defaultMediaClock8;
                    i35 = i42;
                    str6 = str14;
                    defaultMediaClock5 = defaultMediaClock1118;
                    r3 = i40;
                    i25 = i41;
                    set10 = set11;
                    i36 = i39;
                    contentHints2 = contentHints5;
                    i34 = i38;
                    str11 = str13;
                    if (contentHints2.playbackClientOverrideId == null) {
                        break;
                    }
                    str17 = str11;
                    audioQuality7 = audioQuality6;
                    str18 = str6;
                    set14 = set10;
                    r4 = r3;
                    String str2113 = str18;
                    AudioQuality audioQuality110 = audioQuality7;
                    String str2114 = str17;
                    StreamResolveException.Reason reasonClassifyPlayabilityFailures10 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                    if (contentHints2.playbackClientOverrideId == null) {
                        bool = contentHints2.isExplicit;
                        bool2 = Boolean.TRUE;
                        if (Intrinsics.areEqual(bool, bool2)) {
                        }
                        break;
                    }
                    contentHints8 = contentHints2;
                    defaultMediaClock10 = defaultMediaClock5;
                    throwExtractionFailure(contentHints8, defaultMediaClock10);
                    throw null;
                case 7:
                    i49 = c01212.I$4;
                    i51 = c01212.I$3;
                    i36 = c01212.I$2;
                    i50 = c01212.I$1;
                    i52 = c01212.I$0;
                    j7 = c01212.J$0;
                    defaultMediaClock5 = c01212.L$5;
                    str18 = c01212.L$4;
                    audioQuality7 = c01212.L$3;
                    Set set19 = c01212.L$2;
                    contentHints7 = c01212.L$1;
                    String str35 = c01212.L$0;
                    ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                    set15 = set19;
                    coroutineSingletons3 = coroutineSingletons5;
                    str17 = str35;
                    obj5 = objExtractWithWebKidsFallback;
                    extractedStream7 = (ExtractedStream) obj5;
                    if (extractedStream7 != null) {
                        return extractedStream7;
                    }
                    ContentHints contentHints14 = contentHints7;
                    i34 = i51;
                    contentHints2 = contentHints14;
                    i35 = i52;
                    j5 = j7;
                    set14 = set15;
                    r4 = i49;
                    i25 = i50;
                    String str2115 = str18;
                    AudioQuality audioQuality111 = audioQuality7;
                    String str2116 = str17;
                    StreamResolveException.Reason reasonClassifyPlayabilityFailures11 = EntryPoints.classifyPlayabilityFailures((ArrayList) defaultMediaClock5.listener);
                    if (contentHints2.playbackClientOverrideId == null) {
                        bool = contentHints2.isExplicit;
                        bool2 = Boolean.TRUE;
                        if (Intrinsics.areEqual(bool, bool2)) {
                        }
                        break;
                    }
                    contentHints8 = contentHints2;
                    defaultMediaClock10 = defaultMediaClock5;
                    throwExtractionFailure(contentHints8, defaultMediaClock10);
                    throw null;
                case 8:
                    defaultMediaClock10 = c01212.L$5;
                    Set set20 = c01212.L$2;
                    contentHints8 = c01212.L$1;
                    ResultKt.throwOnFailure(objExtractWithWebKidsFallback);
                    extractedStream8 = (ExtractedStream) objExtractWithWebKidsFallback;
                    if (extractedStream8 != null) {
                        return extractedStream8;
                    }
                    throwExtractionFailure(contentHints8, defaultMediaClock10);
                    throw null;
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (CancellationException e5) {
            throw e5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x010b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0164  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object extractWithEmbeddedConfig(String str, ContentHints contentHints, Set set, String str2, long j, AudioQuality audioQuality, DefaultMediaClock defaultMediaClock, ContinuationImpl continuationImpl) throws IOException {
        C01221 c01221;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0;
        DefaultMediaClock defaultMediaClock2;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1;
        String str3;
        long j2;
        DefaultMediaClock defaultMediaClock3;
        AudioQuality audioQuality2;
        long j3;
        String str4;
        Set set2;
        Object obj;
        ContentHints contentHints2;
        String simpleName;
        String str5;
        ClientRequestCapabilities clientRequestCapabilities;
        if (continuationImpl instanceof C01221) {
            c01221 = (C01221) continuationImpl;
            int i = c01221.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01221.label = i - Integer.MIN_VALUE;
            } else {
                c01221 = new C01221(continuationImpl);
            }
        } else {
            c01221 = new C01221(continuationImpl);
        }
        C01221 c01222 = c01221;
        Object obj2 = c01222.result;
        int i2 = c01222.label;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline2 = this.logger;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Set set3 = c01222.L$2;
                    ResultKt.throwOnFailure(obj2);
                    return obj2;
                }
                long j4 = c01222.J$1;
                pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline2;
                long j5 = c01222.J$0;
                DefaultMediaClock defaultMediaClock4 = c01222.L$5;
                AudioQuality audioQuality3 = c01222.L$4;
                String str6 = c01222.L$3;
                Set set4 = c01222.L$2;
                ContentHints contentHints3 = c01222.L$1;
                String str7 = c01222.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    defaultMediaClock3 = defaultMediaClock4;
                    j2 = j4;
                    pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline0;
                    set2 = set4;
                    str3 = str7;
                    j3 = j5;
                    str4 = str6;
                    obj = obj2;
                    contentHints2 = contentHints3;
                    audioQuality2 = audioQuality3;
                    try {
                        PlayerConfig playerConfig = (PlayerConfig) obj;
                        str5 = playerConfig.encryptedHostFlags;
                        if (str5 != null || StringsKt.isBlank(str5)) {
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "embedded config missing encrypted host flags", null, 12);
                            return null;
                        }
                        if (playerConfig.signatureTimestamp == null) {
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "embedded config missing signature timestamp", null, 12);
                            return null;
                        }
                        Map mapSingletonMap = Collections.singletonMap("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j2));
                        mapSingletonMap.getClass();
                        Set set5 = set2;
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "embedded config ready", mapSingletonMap, 4);
                        String str8 = contentHints2.playbackClientOverrideId;
                        if (str8 != null) {
                            PlaybackClientCatalog playbackClientCatalog = PlaybackClientCatalog.INSTANCE;
                            PlaybackClientManifest playbackClientManifestFindManifest = PlaybackClientCatalog.findManifest(str8);
                            if (playbackClientManifestFindManifest == null || (clientRequestCapabilities = playbackClientManifestFindManifest.request) == null || !clientRequestCapabilities.embedded) {
                                str8 = null;
                            }
                            if (str8 == null) {
                                str8 = "WEB_EMBEDDED_PLAYER";
                            }
                        } else {
                            str8 = "WEB_EMBEDDED_PLAYER";
                        }
                        ContentHints contentHintsCopy$default = ContentHints.copy$default(contentHints2, null, str8, 1787);
                        c01222.L$0 = null;
                        c01222.L$1 = null;
                        c01222.L$2 = null;
                        c01222.L$3 = null;
                        c01222.L$4 = null;
                        c01222.L$5 = null;
                        c01222.J$0 = j3;
                        c01222.J$1 = j2;
                        c01222.label = 2;
                        Object objExtractWithConfig$default = extractWithConfig$default(this, str3, contentHintsCopy$default, set5, str4, playerConfig, j3, false, audioQuality2, defaultMediaClock3, null, c01222, 1600);
                        return objExtractWithConfig$default == coroutineSingletons ? coroutineSingletons : objExtractWithConfig$default;
                    } catch (Exception e) {
                        e = e;
                        defaultMediaClock2 = defaultMediaClock3;
                        ((ArrayList) defaultMediaClock2.rendererClockSource).add(e);
                        simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                        if (simpleName == null) {
                            simpleName = "unknown";
                        }
                        Map mapSingletonMap2 = Collections.singletonMap("exceptionType", simpleName);
                        mapSingletonMap2.getClass();
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "embedded config unavailable", mapSingletonMap2, 4);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    defaultMediaClock2 = defaultMediaClock4;
                    pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline0;
                    ((ArrayList) defaultMediaClock2.rendererClockSource).add(e);
                    simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                    if (simpleName == null) {
                        simpleName = "unknown";
                    }
                    Map mapSingletonMap3 = Collections.singletonMap("exceptionType", simpleName);
                    mapSingletonMap3.getClass();
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "embedded config unavailable", mapSingletonMap3, 4);
                    return null;
                }
            }
            pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline2;
            ResultKt.throwOnFailure(obj2);
            long epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
            try {
                FileLock fileLock = this.configParser;
                c01222.L$0 = str;
                c01222.L$1 = contentHints;
                c01222.L$2 = set;
                c01222.L$3 = str2;
                c01222.L$4 = audioQuality;
                defaultMediaClock2 = defaultMediaClock;
                try {
                    c01222.L$5 = defaultMediaClock2;
                    try {
                        c01222.J$0 = j;
                        c01222.J$1 = epochMilliseconds;
                        c01222.label = 1;
                        Object objFetchEmbeddedConfig = ((YtConfigParserImpl) fileLock.lockFilename).fetchEmbeddedConfig(str, c01222);
                        if (objFetchEmbeddedConfig != coroutineSingletons) {
                            str3 = str;
                            j2 = epochMilliseconds;
                            defaultMediaClock3 = defaultMediaClock2;
                            pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline0;
                            audioQuality2 = audioQuality;
                            j3 = j;
                            str4 = str2;
                            set2 = set;
                            obj = objFetchEmbeddedConfig;
                            contentHints2 = contentHints;
                            PlayerConfig playerConfig2 = (PlayerConfig) obj;
                            str5 = playerConfig2.encryptedHostFlags;
                            if (str5 != null) {
                            }
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "embedded config missing encrypted host flags", null, 12);
                            return null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline0;
                        ((ArrayList) defaultMediaClock2.rendererClockSource).add(e);
                        simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                        if (simpleName == null) {
                            simpleName = "unknown";
                        }
                        Map mapSingletonMap4 = Collections.singletonMap("exceptionType", simpleName);
                        mapSingletonMap4.getClass();
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "embedded config unavailable", mapSingletonMap4, 4);
                        return null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline0;
                    ((ArrayList) defaultMediaClock2.rendererClockSource).add(e);
                    simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                    if (simpleName == null) {
                        simpleName = "unknown";
                    }
                    Map mapSingletonMap5 = Collections.singletonMap("exceptionType", simpleName);
                    mapSingletonMap5.getClass();
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "embedded config unavailable", mapSingletonMap5, 4);
                    return null;
                }
            } catch (Exception e5) {
                e = e5;
                defaultMediaClock2 = defaultMediaClock;
            }
        } catch (CancellationException e6) {
            throw e6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object extractWithWebKidsFallback(String str, ContentHints contentHints, Set set, String str2, long j, AudioQuality audioQuality, DefaultMediaClock defaultMediaClock, ContinuationImpl continuationImpl) throws IOException {
        C01231 c01231;
        ContentHints contentHints2;
        DefaultMediaClock defaultMediaClock2;
        long j2;
        String str3;
        AudioQuality audioQuality2;
        Set set2;
        Object obj;
        String str4;
        PlayerConfig playerConfig;
        if (continuationImpl instanceof C01231) {
            c01231 = (C01231) continuationImpl;
            int i = c01231.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01231.label = i - Integer.MIN_VALUE;
            } else {
                c01231 = new C01231(continuationImpl);
            }
        } else {
            c01231 = new C01231(continuationImpl);
        }
        C01231 c01232 = c01231;
        Object obj2 = c01232.result;
        int i2 = c01232.label;
        Object obj3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            long epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
            c01232.L$0 = str;
            contentHints2 = contentHints;
            c01232.L$1 = contentHints2;
            c01232.L$2 = set;
            c01232.L$3 = str2;
            c01232.L$4 = audioQuality;
            defaultMediaClock2 = defaultMediaClock;
            c01232.L$5 = defaultMediaClock2;
            j2 = j;
            c01232.J$0 = j2;
            c01232.label = 1;
            Object cachedPlayerConfig = getCachedPlayerConfig(false, epochMilliseconds, c01232);
            if (cachedPlayerConfig != obj3) {
                str3 = str2;
                audioQuality2 = audioQuality;
                set2 = set;
                obj = cachedPlayerConfig;
                str4 = str;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Set set3 = c01232.L$2;
            ResultKt.throwOnFailure(obj2);
            return obj2;
        }
        long j3 = c01232.J$0;
        DefaultMediaClock defaultMediaClock3 = c01232.L$5;
        AudioQuality audioQuality3 = c01232.L$4;
        String str5 = c01232.L$3;
        set2 = c01232.L$2;
        ContentHints contentHints3 = c01232.L$1;
        String str6 = c01232.L$0;
        ResultKt.throwOnFailure(obj2);
        j2 = j3;
        contentHints2 = contentHints3;
        defaultMediaClock2 = defaultMediaClock3;
        audioQuality2 = audioQuality3;
        str3 = str5;
        obj = obj2;
        str4 = str6;
        CachedPlayerConfig cachedPlayerConfig2 = (CachedPlayerConfig) obj;
        if (cachedPlayerConfig2 == null || (playerConfig = cachedPlayerConfig2.config) == null) {
            return null;
        }
        Map mapSingletonMap = Collections.singletonMap("fallback", "kids");
        mapSingletonMap.getClass();
        EntryPoints.d$default(this.logger, "InnerTubeExtractor", "kids fallback attempted", mapSingletonMap, 4);
        ContentHints contentHintsCopy$default = ContentHints.copy$default(contentHints2, null, "WEB_KIDS", 1789);
        c01232.L$0 = null;
        c01232.L$1 = null;
        c01232.L$2 = null;
        c01232.L$3 = null;
        c01232.L$4 = null;
        c01232.L$5 = null;
        c01232.J$0 = j2;
        c01232.label = 2;
        Object objExtractWithConfig$default = extractWithConfig$default(this, str4, contentHintsCopy$default, set2, str3, playerConfig, j2, false, audioQuality2, defaultMediaClock2, null, c01232, 1600);
        return objExtractWithConfig$default == obj3 ? obj3 : objExtractWithConfig$default;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getCachedPlayerConfig(boolean z, long j, ContinuationImpl continuationImpl) {
        C01241 c01241;
        MutexImpl mutexImpl;
        if (continuationImpl instanceof C01241) {
            c01241 = (C01241) continuationImpl;
            int i = c01241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01241.label = i - Integer.MIN_VALUE;
            } else {
                c01241 = new C01241(continuationImpl);
            }
        } else {
            c01241 = new C01241(continuationImpl);
        }
        Object obj = c01241.result;
        int i2 = c01241.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MutexImpl mutexImpl2 = this.playerConfigFetchMutex;
            c01241.L$0 = mutexImpl2;
            c01241.Z$0 = z;
            c01241.J$0 = j;
            c01241.label = 1;
            Object objLock = mutexImpl2.lock(c01241);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            mutexImpl = mutexImpl2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = c01241.J$0;
            z = c01241.Z$0;
            mutexImpl = c01241.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            return getCachedPlayerConfigLocked(j, z);
        } finally {
            mutexImpl.unlock(null);
        }
    }

    public final CachedPlayerConfig getCachedPlayerConfigLocked(long j, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        LinkedHashMap linkedHashMap = this.playerConfigCache;
        CachedPlayerConfig cachedPlayerConfig = (CachedPlayerConfig) linkedHashMap.get(boolValueOf);
        if (cachedPlayerConfig == null) {
            return null;
        }
        if (!Intrinsics.areEqual(cachedPlayerConfig.identity, configIdentity(z))) {
            linkedHashMap.remove(Boolean.valueOf(z));
            return null;
        }
        if (j - cachedPlayerConfig.cachedAtMs <= 10800000) {
            return cachedPlayerConfig;
        }
        linkedHashMap.remove(Boolean.valueOf(z));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00be  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object prewarm(ContinuationImpl continuationImpl) throws Throwable {
        C01251 c01251;
        long epochMilliseconds;
        String strM;
        long j;
        long j2;
        String str;
        long j3;
        DiscordRpcManager.AnonymousClass4 anonymousClass4;
        InnerTube innerTube = this.innerTube;
        if (continuationImpl instanceof C01251) {
            c01251 = (C01251) continuationImpl;
            int i = c01251.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01251.label = i - Integer.MIN_VALUE;
            } else {
                c01251 = new C01251(continuationImpl);
            }
        } else {
            c01251 = new C01251(continuationImpl);
        }
        Object objFetchFreshVisitorData = c01251.result;
        int i2 = c01251.label;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = this.logger;
        byte b = 2;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objFetchFreshVisitorData);
                    epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
                    InnerTube.SessionSnapshot sessionSnapshot = innerTube.sessionSnapshot();
                    if (!this.tokenProvider.getCapabilities().providers.isEmpty()) {
                        String str2 = sessionSnapshot.visitorData;
                        if (str2 == null) {
                            c01251.J$0 = epochMilliseconds;
                            c01251.label = 1;
                            objFetchFreshVisitorData = innerTube.fetchFreshVisitorData(sessionSnapshot, false, c01251);
                            if (objFetchFreshVisitorData == coroutineSingletons) {
                            }
                        } else {
                            str = str2;
                        }
                        return coroutineSingletons;
                    }
                    str = null;
                    MutatorMutex.AnonymousClass2 anonymousClass2 = new MutatorMutex.AnonymousClass2(this, continuation, b);
                    c01251.L$1 = str;
                    c01251.J$0 = epochMilliseconds;
                    c01251.label = 2;
                    objFetchFreshVisitorData = AwaitKt.coroutineScope(anonymousClass2, c01251);
                    if (objFetchFreshVisitorData != coroutineSingletons) {
                        j3 = epochMilliseconds;
                        anonymousClass4 = new DiscordRpcManager.AnonymousClass4(this, (List) objFetchFreshVisitorData, str, (Continuation) null);
                        c01251.L$1 = null;
                        c01251.J$0 = j3;
                        c01251.label = 3;
                        if (AwaitKt.coroutineScope(anonymousClass4, c01251) != coroutineSingletons) {
                            j2 = j3;
                            Map mapSingletonMap = Collections.singletonMap("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j2));
                            mapSingletonMap.getClass();
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "prewarm completed", mapSingletonMap, 4);
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    epochMilliseconds = c01251.J$0;
                    ResultKt.throwOnFailure(objFetchFreshVisitorData);
                } else {
                    if (i2 == 2) {
                        j3 = c01251.J$0;
                        str = c01251.L$1;
                        try {
                            ResultKt.throwOnFailure(objFetchFreshVisitorData);
                            anonymousClass4 = new DiscordRpcManager.AnonymousClass4(this, (List) objFetchFreshVisitorData, str, (Continuation) null);
                            c01251.L$1 = null;
                            c01251.J$0 = j3;
                            c01251.label = 3;
                            if (AwaitKt.coroutineScope(anonymousClass4, c01251) != coroutineSingletons) {
                                j2 = j3;
                            }
                        } catch (Exception e) {
                            e = e;
                            epochMilliseconds = j3;
                            strM = Format$$ExternalSyntheticOutline0.m(e);
                            if (strM == null) {
                                strM = "unknown";
                            }
                            Map mapSingletonMap2 = Collections.singletonMap("exceptionType", strM);
                            mapSingletonMap2.getClass();
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "player config prewarm failed", mapSingletonMap2, 4);
                            c01251.L$1 = null;
                            c01251.J$0 = epochMilliseconds;
                            c01251.label = 4;
                            if (this.cipherService.prewarmEjs(c01251) != coroutineSingletons) {
                                j = epochMilliseconds;
                                j2 = j;
                                Map mapSingletonMap3 = Collections.singletonMap("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j2));
                                mapSingletonMap3.getClass();
                                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "prewarm completed", mapSingletonMap3, 4);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutineSingletons;
                    }
                    if (i2 == 3) {
                        j2 = c01251.J$0;
                        try {
                            ResultKt.throwOnFailure(objFetchFreshVisitorData);
                        } catch (Exception e2) {
                            e = e2;
                            epochMilliseconds = j2;
                            strM = Format$$ExternalSyntheticOutline0.m(e);
                            if (strM == null) {
                                strM = "unknown";
                            }
                            Map mapSingletonMap4 = Collections.singletonMap("exceptionType", strM);
                            mapSingletonMap4.getClass();
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "player config prewarm failed", mapSingletonMap4, 4);
                            c01251.L$1 = null;
                            c01251.J$0 = epochMilliseconds;
                            c01251.label = 4;
                            if (this.cipherService.prewarmEjs(c01251) != coroutineSingletons) {
                                j = epochMilliseconds;
                                j2 = j;
                            }
                            return coroutineSingletons;
                        }
                    } else {
                        if (i2 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        j = c01251.J$0;
                        ResultKt.throwOnFailure(objFetchFreshVisitorData);
                        j2 = j;
                    }
                }
                Map mapSingletonMap5 = Collections.singletonMap("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j2));
                mapSingletonMap5.getClass();
                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "prewarm completed", mapSingletonMap5, 4);
                return Unit.INSTANCE;
                str = (String) objFetchFreshVisitorData;
                MutatorMutex.AnonymousClass2 anonymousClass3 = new MutatorMutex.AnonymousClass2(this, continuation, b);
                c01251.L$1 = str;
                c01251.J$0 = epochMilliseconds;
                c01251.label = 2;
                objFetchFreshVisitorData = AwaitKt.coroutineScope(anonymousClass3, c01251);
                if (objFetchFreshVisitorData != coroutineSingletons) {
                    j3 = epochMilliseconds;
                    anonymousClass4 = new DiscordRpcManager.AnonymousClass4(this, (List) objFetchFreshVisitorData, str, (Continuation) null);
                    c01251.L$1 = null;
                    c01251.J$0 = j3;
                    c01251.label = 3;
                    if (AwaitKt.coroutineScope(anonymousClass4, c01251) != coroutineSingletons) {
                        j2 = j3;
                        Map mapSingletonMap6 = Collections.singletonMap("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j2));
                        mapSingletonMap6.getClass();
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "prewarm completed", mapSingletonMap6, 4);
                        return Unit.INSTANCE;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            return coroutineSingletons;
        } catch (CancellationException e4) {
            throw e4;
        }
    }

    public final Object resolveBoundedContentLength(Long l, String str, Map map, boolean z, C01201 c01201) {
        Continuation continuation = null;
        if (l != null) {
            if (l.longValue() <= 0) {
                l = null;
            }
            if (l != null) {
                return new Long(l.longValue());
            }
        }
        if (!z) {
            return null;
        }
        Path.Companion companion = Duration.Companion;
        return AwaitKt.m1899withTimeoutOrNullKLykuaI(InstantKt.toDuration(8, DurationUnit.SECONDS), new DataStoreKt$get$2((Object) this, (Object) str, (Object) map, continuation, (byte) 1), c01201);
    }
}
