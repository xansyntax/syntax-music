package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$Plugin$install$1", f = "HttpSend.kt", l = {107, 108}, m = "invokeSuspend", v = 1)
public final class HttpSend$Plugin$install$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ HttpSend $plugin;
    final /* synthetic */ HttpClient $scope;
    int I$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$Plugin$install$1(HttpSend httpSend, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.$plugin = httpSend;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
        HttpSend$Plugin$install$1 httpSend$Plugin$install$1 = new HttpSend$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpSend$Plugin$install$1.L$0 = pipelineContext;
        httpSend$Plugin$install$1.L$1 = obj;
        return httpSend$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00eb, code lost:
    
        if (r0.proceedWith((io.ktor.client.call.HttpClientCall) r10, r9) == r6) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int iIntValue;
        int i;
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        Object obj2 = this.L$1;
        int i2 = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (!(obj2 instanceof OutgoingContent)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) StringsKt__IndentKt.trimMargin$default("\n|Fail to prepare request body for sending. \n|The body type is: " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + ", with Content-Type: " + HttpMessagePropertiesKt.contentType((HttpMessageBuilder) pipelineContext.getContext()) + ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header."));
            return null;
        }
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.getContext();
        httpRequestBuilder.setBody(obj2);
        httpRequestBuilder.setBodyType(null);
        Integer num = (Integer) ((HttpRequestBuilder) pipelineContext.getContext()).getAttributes().getOrNull(HttpRequestRetryKt.getMaxRetriesPerRequestAttributeKey());
        if (num == null || num.intValue() < this.$plugin.maxSendCount) {
            iIntValue = this.$plugin.maxSendCount;
        } else {
            iIntValue = num.intValue() < Integer.MAX_VALUE ? num.intValue() + 1 : num.intValue();
        }
        i = iIntValue;
        Sender defaultSender = new HttpSend.DefaultSender(i, this.$scope);
        Iterator it = CollectionsKt.reversed(this.$plugin.interceptors).iterator();
        while (it.hasNext()) {
            defaultSender = new HttpSend.InterceptedSender((Function3) it.next(), defaultSender);
        }
        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) pipelineContext.getContext();
        this.L$0 = pipelineContext;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.I$0 = i;
        this.label = 1;
        obj = defaultSender.execute(httpRequestBuilder2, this);
        if (obj != coroutineSingletons) {
        }
        return coroutineSingletons;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.I$0 = i;
        this.label = 2;
    }
}
