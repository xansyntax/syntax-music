package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "Lio/ktor/client/engine/HttpClientEngineFactory;", "engineFactory", "Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "block", "Lio/ktor/client/HttpClient;", "HttpClient", "(Lio/ktor/client/engine/HttpClientEngineFactory;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "Lio/ktor/client/engine/HttpClientEngine;", "engine", "(Lio/ktor/client/engine/HttpClientEngine;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpClientKt {
    public static final <T extends HttpClientEngineConfig> HttpClient HttpClient(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1 function1) {
        httpClientEngineFactory.getClass();
        function1.getClass();
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        function1.invoke(httpClientConfig);
        return new HttpClient(httpClientEngineFactory.create(httpClientConfig.getEngineConfig()), httpClientConfig, true);
    }

    public static /* synthetic */ HttpClient HttpClient$default(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new HttpClient$$ExternalSyntheticLambda1((byte) 24);
        }
        return HttpClient(httpClientEngineFactory, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpClient$lambda$0(HttpClientConfig httpClientConfig) {
        httpClientConfig.getClass();
        return Unit.INSTANCE;
    }

    public static final HttpClient HttpClient(HttpClientEngine httpClientEngine, Function1 function1) {
        httpClientEngine.getClass();
        function1.getClass();
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        function1.invoke(httpClientConfig);
        return new HttpClient(httpClientEngine, httpClientConfig, false);
    }
}
