package okhttp3.internal.ws;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavDeepLinkRequest;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okio.BlackholeSink;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import okio.RealBufferedSink;
import okio.Socket;
import okio.internal.ResourceFileSystem$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealWebSocket implements WebSocket {
    public static final List ONLY_HTTP1 = CollectionsKt__IterablesKt.listOf(Protocol.HTTP_1_1);
    public boolean awaitingPong;
    public RealCall call;
    public boolean enqueuedClose;
    public WebSocketExtensions extensions;
    public boolean failed;
    public final String key;
    public final WebSocketListener listener;
    public final ArrayDeque messageAndCloseQueue;
    public final short minimumDeflateSize;
    public String name;
    public final long pingIntervalMillis;
    public final ArrayDeque pongQueue;
    public long queueSize;
    public final Random random;
    public WebSocketReader reader;
    public int receivedCloseCode;
    public String receivedCloseReason;
    public int sentPingCount;
    public NavDeepLinkRequest socket;
    public final TaskQueue taskQueue;
    public final long webSocketCloseTimeout;
    public WebSocketWriter writer;
    public WriterTask writerTask;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Close {
        public final long cancelAfterCloseMillis;
        public final int code;
        public final ByteString reason;

        public Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Message {
        public final ByteString data;
        public final byte formatOpcode;

        /* JADX WARN: Multi-variable type inference failed */
        public Message(int i, ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [int, short] */
    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random, long j, long j2, long j3) {
        taskRunner.getClass();
        request.getClass();
        webSocketListener.getClass();
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j;
        this.extensions = null;
        this.minimumDeflateSize = (int) j2;
        this.webSocketCloseTimeout = j3;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        String str = request.method;
        if (!"GET".equals(str)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Request must be GET: ", str));
            throw null;
        }
        ByteString byteString = ByteString.EMPTY;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = Path.Companion.of$default(bArr).base64();
    }

    public static void failWebSocket$default(RealWebSocket realWebSocket, Exception exc, Response response, int i) {
        WebSocketWriter webSocketWriter;
        if ((i & 2) != 0) {
            response = null;
        }
        byte b = 0;
        boolean z = (i & 4) == 0;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (realWebSocket) {
            try {
                if (realWebSocket.failed) {
                    return;
                }
                realWebSocket.failed = true;
                NavDeepLinkRequest navDeepLinkRequest = realWebSocket.socket;
                WebSocketWriter webSocketWriter2 = realWebSocket.writer;
                ref$ObjectRef.element = webSocketWriter2;
                realWebSocket.writer = null;
                if (!z && webSocketWriter2 != null) {
                    TaskQueue.execute$default(realWebSocket.taskQueue, realWebSocket.name + " writer close", 0L, new RealWebSocket$$ExternalSyntheticLambda2(ref$ObjectRef, b), 2);
                }
                realWebSocket.taskQueue.shutdown();
                try {
                    realWebSocket.listener.onFailure(realWebSocket, exc, response);
                } finally {
                    if (navDeepLinkRequest != null) {
                        navDeepLinkRequest.cancel();
                    }
                    if (z && (webSocketWriter = (WebSocketWriter) ref$ObjectRef.element) != null) {
                        _UtilCommonKt.closeQuietly(webSocketWriter);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void cancel() {
        RealCall realCall = this.call;
        realCall.getClass();
        realCall.cancel();
    }

    public final Socket checkUpgradeSuccess$okhttp(Response response) throws ProtocolException {
        int i = response.code;
        if (i != 101) {
            StringBuilder sb = new StringBuilder("Expected HTTP 101 response but was '");
            sb.append(i);
            sb.append(' ');
            throw new ProtocolException(Format$$ExternalSyntheticOutline0.m(sb, response.message, '\''));
        }
        String strHeader$default = Response.header$default(HttpHeaders.Connection, response);
        if (!HttpHeaders.Upgrade.equalsIgnoreCase(strHeader$default)) {
            throw new ProtocolException(Format$$ExternalSyntheticOutline0.m('\'', "Expected 'Connection' header value 'Upgrade' but was '", strHeader$default));
        }
        String strHeader$default2 = Response.header$default(HttpHeaders.Upgrade, response);
        if (!"websocket".equalsIgnoreCase(strHeader$default2)) {
            throw new ProtocolException(Format$$ExternalSyntheticOutline0.m('\'', "Expected 'Upgrade' header value 'websocket' but was '", strHeader$default2));
        }
        String strHeader$default3 = Response.header$default(HttpHeaders.SecWebSocketAccept, response);
        ByteString byteString = ByteString.EMPTY;
        String strBase64 = Path.Companion.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").digest$okio("SHA-1").base64();
        if (strBase64.equals(strHeader$default3)) {
            Socket socket = response.socket;
            if (socket != null) {
                return socket;
            }
            throw new ProtocolException("Web Socket socket missing: bad interceptor?");
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader$default3 + '\'');
    }

    public final boolean close(int i, String str) {
        String str2;
        long j = this.webSocketCloseTimeout;
        synchronized (this) {
            ByteString byteStringEncodeUtf8 = null;
            try {
                if (i < 1000 || i >= 5000) {
                    str2 = "Code must be in range [1000,5000): " + i;
                } else if ((1004 > i || i >= 1007) && (1015 > i || i >= 3000)) {
                    str2 = null;
                } else {
                    str2 = "Code " + i + " is reserved and may not be used.";
                }
                if (str2 != null) {
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    ByteString byteString = ByteString.EMPTY;
                    byteStringEncodeUtf8 = Path.Companion.encodeUtf8(str);
                    if (byteStringEncodeUtf8.data.length > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                    }
                }
                if (!this.failed && !this.enqueuedClose) {
                    this.enqueuedClose = true;
                    this.messageAndCloseQueue.add(new Close(i, byteStringEncodeUtf8, j));
                    runWriter();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finishReader() {
        int i;
        String str;
        WebSocketReader webSocketReader;
        boolean z;
        synchronized (this) {
            try {
                i = this.receivedCloseCode;
                str = this.receivedCloseReason;
                webSocketReader = this.reader;
                this.reader = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    WebSocketWriter webSocketWriter = this.writer;
                    if (webSocketWriter != null) {
                        this.writer = null;
                        TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, new ResourceFileSystem$$ExternalSyntheticLambda0((byte) 8, webSocketWriter), 2);
                    }
                    this.taskQueue.shutdown();
                }
                z = (this.failed || this.writer != null || this.receivedCloseCode == -1) ? false : true;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            WebSocketListener webSocketListener = this.listener;
            str.getClass();
            webSocketListener.onClosed(this, i, str);
        }
        if (webSocketReader != null) {
            _UtilCommonKt.closeQuietly(webSocketReader);
        }
    }

    public final void runWriter() {
        TimeZone timeZone = _UtilJvmKt.UTC;
        WriterTask writerTask = this.writerTask;
        if (writerTask != null) {
            this.taskQueue.schedule(writerTask, 0L);
        }
    }

    public final synchronized boolean send(int i, ByteString byteString) {
        if (!this.failed && !this.enqueuedClose) {
            long j = this.queueSize;
            byte[] bArr = byteString.data;
            if (((long) bArr.length) + j > 16777216) {
                close(1001, null);
                return false;
            }
            this.queueSize = j + ((long) bArr.length);
            this.messageAndCloseQueue.add(new Message(i, byteString));
            runWriter();
            return true;
        }
        return false;
    }

    public final boolean writeOneFrame$okhttp() {
        WebSocketWriter webSocketWriter;
        Object obj;
        String str;
        synchronized (this) {
            try {
                boolean z = false;
                if (this.failed) {
                    return false;
                }
                WebSocketWriter webSocketWriter2 = this.writer;
                Object objPoll = this.pongQueue.poll();
                String str2 = null;
                int i = -1;
                if (objPoll == null) {
                    Object objPoll2 = this.messageAndCloseQueue.poll();
                    if (objPoll2 instanceof Close) {
                        int i2 = this.receivedCloseCode;
                        str = this.receivedCloseReason;
                        if (i2 != -1) {
                            WebSocketWriter webSocketWriter3 = this.writer;
                            this.writer = null;
                            if (webSocketWriter3 != null && this.reader == null) {
                                z = true;
                            }
                            this.taskQueue.shutdown();
                            webSocketWriter = webSocketWriter3;
                            i = i2;
                            obj = objPoll2;
                        } else {
                            long j = ((Close) objPoll2).cancelAfterCloseMillis;
                            TaskQueue.execute$default(this.taskQueue, this.name + " cancel", TimeUnit.MILLISECONDS.toNanos(j), new ResourceFileSystem$$ExternalSyntheticLambda0((byte) 9, this), 4);
                            i = i2;
                            obj = objPoll2;
                            webSocketWriter = null;
                        }
                    } else {
                        if (objPoll2 == null) {
                            return false;
                        }
                        str = null;
                        obj = objPoll2;
                        webSocketWriter = null;
                    }
                } else {
                    webSocketWriter = null;
                    obj = null;
                    str = null;
                }
                try {
                    if (objPoll != null) {
                        webSocketWriter2.getClass();
                        webSocketWriter2.writeControlFrame(10, (ByteString) objPoll);
                    } else if (obj instanceof Message) {
                        webSocketWriter2.getClass();
                        webSocketWriter2.writeMessageFrame(((Message) obj).formatOpcode, ((Message) obj).data);
                        synchronized (this) {
                            this.queueSize -= (long) ((Message) obj).data.data.length;
                        }
                    } else {
                        if (!(obj instanceof Close)) {
                            throw new AssertionError();
                        }
                        webSocketWriter2.getClass();
                        int i3 = ((Close) obj).code;
                        ByteString byteString = ((Close) obj).reason;
                        ByteString byteString2 = ByteString.EMPTY;
                        if (i3 != 0 || byteString != null) {
                            if (i3 != 0) {
                                if (i3 < 1000 || i3 >= 5000) {
                                    str2 = "Code must be in range [1000,5000): " + i3;
                                } else if ((1004 <= i3 && i3 < 1007) || (1015 <= i3 && i3 < 3000)) {
                                    str2 = "Code " + i3 + " is reserved and may not be used.";
                                }
                                if (str2 != null) {
                                    throw new IllegalArgumentException(str2.toString());
                                }
                            }
                            Buffer buffer = new Buffer();
                            buffer.writeShort(i3);
                            if (byteString != null) {
                                buffer.write(byteString);
                            }
                            byteString2 = buffer.readByteString(buffer.size);
                        }
                        try {
                            webSocketWriter2.writeControlFrame(8, byteString2);
                            webSocketWriter2.writerClosed = true;
                            if (z) {
                                WebSocketListener webSocketListener = this.listener;
                                str.getClass();
                                webSocketListener.onClosed(this, i, str);
                            }
                        } catch (Throwable th) {
                            webSocketWriter2.writerClosed = true;
                            throw th;
                        }
                    }
                    if (webSocketWriter != null) {
                        _UtilCommonKt.closeQuietly(webSocketWriter);
                    }
                    return true;
                } catch (Throwable th2) {
                    if (webSocketWriter != null) {
                        _UtilCommonKt.closeQuietly(webSocketWriter);
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class WriterTask extends Task {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WriterTask(RealWebSocket realWebSocket) {
            super(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), realWebSocket.name, " writer"), true);
            this.$r8$classId = (byte) 0;
            this.this$0 = realWebSocket;
        }

        @Override // okhttp3.internal.concurrent.Task
        public final long runOnce() {
            int i = 0;
            RealConnection realConnection = null;
            switch (this.$r8$classId) {
                case 0:
                    RealWebSocket realWebSocket = (RealWebSocket) this.this$0;
                    try {
                        if (realWebSocket.writeOneFrame$okhttp()) {
                            return 0L;
                        }
                    } catch (IOException e) {
                        RealWebSocket.failWebSocket$default(realWebSocket, e, null, 2);
                    }
                    return -1L;
                case 1:
                    DiskLruCache diskLruCache = (DiskLruCache) this.this$0;
                    synchronized (diskLruCache) {
                        if (diskLruCache.initialized && !diskLruCache.closed) {
                            try {
                                diskLruCache.trimToSize();
                            } catch (IOException unused) {
                                diskLruCache.mostRecentTrimFailed = true;
                            }
                            try {
                                if (diskLruCache.journalRebuildRequired()) {
                                    diskLruCache.rebuildJournal$okhttp();
                                    diskLruCache.redundantOpCount = 0;
                                }
                            } catch (IOException unused2) {
                                diskLruCache.mostRecentRebuildFailed = true;
                                RealBufferedSink realBufferedSink = diskLruCache.journalWriter;
                                if (realBufferedSink != null) {
                                    _UtilCommonKt.closeQuietly(realBufferedSink);
                                }
                                diskLruCache.journalWriter = new RealBufferedSink(new BlackholeSink());
                            }
                        }
                        break;
                    }
                    return -1L;
                default:
                    RealConnectionPool realConnectionPool = (RealConnectionPool) this.this$0;
                    long jNanoTime = System.nanoTime();
                    long j = (jNanoTime - realConnectionPool.keepAliveDurationNs) + 1;
                    Iterator it = realConnectionPool.connections.iterator();
                    it.getClass();
                    RealConnection realConnection2 = null;
                    RealConnection realConnection3 = null;
                    long j2 = Long.MAX_VALUE;
                    long j3 = j;
                    int i2 = 0;
                    while (it.hasNext()) {
                        RealConnection realConnection4 = (RealConnection) it.next();
                        realConnection4.getClass();
                        synchronized (realConnection4) {
                            if (realConnectionPool.pruneAndGetAllocationCount(realConnection4, jNanoTime) > 0) {
                                i2++;
                            } else {
                                long j4 = realConnection4.idleAtNs;
                                if (j4 < j3) {
                                    realConnection2 = realConnection4;
                                    j3 = j4;
                                }
                                i++;
                                if (j4 < j2) {
                                    realConnection3 = realConnection4;
                                    j2 = j4;
                                }
                            }
                        }
                    }
                    if (realConnection2 != null) {
                        realConnection = realConnection2;
                    } else if (i > realConnectionPool.maxIdleConnections) {
                        j3 = j2;
                        realConnection = realConnection3;
                    } else {
                        j3 = -1;
                    }
                    if (realConnection == null) {
                        if (realConnection3 != null) {
                            return (j2 + realConnectionPool.keepAliveDurationNs) - jNanoTime;
                        }
                        if (i2 > 0) {
                            return realConnectionPool.keepAliveDurationNs;
                        }
                        return -1L;
                    }
                    synchronized (realConnection) {
                        if (realConnection.calls.isEmpty() && realConnection.idleAtNs == j3) {
                            realConnection.noNewExchanges = true;
                            realConnectionPool.connections.remove(realConnection);
                            _UtilJvmKt.closeQuietly(realConnection.javaNetSocket);
                            if (realConnectionPool.connections.isEmpty()) {
                                realConnectionPool.cleanupQueue.cancelAll();
                            }
                        }
                    }
                    return 0L;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ WriterTask(byte b, Object obj, String str) {
            super(str, true);
            this.$r8$classId = b;
            this.this$0 = obj;
        }
    }
}
