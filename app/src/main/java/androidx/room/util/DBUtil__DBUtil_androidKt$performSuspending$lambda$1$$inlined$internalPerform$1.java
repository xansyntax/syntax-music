package androidx.room.util;

import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import androidx.room.coroutines.PooledConnectionImpl;
import androidx.room.coroutines.RawConnectionAccessor;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function1 $block$inlined;
    public final /* synthetic */ boolean $inTransaction;
    public final /* synthetic */ boolean $isReadOnly;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ RoomDatabase $this_internalPerform;
    public /* synthetic */ Object L$0;
    public Transactor.SQLiteTransactionType L$1;
    public byte label;

    /* JADX INFO: renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Function1 $block$inlined;
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object L$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(byte b, Continuation continuation, Function1 function1) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$block$inlined = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Function1 function1 = this.$block$inlined;
            switch (b) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1((byte) 0, continuation, function1);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                default:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1((byte) 1, continuation, function1);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            PooledConnectionImpl.TransactionImpl transactionImpl = (PooledConnectionImpl.TransactionImpl) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
            }
            return ((AnonymousClass1) create(transactionImpl, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Function1 function1 = this.$block$inlined;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    PooledConnectionImpl.TransactionImpl transactionImpl = (PooledConnectionImpl.TransactionImpl) this.L$0;
                    transactionImpl.getClass();
                    return function1.invoke(transactionImpl.getRawConnection());
                default:
                    ResultKt.throwOnFailure(obj);
                    PooledConnectionImpl.TransactionImpl transactionImpl2 = (PooledConnectionImpl.TransactionImpl) this.L$0;
                    transactionImpl2.getClass();
                    return function1.invoke(transactionImpl2.getRawConnection());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(boolean z, boolean z2, RoomDatabase roomDatabase, Continuation continuation, Function1 function1, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$inTransaction = z;
        this.$isReadOnly = z2;
        this.$this_internalPerform = roomDatabase;
        this.$block$inlined = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, continuation, this.$block$inlined, (byte) 0);
                dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1.L$0 = obj;
                return dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1;
            default:
                DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$2 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, continuation, this.$block$inlined, (byte) 1);
                dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$2.L$0 = obj;
                return dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Transactor transactor = (Transactor) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1) create(transactor, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:74:0x0161  */
    /* JADX WARN: Code duplicated, block: B:77:0x016c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0175  */
    /* JADX WARN: Code duplicated, block: B:81:0x017d  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Transactor transactor;
        Object objInTransaction;
        Transactor transactor2;
        Transactor.SQLiteTransactionType sQLiteTransactionType;
        Object objWithTransaction;
        Object objInTransaction2;
        Object obj2;
        Transactor transactor3;
        Object objInTransaction3;
        Transactor transactor4;
        Transactor.SQLiteTransactionType sQLiteTransactionType2;
        Object objWithTransaction2;
        Object objInTransaction4;
        Object obj3;
        byte b = this.$r8$classId;
        Transactor.SQLiteTransactionType sQLiteTransactionType3 = Transactor.SQLiteTransactionType.IMMEDIATE;
        Transactor.SQLiteTransactionType sQLiteTransactionType4 = Transactor.SQLiteTransactionType.DEFERRED;
        boolean z = this.$inTransaction;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        boolean z2 = this.$isReadOnly;
        RoomDatabase roomDatabase = this.$this_internalPerform;
        Function1 function1 = this.$block$inlined;
        byte b2 = 1;
        Continuation continuation = null;
        switch (b) {
            case 0:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    transactor = (Transactor) this.L$0;
                    if (!z) {
                        transactor.getClass();
                        return function1.invoke(((RawConnectionAccessor) transactor).getRawConnection());
                    }
                    if (z2) {
                        sQLiteTransactionType3 = sQLiteTransactionType4;
                    }
                    if (!z2) {
                        this.L$0 = transactor;
                        this.L$1 = sQLiteTransactionType3;
                        this.label = (byte) 1;
                        objInTransaction = transactor.inTransaction(this);
                        if (objInTransaction == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        Transactor.SQLiteTransactionType sQLiteTransactionType5 = sQLiteTransactionType3;
                        transactor2 = transactor;
                        sQLiteTransactionType = sQLiteTransactionType5;
                    }
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1((byte) 0, continuation, function1);
                    this.L$0 = transactor;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    objWithTransaction = transactor.withTransaction(sQLiteTransactionType3, anonymousClass1, this);
                    if (objWithTransaction == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (!z2) {
                        return objWithTransaction;
                    }
                    this.L$0 = objWithTransaction;
                    this.label = (byte) 4;
                    objInTransaction2 = transactor.inTransaction(this);
                    if (objInTransaction2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj2 = objWithTransaction;
                    if (((Boolean) objInTransaction2).booleanValue()) {
                        return obj2;
                    }
                    roomDatabase.getInvalidationTracker().refreshAsync();
                    return obj2;
                }
                if (b3 == 1) {
                    sQLiteTransactionType = this.L$1;
                    transactor2 = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objInTransaction = obj;
                } else if (b3 == 2) {
                    sQLiteTransactionType = this.L$1;
                    transactor2 = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Transactor transactor5 = transactor2;
                    sQLiteTransactionType3 = sQLiteTransactionType;
                    transactor = transactor5;
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1((byte) 0, continuation, function1);
                    this.L$0 = transactor;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    objWithTransaction = transactor.withTransaction(sQLiteTransactionType3, anonymousClass2, this);
                    if (objWithTransaction == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (!z2) {
                        return objWithTransaction;
                    }
                    this.L$0 = objWithTransaction;
                    this.label = (byte) 4;
                    objInTransaction2 = transactor.inTransaction(this);
                    if (objInTransaction2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj2 = objWithTransaction;
                } else if (b3 == 3) {
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objWithTransaction = obj;
                    if (!z2) {
                        return objWithTransaction;
                    }
                    this.L$0 = objWithTransaction;
                    this.label = (byte) 4;
                    objInTransaction2 = transactor.inTransaction(this);
                    if (objInTransaction2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj2 = objWithTransaction;
                } else {
                    if (b3 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Object obj4 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj4;
                    objInTransaction2 = obj;
                }
                if (((Boolean) objInTransaction2).booleanValue()) {
                    return obj2;
                }
                roomDatabase.getInvalidationTracker().refreshAsync();
                return obj2;
                if (!((Boolean) objInTransaction).booleanValue()) {
                    InvalidationTracker invalidationTracker = roomDatabase.getInvalidationTracker();
                    this.L$0 = transactor2;
                    this.L$1 = sQLiteTransactionType;
                    this.label = (byte) 2;
                    if (invalidationTracker.sync$room_runtime(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Transactor transactor6 = transactor2;
                sQLiteTransactionType3 = sQLiteTransactionType;
                transactor = transactor6;
                AnonymousClass1 anonymousClass3 = new AnonymousClass1((byte) 0, continuation, function1);
                this.L$0 = transactor;
                this.L$1 = null;
                this.label = (byte) 3;
                objWithTransaction = transactor.withTransaction(sQLiteTransactionType3, anonymousClass3, this);
                if (objWithTransaction == coroutineSingletons) {
                    return coroutineSingletons;
                }
                if (!z2) {
                    return objWithTransaction;
                }
                this.L$0 = objWithTransaction;
                this.label = (byte) 4;
                objInTransaction2 = transactor.inTransaction(this);
                if (objInTransaction2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                obj2 = objWithTransaction;
                if (((Boolean) objInTransaction2).booleanValue()) {
                    return obj2;
                }
                roomDatabase.getInvalidationTracker().refreshAsync();
                return obj2;
            default:
                byte b4 = this.label;
                if (b4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    transactor3 = (Transactor) this.L$0;
                    if (!z) {
                        transactor3.getClass();
                        return function1.invoke(((RawConnectionAccessor) transactor3).getRawConnection());
                    }
                    if (z2) {
                        sQLiteTransactionType3 = sQLiteTransactionType4;
                    }
                    if (!z2) {
                        this.L$0 = transactor3;
                        this.L$1 = sQLiteTransactionType3;
                        this.label = (byte) 1;
                        objInTransaction3 = transactor3.inTransaction(this);
                        if (objInTransaction3 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        Transactor.SQLiteTransactionType sQLiteTransactionType6 = sQLiteTransactionType3;
                        transactor4 = transactor3;
                        sQLiteTransactionType2 = sQLiteTransactionType6;
                    }
                    AnonymousClass1 anonymousClass4 = new AnonymousClass1(b2, continuation, function1);
                    this.L$0 = transactor3;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    objWithTransaction2 = transactor3.withTransaction(sQLiteTransactionType3, anonymousClass4, this);
                    if (objWithTransaction2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (!z2) {
                        return objWithTransaction2;
                    }
                    this.L$0 = objWithTransaction2;
                    this.label = (byte) 4;
                    objInTransaction4 = transactor3.inTransaction(this);
                    if (objInTransaction4 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj3 = objWithTransaction2;
                    if (((Boolean) objInTransaction4).booleanValue()) {
                        return obj3;
                    }
                    roomDatabase.getInvalidationTracker().refreshAsync();
                    return obj3;
                }
                if (b4 == 1) {
                    sQLiteTransactionType2 = this.L$1;
                    transactor4 = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objInTransaction3 = obj;
                } else if (b4 == 2) {
                    sQLiteTransactionType2 = this.L$1;
                    transactor4 = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Transactor transactor7 = transactor4;
                    sQLiteTransactionType3 = sQLiteTransactionType2;
                    transactor3 = transactor7;
                    AnonymousClass1 anonymousClass5 = new AnonymousClass1(b2, continuation, function1);
                    this.L$0 = transactor3;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    objWithTransaction2 = transactor3.withTransaction(sQLiteTransactionType3, anonymousClass5, this);
                    if (objWithTransaction2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (!z2) {
                        return objWithTransaction2;
                    }
                    this.L$0 = objWithTransaction2;
                    this.label = (byte) 4;
                    objInTransaction4 = transactor3.inTransaction(this);
                    if (objInTransaction4 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj3 = objWithTransaction2;
                } else if (b4 == 3) {
                    transactor3 = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objWithTransaction2 = obj;
                    if (!z2) {
                        return objWithTransaction2;
                    }
                    this.L$0 = objWithTransaction2;
                    this.label = (byte) 4;
                    objInTransaction4 = transactor3.inTransaction(this);
                    if (objInTransaction4 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj3 = objWithTransaction2;
                } else {
                    if (b4 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Object obj5 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj3 = obj5;
                    objInTransaction4 = obj;
                }
                if (((Boolean) objInTransaction4).booleanValue()) {
                    return obj3;
                }
                roomDatabase.getInvalidationTracker().refreshAsync();
                return obj3;
                if (!((Boolean) objInTransaction3).booleanValue()) {
                    InvalidationTracker invalidationTracker2 = roomDatabase.getInvalidationTracker();
                    this.L$0 = transactor4;
                    this.L$1 = sQLiteTransactionType2;
                    this.label = (byte) 2;
                    if (invalidationTracker2.sync$room_runtime(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Transactor transactor8 = transactor4;
                sQLiteTransactionType3 = sQLiteTransactionType2;
                transactor3 = transactor8;
                AnonymousClass1 anonymousClass6 = new AnonymousClass1(b2, continuation, function1);
                this.L$0 = transactor3;
                this.L$1 = null;
                this.label = (byte) 3;
                objWithTransaction2 = transactor3.withTransaction(sQLiteTransactionType3, anonymousClass6, this);
                if (objWithTransaction2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                if (!z2) {
                    return objWithTransaction2;
                }
                this.L$0 = objWithTransaction2;
                this.label = (byte) 4;
                objInTransaction4 = transactor3.inTransaction(this);
                if (objInTransaction4 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                obj3 = objWithTransaction2;
                if (((Boolean) objInTransaction4).booleanValue()) {
                    return obj3;
                }
                roomDatabase.getInvalidationTracker().refreshAsync();
                return obj3;
        }
    }
}
