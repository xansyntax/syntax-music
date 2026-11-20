package okhttp3;

import com.google.common.base.Splitter;
import dagger.hilt.EntryPoints;
import io.ktor.http.HttpHeaders;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class OkHttpClient implements WebSocket.Factory {
    public final Protocol.Companion authenticator;
    public final Cache cache;
    public final EntryPoints certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeoutMillis;
    public final ConnectionPool connectionPool;
    public final List connectionSpecs;
    public final Protocol.Companion cookieJar;
    public final Dispatcher dispatcher;
    public final Dns dns;
    public final _UtilJvmKt$$ExternalSyntheticLambda0 eventListenerFactory;
    public final boolean fastFallback;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final HostnameVerifier hostnameVerifier;
    public final List interceptors;
    public final short minWebSocketMessageToCompress;
    public final List networkInterceptors;
    public final int pingIntervalMillis;
    public final List protocols;
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeoutMillis;
    public final boolean retryOnConnectionFailure;
    public final ConnectionPool routeDatabase;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactoryOrNull;
    public final TaskRunner taskRunner;
    public final char webSocketCloseTimeout;
    public final int writeTimeoutMillis;
    public final X509TrustManager x509TrustManager;
    public static final List DEFAULT_PROTOCOLS = _UtilJvmKt.toImmutableList(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
    public static final List DEFAULT_CONNECTION_SPECS = _UtilJvmKt.toImmutableList(new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public Protocol.Companion authenticator;
        public Cache cache;
        public EntryPoints certificateChainCleaner;
        public CertificatePinner certificatePinner;
        public int connectTimeout;
        public ConnectionPool connectionPool;
        public List connectionSpecs;
        public Protocol.Companion cookieJar;
        public Dns dns;
        public _UtilJvmKt$$ExternalSyntheticLambda0 eventListenerFactory;
        public boolean fastFallback;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public HostnameVerifier hostnameVerifier;
        public short minWebSocketMessageToCompress;
        public int pingInterval;
        public List protocols;
        public Proxy proxy;
        public Authenticator proxyAuthenticator;
        public ProxySelector proxySelector;
        public int readTimeout;
        public boolean retryOnConnectionFailure;
        public ConnectionPool routeDatabase;
        public SocketFactory socketFactory;
        public SSLSocketFactory sslSocketFactoryOrNull;
        public TaskRunner taskRunner;
        public char webSocketCloseTimeout;
        public int writeTimeout;
        public X509TrustManager x509TrustManagerOrNull;
        public Dispatcher dispatcher = new Dispatcher((byte) 0);
        public final ArrayList interceptors = new ArrayList();
        public final ArrayList networkInterceptors = new ArrayList();

        public Builder() {
            TimeZone timeZone = _UtilJvmKt.UTC;
            this.eventListenerFactory = new _UtilJvmKt$$ExternalSyntheticLambda0();
            this.retryOnConnectionFailure = true;
            this.fastFallback = true;
            Protocol.Companion companion = Authenticator.NONE;
            this.authenticator = companion;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = Protocol.Companion.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = companion;
            Platform platform = Platform.platform;
            Platform.platform.getClass();
            SocketFactory socketFactory = SocketFactory.getDefault();
            socketFactory.getClass();
            this.socketFactory = socketFactory;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.webSocketCloseTimeout = (char) 60000;
            this.minWebSocketMessageToCompress = (short) 1024;
        }

        public final void connectTimeout(long j, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.connectTimeout = _UtilJvmKt.checkDuration("timeout", j, timeUnit);
        }

        public final void protocols(List list) {
            list.getClass();
            ArrayList arrayList = new ArrayList(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$4(arrayList, "protocols must contain h2_prior_knowledge or http/1.1: ");
                return;
            }
            if (arrayList.contains(protocol) && arrayList.size() > 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$4(arrayList, "protocols containing h2_prior_knowledge cannot use other protocols: ");
                return;
            }
            if (arrayList.contains(Protocol.HTTP_1_0)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$4(arrayList, "protocols must not contain http/1.0: ");
                return;
            }
            if (arrayList.contains(null)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("protocols must not contain null");
                return;
            }
            arrayList.remove(Protocol.SPDY_3);
            if (!arrayList.equals(this.protocols)) {
                this.routeDatabase = null;
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            listUnmodifiableList.getClass();
            this.protocols = listUnmodifiableList;
        }

        public final void proxy(Proxy proxy) {
            if (!Intrinsics.areEqual(proxy, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy;
        }

        public final void proxyAuthenticator(Authenticator authenticator) {
            if (!authenticator.equals(this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = authenticator;
        }

        public final void readTimeout(long j, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.readTimeout = _UtilJvmKt.checkDuration("timeout", j, timeUnit);
        }

        public final void writeTimeout(long j, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.writeTimeout = _UtilJvmKt.checkDuration("timeout", j, timeUnit);
        }
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [int, short] */
    public OkHttpClient(Builder builder) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        SSLSocketFactory sSLSocketFactory;
        X509TrustManager x509TrustManager;
        EntryPoints entryPoints;
        this.dispatcher = builder.dispatcher;
        this.interceptors = _UtilJvmKt.toImmutableList(builder.interceptors);
        this.networkInterceptors = _UtilJvmKt.toImmutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.fastFallback = builder.fastFallback;
        this.authenticator = builder.authenticator;
        this.followRedirects = builder.followRedirects;
        this.followSslRedirects = builder.followSslRedirects;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.dns = builder.dns;
        Proxy proxy = builder.proxy;
        this.proxy = proxy;
        if (proxy != null) {
            proxySelector = NullProxySelector.INSTANCE;
        } else {
            proxySelector = builder.proxySelector;
            if (proxySelector == null && (proxySelector = ProxySelector.getDefault()) == null) {
                proxySelector = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector;
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.socketFactory = builder.socketFactory;
        List list = builder.connectionSpecs;
        this.connectionSpecs = list;
        this.protocols = builder.protocols;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.connectTimeoutMillis = builder.connectTimeout;
        this.readTimeoutMillis = builder.readTimeout;
        this.writeTimeoutMillis = builder.writeTimeout;
        this.pingIntervalMillis = builder.pingInterval;
        this.webSocketCloseTimeout = builder.webSocketCloseTimeout;
        this.minWebSocketMessageToCompress = builder.minWebSocketMessageToCompress;
        ConnectionPool connectionPool = builder.routeDatabase;
        this.routeDatabase = connectionPool == null ? new ConnectionPool((byte) 23) : connectionPool;
        TaskRunner taskRunner = builder.taskRunner;
        this.taskRunner = taskRunner == null ? TaskRunner.INSTANCE : taskRunner;
        ConnectionPool connectionPool2 = builder.connectionPool;
        if (connectionPool2 == null) {
            connectionPool2 = new ConnectionPool(5);
            builder.connectionPool = connectionPool2;
        }
        this.connectionPool = connectionPool2;
        if (list != null && list.isEmpty()) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
            sSLSocketFactory = null;
            entryPoints = null;
            x509TrustManager = null;
            break;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.sslSocketFactoryOrNull = null;
                this.certificateChainCleaner = null;
                this.x509TrustManager = null;
                this.certificatePinner = CertificatePinner.DEFAULT;
                sSLSocketFactory = null;
                entryPoints = null;
                x509TrustManager = null;
                break;
            }
            if (((ConnectionSpec) it.next()).isTls) {
                sSLSocketFactory = builder.sslSocketFactoryOrNull;
                if (sSLSocketFactory != null) {
                    this.sslSocketFactoryOrNull = sSLSocketFactory;
                    entryPoints = builder.certificateChainCleaner;
                    entryPoints.getClass();
                    this.certificateChainCleaner = entryPoints;
                    x509TrustManager = builder.x509TrustManagerOrNull;
                    x509TrustManager.getClass();
                    this.x509TrustManager = x509TrustManager;
                    CertificatePinner certificatePinner = builder.certificatePinner;
                    certificatePinner.getClass();
                    this.certificatePinner = Intrinsics.areEqual(certificatePinner.certificateChainCleaner, entryPoints) ? certificatePinner : new CertificatePinner(certificatePinner.pins, entryPoints);
                    break;
                }
                Platform platform = Platform.platform;
                Platform.platform.getClass();
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                trustManagers.getClass();
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager2 = (X509TrustManager) trustManager;
                        this.x509TrustManager = x509TrustManager2;
                        Platform platform2 = Platform.platform;
                        platform2.getClass();
                        try {
                            SSLContext sSLContextNewSSLContext = platform2.newSSLContext();
                            sSLContextNewSSLContext.init(null, new TrustManager[]{x509TrustManager2}, null);
                            SSLSocketFactory socketFactory = sSLContextNewSSLContext.getSocketFactory();
                            socketFactory.getClass();
                            this.sslSocketFactoryOrNull = socketFactory;
                            EntryPoints entryPointsBuildCertificateChainCleaner = Platform.platform.buildCertificateChainCleaner(x509TrustManager2);
                            this.certificateChainCleaner = entryPointsBuildCertificateChainCleaner;
                            CertificatePinner certificatePinner2 = builder.certificatePinner;
                            certificatePinner2.getClass();
                            this.certificatePinner = Intrinsics.areEqual(certificatePinner2.certificateChainCleaner, entryPointsBuildCertificateChainCleaner) ? certificatePinner2 : new CertificatePinner(certificatePinner2.pins, entryPointsBuildCertificateChainCleaner);
                            x509TrustManager = x509TrustManager2;
                            sSLSocketFactory = socketFactory;
                            entryPoints = entryPointsBuildCertificateChainCleaner;
                            break;
                        } catch (GeneralSecurityException e) {
                            throw new AssertionError("No System TLS: " + e, e);
                        }
                    }
                }
                String string = Arrays.toString(trustManagers);
                string.getClass();
                _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) "Unexpected default trust managers: ".concat(string));
                throw null;
            }
        }
        List list2 = this.networkInterceptors;
        List list3 = this.interceptors;
        list3.getClass();
        if (list3.contains(null)) {
            PathKt$$ExternalSyntheticBUOutline0.m$2(list3, "Null interceptor: ");
            throw null;
        }
        list2.getClass();
        if (list2.contains(null)) {
            PathKt$$ExternalSyntheticBUOutline0.m$2(list2, "Null network interceptor: ");
            throw null;
        }
        List list4 = this.connectionSpecs;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((ConnectionSpec) it2.next()).isTls) {
                    if (sSLSocketFactory == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("sslSocketFactory == null");
                        throw null;
                    }
                    if (entryPoints == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("certificateChainCleaner == null");
                        throw null;
                    }
                    if (x509TrustManager != null) {
                        return;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("x509TrustManager == null");
                    throw null;
                }
            }
        }
        if (sSLSocketFactory != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            throw null;
        }
        if (entryPoints != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            throw null;
        }
        if (x509TrustManager != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            throw null;
        }
        if (Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v31, types: [int, short] */
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.dispatcher = this.dispatcher;
        builder.connectionPool = this.connectionPool;
        CollectionsKt__MutableCollectionsKt.addAll(this.interceptors, builder.interceptors);
        CollectionsKt__MutableCollectionsKt.addAll(this.networkInterceptors, builder.networkInterceptors);
        builder.eventListenerFactory = this.eventListenerFactory;
        builder.retryOnConnectionFailure = this.retryOnConnectionFailure;
        builder.fastFallback = this.fastFallback;
        builder.authenticator = this.authenticator;
        builder.followRedirects = this.followRedirects;
        builder.followSslRedirects = this.followSslRedirects;
        builder.cookieJar = this.cookieJar;
        builder.cache = this.cache;
        builder.dns = this.dns;
        builder.proxy = this.proxy;
        builder.proxySelector = this.proxySelector;
        builder.proxyAuthenticator = this.proxyAuthenticator;
        builder.socketFactory = this.socketFactory;
        builder.sslSocketFactoryOrNull = this.sslSocketFactoryOrNull;
        builder.x509TrustManagerOrNull = this.x509TrustManager;
        builder.connectionSpecs = this.connectionSpecs;
        builder.protocols = this.protocols;
        builder.hostnameVerifier = this.hostnameVerifier;
        builder.certificatePinner = this.certificatePinner;
        builder.certificateChainCleaner = this.certificateChainCleaner;
        builder.connectTimeout = this.connectTimeoutMillis;
        builder.readTimeout = this.readTimeoutMillis;
        builder.writeTimeout = this.writeTimeoutMillis;
        builder.pingInterval = this.pingIntervalMillis;
        builder.webSocketCloseTimeout = this.webSocketCloseTimeout;
        builder.minWebSocketMessageToCompress = this.minWebSocketMessageToCompress;
        builder.routeDatabase = this.routeDatabase;
        builder.taskRunner = this.taskRunner;
        return builder;
    }

    public final RealWebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        request.getClass();
        webSocketListener.getClass();
        RealWebSocket realWebSocket = new RealWebSocket(this.taskRunner, request, webSocketListener, new Random(), this.pingIntervalMillis, this.minWebSocketMessageToCompress, this.webSocketCloseTimeout);
        if (request.headers.get(HttpHeaders.SecWebSocketExtensions) != null) {
            RealWebSocket.failWebSocket$default(realWebSocket, new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null, 6);
            return realWebSocket;
        }
        Builder builderNewBuilder = newBuilder();
        TimeZone timeZone = _UtilJvmKt.UTC;
        builderNewBuilder.eventListenerFactory = new _UtilJvmKt$$ExternalSyntheticLambda0();
        builderNewBuilder.protocols(RealWebSocket.ONLY_HTTP1);
        OkHttpClient okHttpClient = new OkHttpClient(builderNewBuilder);
        Request.Builder builderNewBuilder2 = request.newBuilder();
        builderNewBuilder2.header(HttpHeaders.Upgrade, "websocket");
        builderNewBuilder2.header(HttpHeaders.Connection, HttpHeaders.Upgrade);
        builderNewBuilder2.header(HttpHeaders.SecWebSocketKey, realWebSocket.key);
        builderNewBuilder2.header(HttpHeaders.SecWebSocketVersion, "13");
        builderNewBuilder2.header(HttpHeaders.SecWebSocketExtensions, "permessage-deflate");
        Request request2 = new Request(builderNewBuilder2);
        RealCall realCall = new RealCall(okHttpClient, request2, true);
        realWebSocket.call = realCall;
        realCall.enqueue(new Splitter(realWebSocket, request2, (byte) 14));
        return realWebSocket;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
