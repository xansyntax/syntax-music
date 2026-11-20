package okhttp3.internal.connection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavDeepLinkRequest;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.NaturalOrderComparator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.ech.EchRetryPlan;
import okhttp3.internal.ech.EchUntrustedException;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.ByteString;
import okio.Path;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectPlan implements RoutePlanner$Plan, ExchangeCodec.Carrier {
    public final int attempt;
    public final RealCall call;
    public volatile boolean canceled;
    public RealConnection connection;
    public final RealConnectionPool connectionPool;
    public final int connectionSpecIndex;
    public final EchRetryPlan echRetryPlan;
    public Handshake handshake;
    public final boolean isTlsFallback;
    public Socket javaNetSocket;
    public final int pingIntervalMillis;
    public Protocol protocol;
    public Socket rawSocket;
    public final int readTimeoutMillis;
    public final boolean retryOnConnectionFailure;
    public final Route route;
    public final RealRoutePlanner routePlanner;
    public final List routes;
    public NavDeepLinkRequest socket;
    public final int socketConnectTimeoutMillis;
    public final int socketReadTimeoutMillis;
    public final TaskRunner taskRunner;
    public final Request tunnelRequest;
    public final int writeTimeoutMillis;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConnectPlan(TaskRunner taskRunner, RealConnectionPool realConnectionPool, int i, int i2, int i3, int i4, int i5, boolean z, RealCall realCall, RealRoutePlanner realRoutePlanner, Route route, List list, int i6, Request request, int i7, boolean z2, EchRetryPlan echRetryPlan) {
        taskRunner.getClass();
        route.getClass();
        this.taskRunner = taskRunner;
        this.connectionPool = realConnectionPool;
        this.readTimeoutMillis = i;
        this.writeTimeoutMillis = i2;
        this.socketConnectTimeoutMillis = i3;
        this.socketReadTimeoutMillis = i4;
        this.pingIntervalMillis = i5;
        this.retryOnConnectionFailure = z;
        this.call = realCall;
        this.routePlanner = realRoutePlanner;
        this.route = route;
        this.routes = list;
        this.attempt = i6;
        this.tunnelRequest = request;
        this.connectionSpecIndex = i7;
        this.isTlsFallback = z2;
        this.echRetryPlan = echRetryPlan;
    }

    public static ConnectPlan copy$default(ConnectPlan connectPlan, Route route, int i, Request request, int i2, boolean z, EchRetryPlan echRetryPlan, int i3) {
        return new ConnectPlan(connectPlan.taskRunner, connectPlan.connectionPool, connectPlan.readTimeoutMillis, connectPlan.writeTimeoutMillis, connectPlan.socketConnectTimeoutMillis, connectPlan.socketReadTimeoutMillis, connectPlan.pingIntervalMillis, connectPlan.retryOnConnectionFailure, connectPlan.call, connectPlan.routePlanner, (i3 & 1) != 0 ? connectPlan.route : route, connectPlan.routes, (i3 & 2) != 0 ? connectPlan.attempt : i, (i3 & 4) != 0 ? connectPlan.tunnelRequest : request, (i3 & 8) != 0 ? connectPlan.connectionSpecIndex : i2, (i3 & 16) != 0 ? connectPlan.isTlsFallback : z, (i3 & 32) != 0 ? connectPlan.echRetryPlan : echRetryPlan);
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    public final void cancel() {
        this.canceled = true;
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    public final void connectSocket() throws IOException {
        Socket socketCreateSocket;
        Proxy.Type type = this.route.proxy.type();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1 || i == 2) {
            socketCreateSocket = this.route.address.socketFactory.createSocket();
            socketCreateSocket.getClass();
        } else {
            socketCreateSocket = new Socket(this.route.proxy);
        }
        this.rawSocket = socketCreateSocket;
        if (this.canceled) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("canceled");
            return;
        }
        socketCreateSocket.setSoTimeout(this.socketReadTimeoutMillis);
        try {
            Platform platform = Platform.platform;
            Platform.platform.connectSocket(socketCreateSocket, this.route.socketAddress, this.socketConnectTimeoutMillis);
            try {
                this.socket = new NavDeepLinkRequest(new Dispatcher(socketCreateSocket));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress);
            connectException.initCause(e2);
            throw connectException;
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final RoutePlanner$ConnectResult connectTcp() {
        Socket socket;
        Socket socket2;
        if (this.rawSocket != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("TCP already connected");
            return null;
        }
        this.call.plansToCancel.add(this);
        boolean z = false;
        try {
            try {
                EventListener eventListener = this.call.eventListener;
                Route route = this.route;
                InetSocketAddress inetSocketAddress = route.socketAddress;
                Proxy proxy = route.proxy;
                eventListener.getClass();
                inetSocketAddress.getClass();
                proxy.getClass();
                this.route.getClass();
                connectSocket();
                z = true;
                RoutePlanner$ConnectResult routePlanner$ConnectResult = new RoutePlanner$ConnectResult(this, null, null, 6);
                this.call.plansToCancel.remove(this);
                return routePlanner$ConnectResult;
            } catch (IOException e) {
                Route route2 = this.route;
                if (route2.address.proxy == null && route2.proxy.type() != Proxy.Type.DIRECT) {
                    Address address = this.route.address;
                    address.proxySelector.connectFailed(address.url.uri(), this.route.proxy.address(), e);
                }
                EventListener eventListener2 = this.call.eventListener;
                Route route3 = this.route;
                InetSocketAddress inetSocketAddress2 = route3.socketAddress;
                Proxy proxy2 = route3.proxy;
                eventListener2.getClass();
                inetSocketAddress2.getClass();
                proxy2.getClass();
                this.route.getClass();
                RoutePlanner$ConnectResult routePlanner$ConnectResult2 = new RoutePlanner$ConnectResult(this, null, e, 2);
                this.call.plansToCancel.remove(this);
                if (!z && (socket2 = this.rawSocket) != null) {
                    _UtilJvmKt.closeQuietly(socket2);
                }
                return routePlanner$ConnectResult2;
            }
        } catch (Throwable th) {
            this.call.plansToCancel.remove(this);
            if (!z && (socket = this.rawSocket) != null) {
                _UtilJvmKt.closeQuietly(socket);
            }
            throw th;
        }
    }

    public final void connectTls(SSLSocket sSLSocket, ConnectionSpec connectionSpec) {
        Protocol protocol;
        Address address = this.route.address;
        try {
            if (connectionSpec.supportsTlsExtensions) {
                Platform platform = Platform.platform;
                Platform.platform.configureTlsExtensions(sSLSocket, address.url.host, address.protocols, this.route.echConfigList);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            session.getClass();
            Handshake handshake = StringsKt__IndentKt.get(session);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier;
            hostnameVerifier.getClass();
            if (hostnameVerifier.verify(address.url.host, session)) {
                CertificatePinner certificatePinner = address.certificatePinner;
                certificatePinner.getClass();
                this.handshake = new Handshake(handshake.tlsVersion, handshake.cipherSuite, handshake.localCertificates, new QueueKt$$ExternalSyntheticLambda24((Object) certificatePinner, (Object) handshake, (Object) address, (byte) 17));
                address.url.host.getClass();
                Iterator it = certificatePinner.pins.iterator();
                String selectedProtocol = null;
                if (it.hasNext()) {
                    Fragment$5$$ExternalSyntheticOutline0.m833m(it.next());
                    throw null;
                }
                if (connectionSpec.supportsTlsExtensions) {
                    Platform platform2 = Platform.platform;
                    selectedProtocol = Platform.platform.getSelectedProtocol(sSLSocket);
                }
                this.javaNetSocket = sSLSocket;
                this.socket = new NavDeepLinkRequest(new Dispatcher(sSLSocket));
                if (selectedProtocol != null) {
                    Protocol.Companion.getClass();
                    protocol = Protocol.Companion.get(selectedProtocol);
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
                this.protocol = protocol;
                Platform platform3 = Platform.platform;
                Platform.platform.getClass();
                return;
            }
            List listPeerCertificates = handshake.peerCertificates();
            if (listPeerCertificates.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + address.url.host + " not verified (no certificates)");
            }
            Object obj = listPeerCertificates.get(0);
            obj.getClass();
            X509Certificate x509Certificate = (X509Certificate) obj;
            StringBuilder sb = new StringBuilder("\n            |Hostname ");
            sb.append(address.url.host);
            sb.append(" not verified:\n            |    certificate: ");
            CertificatePinner certificatePinner2 = CertificatePinner.DEFAULT;
            ByteString byteString = ByteString.EMPTY;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            encoded.getClass();
            sb.append("sha256/".concat(Path.Companion.of$default(encoded).digest$okio("SHA-256").base64()));
            sb.append("\n            |    DN: ");
            sb.append(x509Certificate.getSubjectDN().getName());
            sb.append("\n            |    subjectAltNames: ");
            sb.append(CollectionsKt.plus((Iterable) OkHostnameVerifier.getSubjectAltNames(x509Certificate, 2), (Collection) OkHostnameVerifier.getSubjectAltNames(x509Certificate, 7)));
            sb.append("\n            ");
            throw new SSLPeerUnverifiedException(StringsKt__IndentKt.trimMargin$default(sb.toString()));
        } catch (Throwable th) {
            Platform platform4 = Platform.platform;
            Platform.platform.getClass();
            _UtilJvmKt.closeQuietly(sSLSocket);
            throw th;
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final RoutePlanner$ConnectResult connectTlsEtc() throws Throwable {
        Socket socket = this.rawSocket;
        if (socket == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("TCP not connected");
            return null;
        }
        if (isReady()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("already connected");
            return null;
        }
        List list = this.route.address.connectionSpecs;
        this.call.plansToCancel.add(this);
        boolean z = false;
        try {
            try {
                if (this.tunnelRequest != null) {
                    RoutePlanner$ConnectResult routePlanner$ConnectResultConnectTunnel$okhttp = connectTunnel$okhttp();
                    if (routePlanner$ConnectResultConnectTunnel$okhttp.nextPlan != null || routePlanner$ConnectResultConnectTunnel$okhttp.throwable != null) {
                        this.call.plansToCancel.remove(this);
                        Socket socket2 = this.javaNetSocket;
                        if (socket2 != null) {
                            _UtilJvmKt.closeQuietly(socket2);
                        }
                        _UtilJvmKt.closeQuietly(socket);
                        return routePlanner$ConnectResultConnectTunnel$okhttp;
                    }
                }
                Address address = this.route.address;
                if (address.sslSocketFactory != null) {
                    NavDeepLinkRequest navDeepLinkRequest = this.socket;
                    if (navDeepLinkRequest == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("socket");
                        throw null;
                    }
                    if (((RealBufferedSource) navDeepLinkRequest.action).bufferField.exhausted()) {
                        NavDeepLinkRequest navDeepLinkRequest2 = this.socket;
                        if (navDeepLinkRequest2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("socket");
                            throw null;
                        }
                        if (((RealBufferedSink) navDeepLinkRequest2.mimeType).bufferField.exhausted()) {
                            this.call.eventListener.getClass();
                            Address address2 = this.route.address;
                            SSLSocketFactory sSLSocketFactory = address2.sslSocketFactory;
                            HttpUrl httpUrl = address2.url;
                            Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, httpUrl.host, httpUrl.port, true);
                            socketCreateSocket.getClass();
                            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
                            ConnectPlan connectPlanPlanWithCurrentOrInitialConnectionSpec$okhttp = planWithCurrentOrInitialConnectionSpec$okhttp(list, sSLSocket);
                            ConnectionSpec connectionSpec = (ConnectionSpec) list.get(connectPlanPlanWithCurrentOrInitialConnectionSpec$okhttp.connectionSpecIndex);
                            connectionSpec.apply$okhttp(sSLSocket, connectPlanPlanWithCurrentOrInitialConnectionSpec$okhttp.isTlsFallback);
                            try {
                                connectTls(sSLSocket, connectionSpec);
                                this.call.eventListener.getClass();
                            } catch (SSLException e) {
                                connectPlanPlanWithCurrentOrInitialConnectionSpec$okhttp.nextConnectionSpec$okhttp(list, sSLSocket, e);
                                throw e;
                            }
                        }
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                this.javaNetSocket = socket;
                List list2 = address.protocols;
                Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                if (!list2.contains(protocol)) {
                    protocol = Protocol.HTTP_1_1;
                }
                this.protocol = protocol;
                TaskRunner taskRunner = this.taskRunner;
                RealConnectionPool realConnectionPool = this.connectionPool;
                Route route = this.route;
                Socket socket3 = this.javaNetSocket;
                socket3.getClass();
                Handshake handshake = this.handshake;
                Protocol protocol2 = this.protocol;
                protocol2.getClass();
                NavDeepLinkRequest navDeepLinkRequest3 = this.socket;
                if (navDeepLinkRequest3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("socket");
                    throw null;
                }
                RealConnection realConnection = new RealConnection(taskRunner, realConnectionPool, route, socket, socket3, handshake, protocol2, navDeepLinkRequest3, this.pingIntervalMillis);
                this.connection = realConnection;
                realConnection.start();
                EventListener eventListener = this.call.eventListener;
                Route route2 = this.route;
                InetSocketAddress inetSocketAddress = route2.socketAddress;
                Proxy proxy = route2.proxy;
                eventListener.getClass();
                inetSocketAddress.getClass();
                proxy.getClass();
                try {
                    RoutePlanner$ConnectResult routePlanner$ConnectResult = new RoutePlanner$ConnectResult(this, null, null, 6);
                    this.call.plansToCancel.remove(this);
                    return routePlanner$ConnectResult;
                } catch (IOException e2) {
                    e = e2;
                    z = true;
                    EventListener eventListener2 = this.call.eventListener;
                    Route route3 = this.route;
                    InetSocketAddress inetSocketAddress2 = route3.socketAddress;
                    Proxy proxy2 = route3.proxy;
                    eventListener2.getClass();
                    inetSocketAddress2.getClass();
                    proxy2.getClass();
                    this.route.getClass();
                    RoutePlanner$ConnectResult routePlanner$ConnectResult2 = new RoutePlanner$ConnectResult(this, null, e);
                    this.call.plansToCancel.remove(this);
                    if (!z) {
                        Socket socket4 = this.javaNetSocket;
                        if (socket4 != null) {
                            _UtilJvmKt.closeQuietly(socket4);
                        }
                        _UtilJvmKt.closeQuietly(socket);
                    }
                    return routePlanner$ConnectResult2;
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    this.call.plansToCancel.remove(this);
                    if (!z) {
                        Socket socket5 = this.javaNetSocket;
                        if (socket5 != null) {
                            _UtilJvmKt.closeQuietly(socket5);
                        }
                        _UtilJvmKt.closeQuietly(socket);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    public final RoutePlanner$ConnectResult connectTunnel$okhttp() throws IOException {
        Request request;
        Request request2 = this.tunnelRequest;
        request2.getClass();
        Route route = this.route;
        String str = "CONNECT " + _UtilJvmKt.toHostHeader(route.address.url, true) + " HTTP/1.1";
        while (true) {
            NavDeepLinkRequest navDeepLinkRequest = this.socket;
            if (navDeepLinkRequest == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
                throw null;
            }
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, navDeepLinkRequest);
            NavDeepLinkRequest navDeepLinkRequest2 = this.socket;
            if (navDeepLinkRequest2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
                throw null;
            }
            Timeout timeout = ((RealBufferedSource) navDeepLinkRequest2.action).source.timeout();
            long j = this.readTimeoutMillis;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            timeout.timeout(j, timeUnit);
            NavDeepLinkRequest navDeepLinkRequest3 = this.socket;
            if (navDeepLinkRequest3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
                throw null;
            }
            ((RealBufferedSink) navDeepLinkRequest3.mimeType).sink.timeout().timeout(this.writeTimeoutMillis, timeUnit);
            http1ExchangeCodec.writeRequest(request2.headers, str);
            http1ExchangeCodec.finishRequest();
            Response.Builder responseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            responseHeaders.getClass();
            responseHeaders.request = request2;
            Response responseBuild = responseHeaders.build();
            int i = responseBuild.code;
            long jHeadersContentLength = _UtilJvmKt.headersContentLength(responseBuild);
            if (jHeadersContentLength != -1) {
                Http1ExchangeCodec.FixedLengthSource fixedLengthSourceNewFixedLengthSource = http1ExchangeCodec.newFixedLengthSource(responseBuild.request.url, jHeadersContentLength);
                _UtilJvmKt.skipAll(fixedLengthSourceNewFixedLengthSource, Integer.MAX_VALUE);
                fixedLengthSourceNewFixedLengthSource.close();
            }
            if (i == 200) {
                request = null;
                break;
            }
            if (i != 407) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unexpected response code for CONNECT: "));
                return null;
            }
            Request requestAuthenticate = route.address.proxyAuthenticator.authenticate(route, responseBuild);
            if (requestAuthenticate == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Failed to authenticate with proxy");
                return null;
            }
            if ("close".equalsIgnoreCase(Response.header$default(HttpHeaders.Connection, responseBuild))) {
                request = requestAuthenticate;
                break;
            }
            request2 = requestAuthenticate;
        }
        if (request == null) {
            return new RoutePlanner$ConnectResult(this, null, null, 6);
        }
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
        int i2 = this.attempt + 1;
        if (i2 < 21) {
            EventListener eventListener = this.call.eventListener;
            Route route2 = this.route;
            InetSocketAddress inetSocketAddress = route2.socketAddress;
            Proxy proxy = route2.proxy;
            eventListener.getClass();
            inetSocketAddress.getClass();
            proxy.getClass();
            return new RoutePlanner$ConnectResult(this, copy$default(this, null, i2, request, 0, false, null, 57), null, 4);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        EventListener eventListener2 = this.call.eventListener;
        Route route3 = this.route;
        InetSocketAddress inetSocketAddress2 = route3.socketAddress;
        Proxy proxy2 = route3.proxy;
        eventListener2.getClass();
        inetSocketAddress2.getClass();
        proxy2.getClass();
        this.route.getClass();
        return new RoutePlanner$ConnectResult(this, null, protocolException, 2);
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final Route getRoute() {
        return this.route;
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final RealConnection handleSuccess() {
        ConnectionPool connectionPool = this.call.client.routeDatabase;
        Route route = this.route;
        synchronized (connectionPool) {
            route.getClass();
            ((LinkedHashSet) connectionPool.delegate).remove(route);
        }
        RealConnection realConnection = this.connection;
        realConnection.getClass();
        this.route.getClass();
        ReusePlan reusePlanPlanReusePooledConnection$okhttp = this.routePlanner.planReusePooledConnection$okhttp(this, this.routes);
        if (reusePlanPlanReusePooledConnection$okhttp != null) {
            return reusePlanPlanReusePooledConnection$okhttp.connection;
        }
        synchronized (realConnection) {
            RealConnectionPool realConnectionPool = this.connectionPool;
            TimeZone timeZone = _UtilJvmKt.UTC;
            realConnectionPool.connections.add(realConnection);
            realConnectionPool.cleanupQueue.schedule(realConnectionPool.cleanupTask, 0L);
            this.call.acquireConnectionNoEvents(realConnection);
        }
        this.call.eventListener.getClass();
        return realConnection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final boolean isReady() {
        return this.protocol != null;
    }

    public final ConnectPlan nextCompatibleConnectionSpec(List list, SSLSocket sSLSocket) {
        String[] strArr;
        String[] strArr2;
        int i = this.connectionSpecIndex;
        int size = list.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ConnectionSpec connectionSpec = (ConnectionSpec) list.get(i2);
            connectionSpec.getClass();
            if (connectionSpec.isTls && (((strArr = connectionSpec.tlsVersionsAsString) == null || _UtilCommonKt.hasIntersection(strArr, sSLSocket.getEnabledProtocols(), NaturalOrderComparator.INSTANCE)) && ((strArr2 = connectionSpec.cipherSuitesAsString) == null || _UtilCommonKt.hasIntersection(strArr2, sSLSocket.getEnabledCipherSuites(), CipherSuite.ORDER_BY_NAME)))) {
                return copy$default(this, null, 0, null, i2, i != -1, null, 39);
            }
        }
        return null;
    }

    public final ConnectPlan nextConnectionSpec$okhttp(List list, SSLSocket sSLSocket, SSLException sSLException) throws EchUntrustedException {
        if (this.echRetryPlan != null) {
            return null;
        }
        Platform platform = Platform.platform;
        EchRetryPlan echRetryPlan = Platform.platform.echRetryPlan(sSLException);
        if (echRetryPlan != null) {
            HostnameVerifier hostnameVerifier = this.route.address.hostnameVerifier;
            hostnameVerifier.getClass();
            if (!hostnameVerifier.verify(echRetryPlan.publicName, sSLSocket.getSession())) {
                throw new EchUntrustedException(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("public_name '"), echRetryPlan.publicName, "' not verified"), sSLException);
            }
            Route route = this.route;
            return copy$default(this, new Route(route.address, route.proxy, route.socketAddress, echRetryPlan.configList), 0, null, 0, false, echRetryPlan, 30);
        }
        if (!this.retryOnConnectionFailure) {
            return null;
        }
        if (((sSLException instanceof SSLHandshakeException) && (sSLException.getCause() instanceof CertificateException)) || (sSLException instanceof SSLPeerUnverifiedException)) {
            return null;
        }
        return nextCompatibleConnectionSpec(list, sSLSocket);
    }

    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(List list, SSLSocket sSLSocket) throws UnknownServiceException {
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan connectPlanNextCompatibleConnectionSpec = nextCompatibleConnectionSpec(list, sSLSocket);
        if (connectPlanNextCompatibleConnectionSpec != null) {
            return connectPlanNextCompatibleConnectionSpec;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isTlsFallback);
        sb.append(", modes=");
        sb.append(list);
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        enabledProtocols.getClass();
        String string = Arrays.toString(enabledProtocols);
        string.getClass();
        sb.append(", supported protocols=");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final RoutePlanner$Plan retry() {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this.routePlanner, this.route, this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback, this.echRetryPlan);
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final void noNewExchanges() {
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final void trackFailure(RealCall realCall, IOException iOException) {
    }
}
