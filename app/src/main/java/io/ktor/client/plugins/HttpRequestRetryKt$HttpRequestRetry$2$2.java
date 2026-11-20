package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.logging.LoggerJvmKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$IntRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetryKt$HttpRequestRetry$2$2", f = "HttpRequestRetry.kt", l = {358, 361, 377}, m = "invokeSuspend", v = 1)
public final class HttpRequestRetryKt$HttpRequestRetry$2$2 extends SuspendLambda implements Function3 {
    final /* synthetic */ Function2 $delay;
    final /* synthetic */ Function2 $delayMillis;
    final /* synthetic */ int $maxRetries;
    final /* synthetic */ Function2 $modifyRequest;
    final /* synthetic */ Function3 $shouldRetry;
    final /* synthetic */ Function3 $shouldRetryOnException;
    final /* synthetic */ ClientPluginBuilder<HttpRequestRetryConfig> $this_createClientPlugin;
    int I$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestRetryKt$HttpRequestRetry$2$2(Function3 function3, Function3 function4, int i, Function2 function2, Function2 function5, ClientPluginBuilder<HttpRequestRetryConfig> clientPluginBuilder, Function2 function6, Continuation continuation) {
        super(3, continuation);
        this.$shouldRetry = function3;
        this.$shouldRetryOnException = function4;
        this.$maxRetries = i;
        this.$delayMillis = function2;
        this.$modifyRequest = function5;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$delay = function6;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        HttpRequestRetryKt$HttpRequestRetry$2$2 httpRequestRetryKt$HttpRequestRetry$2$2 = new HttpRequestRetryKt$HttpRequestRetry$2$2(this.$shouldRetry, this.$shouldRetryOnException, this.$maxRetries, this.$delayMillis, this.$modifyRequest, this.$this_createClientPlugin, this.$delay, continuation);
        httpRequestRetryKt$HttpRequestRetry$2$2.L$0 = sender;
        httpRequestRetryKt$HttpRequestRetry$2$2.L$1 = httpRequestBuilder;
        return httpRequestRetryKt$HttpRequestRetry$2$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(2:67|38) */
    /* JADX WARN: Code duplicated, block: B:43:0x0164  */
    /* JADX WARN: Code duplicated, block: B:44:0x0166 A[Catch: all -> 0x013d, PHI: r0 r9 r10 r11 r12 r13 r14 r15
      0x0166: PHI (r0v7 java.lang.Object) = (r0v12 java.lang.Object), (r0v27 java.lang.Object) binds: [B:42:0x0162, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x0166: PHI (r9v4 int) = (r9v5 int), (r9v14 int) binds: [B:42:0x0162, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x0166: PHI (r10v3 io.ktor.client.request.HttpRequestBuilder) = (r10v4 io.ktor.client.request.HttpRequestBuilder), (r10v17 io.ktor.client.request.HttpRequestBuilder) binds: [B:42:0x0162, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x0166: PHI (r11v4 kotlin.jvm.functions.Function2) = (r11v5 kotlin.jvm.functions.Function2), (r11v17 kotlin.jvm.functions.Function2) binds: [B:42:0x0162, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x0166: PHI (r12v4 kotlin.jvm.functions.Function2) = (r12v5 kotlin.jvm.functions.Function2), (r12v15 kotlin.jvm.functions.Function2) binds: [B:42:0x0162, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x0166: PHI (r13v4 kotlin.jvm.functions.Function3) = (r13v5 kotlin.jvm.functions.Function3), (r13v16 kotlin.jvm.functions.Function3) binds: [B:42:0x0162, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x0166: PHI (r14v4 kotlin.jvm.functions.Function3) = (r14v5 kotlin.jvm.functions.Function3), (r14v11 kotlin.jvm.functions.Function3) binds: [B:42:0x0162, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x0166: PHI (r15v5 kotlin.jvm.internal.Ref$IntRef) = (r15v6 kotlin.jvm.internal.Ref$IntRef), (r15v11 kotlin.jvm.internal.Ref$IntRef) binds: [B:42:0x0162, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x013d, blocks: (B:38:0x0128, B:41:0x0141, B:44:0x0166, B:46:0x0170), top: B:67:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0170 A[Catch: all -> 0x013d, TRY_LEAVE, TryCatch #1 {all -> 0x013d, blocks: (B:38:0x0128, B:41:0x0141, B:44:0x0166, B:46:0x0170), top: B:67:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0193  */
    /* JADX WARN: Code duplicated, block: B:51:0x0195 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0196 A[Catch: all -> 0x0083, TRY_LEAVE, TryCatch #0 {all -> 0x0083, blocks: (B:48:0x018b, B:52:0x0196, B:12:0x007f, B:17:0x00ae), top: B:66:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x024a  */
    /* JADX WARN: Code duplicated, block: B:67:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x013d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0218, code lost:
    
        if (r5.invoke(r4, r17) == r8) goto L60;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0218 -> B:8:0x004c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z;
        Ref$IntRef ref$IntRef;
        Function3 function3;
        Function3 function4;
        Function2 function2;
        Function2 function5;
        int i;
        HttpRetryEventData httpRetryEventData;
        int i2;
        Function2 function6;
        Function2 function7;
        Function3 function8;
        Function3 function9;
        Ref$IntRef ref$IntRef2;
        HttpRetryEventData httpRetryEventData2;
        char c;
        HttpRequestBuilder httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest;
        Object objProceed;
        HttpClientCall httpClientCall;
        HttpResponse response;
        HttpRetryEventData httpRetryEventData3;
        Send.Sender sender = (Send.Sender) this.L$0;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
        int i3 = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref$IntRef ref$IntRef3 = new Ref$IntRef();
                Function3 function10 = (Function3) httpRequestBuilder.getAttributes().getOrNull(HttpRequestRetryKt.ShouldRetryPerRequestAttributeKey);
                if (function10 == null) {
                    function10 = this.$shouldRetry;
                }
                Function3 function11 = (Function3) httpRequestBuilder.getAttributes().getOrNull(HttpRequestRetryKt.ShouldRetryOnExceptionPerRequestAttributeKey);
                if (function11 == null) {
                    function11 = this.$shouldRetryOnException;
                }
                Integer num = (Integer) httpRequestBuilder.getAttributes().getOrNull(HttpRequestRetryKt.getMaxRetriesPerRequestAttributeKey());
                int iIntValue = num != null ? num.intValue() : this.$maxRetries;
                function2 = (Function2) httpRequestBuilder.getAttributes().getOrNull(HttpRequestRetryKt.RetryDelayPerRequestAttributeKey);
                if (function2 == null) {
                    function2 = this.$delayMillis;
                }
                Function2 function12 = (Function2) httpRequestBuilder.getAttributes().getOrNull(HttpRequestRetryKt.ModifyRequestPerRequestAttributeKey);
                if (function12 == null) {
                    function12 = this.$modifyRequest;
                }
                ref$IntRef = ref$IntRef3;
                httpRetryEventData3 = null;
                function3 = function10;
                i = iIntValue;
                function5 = function12;
                function4 = function11;
                httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest = HttpRequestRetryKt.HttpRequestRetry$lambda$0$prepareRequest(httpRequestBuilder);
                if (httpRetryEventData3 != null) {
                    function5.invoke(new HttpRetryModifyRequestContext(httpRequestBuilder, httpRetryEventData3.getResponse(), httpRetryEventData3.getCause(), httpRetryEventData3.getRetryCount()), httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest);
                }
                this.L$0 = sender;
                this.L$1 = httpRequestBuilder;
                this.L$2 = ref$IntRef;
                this.L$3 = function3;
                this.L$4 = function4;
                this.L$5 = function2;
                this.L$6 = function5;
                this.L$7 = null;
                this.L$8 = null;
                this.L$9 = httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest;
                this.L$10 = null;
                this.L$11 = null;
                this.I$0 = i;
                this.label = 1;
                objProceed = sender.proceed(httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest, this);
                if (objProceed == coroutineSingletons) {
                    httpClientCall = (HttpClientCall) objProceed;
                    if (HttpRequestRetryKt.HttpRequestRetry$lambda$0$shouldRetry(ref$IntRef.element, i, function3, httpClientCall)) {
                        int i4 = ref$IntRef.element + 1;
                        ref$IntRef.element = i4;
                        httpRetryEventData = new HttpRetryEventData(httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest, i4, httpClientCall.getResponse(), null);
                        z = true;
                        i2 = i;
                        function6 = function5;
                        function7 = function2;
                        function8 = function4;
                        function9 = function3;
                        ref$IntRef2 = ref$IntRef;
                        httpRetryEventData2 = httpRetryEventData;
                        this.$this_createClientPlugin.getClient().getMonitor().raise(HttpRequestRetryKt.getHttpRequestRetryEvent(), httpRetryEventData2);
                        HttpRetryDelayContext httpRetryDelayContext = new HttpRetryDelayContext(httpRetryEventData2.getRequest(), httpRetryEventData2.getResponse(), httpRetryEventData2.getCause());
                        Function2 function13 = this.$delay;
                        Object objInvoke = function7.invoke(httpRetryDelayContext, new Integer(ref$IntRef2.element));
                        this.L$0 = sender;
                        this.L$1 = httpRequestBuilder;
                        this.L$2 = ref$IntRef2;
                        this.L$3 = function9;
                        this.L$4 = function8;
                        this.L$5 = function7;
                        this.L$6 = function6;
                        this.L$7 = null;
                        this.L$8 = httpRetryEventData2;
                        this.L$9 = null;
                        this.L$10 = null;
                        this.L$11 = null;
                        this.I$0 = i2;
                        c = 3;
                        this.label = 3;
                    } else {
                        response = httpClientCall.getResponse();
                        this.L$0 = sender;
                        this.L$1 = httpRequestBuilder;
                        this.L$2 = ref$IntRef;
                        this.L$3 = function3;
                        this.L$4 = function4;
                        this.L$5 = function2;
                        this.L$6 = function5;
                        this.L$7 = httpClientCall;
                        this.L$8 = null;
                        this.L$9 = httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest;
                        this.I$0 = i;
                        this.label = 2;
                        if (HttpRequestRetryKt.throwOnInvalidResponseBody(response, this) != coroutineSingletons) {
                            return httpClientCall;
                        }
                    }
                }
                return coroutineSingletons;
            }
            if (i3 == 1) {
                i = this.I$0;
                httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest = (HttpRequestBuilder) this.L$9;
                function5 = (Function2) this.L$6;
                function2 = (Function2) this.L$5;
                function4 = (Function3) this.L$4;
                function3 = (Function3) this.L$3;
                ref$IntRef = (Ref$IntRef) this.L$2;
                ResultKt.throwOnFailure(obj);
                objProceed = obj;
                httpClientCall = (HttpClientCall) objProceed;
                if (HttpRequestRetryKt.HttpRequestRetry$lambda$0$shouldRetry(ref$IntRef.element, i, function3, httpClientCall)) {
                    response = httpClientCall.getResponse();
                    this.L$0 = sender;
                    this.L$1 = httpRequestBuilder;
                    this.L$2 = ref$IntRef;
                    this.L$3 = function3;
                    this.L$4 = function4;
                    this.L$5 = function2;
                    this.L$6 = function5;
                    this.L$7 = httpClientCall;
                    this.L$8 = null;
                    this.L$9 = httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest;
                    this.I$0 = i;
                    this.label = 2;
                    if (HttpRequestRetryKt.throwOnInvalidResponseBody(response, this) != coroutineSingletons) {
                        return httpClientCall;
                    }
                } else {
                    int i5 = ref$IntRef.element + 1;
                    ref$IntRef.element = i5;
                    httpRetryEventData = new HttpRetryEventData(httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest, i5, httpClientCall.getResponse(), null);
                    z = true;
                    i2 = i;
                    function6 = function5;
                    function7 = function2;
                    function8 = function4;
                    function9 = function3;
                    ref$IntRef2 = ref$IntRef;
                    httpRetryEventData2 = httpRetryEventData;
                    this.$this_createClientPlugin.getClient().getMonitor().raise(HttpRequestRetryKt.getHttpRequestRetryEvent(), httpRetryEventData2);
                    HttpRetryDelayContext httpRetryDelayContext2 = new HttpRetryDelayContext(httpRetryEventData2.getRequest(), httpRetryEventData2.getResponse(), httpRetryEventData2.getCause());
                    Function2 function14 = this.$delay;
                    Object objInvoke2 = function7.invoke(httpRetryDelayContext2, new Integer(ref$IntRef2.element));
                    this.L$0 = sender;
                    this.L$1 = httpRequestBuilder;
                    this.L$2 = ref$IntRef2;
                    this.L$3 = function9;
                    this.L$4 = function8;
                    this.L$5 = function7;
                    this.L$6 = function6;
                    this.L$7 = null;
                    this.L$8 = httpRetryEventData2;
                    this.L$9 = null;
                    this.L$10 = null;
                    this.L$11 = null;
                    this.I$0 = i2;
                    c = 3;
                    this.label = 3;
                }
                return coroutineSingletons;
            }
            if (i3 == 2) {
                int i6 = this.I$0;
                HttpClientCall httpClientCall2 = (HttpClientCall) this.L$7;
                ResultKt.throwOnFailure(obj);
                return httpClientCall2;
            }
            if (i3 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i2 = this.I$0;
            httpRetryEventData2 = (HttpRetryEventData) this.L$8;
            function6 = (Function2) this.L$6;
            function7 = (Function2) this.L$5;
            function8 = (Function3) this.L$4;
            function9 = (Function3) this.L$3;
            ref$IntRef2 = (Ref$IntRef) this.L$2;
            ResultKt.throwOnFailure(obj);
            z = true;
            c = 3;
        } catch (Throwable th) {
            th = th;
            if (!HttpRequestRetryKt.HttpRequestRetry$lambda$0$shouldRetryOnException(ref$IntRef.element, i, function4, httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest, th)) {
                throw th;
            }
            z = true;
            int i7 = ref$IntRef.element + 1;
            ref$IntRef.element = i7;
            httpRetryEventData = new HttpRetryEventData(httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest, i7, null, th);
            i2 = i;
            function6 = function5;
            function7 = function2;
            function8 = function4;
            function9 = function3;
            ref$IntRef2 = ref$IntRef;
            httpRetryEventData2 = httpRetryEventData;
            this.$this_createClientPlugin.getClient().getMonitor().raise(HttpRequestRetryKt.getHttpRequestRetryEvent(), httpRetryEventData2);
            HttpRetryDelayContext httpRetryDelayContext3 = new HttpRetryDelayContext(httpRetryEventData2.getRequest(), httpRetryEventData2.getResponse(), httpRetryEventData2.getCause());
            Function2 function15 = this.$delay;
            Object objInvoke3 = function7.invoke(httpRetryDelayContext3, new Integer(ref$IntRef2.element));
            this.L$0 = sender;
            this.L$1 = httpRequestBuilder;
            this.L$2 = ref$IntRef2;
            this.L$3 = function9;
            this.L$4 = function8;
            this.L$5 = function7;
            this.L$6 = function6;
            this.L$7 = null;
            this.L$8 = httpRetryEventData2;
            this.L$9 = null;
            this.L$10 = null;
            this.L$11 = null;
            this.I$0 = i2;
            c = 3;
            this.label = 3;
        }
        HttpRetryEventData httpRetryEventData4 = httpRetryEventData2;
        i = i2;
        httpRetryEventData3 = httpRetryEventData4;
        ref$IntRef = ref$IntRef2;
        function3 = function9;
        function4 = function8;
        function2 = function7;
        function5 = function6;
        Logger logger = HttpRequestRetryKt.LOGGER;
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Retrying request " + httpRequestBuilder.getUrl() + " attempt: " + ref$IntRef.element);
        }
        httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest = HttpRequestRetryKt.HttpRequestRetry$lambda$0$prepareRequest(httpRequestBuilder);
        if (httpRetryEventData3 != null) {
            function5.invoke(new HttpRetryModifyRequestContext(httpRequestBuilder, httpRetryEventData3.getResponse(), httpRetryEventData3.getCause(), httpRetryEventData3.getRetryCount()), httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest);
        }
        this.L$0 = sender;
        this.L$1 = httpRequestBuilder;
        this.L$2 = ref$IntRef;
        this.L$3 = function3;
        this.L$4 = function4;
        this.L$5 = function2;
        this.L$6 = function5;
        this.L$7 = null;
        this.L$8 = null;
        this.L$9 = httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest;
        this.L$10 = null;
        this.L$11 = null;
        this.I$0 = i;
        this.label = 1;
        objProceed = sender.proceed(httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest, this);
        if (objProceed == coroutineSingletons) {
            httpClientCall = (HttpClientCall) objProceed;
            if (HttpRequestRetryKt.HttpRequestRetry$lambda$0$shouldRetry(ref$IntRef.element, i, function3, httpClientCall)) {
                response = httpClientCall.getResponse();
                this.L$0 = sender;
                this.L$1 = httpRequestBuilder;
                this.L$2 = ref$IntRef;
                this.L$3 = function3;
                this.L$4 = function4;
                this.L$5 = function2;
                this.L$6 = function5;
                this.L$7 = httpClientCall;
                this.L$8 = null;
                this.L$9 = httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest;
                this.I$0 = i;
                this.label = 2;
                if (HttpRequestRetryKt.throwOnInvalidResponseBody(response, this) != coroutineSingletons) {
                    return httpClientCall;
                }
            } else {
                int i8 = ref$IntRef.element + 1;
                ref$IntRef.element = i8;
                httpRetryEventData = new HttpRetryEventData(httpRequestBuilderHttpRequestRetry$lambda$0$prepareRequest, i8, httpClientCall.getResponse(), null);
                z = true;
                i2 = i;
                function6 = function5;
                function7 = function2;
                function8 = function4;
                function9 = function3;
                ref$IntRef2 = ref$IntRef;
                httpRetryEventData2 = httpRetryEventData;
                this.$this_createClientPlugin.getClient().getMonitor().raise(HttpRequestRetryKt.getHttpRequestRetryEvent(), httpRetryEventData2);
                HttpRetryDelayContext httpRetryDelayContext4 = new HttpRetryDelayContext(httpRetryEventData2.getRequest(), httpRetryEventData2.getResponse(), httpRetryEventData2.getCause());
                Function2 function16 = this.$delay;
                Object objInvoke4 = function7.invoke(httpRetryDelayContext4, new Integer(ref$IntRef2.element));
                this.L$0 = sender;
                this.L$1 = httpRequestBuilder;
                this.L$2 = ref$IntRef2;
                this.L$3 = function9;
                this.L$4 = function8;
                this.L$5 = function7;
                this.L$6 = function6;
                this.L$7 = null;
                this.L$8 = httpRetryEventData2;
                this.L$9 = null;
                this.L$10 = null;
                this.L$11 = null;
                this.I$0 = i2;
                c = 3;
                this.label = 3;
            }
        }
        return coroutineSingletons;
    }
}
