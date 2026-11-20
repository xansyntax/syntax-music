package androidx.room.coroutines;

import androidx.collection.LruCache;
import androidx.room.BindOnlySQLiteStatement;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionWithLock implements SQLiteConnection, Mutex {
    public CoroutineContext acquireCoroutineContext;
    public Throwable acquireThrowable;
    public final SQLiteConnection delegate;
    public final Mutex lock;
    public final PreparedStatementCache preparedStatementCache;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PreparedStatementCache extends LruCache {
        public PreparedStatementCache() {
            super(25);
        }

        @Override // androidx.collection.LruCache
        public final Object create(Object obj) {
            return ConnectionWithLock.this.delegate.prepare((String) obj);
        }

        @Override // androidx.collection.LruCache
        public final void entryRemoved(Object obj, Object obj2, Object obj3) throws Exception {
            ((String) obj).getClass();
            ((SQLiteStatement) obj2).close();
        }
    }

    public ConnectionWithLock(SQLiteConnection sQLiteConnection) {
        MutexImpl mutexImpl = new MutexImpl();
        sQLiteConnection.getClass();
        this.delegate = sQLiteConnection;
        this.lock = mutexImpl;
        this.preparedStatementCache = new PreparedStatementCache();
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        PreparedStatementCache preparedStatementCache = this.preparedStatementCache;
        if (preparedStatementCache != null) {
            preparedStatementCache.trimToSize(-1);
        }
        this.delegate.close();
    }

    public final void dump(StringBuilder sb) {
        int i;
        if (this.acquireCoroutineContext == null && this.acquireThrowable == null) {
            sb.append("\t\tStatus: Free connection");
            sb.append('\n');
        } else {
            sb.append("\t\tStatus: Acquired connection");
            sb.append('\n');
            CoroutineContext coroutineContext = this.acquireCoroutineContext;
            if (coroutineContext != null) {
                sb.append("\t\tCoroutine: " + coroutineContext);
                sb.append('\n');
            }
            Throwable th = this.acquireThrowable;
            if (th != null) {
                sb.append("\t\tAcquired:");
                sb.append('\n');
                Iterator it = CollectionsKt.drop(StringsKt.lines(ResultKt.stackTraceToString(th)), 1).iterator();
                while (it.hasNext()) {
                    sb.append("\t\t" + ((String) it.next()));
                    sb.append('\n');
                }
            }
        }
        if (this.preparedStatementCache != null) {
            StringBuilder sb2 = new StringBuilder("\t\tPrepared Statement Cache Size: ");
            PreparedStatementCache preparedStatementCache = this.preparedStatementCache;
            synchronized (preparedStatementCache.lock) {
                i = preparedStatementCache.size;
            }
            sb2.append(i);
            sb.append(sb2.toString());
            sb.append('\n');
        }
    }

    @Override // androidx.sqlite.SQLiteConnection
    public final boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final Object lock(Continuation continuation) {
        return this.lock.lock(continuation);
    }

    @Override // androidx.sqlite.SQLiteConnection
    public final SQLiteStatement prepare(String str) {
        str.getClass();
        PreparedStatementCache preparedStatementCache = this.preparedStatementCache;
        if (preparedStatementCache == null) {
            return this.delegate.prepare(str);
        }
        Object obj = preparedStatementCache.get(str);
        obj.getClass();
        return new BindOnlySQLiteStatement((SQLiteStatement) obj, (byte) 1);
    }

    public final String toString() {
        return this.delegate.toString();
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final boolean tryLock() {
        return this.lock.tryLock();
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final void unlock(Object obj) {
        this.lock.unlock(null);
    }
}
