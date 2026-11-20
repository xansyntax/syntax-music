package androidx.room.coroutines;

import androidx.media3.extractor.text.CueDecoder;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.room.concurrent.FileLock;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.metrolist.music.App;
import com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda1;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__IndentKt;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.internal.ThreadLocalElement;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionPoolImpl implements ConnectionPool {
    public final CueDecoder connectionElementKey;
    public final ThreadLocal connectionThreadLocal;
    public volatile boolean isClosed;
    public final Pool readers;
    public final long timeout;
    public final Pool writers;

    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Ref$ObjectRef L$2;
        public CoroutineContext L$3;
        public Ref$ObjectRef L$4;
        public CueDecoder L$5;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectionPoolImpl.this.useConnection(false, null, this);
        }
    }

    public ConnectionPoolImpl(final FileLock fileLock, final String str, int i) {
        str.getClass();
        this.connectionElementKey = new CueDecoder((byte) 25);
        this.connectionThreadLocal = new ThreadLocal();
        Path.Companion companion = Duration.Companion;
        this.timeout = InstantKt.toDuration(30, DurationUnit.SECONDS);
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Maximum number of readers must be greater than 0");
            throw null;
        }
        final byte b = 0;
        this.readers = new Pool(i, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b2 = b;
                String str2 = str;
                FileLock fileLock2 = fileLock;
                switch (b2) {
                    case 0:
                        SQLiteConnection sQLiteConnectionOpen = fileLock2.open(str2);
                        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA query_only = 1");
                        return sQLiteConnectionOpen;
                    default:
                        return fileLock2.open(str2);
                }
            }
        });
        final byte b2 = 1;
        this.writers = new Pool(1, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b3 = b2;
                String str2 = str;
                FileLock fileLock2 = fileLock;
                switch (b3) {
                    case 0:
                        SQLiteConnection sQLiteConnectionOpen = fileLock2.open(str2);
                        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA query_only = 1");
                        return sQLiteConnectionOpen;
                    default:
                        return fileLock2.open(str2);
                }
            }
        });
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.readers.close();
        this.writers.close();
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0138  */
    /* JADX WARN: Code duplicated, block: B:71:0x0144 A[Catch: all -> 0x019b, TRY_LEAVE, TryCatch #3 {all -> 0x019b, blocks: (B:64:0x011d, B:69:0x0139, B:71:0x0144, B:86:0x019f, B:87:0x01a6), top: B:113:0x011d }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0173  */
    /* JADX WARN: Code duplicated, block: B:77:0x017b  */
    /* JADX WARN: Code duplicated, block: B:79:0x017f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:81:0x018c  */
    /* JADX WARN: Code duplicated, block: B:86:0x019f A[Catch: all -> 0x019b, TRY_ENTER, TryCatch #3 {all -> 0x019b, blocks: (B:64:0x011d, B:69:0x0139, B:71:0x0144, B:86:0x019f, B:87:0x01a6), top: B:113:0x011d }] */
    @Override // androidx.room.coroutines.ConnectionPool
    public final Object useConnection(boolean z, Function2 function2, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        Pool pool;
        CoroutineContext context;
        Function2 function3;
        CueDecoder cueDecoder;
        Pool pool2;
        Ref$ObjectRef ref$ObjectRef2;
        boolean z2;
        Object obj;
        Ref$ObjectRef ref$ObjectRef3;
        PooledConnectionImpl pooledConnectionImpl;
        boolean z3 = z;
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
        Object objWithContext = anonymousClass1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            if (i2 == 2) {
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            if (i2 == 3) {
                z3 = anonymousClass1.Z$0;
                cueDecoder = anonymousClass1.L$5;
                Ref$ObjectRef ref$ObjectRef4 = anonymousClass1.L$4;
                CoroutineContext coroutineContext = anonymousClass1.L$3;
                Ref$ObjectRef ref$ObjectRef5 = anonymousClass1.L$2;
                pool2 = (Pool) anonymousClass1.L$1;
                function3 = (Function2) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    ref$ObjectRef2 = ref$ObjectRef4;
                    ref$ObjectRef = ref$ObjectRef5;
                    context = coroutineContext;
                    try {
                        ConnectionWithLock connectionWithLock = (ConnectionWithLock) objWithContext;
                        connectionWithLock.getClass();
                        context.getClass();
                        connectionWithLock.acquireCoroutineContext = context;
                        connectionWithLock.acquireThrowable = new Throwable();
                        if (this.readers == this.writers && z3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ref$ObjectRef2.element = new PooledConnectionImpl(cueDecoder, connectionWithLock, z2);
                        obj = ref$ObjectRef.element;
                        if (obj != null) {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                        PooledConnectionImpl pooledConnectionImpl2 = (PooledConnectionImpl) obj;
                        CoroutineContext coroutineContextPlus = StringsKt__IndentKt.plus(new ConnectionElement(this.connectionElementKey, pooledConnectionImpl2), new ThreadLocalElement(pooledConnectionImpl2, this.connectionThreadLocal));
                        App.C01391 c01391 = new App.C01391(function3, ref$ObjectRef, continuation, (byte) 7);
                        anonymousClass1.L$0 = pool2;
                        anonymousClass1.L$1 = ref$ObjectRef;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.label = 4;
                        objWithContext = AwaitKt.withContext(coroutineContextPlus, c01391, anonymousClass1);
                        if (objWithContext != coroutineSingletons) {
                            ref$ObjectRef3 = ref$ObjectRef;
                            pool = pool2;
                        }
                        return coroutineSingletons;
                    } catch (Throwable th2) {
                        th = th2;
                        pool = pool2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ref$ObjectRef = ref$ObjectRef5;
                    pool = pool2;
                    throw th;
                }
            }
            if (i2 != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$ObjectRef3 = (Ref$ObjectRef) anonymousClass1.L$1;
            pool = (Pool) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(objWithContext);
            } catch (Throwable th4) {
                ref$ObjectRef = ref$ObjectRef3;
                th = th4;
            }
            pooledConnectionImpl = (PooledConnectionImpl) ref$ObjectRef3.element;
            if (pooledConnectionImpl != null) {
                if (!pooledConnectionImpl.isRecycled) {
                    pooledConnectionImpl.isRecycled = true;
                    if (pooledConnectionImpl.delegate.delegate.inTransaction()) {
                        SQLite.execSQL(pooledConnectionImpl.delegate, "ROLLBACK TRANSACTION");
                    }
                }
                ConnectionWithLock connectionWithLock2 = pooledConnectionImpl.delegate;
                connectionWithLock2.acquireCoroutineContext = null;
                connectionWithLock2.acquireThrowable = null;
                pool.recycle(connectionWithLock2);
            }
            return objWithContext;
        }
        ResultKt.throwOnFailure(objWithContext);
        if (this.isClosed) {
            SQLite.throwSQLiteException(21, "Connection pool is closed");
            throw null;
        }
        PooledConnectionImpl pooledConnectionImpl3 = (PooledConnectionImpl) this.connectionThreadLocal.get();
        if (pooledConnectionImpl3 == null) {
            ConnectionElement connectionElement = (ConnectionElement) anonymousClass1.getContext().get(this.connectionElementKey);
            pooledConnectionImpl3 = connectionElement != null ? connectionElement.connectionWrapper : null;
        }
        if (pooledConnectionImpl3 == null) {
            Pool pool3 = z3 ? this.readers : this.writers;
            ref$ObjectRef = new Ref$ObjectRef();
            try {
                context = anonymousClass1.getContext();
                CueDecoder cueDecoder2 = this.connectionElementKey;
                long j = this.timeout;
                ThumbnailKt$$ExternalSyntheticLambda1 thumbnailKt$$ExternalSyntheticLambda1 = new ThumbnailKt$$ExternalSyntheticLambda1(this, z3, (byte) 3);
                anonymousClass1.L$0 = function2;
                anonymousClass1.L$1 = pool3;
                anonymousClass1.L$2 = ref$ObjectRef;
                anonymousClass1.L$3 = context;
                anonymousClass1.L$4 = ref$ObjectRef;
                anonymousClass1.L$5 = cueDecoder2;
                anonymousClass1.Z$0 = z3;
                anonymousClass1.label = 3;
                Object objM844acquireWithTimeoutKLykuaI = pool3.m844acquireWithTimeoutKLykuaI(j, thumbnailKt$$ExternalSyntheticLambda1, anonymousClass1);
                if (objM844acquireWithTimeoutKLykuaI != coroutineSingletons) {
                    function3 = function2;
                    cueDecoder = cueDecoder2;
                    pool2 = pool3;
                    objWithContext = objM844acquireWithTimeoutKLykuaI;
                    ref$ObjectRef2 = ref$ObjectRef;
                    ConnectionWithLock connectionWithLock3 = (ConnectionWithLock) objWithContext;
                    connectionWithLock3.getClass();
                    context.getClass();
                    connectionWithLock3.acquireCoroutineContext = context;
                    connectionWithLock3.acquireThrowable = new Throwable();
                    if (this.readers == this.writers) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    ref$ObjectRef2.element = new PooledConnectionImpl(cueDecoder, connectionWithLock3, z2);
                    obj = ref$ObjectRef.element;
                    if (obj != null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    PooledConnectionImpl pooledConnectionImpl4 = (PooledConnectionImpl) obj;
                    CoroutineContext coroutineContextPlus2 = StringsKt__IndentKt.plus(new ConnectionElement(this.connectionElementKey, pooledConnectionImpl4), new ThreadLocalElement(pooledConnectionImpl4, this.connectionThreadLocal));
                    App.C01391 c01392 = new App.C01391(function3, ref$ObjectRef, continuation, (byte) 7);
                    anonymousClass1.L$0 = pool2;
                    anonymousClass1.L$1 = ref$ObjectRef;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 4;
                    objWithContext = AwaitKt.withContext(coroutineContextPlus2, c01392, anonymousClass1);
                    if (objWithContext != coroutineSingletons) {
                        ref$ObjectRef3 = ref$ObjectRef;
                        pool = pool2;
                        pooledConnectionImpl = (PooledConnectionImpl) ref$ObjectRef3.element;
                        if (pooledConnectionImpl != null) {
                            if (!pooledConnectionImpl.isRecycled) {
                                pooledConnectionImpl.isRecycled = true;
                                if (pooledConnectionImpl.delegate.delegate.inTransaction()) {
                                    SQLite.execSQL(pooledConnectionImpl.delegate, "ROLLBACK TRANSACTION");
                                }
                            }
                            ConnectionWithLock connectionWithLock4 = pooledConnectionImpl.delegate;
                            connectionWithLock4.acquireCoroutineContext = null;
                            connectionWithLock4.acquireThrowable = null;
                            pool.recycle(connectionWithLock4);
                        }
                        return objWithContext;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                pool = pool3;
            }
        } else {
            if (!z3 && pooledConnectionImpl3.isReadOnly) {
                SQLite.throwSQLiteException(1, "Cannot upgrade connection from reader to writer");
                throw null;
            }
            if (anonymousClass1.getContext().get(this.connectionElementKey) == null) {
                CoroutineContext coroutineContextPlus3 = StringsKt__IndentKt.plus(new ConnectionElement(this.connectionElementKey, pooledConnectionImpl3), new ThreadLocalElement(pooledConnectionImpl3, this.connectionThreadLocal));
                App.C01391 c01393 = new App.C01391(function2, pooledConnectionImpl3, continuation, (byte) 6);
                anonymousClass1.label = 1;
                Object objWithContext2 = AwaitKt.withContext(coroutineContextPlus3, c01393, anonymousClass1);
                if (objWithContext2 != coroutineSingletons) {
                    return objWithContext2;
                }
            } else {
                anonymousClass1.label = 2;
                Object objInvoke = function2.invoke(pooledConnectionImpl3, anonymousClass1);
                if (objInvoke != coroutineSingletons) {
                    return objInvoke;
                }
            }
        }
        return coroutineSingletons;
        try {
            throw th;
        } catch (Throwable th6) {
            try {
                PooledConnectionImpl pooledConnectionImpl5 = (PooledConnectionImpl) ref$ObjectRef.element;
                if (pooledConnectionImpl5 == null) {
                    throw th6;
                }
                if (!pooledConnectionImpl5.isRecycled) {
                    pooledConnectionImpl5.isRecycled = true;
                    if (pooledConnectionImpl5.delegate.delegate.inTransaction()) {
                        SQLite.execSQL(pooledConnectionImpl5.delegate, "ROLLBACK TRANSACTION");
                    }
                }
                ConnectionWithLock connectionWithLock5 = pooledConnectionImpl5.delegate;
                connectionWithLock5.acquireCoroutineContext = null;
                connectionWithLock5.acquireThrowable = null;
                pool.recycle(connectionWithLock5);
                throw th6;
            } catch (Throwable th7) {
                ResultKt.addSuppressed(th, th7);
                throw th6;
            }
        }
    }

    public ConnectionPoolImpl(FileLock fileLock) {
        this.connectionElementKey = new CueDecoder((byte) 25);
        this.connectionThreadLocal = new ThreadLocal();
        Path.Companion companion = Duration.Companion;
        this.timeout = InstantKt.toDuration(30, DurationUnit.SECONDS);
        Pool pool = new Pool(1, new RoomDatabase$$ExternalSyntheticLambda0((byte) 25, fileLock));
        this.readers = pool;
        this.writers = pool;
    }
}
