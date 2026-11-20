package okhttp3;

import dagger.hilt.EntryPoints;
import java.io.Closeable;
import kotlin.text.HexFormatKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.Exchange;
import okio.Socket;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Response implements Closeable {
    public final ResponseBody body;
    public final Response cacheResponse;
    public final int code;
    public final Exchange exchange;
    public final Handshake handshake;
    public final Headers headers;
    public final boolean isSuccessful;
    public CacheControl lazyCacheControl;
    public final String message;
    public final Response networkResponse;
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sentRequestAtMillis;
    public final Socket socket;
    public final TrailersSource trailersSource;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public Response cacheResponse;
        public Exchange exchange;
        public Handshake handshake;
        public String message;
        public Response networkResponse;
        public Response priorResponse;
        public Protocol protocol;
        public long receivedResponseAtMillis;
        public Request request;
        public long sentRequestAtMillis;
        public Socket socket;
        public int code = -1;
        public ResponseBody body = ResponseBody.EMPTY;
        public TrailersSource trailersSource = TrailersSource.EMPTY;
        public Headers.Builder headers = new Headers.Builder((byte) 0);

        public static void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (response.networkResponse != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) str.concat(".networkResponse != null"));
                } else if (response.cacheResponse != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) str.concat(".cacheResponse != null"));
                } else {
                    if (response.priorResponse == null) {
                        return;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) str.concat(".priorResponse != null"));
                }
            }
        }

        public final Response build() {
            int i = this.code;
            if (i < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(this.code, "code < 0: ");
                return null;
            }
            Request request = this.request;
            if (request == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("request == null");
                return null;
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("protocol == null");
                return null;
            }
            String str = this.message;
            if (str == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("message == null");
                return null;
            }
            Handshake handshake = this.handshake;
            Headers.Builder builder = this.headers;
            builder.getClass();
            return new Response(request, protocol, str, i, handshake, EntryPoints.commonBuild(builder), this.body, this.socket, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange, this.trailersSource);
        }
    }

    public Response(Request request, Protocol protocol, String str, int i, Handshake handshake, Headers headers, ResponseBody responseBody, Socket socket, Response response, Response response2, Response response3, long j, long j2, Exchange exchange, TrailersSource trailersSource) {
        request.getClass();
        protocol.getClass();
        str.getClass();
        responseBody.getClass();
        trailersSource.getClass();
        this.request = request;
        this.protocol = protocol;
        this.message = str;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.socket = socket;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
        this.trailersSource = trailersSource;
        boolean z = false;
        if (200 <= i && i < 300) {
            z = true;
        }
        this.isSuccessful = z;
    }

    public static String header$default(String str, Response response) {
        response.getClass();
        String str2 = response.headers.get(str);
        if (str2 == null) {
            return null;
        }
        return str2;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        int i = CacheControl.$r8$clinit;
        CacheControl cacheControl2 = HexFormatKt.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.body.close();
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.code = -1;
        builder.body = ResponseBody.EMPTY;
        builder.trailersSource = TrailersSource.EMPTY;
        builder.request = this.request;
        builder.protocol = this.protocol;
        builder.code = this.code;
        builder.message = this.message;
        builder.handshake = this.handshake;
        builder.headers = EntryPoints.commonNewBuilder(this.headers);
        builder.body = this.body;
        builder.socket = this.socket;
        builder.networkResponse = this.networkResponse;
        builder.cacheResponse = this.cacheResponse;
        builder.priorResponse = this.priorResponse;
        builder.sentRequestAtMillis = this.sentRequestAtMillis;
        builder.receivedResponseAtMillis = this.receivedResponseAtMillis;
        builder.exchange = this.exchange;
        builder.trailersSource = this.trailersSource;
        return builder;
    }

    public final String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url + '}';
    }
}
