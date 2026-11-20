package okhttp3.internal.http;

import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealRoutePlanner;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealInterceptorChain {
    public final Authenticator authenticator;
    public final Cache cache;
    public final RealCall call;
    public int calls;
    public final EntryPoints certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeoutMillis;
    public final ConnectionPool connectionPool;
    public final Protocol.Companion cookieJar;
    public final Dns dns;
    public final Exchange exchange;
    public final HostnameVerifier hostnameVerifier;
    public final int index;
    public final ArrayList interceptors;
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeoutMillis;
    public final Request request;
    public final boolean retryOnConnectionFailure;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactoryOrNull;
    public final int writeTimeoutMillis;
    public final X509TrustManager x509TrustManagerOrNull;

    public RealInterceptorChain(RealCall realCall, ArrayList arrayList, int i, Exchange exchange, Request request, int i2, int i3, int i4, Authenticator authenticator, Cache cache, CertificatePinner certificatePinner, ConnectionPool connectionPool, Protocol.Companion companion, Dns dns, HostnameVerifier hostnameVerifier, Proxy proxy, Authenticator authenticator2, ProxySelector proxySelector, boolean z, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, EntryPoints entryPoints) {
        request.getClass();
        authenticator.getClass();
        certificatePinner.getClass();
        connectionPool.getClass();
        companion.getClass();
        dns.getClass();
        hostnameVerifier.getClass();
        authenticator2.getClass();
        proxySelector.getClass();
        socketFactory.getClass();
        this.call = realCall;
        this.interceptors = arrayList;
        this.index = i;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i2;
        this.readTimeoutMillis = i3;
        this.writeTimeoutMillis = i4;
        this.authenticator = authenticator;
        this.cache = cache;
        this.certificatePinner = certificatePinner;
        this.connectionPool = connectionPool;
        this.cookieJar = companion;
        this.dns = dns;
        this.hostnameVerifier = hostnameVerifier;
        this.proxy = proxy;
        this.proxyAuthenticator = authenticator2;
        this.proxySelector = proxySelector;
        this.retryOnConnectionFailure = z;
        this.socketFactory = socketFactory;
        this.sslSocketFactoryOrNull = sSLSocketFactory;
        this.x509TrustManagerOrNull = x509TrustManager;
        this.certificateChainCleaner = entryPoints;
    }

    public static RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i, Exchange exchange, Request request, int i2) {
        int i3 = (i2 & 1) != 0 ? realInterceptorChain.index : i;
        Exchange exchange2 = (i2 & 2) != 0 ? realInterceptorChain.exchange : exchange;
        Request request2 = (i2 & 4) != 0 ? realInterceptorChain.request : request;
        int i4 = realInterceptorChain.connectTimeoutMillis;
        int i5 = realInterceptorChain.readTimeoutMillis;
        int i6 = realInterceptorChain.writeTimeoutMillis;
        Authenticator authenticator = realInterceptorChain.authenticator;
        Cache cache = realInterceptorChain.cache;
        CertificatePinner certificatePinner = realInterceptorChain.certificatePinner;
        ConnectionPool connectionPool = realInterceptorChain.connectionPool;
        Protocol.Companion companion = realInterceptorChain.cookieJar;
        Dns dns = realInterceptorChain.dns;
        HostnameVerifier hostnameVerifier = realInterceptorChain.hostnameVerifier;
        Proxy proxy = realInterceptorChain.proxy;
        Authenticator authenticator2 = realInterceptorChain.proxyAuthenticator;
        ProxySelector proxySelector = realInterceptorChain.proxySelector;
        boolean z = realInterceptorChain.retryOnConnectionFailure;
        SocketFactory socketFactory = realInterceptorChain.socketFactory;
        SSLSocketFactory sSLSocketFactory = realInterceptorChain.sslSocketFactoryOrNull;
        X509TrustManager x509TrustManager = realInterceptorChain.x509TrustManagerOrNull;
        EntryPoints entryPoints = realInterceptorChain.certificateChainCleaner;
        request2.getClass();
        authenticator.getClass();
        certificatePinner.getClass();
        connectionPool.getClass();
        companion.getClass();
        dns.getClass();
        hostnameVerifier.getClass();
        authenticator2.getClass();
        proxySelector.getClass();
        socketFactory.getClass();
        return new RealInterceptorChain(realInterceptorChain.call, realInterceptorChain.interceptors, i3, exchange2, request2, i4, i5, i6, authenticator, cache, certificatePinner, connectionPool, companion, dns, hostnameVerifier, proxy, authenticator2, proxySelector, z, socketFactory, sSLSocketFactory, x509TrustManager, entryPoints);
    }

    public final Response proceed(Request request) {
        request.getClass();
        ArrayList arrayList = this.interceptors;
        int size = arrayList.size();
        int i = this.index;
        if (i >= size) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            return null;
        }
        this.calls++;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            RealRoutePlanner routePlanner = ((ExchangeFinder) exchange.finder).getRoutePlanner();
            HttpUrl httpUrl = request.url;
            routePlanner.getClass();
            httpUrl.getClass();
            HttpUrl httpUrl2 = routePlanner.address.url;
            if (httpUrl.port != httpUrl2.port || !Intrinsics.areEqual(httpUrl.host, httpUrl2.host)) {
                PathKt$$ExternalSyntheticBUOutline0.m("network interceptor ", arrayList.get(i - 1), " must retain the same host and port");
                return null;
            }
            if (this.calls != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m("network interceptor ", arrayList.get(i - 1), " must call proceed() exactly once");
                return null;
            }
        }
        int i2 = i + 1;
        RealInterceptorChain realInterceptorChainCopy$okhttp$default = copy$okhttp$default(this, i2, null, request, 2097146);
        Interceptor interceptor = (Interceptor) arrayList.get(i);
        Response responseIntercept = interceptor.intercept(realInterceptorChainCopy$okhttp$default);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (exchange == null || i2 >= arrayList.size() || realInterceptorChainCopy$okhttp$default.calls == 1) {
            return responseIntercept;
        }
        PathKt$$ExternalSyntheticBUOutline0.m("network interceptor ", interceptor, " must call proceed() exactly once");
        return null;
    }
}
