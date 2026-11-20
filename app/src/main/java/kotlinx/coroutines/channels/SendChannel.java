package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface SendChannel {
    boolean close(Throwable th);

    SelectClause2 getOnSend();

    void invokeOnClose(Function1 function1);

    boolean isClosedForSend();

    default boolean offer(Object obj) throws Throwable {
        Object objMo1712trySendJP2dKIU = mo1712trySendJP2dKIU(obj);
        if (!(objMo1712trySendJP2dKIU instanceof ChannelResult.Failed)) {
            return true;
        }
        Throwable thM1902exceptionOrNullimpl = ChannelResult.m1902exceptionOrNullimpl(objMo1712trySendJP2dKIU);
        if (thM1902exceptionOrNullimpl == null) {
            return false;
        }
        int i = StackTraceRecoveryKt.$r8$clinit;
        throw thM1902exceptionOrNullimpl;
    }

    Object send(Object obj, Continuation continuation);

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    Object mo1712trySendJP2dKIU(Object obj);
}
