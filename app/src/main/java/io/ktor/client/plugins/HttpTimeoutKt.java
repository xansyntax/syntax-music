package io.ktor.client.plugins;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.TimeoutExceptionsKt;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.plugins.sse.SSEClientContent;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.http.URLProtocolKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.net.SocketTimeoutException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\u000b\u001a\u00020\u0005*\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0015\u001a%\u0010\u0018\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0002\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0081\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"\u0018\u0010%\u001a\u00060#j\u0002`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&\"\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u001e\u00101\u001a\u00020,*\u00020\u00018BX\u0082\u0004¢\u0006\f\u0012\u0004\b/\u00100\u001a\u0004\b-\u0010.\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "", "requestTimeout", "", "applyRequestTimeout", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Long;)V", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "block", "timeout", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/request/HttpRequestData;", "", "cause", "Lio/ktor/client/network/sockets/ConnectTimeoutException;", "ConnectTimeoutException", "(Lio/ktor/client/request/HttpRequestData;Ljava/lang/Throwable;)Lio/ktor/client/network/sockets/ConnectTimeoutException;", "", "url", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Throwable;)Lio/ktor/client/network/sockets/ConnectTimeoutException;", "Ljava/net/SocketTimeoutException;", "Lio/ktor/client/network/sockets/SocketTimeoutException;", "SocketTimeoutException", "(Lio/ktor/client/request/HttpRequestData;Ljava/lang/Throwable;)Ljava/net/SocketTimeoutException;", "", "convertLongTimeoutToIntWithInfiniteAsZero", "(J)I", "convertLongTimeoutToLongWithInfiniteAsZero", "(J)J", "T", "Lkotlin/Function0;", "unwrapRequestTimeoutException", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpTimeout", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpTimeout", "()Lio/ktor/client/plugins/api/ClientPlugin;", "", "getSupportsRequestTimeout", "(Lio/ktor/client/request/HttpRequestBuilder;)Z", "getSupportsRequestTimeout$annotations", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "supportsRequestTimeout", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpTimeoutKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpTimeout");
    private static final ClientPlugin<HttpTimeoutConfig> HttpTimeout = CreatePluginUtilsKt.createClientPlugin("HttpTimeout", HttpTimeoutKt$HttpTimeout$2.INSTANCE, new UserAgentKt$$ExternalSyntheticLambda0(11));

    public static final ConnectTimeoutException ConnectTimeoutException(HttpRequestData httpRequestData, Throwable th) {
        Object obj;
        httpRequestData.getClass();
        StringBuilder sb = new StringBuilder("Connect timeout has expired [url=");
        sb.append(httpRequestData.getUrl());
        sb.append(", connect_timeout=");
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) httpRequestData.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        if (httpTimeoutConfig == null || (obj = httpTimeoutConfig.get_connectTimeoutMillis()) == null) {
            obj = "unknown";
        }
        sb.append(obj);
        sb.append(" ms]");
        return new ConnectTimeoutException(sb.toString(), th);
    }

    public static /* synthetic */ ConnectTimeoutException ConnectTimeoutException$default(HttpRequestData httpRequestData, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return ConnectTimeoutException(httpRequestData, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpTimeout$lambda$1(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        clientPluginBuilder.on(Send.INSTANCE, new HttpTimeoutKt$HttpTimeout$3$1(((HttpTimeoutConfig) clientPluginBuilder.getPluginConfig()).get_requestTimeoutMillis(), ((HttpTimeoutConfig) clientPluginBuilder.getPluginConfig()).get_connectTimeoutMillis(), ((HttpTimeoutConfig) clientPluginBuilder.getPluginConfig()).get_socketTimeoutMillis(), null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpTimeout$lambda$1$hasNotNullTimeouts(Long l, Long l2, Long l3, boolean z) {
        return ((!z || l == null) && l2 == null && l3 == null) ? false : true;
    }

    public static final SocketTimeoutException SocketTimeoutException(HttpRequestData httpRequestData, Throwable th) {
        Object obj;
        httpRequestData.getClass();
        StringBuilder sb = new StringBuilder("Socket timeout has expired [url=");
        sb.append(httpRequestData.getUrl());
        sb.append(", socket_timeout=");
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) httpRequestData.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        if (httpTimeoutConfig == null || (obj = httpTimeoutConfig.get_socketTimeoutMillis()) == null) {
            obj = "unknown";
        }
        sb.append(obj);
        sb.append("] ms");
        return TimeoutExceptionsKt.SocketTimeoutException(sb.toString(), th);
    }

    public static /* synthetic */ SocketTimeoutException SocketTimeoutException$default(HttpRequestData httpRequestData, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return SocketTimeoutException(httpRequestData, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyRequestTimeout(CoroutineScope coroutineScope, HttpRequestBuilder httpRequestBuilder, Long l) {
        if (l == null || l.longValue() == Long.MAX_VALUE) {
            return;
        }
        httpRequestBuilder.getExecutionContext().invokeOnCompletion(new HttpTimeoutKt$$ExternalSyntheticLambda1((byte) 0, AwaitKt.launch$default(coroutineScope, new CoroutineName("request-timeout"), null, new HttpTimeoutKt$applyRequestTimeout$killer$1(l, httpRequestBuilder, httpRequestBuilder.getExecutionContext(), null), 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyRequestTimeout$lambda$0(Job job, Throwable th) {
        job.cancel(null);
        return Unit.INSTANCE;
    }

    public static final int convertLongTimeoutToIntWithInfiniteAsZero(long j) {
        if (j == Long.MAX_VALUE) {
            return 0;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public static final long convertLongTimeoutToLongWithInfiniteAsZero(long j) {
        if (j == Long.MAX_VALUE) {
            return 0L;
        }
        return j;
    }

    public static final ClientPlugin<HttpTimeoutConfig> getHttpTimeout() {
        return HttpTimeout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getSupportsRequestTimeout(HttpRequestBuilder httpRequestBuilder) {
        return (URLProtocolKt.isWebsocket(httpRequestBuilder.getUrl().getProtocol()) || (httpRequestBuilder.getBody() instanceof ClientUpgradeContent) || (httpRequestBuilder.getBody() instanceof SSEClientContent)) ? false : true;
    }

    public static final void timeout(HttpRequestBuilder httpRequestBuilder, Function1 function1) {
        httpRequestBuilder.getClass();
        function1.getClass();
        HttpTimeoutCapability httpTimeoutCapability = HttpTimeoutCapability.INSTANCE;
        HttpTimeoutConfig httpTimeoutConfig = new HttpTimeoutConfig(null, null, null, 7, null);
        function1.invoke(httpTimeoutConfig);
        httpRequestBuilder.setCapability(httpTimeoutCapability, httpTimeoutConfig);
    }

    public static final <T> T unwrapRequestTimeoutException(Function0 function0) throws Throwable {
        function0.getClass();
        try {
            return (T) function0.invoke();
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public static /* synthetic */ ConnectTimeoutException ConnectTimeoutException$default(String str, Long l, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        return ConnectTimeoutException(str, l, th);
    }

    private static /* synthetic */ void getSupportsRequestTimeout$annotations(HttpRequestBuilder httpRequestBuilder) {
    }

    public static final ConnectTimeoutException ConnectTimeoutException(String str, Long l, Throwable th) {
        str.getClass();
        StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Connect timeout has expired [url=", str, ", connect_timeout=");
        Object obj = l;
        if (l == null) {
            obj = "unknown";
        }
        sbM4m.append(obj);
        sbM4m.append(" ms]");
        return new ConnectTimeoutException(sbM4m.toString(), th);
    }
}
