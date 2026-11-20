package androidx.room.coroutines;

import androidx.media3.extractor.text.CueDecoder;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.metrolist.music.App;
import kotlin.SynchronizedLazyImpl;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PassthroughConnectionPool implements ConnectionPool {
    public final SynchronizedLazyImpl connection = new SynchronizedLazyImpl(new RoomDatabase$$ExternalSyntheticLambda0((byte) 26, this));
    public final SQLiteDriver driver;
    public final String fileName;
    public final Function2 transactionWrapper;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ConnectionElement implements CoroutineContext.Element {
        public static final CueDecoder Key = new CueDecoder((byte) 26);
        public final PassthroughConnection connectionWrapper;

        public ConnectionElement(PassthroughConnection passthroughConnection) {
            this.connectionWrapper = passthroughConnection;
        }

        @Override // kotlin.coroutines.CoroutineContext
        public final Object fold(Object obj, Function2 function2) {
            return function2.invoke(obj, this);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public final CoroutineContext.Element get(CoroutineContext.Key key) {
            return StringsKt__IndentKt.get(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element
        public final CoroutineContext.Key getKey() {
            return Key;
        }

        @Override // kotlin.coroutines.CoroutineContext
        public final CoroutineContext minusKey(CoroutineContext.Key key) {
            return StringsKt__IndentKt.minusKey(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public final CoroutineContext plus(CoroutineContext coroutineContext) {
            return StringsKt__IndentKt.plus(this, coroutineContext);
        }
    }

    public PassthroughConnectionPool(SQLiteDriver sQLiteDriver, String str, Function2 function2) {
        this.driver = sQLiteDriver;
        this.fileName = str;
        this.transactionWrapper = function2;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        SynchronizedLazyImpl synchronizedLazyImpl = this.connection;
        if (synchronizedLazyImpl.isInitialized()) {
            ((SQLiteConnection) synchronizedLazyImpl.getValue()).close();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool
    public final Object useConnection(boolean z, Function2 function2, ContinuationImpl continuationImpl) {
        ConnectionElement connectionElement = (ConnectionElement) continuationImpl.getContext().get(ConnectionElement.Key);
        Continuation continuation = null;
        PassthroughConnection passthroughConnection = connectionElement != null ? connectionElement.connectionWrapper : null;
        if (passthroughConnection != null) {
            return function2.invoke(passthroughConnection, continuationImpl);
        }
        PassthroughConnection passthroughConnection2 = new PassthroughConnection(this.transactionWrapper, (SQLiteConnection) this.connection.getValue());
        return AwaitKt.withContext(new ConnectionElement(passthroughConnection2), new App.C01391(function2, passthroughConnection2, continuation, (byte) 8), continuationImpl);
    }
}
