package okhttp3.internal.connection;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.WakeLockManager$$ExternalSyntheticLambda0;
import androidx.media3.common.util.WakeLockManager$$ExternalSyntheticLambda2;
import androidx.navigation.NavDeepLinkRequest;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.EventListener;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Exchange {
    public final /* synthetic */ byte $r8$classId;
    public final Object call;
    public final Object codec;
    public final Object finder;
    public boolean hasFailure;
    public boolean isDuplex;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RequestBodySink extends ForwardingSink {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public boolean invokeStartEvent;
        public final boolean isSocket;
        public final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, Sink sink, long j, boolean z) {
            super(sink);
            sink.getClass();
            this.this$0 = exchange;
            this.contentLength = j;
            this.isSocket = z;
            this.invokeStartEvent = z;
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete$1(null);
            } catch (IOException e) {
                IOException iOExceptionComplete$1 = complete$1(e);
                iOExceptionComplete$1.getClass();
                throw iOExceptionComplete$1;
            }
        }

        public final IOException complete$1(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.bodyComplete$default(this.this$0, this.isSocket, iOException, 4);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                IOException iOExceptionComplete$1 = complete$1(e);
                iOExceptionComplete$1.getClass();
                throw iOExceptionComplete$1;
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public final void write(Buffer buffer, long j) throws IOException {
            buffer.getClass();
            if (this.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                return;
            }
            long j2 = this.contentLength;
            if (j2 != -1 && this.bytesReceived + j > j2) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j));
            }
            try {
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    ((RealCall) this.this$0.call).eventListener.getClass();
                }
                this.delegate.write(buffer, j);
                this.bytesReceived += j;
            } catch (IOException e) {
                IOException iOExceptionComplete$1 = complete$1(e);
                iOExceptionComplete$1.getClass();
                throw iOExceptionComplete$1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ResponseBodySource extends ForwardingSource {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public boolean invokeStartEvent;
        public final boolean isSocket;
        public final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, Source source, long j, boolean z) {
            super(source);
            source.getClass();
            this.this$0 = exchange;
            this.contentLength = j;
            this.isSocket = z;
            this.invokeStartEvent = true;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                IOException iOExceptionComplete = complete(e);
                iOExceptionComplete.getClass();
                throw iOExceptionComplete;
            }
        }

        public final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            if (iOException == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                ((RealCall) this.this$0.call).eventListener.getClass();
            }
            return Exchange.bodyComplete$default(this.this$0, this.isSocket, iOException, 8);
        }

        @Override // okio.ForwardingSource, okio.Source
        public final long read(Buffer buffer, long j) throws IOException {
            buffer.getClass();
            if (this.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                return 0L;
            }
            try {
                long j2 = this.delegate.read(buffer, j);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    ((RealCall) this.this$0.call).eventListener.getClass();
                }
                if (j2 == -1) {
                    complete(null);
                    return -1L;
                }
                long j3 = this.bytesReceived + j2;
                long j4 = this.contentLength;
                if (j4 != -1 && j3 > j4) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j3);
                }
                this.bytesReceived = j3;
                if (((ExchangeCodec) this.this$0.codec).isResponseComplete()) {
                    complete(null);
                }
                return j2;
            } catch (IOException e) {
                IOException iOExceptionComplete = complete(e);
                iOExceptionComplete.getClass();
                throw iOExceptionComplete;
            }
        }
    }

    public Exchange(Context context, Looper looper, byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 2:
                this.call = new WeakCache(context.getApplicationContext(), (byte) 17);
                this.finder = new SystemHandlerWrapper(new Handler(looper, null));
                this.codec = new SystemHandlerWrapper(new Handler(Looper.getMainLooper(), null));
                break;
            default:
                this.call = new CallbackWrapper((byte) 16, (Object) context.getApplicationContext());
                this.finder = new SystemHandlerWrapper(new Handler(looper, null));
                this.codec = new SystemHandlerWrapper(new Handler(Looper.getMainLooper(), null));
                break;
        }
    }

    public static IOException bodyComplete$default(Exchange exchange, boolean z, IOException iOException, int i) {
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 8) == 0;
        if (iOException != null) {
            exchange.trackFailure(iOException);
        }
        if (z3) {
            EventListener eventListener = ((RealCall) exchange.call).eventListener;
            if (iOException != null) {
                eventListener.getClass();
            } else {
                eventListener.getClass();
            }
        }
        if (z2) {
            EventListener eventListener2 = ((RealCall) exchange.call).eventListener;
            if (iOException != null) {
                eventListener2.getClass();
            } else {
                eventListener2.getClass();
            }
        }
        return ((RealCall) exchange.call).messageDone$okhttp(exchange, z3 && !z, z2 && !z, z2 && z, z3 && z, iOException);
    }

    public RequestBodySink createRequestBody(Request request, boolean z) {
        request.getClass();
        this.isDuplex = z;
        RequestBody requestBody = request.body;
        requestBody.getClass();
        long jContentLength = requestBody.contentLength();
        ((RealCall) this.call).eventListener.getClass();
        return new RequestBodySink(this, ((ExchangeCodec) this.codec).createRequestBody(request, jContentLength), jContentLength, false);
    }

    public RealConnection getConnection$okhttp() {
        ExchangeCodec.Carrier carrier = ((ExchangeCodec) this.codec).getCarrier();
        RealConnection realConnection = carrier instanceof RealConnection ? (RealConnection) carrier : null;
        if (realConnection != null) {
            return realConnection;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("no connection for CONNECT tunnels");
        return null;
    }

    public RealResponseBody openResponseBody(Response response) throws IOException {
        Exchange exchange;
        try {
            String strHeader$default = Response.header$default(HttpHeaders.ContentType, response);
            long jReportedContentLength = ((ExchangeCodec) this.codec).reportedContentLength(response);
            exchange = this;
            try {
                return new RealResponseBody(strHeader$default, jReportedContentLength, new RealBufferedSource(new ResponseBodySource(exchange, ((ExchangeCodec) this.codec).openResponseBodySource(response), jReportedContentLength, false)));
            } catch (IOException e) {
                e = e;
                IOException iOException = e;
                ((RealCall) exchange.call).eventListener.getClass();
                exchange.trackFailure(iOException);
                throw iOException;
            }
        } catch (IOException e2) {
            e = e2;
            exchange = this;
        }
    }

    public void postUpdateWakeLock(boolean z, boolean z2) {
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) this.finder;
        if (z && z2) {
            systemHandlerWrapper.post(new WakeLockManager$$ExternalSyntheticLambda0(this, z, z2, (byte) 0));
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        SystemHandlerWrapper systemHandlerWrapper2 = (SystemHandlerWrapper) this.codec;
        systemHandlerWrapper2.handler.postDelayed(new ComponentActivity$$ExternalSyntheticLambda10(this, atomicBoolean, (byte) 9), 1000L);
        systemHandlerWrapper.post(new WakeLockManager$$ExternalSyntheticLambda2(this, atomicBoolean, z, z2, (byte) 0));
    }

    public void postUpdateWifiLock(boolean z, boolean z2) {
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) this.finder;
        byte b = 1;
        if (z && z2) {
            systemHandlerWrapper.post(new WakeLockManager$$ExternalSyntheticLambda0(this, z, z2, b));
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        SystemHandlerWrapper systemHandlerWrapper2 = (SystemHandlerWrapper) this.codec;
        systemHandlerWrapper2.handler.postDelayed(new ComponentActivity$$ExternalSyntheticLambda10(this, atomicBoolean, (byte) 11), 1000L);
        systemHandlerWrapper.post(new WakeLockManager$$ExternalSyntheticLambda2(this, atomicBoolean, z, z2, (byte) 1));
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder responseHeaders = ((ExchangeCodec) this.codec).readResponseHeaders(z);
            if (responseHeaders == null) {
                return responseHeaders;
            }
            responseHeaders.exchange = this;
            return responseHeaders;
        } catch (IOException e) {
            ((RealCall) this.call).eventListener.getClass();
            trackFailure(e);
            throw e;
        }
    }

    public void setStayAwake(boolean z) {
        switch (this.$r8$classId) {
            case 1:
                if (this.hasFailure != z) {
                    this.hasFailure = z;
                    if (this.isDuplex) {
                        postUpdateWakeLock(true, z);
                    }
                    break;
                }
                break;
            default:
                if (this.hasFailure != z) {
                    this.hasFailure = z;
                    if (this.isDuplex) {
                        postUpdateWifiLock(true, z);
                    }
                    break;
                }
                break;
        }
    }

    public void trackFailure(IOException iOException) {
        this.hasFailure = true;
        ((ExchangeCodec) this.codec).getCarrier().trackFailure((RealCall) this.call, iOException);
    }

    public NavDeepLinkRequest upgradeToSocket() throws SocketException {
        RealCall realCall = (RealCall) this.call;
        if (realCall.timeoutEarlyExit) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            return null;
        }
        realCall.timeoutEarlyExit = true;
        realCall.timeout.exit();
        synchronized (realCall) {
            if (realCall.exchange == null) {
                throw new IllegalStateException("Check failed.");
            }
            if (realCall.socketSinkOpen || realCall.socketSourceOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (realCall.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (!realCall.responseBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            realCall.responseBodyOpen = false;
            realCall.socketSinkOpen = true;
            realCall.socketSourceOpen = true;
        }
        ExchangeCodec.Carrier carrier = ((ExchangeCodec) this.codec).getCarrier();
        carrier.getClass();
        RealConnection realConnection = (RealConnection) carrier;
        realConnection.javaNetSocket.setSoTimeout(0);
        realConnection.noNewExchanges();
        return new NavDeepLinkRequest(this);
    }

    public Exchange(RealCall realCall, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        this.$r8$classId = (byte) 0;
        exchangeFinder.getClass();
        this.call = realCall;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
    }
}
