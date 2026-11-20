package okhttp3.internal.http1;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavDeepLinkRequest;
import dagger.hilt.EntryPoints;
import io.ktor.sse.ServerSentEventKt;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.DeflaterSink;
import okio.ForwardingTimeout;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Socket;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Headers TRAILERS_RESPONSE_BODY_TRUNCATED;
    public final ExchangeCodec.Carrier carrier;
    public final OkHttpClient client;
    public final HeadersReader headersReader;
    public final NavDeepLinkRequest socket;
    public byte state;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class AbstractSource implements Source {
        public boolean closed;
        public final /* synthetic */ Http1ExchangeCodec this$0;
        public final ForwardingTimeout timeout;
        public final HttpUrl url;

        public AbstractSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            httpUrl.getClass();
            this.this$0 = http1ExchangeCodec;
            this.url = httpUrl;
            this.timeout = new ForwardingTimeout(((RealBufferedSource) http1ExchangeCodec.socket.action).source.timeout());
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            Http1ExchangeCodec http1ExchangeCodec = this.this$0;
            buffer.getClass();
            try {
                return ((RealBufferedSource) http1ExchangeCodec.socket.action).read(buffer, j);
            } catch (IOException e) {
                http1ExchangeCodec.carrier.noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw e;
            }
        }

        public final void responseBodyComplete(Headers headers) {
            OkHttpClient okHttpClient;
            Protocol.Companion companion;
            headers.getClass();
            Http1ExchangeCodec http1ExchangeCodec = this.this$0;
            byte b = http1ExchangeCodec.state;
            if (b == 6) {
                return;
            }
            if (b != 5) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(http1ExchangeCodec.state, "state: ");
                return;
            }
            ForwardingTimeout forwardingTimeout = this.timeout;
            Timeout timeout = forwardingTimeout.delegate;
            forwardingTimeout.delegate = Timeout.NONE;
            timeout.clearDeadline();
            timeout.clearTimeout();
            http1ExchangeCodec.state = (byte) 6;
            if (headers.size() <= 0 || (okHttpClient = http1ExchangeCodec.client) == null || (companion = okHttpClient.cookieJar) == null) {
                return;
            }
            HttpHeaders.receiveHeaders(companion, this.url, headers);
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.timeout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ChunkedSink implements Sink {
        public boolean closed;
        public final ForwardingTimeout timeout;

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(((RealBufferedSink) Http1ExchangeCodec.this.socket.mimeType).sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ((RealBufferedSink) Http1ExchangeCodec.this.socket.mimeType).writeUtf8("0\r\n\r\n");
            ((RealBufferedSink) Http1ExchangeCodec.this.socket.mimeType).flush();
            ForwardingTimeout forwardingTimeout = this.timeout;
            Timeout timeout = forwardingTimeout.delegate;
            forwardingTimeout.delegate = Timeout.NONE;
            timeout.clearDeadline();
            timeout.clearTimeout();
            Http1ExchangeCodec.this.state = (byte) 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public final synchronized void flush() {
            if (this.closed) {
                return;
            }
            ((RealBufferedSink) Http1ExchangeCodec.this.socket.mimeType).flush();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) {
            buffer.getClass();
            if (this.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                return;
            }
            if (j == 0) {
                return;
            }
            RealBufferedSink realBufferedSink = (RealBufferedSink) Http1ExchangeCodec.this.socket.mimeType;
            if (realBufferedSink.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                return;
            }
            realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j);
            realBufferedSink.emitCompleteSegments();
            realBufferedSink.writeUtf8(ServerSentEventKt.END_OF_LINE);
            realBufferedSink.write(buffer, j);
            realBufferedSink.writeUtf8(ServerSentEventKt.END_OF_LINE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ChunkedSource extends AbstractSource {
        public long bytesRemainingInChunk;
        public boolean hasMoreChunks;
        public final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            super(http1ExchangeCodec, httpUrl);
            httpUrl.getClass();
            this.this$0 = http1ExchangeCodec;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean zSkipAll;
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks) {
                TimeZone timeZone = _UtilJvmKt.UTC;
                TimeUnit.MILLISECONDS.getClass();
                try {
                    zSkipAll = _UtilJvmKt.skipAll(this, 100);
                } catch (IOException unused) {
                    zSkipAll = false;
                }
                if (!zSkipAll) {
                    this.this$0.carrier.noNewExchanges();
                    responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                }
            }
            this.closed = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:51:0x00ed, code lost:
        
            if (r18.hasMoreChunks == false) goto L52;
         */
        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final long read(Buffer buffer, long j) throws IOException {
            long j2;
            Http1ExchangeCodec http1ExchangeCodec = this.this$0;
            NavDeepLinkRequest navDeepLinkRequest = http1ExchangeCodec.socket;
            buffer.getClass();
            long j3 = 0;
            if (j < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
                return 0L;
            }
            if (this.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                return 0L;
            }
            if (this.hasMoreChunks) {
                long j4 = this.bytesRemainingInChunk;
                if (j4 == 0 || j4 == -1) {
                    if (j4 != -1) {
                        ((RealBufferedSource) navDeepLinkRequest.action).readUtf8LineStrict(Long.MAX_VALUE);
                    }
                    try {
                        RealBufferedSource realBufferedSource = (RealBufferedSource) navDeepLinkRequest.action;
                        Buffer buffer2 = realBufferedSource.bufferField;
                        realBufferedSource.require(1L);
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            j2 = j3;
                            if (!realBufferedSource.request(i2)) {
                                break;
                            }
                            byte b = buffer2.getByte(i);
                            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                                i = i2;
                                j3 = j2;
                            }
                            if (i != 0) {
                                break;
                            }
                            CharsKt.checkRadix(16);
                            String string = Integer.toString(b, 16);
                            string.getClass();
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
                        }
                        this.bytesRemainingInChunk = buffer2.readHexadecimalUnsignedLong();
                        String string2 = StringsKt.trim(((RealBufferedSource) navDeepLinkRequest.action).readUtf8LineStrict(Long.MAX_VALUE)).toString();
                        if (this.bytesRemainingInChunk < j2 || (string2.length() > 0 && !StringsKt__StringsJVMKt.startsWith(string2, ";", false))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string2 + '\"');
                        }
                        if (this.bytesRemainingInChunk == j2) {
                            this.hasMoreChunks = false;
                            HeadersReader headersReader = http1ExchangeCodec.headersReader;
                            Headers.Builder builder = new Headers.Builder((byte) 0);
                            while (true) {
                                String utf8LineStrict = ((RealBufferedSource) headersReader.source).readUtf8LineStrict(headersReader.headerLimit);
                                headersReader.headerLimit -= (long) utf8LineStrict.length();
                                if (utf8LineStrict.length() == 0) {
                                    break;
                                }
                                builder.addLenient$okhttp(utf8LineStrict);
                            }
                            responseBodyComplete(EntryPoints.commonBuild(builder));
                        }
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long j5 = super.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                if (j5 != -1) {
                    this.bytesRemainingInChunk -= j5;
                    return j5;
                }
                http1ExchangeCodec.carrier.noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw protocolException;
            }
            return -1L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FixedLengthSource extends AbstractSource {
        public long bytesRemaining;
        public final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl, long j) {
            super(http1ExchangeCodec, httpUrl);
            httpUrl.getClass();
            this.this$0 = http1ExchangeCodec;
            this.bytesRemaining = j;
            if (j == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean zSkipAll;
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0) {
                TimeZone timeZone = _UtilJvmKt.UTC;
                TimeUnit.MILLISECONDS.getClass();
                try {
                    zSkipAll = _UtilJvmKt.skipAll(this, 100);
                } catch (IOException unused) {
                    zSkipAll = false;
                }
                if (!zSkipAll) {
                    this.this$0.carrier.noNewExchanges();
                    responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                }
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public final long read(Buffer buffer, long j) throws IOException {
            buffer.getClass();
            if (j < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
                return 0L;
            }
            if (this.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                return 0L;
            }
            long j2 = this.bytesRemaining;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = super.read(buffer, Math.min(j2, j));
            if (j3 == -1) {
                this.this$0.carrier.noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw protocolException;
            }
            long j4 = this.bytesRemaining - j3;
            this.bytesRemaining = j4;
            if (j4 == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
            return j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UnknownLengthSource extends AbstractSource {
        public boolean inputExhausted;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public final long read(Buffer buffer, long j) throws IOException {
            buffer.getClass();
            if (j < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
                return 0L;
            }
            if (this.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                return 0L;
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long j2 = super.read(buffer, j);
            if (j2 != -1) {
                return j2;
            }
            this.inputExhausted = true;
            responseBodyComplete(Headers.EMPTY);
            return -1L;
        }
    }

    static {
        Headers headers = Headers.EMPTY;
        String[] strArr = (String[]) Arrays.copyOf(new String[]{"OkHttp-Response-Body", "Truncated"}, 2);
        if (strArr.length % 2 != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Expected alternating header names and values");
            return;
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        int length = strArr2.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (strArr2[i2] == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Headers cannot be null");
                return;
            }
            strArr2[i2] = StringsKt.trim(strArr[i2]).toString();
        }
        int progressionLastElement = UuidKt.getProgressionLastElement(0, strArr2.length - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                String str = strArr2[i];
                String str2 = strArr2[i + 1];
                EntryPoints.headersCheckName(str);
                EntryPoints.headersCheckValue(str2, str);
                if (i == progressionLastElement) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        TRAILERS_RESPONSE_BODY_TRUNCATED = new Headers(strArr2);
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, ExchangeCodec.Carrier carrier, NavDeepLinkRequest navDeepLinkRequest) {
        navDeepLinkRequest.getClass();
        this.client = okHttpClient;
        this.carrier = carrier;
        this.socket = navDeepLinkRequest;
        RealBufferedSource realBufferedSource = (RealBufferedSource) navDeepLinkRequest.action;
        HeadersReader headersReader = new HeadersReader();
        headersReader.source = realBufferedSource;
        headersReader.headerLimit = 262144L;
        this.headersReader = headersReader;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        this.carrier.cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Sink createRequestBody(Request request, long j) throws ProtocolException {
        request.getClass();
        RequestBody requestBody = request.body;
        if (requestBody != null && requestBody.getDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(request.headers.get(io.ktor.http.HttpHeaders.TransferEncoding))) {
            if (this.state == 1) {
                this.state = (byte) 2;
                return new ChunkedSink();
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.state, "state: ");
            return null;
        }
        if (j == -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot stream a request body without chunked encoding or a known content length!");
            return null;
        }
        if (this.state == 1) {
            this.state = (byte) 2;
            return new DeflaterSink(this);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.state, "state: ");
        return null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void finishRequest() {
        ((RealBufferedSink) this.socket.mimeType).flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void flushRequest() {
        ((RealBufferedSink) this.socket.mimeType).flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Socket getSocket() {
        return this.socket;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final boolean isResponseComplete() {
        return this.state == 6;
    }

    public final FixedLengthSource newFixedLengthSource(HttpUrl httpUrl, long j) {
        if (this.state == 4) {
            this.state = (byte) 5;
            return new FixedLengthSource(this, httpUrl, j);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.state, "state: ");
        return null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source openResponseBodySource(Response response) {
        Request request = response.request;
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(request.url, 0L);
        }
        if ("chunked".equalsIgnoreCase(Response.header$default(io.ktor.http.HttpHeaders.TransferEncoding, response))) {
            HttpUrl httpUrl = request.url;
            if (this.state == 4) {
                this.state = (byte) 5;
                return new ChunkedSource(this, httpUrl);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.state, "state: ");
            return null;
        }
        long jHeadersContentLength = _UtilJvmKt.headersContentLength(response);
        if (jHeadersContentLength != -1) {
            return newFixedLengthSource(request.url, jHeadersContentLength);
        }
        HttpUrl httpUrl2 = request.url;
        if (this.state != 4) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.state, "state: ");
            return null;
        }
        this.state = (byte) 5;
        this.carrier.noNewExchanges();
        httpUrl2.getClass();
        return new UnknownLengthSource(this, httpUrl2);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        HeadersReader headersReader = this.headersReader;
        RealBufferedSource realBufferedSource = (RealBufferedSource) headersReader.source;
        byte b = this.state;
        if (b != 0 && b != 1 && b != 2 && b != 3) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.state, "state: ");
            return null;
        }
        try {
            String utf8LineStrict = realBufferedSource.readUtf8LineStrict(headersReader.headerLimit);
            headersReader.headerLimit -= (long) utf8LineStrict.length();
            StatusLine statusLineM1870parse = CollectionsKt__IterablesKt.m1870parse(utf8LineStrict);
            int i = statusLineM1870parse.code;
            Response.Builder builder = new Response.Builder();
            builder.protocol = (Protocol) statusLineM1870parse.protocol;
            builder.code = i;
            builder.message = (String) statusLineM1870parse.message;
            Headers.Builder builder2 = new Headers.Builder((byte) 0);
            while (true) {
                String utf8LineStrict2 = realBufferedSource.readUtf8LineStrict(headersReader.headerLimit);
                headersReader.headerLimit -= (long) utf8LineStrict2.length();
                if (utf8LineStrict2.length() == 0) {
                    break;
                }
                builder2.addLenient$okhttp(utf8LineStrict2);
            }
            builder.headers = EntryPoints.commonNewBuilder(EntryPoints.commonBuild(builder2));
            if (z && i == 100) {
                return null;
            }
            if (i == 100) {
                this.state = (byte) 3;
                return builder;
            }
            if (102 > i || i >= 200) {
                this.state = (byte) 4;
                return builder;
            }
            this.state = (byte) 3;
            return builder;
        } catch (EOFException e) {
            throw new IOException("unexpected end of stream on ".concat(this.carrier.getRoute().address.url.redact()), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long reportedContentLength(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(Response.header$default(io.ktor.http.HttpHeaders.TransferEncoding, response))) {
            return -1L;
        }
        return _UtilJvmKt.headersContentLength(response);
    }

    public final void writeRequest(Headers headers, String str) {
        if (this.state != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.state, "state: ");
            return;
        }
        NavDeepLinkRequest navDeepLinkRequest = this.socket;
        RealBufferedSink realBufferedSink = (RealBufferedSink) navDeepLinkRequest.mimeType;
        realBufferedSink.writeUtf8(str);
        realBufferedSink.writeUtf8(ServerSentEventKt.END_OF_LINE);
        int size = headers.size();
        int i = 0;
        while (true) {
            RealBufferedSink realBufferedSink2 = (RealBufferedSink) navDeepLinkRequest.mimeType;
            if (i >= size) {
                realBufferedSink2.writeUtf8(ServerSentEventKt.END_OF_LINE);
                this.state = (byte) 1;
                return;
            } else {
                realBufferedSink2.writeUtf8(EntryPoints.commonName(headers, i));
                realBufferedSink2.writeUtf8(": ");
                realBufferedSink2.writeUtf8(EntryPoints.commonValue(headers, i));
                realBufferedSink2.writeUtf8(ServerSentEventKt.END_OF_LINE);
                i++;
            }
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void writeRequestHeaders(Request request) {
        request.getClass();
        Proxy.Type type = this.carrier.getRoute().proxy.type();
        type.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(request.method);
        sb.append(' ');
        HttpUrl httpUrl = request.url;
        if (httpUrl.isHttps() || type != Proxy.Type.HTTP) {
            String strEncodedPath = httpUrl.encodedPath();
            String strEncodedQuery = httpUrl.encodedQuery();
            if (strEncodedQuery != null) {
                strEncodedPath = strEncodedPath + '?' + strEncodedQuery;
            }
            sb.append(strEncodedPath);
        } else {
            sb.append(httpUrl);
        }
        sb.append(" HTTP/1.1");
        writeRequest(request.headers, sb.toString());
    }
}
