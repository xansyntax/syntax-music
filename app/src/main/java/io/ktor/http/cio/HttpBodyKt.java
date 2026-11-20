package io.ktor.http.cio;

import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b\u001a;\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u000b\u001aF\u0010\u0019\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u0019\u0010\u001a\u001a<\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0087@¢\u0006\u0004\b\u0019\u0010\u001b\u001a(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u0019\u0010\u001e\u001a\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lio/ktor/http/HttpMethod;", "method", "", "upgrade", "Lio/ktor/http/cio/ConnectionOptions;", "connectionOptions", "", "expectHttpUpgrade", "(Lio/ktor/http/HttpMethod;Ljava/lang/CharSequence;Lio/ktor/http/cio/ConnectionOptions;)Z", "Lio/ktor/http/cio/Request;", "request", "(Lio/ktor/http/cio/Request;)Z", "", "contentLength", "transferEncoding", "contentType", "expectHttpBody", "(Lio/ktor/http/HttpMethod;JLjava/lang/CharSequence;Lio/ktor/http/cio/ConnectionOptions;Ljava/lang/CharSequence;)Z", "Lio/ktor/http/HttpProtocolVersion;", "version", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "out", "", "parseHttpBody", "(Lio/ktor/http/HttpProtocolVersion;JLjava/lang/CharSequence;Lio/ktor/http/cio/ConnectionOptions;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(JLjava/lang/CharSequence;Lio/ktor/http/cio/ConnectionOptions;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/HttpHeadersMap;", "headers", "(Lio/ktor/http/cio/HttpHeadersMap;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTransferEncodingChunked", "(Ljava/lang/CharSequence;)Z", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpBodyKt {
    public static final boolean expectHttpBody(Request request) {
        request.getClass();
        HttpMethod method = request.getMethod();
        CharSequence charSequence = request.getHeaders().get(HttpHeaders.ContentLength);
        return expectHttpBody(method, charSequence != null ? CharsKt.parseDecLong(charSequence) : -1L, request.getHeaders().get(HttpHeaders.TransferEncoding), ConnectionOptions.INSTANCE.parse(request.getHeaders().get(HttpHeaders.Connection)), request.getHeaders().get(HttpHeaders.ContentType));
    }

    public static final boolean expectHttpUpgrade(Request request) {
        request.getClass();
        return expectHttpUpgrade(request.getMethod(), request.getHeaders().get(HttpHeaders.Upgrade), ConnectionOptions.INSTANCE.parse(request.getHeaders().get(HttpHeaders.Connection)));
    }

    private static final boolean isTransferEncodingChunked(CharSequence charSequence) {
        if (CharsKt.equalsLowerCase$default(charSequence, 0, 0, "chunked", 3, null)) {
            return true;
        }
        if (CharsKt.equalsLowerCase$default(charSequence, 0, 0, "identity", 3, null)) {
            return false;
        }
        Iterator it = StringsKt.split$default(charSequence, new String[]{","}, 0, 6).iterator();
        boolean z = false;
        while (it.hasNext()) {
            String lowerCase = StringsKt.trim((String) it.next()).toString().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            if (lowerCase.equals("chunked")) {
                if (z) {
                    PathKt$$ExternalSyntheticBUOutline0.m$3(charSequence, "Double-chunked TE is not supported: ");
                    return false;
                }
                z = true;
            } else if (!lowerCase.equals("identity")) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unsupported transfer encoding ".concat(lowerCase));
                return false;
            }
        }
        return z;
    }

    public static final Object parseHttpBody(HttpProtocolVersion httpProtocolVersion, long j, CharSequence charSequence, ConnectionOptions connectionOptions, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation continuation) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        if (charSequence != null && isTransferEncodingChunked(charSequence)) {
            Object objDecodeChunked = ChunkedTransferEncodingKt.decodeChunked(byteReadChannel, byteWriteChannel, continuation);
            return objDecodeChunked == coroutineSingletons ? objDecodeChunked : unit;
        }
        if (j != -1) {
            Object objCopyTo = ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel, j, continuation);
            return objCopyTo == coroutineSingletons ? objCopyTo : unit;
        }
        if ((connectionOptions == null || !connectionOptions.getClose()) && !(connectionOptions == null && Intrinsics.areEqual(httpProtocolVersion, HttpProtocolVersion.INSTANCE.getHTTP_1_0()))) {
            ByteWriteChannelOperationsKt.close(byteWriteChannel, new IllegalStateException("Failed to parse request body: request body length should be specified,\nchunked transfer encoding should be used or\nkeep-alive should be disabled (connection: close)"));
            return unit;
        }
        Object objCopyTo2 = ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel, Long.MAX_VALUE, continuation);
        return objCopyTo2 == coroutineSingletons ? objCopyTo2 : unit;
    }

    public static final boolean expectHttpUpgrade(HttpMethod httpMethod, CharSequence charSequence, ConnectionOptions connectionOptions) {
        httpMethod.getClass();
        return httpMethod.equals(HttpMethod.Get) && charSequence != null && connectionOptions != null && connectionOptions.getUpgrade();
    }

    public static final boolean expectHttpBody(HttpMethod httpMethod, long j, CharSequence charSequence, ConnectionOptions connectionOptions, CharSequence charSequence2) {
        httpMethod.getClass();
        if (charSequence != null) {
            isTransferEncodingChunked(charSequence);
            return true;
        }
        if (j != -1) {
            return j > 0;
        }
        return (httpMethod.equals(HttpMethod.Get) || httpMethod.equals(HttpMethod.Head) || httpMethod.equals(HttpMethod.Options) || connectionOptions == null || !connectionOptions.getClose()) ? false : true;
    }

    @Deprecated
    public static final Object parseHttpBody(long j, CharSequence charSequence, ConnectionOptions connectionOptions, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation continuation) throws Throwable {
        Object httpBody = parseHttpBody(null, j, charSequence, connectionOptions, byteReadChannel, byteWriteChannel, continuation);
        return httpBody == CoroutineSingletons.COROUTINE_SUSPENDED ? httpBody : Unit.INSTANCE;
    }

    public static final Object parseHttpBody(HttpHeadersMap httpHeadersMap, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation continuation) throws Throwable {
        CharSequence charSequence = httpHeadersMap.get(HttpHeaders.ContentLength);
        Object httpBody = parseHttpBody(null, charSequence != null ? CharsKt.parseDecLong(charSequence) : -1L, httpHeadersMap.get(HttpHeaders.TransferEncoding), ConnectionOptions.INSTANCE.parse(httpHeadersMap.get(HttpHeaders.Connection)), byteReadChannel, byteWriteChannel, continuation);
        return httpBody == CoroutineSingletons.COROUTINE_SUSPENDED ? httpBody : Unit.INSTANCE;
    }
}
