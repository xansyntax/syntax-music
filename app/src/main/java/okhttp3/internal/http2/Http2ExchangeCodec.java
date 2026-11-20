package okhttp3.internal.http2;

import dagger.hilt.EntryPoints;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.StatusLine;
import okio.ByteString;
import okio.Sink;
import okio.Socket;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    public static final List HTTP_2_SKIPPED_REQUEST_HEADERS = _UtilJvmKt.toImmutableList(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});
    public static final List HTTP_2_SKIPPED_RESPONSE_HEADERS = _UtilJvmKt.toImmutableList(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    public volatile boolean canceled;
    public final RealConnection carrier;
    public final RealInterceptorChain chain;
    public final Http2Connection http2Connection;
    public final Protocol protocol;
    public volatile Http2Stream stream;

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        okHttpClient.getClass();
        http2Connection.getClass();
        this.carrier = realConnection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection;
        List list = okHttpClient.protocols;
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = list.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Sink createRequestBody(Request request, long j) {
        request.getClass();
        Http2Stream http2Stream = this.stream;
        http2Stream.getClass();
        return http2Stream.sink;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void finishRequest() throws SocketTimeoutException {
        Http2Stream http2Stream = this.stream;
        http2Stream.getClass();
        http2Stream.sink.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void flushRequest() {
        this.http2Connection.writer.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Socket getSocket() {
        Http2Stream http2Stream = this.stream;
        http2Stream.getClass();
        return http2Stream;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final boolean isResponseComplete() {
        boolean z;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            synchronized (http2Stream) {
                Http2Stream.FramingSource framingSource = http2Stream.source;
                z = framingSource.finished && framingSource.readBuffer.exhausted();
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source openResponseBodySource(Response response) {
        Http2Stream http2Stream = this.stream;
        http2Stream.getClass();
        return http2Stream.source;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002d  */
    @Override // okhttp3.internal.http.ExchangeCodec
    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        Headers headers;
        boolean z2;
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("stream wasn't created");
            return null;
        }
        synchronized (http2Stream) {
            while (true) {
                if (!http2Stream.headersQueue.isEmpty() || http2Stream.getErrorCode$okhttp() != null) {
                    break;
                }
                if (!z) {
                    http2Stream.connection.getClass();
                    Http2Stream.FramingSink framingSink = http2Stream.sink;
                    z2 = framingSink.closed || framingSink.finished;
                }
                if (z2) {
                    http2Stream.readTimeout.enter();
                }
                try {
                    try {
                        http2Stream.wait();
                        if (z2) {
                            http2Stream.readTimeout.exitAndThrowIfTimedOut();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    if (z2) {
                        http2Stream.readTimeout.exitAndThrowIfTimedOut();
                    }
                    throw th;
                }
            }
            if (http2Stream.headersQueue.isEmpty()) {
                IOException iOException = http2Stream.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                errorCode$okhttp.getClass();
                throw new StreamResetException(errorCode$okhttp);
            }
            Object objRemoveFirst = http2Stream.headersQueue.removeFirst();
            objRemoveFirst.getClass();
            headers = (Headers) objRemoveFirst;
        }
        Protocol protocol = this.protocol;
        ArrayList arrayList = new ArrayList(20);
        int size = headers.size();
        StatusLine statusLineM1870parse = null;
        for (int i = 0; i < size; i++) {
            String strCommonName = EntryPoints.commonName(headers, i);
            String strCommonValue = EntryPoints.commonValue(headers, i);
            if (strCommonName.equals(":status")) {
                statusLineM1870parse = CollectionsKt__IterablesKt.m1870parse("HTTP/1.1 ".concat(strCommonValue));
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(strCommonName)) {
                arrayList.add(strCommonName);
                arrayList.add(StringsKt.trim(strCommonValue).toString());
            }
        }
        if (statusLineM1870parse == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response.Builder builder = new Response.Builder();
        builder.protocol = protocol;
        builder.code = statusLineM1870parse.code;
        builder.message = (String) statusLineM1870parse.message;
        builder.headers = EntryPoints.commonNewBuilder(new Headers((String[]) arrayList.toArray(new String[0])));
        if (z && builder.code == 100) {
            return null;
        }
        return builder;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long reportedContentLength(Response response) {
        if (HttpHeaders.promisesBody(response)) {
            return _UtilJvmKt.headersContentLength(response);
        }
        return 0L;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void writeRequestHeaders(Request request) throws IOException {
        int i;
        Http2Stream http2Stream;
        boolean z;
        request.getClass();
        if (this.stream != null) {
            return;
        }
        boolean z2 = request.body != null;
        Headers headers = request.headers;
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(request.method, Header.TARGET_METHOD));
        ByteString byteString = Header.TARGET_PATH;
        HttpUrl httpUrl = request.url;
        httpUrl.getClass();
        String strEncodedPath = httpUrl.encodedPath();
        String strEncodedQuery = httpUrl.encodedQuery();
        if (strEncodedQuery != null) {
            strEncodedPath = strEncodedPath + '?' + strEncodedQuery;
        }
        arrayList.add(new Header(strEncodedPath, byteString));
        String str = headers.get(io.ktor.http.HttpHeaders.Host);
        if (str != null) {
            arrayList.add(new Header(str, Header.TARGET_AUTHORITY));
        }
        arrayList.add(new Header(httpUrl.scheme, Header.TARGET_SCHEME));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strCommonName = EntryPoints.commonName(headers, i2);
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase = strCommonName.toLowerCase(locale);
            lowerCase.getClass();
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (lowerCase.equals("te") && EntryPoints.commonValue(headers, i2).equals("trailers"))) {
                arrayList.add(new Header(lowerCase, EntryPoints.commonValue(headers, i2)));
            }
        }
        Http2Connection http2Connection = this.http2Connection;
        http2Connection.getClass();
        boolean z3 = !z2;
        synchronized (http2Connection.writer) {
            synchronized (http2Connection) {
                try {
                    if (http2Connection.nextStreamId > 1073741823) {
                        http2Connection.shutdown(ErrorCode.REFUSED_STREAM);
                    }
                    if (http2Connection.isShutdown) {
                        throw new ConnectionShutdownException();
                    }
                    i = http2Connection.nextStreamId;
                    http2Connection.nextStreamId = i + 2;
                    http2Stream = new Http2Stream(i, http2Connection, z3, false, null);
                    z = !z2 || http2Connection.writeBytesTotal >= http2Connection.writeBytesMaximum || http2Stream.writeBytesTotal >= http2Stream.writeBytesMaximum;
                    if (http2Stream.isOpen()) {
                        http2Connection.streams.put(Integer.valueOf(i), http2Stream);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            http2Connection.writer.headers(i, arrayList, z3);
        }
        if (z) {
            http2Connection.writer.flush();
        }
        this.stream = http2Stream;
        boolean z4 = this.canceled;
        Http2Stream http2Stream2 = this.stream;
        if (z4) {
            http2Stream2.getClass();
            http2Stream2.closeLater(ErrorCode.CANCEL);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Canceled");
            return;
        }
        http2Stream2.getClass();
        Http2Stream.StreamTimeout streamTimeout = http2Stream2.readTimeout;
        long j = this.chain.readTimeoutMillis;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        streamTimeout.timeout(j, timeUnit);
        Http2Stream http2Stream3 = this.stream;
        http2Stream3.getClass();
        http2Stream3.writeTimeout.timeout(this.chain.writeTimeoutMillis, timeUnit);
    }
}
