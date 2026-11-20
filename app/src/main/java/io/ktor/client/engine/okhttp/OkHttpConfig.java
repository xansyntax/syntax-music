package io.ktor.client.engine.okhttp;

import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda0;
import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rR.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00066"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "<init>", "()V", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "", "block", "config", "(Lkotlin/jvm/functions/Function1;)V", "Lokhttp3/Interceptor;", "interceptor", "addInterceptor", "(Lokhttp3/Interceptor;)V", "addNetworkInterceptor", "Lkotlin/jvm/functions/Function1;", "getConfig$ktor_client_okhttp", "()Lkotlin/jvm/functions/Function1;", "setConfig$ktor_client_okhttp", "Lokhttp3/OkHttpClient;", "preconfigured", "Lokhttp3/OkHttpClient;", "getPreconfigured", "()Lokhttp3/OkHttpClient;", "setPreconfigured", "(Lokhttp3/OkHttpClient;)V", "", "clientCacheSize", "I", "getClientCacheSize", "()I", "setClientCacheSize", "(I)V", "Lokhttp3/WebSocket$Factory;", "webSocketFactory", "Lokhttp3/WebSocket$Factory;", "getWebSocketFactory", "()Lokhttp3/WebSocket$Factory;", "setWebSocketFactory", "(Lokhttp3/WebSocket$Factory;)V", "", "duplexStreamingEnabled", "Z", "getDuplexStreamingEnabled", "()Z", "setDuplexStreamingEnabled", "(Z)V", "Lokhttp3/Dns;", "dns", "Lokhttp3/Dns;", "getDns", "()Lokhttp3/Dns;", "setDns", "(Lokhttp3/Dns;)V", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OkHttpConfig extends HttpClientEngineConfig {
    private Dns dns;
    private boolean duplexStreamingEnabled;
    private OkHttpClient preconfigured;
    private WebSocket.Factory webSocketFactory;
    private Function1 config = new HttpClient$$ExternalSyntheticLambda1(26);
    private int clientCacheSize = 10;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addInterceptor$lambda$0(Interceptor interceptor, OkHttpClient.Builder builder) {
        builder.getClass();
        interceptor.getClass();
        builder.interceptors.add(interceptor);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addNetworkInterceptor$lambda$0(Interceptor interceptor, OkHttpClient.Builder builder) {
        builder.getClass();
        interceptor.getClass();
        builder.networkInterceptors.add(interceptor);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit config$lambda$0(OkHttpClient.Builder builder) {
        builder.getClass();
        builder.followRedirects = false;
        builder.followSslRedirects = false;
        builder.retryOnConnectionFailure = true;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit config$lambda$1(Function1 function1, Function1 function2, OkHttpClient.Builder builder) {
        builder.getClass();
        function1.invoke(builder);
        function2.invoke(builder);
        return Unit.INSTANCE;
    }

    public final void addInterceptor(Interceptor interceptor) {
        interceptor.getClass();
        config(new OkHttpConfig$$ExternalSyntheticLambda1(interceptor, (byte) 1));
    }

    public final void addNetworkInterceptor(Interceptor interceptor) {
        interceptor.getClass();
        config(new OkHttpConfig$$ExternalSyntheticLambda1(interceptor, (byte) 0));
    }

    public final void config(Function1 block) {
        block.getClass();
        this.config = new HttpClientConfig$$ExternalSyntheticLambda0(this.config, block, (byte) 4);
    }

    public final int getClientCacheSize() {
        return this.clientCacheSize;
    }

    /* JADX INFO: renamed from: getConfig$ktor_client_okhttp, reason: from getter */
    public final Function1 getConfig() {
        return this.config;
    }

    public final Dns getDns() {
        return this.dns;
    }

    public final boolean getDuplexStreamingEnabled() {
        return this.duplexStreamingEnabled;
    }

    public final OkHttpClient getPreconfigured() {
        return this.preconfigured;
    }

    public final WebSocket.Factory getWebSocketFactory() {
        return this.webSocketFactory;
    }

    public final void setClientCacheSize(int i) {
        this.clientCacheSize = i;
    }

    public final void setConfig$ktor_client_okhttp(Function1 function1) {
        function1.getClass();
        this.config = function1;
    }

    public final void setDns(Dns dns) {
        this.dns = dns;
    }

    public final void setDuplexStreamingEnabled(boolean z) {
        this.duplexStreamingEnabled = z;
    }

    public final void setPreconfigured(OkHttpClient okHttpClient) {
        this.preconfigured = okHttpClient;
    }

    public final void setWebSocketFactory(WebSocket.Factory factory) {
        this.webSocketFactory = factory;
    }
}
