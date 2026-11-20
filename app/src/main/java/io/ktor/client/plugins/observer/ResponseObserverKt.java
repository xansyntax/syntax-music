package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.sse.SSEKt$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a=\u0010\b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00002&\u0010\u0007\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001j\u0002`\u0006¢\u0006\u0004\b\b\u0010\t\"#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\u0012\n\u0004\b\b\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e*B\u0010\u0011\"\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¨\u0006\u0012"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "", "", "Lio/ktor/client/plugins/observer/ResponseHandler;", "block", "ResponseObserver", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function2;)V", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/observer/ResponseObserverConfig;", "Lio/ktor/client/plugins/api/ClientPlugin;", "getResponseObserver", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getResponseObserver$annotations", "()V", "ResponseHandler", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ResponseObserverKt {
    private static final ClientPlugin<ResponseObserverConfig> ResponseObserver = CreatePluginUtilsKt.createClientPlugin("ResponseObserver", AnonymousClass1.INSTANCE, new SSEKt$$ExternalSyntheticLambda0(6));

    /* JADX INFO: renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, ResponseObserverConfig.class, "<init>", "<init>()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ResponseObserverConfig invoke() {
            return new ResponseObserverConfig();
        }
    }

    public static final void ResponseObserver(HttpClientConfig<?> httpClientConfig, Function2 function2) {
        httpClientConfig.getClass();
        function2.getClass();
        httpClientConfig.install(ResponseObserver, new DelegatedCallKt$$ExternalSyntheticLambda0(function2, (byte) 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResponseObserver$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        Function2 responseHandler = ((ResponseObserverConfig) clientPluginBuilder.getPluginConfig()).getResponseHandler();
        clientPluginBuilder.on(AfterReceiveHook.INSTANCE, new ResponseObserverKt$ResponseObserver$2$1(((ResponseObserverConfig) clientPluginBuilder.getPluginConfig()).getFilter(), clientPluginBuilder, responseHandler, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResponseObserver$lambda$1(Function2 function2, ResponseObserverConfig responseObserverConfig) {
        responseObserverConfig.getClass();
        responseObserverConfig.setResponseHandler$ktor_client_core(function2);
        return Unit.INSTANCE;
    }

    public static final ClientPlugin<ResponseObserverConfig> getResponseObserver() {
        return ResponseObserver;
    }

    public static /* synthetic */ void getResponseObserver$annotations() {
    }
}
