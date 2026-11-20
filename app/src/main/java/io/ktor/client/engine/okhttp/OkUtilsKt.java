package io.ktor.client.engine.okhttp;

import dagger.hilt.EntryPoints;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.internal.connection.RealCall;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a,\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\f\u001a\u00020\u000f*\u00020\u000eH\u0000¢\u0006\u0004\b\f\u0010\u0010\u001a\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lokhttp3/OkHttpClient;", "Lokhttp3/Request;", "request", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lkotlin/coroutines/CoroutineContext;", "callContext", "Lokhttp3/Response;", "execute", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/Headers;", "Lio/ktor/http/Headers;", "fromOkHttp", "(Lokhttp3/Headers;)Lio/ktor/http/Headers;", "Lokhttp3/Protocol;", "Lio/ktor/http/HttpProtocolVersion;", "(Lokhttp3/Protocol;)Lio/ktor/http/HttpProtocolVersion;", "Ljava/io/IOException;", "origin", "", "mapOkHttpException", "(Lio/ktor/client/request/HttpRequestData;Ljava/io/IOException;)Ljava/lang/Throwable;", "", "isConnectException", "(Ljava/io/IOException;)Z", "ktor-client-okhttp"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OkUtilsKt {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Protocol.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Object execute(OkHttpClient okHttpClient, Request request, HttpRequestData httpRequestData, CoroutineContext coroutineContext, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        okHttpClient.getClass();
        request.getClass();
        final RealCall realCall = new RealCall(okHttpClient, request, false);
        CoroutineContext.Element element = coroutineContext.get(Job.Key.$$INSTANCE);
        element.getClass();
        ((Job) element).invokeOnCompletion(true, true, new Function1() { // from class: io.ktor.client.engine.okhttp.OkUtilsKt$execute$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                ((RealCall) realCall).cancel();
            }
        });
        realCall.enqueue(new OkHttpCallback(httpRequestData, cancellableContinuationImpl));
        return cancellableContinuationImpl.getResult();
    }

    public static final HttpProtocolVersion fromOkHttp(Protocol protocol) {
        protocol.getClass();
        switch (WhenMappings.$EnumSwitchMapping$0[protocol.ordinal()]) {
            case 1:
                return HttpProtocolVersion.INSTANCE.getHTTP_1_0();
            case 2:
                return HttpProtocolVersion.INSTANCE.getHTTP_1_1();
            case 3:
                return HttpProtocolVersion.INSTANCE.getSPDY_3();
            case 4:
                return HttpProtocolVersion.INSTANCE.getHTTP_2_0();
            case 5:
                return HttpProtocolVersion.INSTANCE.getHTTP_2_0();
            case 6:
                return HttpProtocolVersion.INSTANCE.getQUIC();
            case 7:
                return HttpProtocolVersion.INSTANCE.getHTTP_3_0();
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    private static final boolean isConnectException(IOException iOException) {
        String message = iOException.getMessage();
        return message != null && StringsKt.contains(message, "connect", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapOkHttpException(HttpRequestData httpRequestData, IOException iOException) {
        if (iOException instanceof StreamAdapterIOException) {
            Throwable cause = iOException.getCause();
            return cause == null ? iOException : cause;
        }
        if (iOException instanceof SocketTimeoutException) {
            return isConnectException(iOException) ? HttpTimeoutKt.ConnectTimeoutException(httpRequestData, iOException) : HttpTimeoutKt.SocketTimeoutException(httpRequestData, iOException);
        }
        return iOException;
    }

    public static final Headers fromOkHttp(final okhttp3.Headers headers) {
        headers.getClass();
        return new Headers() { // from class: io.ktor.client.engine.okhttp.OkUtilsKt.fromOkHttp.1
            private final boolean caseInsensitiveName = true;

            @Override // io.ktor.util.StringValues
            public /* bridge */ boolean contains(String str) {
                return super.contains(str);
            }

            @Override // io.ktor.util.StringValues
            public Set<Map.Entry<String, List<String>>> entries() {
                return headers.toMultimap().entrySet();
            }

            @Override // io.ktor.util.StringValues
            public /* bridge */ void forEach(Function2 function2) {
                super.forEach(function2);
            }

            @Override // io.ktor.util.StringValues
            public /* bridge */ String get(String str) {
                return super.get(str);
            }

            @Override // io.ktor.util.StringValues
            public List<String> getAll(String name) {
                name.getClass();
                List<String> listValues = headers.values(name);
                if (listValues.isEmpty()) {
                    return null;
                }
                return listValues;
            }

            @Override // io.ktor.util.StringValues
            public boolean getCaseInsensitiveName() {
                return this.caseInsensitiveName;
            }

            @Override // io.ktor.util.StringValues
            public boolean isEmpty() {
                return headers.size() == 0;
            }

            @Override // io.ktor.util.StringValues
            public Set<String> names() {
                okhttp3.Headers headers2 = headers;
                headers2.getClass();
                Comparator comparator = String.CASE_INSENSITIVE_ORDER;
                comparator.getClass();
                TreeSet treeSet = new TreeSet(comparator);
                int size = headers2.size();
                for (int i = 0; i < size; i++) {
                    treeSet.add(EntryPoints.commonName(headers2, i));
                }
                Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
                setUnmodifiableSet.getClass();
                return setUnmodifiableSet;
            }

            @Override // io.ktor.util.StringValues
            public /* bridge */ boolean contains(String str, String str2) {
                return super.contains(str, str2);
            }
        };
    }
}
