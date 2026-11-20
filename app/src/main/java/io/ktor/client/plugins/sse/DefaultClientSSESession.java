package io.ktor.client.plugins.sse;

import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEvent;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.ThrowableKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.LineEnding;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SafeFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0004H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0016*\u00020\u0004H\u0082@¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001e\u001a\u00020\u000e*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\u0004\u0018\u00010\u001c*\u00020\u0004H\u0082@¢\u0006\u0004\b \u0010\u0018J\u0017\u0010!\u001a\u00020\u001c*\u00060\u001aj\u0002`\u001bH\u0002¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\u00020#*\u00020\u0016H\u0002¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020#*\u00020\u0016H\u0002¢\u0006\u0004\b&\u0010%J\u0013\u0010'\u001a\u00020#*\u00020\u0016H\u0002¢\u0006\u0004\b'\u0010%R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00102R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00102R\u0016\u0010\f\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00109R\u0014\u0010:\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010)R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00160@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160@8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lio/ktor/client/plugins/sse/DefaultClientSSESession;", "Lio/ktor/client/plugins/sse/SSESession;", "Lio/ktor/client/plugins/sse/SSEClientContent;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/client/plugins/sse/SSEClientContent;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;)V", "(Lio/ktor/client/plugins/sse/SSEClientContent;Lio/ktor/utils/io/ByteReadChannel;)V", "", "bodyBuffer", "()[B", "", "doReconnection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "getRequestForReconnection", "()Lio/ktor/client/request/HttpRequestBuilder;", "close", "()V", "Lio/ktor/sse/ServerSentEvent;", "tryParseEvent", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseEvent", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "comment", "appendComment", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "readLineWithSave", "toText", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "", "isEmpty", "(Lio/ktor/sse/ServerSentEvent;)Z", "isCommentsEvent", "isRetryEvent", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEventId", "Ljava/lang/String;", "", "reconnectionTimeMillis", "J", "showCommentEvents", "Z", "showRetryEvents", "", "maxReconnectionAttempts", "I", "needToReconnect", "Lio/ktor/client/plugins/sse/BodyBuffer;", "Lio/ktor/client/plugins/sse/BodyBuffer;", "initialRequest", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "clientForReconnection", "Lio/ktor/client/HttpClient;", "callContext", "Lkotlinx/coroutines/flow/Flow;", "_incoming", "Lkotlinx/coroutines/flow/Flow;", "getIncoming", "()Lkotlinx/coroutines/flow/Flow;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultClientSSESession implements SSESession {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultClientSSESession.class, "closed");
    private Flow _incoming;
    private BodyBuffer bodyBuffer;
    private final CoroutineContext callContext;
    private final HttpClient clientForReconnection;
    private volatile /* synthetic */ int closed;
    private final CoroutineContext coroutineContext;
    private final HttpRequestBuilder initialRequest;
    private ByteReadChannel input;
    private String lastEventId;
    private final int maxReconnectionAttempts;
    private boolean needToReconnect;
    private long reconnectionTimeMillis;
    private final boolean showCommentEvents;
    private final boolean showRetryEvents;

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$doReconnection$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$doReconnection$2", f = "DefaultClientSSESession.kt", l = {105, 112, 114}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DefaultClientSSESession.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0088 A[Catch: all -> 0x0023, SSEClientException -> 0x0183, TryCatch #2 {SSEClientException -> 0x0183, all -> 0x0023, blocks: (B:8:0x001e, B:39:0x0108, B:41:0x0118, B:42:0x011e, B:23:0x0057, B:26:0x0076, B:28:0x0088, B:29:0x00bd, B:32:0x00d0, B:34:0x00e0, B:35:0x00f8, B:15:0x0034, B:18:0x003e), top: B:57:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:32:0x00d0 A[Catch: all -> 0x0023, SSEClientException -> 0x0183, PHI: r0 r7 r12
          0x00d0: PHI (r0v9 io.ktor.client.request.HttpRequestBuilder) = (r0v8 io.ktor.client.request.HttpRequestBuilder), (r0v18 io.ktor.client.request.HttpRequestBuilder) binds: [B:30:0x00cd, B:15:0x0034] A[DONT_GENERATE, DONT_INLINE]
          0x00d0: PHI (r7v3 kotlin.jvm.internal.Ref$IntRef) = (r7v2 kotlin.jvm.internal.Ref$IntRef), (r7v9 kotlin.jvm.internal.Ref$IntRef) binds: [B:30:0x00cd, B:15:0x0034] A[DONT_GENERATE, DONT_INLINE]
          0x00d0: PHI (r12v15 java.lang.Object) = (r12v14 java.lang.Object), (r12v0 java.lang.Object) binds: [B:30:0x00cd, B:15:0x0034] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {SSEClientException -> 0x0183, all -> 0x0023, blocks: (B:8:0x001e, B:39:0x0108, B:41:0x0118, B:42:0x011e, B:23:0x0057, B:26:0x0076, B:28:0x0088, B:29:0x00bd, B:32:0x00d0, B:34:0x00e0, B:35:0x00f8, B:15:0x0034, B:18:0x003e), top: B:57:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00e0 A[Catch: all -> 0x0023, SSEClientException -> 0x0183, TryCatch #2 {SSEClientException -> 0x0183, all -> 0x0023, blocks: (B:8:0x001e, B:39:0x0108, B:41:0x0118, B:42:0x011e, B:23:0x0057, B:26:0x0076, B:28:0x0088, B:29:0x00bd, B:32:0x00d0, B:34:0x00e0, B:35:0x00f8, B:15:0x0034, B:18:0x003e), top: B:57:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:38:0x0107  */
        /* JADX WARN: Instruction removed from duplicated block: B:28:0x0088, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:34:0x00e0, please report this as an issue */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0107 -> B:39:0x0108). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref$IntRef ref$IntRef;
            HttpRequestBuilder requestForReconnection;
            Logger logger;
            DefaultClientSSESession defaultClientSSESession;
            HttpResponse response;
            Logger logger2;
            HttpResponse httpResponse;
            int i = this.label;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                    ref$IntRef2.element = 1;
                    ref$IntRef = ref$IntRef2;
                    if (ref$IntRef.element > DefaultClientSSESession.this.maxReconnectionAttempts) {
                        return unit;
                    }
                    ByteReadChannelKt.cancel(DefaultClientSSESession.this.input);
                    long j = DefaultClientSSESession.this.reconnectionTimeMillis;
                    this.L$0 = ref$IntRef;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 1;
                    if (AwaitKt.delay(j, this) != coroutineSingletons) {
                        requestForReconnection = DefaultClientSSESession.this.getRequestForReconnection();
                        logger = SSEKt.getLOGGER();
                        defaultClientSSESession = DefaultClientSSESession.this;
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Sending SSE request " + requestForReconnection.getUrl() + " (attempt " + (ref$IntRef.element + 1) + '/' + (defaultClientSSESession.maxReconnectionAttempts + 1) + ')');
                        }
                        HttpClient httpClient = DefaultClientSSESession.this.clientForReconnection;
                        this.L$0 = ref$IntRef;
                        this.L$1 = requestForReconnection;
                        this.label = 2;
                        obj = httpClient.execute$ktor_client_core(requestForReconnection, this);
                        if (obj == coroutineSingletons) {
                            response = ((HttpClientCall) obj).getResponse();
                            logger2 = SSEKt.getLOGGER();
                            if (LoggerJvmKt.isTraceEnabled(logger2)) {
                                logger2.trace("Receive response for reconnection SSE request to " + requestForReconnection.getUrl());
                            }
                            this.L$0 = ref$IntRef;
                            this.L$1 = null;
                            this.L$2 = response;
                            this.label = 3;
                            if (SSEKt.checkResponse(response, this) != coroutineSingletons) {
                                httpResponse = response;
                            }
                        }
                    }
                    return coroutineSingletons;
                }
                if (i == 1) {
                    ref$IntRef = (Ref$IntRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    requestForReconnection = DefaultClientSSESession.this.getRequestForReconnection();
                    logger = SSEKt.getLOGGER();
                    defaultClientSSESession = DefaultClientSSESession.this;
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Sending SSE request " + requestForReconnection.getUrl() + " (attempt " + (ref$IntRef.element + 1) + '/' + (defaultClientSSESession.maxReconnectionAttempts + 1) + ')');
                    }
                    HttpClient httpClient2 = DefaultClientSSESession.this.clientForReconnection;
                    this.L$0 = ref$IntRef;
                    this.L$1 = requestForReconnection;
                    this.label = 2;
                    obj = httpClient2.execute$ktor_client_core(requestForReconnection, this);
                    if (obj == coroutineSingletons) {
                        response = ((HttpClientCall) obj).getResponse();
                        logger2 = SSEKt.getLOGGER();
                        if (LoggerJvmKt.isTraceEnabled(logger2)) {
                            logger2.trace("Receive response for reconnection SSE request to " + requestForReconnection.getUrl());
                        }
                        this.L$0 = ref$IntRef;
                        this.L$1 = null;
                        this.L$2 = response;
                        this.label = 3;
                        if (SSEKt.checkResponse(response, this) != coroutineSingletons) {
                            httpResponse = response;
                        }
                    }
                    return coroutineSingletons;
                }
                if (i == 2) {
                    requestForReconnection = (HttpRequestBuilder) this.L$1;
                    ref$IntRef = (Ref$IntRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    response = ((HttpClientCall) obj).getResponse();
                    logger2 = SSEKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger2)) {
                        logger2.trace("Receive response for reconnection SSE request to " + requestForReconnection.getUrl());
                    }
                    this.L$0 = ref$IntRef;
                    this.L$1 = null;
                    this.L$2 = response;
                    this.label = 3;
                    if (SSEKt.checkResponse(response, this) != coroutineSingletons) {
                        httpResponse = response;
                    }
                    return coroutineSingletons;
                }
                if (i != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                httpResponse = (HttpResponse) this.L$2;
                ref$IntRef = (Ref$IntRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } catch (SSEClientException e) {
                throw e;
            } catch (Throwable th) {
                if (ref$IntRef.element == DefaultClientSSESession.this.maxReconnectionAttempts) {
                    Logger logger3 = SSEKt.getLOGGER();
                    DefaultClientSSESession defaultClientSSESession2 = DefaultClientSSESession.this;
                    if (LoggerJvmKt.isTraceEnabled(logger3)) {
                        logger3.trace("Max retries (" + defaultClientSSESession2.maxReconnectionAttempts + ") reached for SSE reconnection, closing session");
                    }
                    throw th;
                }
                Logger logger4 = SSEKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled(logger4)) {
                    logger4.trace("SSE reconnection attempt " + (ref$IntRef.element + 1) + " failed");
                }
                ref$IntRef.element++;
            }
            if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNoContent())) {
                DefaultClientSSESession.this.needToReconnect = false;
            }
            DefaultClientSSESession.this.input = httpResponse.getRawContent();
            return unit;
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$parseEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", l = {181, 183, 233}, m = "parseEvent", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultClientSSESession.this.parseEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$readLineWithSave$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", l = {242}, m = "readLineWithSave", v = 1)
    public static final class C02551 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02551(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultClientSSESession.this.readLineWithSave(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", l = {160}, m = "tryParseEvent", v = 1)
    public static final class C02561 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02561(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultClientSSESession.this.tryParseEvent(null, this);
        }
    }

    public DefaultClientSSESession(SSEClientContent sSEClientContent, ByteReadChannel byteReadChannel, CoroutineContext coroutineContext) {
        sSEClientContent.getClass();
        byteReadChannel.getClass();
        coroutineContext.getClass();
        this.input = byteReadChannel;
        this.coroutineContext = coroutineContext;
        this.reconnectionTimeMillis = Duration.m1887getInWholeMillisecondsimpl(sSEClientContent.getReconnectionTime());
        this.showCommentEvents = sSEClientContent.getShowCommentEvents();
        this.showRetryEvents = sSEClientContent.getShowRetryEvents();
        int maxReconnectionAttempts = sSEClientContent.getMaxReconnectionAttempts();
        this.maxReconnectionAttempts = maxReconnectionAttempts;
        byte b = 0;
        this.needToReconnect = maxReconnectionAttempts > 0;
        this.bodyBuffer = SSEBufferPolicyKt.toBodyBuffer(sSEClientContent.getBufferPolicy());
        HttpRequestBuilder initialRequest = sSEClientContent.getInitialRequest();
        this.initialRequest = initialRequest;
        this.clientForReconnection = (HttpClient) initialRequest.getAttributes().get(SSEKt.getSSEClientForReconnectionAttr());
        this.callContext = sSEClientContent.getCallContext();
        this.closed = 0;
        this._incoming = new DownloadUtil$getDownload$$inlined$map$1(new DownloadUtil$getDownload$$inlined$map$1(new SafeFlow(b, new DefaultClientSSESession$_incoming$1(this, null)), new DefaultClientSSESession$_incoming$2(null), (byte) 6), new DefaultClientSSESession$_incoming$3(this, null), (byte) 5);
        AwaitKt.getJob(getCoroutineContext()).invokeOnCompletion(new MimesKt$$ExternalSyntheticLambda0((byte) 25, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(DefaultClientSSESession defaultClientSSESession, Throwable th) {
        defaultClientSSESession.close();
        return Unit.INSTANCE;
    }

    private final void appendComment(StringBuilder sb, String str) {
        sb.append(StringsKt.removePrefix(StringsKt.removePrefix(str, ServerSentEventKt.COLON), ServerSentEventKt.SPACE));
        sb.append(ServerSentEventKt.END_OF_LINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void close() {
        if (closed$FU.compareAndSet(this, 0, 1)) {
            AwaitKt.cancel(getCoroutineContext(), (CancellationException) null);
            ByteReadChannelKt.cancel(this.input);
            AwaitKt.cancel(this.callContext, (CancellationException) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doReconnection(Continuation continuation) {
        Object objWithContext = AwaitKt.withContext(getCoroutineContext(), new AnonymousClass2(null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpRequestBuilder getRequestForReconnection() {
        HttpRequestBuilder httpRequestBuilderTakeFrom = new HttpRequestBuilder().takeFrom(this.initialRequest);
        httpRequestBuilderTakeFrom.getAttributes().remove(BuildersKt.getSseRequestAttr());
        httpRequestBuilderTakeFrom.getAttributes().put(SSEKt.getSSEReconnectionRequestAttr(), Boolean.TRUE);
        String str = this.lastEventId;
        if (str != null) {
            httpRequestBuilderTakeFrom.getHeaders().append(HttpHeaders.LastEventID, str);
        }
        return httpRequestBuilderTakeFrom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCommentsEvent(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getEvent() == null && serverSentEvent.getId() == null && serverSentEvent.getRetry() == null && serverSentEvent.getComments() != null;
    }

    private final boolean isEmpty(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getId() == null && serverSentEvent.getEvent() == null && serverSentEvent.getRetry() == null && serverSentEvent.getComments() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRetryEvent(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getEvent() == null && serverSentEvent.getId() == null && serverSentEvent.getComments() == null && serverSentEvent.getRetry() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x0109  */
    /* JADX WARN: Code duplicated, block: B:38:0x010f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0114  */
    /* JADX WARN: Code duplicated, block: B:42:0x011c  */
    /* JADX WARN: Code duplicated, block: B:43:0x012a  */
    /* JADX WARN: Code duplicated, block: B:46:0x013c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x013d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0142  */
    /* JADX WARN: Code duplicated, block: B:51:0x014d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0155  */
    /* JADX WARN: Code duplicated, block: B:54:0x016d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0172  */
    /* JADX WARN: Code duplicated, block: B:58:0x0177  */
    /* JADX WARN: Code duplicated, block: B:61:0x017d  */
    /* JADX WARN: Code duplicated, block: B:66:0x018f  */
    /* JADX WARN: Code duplicated, block: B:67:0x019d  */
    /* JADX WARN: Code duplicated, block: B:68:0x019f  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:72:0x01aa A[PHI: r4 r12 r13
      0x01aa: PHI (r4v6 int) = (r4v5 int), (r4v5 int), (r4v7 int), (r4v5 int), (r4v5 int), (r4v5 int) binds: [B:78:0x01c7, B:74:0x01b3, B:76:0x01b6, B:69:0x01a6, B:71:0x01a9, B:66:0x018f] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r12v9 java.lang.StringBuilder) = 
      (r12v8 java.lang.StringBuilder)
      (r12v11 java.lang.StringBuilder)
      (r12v11 java.lang.StringBuilder)
      (r12v13 java.lang.StringBuilder)
      (r12v13 java.lang.StringBuilder)
      (r12v15 java.lang.StringBuilder)
     binds: [B:78:0x01c7, B:74:0x01b3, B:76:0x01b6, B:69:0x01a6, B:71:0x01a9, B:66:0x018f] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r13v6 java.lang.String) = 
      (r13v5 java.lang.String)
      (r13v5 java.lang.String)
      (r13v5 java.lang.String)
      (r13v5 java.lang.String)
      (r13v7 java.lang.String)
      (r13v5 java.lang.String)
     binds: [B:78:0x01c7, B:74:0x01b3, B:76:0x01b6, B:69:0x01a6, B:71:0x01a9, B:66:0x018f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f5 -> B:30:0x00f9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x01f2 -> B:87:0x01f5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object parseEvent(io.ktor.utils.io.ByteReadChannel r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instruction units count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession.parseEvent(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readLineWithSave(ByteReadChannel byteReadChannel, Continuation continuation) {
        C02551 c02551;
        if (continuation instanceof C02551) {
            c02551 = (C02551) continuation;
            int i = c02551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02551.label = i - Integer.MIN_VALUE;
            } else {
                c02551 = new C02551(continuation);
            }
        } else {
            c02551 = new C02551(continuation);
        }
        Object line = c02551.result;
        int i2 = c02551.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(line);
            LineEnding lineEnding = LineEnding.Lenient;
            c02551.L$0 = null;
            c02551.label = 1;
            line = ByteReadChannelOperationsKt.readLine(byteReadChannel, lineEnding, c02551);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (line == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(line);
        }
        String str = (String) line;
        if (str == null) {
            return null;
        }
        this.bodyBuffer.appendLine(str);
        return str;
    }

    private final String toText(StringBuilder sb) {
        return StringsKt.removeSuffix(sb.toString(), ServerSentEventKt.END_OF_LINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object tryParseEvent(ByteReadChannel byteReadChannel, Continuation continuation) throws Throwable {
        C02561 c02561;
        if (continuation instanceof C02561) {
            c02561 = (C02561) continuation;
            int i = c02561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02561.label = i - Integer.MIN_VALUE;
            } else {
                c02561 = new C02561(continuation);
            }
        } else {
            c02561 = new C02561(continuation);
        }
        Object event = c02561.result;
        int i2 = c02561.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(event);
                c02561.L$0 = null;
                c02561.label = 1;
                event = parseEvent(byteReadChannel, c02561);
                Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (event == obj) {
                    return obj;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(event);
            }
            return (ServerSentEvent) event;
        } catch (IOException e) {
            Throwable rootCause = ThrowableKt.getRootCause(e);
            if (rootCause instanceof SocketTimeoutException) {
                throw rootCause;
            }
            return null;
        }
    }

    @Override // io.ktor.client.plugins.sse.SSESession
    public byte[] bodyBuffer() {
        return this.bodyBuffer.toByteArray();
    }

    @Override // io.ktor.client.plugins.sse.SSESession, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.client.plugins.sse.SSESession
    /* JADX INFO: renamed from: getIncoming, reason: from getter */
    public Flow get_incoming() {
        return this._incoming;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultClientSSESession(SSEClientContent sSEClientContent, ByteReadChannel byteReadChannel) {
        this(sSEClientContent, byteReadChannel, sSEClientContent.getCallContext().plus(AwaitKt.Job$default()).plus(new CoroutineName("DefaultClientSSESession")));
        sSEClientContent.getClass();
        byteReadChannel.getClass();
    }
}
