package io.ktor.client.plugins;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.StringValuesKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultRequest$Plugin$install$1", f = "DefaultRequest.kt", l = {}, m = "invokeSuspend", v = 1)
public final class DefaultRequest$Plugin$install$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ DefaultRequest $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRequest$Plugin$install$1(DefaultRequest defaultRequest, Continuation continuation) {
        super(3, continuation);
        this.$plugin = defaultRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map invokeSuspend$lambda$1$0() {
        return new LinkedHashMap();
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
        DefaultRequest$Plugin$install$1 defaultRequest$Plugin$install$1 = new DefaultRequest$Plugin$install$1(this.$plugin, continuation);
        defaultRequest$Plugin$install$1.L$0 = pipelineContext;
        return defaultRequest$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        String string = ((HttpRequestBuilder) pipelineContext.getContext()).getUrl().toString();
        DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = new DefaultRequest.DefaultRequestBuilder();
        DefaultRequest defaultRequest = this.$plugin;
        StringValuesKt.appendAll(defaultRequestBuilder.getHeaders(), ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders());
        Headers headersBuild = defaultRequestBuilder.getHeaders().build();
        defaultRequest.block.invoke(defaultRequestBuilder);
        Iterator<T> it = headersBuild.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            List<String> all = defaultRequestBuilder.getHeaders().getAll(str);
            if (all == null) {
                defaultRequestBuilder.getHeaders().appendAll(str, list);
            } else if (!all.equals(list) && !Intrinsics.areEqual(str, HttpHeaders.Cookie)) {
                defaultRequestBuilder.getHeaders().remove(str);
                defaultRequestBuilder.getHeaders().appendAll(str, list);
                defaultRequestBuilder.getHeaders().appendMissing(str, all);
            }
        }
        DefaultRequest.INSTANCE.mergeUrls(defaultRequestBuilder.getUrl().build(), ((HttpRequestBuilder) pipelineContext.getContext()).getUrl());
        for (AttributeKey<?> attributeKey : defaultRequestBuilder.getAttributes().getAllKeys()) {
            if (Intrinsics.areEqual(attributeKey, HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY())) {
                Map map = (Map) ((HttpRequestBuilder) pipelineContext.getContext()).getAttributes().computeIfAbsent(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY(), new DoubleReceivePluginKt$$ExternalSyntheticLambda0((byte) 1));
                for (Map.Entry entry2 : ((Map) defaultRequestBuilder.getAttributes().get(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY())).entrySet()) {
                    HttpClientEngineCapability httpClientEngineCapability = (HttpClientEngineCapability) entry2.getKey();
                    Object value = entry2.getValue();
                    if (!map.containsKey(httpClientEngineCapability)) {
                        map.put(httpClientEngineCapability, value);
                    }
                }
            } else if (!((HttpRequestBuilder) pipelineContext.getContext()).getAttributes().contains(attributeKey)) {
                Attributes attributes = ((HttpRequestBuilder) pipelineContext.getContext()).getAttributes();
                attributeKey.getClass();
                attributes.put(attributeKey, defaultRequestBuilder.getAttributes().get(attributeKey));
            }
        }
        ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().clear();
        ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().appendAll(defaultRequestBuilder.getHeaders().build());
        Logger logger = DefaultRequestKt.LOGGER;
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Applied DefaultRequest to ", string, ". New url: ");
            sbM4m.append(((HttpRequestBuilder) pipelineContext.getContext()).getUrl());
            logger.trace(sbM4m.toString());
        }
        return Unit.INSTANCE;
    }
}
