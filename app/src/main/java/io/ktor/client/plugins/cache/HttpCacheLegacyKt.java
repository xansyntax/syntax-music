package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.plugins.cache.storage.UnlimitedCacheStorage;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.RegexKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a8\u0010\n\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\n\u0010\u000b\u001a8\u0010\u000e\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\u000e\u0010\u000f\u001a0\u0010\u0012\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\f*\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\u0018\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u00020\u00032\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010!¨\u0006\""}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/plugins/cache/HttpCache;", "plugin", "Lio/ktor/http/content/OutgoingContent;", "content", "Lio/ktor/client/HttpClient;", "scope", "", "interceptSendLegacy", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/http/content/OutgoingContent;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "response", "interceptReceiveLegacy", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponse;Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/call/HttpClientCall;", "cachedCall", "proceedWithWarning", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheResponse", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequest;", "request", "findAndRefresh", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "selectResponseToUpdate", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/statement/HttpResponse;Lio/ktor/http/Url;Lio/ktor/client/request/HttpRequest;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "context", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpCacheLegacyKt {

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheLegacyKt", f = "HttpCacheLegacy.kt", l = {112}, m = "cacheResponse", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCacheLegacyKt.cacheResponse(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.HttpCacheLegacyKt$interceptReceiveLegacy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheLegacyKt", f = "HttpCacheLegacy.kt", l = {61, 62, 67, 74}, m = "interceptReceiveLegacy", v = 1)
    public static final class C02371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C02371(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCacheLegacyKt.interceptReceiveLegacy(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object cacheResponse(HttpCache httpCache, HttpResponse httpResponse, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objStore = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objStore);
            HttpRequest request = httpResponse.getCall().getRequest();
            List<HeaderValue> listCacheControl = HttpMessagePropertiesKt.cacheControl(httpResponse);
            List<HeaderValue> listCacheControl2 = HttpMessagePropertiesKt.cacheControl(request);
            CacheControl cacheControl = CacheControl.INSTANCE;
            HttpCacheStorage privateStorage$ktor_client_core = listCacheControl.contains(cacheControl.getPRIVATE$ktor_client_core()) ? httpCache.getPrivateStorage() : httpCache.getPublicStorage();
            if (listCacheControl.contains(cacheControl.getNO_STORE$ktor_client_core()) || listCacheControl2.contains(cacheControl.getNO_STORE$ktor_client_core())) {
                return httpResponse;
            }
            Url url = request.getUrl();
            boolean zIsSharedClient$ktor_client_core = httpCache.getIsSharedClient();
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = null;
            anonymousClass1.L$4 = null;
            anonymousClass1.L$5 = null;
            anonymousClass1.label = 1;
            objStore = HttpCacheStorageKt.store(privateStorage$ktor_client_core, url, httpResponse, zIsSharedClient$ktor_client_core, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objStore == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objStore);
        }
        return ((HttpCacheEntry) objStore).produceResponse$ktor_client_core();
    }

    private static final HttpResponse findAndRefresh(HttpCache httpCache, HttpRequest httpRequest, HttpResponse httpResponse) {
        Url url = httpResponse.getCall().getRequest().getUrl();
        HttpCacheStorage privateStorage$ktor_client_core = HttpMessagePropertiesKt.cacheControl(httpResponse).contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core()) ? httpCache.getPrivateStorage() : httpCache.getPublicStorage();
        HttpCacheEntry httpCacheEntrySelectResponseToUpdate = selectResponseToUpdate(privateStorage$ktor_client_core, httpResponse, url, httpRequest);
        if (httpCacheEntrySelectResponseToUpdate == null) {
            return null;
        }
        Map<String, String> mapVaryKeys = HttpCacheEntryKt.varyKeys(httpResponse);
        if (mapVaryKeys.isEmpty()) {
            mapVaryKeys = httpCacheEntrySelectResponseToUpdate.getVaryKeys();
        }
        HttpCacheEntry httpCacheEntryWithFreshenedMetadata = HttpCacheEntryKt.withFreshenedMetadata(httpCacheEntrySelectResponseToUpdate, HttpCacheEntryKt.cacheExpires$default(httpResponse, httpCache.getIsSharedClient(), null, 2, null), mapVaryKeys, HttpCacheStorageKt.merge(httpCacheEntrySelectResponseToUpdate.getResponseHeaders(), httpResponse.getHeaders()));
        if (!Intrinsics.areEqual(httpCacheEntrySelectResponseToUpdate.getVaryKeys(), mapVaryKeys) && (privateStorage$ktor_client_core instanceof UnlimitedCacheStorage)) {
            ((UnlimitedCacheStorage) privateStorage$ktor_client_core).remove$ktor_client_core(url, httpCacheEntrySelectResponseToUpdate.getVaryKeys());
        }
        privateStorage$ktor_client_core.store(url, httpCacheEntryWithFreshenedMetadata);
        return httpCacheEntryWithFreshenedMetadata.produceResponse$ktor_client_core();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0113 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object interceptReceiveLegacy(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, HttpCache httpCache, HttpClient httpClient, Continuation continuation) {
        C02371 c02371;
        HttpResponse httpResponse2;
        if (continuation instanceof C02371) {
            c02371 = (C02371) continuation;
            int i = c02371.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02371.label = i - Integer.MIN_VALUE;
            } else {
                c02371 = new C02371(continuation);
            }
        } else {
            c02371 = new C02371(continuation);
        }
        Object objRefreshNotModifiedResponse = c02371.result;
        int i2 = c02371.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRefreshNotModifiedResponse);
            if (!HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                    HttpRequest request = httpResponse.getCall().getRequest();
                    HttpCacheLegacyKt$interceptReceiveLegacy$responseFromCache$1 httpCacheLegacyKt$interceptReceiveLegacy$responseFromCache$1 = new HttpCacheLegacyKt$interceptReceiveLegacy$responseFromCache$1(httpCache);
                    c02371.L$0 = pipelineContext;
                    c02371.L$1 = null;
                    c02371.L$2 = null;
                    c02371.L$3 = httpClient;
                    c02371.label = 3;
                    objRefreshNotModifiedResponse = HttpCacheValidationKt.refreshNotModifiedResponse(request, httpResponse, httpCacheLegacyKt$interceptReceiveLegacy$responseFromCache$1, c02371);
                    if (objRefreshNotModifiedResponse != coroutineSingletons) {
                        httpResponse2 = (HttpResponse) objRefreshNotModifiedResponse;
                        httpClient.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse2);
                        c02371.L$0 = null;
                        c02371.L$1 = null;
                        c02371.L$2 = null;
                        c02371.L$3 = null;
                        c02371.L$4 = null;
                        c02371.label = 4;
                        if (pipelineContext.proceedWith(httpResponse2, c02371) == coroutineSingletons) {
                        }
                    }
                }
                return unit;
            }
            c02371.L$0 = pipelineContext;
            c02371.L$1 = null;
            c02371.L$2 = null;
            c02371.L$3 = null;
            c02371.label = 1;
            objRefreshNotModifiedResponse = cacheResponse(httpCache, httpResponse, c02371);
            if (objRefreshNotModifiedResponse != coroutineSingletons) {
                c02371.L$0 = null;
                c02371.L$1 = null;
                c02371.L$2 = null;
                c02371.L$3 = null;
                c02371.L$4 = null;
                c02371.label = 2;
                if (pipelineContext.proceedWith((HttpResponse) objRefreshNotModifiedResponse, c02371) != coroutineSingletons) {
                    return unit;
                }
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            pipelineContext = (PipelineContext) c02371.L$0;
            ResultKt.throwOnFailure(objRefreshNotModifiedResponse);
            c02371.L$0 = null;
            c02371.L$1 = null;
            c02371.L$2 = null;
            c02371.L$3 = null;
            c02371.L$4 = null;
            c02371.label = 2;
            if (pipelineContext.proceedWith((HttpResponse) objRefreshNotModifiedResponse, c02371) != coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    httpClient = (HttpClient) c02371.L$3;
                    pipelineContext = (PipelineContext) c02371.L$0;
                    ResultKt.throwOnFailure(objRefreshNotModifiedResponse);
                    httpResponse2 = (HttpResponse) objRefreshNotModifiedResponse;
                    httpClient.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse2);
                    c02371.L$0 = null;
                    c02371.L$1 = null;
                    c02371.L$2 = null;
                    c02371.L$3 = null;
                    c02371.L$4 = null;
                    c02371.label = 4;
                    if (pipelineContext.proceedWith(httpResponse2, c02371) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objRefreshNotModifiedResponse);
                }
                return unit;
            }
            ResultKt.throwOnFailure(objRefreshNotModifiedResponse);
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object interceptReceiveLegacy$findAndRefresh(HttpCache httpCache, HttpRequest httpRequest, HttpResponse httpResponse, Continuation continuation) {
        return findAndRefresh(httpCache, httpRequest, httpResponse);
    }

    public static final Object interceptSendLegacy(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpCache httpCache, OutgoingContent outgoingContent, HttpClient httpClient, Continuation continuation) {
        Object objProceedWithMissingCache$ktor_client_core;
        HttpCacheEntry httpCacheEntrySelectResponseToUpdate = selectResponseToUpdate(httpCache, pipelineContext.getContext(), outgoingContent);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        if (httpCacheEntrySelectResponseToUpdate == null) {
            return (HttpHeaderValueParserKt.parseHeaderValue(pipelineContext.getContext().getHeaders().get(HttpHeaders.CacheControl)).contains(CacheControl.INSTANCE.getONLY_IF_CACHED$ktor_client_core()) && (objProceedWithMissingCache$ktor_client_core = HttpCache.INSTANCE.proceedWithMissingCache$ktor_client_core(pipelineContext, httpClient, continuation)) == coroutineSingletons) ? objProceedWithMissingCache$ktor_client_core : unit;
        }
        HttpClientCall call = httpCacheEntrySelectResponseToUpdate.produceResponse$ktor_client_core().getCall();
        ValidateStatus validateStatusShouldValidate = HttpCacheEntryKt.shouldValidate(httpCacheEntrySelectResponseToUpdate.getExpires(), httpCacheEntrySelectResponseToUpdate.getResponse().getHeaders(), pipelineContext.getContext());
        if (validateStatusShouldValidate == ValidateStatus.ShouldNotValidate) {
            Object objProceedWithCache$ktor_client_core = HttpCache.INSTANCE.proceedWithCache$ktor_client_core(pipelineContext, httpClient, call, continuation);
            return objProceedWithCache$ktor_client_core == coroutineSingletons ? objProceedWithCache$ktor_client_core : unit;
        }
        if (validateStatusShouldValidate == ValidateStatus.ShouldWarn) {
            Object objProceedWithWarning = proceedWithWarning(pipelineContext, call, httpClient, continuation);
            return objProceedWithWarning == coroutineSingletons ? objProceedWithWarning : unit;
        }
        String str = httpCacheEntrySelectResponseToUpdate.getResponseHeaders().get(HttpHeaders.ETag);
        if (str != null) {
            UtilsKt.header(pipelineContext.getContext(), HttpHeaders.IfNoneMatch, str);
        }
        String str2 = httpCacheEntrySelectResponseToUpdate.getResponseHeaders().get(HttpHeaders.LastModified);
        if (str2 != null) {
            UtilsKt.header(pipelineContext.getContext(), HttpHeaders.IfModifiedSince, str2);
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object proceedWithWarning(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClientCall httpClientCall, HttpClient httpClient, Continuation continuation) {
        HttpRequestData httpRequestDataBuild = pipelineContext.getContext().build();
        HttpStatusCode status = httpClientCall.getResponse().getStatus();
        GMTDate requestTime = httpClientCall.getResponse().getRequestTime();
        Headers.Companion companion = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.appendAll(httpClientCall.getResponse().getHeaders());
        headersBuilder.append(HttpHeaders.Warning, "110");
        HttpClientCall httpClientCall2 = new HttpClientCall(httpClient, httpRequestDataBuild, new HttpResponseData(status, requestTime, headersBuilder.build(), httpClientCall.getResponse().getVersion(), httpClientCall.getResponse().getRawContent(), httpClientCall.getResponse().getCoroutineContext()));
        pipelineContext.finish();
        httpClient.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpClientCall2.getResponse());
        Object objProceedWith = pipelineContext.proceedWith(httpClientCall2, continuation);
        return objProceedWith == CoroutineSingletons.COROUTINE_SUSPENDED ? objProceedWith : Unit.INSTANCE;
    }

    private static final HttpCacheEntry selectResponseToUpdate(HttpCacheStorage httpCacheStorage, HttpResponse httpResponse, Url url, HttpRequest httpRequest) {
        HttpCacheEntry httpCacheEntryFind;
        Map<String, String> mapVaryKeys = HttpCacheEntryKt.varyKeys(httpResponse);
        Object obj = null;
        if (mapVaryKeys.isEmpty()) {
            mapVaryKeys = null;
        }
        if (mapVaryKeys != null && (httpCacheEntryFind = httpCacheStorage.find(url, mapVaryKeys)) != null) {
            return httpCacheEntryFind;
        }
        Function1 function1MergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(httpRequest.getContent(), new HttpCacheLegacyKt$selectResponseToUpdate$requestHeaders$1(httpRequest.getHeaders()), new HttpCacheLegacyKt$selectResponseToUpdate$requestHeaders$2(httpRequest.getHeaders()));
        List listSortedWith = CollectionsKt.sortedWith(httpCacheStorage.findByUrl(url), new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCacheLegacyKt$selectResponseToUpdate$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return RegexKt.compareValues(((HttpCacheEntry) t2).getResponse().getResponseTime(), ((HttpCacheEntry) t).getResponse().getResponseTime());
            }
        });
        loop0: for (Object obj2 : listSortedWith) {
            Map<String, String> varyKeys = ((HttpCacheEntry) obj2).getVaryKeys();
            if (!varyKeys.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = varyKeys.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, String> next = it.next();
                        if (!Intrinsics.areEqual(function1MergedHeadersLookup.invoke(next.getKey()), next.getValue())) {
                        }
                    }
                }
            }
            obj = obj2;
        }
        HttpCacheEntry httpCacheEntry = (HttpCacheEntry) obj;
        return httpCacheEntry != null ? httpCacheEntry : (HttpCacheEntry) HttpCacheValidationKt.selectResponseToFreshen(listSortedWith, httpResponse, new HttpClient$$ExternalSyntheticLambda1((byte) 29));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Headers selectResponseToUpdate$lambda$6(HttpCacheEntry httpCacheEntry) {
        httpCacheEntry.getClass();
        return httpCacheEntry.getResponseHeaders();
    }

    private static final HttpCacheEntry selectResponseToUpdate(HttpCache httpCache, HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent) {
        Url Url = URLUtilsKt.Url(httpRequestBuilder.getUrl());
        Function1 function1MergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(outgoingContent, new HttpCacheLegacyKt$selectResponseToUpdate$lookup$1(httpRequestBuilder.getHeaders()), new HttpCacheLegacyKt$selectResponseToUpdate$lookup$2(httpRequestBuilder.getHeaders()));
        for (HttpCacheEntry httpCacheEntry : SetsKt.plus((Set) httpCache.getPrivateStorage().findByUrl(Url), (Iterable) httpCache.getPublicStorage().findByUrl(Url))) {
            Map<String, String> varyKeys = httpCacheEntry.getVaryKeys();
            if (!varyKeys.isEmpty() && !varyKeys.isEmpty()) {
                for (Map.Entry<String, String> entry : varyKeys.entrySet()) {
                    String key = entry.getKey();
                    if (!Intrinsics.areEqual(function1MergedHeadersLookup.invoke(key), entry.getValue())) {
                    }
                }
            }
            return httpCacheEntry;
        }
        return null;
    }
}
