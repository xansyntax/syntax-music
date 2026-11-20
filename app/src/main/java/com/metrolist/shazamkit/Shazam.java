package com.metrolist.shazamkit;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.shazamkit.models.RecognitionResult;
import com.metrolist.shazamkit.models.ShazamRequestJson;
import com.metrolist.shazamkit.models.ShazamResponseJson;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Shazam {
    public static long lastRequestTime;
    public static final Shazam INSTANCE = new Shazam();
    public static final MutexImpl requestMutex = new MutexImpl();
    public static final ConcurrentHashMap resultCache = new ConcurrentHashMap();
    public static final SynchronizedLazyImpl client$delegate = new SynchronizedLazyImpl(new Shazam$$ExternalSyntheticLambda0(0));
    public static final List userAgents = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"Dalvik/2.1.0 (Linux; U; Android 5.0.2; VS980 4G Build/LRX22G)", "Dalvik/1.6.0 (Linux; U; Android 4.4.2; SM-T210 Build/KOT49H)", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; SM-P905V Build/LMY47X)", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; SM-G920F Build/MMB29K)", "Dalvik/2.1.0 (Linux; U; Android 5.0; SM-G900F Build/LRX21T)"});
    public static final List timezones = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"Europe/Paris", "Europe/London", "America/New_York", "America/Los_Angeles", "Asia/Tokyo", "Asia/Dubai"});

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CachedResult {
        public final RecognitionResult result;
        public final long timestamp;

        public CachedResult(long j, RecognitionResult recognitionResult) {
            recognitionResult.getClass();
            this.timestamp = j;
            this.result = recognitionResult;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CachedResult)) {
                return false;
            }
            CachedResult cachedResult = (CachedResult) obj;
            return this.timestamp == cachedResult.timestamp && Intrinsics.areEqual(this.result, cachedResult.result);
        }

        public final int hashCode() {
            return this.result.hashCode() + (Long.hashCode(this.timestamp) * 31);
        }

        public final String toString() {
            return "CachedResult(timestamp=" + this.timestamp + ", result=" + this.result + ")";
        }
    }

    /* JADX INFO: renamed from: com.metrolist.shazamkit.Shazam$enforceRateLimit$1, reason: invalid class name */
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
            return Shazam.this.enforceRateLimit(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.shazamkit.Shazam$executeRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02261 extends ContinuationImpl {
        public int I$0;
        public long J$0;
        public String L$0;
        public Exception L$1;
        public int label;
        public /* synthetic */ Object result;

        public C02261(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Shazam.this.executeRequest(0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.shazamkit.Shazam$performRecognition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02271 extends ContinuationImpl {
        public long J$0;
        public long J$1;
        public int label;
        public /* synthetic */ Object result;

        public C02271(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Shazam.this.performRecognition(0L, null, this);
        }
    }

    public static void cacheResult(String str, RecognitionResult recognitionResult) {
        CachedResult cachedResult = new CachedResult(System.currentTimeMillis(), recognitionResult);
        ConcurrentHashMap concurrentHashMap = resultCache;
        concurrentHashMap.put(str, cachedResult);
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("ShazamApi");
        ConnectionPool.d(str, Integer.valueOf(concurrentHashMap.size()));
        if (concurrentHashMap.size() < 100) {
            return;
        }
        connectionPool.tag("ShazamApi");
        ConnectionPool.d(Integer.valueOf(concurrentHashMap.size()));
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            if (jCurrentTimeMillis - ((CachedResult) ((Map.Entry) next).getValue()).timestamp > 300000) {
                it.remove();
            }
        }
    }

    public static RecognitionResult getCachedResult(String str) {
        ConcurrentHashMap concurrentHashMap = resultCache;
        CachedResult cachedResult = (CachedResult) concurrentHashMap.get(str);
        if (cachedResult == null) {
            return null;
        }
        if (System.currentTimeMillis() - cachedResult.timestamp <= 300000) {
            return cachedResult.result;
        }
        concurrentHashMap.remove(str);
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object enforceRateLimit(ContinuationImpl continuationImpl) {
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
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            long jCurrentTimeMillis = System.currentTimeMillis() - lastRequestTime;
            if (jCurrentTimeMillis < 1000) {
                anonymousClass1.label = 1;
                Object objDelay = AwaitKt.delay(1000 - jCurrentTimeMillis, anonymousClass1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDelay == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        lastRequestTime = System.currentTimeMillis();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:60|26|(3:29|30|(1:32))|49) */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0098  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:51:0x0137  */
    /* JADX WARN: Code duplicated, block: B:54:0x0146 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x0149  */
    /* JADX WARN: Code duplicated, block: B:60:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        r14 = r11;
        r18 = r13;
        r13 = r0;
        r19 = r2;
        r2 = r12;
        r11 = r19;
        r3 = r18;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012b, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(r7, r2) == r10) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.metrolist.shazamkit.Shazam] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x012b -> B:50:0x012e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0137 -> B:50:0x012e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeRequest(long j, String str, ContinuationImpl continuationImpl) throws Exception {
        C02261 c02261;
        String str2;
        Exception exc;
        long j2;
        String message;
        ?? r17;
        int i;
        String str3;
        int i2;
        C02261 c02262;
        String str4;
        long j3;
        Exception exc2;
        if (continuationImpl instanceof C02261) {
            c02261 = (C02261) continuationImpl;
            int i3 = c02261.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c02261.label = i3 - Integer.MIN_VALUE;
            } else {
                c02261 = new C02261(continuationImpl);
            }
        } else {
            c02261 = new C02261(continuationImpl);
        }
        Object objPerformRecognition = c02261.result;
        int i4 = c02261.label;
        boolean z = false;
        int i5 = 3;
        int i6 = 2;
        Exception exc3 = null;
        ?? r9 = 1;
        r9 = 1;
        ?? r10 = 1;
        ?? r11 = 1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(objPerformRecognition);
                str4 = str;
                c02262 = c02261;
                i2 = 0;
                exc2 = null;
                j3 = j;
                if (i2 < i5) {
                    if (exc2 != null) {
                        throw exc2;
                    }
                    throw new Exception("Recognition failed after 3 attempts");
                }
                c02262.L$0 = str4;
                c02262.L$1 = exc3;
                c02262.J$0 = j3;
                c02262.I$0 = i2;
                c02262.label = r11 == true ? 1 : 0;
                if (enforceRateLimit(c02262) != coroutineSingletons) {
                    int i7 = i2;
                    str3 = str4;
                    long j4 = j3;
                    c02261 = c02262;
                    j2 = j4;
                    i4 = i7;
                    r10 = r11;
                    c02261.L$0 = str3;
                    c02261.L$1 = exc3;
                    c02261.J$0 = j2;
                    c02261.I$0 = i4;
                    c02261.label = i6;
                    objPerformRecognition = performRecognition(j2, str3, c02261);
                    r9 = r10;
                    if (objPerformRecognition == coroutineSingletons) {
                    }
                }
                return coroutineSingletons;
            }
            if (i4 == 1) {
                i4 = c02261.I$0;
                j2 = c02261.J$0;
                str3 = c02261.L$0;
                ResultKt.throwOnFailure(objPerformRecognition);
                c02261.L$0 = str3;
                c02261.L$1 = exc3;
                c02261.J$0 = j2;
                c02261.I$0 = i4;
                c02261.label = i6;
                objPerformRecognition = performRecognition(j2, str3, c02261);
                r9 = r10;
                if (objPerformRecognition == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i4 != 2) {
                    if (i4 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i4 = c02261.I$0;
                    j2 = c02261.J$0;
                    exc = c02261.L$1;
                    str2 = c02261.L$0;
                    ResultKt.throwOnFailure(objPerformRecognition);
                    r17 = 1;
                    i = 3;
                    exc2 = exc;
                    c02262 = c02261;
                    j3 = j2;
                    str4 = str2;
                    i2 = i4 + 1;
                    i5 = i;
                    r11 = r17;
                    z = false;
                    i6 = 2;
                    exc3 = null;
                    if (i2 < i5) {
                        if (exc2 != null) {
                            throw exc2;
                        }
                        throw new Exception("Recognition failed after 3 attempts");
                    }
                    c02262.L$0 = str4;
                    c02262.L$1 = exc3;
                    c02262.J$0 = j3;
                    c02262.I$0 = i2;
                    c02262.label = r11 == true ? 1 : 0;
                    if (enforceRateLimit(c02262) != coroutineSingletons) {
                        int i8 = i2;
                        str3 = str4;
                        long j5 = j3;
                        c02261 = c02262;
                        j2 = j5;
                        i4 = i8;
                        r10 = r11;
                        c02261.L$0 = str3;
                        c02261.L$1 = exc3;
                        c02261.J$0 = j2;
                        c02261.I$0 = i4;
                        c02261.label = i6;
                        objPerformRecognition = performRecognition(j2, str3, c02261);
                        r9 = r10;
                        if (objPerformRecognition == coroutineSingletons) {
                        }
                    }
                    return coroutineSingletons;
                }
                i4 = c02261.I$0;
                j2 = c02261.J$0;
                str3 = c02261.L$0;
                ResultKt.throwOnFailure(objPerformRecognition);
            }
        } catch (Exception e) {
            str2 = str3;
            exc = e;
            ?? r12 = r9;
            ConnectionPool connectionPool = Timber.Forest;
            connectionPool.tag("ShazamApi");
            ConnectionPool.w$1(new Integer(i4 + 1), new Integer(i5), exc.getMessage());
            String message2 = exc.getMessage();
            if (!(message2 == null && StringsKt.contains(message2, "429", z) == r12) && ((message = exc.getMessage()) == null || StringsKt.contains(message, "Too many requests", r12) != r12)) {
                throw exc;
            }
            if (i4 < i6) {
                long j6 = ((long) (r12 << i4)) * 2000;
                connectionPool.tag("ShazamApi");
                r17 = r12;
                i = 3;
                ConnectionPool.d(new Long(j6), new Integer(i4 + 2), new Integer(3));
                c02261.L$0 = str2;
                c02261.L$1 = exc;
                c02261.J$0 = j2;
                c02261.I$0 = i4;
                c02261.label = 3;
            } else {
                r17 = r12;
                i = 3;
            }
        }
        Timber.Forest.tag("ShazamApi");
        ConnectionPool.d(new Integer(i4 + 1));
        return objPerformRecognition;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:120:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:159:0x037d  */
    /* JADX WARN: Code duplicated, block: B:198:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code duplicated, block: B:88:0x0296  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0204, code lost:
    
        if (r0 == r2) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.metrolist.shazamkit.models.ShazamResponseJson$Track$Hub$Option$OptionAction] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.metrolist.shazamkit.models.ShazamResponseJson$Track$Hub$Option$OptionAction] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.metrolist.shazamkit.models.ShazamResponseJson$Track$Hub$Provider] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [com.metrolist.shazamkit.models.ShazamResponseJson$Track$Section] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17, types: [com.metrolist.shazamkit.models.ShazamResponseJson$Track$Section] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v55 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v57 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performRecognition(long j, String str, ContinuationImpl continuationImpl) throws Exception {
        C02271 c02271;
        TypeReference typeReference;
        long j2;
        TypeReference typeReferenceTypeOf;
        long j3;
        CoroutineSingletons coroutineSingletons;
        TypeReference typeReferenceTypeOf2;
        ?? r7;
        ?? r2;
        ?? text;
        ?? text2;
        ?? text3;
        ?? r8;
        ?? r3;
        Object obj;
        ?? r4;
        ?? r23;
        Object recognitionResult;
        List<ShazamResponseJson.Track.Hub.Provider.ProviderAction> actions;
        ShazamResponseJson.Track.Hub.Provider.ProviderAction providerAction;
        String uri;
        ?? SubstringAfterLast;
        List<ShazamResponseJson.Track.Hub.Option> options;
        Object next;
        List<ShazamResponseJson.Track.Hub.Option.OptionAction> actions2;
        ShazamResponseJson.Track.Hub.Option.OptionAction optionAction;
        String type;
        List<ShazamResponseJson.Track.Hub.Provider> providers;
        Object next2;
        String caption;
        List<ShazamResponseJson.Track.Hub.Option> options2;
        Object next3;
        List<ShazamResponseJson.Track.Hub.Option.OptionAction> actions3;
        String providername;
        Object next4;
        ShazamResponseJson.Track.Section section;
        Object next5;
        ShazamResponseJson.Track.Section.Metadata metadata;
        Object next6;
        ShazamResponseJson.Track.Section.Metadata metadata2;
        Object next7;
        ShazamResponseJson.Track.Section.Metadata metadata3;
        List<ShazamResponseJson.Track.Section.Metadata> metadata4;
        Object next8;
        ShazamResponseJson.Track.Section section2;
        if (continuationImpl instanceof C02271) {
            c02271 = (C02271) continuationImpl;
            int i = c02271.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02271.label = i - Integer.MIN_VALUE;
            } else {
                c02271 = new C02271(continuationImpl);
            }
        } else {
            c02271 = new C02271(continuationImpl);
        }
        Object objExecute = c02271.result;
        int i2 = c02271.label;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            typeReference = null;
            ResultKt.throwOnFailure(objExecute);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String string = UUID.randomUUID().toString();
            string.getClass();
            String upperCase = string.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            String string2 = UUID.randomUUID().toString();
            string2.getClass();
            AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
            AbstractPlatformRandom abstractPlatformRandom2 = Random.defaultRandom;
            ShazamRequestJson shazamRequestJson = new ShazamRequestJson(new ShazamRequestJson.Geolocation((abstractPlatformRandom2.getImpl().nextDouble() * 400.0d) + 100.0d, (abstractPlatformRandom2.getImpl().nextDouble() * 180.0d) - 90.0d, (abstractPlatformRandom2.getImpl().nextDouble() * 360.0d) - 180.0d), new ShazamRequestJson.Signature(j, jCurrentTimeMillis, str), jCurrentTimeMillis, (String) CollectionsKt.random(timezones));
            j2 = jCurrentTimeMillis;
            Timber.Forest.tag("ShazamApi");
            ConnectionPool.d(new Object[0]);
            HttpClient httpClient = (HttpClient) client$delegate.getValue();
            String str2 = "https://amp.shazam.com/discovery/v5/en/US/android/-/tag/" + upperCase + "/" + string2;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpRequestKt.url(httpRequestBuilder, str2);
            UtilsKt.parameter(httpRequestBuilder, "sync", "true");
            UtilsKt.parameter(httpRequestBuilder, "webv3", "true");
            UtilsKt.parameter(httpRequestBuilder, "sampling", "true");
            UtilsKt.parameter(httpRequestBuilder, "connected", "");
            UtilsKt.parameter(httpRequestBuilder, "shazamapiversion", "v3");
            UtilsKt.parameter(httpRequestBuilder, "sharehub", "true");
            UtilsKt.parameter(httpRequestBuilder, ContentType.Video.TYPE, "v3");
            UtilsKt.header(httpRequestBuilder, HttpHeaders.UserAgent, CollectionsKt.random(userAgents));
            UtilsKt.header(httpRequestBuilder, HttpHeaders.ContentLanguage, "en_US");
            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
            httpRequestBuilder.setBody(shazamRequestJson);
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ShazamRequestJson.class);
            try {
                typeReferenceTypeOf = Reflection.typeOf(ShazamRequestJson.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
            HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
            j3 = j;
            c02271.J$0 = j3;
            c02271.J$1 = j2;
            c02271.label = 1;
            objExecute = httpStatementM.execute(c02271);
            coroutineSingletons = coroutineSingletons2;
            if (objExecute != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            j2 = c02271.J$1;
            typeReference = null;
            j3 = c02271.J$0;
            ResultKt.throwOnFailure(objExecute);
            coroutineSingletons = coroutineSingletons2;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objExecute);
            typeReference = null;
        }
        if (objExecute == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type com.metrolist.shazamkit.models.ShazamResponseJson");
            return typeReference;
        }
        ShazamResponseJson shazamResponseJson = (ShazamResponseJson) objExecute;
        Timber.Forest.tag("ShazamApi");
        ConnectionPool.d(Boolean.valueOf(shazamResponseJson.getTrack() != null));
        ShazamResponseJson.Track track = shazamResponseJson.getTrack();
        if (track == null) {
            recognitionResult = typeReference;
        } else {
            List<ShazamResponseJson.Track.Section> sections = track.getSections();
            if (sections != null) {
                Iterator it = sections.iterator();
                do {
                    if (!it.hasNext()) {
                        next8 = typeReference;
                        break;
                    }
                    next8 = it.next();
                    section2 = (ShazamResponseJson.Track.Section) next8;
                } while (!Intrinsics.areEqual(section2 != null ? section2.getType() : typeReference, "SONG"));
                r7 = (ShazamResponseJson.Track.Section) next8;
            } else {
                r7 = typeReference;
            }
            if (r7 != 0) {
                metadata4 = r7.getMetadata();
            } else {
                r2 = typeReference;
            }
            if (r2 != 0) {
                r2 = metadata4;
                Iterator it2 = r2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next7 = typeReference;
                        break;
                    }
                    next7 = it2.next();
                    metadata3 = (ShazamResponseJson.Track.Section.Metadata) next7;
                } while (!Intrinsics.areEqual(metadata3 != null ? metadata3.getTitle() : typeReference, "Album"));
                ShazamResponseJson.Track.Section.Metadata metadata5 = (ShazamResponseJson.Track.Section.Metadata) next7;
                if (metadata5 != null) {
                    text = metadata5.getText();
                } else {
                    r2 = metadata4;
                    text = typeReference;
                }
            } else {
                r2 = metadata4;
                text = typeReference;
            }
            if (r2 != 0) {
                Iterator it3 = r2.iterator();
                do {
                    if (!it3.hasNext()) {
                        next6 = typeReference;
                        break;
                    }
                    next6 = it3.next();
                    metadata2 = (ShazamResponseJson.Track.Section.Metadata) next6;
                } while (!Intrinsics.areEqual(metadata2 != null ? metadata2.getTitle() : typeReference, "Label"));
                ShazamResponseJson.Track.Section.Metadata metadata6 = (ShazamResponseJson.Track.Section.Metadata) next6;
                if (metadata6 != null) {
                    text2 = metadata6.getText();
                } else {
                    text2 = typeReference;
                }
            } else {
                text2 = typeReference;
            }
            if (r2 != 0) {
                Iterator it4 = r2.iterator();
                do {
                    if (!it4.hasNext()) {
                        next5 = typeReference;
                        break;
                    }
                    next5 = it4.next();
                    metadata = (ShazamResponseJson.Track.Section.Metadata) next5;
                } while (!Intrinsics.areEqual(metadata != null ? metadata.getTitle() : typeReference, "Released"));
                ShazamResponseJson.Track.Section.Metadata metadata7 = (ShazamResponseJson.Track.Section.Metadata) next5;
                if (metadata7 != null) {
                    text3 = metadata7.getText();
                } else {
                    text3 = typeReference;
                }
            } else {
                text3 = typeReference;
            }
            List<ShazamResponseJson.Track.Section> sections2 = track.getSections();
            if (sections2 != null) {
                Iterator it5 = sections2.iterator();
                do {
                    if (!it5.hasNext()) {
                        next4 = typeReference;
                        break;
                    }
                    next4 = it5.next();
                    section = (ShazamResponseJson.Track.Section) next4;
                } while (!Intrinsics.areEqual(section != null ? section.getType() : typeReference, "LYRICS"));
                r8 = (ShazamResponseJson.Track.Section) next4;
            } else {
                r8 = typeReference;
            }
            ?? text4 = r8 != 0 ? r8.getText() : typeReference;
            ShazamResponseJson.Track.Hub hub = track.getHub();
            if (hub == null || (options2 = hub.getOptions()) == null) {
                r3 = typeReference;
            } else {
                Iterator it6 = options2.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        next3 = typeReference;
                        break;
                    }
                    next3 = it6.next();
                    ShazamResponseJson.Track.Hub.Option option = (ShazamResponseJson.Track.Hub.Option) next3;
                    if (option != null && (providername = option.getProvidername()) != null && StringsKt.contains(providername, "apple", true)) {
                        break;
                    }
                }
                ShazamResponseJson.Track.Hub.Option option2 = (ShazamResponseJson.Track.Hub.Option) next3;
                if (option2 == null || (actions3 = option2.getActions()) == null) {
                    r3 = typeReference;
                } else {
                    r3 = (ShazamResponseJson.Track.Hub.Option.OptionAction) CollectionsKt.firstOrNull((List) actions3);
                }
            }
            ShazamResponseJson.Track.Hub hub2 = track.getHub();
            if (hub2 == null || (providers = hub2.getProviders()) == null) {
                obj = typeReference;
            } else {
                Iterator it7 = providers.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        next2 = typeReference;
                        break;
                    }
                    next2 = it7.next();
                    ShazamResponseJson.Track.Hub.Provider provider = (ShazamResponseJson.Track.Hub.Provider) next2;
                    if (provider != null && (caption = provider.getCaption()) != null && StringsKt.contains(caption, "spotify", true)) {
                        break;
                    }
                }
                obj = (ShazamResponseJson.Track.Hub.Provider) next2;
            }
            ShazamResponseJson.Track.Hub hub3 = track.getHub();
            if (hub3 == null || (options = hub3.getOptions()) == null) {
                r4 = typeReference;
            } else {
                Iterator it8 = options.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        next = typeReference;
                        break;
                    }
                    next = it8.next();
                    ShazamResponseJson.Track.Hub.Option option3 = (ShazamResponseJson.Track.Hub.Option) next;
                    if (option3 != null && (type = option3.getType()) != null) {
                        if (StringsKt.contains(type, ContentType.Video.TYPE, true)) {
                            break;
                        }
                    }
                }
                ShazamResponseJson.Track.Hub.Option option4 = (ShazamResponseJson.Track.Hub.Option) next;
                if (option4 == null || (actions2 = option4.getActions()) == null) {
                    r4 = typeReference;
                } else {
                    optionAction = (ShazamResponseJson.Track.Hub.Option.OptionAction) CollectionsKt.firstOrNull((List) actions2);
                }
            }
            if (r4 == 0 || (uri = r4.getUri()) == null) {
                r4 = optionAction;
                r4 = optionAction;
                r23 = typeReference;
            } else {
                String strSubstringAfterLast = StringsKt.substringAfterLast(uri, "v=", "");
                if (strSubstringAfterLast.length() <= 0) {
                    r4 = optionAction;
                    SubstringAfterLast = strSubstringAfterLast;
                    SubstringAfterLast = typeReference;
                }
                if (SubstringAfterLast == 0) {
                    SubstringAfterLast = StringsKt.substringAfterLast(uri, "/", "");
                    if (SubstringAfterLast.length() <= 0 || SubstringAfterLast.length() != 11) {
                        SubstringAfterLast = typeReference;
                    }
                }
                r23 = SubstringAfterLast;
            }
            ?? r5 = obj;
            String key = track.getKey();
            String str3 = (key == null && (key = shazamResponseJson.getTagid()) == null) ? "" : key;
            String title = track.getTitle();
            String str4 = title == null ? "" : title;
            String subtitle = track.getSubtitle();
            String str5 = subtitle == null ? "" : subtitle;
            ShazamResponseJson.Track.Images images = track.getImages();
            ?? coverart = images != null ? images.getCoverart() : typeReference;
            ShazamResponseJson.Track.Images images2 = track.getImages();
            ?? coverarthq = images2 != null ? images2.getCoverarthq() : typeReference;
            ShazamResponseJson.Track.Genres genres = track.getGenres();
            recognitionResult = new RecognitionResult(str3, str4, str5, text, coverart, coverarthq, genres != null ? genres.getPrimary() : typeReference, text3, text2, text4, track.getUrl(), r3 != 0 ? r3.getUri() : typeReference, (r5 == 0 || (actions = r5.getActions()) == null || (providerAction = (ShazamResponseJson.Track.Hub.Provider.ProviderAction) CollectionsKt.firstOrNull((List) actions)) == null) ? typeReference : providerAction.getUri(), track.getIsrc(), r23);
        }
        if (recognitionResult != null) {
            return recognitionResult;
        }
        throw new Exception("No match found");
        HttpResponse httpResponse = (HttpResponse) objExecute;
        if (!HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
            int value = httpResponse.getStatus().getValue();
            Timber.Forest.tag("ShazamApi");
            ConnectionPool.w(new Integer(value));
            if (value == 429) {
                throw new Exception("Too many requests");
            }
            if (value == 404) {
                throw new Exception("No match found");
            }
            if (500 > value || value >= 600) {
                throw new Exception(IntIntPair$$ExternalSyntheticOutline0.m(value, "Recognition failed (error ", ")"));
            }
            throw new Exception("Shazam service temporarily unavailable");
        }
        HttpClientCall call = httpResponse.getCall();
        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ShazamResponseJson.class);
        try {
            typeReferenceTypeOf2 = Reflection.typeOf(ShazamResponseJson.class);
        } catch (Throwable unused2) {
            typeReferenceTypeOf2 = typeReference;
        }
        TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf2);
        c02271.J$0 = j3;
        c02271.J$1 = j2;
        c02271.label = 2;
        objExecute = call.bodyNullable(typeInfo, c02271);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.metrolist.shazamkit.Shazam] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [long] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v6 */
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
    /* JADX INFO: renamed from: recognize-0E7RQCE, reason: not valid java name */
    public final Object m1533recognize0E7RQCE(long j, String str, ContinuationImpl continuationImpl) {
        Shazam$recognize$1 shazam$recognize$1;
        String strValueOf;
        String str2;
        ?? r10;
        Mutex mutex;
        RecognitionResult cachedResult;
        String str3;
        ?? r9;
        ?? r0 = INSTANCE;
        if (continuationImpl instanceof Shazam$recognize$1) {
            shazam$recognize$1 = (Shazam$recognize$1) continuationImpl;
            int i = shazam$recognize$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                shazam$recognize$1.label = i - Integer.MIN_VALUE;
            } else {
                shazam$recognize$1 = new Shazam$recognize$1(this, continuationImpl);
            }
        } else {
            shazam$recognize$1 = new Shazam$recognize$1(this, continuationImpl);
        }
        Object obj = shazam$recognize$1.result;
        int i2 = shazam$recognize$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    strValueOf = String.valueOf(str.hashCode());
                    RecognitionResult cachedResult2 = getCachedResult(strValueOf);
                    if (cachedResult2 != null) {
                        return cachedResult2;
                    }
                    MutexImpl mutexImpl = requestMutex;
                    shazam$recognize$1.L$0 = str;
                    shazam$recognize$1.L$1 = strValueOf;
                    shazam$recognize$1.L$2 = mutexImpl;
                    shazam$recognize$1.J$0 = j;
                    shazam$recognize$1.label = 1;
                    if (mutexImpl.lock(shazam$recognize$1) != coroutineSingletons) {
                        str2 = str;
                        r10 = j;
                        mutex = mutexImpl;
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    long j2 = shazam$recognize$1.J$0;
                    Mutex mutex2 = shazam$recognize$1.L$2;
                    String str4 = shazam$recognize$1.L$1;
                    str2 = shazam$recognize$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex2;
                    r10 = j2;
                    strValueOf = str4;
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Mutex mutex3 = shazam$recognize$1.L$2;
                    str3 = shazam$recognize$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    j = mutex3;
                }
                cacheResult(str3, (RecognitionResult) obj);
                cachedResult = (RecognitionResult) obj;
                r9 = j;
                r9.unlock(null);
                return cachedResult;
                cachedResult = getCachedResult(strValueOf);
                r9 = mutex;
                if (cachedResult == null) {
                    shazam$recognize$1.L$0 = null;
                    shazam$recognize$1.L$1 = strValueOf;
                    shazam$recognize$1.L$2 = mutex;
                    shazam$recognize$1.J$0 = r10;
                    shazam$recognize$1.label = 2;
                    Object objExecuteRequest = r0.executeRequest(r10, str2, shazam$recognize$1);
                    if (objExecuteRequest != coroutineSingletons) {
                        str3 = strValueOf;
                        obj = objExecuteRequest;
                        j = mutex;
                        cacheResult(str3, (RecognitionResult) obj);
                        cachedResult = (RecognitionResult) obj;
                        r9 = j;
                    }
                    return coroutineSingletons;
                }
                r9.unlock(null);
                return cachedResult;
            } catch (Throwable th) {
                j.unlock(null);
                throw th;
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            return new Result.Failure(e2);
        }
    }
}
