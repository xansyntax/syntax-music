package androidx.room.util;

import androidx.room.RoomDatabase;
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
public final class DBUtil__DBUtil_androidKt$performBlocking$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ RoomDatabase $db;
    public final /* synthetic */ boolean $inTransaction;
    public final /* synthetic */ boolean $isReadOnly;
    public final /* synthetic */ byte $r8$classId = 0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performBlocking$1$1(RoomDatabase roomDatabase, boolean z, boolean z2, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.$db = roomDatabase;
        this.$inTransaction = z;
        this.$isReadOnly = z2;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new DBUtil__DBUtil_androidKt$performBlocking$1$1(this.$db, this.$inTransaction, this.$isReadOnly, this.$block, continuation);
            default:
                return new DBUtil__DBUtil_androidKt$performBlocking$1$1(continuation, this.$db, this.$inTransaction, this.$isReadOnly, this.$block);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((DBUtil__DBUtil_androidKt$performBlocking$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                RoomDatabase roomDatabase = this.$db;
                boolean z2 = !(roomDatabase.inCompatibilityMode() && roomDatabase.inTransaction()) && this.$inTransaction;
                boolean z3 = this.$isReadOnly;
                RoomDatabase roomDatabase2 = this.$db;
                DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(z2, z3, roomDatabase2, null, this.$block, (byte) 1);
                this.label = true;
                Object objUseConnection = roomDatabase2.useConnection(z3, dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1, this);
                return objUseConnection == coroutineSingletons ? coroutineSingletons : objUseConnection;
            default:
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Function1 function1 = this.$block;
                boolean z5 = this.$isReadOnly;
                boolean z6 = this.$inTransaction;
                RoomDatabase roomDatabase3 = this.$db;
                DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$2 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(z5, z6, roomDatabase3, null, function1, (byte) 0);
                this.label = true;
                Object objUseConnection2 = roomDatabase3.useConnection(z6, dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$2, this);
                return objUseConnection2 == coroutineSingletons ? coroutineSingletons : objUseConnection2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performBlocking$1$1(Continuation continuation, RoomDatabase roomDatabase, boolean z, boolean z2, Function1 function1) {
        super(2, continuation);
        this.$db = roomDatabase;
        this.$inTransaction = z;
        this.$isReadOnly = z2;
        this.$block = function1;
    }
}
