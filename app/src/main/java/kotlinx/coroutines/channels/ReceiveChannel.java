package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface ReceiveChannel {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;
        public final /* synthetic */ Channel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, Continuation continuation) {
            super(continuation);
            this.this$0 = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReceiveChannel.receiveOrNull$suspendImpl(this.this$0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    static Object receiveOrNull$suspendImpl(Channel channel, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object objMo1860receiveCatchingJP2dKIU;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(channel, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(channel, continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.label = 1;
            objMo1860receiveCatchingJP2dKIU = channel.mo1860receiveCatchingJP2dKIU(anonymousClass1);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objMo1860receiveCatchingJP2dKIU == obj2) {
                return obj2;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objMo1860receiveCatchingJP2dKIU = ((ChannelResult) obj).holder;
        }
        return ChannelResult.m1903getOrNullimpl(objMo1860receiveCatchingJP2dKIU);
    }

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    SelectClause1 getOnReceive();

    SelectClause1 getOnReceiveCatching();

    SelectClause1 getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    ChannelIterator iterator();

    default Object poll() throws Throwable {
        Object objMo1861tryReceivePtdJZtk = mo1861tryReceivePtdJZtk();
        boolean z = objMo1861tryReceivePtdJZtk instanceof ChannelResult.Failed;
        if (z) {
            Throwable thM1902exceptionOrNullimpl = ChannelResult.m1902exceptionOrNullimpl(objMo1861tryReceivePtdJZtk);
            if (thM1902exceptionOrNullimpl == null) {
                return null;
            }
            int i = StackTraceRecoveryKt.$r8$clinit;
            throw thM1902exceptionOrNullimpl;
        }
        if (!z) {
            return objMo1861tryReceivePtdJZtk;
        }
        if (!(objMo1861tryReceivePtdJZtk instanceof ChannelResult.Closed)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Trying to call 'getOrThrow' on a failed result of a non-closed channel");
            return null;
        }
        Throwable th = ((ChannelResult.Closed) objMo1861tryReceivePtdJZtk).cause;
        if (th != null) {
            throw th;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Trying to call 'getOrThrow' on a channel closed without a cause");
        return null;
    }

    Object receive(Continuation continuation);

    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    Object mo1860receiveCatchingJP2dKIU(Continuation continuation);

    default Object receiveOrNull(Continuation continuation) {
        return receiveOrNull$suspendImpl((Channel) this, continuation);
    }

    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    Object mo1861tryReceivePtdJZtk();
}
