package okhttp3.internal.connection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealConnectionPool {
    public final TaskQueue cleanupQueue;
    public final RealWebSocket.WriterTask cleanupTask;
    public final ConcurrentLinkedQueue connections;
    public final long keepAliveDurationNs;
    public final byte maxIdleConnections;

    /* JADX WARN: Multi-variable type inference failed */
    public RealConnectionPool(TaskRunner taskRunner, int i) {
        TimeUnit.MINUTES.getClass();
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = 300000000000L;
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new RealWebSocket.WriterTask((byte) 2, this, IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), _UtilJvmKt.okHttpName, " ConnectionPool connection closer"));
        this.connections = new ConcurrentLinkedQueue();
    }

    public final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        TimeZone timeZone = _UtilJvmKt.UTC;
        ArrayList arrayList = realConnection.calls;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + realConnection.route.address.url + " was leaked. Did you forget to close a response body?";
                Platform platform = Platform.platform;
                Platform.platform.logCloseableLeak(((RealCall.CallReference) reference).callStackTrace, str);
                arrayList.remove(i);
                if (arrayList.isEmpty()) {
                    realConnection.idleAtNs = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
