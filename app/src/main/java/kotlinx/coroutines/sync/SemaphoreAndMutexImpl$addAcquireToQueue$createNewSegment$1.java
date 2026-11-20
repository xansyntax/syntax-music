package kotlinx.coroutines.sync;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2 {
    public static final SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 INSTANCE = new SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = SemaphoreKt.MAX_SPIN_CYCLES;
        return new SemaphoreSegment(((Number) obj).longValue(), (SemaphoreSegment) obj2, 0);
    }
}
