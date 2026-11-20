package androidx.room.util;

import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
import androidx.room.Transactor;
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
public final class DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function1 $block$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ RoomDatabase $this_internalPerform;
    public /* synthetic */ Object L$0;
    public Transactor.SQLiteTransactionType L$1;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1(RoomDatabase roomDatabase, Continuation continuation, Function1 function1, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$this_internalPerform = roomDatabase;
        this.$block$inlined = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1(this.$this_internalPerform, continuation, this.$block$inlined, (byte) 0);
                dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1.L$0 = obj;
                return dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1;
            default:
                DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$2 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1(this.$this_internalPerform, continuation, this.$block$inlined, (byte) 1);
                dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$2.L$0 = obj;
                return dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$2;
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
        return ((DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1) create(transactor, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0085 A[PHI: r0 r1
      0x0085: PHI (r0v15 androidx.room.Transactor$SQLiteTransactionType) = 
      (r0v14 androidx.room.Transactor$SQLiteTransactionType)
      (r0v14 androidx.room.Transactor$SQLiteTransactionType)
      (r0v20 androidx.room.Transactor$SQLiteTransactionType)
     binds: [B:23:0x0072, B:25:0x0082, B:15:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r1v11 androidx.room.Transactor) = (r1v10 androidx.room.Transactor), (r1v10 androidx.room.Transactor), (r1v16 androidx.room.Transactor) binds: [B:23:0x0072, B:25:0x0082, B:15:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x0099 A[PHI: r0 r14
      0x0099: PHI (r0v17 androidx.room.Transactor) = (r0v16 androidx.room.Transactor), (r0v22 androidx.room.Transactor) binds: [B:28:0x0096, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r14v31 java.lang.Object) = (r14v29 java.lang.Object), (r14v0 java.lang.Object) binds: [B:28:0x0096, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x0129 A[PHI: r0 r1
      0x0129: PHI (r0v4 androidx.room.Transactor$SQLiteTransactionType) = 
      (r0v3 androidx.room.Transactor$SQLiteTransactionType)
      (r0v3 androidx.room.Transactor$SQLiteTransactionType)
      (r0v9 androidx.room.Transactor$SQLiteTransactionType)
     binds: [B:58:0x0116, B:60:0x0126, B:50:0x00e1] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r1v3 androidx.room.Transactor) = (r1v2 androidx.room.Transactor), (r1v2 androidx.room.Transactor), (r1v8 androidx.room.Transactor) binds: [B:58:0x0116, B:60:0x0126, B:50:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x013d A[PHI: r0 r14
      0x013d: PHI (r0v6 androidx.room.Transactor) = (r0v5 androidx.room.Transactor), (r0v11 androidx.room.Transactor) binds: [B:63:0x013a, B:49:0x00d9] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r14v12 java.lang.Object) = (r14v10 java.lang.Object), (r14v0 java.lang.Object) binds: [B:63:0x013a, B:49:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x0149  */
    /* JADX WARN: Code duplicated, block: B:71:0x0154  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Transactor.SQLiteTransactionType sQLiteTransactionType;
        Transactor transactor;
        Transactor.SQLiteTransactionType sQLiteTransactionType2;
        Transactor transactor2;
        Boolean boolInTransaction;
        Object obj2;
        Transactor.SQLiteTransactionType sQLiteTransactionType3;
        Transactor transactor3;
        Transactor.SQLiteTransactionType sQLiteTransactionType4;
        Transactor transactor4;
        Boolean boolInTransaction2;
        Object obj3;
        byte b = this.$r8$classId;
        Transactor.SQLiteTransactionType sQLiteTransactionType5 = Transactor.SQLiteTransactionType.IMMEDIATE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        RoomDatabase roomDatabase = this.$this_internalPerform;
        Function1 function1 = this.$block$inlined;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Transactor transactor5 = (Transactor) this.L$0;
                    this.L$0 = transactor5;
                    this.L$1 = sQLiteTransactionType5;
                    this.label = (byte) 1;
                    Boolean boolInTransaction3 = transactor5.inTransaction(this);
                    if (boolInTransaction3 != coroutineSingletons) {
                        sQLiteTransactionType = sQLiteTransactionType5;
                        transactor = transactor5;
                        obj = boolInTransaction3;
                    }
                    return coroutineSingletons;
                }
                if (b2 == 1) {
                    Transactor.SQLiteTransactionType sQLiteTransactionType6 = this.L$1;
                    Transactor transactor6 = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sQLiteTransactionType = sQLiteTransactionType6;
                    transactor = transactor6;
                } else {
                    if (b2 == 2) {
                        sQLiteTransactionType2 = this.L$1;
                        transactor = (Transactor) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Transactor.SQLiteTransactionType sQLiteTransactionType7 = sQLiteTransactionType2;
                        transactor2 = transactor;
                        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1((byte) 2, null, function1);
                        this.L$0 = transactor2;
                        this.L$1 = null;
                        this.label = (byte) 3;
                        obj = transactor2.withTransaction(sQLiteTransactionType7, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, this);
                        if (obj != coroutineSingletons) {
                            this.L$0 = obj;
                            this.label = (byte) 4;
                            boolInTransaction = transactor2.inTransaction(this);
                            if (boolInTransaction != coroutineSingletons) {
                                Object obj4 = obj;
                                obj = boolInTransaction;
                                obj2 = obj4;
                            }
                        }
                        return coroutineSingletons;
                    }
                    if (b2 == 3) {
                        transactor2 = (Transactor) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = obj;
                        this.label = (byte) 4;
                        boolInTransaction = transactor2.inTransaction(this);
                        if (boolInTransaction != coroutineSingletons) {
                            Object obj5 = obj;
                            obj = boolInTransaction;
                            obj2 = obj5;
                        }
                        return coroutineSingletons;
                    }
                    if (b2 != 4) {
                        if (b2 == 5) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    roomDatabase.getInvalidationTracker().refreshAsync();
                }
                return obj2;
                sQLiteTransactionType2 = sQLiteTransactionType;
                if (((Boolean) obj).booleanValue()) {
                    Transactor.SQLiteTransactionType sQLiteTransactionType8 = sQLiteTransactionType2;
                    transactor2 = transactor;
                    RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$2 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1((byte) 2, null, function1);
                    this.L$0 = transactor2;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    obj = transactor2.withTransaction(sQLiteTransactionType8, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$2, this);
                    if (obj != coroutineSingletons) {
                        this.L$0 = obj;
                        this.label = (byte) 4;
                        boolInTransaction = transactor2.inTransaction(this);
                        if (boolInTransaction != coroutineSingletons) {
                            Object obj6 = obj;
                            obj = boolInTransaction;
                            obj2 = obj6;
                            if (!((Boolean) obj).booleanValue()) {
                                roomDatabase.getInvalidationTracker().refreshAsync();
                            }
                            return obj2;
                        }
                    }
                } else {
                    InvalidationTracker invalidationTracker = roomDatabase.getInvalidationTracker();
                    this.L$0 = transactor;
                    this.L$1 = sQLiteTransactionType2;
                    this.label = (byte) 2;
                    if (invalidationTracker.sync$room_runtime(this) != coroutineSingletons) {
                        Transactor.SQLiteTransactionType sQLiteTransactionType9 = sQLiteTransactionType2;
                        transactor2 = transactor;
                        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$3 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1((byte) 2, null, function1);
                        this.L$0 = transactor2;
                        this.L$1 = null;
                        this.label = (byte) 3;
                        obj = transactor2.withTransaction(sQLiteTransactionType9, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$3, this);
                        if (obj != coroutineSingletons) {
                            this.L$0 = obj;
                            this.label = (byte) 4;
                            boolInTransaction = transactor2.inTransaction(this);
                            if (boolInTransaction != coroutineSingletons) {
                                Object obj7 = obj;
                                obj = boolInTransaction;
                                obj2 = obj7;
                                if (!((Boolean) obj).booleanValue()) {
                                    roomDatabase.getInvalidationTracker().refreshAsync();
                                }
                                return obj2;
                            }
                        }
                    }
                }
                return coroutineSingletons;
            default:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Transactor transactor7 = (Transactor) this.L$0;
                    this.L$0 = transactor7;
                    this.L$1 = sQLiteTransactionType5;
                    this.label = (byte) 1;
                    Boolean boolInTransaction4 = transactor7.inTransaction(this);
                    if (boolInTransaction4 != coroutineSingletons) {
                        sQLiteTransactionType3 = sQLiteTransactionType5;
                        transactor3 = transactor7;
                        obj = boolInTransaction4;
                    }
                    return coroutineSingletons;
                }
                if (b3 == 1) {
                    Transactor.SQLiteTransactionType sQLiteTransactionType10 = this.L$1;
                    Transactor transactor8 = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sQLiteTransactionType3 = sQLiteTransactionType10;
                    transactor3 = transactor8;
                } else {
                    if (b3 == 2) {
                        sQLiteTransactionType4 = this.L$1;
                        transactor3 = (Transactor) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Transactor.SQLiteTransactionType sQLiteTransactionType11 = sQLiteTransactionType4;
                        transactor4 = transactor3;
                        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$4 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1((byte) 1, null, function1);
                        this.L$0 = transactor4;
                        this.L$1 = null;
                        this.label = (byte) 3;
                        obj = transactor4.withTransaction(sQLiteTransactionType11, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$4, this);
                        if (obj != coroutineSingletons) {
                            this.L$0 = obj;
                            this.label = (byte) 4;
                            boolInTransaction2 = transactor4.inTransaction(this);
                            if (boolInTransaction2 != coroutineSingletons) {
                                Object obj8 = obj;
                                obj = boolInTransaction2;
                                obj3 = obj8;
                            }
                        }
                        return coroutineSingletons;
                    }
                    if (b3 == 3) {
                        transactor4 = (Transactor) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = obj;
                        this.label = (byte) 4;
                        boolInTransaction2 = transactor4.inTransaction(this);
                        if (boolInTransaction2 != coroutineSingletons) {
                            Object obj9 = obj;
                            obj = boolInTransaction2;
                            obj3 = obj9;
                        }
                        return coroutineSingletons;
                    }
                    if (b3 != 4) {
                        if (b3 == 5) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj3 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    roomDatabase.getInvalidationTracker().refreshAsync();
                }
                return obj3;
                sQLiteTransactionType4 = sQLiteTransactionType3;
                if (((Boolean) obj).booleanValue()) {
                    Transactor.SQLiteTransactionType sQLiteTransactionType12 = sQLiteTransactionType4;
                    transactor4 = transactor3;
                    RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$5 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1((byte) 1, null, function1);
                    this.L$0 = transactor4;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    obj = transactor4.withTransaction(sQLiteTransactionType12, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$5, this);
                    if (obj != coroutineSingletons) {
                        this.L$0 = obj;
                        this.label = (byte) 4;
                        boolInTransaction2 = transactor4.inTransaction(this);
                        if (boolInTransaction2 != coroutineSingletons) {
                            Object obj10 = obj;
                            obj = boolInTransaction2;
                            obj3 = obj10;
                            if (!((Boolean) obj).booleanValue()) {
                                roomDatabase.getInvalidationTracker().refreshAsync();
                            }
                            return obj3;
                        }
                    }
                } else {
                    InvalidationTracker invalidationTracker2 = roomDatabase.getInvalidationTracker();
                    this.L$0 = transactor3;
                    this.L$1 = sQLiteTransactionType4;
                    this.label = (byte) 2;
                    if (invalidationTracker2.sync$room_runtime(this) != coroutineSingletons) {
                        Transactor.SQLiteTransactionType sQLiteTransactionType13 = sQLiteTransactionType4;
                        transactor4 = transactor3;
                        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$6 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1((byte) 1, null, function1);
                        this.L$0 = transactor4;
                        this.L$1 = null;
                        this.label = (byte) 3;
                        obj = transactor4.withTransaction(sQLiteTransactionType13, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$6, this);
                        if (obj != coroutineSingletons) {
                            this.L$0 = obj;
                            this.label = (byte) 4;
                            boolInTransaction2 = transactor4.inTransaction(this);
                            if (boolInTransaction2 != coroutineSingletons) {
                                Object obj11 = obj;
                                obj = boolInTransaction2;
                                obj3 = obj11;
                                if (!((Boolean) obj).booleanValue()) {
                                    roomDatabase.getInvalidationTracker().refreshAsync();
                                }
                                return obj3;
                            }
                        }
                    }
                }
                return coroutineSingletons;
        }
    }
}
