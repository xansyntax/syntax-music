package io.ktor.websocket;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/websocket/CloseReason;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1", f = "DefaultWebSocketSession.kt", l = {388}, m = "invokeSuspend", v = 1)
public final class DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1 extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1 defaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1 = new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this.this$0, continuation);
        defaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1.L$0 = obj;
        return defaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CloseReason closeReason, Continuation continuation) {
        return ((DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1) create(closeReason, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CloseReason closeReason = (CloseReason) this.L$0;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DefaultWebSocketSessionImpl defaultWebSocketSessionImpl = this.this$0;
            IOException iOException = new IOException("Ping timeout");
            this.L$0 = null;
            this.label = 1;
            Object objSendCloseSequence = defaultWebSocketSessionImpl.sendCloseSequence(closeReason, iOException, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objSendCloseSequence == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
