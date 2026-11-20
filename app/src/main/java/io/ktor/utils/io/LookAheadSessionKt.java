package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a8\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\t\u001a\u00020\u0004*\u00020\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0086@¢\u0006\u0004\b\t\u0010\b*\n\u0010\n\"\u00020\u00022\u00020\u0002¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "", "block", "lookAhead", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookAheadSuspend", "LookAheadSession", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LookAheadSessionKt {
    public static final Object lookAhead(ByteReadChannel byteReadChannel, Function2 function2, Continuation continuation) {
        Object objInvoke = function2.invoke(new LookAheadSuspendSession(byteReadChannel), continuation);
        return objInvoke == CoroutineSingletons.COROUTINE_SUSPENDED ? objInvoke : Unit.INSTANCE;
    }

    public static final Object lookAheadSuspend(ByteReadChannel byteReadChannel, Function2 function2, Continuation continuation) {
        Object objInvoke = function2.invoke(new LookAheadSuspendSession(byteReadChannel), continuation);
        return objInvoke == CoroutineSingletons.COROUTINE_SUSPENDED ? objInvoke : Unit.INSTANCE;
    }
}
