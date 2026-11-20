package androidx.room.coroutines;

import android.database.SQLException;
import androidx.media3.extractor.text.CueDecoder;
import androidx.room.PooledConnection;
import androidx.room.Transactor;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.network.HttpException;
import coil3.util.FileSystemsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {
    public final CueDecoder connectionElementKey;
    public final ConnectionWithLock delegate;
    public final boolean isReadOnly;
    public volatile boolean isRecycled;
    public final ArrayDeque transactionStack;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StatementWrapper implements SQLiteStatement {
        public final SQLiteStatement delegate;
        public final /* synthetic */ PooledConnectionImpl this$0;
        public final long threadId;

        public StatementWrapper(PooledConnectionImpl pooledConnectionImpl, SQLiteStatement sQLiteStatement) {
            sQLiteStatement.getClass();
            this.this$0 = pooledConnectionImpl;
            this.delegate = sQLiteStatement;
            this.threadId = FileSystemsKt.currentThreadId();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindBlob(byte[] bArr, int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                this.delegate.bindBlob(bArr, i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindDouble(int i, double d) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                this.delegate.bindDouble(i, d);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindLong(int i, long j) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                this.delegate.bindLong(i, j);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindNull(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                this.delegate.bindNull(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindText(int i, String str) {
            str.getClass();
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                this.delegate.bindText(i, str);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void clearBindings() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                this.delegate.clearBindings();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw null;
            }
        }

        @Override // java.lang.AutoCloseable
        public final void close() throws Exception {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                this.delegate.close();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final int getColumnCount() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                return this.delegate.getColumnCount();
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final String getColumnName(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                return this.delegate.getColumnName(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final double getDouble(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                return this.delegate.getDouble(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final long getLong(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                return this.delegate.getLong(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final String getText(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                return this.delegate.getText(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final boolean isNull(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                return this.delegate.isNull(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void reset() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                this.delegate.reset();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final boolean step() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw null;
            }
            if (this.threadId == FileSystemsKt.currentThreadId()) {
                return this.delegate.step();
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TransactionImpl implements RawConnectionAccessor, PooledConnection {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ TransactionImpl(byte b, Object obj) {
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public final SQLiteConnection getRawConnection() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    return ((PooledConnectionImpl) obj).delegate;
                default:
                    return ((PassthroughConnection) obj).delegate;
            }
        }

        @Override // androidx.room.PooledConnection
        public final Object usePrepared(String str, Function1 function1, ContinuationImpl continuationImpl) {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    return ((PooledConnectionImpl) obj).usePrepared(str, function1, continuationImpl);
                default:
                    return ((PassthroughConnection) obj).usePrepared(str, function1, continuationImpl);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TransactionItem {
        public final int id;

        public TransactionItem(int i) {
            this.id = i;
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Transactor.SQLiteTransactionType L$0;
        public ConnectionWithLock L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PooledConnectionImpl.this.beginTransaction(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PooledConnectionImpl$endTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00501 extends ContinuationImpl {
        public ConnectionWithLock L$0;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00501(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PooledConnectionImpl.this.endTransaction(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PooledConnectionImpl$usePrepared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00511 extends ContinuationImpl {
        public String L$0;
        public Function1 L$1;
        public ConnectionWithLock L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00511(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PooledConnectionImpl.this.usePrepared(null, null, this);
        }
    }

    public PooledConnectionImpl(CueDecoder cueDecoder, ConnectionWithLock connectionWithLock, boolean z) {
        cueDecoder.getClass();
        this.connectionElementKey = cueDecoder;
        this.delegate = connectionWithLock;
        this.isReadOnly = z;
        this.transactionStack = new ArrayDeque();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object beginTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        ConnectionWithLock connectionWithLock;
        ArrayDeque arrayDeque = this.transactionStack;
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
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        ConnectionWithLock connectionWithLock2 = this.delegate;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.L$0 = sQLiteTransactionType;
            anonymousClass1.L$1 = connectionWithLock2;
            anonymousClass1.label = 1;
            Object objLock = connectionWithLock2.lock.lock(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            connectionWithLock = connectionWithLock2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ConnectionWithLock connectionWithLock3 = anonymousClass1.L$1;
            Transactor.SQLiteTransactionType sQLiteTransactionType2 = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            connectionWithLock = connectionWithLock3;
            sQLiteTransactionType = sQLiteTransactionType2;
        }
        try {
            int i3 = arrayDeque.size;
            if (arrayDeque.isEmpty()) {
                int iOrdinal = sQLiteTransactionType.ordinal();
                if (iOrdinal == 0) {
                    SQLite.execSQL(connectionWithLock2, "BEGIN DEFERRED TRANSACTION");
                } else if (iOrdinal == 1) {
                    SQLite.execSQL(connectionWithLock2, "BEGIN IMMEDIATE TRANSACTION");
                } else {
                    if (iOrdinal != 2) {
                        throw new HttpException();
                    }
                    SQLite.execSQL(connectionWithLock2, "BEGIN EXCLUSIVE TRANSACTION");
                }
            } else {
                SQLite.execSQL(connectionWithLock2, "SAVEPOINT '" + i3 + '\'');
            }
            arrayDeque.addLast(new TransactionItem(i3));
            Unit unit = Unit.INSTANCE;
            connectionWithLock.unlock(null);
            return unit;
        } catch (Throwable th) {
            connectionWithLock.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object endTransaction(boolean z, ContinuationImpl continuationImpl) {
        C00501 c00501;
        ConnectionWithLock connectionWithLock;
        ArrayDeque arrayDeque = this.transactionStack;
        if (continuationImpl instanceof C00501) {
            c00501 = (C00501) continuationImpl;
            int i = c00501.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00501.label = i - Integer.MIN_VALUE;
            } else {
                c00501 = new C00501(continuationImpl);
            }
        } else {
            c00501 = new C00501(continuationImpl);
        }
        Object obj = c00501.result;
        int i2 = c00501.label;
        ConnectionWithLock connectionWithLock2 = this.delegate;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c00501.L$0 = connectionWithLock2;
            c00501.Z$0 = z;
            c00501.label = 1;
            Object objLock = connectionWithLock2.lock.lock(c00501);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            connectionWithLock = connectionWithLock2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = c00501.Z$0;
            connectionWithLock = c00501.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (arrayDeque.isEmpty()) {
                throw new IllegalStateException("Not in a transaction");
            }
            TransactionItem transactionItem = (TransactionItem) CollectionsKt__MutableCollectionsKt.removeLast(arrayDeque);
            if (z) {
                transactionItem.getClass();
                if (arrayDeque.isEmpty()) {
                    SQLite.execSQL(connectionWithLock2, "END TRANSACTION");
                } else {
                    SQLite.execSQL(connectionWithLock2, "RELEASE SAVEPOINT '" + transactionItem.id + '\'');
                }
            } else if (arrayDeque.isEmpty()) {
                SQLite.execSQL(connectionWithLock2, "ROLLBACK TRANSACTION");
            } else {
                SQLite.execSQL(connectionWithLock2, "ROLLBACK TRANSACTION TO SAVEPOINT '" + transactionItem.id + '\'');
            }
            Unit unit = Unit.INSTANCE;
            connectionWithLock.unlock(null);
            return unit;
        } catch (Throwable th) {
            connectionWithLock.unlock(null);
            throw th;
        }
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public final SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    @Override // androidx.room.Transactor
    public final Boolean inTransaction(Continuation continuation) {
        if (this.isRecycled) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw null;
        }
        ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(this.connectionElementKey);
        if (connectionElement != null && connectionElement.connectionWrapper == this) {
            return Boolean.valueOf(!this.transactionStack.isEmpty() || this.delegate.delegate.inTransaction());
        }
        SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x008a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object] */
    public final Object transaction$1(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, ContinuationImpl continuationImpl) throws Throwable {
        PooledConnectionImpl$transaction$1 pooledConnectionImpl$transaction$1;
        SQLException e;
        Throwable th;
        if (continuationImpl instanceof PooledConnectionImpl$transaction$1) {
            pooledConnectionImpl$transaction$1 = (PooledConnectionImpl$transaction$1) continuationImpl;
            int i = pooledConnectionImpl$transaction$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                pooledConnectionImpl$transaction$1.label = i - Integer.MIN_VALUE;
            } else {
                pooledConnectionImpl$transaction$1 = new PooledConnectionImpl$transaction$1(this, continuationImpl);
            }
        } else {
            pooledConnectionImpl$transaction$1 = new PooledConnectionImpl$transaction$1(this, continuationImpl);
        }
        Object objInvoke = pooledConnectionImpl$transaction$1.result;
        int i2 = pooledConnectionImpl$transaction$1.label;
        byte b = 0;
        boolean z = true;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                if (sQLiteTransactionType == null) {
                    sQLiteTransactionType = Transactor.SQLiteTransactionType.DEFERRED;
                }
                pooledConnectionImpl$transaction$1.L$0 = function2;
                pooledConnectionImpl$transaction$1.label = 1;
                if (beginTransaction(sQLiteTransactionType, pooledConnectionImpl$transaction$1) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                function2 = (Function2) pooledConnectionImpl$transaction$1.L$0;
                ResultKt.throwOnFailure(objInvoke);
            } else {
                if (i2 != 2) {
                    if (i2 == 3 || i2 == 4) {
                        Object obj = pooledConnectionImpl$transaction$1.L$0;
                        ResultKt.throwOnFailure(objInvoke);
                        return obj;
                    }
                    if (i2 != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    th = pooledConnectionImpl$transaction$1.L$1;
                    th = (Throwable) pooledConnectionImpl$transaction$1.L$0;
                    try {
                        ResultKt.throwOnFailure(objInvoke);
                        throw th;
                    } catch (SQLException e2) {
                        e = e2;
                        if (th != null) {
                            throw e;
                        }
                        ResultKt.addSuppressed(th, e);
                        throw th;
                    }
                }
                z = pooledConnectionImpl$transaction$1.I$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            pooledConnectionImpl$transaction$1.L$0 = objInvoke;
            pooledConnectionImpl$transaction$1.label = 3;
            this = endTransaction(z, pooledConnectionImpl$transaction$1);
            if (this != coroutineSingletons) {
                return coroutineSingletons;
            }
            return objInvoke;
            TransactionImpl transactionImpl = new TransactionImpl(b, this);
            pooledConnectionImpl$transaction$1.L$0 = null;
            pooledConnectionImpl$transaction$1.I$0 = true;
            pooledConnectionImpl$transaction$1.label = 2;
            objInvoke = function2.invoke(transactionImpl, pooledConnectionImpl$transaction$1);
            if (objInvoke != coroutineSingletons) {
                pooledConnectionImpl$transaction$1.L$0 = objInvoke;
                pooledConnectionImpl$transaction$1.label = 3;
                this = endTransaction(z, pooledConnectionImpl$transaction$1);
                if (this != coroutineSingletons) {
                    return objInvoke;
                }
            }
            return coroutineSingletons;
        } catch (Throwable th2) {
            th = th2;
            try {
                throw th;
            } catch (Throwable th3) {
                try {
                    pooledConnectionImpl$transaction$1.L$0 = th;
                    pooledConnectionImpl$transaction$1.L$1 = th3;
                    pooledConnectionImpl$transaction$1.label = 5;
                    if (this.endTransaction(false, pooledConnectionImpl$transaction$1) != coroutineSingletons) {
                        throw th3;
                    }
                } catch (SQLException e3) {
                    e = e3;
                    th = th3;
                    if (th != null) {
                        throw e;
                    }
                    ResultKt.addSuppressed(th, e);
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.room.PooledConnection
    public final Object usePrepared(String str, Function1 function1, ContinuationImpl continuationImpl) {
        C00511 c00511;
        ConnectionWithLock connectionWithLock;
        if (continuationImpl instanceof C00511) {
            c00511 = (C00511) continuationImpl;
            int i = c00511.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00511.label = i - Integer.MIN_VALUE;
            } else {
                c00511 = new C00511(continuationImpl);
            }
        } else {
            c00511 = new C00511(continuationImpl);
        }
        Object obj = c00511.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c00511.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isRecycled) {
                SQLite.throwSQLiteException(21, "Connection is recycled");
                throw null;
            }
            ConnectionElement connectionElement = (ConnectionElement) c00511.getContext().get(this.connectionElementKey);
            if (connectionElement == null || connectionElement.connectionWrapper != this) {
                SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
                throw null;
            }
            connectionWithLock = this.delegate;
            c00511.L$0 = str;
            c00511.L$1 = function1;
            c00511.L$2 = connectionWithLock;
            c00511.label = 1;
            if (connectionWithLock.lock.lock(c00511) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ConnectionWithLock connectionWithLock2 = c00511.L$2;
            function1 = c00511.L$1;
            String str2 = c00511.L$0;
            ResultKt.throwOnFailure(obj);
            connectionWithLock = connectionWithLock2;
            str = str2;
        }
        try {
            StatementWrapper statementWrapper = new StatementWrapper(this, this.delegate.prepare(str));
            try {
                Object objInvoke = function1.invoke(statementWrapper);
                StringsKt__IndentKt.closeFinally(statementWrapper, null);
                connectionWithLock.unlock(null);
                return objInvoke;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    StringsKt__IndentKt.closeFinally(statementWrapper, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            connectionWithLock.unlock(null);
            throw th3;
        }
    }

    @Override // androidx.room.Transactor
    public final Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, SuspendLambda suspendLambda) {
        if (this.isRecycled) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw null;
        }
        ConnectionElement connectionElement = (ConnectionElement) suspendLambda.getContext().get(this.connectionElementKey);
        if (connectionElement != null && connectionElement.connectionWrapper == this) {
            return transaction$1(sQLiteTransactionType, function2, suspendLambda);
        }
        SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
        throw null;
    }
}
