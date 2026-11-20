package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketSessionKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/client/statement/HttpStatement$body$4$1"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocket$$inlined$body$1", f = "builders.kt", l = {250, 265, 267, 267}, m = "invokeSuspend", v = 1)
public final class BuildersKt$webSocket$$inlined$body$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $block$inlined;
    final /* synthetic */ HttpResponse $response;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$webSocket$$inlined$body$1(HttpResponse httpResponse, Continuation continuation, Function2 function2) {
        super(2, continuation);
        this.$response = httpResponse;
        this.$block$inlined = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BuildersKt$webSocket$$inlined$body$1(this.$response, continuation, this.$block$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BuildersKt$webSocket$$inlined$body$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00cd  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ac, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r0, null, r11, 1, null) == r7) goto L39;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        TypeReference typeReferenceTypeOf;
        DefaultClientWebSocketSession defaultClientWebSocketSession;
        DefaultClientWebSocketSession defaultClientWebSocketSession2;
        DefaultClientWebSocketSession defaultClientWebSocketSession3;
        int i = this.label;
        int i2 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpClientCall call = this.$response.getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
            try {
                typeReferenceTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            this.L$0 = null;
            this.I$0 = 0;
            this.label = 1;
            obj = call.bodyNullable(typeInfo, this);
            if (obj != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i != 1) {
            if (i == 2) {
                i2 = this.I$0;
                defaultClientWebSocketSession2 = (DefaultClientWebSocketSession) this.L$2;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = defaultClientWebSocketSession2;
                    this.I$0 = i2;
                    this.label = 3;
                } catch (Throwable th) {
                    th = th;
                    defaultClientWebSocketSession = defaultClientWebSocketSession2;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = defaultClientWebSocketSession;
                    this.L$3 = th;
                    this.I$0 = i2;
                    this.label = 4;
                    if (WebSocketSessionKt.close$default(defaultClientWebSocketSession, null, this, 1, null) != coroutineSingletons) {
                        defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                        defaultClientWebSocketSession3.getIncoming().cancel((CancellationException) null);
                        throw th;
                    }
                }
            } else {
                if (i != 3) {
                    if (i != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    th = (Throwable) this.L$3;
                    defaultClientWebSocketSession3 = (DefaultClientWebSocketSession) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    defaultClientWebSocketSession3.getIncoming().cancel((CancellationException) null);
                    throw th;
                }
                defaultClientWebSocketSession2 = (DefaultClientWebSocketSession) this.L$2;
                ResultKt.throwOnFailure(obj);
            }
            defaultClientWebSocketSession2.getIncoming().cancel((CancellationException) null);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (obj == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
            return null;
        }
        defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj;
        try {
            Function2 function2 = this.$block$inlined;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = defaultClientWebSocketSession;
            this.I$0 = 0;
            this.label = 2;
            if (function2.invoke(defaultClientWebSocketSession, this) != coroutineSingletons) {
                defaultClientWebSocketSession2 = defaultClientWebSocketSession;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = defaultClientWebSocketSession2;
                this.I$0 = i2;
                this.label = 3;
            }
        } catch (Throwable th2) {
            th = th2;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = defaultClientWebSocketSession;
            this.L$3 = th;
            this.I$0 = i2;
            this.label = 4;
            if (WebSocketSessionKt.close$default(defaultClientWebSocketSession, null, this, 1, null) != coroutineSingletons) {
                defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                defaultClientWebSocketSession3.getIncoming().cancel((CancellationException) null);
                throw th;
            }
        }
        return coroutineSingletons;
    }
}
