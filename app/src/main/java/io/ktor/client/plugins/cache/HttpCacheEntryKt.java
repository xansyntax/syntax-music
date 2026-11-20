package io.ktor.client.plugins.cache;

import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.DateUtilsKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.EntityTagVersion;
import io.ktor.http.content.VersionCheckResult;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.DateKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\b*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000b*\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u0011\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a7\u0010 \u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000f2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u001f\u001a\u00020\u0013H\u0000¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"", "isShared", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "HttpCacheEntry", "(ZLio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "joinHeaderValues", "(Ljava/util/List;)Ljava/lang/String;", "", "varyKeys", "(Lio/ktor/client/statement/HttpResponse;)Ljava/util/Map;", "Lkotlin/Function0;", "Lio/ktor/util/date/GMTDate;", "fallback", "cacheExpires", "(Lio/ktor/client/statement/HttpResponse;ZLkotlin/jvm/functions/Function0;)Lio/ktor/util/date/GMTDate;", "Lio/ktor/http/Headers;", "responseHeaders", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/client/plugins/cache/ValidateStatus;", "shouldValidate", "(Lio/ktor/util/date/GMTDate;Lio/ktor/http/Headers;Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/plugins/cache/ValidateStatus;", "cachedEtag", "validationEtag", "etagMatches", "(Ljava/lang/String;Ljava/lang/String;)Z", "expires", "mergedHeaders", "withFreshenedMetadata", "(Lio/ktor/client/plugins/cache/HttpCacheEntry;Lio/ktor/util/date/GMTDate;Ljava/util/Map;Lio/ktor/http/Headers;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpCacheEntryKt {

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheEntryKt", f = "HttpCacheEntry.kt", l = {20}, m = "HttpCacheEntry", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
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
            return HttpCacheEntryKt.HttpCacheEntry(false, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object HttpCacheEntry(boolean z, HttpResponse httpResponse, Continuation continuation) {
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
        Object buffer = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(buffer);
            ByteReadChannel rawContent = httpResponse.getRawContent();
            anonymousClass1.L$0 = httpResponse;
            anonymousClass1.Z$0 = z;
            anonymousClass1.label = 1;
            buffer = ByteReadChannelOperationsKt.readBuffer(rawContent, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (buffer == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = anonymousClass1.Z$0;
            httpResponse = (HttpResponse) anonymousClass1.L$0;
            ResultKt.throwOnFailure(buffer);
        }
        return new HttpCacheEntry(cacheExpires$default(httpResponse, z, null, 2, null), varyKeys(httpResponse), httpResponse, Utf8Kt.readByteArray((Source) buffer));
    }

    public static final GMTDate cacheExpires(HttpResponse httpResponse, boolean z, Function0 function0) {
        String str;
        Long longOrNull;
        Object next;
        String value;
        String str2;
        String value2;
        httpResponse.getClass();
        function0.getClass();
        List<HeaderValue> listCacheControl = HttpMessagePropertiesKt.cacheControl(httpResponse);
        if (z && (listCacheControl == null || !listCacheControl.isEmpty())) {
            Iterator<T> it = listCacheControl.iterator();
            do {
                if (!it.hasNext()) {
                    str = io.ktor.client.utils.CacheControl.MAX_AGE;
                    break;
                }
                value2 = ((HeaderValue) it.next()).getValue();
                str = io.ktor.client.utils.CacheControl.S_MAX_AGE;
            } while (!StringsKt__StringsJVMKt.startsWith(value2, io.ktor.client.utils.CacheControl.S_MAX_AGE, false));
        } else {
            str = io.ktor.client.utils.CacheControl.MAX_AGE;
            break;
        }
        Iterator<T> it2 = listCacheControl.iterator();
        do {
            longOrNull = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!StringsKt__StringsJVMKt.startsWith(((HeaderValue) next).getValue(), str, false));
        HeaderValue headerValue = (HeaderValue) next;
        if (headerValue != null && (value = headerValue.getValue()) != null && (str2 = (String) CollectionsKt.getOrNull(1, StringsKt.split$default(value, new String[]{"="}, 0, 6))) != null) {
            longOrNull = StringsKt__StringsJVMKt.toLongOrNull(10, str2);
        }
        if (longOrNull != null) {
            return DateKt.plus(httpResponse.getRequestTime(), longOrNull.longValue() * 1000);
        }
        String str3 = httpResponse.getHeaders().get(HttpHeaders.Expires);
        if (str3 == null) {
            return (GMTDate) function0.invoke();
        }
        if (str3.equals("0") || StringsKt.isBlank(str3)) {
            return (GMTDate) function0.invoke();
        }
        try {
            return DateUtilsKt.fromHttpToGmtDate(str3);
        } catch (Throwable unused) {
            return (GMTDate) function0.invoke();
        }
    }

    public static /* synthetic */ GMTDate cacheExpires$default(HttpResponse httpResponse, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Shazam$$ExternalSyntheticLambda0((byte) 27);
        }
        return cacheExpires(httpResponse, z, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GMTDate cacheExpires$lambda$0() {
        return DateJvmKt.GMTDate$default(null, 1, null);
    }

    public static final boolean etagMatches(String str, String str2) {
        str.getClass();
        str2.getClass();
        try {
            EntityTagVersion.Companion companion = EntityTagVersion.INSTANCE;
            return companion.parseSingle(str).noneMatch(CollectionsKt__IterablesKt.listOf(companion.parseSingle(str2))) == VersionCheckResult.NOT_MODIFIED;
        } catch (Throwable unused) {
        }
    }

    public static final String joinHeaderValues(List<String> list) {
        return list != null ? CollectionsKt.joinToString$default(list, ",", null, null, null, 62) : "";
    }

    public static final ValidateStatus shouldValidate(GMTDate gMTDate, Headers headers, HttpRequestBuilder httpRequestBuilder) {
        int iIntValue;
        Object next;
        Integer numValueOf;
        String value;
        Integer intOrNull;
        String value2;
        String str;
        gMTDate.getClass();
        headers.getClass();
        httpRequestBuilder.getClass();
        HeadersBuilder headers2 = httpRequestBuilder.getHeaders();
        List<String> all = headers.getAll(HttpHeaders.CacheControl);
        Object obj = null;
        List<HeaderValue> headerValue = HttpHeaderValueParserKt.parseHeaderValue(all != null ? CollectionsKt.joinToString$default(all, ",", null, null, null, 62) : null);
        List<String> all2 = headers2.getAll(HttpHeaders.CacheControl);
        List<HeaderValue> headerValue2 = HttpHeaderValueParserKt.parseHeaderValue(all2 != null ? CollectionsKt.joinToString$default(all2, ",", null, null, null, 62) : null);
        if (headerValue2.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            Logger logger = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("\"no-cache\" is set for " + httpRequestBuilder.getUrl() + ", should validate cached response");
            }
            return ValidateStatus.ShouldValidate;
        }
        Iterator<T> it = headerValue2.iterator();
        do {
            iIntValue = 0;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt__StringsJVMKt.startsWith(((HeaderValue) next).getValue(), "max-age=", false));
        HeaderValue headerValue3 = (HeaderValue) next;
        if (headerValue3 == null || (value2 = headerValue3.getValue()) == null || (str = (String) StringsKt.split$default(value2, new String[]{"="}, 0, 6).get(1)) == null) {
            numValueOf = null;
        } else {
            Integer intOrNull2 = StringsKt__StringsJVMKt.toIntOrNull(10, str);
            numValueOf = Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0);
        }
        if (numValueOf != null && numValueOf.intValue() == 0) {
            Logger logger2 = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger2)) {
                logger2.trace("\"max-age\" is not set for " + httpRequestBuilder.getUrl() + ", should validate cached response");
            }
            return ValidateStatus.ShouldValidate;
        }
        CacheControl cacheControl = CacheControl.INSTANCE;
        if (headerValue.contains(cacheControl.getNO_CACHE$ktor_client_core())) {
            Logger logger3 = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger3)) {
                logger3.trace("\"no-cache\" is set for " + httpRequestBuilder.getUrl() + ", should validate cached response");
            }
            return ValidateStatus.ShouldValidate;
        }
        long timestamp = gMTDate.getTimestamp() - DateJvmKt.getTimeMillis();
        if (timestamp > 0) {
            Logger logger4 = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger4)) {
                logger4.trace("Cached response is valid for " + httpRequestBuilder.getUrl() + ", should not validate");
            }
            return ValidateStatus.ShouldNotValidate;
        }
        if (headerValue.contains(cacheControl.getMUST_REVALIDATE$ktor_client_core())) {
            Logger logger5 = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger5)) {
                logger5.trace("\"must-revalidate\" is set for " + httpRequestBuilder.getUrl() + ", should validate cached response");
            }
            return ValidateStatus.ShouldValidate;
        }
        for (Object obj2 : headerValue2) {
            if (StringsKt__StringsJVMKt.startsWith(((HeaderValue) obj2).getValue(), "max-stale=", false)) {
                obj = obj2;
                break;
            }
        }
        HeaderValue headerValue4 = (HeaderValue) obj;
        if (headerValue4 != null && (value = headerValue4.getValue()) != null && (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, value.substring(10))) != null) {
            iIntValue = intOrNull.intValue();
        }
        if ((((long) iIntValue) * 1000) + timestamp > 0) {
            Logger logger6 = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger6)) {
                logger6.trace("Cached response is stale for " + httpRequestBuilder.getUrl() + " but less than max-stale, should warn");
            }
            return ValidateStatus.ShouldWarn;
        }
        Logger logger7 = HttpCacheKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled(logger7)) {
            logger7.trace("Cached response is stale for " + httpRequestBuilder.getUrl() + ", should validate cached response");
        }
        return ValidateStatus.ShouldValidate;
    }

    public static final Map<String, String> varyKeys(HttpResponse httpResponse) {
        httpResponse.getClass();
        List<String> listVary = HttpMessagePropertiesKt.vary(httpResponse);
        if (listVary == null) {
            return EmptyMap.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Headers headers = httpResponse.getCall().getRequest().getHeaders();
        for (String str : listVary) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            linkedHashMap.put(lowerCase, joinHeaderValues(headers.getAll(str)));
        }
        return linkedHashMap;
    }

    public static final HttpCacheEntry withFreshenedMetadata(final HttpCacheEntry httpCacheEntry, GMTDate gMTDate, Map<String, String> map, final Headers headers) {
        httpCacheEntry.getClass();
        gMTDate.getClass();
        map.getClass();
        headers.getClass();
        return new HttpCacheEntry(gMTDate, map, new HttpResponse(headers, httpCacheEntry) { // from class: io.ktor.client.plugins.cache.HttpCacheEntryKt$withFreshenedMetadata$freshenedResponse$1
            final /* synthetic */ HttpCacheEntry $this_withFreshenedMetadata;
            private final Headers headers;

            {
                this.$this_withFreshenedMetadata = httpCacheEntry;
                this.headers = headers;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpClientCall getCall() {
                return this.$this_withFreshenedMetadata.getResponse().getCall();
            }

            @Override // io.ktor.client.statement.HttpResponse, kotlinx.coroutines.CoroutineScope
            public CoroutineContext getCoroutineContext() {
                return this.$this_withFreshenedMetadata.getResponse().getCoroutineContext();
            }

            @Override // io.ktor.http.HttpMessage
            public Headers getHeaders() {
                return this.headers;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public ByteReadChannel getRawContent() {
                return this.$this_withFreshenedMetadata.getResponse().getRawContent();
            }

            @Override // io.ktor.client.statement.HttpResponse
            public GMTDate getRequestTime() {
                return this.$this_withFreshenedMetadata.getResponse().getRequestTime();
            }

            @Override // io.ktor.client.statement.HttpResponse
            public GMTDate getResponseTime() {
                return this.$this_withFreshenedMetadata.getResponse().getResponseTime();
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpStatusCode getStatus() {
                return this.$this_withFreshenedMetadata.getResponse().getStatus();
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpProtocolVersion getVersion() {
                return this.$this_withFreshenedMetadata.getResponse().getVersion();
            }

            public static /* synthetic */ void getRawContent$annotations() {
            }
        }, httpCacheEntry.getBody());
    }
}
