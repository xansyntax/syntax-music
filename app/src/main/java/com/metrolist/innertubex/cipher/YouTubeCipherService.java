package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.network.NetworkFetcher;
import com.metrolist.innertubex.InnerTube$executeMutation$2$1;
import com.metrolist.innertubex.extraction.InnerTubeExtractor;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.music.utils.SyncUtils$executeLikeSong$2$1;
import dagger.hilt.EntryPoints;
import io.ktor.client.HttpClient;
import io.ktor.http.CodecsKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.ReversedListReadOnly;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SubSequence;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.InstantJvmKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeCipherService {
    public static final Regex N_PARAMETER_REGEX = new Regex("[&?]n=([^&#]+)");
    public static final Regex QUERY_PARAMETER_NAME_REGEX = new Regex("[A-Za-z][A-Za-z0-9._~-]*");
    public final LinkedHashMap cache;
    public final MutexImpl cacheMutex;
    public final EjsChallengeSolver ejs;
    public final GitHubPlayerConfigClient githubPreprocessedPlayer;
    public final HttpClient httpClient;
    public final PathKt$$ExternalSyntheticBUOutline0 logger;
    public final MutexImpl operationMutex;
    public final LinkedHashMap playerCodeCache;
    public final LinkedHashMap playerCodeDownloads;
    public final RemotePlayerConfigStore remotePlayerConfigStore;
    public final LinkedHashMap zemerCache;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CachedSolver {
        public final QuickJsEngine engine;
        public final YouTubeCipherService$createSolver$nSolver$1 nSolver;
        public final String playerUrl;
        public final YouTubeCipherService$createSolver$nSolver$1 sigSolver;

        public CachedSolver(String str, QuickJsEngine quickJsEngine, YouTubeCipherService$createSolver$nSolver$1 youTubeCipherService$createSolver$nSolver$1, YouTubeCipherService$createSolver$nSolver$1 youTubeCipherService$createSolver$nSolver$2) {
            str.getClass();
            quickJsEngine.getClass();
            this.playerUrl = str;
            this.engine = quickJsEngine;
            this.nSolver = youTubeCipherService$createSolver$nSolver$1;
            this.sigSolver = youTubeCipherService$createSolver$nSolver$2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CachedSolver) {
                CachedSolver cachedSolver = (CachedSolver) obj;
                return Intrinsics.areEqual(this.playerUrl, cachedSolver.playerUrl) && Intrinsics.areEqual(this.engine, cachedSolver.engine) && this.nSolver == cachedSolver.nSolver && this.sigSolver == cachedSolver.sigSolver;
            }
            return false;
        }

        public final int hashCode() {
            return this.sigSolver.hashCode() + ((this.nSolver.hashCode() + ((this.engine.hashCode() + (this.playerUrl.hashCode() * 31)) * 31)) * 31);
        }

        public final String toString() {
            return "CachedSolver(playerUrl=" + this.playerUrl + ", engine=" + this.engine + ", nSolver=" + this.nSolver + ", sigSolver=" + this.sigSolver + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CachedZemerSolver {
        public final RemotePlayerConfigParser.HardcodedPlayerConfig config;
        public final long configEpoch;
        public final ZemerCipherSolver solver;

        public CachedZemerSolver(RemotePlayerConfigParser.HardcodedPlayerConfig hardcodedPlayerConfig, long j, ZemerCipherSolver zemerCipherSolver) {
            hardcodedPlayerConfig.getClass();
            zemerCipherSolver.getClass();
            this.config = hardcodedPlayerConfig;
            this.configEpoch = j;
            this.solver = zemerCipherSolver;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CachedZemerSolver)) {
                return false;
            }
            CachedZemerSolver cachedZemerSolver = (CachedZemerSolver) obj;
            return Intrinsics.areEqual(this.config, cachedZemerSolver.config) && this.configEpoch == cachedZemerSolver.configEpoch && Intrinsics.areEqual(this.solver, cachedZemerSolver.solver);
        }

        public final int hashCode() {
            return this.solver.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.config.hashCode() * 31, 31, this.configEpoch);
        }

        public final String toString() {
            return "CachedZemerSolver(config=" + this.config + ", configEpoch=" + this.configEpoch + ", solver=" + this.solver + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlayerCodeResult {
        public final String code;
        public final String source;

        public PlayerCodeResult(String str, String str2) {
            str.getClass();
            this.code = str;
            this.source = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlayerCodeResult)) {
                return false;
            }
            PlayerCodeResult playerCodeResult = (PlayerCodeResult) obj;
            return Intrinsics.areEqual(this.code, playerCodeResult.code) && this.source.equals(playerCodeResult.source);
        }

        public final int hashCode() {
            return this.source.hashCode() + (this.code.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("PlayerCodeResult(code=", this.code, ", source=", this.source, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlayerScriptHttpException extends IllegalStateException {
        public final boolean retryable;

        public PlayerScriptHttpException(int i, boolean z) {
            super(IntIntPair$$ExternalSyntheticOutline0.m(i, "Player script request failed with HTTP "));
            this.retryable = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RemoteSolveResult {
        public final Map nByChallenge;
        public final Map sigByChallenge;

        public RemoteSolveResult(Map map, Map map2) {
            map.getClass();
            this.sigByChallenge = map;
            this.nByChallenge = map2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteSolveResult)) {
                return false;
            }
            RemoteSolveResult remoteSolveResult = (RemoteSolveResult) obj;
            return Intrinsics.areEqual(this.sigByChallenge, remoteSolveResult.sigByChallenge) && this.nByChallenge.equals(remoteSolveResult.nByChallenge);
        }

        public final int hashCode() {
            return this.nByChallenge.hashCode() + (this.sigByChallenge.hashCode() * 31);
        }

        public final String toString() {
            return "RemoteSolveResult(sigByChallenge=" + this.sigByChallenge + ", nByChallenge=" + this.nByChallenge + ")";
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$createSolver$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public String L$0;
        public PlayerScriptParser.ParseResult L$2;
        public String L$3;
        public QuickJsEngine L$4;
        public Throwable L$5;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.createSolver(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$dispose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01061 extends ContinuationImpl {
        public Mutex L$0;
        public MutexImpl L$1;
        public List L$3;
        public Iterator L$4;
        public int label;
        public /* synthetic */ Object result;

        public C01061(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.dispose(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$downloadPlayerScript$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01071 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public int I$2;
        public Url L$1;
        public Ref$ObjectRef L$2;
        public int label;
        public /* synthetic */ Object result;

        public C01071(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.downloadPlayerScript(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$getOrCreateSolver$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass4 extends ContinuationImpl {
        public String L$0;
        public String L$1;
        public Ref$ObjectRef L$2;
        public Object L$3;
        public Iterator L$5;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass4(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.getOrCreateSolver(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$getOrCreateZemerSolver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01081 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public String L$1;
        public RemotePlayerConfigParser.HardcodedPlayerConfig L$2;
        public Ref$ObjectRef L$3;
        public Ref$ObjectRef L$4;
        public Object L$5;
        public Iterator L$7;
        public int label;
        public /* synthetic */ Object result;

        public C01081(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.getOrCreateZemerSolver(null, null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$getOrDownloadPlayerCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01091 extends ContinuationImpl {
        public String L$0;
        public Ref$ObjectRef L$1;
        public Ref$ObjectRef L$2;
        public Ref$BooleanRef L$3;
        public Object L$4;
        public Serializable L$5;
        public MutexImpl L$6;
        public int label;
        public /* synthetic */ Object result;

        public C01091(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.getOrDownloadPlayerCode(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$preloadCanonicalPlayerCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01101 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public Mutex L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01101(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.preloadCanonicalPlayerCode(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$prewarmEjs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01111 extends ContinuationImpl {
        public Mutex L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01111(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.prewarmEjs(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$processFormatWithSolver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01121 extends ContinuationImpl {
        public CachedSolver L$0;
        public PlayerResponse.StreamingData.Format L$1;
        public LinkedHashMap L$3;
        public Serializable L$4;
        public String L$5;
        public int label;
        public /* synthetic */ Object result;

        public C01121(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.processFormatWithSolver(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$processNParameterWithSolver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01131 extends ContinuationImpl {
        public String L$1;
        public MatcherMatchResult L$2;
        public int label;
        public /* synthetic */ Object result;

        public C01131(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.processNParameterWithSolver(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$refreshAfterStreamRejection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01141 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01141(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.refreshAfterStreamRejection(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$solveWithGitHubConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01151 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01151(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.solveWithGitHubConfig(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.YouTubeCipherService$solveWithZemerConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01161 extends ContinuationImpl {
        public String L$0;
        public List L$1;
        public Collection L$11;
        public Iterator L$13;
        public String L$16;
        public Map L$17;
        public List L$2;
        public RemotePlayerConfigStore L$3;
        public RemotePlayerConfigParser.HardcodedPlayerConfig L$5;
        public String L$6;
        public ZemerCipherSolver L$8;
        public int label;
        public /* synthetic */ Object result;

        public C01161(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTubeCipherService.this.solveWithZemerConfig(null, null, null, this);
        }
    }

    public YouTubeCipherService(HttpClient httpClient, RemotePlayerConfigStore remotePlayerConfigStore, PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0) {
        httpClient.getClass();
        pathKt$$ExternalSyntheticBUOutline0.getClass();
        this.httpClient = httpClient;
        this.remotePlayerConfigStore = remotePlayerConfigStore;
        this.logger = pathKt$$ExternalSyntheticBUOutline0;
        EjsChallengeSolver ejsChallengeSolver = new EjsChallengeSolver(new QuickJsEngine(), pathKt$$ExternalSyntheticBUOutline0);
        this.ejs = ejsChallengeSolver;
        this.githubPreprocessedPlayer = new GitHubPlayerConfigClient(httpClient, ejsChallengeSolver, remotePlayerConfigStore.repository, new NetworkFetcher.AnonymousClass2(1, remotePlayerConfigStore, RemotePlayerConfigStore.class, "validatedSourceUrlOrNull", "validatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex(Ljava/lang/String;)Lio/ktor/http/Url;", 0, (byte) 26), pathKt$$ExternalSyntheticBUOutline0);
        this.cache = new LinkedHashMap();
        this.zemerCache = new LinkedHashMap();
        this.playerCodeCache = new LinkedHashMap();
        this.playerCodeDownloads = new LinkedHashMap();
        this.cacheMutex = new MutexImpl();
        this.operationMutex = new MutexImpl();
    }

    public static String appendQueryParameter$com_github_MetrolistGroup_innertubex(String str, String str2, String str3) {
        String str4;
        str.getClass();
        if (!isApprovedMediaUrl(str) || !QUERY_PARAMETER_NAME_REGEX.matches(str2) || StringsKt.isBlank(str3) || str3.length() > 262144) {
            return null;
        }
        int iIndexOf$default = StringsKt.indexOf$default(str, '#', 0, 6);
        Integer numValueOf = iIndexOf$default >= 0 ? Integer.valueOf(iIndexOf$default) : null;
        int iIntValue = numValueOf != null ? numValueOf.intValue() : str.length();
        int iIndexOf$default2 = StringsKt.indexOf$default(str, '?', 0, 6);
        if (iIndexOf$default2 < 0 || iIndexOf$default2 >= iIntValue) {
            str4 = "?";
        } else {
            str4 = (iIntValue <= 0 || !StringsKt.contains$default("?&", str.charAt(iIntValue + (-1)))) ? "&" : "";
        }
        StringBuilder sb = new StringBuilder(str3.length() + str2.length() + str.length() + 2);
        sb.append((CharSequence) str, 0, iIntValue);
        sb.append(str4);
        sb.append(str2);
        sb.append('=');
        sb.append(encodeQueryComponent(str3));
        sb.append((CharSequence) str, iIntValue, str.length());
        return sb.toString();
    }

    public static String encodeQueryComponent(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (byte b : StringsKt__StringsJVMKt.encodeToByteArray(str)) {
            int i = b & 255;
            if ((48 > i || i >= 58) && ((65 > i || i >= 91) && !((97 <= i && i < 123) || i == 45 || i == 46 || i == 95 || i == 126))) {
                sb.append('%');
                sb.append("0123456789ABCDEF".charAt(i >>> 4));
                sb.append("0123456789ABCDEF".charAt(b & 15));
            } else {
                sb.append((char) i);
            }
        }
        return sb.toString();
    }

    public static String extractNParameter(String str) {
        MatcherMatchResult matcherMatchResultFindNParameter = findNParameter(str);
        if (matcherMatchResultFindNParameter != null) {
            return (String) ((ReversedListReadOnly) matcherMatchResultFindNParameter.getGroupValues()).get(1);
        }
        return null;
    }

    public static MatcherMatchResult findNParameter(String str) {
        if (isApprovedMediaUrl(str)) {
            int iIndexOf$default = StringsKt.indexOf$default(str, '#', 0, 6);
            Integer numValueOf = Integer.valueOf(iIndexOf$default);
            if (iIndexOf$default < 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : str.length();
            MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(N_PARAMETER_REGEX, str);
            if (matcherMatchResultFind$default != null && matcherMatchResultFind$default.getRange().first < iIntValue) {
                return matcherMatchResultFind$default;
            }
        }
        return null;
    }

    public static boolean isApprovedMediaUrl(String str) {
        Object failure;
        int length = str.length();
        if (1 > length || length >= 16385) {
            return false;
        }
        try {
            failure = URLUtilsKt.Url(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        Url url = (Url) failure;
        if (url == null) {
            return false;
        }
        return Intrinsics.areEqual(url.getProtocol().getName(), "https") && url.getPort() == 443 && (Intrinsics.areEqual(url.getHost(), "googlevideo.com") || StringsKt__StringsJVMKt.endsWith(url.getHost(), ".googlevideo.com", false) || Intrinsics.areEqual(url.getHost(), "youtube.com") || StringsKt__StringsJVMKt.endsWith(url.getHost(), ".youtube.com", false)) && Intrinsics.areEqual(url.getEncodedPath(), "/videoplayback") && url.getUser() == null && url.getPassword() == null;
    }

    public static String logId(String str) {
        String strExtractPlayerHash = RemotePlayerConfigParser.extractPlayerHash(str);
        return strExtractPlayerHash == null ? "unknown" : strExtractPlayerHash;
    }

    public static LinkedHashMap parseCipherParams(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = StringsKt.split$default(str, new String[]{"&"}, 0, 6).iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt.split$default((String) it.next(), new String[]{"="}, 2, 2);
            if (listSplit$default.size() == 2) {
                Object obj = listSplit$default.get(0);
                String str2 = (String) listSplit$default.get(1);
                str2.getClass();
                linkedHashMap.put(obj, CodecsKt.decodeURLQueryComponent$default(str2, 0, 0, true, null, 11, null));
            }
        }
        return linkedHashMap;
    }

    public static String replaceQueryParameter$com_github_MetrolistGroup_innertubex(String str, MatchResult matchResult, String str2) {
        str.getClass();
        matchResult.getClass();
        int iIndexOf$default = StringsKt.indexOf$default(str, '#', 0, 6);
        Integer numValueOf = Integer.valueOf(iIndexOf$default);
        if (iIndexOf$default < 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : str.length();
        if (isApprovedMediaUrl(str)) {
            MatcherMatchResult matcherMatchResult = (MatcherMatchResult) matchResult;
            if (matcherMatchResult.getRange().first < iIntValue && !StringsKt.isBlank(str2) && str2.length() <= 262144) {
                return StringsKt.replaceRange(str, (matcherMatchResult.getRange().last + 1) - ((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(1)).length(), matcherMatchResult.getRange().last + 1, encodeQueryComponent(str2)).toString();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x026e A[Catch: all -> 0x0284, TRY_LEAVE, TryCatch #0 {all -> 0x0284, blocks: (B:100:0x0268, B:102:0x026e, B:93:0x024e, B:96:0x0261, B:89:0x023b), top: B:123:0x023b }] */
    /* JADX WARN: Code duplicated, block: B:105:0x0281  */
    /* JADX WARN: Code duplicated, block: B:111:0x028b  */
    /* JADX WARN: Code duplicated, block: B:112:0x028d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0292  */
    /* JADX WARN: Code duplicated, block: B:116:0x0294  */
    /* JADX WARN: Code duplicated, block: B:135:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.metrolist.innertubex.cipher.PlayerScriptParser$ParseResult, com.metrolist.innertubex.cipher.QuickJsEngine, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final Object createSolver(String str, String str2, ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ?? r1;
        String string;
        PlayerScriptParser.ParseResult parseResult;
        String str3;
        PlayerScriptParser.ParseResult parseResult2;
        String str4;
        PlayerScriptParser.ParseResult parseResult3;
        QuickJsEngine quickJsEngine;
        QuickJsEngine quickJsEngine2;
        QuickJsEngine quickJsEngine3;
        boolean z;
        boolean z2;
        QuickJsEngine quickJsEngine4;
        QuickJsEngine quickJsEngine5;
        SubSequence.AnonymousClass1 anonymousClass2;
        Pair pair;
        String strExtractFunctionByName;
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
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Regex regex = PlayerScriptParser.functionPattern;
            str2.getClass();
            Pair pairExtractSplitJoinByIndex = PlayerScriptParser.extractSplitJoinByIndex(0, str2);
            String str5 = (String) pairExtractSplitJoinByIndex.first;
            String str6 = (String) pairExtractSplitJoinByIndex.second;
            List list = SequencesKt.toList(SequencesKt.mapNotNull(Regex.findAll$default(PlayerScriptParser.functionPattern, str2), new IconKt$$ExternalSyntheticLambda1(str2, (byte) 12)));
            int size = list.size();
            int i3 = 1;
            while (true) {
                if (i3 >= size) {
                    if (!list.isEmpty() && str5 == null) {
                        pair = PlayerScriptParser.extractSplitJoinByIndex(1, str2);
                        if (pair.first != null) {
                            break;
                        }
                        anonymousClass2 = new SubSequence.AnonymousClass1(Regex.findAll$default(new Regex("(?s)function\\s+([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*\\(\\s*a\\s*\\)\\s*\\{[^{}]*a\\s*[=.][^{}]*reverse[^{}]*\\}"), str2));
                        while (true) {
                            if (anonymousClass2.hasNext()) {
                                pair = new Pair(null, null);
                                break;
                            }
                            String str7 = (String) ((ReversedListReadOnly) ((MatcherMatchResult) ((MatchResult) anonymousClass2.next())).getGroupValues()).get(1);
                            strExtractFunctionByName = PlayerScriptParser.extractFunctionByName(str2, str7);
                            if (strExtractFunctionByName == null) {
                            }
                        }
                    } else {
                        anonymousClass2 = new SubSequence.AnonymousClass1(Regex.findAll$default(new Regex("(?s)function\\s+([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*\\(\\s*a\\s*\\)\\s*\\{[^{}]*a\\s*[=.][^{}]*reverse[^{}]*\\}"), str2));
                        while (true) {
                            if (anonymousClass2.hasNext()) {
                                pair = new Pair(null, null);
                                break;
                            }
                            String str8 = (String) ((ReversedListReadOnly) ((MatcherMatchResult) ((MatchResult) anonymousClass2.next())).getGroupValues()).get(1);
                            strExtractFunctionByName = PlayerScriptParser.extractFunctionByName(str2, str8);
                            if (strExtractFunctionByName == null && !strExtractFunctionByName.equals(str5) && (StringsKt.contains(strExtractFunctionByName, "reverse", false) || StringsKt.contains(strExtractFunctionByName, "splice", false) || StringsKt.contains(strExtractFunctionByName, "slice", false))) {
                                pair = new Pair(strExtractFunctionByName, str8);
                                break;
                            }
                        }
                    }
                } else {
                    String str9 = ((PlayerScriptParser.FunctionMatch) list.get(i3)).name;
                    String strExtractFunctionByName2 = PlayerScriptParser.extractFunctionByName(str2, str9);
                    if (strExtractFunctionByName2 != null && !strExtractFunctionByName2.equals(str5)) {
                        pair = new Pair(strExtractFunctionByName2, str9);
                        break;
                    }
                    i3++;
                }
            }
            String str10 = (String) pair.first;
            String str11 = (String) pair.second;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{new Regex("(?s)var\\s+([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*=\\s*\\{\\s*[^}]*reverse[^}]*\\}"), new Regex("(?s)var\\s+([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*=\\s*\\{\\s*[^}]*slice[^}]*\\}"), new Regex("(?s)var\\s+([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*=\\s*\\{\\s*[^}]*splice[^}]*\\}")}).iterator();
            while (it.hasNext()) {
                SubSequence.AnonymousClass1 anonymousClass3 = new SubSequence.AnonymousClass1(Regex.findAll$default((Regex) it.next(), str2));
                while (anonymousClass3.hasNext()) {
                    MatcherMatchResult matcherMatchResult = (MatcherMatchResult) ((MatchResult) anonymousClass3.next());
                    int i4 = matcherMatchResult.getRange().first;
                    int iFindFunctionEnd = PlayerScriptParser.findFunctionEnd(i4, str2);
                    if (iFindFunctionEnd > i4) {
                        linkedHashMap.put((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(1), str2.substring(i4, iFindFunctionEnd));
                    }
                }
            }
            parseResult = new PlayerScriptParser.ParseResult(str5, str6, str10, str11, linkedHashMap);
            Regex regex2 = PlayerScriptParser.functionPattern;
            StringBuilder sb = new StringBuilder();
            Iterator it2 = linkedHashMap.entrySet().iterator();
            while (it2.hasNext()) {
                sb.append((String) ((Map.Entry) it2.next()).getValue());
                sb.append('\n');
            }
            String str12 = parseResult.nFunctionCode;
            if (str12 != null) {
                sb.append(str12);
                sb.append('\n');
                String str13 = parseResult.nInvoker;
                if (str13 != null && !StringsKt.isBlank(str13)) {
                    sb.append(StringsKt__IndentKt.trimIndent("\n                    function _solveN(input) {\n                        try { return " + str13 + "(input); } catch(e) { return null; }\n                    }\n                    "));
                    sb.append('\n');
                }
            }
            String str14 = parseResult.sigFunctionCode;
            if (str14 != null) {
                sb.append(str14);
                sb.append('\n');
                String str15 = parseResult.sigInvoker;
                if (str15 != null && !StringsKt.isBlank(str15)) {
                    sb.append(StringsKt__IndentKt.trimIndent("\n                    function _solveSig(input) {\n                        try { return " + str15 + "(input); } catch(e) { return null; }\n                    }\n                    "));
                    sb.append('\n');
                }
            }
            string = sb.toString();
            quickJsEngine2 = new QuickJsEngine();
            try {
                anonymousClass1.L$0 = str;
                anonymousClass1.L$2 = parseResult;
                anonymousClass1.L$3 = string;
                anonymousClass1.L$4 = quickJsEngine2;
                anonymousClass1.label = 1;
                if (quickJsEngine2.initialize(anonymousClass1) != coroutineSingletons) {
                    str3 = str;
                    quickJsEngine5 = quickJsEngine2;
                }
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                quickJsEngine = quickJsEngine2;
                anonymousClass1.L$0 = r1;
                anonymousClass1.L$2 = r1;
                anonymousClass1.L$3 = r1;
                anonymousClass1.L$4 = r1;
                anonymousClass1.L$5 = th;
                anonymousClass1.label = 4;
                if (quickJsEngine.dispose(anonymousClass1) == coroutineSingletons) {
                    throw th;
                }
            }
            return coroutineSingletons;
        }
        try {
            if (i2 == 1) {
                QuickJsEngine quickJsEngine6 = anonymousClass1.L$4;
                string = anonymousClass1.L$3;
                parseResult = anonymousClass1.L$2;
                str3 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                quickJsEngine5 = quickJsEngine6;
            } else {
                if (i2 == 2) {
                    QuickJsEngine quickJsEngine7 = anonymousClass1.L$4;
                    string = anonymousClass1.L$3;
                    parseResult2 = anonymousClass1.L$2;
                    String str16 = anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str4 = str16;
                    quickJsEngine2 = quickJsEngine7;
                    quickJsEngine3 = quickJsEngine2;
                    if (!StringsKt.isBlank(string)) {
                        anonymousClass1.L$0 = str4;
                        anonymousClass1.L$2 = parseResult2;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.L$4 = quickJsEngine2;
                        anonymousClass1.label = 3;
                        if (quickJsEngine2.execute(string, anonymousClass1) != coroutineSingletons) {
                            parseResult3 = parseResult2;
                            quickJsEngine4 = quickJsEngine2;
                        }
                        return coroutineSingletons;
                    }
                    if (parseResult2.nFunctionCode != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (parseResult2.sigFunctionCode != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    return new CachedSolver(str4, quickJsEngine3, new YouTubeCipherService$createSolver$nSolver$1(z, quickJsEngine3, null, (byte) 0), new YouTubeCipherService$createSolver$nSolver$1(z2, quickJsEngine3, null, (byte) 1));
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th2 = anonymousClass1.L$5;
                    ResultKt.throwOnFailure(obj);
                    throw th2;
                }
                QuickJsEngine quickJsEngine8 = anonymousClass1.L$4;
                parseResult3 = anonymousClass1.L$2;
                str4 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                quickJsEngine4 = quickJsEngine8;
            }
            parseResult2 = parseResult3;
            quickJsEngine3 = quickJsEngine4;
            if (parseResult2.nFunctionCode != null) {
                z = true;
            } else {
                z = false;
            }
            if (parseResult2.sigFunctionCode != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            return new CachedSolver(str4, quickJsEngine3, new YouTubeCipherService$createSolver$nSolver$1(z, quickJsEngine3, null, (byte) 0), new YouTubeCipherService$createSolver$nSolver$1(z2, quickJsEngine3, null, (byte) 1));
        } catch (Throwable th3) {
            th = th3;
            r1 = 0;
            quickJsEngine = i2;
            anonymousClass1.L$0 = r1;
            anonymousClass1.L$2 = r1;
            anonymousClass1.L$3 = r1;
            anonymousClass1.L$4 = r1;
            anonymousClass1.L$5 = th;
            anonymousClass1.label = 4;
            if (quickJsEngine.dispose(anonymousClass1) == coroutineSingletons) {
                throw th;
            }
        }
        anonymousClass1.L$0 = str3;
        anonymousClass1.L$2 = parseResult;
        anonymousClass1.L$3 = string;
        anonymousClass1.L$4 = quickJsEngine5;
        anonymousClass1.label = 2;
        Object objExecute = quickJsEngine5.execute("if (typeof globalThis.XMLHttpRequest === \"undefined\") {\n    globalThis.XMLHttpRequest = { prototype: {} };\n}\nif (typeof URL === \"undefined\") {\n    globalThis.location = {\n        hash: \"\",\n        host: \"www.youtube.com\",\n        hostname: \"www.youtube.com\",\n        href: \"https://www.youtube.com/watch?v=yt-dlp-wins\",\n        origin: \"https://www.youtube.com\",\n        password: \"\",\n        pathname: \"/watch\",\n        port: \"\",\n        protocol: \"https:\",\n        search: \"?v=yt-dlp-wins\",\n        username: \"\",\n    };\n} else {\n    globalThis.location = new URL(\"https://www.youtube.com/watch?v=yt-dlp-wins\");\n}\nif (typeof globalThis.document === \"undefined\") {\n    globalThis.document = Object.create(null);\n}\nif (typeof globalThis.navigator === \"undefined\") {\n    globalThis.navigator = Object.create(null);\n}\nif (typeof globalThis.self === \"undefined\") {\n    globalThis.self = globalThis;\n}\nif (typeof globalThis.window === \"undefined\") {\n    globalThis.window = globalThis;\n}\nif (typeof globalThis.Intl === \"undefined\") {\n    const NumberFormat = function(locale, options) {\n        this.options = options || {};\n    };\n    NumberFormat.supportedLocalesOf = function(locales) {\n        return Array.isArray(locales) ? locales : [locales];\n    };\n    NumberFormat.prototype.format = function(value) {\n        let formatted = String(value);\n        const minimumDigits = this.options.minimumIntegerDigits || 0;\n        while (formatted.length < minimumDigits) formatted = \"0\" + formatted;\n        return formatted;\n    };\n    const DateTimeFormat = function() {};\n    DateTimeFormat.prototype.resolvedOptions = function() {\n        return { timeZone: \"UTC\" };\n    };\n    DateTimeFormat.prototype.format = function(value) {\n        return String(value);\n    };\n    globalThis.Intl = { NumberFormat, DateTimeFormat };\n}", anonymousClass1);
        if (objExecute != coroutineSingletons) {
            objExecute = Unit.INSTANCE;
        }
        if (objExecute != coroutineSingletons) {
            parseResult2 = parseResult;
            str4 = str3;
            quickJsEngine2 = quickJsEngine5;
            quickJsEngine3 = quickJsEngine2;
            if (!StringsKt.isBlank(string)) {
                anonymousClass1.L$0 = str4;
                anonymousClass1.L$2 = parseResult2;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = quickJsEngine2;
                anonymousClass1.label = 3;
                if (quickJsEngine2.execute(string, anonymousClass1) != coroutineSingletons) {
                    parseResult3 = parseResult2;
                    quickJsEngine4 = quickJsEngine2;
                    parseResult2 = parseResult3;
                    quickJsEngine3 = quickJsEngine4;
                }
            }
            if (parseResult2.nFunctionCode != null) {
                z = true;
            } else {
                z = false;
            }
            if (parseResult2.sigFunctionCode != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            return new CachedSolver(str4, quickJsEngine3, new YouTubeCipherService$createSolver$nSolver$1(z, quickJsEngine3, null, (byte) 0), new YouTubeCipherService$createSolver$nSolver$1(z2, quickJsEngine3, null, (byte) 1));
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00dd A[Catch: all -> 0x00f6, TryCatch #1 {all -> 0x00f6, blocks: (B:54:0x00ff, B:56:0x0105, B:62:0x0124, B:46:0x00d7, B:48:0x00dd, B:53:0x00fb, B:45:0x00cf, B:72:0x0149, B:73:0x014c, B:41:0x0095, B:44:0x00a5), top: B:78:0x0095, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0105 A[Catch: all -> 0x00f6, TryCatch #1 {all -> 0x00f6, blocks: (B:54:0x00ff, B:56:0x0105, B:62:0x0124, B:46:0x00d7, B:48:0x00dd, B:53:0x00fb, B:45:0x00cf, B:72:0x0149, B:73:0x014c, B:41:0x0095, B:44:0x00a5), top: B:78:0x0095, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x011f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0120  */
    /* JADX WARN: Code duplicated, block: B:65:0x013f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0143  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:88:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:? A[LOOP:0: B:54:0x00ff->B:92:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[LOOP:1: B:46:0x00d7->B:96:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
    
        if (r3.lock(r2) == r4) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object dispose(ContinuationImpl continuationImpl) throws Throwable {
        C01061 c01061;
        Mutex mutex;
        MutexImpl mutexImpl;
        Throwable th;
        Mutex mutex2;
        Iterator it;
        List list;
        Iterator it2;
        QuickJsEngine quickJsEngine;
        Object objWithContext;
        Object objDispose;
        LinkedHashMap linkedHashMap = this.zemerCache;
        LinkedHashMap linkedHashMap2 = this.cache;
        if (continuationImpl instanceof C01061) {
            c01061 = (C01061) continuationImpl;
            int i = c01061.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01061.label = i - Integer.MIN_VALUE;
            } else {
                c01061 = new C01061(continuationImpl);
            }
        } else {
            c01061 = new C01061(continuationImpl);
        }
        Object obj = c01061.result;
        int i2 = c01061.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.operationMutex;
                c01061.L$0 = mutex;
                c01061.label = 1;
                if (mutex.lock(c01061) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    mutexImpl = c01061.L$1;
                    Mutex mutex3 = c01061.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                        try {
                            Collection collectionValues = linkedHashMap2.values();
                            collectionValues.getClass();
                            List list2 = CollectionsKt.toList(collectionValues);
                            Collection collectionValues2 = linkedHashMap.values();
                            collectionValues2.getClass();
                            List list3 = CollectionsKt.toList(collectionValues2);
                            linkedHashMap2.clear();
                            linkedHashMap.clear();
                            this.playerCodeCache.clear();
                            this.playerCodeDownloads.clear();
                            mutexImpl.unlock(null);
                            it = list2.iterator();
                            list = list3;
                            while (it.hasNext()) {
                                quickJsEngine = ((CachedSolver) it.next()).engine;
                                c01061.L$0 = mutex;
                                c01061.L$1 = null;
                                c01061.L$3 = list;
                                c01061.L$4 = it;
                                c01061.label = 3;
                                if (quickJsEngine.dispose(c01061) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            it2 = list.iterator();
                            while (it2.hasNext()) {
                                ZemerCipherSolver zemerCipherSolver = ((CachedZemerSolver) it2.next()).solver;
                                c01061.L$0 = mutex;
                                c01061.L$1 = null;
                                c01061.L$3 = null;
                                c01061.L$4 = it2;
                                c01061.label = 4;
                                objDispose = zemerCipherSolver.engine.dispose(c01061);
                                if (objDispose != coroutineSingletons) {
                                    objDispose = unit;
                                }
                                if (objDispose == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            EjsChallengeSolver ejsChallengeSolver = this.ejs;
                            c01061.L$0 = mutex;
                            c01061.L$1 = null;
                            c01061.L$3 = null;
                            c01061.L$4 = null;
                            c01061.label = 5;
                            objWithContext = AwaitKt.withContext(NonCancellable.INSTANCE, new EjsChallengeSolver$dispose$2(ejsChallengeSolver, continuation, (byte) 0), c01061);
                            if (objWithContext != coroutineSingletons) {
                                objWithContext = unit;
                            }
                            if (objWithContext != coroutineSingletons) {
                                mutex2 = mutex;
                            }
                            return coroutineSingletons;
                        } catch (Throwable th2) {
                            mutexImpl.unlock(null);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        mutex2 = mutex3;
                    }
                } else if (i2 == 3) {
                    it = c01061.L$4;
                    list = c01061.L$3;
                    Mutex mutex4 = c01061.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex4;
                        while (it.hasNext()) {
                            quickJsEngine = ((CachedSolver) it.next()).engine;
                            c01061.L$0 = mutex;
                            c01061.L$1 = null;
                            c01061.L$3 = list;
                            c01061.L$4 = it;
                            c01061.label = 3;
                            if (quickJsEngine.dispose(c01061) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            ZemerCipherSolver zemerCipherSolver2 = ((CachedZemerSolver) it2.next()).solver;
                            c01061.L$0 = mutex;
                            c01061.L$1 = null;
                            c01061.L$3 = null;
                            c01061.L$4 = it2;
                            c01061.label = 4;
                            objDispose = zemerCipherSolver2.engine.dispose(c01061);
                            if (objDispose != coroutineSingletons) {
                                objDispose = unit;
                            }
                            if (objDispose == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        EjsChallengeSolver ejsChallengeSolver2 = this.ejs;
                        c01061.L$0 = mutex;
                        c01061.L$1 = null;
                        c01061.L$3 = null;
                        c01061.L$4 = null;
                        c01061.label = 5;
                        objWithContext = AwaitKt.withContext(NonCancellable.INSTANCE, new EjsChallengeSolver$dispose$2(ejsChallengeSolver2, continuation, (byte) 0), c01061);
                        if (objWithContext != coroutineSingletons) {
                            objWithContext = unit;
                        }
                        if (objWithContext != coroutineSingletons) {
                            mutex2 = mutex;
                        }
                        return coroutineSingletons;
                    } catch (Throwable th4) {
                        th = th4;
                        mutex2 = mutex4;
                    }
                } else if (i2 == 4) {
                    it2 = c01061.L$4;
                    Mutex mutex5 = c01061.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex5;
                        while (it2.hasNext()) {
                            ZemerCipherSolver zemerCipherSolver3 = ((CachedZemerSolver) it2.next()).solver;
                            c01061.L$0 = mutex;
                            c01061.L$1 = null;
                            c01061.L$3 = null;
                            c01061.L$4 = it2;
                            c01061.label = 4;
                            objDispose = zemerCipherSolver3.engine.dispose(c01061);
                            if (objDispose != coroutineSingletons) {
                                objDispose = unit;
                            }
                            if (objDispose == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        EjsChallengeSolver ejsChallengeSolver3 = this.ejs;
                        c01061.L$0 = mutex;
                        c01061.L$1 = null;
                        c01061.L$3 = null;
                        c01061.L$4 = null;
                        c01061.label = 5;
                        objWithContext = AwaitKt.withContext(NonCancellable.INSTANCE, new EjsChallengeSolver$dispose$2(ejsChallengeSolver3, continuation, (byte) 0), c01061);
                        if (objWithContext != coroutineSingletons) {
                            objWithContext = unit;
                        }
                        if (objWithContext != coroutineSingletons) {
                            mutex2 = mutex;
                        }
                        return coroutineSingletons;
                    } catch (Throwable th5) {
                        th = th5;
                        mutex2 = mutex5;
                    }
                } else {
                    if (i2 != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutex2 = c01061.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                mutex2.unlock(null);
                throw th;
            }
            Mutex mutex6 = c01061.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex6;
            mutex2.unlock(null);
            return unit;
            mutexImpl = this.cacheMutex;
            c01061.L$0 = mutex;
            c01061.L$1 = mutexImpl;
            c01061.label = 2;
        } catch (Throwable th7) {
            Mutex mutex7 = mutex;
            th = th7;
            mutex2 = mutex7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0098 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0099 A[Catch: Exception -> 0x0053, CancellationException -> 0x013a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x013a, blocks: (B:22:0x006d, B:26:0x0090, B:30:0x0099, B:32:0x00b3, B:37:0x00fe, B:16:0x004f), top: B:62:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:51:0x012d  */
    /* JADX WARN: Code duplicated, block: B:65:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x012d -> B:52:0x0130). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object downloadPlayerScript(java.lang.String r21, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.cipher.YouTubeCipherService.downloadPlayerScript(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b0 A[Catch: all -> 0x0049, TryCatch #1 {all -> 0x0049, blocks: (B:17:0x0045, B:35:0x009e, B:36:0x00a9, B:38:0x00b0, B:41:0x00c2, B:43:0x00ca, B:44:0x00ce), top: B:59:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c2 A[Catch: all -> 0x0049, TryCatch #1 {all -> 0x0049, blocks: (B:17:0x0045, B:35:0x009e, B:36:0x00a9, B:38:0x00b0, B:41:0x00c2, B:43:0x00ca, B:44:0x00ce), top: B:59:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:62:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:? A[LOOP:0: B:49:0x00e6->B:64:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getOrCreateSolver(String str, String str2, ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass4 anonymousClass4;
        String str3;
        Mutex mutex;
        String str4;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        Mutex mutex2;
        CachedSolver cachedSolver;
        Ref$ObjectRef ref$ObjectRef2;
        String str5;
        Iterator it;
        CachedSolver cachedSolver2;
        ArrayList arrayList;
        String str6;
        CachedSolver cachedSolver3;
        QuickJsEngine quickJsEngine;
        if (continuationImpl instanceof AnonymousClass4) {
            anonymousClass4 = (AnonymousClass4) continuationImpl;
            int i = anonymousClass4.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass4.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass4 = new AnonymousClass4(continuationImpl);
            }
        } else {
            anonymousClass4 = new AnonymousClass4(continuationImpl);
        }
        Object objCreateSolver = anonymousClass4.result;
        int i2 = anonymousClass4.label;
        LinkedHashMap linkedHashMap = this.cache;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(objCreateSolver);
                ref$ObjectRefM5m.element = EmptyList.INSTANCE;
                anonymousClass4.L$0 = str;
                anonymousClass4.L$1 = str2;
                anonymousClass4.L$2 = ref$ObjectRefM5m;
                MutexImpl mutexImpl = this.cacheMutex;
                anonymousClass4.L$3 = mutexImpl;
                anonymousClass4.label = 1;
                if (mutexImpl.lock(anonymousClass4) != obj) {
                    str3 = str;
                    mutex = mutexImpl;
                    str4 = str2;
                    ref$ObjectRef = ref$ObjectRefM5m;
                }
                return obj;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    mutex2 = (Mutex) anonymousClass4.L$3;
                    ref$ObjectRef2 = anonymousClass4.L$2;
                    str5 = anonymousClass4.L$0;
                    try {
                        ResultKt.throwOnFailure(objCreateSolver);
                        linkedHashMap.put(str5, (CachedSolver) objCreateSolver);
                        arrayList = new ArrayList();
                        while (linkedHashMap.size() > 4) {
                            Set setKeySet = linkedHashMap.keySet();
                            setKeySet.getClass();
                            str6 = (String) CollectionsKt.firstOrNull(setKeySet);
                            if (str6 == null) {
                                break;
                            }
                            cachedSolver3 = (CachedSolver) linkedHashMap.remove(str6);
                            if (cachedSolver3 != null) {
                                arrayList.add(cachedSolver3);
                            }
                        }
                        ref$ObjectRef2.element = arrayList;
                        cachedSolver = (CachedSolver) objCreateSolver;
                        ref$ObjectRef = ref$ObjectRef2;
                        mutex = mutex2;
                        mutex.unlock(null);
                        it = ((Iterable) ref$ObjectRef.element).iterator();
                        cachedSolver2 = cachedSolver;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                } else {
                    if (i2 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    it = anonymousClass4.L$5;
                    cachedSolver2 = (CachedSolver) anonymousClass4.L$3;
                    ResultKt.throwOnFailure(objCreateSolver);
                }
                while (it.hasNext()) {
                    quickJsEngine = ((CachedSolver) it.next()).engine;
                    anonymousClass4.L$0 = null;
                    anonymousClass4.L$1 = null;
                    anonymousClass4.L$2 = null;
                    anonymousClass4.L$3 = cachedSolver2;
                    anonymousClass4.L$5 = it;
                    anonymousClass4.label = 3;
                    if (quickJsEngine.dispose(anonymousClass4) == obj) {
                        return obj;
                    }
                }
                return cachedSolver2;
            }
            mutex = (Mutex) anonymousClass4.L$3;
            ref$ObjectRef = anonymousClass4.L$2;
            str4 = anonymousClass4.L$1;
            str3 = anonymousClass4.L$0;
            ResultKt.throwOnFailure(objCreateSolver);
            cachedSolver = (CachedSolver) linkedHashMap.remove(str3);
            if (cachedSolver != null) {
                linkedHashMap.put(str3, cachedSolver);
            } else {
                cachedSolver = null;
            }
            if (cachedSolver != null) {
                mutex.unlock(null);
                it = ((Iterable) ref$ObjectRef.element).iterator();
                cachedSolver2 = cachedSolver;
                while (it.hasNext()) {
                    quickJsEngine = ((CachedSolver) it.next()).engine;
                    anonymousClass4.L$0 = null;
                    anonymousClass4.L$1 = null;
                    anonymousClass4.L$2 = null;
                    anonymousClass4.L$3 = cachedSolver2;
                    anonymousClass4.L$5 = it;
                    anonymousClass4.label = 3;
                    if (quickJsEngine.dispose(anonymousClass4) == obj) {
                    }
                }
                return cachedSolver2;
            }
            anonymousClass4.L$0 = str3;
            anonymousClass4.L$1 = null;
            anonymousClass4.L$2 = ref$ObjectRef;
            anonymousClass4.L$3 = mutex;
            anonymousClass4.label = 2;
            objCreateSolver = createSolver(str3, str4, anonymousClass4);
            if (objCreateSolver != obj) {
                mutex2 = mutex;
                ref$ObjectRef2 = ref$ObjectRef;
                str5 = str3;
                linkedHashMap.put(str5, (CachedSolver) objCreateSolver);
                arrayList = new ArrayList();
                while (linkedHashMap.size() > 4) {
                    Set setKeySet2 = linkedHashMap.keySet();
                    setKeySet2.getClass();
                    str6 = (String) CollectionsKt.firstOrNull(setKeySet2);
                    if (str6 == null) {
                        break;
                        break;
                    }
                    cachedSolver3 = (CachedSolver) linkedHashMap.remove(str6);
                    if (cachedSolver3 != null) {
                        arrayList.add(cachedSolver3);
                    }
                }
                ref$ObjectRef2.element = arrayList;
                cachedSolver = (CachedSolver) objCreateSolver;
                ref$ObjectRef = ref$ObjectRef2;
                mutex = mutex2;
                mutex.unlock(null);
                it = ((Iterable) ref$ObjectRef.element).iterator();
                cachedSolver2 = cachedSolver;
                while (it.hasNext()) {
                    quickJsEngine = ((CachedSolver) it.next()).engine;
                    anonymousClass4.L$0 = null;
                    anonymousClass4.L$1 = null;
                    anonymousClass4.L$2 = null;
                    anonymousClass4.L$3 = cachedSolver2;
                    anonymousClass4.L$5 = it;
                    anonymousClass4.label = 3;
                    if (quickJsEngine.dispose(anonymousClass4) == obj) {
                    }
                }
                return cachedSolver2;
            }
            return obj;
        } catch (Throwable th3) {
            Mutex mutex3 = mutex;
            th = th3;
            mutex2 = mutex3;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x012b A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:43:0x010e, B:44:0x0124, B:46:0x012b, B:49:0x013d, B:51:0x0145, B:52:0x0149, B:28:0x00c0, B:30:0x00c8, B:32:0x00d0, B:34:0x00d8, B:39:0x00ed), top: B:78:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x013d A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:43:0x010e, B:44:0x0124, B:46:0x012b, B:49:0x013d, B:51:0x0145, B:52:0x0149, B:28:0x00c0, B:30:0x00c8, B:32:0x00d0, B:34:0x00d8, B:39:0x00ed), top: B:78:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x015b  */
    /* JADX WARN: Code duplicated, block: B:69:0x018f  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:? A[LOOP:0: B:67:0x0189->B:86:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x013c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0124 A[SYNTHETIC] */
    public final Object getOrCreateZemerSolver(String str, String str2, RemotePlayerConfigParser.HardcodedPlayerConfig hardcodedPlayerConfig, long j, ContinuationImpl continuationImpl) throws Throwable {
        C01081 c01081;
        Ref$ObjectRef ref$ObjectRefM5m;
        String str3;
        String str4;
        RemotePlayerConfigParser.HardcodedPlayerConfig hardcodedPlayerConfig2;
        long j2;
        Mutex mutex;
        Ref$ObjectRef ref$ObjectRef;
        Object obj;
        Ref$ObjectRef ref$ObjectRef2;
        long j3;
        String str5;
        Ref$ObjectRef ref$ObjectRef3;
        ZemerCipherSolver zemerCipherSolver;
        long j4;
        CachedZemerSolver cachedZemerSolver;
        ZemerCipherSolver zemerCipherSolver2;
        Ref$ObjectRef ref$ObjectRef4;
        ArrayList arrayList;
        String str6;
        CachedZemerSolver cachedZemerSolver2;
        ZemerCipherSolver zemerCipherSolver3;
        Iterator it;
        Object objDispose;
        if (continuationImpl instanceof C01081) {
            c01081 = (C01081) continuationImpl;
            int i = c01081.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01081.label = i - Integer.MIN_VALUE;
            } else {
                c01081 = new C01081(continuationImpl);
            }
        } else {
            c01081 = new C01081(continuationImpl);
        }
        Object obj2 = c01081.result;
        int i2 = c01081.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        LinkedHashMap linkedHashMap = this.zemerCache;
        try {
            if (i2 == 0) {
                ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj2);
                ref$ObjectRefM5m.element = EmptyList.INSTANCE;
                Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
                str3 = str;
                c01081.L$0 = str3;
                str4 = str2;
                c01081.L$1 = str4;
                hardcodedPlayerConfig2 = hardcodedPlayerConfig;
                c01081.L$2 = hardcodedPlayerConfig2;
                c01081.L$3 = ref$ObjectRefM5m;
                c01081.L$4 = ref$ObjectRef5;
                MutexImpl mutexImpl = this.cacheMutex;
                c01081.L$5 = mutexImpl;
                j2 = j;
                c01081.J$0 = j2;
                c01081.label = 1;
                if (mutexImpl.lock(c01081) != coroutineSingletons) {
                    mutex = mutexImpl;
                    ref$ObjectRef = ref$ObjectRef5;
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    j3 = c01081.J$0;
                    mutex = (Mutex) c01081.L$5;
                    ref$ObjectRef = c01081.L$4;
                    ref$ObjectRef2 = c01081.L$3;
                    hardcodedPlayerConfig2 = c01081.L$2;
                    str5 = c01081.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ref$ObjectRef.element = linkedHashMap.remove(str5);
                        linkedHashMap.put(str5, new CachedZemerSolver(hardcodedPlayerConfig2, j3, (ZemerCipherSolver) obj2));
                        arrayList = new ArrayList();
                        while (linkedHashMap.size() > 4) {
                            Set setKeySet = linkedHashMap.keySet();
                            setKeySet.getClass();
                            str6 = (String) CollectionsKt.firstOrNull(setKeySet);
                            if (str6 == null) {
                                break;
                            }
                            cachedZemerSolver2 = (CachedZemerSolver) linkedHashMap.remove(str6);
                            if (cachedZemerSolver2 != null) {
                                arrayList.add(cachedZemerSolver2);
                            }
                        }
                        ref$ObjectRef2.element = arrayList;
                        ZemerCipherSolver zemerCipherSolver4 = (ZemerCipherSolver) obj2;
                        ref$ObjectRef3 = ref$ObjectRef;
                        zemerCipherSolver = zemerCipherSolver4;
                        j4 = j3;
                        mutex.unlock(null);
                        cachedZemerSolver = (CachedZemerSolver) ref$ObjectRef3.element;
                        if (cachedZemerSolver != null || (zemerCipherSolver2 = cachedZemerSolver.solver) == null) {
                            zemerCipherSolver3 = zemerCipherSolver;
                            it = ((Iterable) ref$ObjectRef2.element).iterator();
                        } else {
                            c01081.L$0 = null;
                            c01081.L$1 = null;
                            c01081.L$2 = null;
                            c01081.L$3 = ref$ObjectRef2;
                            c01081.L$4 = null;
                            c01081.L$5 = zemerCipherSolver;
                            c01081.J$0 = j4;
                            c01081.label = 3;
                            Object objDispose2 = zemerCipherSolver2.engine.dispose(c01081);
                            if (objDispose2 != coroutineSingletons) {
                                objDispose2 = unit;
                            }
                            if (objDispose2 != coroutineSingletons) {
                                ref$ObjectRef4 = ref$ObjectRef2;
                                ref$ObjectRef2 = ref$ObjectRef4;
                                zemerCipherSolver3 = zemerCipherSolver;
                                it = ((Iterable) ref$ObjectRef2.element).iterator();
                            }
                        }
                        return coroutineSingletons;
                    } catch (Throwable th) {
                        th = th;
                        obj = null;
                        mutex.unlock(obj);
                        throw th;
                    }
                }
                if (i2 == 3) {
                    j4 = c01081.J$0;
                    zemerCipherSolver = (ZemerCipherSolver) c01081.L$5;
                    ref$ObjectRef4 = c01081.L$3;
                    ResultKt.throwOnFailure(obj2);
                    ref$ObjectRef2 = ref$ObjectRef4;
                    zemerCipherSolver3 = zemerCipherSolver;
                    it = ((Iterable) ref$ObjectRef2.element).iterator();
                } else {
                    if (i2 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    j4 = c01081.J$0;
                    it = c01081.L$7;
                    zemerCipherSolver3 = (ZemerCipherSolver) c01081.L$5;
                    ResultKt.throwOnFailure(obj2);
                }
                while (it.hasNext()) {
                    ZemerCipherSolver zemerCipherSolver5 = ((CachedZemerSolver) it.next()).solver;
                    c01081.L$0 = null;
                    c01081.L$1 = null;
                    c01081.L$2 = null;
                    c01081.L$3 = null;
                    c01081.L$4 = null;
                    c01081.L$5 = zemerCipherSolver3;
                    c01081.L$7 = it;
                    c01081.J$0 = j4;
                    c01081.label = 4;
                    objDispose = zemerCipherSolver5.engine.dispose(c01081);
                    if (objDispose != coroutineSingletons) {
                        objDispose = unit;
                    }
                    if (objDispose == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return zemerCipherSolver3;
            }
            long j5 = c01081.J$0;
            Mutex mutex2 = (Mutex) c01081.L$5;
            Ref$ObjectRef ref$ObjectRef6 = c01081.L$4;
            Ref$ObjectRef ref$ObjectRef7 = c01081.L$3;
            RemotePlayerConfigParser.HardcodedPlayerConfig hardcodedPlayerConfig3 = c01081.L$2;
            String str7 = c01081.L$1;
            str3 = c01081.L$0;
            ResultKt.throwOnFailure(obj2);
            mutex = mutex2;
            ref$ObjectRef = ref$ObjectRef6;
            ref$ObjectRefM5m = ref$ObjectRef7;
            hardcodedPlayerConfig2 = hardcodedPlayerConfig3;
            str4 = str7;
            j2 = j5;
            CachedZemerSolver cachedZemerSolver3 = (CachedZemerSolver) linkedHashMap.get(str3);
            if (cachedZemerSolver3 != null && Intrinsics.areEqual(cachedZemerSolver3.config, hardcodedPlayerConfig2)) {
                if (cachedZemerSolver3.configEpoch == j2) {
                    linkedHashMap.remove(str3);
                    linkedHashMap.put(str3, cachedZemerSolver3);
                    ref$ObjectRef2 = ref$ObjectRefM5m;
                    ref$ObjectRef3 = ref$ObjectRef;
                    zemerCipherSolver = cachedZemerSolver3.solver;
                    j4 = j2;
                    mutex.unlock(null);
                    cachedZemerSolver = (CachedZemerSolver) ref$ObjectRef3.element;
                    if (cachedZemerSolver != null) {
                    }
                    zemerCipherSolver3 = zemerCipherSolver;
                    it = ((Iterable) ref$ObjectRef2.element).iterator();
                    while (it.hasNext()) {
                        ZemerCipherSolver zemerCipherSolver6 = ((CachedZemerSolver) it.next()).solver;
                        c01081.L$0 = null;
                        c01081.L$1 = null;
                        c01081.L$2 = null;
                        c01081.L$3 = null;
                        c01081.L$4 = null;
                        c01081.L$5 = zemerCipherSolver3;
                        c01081.L$7 = it;
                        c01081.J$0 = j4;
                        c01081.label = 4;
                        objDispose = zemerCipherSolver6.engine.dispose(c01081);
                        if (objDispose != coroutineSingletons) {
                            objDispose = unit;
                        }
                        if (objDispose == coroutineSingletons) {
                        }
                    }
                    return zemerCipherSolver3;
                }
                return coroutineSingletons;
            }
            Path.Companion companion = ZemerCipherSolver.Companion;
            c01081.L$0 = str3;
            c01081.L$1 = null;
            c01081.L$2 = hardcodedPlayerConfig2;
            c01081.L$3 = ref$ObjectRefM5m;
            c01081.L$4 = ref$ObjectRef;
            c01081.L$5 = mutex;
            c01081.J$0 = j2;
            c01081.label = 2;
            Object objCreate = companion.create(str4, hardcodedPlayerConfig2, c01081);
            if (objCreate != coroutineSingletons) {
                ref$ObjectRef2 = ref$ObjectRefM5m;
                obj2 = objCreate;
                j3 = j2;
                str5 = str3;
                ref$ObjectRef.element = linkedHashMap.remove(str5);
                linkedHashMap.put(str5, new CachedZemerSolver(hardcodedPlayerConfig2, j3, (ZemerCipherSolver) obj2));
                arrayList = new ArrayList();
                while (linkedHashMap.size() > 4) {
                    Set setKeySet2 = linkedHashMap.keySet();
                    setKeySet2.getClass();
                    str6 = (String) CollectionsKt.firstOrNull(setKeySet2);
                    if (str6 == null) {
                        break;
                        break;
                    }
                    cachedZemerSolver2 = (CachedZemerSolver) linkedHashMap.remove(str6);
                    if (cachedZemerSolver2 != null) {
                        arrayList.add(cachedZemerSolver2);
                    }
                }
                ref$ObjectRef2.element = arrayList;
                ZemerCipherSolver zemerCipherSolver7 = (ZemerCipherSolver) obj2;
                ref$ObjectRef3 = ref$ObjectRef;
                zemerCipherSolver = zemerCipherSolver7;
                j4 = j3;
                mutex.unlock(null);
                cachedZemerSolver = (CachedZemerSolver) ref$ObjectRef3.element;
                if (cachedZemerSolver != null) {
                }
                zemerCipherSolver3 = zemerCipherSolver;
                it = ((Iterable) ref$ObjectRef2.element).iterator();
                while (it.hasNext()) {
                    ZemerCipherSolver zemerCipherSolver8 = ((CachedZemerSolver) it.next()).solver;
                    c01081.L$0 = null;
                    c01081.L$1 = null;
                    c01081.L$2 = null;
                    c01081.L$3 = null;
                    c01081.L$4 = null;
                    c01081.L$5 = zemerCipherSolver3;
                    c01081.L$7 = it;
                    c01081.J$0 = j4;
                    c01081.label = 4;
                    objDispose = zemerCipherSolver8.engine.dispose(c01081);
                    if (objDispose != coroutineSingletons) {
                        objDispose = unit;
                    }
                    if (objDispose == coroutineSingletons) {
                    }
                }
                return zemerCipherSolver3;
            }
            return coroutineSingletons;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
            mutex.unlock(obj);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e3 A[Catch: all -> 0x01e7, TRY_LEAVE, TryCatch #6 {all -> 0x01e7, blocks: (B:98:0x01dd, B:100:0x01e3), top: B:128:0x01dd }] */
    /* JADX WARN: Code duplicated, block: B:111:0x020e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0215 A[Catch: all -> 0x0219, TRY_LEAVE, TryCatch #8 {all -> 0x0219, blocks: (B:112:0x020f, B:114:0x0215), top: B:130:0x020f }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d0 A[Catch: all -> 0x00d4, TryCatch #3 {all -> 0x00d4, blocks: (B:36:0x00c8, B:38:0x00d0, B:42:0x00d8, B:44:0x00dc, B:46:0x00e4), top: B:124:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00dc A[Catch: all -> 0x00d4, TryCatch #3 {all -> 0x00d4, blocks: (B:36:0x00c8, B:38:0x00d0, B:42:0x00d8, B:44:0x00dc, B:46:0x00e4), top: B:124:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #3 {all -> 0x00d4, blocks: (B:36:0x00c8, B:38:0x00d0, B:42:0x00d8, B:44:0x00dc, B:46:0x00e4), top: B:124:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:51:0x0100  */
    /* JADX WARN: Code duplicated, block: B:53:0x0106  */
    /* JADX WARN: Code duplicated, block: B:58:0x0123  */
    /* JADX WARN: Code duplicated, block: B:60:0x0127  */
    /* JADX WARN: Code duplicated, block: B:68:0x015d  */
    /* JADX WARN: Code duplicated, block: B:72:0x017d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0187 A[Catch: all -> 0x01a7, TryCatch #5 {all -> 0x01a7, blocks: (B:73:0x017e, B:74:0x0181, B:76:0x0187, B:79:0x0199, B:80:0x019d, B:82:0x01a3), top: B:126:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0199 A[Catch: all -> 0x01a7, LOOP:0: B:74:0x0181->B:79:0x0199, LOOP_END, TryCatch #5 {all -> 0x01a7, blocks: (B:73:0x017e, B:74:0x0181, B:76:0x0187, B:79:0x0199, B:80:0x019d, B:82:0x01a3), top: B:126:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a3 A[Catch: all -> 0x01a7, TRY_LEAVE, TryCatch #5 {all -> 0x01a7, blocks: (B:73:0x017e, B:74:0x0181, B:76:0x0187, B:79:0x0199, B:80:0x019d, B:82:0x01a3), top: B:126:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01dc  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0117, code lost:
    
        if (r14 == r8) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013a, code lost:
    
        if (r14 == r8) goto L110;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.metrolist.innertubex.cipher.YouTubeCipherService] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getOrDownloadPlayerCode(String str, ContinuationImpl continuationImpl) {
        C01091 c01091;
        ?? r13;
        ?? r14;
        String str2;
        String str3;
        String str4;
        String str5;
        ?? r15;
        ?? r16;
        Ref$ObjectRef ref$ObjectRefM5m;
        Ref$ObjectRef ref$ObjectRef;
        Ref$BooleanRef ref$BooleanRef;
        Mutex mutex;
        String str6;
        String str7;
        CompletableDeferred completableDeferred;
        Object objDownloadPlayerScript;
        CompletableDeferred completableDeferred2;
        Object obj;
        String str8;
        String str9;
        MutexImpl mutexImpl;
        String str10;
        if (continuationImpl instanceof C01091) {
            c01091 = (C01091) continuationImpl;
            int i = c01091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01091.label = i - Integer.MIN_VALUE;
            } else {
                c01091 = new C01091(continuationImpl);
            }
        } else {
            c01091 = new C01091(continuationImpl);
        }
        Object objAwaitInternal = c01091.result;
        ?? r1 = c01091.label;
        LinkedHashMap linkedHashMap = this.playerCodeCache;
        MutexImpl mutexImpl2 = this.cacheMutex;
        LinkedHashMap linkedHashMap2 = this.playerCodeDownloads;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            switch (r1) {
                case 0:
                    ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(objAwaitInternal);
                    ref$ObjectRef = new Ref$ObjectRef();
                    ref$BooleanRef = new Ref$BooleanRef();
                    c01091.L$0 = str;
                    c01091.L$1 = ref$ObjectRefM5m;
                    c01091.L$2 = ref$ObjectRef;
                    c01091.L$3 = ref$BooleanRef;
                    c01091.L$4 = mutexImpl2;
                    c01091.label = 1;
                    if (mutexImpl2.lock(c01091) != coroutineSingletons) {
                        mutex = mutexImpl2;
                        try {
                            str6 = (String) linkedHashMap.remove(str);
                            if (str6 != null) {
                                linkedHashMap.put(str, str6);
                            } else {
                                str6 = null;
                            }
                            ref$ObjectRefM5m.element = str6;
                            if (str6 == null) {
                                obj = linkedHashMap2.get(str);
                                ref$ObjectRef.element = obj;
                                if (obj == null) {
                                    CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
                                    ref$ObjectRef.element = completableDeferredImplCompletableDeferred$default;
                                    linkedHashMap2.put(str, completableDeferredImplCompletableDeferred$default);
                                    ref$BooleanRef.element = true;
                                }
                            }
                            mutex.unlock(null);
                            str7 = (String) ref$ObjectRefM5m.element;
                            if (str7 != null) {
                                return new PlayerCodeResult(str7, "preloaded");
                            }
                            completableDeferred = (CompletableDeferred) ref$ObjectRef.element;
                            if (completableDeferred != null) {
                                c01091.L$0 = null;
                                c01091.L$1 = null;
                                c01091.L$2 = null;
                                c01091.L$3 = null;
                                c01091.L$4 = null;
                                c01091.label = 2;
                                objAwaitInternal = downloadPlayerScript(str, c01091);
                                break;
                            } else if (!ref$BooleanRef.element) {
                                c01091.L$0 = null;
                                c01091.L$1 = null;
                                c01091.L$2 = null;
                                c01091.L$3 = null;
                                c01091.L$4 = null;
                                c01091.label = 3;
                                objAwaitInternal = ((CompletableDeferredImpl) completableDeferred).awaitInternal(c01091);
                                break;
                            } else {
                                try {
                                    c01091.L$0 = str;
                                    c01091.L$1 = null;
                                    c01091.L$2 = null;
                                    c01091.L$3 = null;
                                    c01091.L$4 = completableDeferred;
                                    c01091.label = 4;
                                    objDownloadPlayerScript = downloadPlayerScript(str, c01091);
                                    if (objDownloadPlayerScript != coroutineSingletons) {
                                        completableDeferred2 = completableDeferred;
                                        objAwaitInternal = objDownloadPlayerScript;
                                        str8 = str;
                                        str9 = (String) objAwaitInternal;
                                        c01091.L$0 = str8;
                                        c01091.L$1 = null;
                                        c01091.L$2 = null;
                                        c01091.L$3 = null;
                                        c01091.L$4 = completableDeferred2;
                                        c01091.L$5 = str9;
                                        c01091.L$6 = mutexImpl2;
                                        c01091.label = 5;
                                        if (mutexImpl2.lock(c01091) != coroutineSingletons) {
                                            mutexImpl = mutexImpl2;
                                            try {
                                                linkedHashMap.put(str8, str9);
                                                while (linkedHashMap.size() > 1) {
                                                    Set setKeySet = linkedHashMap.keySet();
                                                    setKeySet.getClass();
                                                    str10 = (String) CollectionsKt.firstOrNull(setKeySet);
                                                    if (str10 == null) {
                                                        if (linkedHashMap2.get(str8) == completableDeferred2) {
                                                            linkedHashMap2.remove(str8);
                                                            break;
                                                        }
                                                        mutexImpl.unlock(null);
                                                        ((CompletableDeferredImpl) completableDeferred2).makeCompleting$kotlinx_coroutines_core(str9);
                                                        return new PlayerCodeResult(str9, "downloaded");
                                                    }
                                                    linkedHashMap.remove(str10);
                                                }
                                                if (linkedHashMap2.get(str8) == completableDeferred2) {
                                                    linkedHashMap2.remove(str8);
                                                    break;
                                                }
                                                mutexImpl.unlock(null);
                                                ((CompletableDeferredImpl) completableDeferred2).makeCompleting$kotlinx_coroutines_core(str9);
                                                return new PlayerCodeResult(str9, "downloaded");
                                            } catch (Throwable th) {
                                                mutexImpl.unlock(null);
                                                throw th;
                                            }
                                        }
                                    }
                                } catch (CancellationException e) {
                                    e = e;
                                    str4 = str;
                                    r14 = completableDeferred;
                                    c01091.L$0 = str4;
                                    c01091.L$1 = null;
                                    c01091.L$2 = null;
                                    c01091.L$3 = null;
                                    c01091.L$4 = r14;
                                    c01091.L$5 = e;
                                    c01091.L$6 = mutexImpl2;
                                    c01091.label = 6;
                                    if (mutexImpl2.lock(c01091) != coroutineSingletons) {
                                        str5 = str4;
                                        r15 = r14;
                                        try {
                                            if (linkedHashMap2.get(str5) == r15) {
                                                linkedHashMap2.remove(str5);
                                                break;
                                            }
                                            mutexImpl2.unlock(null);
                                            ((CompletableDeferredImpl) r15).completeExceptionally(e);
                                            throw e;
                                        } catch (Throwable th2) {
                                            mutexImpl2.unlock(null);
                                            throw th2;
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str2 = str;
                                    r13 = completableDeferred;
                                    c01091.L$0 = str2;
                                    c01091.L$1 = null;
                                    c01091.L$2 = null;
                                    c01091.L$3 = null;
                                    c01091.L$4 = r13;
                                    c01091.L$5 = e;
                                    c01091.L$6 = mutexImpl2;
                                    c01091.label = 7;
                                    if (mutexImpl2.lock(c01091) != coroutineSingletons) {
                                        str3 = str2;
                                        r16 = r13;
                                        try {
                                            if (linkedHashMap2.get(str3) == r16) {
                                                linkedHashMap2.remove(str3);
                                                break;
                                            }
                                            mutexImpl2.unlock(null);
                                            ((CompletableDeferredImpl) r16).completeExceptionally(e);
                                            throw e;
                                        } catch (Throwable th3) {
                                            mutexImpl2.unlock(null);
                                            throw th3;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            mutex.unlock(null);
                            throw th4;
                        }
                        break;
                    }
                    return coroutineSingletons;
                case 1:
                    Mutex mutex2 = (Mutex) c01091.L$4;
                    ref$BooleanRef = c01091.L$3;
                    ref$ObjectRef = c01091.L$2;
                    ref$ObjectRefM5m = c01091.L$1;
                    String str11 = c01091.L$0;
                    ResultKt.throwOnFailure(objAwaitInternal);
                    mutex = mutex2;
                    str = str11;
                    str6 = (String) linkedHashMap.remove(str);
                    if (str6 != null) {
                        linkedHashMap.put(str, str6);
                    } else {
                        str6 = null;
                    }
                    ref$ObjectRefM5m.element = str6;
                    if (str6 == null) {
                        obj = linkedHashMap2.get(str);
                        ref$ObjectRef.element = obj;
                        if (obj == null) {
                            CompletableDeferredImpl completableDeferredImplCompletableDeferred$default2 = AwaitKt.CompletableDeferred$default();
                            ref$ObjectRef.element = completableDeferredImplCompletableDeferred$default2;
                            linkedHashMap2.put(str, completableDeferredImplCompletableDeferred$default2);
                            ref$BooleanRef.element = true;
                        }
                        break;
                    }
                    mutex.unlock(null);
                    str7 = (String) ref$ObjectRefM5m.element;
                    if (str7 != null) {
                        return new PlayerCodeResult(str7, "preloaded");
                    }
                    completableDeferred = (CompletableDeferred) ref$ObjectRef.element;
                    if (completableDeferred != null) {
                        if (!ref$BooleanRef.element) {
                            c01091.L$0 = null;
                            c01091.L$1 = null;
                            c01091.L$2 = null;
                            c01091.L$3 = null;
                            c01091.L$4 = null;
                            c01091.label = 3;
                            objAwaitInternal = ((CompletableDeferredImpl) completableDeferred).awaitInternal(c01091);
                        } else {
                            c01091.L$0 = str;
                            c01091.L$1 = null;
                            c01091.L$2 = null;
                            c01091.L$3 = null;
                            c01091.L$4 = completableDeferred;
                            c01091.label = 4;
                            objDownloadPlayerScript = downloadPlayerScript(str, c01091);
                            if (objDownloadPlayerScript != coroutineSingletons) {
                                completableDeferred2 = completableDeferred;
                                objAwaitInternal = objDownloadPlayerScript;
                                str8 = str;
                                str9 = (String) objAwaitInternal;
                                c01091.L$0 = str8;
                                c01091.L$1 = null;
                                c01091.L$2 = null;
                                c01091.L$3 = null;
                                c01091.L$4 = completableDeferred2;
                                c01091.L$5 = str9;
                                c01091.L$6 = mutexImpl2;
                                c01091.label = 5;
                                if (mutexImpl2.lock(c01091) != coroutineSingletons) {
                                    mutexImpl = mutexImpl2;
                                    linkedHashMap.put(str8, str9);
                                    while (linkedHashMap.size() > 1) {
                                        Set setKeySet2 = linkedHashMap.keySet();
                                        setKeySet2.getClass();
                                        str10 = (String) CollectionsKt.firstOrNull(setKeySet2);
                                        if (str10 == null) {
                                            if (linkedHashMap2.get(str8) == completableDeferred2) {
                                                linkedHashMap2.remove(str8);
                                                break;
                                            }
                                            mutexImpl.unlock(null);
                                            ((CompletableDeferredImpl) completableDeferred2).makeCompleting$kotlinx_coroutines_core(str9);
                                            return new PlayerCodeResult(str9, "downloaded");
                                        }
                                        linkedHashMap.remove(str10);
                                    }
                                    if (linkedHashMap2.get(str8) == completableDeferred2) {
                                        linkedHashMap2.remove(str8);
                                        break;
                                    }
                                    mutexImpl.unlock(null);
                                    ((CompletableDeferredImpl) completableDeferred2).makeCompleting$kotlinx_coroutines_core(str9);
                                    return new PlayerCodeResult(str9, "downloaded");
                                }
                            }
                        }
                        break;
                    } else {
                        c01091.L$0 = null;
                        c01091.L$1 = null;
                        c01091.L$2 = null;
                        c01091.L$3 = null;
                        c01091.L$4 = null;
                        c01091.label = 2;
                        objAwaitInternal = downloadPlayerScript(str, c01091);
                        break;
                    }
                    return coroutineSingletons;
                case 2:
                    ResultKt.throwOnFailure(objAwaitInternal);
                    return new PlayerCodeResult((String) objAwaitInternal, "downloaded");
                case 3:
                    ResultKt.throwOnFailure(objAwaitInternal);
                    return new PlayerCodeResult((String) objAwaitInternal, "in-flight");
                case 4:
                    CompletableDeferred completableDeferred3 = (CompletableDeferred) c01091.L$4;
                    str = c01091.L$0;
                    try {
                        ResultKt.throwOnFailure(objAwaitInternal);
                        completableDeferred2 = completableDeferred3;
                        str8 = str;
                        str9 = (String) objAwaitInternal;
                        c01091.L$0 = str8;
                        c01091.L$1 = null;
                        c01091.L$2 = null;
                        c01091.L$3 = null;
                        c01091.L$4 = completableDeferred2;
                        c01091.L$5 = str9;
                        c01091.L$6 = mutexImpl2;
                        c01091.label = 5;
                        if (mutexImpl2.lock(c01091) != coroutineSingletons) {
                            mutexImpl = mutexImpl2;
                            linkedHashMap.put(str8, str9);
                            while (linkedHashMap.size() > 1) {
                                Set setKeySet3 = linkedHashMap.keySet();
                                setKeySet3.getClass();
                                str10 = (String) CollectionsKt.firstOrNull(setKeySet3);
                                if (str10 == null) {
                                    if (linkedHashMap2.get(str8) == completableDeferred2) {
                                        linkedHashMap2.remove(str8);
                                        break;
                                    }
                                    mutexImpl.unlock(null);
                                    ((CompletableDeferredImpl) completableDeferred2).makeCompleting$kotlinx_coroutines_core(str9);
                                    return new PlayerCodeResult(str9, "downloaded");
                                }
                                linkedHashMap.remove(str10);
                            }
                            if (linkedHashMap2.get(str8) == completableDeferred2) {
                                linkedHashMap2.remove(str8);
                                break;
                            }
                            mutexImpl.unlock(null);
                            ((CompletableDeferredImpl) completableDeferred2).makeCompleting$kotlinx_coroutines_core(str9);
                            return new PlayerCodeResult(str9, "downloaded");
                        }
                    } catch (CancellationException e3) {
                        str4 = str;
                        r14 = completableDeferred3;
                        e = e3;
                        c01091.L$0 = str4;
                        c01091.L$1 = null;
                        c01091.L$2 = null;
                        c01091.L$3 = null;
                        c01091.L$4 = r14;
                        c01091.L$5 = e;
                        c01091.L$6 = mutexImpl2;
                        c01091.label = 6;
                        if (mutexImpl2.lock(c01091) != coroutineSingletons) {
                            str5 = str4;
                            r15 = r14;
                            if (linkedHashMap2.get(str5) == r15) {
                                linkedHashMap2.remove(str5);
                                break;
                            }
                            mutexImpl2.unlock(null);
                            ((CompletableDeferredImpl) r15).completeExceptionally(e);
                            throw e;
                        }
                    } catch (Exception e4) {
                        str2 = str;
                        r13 = completableDeferred3;
                        e = e4;
                        c01091.L$0 = str2;
                        c01091.L$1 = null;
                        c01091.L$2 = null;
                        c01091.L$3 = null;
                        c01091.L$4 = r13;
                        c01091.L$5 = e;
                        c01091.L$6 = mutexImpl2;
                        c01091.label = 7;
                        if (mutexImpl2.lock(c01091) != coroutineSingletons) {
                            str3 = str2;
                            r16 = r13;
                            if (linkedHashMap2.get(str3) == r16) {
                                linkedHashMap2.remove(str3);
                                break;
                            }
                            mutexImpl2.unlock(null);
                            ((CompletableDeferredImpl) r16).completeExceptionally(e);
                            throw e;
                        }
                    }
                    return coroutineSingletons;
                case 5:
                    mutexImpl = c01091.L$6;
                    str9 = (String) c01091.L$5;
                    completableDeferred2 = (CompletableDeferred) c01091.L$4;
                    str8 = c01091.L$0;
                    ResultKt.throwOnFailure(objAwaitInternal);
                    linkedHashMap.put(str8, str9);
                    while (linkedHashMap.size() > 1) {
                        Set setKeySet4 = linkedHashMap.keySet();
                        setKeySet4.getClass();
                        str10 = (String) CollectionsKt.firstOrNull(setKeySet4);
                        if (str10 == null) {
                            if (linkedHashMap2.get(str8) == completableDeferred2) {
                                linkedHashMap2.remove(str8);
                                break;
                            }
                            mutexImpl.unlock(null);
                            ((CompletableDeferredImpl) completableDeferred2).makeCompleting$kotlinx_coroutines_core(str9);
                            return new PlayerCodeResult(str9, "downloaded");
                        }
                        linkedHashMap.remove(str10);
                    }
                    if (linkedHashMap2.get(str8) == completableDeferred2) {
                        linkedHashMap2.remove(str8);
                        break;
                    }
                    mutexImpl.unlock(null);
                    ((CompletableDeferredImpl) completableDeferred2).makeCompleting$kotlinx_coroutines_core(str9);
                    return new PlayerCodeResult(str9, "downloaded");
                case 6:
                    mutexImpl2 = c01091.L$6;
                    e = (CancellationException) c01091.L$5;
                    CompletableDeferred completableDeferred4 = (CompletableDeferred) c01091.L$4;
                    str5 = c01091.L$0;
                    ResultKt.throwOnFailure(objAwaitInternal);
                    r15 = completableDeferred4;
                    if (linkedHashMap2.get(str5) == r15) {
                        linkedHashMap2.remove(str5);
                        break;
                    }
                    mutexImpl2.unlock(null);
                    ((CompletableDeferredImpl) r15).completeExceptionally(e);
                    throw e;
                case 7:
                    mutexImpl2 = c01091.L$6;
                    e = (Exception) c01091.L$5;
                    CompletableDeferred completableDeferred5 = (CompletableDeferred) c01091.L$4;
                    str3 = c01091.L$0;
                    ResultKt.throwOnFailure(objAwaitInternal);
                    r16 = completableDeferred5;
                    if (linkedHashMap2.get(str3) == r16) {
                        linkedHashMap2.remove(str3);
                        break;
                    }
                    mutexImpl2.unlock(null);
                    ((CompletableDeferredImpl) r16).completeExceptionally(e);
                    throw e;
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (CancellationException e5) {
            e = e5;
            r14 = r1;
        } catch (Exception e6) {
            e = e6;
            r13 = r1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ba A[Catch: all -> 0x0048, Exception -> 0x004c, CancellationException -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0048, blocks: (B:16:0x0043, B:46:0x00ba), top: B:94:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ca A[Catch: all -> 0x0145, Exception -> 0x0148, CancellationException -> 0x014e, TRY_ENTER, TRY_LEAVE, TryCatch #11 {CancellationException -> 0x014e, Exception -> 0x0148, all -> 0x0145, blocks: (B:44:0x00b6, B:49:0x00ca, B:51:0x00e0), top: B:106:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:85:0x0177  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c7, code lost:
    
        if (getOrDownloadPlayerCode(r7, r10) == r9) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37, types: [long] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.metrolist.innertubex.cipher.YouTubeCipherService, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [long] */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [long] */
    /* JADX WARN: Type inference failed for: r4v9, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v2, types: [long] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object preloadCanonicalPlayerCode(String str, ContinuationImpl continuationImpl) {
        C01101 c01101;
        Object obj;
        String simpleName;
        Object obj2;
        ?? r6;
        ?? r7;
        String str2;
        MutexImpl mutexImpl;
        long epochMilliseconds;
        String str3;
        long j;
        long j2;
        ?? r4;
        EjsChallengeSolver ejsChallengeSolver;
        InnerTube$executeMutation$2$1 innerTube$executeMutation$2$1;
        long j3;
        String str4;
        List listListOf;
        if (continuationImpl instanceof C01101) {
            c01101 = (C01101) continuationImpl;
            int i = c01101.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01101.label = i - Integer.MIN_VALUE;
            } else {
                c01101 = new C01101(continuationImpl);
            }
        } else {
            c01101 = new C01101(continuationImpl);
        }
        C01101 c01102 = c01101;
        Object obj3 = c01102.result;
        ?? r5 = c01102.label;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = this.logger;
        ?? r8 = 3;
        ?? r9 = 3;
        r8 = 3;
        ?? r10 = 2;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                if (r5 == 0) {
                                    ResultKt.throwOnFailure(obj3);
                                    str2 = str;
                                    c01102.L$0 = str2;
                                    mutexImpl = this.operationMutex;
                                    c01102.L$1 = mutexImpl;
                                    c01102.label = 1;
                                    if (mutexImpl.lock(c01102) != coroutineSingletons) {
                                    }
                                    r5 = mutexImpl;
                                    r5 = j;
                                    r8 = r9;
                                    r10 = str3;
                                    return coroutineSingletons;
                                }
                                if (r5 != 1) {
                                    if (r5 == 2) {
                                        long j4 = c01102.J$0;
                                        Mutex mutex = c01102.L$1;
                                        String str5 = c01102.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj3);
                                            r9 = mutex;
                                            j = j4;
                                            str3 = str5;
                                            try {
                                                if (((RemotePlayerConfigParser.HardcodedPlayerConfig) obj3) != null) {
                                                    c01102.L$0 = str3;
                                                    c01102.L$1 = r9;
                                                    c01102.J$0 = j;
                                                    c01102.label = 3;
                                                } else {
                                                    ejsChallengeSolver = this.ejs;
                                                    innerTube$executeMutation$2$1 = new InnerTube$executeMutation$2$1(this, str3, continuation, (byte) 6);
                                                    try {
                                                        listListOf = CollectionsKt__IterablesKt.listOf(new Pair("sig", CollectionsKt__IterablesKt.listOf("prewarm")));
                                                        c01102.L$0 = str3;
                                                        c01102.L$1 = r9;
                                                        c01102.J$0 = j;
                                                        c01102.label = 4;
                                                        JsonImpl jsonImpl = EjsChallengeSolver.payloadJson;
                                                        j3 = j;
                                                        r5 = r9;
                                                        str4 = str3;
                                                        try {
                                                            if (ejsChallengeSolver.solve(str4, innerTube$executeMutation$2$1, listListOf, true, c01102) == coroutineSingletons) {
                                                                return coroutineSingletons;
                                                            }
                                                            r10 = str4;
                                                            r8 = r5;
                                                            r5 = j3;
                                                        } catch (Exception e) {
                                                            e = e;
                                                            r10 = str4;
                                                            r4 = r5;
                                                            j2 = j3;
                                                            r8 = r4;
                                                            r5 = j2;
                                                            ?? epochMilliseconds2 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r5;
                                                            String strLogId = logId(r10);
                                                            simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                                                            if (simpleName == null) {
                                                                simpleName = "Exception";
                                                            }
                                                            obj2 = null;
                                                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YouTubeCipherService", "player JS preload failed elapsed=" + ((long) epochMilliseconds2) + "ms player=" + strLogId + " type=" + simpleName, null, 12);
                                                            r7 = r8;
                                                        }
                                                    } catch (CancellationException e2) {
                                                        e = e2;
                                                        r5 = r9;
                                                        throw e;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        j3 = j;
                                                        r5 = r9;
                                                        str4 = str3;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        r5 = r9;
                                                        r9 = r5;
                                                        obj = null;
                                                        r6 = r9;
                                                        r6.unlock(obj);
                                                        throw th;
                                                    }
                                                }
                                                ?? epochMilliseconds3 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r5;
                                                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YouTubeCipherService", "player JS preload done elapsed=" + ((long) epochMilliseconds3) + "ms player=" + logId(r10), null, 12);
                                                obj2 = null;
                                                r7 = r8;
                                            } catch (CancellationException e4) {
                                                throw e4;
                                            } catch (Exception e5) {
                                                e = e5;
                                                j2 = j;
                                                r4 = r9;
                                                r10 = str3;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                obj = null;
                                                r6 = r9;
                                                r6.unlock(obj);
                                                throw th;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            r8 = mutex;
                                            r5 = j4;
                                            r10 = str5;
                                            ?? epochMilliseconds4 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r5;
                                            String strLogId2 = logId(r10);
                                            simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                                            if (simpleName == null) {
                                                simpleName = "Exception";
                                            }
                                            obj2 = null;
                                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YouTubeCipherService", "player JS preload failed elapsed=" + ((long) epochMilliseconds4) + "ms player=" + strLogId2 + " type=" + simpleName, null, 12);
                                            r7 = r8;
                                            Unit unit = Unit.INSTANCE;
                                            r7.unlock(obj2);
                                            return unit;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            r8 = mutex;
                                            obj = null;
                                            r6 = r8;
                                            r6.unlock(obj);
                                            throw th;
                                        }
                                        Unit unit2 = Unit.INSTANCE;
                                        r7.unlock(obj2);
                                        return unit2;
                                    }
                                    if (r5 != 3 && r5 != 4) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    long j5 = c01102.J$0;
                                    Mutex mutex2 = c01102.L$1;
                                    String str6 = c01102.L$0;
                                    ResultKt.throwOnFailure(obj3);
                                    r5 = j5;
                                    r8 = mutex2;
                                    r10 = str6;
                                    r5 = j;
                                    r8 = r9;
                                    r10 = str3;
                                    ?? epochMilliseconds5 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r5;
                                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YouTubeCipherService", "player JS preload done elapsed=" + ((long) epochMilliseconds5) + "ms player=" + logId(r10), null, 12);
                                    obj2 = null;
                                    r7 = r8;
                                    Unit unit3 = Unit.INSTANCE;
                                    r7.unlock(obj2);
                                    return unit3;
                                }
                                Mutex mutex3 = c01102.L$1;
                                String str7 = c01102.L$0;
                                ResultKt.throwOnFailure(obj3);
                                str2 = str7;
                                r5 = mutex3;
                                RemotePlayerConfigStore remotePlayerConfigStore = this.remotePlayerConfigStore;
                                c01102.L$0 = str2;
                                c01102.L$1 = r5;
                                c01102.J$0 = epochMilliseconds;
                                c01102.label = 2;
                                Object config$com_github_MetrolistGroup_innertubex = remotePlayerConfigStore.getConfig$com_github_MetrolistGroup_innertubex(str2, c01102);
                                if (config$com_github_MetrolistGroup_innertubex != coroutineSingletons) {
                                    str3 = str2;
                                    obj3 = config$com_github_MetrolistGroup_innertubex;
                                    r9 = r5;
                                    j = epochMilliseconds;
                                    if (((RemotePlayerConfigParser.HardcodedPlayerConfig) obj3) != null) {
                                        c01102.L$0 = str3;
                                        c01102.L$1 = r9;
                                        c01102.J$0 = j;
                                        c01102.label = 3;
                                    } else {
                                        ejsChallengeSolver = this.ejs;
                                        innerTube$executeMutation$2$1 = new InnerTube$executeMutation$2$1(this, str3, continuation, (byte) 6);
                                        listListOf = CollectionsKt__IterablesKt.listOf(new Pair("sig", CollectionsKt__IterablesKt.listOf("prewarm")));
                                        c01102.L$0 = str3;
                                        c01102.L$1 = r9;
                                        c01102.J$0 = j;
                                        c01102.label = 4;
                                        JsonImpl jsonImpl2 = EjsChallengeSolver.payloadJson;
                                        j3 = j;
                                        r5 = r9;
                                        str4 = str3;
                                        if (ejsChallengeSolver.solve(str4, innerTube$executeMutation$2$1, listListOf, true, c01102) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        r10 = str4;
                                        r8 = r5;
                                        r5 = j3;
                                    }
                                    ?? epochMilliseconds6 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r5;
                                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YouTubeCipherService", "player JS preload done elapsed=" + ((long) epochMilliseconds6) + "ms player=" + logId(r10), null, 12);
                                    obj2 = null;
                                    r7 = r8;
                                    Unit unit4 = Unit.INSTANCE;
                                    r7.unlock(obj2);
                                    return unit4;
                                }
                                r5 = mutexImpl;
                                r5 = j;
                                r8 = r9;
                                r10 = str3;
                                return coroutineSingletons;
                            } catch (Exception e7) {
                                e = e7;
                                r8 = r5;
                                r5 = epochMilliseconds;
                                r10 = str2;
                                ?? epochMilliseconds7 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r5;
                                String strLogId3 = logId(r10);
                                simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                                if (simpleName == null) {
                                    simpleName = "Exception";
                                }
                                obj2 = null;
                                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YouTubeCipherService", "player JS preload failed elapsed=" + ((long) epochMilliseconds7) + "ms player=" + strLogId3 + " type=" + simpleName, null, 12);
                                r7 = r8;
                                Unit unit5 = Unit.INSTANCE;
                                r7.unlock(obj2);
                                return unit5;
                            }
                            r5 = mutexImpl;
                            epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
                        } catch (Throwable th4) {
                            th = th4;
                            r9 = r5;
                            obj = null;
                            r6 = r9;
                            r6.unlock(obj);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (CancellationException e8) {
                e = e8;
            }
        } catch (CancellationException e9) {
            throw e9;
        } catch (Exception e10) {
            e = e10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object prewarmEjs(ContinuationImpl continuationImpl) throws Throwable {
        C01111 c01111;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof C01111) {
            c01111 = (C01111) continuationImpl;
            int i = c01111.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01111.label = i - Integer.MIN_VALUE;
            } else {
                c01111 = new C01111(continuationImpl);
            }
        } else {
            c01111 = new C01111(continuationImpl);
        }
        Object obj = c01111.result;
        int i2 = c01111.label;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.operationMutex;
                c01111.L$0 = mutex;
                c01111.label = 1;
                if (mutex.lock(c01111) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c01111.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = c01111.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            EjsChallengeSolver ejsChallengeSolver = this.ejs;
            c01111.L$0 = mutex;
            c01111.label = 2;
            Object objWithActivity = ejsChallengeSolver.withActivity(new SyncUtils$executeLikeSong$2$1(ejsChallengeSolver, continuation, (byte) 3), c01111);
            if (objWithActivity != coroutineSingletons) {
                objWithActivity = unit;
            }
            if (objWithActivity != coroutineSingletons) {
                mutex2 = mutex;
                mutex2.unlock(null);
                return unit;
            }
            return coroutineSingletons;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0110  */
    /* JADX WARN: Code duplicated, block: B:65:0x0119  */
    /* JADX WARN: Code duplicated, block: B:68:0x0120 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x0121  */
    /* JADX WARN: Code duplicated, block: B:71:0x0129  */
    /* JADX WARN: Code duplicated, block: B:72:0x012b A[PHI: r2 r12
      0x012b: PHI (r2v4 com.metrolist.innertubex.models.response.PlayerResponse$StreamingData$Format) = 
      (r2v1 com.metrolist.innertubex.models.response.PlayerResponse$StreamingData$Format)
      (r2v1 com.metrolist.innertubex.models.response.PlayerResponse$StreamingData$Format)
      (r2v6 com.metrolist.innertubex.models.response.PlayerResponse$StreamingData$Format)
     binds: [B:46:0x00d2, B:48:0x00d8, B:71:0x0129] A[DONT_GENERATE, DONT_INLINE]
      0x012b: PHI (r12v5 com.metrolist.innertubex.cipher.YouTubeCipherService$CachedSolver) = 
      (r12v3 com.metrolist.innertubex.cipher.YouTubeCipherService$CachedSolver)
      (r12v3 com.metrolist.innertubex.cipher.YouTubeCipherService$CachedSolver)
      (r12v6 com.metrolist.innertubex.cipher.YouTubeCipherService$CachedSolver)
     binds: [B:46:0x00d2, B:48:0x00d8, B:71:0x0129] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x012f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object processFormatWithSolver(CachedSolver cachedSolver, PlayerResponse.StreamingData.Format format, ContinuationImpl continuationImpl) {
        C01121 c01121;
        CachedSolver cachedSolver2;
        LinkedHashMap cipherParams;
        String str;
        Object objInvoke;
        String str2;
        String str3;
        String str4;
        Map map;
        String str5;
        PlayerResponse.StreamingData.Format format2;
        CachedSolver cachedSolver3;
        String str6;
        PlayerResponse.StreamingData.Format format3;
        String str7;
        String strAppendQueryParameter$com_github_MetrolistGroup_innertubex;
        PlayerResponse.StreamingData.Format format4 = format;
        if (continuationImpl instanceof C01121) {
            c01121 = (C01121) continuationImpl;
            int i = c01121.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01121.label = i - Integer.MIN_VALUE;
            } else {
                c01121 = new C01121(continuationImpl);
            }
        } else {
            c01121 = new C01121(continuationImpl);
        }
        Object objProcessNParameterWithSolver = c01121.result;
        int i2 = c01121.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                str2 = (String) c01121.L$4;
                LinkedHashMap linkedHashMap = c01121.L$3;
                PlayerResponse.StreamingData.Format format5 = c01121.L$1;
                cachedSolver2 = c01121.L$0;
                ResultKt.throwOnFailure(objProcessNParameterWithSolver);
                objInvoke = objProcessNParameterWithSolver;
                cipherParams = linkedHashMap;
                format4 = format5;
            } else {
                if (i2 == 2) {
                    str5 = c01121.L$5;
                    map = (Map) c01121.L$4;
                    format2 = c01121.L$1;
                    cachedSolver3 = c01121.L$0;
                    ResultKt.throwOnFailure(objProcessNParameterWithSolver);
                    str7 = (String) objProcessNParameterWithSolver;
                    if (str7 != null) {
                        String str8 = (String) map.get("sp");
                        strAppendQueryParameter$com_github_MetrolistGroup_innertubex = appendQueryParameter$com_github_MetrolistGroup_innertubex(str5, str8 != null ? str8 : "signature", str7);
                        if (strAppendQueryParameter$com_github_MetrolistGroup_innertubex == null) {
                            return format2;
                        }
                        return PlayerResponse.StreamingData.Format.copy$default(format2, strAppendQueryParameter$com_github_MetrolistGroup_innertubex, 262141);
                    }
                    format4 = format2;
                    cachedSolver2 = cachedSolver3;
                    str6 = format4.url;
                    if (str6 != null || StringsKt.isBlank(str6) || extractNParameter(str6) == null) {
                        return format4;
                    }
                    c01121.L$0 = null;
                    c01121.L$1 = format4;
                    c01121.L$3 = null;
                    c01121.L$4 = null;
                    c01121.L$5 = null;
                    c01121.label = 3;
                    objProcessNParameterWithSolver = processNParameterWithSolver(cachedSolver2, str6, c01121);
                    if (objProcessNParameterWithSolver != obj) {
                        format3 = format4;
                    }
                    return obj;
                }
                if (i2 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                format3 = c01121.L$1;
                ResultKt.throwOnFailure(objProcessNParameterWithSolver);
            }
            String str9 = (String) objProcessNParameterWithSolver;
            return str9 != null ? PlayerResponse.StreamingData.Format.copy$default(format3, str9, 524285) : format3;
        }
        ResultKt.throwOnFailure(objProcessNParameterWithSolver);
        String str10 = format4.signatureCipher;
        if (str10 == null || StringsKt.isBlank(str10)) {
            cachedSolver2 = cachedSolver;
            str3 = format4.cipher;
            if (str3 != null || StringsKt.isBlank(str3)) {
                str6 = format4.url;
                if (str6 != null) {
                }
                return format4;
            }
            LinkedHashMap cipherParams2 = parseCipherParams(str3);
            String str11 = (String) cipherParams2.get("url");
            if (str11 == null || (str4 = (String) cipherParams2.get("s")) == null) {
                return format4;
            }
            YouTubeCipherService$createSolver$nSolver$1 youTubeCipherService$createSolver$nSolver$1 = cachedSolver2.sigSolver;
            c01121.L$0 = cachedSolver2;
            c01121.L$1 = format4;
            c01121.L$3 = null;
            c01121.L$4 = cipherParams2;
            c01121.L$5 = str11;
            c01121.label = 2;
            Object objInvoke2 = youTubeCipherService$createSolver$nSolver$1.invoke(str4, c01121);
            if (objInvoke2 != obj) {
                PlayerResponse.StreamingData.Format format6 = format4;
                map = cipherParams2;
                str5 = str11;
                objProcessNParameterWithSolver = objInvoke2;
                format2 = format6;
                cachedSolver3 = cachedSolver2;
                str7 = (String) objProcessNParameterWithSolver;
                if (str7 != null) {
                    String str12 = (String) map.get("sp");
                    strAppendQueryParameter$com_github_MetrolistGroup_innertubex = appendQueryParameter$com_github_MetrolistGroup_innertubex(str5, str12 != null ? str12 : "signature", str7);
                    if (strAppendQueryParameter$com_github_MetrolistGroup_innertubex == null) {
                        return format2;
                    }
                    return PlayerResponse.StreamingData.Format.copy$default(format2, strAppendQueryParameter$com_github_MetrolistGroup_innertubex, 262141);
                }
                format4 = format2;
                cachedSolver2 = cachedSolver3;
                str6 = format4.url;
                if (str6 != null) {
                }
                return format4;
            }
        } else {
            cipherParams = parseCipherParams(str10);
            String str13 = (String) cipherParams.get("url");
            if (str13 == null || (str = (String) cipherParams.get("s")) == null) {
                return format4;
            }
            YouTubeCipherService$createSolver$nSolver$1 youTubeCipherService$createSolver$nSolver$2 = cachedSolver.sigSolver;
            c01121.L$0 = cachedSolver;
            c01121.L$1 = format4;
            c01121.L$3 = cipherParams;
            c01121.L$4 = str13;
            c01121.L$5 = null;
            c01121.label = 1;
            objInvoke = youTubeCipherService$createSolver$nSolver$2.invoke(str, c01121);
            if (objInvoke != obj) {
                cachedSolver2 = cachedSolver;
                str2 = str13;
            }
        }
        return obj;
        String str14 = (String) objInvoke;
        if (str14 != null) {
            String str15 = (String) cipherParams.get("sp");
            String strAppendQueryParameter$com_github_MetrolistGroup_innertubex2 = appendQueryParameter$com_github_MetrolistGroup_innertubex(str2, str15 != null ? str15 : "signature", str14);
            return strAppendQueryParameter$com_github_MetrolistGroup_innertubex2 == null ? format4 : PlayerResponse.StreamingData.Format.copy$default(format4, strAppendQueryParameter$com_github_MetrolistGroup_innertubex2, 393213);
        }
        str3 = format4.cipher;
        if (str3 != null) {
            str6 = format4.url;
            if (str6 != null) {
            }
            return format4;
        }
        str6 = format4.url;
        if (str6 != null) {
        }
        return format4;
        return obj;
    }

    public final Object processFormats(String str, List list, InnerTubeExtractor.C01201 c01201) {
        int i;
        String str2;
        String strCanonicalPlayerUrl = RemotePlayerConfigParserKt.canonicalPlayerUrl(str);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (true) {
            String strExtractNParameter = null;
            if (!it.hasNext()) {
                break;
            }
            String str3 = ((PlayerResponse.StreamingData.Format) it.next()).url;
            if (str3 != null) {
                strExtractNParameter = extractNParameter(str3);
            }
            arrayList.add(strExtractNParameter);
        }
        int i2 = 0;
        if (list.isEmpty()) {
            i = 0;
        } else {
            Iterator it2 = list.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                PlayerResponse.StreamingData.Format format = (PlayerResponse.StreamingData.Format) it2.next();
                String str4 = format.signatureCipher;
                if ((str4 != null && !StringsKt.isBlank(str4)) || ((str2 = format.cipher) != null && !StringsKt.isBlank(str2))) {
                    i3++;
                    if (i3 < 0) {
                        CollectionsKt__IterablesKt.throwCountOverflow();
                        throw null;
                    }
                }
            }
            i = i3;
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                if (((String) obj) != null && (i2 = i2 + 1) < 0) {
                    CollectionsKt__IterablesKt.throwCountOverflow();
                    throw null;
                }
            }
        }
        int i5 = i2;
        return (i == 0 && i5 == 0) ? list : AwaitKt.withContext(Dispatchers.Default, new YouTubeCipherService$processCanonicalFormats$2(this, list, i, i5, strCanonicalPlayerUrl, arrayList, null), c01201);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processNParameterWithSolver(CachedSolver cachedSolver, String str, ContinuationImpl continuationImpl) {
        C01131 c01131;
        MatcherMatchResult matcherMatchResult;
        if (continuationImpl instanceof C01131) {
            c01131 = (C01131) continuationImpl;
            int i = c01131.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01131.label = i - Integer.MIN_VALUE;
            } else {
                c01131 = new C01131(continuationImpl);
            }
        } else {
            c01131 = new C01131(continuationImpl);
        }
        Object obj = c01131.result;
        int i2 = c01131.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MatcherMatchResult matcherMatchResultFindNParameter = findNParameter(str);
            if (matcherMatchResultFindNParameter != null) {
                String str2 = (String) ((ReversedListReadOnly) matcherMatchResultFindNParameter.getGroupValues()).get(1);
                YouTubeCipherService$createSolver$nSolver$1 youTubeCipherService$createSolver$nSolver$1 = cachedSolver.nSolver;
                c01131.L$1 = str;
                c01131.L$2 = matcherMatchResultFindNParameter;
                c01131.label = 1;
                Object objInvoke = youTubeCipherService$createSolver$nSolver$1.invoke(str2, c01131);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objInvoke == coroutineSingletons) {
                    return coroutineSingletons;
                }
                matcherMatchResult = matcherMatchResultFindNParameter;
                obj = objInvoke;
            }
            return null;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        matcherMatchResult = c01131.L$2;
        str = c01131.L$1;
        ResultKt.throwOnFailure(obj);
        String str3 = (String) obj;
        if (str3 != null) {
            return replaceQueryParameter$com_github_MetrolistGroup_innertubex(str, matcherMatchResult, str3);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object refreshAfterStreamRejection(ContinuationImpl continuationImpl) throws Throwable {
        C01141 c01141;
        if (continuationImpl instanceof C01141) {
            c01141 = (C01141) continuationImpl;
            int i = c01141.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01141.label = i - Integer.MIN_VALUE;
            } else {
                c01141 = new C01141(continuationImpl);
            }
        } else {
            c01141 = new C01141(continuationImpl);
        }
        Object objRefreshAfterStreamRejection$com_github_MetrolistGroup_innertubex = c01141.result;
        int i2 = c01141.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRefreshAfterStreamRejection$com_github_MetrolistGroup_innertubex);
            c01141.label = 1;
            objRefreshAfterStreamRejection$com_github_MetrolistGroup_innertubex = this.remotePlayerConfigStore.refreshAfterStreamRejection$com_github_MetrolistGroup_innertubex(c01141);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objRefreshAfterStreamRejection$com_github_MetrolistGroup_innertubex == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objRefreshAfterStreamRejection$com_github_MetrolistGroup_innertubex);
        }
        return Boolean.valueOf(((Boolean) objRefreshAfterStreamRejection$com_github_MetrolistGroup_innertubex).booleanValue());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object solveWithGitHubConfig(String str, List list, ArrayList arrayList, ContinuationImpl continuationImpl) {
        C01151 c01151;
        if (continuationImpl instanceof C01151) {
            c01151 = (C01151) continuationImpl;
            int i = c01151.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01151.label = i - Integer.MIN_VALUE;
            } else {
                c01151 = new C01151(continuationImpl);
            }
        } else {
            c01151 = new C01151(continuationImpl);
        }
        Object objSolve = c01151.result;
        int i2 = c01151.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSolve);
            GitHubPlayerConfigClient gitHubPlayerConfigClient = this.githubPreprocessedPlayer;
            if (gitHubPlayerConfigClient == null) {
                EmptyMap emptyMap = EmptyMap.INSTANCE;
                return new RemoteSolveResult(emptyMap, emptyMap);
            }
            c01151.label = 1;
            objSolve = gitHubPlayerConfigClient.solve(str, list, arrayList, c01151);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objSolve == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objSolve);
        }
        GitHubPlayerConfigClient.SolveResult solveResult = (GitHubPlayerConfigClient.SolveResult) objSolve;
        return new RemoteSolveResult(solveResult.sigByChallenge, solveResult.nByChallenge);
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0192 A[Catch: Exception -> 0x0045, CancellationException -> 0x0260, TryCatch #0 {CancellationException -> 0x0260, blocks: (B:14:0x0040, B:86:0x0210, B:88:0x0214, B:81:0x01e0, B:83:0x01e6, B:92:0x0221, B:91:0x021d, B:19:0x0056, B:74:0x01b9, B:76:0x01bd, B:69:0x018c, B:71:0x0192, B:80:0x01ca, B:79:0x01c6, B:22:0x0061, B:68:0x017b, B:25:0x0072, B:64:0x015a, B:60:0x013e), top: B:103:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:74:0x01b9 A[Catch: Exception -> 0x0045, CancellationException -> 0x0260, PHI: r0 r2 r3 r4 r5 r6 r11
      0x01b9: PHI (r0v33 java.lang.String) = (r0v32 java.lang.String), (r0v34 java.lang.String) binds: [B:72:0x01b6, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r2v28 java.lang.Object) = (r2v27 java.lang.Object), (r2v1 java.lang.Object) binds: [B:72:0x01b6, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r3v31 java.util.Iterator) = (r3v29 java.util.Iterator), (r3v32 java.util.Iterator) binds: [B:72:0x01b6, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r4v20 java.util.Collection) = (r4v17 java.util.Collection), (r4v22 java.util.Collection) binds: [B:72:0x01b6, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r5v25 com.metrolist.innertubex.cipher.ZemerCipherSolver) = (r5v23 com.metrolist.innertubex.cipher.ZemerCipherSolver), (r5v26 com.metrolist.innertubex.cipher.ZemerCipherSolver) binds: [B:72:0x01b6, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r6v11 java.util.List) = (r6v9 java.util.List), (r6v12 java.util.List) binds: [B:72:0x01b6, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r11v15 java.lang.String) = (r11v14 java.lang.String), (r11v16 java.lang.String) binds: [B:72:0x01b6, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {CancellationException -> 0x0260, blocks: (B:14:0x0040, B:86:0x0210, B:88:0x0214, B:81:0x01e0, B:83:0x01e6, B:92:0x0221, B:91:0x021d, B:19:0x0056, B:74:0x01b9, B:76:0x01bd, B:69:0x018c, B:71:0x0192, B:80:0x01ca, B:79:0x01c6, B:22:0x0061, B:68:0x017b, B:25:0x0072, B:64:0x015a, B:60:0x013e), top: B:103:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01bd A[Catch: Exception -> 0x0045, CancellationException -> 0x0260, TryCatch #0 {CancellationException -> 0x0260, blocks: (B:14:0x0040, B:86:0x0210, B:88:0x0214, B:81:0x01e0, B:83:0x01e6, B:92:0x0221, B:91:0x021d, B:19:0x0056, B:74:0x01b9, B:76:0x01bd, B:69:0x018c, B:71:0x0192, B:80:0x01ca, B:79:0x01c6, B:22:0x0061, B:68:0x017b, B:25:0x0072, B:64:0x015a, B:60:0x013e), top: B:103:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c6 A[Catch: Exception -> 0x0045, CancellationException -> 0x0260, TryCatch #0 {CancellationException -> 0x0260, blocks: (B:14:0x0040, B:86:0x0210, B:88:0x0214, B:81:0x01e0, B:83:0x01e6, B:92:0x0221, B:91:0x021d, B:19:0x0056, B:74:0x01b9, B:76:0x01bd, B:69:0x018c, B:71:0x0192, B:80:0x01ca, B:79:0x01c6, B:22:0x0061, B:68:0x017b, B:25:0x0072, B:64:0x015a, B:60:0x013e), top: B:103:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x01b6 -> B:74:0x01b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x020d -> B:86:0x0210). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object solveWithZemerConfig(java.lang.String r17, java.util.List r18, java.util.List r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.cipher.YouTubeCipherService.solveWithZemerConfig(java.lang.String, java.util.List, java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
