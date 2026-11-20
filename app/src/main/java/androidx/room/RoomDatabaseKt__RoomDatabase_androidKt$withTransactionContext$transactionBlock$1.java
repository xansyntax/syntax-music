package androidx.room;

import androidx.room.coroutines.PooledConnectionImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(this.$block, continuation);
                roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1.L$0 = obj;
                return roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
            case 1:
                RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$2 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1((byte) 1, continuation, this.$block);
                roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$2.L$0 = obj;
                return roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$2;
            default:
                RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$3 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1((byte) 2, continuation, this.$block);
                roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$3.L$0 = obj;
                return roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) create((PooledConnectionImpl.TransactionImpl) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) create((PooledConnectionImpl.TransactionImpl) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Function1 function1 = this.$block;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    if (((CoroutineScope) this.L$0).getCoroutineContext().get(TransactionElement.Key) != null) {
                        this.label = true;
                        Object objInvoke = function1.invoke(this);
                        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Expected a TransactionElement in the CoroutineContext but none was found.");
                } else {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                }
                return null;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.label = true;
                Object objInvoke2 = function1.invoke(this);
                return objInvoke2 == coroutineSingletons ? coroutineSingletons : objInvoke2;
            default:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.label = true;
                Object objInvoke3 = function1.invoke(this);
                return objInvoke3 == coroutineSingletons ? coroutineSingletons : objInvoke3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(byte b, Continuation continuation, Function1 function1) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$block = function1;
    }
}
