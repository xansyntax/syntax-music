package okhttp3.internal.connection;

import androidx.navigation.NavDeepLinkRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        ExchangeCodec http1ExchangeCodec;
        RealCall realCall = realInterceptorChain.call;
        synchronized (realCall) {
            if (!realCall.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (realCall.responseBodyOpen || realCall.requestBodyOpen || realCall.socketSourceOpen || realCall.socketSinkOpen) {
                throw new IllegalStateException("Check failed.");
            }
        }
        ExchangeFinder exchangeFinder = realCall.exchangeFinder;
        exchangeFinder.getClass();
        RealConnection realConnectionFind = exchangeFinder.find();
        OkHttpClient okHttpClient = realCall.client;
        realConnectionFind.getClass();
        okHttpClient.getClass();
        int i = realInterceptorChain.readTimeoutMillis;
        NavDeepLinkRequest navDeepLinkRequest = realConnectionFind.socket;
        Http2Connection http2Connection = realConnectionFind.http2Connection;
        if (http2Connection != null) {
            http1ExchangeCodec = new Http2ExchangeCodec(okHttpClient, realConnectionFind, realInterceptorChain, http2Connection);
        } else {
            realConnectionFind.javaNetSocket.setSoTimeout(i);
            Timeout timeout = ((RealBufferedSource) navDeepLinkRequest.action).source.timeout();
            long j = i;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            timeout.timeout(j, timeUnit);
            ((RealBufferedSink) navDeepLinkRequest.mimeType).sink.timeout().timeout(realInterceptorChain.writeTimeoutMillis, timeUnit);
            http1ExchangeCodec = new Http1ExchangeCodec(okHttpClient, realConnectionFind, navDeepLinkRequest);
        }
        Exchange exchange = new Exchange(realCall, exchangeFinder, http1ExchangeCodec);
        realCall.interceptorScopedExchange = exchange;
        realCall.exchange = exchange;
        synchronized (realCall) {
            realCall.requestBodyOpen = true;
            realCall.responseBodyOpen = true;
        }
        if (!realCall.canceled) {
            return RealInterceptorChain.copy$okhttp$default(realInterceptorChain, 0, exchange, null, 2097149).proceed(realInterceptorChain.request);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Canceled");
        return null;
    }
}
