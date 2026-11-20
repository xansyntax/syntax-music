package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.TransformRequestBodyContext;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.reflect.TypeInfo;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.reflect.KClass;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/client/plugins/api/TransformRequestBodyContext;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "body", "", "<unused var>", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$ContentNegotiation$2$1", f = "ContentNegotiation.kt", l = {378}, m = "invokeSuspend", v = 1)
public final class ContentNegotiationKt$ContentNegotiation$2$1 extends SuspendLambda implements Function5 {
    final /* synthetic */ Set<KClass<?>> $ignoredTypes;
    final /* synthetic */ List<ContentNegotiationConfig.ConverterRegistration> $registrations;
    final /* synthetic */ ClientPluginBuilder<ContentNegotiationConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContentNegotiationKt$ContentNegotiation$2$1(List<ContentNegotiationConfig.ConverterRegistration> list, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Set<? extends KClass<?>> set, Continuation continuation) {
        super(5, continuation);
        this.$registrations = list;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$ignoredTypes = set;
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(TransformRequestBodyContext transformRequestBodyContext, HttpRequestBuilder httpRequestBuilder, Object obj, TypeInfo typeInfo, Continuation continuation) {
        ContentNegotiationKt$ContentNegotiation$2$1 contentNegotiationKt$ContentNegotiation$2$1 = new ContentNegotiationKt$ContentNegotiation$2$1(this.$registrations, this.$this_createClientPlugin, this.$ignoredTypes, continuation);
        contentNegotiationKt$ContentNegotiation$2$1.L$0 = httpRequestBuilder;
        contentNegotiationKt$ContentNegotiation$2$1.L$1 = obj;
        return contentNegotiationKt$ContentNegotiation$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws ContentConverterException, IOException {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        Object obj2 = this.L$1;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        List<ContentNegotiationConfig.ConverterRegistration> list = this.$registrations;
        ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder = this.$this_createClientPlugin;
        Set<KClass<?>> set = this.$ignoredTypes;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 1;
        Object objContentNegotiation$lambda$0$convertRequest = ContentNegotiationKt.ContentNegotiation$lambda$0$convertRequest(list, clientPluginBuilder, set, httpRequestBuilder, obj2, this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objContentNegotiation$lambda$0$convertRequest == coroutineSingletons ? coroutineSingletons : objContentNegotiation$lambda$0$convertRequest;
    }
}
