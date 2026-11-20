package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.gestures.DraggableKt$NoOpOnDragStarted$1;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.music.App$Companion$forgetAccount$2;
import com.metrolist.music.discord.DiscordRpcManager;
import dagger.hilt.EntryPoints;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.InstantJvmKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EjsChallengeSolver {
    public static final JsonImpl payloadJson = UuidKt.Json$default(new YouTube$$ExternalSyntheticLambda2((byte) 11));
    public boolean bootstrapped;
    public String bundleHash;
    public final QuickJsEngine engine;
    public StandaloneCoroutine idleJob;
    public final PathKt$$ExternalSyntheticBUOutline0 logger;
    public final MutexImpl operationMutex = new MutexImpl();
    public final ContextScope idleScope = AwaitKt.CoroutineScope(Dispatchers.Default);
    public final LinkedHashMap solvedChallenges = new LinkedHashMap();
    public final LinkedHashMap preprocessedByPlayerUrl = new LinkedHashMap();
    public final LinkedHashSet compiledPlayers = new LinkedHashSet();
    public final App$Companion$forgetAccount$2 readPreprocessedPlayer = new App$Companion$forgetAccount$2(2, null, 7);
    public final DraggableKt$NoOpOnDragStarted$1 writePreprocessedPlayer = new DraggableKt$NoOpOnDragStarted$1(3, null, (byte) 3);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ChallengeKey {
        public final String challenge;
        public final String kind;
        public final String playerUrl;

        public ChallengeKey(String str, String str2, String str3) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            this.playerUrl = str;
            this.kind = str2;
            this.challenge = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChallengeKey)) {
                return false;
            }
            ChallengeKey challengeKey = (ChallengeKey) obj;
            return Intrinsics.areEqual(this.playerUrl, challengeKey.playerUrl) && Intrinsics.areEqual(this.kind, challengeKey.kind) && Intrinsics.areEqual(this.challenge, challengeKey.challenge);
        }

        public final int hashCode() {
            return this.challenge.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.playerUrl.hashCode() * 31, 31, this.kind);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("ChallengeKey(playerUrl=", this.playerUrl, ", kind=", this.kind, ", challenge="), this.challenge, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SolveResult {
        public final Map nByChallenge;
        public final String preprocessedPlayer;
        public final Map sigByChallenge;

        public SolveResult(Map map, Map map2, String str) {
            this.sigByChallenge = map;
            this.nByChallenge = map2;
            this.preprocessedPlayer = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SolveResult)) {
                return false;
            }
            SolveResult solveResult = (SolveResult) obj;
            return this.sigByChallenge.equals(solveResult.sigByChallenge) && this.nByChallenge.equals(solveResult.nByChallenge) && Intrinsics.areEqual(this.preprocessedPlayer, solveResult.preprocessedPlayer);
        }

        public final int hashCode() {
            int iHashCode = (this.nByChallenge.hashCode() + (this.sigByChallenge.hashCode() * 31)) * 31;
            String str = this.preprocessedPlayer;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("SolveResult(sigByChallenge=");
            sb.append(this.sigByChallenge);
            sb.append(", nByChallenge=");
            sb.append(this.nByChallenge);
            sb.append(", preprocessedPlayer=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.preprocessedPlayer, ")");
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.EjsChallengeSolver$ensureBootstrapped$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public long J$0;
        public Throwable L$0;
        public String L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EjsChallengeSolver.this.ensureBootstrapped(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.EjsChallengeSolver$loadPreprocessedPlayer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00891 extends ContinuationImpl {
        public String L$0;
        public String L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00891(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EjsChallengeSolver.this.loadPreprocessedPlayer(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.EjsChallengeSolver$safeWritePreprocessedPlayer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00901 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00901(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EjsChallengeSolver.this.safeWritePreprocessedPlayer(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.EjsChallengeSolver$solve$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ byte $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(int i, Continuation continuation, byte b) {
            super(i, continuation);
            this.$r8$classId = b;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass2(1, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass2(1, continuation, (byte) 1);
                default:
                    return new AnonymousClass2(1, continuation, (byte) 2);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = (Continuation) obj;
            switch (b) {
                case 0:
                    ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
                    return "";
                case 1:
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
                default:
                    ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
                    return unit;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return "";
                case 1:
                    ResultKt.throwOnFailure(obj);
                    String str = DiscordRpcManager.accessToken;
                    return "Bearer ".concat(str != null ? str : "");
                default:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.EjsChallengeSolver$solve$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass8 extends SuspendLambda implements Function1 {
        public final /* synthetic */ Function1 $loadFullPlayerJs;
        public final /* synthetic */ String $playerUrl;
        public final /* synthetic */ boolean $preferPreprocessed;
        public final /* synthetic */ List $requestOrder;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(String str, List list, boolean z, Function1 function1, Continuation continuation) {
            super(1, continuation);
            this.$playerUrl = str;
            this.$requestOrder = list;
            this.$preferPreprocessed = z;
            this.$loadFullPlayerJs = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return EjsChallengeSolver.this.new AnonymousClass8(this.$playerUrl, this.$requestOrder, this.$preferPreprocessed, this.$loadFullPlayerJs, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ((AnonymousClass8) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objSolveUncached;
            EjsChallengeSolver ejsChallengeSolver = EjsChallengeSolver.this;
            LinkedHashMap linkedHashMap = ejsChallengeSolver.solvedChallenges;
            boolean z = this.label;
            String str = this.$playerUrl;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                JsonImpl jsonImpl = EjsChallengeSolver.payloadJson;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                List<Pair> list = this.$requestOrder;
                for (Pair pair : list) {
                    String str2 = (String) pair.first;
                    for (String str3 : (List) pair.second) {
                        ChallengeKey challengeKey = new ChallengeKey(str, str2, str3);
                        String str4 = (String) linkedHashMap.remove(challengeKey);
                        if (str4 != null) {
                            linkedHashMap.put(challengeKey, str4);
                            if (str2.equals("sig")) {
                                linkedHashMap2.put(str3, str4);
                            } else if (str2.equals("n")) {
                                linkedHashMap3.put(str3, str4);
                            }
                        }
                    }
                }
                SolveResult solveResult = new SolveResult(linkedHashMap2, linkedHashMap3, null);
                if (this.$preferPreprocessed && EjsChallengeSolverKt.solvesAll(solveResult, list)) {
                    return solveResult;
                }
                this.label = true;
                objSolveUncached = ejsChallengeSolver.solveUncached(this.$playerUrl, this.$loadFullPlayerJs, this.$requestOrder, this.$preferPreprocessed, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSolveUncached == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objSolveUncached = obj;
            }
            SolveResult solveResult2 = (SolveResult) objSolveUncached;
            for (Pair pair2 : CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair("sig", solveResult2.sigByChallenge), new Pair("n", solveResult2.nByChallenge)})) {
                String str5 = (String) pair2.first;
                for (Map.Entry entry : ((Map) pair2.second).entrySet()) {
                    String str6 = (String) entry.getKey();
                    String str7 = (String) entry.getValue();
                    if (str7.length() + str6.length() + str.length() <= 4096) {
                        ChallengeKey challengeKey2 = new ChallengeKey(str, str5, str6);
                        linkedHashMap.remove(challengeKey2);
                        linkedHashMap.put(challengeKey2, str7);
                        while (linkedHashMap.size() > 256) {
                            Set setKeySet = linkedHashMap.keySet();
                            setKeySet.getClass();
                            linkedHashMap.remove(CollectionsKt.first(setKeySet));
                        }
                    }
                }
            }
            return solveResult2;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.EjsChallengeSolver$solveOnce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00911 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public List L$2;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00911(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EjsChallengeSolver.this.solveOnce(null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.EjsChallengeSolver$solveUncached$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00921 extends ContinuationImpl {
        public String L$0;
        public Function1 L$1;
        public List L$2;
        public String L$3;
        public SolveResult L$5;
        public Object L$7;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00921(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EjsChallengeSolver.this.solveUncached(null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.EjsChallengeSolver$withActivity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00931 extends ContinuationImpl {
        public SuspendLambda L$0;
        public Mutex L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00931(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EjsChallengeSolver.this.withActivity(null, this);
        }
    }

    public EjsChallengeSolver(QuickJsEngine quickJsEngine, PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0) {
        this.engine = quickJsEngine;
        this.logger = pathKt$$ExternalSyntheticBUOutline0;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x009f  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a5 A[Catch: all -> 0x0041, PHI: r8
      0x00a5: PHI (r8v3 long) = (r8v1 long), (r8v4 long) binds: [B:43:0x00a1, B:28:0x006a] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:57:0x0101, B:19:0x004a, B:54:0x00ef, B:22:0x0057, B:51:0x00df, B:25:0x0064, B:48:0x00cd, B:28:0x006a, B:45:0x00a5, B:31:0x0070, B:39:0x0092, B:36:0x007c), top: B:64:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cd A[Catch: all -> 0x0041, PHI: r2 r8
      0x00cd: PHI (r2v3 java.lang.String) = (r2v2 java.lang.String), (r2v4 java.lang.String) binds: [B:46:0x00ca, B:25:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r8v5 long) = (r8v3 long), (r8v6 long) binds: [B:46:0x00ca, B:25:0x0064] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:57:0x0101, B:19:0x004a, B:54:0x00ef, B:22:0x0057, B:51:0x00df, B:25:0x0064, B:48:0x00cd, B:28:0x006a, B:45:0x00a5, B:31:0x0070, B:39:0x0092, B:36:0x007c), top: B:64:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00de  */
    /* JADX WARN: Code duplicated, block: B:51:0x00df A[Catch: all -> 0x0041, PHI: r2 r8
      0x00df: PHI (r2v5 java.lang.String) = (r2v3 java.lang.String), (r2v6 java.lang.String) binds: [B:49:0x00dc, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x00df: PHI (r8v7 long) = (r8v5 long), (r8v8 long) binds: [B:49:0x00dc, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:57:0x0101, B:19:0x004a, B:54:0x00ef, B:22:0x0057, B:51:0x00df, B:25:0x0064, B:48:0x00cd, B:28:0x006a, B:45:0x00a5, B:31:0x0070, B:39:0x0092, B:36:0x007c), top: B:64:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ef A[Catch: all -> 0x0041, PHI: r8
      0x00ef: PHI (r8v9 long) = (r8v7 long), (r8v10 long) binds: [B:52:0x00ec, B:19:0x004a] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:57:0x0101, B:19:0x004a, B:54:0x00ef, B:22:0x0057, B:51:0x00df, B:25:0x0064, B:48:0x00cd, B:28:0x006a, B:45:0x00a5, B:31:0x0070, B:39:0x0092, B:36:0x007c), top: B:64:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0100  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object ensureBootstrapped(ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        long epochMilliseconds;
        Object objExecute;
        String ytEjsSolverScript;
        String ytEjsSolverScript2;
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
        Object obj2 = Unit.INSTANCE;
        QuickJsEngine quickJsEngine = this.engine;
        Object obj3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            switch (i2) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (this.bootstrapped) {
                        return obj2;
                    }
                    epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
                    anonymousClass1.J$0 = epochMilliseconds;
                    anonymousClass1.label = 1;
                    if (quickJsEngine.initialize(anonymousClass1) != obj3) {
                        anonymousClass1.J$0 = epochMilliseconds;
                        anonymousClass1.label = 2;
                        objExecute = quickJsEngine.execute("if (typeof globalThis.XMLHttpRequest === \"undefined\") {\n    globalThis.XMLHttpRequest = { prototype: {} };\n}\nif (typeof URL === \"undefined\") {\n    globalThis.location = {\n        hash: \"\",\n        host: \"www.youtube.com\",\n        hostname: \"www.youtube.com\",\n        href: \"https://www.youtube.com/watch?v=yt-dlp-wins\",\n        origin: \"https://www.youtube.com\",\n        password: \"\",\n        pathname: \"/watch\",\n        port: \"\",\n        protocol: \"https:\",\n        search: \"?v=yt-dlp-wins\",\n        username: \"\",\n    };\n} else {\n    globalThis.location = new URL(\"https://www.youtube.com/watch?v=yt-dlp-wins\");\n}\nif (typeof globalThis.document === \"undefined\") {\n    globalThis.document = Object.create(null);\n}\nif (typeof globalThis.navigator === \"undefined\") {\n    globalThis.navigator = Object.create(null);\n}\nif (typeof globalThis.self === \"undefined\") {\n    globalThis.self = globalThis;\n}\nif (typeof globalThis.window === \"undefined\") {\n    globalThis.window = globalThis;\n}\nif (typeof globalThis.Intl === \"undefined\") {\n    const NumberFormat = function(locale, options) {\n        this.options = options || {};\n    };\n    NumberFormat.supportedLocalesOf = function(locales) {\n        return Array.isArray(locales) ? locales : [locales];\n    };\n    NumberFormat.prototype.format = function(value) {\n        let formatted = String(value);\n        const minimumDigits = this.options.minimumIntegerDigits || 0;\n        while (formatted.length < minimumDigits) formatted = \"0\" + formatted;\n        return formatted;\n    };\n    const DateTimeFormat = function() {};\n    DateTimeFormat.prototype.resolvedOptions = function() {\n        return { timeZone: \"UTC\" };\n    };\n    DateTimeFormat.prototype.format = function(value) {\n        return String(value);\n    };\n    globalThis.Intl = { NumberFormat, DateTimeFormat };\n}", anonymousClass1);
                        if (objExecute == obj3) {
                            objExecute = obj2;
                        }
                        if (objExecute == obj3) {
                            ytEjsSolverScript = Okio__OkioKt.readYtEjsSolverScript("yt.solver.lib.min.js");
                            ytEjsSolverScript2 = Okio__OkioKt.readYtEjsSolverScript("yt.solver.core.min.js");
                            this.bundleHash = CharsKt.sha1(ytEjsSolverScript.concat(ytEjsSolverScript2));
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = ytEjsSolverScript2;
                            anonymousClass1.J$0 = epochMilliseconds;
                            anonymousClass1.label = 3;
                            if (quickJsEngine.execute(ytEjsSolverScript, anonymousClass1) != obj3) {
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = ytEjsSolverScript2;
                                anonymousClass1.J$0 = epochMilliseconds;
                                anonymousClass1.label = 4;
                                if (quickJsEngine.execute("Object.assign(globalThis, lib);", anonymousClass1) == obj3) {
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.J$0 = epochMilliseconds;
                                    anonymousClass1.label = 5;
                                    if (quickJsEngine.execute(ytEjsSolverScript2, anonymousClass1) != obj3) {
                                        anonymousClass1.L$0 = null;
                                        anonymousClass1.L$1 = null;
                                        anonymousClass1.J$0 = epochMilliseconds;
                                        anonymousClass1.label = 6;
                                        if (quickJsEngine.execute("globalThis.__itxPlayers = new Map();\nglobalThis.__itxCompile = function(key, code) {\n  var fns = {\"n\":null,\"sig\":null};\n  Function(\"_result\", code)(fns);\n  __itxPlayers.delete(key);\n  __itxPlayers.set(key, fns);\n  while (__itxPlayers.size > 2) __itxPlayers.delete(__itxPlayers.keys().next().value);\n  return fns;\n};\nglobalThis.__itxRun = function(fns, requests) {\n  return {\"type\":\"result\",\"responses\":requests.map(function(req) {\n    if (req.type !== \"n\" && req.type !== \"sig\")\n      return {\"type\":\"error\",\"error\":\"Unknown request type: \" + req.type};\n    var fn = fns[req.type];\n    if (!fn) return {\"type\":\"error\",\"error\":\"Failed to extract \" + req.type + \" function\"};\n    try {\n      return {\"type\":\"result\",\"data\":Object.fromEntries(req.challenges.map(function(c) { return [c, fn(c)]; }))};\n    } catch (e) {\n      return {\"type\":\"error\",\"error\":String(e)};\n    }\n  })};\n};", anonymousClass1) == obj3) {
                                        }
                                        this.bootstrapped = true;
                                        EntryPoints.d$default(this.logger, "EjsChallengeSolver", "EJS bootstrap done elapsed=" + (InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds) + "ms", null, 12);
                                        return obj2;
                                    }
                                }
                            }
                        }
                    }
                    return obj3;
                case 1:
                    epochMilliseconds = anonymousClass1.J$0;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1.J$0 = epochMilliseconds;
                    anonymousClass1.label = 2;
                    objExecute = quickJsEngine.execute("if (typeof globalThis.XMLHttpRequest === \"undefined\") {\n    globalThis.XMLHttpRequest = { prototype: {} };\n}\nif (typeof URL === \"undefined\") {\n    globalThis.location = {\n        hash: \"\",\n        host: \"www.youtube.com\",\n        hostname: \"www.youtube.com\",\n        href: \"https://www.youtube.com/watch?v=yt-dlp-wins\",\n        origin: \"https://www.youtube.com\",\n        password: \"\",\n        pathname: \"/watch\",\n        port: \"\",\n        protocol: \"https:\",\n        search: \"?v=yt-dlp-wins\",\n        username: \"\",\n    };\n} else {\n    globalThis.location = new URL(\"https://www.youtube.com/watch?v=yt-dlp-wins\");\n}\nif (typeof globalThis.document === \"undefined\") {\n    globalThis.document = Object.create(null);\n}\nif (typeof globalThis.navigator === \"undefined\") {\n    globalThis.navigator = Object.create(null);\n}\nif (typeof globalThis.self === \"undefined\") {\n    globalThis.self = globalThis;\n}\nif (typeof globalThis.window === \"undefined\") {\n    globalThis.window = globalThis;\n}\nif (typeof globalThis.Intl === \"undefined\") {\n    const NumberFormat = function(locale, options) {\n        this.options = options || {};\n    };\n    NumberFormat.supportedLocalesOf = function(locales) {\n        return Array.isArray(locales) ? locales : [locales];\n    };\n    NumberFormat.prototype.format = function(value) {\n        let formatted = String(value);\n        const minimumDigits = this.options.minimumIntegerDigits || 0;\n        while (formatted.length < minimumDigits) formatted = \"0\" + formatted;\n        return formatted;\n    };\n    const DateTimeFormat = function() {};\n    DateTimeFormat.prototype.resolvedOptions = function() {\n        return { timeZone: \"UTC\" };\n    };\n    DateTimeFormat.prototype.format = function(value) {\n        return String(value);\n    };\n    globalThis.Intl = { NumberFormat, DateTimeFormat };\n}", anonymousClass1);
                    if (objExecute == obj3) {
                        objExecute = obj2;
                    }
                    if (objExecute == obj3) {
                        ytEjsSolverScript = Okio__OkioKt.readYtEjsSolverScript("yt.solver.lib.min.js");
                        ytEjsSolverScript2 = Okio__OkioKt.readYtEjsSolverScript("yt.solver.core.min.js");
                        this.bundleHash = CharsKt.sha1(ytEjsSolverScript.concat(ytEjsSolverScript2));
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = ytEjsSolverScript2;
                        anonymousClass1.J$0 = epochMilliseconds;
                        anonymousClass1.label = 3;
                        if (quickJsEngine.execute(ytEjsSolverScript, anonymousClass1) != obj3) {
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = ytEjsSolverScript2;
                            anonymousClass1.J$0 = epochMilliseconds;
                            anonymousClass1.label = 4;
                            if (quickJsEngine.execute("Object.assign(globalThis, lib);", anonymousClass1) == obj3) {
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.J$0 = epochMilliseconds;
                                anonymousClass1.label = 5;
                                if (quickJsEngine.execute(ytEjsSolverScript2, anonymousClass1) != obj3) {
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.J$0 = epochMilliseconds;
                                    anonymousClass1.label = 6;
                                    if (quickJsEngine.execute("globalThis.__itxPlayers = new Map();\nglobalThis.__itxCompile = function(key, code) {\n  var fns = {\"n\":null,\"sig\":null};\n  Function(\"_result\", code)(fns);\n  __itxPlayers.delete(key);\n  __itxPlayers.set(key, fns);\n  while (__itxPlayers.size > 2) __itxPlayers.delete(__itxPlayers.keys().next().value);\n  return fns;\n};\nglobalThis.__itxRun = function(fns, requests) {\n  return {\"type\":\"result\",\"responses\":requests.map(function(req) {\n    if (req.type !== \"n\" && req.type !== \"sig\")\n      return {\"type\":\"error\",\"error\":\"Unknown request type: \" + req.type};\n    var fn = fns[req.type];\n    if (!fn) return {\"type\":\"error\",\"error\":\"Failed to extract \" + req.type + \" function\"};\n    try {\n      return {\"type\":\"result\",\"data\":Object.fromEntries(req.challenges.map(function(c) { return [c, fn(c)]; }))};\n    } catch (e) {\n      return {\"type\":\"error\",\"error\":String(e)};\n    }\n  })};\n};", anonymousClass1) == obj3) {
                                    }
                                    this.bootstrapped = true;
                                    EntryPoints.d$default(this.logger, "EjsChallengeSolver", "EJS bootstrap done elapsed=" + (InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds) + "ms", null, 12);
                                    return obj2;
                                }
                            }
                        }
                    }
                    return obj3;
                case 2:
                    epochMilliseconds = anonymousClass1.J$0;
                    ResultKt.throwOnFailure(obj);
                    ytEjsSolverScript = Okio__OkioKt.readYtEjsSolverScript("yt.solver.lib.min.js");
                    ytEjsSolverScript2 = Okio__OkioKt.readYtEjsSolverScript("yt.solver.core.min.js");
                    this.bundleHash = CharsKt.sha1(ytEjsSolverScript.concat(ytEjsSolverScript2));
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = ytEjsSolverScript2;
                    anonymousClass1.J$0 = epochMilliseconds;
                    anonymousClass1.label = 3;
                    if (quickJsEngine.execute(ytEjsSolverScript, anonymousClass1) != obj3) {
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = ytEjsSolverScript2;
                        anonymousClass1.J$0 = epochMilliseconds;
                        anonymousClass1.label = 4;
                        if (quickJsEngine.execute("Object.assign(globalThis, lib);", anonymousClass1) == obj3) {
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.J$0 = epochMilliseconds;
                            anonymousClass1.label = 5;
                            if (quickJsEngine.execute(ytEjsSolverScript2, anonymousClass1) != obj3) {
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.J$0 = epochMilliseconds;
                                anonymousClass1.label = 6;
                                if (quickJsEngine.execute("globalThis.__itxPlayers = new Map();\nglobalThis.__itxCompile = function(key, code) {\n  var fns = {\"n\":null,\"sig\":null};\n  Function(\"_result\", code)(fns);\n  __itxPlayers.delete(key);\n  __itxPlayers.set(key, fns);\n  while (__itxPlayers.size > 2) __itxPlayers.delete(__itxPlayers.keys().next().value);\n  return fns;\n};\nglobalThis.__itxRun = function(fns, requests) {\n  return {\"type\":\"result\",\"responses\":requests.map(function(req) {\n    if (req.type !== \"n\" && req.type !== \"sig\")\n      return {\"type\":\"error\",\"error\":\"Unknown request type: \" + req.type};\n    var fn = fns[req.type];\n    if (!fn) return {\"type\":\"error\",\"error\":\"Failed to extract \" + req.type + \" function\"};\n    try {\n      return {\"type\":\"result\",\"data\":Object.fromEntries(req.challenges.map(function(c) { return [c, fn(c)]; }))};\n    } catch (e) {\n      return {\"type\":\"error\",\"error\":String(e)};\n    }\n  })};\n};", anonymousClass1) == obj3) {
                                }
                                this.bootstrapped = true;
                                EntryPoints.d$default(this.logger, "EjsChallengeSolver", "EJS bootstrap done elapsed=" + (InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds) + "ms", null, 12);
                                return obj2;
                            }
                        }
                    }
                    return obj3;
                case 3:
                    epochMilliseconds = anonymousClass1.J$0;
                    ytEjsSolverScript2 = anonymousClass1.L$1;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = ytEjsSolverScript2;
                    anonymousClass1.J$0 = epochMilliseconds;
                    anonymousClass1.label = 4;
                    if (quickJsEngine.execute("Object.assign(globalThis, lib);", anonymousClass1) == obj3) {
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.J$0 = epochMilliseconds;
                        anonymousClass1.label = 5;
                        if (quickJsEngine.execute(ytEjsSolverScript2, anonymousClass1) != obj3) {
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.J$0 = epochMilliseconds;
                            anonymousClass1.label = 6;
                            if (quickJsEngine.execute("globalThis.__itxPlayers = new Map();\nglobalThis.__itxCompile = function(key, code) {\n  var fns = {\"n\":null,\"sig\":null};\n  Function(\"_result\", code)(fns);\n  __itxPlayers.delete(key);\n  __itxPlayers.set(key, fns);\n  while (__itxPlayers.size > 2) __itxPlayers.delete(__itxPlayers.keys().next().value);\n  return fns;\n};\nglobalThis.__itxRun = function(fns, requests) {\n  return {\"type\":\"result\",\"responses\":requests.map(function(req) {\n    if (req.type !== \"n\" && req.type !== \"sig\")\n      return {\"type\":\"error\",\"error\":\"Unknown request type: \" + req.type};\n    var fn = fns[req.type];\n    if (!fn) return {\"type\":\"error\",\"error\":\"Failed to extract \" + req.type + \" function\"};\n    try {\n      return {\"type\":\"result\",\"data\":Object.fromEntries(req.challenges.map(function(c) { return [c, fn(c)]; }))};\n    } catch (e) {\n      return {\"type\":\"error\",\"error\":String(e)};\n    }\n  })};\n};", anonymousClass1) == obj3) {
                            }
                            this.bootstrapped = true;
                            EntryPoints.d$default(this.logger, "EjsChallengeSolver", "EJS bootstrap done elapsed=" + (InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds) + "ms", null, 12);
                            return obj2;
                        }
                    }
                    return obj3;
                case 4:
                    epochMilliseconds = anonymousClass1.J$0;
                    ytEjsSolverScript2 = anonymousClass1.L$1;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.J$0 = epochMilliseconds;
                    anonymousClass1.label = 5;
                    if (quickJsEngine.execute(ytEjsSolverScript2, anonymousClass1) != obj3) {
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.J$0 = epochMilliseconds;
                        anonymousClass1.label = 6;
                        if (quickJsEngine.execute("globalThis.__itxPlayers = new Map();\nglobalThis.__itxCompile = function(key, code) {\n  var fns = {\"n\":null,\"sig\":null};\n  Function(\"_result\", code)(fns);\n  __itxPlayers.delete(key);\n  __itxPlayers.set(key, fns);\n  while (__itxPlayers.size > 2) __itxPlayers.delete(__itxPlayers.keys().next().value);\n  return fns;\n};\nglobalThis.__itxRun = function(fns, requests) {\n  return {\"type\":\"result\",\"responses\":requests.map(function(req) {\n    if (req.type !== \"n\" && req.type !== \"sig\")\n      return {\"type\":\"error\",\"error\":\"Unknown request type: \" + req.type};\n    var fn = fns[req.type];\n    if (!fn) return {\"type\":\"error\",\"error\":\"Failed to extract \" + req.type + \" function\"};\n    try {\n      return {\"type\":\"result\",\"data\":Object.fromEntries(req.challenges.map(function(c) { return [c, fn(c)]; }))};\n    } catch (e) {\n      return {\"type\":\"error\",\"error\":String(e)};\n    }\n  })};\n};", anonymousClass1) == obj3) {
                        }
                        this.bootstrapped = true;
                        EntryPoints.d$default(this.logger, "EjsChallengeSolver", "EJS bootstrap done elapsed=" + (InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds) + "ms", null, 12);
                        return obj2;
                    }
                    return obj3;
                case 5:
                    epochMilliseconds = anonymousClass1.J$0;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.J$0 = epochMilliseconds;
                    anonymousClass1.label = 6;
                    if (quickJsEngine.execute("globalThis.__itxPlayers = new Map();\nglobalThis.__itxCompile = function(key, code) {\n  var fns = {\"n\":null,\"sig\":null};\n  Function(\"_result\", code)(fns);\n  __itxPlayers.delete(key);\n  __itxPlayers.set(key, fns);\n  while (__itxPlayers.size > 2) __itxPlayers.delete(__itxPlayers.keys().next().value);\n  return fns;\n};\nglobalThis.__itxRun = function(fns, requests) {\n  return {\"type\":\"result\",\"responses\":requests.map(function(req) {\n    if (req.type !== \"n\" && req.type !== \"sig\")\n      return {\"type\":\"error\",\"error\":\"Unknown request type: \" + req.type};\n    var fn = fns[req.type];\n    if (!fn) return {\"type\":\"error\",\"error\":\"Failed to extract \" + req.type + \" function\"};\n    try {\n      return {\"type\":\"result\",\"data\":Object.fromEntries(req.challenges.map(function(c) { return [c, fn(c)]; }))};\n    } catch (e) {\n      return {\"type\":\"error\",\"error\":String(e)};\n    }\n  })};\n};", anonymousClass1) == obj3) {
                        return obj3;
                    }
                    this.bootstrapped = true;
                    EntryPoints.d$default(this.logger, "EjsChallengeSolver", "EJS bootstrap done elapsed=" + (InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds) + "ms", null, 12);
                    return obj2;
                case 6:
                    epochMilliseconds = anonymousClass1.J$0;
                    ResultKt.throwOnFailure(obj);
                    this.bootstrapped = true;
                    EntryPoints.d$default(this.logger, "EjsChallengeSolver", "EJS bootstrap done elapsed=" + (InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds) + "ms", null, 12);
                    return obj2;
                case 7:
                    Throwable th = anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (Throwable th2) {
            anonymousClass1.L$0 = th2;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 7;
            if (releaseRuntime(anonymousClass1) != obj3) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object loadPreprocessedPlayer(String str, String str2, ContinuationImpl continuationImpl) {
        C00891 c00891;
        String str3;
        if (continuationImpl instanceof C00891) {
            c00891 = (C00891) continuationImpl;
            int i = c00891.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00891.label = i - Integer.MIN_VALUE;
            } else {
                c00891 = new C00891(continuationImpl);
            }
        } else {
            c00891 = new C00891(continuationImpl);
        }
        Object obj = c00891.result;
        int i2 = c00891.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = this.preprocessedByPlayerUrl;
                String str4 = (String) linkedHashMap.remove(str);
                if (str4 != null) {
                    linkedHashMap.put(str, str4);
                    return str4;
                }
                if (str2 != null) {
                    App$Companion$forgetAccount$2 app$Companion$forgetAccount$2 = this.readPreprocessedPlayer;
                    c00891.L$0 = str;
                    c00891.L$1 = str2;
                    c00891.label = 1;
                    app$Companion$forgetAccount$2.invoke(str2, c00891);
                    obj = null;
                }
                return null;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return null;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = c00891.L$1;
            str = c00891.L$0;
            ResultKt.throwOnFailure(obj);
            str3 = (String) obj;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
            str3 = null;
        }
        if (str3 != null) {
            if (!StringsKt.isBlank(str3) && str3.length() <= 8388608) {
                putPreprocessedPlayerLocked(str, str3);
                return str3;
            }
            c00891.L$0 = null;
            c00891.L$1 = null;
            c00891.label = 2;
            Object objSafeWritePreprocessedPlayer = safeWritePreprocessedPlayer(str2, null, c00891);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objSafeWritePreprocessedPlayer == obj2) {
                return obj2;
            }
        }
        return null;
    }

    public final void putPreprocessedPlayerLocked(String str, String str2) {
        LinkedHashMap linkedHashMap = this.preprocessedByPlayerUrl;
        linkedHashMap.remove(str);
        linkedHashMap.put(str, str2);
        while (linkedHashMap.size() > 1) {
            Set setKeySet = linkedHashMap.keySet();
            setKeySet.getClass();
            String str3 = (String) CollectionsKt.firstOrNull(setKeySet);
            if (str3 == null) {
                return;
            } else {
                linkedHashMap.remove(str3);
            }
        }
    }

    public final Object releaseRuntime(ContinuationImpl continuationImpl) {
        this.bootstrapped = false;
        this.compiledPlayers.clear();
        this.preprocessedByPlayerUrl.clear();
        Object objDispose = this.engine.dispose(continuationImpl);
        return objDispose == CoroutineSingletons.COROUTINE_SUSPENDED ? objDispose : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object safeWritePreprocessedPlayer(String str, String str2, ContinuationImpl continuationImpl) {
        C00901 c00901;
        if (continuationImpl instanceof C00901) {
            c00901 = (C00901) continuationImpl;
            int i = c00901.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00901.label = i - Integer.MIN_VALUE;
            } else {
                c00901 = new C00901(continuationImpl);
            }
        } else {
            c00901 = new C00901(continuationImpl);
        }
        Object obj = c00901.result;
        int i2 = c00901.label;
        Unit unit = Unit.INSTANCE;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = this.writePreprocessedPlayer;
            c00901.label = 1;
            draggableKt$NoOpOnDragStarted$1.invoke(str, str2, c00901);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return unit == coroutineSingletons ? coroutineSingletons : unit;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public final Object solve(String str, Function1 function1, List list, boolean z, ContinuationImpl continuationImpl) {
        boolean zIsEmpty = list.isEmpty();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (!zIsEmpty && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((List) ((Pair) it.next()).second).isEmpty()) {
                    Iterator it2 = list.iterator();
                    int size = 0;
                    while (it2.hasNext()) {
                        size += ((List) ((Pair) it2.next()).second).size();
                    }
                    if (size <= 256) {
                        Iterator it3 = list.iterator();
                        long j = 0;
                        while (it3.hasNext()) {
                            Iterator it4 = ((List) ((Pair) it3.next()).second).iterator();
                            long length = 0;
                            while (it4.hasNext()) {
                                length += (long) ((String) it4.next()).length();
                            }
                            j += length;
                        }
                        if (j <= 8388608) {
                            if (!list.isEmpty()) {
                                Iterator it5 = list.iterator();
                                while (it5.hasNext()) {
                                    List list2 = (List) ((Pair) it5.next()).second;
                                    if (list2 == null || !list2.isEmpty()) {
                                        Iterator it6 = list2.iterator();
                                        while (it6.hasNext()) {
                                            if (((String) it6.next()).length() > 65536) {
                                            }
                                        }
                                    }
                                }
                            }
                            return withActivity(new AnonymousClass8(str, list, z, function1, null), continuationImpl);
                        }
                    }
                    return new SolveResult(emptyMap, emptyMap, null);
                }
            }
        }
        return new SolveResult(emptyMap, emptyMap, null);
    }

    /* JADX WARN: Code duplicated, block: B:145:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0231  */
    public final Object solveOnce(String str, String str2, List list, boolean z, ContinuationImpl continuationImpl) throws Throwable {
        C00911 c00911;
        long epochMilliseconds;
        List list2;
        String contentOrNull;
        JsonArray jsonArray;
        List list3;
        ArrayList arrayList;
        Throwable th;
        List list4;
        ArrayList arrayList2;
        String str3 = str;
        boolean z2 = z;
        if (continuationImpl instanceof C00911) {
            c00911 = (C00911) continuationImpl;
            int i = c00911.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00911.label = i - Integer.MIN_VALUE;
            } else {
                c00911 = new C00911(continuationImpl);
            }
        } else {
            c00911 = new C00911(continuationImpl);
        }
        Object objWithRuntime = c00911.result;
        int i2 = c00911.label;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        Throwable th2 = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithRuntime);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str4 = (String) pair.first;
                List list5 = (List) pair.second;
                if (!list5.isEmpty()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it2 = list5.iterator();
                    while (it2.hasNext()) {
                        JsonPrimitive JsonPrimitive = JsonElementKt.JsonPrimitive((String) it2.next());
                        JsonPrimitive.getClass();
                        arrayList4.add(JsonPrimitive);
                    }
                    arrayList3.add(new JsonObject(linkedHashMap));
                }
            }
            String strEncodeToString = payloadJson.encodeToString(JsonElement.INSTANCE.serializer(), new JsonArray(arrayList3));
            Regex regex = QuickJsEngine.JS_IDENTIFIER;
            String strJsStringLiteral$com_github_MetrolistGroup_innertubex = CharsKt.jsStringLiteral$com_github_MetrolistGroup_innertubex(str3);
            String strJsStringLiteral$com_github_MetrolistGroup_innertubex2 = str2 != null ? CharsKt.jsStringLiteral$com_github_MetrolistGroup_innertubex(str2) : null;
            if (strJsStringLiteral$com_github_MetrolistGroup_innertubex2 == null) {
                strJsStringLiteral$com_github_MetrolistGroup_innertubex2 = "";
            }
            if (strEncodeToString.length() + strJsStringLiteral$com_github_MetrolistGroup_innertubex2.length() > 10485760) {
                return new SolveResult(emptyMap, emptyMap, null);
            }
            String strM = IntIntPair$$ExternalSyntheticOutline0.m("\n            (function() {\n              ", str2 == null ? Fragment$5$$ExternalSyntheticOutline0.m("\n                    var fns = __itxPlayers.get(", strJsStringLiteral$com_github_MetrolistGroup_innertubex, ");\n                    var r = fns ? __itxRun(fns, ", strEncodeToString, ") : null;\n                    ") : z2 ? IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("\n                    var r = __itxRun(__itxCompile(", strJsStringLiteral$com_github_MetrolistGroup_innertubex, ", ", strJsStringLiteral$com_github_MetrolistGroup_innertubex2, "), "), strEncodeToString, ");\n                    ") : Fragment$5$$ExternalSyntheticOutline0.m("\n                    __itxPlayers.clear();\n                    var r = jsc({\"type\":\"player\",\"player\":", strJsStringLiteral$com_github_MetrolistGroup_innertubex2, ",\"output_preprocessed\":true,\"requests\":", strEncodeToString, "});\n                    "), "\n              if (!r) return JSON.stringify({\"type\":\"error\",\"error\":\"jsc returned null\"});\n              if (r.type === \"error\")\n                return JSON.stringify({\"type\":\"error\",\"error\":String(r.error != null ? r.error : \"\")});\n              if (r.type !== \"result\")\n                return JSON.stringify({\"type\":\"error\",\"error\":\"unexpected jsc type: \"+String(r.type)});\n              var out = {\"type\":\"result\",\"responses\":[]};\n              if (typeof r.preprocessed_player === \"string\" && r.preprocessed_player.length > 0) {\n                if (r.preprocessed_player.length > 8388608)\n                  return JSON.stringify({\"type\":\"error\",\"error\":\"preprocessed player too large\"});\n                out.preprocessed_player = r.preprocessed_player;\n              }\n              var resps = r.responses;\n              if (!resps) return JSON.stringify(out);\n              for (var i = 0; i < resps.length; i++) {\n                var resp = resps[i];\n                if (!resp) {\n                  out.responses.push({\"type\":\"error\",\"error\":\"null response\"});\n                  continue;\n                }\n                if (resp.type === \"error\") {\n                  out.responses.push({\n                    \"type\":\"error\",\n                    \"error\":String(resp.error != null ? resp.error : \"\")\n                  });\n                } else if (resp.type === \"result\") {\n                  var d = resp.data;\n                  var plain = {};\n                  if (d && typeof d === \"object\") {\n                    var keys = Object.keys(d);\n                    for (var j = 0; j < keys.length; j++) {\n                      var k = keys[j];\n                      var v = d[k];\n                      var text = v == null ? \"\" : String(v);\n                      if (text.length > 262144) {\n                        plain = null;\n                        break;\n                      }\n                      plain[k] = text;\n                    }\n                  }\n                  if (plain == null)\n                    out.responses.push({\"type\":\"error\",\"error\":\"solver output too large\"});\n                  else\n                    out.responses.push({\"type\":\"result\",\"data\":plain});\n                } else {\n                  out.responses.push({\"type\":\"error\",\"error\":\"unknown response type\"});\n                }\n              }\n              return JSON.stringify(out);\n            })()\n            ");
            epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
            if (str2 != null) {
                LinkedHashSet linkedHashSet = this.compiledPlayers;
                if (z2) {
                    linkedHashSet.remove(str3);
                    linkedHashSet.add(str3);
                    while (linkedHashSet.size() > 2) {
                        linkedHashSet.remove(CollectionsKt.first(linkedHashSet));
                    }
                } else {
                    linkedHashSet.clear();
                }
            }
            c00911.L$0 = str3;
            list2 = list;
            c00911.L$2 = list2;
            c00911.Z$0 = z2;
            c00911.J$0 = epochMilliseconds;
            c00911.label = 1;
            objWithRuntime = this.engine.withRuntime(new QuickJsEngine$evaluate$3(IntIntPair$$ExternalSyntheticOutline0.m("\n            (function() {\n              const value = (", strM, ");\n              if (value == null) return \"\";\n              const text = String(value);\n              return text.length <= 10485760 ? text : \"\";\n            })()\n            "), !z2, null), c00911);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithRuntime == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            long j = c00911.J$0;
            boolean z3 = c00911.Z$0;
            List list6 = c00911.L$2;
            String str5 = c00911.L$0;
            ResultKt.throwOnFailure(objWithRuntime);
            epochMilliseconds = j;
            str3 = str5;
            z2 = z3;
            list2 = list6;
        }
        String str6 = (String) objWithRuntime;
        if (str6.length() > 10485760) {
            return new SolveResult(emptyMap, emptyMap, null);
        }
        String string = StringsKt.trim(str6).toString();
        Iterator it3 = list2.iterator();
        int i3 = 0;
        int size = 0;
        while (it3.hasNext()) {
            size += ((List) ((Pair) it3.next()).second).size();
        }
        long epochMilliseconds2 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds;
        String strExtractPlayerHash = RemotePlayerConfigParser.extractPlayerHash(str3);
        if (strExtractPlayerHash == null) {
            strExtractPlayerHash = "unknown";
        }
        String str7 = "EJS evaluate done preprocessed=" + z2 + " requests=" + size + " elapsed=" + epochMilliseconds2 + "ms player=" + strExtractPlayerHash;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = this.logger;
        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "EjsChallengeSolver", str7, null, 12);
        try {
            JsonObject jsonObject = JsonElementKt.getJsonObject(Json.Default.parseToJsonElement(string));
            JsonElement jsonElement = (JsonElement) jsonObject.get(LinkHeader.Parameters.Type);
            if (!Intrinsics.areEqual(jsonElement != null ? JsonElementKt.getJsonPrimitive(jsonElement).getContent() : null, "result")) {
                EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "EjsChallengeSolver", "EJS returned a top-level error", null, 12);
                return new SolveResult(emptyMap, emptyMap, null);
            }
            JsonElement jsonElement2 = (JsonElement) jsonObject.get("preprocessed_player");
            if (jsonElement2 == null || (contentOrNull = JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(jsonElement2))) == null) {
                contentOrNull = null;
            } else {
                if (StringsKt.isBlank(contentOrNull)) {
                    contentOrNull = null;
                }
                if (contentOrNull == null || contentOrNull.length() > 8388608) {
                    contentOrNull = null;
                }
            }
            if (contentOrNull != null) {
                putPreprocessedPlayerLocked(str3, contentOrNull);
            }
            JsonElement jsonElement3 = (JsonElement) jsonObject.get("responses");
            JsonArray jsonArray2 = jsonElement3 != null ? JsonElementKt.getJsonArray(jsonElement3) : new JsonArray(EmptyList.INSTANCE);
            List list7 = jsonArray2.content;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj : list2) {
                if (!((Collection) ((Pair) obj).second).isEmpty()) {
                    arrayList5.add(obj);
                }
            }
            if (list7.size() != arrayList5.size()) {
                EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "EjsChallengeSolver", Fragment$5$$ExternalSyntheticOutline0.m(arrayList5.size(), list7.size(), "EJS responses size mismatch expected=", " got="), null, 12);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            int size2 = arrayList5.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList5.get(i4);
                i4++;
                int i5 = i3 + 1;
                if (i3 < 0) {
                    Throwable th3 = th2;
                    CollectionsKt__IterablesKt.throwIndexOverflow();
                    throw th3;
                }
                String str8 = (String) ((Pair) obj2).first;
                if (list7.size() > i3) {
                    JsonObject jsonObject2 = JsonElementKt.getJsonObject(jsonArray2.get(i3));
                    JsonElement jsonElement4 = (JsonElement) jsonObject2.get(LinkHeader.Parameters.Type);
                    if (Intrinsics.areEqual(jsonElement4 != null ? JsonElementKt.getJsonPrimitive(jsonElement4).getContent() : th2, "result")) {
                        JsonElement jsonElement5 = (JsonElement) jsonObject2.get("data");
                        if (jsonElement5 != null) {
                            Set<Map.Entry> setEntrySet = JsonElementKt.getJsonObject(jsonElement5).content.entrySet();
                            int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(setEntrySet, 10));
                            if (iMapCapacity < 16) {
                                iMapCapacity = 16;
                            }
                            LinkedHashMap linkedHashMap4 = new LinkedHashMap(iMapCapacity);
                            for (Map.Entry entry : setEntrySet) {
                                JsonArray jsonArray3 = jsonArray2;
                                Object key = entry.getKey();
                                String content = JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent();
                                if (StringsKt.isBlank(content)) {
                                    list4 = list7;
                                    arrayList2 = arrayList5;
                                } else {
                                    list4 = list7;
                                    arrayList2 = arrayList5;
                                    if (content.length() <= 262144) {
                                    }
                                    linkedHashMap4.put(key, content);
                                    jsonArray2 = jsonArray3;
                                    arrayList5 = arrayList2;
                                    list7 = list4;
                                }
                                content = null;
                                linkedHashMap4.put(key, content);
                                jsonArray2 = jsonArray3;
                                arrayList5 = arrayList2;
                                list7 = list4;
                            }
                            jsonArray = jsonArray2;
                            list3 = list7;
                            arrayList = arrayList5;
                            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                            for (Map.Entry entry2 : linkedHashMap4.entrySet()) {
                                if (((String) entry2.getValue()) != null) {
                                    linkedHashMap5.put(entry2.getKey(), entry2.getValue());
                                }
                            }
                            LinkedHashMap linkedHashMap6 = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(linkedHashMap5.size()));
                            for (Map.Entry entry3 : linkedHashMap5.entrySet()) {
                                Object key2 = entry3.getKey();
                                Object value = entry3.getValue();
                                value.getClass();
                                linkedHashMap6.put(key2, (String) value);
                            }
                            if (Intrinsics.areEqual(str8, "sig")) {
                                linkedHashMap2.putAll(linkedHashMap6);
                            } else if (Intrinsics.areEqual(str8, "n")) {
                                linkedHashMap3.putAll(linkedHashMap6);
                            }
                            th = null;
                        } else {
                            jsonArray = jsonArray2;
                            list3 = list7;
                            arrayList = arrayList5;
                            th = th2;
                        }
                    } else {
                        jsonArray = jsonArray2;
                        list3 = list7;
                        arrayList = arrayList5;
                        th = null;
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "EjsChallengeSolver", IntIntPair$$ExternalSyntheticOutline0.m("EJS request kind=", str8, " failed"), null, 12);
                    }
                } else {
                    jsonArray = jsonArray2;
                    list3 = list7;
                    arrayList = arrayList5;
                    th = th2;
                }
                jsonArray2 = jsonArray;
                th2 = th;
                i3 = i5;
                list7 = list3;
                arrayList5 = arrayList;
            }
            return new SolveResult(linkedHashMap2, linkedHashMap3, contentOrNull);
        } catch (Exception e) {
            String strM2 = Format$$ExternalSyntheticOutline0.m(e);
            if (strM2 == null) {
                strM2 = "Exception";
            }
            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "EjsChallengeSolver", IntIntPair$$ExternalSyntheticOutline0.m("EJS output was not valid JSON (", strM2, ")"), null, 12);
            return new SolveResult(emptyMap, emptyMap, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01a3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:106:0x01a4 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x01bd A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:117:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:120:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:121:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:124:0x01f2 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x01f8 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:131:0x0202  */
    /* JADX WARN: Code duplicated, block: B:132:0x0203 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x021a  */
    /* JADX WARN: Code duplicated, block: B:135:0x021b  */
    /* JADX WARN: Code duplicated, block: B:138:0x0225 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0239 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x024f  */
    /* JADX WARN: Code duplicated, block: B:156:0x025d  */
    /* JADX WARN: Code duplicated, block: B:159:0x0266  */
    /* JADX WARN: Code duplicated, block: B:175:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0125 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0126 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0137 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x013c  */
    /* JADX WARN: Code duplicated, block: B:84:0x013f A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0152  */
    /* JADX WARN: Code duplicated, block: B:87:0x0154 A[Catch: Exception -> 0x00ce, CancellationException -> 0x028d, PHI: r0 r1 r11 r12 r13 r14
      0x0154: PHI (r0v25 java.lang.Object) = (r0v18 java.lang.Object), (r0v3 java.lang.Object) binds: [B:85:0x0150, B:41:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0154: PHI (r1v13 boolean) = (r1v7 boolean), (r1v15 boolean) binds: [B:85:0x0150, B:41:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0154: PHI (r11v27 java.lang.String) = (r11v19 java.lang.String), (r11v29 java.lang.String) binds: [B:85:0x0150, B:41:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0154: PHI (r12v32 java.lang.String) = (r12v20 java.lang.String), (r12v34 java.lang.String) binds: [B:85:0x0150, B:41:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0154: PHI (r13v15 java.util.List) = (r13v9 java.util.List), (r13v16 java.util.List) binds: [B:85:0x0150, B:41:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0154: PHI (r14v26 kotlin.jvm.functions.Function1) = (r14v12 kotlin.jvm.functions.Function1), (r14v27 kotlin.jvm.functions.Function1) binds: [B:85:0x0150, B:41:0x00a7] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x00ce, blocks: (B:151:0x0253, B:136:0x021e, B:138:0x0225, B:140:0x0239, B:142:0x023f, B:144:0x0245, B:122:0x01ee, B:124:0x01f2, B:126:0x01f8, B:132:0x0203, B:118:0x01d4, B:103:0x019d, B:106:0x01a4, B:108:0x01bd, B:102:0x0197, B:87:0x0154, B:90:0x015e, B:70:0x011f, B:73:0x0126, B:79:0x0133, B:81:0x0137, B:84:0x013f, B:69:0x011a, B:49:0x00c8, B:58:0x00ec, B:54:0x00d7), top: B:165:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x015b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code duplicated, block: B:95:0x017d  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object solveUncached(String str, Function1 function1, List list, boolean z, ContinuationImpl continuationImpl) throws Throwable {
        C00921 c00921;
        Exception exc;
        String str2;
        String strExtractPlayerHash;
        String strM;
        Function1 function2;
        boolean z2;
        Function1 function3;
        List list2;
        Function1 function4;
        String str3;
        CancellationException cancellationException;
        boolean z3;
        SolveResult solveResult;
        String str4;
        String strPreprocessedPlayerCacheKey;
        String str5;
        String str6;
        Function1 function5;
        SolveResult solveResult2;
        String str7;
        Function1 function6;
        Object objSolveOnce;
        String str8;
        boolean z4;
        SolveResult solveResult3;
        List list3;
        SolveResult solveResult4;
        String str9;
        Function1 function7;
        Object objSafeWritePreprocessedPlayer;
        String str10;
        boolean z5;
        Function1 function8;
        Object objInvoke;
        Object obj;
        List list4;
        String str11;
        Object objSolveOnce2;
        String str12;
        String str13;
        String str14;
        Object obj2;
        Object objSafeWritePreprocessedPlayer2;
        if (continuationImpl instanceof C00921) {
            c00921 = (C00921) continuationImpl;
            int i = c00921.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00921.label = i - Integer.MIN_VALUE;
            } else {
                c00921 = new C00921(continuationImpl);
            }
        } else {
            c00921 = new C00921(continuationImpl);
        }
        C00921 c00922 = c00921;
        Object objLoadPreprocessedPlayer = c00922.result;
        int i2 = c00922.label;
        Object obj3 = Unit.INSTANCE;
        LinkedHashSet linkedHashSet = this.compiledPlayers;
        Object obj4 = CoroutineSingletons.COROUTINE_SUSPENDED;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        try {
            try {
                try {
                    switch (i2) {
                        case 0:
                            ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                            c00922.L$0 = str;
                            c00922.L$1 = function1;
                            c00922.L$2 = list;
                            c00922.Z$0 = z;
                            c00922.label = 1;
                            if (ensureBootstrapped(c00922) != obj4) {
                                function2 = function1;
                                z2 = z;
                                if (z2 || !linkedHashSet.contains(str)) {
                                    function3 = function2;
                                    str4 = this.bundleHash;
                                    if (str4 != null) {
                                        strPreprocessedPlayerCacheKey = EjsChallengeSolverKt.preprocessedPlayerCacheKey(str, str4);
                                    } else {
                                        strPreprocessedPlayerCacheKey = null;
                                    }
                                    if (z2) {
                                        c00922.L$0 = str;
                                        c00922.L$1 = function3;
                                        c00922.L$2 = list;
                                        c00922.L$3 = strPreprocessedPlayerCacheKey;
                                        c00922.Z$0 = z2;
                                        c00922.label = 3;
                                        objLoadPreprocessedPlayer = loadPreprocessedPlayer(str, strPreprocessedPlayerCacheKey, c00922);
                                        if (objLoadPreprocessedPlayer == obj4) {
                                            String str15 = (String) objLoadPreprocessedPlayer;
                                            str5 = strPreprocessedPlayerCacheKey;
                                            str6 = str15;
                                            function5 = function3;
                                            solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                                            if (str6 != null) {
                                                try {
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = function5;
                                                    c00922.L$2 = list;
                                                    c00922.L$3 = str5;
                                                    c00922.L$5 = null;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 4;
                                                    objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                                    if (objSolveOnce != obj4) {
                                                        boolean z6 = z2;
                                                        str8 = str;
                                                        z4 = z6;
                                                        String str16 = str5;
                                                        objLoadPreprocessedPlayer = objSolveOnce;
                                                        str7 = str16;
                                                        function6 = function5;
                                                        solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                                        String str17 = str8;
                                                        z2 = z4;
                                                        str = str17;
                                                        List list5 = list;
                                                        str9 = str7;
                                                        solveResult3 = solveResult4;
                                                        function7 = function6;
                                                        list3 = list5;
                                                        if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                                            return solveResult3;
                                                        }
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = function7;
                                                        c00922.L$2 = list3;
                                                        c00922.L$3 = str9;
                                                        c00922.L$5 = solveResult3;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 5;
                                                        this.preprocessedByPlayerUrl.remove(str);
                                                        linkedHashSet.remove(str);
                                                        if (str9 != null || (objSafeWritePreprocessedPlayer = safeWritePreprocessedPlayer(str9, null, c00922)) != obj4) {
                                                            objSafeWritePreprocessedPlayer = obj3;
                                                        }
                                                        if (objSafeWritePreprocessedPlayer != obj4) {
                                                            str10 = str;
                                                            z5 = z2;
                                                            function8 = function7;
                                                            str5 = str9;
                                                            function5 = function8;
                                                            z2 = z5;
                                                            str = str10;
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = null;
                                                            c00922.L$2 = list3;
                                                            c00922.L$3 = str5;
                                                            c00922.L$5 = solveResult3;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 6;
                                                            objInvoke = function5.invoke(c00922);
                                                            if (objInvoke == obj4) {
                                                                List list6 = list3;
                                                                obj = objInvoke;
                                                                list4 = list6;
                                                                str11 = (String) obj;
                                                                if (str11 != null) {
                                                                    if (StringsKt.isBlank(str11) || str11.length() > 8388608) {
                                                                        str11 = null;
                                                                    }
                                                                    if (str11 != null) {
                                                                        c00922.L$0 = str;
                                                                        c00922.L$1 = null;
                                                                        c00922.L$2 = null;
                                                                        c00922.L$3 = str5;
                                                                        c00922.L$5 = null;
                                                                        c00922.Z$0 = z2;
                                                                        c00922.label = 7;
                                                                        objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                                        if (objSolveOnce2 != obj4) {
                                                                            String str18 = str5;
                                                                            objLoadPreprocessedPlayer = objSolveOnce2;
                                                                            str12 = str18;
                                                                            str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                            if (str13 != null) {
                                                                                c00922.L$0 = str;
                                                                                c00922.L$1 = null;
                                                                                c00922.L$2 = null;
                                                                                c00922.L$3 = null;
                                                                                c00922.L$5 = null;
                                                                                c00922.L$7 = objLoadPreprocessedPlayer;
                                                                                c00922.Z$0 = z2;
                                                                                c00922.label = 8;
                                                                                if (str12 != null && !StringsKt.isBlank(str13) && str13.length() <= 8388608 && (objSafeWritePreprocessedPlayer2 = safeWritePreprocessedPlayer(str12, str13, c00922)) == obj4) {
                                                                                    obj3 = objSafeWritePreprocessedPlayer2;
                                                                                }
                                                                                if (obj3 != obj4) {
                                                                                    str14 = str;
                                                                                    obj2 = objLoadPreprocessedPlayer;
                                                                                    objLoadPreprocessedPlayer = obj2;
                                                                                    str = str14;
                                                                                }
                                                                            }
                                                                            return (SolveResult) objLoadPreprocessedPlayer;
                                                                        }
                                                                    }
                                                                }
                                                                return solveResult3;
                                                            }
                                                        }
                                                    }
                                                } catch (CancellationException e) {
                                                    throw e;
                                                } catch (Exception unused) {
                                                    str7 = str5;
                                                    function6 = function5;
                                                    solveResult4 = new SolveResult(emptyMap, emptyMap, null);
                                                }
                                            } else {
                                                solveResult3 = solveResult2;
                                                list3 = list;
                                                c00922.L$0 = str;
                                                c00922.L$1 = null;
                                                c00922.L$2 = list3;
                                                c00922.L$3 = str5;
                                                c00922.L$5 = solveResult3;
                                                c00922.Z$0 = z2;
                                                c00922.label = 6;
                                                objInvoke = function5.invoke(c00922);
                                                if (objInvoke == obj4) {
                                                    List list7 = list3;
                                                    obj = objInvoke;
                                                    list4 = list7;
                                                    str11 = (String) obj;
                                                    if (str11 != null) {
                                                        if (StringsKt.isBlank(str11)) {
                                                            str11 = null;
                                                        } else {
                                                            str11 = null;
                                                        }
                                                        if (str11 != null) {
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = null;
                                                            c00922.L$2 = null;
                                                            c00922.L$3 = str5;
                                                            c00922.L$5 = null;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 7;
                                                            objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                            if (objSolveOnce2 != obj4) {
                                                                String str19 = str5;
                                                                objLoadPreprocessedPlayer = objSolveOnce2;
                                                                str12 = str19;
                                                                str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                if (str13 != null) {
                                                                    c00922.L$0 = str;
                                                                    c00922.L$1 = null;
                                                                    c00922.L$2 = null;
                                                                    c00922.L$3 = null;
                                                                    c00922.L$5 = null;
                                                                    c00922.L$7 = objLoadPreprocessedPlayer;
                                                                    c00922.Z$0 = z2;
                                                                    c00922.label = 8;
                                                                    if (str12 != null) {
                                                                        obj3 = objSafeWritePreprocessedPlayer2;
                                                                    }
                                                                    if (obj3 != obj4) {
                                                                        str14 = str;
                                                                        obj2 = objLoadPreprocessedPlayer;
                                                                        objLoadPreprocessedPlayer = obj2;
                                                                        str = str14;
                                                                    }
                                                                }
                                                                return (SolveResult) objLoadPreprocessedPlayer;
                                                            }
                                                        }
                                                    }
                                                    return solveResult3;
                                                }
                                            }
                                        }
                                    } else {
                                        str5 = strPreprocessedPlayerCacheKey;
                                        str6 = null;
                                        function5 = function3;
                                        solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                                        if (str6 != null) {
                                            c00922.L$0 = str;
                                            c00922.L$1 = function5;
                                            c00922.L$2 = list;
                                            c00922.L$3 = str5;
                                            c00922.L$5 = null;
                                            c00922.Z$0 = z2;
                                            c00922.label = 4;
                                            objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                            if (objSolveOnce != obj4) {
                                                boolean z7 = z2;
                                                str8 = str;
                                                z4 = z7;
                                                String str110 = str5;
                                                objLoadPreprocessedPlayer = objSolveOnce;
                                                str7 = str110;
                                                function6 = function5;
                                                solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                                String str111 = str8;
                                                z2 = z4;
                                                str = str111;
                                                List list8 = list;
                                                str9 = str7;
                                                solveResult3 = solveResult4;
                                                function7 = function6;
                                                list3 = list8;
                                                if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                                    return solveResult3;
                                                }
                                                c00922.L$0 = str;
                                                c00922.L$1 = function7;
                                                c00922.L$2 = list3;
                                                c00922.L$3 = str9;
                                                c00922.L$5 = solveResult3;
                                                c00922.Z$0 = z2;
                                                c00922.label = 5;
                                                this.preprocessedByPlayerUrl.remove(str);
                                                linkedHashSet.remove(str);
                                                if (str9 != null) {
                                                    objSafeWritePreprocessedPlayer = obj3;
                                                } else {
                                                    objSafeWritePreprocessedPlayer = obj3;
                                                }
                                                if (objSafeWritePreprocessedPlayer != obj4) {
                                                    str10 = str;
                                                    z5 = z2;
                                                    function8 = function7;
                                                    str5 = str9;
                                                    function5 = function8;
                                                    z2 = z5;
                                                    str = str10;
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = null;
                                                    c00922.L$2 = list3;
                                                    c00922.L$3 = str5;
                                                    c00922.L$5 = solveResult3;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 6;
                                                    objInvoke = function5.invoke(c00922);
                                                    if (objInvoke == obj4) {
                                                        List list9 = list3;
                                                        obj = objInvoke;
                                                        list4 = list9;
                                                        str11 = (String) obj;
                                                        if (str11 != null) {
                                                            if (StringsKt.isBlank(str11)) {
                                                                str11 = null;
                                                            } else {
                                                                str11 = null;
                                                            }
                                                            if (str11 != null) {
                                                                c00922.L$0 = str;
                                                                c00922.L$1 = null;
                                                                c00922.L$2 = null;
                                                                c00922.L$3 = str5;
                                                                c00922.L$5 = null;
                                                                c00922.Z$0 = z2;
                                                                c00922.label = 7;
                                                                objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                                if (objSolveOnce2 != obj4) {
                                                                    String str112 = str5;
                                                                    objLoadPreprocessedPlayer = objSolveOnce2;
                                                                    str12 = str112;
                                                                    str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                    if (str13 != null) {
                                                                        c00922.L$0 = str;
                                                                        c00922.L$1 = null;
                                                                        c00922.L$2 = null;
                                                                        c00922.L$3 = null;
                                                                        c00922.L$5 = null;
                                                                        c00922.L$7 = objLoadPreprocessedPlayer;
                                                                        c00922.Z$0 = z2;
                                                                        c00922.label = 8;
                                                                        if (str12 != null) {
                                                                            obj3 = objSafeWritePreprocessedPlayer2;
                                                                        }
                                                                        if (obj3 != obj4) {
                                                                            str14 = str;
                                                                            obj2 = objLoadPreprocessedPlayer;
                                                                            objLoadPreprocessedPlayer = obj2;
                                                                            str = str14;
                                                                        }
                                                                    }
                                                                    return (SolveResult) objLoadPreprocessedPlayer;
                                                                }
                                                            }
                                                        }
                                                        return solveResult3;
                                                    }
                                                }
                                            }
                                        } else {
                                            solveResult3 = solveResult2;
                                            list3 = list;
                                            c00922.L$0 = str;
                                            c00922.L$1 = null;
                                            c00922.L$2 = list3;
                                            c00922.L$3 = str5;
                                            c00922.L$5 = solveResult3;
                                            c00922.Z$0 = z2;
                                            c00922.label = 6;
                                            objInvoke = function5.invoke(c00922);
                                            if (objInvoke == obj4) {
                                                List list10 = list3;
                                                obj = objInvoke;
                                                list4 = list10;
                                                str11 = (String) obj;
                                                if (str11 != null) {
                                                    if (StringsKt.isBlank(str11)) {
                                                        str11 = null;
                                                    } else {
                                                        str11 = null;
                                                    }
                                                    if (str11 != null) {
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = null;
                                                        c00922.L$2 = null;
                                                        c00922.L$3 = str5;
                                                        c00922.L$5 = null;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 7;
                                                        objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                        if (objSolveOnce2 != obj4) {
                                                            String str113 = str5;
                                                            objLoadPreprocessedPlayer = objSolveOnce2;
                                                            str12 = str113;
                                                            str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                            if (str13 != null) {
                                                                c00922.L$0 = str;
                                                                c00922.L$1 = null;
                                                                c00922.L$2 = null;
                                                                c00922.L$3 = null;
                                                                c00922.L$5 = null;
                                                                c00922.L$7 = objLoadPreprocessedPlayer;
                                                                c00922.Z$0 = z2;
                                                                c00922.label = 8;
                                                                if (str12 != null) {
                                                                    obj3 = objSafeWritePreprocessedPlayer2;
                                                                }
                                                                if (obj3 != obj4) {
                                                                    str14 = str;
                                                                    obj2 = objLoadPreprocessedPlayer;
                                                                    objLoadPreprocessedPlayer = obj2;
                                                                    str = str14;
                                                                }
                                                            }
                                                            return (SolveResult) objLoadPreprocessedPlayer;
                                                        }
                                                    }
                                                }
                                                return solveResult3;
                                            }
                                        }
                                    }
                                } else {
                                    try {
                                        c00922.L$0 = str;
                                        c00922.L$1 = function2;
                                        c00922.L$2 = list;
                                        c00922.Z$0 = z2;
                                        c00922.label = 2;
                                        Object objSolveOnce3 = solveOnce(str, null, list, true, c00922);
                                        if (objSolveOnce3 != obj4) {
                                            objLoadPreprocessedPlayer = objSolveOnce3;
                                            list2 = list;
                                            function4 = function2;
                                            str3 = str;
                                            z3 = z2;
                                            solveResult = (SolveResult) objLoadPreprocessedPlayer;
                                            z2 = z3;
                                            str = str3;
                                            if (EjsChallengeSolverKt.solvesAll(solveResult, list2)) {
                                                return solveResult;
                                            }
                                            linkedHashSet.remove(str);
                                            function3 = function4;
                                            list = list2;
                                            str4 = this.bundleHash;
                                            if (str4 != null) {
                                                strPreprocessedPlayerCacheKey = EjsChallengeSolverKt.preprocessedPlayerCacheKey(str, str4);
                                            } else {
                                                strPreprocessedPlayerCacheKey = null;
                                            }
                                            if (z2) {
                                                c00922.L$0 = str;
                                                c00922.L$1 = function3;
                                                c00922.L$2 = list;
                                                c00922.L$3 = strPreprocessedPlayerCacheKey;
                                                c00922.Z$0 = z2;
                                                c00922.label = 3;
                                                objLoadPreprocessedPlayer = loadPreprocessedPlayer(str, strPreprocessedPlayerCacheKey, c00922);
                                                if (objLoadPreprocessedPlayer == obj4) {
                                                    String str114 = (String) objLoadPreprocessedPlayer;
                                                    str5 = strPreprocessedPlayerCacheKey;
                                                    str6 = str114;
                                                    function5 = function3;
                                                    solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                                                    if (str6 != null) {
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = function5;
                                                        c00922.L$2 = list;
                                                        c00922.L$3 = str5;
                                                        c00922.L$5 = null;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 4;
                                                        objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                                        if (objSolveOnce != obj4) {
                                                            boolean z8 = z2;
                                                            str8 = str;
                                                            z4 = z8;
                                                            String str115 = str5;
                                                            objLoadPreprocessedPlayer = objSolveOnce;
                                                            str7 = str115;
                                                            function6 = function5;
                                                            solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                                            String str116 = str8;
                                                            z2 = z4;
                                                            str = str116;
                                                            List list11 = list;
                                                            str9 = str7;
                                                            solveResult3 = solveResult4;
                                                            function7 = function6;
                                                            list3 = list11;
                                                            if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                                                return solveResult3;
                                                            }
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = function7;
                                                            c00922.L$2 = list3;
                                                            c00922.L$3 = str9;
                                                            c00922.L$5 = solveResult3;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 5;
                                                            this.preprocessedByPlayerUrl.remove(str);
                                                            linkedHashSet.remove(str);
                                                            if (str9 != null) {
                                                                objSafeWritePreprocessedPlayer = obj3;
                                                            } else {
                                                                objSafeWritePreprocessedPlayer = obj3;
                                                            }
                                                            if (objSafeWritePreprocessedPlayer != obj4) {
                                                                str10 = str;
                                                                z5 = z2;
                                                                function8 = function7;
                                                                str5 = str9;
                                                                function5 = function8;
                                                                z2 = z5;
                                                                str = str10;
                                                                c00922.L$0 = str;
                                                                c00922.L$1 = null;
                                                                c00922.L$2 = list3;
                                                                c00922.L$3 = str5;
                                                                c00922.L$5 = solveResult3;
                                                                c00922.Z$0 = z2;
                                                                c00922.label = 6;
                                                                objInvoke = function5.invoke(c00922);
                                                                if (objInvoke == obj4) {
                                                                    List list12 = list3;
                                                                    obj = objInvoke;
                                                                    list4 = list12;
                                                                    str11 = (String) obj;
                                                                    if (str11 != null) {
                                                                        if (StringsKt.isBlank(str11)) {
                                                                            str11 = null;
                                                                        } else {
                                                                            str11 = null;
                                                                        }
                                                                        if (str11 != null) {
                                                                            c00922.L$0 = str;
                                                                            c00922.L$1 = null;
                                                                            c00922.L$2 = null;
                                                                            c00922.L$3 = str5;
                                                                            c00922.L$5 = null;
                                                                            c00922.Z$0 = z2;
                                                                            c00922.label = 7;
                                                                            objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                                            if (objSolveOnce2 != obj4) {
                                                                                String str117 = str5;
                                                                                objLoadPreprocessedPlayer = objSolveOnce2;
                                                                                str12 = str117;
                                                                                str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                                if (str13 != null) {
                                                                                    c00922.L$0 = str;
                                                                                    c00922.L$1 = null;
                                                                                    c00922.L$2 = null;
                                                                                    c00922.L$3 = null;
                                                                                    c00922.L$5 = null;
                                                                                    c00922.L$7 = objLoadPreprocessedPlayer;
                                                                                    c00922.Z$0 = z2;
                                                                                    c00922.label = 8;
                                                                                    if (str12 != null) {
                                                                                        obj3 = objSafeWritePreprocessedPlayer2;
                                                                                    }
                                                                                    if (obj3 != obj4) {
                                                                                        str14 = str;
                                                                                        obj2 = objLoadPreprocessedPlayer;
                                                                                        objLoadPreprocessedPlayer = obj2;
                                                                                        str = str14;
                                                                                    }
                                                                                }
                                                                                return (SolveResult) objLoadPreprocessedPlayer;
                                                                            }
                                                                        }
                                                                    }
                                                                    return solveResult3;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        solveResult3 = solveResult2;
                                                        list3 = list;
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = null;
                                                        c00922.L$2 = list3;
                                                        c00922.L$3 = str5;
                                                        c00922.L$5 = solveResult3;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 6;
                                                        objInvoke = function5.invoke(c00922);
                                                        if (objInvoke == obj4) {
                                                            List list13 = list3;
                                                            obj = objInvoke;
                                                            list4 = list13;
                                                            str11 = (String) obj;
                                                            if (str11 != null) {
                                                                if (StringsKt.isBlank(str11)) {
                                                                    str11 = null;
                                                                } else {
                                                                    str11 = null;
                                                                }
                                                                if (str11 != null) {
                                                                    c00922.L$0 = str;
                                                                    c00922.L$1 = null;
                                                                    c00922.L$2 = null;
                                                                    c00922.L$3 = str5;
                                                                    c00922.L$5 = null;
                                                                    c00922.Z$0 = z2;
                                                                    c00922.label = 7;
                                                                    objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                                    if (objSolveOnce2 != obj4) {
                                                                        String str118 = str5;
                                                                        objLoadPreprocessedPlayer = objSolveOnce2;
                                                                        str12 = str118;
                                                                        str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                        if (str13 != null) {
                                                                            c00922.L$0 = str;
                                                                            c00922.L$1 = null;
                                                                            c00922.L$2 = null;
                                                                            c00922.L$3 = null;
                                                                            c00922.L$5 = null;
                                                                            c00922.L$7 = objLoadPreprocessedPlayer;
                                                                            c00922.Z$0 = z2;
                                                                            c00922.label = 8;
                                                                            if (str12 != null) {
                                                                                obj3 = objSafeWritePreprocessedPlayer2;
                                                                            }
                                                                            if (obj3 != obj4) {
                                                                                str14 = str;
                                                                                obj2 = objLoadPreprocessedPlayer;
                                                                                objLoadPreprocessedPlayer = obj2;
                                                                                str = str14;
                                                                            }
                                                                        }
                                                                        return (SolveResult) objLoadPreprocessedPlayer;
                                                                    }
                                                                }
                                                            }
                                                            return solveResult3;
                                                        }
                                                    }
                                                }
                                            } else {
                                                str5 = strPreprocessedPlayerCacheKey;
                                                str6 = null;
                                                function5 = function3;
                                                solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                                                if (str6 != null) {
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = function5;
                                                    c00922.L$2 = list;
                                                    c00922.L$3 = str5;
                                                    c00922.L$5 = null;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 4;
                                                    objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                                    if (objSolveOnce != obj4) {
                                                        boolean z9 = z2;
                                                        str8 = str;
                                                        z4 = z9;
                                                        String str119 = str5;
                                                        objLoadPreprocessedPlayer = objSolveOnce;
                                                        str7 = str119;
                                                        function6 = function5;
                                                        solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                                        String str1110 = str8;
                                                        z2 = z4;
                                                        str = str1110;
                                                        List list14 = list;
                                                        str9 = str7;
                                                        solveResult3 = solveResult4;
                                                        function7 = function6;
                                                        list3 = list14;
                                                        if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                                            return solveResult3;
                                                        }
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = function7;
                                                        c00922.L$2 = list3;
                                                        c00922.L$3 = str9;
                                                        c00922.L$5 = solveResult3;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 5;
                                                        this.preprocessedByPlayerUrl.remove(str);
                                                        linkedHashSet.remove(str);
                                                        if (str9 != null) {
                                                            objSafeWritePreprocessedPlayer = obj3;
                                                        } else {
                                                            objSafeWritePreprocessedPlayer = obj3;
                                                        }
                                                        if (objSafeWritePreprocessedPlayer != obj4) {
                                                            str10 = str;
                                                            z5 = z2;
                                                            function8 = function7;
                                                            str5 = str9;
                                                            function5 = function8;
                                                            z2 = z5;
                                                            str = str10;
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = null;
                                                            c00922.L$2 = list3;
                                                            c00922.L$3 = str5;
                                                            c00922.L$5 = solveResult3;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 6;
                                                            objInvoke = function5.invoke(c00922);
                                                            if (objInvoke == obj4) {
                                                                List list15 = list3;
                                                                obj = objInvoke;
                                                                list4 = list15;
                                                                str11 = (String) obj;
                                                                if (str11 != null) {
                                                                    if (StringsKt.isBlank(str11)) {
                                                                        str11 = null;
                                                                    } else {
                                                                        str11 = null;
                                                                    }
                                                                    if (str11 != null) {
                                                                        c00922.L$0 = str;
                                                                        c00922.L$1 = null;
                                                                        c00922.L$2 = null;
                                                                        c00922.L$3 = str5;
                                                                        c00922.L$5 = null;
                                                                        c00922.Z$0 = z2;
                                                                        c00922.label = 7;
                                                                        objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                                        if (objSolveOnce2 != obj4) {
                                                                            String str1111 = str5;
                                                                            objLoadPreprocessedPlayer = objSolveOnce2;
                                                                            str12 = str1111;
                                                                            str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                            if (str13 != null) {
                                                                                c00922.L$0 = str;
                                                                                c00922.L$1 = null;
                                                                                c00922.L$2 = null;
                                                                                c00922.L$3 = null;
                                                                                c00922.L$5 = null;
                                                                                c00922.L$7 = objLoadPreprocessedPlayer;
                                                                                c00922.Z$0 = z2;
                                                                                c00922.label = 8;
                                                                                if (str12 != null) {
                                                                                    obj3 = objSafeWritePreprocessedPlayer2;
                                                                                }
                                                                                if (obj3 != obj4) {
                                                                                    str14 = str;
                                                                                    obj2 = objLoadPreprocessedPlayer;
                                                                                    objLoadPreprocessedPlayer = obj2;
                                                                                    str = str14;
                                                                                }
                                                                            }
                                                                            return (SolveResult) objLoadPreprocessedPlayer;
                                                                        }
                                                                    }
                                                                }
                                                                return solveResult3;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    solveResult3 = solveResult2;
                                                    list3 = list;
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = null;
                                                    c00922.L$2 = list3;
                                                    c00922.L$3 = str5;
                                                    c00922.L$5 = solveResult3;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 6;
                                                    objInvoke = function5.invoke(c00922);
                                                    if (objInvoke == obj4) {
                                                        List list16 = list3;
                                                        obj = objInvoke;
                                                        list4 = list16;
                                                        str11 = (String) obj;
                                                        if (str11 != null) {
                                                            if (StringsKt.isBlank(str11)) {
                                                                str11 = null;
                                                            } else {
                                                                str11 = null;
                                                            }
                                                            if (str11 != null) {
                                                                c00922.L$0 = str;
                                                                c00922.L$1 = null;
                                                                c00922.L$2 = null;
                                                                c00922.L$3 = str5;
                                                                c00922.L$5 = null;
                                                                c00922.Z$0 = z2;
                                                                c00922.label = 7;
                                                                objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                                if (objSolveOnce2 != obj4) {
                                                                    String str1112 = str5;
                                                                    objLoadPreprocessedPlayer = objSolveOnce2;
                                                                    str12 = str1112;
                                                                    str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                    if (str13 != null) {
                                                                        c00922.L$0 = str;
                                                                        c00922.L$1 = null;
                                                                        c00922.L$2 = null;
                                                                        c00922.L$3 = null;
                                                                        c00922.L$5 = null;
                                                                        c00922.L$7 = objLoadPreprocessedPlayer;
                                                                        c00922.Z$0 = z2;
                                                                        c00922.label = 8;
                                                                        if (str12 != null) {
                                                                            obj3 = objSafeWritePreprocessedPlayer2;
                                                                        }
                                                                        if (obj3 != obj4) {
                                                                            str14 = str;
                                                                            obj2 = objLoadPreprocessedPlayer;
                                                                            objLoadPreprocessedPlayer = obj2;
                                                                            str = str14;
                                                                        }
                                                                    }
                                                                    return (SolveResult) objLoadPreprocessedPlayer;
                                                                }
                                                            }
                                                        }
                                                        return solveResult3;
                                                    }
                                                }
                                            }
                                        }
                                    } catch (CancellationException e2) {
                                        str3 = str;
                                        cancellationException = e2;
                                        try {
                                            throw cancellationException;
                                        } catch (Exception e3) {
                                            exc = e3;
                                            str2 = str3;
                                            strExtractPlayerHash = RemotePlayerConfigParser.extractPlayerHash(str2);
                                            if (strExtractPlayerHash == null) {
                                                strExtractPlayerHash = "unknown";
                                            }
                                            strM = Format$$ExternalSyntheticOutline0.m(exc);
                                            if (strM == null) {
                                                strM = "Exception";
                                            }
                                            EntryPoints.w$default(this.logger, "EjsChallengeSolver", "EJS solve failed player=" + strExtractPlayerHash + " type=" + strM, null, 12);
                                            return new SolveResult(emptyMap, emptyMap, null);
                                        }
                                    } catch (Exception unused2) {
                                        list2 = list;
                                        function4 = function2;
                                        solveResult = new SolveResult(emptyMap, emptyMap, null);
                                    }
                                }
                            }
                            return obj4;
                        case 1:
                            z = c00922.Z$0;
                            list = c00922.L$2;
                            function1 = c00922.L$1;
                            str = c00922.L$0;
                            ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                            function2 = function1;
                            z2 = z;
                            if (z2) {
                                break;
                            }
                            function3 = function2;
                            str4 = this.bundleHash;
                            if (str4 != null) {
                                strPreprocessedPlayerCacheKey = EjsChallengeSolverKt.preprocessedPlayerCacheKey(str, str4);
                            } else {
                                strPreprocessedPlayerCacheKey = null;
                            }
                            if (z2) {
                                c00922.L$0 = str;
                                c00922.L$1 = function3;
                                c00922.L$2 = list;
                                c00922.L$3 = strPreprocessedPlayerCacheKey;
                                c00922.Z$0 = z2;
                                c00922.label = 3;
                                objLoadPreprocessedPlayer = loadPreprocessedPlayer(str, strPreprocessedPlayerCacheKey, c00922);
                                if (objLoadPreprocessedPlayer == obj4) {
                                    String str1113 = (String) objLoadPreprocessedPlayer;
                                    str5 = strPreprocessedPlayerCacheKey;
                                    str6 = str1113;
                                    function5 = function3;
                                    solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                                    if (str6 != null) {
                                        c00922.L$0 = str;
                                        c00922.L$1 = function5;
                                        c00922.L$2 = list;
                                        c00922.L$3 = str5;
                                        c00922.L$5 = null;
                                        c00922.Z$0 = z2;
                                        c00922.label = 4;
                                        objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                        if (objSolveOnce != obj4) {
                                            boolean z10 = z2;
                                            str8 = str;
                                            z4 = z10;
                                            String str1114 = str5;
                                            objLoadPreprocessedPlayer = objSolveOnce;
                                            str7 = str1114;
                                            function6 = function5;
                                            solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                            String str1115 = str8;
                                            z2 = z4;
                                            str = str1115;
                                            List list17 = list;
                                            str9 = str7;
                                            solveResult3 = solveResult4;
                                            function7 = function6;
                                            list3 = list17;
                                            if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                                return solveResult3;
                                            }
                                            c00922.L$0 = str;
                                            c00922.L$1 = function7;
                                            c00922.L$2 = list3;
                                            c00922.L$3 = str9;
                                            c00922.L$5 = solveResult3;
                                            c00922.Z$0 = z2;
                                            c00922.label = 5;
                                            this.preprocessedByPlayerUrl.remove(str);
                                            linkedHashSet.remove(str);
                                            if (str9 != null) {
                                                objSafeWritePreprocessedPlayer = obj3;
                                            } else {
                                                objSafeWritePreprocessedPlayer = obj3;
                                            }
                                            if (objSafeWritePreprocessedPlayer != obj4) {
                                                str10 = str;
                                                z5 = z2;
                                                function8 = function7;
                                                str5 = str9;
                                                function5 = function8;
                                                z2 = z5;
                                                str = str10;
                                                c00922.L$0 = str;
                                                c00922.L$1 = null;
                                                c00922.L$2 = list3;
                                                c00922.L$3 = str5;
                                                c00922.L$5 = solveResult3;
                                                c00922.Z$0 = z2;
                                                c00922.label = 6;
                                                objInvoke = function5.invoke(c00922);
                                                if (objInvoke == obj4) {
                                                    List list18 = list3;
                                                    obj = objInvoke;
                                                    list4 = list18;
                                                    str11 = (String) obj;
                                                    if (str11 != null) {
                                                        if (StringsKt.isBlank(str11)) {
                                                            str11 = null;
                                                        } else {
                                                            str11 = null;
                                                        }
                                                        if (str11 != null) {
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = null;
                                                            c00922.L$2 = null;
                                                            c00922.L$3 = str5;
                                                            c00922.L$5 = null;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 7;
                                                            objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                            if (objSolveOnce2 != obj4) {
                                                                String str1116 = str5;
                                                                objLoadPreprocessedPlayer = objSolveOnce2;
                                                                str12 = str1116;
                                                                str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                if (str13 != null) {
                                                                    c00922.L$0 = str;
                                                                    c00922.L$1 = null;
                                                                    c00922.L$2 = null;
                                                                    c00922.L$3 = null;
                                                                    c00922.L$5 = null;
                                                                    c00922.L$7 = objLoadPreprocessedPlayer;
                                                                    c00922.Z$0 = z2;
                                                                    c00922.label = 8;
                                                                    if (str12 != null) {
                                                                        obj3 = objSafeWritePreprocessedPlayer2;
                                                                    }
                                                                    if (obj3 != obj4) {
                                                                        str14 = str;
                                                                        obj2 = objLoadPreprocessedPlayer;
                                                                        objLoadPreprocessedPlayer = obj2;
                                                                        str = str14;
                                                                    }
                                                                }
                                                                return (SolveResult) objLoadPreprocessedPlayer;
                                                            }
                                                        }
                                                    }
                                                    return solveResult3;
                                                }
                                            }
                                        }
                                    } else {
                                        solveResult3 = solveResult2;
                                        list3 = list;
                                        c00922.L$0 = str;
                                        c00922.L$1 = null;
                                        c00922.L$2 = list3;
                                        c00922.L$3 = str5;
                                        c00922.L$5 = solveResult3;
                                        c00922.Z$0 = z2;
                                        c00922.label = 6;
                                        objInvoke = function5.invoke(c00922);
                                        if (objInvoke == obj4) {
                                            List list19 = list3;
                                            obj = objInvoke;
                                            list4 = list19;
                                            str11 = (String) obj;
                                            if (str11 != null) {
                                                if (StringsKt.isBlank(str11)) {
                                                    str11 = null;
                                                } else {
                                                    str11 = null;
                                                }
                                                if (str11 != null) {
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = null;
                                                    c00922.L$2 = null;
                                                    c00922.L$3 = str5;
                                                    c00922.L$5 = null;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 7;
                                                    objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                    if (objSolveOnce2 != obj4) {
                                                        String str1117 = str5;
                                                        objLoadPreprocessedPlayer = objSolveOnce2;
                                                        str12 = str1117;
                                                        str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                        if (str13 != null) {
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = null;
                                                            c00922.L$2 = null;
                                                            c00922.L$3 = null;
                                                            c00922.L$5 = null;
                                                            c00922.L$7 = objLoadPreprocessedPlayer;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 8;
                                                            if (str12 != null) {
                                                                obj3 = objSafeWritePreprocessedPlayer2;
                                                            }
                                                            if (obj3 != obj4) {
                                                                str14 = str;
                                                                obj2 = objLoadPreprocessedPlayer;
                                                                objLoadPreprocessedPlayer = obj2;
                                                                str = str14;
                                                            }
                                                        }
                                                        return (SolveResult) objLoadPreprocessedPlayer;
                                                    }
                                                }
                                            }
                                            return solveResult3;
                                        }
                                    }
                                }
                            } else {
                                str5 = strPreprocessedPlayerCacheKey;
                                str6 = null;
                                function5 = function3;
                                solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                                if (str6 != null) {
                                    c00922.L$0 = str;
                                    c00922.L$1 = function5;
                                    c00922.L$2 = list;
                                    c00922.L$3 = str5;
                                    c00922.L$5 = null;
                                    c00922.Z$0 = z2;
                                    c00922.label = 4;
                                    objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                    if (objSolveOnce != obj4) {
                                        boolean z11 = z2;
                                        str8 = str;
                                        z4 = z11;
                                        String str1118 = str5;
                                        objLoadPreprocessedPlayer = objSolveOnce;
                                        str7 = str1118;
                                        function6 = function5;
                                        solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                        String str1119 = str8;
                                        z2 = z4;
                                        str = str1119;
                                        List list110 = list;
                                        str9 = str7;
                                        solveResult3 = solveResult4;
                                        function7 = function6;
                                        list3 = list110;
                                        if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                            return solveResult3;
                                        }
                                        c00922.L$0 = str;
                                        c00922.L$1 = function7;
                                        c00922.L$2 = list3;
                                        c00922.L$3 = str9;
                                        c00922.L$5 = solveResult3;
                                        c00922.Z$0 = z2;
                                        c00922.label = 5;
                                        this.preprocessedByPlayerUrl.remove(str);
                                        linkedHashSet.remove(str);
                                        if (str9 != null) {
                                            objSafeWritePreprocessedPlayer = obj3;
                                        } else {
                                            objSafeWritePreprocessedPlayer = obj3;
                                        }
                                        if (objSafeWritePreprocessedPlayer != obj4) {
                                            str10 = str;
                                            z5 = z2;
                                            function8 = function7;
                                            str5 = str9;
                                            function5 = function8;
                                            z2 = z5;
                                            str = str10;
                                            c00922.L$0 = str;
                                            c00922.L$1 = null;
                                            c00922.L$2 = list3;
                                            c00922.L$3 = str5;
                                            c00922.L$5 = solveResult3;
                                            c00922.Z$0 = z2;
                                            c00922.label = 6;
                                            objInvoke = function5.invoke(c00922);
                                            if (objInvoke == obj4) {
                                                List list111 = list3;
                                                obj = objInvoke;
                                                list4 = list111;
                                                str11 = (String) obj;
                                                if (str11 != null) {
                                                    if (StringsKt.isBlank(str11)) {
                                                        str11 = null;
                                                    } else {
                                                        str11 = null;
                                                    }
                                                    if (str11 != null) {
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = null;
                                                        c00922.L$2 = null;
                                                        c00922.L$3 = str5;
                                                        c00922.L$5 = null;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 7;
                                                        objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                        if (objSolveOnce2 != obj4) {
                                                            String str11110 = str5;
                                                            objLoadPreprocessedPlayer = objSolveOnce2;
                                                            str12 = str11110;
                                                            str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                            if (str13 != null) {
                                                                c00922.L$0 = str;
                                                                c00922.L$1 = null;
                                                                c00922.L$2 = null;
                                                                c00922.L$3 = null;
                                                                c00922.L$5 = null;
                                                                c00922.L$7 = objLoadPreprocessedPlayer;
                                                                c00922.Z$0 = z2;
                                                                c00922.label = 8;
                                                                if (str12 != null) {
                                                                    obj3 = objSafeWritePreprocessedPlayer2;
                                                                }
                                                                if (obj3 != obj4) {
                                                                    str14 = str;
                                                                    obj2 = objLoadPreprocessedPlayer;
                                                                    objLoadPreprocessedPlayer = obj2;
                                                                    str = str14;
                                                                }
                                                            }
                                                            return (SolveResult) objLoadPreprocessedPlayer;
                                                        }
                                                    }
                                                }
                                                return solveResult3;
                                            }
                                        }
                                    }
                                } else {
                                    solveResult3 = solveResult2;
                                    list3 = list;
                                    c00922.L$0 = str;
                                    c00922.L$1 = null;
                                    c00922.L$2 = list3;
                                    c00922.L$3 = str5;
                                    c00922.L$5 = solveResult3;
                                    c00922.Z$0 = z2;
                                    c00922.label = 6;
                                    objInvoke = function5.invoke(c00922);
                                    if (objInvoke == obj4) {
                                        List list112 = list3;
                                        obj = objInvoke;
                                        list4 = list112;
                                        str11 = (String) obj;
                                        if (str11 != null) {
                                            if (StringsKt.isBlank(str11)) {
                                                str11 = null;
                                            } else {
                                                str11 = null;
                                            }
                                            if (str11 != null) {
                                                c00922.L$0 = str;
                                                c00922.L$1 = null;
                                                c00922.L$2 = null;
                                                c00922.L$3 = str5;
                                                c00922.L$5 = null;
                                                c00922.Z$0 = z2;
                                                c00922.label = 7;
                                                objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                if (objSolveOnce2 != obj4) {
                                                    String str11111 = str5;
                                                    objLoadPreprocessedPlayer = objSolveOnce2;
                                                    str12 = str11111;
                                                    str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                    if (str13 != null) {
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = null;
                                                        c00922.L$2 = null;
                                                        c00922.L$3 = null;
                                                        c00922.L$5 = null;
                                                        c00922.L$7 = objLoadPreprocessedPlayer;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 8;
                                                        if (str12 != null) {
                                                            obj3 = objSafeWritePreprocessedPlayer2;
                                                        }
                                                        if (obj3 != obj4) {
                                                            str14 = str;
                                                            obj2 = objLoadPreprocessedPlayer;
                                                            objLoadPreprocessedPlayer = obj2;
                                                            str = str14;
                                                        }
                                                    }
                                                    return (SolveResult) objLoadPreprocessedPlayer;
                                                }
                                            }
                                        }
                                        return solveResult3;
                                    }
                                }
                            }
                            return obj4;
                        case 2:
                            z3 = c00922.Z$0;
                            list2 = c00922.L$2;
                            function4 = c00922.L$1;
                            str3 = c00922.L$0;
                            try {
                                ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                                solveResult = (SolveResult) objLoadPreprocessedPlayer;
                                z2 = z3;
                                str = str3;
                            } catch (CancellationException e4) {
                                cancellationException = e4;
                                throw cancellationException;
                            } catch (Exception unused3) {
                                z2 = z3;
                                str = str3;
                                solveResult = new SolveResult(emptyMap, emptyMap, null);
                            }
                            if (EjsChallengeSolverKt.solvesAll(solveResult, list2)) {
                                return solveResult;
                            }
                            linkedHashSet.remove(str);
                            function3 = function4;
                            list = list2;
                            str4 = this.bundleHash;
                            if (str4 != null) {
                                strPreprocessedPlayerCacheKey = EjsChallengeSolverKt.preprocessedPlayerCacheKey(str, str4);
                            } else {
                                strPreprocessedPlayerCacheKey = null;
                            }
                            if (z2) {
                                c00922.L$0 = str;
                                c00922.L$1 = function3;
                                c00922.L$2 = list;
                                c00922.L$3 = strPreprocessedPlayerCacheKey;
                                c00922.Z$0 = z2;
                                c00922.label = 3;
                                objLoadPreprocessedPlayer = loadPreprocessedPlayer(str, strPreprocessedPlayerCacheKey, c00922);
                                if (objLoadPreprocessedPlayer == obj4) {
                                    String str11112 = (String) objLoadPreprocessedPlayer;
                                    str5 = strPreprocessedPlayerCacheKey;
                                    str6 = str11112;
                                    function5 = function3;
                                    solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                                    if (str6 != null) {
                                        c00922.L$0 = str;
                                        c00922.L$1 = function5;
                                        c00922.L$2 = list;
                                        c00922.L$3 = str5;
                                        c00922.L$5 = null;
                                        c00922.Z$0 = z2;
                                        c00922.label = 4;
                                        objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                        if (objSolveOnce != obj4) {
                                            boolean z12 = z2;
                                            str8 = str;
                                            z4 = z12;
                                            String str11113 = str5;
                                            objLoadPreprocessedPlayer = objSolveOnce;
                                            str7 = str11113;
                                            function6 = function5;
                                            solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                            String str11114 = str8;
                                            z2 = z4;
                                            str = str11114;
                                            List list113 = list;
                                            str9 = str7;
                                            solveResult3 = solveResult4;
                                            function7 = function6;
                                            list3 = list113;
                                            if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                                return solveResult3;
                                            }
                                            c00922.L$0 = str;
                                            c00922.L$1 = function7;
                                            c00922.L$2 = list3;
                                            c00922.L$3 = str9;
                                            c00922.L$5 = solveResult3;
                                            c00922.Z$0 = z2;
                                            c00922.label = 5;
                                            this.preprocessedByPlayerUrl.remove(str);
                                            linkedHashSet.remove(str);
                                            if (str9 != null) {
                                                objSafeWritePreprocessedPlayer = obj3;
                                            } else {
                                                objSafeWritePreprocessedPlayer = obj3;
                                            }
                                            if (objSafeWritePreprocessedPlayer != obj4) {
                                                str10 = str;
                                                z5 = z2;
                                                function8 = function7;
                                                str5 = str9;
                                                function5 = function8;
                                                z2 = z5;
                                                str = str10;
                                                c00922.L$0 = str;
                                                c00922.L$1 = null;
                                                c00922.L$2 = list3;
                                                c00922.L$3 = str5;
                                                c00922.L$5 = solveResult3;
                                                c00922.Z$0 = z2;
                                                c00922.label = 6;
                                                objInvoke = function5.invoke(c00922);
                                                if (objInvoke == obj4) {
                                                    List list114 = list3;
                                                    obj = objInvoke;
                                                    list4 = list114;
                                                    str11 = (String) obj;
                                                    if (str11 != null) {
                                                        if (StringsKt.isBlank(str11)) {
                                                            str11 = null;
                                                        } else {
                                                            str11 = null;
                                                        }
                                                        if (str11 != null) {
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = null;
                                                            c00922.L$2 = null;
                                                            c00922.L$3 = str5;
                                                            c00922.L$5 = null;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 7;
                                                            objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                            if (objSolveOnce2 != obj4) {
                                                                String str11115 = str5;
                                                                objLoadPreprocessedPlayer = objSolveOnce2;
                                                                str12 = str11115;
                                                                str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                                if (str13 != null) {
                                                                    c00922.L$0 = str;
                                                                    c00922.L$1 = null;
                                                                    c00922.L$2 = null;
                                                                    c00922.L$3 = null;
                                                                    c00922.L$5 = null;
                                                                    c00922.L$7 = objLoadPreprocessedPlayer;
                                                                    c00922.Z$0 = z2;
                                                                    c00922.label = 8;
                                                                    if (str12 != null) {
                                                                        obj3 = objSafeWritePreprocessedPlayer2;
                                                                    }
                                                                    if (obj3 != obj4) {
                                                                        str14 = str;
                                                                        obj2 = objLoadPreprocessedPlayer;
                                                                        objLoadPreprocessedPlayer = obj2;
                                                                        str = str14;
                                                                    }
                                                                }
                                                                return (SolveResult) objLoadPreprocessedPlayer;
                                                            }
                                                        }
                                                    }
                                                    return solveResult3;
                                                }
                                            }
                                        }
                                    } else {
                                        solveResult3 = solveResult2;
                                        list3 = list;
                                        c00922.L$0 = str;
                                        c00922.L$1 = null;
                                        c00922.L$2 = list3;
                                        c00922.L$3 = str5;
                                        c00922.L$5 = solveResult3;
                                        c00922.Z$0 = z2;
                                        c00922.label = 6;
                                        objInvoke = function5.invoke(c00922);
                                        if (objInvoke == obj4) {
                                            List list115 = list3;
                                            obj = objInvoke;
                                            list4 = list115;
                                            str11 = (String) obj;
                                            if (str11 != null) {
                                                if (StringsKt.isBlank(str11)) {
                                                    str11 = null;
                                                } else {
                                                    str11 = null;
                                                }
                                                if (str11 != null) {
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = null;
                                                    c00922.L$2 = null;
                                                    c00922.L$3 = str5;
                                                    c00922.L$5 = null;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 7;
                                                    objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                    if (objSolveOnce2 != obj4) {
                                                        String str11116 = str5;
                                                        objLoadPreprocessedPlayer = objSolveOnce2;
                                                        str12 = str11116;
                                                        str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                        if (str13 != null) {
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = null;
                                                            c00922.L$2 = null;
                                                            c00922.L$3 = null;
                                                            c00922.L$5 = null;
                                                            c00922.L$7 = objLoadPreprocessedPlayer;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 8;
                                                            if (str12 != null) {
                                                                obj3 = objSafeWritePreprocessedPlayer2;
                                                            }
                                                            if (obj3 != obj4) {
                                                                str14 = str;
                                                                obj2 = objLoadPreprocessedPlayer;
                                                                objLoadPreprocessedPlayer = obj2;
                                                                str = str14;
                                                            }
                                                        }
                                                        return (SolveResult) objLoadPreprocessedPlayer;
                                                    }
                                                }
                                            }
                                            return solveResult3;
                                        }
                                    }
                                }
                            } else {
                                str5 = strPreprocessedPlayerCacheKey;
                                str6 = null;
                                function5 = function3;
                                solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                                if (str6 != null) {
                                    c00922.L$0 = str;
                                    c00922.L$1 = function5;
                                    c00922.L$2 = list;
                                    c00922.L$3 = str5;
                                    c00922.L$5 = null;
                                    c00922.Z$0 = z2;
                                    c00922.label = 4;
                                    objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                    if (objSolveOnce != obj4) {
                                        boolean z13 = z2;
                                        str8 = str;
                                        z4 = z13;
                                        String str11117 = str5;
                                        objLoadPreprocessedPlayer = objSolveOnce;
                                        str7 = str11117;
                                        function6 = function5;
                                        solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                        String str11118 = str8;
                                        z2 = z4;
                                        str = str11118;
                                        List list116 = list;
                                        str9 = str7;
                                        solveResult3 = solveResult4;
                                        function7 = function6;
                                        list3 = list116;
                                        if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                            return solveResult3;
                                        }
                                        c00922.L$0 = str;
                                        c00922.L$1 = function7;
                                        c00922.L$2 = list3;
                                        c00922.L$3 = str9;
                                        c00922.L$5 = solveResult3;
                                        c00922.Z$0 = z2;
                                        c00922.label = 5;
                                        this.preprocessedByPlayerUrl.remove(str);
                                        linkedHashSet.remove(str);
                                        if (str9 != null) {
                                            objSafeWritePreprocessedPlayer = obj3;
                                        } else {
                                            objSafeWritePreprocessedPlayer = obj3;
                                        }
                                        if (objSafeWritePreprocessedPlayer != obj4) {
                                            str10 = str;
                                            z5 = z2;
                                            function8 = function7;
                                            str5 = str9;
                                            function5 = function8;
                                            z2 = z5;
                                            str = str10;
                                            c00922.L$0 = str;
                                            c00922.L$1 = null;
                                            c00922.L$2 = list3;
                                            c00922.L$3 = str5;
                                            c00922.L$5 = solveResult3;
                                            c00922.Z$0 = z2;
                                            c00922.label = 6;
                                            objInvoke = function5.invoke(c00922);
                                            if (objInvoke == obj4) {
                                                List list117 = list3;
                                                obj = objInvoke;
                                                list4 = list117;
                                                str11 = (String) obj;
                                                if (str11 != null) {
                                                    if (StringsKt.isBlank(str11)) {
                                                        str11 = null;
                                                    } else {
                                                        str11 = null;
                                                    }
                                                    if (str11 != null) {
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = null;
                                                        c00922.L$2 = null;
                                                        c00922.L$3 = str5;
                                                        c00922.L$5 = null;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 7;
                                                        objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                        if (objSolveOnce2 != obj4) {
                                                            String str11119 = str5;
                                                            objLoadPreprocessedPlayer = objSolveOnce2;
                                                            str12 = str11119;
                                                            str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                            if (str13 != null) {
                                                                c00922.L$0 = str;
                                                                c00922.L$1 = null;
                                                                c00922.L$2 = null;
                                                                c00922.L$3 = null;
                                                                c00922.L$5 = null;
                                                                c00922.L$7 = objLoadPreprocessedPlayer;
                                                                c00922.Z$0 = z2;
                                                                c00922.label = 8;
                                                                if (str12 != null) {
                                                                    obj3 = objSafeWritePreprocessedPlayer2;
                                                                }
                                                                if (obj3 != obj4) {
                                                                    str14 = str;
                                                                    obj2 = objLoadPreprocessedPlayer;
                                                                    objLoadPreprocessedPlayer = obj2;
                                                                    str = str14;
                                                                }
                                                            }
                                                            return (SolveResult) objLoadPreprocessedPlayer;
                                                        }
                                                    }
                                                }
                                                return solveResult3;
                                            }
                                        }
                                    }
                                } else {
                                    solveResult3 = solveResult2;
                                    list3 = list;
                                    c00922.L$0 = str;
                                    c00922.L$1 = null;
                                    c00922.L$2 = list3;
                                    c00922.L$3 = str5;
                                    c00922.L$5 = solveResult3;
                                    c00922.Z$0 = z2;
                                    c00922.label = 6;
                                    objInvoke = function5.invoke(c00922);
                                    if (objInvoke == obj4) {
                                        List list118 = list3;
                                        obj = objInvoke;
                                        list4 = list118;
                                        str11 = (String) obj;
                                        if (str11 != null) {
                                            if (StringsKt.isBlank(str11)) {
                                                str11 = null;
                                            } else {
                                                str11 = null;
                                            }
                                            if (str11 != null) {
                                                c00922.L$0 = str;
                                                c00922.L$1 = null;
                                                c00922.L$2 = null;
                                                c00922.L$3 = str5;
                                                c00922.L$5 = null;
                                                c00922.Z$0 = z2;
                                                c00922.label = 7;
                                                objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                if (objSolveOnce2 != obj4) {
                                                    String str111110 = str5;
                                                    objLoadPreprocessedPlayer = objSolveOnce2;
                                                    str12 = str111110;
                                                    str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                    if (str13 != null) {
                                                        c00922.L$0 = str;
                                                        c00922.L$1 = null;
                                                        c00922.L$2 = null;
                                                        c00922.L$3 = null;
                                                        c00922.L$5 = null;
                                                        c00922.L$7 = objLoadPreprocessedPlayer;
                                                        c00922.Z$0 = z2;
                                                        c00922.label = 8;
                                                        if (str12 != null) {
                                                            obj3 = objSafeWritePreprocessedPlayer2;
                                                        }
                                                        if (obj3 != obj4) {
                                                            str14 = str;
                                                            obj2 = objLoadPreprocessedPlayer;
                                                            objLoadPreprocessedPlayer = obj2;
                                                            str = str14;
                                                        }
                                                    }
                                                    return (SolveResult) objLoadPreprocessedPlayer;
                                                }
                                            }
                                        }
                                        return solveResult3;
                                    }
                                }
                            }
                            return obj4;
                        case 3:
                            boolean z14 = c00922.Z$0;
                            strPreprocessedPlayerCacheKey = c00922.L$3;
                            list = c00922.L$2;
                            function3 = c00922.L$1;
                            String str20 = c00922.L$0;
                            ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                            z2 = z14;
                            str = str20;
                            String str111111 = (String) objLoadPreprocessedPlayer;
                            str5 = strPreprocessedPlayerCacheKey;
                            str6 = str111111;
                            function5 = function3;
                            solveResult2 = new SolveResult(emptyMap, emptyMap, null);
                            if (str6 != null) {
                                c00922.L$0 = str;
                                c00922.L$1 = function5;
                                c00922.L$2 = list;
                                c00922.L$3 = str5;
                                c00922.L$5 = null;
                                c00922.Z$0 = z2;
                                c00922.label = 4;
                                objSolveOnce = solveOnce(str, str6, list, true, c00922);
                                if (objSolveOnce != obj4) {
                                    boolean z15 = z2;
                                    str8 = str;
                                    z4 = z15;
                                    String str111112 = str5;
                                    objLoadPreprocessedPlayer = objSolveOnce;
                                    str7 = str111112;
                                    function6 = function5;
                                    solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                    String str111113 = str8;
                                    z2 = z4;
                                    str = str111113;
                                    List list119 = list;
                                    str9 = str7;
                                    solveResult3 = solveResult4;
                                    function7 = function6;
                                    list3 = list119;
                                    if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                        return solveResult3;
                                    }
                                    c00922.L$0 = str;
                                    c00922.L$1 = function7;
                                    c00922.L$2 = list3;
                                    c00922.L$3 = str9;
                                    c00922.L$5 = solveResult3;
                                    c00922.Z$0 = z2;
                                    c00922.label = 5;
                                    this.preprocessedByPlayerUrl.remove(str);
                                    linkedHashSet.remove(str);
                                    if (str9 != null) {
                                        objSafeWritePreprocessedPlayer = obj3;
                                    } else {
                                        objSafeWritePreprocessedPlayer = obj3;
                                    }
                                    if (objSafeWritePreprocessedPlayer != obj4) {
                                        str10 = str;
                                        z5 = z2;
                                        function8 = function7;
                                        str5 = str9;
                                        function5 = function8;
                                        z2 = z5;
                                        str = str10;
                                        c00922.L$0 = str;
                                        c00922.L$1 = null;
                                        c00922.L$2 = list3;
                                        c00922.L$3 = str5;
                                        c00922.L$5 = solveResult3;
                                        c00922.Z$0 = z2;
                                        c00922.label = 6;
                                        objInvoke = function5.invoke(c00922);
                                        if (objInvoke == obj4) {
                                            List list1110 = list3;
                                            obj = objInvoke;
                                            list4 = list1110;
                                            str11 = (String) obj;
                                            if (str11 != null) {
                                                if (StringsKt.isBlank(str11)) {
                                                    str11 = null;
                                                } else {
                                                    str11 = null;
                                                }
                                                if (str11 != null) {
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = null;
                                                    c00922.L$2 = null;
                                                    c00922.L$3 = str5;
                                                    c00922.L$5 = null;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 7;
                                                    objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                                    if (objSolveOnce2 != obj4) {
                                                        String str111114 = str5;
                                                        objLoadPreprocessedPlayer = objSolveOnce2;
                                                        str12 = str111114;
                                                        str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                        if (str13 != null) {
                                                            c00922.L$0 = str;
                                                            c00922.L$1 = null;
                                                            c00922.L$2 = null;
                                                            c00922.L$3 = null;
                                                            c00922.L$5 = null;
                                                            c00922.L$7 = objLoadPreprocessedPlayer;
                                                            c00922.Z$0 = z2;
                                                            c00922.label = 8;
                                                            if (str12 != null) {
                                                                obj3 = objSafeWritePreprocessedPlayer2;
                                                            }
                                                            if (obj3 != obj4) {
                                                                str14 = str;
                                                                obj2 = objLoadPreprocessedPlayer;
                                                                objLoadPreprocessedPlayer = obj2;
                                                                str = str14;
                                                            }
                                                        }
                                                        return (SolveResult) objLoadPreprocessedPlayer;
                                                    }
                                                }
                                            }
                                            return solveResult3;
                                        }
                                    }
                                }
                            } else {
                                solveResult3 = solveResult2;
                                list3 = list;
                                c00922.L$0 = str;
                                c00922.L$1 = null;
                                c00922.L$2 = list3;
                                c00922.L$3 = str5;
                                c00922.L$5 = solveResult3;
                                c00922.Z$0 = z2;
                                c00922.label = 6;
                                objInvoke = function5.invoke(c00922);
                                if (objInvoke == obj4) {
                                    List list1111 = list3;
                                    obj = objInvoke;
                                    list4 = list1111;
                                    str11 = (String) obj;
                                    if (str11 != null) {
                                        if (StringsKt.isBlank(str11)) {
                                            str11 = null;
                                        } else {
                                            str11 = null;
                                        }
                                        if (str11 != null) {
                                            c00922.L$0 = str;
                                            c00922.L$1 = null;
                                            c00922.L$2 = null;
                                            c00922.L$3 = str5;
                                            c00922.L$5 = null;
                                            c00922.Z$0 = z2;
                                            c00922.label = 7;
                                            objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                            if (objSolveOnce2 != obj4) {
                                                String str111115 = str5;
                                                objLoadPreprocessedPlayer = objSolveOnce2;
                                                str12 = str111115;
                                                str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                if (str13 != null) {
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = null;
                                                    c00922.L$2 = null;
                                                    c00922.L$3 = null;
                                                    c00922.L$5 = null;
                                                    c00922.L$7 = objLoadPreprocessedPlayer;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 8;
                                                    if (str12 != null) {
                                                        obj3 = objSafeWritePreprocessedPlayer2;
                                                    }
                                                    if (obj3 != obj4) {
                                                        str14 = str;
                                                        obj2 = objLoadPreprocessedPlayer;
                                                        objLoadPreprocessedPlayer = obj2;
                                                        str = str14;
                                                    }
                                                }
                                                return (SolveResult) objLoadPreprocessedPlayer;
                                            }
                                        }
                                    }
                                    return solveResult3;
                                }
                            }
                            return obj4;
                        case 4:
                            z4 = c00922.Z$0;
                            str7 = c00922.L$3;
                            list = c00922.L$2;
                            function6 = c00922.L$1;
                            str8 = c00922.L$0;
                            try {
                                ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                                solveResult4 = (SolveResult) objLoadPreprocessedPlayer;
                                String str111116 = str8;
                                z2 = z4;
                                str = str111116;
                            } catch (CancellationException e5) {
                                throw e5;
                            } catch (Exception unused4) {
                                String str21 = str8;
                                z2 = z4;
                                str = str21;
                                solveResult4 = new SolveResult(emptyMap, emptyMap, null);
                            }
                            List list1112 = list;
                            str9 = str7;
                            solveResult3 = solveResult4;
                            function7 = function6;
                            list3 = list1112;
                            if (EjsChallengeSolverKt.solvesAll(solveResult3, list3)) {
                                return solveResult3;
                            }
                            c00922.L$0 = str;
                            c00922.L$1 = function7;
                            c00922.L$2 = list3;
                            c00922.L$3 = str9;
                            c00922.L$5 = solveResult3;
                            c00922.Z$0 = z2;
                            c00922.label = 5;
                            this.preprocessedByPlayerUrl.remove(str);
                            linkedHashSet.remove(str);
                            if (str9 != null) {
                                objSafeWritePreprocessedPlayer = obj3;
                            } else {
                                objSafeWritePreprocessedPlayer = obj3;
                            }
                            if (objSafeWritePreprocessedPlayer != obj4) {
                                str10 = str;
                                z5 = z2;
                                function8 = function7;
                                str5 = str9;
                                function5 = function8;
                                z2 = z5;
                                str = str10;
                                c00922.L$0 = str;
                                c00922.L$1 = null;
                                c00922.L$2 = list3;
                                c00922.L$3 = str5;
                                c00922.L$5 = solveResult3;
                                c00922.Z$0 = z2;
                                c00922.label = 6;
                                objInvoke = function5.invoke(c00922);
                                if (objInvoke == obj4) {
                                    List list1113 = list3;
                                    obj = objInvoke;
                                    list4 = list1113;
                                    str11 = (String) obj;
                                    if (str11 != null) {
                                        if (StringsKt.isBlank(str11)) {
                                            str11 = null;
                                        } else {
                                            str11 = null;
                                        }
                                        if (str11 != null) {
                                            c00922.L$0 = str;
                                            c00922.L$1 = null;
                                            c00922.L$2 = null;
                                            c00922.L$3 = str5;
                                            c00922.L$5 = null;
                                            c00922.Z$0 = z2;
                                            c00922.label = 7;
                                            objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                            if (objSolveOnce2 != obj4) {
                                                String str111117 = str5;
                                                objLoadPreprocessedPlayer = objSolveOnce2;
                                                str12 = str111117;
                                                str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                if (str13 != null) {
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = null;
                                                    c00922.L$2 = null;
                                                    c00922.L$3 = null;
                                                    c00922.L$5 = null;
                                                    c00922.L$7 = objLoadPreprocessedPlayer;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 8;
                                                    if (str12 != null) {
                                                        obj3 = objSafeWritePreprocessedPlayer2;
                                                    }
                                                    if (obj3 != obj4) {
                                                        str14 = str;
                                                        obj2 = objLoadPreprocessedPlayer;
                                                        objLoadPreprocessedPlayer = obj2;
                                                        str = str14;
                                                    }
                                                }
                                                return (SolveResult) objLoadPreprocessedPlayer;
                                            }
                                        }
                                    }
                                    return solveResult3;
                                }
                            }
                            return obj4;
                        case 5:
                            z5 = c00922.Z$0;
                            solveResult3 = c00922.L$5;
                            str9 = c00922.L$3;
                            list3 = c00922.L$2;
                            function8 = c00922.L$1;
                            str10 = c00922.L$0;
                            try {
                                ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                                str5 = str9;
                                function5 = function8;
                                z2 = z5;
                                str = str10;
                                c00922.L$0 = str;
                                c00922.L$1 = null;
                                c00922.L$2 = list3;
                                c00922.L$3 = str5;
                                c00922.L$5 = solveResult3;
                                c00922.Z$0 = z2;
                                c00922.label = 6;
                                objInvoke = function5.invoke(c00922);
                                if (objInvoke == obj4) {
                                    List list1114 = list3;
                                    obj = objInvoke;
                                    list4 = list1114;
                                    str11 = (String) obj;
                                    if (str11 != null) {
                                        if (StringsKt.isBlank(str11)) {
                                            str11 = null;
                                        } else {
                                            str11 = null;
                                        }
                                        if (str11 != null) {
                                            c00922.L$0 = str;
                                            c00922.L$1 = null;
                                            c00922.L$2 = null;
                                            c00922.L$3 = str5;
                                            c00922.L$5 = null;
                                            c00922.Z$0 = z2;
                                            c00922.label = 7;
                                            objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                            if (objSolveOnce2 != obj4) {
                                                String str111118 = str5;
                                                objLoadPreprocessedPlayer = objSolveOnce2;
                                                str12 = str111118;
                                                str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                                if (str13 != null) {
                                                    c00922.L$0 = str;
                                                    c00922.L$1 = null;
                                                    c00922.L$2 = null;
                                                    c00922.L$3 = null;
                                                    c00922.L$5 = null;
                                                    c00922.L$7 = objLoadPreprocessedPlayer;
                                                    c00922.Z$0 = z2;
                                                    c00922.label = 8;
                                                    if (str12 != null) {
                                                        obj3 = objSafeWritePreprocessedPlayer2;
                                                    }
                                                    if (obj3 != obj4) {
                                                        str14 = str;
                                                        obj2 = objLoadPreprocessedPlayer;
                                                        objLoadPreprocessedPlayer = obj2;
                                                        str = str14;
                                                    }
                                                }
                                                return (SolveResult) objLoadPreprocessedPlayer;
                                            }
                                        }
                                    }
                                    return solveResult3;
                                }
                                return obj4;
                            } catch (Exception e6) {
                                exc = e6;
                                str2 = str10;
                                strExtractPlayerHash = RemotePlayerConfigParser.extractPlayerHash(str2);
                                if (strExtractPlayerHash == null) {
                                    strExtractPlayerHash = "unknown";
                                }
                                strM = Format$$ExternalSyntheticOutline0.m(exc);
                                if (strM == null) {
                                    strM = "Exception";
                                }
                                EntryPoints.w$default(this.logger, "EjsChallengeSolver", "EJS solve failed player=" + strExtractPlayerHash + " type=" + strM, null, 12);
                                return new SolveResult(emptyMap, emptyMap, null);
                            }
                        case 6:
                            boolean z16 = c00922.Z$0;
                            solveResult3 = c00922.L$5;
                            String str22 = c00922.L$3;
                            List list20 = c00922.L$2;
                            String str23 = c00922.L$0;
                            ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                            z2 = z16;
                            str = str23;
                            str5 = str22;
                            list4 = list20;
                            obj = objLoadPreprocessedPlayer;
                            str11 = (String) obj;
                            if (str11 != null) {
                                if (StringsKt.isBlank(str11)) {
                                    str11 = null;
                                } else {
                                    str11 = null;
                                }
                                if (str11 != null) {
                                    c00922.L$0 = str;
                                    c00922.L$1 = null;
                                    c00922.L$2 = null;
                                    c00922.L$3 = str5;
                                    c00922.L$5 = null;
                                    c00922.Z$0 = z2;
                                    c00922.label = 7;
                                    objSolveOnce2 = solveOnce(str, str11, list4, false, c00922);
                                    if (objSolveOnce2 != obj4) {
                                        String str111119 = str5;
                                        objLoadPreprocessedPlayer = objSolveOnce2;
                                        str12 = str111119;
                                        str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                        if (str13 != null) {
                                            c00922.L$0 = str;
                                            c00922.L$1 = null;
                                            c00922.L$2 = null;
                                            c00922.L$3 = null;
                                            c00922.L$5 = null;
                                            c00922.L$7 = objLoadPreprocessedPlayer;
                                            c00922.Z$0 = z2;
                                            c00922.label = 8;
                                            if (str12 != null) {
                                                obj3 = objSafeWritePreprocessedPlayer2;
                                            }
                                            if (obj3 != obj4) {
                                                str14 = str;
                                                obj2 = objLoadPreprocessedPlayer;
                                                objLoadPreprocessedPlayer = obj2;
                                                str = str14;
                                            }
                                        }
                                        return (SolveResult) objLoadPreprocessedPlayer;
                                    }
                                    return obj4;
                                }
                            }
                            return solveResult3;
                        case 7:
                            boolean z17 = c00922.Z$0;
                            str12 = c00922.L$3;
                            String str24 = c00922.L$0;
                            try {
                                ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                                z2 = z17;
                                str = str24;
                                str13 = ((SolveResult) objLoadPreprocessedPlayer).preprocessedPlayer;
                                if (str13 != null) {
                                    c00922.L$0 = str;
                                    c00922.L$1 = null;
                                    c00922.L$2 = null;
                                    c00922.L$3 = null;
                                    c00922.L$5 = null;
                                    c00922.L$7 = objLoadPreprocessedPlayer;
                                    c00922.Z$0 = z2;
                                    c00922.label = 8;
                                    if (str12 != null) {
                                        obj3 = objSafeWritePreprocessedPlayer2;
                                    }
                                    if (obj3 != obj4) {
                                        str14 = str;
                                        obj2 = objLoadPreprocessedPlayer;
                                        objLoadPreprocessedPlayer = obj2;
                                        str = str14;
                                    }
                                    return obj4;
                                }
                                return (SolveResult) objLoadPreprocessedPlayer;
                            } catch (Exception e7) {
                                exc = e7;
                                str2 = str24;
                                strExtractPlayerHash = RemotePlayerConfigParser.extractPlayerHash(str2);
                                if (strExtractPlayerHash == null) {
                                    strExtractPlayerHash = "unknown";
                                }
                                strM = Format$$ExternalSyntheticOutline0.m(exc);
                                if (strM == null) {
                                    strM = "Exception";
                                }
                                EntryPoints.w$default(this.logger, "EjsChallengeSolver", "EJS solve failed player=" + strExtractPlayerHash + " type=" + strM, null, 12);
                                return new SolveResult(emptyMap, emptyMap, null);
                            }
                        case 8:
                            obj2 = c00922.L$7;
                            str14 = c00922.L$0;
                            try {
                                ResultKt.throwOnFailure(objLoadPreprocessedPlayer);
                                objLoadPreprocessedPlayer = obj2;
                                str = str14;
                                return (SolveResult) objLoadPreprocessedPlayer;
                            } catch (Exception e8) {
                                exc = e8;
                                str2 = str14;
                                strExtractPlayerHash = RemotePlayerConfigParser.extractPlayerHash(str2);
                                if (strExtractPlayerHash == null) {
                                    strExtractPlayerHash = "unknown";
                                }
                                strM = Format$$ExternalSyntheticOutline0.m(exc);
                                if (strM == null) {
                                    strM = "Exception";
                                }
                                EntryPoints.w$default(this.logger, "EjsChallengeSolver", "EJS solve failed player=" + strExtractPlayerHash + " type=" + strM, null, 12);
                                return new SolveResult(emptyMap, emptyMap, null);
                            }
                        default:
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                    }
                } catch (Exception e9) {
                    str2 = str;
                    exc = e9;
                }
            } catch (CancellationException e10) {
                throw e10;
            }
        } catch (Exception e11) {
            exc = e11;
            str2 = i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r10v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v7, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    public final Object withActivity(Function1 function1, ContinuationImpl continuationImpl) throws Throwable {
        C00931 c00931;
        ?? r11;
        MutexImpl mutexImpl;
        ?? r10;
        Throwable th;
        ?? r12;
        if (continuationImpl instanceof C00931) {
            c00931 = (C00931) continuationImpl;
            int i = c00931.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00931.label = i - Integer.MIN_VALUE;
            } else {
                c00931 = new C00931(continuationImpl);
            }
        } else {
            c00931 = new C00931(continuationImpl);
        }
        Object obj = c00931.result;
        int i2 = c00931.label;
        ContextScope contextScope = this.idleScope;
        byte b = 1;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        c00931.L$0 = (SuspendLambda) function1;
                        mutexImpl = this.operationMutex;
                        c00931.L$1 = mutexImpl;
                        c00931.label = 1;
                        if (mutexImpl.lock(c00931) != coroutineSingletons) {
                        }
                        r10 = function1;
                        r11 = mutexImpl;
                        return coroutineSingletons;
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        Mutex mutex = c00931.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            r12 = mutex;
                            this.idleJob = AwaitKt.launch$default(contextScope, null, null, new EjsChallengeSolver$dispose$2(this, continuation, b), 3);
                            r12.unlock(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            this.idleJob = AwaitKt.launch$default(contextScope, null, null, new EjsChallengeSolver$dispose$2(this, continuation, b), 3);
                            throw th;
                        }
                    }
                    Mutex mutex2 = c00931.L$1;
                    Function1 function2 = (Function1) c00931.L$0;
                    ResultKt.throwOnFailure(obj);
                    r11 = mutex2;
                    r10 = function2;
                    c00931.L$0 = null;
                    c00931.L$1 = r11;
                    c00931.label = 2;
                    Object objInvoke = r10.invoke(c00931);
                    if (objInvoke != coroutineSingletons) {
                        ?? r8 = r11;
                        obj = objInvoke;
                        r12 = r8;
                        this.idleJob = AwaitKt.launch$default(contextScope, null, null, new EjsChallengeSolver$dispose$2(this, continuation, b), 3);
                        r12.unlock(null);
                        return obj;
                    }
                    r10 = function1;
                    r11 = mutexImpl;
                    return coroutineSingletons;
                } catch (Throwable th3) {
                    th = th3;
                    this.idleJob = AwaitKt.launch$default(contextScope, null, null, new EjsChallengeSolver$dispose$2(this, continuation, b), 3);
                    throw th;
                }
                r10 = function1;
                r11 = mutexImpl;
                StandaloneCoroutine standaloneCoroutine = this.idleJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
            } catch (Throwable th4) {
                th = th4;
                r11.unlock(null);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            r11 = function1;
        }
    }
}
