package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealCall implements Call, Cloneable {
    public Object callStackTrace;
    public volatile boolean canceled;
    public final OkHttpClient client;
    public RealConnection connection;
    public final RealConnectionPool connectionPool;
    public volatile EventListener eventListener;
    public volatile Exchange exchange;
    public ExchangeFinder exchangeFinder;
    public final AtomicBoolean executed;
    public boolean expectMoreExchanges;
    public final boolean forWebSocket;
    public Exchange interceptorScopedExchange;
    public final Request originalRequest;
    public final CopyOnWriteArrayList plansToCancel;
    public boolean requestBodyOpen;
    public boolean responseBodyOpen;
    public boolean socketSinkOpen;
    public boolean socketSourceOpen;
    public final RealCall$timeout$1 timeout;
    public boolean timeoutEarlyExit;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AsyncCall implements Runnable {
        public volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        public final Callback responseCallback;

        public AsyncCall(Callback callback) {
            this.responseCallback = callback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dispatcher dispatcher;
            String strConcat = "OkHttp ".concat(RealCall.this.originalRequest.url.redact());
            RealCall realCall = RealCall.this;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(strConcat);
            try {
                realCall.timeout.enter();
                boolean z = false;
                try {
                    try {
                        try {
                            this.responseCallback.onResponse(realCall, realCall.getResponseWithInterceptorChain$okhttp());
                            dispatcher = realCall.client.dispatcher;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (z) {
                                Platform platform = Platform.platform;
                                Platform platform2 = Platform.platform;
                                StringBuilder sb = new StringBuilder("Callback failure for ");
                                StringBuilder sb2 = new StringBuilder(realCall.canceled ? "canceled " : "");
                                sb2.append(realCall.forWebSocket ? "web socket" : "call");
                                sb2.append(" to ");
                                sb2.append(realCall.originalRequest.url.redact());
                                sb.append(sb2.toString());
                                platform2.log(4, sb.toString(), e);
                            } else {
                                this.responseCallback.onFailure(realCall, e);
                            }
                            dispatcher = realCall.client.dispatcher;
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            realCall.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                iOException.initCause(th);
                                this.responseCallback.onFailure(realCall, iOException);
                            }
                            if (!(th instanceof InterruptedException)) {
                                throw th;
                            }
                            Thread.currentThread().interrupt();
                            dispatcher = realCall.client.dispatcher;
                        }
                    } catch (Throwable th2) {
                        Dispatcher dispatcher2 = realCall.client.dispatcher;
                        dispatcher2.getClass();
                        Dispatcher.promoteAndExecute$default(dispatcher2, null, null, this, 3);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
                dispatcher.getClass();
                Dispatcher.promoteAndExecute$default(dispatcher, null, null, this, 3);
                threadCurrentThread.setName(name);
            } catch (Throwable th4) {
                threadCurrentThread.setName(name);
                throw th4;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CallReference extends WeakReference {
        public final Object callStackTrace;

        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            this.callStackTrace = obj;
        }
    }

    static {
        AtomicReferenceFieldUpdater.newUpdater(RealCall.class, EventListener.class, "eventListener");
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [okhttp3.internal.connection.RealCall$timeout$1, okio.Timeout] */
    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        okHttpClient.getClass();
        request.getClass();
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.connectionPool = (RealConnectionPool) okHttpClient.connectionPool.delegate;
        okHttpClient.eventListenerFactory.getClass();
        this.eventListener = EventListener.NONE;
        ?? r3 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            public final void timedOut() {
                this.this$0.cancel();
            }
        };
        r3.timeout(0L, TimeUnit.MILLISECONDS);
        this.timeout = r3;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
        this.plansToCancel = new CopyOnWriteArrayList();
        new AtomicReference(request.tags);
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        realConnection.getClass();
        TimeZone timeZone = _UtilJvmKt.UTC;
        if (this.connection != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        } else {
            this.connection = realConnection;
            realConnection.calls.add(new CallReference(this, this.callStackTrace));
        }
    }

    public final IOException callDone(IOException iOException) {
        IOException interruptedIOException;
        Socket socketReleaseConnectionNoEvents$okhttp;
        TimeZone timeZone = _UtilJvmKt.UTC;
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            synchronized (realConnection) {
                socketReleaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                }
                this.eventListener.getClass();
            } else if (socketReleaseConnectionNoEvents$okhttp != null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                return null;
            }
        }
        if (!this.timeoutEarlyExit && exit()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        EventListener eventListener = this.eventListener;
        if (iOException == null) {
            eventListener.getClass();
            return interruptedIOException;
        }
        interruptedIOException.getClass();
        eventListener.getClass();
        return interruptedIOException;
    }

    public final void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            ((ExchangeCodec) exchange.codec).cancel();
        }
        Iterator it = this.plansToCancel.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((RoutePlanner$Plan) it.next()).cancel();
        }
        this.eventListener.getClass();
    }

    public final Object clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    public final void enqueue(Callback callback) {
        if (!this.executed.compareAndSet(false, true)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Already Executed");
            return;
        }
        Platform platform = Platform.platform;
        this.callStackTrace = Platform.platform.getStackTraceForCloseable();
        this.eventListener.getClass();
        Dispatcher dispatcher = this.client.dispatcher;
        AsyncCall asyncCall = new AsyncCall(callback);
        dispatcher.getClass();
        Dispatcher.promoteAndExecute$default(dispatcher, asyncCall, null, null, 6);
    }

    public final Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Already Executed");
            return null;
        }
        enter();
        Platform platform = Platform.platform;
        this.callStackTrace = Platform.platform.getStackTraceForCloseable();
        this.eventListener.getClass();
        try {
            Dispatcher dispatcher = this.client.dispatcher;
            synchronized (dispatcher) {
                ((ArrayDeque) dispatcher.runningSyncCalls).add(this);
            }
            Response responseWithInterceptorChain$okhttp = getResponseWithInterceptorChain$okhttp();
            Dispatcher dispatcher2 = this.client.dispatcher;
            dispatcher2.getClass();
            Dispatcher.promoteAndExecute$default(dispatcher2, null, this, null, 5);
            return responseWithInterceptorChain$okhttp;
        } catch (Throwable th) {
            Dispatcher dispatcher3 = this.client.dispatcher;
            dispatcher3.getClass();
            Dispatcher.promoteAndExecute$default(dispatcher3, null, this, null, 5);
            throw th;
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
        }
        if (z && (exchange = this.exchange) != null) {
            ((ExchangeCodec) exchange.codec).cancel();
            ((RealCall) exchange.call).messageDone$okhttp(exchange, true, true, true, true, null);
        }
        this.interceptorScopedExchange = null;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00c1  */
    public final Response getResponseWithInterceptorChain$okhttp() throws Throwable {
        boolean z;
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(this.client.interceptors, arrayList);
        arrayList.add(new BridgeInterceptor((byte) 2));
        arrayList.add(new BridgeInterceptor((byte) 0));
        arrayList.add(new CacheInterceptor());
        arrayList.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt__MutableCollectionsKt.addAll(this.client.networkInterceptors, arrayList);
        }
        arrayList.add(BridgeInterceptor.INSTANCE);
        Request request = this.originalRequest;
        OkHttpClient okHttpClient = this.client;
        request.getClass();
        okHttpClient.getClass();
        try {
            Response responseProceed = new RealInterceptorChain(this, arrayList, 0, null, request, okHttpClient.connectTimeoutMillis, okHttpClient.readTimeoutMillis, okHttpClient.writeTimeoutMillis, okHttpClient.authenticator, okHttpClient.cache, okHttpClient.certificatePinner, okHttpClient.connectionPool, okHttpClient.cookieJar, okHttpClient.dns, okHttpClient.hostnameVerifier, okHttpClient.proxy, okHttpClient.proxyAuthenticator, okHttpClient.proxySelector, okHttpClient.retryOnConnectionFailure, okHttpClient.socketFactory, okHttpClient.sslSocketFactoryOrNull, okHttpClient.x509TrustManager, okHttpClient.certificateChainCleaner).proceed(this.originalRequest);
            if (this.canceled) {
                _UtilCommonKt.closeQuietly(responseProceed);
                throw new IOException("Canceled");
            }
            noMoreExchanges$okhttp(null);
            return responseProceed;
        } catch (IOException e) {
            z = true;
            try {
                IOException iOExceptionNoMoreExchanges$okhttp = noMoreExchanges$okhttp(e);
                iOExceptionNoMoreExchanges$okhttp.getClass();
                throw iOExceptionNoMoreExchanges$okhttp;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                    noMoreExchanges$okhttp(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            if (!z) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x002b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x002d A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0039, B:30:0x003b, B:32:0x003f, B:34:0x0043, B:36:0x0047, B:41:0x0050, B:14:0x001b, B:17:0x0021, B:20:0x0027), top: B:63:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0031 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0039, B:30:0x003b, B:32:0x003f, B:34:0x0043, B:36:0x0047, B:41:0x0050, B:14:0x001b, B:17:0x0021, B:20:0x0027), top: B:63:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0035 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0039, B:30:0x003b, B:32:0x003f, B:34:0x0043, B:36:0x0047, B:41:0x0050, B:14:0x001b, B:17:0x0021, B:20:0x0027), top: B:63:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0039 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0039, B:30:0x003b, B:32:0x003f, B:34:0x0043, B:36:0x0047, B:41:0x0050, B:14:0x001b, B:17:0x0021, B:20:0x0027), top: B:63:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x004d  */
    public final IOException messageDone$okhttp(Exchange exchange, boolean z, boolean z2, boolean z3, boolean z4, IOException iOException) {
        boolean z5;
        boolean z6;
        boolean z7;
        exchange.getClass();
        if (exchange.equals(this.exchange)) {
            synchronized (this) {
                z5 = false;
                if (z) {
                    try {
                        if (this.requestBodyOpen) {
                            if (z) {
                                this.requestBodyOpen = false;
                            }
                            if (z2) {
                                this.responseBodyOpen = false;
                            }
                            if (z4) {
                                this.socketSinkOpen = false;
                            }
                            if (z3) {
                                this.socketSourceOpen = false;
                            }
                            if (this.requestBodyOpen) {
                                z7 = false;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                z5 = true;
                            }
                            boolean z8 = z5;
                            z5 = z7;
                            z6 = z8;
                        } else if ((!z2 && this.responseBodyOpen) || ((z4 && this.socketSinkOpen) || (z3 && this.socketSourceOpen))) {
                            if (z) {
                                this.requestBodyOpen = false;
                            }
                            if (z2) {
                                this.responseBodyOpen = false;
                            }
                            if (z4) {
                                this.socketSinkOpen = false;
                            }
                            if (z3) {
                                this.socketSourceOpen = false;
                            }
                            if (this.requestBodyOpen || this.responseBodyOpen || this.socketSinkOpen || this.socketSourceOpen) {
                                z7 = false;
                            } else {
                                z7 = true;
                            }
                            if (z7 && !this.expectMoreExchanges) {
                                z5 = true;
                            }
                            boolean z9 = z5;
                            z5 = z7;
                            z6 = z9;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    z6 = !z2 ? false : false;
                }
            }
            if (z5) {
                this.exchange = null;
                RealConnection realConnection = this.connection;
                if (realConnection != null) {
                    synchronized (realConnection) {
                        realConnection.successCount++;
                    }
                }
            }
            if (z6) {
                return callDone(iOException);
            }
        }
        return iOException;
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen && !this.socketSinkOpen && !this.socketSourceOpen) {
                    z = true;
                }
            }
        }
        return z ? callDone(iOException) : iOException;
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        realConnection.getClass();
        TimeZone timeZone = _UtilJvmKt.UTC;
        ArrayList arrayList = realConnection.calls;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = -1;
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            if (Intrinsics.areEqual(((Reference) obj).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            return null;
        }
        arrayList.remove(i);
        this.connection = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        realConnection.idleAtNs = System.nanoTime();
        RealConnectionPool realConnectionPool = this.connectionPool;
        TaskQueue taskQueue = realConnectionPool.cleanupQueue;
        ConcurrentLinkedQueue concurrentLinkedQueue = realConnectionPool.connections;
        TimeZone timeZone2 = _UtilJvmKt.UTC;
        if (!realConnection.noNewExchanges && realConnectionPool.maxIdleConnections != 0) {
            taskQueue.schedule(realConnectionPool.cleanupTask, 0L);
            return null;
        }
        realConnection.noNewExchanges = true;
        concurrentLinkedQueue.remove(realConnection);
        if (concurrentLinkedQueue.isEmpty()) {
            taskQueue.cancelAll();
        }
        return realConnection.javaNetSocket;
    }
}
