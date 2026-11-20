package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.Transactor;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.dokar.quickjs.QuickJs;
import com.metrolist.innertubex.cipher.EjsChallengeSolver;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PassthroughConnection implements Transactor, RawConnectionAccessor {
    public Transactor.SQLiteTransactionType currentTransactionType;
    public final SQLiteConnection delegate;
    public final AtomicInteger nestedTransactionCount;
    public final Function2 transactionWrapper;

    /* JADX INFO: renamed from: androidx.room.coroutines.PassthroughConnection$transaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public boolean I$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PassthroughConnection.this.transaction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PassthroughConnection$usePrepared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00491 extends ContinuationImpl {
        public String L$0;
        public Function1 L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00491(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PassthroughConnection.this.usePrepared(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PassthroughConnection$usePrepared$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ Object $block;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ String $sql;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, String str, Object obj2, Continuation continuation, byte b) {
            super(1, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.$sql = str;
            this.$block = obj2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj = this.$block;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass2((PassthroughConnection) obj2, this.$sql, (Function1) obj, continuation, (byte) 0);
                default:
                    return new AnonymousClass2((EjsChallengeSolver) obj2, this.$sql, (String) obj, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = (Continuation) obj;
            switch (b) {
                case 0:
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
                default:
                    ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
                    return unit;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            String str = this.$sql;
            Object obj2 = this.$block;
            Object obj3 = this.this$0;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    SQLiteStatement sQLiteStatementPrepare = ((PassthroughConnection) obj3).delegate.prepare(str);
                    try {
                        Object objInvoke = ((Function1) obj2).invoke(sQLiteStatementPrepare);
                        StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                        return objInvoke;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                            throw th2;
                        }
                    }
                default:
                    EjsChallengeSolver ejsChallengeSolver = (EjsChallengeSolver) obj3;
                    ResultKt.throwOnFailure(obj);
                    JsonImpl jsonImpl = EjsChallengeSolver.payloadJson;
                    ejsChallengeSolver.getClass();
                    ejsChallengeSolver.preprocessedByPlayerUrl.clear();
                    ejsChallengeSolver.preprocessedByPlayerUrl.put((String) obj2, str);
                    return Unit.INSTANCE;
            }
        }
    }

    public PassthroughConnection(Function2 function2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        this.transactionWrapper = function2;
        this.delegate = sQLiteConnection;
        this.nestedTransactionCount = new AtomicInteger(0);
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public final SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    @Override // androidx.room.Transactor
    public final Boolean inTransaction(Continuation continuation) {
        return Boolean.valueOf(this.currentTransactionType != null || this.delegate.inTransaction());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object transaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objInvoke = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        AtomicInteger atomicInteger = this.nestedTransactionCount;
        boolean z = true;
        SQLiteConnection sQLiteConnection = this.delegate;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                int iOrdinal = sQLiteTransactionType.ordinal();
                if (iOrdinal == 0) {
                    SQLite.execSQL(sQLiteConnection, "BEGIN DEFERRED TRANSACTION");
                } else if (iOrdinal == 1) {
                    SQLite.execSQL(sQLiteConnection, "BEGIN IMMEDIATE TRANSACTION");
                } else {
                    if (iOrdinal != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
                }
                if (atomicInteger.incrementAndGet() > 0) {
                    this.currentTransactionType = sQLiteTransactionType;
                }
                Object transactionImpl = new PooledConnectionImpl.TransactionImpl((byte) 1, this);
                anonymousClass1.I$0 = true;
                anonymousClass1.label = 1;
                objInvoke = function2.invoke(transactionImpl, anonymousClass1);
                Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objInvoke == obj) {
                    return obj;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                z = anonymousClass1.I$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                this.currentTransactionType = null;
            }
            if (z) {
                SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
                return objInvoke;
            }
            SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
            return objInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    if (atomicInteger.decrementAndGet() == 0) {
                        this.currentTransactionType = null;
                    }
                    SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                } catch (SQLException e) {
                    ResultKt.addSuppressed(th, e);
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.room.PooledConnection
    public final Object usePrepared(String str, Function1 function1, ContinuationImpl continuationImpl) {
        C00491 c00491;
        if (continuationImpl instanceof C00491) {
            c00491 = (C00491) continuationImpl;
            int i = c00491.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00491.label = i - Integer.MIN_VALUE;
            } else {
                c00491 = new C00491(continuationImpl);
            }
        } else {
            c00491 = new C00491(continuationImpl);
        }
        Object objInTransaction = c00491.result;
        int i2 = c00491.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInTransaction);
            c00491.L$0 = str;
            c00491.L$1 = function1;
            c00491.label = 1;
            objInTransaction = inTransaction(c00491);
            if (objInTransaction != obj) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objInTransaction);
                return objInTransaction;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        function1 = c00491.L$1;
        str = c00491.L$0;
        ResultKt.throwOnFailure(objInTransaction);
        String str2 = str;
        Function1 function2 = function1;
        Continuation continuation = null;
        if (((Boolean) objInTransaction).booleanValue()) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, str2, function2, continuation, (byte) 0);
            c00491.L$0 = null;
            c00491.L$1 = null;
            c00491.label = 2;
            Object objInvoke = this.transactionWrapper.invoke(anonymousClass2, c00491);
            return objInvoke == obj ? obj : objInvoke;
        }
        SQLiteStatement sQLiteStatementPrepare = this.delegate.prepare(str2);
        try {
            Object objInvoke2 = function2.invoke(sQLiteStatementPrepare);
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            return objInvoke2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    @Override // androidx.room.Transactor
    public final Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, SuspendLambda suspendLambda) {
        return this.transactionWrapper.invoke(new QuickJs.C00594(this, sQLiteTransactionType, function2, (Continuation) null, (byte) 2), suspendLambda);
    }
}
