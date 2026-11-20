package com.metrolist.innertubex;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.datastore.core.FileWriteScope$writeData$2;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil3.RealImageLoader$execute$result$1;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.YouTubeLocale;
import com.metrolist.innertubex.models.response.ImageUploadResponse;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteReadChannel;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.FilteringSequence;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Duration;
import kotlin.time.InstantJvmKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube {
    public static final Set MEDIA_REQUEST_HEADERS;
    public static final Regex VISITOR_DATA_REGEX;
    public final HttpClient httpClient;
    public final PathKt$$ExternalSyntheticBUOutline0 logger;
    public final StateFlowImpl mutableSessionFlow;
    public final Function2 retryDelay;
    public final AtomicReference session;
    public final AtomicReference sessionBoundRequests;
    public final MutexImpl visitorDataFetchMutex;
    public VisitorDataFlight visitorDataFlight;
    public final ContextScope visitorDataScope;
    public static final Set TRANSIENT_STATUS_CODES = ArraysKt.toSet(new Integer[]{408, 425, 429, Integer.valueOf(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION), 502, 503, 504});
    public static final Set STATS_HOSTS = ArraysKt.toSet(new String[]{"s.youtube.com", "www.youtube.com", "music.youtube.com"});
    public static final Set STATS_PATHS = ArraysKt.toSet(new String[]{"/api/stats/playback", "/api/stats/watchtime"});

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public /* synthetic */ long J$0;
        public boolean label;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(2, continuation);
            anonymousClass1.J$0 = ((Duration) obj).rawValue;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Duration duration = (Duration) obj;
            long j = duration.rawValue;
            return ((AnonymousClass1) create(duration, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long j = this.J$0;
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                this.J$0 = j;
                this.label = true;
                Object objM1897delayVtjQ1oo = AwaitKt.m1897delayVtjQ1oo(j, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objM1897delayVtjQ1oo == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SessionBoundRequest {
        public final Job job;
        public final SessionSnapshot session;

        public SessionBoundRequest(SessionSnapshot sessionSnapshot, Job job) {
            sessionSnapshot.getClass();
            this.session = sessionSnapshot;
            this.job = job;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SessionBoundRequest)) {
                return false;
            }
            SessionBoundRequest sessionBoundRequest = (SessionBoundRequest) obj;
            return Intrinsics.areEqual(this.session, sessionBoundRequest.session) && this.job.equals(sessionBoundRequest.job);
        }

        public final int hashCode() {
            return this.job.hashCode() + (this.session.hashCode() * 31);
        }

        public final String toString() {
            return "SessionBoundRequest(session=" + this.session + ", job=" + this.job + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SessionSnapshot {
        public final String authUser;
        public final String cookie;
        public final String dataSyncId;
        public final long generation;
        public final YouTubeLocale locale;
        public final boolean regionOverrideActive;
        public final String sapisid;
        public final boolean useLoginForBrowse;
        public final String visitorData;

        public SessionSnapshot(YouTubeLocale youTubeLocale, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, long j) {
            this.locale = youTubeLocale;
            this.visitorData = str;
            this.dataSyncId = str2;
            this.authUser = str3;
            this.cookie = str4;
            this.sapisid = str5;
            this.useLoginForBrowse = z;
            this.regionOverrideActive = z2;
            this.generation = j;
        }

        public static SessionSnapshot copy$default(SessionSnapshot sessionSnapshot, YouTubeLocale youTubeLocale, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, long j, int i) {
            if ((i & 1) != 0) {
                youTubeLocale = sessionSnapshot.locale;
            }
            YouTubeLocale youTubeLocale2 = youTubeLocale;
            if ((i & 2) != 0) {
                str = sessionSnapshot.visitorData;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = sessionSnapshot.dataSyncId;
            }
            String str7 = str2;
            String str8 = (i & 8) != 0 ? sessionSnapshot.authUser : str3;
            String str9 = (i & 16) != 0 ? sessionSnapshot.cookie : str4;
            String str10 = (i & 32) != 0 ? sessionSnapshot.sapisid : str5;
            boolean z3 = (i & 64) != 0 ? sessionSnapshot.useLoginForBrowse : z;
            boolean z4 = (i & 128) != 0 ? sessionSnapshot.regionOverrideActive : z2;
            long j2 = (i & 256) != 0 ? sessionSnapshot.generation : j;
            sessionSnapshot.getClass();
            return new SessionSnapshot(youTubeLocale2, str6, str7, str8, str9, str10, z3, z4, j2);
        }

        public static String presence(String str) {
            return (str == null || StringsKt.isBlank(str)) ? "missing" : "present";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SessionSnapshot)) {
                return false;
            }
            SessionSnapshot sessionSnapshot = (SessionSnapshot) obj;
            return this.locale.equals(sessionSnapshot.locale) && Intrinsics.areEqual(this.visitorData, sessionSnapshot.visitorData) && Intrinsics.areEqual(this.dataSyncId, sessionSnapshot.dataSyncId) && this.authUser.equals(sessionSnapshot.authUser) && Intrinsics.areEqual(this.cookie, sessionSnapshot.cookie) && Intrinsics.areEqual(this.sapisid, sessionSnapshot.sapisid) && this.useLoginForBrowse == sessionSnapshot.useLoginForBrowse && this.regionOverrideActive == sessionSnapshot.regionOverrideActive && this.generation == sessionSnapshot.generation;
        }

        public final int hashCode() {
            int iHashCode = this.locale.hashCode() * 31;
            String str = this.visitorData;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.dataSyncId;
            int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.authUser);
            String str3 = this.cookie;
            int iHashCode3 = (iM + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.sapisid;
            return Long.hashCode(this.generation) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31, this.useLoginForBrowse, 31), this.regionOverrideActive, 31);
        }

        public final String toString() {
            String strPresence = presence(this.visitorData);
            String strPresence2 = presence(this.dataSyncId);
            String strPresence3 = presence(this.authUser);
            String strPresence4 = presence(this.cookie);
            String strPresence5 = presence(this.sapisid);
            StringBuilder sb = new StringBuilder("SessionSnapshot(locale=");
            sb.append(this.locale);
            sb.append(", visitorData=");
            sb.append(strPresence);
            sb.append(", dataSyncId=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sb, strPresence2, ", authUser=", strPresence3, ", cookie=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sb, strPresence4, ", sapisid=", strPresence5, ", useLoginForBrowse=");
            Fragment$5$$ExternalSyntheticOutline0.m(sb, this.useLoginForBrowse, ", regionOverrideActive=", this.regionOverrideActive, ", generation=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.generation, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class VisitorDataFlight {
        public final CompletableDeferredImpl result;
        public final SessionSnapshot sessionIdentity;

        public VisitorDataFlight(SessionSnapshot sessionSnapshot, CompletableDeferredImpl completableDeferredImpl) {
            this.sessionIdentity = sessionSnapshot;
            this.result = completableDeferredImpl;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VisitorDataFlight) {
                VisitorDataFlight visitorDataFlight = (VisitorDataFlight) obj;
                return this.sessionIdentity.equals(visitorDataFlight.sessionIdentity) && this.result == visitorDataFlight.result;
            }
            return false;
        }

        public final int hashCode() {
            return this.result.hashCode() + (this.sessionIdentity.hashCode() * 31);
        }

        public final String toString() {
            return "VisitorDataFlight(sessionIdentity=" + this.sessionIdentity + ", result=" + this.result + ")";
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$executeRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00831 extends ContinuationImpl {
        public double D$0;
        public byte I$0;
        public int I$1;
        public int I$2;
        public short J$0;
        public long J$1;
        public String L$0;
        public Function1 L$1;
        public HttpResponse L$2;
        public Long L$3;
        public boolean Z$0;
        public boolean Z$1;
        public int label;
        public /* synthetic */ Object result;

        public C00831(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.executeRequest(null, false, false, 0, 0L, 0.0d, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$fetchFreshVisitorData$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends ContinuationImpl {
        public SessionSnapshot L$0;
        public MutexImpl L$1;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass2(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.fetchFreshVisitorData(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$fetchFreshVisitorDataNetwork$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00841 extends ContinuationImpl {
        public long J$0;
        public SessionSnapshot L$0;
        public String L$1;
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00841(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.fetchFreshVisitorDataNetwork(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$fetchHomepageVisitorData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00851 extends ContinuationImpl {
        public Regex L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00851(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.fetchHomepageVisitorData(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$mediaContentLength$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00861 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00861(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.mediaContentLength(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$setPlaylistThumbnail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00871 extends ContinuationImpl {
        public YouTubeClient L$0;
        public String L$1;
        public byte[] L$2;
        public SessionSnapshot L$3;
        public HttpResponse L$4;
        public String L$5;
        public HttpResponse L$6;
        public int label;
        public /* synthetic */ Object result;

        public C00871(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.setPlaylistThumbnail(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$withSessionBoundRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00881 extends ContinuationImpl {
        public SessionBoundRequest L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00881(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.withSessionBoundRequest(null, null, this);
        }
    }

    static {
        Locale locale = Locale.ROOT;
        String lowerCase = HttpHeaders.Accept.toLowerCase(locale);
        lowerCase.getClass();
        String lowerCase2 = HttpHeaders.AcceptLanguage.toLowerCase(locale);
        lowerCase2.getClass();
        String lowerCase3 = HttpHeaders.Range.toLowerCase(locale);
        lowerCase3.getClass();
        String lowerCase4 = HttpHeaders.UserAgent.toLowerCase(locale);
        lowerCase4.getClass();
        MEDIA_REQUEST_HEADERS = ArraysKt.toSet(new String[]{lowerCase, lowerCase2, lowerCase3, lowerCase4});
        VISITOR_DATA_REGEX = new Regex("\"(?:VISITOR_DATA|visitorData)\"\\s*:\\s*\"([^\"]+)\"");
    }

    public InnerTube(HttpClient httpClient) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(2, null);
        httpClient.getClass();
        this.httpClient = httpClient;
        this.retryDelay = anonymousClass1;
        this.logger = InnerTubeLogger$Companion.NONE;
        Locale locale = Locale.getDefault();
        locale.getClass();
        String country = locale.getCountry();
        country.getClass();
        Locale locale2 = Locale.ROOT;
        locale2.getClass();
        String upperCase = country.toUpperCase(locale2);
        upperCase.getClass();
        String languageTag = locale.toLanguageTag();
        languageTag.getClass();
        AtomicReference atomicReference = new AtomicReference(new SessionSnapshot(new YouTubeLocale(upperCase, languageTag), null, null, "0", null, null, false, false, 0L));
        this.session = atomicReference;
        this.mutableSessionFlow = StateFlowKt.MutableStateFlow(atomicReference.get());
        this.visitorDataFetchMutex = new MutexImpl();
        this.visitorDataScope = AwaitKt.CoroutineScope(StringsKt__IndentKt.plus(AwaitKt.SupervisorJob$default(), Dispatchers.Default));
        this.sessionBoundRequests = new AtomicReference(EmptyList.INSTANCE);
    }

    public static /* synthetic */ Object executeRequest$default(InnerTube innerTube, String str, Function1 function1, Continuation continuation, int i) {
        return innerTube.executeRequest(str, (i & 2) != 0, (i & 4) != 0, 3, 500L, 2.0d, function1, continuation);
    }

    public static String parseServiceWorkerVisitorData(String str) {
        Object failure;
        String contentOrNull;
        try {
            contentOrNull = JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(JsonElementKt.getJsonArray(JsonElementKt.getJsonArray(JsonElementKt.getJsonArray(JsonElementKt.getJsonArray(JsonElementKt.getJsonArray(Json.Default.parseToJsonElement(StringsKt.trimStart(StringsKt.substringAfter('\n', str, str)).toString())).get(0)).get(2)).get(0)).get(0)).get(13)));
            if (contentOrNull == null || StringsKt.isBlank(contentOrNull)) {
                failure = contentOrNull;
                failure = null;
            }
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        failure = contentOrNull;
        return (String) (failure instanceof Result.Failure ? null : failure);
    }

    public static String resolveSapisidValue(String str) {
        Map linkedHashMap;
        String string;
        String string2;
        if (str != null) {
            List listSplit$default = StringsKt.split$default(HexFormatKt.sanitizeCookieString(str), new String[]{";"}, 0, 6);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((String) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            if (iMapCapacity < 16) {
                iMapCapacity = 16;
            }
            linkedHashMap = new LinkedHashMap(iMapCapacity);
            int size2 = arrayList2.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                List listSplit$default2 = StringsKt.split$default((String) obj2, new String[]{"="}, 2, 2);
                String str2 = (String) CollectionsKt.getOrNull(0, listSplit$default2);
                String str3 = "";
                if (str2 == null || (string = StringsKt.trim(str2).toString()) == null) {
                    string = "";
                }
                String string3 = StringsKt.trim(StringsKt.removePrefix(StringsKt.removePrefix(string, "Cookie:"), "cookie:")).toString();
                String str4 = (String) CollectionsKt.getOrNull(1, listSplit$default2);
                if (str4 != null && (string2 = StringsKt.trim(str4).toString()) != null) {
                    str3 = string2;
                }
                linkedHashMap.put(string3, str3);
            }
        } else {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            linkedHashMap = EmptyMap.INSTANCE;
        }
        String str5 = (String) linkedHashMap.get("SAPISID");
        if (str5 != null) {
            return str5;
        }
        String str6 = (String) linkedHashMap.get("__Secure-3PAPISID");
        return str6 == null ? (String) linkedHashMap.get("__Secure-1PAPISID") : str6;
    }

    public static String sanitizeAuthUser(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        return StringsKt.isBlank(string) ? "0" : string;
    }

    public static Url validatedMediaUrl(String str) {
        Url Url = URLUtilsKt.Url(str);
        if (Intrinsics.areEqual(Url.getProtocol().getName(), "https") && Url.getPort() == 443 && ((Intrinsics.areEqual(Url.getHost(), "googlevideo.com") || StringsKt__StringsJVMKt.endsWith(Url.getHost(), ".googlevideo.com", false)) && Intrinsics.areEqual(Url.getEncodedPath(), "/videoplayback") && Url.getUser() == null && Url.getPassword() == null)) {
            return Url;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Media URL must use an approved Google Video HTTPS endpoint");
        return null;
    }

    public static void ytClient(HttpRequestBuilder httpRequestBuilder, final YouTubeClient youTubeClient, final SessionSnapshot sessionSnapshot, final boolean z, final String str, final boolean z2) {
        Triple triple;
        String strRemovePrefix = StringsKt.removePrefix(URLBuilderKt.getEncodedPath(httpRequestBuilder.getUrl()), "/");
        if (strRemovePrefix.equals("player") && youTubeClient.useMusicPlayerEndpoint) {
            triple = new Triple("https://music.youtube.com/youtubei/v1", "https://music.youtube.com", "https://music.youtube.com/");
        } else {
            String str2 = youTubeClient.clientName;
            if (Intrinsics.areEqual(str2, "WEB_REMIX")) {
                triple = new Triple("https://music.youtube.com/youtubei/v1", "https://music.youtube.com", "https://music.youtube.com/");
            } else if (Intrinsics.areEqual(str2, "WEB_CREATOR")) {
                triple = new Triple("https://studio.youtube.com/youtubei/v1", "https://studio.youtube.com", "https://studio.youtube.com/");
            } else {
                triple = Intrinsics.areEqual(str2, "MWEB") ? new Triple("https://m.youtube.com/youtubei/v1", "https://m.youtube.com", "https://m.youtube.com/") : new Triple("https://www.youtube.com/youtubei/v1", "https://www.youtube.com", "https://www.youtube.com/");
            }
        }
        String str3 = (String) triple.first;
        final String str4 = (String) triple.second;
        String str5 = (String) triple.third;
        if (youTubeClient.isEmbedded) {
            str5 = "https://www.reddit.com/";
        }
        final String str6 = str5;
        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
        HttpRequestKt.headers(httpRequestBuilder, new Function1() { // from class: com.metrolist.innertubex.InnerTube$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) throws NoSuchAlgorithmException {
                HeadersBuilder headersBuilder = (HeadersBuilder) obj;
                headersBuilder.getClass();
                headersBuilder.append("X-Goog-Api-Format-Version", "1");
                YouTubeClient youTubeClient2 = youTubeClient;
                String str7 = youTubeClient2.clientId;
                boolean z3 = youTubeClient2.loginSupported;
                headersBuilder.append("X-YouTube-Client-Name", str7);
                headersBuilder.append("X-YouTube-Client-Version", youTubeClient2.clientVersion);
                String str8 = str4;
                headersBuilder.append(HttpHeaders.Origin, str8);
                headersBuilder.append("X-Origin", str8);
                headersBuilder.append(HttpHeaders.Referrer, str6);
                InnerTube.SessionSnapshot sessionSnapshot2 = sessionSnapshot;
                YouTubeLocale youTubeLocale = sessionSnapshot2.locale;
                String str9 = sessionSnapshot2.cookie;
                headersBuilder.append(HttpHeaders.AcceptLanguage, youTubeLocale.acceptLanguageHeader$com_github_MetrolistGroup_innertubex());
                String str10 = str;
                if (str10 != null) {
                    headersBuilder.append("X-Goog-Visitor-Id", str10);
                }
                if (z3 && z2) {
                    YouTubeLocale youTubeLocale2 = sessionSnapshot2.locale;
                    headersBuilder.append(HttpHeaders.Cookie, UuidKt.injectPrefCookie(str9, youTubeLocale2.hl, youTubeLocale2.gl));
                }
                if (z && z3 && str9 != null && !StringsKt.isBlank(str9)) {
                    headersBuilder.append("X-Goog-AuthUser", sessionSnapshot2.authUser);
                    String str11 = sessionSnapshot2.sapisid;
                    if (str11 != null && !StringsKt.isBlank(str11)) {
                        long epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds() / 1000;
                        String strSha1 = CharsKt.sha1(epochMilliseconds + ServerSentEventKt.SPACE + str11 + ServerSentEventKt.SPACE + str8);
                        StringBuilder sb = new StringBuilder("SAPISIDHASH ");
                        sb.append(epochMilliseconds);
                        sb.append("_");
                        sb.append(strSha1);
                        headersBuilder.append(HttpHeaders.Authorization, sb.toString());
                    }
                }
                return Unit.INSTANCE;
            }
        });
        HttpRequestKt.url(httpRequestBuilder, str3 + "/" + strRemovePrefix);
        UtilsKt.parameter(httpRequestBuilder, "prettyPrint", Boolean.FALSE);
        HttpMessagePropertiesKt.userAgent(httpRequestBuilder, youTubeClient.userAgent);
    }

    public static void ytClient$default(InnerTube innerTube, HttpRequestBuilder httpRequestBuilder, YouTubeClient youTubeClient, SessionSnapshot sessionSnapshot, boolean z, String str, boolean z2, int i) {
        if ((i & 8) != 0) {
            str = sessionSnapshot.visitorData;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            z2 = true;
        }
        innerTube.getClass();
        ytClient(httpRequestBuilder, youTubeClient, sessionSnapshot, z, str2, z2);
    }

    public final Object executeMutation(String str, SessionSnapshot sessionSnapshot, Function2 function2, ContinuationImpl continuationImpl) {
        return withSessionBoundRequest(sessionSnapshot, new FileWriteScope$writeData$2(this, str, function2, sessionSnapshot, null), continuationImpl);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 17311. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object executeRequest(java.lang.String r36, boolean r37, boolean r38, int r39, long r40, double r42, kotlin.jvm.functions.Function1 r44, kotlin.coroutines.Continuation r45) {
        /*
            Method dump skipped, instruction units count: 1731
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.InnerTube.executeRequest(java.lang.String, boolean, boolean, int, long, double, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a7 A[Catch: all -> 0x0074, TryCatch #0 {all -> 0x0074, blocks: (B:23:0x0063, B:25:0x006d, B:41:0x00a7, B:43:0x00bd, B:48:0x00c9, B:49:0x00cc, B:30:0x0078, B:32:0x007c, B:34:0x0082, B:39:0x009d), top: B:60:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bd A[Catch: all -> 0x0074, TryCatch #0 {all -> 0x0074, blocks: (B:23:0x0063, B:25:0x006d, B:41:0x00a7, B:43:0x00bd, B:48:0x00c9, B:49:0x00cc, B:30:0x0078, B:32:0x007c, B:34:0x0082, B:39:0x009d), top: B:60:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c9 A[Catch: all -> 0x0074, TryCatch #0 {all -> 0x0074, blocks: (B:23:0x0063, B:25:0x006d, B:41:0x00a7, B:43:0x00bd, B:48:0x00c9, B:49:0x00cc, B:30:0x0078, B:32:0x007c, B:34:0x0082, B:39:0x009d), top: B:60:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object fetchFreshVisitorData(SessionSnapshot sessionSnapshot, boolean z, ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass2 anonymousClass2;
        SessionSnapshot sessionSnapshot2;
        MutexImpl mutexImpl;
        boolean z2;
        Continuation continuation;
        MutexImpl mutexImpl2;
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default;
        boolean z3;
        SessionSnapshot sessionSnapshotCopy$default;
        VisitorDataFlight visitorDataFlight;
        if (continuationImpl instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuationImpl;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuationImpl);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuationImpl);
        }
        AnonymousClass2 anonymousClass3 = anonymousClass2;
        Object obj = anonymousClass3.result;
        int i2 = anonymousClass3.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                anonymousClass3.L$0 = sessionSnapshot;
                MutexImpl mutexImpl3 = this.visitorDataFetchMutex;
                anonymousClass3.L$1 = mutexImpl3;
                anonymousClass3.Z$0 = z;
                anonymousClass3.label = 1;
                if (mutexImpl3.lock(anonymousClass3) != coroutineSingletons) {
                    sessionSnapshot2 = sessionSnapshot;
                    mutexImpl = mutexImpl3;
                    z2 = z;
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            z2 = anonymousClass3.Z$0;
            mutexImpl = anonymousClass3.L$1;
            SessionSnapshot sessionSnapshot3 = anonymousClass3.L$0;
            ResultKt.throwOnFailure(obj);
            sessionSnapshot2 = sessionSnapshot3;
            SessionSnapshot sessionSnapshot4 = (SessionSnapshot) this.session.get();
            if (z2 && Intrinsics.areEqual(sessionSnapshot2, sessionSnapshot4)) {
                sessionSnapshotCopy$default = SessionSnapshot.copy$default(sessionSnapshot2, null, null, null, null, null, null, false, false, 0L, 509);
                visitorDataFlight = this.visitorDataFlight;
                if (visitorDataFlight != null) {
                    if (!visitorDataFlight.sessionIdentity.equals(sessionSnapshotCopy$default)) {
                        visitorDataFlight = null;
                    }
                    if (visitorDataFlight != null) {
                        completableDeferredImplCompletableDeferred$default = visitorDataFlight.result;
                        z3 = z2;
                        mutexImpl2 = mutexImpl;
                    }
                }
                boolean z4 = z2;
                CompletableDeferredImpl completableDeferredImplCompletableDeferred$default2 = AwaitKt.CompletableDeferred$default();
                this.visitorDataFlight = new VisitorDataFlight(sessionSnapshotCopy$default, completableDeferredImplCompletableDeferred$default2);
                z3 = z4;
                SessionSnapshot sessionSnapshot5 = sessionSnapshot2;
                mutexImpl2 = mutexImpl;
                AwaitKt.launch$default(this.visitorDataScope, null, null, new NavHostKt$NavHost$29$1((Object) completableDeferredImplCompletableDeferred$default2, (Object) this, (Object) sessionSnapshot5, continuation, (byte) 6), 3);
                completableDeferredImplCompletableDeferred$default = completableDeferredImplCompletableDeferred$default2;
            } else {
                String str = sessionSnapshot4.visitorData;
                if (str == null) {
                    sessionSnapshotCopy$default = SessionSnapshot.copy$default(sessionSnapshot2, null, null, null, null, null, null, false, false, 0L, 509);
                    visitorDataFlight = this.visitorDataFlight;
                    if (visitorDataFlight != null) {
                        if (!visitorDataFlight.sessionIdentity.equals(sessionSnapshotCopy$default)) {
                            visitorDataFlight = null;
                        }
                        if (visitorDataFlight != null) {
                            completableDeferredImplCompletableDeferred$default = visitorDataFlight.result;
                            z3 = z2;
                            mutexImpl2 = mutexImpl;
                        }
                    }
                    boolean z5 = z2;
                    CompletableDeferredImpl completableDeferredImplCompletableDeferred$default3 = AwaitKt.CompletableDeferred$default();
                    this.visitorDataFlight = new VisitorDataFlight(sessionSnapshotCopy$default, completableDeferredImplCompletableDeferred$default3);
                    z3 = z5;
                    SessionSnapshot sessionSnapshot6 = sessionSnapshot2;
                    mutexImpl2 = mutexImpl;
                    try {
                        AwaitKt.launch$default(this.visitorDataScope, null, null, new NavHostKt$NavHost$29$1((Object) completableDeferredImplCompletableDeferred$default3, (Object) this, (Object) sessionSnapshot6, continuation, (byte) 6), 3);
                        completableDeferredImplCompletableDeferred$default = completableDeferredImplCompletableDeferred$default3;
                    } catch (Throwable th) {
                        th = th;
                        mutexImpl2.unlock(null);
                        throw th;
                    }
                } else {
                    if (StringsKt.isBlank(str) || !SessionSnapshot.copy$default(sessionSnapshot2, null, str, null, null, null, null, false, false, 0L, 509).equals(sessionSnapshot4)) {
                        str = null;
                    }
                    if (str != null) {
                        completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
                        completableDeferredImplCompletableDeferred$default.makeCompleting$kotlinx_coroutines_core(str);
                    } else {
                        sessionSnapshotCopy$default = SessionSnapshot.copy$default(sessionSnapshot2, null, null, null, null, null, null, false, false, 0L, 509);
                        visitorDataFlight = this.visitorDataFlight;
                        if (visitorDataFlight != null) {
                            if (!visitorDataFlight.sessionIdentity.equals(sessionSnapshotCopy$default)) {
                                visitorDataFlight = null;
                            }
                            if (visitorDataFlight != null) {
                                completableDeferredImplCompletableDeferred$default = visitorDataFlight.result;
                            }
                        }
                        boolean z6 = z2;
                        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default4 = AwaitKt.CompletableDeferred$default();
                        this.visitorDataFlight = new VisitorDataFlight(sessionSnapshotCopy$default, completableDeferredImplCompletableDeferred$default4);
                        z3 = z6;
                        SessionSnapshot sessionSnapshot7 = sessionSnapshot2;
                        mutexImpl2 = mutexImpl;
                        AwaitKt.launch$default(this.visitorDataScope, null, null, new NavHostKt$NavHost$29$1((Object) completableDeferredImplCompletableDeferred$default4, (Object) this, (Object) sessionSnapshot7, continuation, (byte) 6), 3);
                        completableDeferredImplCompletableDeferred$default = completableDeferredImplCompletableDeferred$default4;
                    }
                    z3 = z2;
                    mutexImpl2 = mutexImpl;
                }
            }
            mutexImpl2.unlock(null);
            anonymousClass3.L$0 = null;
            anonymousClass3.L$1 = null;
            anonymousClass3.Z$0 = z3;
            anonymousClass3.label = 2;
            Object objAwaitInternal = completableDeferredImplCompletableDeferred$default.awaitInternal(anonymousClass3);
            return objAwaitInternal == coroutineSingletons ? coroutineSingletons : objAwaitInternal;
        } catch (Throwable th2) {
            th = th2;
            mutexImpl2 = mutexImpl;
        }
        continuation = null;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x012d A[Catch: Exception -> 0x004a, CancellationException -> 0x01ba, TryCatch #9 {CancellationException -> 0x01ba, Exception -> 0x004a, blocks: (B:15:0x0043, B:74:0x0140, B:78:0x014d, B:81:0x0154, B:82:0x016f, B:84:0x017c, B:89:0x0187, B:93:0x0190, B:70:0x012d, B:68:0x0111, B:94:0x01b9, B:39:0x0092, B:22:0x005b, B:63:0x0104, B:29:0x0074, B:53:0x00e4, B:34:0x0086, B:45:0x00bc, B:49:0x00ce, B:59:0x00f3, B:40:0x00a3, B:42:0x00b4), top: B:105:0x0033, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x013f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0148  */
    /* JADX WARN: Code duplicated, block: B:78:0x014d A[Catch: Exception -> 0x004a, CancellationException -> 0x01ba, TryCatch #9 {CancellationException -> 0x01ba, Exception -> 0x004a, blocks: (B:15:0x0043, B:74:0x0140, B:78:0x014d, B:81:0x0154, B:82:0x016f, B:84:0x017c, B:89:0x0187, B:93:0x0190, B:70:0x012d, B:68:0x0111, B:94:0x01b9, B:39:0x0092, B:22:0x005b, B:63:0x0104, B:29:0x0074, B:53:0x00e4, B:34:0x0086, B:45:0x00bc, B:49:0x00ce, B:59:0x00f3, B:40:0x00a3, B:42:0x00b4), top: B:105:0x0033, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code duplicated, block: B:84:0x017c A[Catch: Exception -> 0x004a, CancellationException -> 0x01ba, TryCatch #9 {CancellationException -> 0x01ba, Exception -> 0x004a, blocks: (B:15:0x0043, B:74:0x0140, B:78:0x014d, B:81:0x0154, B:82:0x016f, B:84:0x017c, B:89:0x0187, B:93:0x0190, B:70:0x012d, B:68:0x0111, B:94:0x01b9, B:39:0x0092, B:22:0x005b, B:63:0x0104, B:29:0x0074, B:53:0x00e4, B:34:0x0086, B:45:0x00bc, B:49:0x00ce, B:59:0x00f3, B:40:0x00a3, B:42:0x00b4), top: B:105:0x0033, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0185  */
    /* JADX WARN: Code duplicated, block: B:91:0x018b  */
    /* JADX WARN: Code duplicated, block: B:92:0x018e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [long] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [long] */
    /* JADX WARN: Type inference failed for: r11v8, types: [long] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [long] */
    /* JADX WARN: Type inference failed for: r12v15, types: [long] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [long] */
    /* JADX WARN: Type inference failed for: r12v5, types: [long] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.metrolist.innertubex.InnerTube$SessionSnapshot] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r29v0, types: [com.metrolist.innertubex.InnerTube] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.metrolist.innertubex.InnerTube$SessionSnapshot] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.metrolist.innertubex.InnerTube$SessionSnapshot] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [com.metrolist.innertubex.InnerTube$SessionSnapshot] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v26, types: [com.metrolist.innertubex.InnerTube$SessionSnapshot] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.metrolist.innertubex.InnerTube$SessionSnapshot] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0111 -> B:69:0x012b). Please report as a decompilation issue!!! */
    public final Object fetchFreshVisitorDataNetwork(SessionSnapshot sessionSnapshot, ContinuationImpl continuationImpl) throws Throwable {
        C00841 c00841;
        boolean z;
        ?? r4;
        ?? r2;
        ?? r12;
        ?? r11;
        ?? r19;
        ?? r6;
        ?? r13;
        ?? r5;
        ?? r3;
        ?? r17;
        boolean z2;
        String str;
        ?? r7;
        ?? r8;
        ?? r14;
        ?? r9;
        ?? r15;
        ?? r10;
        ?? r16;
        ?? r18;
        String serviceWorkerVisitorData;
        ?? r20;
        ?? r21;
        ?? r22 = sessionSnapshot;
        ?? r23 = "service-worker visitor data unavailable (";
        if (continuationImpl instanceof C00841) {
            c00841 = (C00841) continuationImpl;
            int i = c00841.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00841.label = i - Integer.MIN_VALUE;
            } else {
                c00841 = new C00841(continuationImpl);
            }
        } else {
            c00841 = new C00841(continuationImpl);
        }
        Object objFetchHomepageVisitorData = c00841.result;
        int i2 = c00841.label;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = this.logger;
        ?? epochMilliseconds = 4;
        ?? r110 = 4;
        epochMilliseconds = 4;
        ?? r111 = 4;
        epochMilliseconds = 4;
        ?? r112 = 3;
        byte b = 1;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(objFetchHomepageVisitorData);
                        epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", "fetchFreshVisitorData start", null, 12);
                        try {
                            InnerTube$fetchHomepageVisitorData$response$1 innerTube$fetchHomepageVisitorData$response$1 = new InnerTube$fetchHomepageVisitorData$response$1(this, r22, continuation, b);
                            c00841.L$0 = r22;
                            c00841.J$0 = epochMilliseconds;
                            c00841.label = 1;
                            z = true;
                            try {
                                objFetchHomepageVisitorData = executeRequest$default(this, "fetchFreshVisitorData", innerTube$fetchHomepageVisitorData$response$1, c00841, 58);
                                r9 = r22;
                                r14 = epochMilliseconds;
                                if (objFetchHomepageVisitorData == coroutineSingletons) {
                                    r22 = r22;
                                    r23 = r23;
                                    epochMilliseconds = epochMilliseconds;
                                }
                            } catch (Exception e) {
                                e = e;
                                r112 = epochMilliseconds;
                                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", ((String) r23) + UuidKt.logType(e) + ")", null, 12);
                                r4 = r22;
                                r2 = 0;
                                r11 = epochMilliseconds;
                                r12 = r112;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            z = true;
                            r112 = epochMilliseconds;
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", ((String) r23) + UuidKt.logType(e) + ")", null, 12);
                            r4 = r22;
                            r2 = 0;
                            r11 = epochMilliseconds;
                            r12 = r112;
                        }
                        r22 = r9;
                        r23 = r23;
                        epochMilliseconds = r14;
                        r22 = r2;
                        r23 = r4;
                        epochMilliseconds = r11;
                        return coroutineSingletons;
                    }
                    if (i2 != 1) {
                        if (i2 == 2) {
                            r112 = c00841.J$0;
                            InnerTube innerTube = c00841.L$2;
                            SessionSnapshot sessionSnapshot2 = c00841.L$0;
                            try {
                                ResultKt.throwOnFailure(objFetchHomepageVisitorData);
                                r10 = innerTube;
                                r18 = sessionSnapshot2;
                                z = true;
                                r16 = r112;
                                r10.getClass();
                                serviceWorkerVisitorData = parseServiceWorkerVisitorData((String) objFetchHomepageVisitorData);
                                r20 = r18;
                                epochMilliseconds = r111;
                                r112 = r16;
                                r23 = r20;
                                r22 = serviceWorkerVisitorData;
                                r2 = r22;
                                r4 = r23;
                                r11 = epochMilliseconds;
                                r12 = r112;
                            } catch (Exception e3) {
                                e = e3;
                                r22 = sessionSnapshot2;
                                z = true;
                                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", ((String) r23) + UuidKt.logType(e) + ")", null, 12);
                                r4 = r22;
                                r2 = 0;
                                r11 = epochMilliseconds;
                                r12 = r112;
                            }
                            if (r2 == 0) {
                                c00841.L$0 = r4;
                                c00841.L$1 = r2;
                                c00841.L$2 = null;
                                c00841.J$0 = r12;
                                c00841.label = 4;
                                objFetchHomepageVisitorData = fetchHomepageVisitorData(r4, c00841);
                                if (objFetchHomepageVisitorData != coroutineSingletons) {
                                    r22 = r2;
                                    r23 = r4;
                                    epochMilliseconds = r11;
                                    r6 = r12;
                                    r8 = r2;
                                    r7 = r4;
                                    r19 = (String) objFetchHomepageVisitorData;
                                    r13 = r6;
                                    r3 = r8;
                                    r5 = r7;
                                }
                                r22 = r9;
                                r23 = r23;
                                epochMilliseconds = r14;
                                r22 = r2;
                                r23 = r4;
                                epochMilliseconds = r11;
                                return coroutineSingletons;
                            }
                            r19 = r2;
                            r3 = r2;
                            r5 = r4;
                            r13 = r12;
                            r17 = r5;
                            if (r19 != 0) {
                                publishSession(r17, SessionSnapshot.copy$default(r17, null, r19, null, null, null, null, false, false, 0L, 509));
                            }
                            ?? epochMilliseconds2 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r13;
                            if (r19 != 0) {
                                z2 = z;
                            } else {
                                z2 = z;
                            }
                            boolean z3 = !z2;
                            if (r3 != 0) {
                                str = "service-worker";
                            } else {
                                str = "homepage";
                            }
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", "fetchFreshVisitorData success hasVisitorData=" + z3 + " source=" + str + " elapsed=" + ((long) epochMilliseconds2) + "ms", null, 12);
                            return r19;
                        }
                        if (i2 == 3) {
                            r112 = c00841.J$0;
                            r22 = c00841.L$0;
                            try {
                                ResultKt.throwOnFailure(objFetchHomepageVisitorData);
                                z = true;
                                r21 = r22;
                                r15 = r112;
                                ((ByteReadChannel) objFetchHomepageVisitorData).cancel(null);
                                serviceWorkerVisitorData = null;
                                r20 = r21;
                                epochMilliseconds = r110;
                                r112 = r15;
                                r23 = r20;
                                r22 = serviceWorkerVisitorData;
                                r2 = r22;
                                r4 = r23;
                                r11 = epochMilliseconds;
                                r12 = r112;
                            } catch (Exception e4) {
                                e = e4;
                                z = true;
                                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", ((String) r23) + UuidKt.logType(e) + ")", null, 12);
                                r4 = r22;
                                r2 = 0;
                                r11 = epochMilliseconds;
                                r12 = r112;
                            }
                            if (r2 == 0) {
                                c00841.L$0 = r4;
                                c00841.L$1 = r2;
                                c00841.L$2 = null;
                                c00841.J$0 = r12;
                                c00841.label = 4;
                                objFetchHomepageVisitorData = fetchHomepageVisitorData(r4, c00841);
                                if (objFetchHomepageVisitorData != coroutineSingletons) {
                                    r22 = r2;
                                    r23 = r4;
                                    epochMilliseconds = r11;
                                    r6 = r12;
                                    r8 = r2;
                                    r7 = r4;
                                }
                                r22 = r9;
                                r23 = r23;
                                epochMilliseconds = r14;
                                r22 = r2;
                                r23 = r4;
                                epochMilliseconds = r11;
                                return coroutineSingletons;
                            }
                            r19 = r2;
                            r3 = r2;
                            r5 = r4;
                            r13 = r12;
                            r17 = r5;
                            if (r19 != 0 && !StringsKt.isBlank(r19)) {
                                publishSession(r17, SessionSnapshot.copy$default(r17, null, r19, null, null, null, null, false, false, 0L, 509));
                            }
                            ?? epochMilliseconds3 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r13;
                            if (r19 != 0 || StringsKt.isBlank(r19)) {
                                z2 = z;
                            } else {
                                z2 = false;
                            }
                            boolean z4 = !z2;
                            if (r3 != 0) {
                                str = "service-worker";
                            } else {
                                str = "homepage";
                            }
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", "fetchFreshVisitorData success hasVisitorData=" + z4 + " source=" + str + " elapsed=" + ((long) epochMilliseconds3) + "ms", null, 12);
                            return r19;
                        }
                        if (i2 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        long j = c00841.J$0;
                        String str2 = c00841.L$1;
                        SessionSnapshot sessionSnapshot3 = c00841.L$0;
                        ResultKt.throwOnFailure(objFetchHomepageVisitorData);
                        z = true;
                        r8 = str2;
                        r7 = sessionSnapshot3;
                        r6 = j;
                        r19 = (String) objFetchHomepageVisitorData;
                        r13 = r6;
                        r3 = r8;
                        r5 = r7;
                        r17 = r5;
                        if (r19 != 0) {
                            publishSession(r17, SessionSnapshot.copy$default(r17, null, r19, null, null, null, null, false, false, 0L, 509));
                        }
                        ?? epochMilliseconds4 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r13;
                        if (r19 != 0) {
                            z2 = z;
                        } else {
                            z2 = z;
                        }
                        boolean z5 = !z2;
                        if (r3 != 0) {
                            str = "service-worker";
                        } else {
                            str = "homepage";
                        }
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", "fetchFreshVisitorData success hasVisitorData=" + z5 + " source=" + str + " elapsed=" + ((long) epochMilliseconds4) + "ms", null, 12);
                        return r19;
                    }
                    epochMilliseconds = c00841.J$0;
                    r22 = c00841.L$0;
                    try {
                        ResultKt.throwOnFailure(objFetchHomepageVisitorData);
                        z = true;
                        r9 = r22;
                        r14 = epochMilliseconds;
                    } catch (Exception e5) {
                        e = e5;
                        r112 = epochMilliseconds;
                        z = true;
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", ((String) r23) + UuidKt.logType(e) + ")", null, 12);
                        r4 = r22;
                        r2 = 0;
                        r11 = epochMilliseconds;
                        r12 = r112;
                    }
                    z = true;
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", ((String) r23) + UuidKt.logType(e) + ")", null, 12);
                    r4 = r22;
                    r2 = 0;
                    r11 = epochMilliseconds;
                    r12 = r112;
                    if (r2 == 0) {
                        c00841.L$0 = r4;
                        c00841.L$1 = r2;
                        c00841.L$2 = null;
                        c00841.J$0 = r12;
                        c00841.label = 4;
                        objFetchHomepageVisitorData = fetchHomepageVisitorData(r4, c00841);
                        if (objFetchHomepageVisitorData != coroutineSingletons) {
                            r22 = r2;
                            r23 = r4;
                            epochMilliseconds = r11;
                            r6 = r12;
                            r8 = r2;
                            r7 = r4;
                            r19 = (String) objFetchHomepageVisitorData;
                            r13 = r6;
                            r3 = r8;
                            r5 = r7;
                        }
                        r22 = r9;
                        r23 = r23;
                        epochMilliseconds = r14;
                        r22 = r2;
                        r23 = r4;
                        epochMilliseconds = r11;
                        return coroutineSingletons;
                    }
                    r19 = r2;
                    r3 = r2;
                    r5 = r4;
                    r13 = r12;
                    r17 = r5;
                    if (r19 != 0) {
                        publishSession(r17, SessionSnapshot.copy$default(r17, null, r19, null, null, null, null, false, false, 0L, 509));
                    }
                    ?? epochMilliseconds5 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r13;
                    if (r19 != 0) {
                        z2 = z;
                    } else {
                        z2 = z;
                    }
                    boolean z6 = !z2;
                    if (r3 != 0) {
                        str = "service-worker";
                    } else {
                        str = "homepage";
                    }
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", "fetchFreshVisitorData success hasVisitorData=" + z6 + " source=" + str + " elapsed=" + ((long) epochMilliseconds5) + "ms", null, 12);
                    return r19;
                    HttpResponse httpResponse = (HttpResponse) objFetchHomepageVisitorData;
                    int value = httpResponse.getStatus().getValue();
                    if (200 > value || value >= 300) {
                        c00841.L$0 = r9;
                        c00841.L$1 = null;
                        c00841.J$0 = r14;
                        c00841.label = 3;
                        objFetchHomepageVisitorData = HttpResponseKt.bodyAsChannel(httpResponse, c00841);
                        r22 = r9;
                        r23 = r23;
                        epochMilliseconds = r14;
                        if (objFetchHomepageVisitorData != coroutineSingletons) {
                            r15 = r14;
                            r21 = r9;
                            r110 = r14;
                            ((ByteReadChannel) objFetchHomepageVisitorData).cancel(null);
                            serviceWorkerVisitorData = null;
                            r20 = r21;
                            epochMilliseconds = r110;
                            r112 = r15;
                            r23 = r20;
                            r22 = serviceWorkerVisitorData;
                            r2 = r22;
                            r4 = r23;
                            r11 = epochMilliseconds;
                            r12 = r112;
                            if (r2 == 0) {
                                c00841.L$0 = r4;
                                c00841.L$1 = r2;
                                c00841.L$2 = null;
                                c00841.J$0 = r12;
                                c00841.label = 4;
                                objFetchHomepageVisitorData = fetchHomepageVisitorData(r4, c00841);
                                if (objFetchHomepageVisitorData != coroutineSingletons) {
                                    r22 = r2;
                                    r23 = r4;
                                    epochMilliseconds = r11;
                                    r6 = r12;
                                    r8 = r2;
                                    r7 = r4;
                                    r19 = (String) objFetchHomepageVisitorData;
                                    r13 = r6;
                                    r3 = r8;
                                    r5 = r7;
                                }
                            } else {
                                r19 = r2;
                                r3 = r2;
                                r5 = r4;
                                r13 = r12;
                            }
                            r17 = r5;
                            if (r19 != 0) {
                                publishSession(r17, SessionSnapshot.copy$default(r17, null, r19, null, null, null, null, false, false, 0L, 509));
                            }
                            ?? epochMilliseconds6 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r13;
                            if (r19 != 0) {
                                z2 = z;
                            } else {
                                z2 = z;
                            }
                            boolean z7 = !z2;
                            if (r3 != 0) {
                                str = "service-worker";
                            } else {
                                str = "homepage";
                            }
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", "fetchFreshVisitorData success hasVisitorData=" + z7 + " source=" + str + " elapsed=" + ((long) epochMilliseconds6) + "ms", null, 12);
                            return r19;
                        }
                    } else {
                        c00841.L$0 = r9;
                        c00841.L$1 = null;
                        c00841.L$2 = this;
                        c00841.J$0 = r14;
                        c00841.label = 2;
                        objFetchHomepageVisitorData = CollectionsKt__IterablesKt.bodyAsTextLimited(httpResponse, 4194304, null, c00841);
                        if (objFetchHomepageVisitorData != coroutineSingletons) {
                            r22 = r9;
                            r23 = r23;
                            epochMilliseconds = r14;
                            r10 = this;
                            r16 = r14;
                            r18 = r9;
                            r111 = r14;
                            r10.getClass();
                            serviceWorkerVisitorData = parseServiceWorkerVisitorData((String) objFetchHomepageVisitorData);
                            r20 = r18;
                            epochMilliseconds = r111;
                            r112 = r16;
                            r23 = r20;
                            r22 = serviceWorkerVisitorData;
                            r2 = r22;
                            r4 = r23;
                            r11 = epochMilliseconds;
                            r12 = r112;
                            if (r2 == 0) {
                                c00841.L$0 = r4;
                                c00841.L$1 = r2;
                                c00841.L$2 = null;
                                c00841.J$0 = r12;
                                c00841.label = 4;
                                objFetchHomepageVisitorData = fetchHomepageVisitorData(r4, c00841);
                                if (objFetchHomepageVisitorData != coroutineSingletons) {
                                    r22 = r2;
                                    r23 = r4;
                                    epochMilliseconds = r11;
                                    r6 = r12;
                                    r8 = r2;
                                    r7 = r4;
                                    r19 = (String) objFetchHomepageVisitorData;
                                    r13 = r6;
                                    r3 = r8;
                                    r5 = r7;
                                }
                            } else {
                                r19 = r2;
                                r3 = r2;
                                r5 = r4;
                                r13 = r12;
                            }
                            r17 = r5;
                            if (r19 != 0) {
                                publishSession(r17, SessionSnapshot.copy$default(r17, null, r19, null, null, null, null, false, false, 0L, 509));
                            }
                            ?? epochMilliseconds7 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - r13;
                            if (r19 != 0) {
                                z2 = z;
                            } else {
                                z2 = z;
                            }
                            boolean z8 = !z2;
                            if (r3 != 0) {
                                str = "service-worker";
                            } else {
                                str = "homepage";
                            }
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", "fetchFreshVisitorData success hasVisitorData=" + z8 + " source=" + str + " elapsed=" + ((long) epochMilliseconds7) + "ms", null, 12);
                            return r19;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                }
                r22 = r9;
                r23 = r23;
                epochMilliseconds = r14;
                r22 = r2;
                r23 = r4;
                epochMilliseconds = r11;
                return coroutineSingletons;
            } catch (CancellationException e7) {
                throw e7;
            }
        } catch (CancellationException e8) {
            throw e8;
        } catch (Exception e9) {
            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", IntIntPair$$ExternalSyntheticOutline0.m("fetchFreshVisitorData failed (", UuidKt.logType(e9), ")"), null, 12);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        if (r9 == r6) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0091, code lost:
    
        if (r9 == r6) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchHomepageVisitorData(SessionSnapshot sessionSnapshot, ContinuationImpl continuationImpl) throws Throwable {
        C00851 c00851;
        Regex regex;
        if (continuationImpl instanceof C00851) {
            c00851 = (C00851) continuationImpl;
            int i = c00851.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00851.label = i - Integer.MIN_VALUE;
            } else {
                c00851 = new C00851(continuationImpl);
            }
        } else {
            c00851 = new C00851(continuationImpl);
        }
        Object objExecuteRequest$default = c00851.result;
        int i2 = c00851.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteRequest$default);
            InnerTube$fetchHomepageVisitorData$response$1 innerTube$fetchHomepageVisitorData$response$1 = new InnerTube$fetchHomepageVisitorData$response$1(this, sessionSnapshot, continuation, (byte) 0);
            c00851.label = 1;
            objExecuteRequest$default = executeRequest$default(this, "fetchFreshVisitorData", innerTube$fetchHomepageVisitorData$response$1, c00851, 58);
            if (objExecuteRequest$default != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteRequest$default);
                ((ByteReadChannel) objExecuteRequest$default).cancel(null);
                return null;
            }
            if (i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            regex = c00851.L$2;
            ResultKt.throwOnFailure(objExecuteRequest$default);
            MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(regex, (CharSequence) objExecuteRequest$default);
            if (matcherMatchResultFind$default != null) {
                return (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(1);
            }
            return null;
        }
        ResultKt.throwOnFailure(objExecuteRequest$default);
        HttpResponse httpResponse = (HttpResponse) objExecuteRequest$default;
        int value = httpResponse.getStatus().getValue();
        if (200 > value || value >= 300) {
            c00851.label = 2;
            objExecuteRequest$default = HttpResponseKt.bodyAsChannel(httpResponse, c00851);
        } else {
            regex = VISITOR_DATA_REGEX;
            c00851.L$2 = regex;
            c00851.label = 3;
            objExecuteRequest$default = CollectionsKt__IterablesKt.bodyAsTextLimited(httpResponse, 4194304, null, c00851);
        }
        return coroutineSingletons;
    }

    public final boolean hasSapCookieAuth() {
        String str;
        SessionSnapshot sessionSnapshot = (SessionSnapshot) this.session.get();
        sessionSnapshot.getClass();
        String str2 = sessionSnapshot.cookie;
        return (str2 == null || StringsKt.isBlank(str2) || (str = sessionSnapshot.sapisid) == null || StringsKt.isBlank(str)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object mediaContentLength(String str, Map map, ContinuationImpl continuationImpl) {
        C00861 c00861;
        if (continuationImpl instanceof C00861) {
            c00861 = (C00861) continuationImpl;
            int i = c00861.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00861.label = i - Integer.MIN_VALUE;
            } else {
                c00861 = new C00861(continuationImpl);
            }
        } else {
            c00861 = new C00861(continuationImpl);
        }
        Object objExecute = c00861.result;
        int i2 = c00861.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                Url urlValidatedMediaUrl = validatedMediaUrl(str);
                HttpClient httpClient = this.httpClient;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                httpRequestBuilder.setMethod(HttpMethod.Head);
                URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), urlValidatedMediaUrl);
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    Set set = MEDIA_REQUEST_HEADERS;
                    String lowerCase = str2.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    if (set.contains(lowerCase)) {
                        UtilsKt.header(httpRequestBuilder, str2, str3);
                    }
                }
                httpRequestBuilder.setMethod(HttpMethod.Head);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                c00861.label = 1;
                objExecute = httpStatement.execute(c00861);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objExecute == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute);
            }
            Long lContentLength = HttpMessagePropertiesKt.contentLength((HttpMessage) objExecute);
            if (lContentLength == null || lContentLength.longValue() <= 0) {
                return null;
            }
            return lContentLength;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public final boolean publishSession(SessionSnapshot sessionSnapshot, SessionSnapshot sessionSnapshot2) {
        StateFlowImpl stateFlowImpl;
        SessionSnapshot sessionSnapshot3;
        List list;
        AtomicReference atomicReference = this.session;
        SessionSnapshot sessionSnapshot4 = (SessionSnapshot) atomicReference.get();
        if (sessionSnapshot2.equals(sessionSnapshot)) {
            return Intrinsics.areEqual(sessionSnapshot4, sessionSnapshot);
        }
        byte b = 0;
        if (!Intrinsics.areEqual(sessionSnapshot4, sessionSnapshot)) {
            return false;
        }
        SessionSnapshot sessionSnapshotCopy$default = SessionSnapshot.copy$default(sessionSnapshot2, null, null, null, null, null, null, false, false, sessionSnapshot.generation + 1, 255);
        long j = sessionSnapshotCopy$default.generation;
        while (!atomicReference.compareAndSet(sessionSnapshot4, sessionSnapshotCopy$default)) {
            if (atomicReference.get() != sessionSnapshot4) {
                return false;
            }
        }
        do {
            stateFlowImpl = this.mutableSessionFlow;
            sessionSnapshot3 = (SessionSnapshot) stateFlowImpl.getValue();
            if (sessionSnapshot3.generation >= j) {
                break;
            }
        } while (!stateFlowImpl.compareAndSet(sessionSnapshot3, sessionSnapshotCopy$default));
        loop2: while (true) {
            AtomicReference atomicReference2 = this.sessionBoundRequests;
            list = (List) atomicReference2.get();
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((SessionBoundRequest) obj).session.generation >= j) {
                    arrayList.add(obj);
                }
            }
            do {
                if (atomicReference2.compareAndSet(list, arrayList)) {
                    break loop2;
                }
            } while (atomicReference2.get() == list);
        }
        FilteringSequence.AnonymousClass1 anonymousClass1 = new FilteringSequence.AnonymousClass1(new FilteringSequence(new LinesSequence((byte) 2, list), true, new InnerTube$$ExternalSyntheticLambda2(j, b)));
        while (anonymousClass1.hasNext()) {
            ((SessionBoundRequest) anonymousClass1.next()).job.cancel(new CancellationException("InnerTube session changed"));
        }
        return true;
    }

    public final SessionSnapshot sessionSnapshot() {
        return (SessionSnapshot) this.session.get();
    }

    public final SessionSnapshot sessionSnapshotWithVisitorData(SessionSnapshot sessionSnapshot, String str) {
        sessionSnapshot.getClass();
        str.getClass();
        SessionSnapshot sessionSnapshot2 = (SessionSnapshot) this.session.get();
        if (SessionSnapshot.copy$default(sessionSnapshot, null, str, null, null, null, null, false, false, sessionSnapshot2.generation, 253).equals(sessionSnapshot2)) {
            return sessionSnapshot2;
        }
        return null;
    }

    public final void setLocale(YouTubeLocale youTubeLocale) {
        while (true) {
            SessionSnapshot sessionSnapshot = (SessionSnapshot) this.session.get();
            YouTubeLocale youTubeLocale2 = youTubeLocale;
            SessionSnapshot sessionSnapshotCopy$default = SessionSnapshot.copy$default(sessionSnapshot, youTubeLocale2, null, null, null, null, null, false, false, 0L, 510);
            if (sessionSnapshotCopy$default.equals(sessionSnapshot) || publishSession(sessionSnapshot, sessionSnapshotCopy$default)) {
                return;
            } else {
                youTubeLocale = youTubeLocale2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:60:0x0195  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [byte[], io.ktor.client.statement.HttpResponse, java.lang.String, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r8v5, types: [byte[], com.metrolist.innertubex.InnerTube$SessionSnapshot, com.metrolist.innertubex.models.YouTubeClient, io.ktor.client.statement.HttpResponse, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    public final Object setPlaylistThumbnail(YouTubeClient youTubeClient, String str, byte[] bArr, ContinuationImpl continuationImpl) throws Throwable {
        C00871 c00871;
        SessionSnapshot sessionSnapshot;
        String str2;
        YouTubeClient youTubeClient2;
        HttpResponse httpResponse;
        byte[] bArr2;
        String str3;
        YouTubeClient youTubeClient3;
        String str4;
        ?? r8;
        YouTubeClient youTubeClient4;
        String str5;
        SessionSnapshot sessionSnapshot2;
        HttpResponse httpResponse2;
        ?? r9;
        byte[] bArr3 = bArr;
        if (continuationImpl instanceof C00871) {
            c00871 = (C00871) continuationImpl;
            int i = c00871.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00871.label = i - Integer.MIN_VALUE;
            } else {
                c00871 = new C00871(continuationImpl);
            }
        } else {
            c00871 = new C00871(continuationImpl);
        }
        C00871 c00872 = c00871;
        Object objExecuteMutation = c00872.result;
        int i2 = c00872.label;
        Object obj = null;
        Continuation continuation = null;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            if (bArr3.length == 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Playlist thumbnail must not be empty");
                return null;
            }
            sessionSnapshot = sessionSnapshot();
            Function2 innerTube$feedback$2 = new InnerTube$feedback$2((Object) this, (Object) youTubeClient, (Object) bArr3, continuation, (byte) 9);
            c00872.L$0 = youTubeClient;
            str2 = str;
            c00872.L$1 = str2;
            c00872.L$2 = bArr3;
            c00872.L$3 = sessionSnapshot;
            c00872.label = 1;
            objExecuteMutation = executeMutation("setPlaylistThumbnail:start", sessionSnapshot, innerTube$feedback$2, c00872);
            if (objExecuteMutation != obj2) {
                youTubeClient2 = youTubeClient;
            }
        }
        if (i2 == 1) {
            SessionSnapshot sessionSnapshot3 = c00872.L$3;
            bArr3 = c00872.L$2;
            str2 = c00872.L$1;
            youTubeClient2 = c00872.L$0;
            ResultKt.throwOnFailure(objExecuteMutation);
            sessionSnapshot = sessionSnapshot3;
        } else {
            if (i2 == 2) {
                String str6 = c00872.L$5;
                HttpResponse httpResponse3 = c00872.L$4;
                SessionSnapshot sessionSnapshot4 = c00872.L$3;
                bArr2 = c00872.L$2;
                str4 = c00872.L$1;
                YouTubeClient youTubeClient5 = c00872.L$0;
                ResultKt.throwOnFailure(objExecuteMutation);
                httpResponse = httpResponse3;
                str3 = str6;
                youTubeClient3 = youTubeClient5;
                sessionSnapshot = sessionSnapshot4;
                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(httpResponse.getStatus().getValue(), "Playlist thumbnail upload session start failed with HTTP "));
                    return obj;
                }
                if (str3 != null || StringsKt.isBlank(str3)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Missing playlist thumbnail upload ID");
                    return obj;
                }
                r8 = 0;
                Function2 realImageLoader$execute$result$1 = new RealImageLoader$execute$result$1(this, youTubeClient3, str3, bArr2, null, (byte) 10);
                c00872.L$0 = youTubeClient3;
                c00872.L$1 = str4;
                c00872.L$2 = null;
                c00872.L$3 = sessionSnapshot;
                c00872.L$4 = null;
                c00872.L$5 = null;
                c00872.label = 3;
                objExecuteMutation = executeMutation("setPlaylistThumbnail:upload", sessionSnapshot, realImageLoader$execute$result$1, c00872);
                if (objExecuteMutation != obj2) {
                    youTubeClient4 = youTubeClient3;
                    str5 = str4;
                    sessionSnapshot2 = sessionSnapshot;
                    httpResponse2 = (HttpResponse) objExecuteMutation;
                    c00872.L$0 = youTubeClient4;
                    c00872.L$1 = str5;
                    c00872.L$2 = r8;
                    c00872.L$3 = sessionSnapshot2;
                    c00872.L$4 = r8;
                    c00872.L$5 = r8;
                    c00872.L$6 = httpResponse2;
                    c00872.label = 4;
                    objExecuteMutation = CollectionsKt__IterablesKt.bodyAsTextLimited(httpResponse2, 65536, r8, c00872);
                    r9 = r8;
                    if (objExecuteMutation != obj2) {
                    }
                }
            }
            if (i2 == 3) {
                SessionSnapshot sessionSnapshot5 = c00872.L$3;
                String str7 = c00872.L$1;
                YouTubeClient youTubeClient6 = c00872.L$0;
                ResultKt.throwOnFailure(objExecuteMutation);
                youTubeClient4 = youTubeClient6;
                obj = null;
                str5 = str7;
                r8 = 0;
                sessionSnapshot2 = sessionSnapshot5;
                httpResponse2 = (HttpResponse) objExecuteMutation;
                c00872.L$0 = youTubeClient4;
                c00872.L$1 = str5;
                c00872.L$2 = r8;
                c00872.L$3 = sessionSnapshot2;
                c00872.L$4 = r8;
                c00872.L$5 = r8;
                c00872.L$6 = httpResponse2;
                c00872.label = 4;
                objExecuteMutation = CollectionsKt__IterablesKt.bodyAsTextLimited(httpResponse2, 65536, r8, c00872);
                r9 = r8;
                if (objExecuteMutation != obj2) {
                }
            }
            if (i2 != 4) {
                if (i2 == 5) {
                    ResultKt.throwOnFailure(objExecuteMutation);
                    return objExecuteMutation;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            httpResponse2 = c00872.L$6;
            sessionSnapshot2 = c00872.L$3;
            str5 = c00872.L$1;
            youTubeClient4 = c00872.L$0;
            ResultKt.throwOnFailure(objExecuteMutation);
            obj = null;
            r9 = 0;
        }
        SessionSnapshot sessionSnapshot6 = sessionSnapshot2;
        String str8 = str5;
        String str9 = (String) objExecuteMutation;
        if (!HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(httpResponse2.getStatus().getValue(), "Playlist thumbnail upload failed with HTTP "));
            return obj;
        }
        Json.Default r2 = Json.Default;
        r2.getClass();
        Function2 innerTube$addToPlaylist$2 = new InnerTube$addToPlaylist$2(this, youTubeClient4, str8, ((ImageUploadResponse) r2.decodeFromString(ImageUploadResponse.INSTANCE.serializer(), str9)).encryptedBlobId, null, (byte) 2);
        c00872.L$0 = r9;
        c00872.L$1 = r9;
        c00872.L$2 = r9;
        c00872.L$3 = r9;
        c00872.L$4 = r9;
        c00872.L$5 = r9;
        c00872.L$6 = r9;
        c00872.label = 5;
        Object objExecuteMutation2 = executeMutation("setPlaylistThumbnail:apply", sessionSnapshot6, innerTube$addToPlaylist$2, c00872);
        return objExecuteMutation2 == obj2 ? obj2 : objExecuteMutation2;
        httpResponse = (HttpResponse) objExecuteMutation;
        String str10 = httpResponse.getHeaders().get("X-Goog-Upload-Id");
        if (str10 == null) {
            str10 = httpResponse.getHeaders().get("X-Guploader-Uploadid");
        }
        c00872.L$0 = youTubeClient2;
        c00872.L$1 = str2;
        c00872.L$2 = bArr3;
        c00872.L$3 = sessionSnapshot;
        c00872.L$4 = httpResponse;
        c00872.L$5 = str10;
        c00872.label = 2;
        if (CollectionsKt__IterablesKt.bodyAsTextLimited(httpResponse, 65536, null, c00872) != obj2) {
            bArr2 = bArr3;
            str3 = str10;
            youTubeClient3 = youTubeClient2;
            str4 = str2;
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(httpResponse.getStatus().getValue(), "Playlist thumbnail upload session start failed with HTTP "));
                return obj;
            }
            if (str3 != null) {
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Missing playlist thumbnail upload ID");
            return obj;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b4 A[EDGE_INSN: B:70:0x00b4->B:48:0x00b4 BREAK  A[LOOP:0: B:39:0x0096->B:73:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:? A[LOOP:0: B:39:0x0096->B:73:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[LOOP:1: B:42:0x00a6->B:74:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00db A[EDGE_INSN: B:75:0x00db->B:61:0x00db BREAK  A[LOOP:2: B:53:0x00be->B:78:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00db A[EDGE_INSN: B:76:0x00db->B:61:0x00db BREAK  A[LOOP:2: B:53:0x00be->B:78:?, LOOP_LABEL: LOOP:2: B:53:0x00be->B:78:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object withSessionBoundRequest(SessionSnapshot sessionSnapshot, Function1 function1, Continuation continuation) throws Throwable {
        C00881 c00881;
        SessionBoundRequest sessionBoundRequest;
        List list;
        ArrayList arrayListMinus;
        List list2;
        ArrayList arrayListMinus2;
        if (continuation instanceof C00881) {
            c00881 = (C00881) continuation;
            int i = c00881.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00881.label = i - Integer.MIN_VALUE;
            } else {
                c00881 = new C00881(continuation);
            }
        } else {
            c00881 = new C00881(continuation);
        }
        Object objInvoke = c00881.result;
        int i2 = c00881.label;
        AtomicReference atomicReference = this.sessionBoundRequests;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objInvoke);
                return objInvoke;
            }
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            sessionBoundRequest = c00881.L$3;
            try {
                ResultKt.throwOnFailure(objInvoke);
                loop0: while (true) {
                    list2 = (List) atomicReference.get();
                    if (list2.contains(sessionBoundRequest)) {
                        break;
                    }
                    arrayListMinus2 = CollectionsKt.minus(list2, sessionBoundRequest);
                    while (!atomicReference.compareAndSet(list2, arrayListMinus2)) {
                        if (atomicReference.get() != list2) {
                        }
                    }
                    break loop0;
                }
                return objInvoke;
            } catch (Throwable th) {
                th = th;
                loop2: while (true) {
                    list = (List) atomicReference.get();
                    if (list.contains(sessionBoundRequest)) {
                        break;
                    }
                    arrayListMinus = CollectionsKt.minus(list, sessionBoundRequest);
                    do {
                        if (!atomicReference.compareAndSet(list, arrayListMinus)) {
                            break loop2;
                        }
                    } while (atomicReference.get() == list);
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(objInvoke);
        Job job = (Job) c00881.getContext().get(Job.Key.$$INSTANCE);
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (job != null) {
            SessionBoundRequest sessionBoundRequest2 = new SessionBoundRequest(sessionSnapshot, job);
            long j = sessionSnapshot.generation;
            loop4: while (true) {
                AtomicReference atomicReference2 = this.session;
                if (((SessionSnapshot) atomicReference2.get()).generation != j) {
                    throw new CancellationException("InnerTube session changed");
                }
                List list3 = (List) atomicReference.get();
                ArrayList arrayListPlus = CollectionsKt.plus(sessionBoundRequest2, list3);
                do {
                    if (atomicReference.compareAndSet(list3, arrayListPlus)) {
                        try {
                            if (((SessionSnapshot) atomicReference2.get()).generation != j) {
                                throw new CancellationException("InnerTube session changed");
                            }
                            c00881.L$3 = sessionBoundRequest2;
                            c00881.label = 2;
                            objInvoke = function1.invoke(c00881);
                            if (objInvoke != obj) {
                                sessionBoundRequest = sessionBoundRequest2;
                                break loop4;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            sessionBoundRequest = sessionBoundRequest2;
                            loop2: while (true) {
                                list = (List) atomicReference.get();
                                if (list.contains(sessionBoundRequest)) {
                                    break;
                                    break;
                                }
                                arrayListMinus = CollectionsKt.minus(list, sessionBoundRequest);
                                do {
                                    if (!atomicReference.compareAndSet(list, arrayListMinus)) {
                                        break loop2;
                                        break loop2;
                                    }
                                } while (atomicReference.get() == list);
                            }
                            throw th;
                        }
                    }
                } while (atomicReference.get() == list3);
            }
            loop0: while (true) {
                list2 = (List) atomicReference.get();
                if (list2.contains(sessionBoundRequest)) {
                    break;
                    break;
                }
                arrayListMinus2 = CollectionsKt.minus(list2, sessionBoundRequest);
                while (!atomicReference.compareAndSet(list2, arrayListMinus2)) {
                    if (atomicReference.get() != list2) {
                    }
                }
                break loop0;
                break loop0;
            }
            return objInvoke;
        }
        c00881.label = 1;
        Object objInvoke2 = function1.invoke(c00881);
        if (objInvoke2 != obj) {
            return objInvoke2;
        }
        return obj;
    }
}
