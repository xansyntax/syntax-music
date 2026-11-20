package coil3.network.okhttp.internal;

import androidx.sqlite.SQLite;
import coil3.network.NetworkRequest;
import coil3.network.NetworkResponse;
import java.io.Closeable;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealCall;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CallFactoryNetworkClient {
    public final OkHttpClient callFactory;

    public /* synthetic */ CallFactoryNetworkClient(OkHttpClient okHttpClient) {
        this.callFactory = okHttpClient;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: executeRequest-impl, reason: not valid java name */
    public static Object m858executeRequestimpl(OkHttpClient okHttpClient, NetworkRequest networkRequest, Function2 function2, ContinuationImpl continuationImpl) {
        CallFactoryNetworkClient$executeRequest$1 callFactoryNetworkClient$executeRequest$1;
        Function2 function3;
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        if (continuationImpl instanceof CallFactoryNetworkClient$executeRequest$1) {
            callFactoryNetworkClient$executeRequest$1 = (CallFactoryNetworkClient$executeRequest$1) continuationImpl;
            int i = callFactoryNetworkClient$executeRequest$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                callFactoryNetworkClient$executeRequest$1.label = i - Integer.MIN_VALUE;
            } else {
                callFactoryNetworkClient$executeRequest$1 = new CallFactoryNetworkClient$executeRequest$1(continuationImpl);
            }
        } else {
            callFactoryNetworkClient$executeRequest$1 = new CallFactoryNetworkClient$executeRequest$1(continuationImpl);
        }
        Object request = callFactoryNetworkClient$executeRequest$1.result;
        int i2 = callFactoryNetworkClient$executeRequest$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(request);
            callFactoryNetworkClient$executeRequest$1.L$2 = function2;
            callFactoryNetworkClient$executeRequest$1.L$3 = okHttpClient;
            callFactoryNetworkClient$executeRequest$1.label = 1;
            request = SQLite.toRequest(networkRequest, callFactoryNetworkClient$executeRequest$1);
            if (request != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                closeable2 = (Closeable) callFactoryNetworkClient$executeRequest$1.L$3;
                try {
                    ResultKt.throwOnFailure(request);
                    CharsKt.closeFinally(closeable2, null);
                    return request;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        CharsKt.closeFinally(closeable2, th);
                        throw th3;
                    }
                }
            }
            function3 = callFactoryNetworkClient$executeRequest$1.L$2;
            ResultKt.throwOnFailure(request);
            closeable = (Closeable) request;
            try {
                NetworkResponse networkResponse = SQLite.toNetworkResponse((Response) closeable);
                callFactoryNetworkClient$executeRequest$1.L$2 = null;
                callFactoryNetworkClient$executeRequest$1.L$3 = closeable;
                callFactoryNetworkClient$executeRequest$1.label = 3;
                request = function3.invoke(networkResponse, callFactoryNetworkClient$executeRequest$1);
                if (request != coroutineSingletons) {
                    closeable2 = closeable;
                    CharsKt.closeFinally(closeable2, null);
                    return request;
                }
                return coroutineSingletons;
            } catch (Throwable th4) {
                th = th4;
                closeable2 = closeable;
                throw th;
            }
        }
        okHttpClient = (OkHttpClient) callFactoryNetworkClient$executeRequest$1.L$3;
        function2 = callFactoryNetworkClient$executeRequest$1.L$2;
        ResultKt.throwOnFailure(request);
        Request request2 = (Request) request;
        okHttpClient.getClass();
        request2.getClass();
        RealCall realCall = new RealCall(okHttpClient, request2, false);
        callFactoryNetworkClient$executeRequest$1.L$2 = function2;
        callFactoryNetworkClient$executeRequest$1.L$3 = null;
        callFactoryNetworkClient$executeRequest$1.label = 2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(callFactoryNetworkClient$executeRequest$1));
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new CallsKt$await$2$1((byte) 0, realCall));
        realCall.enqueue(new ConnectionPool(cancellableContinuationImpl));
        request = cancellableContinuationImpl.getResult();
        if (request != coroutineSingletons) {
            function3 = function2;
            closeable = (Closeable) request;
            NetworkResponse networkResponse2 = SQLite.toNetworkResponse((Response) closeable);
            callFactoryNetworkClient$executeRequest$1.L$2 = null;
            callFactoryNetworkClient$executeRequest$1.L$3 = closeable;
            callFactoryNetworkClient$executeRequest$1.label = 3;
            request = function3.invoke(networkResponse2, callFactoryNetworkClient$executeRequest$1);
            if (request != coroutineSingletons) {
                closeable2 = closeable;
                CharsKt.closeFinally(closeable2, null);
                return request;
            }
        }
        return coroutineSingletons;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CallFactoryNetworkClient) {
            return this.callFactory == ((CallFactoryNetworkClient) obj).callFactory;
        }
        return false;
    }

    public final int hashCode() {
        return this.callFactory.hashCode();
    }

    public final String toString() {
        return "CallFactoryNetworkClient(callFactory=" + this.callFactory + ")";
    }
}
