package androidx.room.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Pool {
    public final ArrayDeque availableConnections;
    public final int capacity;
    public final Function0 connectionFactory;
    public final SemaphoreImpl connectionPermits;
    public final ConnectionWithLock[] connections;
    public boolean isClosed;
    public final ReentrantLock lock = new ReentrantLock();
    public int size;

    /* JADX INFO: renamed from: androidx.room.coroutines.Pool$acquire$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pool.this.acquire(this);
        }
    }

    public Pool(int i, Function0 function0) {
        this.capacity = i;
        this.connectionFactory = function0;
        this.connections = new ConnectionWithLock[i];
        int i2 = SemaphoreKt.MAX_SPIN_CYCLES;
        this.connectionPermits = new SemaphoreImpl(i);
        this.availableConnections = new ArrayDeque(i);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object acquire(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        ArrayDeque arrayDeque = this.availableConnections;
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
        SemaphoreImpl semaphoreImpl = this.connectionPermits;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.label = 1;
            Object objAcquire = semaphoreImpl.acquire(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAcquire == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        try {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.isClosed) {
                    SQLite.throwSQLiteException(21, "Connection pool is closed");
                    throw null;
                }
                if (arrayDeque.isEmpty() && this.size < this.capacity) {
                    ConnectionWithLock connectionWithLock = new ConnectionWithLock((SQLiteConnection) this.connectionFactory.invoke());
                    ConnectionWithLock[] connectionWithLockArr = this.connections;
                    int i3 = this.size;
                    this.size = i3 + 1;
                    connectionWithLockArr[i3] = connectionWithLock;
                    arrayDeque.addLast(connectionWithLock);
                }
                ConnectionWithLock connectionWithLock2 = (ConnectionWithLock) arrayDeque.removeLast();
                reentrantLock.unlock();
                return connectionWithLock2;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            semaphoreImpl.release();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0057 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x006f A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:30:0x006b, B:32:0x006f, B:36:0x0077, B:40:0x007e), top: B:45:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:30:0x006b, B:32:0x006f, B:36:0x0077, B:40:0x007e), top: B:45:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x007b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x007e A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:30:0x006b, B:32:0x006f, B:36:0x0077, B:40:0x007e), top: B:45:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0058 -> B:25:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:24:0x0058
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: acquireWithTimeout-KLykuaI, reason: not valid java name */
    public final java.lang.Object m844acquireWithTimeoutKLykuaI(long r8, com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda1 r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof androidx.room.coroutines.Pool$acquireWithTimeout$1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = (androidx.room.coroutines.Pool$acquireWithTimeout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = new androidx.room.coroutines.Pool$acquireWithTimeout$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2e
            long r8 = r0.J$0
            kotlin.jvm.internal.Ref$ObjectRef r10 = r0.L$1
            kotlin.jvm.functions.Function0 r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L2c
            goto L5a
        L2c:
            r11 = move-exception
            goto L66
        L2e:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            return r3
        L34:
            kotlin.ResultKt.throwOnFailure(r11)
        L37:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            coil3.RealImageLoader$execute$2 r1 = new coil3.RealImageLoader$execute$2     // Catch: java.lang.Throwable -> L64
            r4 = 27
            r1.<init>(r11, r7, r3, r4)     // Catch: java.lang.Throwable -> L64
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L64
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L64
            r0.J$0 = r8     // Catch: java.lang.Throwable -> L64
            r0.label = r2     // Catch: java.lang.Throwable -> L64
            long r4 = kotlinx.coroutines.AwaitKt.m1898toDelayMillisLRDsOJo(r8)     // Catch: java.lang.Throwable -> L64
            java.lang.Object r1 = kotlinx.coroutines.AwaitKt.withTimeout(r4, r1, r0)     // Catch: java.lang.Throwable -> L64
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 != r4) goto L58
            return r4
        L58:
            r1 = r10
            r10 = r11
        L5a:
            r11 = r10
            r10 = r1
            r1 = r0
            r0 = r3
            goto L6b
        L5f:
            r6 = r1
            r1 = r10
            r10 = r11
            r11 = r6
            goto L66
        L64:
            r1 = move-exception
            goto L5f
        L66:
            r6 = r11
            r11 = r10
            r10 = r1
            r1 = r0
            r0 = r6
        L6b:
            boolean r4 = r0 instanceof kotlinx.coroutines.TimeoutCancellationException     // Catch: java.lang.Throwable -> L73
            if (r4 == 0) goto L75
            r10.invoke()     // Catch: java.lang.Throwable -> L73
            goto L7c
        L73:
            r8 = move-exception
            goto L7f
        L75:
            if (r0 != 0) goto L7e
            java.lang.Object r11 = r11.element     // Catch: java.lang.Throwable -> L73
            if (r11 == 0) goto L7c
            return r11
        L7c:
            r0 = r1
            goto L37
        L7e:
            throw r0     // Catch: java.lang.Throwable -> L73
        L7f:
            java.lang.Object r9 = r11.element
            androidx.room.coroutines.ConnectionWithLock r9 = (androidx.room.coroutines.ConnectionWithLock) r9
            if (r9 == 0) goto L88
            r7.recycle(r9)
        L88:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.m844acquireWithTimeoutKLykuaI(long, com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void dump(StringBuilder sb) {
        ArrayDeque arrayDeque = this.availableConnections;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
            int i = arrayDeque.size;
            for (int i2 = 0; i2 < i; i2++) {
                listBuilderCreateListBuilder.add(arrayDeque.get(i2));
            }
            ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
            sb.append('\t' + toString() + " (");
            sb.append("capacity=" + this.capacity + ", ");
            sb.append("permits=" + Math.max(ArtificialStackFramesUnsafe.unsafe.getIntVolatile(this.connectionPermits, SemaphoreAndMutexImpl._availablePermits$volatile$FU$offset), 0) + ", ");
            sb.append("queue=(size=" + listBuilderBuild.getSize() + ")[" + CollectionsKt.joinToString$default(listBuilderBuild, null, null, null, null, 63) + ']');
            sb.append(")");
            sb.append('\n');
            ConnectionWithLock[] connectionWithLockArr = this.connections;
            int length = connectionWithLockArr.length;
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                ConnectionWithLock connectionWithLock = connectionWithLockArr[i4];
                i3++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\t\t[");
                sb2.append(i3);
                sb2.append("] - ");
                sb2.append(connectionWithLock != null ? connectionWithLock.delegate.toString() : null);
                sb.append(sb2.toString());
                sb.append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.dump(sb);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void recycle(ConnectionWithLock connectionWithLock) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connectionWithLock);
            reentrantLock.unlock();
            this.connectionPermits.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
