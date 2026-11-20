package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.room.coroutines.PassthroughConnection;
import coil3.network.NetworkFetcher;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.music.utils.InnerTubeXPlayer;
import dagger.hilt.EntryPoints;
import io.ktor.client.HttpClient;
import io.ktor.http.Url;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.InstantJvmKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GitHubPlayerConfigClient {
    public static final Regex JSDELIVR_URL_REGEX = new Regex("^https://cdn\\.jsdelivr\\.net/gh/([^/]+)/([^@/]+)@([^/]+)/(.+)$");
    public static final Regex PLAYER_HASH_REGEX = new Regex("/s/player/([^/]+)/");
    public final MutexImpl cacheMutex;
    public final LinkedHashMap cachedConfigs;
    public final EjsChallengeSolver ejs;
    public final HttpClient httpClient;
    public final JsonImpl json;
    public final PathKt$$ExternalSyntheticBUOutline0 logger;
    public final LinkedHashMap missingConfigs;
    public final InnerTubeXPlayer.AndroidPlayerConfigRepository repository;
    public final NetworkFetcher.AnonymousClass2 validateSourceUrl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CachedConfig {
        public final PlayerConfig config;
        public final long fetchedAtMs;
        public final String url;

        public CachedConfig(String str, PlayerConfig playerConfig, long j) {
            str.getClass();
            playerConfig.getClass();
            this.url = str;
            this.config = playerConfig;
            this.fetchedAtMs = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CachedConfig)) {
                return false;
            }
            CachedConfig cachedConfig = (CachedConfig) obj;
            return Intrinsics.areEqual(this.url, cachedConfig.url) && Intrinsics.areEqual(this.config, cachedConfig.config) && this.fetchedAtMs == cachedConfig.fetchedAtMs;
        }

        public final int hashCode() {
            return Long.hashCode(this.fetchedAtMs) + (((this.url.hashCode() * 31) + this.config.hashCode()) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("CachedConfig(url=");
            sb.append(this.url);
            sb.append(", config=");
            sb.append(this.config);
            sb.append(", fetchedAtMs=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.fetchedAtMs, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/innertubex/cipher/GitHubPlayerConfigClient$NTransformConfig", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class NTransformConfig {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String preprocessedPlayer;
        public final String preprocessedPlayerEncoding;
        public final String type;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/cipher/GitHubPlayerConfigClient$NTransformConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/cipher/GitHubPlayerConfigClient$NTransformConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return GitHubPlayerConfigClient$NTransformConfig$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ NTransformConfig(int i, String str, String str2, String str3) {
            if (5 != (i & 5)) {
                EnumsKt.throwMissingFieldException(GitHubPlayerConfigClient$NTransformConfig$$serializer.INSTANCE.getDescriptor(), i, 5);
                throw null;
            }
            this.type = str;
            if ((i & 2) == 0) {
                this.preprocessedPlayerEncoding = null;
            } else {
                this.preprocessedPlayerEncoding = str2;
            }
            this.preprocessedPlayer = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NTransformConfig)) {
                return false;
            }
            NTransformConfig nTransformConfig = (NTransformConfig) obj;
            return Intrinsics.areEqual(this.type, nTransformConfig.type) && Intrinsics.areEqual(this.preprocessedPlayerEncoding, nTransformConfig.preprocessedPlayerEncoding) && Intrinsics.areEqual(this.preprocessedPlayer, nTransformConfig.preprocessedPlayer);
        }

        public final int hashCode() {
            int iHashCode = this.type.hashCode() * 31;
            String str = this.preprocessedPlayerEncoding;
            return this.preprocessedPlayer.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("NTransformConfig(type=", this.type, ", preprocessedPlayerEncoding=", this.preprocessedPlayerEncoding, ", preprocessedPlayer="), this.preprocessedPlayer, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/innertubex/cipher/GitHubPlayerConfigClient$PlayerConfig", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class PlayerConfig {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final NTransformConfig nTransform;
        public final String playerHash;
        public final int schemaVersion;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/cipher/GitHubPlayerConfigClient$PlayerConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/cipher/GitHubPlayerConfigClient$PlayerConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return GitHubPlayerConfigClient$PlayerConfig$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PlayerConfig(int i, int i2, String str, NTransformConfig nTransformConfig) {
            if (2 != (i & 2)) {
                EnumsKt.throwMissingFieldException(GitHubPlayerConfigClient$PlayerConfig$$serializer.INSTANCE.getDescriptor(), i, 2);
                throw null;
            }
            this.schemaVersion = (i & 1) == 0 ? 0 : i2;
            this.playerHash = str;
            if ((i & 4) == 0) {
                this.nTransform = null;
            } else {
                this.nTransform = nTransformConfig;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlayerConfig)) {
                return false;
            }
            PlayerConfig playerConfig = (PlayerConfig) obj;
            return this.schemaVersion == playerConfig.schemaVersion && Intrinsics.areEqual(this.playerHash, playerConfig.playerHash) && Intrinsics.areEqual(this.nTransform, playerConfig.nTransform);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(Integer.hashCode(this.schemaVersion) * 31, 31, this.playerHash);
            NTransformConfig nTransformConfig = this.nTransform;
            return iM + (nTransformConfig == null ? 0 : nTransformConfig.hashCode());
        }

        public final String toString() {
            return "PlayerConfig(schemaVersion=" + this.schemaVersion + ", playerHash=" + this.playerHash + ", nTransform=" + this.nTransform + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SolveResult {
        public final Map nByChallenge;
        public final Map sigByChallenge;

        public SolveResult(Map map, Map map2) {
            this.sigByChallenge = map;
            this.nByChallenge = map2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SolveResult)) {
                return false;
            }
            SolveResult solveResult = (SolveResult) obj;
            return this.sigByChallenge.equals(solveResult.sigByChallenge) && this.nByChallenge.equals(solveResult.nByChallenge);
        }

        public final int hashCode() {
            return this.nByChallenge.hashCode() + (this.sigByChallenge.hashCode() * 31);
        }

        public final String toString() {
            return "SolveResult(sigByChallenge=" + this.sigByChallenge + ", nByChallenge=" + this.nByChallenge + ")";
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.GitHubPlayerConfigClient$fetchConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GitHubPlayerConfigClient.this.fetchConfig(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.GitHubPlayerConfigClient$loadConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00941 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public String L$1;
        public Object L$2;
        public MutexImpl L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00941(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GitHubPlayerConfigClient.this.loadConfig(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.GitHubPlayerConfigClient$loadPreprocessedPlayer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00951 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public String L$0;
        public String L$1;
        public Iterator L$2;
        public String L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00951(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GitHubPlayerConfigClient.this.loadPreprocessedPlayer(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.GitHubPlayerConfigClient$solve$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00961 extends ContinuationImpl {
        public String L$0;
        public String L$3;
        public List L$7;
        public List L$8;
        public int label;
        public /* synthetic */ Object result;

        public C00961(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GitHubPlayerConfigClient.this.solve(null, null, null, this);
        }
    }

    public GitHubPlayerConfigClient(HttpClient httpClient, EjsChallengeSolver ejsChallengeSolver, InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository, NetworkFetcher.AnonymousClass2 anonymousClass2, PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0) {
        httpClient.getClass();
        androidPlayerConfigRepository.getClass();
        this.httpClient = httpClient;
        this.ejs = ejsChallengeSolver;
        this.repository = androidPlayerConfigRepository;
        this.validateSourceUrl = anonymousClass2;
        this.logger = pathKt$$ExternalSyntheticBUOutline0;
        this.json = UuidKt.Json$default(new YouTube$$ExternalSyntheticLambda2((byte) 14));
        this.cacheMutex = new MutexImpl();
        this.cachedConfigs = new LinkedHashMap();
        this.missingConfigs = new LinkedHashMap();
    }

    public static NTransformConfig nTransformFor(PlayerConfig playerConfig, String str) {
        NTransformConfig nTransformConfig;
        if (!Intrinsics.areEqual(playerConfig.playerHash, str)) {
            playerConfig = null;
        }
        if (playerConfig == null || (nTransformConfig = playerConfig.nTransform) == null || !Intrinsics.areEqual(nTransformConfig.type, "yt-dlp-ejs-preprocessed-player") || StringsKt.isBlank(nTransformConfig.preprocessedPlayer)) {
            return null;
        }
        return nTransformConfig;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object fetchConfig(String str, ContinuationImpl continuationImpl) throws IOException {
        AnonymousClass1 anonymousClass1;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object textWithoutRedirects = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        byte b = 12;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(textWithoutRedirects);
                Url url = (Url) this.validateSourceUrl.invoke(str);
                if (url != null) {
                    HttpClient httpClient = this.httpClient;
                    YouTube$$ExternalSyntheticLambda2 youTube$$ExternalSyntheticLambda2 = new YouTube$$ExternalSyntheticLambda2(b);
                    anonymousClass2.label = 1;
                    textWithoutRedirects = RegexKt.getTextWithoutRedirects(httpClient, url, 4194304, null, youTube$$ExternalSyntheticLambda2, anonymousClass2);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (textWithoutRedirects == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return null;
            }
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(textWithoutRedirects);
            String str2 = ((RestrictedTextResponse) textWithoutRedirects).body;
            if (str2 != null) {
                return (PlayerConfig) this.json.decodeFromString(PlayerConfig.INSTANCE.serializer(), str2);
            }
            return null;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            String strM = Format$$ExternalSyntheticOutline0.m(e2);
            if (strM == null) {
                strM = "Exception";
            }
            EntryPoints.d$default(this.logger, "GitHubPlayerConfigClient", IntIntPair$$ExternalSyntheticOutline0.m("GitHub config fetch failed (", strM, ")"), null, 12);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x01a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0114  */
    /* JADX WARN: Code duplicated, block: B:65:0x0117  */
    /* JADX WARN: Code duplicated, block: B:68:0x012b  */
    /* JADX WARN: Code duplicated, block: B:72:0x0146 A[Catch: all -> 0x015c, TryCatch #1 {all -> 0x015c, blocks: (B:69:0x012c, B:70:0x013e, B:72:0x0146, B:75:0x0158), top: B:103:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0158 A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #1 {all -> 0x015c, blocks: (B:69:0x012c, B:70:0x013e, B:72:0x0146, B:75:0x0158), top: B:103:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:83:0x0166  */
    /* JADX WARN: Code duplicated, block: B:86:0x017a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0193 A[Catch: all -> 0x01ad, TryCatch #2 {all -> 0x01ad, blocks: (B:87:0x017b, B:88:0x018d, B:90:0x0193, B:93:0x01a5), top: B:105:0x017b }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01a5 A[Catch: all -> 0x01ad, TRY_LEAVE, TryCatch #2 {all -> 0x01ad, blocks: (B:87:0x017b, B:88:0x018d, B:90:0x0193, B:93:0x01a5), top: B:105:0x017b }] */
    public final Object loadConfig(String str, String str2, ContinuationImpl continuationImpl) throws IOException {
        C00941 c00941;
        long epochMilliseconds;
        String str3;
        String str4;
        Mutex mutex;
        String str5;
        String str6;
        PlayerConfig playerConfig;
        PlayerConfig playerConfig2;
        String str7;
        String str8;
        String str9;
        String str10;
        if (continuationImpl instanceof C00941) {
            c00941 = (C00941) continuationImpl;
            int i = c00941.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00941.label = i - Integer.MIN_VALUE;
            } else {
                c00941 = new C00941(continuationImpl);
            }
        } else {
            c00941 = new C00941(continuationImpl);
        }
        Object obj = c00941.result;
        int i2 = c00941.label;
        MutexImpl mutexImpl = this.cacheMutex;
        LinkedHashMap linkedHashMap = this.cachedConfigs;
        LinkedHashMap linkedHashMap2 = this.missingConfigs;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
                str3 = str;
                c00941.L$0 = str3;
                c00941.L$1 = str2;
                c00941.L$2 = mutexImpl;
                c00941.J$0 = epochMilliseconds;
                c00941.label = 1;
                if (mutexImpl.lock(c00941) != obj2) {
                    str4 = str2;
                    mutex = mutexImpl;
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        mutexImpl = c00941.L$3;
                        str8 = c00941.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            linkedHashMap2.put(str8, new Long(InstantJvmKt.systemClock.now().toEpochMilliseconds()));
                            while (linkedHashMap2.size() > 8) {
                                Set setKeySet = linkedHashMap2.keySet();
                                setKeySet.getClass();
                                str9 = (String) CollectionsKt.firstOrNull(setKeySet);
                                if (str9 == null) {
                                    break;
                                }
                                linkedHashMap2.remove(str9);
                            }
                            mutexImpl.unlock(null);
                            return null;
                        } catch (Throwable th) {
                            mutexImpl.unlock(null);
                            throw th;
                        }
                    }
                    if (i2 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutexImpl = c00941.L$3;
                    playerConfig2 = (PlayerConfig) c00941.L$2;
                    str7 = c00941.L$0;
                    ResultKt.throwOnFailure(obj);
                    try {
                        linkedHashMap.put(str7, new CachedConfig(str7, playerConfig2, InstantJvmKt.systemClock.now().toEpochMilliseconds()));
                        while (linkedHashMap.size() > 1) {
                            Set setKeySet2 = linkedHashMap.keySet();
                            setKeySet2.getClass();
                            str10 = (String) CollectionsKt.firstOrNull(setKeySet2);
                            if (str10 == null) {
                                break;
                            }
                            linkedHashMap.remove(str10);
                        }
                        mutexImpl.unlock(null);
                        return playerConfig2;
                    } catch (Throwable th2) {
                        mutexImpl.unlock(null);
                        throw th2;
                    }
                }
                epochMilliseconds = c00941.J$0;
                str6 = c00941.L$1;
                str5 = c00941.L$0;
                ResultKt.throwOnFailure(obj);
                playerConfig = (PlayerConfig) obj;
                if (playerConfig != null || nTransformFor(playerConfig, str6) == null) {
                    playerConfig2 = null;
                } else {
                    playerConfig2 = playerConfig;
                }
                if (playerConfig2 == null) {
                    c00941.L$0 = str5;
                    c00941.L$1 = null;
                    c00941.L$2 = null;
                    c00941.L$3 = mutexImpl;
                    c00941.J$0 = epochMilliseconds;
                    c00941.label = 3;
                    if (mutexImpl.lock(c00941) != obj2) {
                        str8 = str5;
                        linkedHashMap2.put(str8, new Long(InstantJvmKt.systemClock.now().toEpochMilliseconds()));
                        while (linkedHashMap2.size() > 8) {
                            Set setKeySet3 = linkedHashMap2.keySet();
                            setKeySet3.getClass();
                            str9 = (String) CollectionsKt.firstOrNull(setKeySet3);
                            if (str9 == null) {
                                break;
                                break;
                            }
                            linkedHashMap2.remove(str9);
                        }
                        mutexImpl.unlock(null);
                        return null;
                    }
                } else {
                    c00941.L$0 = str5;
                    c00941.L$1 = null;
                    c00941.L$2 = playerConfig2;
                    c00941.L$3 = mutexImpl;
                    c00941.J$0 = epochMilliseconds;
                    c00941.label = 4;
                    if (mutexImpl.lock(c00941) != obj2) {
                        str7 = str5;
                        linkedHashMap.put(str7, new CachedConfig(str7, playerConfig2, InstantJvmKt.systemClock.now().toEpochMilliseconds()));
                        while (linkedHashMap.size() > 1) {
                            Set setKeySet4 = linkedHashMap.keySet();
                            setKeySet4.getClass();
                            str10 = (String) CollectionsKt.firstOrNull(setKeySet4);
                            if (str10 == null) {
                                break;
                                break;
                            }
                            linkedHashMap.remove(str10);
                        }
                        mutexImpl.unlock(null);
                        return playerConfig2;
                    }
                }
                return obj2;
            }
            epochMilliseconds = c00941.J$0;
            mutex = (Mutex) c00941.L$2;
            str4 = c00941.L$1;
            String str11 = c00941.L$0;
            ResultKt.throwOnFailure(obj);
            str3 = str11;
            CachedConfig cachedConfig = (CachedConfig) linkedHashMap.remove(str3);
            if (cachedConfig != null) {
                if (epochMilliseconds - cachedConfig.fetchedAtMs >= 86400000) {
                    cachedConfig = null;
                }
                if (cachedConfig != null) {
                    if (!(nTransformFor(cachedConfig.config, str4) != null)) {
                        cachedConfig = null;
                    }
                    if (cachedConfig != null) {
                        linkedHashMap.put(str3, cachedConfig);
                        PlayerConfig playerConfig3 = cachedConfig.config;
                        mutex.unlock(null);
                        return playerConfig3;
                    }
                }
            }
            Long l = (Long) linkedHashMap2.get(str3);
            if (l != null) {
                long jLongValue = epochMilliseconds - l.longValue();
                if (0 <= jLongValue && jLongValue < 900000) {
                    mutex.unlock(null);
                    return null;
                }
            }
            mutex.unlock(null);
            c00941.L$0 = str3;
            c00941.L$1 = str4;
            c00941.L$2 = null;
            c00941.J$0 = epochMilliseconds;
            c00941.label = 2;
            Object objFetchConfig = fetchConfig(str3, c00941);
            if (objFetchConfig != obj2) {
                str5 = str3;
                obj = objFetchConfig;
                str6 = str4;
                playerConfig = (PlayerConfig) obj;
                if (playerConfig != null) {
                    playerConfig2 = null;
                } else {
                    playerConfig2 = null;
                }
                if (playerConfig2 == null) {
                    c00941.L$0 = str5;
                    c00941.L$1 = null;
                    c00941.L$2 = null;
                    c00941.L$3 = mutexImpl;
                    c00941.J$0 = epochMilliseconds;
                    c00941.label = 3;
                    if (mutexImpl.lock(c00941) != obj2) {
                        str8 = str5;
                        linkedHashMap2.put(str8, new Long(InstantJvmKt.systemClock.now().toEpochMilliseconds()));
                        while (linkedHashMap2.size() > 8) {
                            Set setKeySet5 = linkedHashMap2.keySet();
                            setKeySet5.getClass();
                            str9 = (String) CollectionsKt.firstOrNull(setKeySet5);
                            if (str9 == null) {
                                break;
                                break;
                            }
                            linkedHashMap2.remove(str9);
                        }
                        mutexImpl.unlock(null);
                        return null;
                    }
                } else {
                    c00941.L$0 = str5;
                    c00941.L$1 = null;
                    c00941.L$2 = playerConfig2;
                    c00941.L$3 = mutexImpl;
                    c00941.J$0 = epochMilliseconds;
                    c00941.label = 4;
                    if (mutexImpl.lock(c00941) != obj2) {
                        str7 = str5;
                        linkedHashMap.put(str7, new CachedConfig(str7, playerConfig2, InstantJvmKt.systemClock.now().toEpochMilliseconds()));
                        while (linkedHashMap.size() > 1) {
                            Set setKeySet6 = linkedHashMap.keySet();
                            setKeySet6.getClass();
                            str10 = (String) CollectionsKt.firstOrNull(setKeySet6);
                            if (str10 == null) {
                                break;
                                break;
                            }
                            linkedHashMap.remove(str10);
                        }
                        mutexImpl.unlock(null);
                        return playerConfig2;
                    }
                }
            }
            return obj2;
        } catch (Throwable th3) {
            mutex.unlock(null);
            throw th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00be  */
    /* JADX WARN: Code duplicated, block: B:27:0x00dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:53:0x013d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0140  */
    /* JADX WARN: Code duplicated, block: B:57:0x0146  */
    /* JADX WARN: Code duplicated, block: B:59:0x0150  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00dd -> B:29:0x00e5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object loadPreprocessedPlayer(java.lang.String r17, java.lang.String r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.cipher.GitHubPlayerConfigClient.loadPreprocessedPlayer(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0209 A[Catch: Exception -> 0x01f1, CancellationException -> 0x0293, TryCatch #1 {CancellationException -> 0x0293, blocks: (B:15:0x0042, B:93:0x01bc, B:94:0x01cd, B:96:0x01d3, B:98:0x01e5, B:101:0x01f4, B:102:0x0203, B:104:0x0209, B:106:0x021b, B:107:0x0227, B:22:0x005f, B:79:0x016d, B:81:0x0177, B:84:0x0187, B:86:0x018d, B:87:0x0197, B:89:0x01b4, B:25:0x006f, B:61:0x0129, B:63:0x012d, B:65:0x0133, B:66:0x013f, B:68:0x0145, B:71:0x0153, B:73:0x0161, B:57:0x0113), top: B:120:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x027e  */
    /* JADX WARN: Code duplicated, block: B:127:0x01e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x01cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x021b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x0203 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0177 A[Catch: Exception -> 0x0183, CancellationException -> 0x0293, TryCatch #1 {CancellationException -> 0x0293, blocks: (B:15:0x0042, B:93:0x01bc, B:94:0x01cd, B:96:0x01d3, B:98:0x01e5, B:101:0x01f4, B:102:0x0203, B:104:0x0209, B:106:0x021b, B:107:0x0227, B:22:0x005f, B:79:0x016d, B:81:0x0177, B:84:0x0187, B:86:0x018d, B:87:0x0197, B:89:0x01b4, B:25:0x006f, B:61:0x0129, B:63:0x012d, B:65:0x0133, B:66:0x013f, B:68:0x0145, B:71:0x0153, B:73:0x0161, B:57:0x0113), top: B:120:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x018d A[Catch: Exception -> 0x0183, CancellationException -> 0x0293, TryCatch #1 {CancellationException -> 0x0293, blocks: (B:15:0x0042, B:93:0x01bc, B:94:0x01cd, B:96:0x01d3, B:98:0x01e5, B:101:0x01f4, B:102:0x0203, B:104:0x0209, B:106:0x021b, B:107:0x0227, B:22:0x005f, B:79:0x016d, B:81:0x0177, B:84:0x0187, B:86:0x018d, B:87:0x0197, B:89:0x01b4, B:25:0x006f, B:61:0x0129, B:63:0x012d, B:65:0x0133, B:66:0x013f, B:68:0x0145, B:71:0x0153, B:73:0x0161, B:57:0x0113), top: B:120:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code duplicated, block: B:92:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:96:0x01d3 A[Catch: Exception -> 0x01f1, CancellationException -> 0x0293, TryCatch #1 {CancellationException -> 0x0293, blocks: (B:15:0x0042, B:93:0x01bc, B:94:0x01cd, B:96:0x01d3, B:98:0x01e5, B:101:0x01f4, B:102:0x0203, B:104:0x0209, B:106:0x021b, B:107:0x0227, B:22:0x005f, B:79:0x016d, B:81:0x0177, B:84:0x0187, B:86:0x018d, B:87:0x0197, B:89:0x01b4, B:25:0x006f, B:61:0x0129, B:63:0x012d, B:65:0x0133, B:66:0x013f, B:68:0x0145, B:71:0x0153, B:73:0x0161, B:57:0x0113), top: B:120:0x0034 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22, types: [java.lang.String, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.metrolist.innertubex.cipher.GitHubPlayerConfigClient] */
    public final Object solve(String str, List list, List list2, ContinuationImpl continuationImpl) {
        C00961 c00961;
        EmptyMap emptyMap;
        ?? r10;
        String strM;
        String str2;
        List list3;
        String str3;
        List list4;
        ?? r11;
        CoroutineSingletons coroutineSingletons;
        String str4;
        ?? r12;
        String str5;
        ListBuilder listBuilderCreateListBuilder;
        Object objSolve;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        if (continuationImpl instanceof C00961) {
            c00961 = (C00961) continuationImpl;
            int i = c00961.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00961.label = i - Integer.MIN_VALUE;
            } else {
                c00961 = new C00961(continuationImpl);
            }
        } else {
            c00961 = new C00961(continuationImpl);
        }
        C00961 c00962 = c00961;
        Object objLoadPreprocessedPlayer = c00962.result;
        int i2 = c00962.label;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = this.logger;
        EjsChallengeSolver ejsChallengeSolver = this.ejs;
        int i3 = 1;
        EmptyMap emptyMap2 = EmptyMap.INSTANCE;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 != 0) {
                    if (i2 == 1) {
                        list3 = c00962.L$8;
                        list4 = c00962.L$7;
                        str2 = c00962.L$3;
                        str3 = c00962.L$0;
                        ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                    } else if (i2 == 2) {
                        list3 = c00962.L$8;
                        list4 = c00962.L$7;
                        str2 = c00962.L$3;
                        str5 = c00962.L$0;
                        ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                        coroutineSingletons = coroutineSingletons2;
                        r11 = 0;
                        listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                        if (!list4.isEmpty()) {
                            listBuilderCreateListBuilder.add(new Pair("sig", list4));
                        }
                        if (!list3.isEmpty()) {
                            listBuilderCreateListBuilder.add(new Pair("n", list3));
                        }
                        ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                        c00962.L$0 = r11;
                        c00962.L$3 = str2;
                        c00962.L$7 = list4;
                        c00962.L$8 = list3;
                        c00962.label = 3;
                        JsonImpl jsonImpl = EjsChallengeSolver.payloadJson;
                        emptyMap = emptyMap2;
                        try {
                            objSolve = ejsChallengeSolver.solve(str5, new EjsChallengeSolver.AnonymousClass2(i3, r11, (byte) 0), listBuilderBuild, true, c00962);
                            if (objSolve == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            objLoadPreprocessedPlayer = objSolve;
                            r11 = r11;
                        } catch (Exception e) {
                            e = e;
                            r10 = r11;
                            strM = Format$$ExternalSyntheticOutline0.m(e);
                            if (strM == null) {
                                strM = "Exception";
                            }
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "GitHubPlayerConfigClient", IntIntPair$$ExternalSyntheticOutline0.m("GitHub preprocessed-player failed (", strM, ")"), r10, 12);
                            return new SolveResult(emptyMap, emptyMap);
                        }
                    } else {
                        if (i2 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        list3 = c00962.L$8;
                        list4 = c00962.L$7;
                        str2 = c00962.L$3;
                        ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                        emptyMap = emptyMap2;
                        r11 = 0;
                    }
                    EjsChallengeSolver.SolveResult solveResult = (EjsChallengeSolver.SolveResult) objLoadPreprocessedPlayer;
                    Map map = solveResult.sigByChallenge;
                    linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : map.entrySet()) {
                        if (!StringsKt.isBlank((String) entry.getValue())) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    Map map2 = solveResult.nByChallenge;
                    linkedHashMap2 = new LinkedHashMap();
                    for (Map.Entry entry2 : map2.entrySet()) {
                        if (!StringsKt.isBlank((String) entry2.getValue())) {
                            linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    SolveResult solveResult2 = new SolveResult(linkedHashMap, linkedHashMap2);
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "GitHubPlayerConfigClient", "GitHub preprocessed-player response sigRequested=" + list4.size() + " sigSolved=" + linkedHashMap.size() + " nRequested=" + list3.size() + " nSolved=" + linkedHashMap2.size() + " hash=" + str2, r11, 12);
                    return solveResult2;
                }
                ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                if (list.isEmpty() && list2.isEmpty()) {
                    return new SolveResult(emptyMap2, emptyMap2);
                }
                this.repository.getClass();
                MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(PLAYER_HASH_REGEX, str);
                str2 = matcherMatchResultFind$default != null ? (String) CollectionsKt.getOrNull(1, matcherMatchResultFind$default.getGroupValues()) : null;
                if (str2 == null) {
                    return new SolveResult(emptyMap2, emptyMap2);
                }
                String string = StringsKt.trim("https://raw.githubusercontent.com/ZemerTeam/zemer-cipher/master/library/src/main/assets/player_configs.json").toString();
                if (StringsKt__StringsJVMKt.endsWith(StringsKt.substringBefore$default(string, '?'), "/player_configs.json", false) || string.equals("https://github.com/MetrolistGroup/faraday/releases/download/{playerTag}/{playerHash}.json")) {
                    string = "https://cdn.jsdelivr.net/gh/MetrolistGroup/faraday@{playerTag}/registry/players/{playerHash}.json";
                }
                String string2 = StringsKt.trim(string).toString();
                if (StringsKt.isBlank(string2)) {
                    string2 = null;
                }
                String strReplace = string2 != null ? StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(string2, "{playerHash}", str2, false), "{playerTag}", "player-".concat(str2), false) : null;
                if (strReplace == null || StringsKt.isBlank(strReplace)) {
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "GitHubPlayerConfigClient", "GitHub preprocessed-player skipped; config URL template is blank", null, 12);
                    return new SolveResult(emptyMap2, emptyMap2);
                }
                List list5 = CollectionsKt.toList(CollectionsKt.toMutableSet(list));
                List listDistinct = CollectionsKt.distinct(list2);
                c00962.L$0 = str;
                c00962.L$3 = str2;
                c00962.L$7 = list5;
                c00962.L$8 = listDistinct;
                c00962.label = 1;
                objLoadPreprocessedPlayer = loadPreprocessedPlayer(strReplace, str2, c00962);
                if (objLoadPreprocessedPlayer == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                list3 = listDistinct;
                str3 = str;
                list4 = list5;
                String str6 = (String) objLoadPreprocessedPlayer;
                if (str6 == null) {
                    return new SolveResult(emptyMap2, emptyMap2);
                }
                c00962.L$0 = str3;
                c00962.L$3 = str2;
                c00962.L$7 = list4;
                c00962.L$8 = list3;
                c00962.label = 2;
                Object obj = Unit.INSTANCE;
                try {
                    if (StringsKt.isBlank(str6) || str6.length() > 8388608) {
                        coroutineSingletons = coroutineSingletons2;
                        str4 = str3;
                        r12 = 0;
                    } else {
                        str4 = str3;
                        coroutineSingletons = coroutineSingletons2;
                        r11 = 0;
                        try {
                            Object objWithActivity = ejsChallengeSolver.withActivity(new PassthroughConnection.AnonymousClass2(ejsChallengeSolver, str6, str4, continuation, (byte) 1), c00962);
                            r12 = r11;
                            if (objWithActivity == coroutineSingletons) {
                                obj = objWithActivity;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            emptyMap = emptyMap2;
                            r10 = r11;
                            strM = Format$$ExternalSyntheticOutline0.m(e);
                            if (strM == null) {
                                strM = "Exception";
                            }
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "GitHubPlayerConfigClient", IntIntPair$$ExternalSyntheticOutline0.m("GitHub preprocessed-player failed (", strM, ")"), r10, 12);
                            return new SolveResult(emptyMap, emptyMap);
                        }
                    }
                    if (obj == coroutineSingletons) {
                        r12 = r11;
                        return coroutineSingletons;
                    }
                    r12 = r11;
                    str5 = str4;
                    r11 = r12;
                    listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (!list4.isEmpty()) {
                        listBuilderCreateListBuilder.add(new Pair("sig", list4));
                    }
                    if (!list3.isEmpty()) {
                        listBuilderCreateListBuilder.add(new Pair("n", list3));
                    }
                    ListBuilder listBuilderBuild2 = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    c00962.L$0 = r11;
                    c00962.L$3 = str2;
                    c00962.L$7 = list4;
                    c00962.L$8 = list3;
                    c00962.label = 3;
                    JsonImpl jsonImpl2 = EjsChallengeSolver.payloadJson;
                    emptyMap = emptyMap2;
                    objSolve = ejsChallengeSolver.solve(str5, new EjsChallengeSolver.AnonymousClass2(i3, r11, (byte) 0), listBuilderBuild2, true, c00962);
                    if (objSolve == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    objLoadPreprocessedPlayer = objSolve;
                    r11 = r11;
                    EjsChallengeSolver.SolveResult solveResult3 = (EjsChallengeSolver.SolveResult) objLoadPreprocessedPlayer;
                    Map map3 = solveResult3.sigByChallenge;
                    linkedHashMap = new LinkedHashMap();
                    while (r4.hasNext()) {
                        if (!StringsKt.isBlank((String) entry.getValue())) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    Map map4 = solveResult3.nByChallenge;
                    linkedHashMap2 = new LinkedHashMap();
                    while (r2.hasNext()) {
                        if (!StringsKt.isBlank((String) entry2.getValue())) {
                            linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    SolveResult solveResult4 = new SolveResult(linkedHashMap, linkedHashMap2);
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "GitHubPlayerConfigClient", "GitHub preprocessed-player response sigRequested=" + list4.size() + " sigSolved=" + linkedHashMap.size() + " nRequested=" + list3.size() + " nSolved=" + linkedHashMap2.size() + " hash=" + str2, r11, 12);
                    return solveResult4;
                } catch (Exception e3) {
                    e = e3;
                    r11 = 0;
                    emptyMap = emptyMap2;
                    r10 = r11;
                    strM = Format$$ExternalSyntheticOutline0.m(e);
                    if (strM == null) {
                        strM = "Exception";
                    }
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "GitHubPlayerConfigClient", IntIntPair$$ExternalSyntheticOutline0.m("GitHub preprocessed-player failed (", strM, ")"), r10, 12);
                    return new SolveResult(emptyMap, emptyMap);
                }
            } catch (Exception e4) {
                e = e4;
                emptyMap = emptyMap2;
                r10 = 0;
            }
        } catch (CancellationException e5) {
            throw e5;
        }
    }
}
