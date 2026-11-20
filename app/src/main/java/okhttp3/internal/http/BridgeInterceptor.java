package okhttp3.internal.http;

import dagger.hilt.EntryPoints;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.UnreadableResponseBody;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.FastFallbackExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RealRoutePlanner;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.GzipSource;
import okio.Okio__OkioKt;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class BridgeInterceptor implements Interceptor {
    public static final BridgeInterceptor INSTANCE = new BridgeInterceptor(1);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BridgeInterceptor(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0148  */
    /* JADX WARN: Code duplicated, block: B:108:0x0163  */
    /* JADX WARN: Code duplicated, block: B:111:0x0170  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:86:0x0101  */
    /* JADX WARN: Code duplicated, block: B:96:0x0124  */
    /* JADX WARN: Code duplicated, block: B:98:0x012c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0133  */
    public static Request followUpRequest(Response response, Exchange exchange, RealInterceptorChain realInterceptorChain) throws ProtocolException, EOFException {
        String strHeader$default;
        Request request;
        HttpUrl.Builder builder;
        HttpUrl httpUrlBuild;
        Request.Builder builderNewBuilder;
        int i;
        RequestBody requestBody;
        Response response2;
        Route route = exchange != null ? exchange.getConnection$okhttp().route : null;
        int i2 = response.code;
        Request request2 = response.request;
        String str = request2.method;
        boolean z = false;
        if (i2 == 307 || i2 == 308) {
            if (realInterceptorChain.call.client.followRedirects) {
                strHeader$default = Response.header$default(io.ktor.http.HttpHeaders.Location, response);
                request = response.request;
                if (strHeader$default != null) {
                    HttpUrl httpUrl = request.url;
                    httpUrl.getClass();
                    try {
                        builder = new HttpUrl.Builder();
                        builder.parse$okhttp(httpUrl, strHeader$default);
                    } catch (IllegalArgumentException unused) {
                        builder = null;
                    }
                    if (builder != null) {
                        httpUrlBuild = builder.build();
                    } else {
                        httpUrlBuild = null;
                    }
                    if (httpUrlBuild != null && (Intrinsics.areEqual(httpUrlBuild.scheme, request.url.scheme) || realInterceptorChain.call.client.followSslRedirects)) {
                        builderNewBuilder = request.newBuilder();
                        if (Okio__OkioKt.permitsRequestBody(str)) {
                            i = response.code;
                            if (i == 303) {
                                z = !str.equals("PROPFIND");
                            } else if (i != 307 && i != 308 && !str.equals("PROPFIND") && !str.equals("QUERY")) {
                                z = true;
                            }
                            if (z) {
                                builderNewBuilder.method("GET", null);
                                builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.TransferEncoding);
                                builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.ContentLength);
                                builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.ContentType);
                            } else {
                                builderNewBuilder.method(str, request.body);
                            }
                        }
                        if (!_UtilJvmKt.canReuseConnectionFor(request.url, httpUrlBuild)) {
                            builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.Authorization);
                        }
                        builderNewBuilder.url = httpUrlBuild;
                        return new Request(builderNewBuilder);
                    }
                }
            }
        } else {
            if (i2 == 401) {
                return realInterceptorChain.authenticator.authenticate(route, response);
            }
            if (i2 == 421) {
                RequestBody requestBody2 = request2.body;
                if ((requestBody2 == null || !requestBody2.isOneShot()) && exchange != null && !Intrinsics.areEqual(((ExchangeFinder) exchange.finder).getRoutePlanner().address.url.host, ((ExchangeCodec) exchange.codec).getCarrier().getRoute().address.url.host)) {
                    RealConnection connection$okhttp = exchange.getConnection$okhttp();
                    synchronized (connection$okhttp) {
                        connection$okhttp.noCoalescedConnections = true;
                    }
                    return response.request;
                }
            } else if (i2 == 503) {
                Response response3 = response.priorResponse;
                if ((response3 == null || response3.code != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request;
                }
            } else {
                if (i2 == 407) {
                    route.getClass();
                    if (route.proxy.type() == Proxy.Type.HTTP) {
                        return realInterceptorChain.proxyAuthenticator.authenticate(route, response);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (i2 != 408) {
                    switch (i2) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            if (realInterceptorChain.call.client.followRedirects) {
                                strHeader$default = Response.header$default(io.ktor.http.HttpHeaders.Location, response);
                                request = response.request;
                                if (strHeader$default != null) {
                                    HttpUrl httpUrl2 = request.url;
                                    httpUrl2.getClass();
                                    builder = new HttpUrl.Builder();
                                    builder.parse$okhttp(httpUrl2, strHeader$default);
                                    if (builder != null) {
                                        httpUrlBuild = builder.build();
                                    } else {
                                        httpUrlBuild = null;
                                    }
                                    if (httpUrlBuild != null) {
                                        builderNewBuilder = request.newBuilder();
                                        if (Okio__OkioKt.permitsRequestBody(str)) {
                                            i = response.code;
                                            if (i == 303) {
                                                z = !str.equals("PROPFIND");
                                            } else if (i != 307) {
                                                z = true;
                                            }
                                            if (z) {
                                                builderNewBuilder.method("GET", null);
                                                builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.TransferEncoding);
                                                builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.ContentLength);
                                                builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.ContentType);
                                            } else {
                                                builderNewBuilder.method(str, request.body);
                                            }
                                        }
                                        if (!_UtilJvmKt.canReuseConnectionFor(request.url, httpUrlBuild)) {
                                            builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.Authorization);
                                        }
                                        builderNewBuilder.url = httpUrlBuild;
                                        return new Request(builderNewBuilder);
                                    }
                                }
                            }
                        default:
                            return null;
                    }
                } else if (realInterceptorChain.retryOnConnectionFailure && (((requestBody = request2.body) == null || !requestBody.isOneShot()) && (((response2 = response.priorResponse) == null || response2.code != 408) && retryAfter(response, 0) <= 0))) {
                    return response.request;
                }
            }
        }
        return null;
    }

    public static boolean recover(IOException iOException, RealCall realCall, RealInterceptorChain realInterceptorChain, Request request) {
        RequestBody requestBody;
        boolean z = iOException instanceof ConnectionShutdownException;
        if (!realInterceptorChain.retryOnConnectionFailure) {
            return false;
        }
        if ((!z && (((requestBody = request.body) != null && requestBody.isOneShot()) || (iOException instanceof FileNotFoundException))) || (iOException instanceof ProtocolException)) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || !z) {
                return false;
            }
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        Exchange exchange = realCall.exchange;
        if (exchange == null || !exchange.hasFailure) {
            return false;
        }
        ExchangeFinder exchangeFinder = realCall.exchangeFinder;
        exchangeFinder.getClass();
        RealRoutePlanner routePlanner = exchangeFinder.getRoutePlanner();
        Exchange exchange2 = realCall.exchange;
        return routePlanner.hasNext(exchange2 != null ? exchange2.getConnection$okhttp() : null);
    }

    public static int retryAfter(Response response, int i) {
        String strHeader$default = Response.header$default(io.ktor.http.HttpHeaders.RetryAfter, response);
        if (strHeader$default == null) {
            return i;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        patternCompile.getClass();
        if (!patternCompile.matcher(strHeader$default).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strHeader$default);
        numValueOf.getClass();
        return numValueOf.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:165:0x0310  */
    /* JADX WARN: Code duplicated, block: B:229:0x0460 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v1, types: [okhttp3.internal.connection.RealCall] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [okhttp3.internal.connection.RealCall] */
    /* JADX WARN: Type inference failed for: r3v18, types: [okhttp3.internal.connection.RealCall] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [okhttp3.Response] */
    /* JADX WARN: Type inference failed for: r3v23, types: [okhttp3.internal.connection.RealCall] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v35, types: [okhttp3.internal.http.ExchangeCodec] */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58, types: [okhttp3.internal.connection.RealCall] */
    /* JADX WARN: Type inference failed for: r5v61 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v67 */
    /* JADX WARN: Type inference failed for: r5v68 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws Throwable {
        boolean z;
        boolean z2;
        Response.Builder responseHeaders;
        ?? r22;
        IOException iOException;
        ?? r23;
        Response responseBuild;
        int i;
        Response responseBuild2;
        ?? IsDuplex;
        boolean z3;
        ?? r3;
        ?? r4;
        List list;
        boolean z4;
        ?? r5;
        boolean z5;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        switch (this.$r8$classId) {
            case 0:
                boolean z6 = true;
                Protocol.Companion companion = realInterceptorChain.cookieJar;
                Request request = realInterceptorChain.request;
                Request.Builder builderNewBuilder = request.newBuilder();
                HttpUrl httpUrl = request.url;
                Headers headers = request.headers;
                RequestBody requestBody = request.body;
                if (requestBody != null) {
                    MediaType mediaTypeContentType = requestBody.contentType();
                    if (mediaTypeContentType != null) {
                        builderNewBuilder.header(io.ktor.http.HttpHeaders.ContentType, mediaTypeContentType.mediaType);
                    }
                    long jContentLength = requestBody.contentLength();
                    if (jContentLength != -1) {
                        builderNewBuilder.header(io.ktor.http.HttpHeaders.ContentLength, String.valueOf(jContentLength));
                        builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.TransferEncoding);
                    } else {
                        builderNewBuilder.header(io.ktor.http.HttpHeaders.TransferEncoding, "chunked");
                        builderNewBuilder.headers.removeAll(io.ktor.http.HttpHeaders.ContentLength);
                    }
                }
                if (headers.get(io.ktor.http.HttpHeaders.Host) == null) {
                    z = false;
                    builderNewBuilder.header(io.ktor.http.HttpHeaders.Host, _UtilJvmKt.toHostHeader(httpUrl, false));
                } else {
                    z = false;
                }
                if (headers.get(io.ktor.http.HttpHeaders.Connection) == null) {
                    builderNewBuilder.header(io.ktor.http.HttpHeaders.Connection, "Keep-Alive");
                }
                if (headers.get(io.ktor.http.HttpHeaders.AcceptEncoding) == null && headers.get(io.ktor.http.HttpHeaders.Range) == null) {
                    builderNewBuilder.header(io.ktor.http.HttpHeaders.AcceptEncoding, "gzip");
                } else {
                    z6 = z;
                }
                companion.getClass();
                httpUrl.getClass();
                if (headers.get(io.ktor.http.HttpHeaders.UserAgent) == null) {
                    builderNewBuilder.header(io.ktor.http.HttpHeaders.UserAgent, "okhttp/5.5.0");
                }
                Request request2 = new Request(builderNewBuilder);
                Response responseProceed = realInterceptorChain.proceed(request2);
                Headers headers2 = responseProceed.headers;
                HttpHeaders.receiveHeaders(companion, request2.url, headers2);
                Response.Builder builderNewBuilder2 = responseProceed.newBuilder();
                builderNewBuilder2.request = request2;
                if (z6 && "gzip".equalsIgnoreCase(Response.header$default(io.ktor.http.HttpHeaders.ContentEncoding, responseProceed)) && HttpHeaders.promisesBody(responseProceed)) {
                    GzipSource gzipSource = new GzipSource(responseProceed.body.source());
                    Headers.Builder builderCommonNewBuilder = EntryPoints.commonNewBuilder(headers2);
                    builderCommonNewBuilder.removeAll(io.ktor.http.HttpHeaders.ContentEncoding);
                    builderCommonNewBuilder.removeAll(io.ktor.http.HttpHeaders.ContentLength);
                    builderNewBuilder2.headers = EntryPoints.commonNewBuilder(EntryPoints.commonBuild(builderCommonNewBuilder));
                    builderNewBuilder2.body = new RealResponseBody(Response.header$default(io.ktor.http.HttpHeaders.ContentType, responseProceed), -1L, new RealBufferedSource(gzipSource));
                }
                return builderNewBuilder2.build();
            case 1:
                Exchange exchange = realInterceptorChain.exchange;
                exchange.getClass();
                Request request3 = realInterceptorChain.request;
                RequestBody requestBody2 = request3.body;
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z7 = Okio__OkioKt.permitsRequestBody(request3.method) && requestBody2 != null;
                boolean zEqualsIgnoreCase = "upgrade".equalsIgnoreCase(request3.headers.get(io.ktor.http.HttpHeaders.Connection));
                try {
                    try {
                        ((RealCall) exchange.call).eventListener.getClass();
                        ((ExchangeCodec) exchange.codec).writeRequestHeaders(request3);
                        ((RealCall) exchange.call).eventListener.getClass();
                        if (z7) {
                            try {
                                boolean zEqualsIgnoreCase2 = "100-continue".equalsIgnoreCase(request3.headers.get(io.ktor.http.HttpHeaders.Expect));
                                try {
                                    if (zEqualsIgnoreCase2) {
                                        try {
                                            ((ExchangeCodec) exchange.codec).flushRequest();
                                            Response.Builder responseHeaders2 = exchange.readResponseHeaders(true);
                                            try {
                                                EventListener eventListener = ((RealCall) exchange.call).eventListener;
                                                eventListener.getClass();
                                                responseHeaders = responseHeaders2;
                                                z2 = false;
                                                IsDuplex = eventListener;
                                            } catch (IOException e) {
                                                e = e;
                                                responseHeaders = responseHeaders2;
                                                z2 = true;
                                                r22 = 1;
                                                if (e instanceof ConnectionShutdownException) {
                                                    throw e;
                                                }
                                                throw e;
                                            }
                                        } catch (IOException e2) {
                                            ((RealCall) exchange.call).eventListener.getClass();
                                            exchange.trackFailure(e2);
                                            throw e2;
                                        }
                                    } else {
                                        responseHeaders = null;
                                        z2 = true;
                                        IsDuplex = zEqualsIgnoreCase2;
                                    }
                                    try {
                                        if (responseHeaders == null) {
                                            try {
                                                IsDuplex = requestBody2.getDuplex();
                                                if (IsDuplex != 0) {
                                                    try {
                                                        IsDuplex = (ExchangeCodec) exchange.codec;
                                                        IsDuplex.flushRequest();
                                                        z3 = true;
                                                        requestBody2.writeTo(new RealBufferedSink(exchange.createRequestBody(request3, true)));
                                                    } catch (IOException e3) {
                                                        ((RealCall) exchange.call).eventListener.getClass();
                                                        exchange.trackFailure(e3);
                                                        throw e3;
                                                    }
                                                } else {
                                                    z3 = true;
                                                    RealBufferedSink realBufferedSink = new RealBufferedSink(exchange.createRequestBody(request3, false));
                                                    requestBody2.writeTo(realBufferedSink);
                                                    realBufferedSink.close();
                                                }
                                                r22 = z3;
                                            } catch (IOException e4) {
                                                e = e4;
                                                IsDuplex = 1;
                                                r22 = IsDuplex;
                                                if ((e instanceof ConnectionShutdownException) || !exchange.hasFailure) {
                                                    throw e;
                                                }
                                                iOException = e;
                                            }
                                        } else {
                                            r22 = 1;
                                            try {
                                                ((RealCall) exchange.call).messageDone$okhttp(exchange, true, false, false, false, null);
                                                if (!(exchange.getConnection$okhttp().http2Connection != null)) {
                                                    ((ExchangeCodec) exchange.codec).getCarrier().noNewExchanges();
                                                }
                                            } catch (IOException e5) {
                                                e = e5;
                                                if (e instanceof ConnectionShutdownException) {
                                                    throw e;
                                                }
                                                throw e;
                                            }
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                        r22 = IsDuplex;
                                        if (e instanceof ConnectionShutdownException) {
                                            throw e;
                                        }
                                        throw e;
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    responseHeaders = null;
                                }
                            } catch (IOException e8) {
                                e = e8;
                                r22 = 1;
                                z2 = true;
                                responseHeaders = null;
                                if (e instanceof ConnectionShutdownException) {
                                    throw e;
                                }
                                throw e;
                            }
                        } else {
                            r22 = 1;
                            ((RealCall) exchange.call).messageDone$okhttp(exchange, true, false, false, false, null);
                            z2 = true;
                            responseHeaders = null;
                        }
                        if (requestBody2 == null || !requestBody2.getDuplex()) {
                            try {
                                ((ExchangeCodec) exchange.codec).finishRequest();
                            } catch (IOException e9) {
                                ((RealCall) exchange.call).eventListener.getClass();
                                exchange.trackFailure(e9);
                                throw e9;
                            }
                        }
                        iOException = null;
                        r23 = r22;
                        while (true) {
                            if (i != 100 && (102 > i || i >= 200)) {
                            }
                            Response.Builder responseHeaders3 = exchange.readResponseHeaders(false);
                            responseHeaders3.getClass();
                            if (z2) {
                                ((RealCall) exchange.call).eventListener.getClass();
                            }
                            responseHeaders3.request = request3;
                            responseHeaders3.handshake = exchange.getConnection$okhttp().handshake;
                            responseHeaders3.sentRequestAtMillis = jCurrentTimeMillis;
                            responseHeaders3.receivedResponseAtMillis = System.currentTimeMillis();
                            responseBuild = responseHeaders3.build();
                            i = responseBuild.code;
                        }
                        break;
                    } catch (IOException e10) {
                        e = e10;
                    }
                    if (responseHeaders == null) {
                        r23 = r22;
                        try {
                            responseHeaders = exchange.readResponseHeaders(false);
                            responseHeaders.getClass();
                            if (z2) {
                                ((RealCall) exchange.call).eventListener.getClass();
                                z2 = false;
                            }
                        } catch (IOException e11) {
                            if (iOException == null) {
                                throw e11;
                            }
                            ResultKt.addSuppressed(iOException, e11);
                            throw iOException;
                        }
                    }
                    r23 = r22;
                    responseHeaders.request = request3;
                    responseHeaders.handshake = exchange.getConnection$okhttp().handshake;
                    responseHeaders.sentRequestAtMillis = jCurrentTimeMillis;
                    responseHeaders.receivedResponseAtMillis = System.currentTimeMillis();
                    responseBuild = responseHeaders.build();
                    i = responseBuild.code;
                    ((RealCall) exchange.call).eventListener.getClass();
                    ?? r1 = i == 101 ? r23 : 0;
                    if (r1 != 0) {
                        if ((exchange.getConnection$okhttp().http2Connection != null ? r23 : 0) != 0) {
                            throw new ProtocolException("Unexpected 101 code on HTTP/2 connection");
                        }
                    }
                    ?? r21 = (r1 == 0 || !"upgrade".equalsIgnoreCase(Response.header$default(io.ktor.http.HttpHeaders.Connection, responseBuild))) ? 0 : r23;
                    if (!zEqualsIgnoreCase || r21 == 0) {
                        RealResponseBody realResponseBodyOpenResponseBody = exchange.openResponseBody(responseBuild);
                        Response.Builder builderNewBuilder3 = responseBuild.newBuilder();
                        builderNewBuilder3.body = realResponseBodyOpenResponseBody;
                        builderNewBuilder3.trailersSource = new CallServerInterceptor$intercept$1();
                        responseBuild2 = builderNewBuilder3.build();
                    } else {
                        Response.Builder builderNewBuilder4 = responseBuild.newBuilder();
                        builderNewBuilder4.body = new UnreadableResponseBody(responseBuild.body.contentType(), responseBuild.body.contentLength());
                        builderNewBuilder4.socket = exchange.upgradeToSocket();
                        responseBuild2 = builderNewBuilder4.build();
                    }
                    Request request4 = responseBuild2.request;
                    request4.getClass();
                    if ("close".equalsIgnoreCase(request4.headers.get(io.ktor.http.HttpHeaders.Connection)) || "close".equalsIgnoreCase(Response.header$default(io.ktor.http.HttpHeaders.Connection, responseBuild2))) {
                        ((ExchangeCodec) exchange.codec).getCarrier().noNewExchanges();
                    }
                    if ((i != 204 && i != 205) || responseBuild2.body.contentLength() <= 0) {
                        return responseBuild2;
                    }
                    throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + responseBuild2.body.contentLength());
                } catch (IOException e12) {
                    ((RealCall) exchange.call).eventListener.getClass();
                    exchange.trackFailure(e12);
                    throw e12;
                }
            default:
                Request request5 = realInterceptorChain.request;
                RealCall realCall = realInterceptorChain.call;
                List listPlus = EmptyList.INSTANCE;
                Response response = null;
                int i2 = 0;
                Request requestFollowUpRequest = request5;
                ?? r6 = realCall;
                while (true) {
                    boolean z8 = true;
                    ?? r7 = r6;
                    while (true) {
                        requestFollowUpRequest.getClass();
                        if (r7.interceptorScopedExchange != null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                            return null;
                        }
                        synchronized (r7) {
                            try {
                                try {
                                    if (r7.responseBodyOpen) {
                                        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                                    }
                                    if (r7.requestBodyOpen || r7.socketSourceOpen || r7.socketSinkOpen) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r3 = r4;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                r3 = r7;
                            }
                            throw th;
                        }
                        if (z8) {
                            OkHttpClient okHttpClient = r7.client;
                            TaskRunner taskRunner = okHttpClient.taskRunner;
                            RealConnectionPool realConnectionPool = (RealConnectionPool) realInterceptorChain.connectionPool.delegate;
                            int i3 = realInterceptorChain.readTimeoutMillis;
                            int i4 = realInterceptorChain.writeTimeoutMillis;
                            List list2 = listPlus;
                            int i5 = realInterceptorChain.connectTimeoutMillis;
                            int i6 = okHttpClient.pingIntervalMillis;
                            boolean z9 = realInterceptorChain.retryOnConnectionFailure;
                            boolean z10 = okHttpClient.fastFallback;
                            HttpUrl httpUrl2 = requestFollowUpRequest.url;
                            httpUrl2.getClass();
                            if (httpUrl2.isHttps()) {
                                SSLSocketFactory sSLSocketFactory2 = realInterceptorChain.sslSocketFactoryOrNull;
                                HostnameVerifier hostnameVerifier2 = realInterceptorChain.hostnameVerifier;
                                certificatePinner = realInterceptorChain.certificatePinner;
                                hostnameVerifier = hostnameVerifier2;
                                sSLSocketFactory = sSLSocketFactory2;
                            } else {
                                sSLSocketFactory = null;
                                hostnameVerifier = null;
                                certificatePinner = null;
                            }
                            String str = httpUrl2.host;
                            int i7 = httpUrl2.port;
                            Dns dns = realInterceptorChain.dns;
                            SocketFactory socketFactory = realInterceptorChain.socketFactory;
                            Authenticator authenticator = realInterceptorChain.proxyAuthenticator;
                            Proxy proxy = realInterceptorChain.proxy;
                            OkHttpClient okHttpClient2 = realInterceptorChain.call.client;
                            Request request6 = requestFollowUpRequest;
                            ?? r17 = r7;
                            list = list2;
                            RealRoutePlanner realRoutePlanner = new RealRoutePlanner(taskRunner, realConnectionPool, i3, i4, i5, i3, i6, z9, z10, new Address(str, i7, dns, socketFactory, sSLSocketFactory, hostnameVerifier, certificatePinner, authenticator, proxy, okHttpClient2.protocols, okHttpClient2.connectionSpecs, realInterceptorChain.proxySelector), r7.client.routeDatabase, r17, request6);
                            ?? r8 = r17;
                            requestFollowUpRequest = request6;
                            OkHttpClient okHttpClient3 = r8.client;
                            r8.exchangeFinder = okHttpClient3.fastFallback ? new FastFallbackExchangeFinder(realRoutePlanner, okHttpClient3.taskRunner) : new ConnectionPool(realRoutePlanner);
                            r4 = r8;
                        } else {
                            r4 = r7;
                            list = listPlus;
                        }
                        try {
                            if (r4.canceled) {
                                throw new IOException("Canceled");
                            }
                            try {
                            } catch (IOException e13) {
                                boolean zRecover = recover(e13, r4, realInterceptorChain, requestFollowUpRequest);
                                r4.eventListener.getClass();
                                if (!zRecover) {
                                    byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        ResultKt.addSuppressed(e13, (Exception) it.next());
                                    }
                                    throw e13;
                                }
                                listPlus = CollectionsKt.plus(e13, list);
                                r4.exitNetworkInterceptorExchange$okhttp(true);
                                r7 = r4;
                                z8 = false;
                            }
                            break;
                        } catch (Throwable th3) {
                            th = th3;
                            z4 = true;
                            r5 = r4;
                        }
                        r5.exitNetworkInterceptorExchange$okhttp(z4);
                        throw th;
                    }
                    Response.Builder builderNewBuilder5 = realInterceptorChain.proceed(requestFollowUpRequest).newBuilder();
                    builderNewBuilder5.request = requestFollowUpRequest;
                    builderNewBuilder5.priorResponse = response != null ? UuidKt.stripBody(response) : null;
                    Response responseBuild3 = builderNewBuilder5.build();
                    Exchange exchange2 = r4.interceptorScopedExchange;
                    requestFollowUpRequest = followUpRequest(responseBuild3, exchange2, realInterceptorChain);
                    try {
                        if (requestFollowUpRequest == null) {
                            if (exchange2 != null && exchange2.isDuplex) {
                                if (r4.timeoutEarlyExit) {
                                    throw new IllegalStateException("Check failed.");
                                }
                                r4.timeoutEarlyExit = true;
                                r4.timeout.exit();
                            }
                            r4.eventListener.getClass();
                            z5 = false;
                        } else {
                            RequestBody requestBody3 = requestFollowUpRequest.body;
                            if (requestBody3 == null || !requestBody3.isOneShot()) {
                                _UtilCommonKt.closeQuietly(responseBuild3.body);
                                int i8 = i2 + 1;
                                EventListener eventListener2 = r4.eventListener;
                                if (i8 > 20) {
                                    eventListener2.getClass();
                                    throw new ProtocolException("Too many follow-up requests: " + i8);
                                }
                                eventListener2.getClass();
                                r4.exitNetworkInterceptorExchange$okhttp(true);
                                response = responseBuild3;
                                listPlus = list;
                                r6 = r4;
                                i2 = i8;
                            } else {
                                r4.eventListener.getClass();
                                z5 = false;
                            }
                        }
                        r4.exitNetworkInterceptorExchange$okhttp(z5);
                        r4 = responseBuild3;
                        return r4;
                    } catch (Throwable th4) {
                        th = th4;
                        z4 = false;
                        r5 = r4;
                    }
                }
                break;
        }
    }
}
