package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
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
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/client/statement/HttpStatement$body$4$1"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1", f = "builders.kt", l = {250, 273}, m = "invokeSuspend", v = 1)
public final class BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ HttpResponse $response;
    final /* synthetic */ CompletableDeferred $sessionDeferred$inlined;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1(HttpResponse httpResponse, Continuation continuation, CompletableDeferred completableDeferred) {
        super(2, continuation);
        this.$response = httpResponse;
        this.$sessionDeferred$inlined = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1(this.$response, continuation, this.$sessionDeferred$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BuildersKt$webSocketSession$2$invokeSuspend$$inlined$body$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
    
        if (r0.awaitInternal(r8) == r5) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TypeReference typeReferenceTypeOf;
        int i = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
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
        if (obj == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
            return null;
        }
        DefaultClientWebSocketSession defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj;
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
        ((CompletableDeferredImpl) this.$sessionDeferred$inlined).makeCompleting$kotlinx_coroutines_core(defaultClientWebSocketSession);
        defaultClientWebSocketSession.getOutgoing().invokeOnClose(new BuildersKt$webSocketSession$2$1$1(completableDeferredImplCompletableDeferred$default));
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.I$0 = 0;
        this.label = 2;
    }
}
