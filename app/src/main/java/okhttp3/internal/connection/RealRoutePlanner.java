package okhttp3.internal.connection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.intercept.RealInterceptorChain;
import dagger.hilt.EntryPoints;
import io.ktor.http.HttpHeaders;
import java.io.Serializable;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import okhttp3.Route;
import okhttp3.TrailersSource;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealRoutePlanner {
    public final Address address;
    public final RealCall call;
    public final RealConnectionPool connectionPool;
    public final ArrayDeque deferredPlans;
    public final boolean doExtensiveHealthChecks;
    public final boolean fastFallback;
    public Route nextRouteToTry;
    public final int pingIntervalMillis;
    public final int readTimeoutMillis;
    public final boolean retryOnConnectionFailure;
    public final ConnectionPool routeDatabase;
    public PriorityQueue routeSelection;
    public RealInterceptorChain routeSelector;
    public final int socketConnectTimeoutMillis;
    public final int socketReadTimeoutMillis;
    public final TaskRunner taskRunner;
    public final int writeTimeoutMillis;

    public RealRoutePlanner(TaskRunner taskRunner, RealConnectionPool realConnectionPool, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, Address address, ConnectionPool connectionPool, RealCall realCall, Request request) {
        taskRunner.getClass();
        connectionPool.getClass();
        this.taskRunner = taskRunner;
        this.connectionPool = realConnectionPool;
        this.readTimeoutMillis = i;
        this.writeTimeoutMillis = i2;
        this.socketConnectTimeoutMillis = i3;
        this.socketReadTimeoutMillis = i4;
        this.pingIntervalMillis = i5;
        this.retryOnConnectionFailure = z;
        this.fastFallback = z2;
        this.address = address;
        this.routeDatabase = connectionPool;
        this.call = realCall;
        this.doExtensiveHealthChecks = !Intrinsics.areEqual(request.method, "GET");
        this.deferredPlans = new ArrayDeque();
    }

    public final boolean hasNext(RealConnection realConnection) {
        RealInterceptorChain realInterceptorChain;
        Route route;
        if (this.deferredPlans.isEmpty() && this.nextRouteToTry == null) {
            if (realConnection != null) {
                synchronized (realConnection) {
                    route = null;
                    if (realConnection.routeFailureCount == 0 && realConnection.noNewExchanges && _UtilJvmKt.canReuseConnectionFor(realConnection.route.address.url, this.address.url)) {
                        route = realConnection.route;
                    }
                }
                if (route != null) {
                    this.nextRouteToTry = route;
                    return true;
                }
            }
            PriorityQueue priorityQueue = this.routeSelection;
            if ((priorityQueue == null || priorityQueue.size >= ((ArrayList) priorityQueue.array).size()) && (realInterceptorChain = this.routeSelector) != null) {
                return realInterceptorChain.hasNext();
            }
        }
        return true;
    }

    public final RoutePlanner$Plan plan() {
        Socket socketReleaseConnectionNoEvents$okhttp;
        ReusePlan reusePlan;
        ConnectPlan connectPlanPlanConnectToRoute$okhttp;
        String hostAddress;
        int port;
        ArrayList arrayList;
        List<Route> listBuild;
        boolean zContains;
        RealConnection realConnection = this.call.connection;
        if (realConnection == null) {
            reusePlan = null;
        } else {
            boolean zIsHealthy = realConnection.isHealthy(this.doExtensiveHealthChecks);
            synchronized (realConnection) {
                boolean z = realConnection.noNewExchanges;
                try {
                    if (!zIsHealthy) {
                        realConnection.noNewExchanges = true;
                        socketReleaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
                    } else if (!z) {
                        HttpUrl httpUrl = realConnection.route.address.url;
                        HttpUrl httpUrl2 = this.address.url;
                        socketReleaseConnectionNoEvents$okhttp = !(httpUrl.port == httpUrl2.port && Intrinsics.areEqual(httpUrl.host, httpUrl2.host)) ? this.call.releaseConnectionNoEvents$okhttp() : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.call.connection == null) {
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                }
                this.call.eventListener.getClass();
                reusePlan = null;
            } else {
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                    return null;
                }
                reusePlan = new ReusePlan(realConnection);
            }
        }
        if (reusePlan != null) {
            return reusePlan;
        }
        ReusePlan reusePlanPlanReusePooledConnection$okhttp = planReusePooledConnection$okhttp(null, null);
        if (reusePlanPlanReusePooledConnection$okhttp != null) {
            return reusePlanPlanReusePooledConnection$okhttp;
        }
        if (!this.deferredPlans.isEmpty()) {
            return (RoutePlanner$Plan) this.deferredPlans.removeFirst();
        }
        Route route = this.nextRouteToTry;
        if (route != null) {
            this.nextRouteToTry = null;
            connectPlanPlanConnectToRoute$okhttp = planConnectToRoute$okhttp(route, null);
        } else {
            PriorityQueue priorityQueue = this.routeSelection;
            if (priorityQueue == null || priorityQueue.size >= ((ArrayList) priorityQueue.array).size()) {
                RealInterceptorChain realInterceptorChain = this.routeSelector;
                if (realInterceptorChain == null) {
                    realInterceptorChain = new RealInterceptorChain(this.address, this.routeDatabase, this.call, this.fastFallback);
                    this.routeSelector = realInterceptorChain;
                }
                if (!realInterceptorChain.hasNext()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("exhausted all routes");
                    return null;
                }
                if (!realInterceptorChain.hasNext()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                while (realInterceptorChain.index < realInterceptorChain.interceptors.size()) {
                    if (realInterceptorChain.index >= realInterceptorChain.interceptors.size()) {
                        throw new SocketException("No route to " + ((Address) realInterceptorChain.initialRequest).url.host + "; exhausted proxy configurations: " + realInterceptorChain.interceptors);
                    }
                    List list = realInterceptorChain.interceptors;
                    int i = realInterceptorChain.index;
                    realInterceptorChain.index = i + 1;
                    Proxy proxy = (Proxy) list.get(i);
                    if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                        HttpUrl httpUrl3 = ((Address) realInterceptorChain.initialRequest).url;
                        hostAddress = httpUrl3.host;
                        port = httpUrl3.port;
                    } else {
                        SocketAddress socketAddressAddress = proxy.address();
                        if (!(socketAddressAddress instanceof InetSocketAddress)) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$4(socketAddressAddress.getClass(), "Proxy.address() is not an InetSocketAddress: ");
                            return null;
                        }
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                        InetAddress address = inetSocketAddress.getAddress();
                        if (address == null) {
                            hostAddress = inetSocketAddress.getHostName();
                            hostAddress.getClass();
                        } else {
                            hostAddress = address.getHostAddress();
                            hostAddress.getClass();
                        }
                        port = inetSocketAddress.getPort();
                    }
                    if (1 > port || port >= 65536) {
                        throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
                    }
                    if (proxy.type() == Proxy.Type.SOCKS) {
                        Address address2 = (Address) realInterceptorChain.initialRequest;
                        InetSocketAddress inetSocketAddressCreateUnresolved = InetSocketAddress.createUnresolved(hostAddress, port);
                        inetSocketAddressCreateUnresolved.getClass();
                        listBuild = CollectionsKt__IterablesKt.listOf(new Route(address2, proxy, inetSocketAddressCreateUnresolved, null));
                    } else {
                        Regex regex = _HostnamesCommonKt.VERIFY_AS_IP_ADDRESS;
                        hostAddress.getClass();
                        if (_HostnamesCommonKt.VERIFY_AS_IP_ADDRESS.matches(hostAddress)) {
                            listBuild = CollectionsKt__IterablesKt.listOf(new Route((Address) realInterceptorChain.initialRequest, proxy, new InetSocketAddress(InetAddress.getByName(hostAddress), port), null));
                        } else {
                            ((RealCall) realInterceptorChain.size).eventListener.getClass();
                            ((Address) realInterceptorChain.initialRequest).dns.newCall(new Dns.Request(hostAddress, (((Address) realInterceptorChain.initialRequest).url.isHttps() || port != 80) ? port : -1));
                            List listLookup = ((Address) realInterceptorChain.initialRequest).dns.lookup(hostAddress);
                            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listLookup, 10));
                            Iterator it = listLookup.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(new Route((Address) realInterceptorChain.initialRequest, proxy, new InetSocketAddress((InetAddress) it.next(), port), null));
                            }
                            if (arrayList3.isEmpty()) {
                                throw new UnknownHostException(((Address) realInterceptorChain.initialRequest).dns + " returned no addresses for " + hostAddress);
                            }
                            EventListener eventListener = ((RealCall) realInterceptorChain.size).eventListener;
                            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                            int size = arrayList3.size();
                            int i2 = 0;
                            while (i2 < size) {
                                Object obj = arrayList3.get(i2);
                                i2++;
                                arrayList4.add(((Route) obj).socketAddress.getAddress());
                            }
                            eventListener.getClass();
                            ArrayList arrayList5 = new ArrayList();
                            int size2 = arrayList3.size();
                            int i3 = 0;
                            while (i3 < size2) {
                                Object obj2 = arrayList3.get(i3);
                                i3++;
                                if (((Route) obj2).echConfigList != null) {
                                    arrayList5.add(obj2);
                                }
                            }
                            boolean zIsEmpty = arrayList5.isEmpty();
                            arrayList = arrayList5;
                            if (zIsEmpty) {
                                arrayList = arrayList3;
                            }
                            listBuild = arrayList;
                            if (realInterceptorChain.isPlaceholderCached && arrayList.size() >= 2) {
                                ArrayList arrayList6 = new ArrayList();
                                ArrayList arrayList7 = new ArrayList();
                                int size3 = arrayList.size();
                                int i4 = 0;
                                while (i4 < size3) {
                                    Object obj3 = arrayList.get(i4);
                                    i4++;
                                    if (((Route) obj3).socketAddress.getAddress() instanceof Inet6Address) {
                                        listBuild = arrayList;
                                        arrayList6.add(obj3);
                                    } else {
                                        listBuild = arrayList;
                                        arrayList7.add(obj3);
                                    }
                                }
                                listBuild = arrayList;
                                listBuild = arrayList;
                                if (!arrayList6.isEmpty() && !arrayList7.isEmpty()) {
                                    listBuild = arrayList;
                                    byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                                    Iterator it2 = arrayList6.iterator();
                                    Iterator it3 = arrayList7.iterator();
                                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                                    while (true) {
                                        if (!it2.hasNext() && !it3.hasNext()) {
                                            break;
                                        }
                                        if (it2.hasNext()) {
                                            listBuilderCreateListBuilder.add(it2.next());
                                        }
                                        if (it3.hasNext()) {
                                            listBuilderCreateListBuilder.add(it3.next());
                                        }
                                    }
                                    listBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                                }
                            }
                        }
                    }
                    listBuild = arrayList;
                    listBuild = arrayList;
                    for (Route route2 : listBuild) {
                        ConnectionPool connectionPool = (ConnectionPool) realInterceptorChain.request;
                        synchronized (connectionPool) {
                            route2.getClass();
                            zContains = ((LinkedHashSet) connectionPool.delegate).contains(route2);
                        }
                        if (zContains) {
                            ((ArrayList) realInterceptorChain.eventListener).add(route2);
                        } else {
                            arrayList2.add(route2);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                }
                if (arrayList2.isEmpty()) {
                    CollectionsKt__MutableCollectionsKt.addAll((ArrayList) realInterceptorChain.eventListener, arrayList2);
                    ((ArrayList) realInterceptorChain.eventListener).clear();
                }
                PriorityQueue priorityQueue2 = new PriorityQueue((Serializable) arrayList2, (byte) 13);
                this.routeSelection = priorityQueue2;
                if (this.call.canceled) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Canceled");
                    return null;
                }
                if (priorityQueue2.size >= arrayList2.size()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                int i5 = priorityQueue2.size;
                priorityQueue2.size = i5 + 1;
                connectPlanPlanConnectToRoute$okhttp = planConnectToRoute$okhttp((Route) arrayList2.get(i5), arrayList2);
            } else {
                int i6 = priorityQueue.size;
                ArrayList arrayList8 = (ArrayList) priorityQueue.array;
                if (i6 >= arrayList8.size()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                int i7 = priorityQueue.size;
                priorityQueue.size = i7 + 1;
                connectPlanPlanConnectToRoute$okhttp = planConnectToRoute$okhttp((Route) arrayList8.get(i7), null);
            }
        }
        ReusePlan reusePlanPlanReusePooledConnection$okhttp2 = planReusePooledConnection$okhttp(connectPlanPlanConnectToRoute$okhttp, connectPlanPlanConnectToRoute$okhttp.routes);
        return reusePlanPlanReusePooledConnection$okhttp2 != null ? reusePlanPlanReusePooledConnection$okhttp2 : connectPlanPlanConnectToRoute$okhttp;
    }

    public final ConnectPlan planConnectToRoute$okhttp(Route route, ArrayList arrayList) throws UnknownServiceException {
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        route.getClass();
        Address address = route.address;
        if (address.sslSocketFactory == null) {
            if (!address.connectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String str = route.address.url.host;
            Platform platform = Platform.platform;
            if (!Platform.platform.isCleartextTrafficPermitted(str)) {
                throw new UnknownServiceException(IntIntPair$$ExternalSyntheticOutline0.m("CLEARTEXT communication to ", str, " not permitted by network security policy"));
            }
        } else if (address.protocols.contains(protocol)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        Request request = null;
        if (route.proxy.type() == Proxy.Type.HTTP) {
            Address address2 = route.address;
            if (address2.sslSocketFactory != null || address2.protocols.contains(protocol)) {
                Request.Builder builder = new Request.Builder();
                builder.url = route.address.url;
                builder.method("CONNECT", null);
                Address address3 = route.address;
                builder.header(HttpHeaders.Host, _UtilJvmKt.toHostHeader(address3.url, true));
                builder.header("Proxy-Connection", "Keep-Alive");
                builder.header(HttpHeaders.UserAgent, "okhttp/5.5.0");
                Request request2 = new Request(builder);
                ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$1 = ResponseBody.EMPTY;
                Protocol.Companion companion = TrailersSource.EMPTY;
                Headers.Builder builder2 = new Headers.Builder((byte) 0);
                Protocol protocol2 = Protocol.HTTP_1_1;
                EntryPoints.headersCheckName(HttpHeaders.ProxyAuthenticate);
                EntryPoints.headersCheckValue("OkHttp-Preemptive", HttpHeaders.ProxyAuthenticate);
                builder2.removeAll(HttpHeaders.ProxyAuthenticate);
                EntryPoints.commonAddLenient(builder2, HttpHeaders.ProxyAuthenticate, "OkHttp-Preemptive");
                Request requestAuthenticate = address3.proxyAuthenticator.authenticate(route, new Response(request2, protocol2, "Preemptive Authenticate", 407, null, EntryPoints.commonBuild(builder2), responseBody$Companion$asResponseBody$1, null, null, null, null, -1L, -1L, null, companion));
                request = requestAuthenticate == null ? request2 : requestAuthenticate;
            }
        }
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this, route, arrayList, 0, request, -1, false, null);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003e A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:14:0x0031, B:22:0x003e, B:25:0x0045), top: B:53:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0045 A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #1 {all -> 0x003c, blocks: (B:14:0x0031, B:22:0x003e, B:25:0x0045), top: B:53:0x0031 }] */
    public final ReusePlan planReusePooledConnection$okhttp(ConnectPlan connectPlan, List list) {
        RealConnection realConnection;
        boolean z;
        Socket socketReleaseConnectionNoEvents$okhttp;
        RealConnectionPool realConnectionPool = this.connectionPool;
        boolean z2 = this.doExtensiveHealthChecks;
        Address address = this.address;
        RealCall realCall = this.call;
        boolean z3 = connectPlan != null && connectPlan.isReady();
        Iterator it = realConnectionPool.connections.iterator();
        it.getClass();
        while (true) {
            if (!it.hasNext()) {
                realConnection = null;
                break;
            }
            realConnection = (RealConnection) it.next();
            realConnection.getClass();
            synchronized (realConnection) {
                if (z3) {
                    try {
                        if (!(realConnection.http2Connection != null)) {
                            z = false;
                        } else if (realConnection.isEligible$okhttp(address, list)) {
                            realCall.acquireConnectionNoEvents(realConnection);
                            z = true;
                        } else {
                            z = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (realConnection.isEligible$okhttp(address, list)) {
                    z = false;
                } else {
                    realCall.acquireConnectionNoEvents(realConnection);
                    z = true;
                }
            }
            if (z) {
                if (realConnection.isHealthy(z2)) {
                    break;
                }
                synchronized (realConnection) {
                    realConnection.noNewExchanges = true;
                    socketReleaseConnectionNoEvents$okhttp = realCall.releaseConnectionNoEvents$okhttp();
                }
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                }
            }
        }
        if (realConnection == null) {
            return null;
        }
        if (connectPlan != null) {
            this.nextRouteToTry = connectPlan.route;
            Socket socket = connectPlan.javaNetSocket;
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
            }
        }
        this.call.eventListener.getClass();
        return new ReusePlan(realConnection);
    }
}
