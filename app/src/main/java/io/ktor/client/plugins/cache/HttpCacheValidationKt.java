package io.ktor.client.plugins.cache;

import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aL\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022*\u0010\u0007\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0080@¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/client/request/HttpRequest;", "request", "Lio/ktor/client/statement/HttpResponse;", "response", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "findAndRefresh", "refreshNotModifiedResponse", "(Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E", "", "Lkotlin/Function1;", "Lio/ktor/http/Headers;", "headers", "selectResponseToFreshen", "(Ljava/util/List;Lio/ktor/client/statement/HttpResponse;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "haveNoValidator", "(Lio/ktor/http/Headers;)Z", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpCacheValidationKt {

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.HttpCacheValidationKt$refreshNotModifiedResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheValidationKt", f = "HttpCacheValidation.kt", l = {16}, m = "refreshNotModifiedResponse", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCacheValidationKt.refreshNotModifiedResponse(null, null, null, this);
        }
    }

    private static final boolean haveNoValidator(Headers headers) {
        return (headers.contains(HttpHeaders.ETag) || headers.contains(HttpHeaders.LastModified)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object refreshNotModifiedResponse(HttpRequest httpRequest, HttpResponse httpResponse, Function3 function3, Continuation continuation) {
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
        Object objInvoke = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            anonymousClass1.L$0 = httpRequest;
            anonymousClass1.L$1 = httpResponse;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 1;
            objInvoke = function3.invoke(httpRequest, httpResponse, anonymousClass1);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            httpResponse = (HttpResponse) anonymousClass1.L$1;
            httpRequest = (HttpRequest) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objInvoke);
        }
        HttpResponse httpResponse2 = (HttpResponse) objInvoke;
        if (httpResponse2 == null) {
            throw new InvalidCacheStateException(httpRequest.getUrl());
        }
        if (HttpCacheEntryKt.varyKeys(httpResponse2).size() != HttpCacheEntryKt.varyKeys(httpResponse).size()) {
            HttpCacheKt.getLOGGER().warn("Vary header mismatch on cached response for " + httpRequest.getUrl() + ". Received 304 Not Modified with Vary: " + HttpCacheEntryKt.varyKeys(httpResponse) + " but cached response has Vary: " + HttpCacheEntryKt.varyKeys(httpResponse2) + ". According to RFC 9110 §15.4.5 and RFC 9111 §4.1, the server must include the full Vary header in 304 responses. Proceeding with cached response despite Vary mismatch. Consider reporting this issue to the server maintainers.");
        }
        return httpResponse2;
    }

    public static final <E> E selectResponseToFreshen(List<? extends E> list, HttpResponse httpResponse, Function1 function1) {
        list.getClass();
        httpResponse.getClass();
        function1.getClass();
        if (haveNoValidator(httpResponse.getHeaders()) && list.size() == 1) {
            E e = (E) CollectionsKt.first((List) list);
            if (haveNoValidator((Headers) function1.invoke(e))) {
                return e;
            }
            return null;
        }
        String str = httpResponse.getHeaders().get(HttpHeaders.ETag);
        if (str == null) {
            return null;
        }
        for (E e2 : list) {
            String str2 = ((Headers) function1.invoke(e2)).get(HttpHeaders.ETag);
            if (str2 != null && HttpCacheEntryKt.etagMatches(str2, str)) {
                return e2;
            }
        }
        return null;
    }
}
