package com.metrolist.innertubex.cipher;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RestrictedHttpFetchKt$getTextWithoutRedirects$3 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $maxBytes;
    public final /* synthetic */ Function2 $stopWhen;
    public /* synthetic */ Object L$0;
    public HttpStatusCode L$1;
    public Headers L$2;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestrictedHttpFetchKt$getTextWithoutRedirects$3(int i, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$maxBytes = i;
        this.$stopWhen = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RestrictedHttpFetchKt$getTextWithoutRedirects$3 restrictedHttpFetchKt$getTextWithoutRedirects$3 = new RestrictedHttpFetchKt$getTextWithoutRedirects$3(this.$maxBytes, this.$stopWhen, continuation);
        restrictedHttpFetchKt$getTextWithoutRedirects$3.L$0 = obj;
        return restrictedHttpFetchKt$getTextWithoutRedirects$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((RestrictedHttpFetchKt$getTextWithoutRedirects$3) create((HttpResponse) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (r6 == r1) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpStatusCode httpStatusCode;
        Headers headers;
        HttpResponse httpResponse = (HttpResponse) this.L$0;
        byte b = this.label;
        if (b != 0) {
            if (b == 1) {
                headers = this.L$2;
                httpStatusCode = this.L$1;
                ResultKt.throwOnFailure(obj);
                return new RestrictedTextResponse(httpStatusCode, headers, (String) obj);
            }
            if (b != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ((ByteReadChannel) obj).cancel(null);
            return new RestrictedTextResponse(httpResponse.getStatus(), httpResponse.getHeaders(), null);
        }
        ResultKt.throwOnFailure(obj);
        boolean zIsSuccess = HttpStatusCodeKt.isSuccess(httpResponse.getStatus());
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (zIsSuccess) {
            HttpStatusCode status = httpResponse.getStatus();
            Headers headers2 = httpResponse.getHeaders();
            this.L$0 = null;
            this.L$1 = status;
            this.L$2 = headers2;
            this.label = (byte) 1;
            Object objBodyAsTextLimited = CollectionsKt__IterablesKt.bodyAsTextLimited(httpResponse, this.$maxBytes, this.$stopWhen, this);
            if (objBodyAsTextLimited != coroutineSingletons) {
                obj = objBodyAsTextLimited;
                httpStatusCode = status;
                headers = headers2;
                return new RestrictedTextResponse(httpStatusCode, headers, (String) obj);
            }
        } else {
            this.L$0 = httpResponse;
            this.label = (byte) 2;
            obj = HttpResponseKt.bodyAsChannel(httpResponse, this);
        }
        return coroutineSingletons;
    }
}
