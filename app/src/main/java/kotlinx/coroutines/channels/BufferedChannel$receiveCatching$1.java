package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class BufferedChannel$receiveCatching$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BufferedChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel bufferedChannel, Continuation continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM1900receiveCatchingJP2dKIU$suspendImpl = BufferedChannel.m1900receiveCatchingJP2dKIU$suspendImpl(this.this$0, this);
        return objM1900receiveCatchingJP2dKIU$suspendImpl == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1900receiveCatchingJP2dKIU$suspendImpl : new ChannelResult(objM1900receiveCatchingJP2dKIU$suspendImpl);
    }
}
