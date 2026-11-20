package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.cache.storage.CacheStorage;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.KtorDsl;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.RegexKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 +2\u00020\u0001:\u0002,+B9\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J.\u0010\u001b\u001a\u0004\u0018\u00010\u0012*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0082@¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\u0004\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b&\u0010%R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010'R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010'R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010(R\u001a\u0010\n\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache;", "", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "publicStorage", "privateStorage", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "publicStorageNew", "privateStorageNew", "", "useOldStorage", "isSharedClient", "<init>", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;ZZ)V", "", "clearAllCaches", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "cacheResponse", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequest;", "request", "findAndRefresh", "(Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "url", "selectResponseToUpdate", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Lio/ktor/http/Url;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "Lio/ktor/http/content/OutgoingContent;", "content", "findResponse", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage$ktor_client_core", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPrivateStorage$ktor_client_core", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Z", "isSharedClient$ktor_client_core", "()Z", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpCache {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final EventDefinition<HttpResponse> HttpResponseFromCache;
    private static final AttributeKey<HttpCache> key;
    private final boolean isSharedClient;
    private final HttpCacheStorage privateStorage;
    private final CacheStorage privateStorageNew;
    private final HttpCacheStorage publicStorage;
    private final CacheStorage publicStorageNew;
    private final boolean useOldStorage;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.HttpCache$clearAllCaches$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", l = {151, 158}, m = "clearAllCaches", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCache.this.clearAllCaches(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.HttpCache$findAndRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", l = {359, 366, 368}, m = "findAndRefresh", v = 1)
    public static final class C02341 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C02341(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCache.this.findAndRefresh(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.HttpCache$findResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", l = {393, 393}, m = "findResponse", v = 1)
    public static final class C02351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C02351(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCache.this.findResponse(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.HttpCache$selectResponseToUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", l = {378, 381}, m = "selectResponseToUpdate", v = 1)
    public static final class C02361 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C02361(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCache.this.selectResponseToUpdate(null, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TypeReference typeReferenceTypeOf = null;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpCache.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(HttpCache.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("HttpCache", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        HttpResponseFromCache = new EventDefinition<>();
    }

    private HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2) {
        this.publicStorage = httpCacheStorage;
        this.privateStorage = httpCacheStorage2;
        this.publicStorageNew = cacheStorage;
        this.privateStorageNew = cacheStorage2;
        this.useOldStorage = z;
        this.isSharedClient = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cacheResponse(HttpResponse httpResponse, Continuation continuation) {
        HttpRequest request = httpResponse.getCall().getRequest();
        List<HeaderValue> listCacheControl = HttpMessagePropertiesKt.cacheControl(httpResponse);
        List<HeaderValue> listCacheControl2 = HttpMessagePropertiesKt.cacheControl(request);
        CacheControl cacheControl = CacheControl.INSTANCE;
        boolean zContains = listCacheControl.contains(cacheControl.getPRIVATE$ktor_client_core());
        if (zContains && this.isSharedClient) {
            return null;
        }
        CacheStorage cacheStorage = zContains ? this.privateStorageNew : this.publicStorageNew;
        if (listCacheControl.contains(cacheControl.getNO_STORE$ktor_client_core()) || listCacheControl2.contains(cacheControl.getNO_STORE$ktor_client_core())) {
            return null;
        }
        return HttpCacheStorageKt.store(cacheStorage, httpResponse, HttpCacheEntryKt.varyKeys(httpResponse), this.isSharedClient, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:49:0x0182  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object findAndRefresh(HttpRequest httpRequest, HttpResponse httpResponse, Continuation continuation) {
        C02341 c02341;
        CacheStorage cacheStorage;
        HttpCache httpCache;
        boolean z;
        HttpResponse httpResponse2;
        Url url;
        HttpRequest httpRequest2;
        boolean z2;
        CachedResponseData cachedResponseData;
        HttpRequest httpRequest3;
        CachedResponseData cachedResponseData2;
        HttpResponse httpResponse3;
        CacheStorage cacheStorage2;
        Url url2;
        HttpResponse httpResponse4;
        HttpRequest httpRequest4;
        if (continuation instanceof C02341) {
            c02341 = (C02341) continuation;
            int i = c02341.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02341.label = i - Integer.MIN_VALUE;
            } else {
                c02341 = new C02341(continuation);
            }
        } else {
            c02341 = new C02341(continuation);
        }
        C02341 c02342 = c02341;
        Object obj = c02342.result;
        int i2 = c02342.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Url url3 = httpResponse.getCall().getRequest().getUrl();
            boolean zContains = HttpMessagePropertiesKt.cacheControl(httpResponse).contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core());
            if (zContains && this.isSharedClient) {
                return null;
            }
            cacheStorage = zContains ? this.privateStorageNew : this.publicStorageNew;
            c02342.L$0 = httpRequest;
            c02342.L$1 = httpResponse;
            c02342.L$2 = url3;
            c02342.L$3 = null;
            c02342.L$4 = cacheStorage;
            c02342.Z$0 = zContains;
            c02342.label = 1;
            httpCache = this;
            Object objSelectResponseToUpdate = httpCache.selectResponseToUpdate(cacheStorage, httpResponse, url3, httpRequest, c02342);
            if (objSelectResponseToUpdate != coroutineSingletons) {
                obj = objSelectResponseToUpdate;
                z = zContains;
                httpResponse2 = httpResponse;
                url = url3;
                httpRequest2 = httpRequest;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            boolean z3 = c02342.Z$0;
            CacheStorage cacheStorage3 = (CacheStorage) c02342.L$4;
            url = (Url) c02342.L$2;
            HttpResponse httpResponse5 = (HttpResponse) c02342.L$1;
            HttpRequest httpRequest5 = (HttpRequest) c02342.L$0;
            ResultKt.throwOnFailure(obj);
            httpCache = this;
            z = z3;
            httpRequest2 = httpRequest5;
            cacheStorage = cacheStorage3;
            httpResponse2 = httpResponse5;
        } else {
            if (i2 == 2) {
                z = c02342.Z$0;
                cachedResponseData2 = (CachedResponseData) c02342.L$9;
                cacheStorage2 = (CacheStorage) c02342.L$4;
                httpResponse3 = (HttpResponse) c02342.L$1;
                httpRequest3 = (HttpRequest) c02342.L$0;
                ResultKt.throwOnFailure(obj);
                CachedResponseData cachedResponseData3 = cachedResponseData2;
                z2 = z;
                cachedResponseData = cachedResponseData3;
                cacheStorage = cacheStorage2;
                httpResponse2 = httpResponse3;
                url2 = httpRequest3.getUrl();
                c02342.L$0 = httpRequest3;
                c02342.L$1 = httpResponse2;
                c02342.L$2 = null;
                c02342.L$3 = null;
                c02342.L$4 = null;
                c02342.L$5 = null;
                c02342.L$6 = null;
                c02342.L$7 = null;
                c02342.L$8 = null;
                c02342.L$9 = cachedResponseData;
                c02342.Z$0 = z2;
                c02342.label = 3;
                if (cacheStorage.store(url2, cachedResponseData, c02342) != coroutineSingletons) {
                    httpResponse4 = httpResponse2;
                    httpRequest4 = httpRequest3;
                }
                return coroutineSingletons;
            }
            if (i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            cachedResponseData = (CachedResponseData) c02342.L$9;
            httpResponse4 = (HttpResponse) c02342.L$1;
            httpRequest4 = (HttpRequest) c02342.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return HttpCacheStorageKt.createResponse(cachedResponseData, httpRequest4.getCall().getClient(), httpRequest4, httpResponse4.getCoroutineContext());
        CachedResponseData cachedResponseData4 = (CachedResponseData) obj;
        if (cachedResponseData4 == null) {
            return null;
        }
        Map<String, String> mapVaryKeys = HttpCacheEntryKt.varyKeys(httpResponse2);
        if (mapVaryKeys.isEmpty()) {
            mapVaryKeys = cachedResponseData4.getVaryKeys();
        }
        CachedResponseData cachedResponseDataCopy$ktor_client_core = cachedResponseData4.copy$ktor_client_core(mapVaryKeys, HttpCacheEntryKt.cacheExpires$default(httpResponse2, httpCache.isSharedClient, null, 2, null), HttpCacheStorageKt.merge(cachedResponseData4.getHeaders(), httpResponse2.getHeaders()));
        if (Intrinsics.areEqual(cachedResponseData4.getVaryKeys(), mapVaryKeys)) {
            HttpRequest httpRequest6 = httpRequest2;
            z2 = z;
            cachedResponseData = cachedResponseDataCopy$ktor_client_core;
            httpRequest3 = httpRequest6;
            url2 = httpRequest3.getUrl();
            c02342.L$0 = httpRequest3;
            c02342.L$1 = httpResponse2;
            c02342.L$2 = null;
            c02342.L$3 = null;
            c02342.L$4 = null;
            c02342.L$5 = null;
            c02342.L$6 = null;
            c02342.L$7 = null;
            c02342.L$8 = null;
            c02342.L$9 = cachedResponseData;
            c02342.Z$0 = z2;
            c02342.label = 3;
            if (cacheStorage.store(url2, cachedResponseData, c02342) != coroutineSingletons) {
                httpResponse4 = httpResponse2;
                httpRequest4 = httpRequest3;
                return HttpCacheStorageKt.createResponse(cachedResponseData, httpRequest4.getCall().getClient(), httpRequest4, httpResponse4.getCoroutineContext());
            }
        } else {
            Map<String, String> varyKeys = cachedResponseData4.getVaryKeys();
            c02342.L$0 = httpRequest2;
            c02342.L$1 = httpResponse2;
            c02342.L$2 = null;
            c02342.L$3 = null;
            c02342.L$4 = cacheStorage;
            c02342.L$5 = null;
            c02342.L$6 = null;
            c02342.L$7 = null;
            c02342.L$8 = null;
            c02342.L$9 = cachedResponseDataCopy$ktor_client_core;
            c02342.Z$0 = z;
            c02342.label = 2;
            if (cacheStorage.remove(url, varyKeys, c02342) != coroutineSingletons) {
                httpRequest3 = httpRequest2;
                cachedResponseData2 = cachedResponseDataCopy$ktor_client_core;
                httpResponse3 = httpResponse2;
                cacheStorage2 = cacheStorage;
                CachedResponseData cachedResponseData5 = cachedResponseData2;
                z2 = z;
                cachedResponseData = cachedResponseData5;
                cacheStorage = cacheStorage2;
                httpResponse2 = httpResponse3;
                url2 = httpRequest3.getUrl();
                c02342.L$0 = httpRequest3;
                c02342.L$1 = httpResponse2;
                c02342.L$2 = null;
                c02342.L$3 = null;
                c02342.L$4 = null;
                c02342.L$5 = null;
                c02342.L$6 = null;
                c02342.L$7 = null;
                c02342.L$8 = null;
                c02342.L$9 = cachedResponseData;
                c02342.Z$0 = z2;
                c02342.label = 3;
                if (cacheStorage.store(url2, cachedResponseData, c02342) != coroutineSingletons) {
                    httpResponse4 = httpResponse2;
                    httpRequest4 = httpRequest3;
                    return HttpCacheStorageKt.createResponse(cachedResponseData, httpRequest4.getCall().getClient(), httpRequest4, httpResponse4.getCoroutineContext());
                }
            }
        }
        return coroutineSingletons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object findResponse(HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent, Continuation continuation) {
        C02351 c02351;
        Function1 function1MergedHeadersLookup;
        Url url;
        Set set;
        Map<String, String> varyKeys;
        if (continuation instanceof C02351) {
            c02351 = (C02351) continuation;
            int i = c02351.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02351.label = i - Integer.MIN_VALUE;
            } else {
                c02351 = new C02351(continuation);
            }
        } else {
            c02351 = new C02351(continuation);
        }
        Object obj = c02351.result;
        int i2 = c02351.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Url Url = URLUtilsKt.Url(httpRequestBuilder.getUrl());
            function1MergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(outgoingContent, new HttpCache$findResponse$lookup$1(httpRequestBuilder.getHeaders()), new HttpCache$findResponse$lookup$2(httpRequestBuilder.getHeaders()));
            CacheStorage cacheStorage = this.privateStorageNew;
            c02351.L$0 = null;
            c02351.L$1 = null;
            c02351.L$2 = Url;
            c02351.L$3 = function1MergedHeadersLookup;
            c02351.label = 1;
            Object objFindAll = cacheStorage.findAll(Url, c02351);
            if (objFindAll != coroutineSingletons) {
                obj = objFindAll;
                url = Url;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            function1MergedHeadersLookup = (Function1) c02351.L$3;
            url = (Url) c02351.L$2;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            set = (Set) c02351.L$4;
            function1MergedHeadersLookup = (Function1) c02351.L$3;
            ResultKt.throwOnFailure(obj);
        }
        for (CachedResponseData cachedResponseData : SetsKt.plus(set, (Iterable) obj)) {
            varyKeys = cachedResponseData.getVaryKeys();
            if (varyKeys.isEmpty() && !varyKeys.isEmpty()) {
                for (Map.Entry<String, String> entry : varyKeys.entrySet()) {
                    String key2 = entry.getKey();
                    if (!Intrinsics.areEqual(function1MergedHeadersLookup.invoke(key2), entry.getValue())) {
                    }
                }
            }
            return cachedResponseData;
        }
        return null;
        Set set2 = (Set) obj;
        CacheStorage cacheStorage2 = this.publicStorageNew;
        c02351.L$0 = null;
        c02351.L$1 = null;
        c02351.L$2 = null;
        c02351.L$3 = function1MergedHeadersLookup;
        c02351.L$4 = set2;
        c02351.label = 2;
        Object objFindAll2 = cacheStorage2.findAll(url, c02351);
        if (objFindAll2 != coroutineSingletons) {
            obj = objFindAll2;
            set = set2;
            while (r8.hasNext()) {
                varyKeys = cachedResponseData.getVaryKeys();
                if (varyKeys.isEmpty()) {
                }
                return cachedResponseData;
            }
            return null;
        }
        return coroutineSingletons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:34:0x00de  */
    /* JADX WARN: Code duplicated, block: B:37:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:46:0x0120 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0121  */
    /* JADX WARN: Code duplicated, block: B:50:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:? A[LOOP:0: B:32:0x00d8->B:52:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:? A[LOOP:1: B:38:0x00f8->B:53:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
    
        if (r6 == r4) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object selectResponseToUpdate(CacheStorage cacheStorage, HttpResponse httpResponse, Url url, HttpRequest httpRequest, Continuation continuation) {
        C02361 c02361;
        Function1 function1MergedHeadersLookup;
        Object objFindAll;
        Function1 function1;
        List listSortedWith;
        CachedResponseData cachedResponseData;
        Map<String, String> varyKeys;
        Iterator<Map.Entry<String, String>> it;
        Map.Entry<String, String> next;
        if (continuation instanceof C02361) {
            c02361 = (C02361) continuation;
            int i = c02361.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02361.label = i - Integer.MIN_VALUE;
            } else {
                c02361 = new C02361(continuation);
            }
        } else {
            c02361 = new C02361(continuation);
        }
        Object objFind = c02361.result;
        int i2 = c02361.label;
        Object obj = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                httpRequest = (HttpRequest) c02361.L$3;
                url = (Url) c02361.L$2;
                httpResponse = (HttpResponse) c02361.L$1;
                cacheStorage = (CacheStorage) c02361.L$0;
                ResultKt.throwOnFailure(objFind);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                function1 = (Function1) c02361.L$5;
                httpResponse = (HttpResponse) c02361.L$1;
                ResultKt.throwOnFailure(objFind);
            }
            listSortedWith = CollectionsKt.sortedWith((Iterable) objFind, new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCache$selectResponseToUpdate$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return RegexKt.compareValues(((CachedResponseData) t2).getResponseTime(), ((CachedResponseData) t).getResponseTime());
                }
            });
            loop0: for (Object obj2 : listSortedWith) {
                varyKeys = ((CachedResponseData) obj2).getVaryKeys();
                if (!varyKeys.isEmpty()) {
                    it = varyKeys.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (!Intrinsics.areEqual(function1.invoke(next.getKey()), next.getValue())) {
                            }
                        }
                    }
                }
                obj = obj2;
            }
            cachedResponseData = (CachedResponseData) obj;
            if (cachedResponseData != null) {
                return cachedResponseData;
            }
            return HttpCacheValidationKt.selectResponseToFreshen(listSortedWith, httpResponse, new HttpClient$$ExternalSyntheticLambda1((byte) 28));
        }
        ResultKt.throwOnFailure(objFind);
        Map<String, String> mapVaryKeys = HttpCacheEntryKt.varyKeys(httpResponse);
        if (mapVaryKeys.isEmpty()) {
            mapVaryKeys = null;
        }
        if (mapVaryKeys != null) {
            c02361.L$0 = cacheStorage;
            c02361.L$1 = httpResponse;
            c02361.L$2 = url;
            c02361.L$3 = httpRequest;
            c02361.L$4 = null;
            c02361.L$5 = null;
            c02361.I$0 = 0;
            c02361.label = 1;
            objFind = cacheStorage.find(url, mapVaryKeys, c02361);
        } else {
            function1MergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(httpRequest.getContent(), new HttpCache$selectResponseToUpdate$requestHeaders$1(httpRequest.getHeaders()), new HttpCache$selectResponseToUpdate$requestHeaders$2(httpRequest.getHeaders()));
            c02361.L$0 = null;
            c02361.L$1 = httpResponse;
            c02361.L$2 = null;
            c02361.L$3 = null;
            c02361.L$4 = null;
            c02361.L$5 = function1MergedHeadersLookup;
            c02361.label = 2;
            objFindAll = cacheStorage.findAll(url, c02361);
            if (objFindAll != coroutineSingletons) {
                function1 = function1MergedHeadersLookup;
                objFind = objFindAll;
                listSortedWith = CollectionsKt.sortedWith((Iterable) objFind, new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCache$selectResponseToUpdate$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return RegexKt.compareValues(((CachedResponseData) t2).getResponseTime(), ((CachedResponseData) t).getResponseTime());
                    }
                });
                loop0: while (r9.hasNext()) {
                    varyKeys = ((CachedResponseData) obj2).getVaryKeys();
                    if (!varyKeys.isEmpty()) {
                        it = varyKeys.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                next = it.next();
                                if (!Intrinsics.areEqual(function1.invoke(next.getKey()), next.getValue())) {
                                }
                            }
                        }
                    }
                    obj = obj2;
                }
                cachedResponseData = (CachedResponseData) obj;
                if (cachedResponseData != null) {
                    return cachedResponseData;
                }
                return HttpCacheValidationKt.selectResponseToFreshen(listSortedWith, httpResponse, new HttpClient$$ExternalSyntheticLambda1((byte) 28));
            }
        }
        return coroutineSingletons;
        CachedResponseData cachedResponseData2 = (CachedResponseData) objFind;
        if (cachedResponseData2 != null) {
            return cachedResponseData2;
        }
        function1MergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(httpRequest.getContent(), new HttpCache$selectResponseToUpdate$requestHeaders$1(httpRequest.getHeaders()), new HttpCache$selectResponseToUpdate$requestHeaders$2(httpRequest.getHeaders()));
        c02361.L$0 = null;
        c02361.L$1 = httpResponse;
        c02361.L$2 = null;
        c02361.L$3 = null;
        c02361.L$4 = null;
        c02361.L$5 = function1MergedHeadersLookup;
        c02361.label = 2;
        objFindAll = cacheStorage.findAll(url, c02361);
        if (objFindAll != coroutineSingletons) {
            function1 = function1MergedHeadersLookup;
            objFind = objFindAll;
            listSortedWith = CollectionsKt.sortedWith((Iterable) objFind, new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCache$selectResponseToUpdate$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return RegexKt.compareValues(((CachedResponseData) t2).getResponseTime(), ((CachedResponseData) t).getResponseTime());
                }
            });
            loop0: while (r9.hasNext()) {
                varyKeys = ((CachedResponseData) obj2).getVaryKeys();
                if (!varyKeys.isEmpty()) {
                    it = varyKeys.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (!Intrinsics.areEqual(function1.invoke(next.getKey()), next.getValue())) {
                            }
                        }
                    }
                }
                obj = obj2;
            }
            cachedResponseData = (CachedResponseData) obj;
            if (cachedResponseData != null) {
                return cachedResponseData;
            }
            return HttpCacheValidationKt.selectResponseToFreshen(listSortedWith, httpResponse, new HttpClient$$ExternalSyntheticLambda1((byte) 28));
        }
        return coroutineSingletons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Headers selectResponseToUpdate$lambda$6(CachedResponseData cachedResponseData) {
        cachedResponseData.getClass();
        return cachedResponseData.getHeaders();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x006d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x003c -> B:50:0x0050). Please report as a decompilation issue!!! */
    public final Object clearAllCaches(Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ?? r6;
        Throwable th;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Throwable th2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.useOldStorage) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("clearAllCaches() is not supported with deprecated HttpCacheStorage. Please migrate to the new CacheStorage API.");
                            return null;
                        }
                        CacheStorage cacheStorage = this.privateStorageNew;
                        anonymousClass1.label = 1;
                        if (cacheStorage.clear(anonymousClass1) != coroutineSingletons) {
                        }
                        this = this;
                        return coroutineSingletons;
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        th = (Throwable) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            if (th == null) {
                                th = th;
                            } else {
                                ResultKt.addSuppressed(th, th);
                            }
                        }
                        if (th == null) {
                            return Unit.INSTANCE;
                        }
                        throw th;
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                } catch (CancellationException e) {
                    throw e;
                }
            } catch (CancellationException e2) {
                throw e2;
            } catch (Throwable th4) {
                th2 = th4;
                r6 = this;
            }
            this = this;
            CacheStorage cacheStorage2 = r6.publicStorageNew;
            anonymousClass1.L$0 = th2;
            anonymousClass1.label = 2;
            this = cacheStorage2.clear(anonymousClass1);
            if (this != coroutineSingletons) {
                th = th2;
                if (th == null) {
                    return Unit.INSTANCE;
                }
                throw th;
            }
            this = this;
            return coroutineSingletons;
        } catch (Throwable th5) {
            th = th5;
            th = th2;
            if (th == null) {
                th = th;
            } else {
                ResultKt.addSuppressed(th, th);
            }
        }
    }

    /* JADX INFO: renamed from: getPrivateStorage$ktor_client_core, reason: from getter */
    public final HttpCacheStorage getPrivateStorage() {
        return this.privateStorage;
    }

    /* JADX INFO: renamed from: getPublicStorage$ktor_client_core, reason: from getter */
    public final HttpCacheStorage getPublicStorage() {
        return this.publicStorage;
    }

    /* JADX INFO: renamed from: isSharedClient$ktor_client_core, reason: from getter */
    public final boolean getIsSharedClient() {
        return this.isSharedClient;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u0010\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u001d\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0080@¢\u0006\u0004\b\u001b\u0010\u001cJ(\u0010 \u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\u001e\u0010\u001fR \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cache/HttpCache$Config;", "Lio/ktor/client/plugins/cache/HttpCache;", "<init>", "()V", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "cachedResponse", "Lio/ktor/client/HttpClient;", "scope", "Lkotlin/coroutines/CoroutineContext;", "callContext", "", "proceedWithWarning", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lio/ktor/client/HttpClient;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/cache/HttpCache;", "plugin", "install", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/HttpClient;)V", "Lio/ktor/client/call/HttpClientCall;", "cachedCall", "proceedWithCache$ktor_client_core", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithCache", "proceedWithMissingCache$ktor_client_core", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithMissingCache", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "HttpResponseFromCache", "Lio/ktor/events/EventDefinition;", "getHttpResponseFromCache", "()Lio/ktor/events/EventDefinition;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, HttpCache> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object proceedWithWarning(PipelineContext<Object, HttpRequestBuilder> pipelineContext, CachedResponseData cachedResponseData, HttpClient httpClient, CoroutineContext coroutineContext, Continuation continuation) {
            HttpRequestData httpRequestDataBuild = pipelineContext.getContext().build();
            HttpStatusCode statusCode = cachedResponseData.getStatusCode();
            GMTDate requestTime = cachedResponseData.getRequestTime();
            Headers.Companion companion = Headers.INSTANCE;
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
            headersBuilder.appendAll(cachedResponseData.getHeaders());
            headersBuilder.append(HttpHeaders.Warning, "110");
            HttpClientCall httpClientCall = new HttpClientCall(httpClient, httpRequestDataBuild, new HttpResponseData(statusCode, requestTime, headersBuilder.build(), cachedResponseData.getVersion(), ByteChannelCtorKt.ByteReadChannel$default(cachedResponseData.getBody(), 0, 0, 6, null), coroutineContext));
            pipelineContext.finish();
            httpClient.getMonitor().raise(getHttpResponseFromCache(), httpClientCall.getResponse());
            Object objProceedWith = pipelineContext.proceedWith(httpClientCall, continuation);
            return objProceedWith == CoroutineSingletons.COROUTINE_SUSPENDED ? objProceedWith : Unit.INSTANCE;
        }

        public final EventDefinition<HttpResponse> getHttpResponseFromCache() {
            return HttpCache.HttpResponseFromCache;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCache> getKey() {
            return HttpCache.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCache plugin, HttpClient scope) {
            plugin.getClass();
            scope.getClass();
            PipelinePhase pipelinePhase = new PipelinePhase("Cache");
            scope.getSendPipeline().insertPhaseAfter(HttpSendPipeline.INSTANCE.getState(), pipelinePhase);
            scope.getSendPipeline().intercept(pipelinePhase, new HttpCache$Companion$install$1(plugin, scope, null));
            PipelinePhase pipelinePhase2 = new PipelinePhase("Cache");
            scope.getReceivePipeline().insertPhaseAfter(HttpReceivePipeline.INSTANCE.getState(), pipelinePhase2);
            scope.getReceivePipeline().intercept(pipelinePhase2, new HttpCache$Companion$install$2(plugin, scope, null));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCache prepare(Function1 block) {
            block.getClass();
            Config config = new Config();
            block.invoke(config);
            return new HttpCache(config.getPublicStorage(), config.getPrivateStorage(), config.getPublicStorageNew(), config.getPrivateStorageNew(), config.getUseOldStorage(), config.getIsShared(), null);
        }

        public final Object proceedWithCache$ktor_client_core(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient httpClient, HttpClientCall httpClientCall, Continuation continuation) {
            pipelineContext.finish();
            httpClient.getMonitor().raise(getHttpResponseFromCache(), httpClientCall.getResponse());
            Object objProceedWith = pipelineContext.proceedWith(httpClientCall, continuation);
            return objProceedWith == CoroutineSingletons.COROUTINE_SUSPENDED ? objProceedWith : Unit.INSTANCE;
        }

        public final Object proceedWithMissingCache$ktor_client_core(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient httpClient, Continuation continuation) {
            pipelineContext.finish();
            HttpRequestData httpRequestDataBuild = pipelineContext.getContext().build();
            Object objProceedWith = pipelineContext.proceedWith(new HttpClientCall(httpClient, httpRequestDataBuild, new HttpResponseData(HttpStatusCode.INSTANCE.getGatewayTimeout(), DateJvmKt.GMTDate$default(null, 1, null), Headers.INSTANCE.getEmpty(), HttpProtocolVersion.INSTANCE.getHTTP_1_1(), ByteChannelCtorKt.ByteReadChannel$default(new byte[0], 0, 0, 6, null), httpRequestDataBuild.getExecutionContext())), continuation);
            return objProceedWith == CoroutineSingletons.COROUTINE_SUSPENDED ? objProceedWith : Unit.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpCacheStorage, httpCacheStorage2, cacheStorage, cacheStorage2, z, z2);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\"\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R0\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\u0007\u0010\u001d\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010\t\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\t\u0010\u001d\u0012\u0004\b%\u0010\u0003\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006&"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Config;", "", "<init>", "()V", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "storage", "", "publicStorage", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "privateStorage", "publicStorageNew", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "getPublicStorageNew$ktor_client_core", "()Lio/ktor/client/plugins/cache/storage/CacheStorage;", "setPublicStorageNew$ktor_client_core", "privateStorageNew", "getPrivateStorageNew$ktor_client_core", "setPrivateStorageNew$ktor_client_core", "", "useOldStorage", "Z", "getUseOldStorage$ktor_client_core", "()Z", "setUseOldStorage$ktor_client_core", "(Z)V", "isShared", "setShared", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "value", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "setPublicStorage", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;)V", "getPublicStorage$annotations", "getPrivateStorage", "setPrivateStorage", "getPrivateStorage$annotations", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Config {
        private boolean isShared;
        private HttpCacheStorage privateStorage;
        private CacheStorage privateStorageNew;
        private HttpCacheStorage publicStorage;
        private CacheStorage publicStorageNew;
        private boolean useOldStorage;

        public Config() {
            CacheStorage.Companion companion = CacheStorage.INSTANCE;
            this.publicStorageNew = (CacheStorage) companion.getUnlimited().invoke();
            this.privateStorageNew = (CacheStorage) companion.getUnlimited().invoke();
            HttpCacheStorage.Companion companion2 = HttpCacheStorage.INSTANCE;
            this.publicStorage = (HttpCacheStorage) companion2.getUnlimited().invoke();
            this.privateStorage = (HttpCacheStorage) companion2.getUnlimited().invoke();
        }

        public final HttpCacheStorage getPrivateStorage() {
            return this.privateStorage;
        }

        /* JADX INFO: renamed from: getPrivateStorageNew$ktor_client_core, reason: from getter */
        public final CacheStorage getPrivateStorageNew() {
            return this.privateStorageNew;
        }

        public final HttpCacheStorage getPublicStorage() {
            return this.publicStorage;
        }

        /* JADX INFO: renamed from: getPublicStorageNew$ktor_client_core, reason: from getter */
        public final CacheStorage getPublicStorageNew() {
            return this.publicStorageNew;
        }

        /* JADX INFO: renamed from: getUseOldStorage$ktor_client_core, reason: from getter */
        public final boolean getUseOldStorage() {
            return this.useOldStorage;
        }

        /* JADX INFO: renamed from: isShared, reason: from getter */
        public final boolean getIsShared() {
            return this.isShared;
        }

        public final void privateStorage(CacheStorage storage) {
            storage.getClass();
            this.privateStorageNew = storage;
        }

        public final void publicStorage(CacheStorage storage) {
            storage.getClass();
            this.publicStorageNew = storage;
        }

        public final void setPrivateStorage(HttpCacheStorage httpCacheStorage) {
            httpCacheStorage.getClass();
            this.useOldStorage = true;
            this.privateStorage = httpCacheStorage;
        }

        public final void setPrivateStorageNew$ktor_client_core(CacheStorage cacheStorage) {
            cacheStorage.getClass();
            this.privateStorageNew = cacheStorage;
        }

        public final void setPublicStorage(HttpCacheStorage httpCacheStorage) {
            httpCacheStorage.getClass();
            this.useOldStorage = true;
            this.publicStorage = httpCacheStorage;
        }

        public final void setPublicStorageNew$ktor_client_core(CacheStorage cacheStorage) {
            cacheStorage.getClass();
            this.publicStorageNew = cacheStorage;
        }

        public final void setShared(boolean z) {
            this.isShared = z;
        }

        public final void setUseOldStorage$ktor_client_core(boolean z) {
            this.useOldStorage = z;
        }

        @Deprecated
        public static /* synthetic */ void getPrivateStorage$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getPublicStorage$annotations() {
        }
    }
}
