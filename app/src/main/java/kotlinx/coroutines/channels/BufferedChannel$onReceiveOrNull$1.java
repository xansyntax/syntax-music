package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class BufferedChannel$onReceiveOrNull$1 extends FunctionReferenceImpl implements Function3 {
    public static final BufferedChannel$onReceiveOrNull$1 INSTANCE = new BufferedChannel$onReceiveOrNull$1(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = BufferedChannel.sendersAndCloseStatus$volatile$FU;
        ((BufferedChannel) obj).registerSelectForReceive((SelectImplementation) obj2);
        return Unit.INSTANCE;
    }
}
