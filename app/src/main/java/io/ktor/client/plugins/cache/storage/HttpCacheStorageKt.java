package io.ktor.client.plugins.cache.storage;

import com.yalantis.ucrop.UCrop;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.client.plugins.cache.HttpCacheEntryKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.BuffersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.io.Buffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\u001a,\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\b\u001a\u00020\f*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0087@¢\u0006\u0004\b\b\u0010\r\u001a:\u0010\b\u001a\u00020\f*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\b\u0010\u0011\u001a+\u0010\u0018\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b*\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e*\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010\"\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u000f0\u001e2\u0006\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010$\u001a\u00020\u001a*\u00020\u001aH\u0000¢\u0006\u0004\b$\u0010%\u001a!\u0010'\u001a\u00020\u001a*\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0002¢\u0006\u0004\b'\u0010(\u001a\u001b\u0010*\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010)\u001a\u00020\u001aH\u0000¢\u0006\u0004\b*\u0010+\"\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-\"\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010-\"\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010-\"\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010-¨\u00061"}, d2 = {"Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/statement/HttpResponse;", "value", "", "isShared", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "store", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/http/Url;Lio/ktor/client/statement/HttpResponse;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "response", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/HttpClient;", "client", "Lio/ktor/client/request/HttpRequest;", "request", "Lkotlin/coroutines/CoroutineContext;", "responseContext", "createResponse", "(Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/http/Headers;", "", "connectionOptionFieldNames", "(Lio/ktor/http/Headers;)Ljava/util/Set;", "", "excludedNamesForCacheStorage", "(Lio/ktor/http/Headers;)Ljava/util/List;", "element", "containsIgnoreCase", "(Ljava/util/List;Ljava/lang/String;)Z", "filterForCacheStorage", "(Lio/ktor/http/Headers;)Lio/ktor/http/Headers;", "excluded", "filterExcluded", "(Lio/ktor/http/Headers;Ljava/util/List;)Lio/ktor/http/Headers;", "other", "merge", "(Lio/ktor/http/Headers;Lio/ktor/http/Headers;)Lio/ktor/http/Headers;", "hopByHopHeaders", "Ljava/util/List;", "proxyAuthHeaders", "staticStorageExcludedHeaders", "connectionOptionsWithoutFieldNames", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpCacheStorageKt {
    private static final List<String> connectionOptionsWithoutFieldNames;
    private static final List<String> hopByHopHeaders;
    private static final List<String> proxyAuthHeaders;
    private static final List<String> staticStorageExcludedHeaders;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.HttpCacheStorageKt", f = "HttpCacheStorage.kt", l = {UCrop.REQUEST_CROP}, m = "store", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCacheStorageKt.store((HttpCacheStorage) null, (Url) null, (HttpResponse) null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.HttpCacheStorageKt", f = "HttpCacheStorage.kt", l = {166, 178}, m = "store", v = 1)
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCacheStorageKt.store((CacheStorage) null, (HttpResponse) null, (Map<String, String>) null, false, (Continuation) this);
        }
    }

    static {
        List<String> listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{HttpHeaders.Connection, HttpHeaders.TE, HttpHeaders.TransferEncoding, HttpHeaders.Upgrade, HttpHeaders.ContentRange, "Keep-Alive", "Proxy-Connection"});
        hopByHopHeaders = listListOf;
        List<String> listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{HttpHeaders.ProxyAuthenticate, HttpHeaders.ProxyAuthenticationInfo, HttpHeaders.ProxyAuthorization});
        proxyAuthHeaders = listListOf2;
        staticStorageExcludedHeaders = CollectionsKt.plus((Iterable) listListOf2, (Collection) listListOf);
        connectionOptionsWithoutFieldNames = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"close", "keep-alive", "upgrade"});
    }

    private static final Set<String> connectionOptionFieldNames(Headers headers) {
        String str = headers.get(HttpHeaders.Connection);
        if (str == null) {
            return EmptySet.INSTANCE;
        }
        int i = 0;
        List listSplit$default = StringsKt.split$default(str, new char[]{','});
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str2 = (String) obj;
            if (str2.length() > 0) {
                List<String> list = connectionOptionsWithoutFieldNames;
                String lowerCase = str2.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                if (!list.contains(lowerCase)) {
                    arrayList2.add(obj);
                }
            }
        }
        return CollectionsKt.toSet(arrayList2);
    }

    private static final boolean containsIgnoreCase(List<String> list, String str) {
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), str, true)) {
                return true;
            }
        }
        return false;
    }

    public static final HttpResponse createResponse(final CachedResponseData cachedResponseData, HttpClient httpClient, HttpRequest httpRequest, final CoroutineContext coroutineContext) {
        cachedResponseData.getClass();
        httpClient.getClass();
        httpRequest.getClass();
        coroutineContext.getClass();
        return new SavedHttpCall(httpClient, httpRequest, new HttpResponse(cachedResponseData, coroutineContext) { // from class: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$createResponse$response$1
            private final CoroutineContext coroutineContext;
            private final Headers headers;
            private final GMTDate requestTime;
            private final GMTDate responseTime;
            private final HttpStatusCode status;
            private final HttpProtocolVersion version;

            {
                this.status = cachedResponseData.getStatusCode();
                this.version = cachedResponseData.getVersion();
                this.requestTime = cachedResponseData.getRequestTime();
                this.responseTime = cachedResponseData.getResponseTime();
                this.headers = cachedResponseData.getHeaders();
                this.coroutineContext = coroutineContext;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpClientCall getCall() {
                throw new IllegalStateException("This is a fake response");
            }

            @Override // io.ktor.client.statement.HttpResponse, kotlinx.coroutines.CoroutineScope
            public CoroutineContext getCoroutineContext() {
                return this.coroutineContext;
            }

            @Override // io.ktor.http.HttpMessage
            public Headers getHeaders() {
                return this.headers;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public ByteReadChannel getRawContent() {
                throw new IllegalStateException("This is a fake response");
            }

            @Override // io.ktor.client.statement.HttpResponse
            public GMTDate getRequestTime() {
                return this.requestTime;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public GMTDate getResponseTime() {
                return this.responseTime;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpStatusCode getStatus() {
                return this.status;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpProtocolVersion getVersion() {
                return this.version;
            }

            public static /* synthetic */ void getRawContent$annotations() {
            }
        }, cachedResponseData.getBody()).getResponse();
    }

    private static final List<String> excludedNamesForCacheStorage(Headers headers) {
        Set<String> setConnectionOptionFieldNames = connectionOptionFieldNames(headers);
        if (setConnectionOptionFieldNames.isEmpty()) {
            return staticStorageExcludedHeaders;
        }
        return CollectionsKt.plus((Iterable) setConnectionOptionFieldNames, (Collection) staticStorageExcludedHeaders);
    }

    private static final Headers filterExcluded(Headers headers, List<String> list) {
        Headers.Companion companion = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        for (Map.Entry<String, List<String>> entry : headers.entries()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (!containsIgnoreCase(list, key)) {
                headersBuilder.appendAll(key, value);
            }
        }
        return headersBuilder.build();
    }

    public static final Headers filterForCacheStorage(Headers headers) {
        headers.getClass();
        return filterExcluded(headers, excludedNamesForCacheStorage(headers));
    }

    public static final Headers merge(Headers headers, Headers headers2) {
        headers.getClass();
        headers2.getClass();
        Headers.Companion companion = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.appendAll(headers);
        ArrayList arrayListPlus = CollectionsKt.plus(HttpHeaders.ContentLength, excludedNamesForCacheStorage(headers2));
        for (Map.Entry<String, List<String>> entry : headers2.entries()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (!containsIgnoreCase(arrayListPlus, key)) {
                headersBuilder.remove(key);
                headersBuilder.appendAll(key, value);
            }
        }
        return headersBuilder.build();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object store(CacheStorage cacheStorage, HttpResponse httpResponse, Map<String, String> map, boolean z, Continuation continuation) {
        AnonymousClass3 anonymousClass3;
        CacheStorage cacheStorage2;
        HttpResponse httpResponse2;
        Map<String, String> map2;
        Url url;
        Object obj;
        boolean z2;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i = anonymousClass3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object obj2 = anonymousClass3.result;
        int i2 = anonymousClass3.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Url url2 = httpResponse.getCall().getRequest().getUrl();
            ByteReadChannel rawContent = httpResponse.getRawContent();
            cacheStorage2 = cacheStorage;
            anonymousClass3.L$0 = cacheStorage2;
            httpResponse2 = httpResponse;
            anonymousClass3.L$1 = httpResponse2;
            anonymousClass3.L$2 = map;
            anonymousClass3.L$3 = url2;
            anonymousClass3.Z$0 = z;
            anonymousClass3.label = 1;
            Object buffer = ByteReadChannelOperationsKt.readBuffer(rawContent, anonymousClass3);
            if (buffer != coroutineSingletons) {
                map2 = map;
                url = url2;
                obj = buffer;
                z2 = z;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            CachedResponseData cachedResponseData = (CachedResponseData) anonymousClass3.L$5;
            ResultKt.throwOnFailure(obj2);
            return cachedResponseData;
        }
        boolean z3 = anonymousClass3.Z$0;
        Url url3 = (Url) anonymousClass3.L$3;
        Map<String, String> map3 = (Map) anonymousClass3.L$2;
        HttpResponse httpResponse3 = (HttpResponse) anonymousClass3.L$1;
        CacheStorage cacheStorage3 = (CacheStorage) anonymousClass3.L$0;
        ResultKt.throwOnFailure(obj2);
        map2 = map3;
        httpResponse2 = httpResponse3;
        url = url3;
        obj = obj2;
        z2 = z3;
        cacheStorage2 = cacheStorage3;
        byte[] bytes$default = BuffersKt.readBytes$default((Buffer) obj, 0, 1, null);
        Url url4 = url;
        CachedResponseData cachedResponseData2 = new CachedResponseData(httpResponse2.getCall().getRequest().getUrl(), httpResponse2.getStatus(), httpResponse2.getRequestTime(), httpResponse2.getResponseTime(), httpResponse2.getVersion(), HttpCacheEntryKt.cacheExpires$default(httpResponse2, z2, null, 2, null), filterForCacheStorage(httpResponse2.getHeaders()), map2, bytes$default);
        anonymousClass3.L$0 = null;
        anonymousClass3.L$1 = null;
        anonymousClass3.L$2 = null;
        anonymousClass3.L$3 = null;
        anonymousClass3.L$4 = null;
        anonymousClass3.L$5 = cachedResponseData2;
        anonymousClass3.Z$0 = z2;
        anonymousClass3.label = 2;
        return cacheStorage2.store(url4, cachedResponseData2, anonymousClass3) == coroutineSingletons ? coroutineSingletons : cachedResponseData2;
    }

    public static /* synthetic */ Object store$default(CacheStorage cacheStorage, HttpResponse httpResponse, Map map, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return store(cacheStorage, httpResponse, (Map<String, String>) map, z, continuation);
    }

    @Deprecated
    public static final Object store(CacheStorage cacheStorage, HttpResponse httpResponse, Continuation continuation) {
        return store$default(cacheStorage, httpResponse, HttpCacheEntryKt.varyKeys(httpResponse), false, continuation, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object store(HttpCacheStorage httpCacheStorage, Url url, HttpResponse httpResponse, boolean z, Continuation continuation) {
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
        Object objHttpCacheEntry = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objHttpCacheEntry);
            anonymousClass1.L$0 = httpCacheStorage;
            anonymousClass1.L$1 = url;
            anonymousClass1.L$2 = null;
            anonymousClass1.Z$0 = z;
            anonymousClass1.label = 1;
            objHttpCacheEntry = HttpCacheEntryKt.HttpCacheEntry(z, httpResponse, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objHttpCacheEntry == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            url = (Url) anonymousClass1.L$1;
            httpCacheStorage = (HttpCacheStorage) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objHttpCacheEntry);
        }
        HttpCacheEntry httpCacheEntry = (HttpCacheEntry) objHttpCacheEntry;
        httpCacheStorage.store(url, httpCacheEntry);
        return httpCacheEntry;
    }
}
