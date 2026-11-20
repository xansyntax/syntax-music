package io.ktor.client.plugins.websocket;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda1;
import io.ktor.client.plugins.sse.SSEKt$$ExternalSyntheticLambda0;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.DispatcherSwitching_jvmKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.events.Events$$ExternalSyntheticLambda0;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketSessionKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a)\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a(\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001aX\u0010\u000b\u001a\u00020\n*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u000b\u0010\u0014\u001a2\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u000b\u0010\u0016\u001aL\u0010\u001b\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a|\u0010\u001b\u001a\u00020\u0003*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001d\u001aV\u0010\u001b\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001e\u001a|\u0010\u001f\u001a\u00020\u0003*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001f\u0010\u001d\u001aL\u0010\u001f\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001f\u0010\u001c\u001aV\u0010\u001f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001f\u0010\u001e\u001aL\u0010 \u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b \u0010\u001c\u001aV\u0010 \u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b \u0010\u001e\u001a|\u0010 \u001a\u00020\u0003*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "", "config", "WebSockets", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/HttpClient;", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "webSocketSession", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/HttpMethod;", "method", "", "host", "", "port", "path", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "webSocket", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ws", "wss", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuildersKt {

    /* JADX INFO: renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocket$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt", f = "builders.kt", l = {271, 275, 281, 114, 116, 116, 301, 301}, m = "webSocket", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BuildersKt.webSocket(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2", f = "builders.kt", l = {269, 273, 279, 56, 299, 299}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ CompletableDeferred $sessionDeferred;
        final /* synthetic */ HttpStatement $statement;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpStatement httpStatement, CompletableDeferred completableDeferred, Continuation continuation) {
            super(2, continuation);
            this.$statement = httpStatement;
            this.$sessionDeferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$statement, this.$sessionDeferred, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00d7 A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:39:0x00d1, B:41:0x00d7, B:47:0x010d, B:51:0x011d), top: B:80:0x00d1 }] */
        /* JADX WARN: Code duplicated, block: B:43:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:44:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:47:0x010d A[Catch: all -> 0x0105, TRY_LEAVE, TryCatch #1 {all -> 0x0105, blocks: (B:39:0x00d1, B:41:0x00d7, B:47:0x010d, B:51:0x011d), top: B:80:0x00d1 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x013f  */
        /* JADX WARN: Code duplicated, block: B:56:0x0145 A[Catch: all -> 0x007e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x007e, blocks: (B:22:0x0079, B:56:0x0145, B:64:0x019b, B:65:0x01a2), top: B:85:0x0079 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x017a  */
        /* JADX WARN: Code duplicated, block: B:64:0x019b A[Catch: all -> 0x007e, TRY_ENTER, TryCatch #6 {all -> 0x007e, blocks: (B:22:0x0079, B:56:0x0145, B:64:0x019b, B:65:0x01a2), top: B:85:0x0079 }] */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0198, code lost:
        
            if (r14 == r4) goto L79;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0 */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r14v0, types: [io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r14v10 */
        /* JADX WARN: Type inference failed for: r14v3, types: [io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /* JADX WARN: Type inference failed for: r14v8 */
        /* JADX WARN: Type inference failed for: r14v9 */
        /* JADX WARN: Type inference failed for: r15v10, types: [io.ktor.client.statement.HttpResponse, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r15v20 */
        /* JADX WARN: Type inference failed for: r15v22 */
        /* JADX WARN: Type inference failed for: r15v24 */
        /* JADX WARN: Type inference failed for: r15v26 */
        /* JADX WARN: Type inference failed for: r15v27 */
        /* JADX WARN: Type inference failed for: r15v28 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v15, types: [int] */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v21 */
        /* JADX WARN: Type inference failed for: r5v22 */
        /* JADX WARN: Type inference failed for: r5v23 */
        /* JADX WARN: Type inference failed for: r5v24 */
        /* JADX WARN: Type inference failed for: r5v25 */
        /* JADX WARN: Type inference failed for: r5v26 */
        /* JADX WARN: Type inference failed for: r5v27 */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [int] */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v8, types: [int] */
        /* JADX WARN: Type inference failed for: r5v9 */
        /* JADX WARN: Type inference failed for: r6v0, types: [io.ktor.client.statement.HttpResponse] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v12 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v14, types: [io.ktor.client.statement.HttpResponse] */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v2, types: [int] */
        /* JADX WARN: Type inference failed for: r6v26 */
        /* JADX WARN: Type inference failed for: r6v27 */
        /* JADX WARN: Type inference failed for: r6v28 */
        /* JADX WARN: Type inference failed for: r6v29 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v30 */
        /* JADX WARN: Type inference failed for: r6v31 */
        /* JADX WARN: Type inference failed for: r6v32 */
        /* JADX WARN: Type inference failed for: r6v33 */
        /* JADX WARN: Type inference failed for: r6v34 */
        /* JADX WARN: Type inference failed for: r6v35 */
        /* JADX WARN: Type inference failed for: r6v7, types: [int] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r7v0, types: [io.ktor.client.statement.HttpStatement] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v20, types: [io.ktor.client.statement.HttpStatement] */
        /* JADX WARN: Type inference failed for: r7v21 */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v25 */
        /* JADX WARN: Type inference failed for: r7v26 */
        /* JADX WARN: Type inference failed for: r7v27 */
        /* JADX WARN: Type inference failed for: r7v28 */
        /* JADX WARN: Type inference failed for: r7v29 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v30 */
        /* JADX WARN: Type inference failed for: r7v31 */
        /* JADX WARN: Type inference failed for: r7v32 */
        /* JADX WARN: Type inference failed for: r7v33 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r7;
            ?? r6;
            int i;
            ?? r8;
            CompletableDeferred completableDeferred;
            ?? r9;
            ?? r5;
            ?? r15;
            TypeReference typeReferenceTypeOf;
            Object objBodyNullable;
            ?? r10;
            ?? r11;
            Object objWithContext;
            ?? r12;
            ?? r2;
            ?? r13;
            ?? r14;
            ?? r16;
            Object objAwaitInternal;
            ?? r3;
            ?? r17;
            ?? r18;
            ?? r19;
            ?? r20;
            int i2 = this.label;
            Unit unit = Unit.INSTANCE;
            ?? r4 = 0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    try {
                        switch (i2) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                HttpStatement httpStatement = this.$statement;
                                CompletableDeferred completableDeferred2 = this.$sessionDeferred;
                                this.L$0 = httpStatement;
                                this.L$1 = completableDeferred2;
                                this.I$0 = 0;
                                this.I$1 = 0;
                                this.I$2 = 0;
                                this.label = 1;
                                Object objFetchStreamingResponse = httpStatement.fetchStreamingResponse(this);
                                if (objFetchStreamingResponse != coroutineSingletons) {
                                    r8 = httpStatement;
                                    completableDeferred = completableDeferred2;
                                    i2 = 0;
                                    r9 = 0;
                                    obj = objFetchStreamingResponse;
                                    r5 = 0;
                                    r15 = (HttpResponse) obj;
                                    try {
                                        if (!DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                                            CoroutineContext.Element element = r15.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE);
                                            element.getClass();
                                            BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1 buildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1 = new BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1(r15, null, completableDeferred);
                                            this.L$0 = r8;
                                            this.L$1 = r15;
                                            this.I$0 = r9;
                                            this.I$1 = r5;
                                            this.I$2 = i2;
                                            this.label = 2;
                                            objWithContext = AwaitKt.withContext(element, buildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1, this);
                                            if (objWithContext == coroutineSingletons) {
                                                ?? r110 = r9;
                                                r12 = r15;
                                                obj = objWithContext;
                                                r2 = r5;
                                                r13 = r110 == true ? 1 : 0;
                                                r20 = r8;
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.L$2 = obj;
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.L$5 = null;
                                                this.I$0 = r13;
                                                this.I$1 = r2;
                                                this.I$2 = i2;
                                                r15 = 5;
                                                this.label = 5;
                                                Object objCleanup = r20.cleanup(r12, null, this);
                                                r5 = r13;
                                                r9 = r12;
                                                r8 = r20;
                                                this = objCleanup;
                                            } else {
                                                r5 = r5;
                                                r9 = r9;
                                                r8 = r8;
                                                this = this;
                                                r15 = r15;
                                            }
                                        } else {
                                            HttpClientCall call = r15.getCall();
                                            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
                                            try {
                                                typeReferenceTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
                                            } catch (Throwable unused) {
                                                typeReferenceTypeOf = null;
                                            }
                                            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
                                            this.L$0 = r8;
                                            this.L$1 = completableDeferred;
                                            this.L$2 = r15;
                                            this.L$3 = null;
                                            this.L$4 = null;
                                            this.I$0 = r9;
                                            this.I$1 = r5;
                                            this.I$2 = i2;
                                            this.I$3 = 0;
                                            this.label = 3;
                                            objBodyNullable = call.bodyNullable(typeInfo, this);
                                            r5 = r5;
                                            r9 = r9;
                                            r8 = r8;
                                            this = this;
                                            r15 = r15;
                                            if (objBodyNullable != coroutineSingletons) {
                                                ?? r111 = r8;
                                                r10 = r15;
                                                obj = objBodyNullable;
                                                r11 = r111;
                                                if (obj == null) {
                                                    r16 = r5;
                                                    r14 = r9;
                                                    throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                                                }
                                                r16 = r5;
                                                r14 = r9;
                                                DefaultClientWebSocketSession defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj;
                                                CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
                                                ((CompletableDeferredImpl) completableDeferred).makeCompleting$kotlinx_coroutines_core(defaultClientWebSocketSession);
                                                defaultClientWebSocketSession.getOutgoing().invokeOnClose(new BuildersKt$webSocketSession$2$1$1(completableDeferredImplCompletableDeferred$default));
                                                this.L$0 = r11;
                                                this.L$1 = r10;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.L$5 = null;
                                                this.I$0 = r14;
                                                this.I$1 = r16;
                                                this.I$2 = i2;
                                                this.I$3 = 0;
                                                this.label = 4;
                                                objAwaitInternal = completableDeferredImplCompletableDeferred$default.awaitInternal(this);
                                                if (objAwaitInternal != coroutineSingletons) {
                                                    r5 = r16;
                                                    r9 = r14;
                                                    r8 = r10;
                                                    this = this;
                                                    r15 = objAwaitInternal;
                                                    r3 = r16;
                                                    r17 = r14;
                                                    r18 = r10;
                                                    r19 = r11;
                                                    obj = unit;
                                                    r2 = r3;
                                                    r13 = r17;
                                                    r12 = r18;
                                                    r20 = r19;
                                                    this.L$0 = null;
                                                    this.L$1 = null;
                                                    this.L$2 = obj;
                                                    this.L$3 = null;
                                                    this.L$4 = null;
                                                    this.L$5 = null;
                                                    this.I$0 = r13;
                                                    this.I$1 = r2;
                                                    this.I$2 = i2;
                                                    r15 = 5;
                                                    this.label = 5;
                                                    Object objCleanup2 = r20.cleanup(r12, null, this);
                                                    r5 = r13;
                                                    r9 = r12;
                                                    r8 = r20;
                                                    this = objCleanup2;
                                                }
                                            }
                                        }
                                        r5 = r16;
                                        r9 = r14;
                                        r8 = r10;
                                        this = this;
                                        r15 = objAwaitInternal;
                                        break;
                                    } catch (Throwable th) {
                                        ?? r112 = r9;
                                        r6 = r15;
                                        th = th;
                                        r4 = r5;
                                        i = r112 == true ? 1 : 0;
                                        r7 = r8;
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            this.L$0 = null;
                                            this.L$1 = null;
                                            this.L$2 = null;
                                            this.L$3 = th2;
                                            this.L$4 = null;
                                            this.L$5 = null;
                                            this.I$0 = i;
                                            this.I$1 = r4;
                                            this.I$2 = i2;
                                            this.label = 6;
                                            if (r7.cleanup(r6, th, this) != coroutineSingletons) {
                                                throw th2;
                                            }
                                        }
                                    }
                                }
                                return coroutineSingletons;
                            case 1:
                                i2 = this.I$2;
                                int i3 = this.I$1;
                                int i4 = this.I$0;
                                CompletableDeferred completableDeferred3 = (CompletableDeferred) this.L$1;
                                HttpStatement httpStatement2 = (HttpStatement) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                completableDeferred = completableDeferred3;
                                r8 = httpStatement2;
                                r5 = i3;
                                r9 = i4;
                                r15 = (HttpResponse) obj;
                                if (!DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                                    HttpClientCall call2 = r15.getCall();
                                    ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
                                    typeReferenceTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
                                    TypeInfo typeInfo2 = new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf);
                                    this.L$0 = r8;
                                    this.L$1 = completableDeferred;
                                    this.L$2 = r15;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.I$0 = r9;
                                    this.I$1 = r5;
                                    this.I$2 = i2;
                                    this.I$3 = 0;
                                    this.label = 3;
                                    objBodyNullable = call2.bodyNullable(typeInfo2, this);
                                    r5 = r5;
                                    r9 = r9;
                                    r8 = r8;
                                    this = this;
                                    r15 = r15;
                                    if (objBodyNullable != coroutineSingletons) {
                                        ?? r113 = r8;
                                        r10 = r15;
                                        obj = objBodyNullable;
                                        r11 = r113;
                                        if (obj == null) {
                                            r16 = r5;
                                            r14 = r9;
                                            throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                                        }
                                        r16 = r5;
                                        r14 = r9;
                                        DefaultClientWebSocketSession defaultClientWebSocketSession2 = (DefaultClientWebSocketSession) obj;
                                        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default2 = AwaitKt.CompletableDeferred$default();
                                        ((CompletableDeferredImpl) completableDeferred).makeCompleting$kotlinx_coroutines_core(defaultClientWebSocketSession2);
                                        defaultClientWebSocketSession2.getOutgoing().invokeOnClose(new BuildersKt$webSocketSession$2$1$1(completableDeferredImplCompletableDeferred$default2));
                                        this.L$0 = r11;
                                        this.L$1 = r10;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.I$0 = r14;
                                        this.I$1 = r16;
                                        this.I$2 = i2;
                                        this.I$3 = 0;
                                        this.label = 4;
                                        objAwaitInternal = completableDeferredImplCompletableDeferred$default2.awaitInternal(this);
                                        if (objAwaitInternal != coroutineSingletons) {
                                            r5 = r16;
                                            r9 = r14;
                                            r8 = r10;
                                            this = this;
                                            r15 = objAwaitInternal;
                                            r3 = r16;
                                            r17 = r14;
                                            r18 = r10;
                                            r19 = r11;
                                            obj = unit;
                                            r2 = r3;
                                            r13 = r17;
                                            r12 = r18;
                                            r20 = r19;
                                            this.L$0 = null;
                                            this.L$1 = null;
                                            this.L$2 = obj;
                                            this.L$3 = null;
                                            this.L$4 = null;
                                            this.L$5 = null;
                                            this.I$0 = r13;
                                            this.I$1 = r2;
                                            this.I$2 = i2;
                                            r15 = 5;
                                            this.label = 5;
                                            Object objCleanup3 = r20.cleanup(r12, null, this);
                                            r5 = r13;
                                            r9 = r12;
                                            r8 = r20;
                                            this = objCleanup3;
                                        }
                                    }
                                    break;
                                } else {
                                    CoroutineContext.Element element2 = r15.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE);
                                    element2.getClass();
                                    BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1 buildersKt$webSocketSession$2$invokeSuspend$$inlined$body$2 = new BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1(r15, null, completableDeferred);
                                    this.L$0 = r8;
                                    this.L$1 = r15;
                                    this.I$0 = r9;
                                    this.I$1 = r5;
                                    this.I$2 = i2;
                                    this.label = 2;
                                    objWithContext = AwaitKt.withContext(element2, buildersKt$webSocketSession$2$invokeSuspend$$inlined$body$2, this);
                                    if (objWithContext == coroutineSingletons) {
                                        ?? r114 = r9;
                                        r12 = r15;
                                        obj = objWithContext;
                                        r2 = r5;
                                        r13 = r114 == true ? 1 : 0;
                                        r20 = r8;
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = obj;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.I$0 = r13;
                                        this.I$1 = r2;
                                        this.I$2 = i2;
                                        r15 = 5;
                                        this.label = 5;
                                        Object objCleanup4 = r20.cleanup(r12, null, this);
                                        r5 = r13;
                                        r9 = r12;
                                        r8 = r20;
                                        this = objCleanup4;
                                    } else {
                                        r5 = r5;
                                        r9 = r9;
                                        r8 = r8;
                                        this = this;
                                        r15 = r15;
                                    }
                                    break;
                                }
                                r5 = r16;
                                r9 = r14;
                                r8 = r10;
                                this = this;
                                r15 = objAwaitInternal;
                                return coroutineSingletons;
                            case 2:
                                i2 = this.I$2;
                                int i5 = this.I$1;
                                int i6 = this.I$0;
                                HttpResponse httpResponse = (HttpResponse) this.L$1;
                                HttpStatement httpStatement3 = (HttpStatement) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                r2 = i5;
                                r13 = i6;
                                r12 = httpResponse;
                                r20 = httpStatement3;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = obj;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.I$0 = r13;
                                this.I$1 = r2;
                                this.I$2 = i2;
                                r15 = 5;
                                this.label = 5;
                                Object objCleanup5 = r20.cleanup(r12, null, this);
                                r5 = r13;
                                r9 = r12;
                                r8 = r20;
                                this = objCleanup5;
                                break;
                            case 3:
                                i2 = this.I$2;
                                int i7 = this.I$1;
                                int i8 = this.I$0;
                                HttpResponse httpResponse2 = (HttpResponse) this.L$2;
                                completableDeferred = (CompletableDeferred) this.L$1;
                                HttpStatement httpStatement4 = (HttpStatement) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    r16 = i7;
                                    r14 = i8;
                                    r10 = httpResponse2;
                                    r11 = httpStatement4;
                                    if (obj == null) {
                                        r16 = r5;
                                        r14 = r9;
                                        throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                                    }
                                    r16 = r5;
                                    r14 = r9;
                                    DefaultClientWebSocketSession defaultClientWebSocketSession3 = (DefaultClientWebSocketSession) obj;
                                    CompletableDeferredImpl completableDeferredImplCompletableDeferred$default3 = AwaitKt.CompletableDeferred$default();
                                    ((CompletableDeferredImpl) completableDeferred).makeCompleting$kotlinx_coroutines_core(defaultClientWebSocketSession3);
                                    defaultClientWebSocketSession3.getOutgoing().invokeOnClose(new BuildersKt$webSocketSession$2$1$1(completableDeferredImplCompletableDeferred$default3));
                                    this.L$0 = r11;
                                    this.L$1 = r10;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.I$0 = r14;
                                    this.I$1 = r16;
                                    this.I$2 = i2;
                                    this.I$3 = 0;
                                    this.label = 4;
                                    objAwaitInternal = completableDeferredImplCompletableDeferred$default3.awaitInternal(this);
                                    if (objAwaitInternal != coroutineSingletons) {
                                        r5 = r16;
                                        r9 = r14;
                                        r8 = r10;
                                        this = this;
                                        r15 = objAwaitInternal;
                                        r3 = r16;
                                        r17 = r14;
                                        r18 = r10;
                                        r19 = r11;
                                        obj = unit;
                                        r2 = r3;
                                        r13 = r17;
                                        r12 = r18;
                                        r20 = r19;
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = obj;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.I$0 = r13;
                                        this.I$1 = r2;
                                        this.I$2 = i2;
                                        r15 = 5;
                                        this.label = 5;
                                        Object objCleanup6 = r20.cleanup(r12, null, this);
                                        r5 = r13;
                                        r9 = r12;
                                        r8 = r20;
                                        this = objCleanup6;
                                        break;
                                    }
                                    r5 = r16;
                                    r9 = r14;
                                    r8 = r10;
                                    this = this;
                                    r15 = objAwaitInternal;
                                    return coroutineSingletons;
                                } catch (Throwable th3) {
                                    th = th3;
                                    r4 = i7;
                                    i = i8;
                                    r6 = httpResponse2;
                                    r7 = httpStatement4;
                                    throw th;
                                }
                            case 4:
                                i2 = this.I$2;
                                int i9 = this.I$1;
                                int i10 = this.I$0;
                                HttpResponse httpResponse3 = (HttpResponse) this.L$1;
                                HttpStatement httpStatement5 = (HttpStatement) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                r3 = i9;
                                r17 = i10;
                                r18 = httpResponse3;
                                r19 = httpStatement5;
                                obj = unit;
                                r2 = r3;
                                r13 = r17;
                                r12 = r18;
                                r20 = r19;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = obj;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.I$0 = r13;
                                this.I$1 = r2;
                                this.I$2 = i2;
                                r15 = 5;
                                this.label = 5;
                                Object objCleanup7 = r20.cleanup(r12, null, this);
                                r5 = r13;
                                r9 = r12;
                                r8 = r20;
                                this = objCleanup7;
                                break;
                            case 5:
                                ResultKt.throwOnFailure(obj);
                                return unit;
                            case 6:
                                Throwable th4 = (Throwable) this.L$3;
                                ResultKt.throwOnFailure(obj);
                                throw th4;
                            default:
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                        }
                    } catch (CancellationException e) {
                        throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
                    }
                } catch (Throwable th5) {
                    ((CompletableDeferredImpl) this.$sessionDeferred).completeExceptionally(th5);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public static final void WebSockets(HttpClientConfig<?> httpClientConfig, Function1 function1) {
        httpClientConfig.getClass();
        function1.getClass();
        httpClientConfig.install(WebSockets.INSTANCE, new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 24));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WebSockets$lambda$0(Function1 function1, WebSockets.Config config) {
        config.getClass();
        function1.invoke(config);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x01e2 A[Catch: all -> 0x0218, TryCatch #4 {all -> 0x0218, blocks: (B:51:0x01dc, B:53:0x01e2, B:59:0x021f, B:63:0x022f), top: B:113:0x01dc }] */
    /* JADX WARN: Code duplicated, block: B:55:0x020f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0211  */
    /* JADX WARN: Code duplicated, block: B:59:0x021f A[Catch: all -> 0x0218, TRY_LEAVE, TryCatch #4 {all -> 0x0218, blocks: (B:51:0x01dc, B:53:0x01e2, B:59:0x021f, B:63:0x022f), top: B:113:0x01dc }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0257  */
    /* JADX WARN: Code duplicated, block: B:68:0x025f A[Catch: all -> 0x014b, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x014b, blocks: (B:73:0x0287, B:34:0x0146, B:68:0x025f, B:93:0x0317, B:94:0x031e), top: B:116:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0286  */
    /* JADX WARN: Code duplicated, block: B:76:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:82:0x02db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0308  */
    /* JADX WARN: Code duplicated, block: B:93:0x0317 A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #7 {all -> 0x014b, blocks: (B:73:0x0287, B:34:0x0146, B:68:0x025f, B:93:0x0317, B:94:0x031e), top: B:116:0x0146 }] */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0343, code lost:
    
        if (r11.cleanup(r10, r1, r2) == r9) goto L99;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v14, types: [int] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v37, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v44 */
    /* JADX WARN: Type inference failed for: r10v45 */
    /* JADX WARN: Type inference failed for: r10v46 */
    /* JADX WARN: Type inference failed for: r10v47 */
    /* JADX WARN: Type inference failed for: r10v48 */
    /* JADX WARN: Type inference failed for: r10v49 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v51 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v53 */
    /* JADX WARN: Type inference failed for: r10v54 */
    /* JADX WARN: Type inference failed for: r10v8, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v0, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [int] */
    /* JADX WARN: Type inference failed for: r11v14, types: [int] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v20, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r18v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v9, types: [io.ktor.client.statement.HttpResponse, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [int] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [int] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [int] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19, types: [int] */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v10, types: [int] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object webSocket(HttpClient httpClient, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Throwable th;
        ?? r5;
        ?? r6;
        ?? r11;
        ?? r10;
        Function2 function3;
        HttpStatement httpStatement;
        ?? r12;
        ?? r13;
        Object obj;
        ?? r1;
        TypeReference typeReferenceTypeOf;
        Object objBodyNullable;
        Object obj2;
        Function2 function4;
        ?? r14;
        Object objWithContext;
        ?? r7;
        ?? r8;
        ?? r15;
        ?? r16;
        Object obj3;
        ?? r17;
        ?? r18;
        DefaultClientWebSocketSession defaultClientWebSocketSession;
        DefaultClientWebSocketSession defaultClientWebSocketSession2;
        int i;
        ?? r9;
        ?? r19;
        Object objInvoke;
        DefaultClientWebSocketSession defaultClientWebSocketSession3;
        ?? r20;
        ?? r21;
        ?? r110;
        ?? r111;
        ?? r22;
        HttpStatement httpStatement2;
        ?? r112;
        ?? r113;
        ?? r114;
        Object objClose$default;
        ?? r23;
        ?? r24;
        ?? r115;
        HttpStatement httpStatement3;
        ?? r25;
        ?? r116;
        Object objCleanup;
        DefaultClientWebSocketSession defaultClientWebSocketSession4;
        DefaultClientWebSocketSession defaultClientWebSocketSession5;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj4 = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        byte b = 8;
        Unit unit = Unit.INSTANCE;
        int i4 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                switch (i3) {
                    case 0:
                        ResultKt.throwOnFailure(obj4);
                        HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
                        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                        httpRequestBuilder.url(new HttpParserKt$$ExternalSyntheticLambda0(b));
                        function1.invoke(httpRequestBuilder);
                        HttpStatement httpStatement4 = new HttpStatement(httpRequestBuilder, httpClient);
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = function2;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.L$4 = httpStatement4;
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.I$1 = 0;
                        anonymousClass1.I$2 = 0;
                        anonymousClass1.label = 1;
                        Object objFetchStreamingResponse = httpStatement4.fetchStreamingResponse(anonymousClass1);
                        if (objFetchStreamingResponse != coroutineSingletons) {
                            function3 = function2;
                            httpStatement = httpStatement4;
                            i3 = 0;
                            r12 = 0;
                            r13 = 0;
                            obj = objFetchStreamingResponse;
                            r1 = (HttpResponse) obj;
                            try {
                                if (!DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                                    HttpClientCall call = r1.getCall();
                                    ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
                                    try {
                                        typeReferenceTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
                                    } catch (Throwable unused) {
                                        typeReferenceTypeOf = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = function3;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$4 = httpStatement;
                                    anonymousClass1.L$5 = r1;
                                    anonymousClass1.L$6 = null;
                                    anonymousClass1.L$7 = null;
                                    anonymousClass1.I$0 = r13;
                                    anonymousClass1.I$1 = r12;
                                    anonymousClass1.I$2 = i3;
                                    anonymousClass1.I$3 = 0;
                                    anonymousClass1.label = 3;
                                    objBodyNullable = call.bodyNullable(typeInfo, anonymousClass1);
                                    r1 = r1;
                                    r12 = r12;
                                    r13 = r13;
                                    if (objBodyNullable != coroutineSingletons) {
                                        obj2 = objBodyNullable;
                                        function4 = function3;
                                        r14 = r1;
                                        if (obj2 == null) {
                                            r18 = r12;
                                            r17 = r13;
                                            throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                                        }
                                        r18 = r12;
                                        r17 = r13;
                                        defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj2;
                                        try {
                                            anonymousClass1.L$0 = null;
                                            anonymousClass1.L$1 = null;
                                            anonymousClass1.L$2 = null;
                                            anonymousClass1.L$3 = null;
                                            anonymousClass1.L$4 = httpStatement;
                                            anonymousClass1.L$5 = r14;
                                            anonymousClass1.L$6 = null;
                                            anonymousClass1.L$7 = null;
                                            anonymousClass1.L$8 = defaultClientWebSocketSession;
                                            anonymousClass1.I$0 = r17;
                                            anonymousClass1.I$1 = r18;
                                            anonymousClass1.I$2 = i3;
                                            anonymousClass1.I$3 = 0;
                                            anonymousClass1.label = 4;
                                            objInvoke = function4.invoke(defaultClientWebSocketSession, anonymousClass1);
                                            r1 = defaultClientWebSocketSession;
                                            r12 = r18;
                                            r13 = r17;
                                            if (objInvoke != coroutineSingletons) {
                                                defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                                                r114 = r18;
                                                r113 = r17;
                                                r112 = r14;
                                                anonymousClass1.L$0 = null;
                                                anonymousClass1.L$1 = null;
                                                anonymousClass1.L$2 = null;
                                                anonymousClass1.L$3 = null;
                                                anonymousClass1.L$4 = httpStatement;
                                                anonymousClass1.L$5 = r112;
                                                anonymousClass1.L$6 = null;
                                                anonymousClass1.L$7 = null;
                                                anonymousClass1.L$8 = defaultClientWebSocketSession3;
                                                anonymousClass1.I$0 = r113;
                                                anonymousClass1.I$1 = r114;
                                                anonymousClass1.I$2 = i3;
                                                anonymousClass1.I$3 = i4;
                                                anonymousClass1.label = 5;
                                                objClose$default = WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, anonymousClass1, 1, null);
                                                r1 = objClose$default;
                                                r12 = r114;
                                                r13 = r113;
                                                if (objClose$default != coroutineSingletons) {
                                                    r23 = r114;
                                                    r24 = r113;
                                                    r115 = r112;
                                                    httpStatement3 = httpStatement;
                                                    defaultClientWebSocketSession4 = defaultClientWebSocketSession3;
                                                    defaultClientWebSocketSession4.getIncoming().cancel((CancellationException) null);
                                                    obj3 = unit;
                                                    r7 = r23;
                                                    r8 = r24;
                                                    r16 = r115;
                                                    r15 = httpStatement3;
                                                    anonymousClass1.L$0 = null;
                                                    anonymousClass1.L$1 = null;
                                                    anonymousClass1.L$2 = null;
                                                    anonymousClass1.L$3 = null;
                                                    anonymousClass1.L$4 = null;
                                                    anonymousClass1.L$5 = null;
                                                    anonymousClass1.L$6 = obj3;
                                                    anonymousClass1.L$7 = null;
                                                    anonymousClass1.L$8 = null;
                                                    anonymousClass1.I$0 = r8;
                                                    anonymousClass1.I$1 = r7;
                                                    anonymousClass1.I$2 = i3;
                                                    anonymousClass1.label = 7;
                                                    objCleanup = r15.cleanup(r16, null, anonymousClass1);
                                                    r1 = obj3;
                                                    r12 = r16;
                                                    r13 = r15;
                                                    if (objCleanup != coroutineSingletons) {
                                                        return unit;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            defaultClientWebSocketSession2 = defaultClientWebSocketSession;
                                            i = 0;
                                            r9 = r18;
                                            r19 = r14;
                                            r111 = r17;
                                            try {
                                                anonymousClass1.L$0 = null;
                                                anonymousClass1.L$1 = null;
                                                anonymousClass1.L$2 = null;
                                                anonymousClass1.L$3 = null;
                                                anonymousClass1.L$4 = httpStatement;
                                                anonymousClass1.L$5 = r19;
                                                anonymousClass1.L$6 = null;
                                                anonymousClass1.L$7 = null;
                                                anonymousClass1.L$8 = defaultClientWebSocketSession2;
                                                anonymousClass1.L$9 = th;
                                                anonymousClass1.I$0 = r111;
                                                anonymousClass1.I$1 = r9;
                                                anonymousClass1.I$2 = i3;
                                                anonymousClass1.I$3 = i;
                                                anonymousClass1.label = 6;
                                                if (WebSocketSessionKt.close$default(defaultClientWebSocketSession2, null, anonymousClass1, 1, null) != coroutineSingletons) {
                                                    r22 = r111;
                                                    httpStatement2 = httpStatement;
                                                    r25 = r9;
                                                    defaultClientWebSocketSession5 = defaultClientWebSocketSession2;
                                                    r116 = r19;
                                                    defaultClientWebSocketSession5.getIncoming().cancel((CancellationException) null);
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                r21 = r111;
                                                r20 = r9;
                                                r110 = r19;
                                                r11 = httpStatement;
                                                r5 = r20;
                                                r6 = r21;
                                                r10 = r110;
                                                try {
                                                    throw th;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    anonymousClass1.L$0 = null;
                                                    anonymousClass1.L$1 = null;
                                                    anonymousClass1.L$2 = null;
                                                    anonymousClass1.L$3 = null;
                                                    anonymousClass1.L$4 = null;
                                                    anonymousClass1.L$5 = null;
                                                    anonymousClass1.L$6 = null;
                                                    anonymousClass1.L$7 = th;
                                                    anonymousClass1.L$8 = null;
                                                    anonymousClass1.L$9 = null;
                                                    anonymousClass1.I$0 = r6;
                                                    anonymousClass1.I$1 = r5;
                                                    anonymousClass1.I$2 = i3;
                                                    anonymousClass1.label = 8;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                } else {
                                    CoroutineContext.Element element = r1.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE);
                                    element.getClass();
                                    BuildersKt$webSocket$$inlined$body$1 buildersKt$webSocket$$inlined$body$1 = new BuildersKt$webSocket$$inlined$body$1(r1, null, function3);
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$4 = httpStatement;
                                    anonymousClass1.L$5 = r1;
                                    anonymousClass1.I$0 = r13;
                                    anonymousClass1.I$1 = r12;
                                    anonymousClass1.I$2 = i3;
                                    anonymousClass1.label = 2;
                                    objWithContext = AwaitKt.withContext(element, buildersKt$webSocket$$inlined$body$1, anonymousClass1);
                                    if (objWithContext == coroutineSingletons) {
                                        r1 = r1;
                                        r12 = r12;
                                        r13 = r13;
                                    } else {
                                        r7 = r12;
                                        r8 = r13;
                                        r15 = httpStatement;
                                        r16 = r1;
                                        obj3 = objWithContext;
                                        anonymousClass1.L$0 = null;
                                        anonymousClass1.L$1 = null;
                                        anonymousClass1.L$2 = null;
                                        anonymousClass1.L$3 = null;
                                        anonymousClass1.L$4 = null;
                                        anonymousClass1.L$5 = null;
                                        anonymousClass1.L$6 = obj3;
                                        anonymousClass1.L$7 = null;
                                        anonymousClass1.L$8 = null;
                                        anonymousClass1.I$0 = r8;
                                        anonymousClass1.I$1 = r7;
                                        anonymousClass1.I$2 = i3;
                                        anonymousClass1.label = 7;
                                        objCleanup = r15.cleanup(r16, null, anonymousClass1);
                                        r1 = obj3;
                                        r12 = r16;
                                        r13 = r15;
                                        if (objCleanup != coroutineSingletons) {
                                            return unit;
                                        }
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                r25 = r12;
                                r22 = r13;
                                httpStatement2 = httpStatement;
                                r116 = r1;
                                th = th;
                                r5 = r25;
                                r6 = r22;
                                r10 = r116;
                                r11 = httpStatement2;
                                throw th;
                            }
                            break;
                        }
                        return coroutineSingletons;
                    case 1:
                        int i5 = anonymousClass1.I$2;
                        int i6 = anonymousClass1.I$1;
                        int i7 = anonymousClass1.I$0;
                        HttpStatement httpStatement5 = (HttpStatement) anonymousClass1.L$4;
                        function3 = (Function2) anonymousClass1.L$2;
                        ResultKt.throwOnFailure(obj4);
                        httpStatement = httpStatement5;
                        r13 = i7;
                        r12 = i6;
                        i3 = i5;
                        obj = obj4;
                        r1 = (HttpResponse) obj;
                        if (!DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                            CoroutineContext.Element element2 = r1.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE);
                            element2.getClass();
                            BuildersKt$webSocket$$inlined$body$1 buildersKt$webSocket$$inlined$body$2 = new BuildersKt$webSocket$$inlined$body$1(r1, null, function3);
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = httpStatement;
                            anonymousClass1.L$5 = r1;
                            anonymousClass1.I$0 = r13;
                            anonymousClass1.I$1 = r12;
                            anonymousClass1.I$2 = i3;
                            anonymousClass1.label = 2;
                            objWithContext = AwaitKt.withContext(element2, buildersKt$webSocket$$inlined$body$2, anonymousClass1);
                            if (objWithContext == coroutineSingletons) {
                                r1 = r1;
                                r12 = r12;
                                r13 = r13;
                            } else {
                                r7 = r12;
                                r8 = r13;
                                r15 = httpStatement;
                                r16 = r1;
                                obj3 = objWithContext;
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.L$4 = null;
                                anonymousClass1.L$5 = null;
                                anonymousClass1.L$6 = obj3;
                                anonymousClass1.L$7 = null;
                                anonymousClass1.L$8 = null;
                                anonymousClass1.I$0 = r8;
                                anonymousClass1.I$1 = r7;
                                anonymousClass1.I$2 = i3;
                                anonymousClass1.label = 7;
                                objCleanup = r15.cleanup(r16, null, anonymousClass1);
                                r1 = obj3;
                                r12 = r16;
                                r13 = r15;
                                if (objCleanup != coroutineSingletons) {
                                    return unit;
                                }
                            }
                        } else {
                            HttpClientCall call2 = r1.getCall();
                            ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
                            typeReferenceTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
                            TypeInfo typeInfo2 = new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf);
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = function3;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = httpStatement;
                            anonymousClass1.L$5 = r1;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.L$7 = null;
                            anonymousClass1.I$0 = r13;
                            anonymousClass1.I$1 = r12;
                            anonymousClass1.I$2 = i3;
                            anonymousClass1.I$3 = 0;
                            anonymousClass1.label = 3;
                            objBodyNullable = call2.bodyNullable(typeInfo2, anonymousClass1);
                            r1 = r1;
                            r12 = r12;
                            r13 = r13;
                            if (objBodyNullable != coroutineSingletons) {
                                obj2 = objBodyNullable;
                                function4 = function3;
                                r14 = r1;
                                if (obj2 == null) {
                                    r18 = r12;
                                    r17 = r13;
                                    throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                                }
                                r18 = r12;
                                r17 = r13;
                                defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj2;
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.L$4 = httpStatement;
                                anonymousClass1.L$5 = r14;
                                anonymousClass1.L$6 = null;
                                anonymousClass1.L$7 = null;
                                anonymousClass1.L$8 = defaultClientWebSocketSession;
                                anonymousClass1.I$0 = r17;
                                anonymousClass1.I$1 = r18;
                                anonymousClass1.I$2 = i3;
                                anonymousClass1.I$3 = 0;
                                anonymousClass1.label = 4;
                                objInvoke = function4.invoke(defaultClientWebSocketSession, anonymousClass1);
                                r1 = defaultClientWebSocketSession;
                                r12 = r18;
                                r13 = r17;
                                if (objInvoke != coroutineSingletons) {
                                    defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                                    r114 = r18;
                                    r113 = r17;
                                    r112 = r14;
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$4 = httpStatement;
                                    anonymousClass1.L$5 = r112;
                                    anonymousClass1.L$6 = null;
                                    anonymousClass1.L$7 = null;
                                    anonymousClass1.L$8 = defaultClientWebSocketSession3;
                                    anonymousClass1.I$0 = r113;
                                    anonymousClass1.I$1 = r114;
                                    anonymousClass1.I$2 = i3;
                                    anonymousClass1.I$3 = i4;
                                    anonymousClass1.label = 5;
                                    objClose$default = WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, anonymousClass1, 1, null);
                                    r1 = objClose$default;
                                    r12 = r114;
                                    r13 = r113;
                                    if (objClose$default != coroutineSingletons) {
                                        r23 = r114;
                                        r24 = r113;
                                        r115 = r112;
                                        httpStatement3 = httpStatement;
                                        defaultClientWebSocketSession4 = defaultClientWebSocketSession3;
                                        defaultClientWebSocketSession4.getIncoming().cancel((CancellationException) null);
                                        obj3 = unit;
                                        r7 = r23;
                                        r8 = r24;
                                        r16 = r115;
                                        r15 = httpStatement3;
                                        anonymousClass1.L$0 = null;
                                        anonymousClass1.L$1 = null;
                                        anonymousClass1.L$2 = null;
                                        anonymousClass1.L$3 = null;
                                        anonymousClass1.L$4 = null;
                                        anonymousClass1.L$5 = null;
                                        anonymousClass1.L$6 = obj3;
                                        anonymousClass1.L$7 = null;
                                        anonymousClass1.L$8 = null;
                                        anonymousClass1.I$0 = r8;
                                        anonymousClass1.I$1 = r7;
                                        anonymousClass1.I$2 = i3;
                                        anonymousClass1.label = 7;
                                        objCleanup = r15.cleanup(r16, null, anonymousClass1);
                                        r1 = obj3;
                                        r12 = r16;
                                        r13 = r15;
                                        if (objCleanup != coroutineSingletons) {
                                            return unit;
                                        }
                                    }
                                }
                            }
                        }
                        return coroutineSingletons;
                    case 2:
                        i3 = anonymousClass1.I$2;
                        int i8 = anonymousClass1.I$1;
                        int i9 = anonymousClass1.I$0;
                        HttpResponse httpResponse = (HttpResponse) anonymousClass1.L$5;
                        HttpStatement httpStatement6 = (HttpStatement) anonymousClass1.L$4;
                        ResultKt.throwOnFailure(obj4);
                        obj3 = obj4;
                        r7 = i8;
                        r8 = i9;
                        r16 = httpResponse;
                        r15 = httpStatement6;
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.L$6 = obj3;
                        anonymousClass1.L$7 = null;
                        anonymousClass1.L$8 = null;
                        anonymousClass1.I$0 = r8;
                        anonymousClass1.I$1 = r7;
                        anonymousClass1.I$2 = i3;
                        anonymousClass1.label = 7;
                        objCleanup = r15.cleanup(r16, null, anonymousClass1);
                        r1 = obj3;
                        r12 = r16;
                        r13 = r15;
                        if (objCleanup != coroutineSingletons) {
                            return unit;
                        }
                        return coroutineSingletons;
                    case 3:
                        i3 = anonymousClass1.I$2;
                        int i10 = anonymousClass1.I$1;
                        int i11 = anonymousClass1.I$0;
                        HttpResponse httpResponse2 = (HttpResponse) anonymousClass1.L$5;
                        httpStatement = (HttpStatement) anonymousClass1.L$4;
                        Function2 function5 = (Function2) anonymousClass1.L$2;
                        try {
                            ResultKt.throwOnFailure(obj4);
                            function4 = function5;
                            obj2 = obj4;
                            r18 = i10;
                            r17 = i11;
                            r14 = httpResponse2;
                            if (obj2 == null) {
                                r18 = r12;
                                r17 = r13;
                                throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                            }
                            r18 = r12;
                            r17 = r13;
                            defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj2;
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = httpStatement;
                            anonymousClass1.L$5 = r14;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.L$7 = null;
                            anonymousClass1.L$8 = defaultClientWebSocketSession;
                            anonymousClass1.I$0 = r17;
                            anonymousClass1.I$1 = r18;
                            anonymousClass1.I$2 = i3;
                            anonymousClass1.I$3 = 0;
                            anonymousClass1.label = 4;
                            objInvoke = function4.invoke(defaultClientWebSocketSession, anonymousClass1);
                            r1 = defaultClientWebSocketSession;
                            r12 = r18;
                            r13 = r17;
                            if (objInvoke != coroutineSingletons) {
                                defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                                r114 = r18;
                                r113 = r17;
                                r112 = r14;
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.L$4 = httpStatement;
                                anonymousClass1.L$5 = r112;
                                anonymousClass1.L$6 = null;
                                anonymousClass1.L$7 = null;
                                anonymousClass1.L$8 = defaultClientWebSocketSession3;
                                anonymousClass1.I$0 = r113;
                                anonymousClass1.I$1 = r114;
                                anonymousClass1.I$2 = i3;
                                anonymousClass1.I$3 = i4;
                                anonymousClass1.label = 5;
                                objClose$default = WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, anonymousClass1, 1, null);
                                r1 = objClose$default;
                                r12 = r114;
                                r13 = r113;
                                if (objClose$default != coroutineSingletons) {
                                    r23 = r114;
                                    r24 = r113;
                                    r115 = r112;
                                    httpStatement3 = httpStatement;
                                    defaultClientWebSocketSession4 = defaultClientWebSocketSession3;
                                    defaultClientWebSocketSession4.getIncoming().cancel((CancellationException) null);
                                    obj3 = unit;
                                    r7 = r23;
                                    r8 = r24;
                                    r16 = r115;
                                    r15 = httpStatement3;
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$4 = null;
                                    anonymousClass1.L$5 = null;
                                    anonymousClass1.L$6 = obj3;
                                    anonymousClass1.L$7 = null;
                                    anonymousClass1.L$8 = null;
                                    anonymousClass1.I$0 = r8;
                                    anonymousClass1.I$1 = r7;
                                    anonymousClass1.I$2 = i3;
                                    anonymousClass1.label = 7;
                                    objCleanup = r15.cleanup(r16, null, anonymousClass1);
                                    r1 = obj3;
                                    r12 = r16;
                                    r13 = r15;
                                    if (objCleanup != coroutineSingletons) {
                                        return unit;
                                    }
                                }
                            }
                            return coroutineSingletons;
                        } catch (Throwable th6) {
                            th = th6;
                            r20 = i10;
                            r21 = i11;
                            r110 = httpResponse2;
                            r11 = httpStatement;
                            r5 = r20;
                            r6 = r21;
                            r10 = r110;
                            throw th;
                        }
                    case 4:
                        i4 = anonymousClass1.I$3;
                        i3 = anonymousClass1.I$2;
                        int i12 = anonymousClass1.I$1;
                        int i13 = anonymousClass1.I$0;
                        DefaultClientWebSocketSession defaultClientWebSocketSession6 = (DefaultClientWebSocketSession) anonymousClass1.L$8;
                        HttpResponse httpResponse3 = (HttpResponse) anonymousClass1.L$5;
                        HttpStatement httpStatement7 = (HttpStatement) anonymousClass1.L$4;
                        try {
                            ResultKt.throwOnFailure(obj4);
                            defaultClientWebSocketSession3 = defaultClientWebSocketSession6;
                            r112 = httpResponse3;
                            httpStatement = httpStatement7;
                            r114 = i12;
                            r113 = i13;
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = httpStatement;
                            anonymousClass1.L$5 = r112;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.L$7 = null;
                            anonymousClass1.L$8 = defaultClientWebSocketSession3;
                            anonymousClass1.I$0 = r113;
                            anonymousClass1.I$1 = r114;
                            anonymousClass1.I$2 = i3;
                            anonymousClass1.I$3 = i4;
                            anonymousClass1.label = 5;
                            objClose$default = WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, anonymousClass1, 1, null);
                            r1 = objClose$default;
                            r12 = r114;
                            r13 = r113;
                            if (objClose$default != coroutineSingletons) {
                                r23 = r114;
                                r24 = r113;
                                r115 = r112;
                                httpStatement3 = httpStatement;
                                defaultClientWebSocketSession4 = defaultClientWebSocketSession3;
                                defaultClientWebSocketSession4.getIncoming().cancel((CancellationException) null);
                                obj3 = unit;
                                r7 = r23;
                                r8 = r24;
                                r16 = r115;
                                r15 = httpStatement3;
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.L$4 = null;
                                anonymousClass1.L$5 = null;
                                anonymousClass1.L$6 = obj3;
                                anonymousClass1.L$7 = null;
                                anonymousClass1.L$8 = null;
                                anonymousClass1.I$0 = r8;
                                anonymousClass1.I$1 = r7;
                                anonymousClass1.I$2 = i3;
                                anonymousClass1.label = 7;
                                objCleanup = r15.cleanup(r16, null, anonymousClass1);
                                r1 = obj3;
                                r12 = r16;
                                r13 = r15;
                                if (objCleanup != coroutineSingletons) {
                                    return unit;
                                }
                            }
                            break;
                        } catch (Throwable th7) {
                            th = th7;
                            i = i4;
                            r9 = i12;
                            defaultClientWebSocketSession2 = defaultClientWebSocketSession6;
                            r19 = httpResponse3;
                            httpStatement = httpStatement7;
                            r111 = i13;
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = httpStatement;
                            anonymousClass1.L$5 = r19;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.L$7 = null;
                            anonymousClass1.L$8 = defaultClientWebSocketSession2;
                            anonymousClass1.L$9 = th;
                            anonymousClass1.I$0 = r111;
                            anonymousClass1.I$1 = r9;
                            anonymousClass1.I$2 = i3;
                            anonymousClass1.I$3 = i;
                            anonymousClass1.label = 6;
                            if (WebSocketSessionKt.close$default(defaultClientWebSocketSession2, null, anonymousClass1, 1, null) != coroutineSingletons) {
                                r22 = r111;
                                httpStatement2 = httpStatement;
                                r25 = r9;
                                defaultClientWebSocketSession5 = defaultClientWebSocketSession2;
                                r116 = r19;
                                defaultClientWebSocketSession5.getIncoming().cancel((CancellationException) null);
                                throw th;
                            }
                        }
                        return coroutineSingletons;
                    case 5:
                        i3 = anonymousClass1.I$2;
                        int i14 = anonymousClass1.I$1;
                        int i15 = anonymousClass1.I$0;
                        DefaultClientWebSocketSession defaultClientWebSocketSession7 = (DefaultClientWebSocketSession) anonymousClass1.L$8;
                        HttpResponse httpResponse4 = (HttpResponse) anonymousClass1.L$5;
                        HttpStatement httpStatement8 = (HttpStatement) anonymousClass1.L$4;
                        ResultKt.throwOnFailure(obj4);
                        defaultClientWebSocketSession4 = defaultClientWebSocketSession7;
                        r23 = i14;
                        r24 = i15;
                        r115 = httpResponse4;
                        httpStatement3 = httpStatement8;
                        defaultClientWebSocketSession4.getIncoming().cancel((CancellationException) null);
                        obj3 = unit;
                        r7 = r23;
                        r8 = r24;
                        r16 = r115;
                        r15 = httpStatement3;
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.L$6 = obj3;
                        anonymousClass1.L$7 = null;
                        anonymousClass1.L$8 = null;
                        anonymousClass1.I$0 = r8;
                        anonymousClass1.I$1 = r7;
                        anonymousClass1.I$2 = i3;
                        anonymousClass1.label = 7;
                        objCleanup = r15.cleanup(r16, null, anonymousClass1);
                        r1 = obj3;
                        r12 = r16;
                        r13 = r15;
                        if (objCleanup != coroutineSingletons) {
                            return unit;
                        }
                        return coroutineSingletons;
                    case 6:
                        i3 = anonymousClass1.I$2;
                        r25 = anonymousClass1.I$1;
                        r22 = anonymousClass1.I$0;
                        th = (Throwable) anonymousClass1.L$9;
                        DefaultClientWebSocketSession defaultClientWebSocketSession8 = (DefaultClientWebSocketSession) anonymousClass1.L$8;
                        r116 = (HttpResponse) anonymousClass1.L$5;
                        httpStatement2 = (HttpStatement) anonymousClass1.L$4;
                        try {
                            ResultKt.throwOnFailure(obj4);
                            r25 = r25;
                            r22 = r22;
                            defaultClientWebSocketSession5 = defaultClientWebSocketSession8;
                            r116 = r116;
                            httpStatement2 = httpStatement2;
                            defaultClientWebSocketSession5.getIncoming().cancel((CancellationException) null);
                            throw th;
                        } catch (Throwable th8) {
                            th = th8;
                            th = th;
                            r5 = r25;
                            r6 = r22;
                            r10 = r116;
                            r11 = httpStatement2;
                            throw th;
                        }
                    case 7:
                        ResultKt.throwOnFailure(obj4);
                        return unit;
                    case 8:
                        th = (Throwable) anonymousClass1.L$7;
                        ResultKt.throwOnFailure(obj4);
                        throw th;
                    default:
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (CancellationException e) {
                throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
            }
        } catch (Throwable th9) {
            th = th9;
            r5 = 1;
            r6 = 0;
        }
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.Get;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 23);
        }
        Function1 function3 = function1;
        return webSocket(httpClient, httpMethod, str, num, str2, function3, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$0$0(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
        uRLBuilder.getClass();
        uRLBuilder2.getClass();
        uRLBuilder.setProtocol(URLProtocol.INSTANCE.getWS());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$2(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$3(HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url$default(httpRequestBuilder, "ws", str, num, str2, null, 16, null);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$4(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$5(String str, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.getUrl().setProtocol(URLProtocol.INSTANCE.getWS());
        httpRequestBuilder.getUrl().setPort(UtilsKt.getPort(httpRequestBuilder));
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    public static final Object webSocketSession(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.url(new HttpParserKt$$ExternalSyntheticLambda0((byte) 9));
        function1.invoke(httpRequestBuilder);
        AwaitKt.launch$default(httpClient, null, null, new AnonymousClass2(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredImplCompletableDeferred$default, null), 3);
        return completableDeferredImplCompletableDeferred$default.awaitInternal(continuation);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.Get;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 1);
        }
        return webSocketSession(httpClient, httpMethod, str, num, str2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$0$0(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
        uRLBuilder.getClass();
        uRLBuilder2.getClass();
        uRLBuilder.setProtocol(URLProtocol.INSTANCE.getWS());
        uRLBuilder.setPort(uRLBuilder.getProtocol().getDefaultPort());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$2(HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url$default(httpRequestBuilder, "ws", str, num, str2, null, 16, null);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$3(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$4(String str, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, httpMethod, str, num, str2, function1, function2, continuation);
        return objWebSocket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.Get;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 26);
        }
        Function1 function3 = function1;
        return ws(httpClient, httpMethod, str, num, str2, function3, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ws$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ws$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 25), function2, continuation);
        return objWebSocket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.Get;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 25);
        }
        Function1 function3 = function1;
        return wss(httpClient, httpMethod, str, num, str2, function3, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$0(Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
        httpRequestBuilder.getUrl().setPort(httpRequestBuilder.getUrl().getProtocol().getDefaultPort());
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$2(String str, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$3(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$4(Integer num, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
        if (num != null) {
            httpRequestBuilder.getUrl().setPort(num.intValue());
        }
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, function1, function2, continuation);
        return objWebSocket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, str, function1, function2, continuation);
        return objWebSocket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        Object objWss = wss(httpClient, new BuildersKt$$ExternalSyntheticLambda1((byte) 5, str, function1), function2, continuation);
        return objWss == CoroutineSingletons.COROUTINE_SUSPENDED ? objWss : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, httpMethod, str, num, str2, new FileChannelsKt$$ExternalSyntheticLambda1(num, function1, (byte) 6), function2, continuation);
        return objWebSocket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 27);
        }
        return webSocketSession(httpClient, str, function1, continuation);
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 28);
        }
        return webSocket(httpClient, str, function1, function2, continuation);
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 29);
        }
        return ws(httpClient, str, function1, function2, continuation);
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 24);
        }
        return wss(httpClient, str, function1, function2, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Continuation continuation) {
        return webSocketSession(httpClient, new BuildersKt$$ExternalSyntheticLambda0(httpMethod, str, num, str2, function1, (byte) 0), continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        return webSocketSession(httpClient, new BuildersKt$$ExternalSyntheticLambda1((byte) 6, str, function1), continuation);
    }

    public static final Object webSocket(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, new BuildersKt$$ExternalSyntheticLambda0(httpMethod, str, num, str2, function1, (byte) 1), function2, continuation);
        return objWebSocket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object webSocket(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, HttpMethod.Get, null, null, null, new BuildersKt$$ExternalSyntheticLambda1((byte) 4, str, function1), function2, continuation);
        return objWebSocket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWebSocket : Unit.INSTANCE;
    }
}
