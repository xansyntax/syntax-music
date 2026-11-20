package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketDeflateExtension;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpClientConfig$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ HttpClientConfig$$ExternalSyntheticLambda0(Function1 function1, Function1 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
        this.f$1 = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function1 function1 = this.f$1;
        Function1 function2 = this.f$0;
        switch (b) {
            case 0:
                return HttpClientConfig.install$lambda$1(function2, function1, obj);
            case 1:
                function2.invoke(obj);
                function1.invoke(obj);
                return unit;
            case 2:
                function2.invoke(obj);
                function1.invoke(obj);
                return unit;
            case 3:
                return HttpClientConfig.engine$lambda$0(function2, function1, (HttpClientEngineConfig) obj);
            case 4:
                return OkHttpConfig.config$lambda$1(function2, function1, (OkHttpClient.Builder) obj);
            case 5:
                return Boolean.valueOf(WebSocketDeflateExtension.Config.compressIf$lambda$0(function2, function1, (Frame) obj));
            default:
                return WebSocketDeflateExtension.Config.configureProtocols$lambda$0(function2, function1, (List) obj);
        }
    }
}
