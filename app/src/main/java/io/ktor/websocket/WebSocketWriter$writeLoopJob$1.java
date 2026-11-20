package io.ktor.websocket;

import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter$writeLoopJob$1", f = "WebSocketWriter.kt", l = {55}, m = "invokeSuspend", v = 1)
public final class WebSocketWriter$writeLoopJob$1 extends SuspendLambda implements Function2 {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WebSocketWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketWriter$writeLoopJob$1(WebSocketWriter webSocketWriter, Continuation continuation) {
        super(2, continuation);
        this.this$0 = webSocketWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WebSocketWriter$writeLoopJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WebSocketWriter$writeLoopJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        ObjectPool objectPool;
        Object obj2;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            obj2 = this.L$1;
            objectPool = (ObjectPool) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                objectPool.recycle(obj2);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                objectPool.recycle(obj2);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        ObjectPool<ByteBuffer> pool = this.this$0.getPool();
        WebSocketWriter webSocketWriter = this.this$0;
        ByteBuffer byteBufferBorrow = pool.borrow();
        try {
            this.L$0 = pool;
            this.L$1 = byteBufferBorrow;
            this.L$2 = null;
            this.I$0 = 0;
            this.I$1 = 0;
            this.label = 1;
            Object objWriteLoop = webSocketWriter.writeLoop(byteBufferBorrow, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWriteLoop == coroutineSingletons) {
                return coroutineSingletons;
            }
            objectPool = pool;
            obj2 = byteBufferBorrow;
            objectPool.recycle(obj2);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            objectPool = pool;
            obj2 = byteBufferBorrow;
            objectPool.recycle(obj2);
            throw th;
        }
    }
}
