package kotlinx.coroutines.selects;

import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements Function3 {
    public static final OnTimeout$selectClause$1 INSTANCE = new OnTimeout$selectClause$1(3, OnTimeout.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        OnTimeout onTimeout = (OnTimeout) obj;
        SelectImplementation selectImplementation = (SelectImplementation) obj2;
        long j = onTimeout.timeMillis;
        Unit unit = Unit.INSTANCE;
        if (j <= 0) {
            selectImplementation.internalResult = unit;
            return unit;
        }
        TransactionExecutor$$ExternalSyntheticLambda0 transactionExecutor$$ExternalSyntheticLambda0 = new TransactionExecutor$$ExternalSyntheticLambda0(selectImplementation, onTimeout, (byte) 18);
        selectImplementation.getClass();
        CoroutineContext coroutineContext = selectImplementation.context;
        selectImplementation.disposableHandleOrSegment = AwaitKt.getDelay(coroutineContext).invokeOnTimeout(j, transactionExecutor$$ExternalSyntheticLambda0, coroutineContext);
        return unit;
    }
}
