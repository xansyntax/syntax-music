package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a3\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\t\"\u0018\u0010\f\u001a\u00060\nj\u0002`\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "", "block", "defaultRequest", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "", "replace", "(Lio/ktor/client/HttpClientConfig;ZLkotlin/jvm/functions/Function1;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DefaultRequestKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.DefaultRequest");

    public static final void defaultRequest(HttpClientConfig<?> httpClientConfig, boolean z, Function1 function1) {
        httpClientConfig.getClass();
        function1.getClass();
        if (z) {
            httpClientConfig.installOrReplace(DefaultRequest.INSTANCE, new DefaultRequestKt$$ExternalSyntheticLambda0(function1, (byte) 2));
        } else {
            httpClientConfig.install(DefaultRequest.INSTANCE, new DefaultRequestKt$$ExternalSyntheticLambda0(function1, (byte) 1));
        }
    }

    public static /* synthetic */ void defaultRequest$default(HttpClientConfig httpClientConfig, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        defaultRequest(httpClientConfig, z, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit defaultRequest$lambda$0(Function1 function1, DefaultRequest.DefaultRequestBuilder defaultRequestBuilder) {
        defaultRequestBuilder.getClass();
        function1.invoke(defaultRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit defaultRequest$lambda$1(Function1 function1, DefaultRequest.DefaultRequestBuilder defaultRequestBuilder) {
        defaultRequestBuilder.getClass();
        function1.invoke(defaultRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit defaultRequest$lambda$2(Function1 function1, DefaultRequest.DefaultRequestBuilder defaultRequestBuilder) {
        defaultRequestBuilder.getClass();
        function1.invoke(defaultRequestBuilder);
        return Unit.INSTANCE;
    }

    public static final void defaultRequest(HttpClientConfig<?> httpClientConfig, Function1 function1) {
        httpClientConfig.getClass();
        function1.getClass();
        httpClientConfig.install(DefaultRequest.INSTANCE, new DefaultRequestKt$$ExternalSyntheticLambda0(function1, (byte) 0));
    }
}
