package okhttp3.internal.http2;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntProgression;
import kotlin.uuid.UuidKt;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskQueue;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Http2Reader implements Closeable {
    public static final Logger logger;
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final RealBufferedSource source;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        public static int lengthWithoutPadding(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(Fragment$5$$ExternalSyntheticOutline0.m(i3, i, "PROTOCOL_ERROR padding ", " > remaining length "));
            return 0;
        }
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        logger2.getClass();
        logger = logger2;
    }

    public Http2Reader(RealBufferedSource realBufferedSource) {
        this.source = realBufferedSource;
        ContinuationSource continuationSource = new ContinuationSource(realBufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.source.close();
    }

    /* JADX WARN: Code duplicated, block: B:189:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:197:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:200:0x02f5 A[Catch: all -> 0x02fb, TRY_LEAVE, TryCatch #5 {, blocks: (B:198:0x02ef, B:200:0x02f5), top: B:240:0x02ef }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0303  */
    /* JADX WARN: Code duplicated, block: B:240:0x02ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0103  */
    /* JADX WARN: Code duplicated, block: B:70:0x0107  */
    /* JADX WARN: Code duplicated, block: B:77:0x012d  */
    /* JADX WARN: Code duplicated, block: B:98:0x015f  */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean nextFrame(boolean z, Http2Connection.ReaderRunnable readerRunnable) throws Exception {
        Http2Connection http2Connection;
        Http2Stream http2StreamRemoveStream$okhttp;
        ByteString byteString;
        Http2Connection http2Connection2;
        Object[] objArr = 0;
        try {
            this.source.require(9L);
            int medium = _UtilCommonKt.readMedium(this.source);
            if (medium > 16384) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(medium, "FRAME_SIZE_ERROR: "));
                return false;
            }
            int i = this.source.readByte() & 255;
            byte b = this.source.readByte();
            int i2 = b & 255;
            int i3 = this.source.readInt();
            int i4 = Integer.MAX_VALUE & i3;
            byte b2 = 8;
            byte b3 = 1;
            if (i != 8) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.frameLog(true, i4, medium, i, i2));
                }
            }
            if (z && i != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$5(Http2.formattedType$okhttp(i), "Expected a SETTINGS frame but was ");
                return false;
            }
            ErrorCode errorCode = null;
            switch (i) {
                case 0:
                    readData(readerRunnable, medium, i2, i4);
                    return true;
                case 1:
                    readHeaders(readerRunnable, medium, i2, i4);
                    return true;
                case 2:
                    if (medium != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(medium, "TYPE_PRIORITY length: ", " != 5"));
                        return false;
                    }
                    if (i4 == 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("TYPE_PRIORITY streamId == 0");
                        return false;
                    }
                    RealBufferedSource realBufferedSource = this.source;
                    realBufferedSource.readInt();
                    realBufferedSource.readByte();
                    return true;
                case 3:
                    if (medium != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(medium, "TYPE_RST_STREAM length: ", " != 4"));
                        return false;
                    }
                    if (i4 == 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("TYPE_RST_STREAM streamId == 0");
                        return false;
                    }
                    int i5 = this.source.readInt();
                    ErrorCode.Companion.getClass();
                    for (ErrorCode errorCode2 : ErrorCode.values()) {
                        if (errorCode2.httpCode == i5) {
                            errorCode = errorCode2;
                            if (errorCode != null) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i5, "TYPE_RST_STREAM unexpected error code: "));
                                return false;
                            }
                            http2Connection = (Http2Connection) readerRunnable.this$0;
                            if (i4 == 0 && (i3 & 1) == 0) {
                                TaskQueue.execute$default(http2Connection.pushQueue, http2Connection.connectionName + '[' + i4 + "] onReset", 0L, new Http2Connection$$ExternalSyntheticLambda5(http2Connection, i4, errorCode, b3), 6);
                                return true;
                            }
                            http2StreamRemoveStream$okhttp = http2Connection.removeStream$okhttp(i4);
                            if (http2StreamRemoveStream$okhttp != null) {
                                synchronized (http2StreamRemoveStream$okhttp) {
                                    if (http2StreamRemoveStream$okhttp.getErrorCode$okhttp() == null) {
                                        http2StreamRemoveStream$okhttp.errorCode = errorCode;
                                        http2StreamRemoveStream$okhttp.notifyAll();
                                    }
                                    break;
                                }
                                return true;
                            }
                            return true;
                        }
                    }
                    if (errorCode != null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i5, "TYPE_RST_STREAM unexpected error code: "));
                        return false;
                    }
                    http2Connection = (Http2Connection) readerRunnable.this$0;
                    if (i4 == 0) {
                    }
                    http2StreamRemoveStream$okhttp = http2Connection.removeStream$okhttp(i4);
                    if (http2StreamRemoveStream$okhttp != null) {
                        synchronized (http2StreamRemoveStream$okhttp) {
                            if (http2StreamRemoveStream$okhttp.getErrorCode$okhttp() == null) {
                                http2StreamRemoveStream$okhttp.errorCode = errorCode;
                                http2StreamRemoveStream$okhttp.notifyAll();
                                break;
                            }
                            return true;
                        }
                    }
                    return true;
                case 4:
                    RealBufferedSource realBufferedSource2 = this.source;
                    if (i4 != 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("TYPE_SETTINGS streamId != 0");
                        return false;
                    }
                    if ((b & 1) != 0) {
                        if (medium != 0) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("FRAME_SIZE_ERROR ack frame should be empty!");
                            return false;
                        }
                        return true;
                    }
                    if (medium % 6 != 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(medium, "TYPE_SETTINGS length % 6 != 0: "));
                        return false;
                    }
                    Settings settings = new Settings();
                    IntProgression intProgressionStep = UuidKt.step(UuidKt.until(0, medium), 6);
                    int i6 = intProgressionStep.first;
                    int i7 = intProgressionStep.last;
                    int i8 = intProgressionStep.step;
                    if ((i8 > 0 && i6 <= i7) || (i8 < 0 && i7 <= i6)) {
                        while (true) {
                            short s = realBufferedSource2.readShort();
                            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                            int i9 = s & 65535;
                            int i10 = realBufferedSource2.readInt();
                            if (i9 != 2) {
                                if (i9 != 4) {
                                    if (i9 == 5 && (i10 < 16384 || i10 > 16777215)) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i10, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
                                        return false;
                                    }
                                } else if (i10 < 0) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                    return false;
                                }
                            } else if (i10 != 0 && i10 != 1) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                return false;
                            }
                            settings.set(i9, i10);
                            if (i6 != i7) {
                                i6 += i8;
                            }
                        }
                    }
                    Http2Connection http2Connection3 = (Http2Connection) readerRunnable.this$0;
                    TaskQueue.execute$default(http2Connection3.writerQueue, IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), http2Connection3.connectionName, " applyAndAckSettings"), 0L, new Url$$ExternalSyntheticLambda1(readerRunnable, settings, b2), 6);
                    return true;
                case 5:
                    readPushPromise(readerRunnable, medium, i2, i4);
                    return true;
                case 6:
                    if (medium != 8) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(medium, "TYPE_PING length != 8: "));
                        return false;
                    }
                    if (i4 != 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("TYPE_PING streamId != 0");
                        return false;
                    }
                    int i11 = this.source.readInt();
                    int i12 = this.source.readInt();
                    Object[] objArr2 = (b & 1) != 0;
                    Http2Connection http2Connection4 = (Http2Connection) readerRunnable.this$0;
                    if (objArr2 != true) {
                        TaskQueue.execute$default(http2Connection4.writerQueue, IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), ((Http2Connection) readerRunnable.this$0).connectionName, " ping"), 0L, new Http2Connection$ReaderRunnable$$ExternalSyntheticLambda0((Http2Connection) readerRunnable.this$0, i11, i12, objArr == true ? 1 : 0), 6);
                        return true;
                    }
                    synchronized (http2Connection4) {
                        try {
                            if (i11 == 1) {
                                http2Connection4.intervalPongsReceived++;
                            } else if (i11 == 2) {
                                http2Connection4.degradedPongsReceived++;
                            } else if (i11 == 3) {
                                http2Connection4.notifyAll();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return true;
                case 7:
                    if (medium < 8) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(medium, "TYPE_GOAWAY length < 8: "));
                        return false;
                    }
                    if (i4 != 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("TYPE_GOAWAY streamId != 0");
                        return false;
                    }
                    int i13 = this.source.readInt();
                    int i14 = this.source.readInt();
                    int i15 = medium - 8;
                    ErrorCode.Companion.getClass();
                    for (ErrorCode errorCode3 : ErrorCode.values()) {
                        if (errorCode3.httpCode == i14) {
                            errorCode = errorCode3;
                            if (errorCode != null) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i14, "TYPE_GOAWAY unexpected error code: "));
                                return false;
                            }
                            byteString = ByteString.EMPTY;
                            if (i15 > 0) {
                                byteString = this.source.readByteString(i15);
                            }
                            byteString.getClass();
                            byteString.getSize$okio();
                            http2Connection2 = (Http2Connection) readerRunnable.this$0;
                            synchronized (http2Connection2) {
                                Object[] array = http2Connection2.streams.values().toArray(new Http2Stream[0]);
                                http2Connection2.isShutdown = true;
                            }
                            for (Http2Stream http2Stream : (Http2Stream[]) array) {
                                if (http2Stream.id <= i13 && http2Stream.isLocallyInitiated()) {
                                    ErrorCode errorCode4 = ErrorCode.REFUSED_STREAM;
                                    synchronized (http2Stream) {
                                        if (http2Stream.getErrorCode$okhttp() == null) {
                                            http2Stream.errorCode = errorCode4;
                                            http2Stream.notifyAll();
                                        }
                                        break;
                                    }
                                    ((Http2Connection) readerRunnable.this$0).removeStream$okhttp(http2Stream.id);
                                }
                            }
                            return true;
                        }
                    }
                    if (errorCode != null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i14, "TYPE_GOAWAY unexpected error code: "));
                        return false;
                    }
                    byteString = ByteString.EMPTY;
                    if (i15 > 0) {
                        byteString = this.source.readByteString(i15);
                    }
                    byteString.getClass();
                    byteString.getSize$okio();
                    http2Connection2 = (Http2Connection) readerRunnable.this$0;
                    synchronized (http2Connection2) {
                        Object[] array2 = http2Connection2.streams.values().toArray(new Http2Stream[0]);
                        http2Connection2.isShutdown = true;
                        while (i < r13) {
                            if (http2Stream.id <= i13) {
                            }
                        }
                        return true;
                    }
                case 8:
                    try {
                        if (medium != 4) {
                            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + medium);
                        }
                        long j = ((long) this.source.readInt()) & 2147483647L;
                        if (j == 0) {
                            throw new IOException("windowSizeIncrement was 0");
                        }
                        Logger logger3 = logger;
                        if (logger3.isLoggable(Level.FINE)) {
                            logger3.fine(Http2.frameLogWindowUpdate(i4, medium, j, true));
                        }
                        Http2Connection http2Connection5 = (Http2Connection) readerRunnable.this$0;
                        if (i4 == 0) {
                            synchronized (http2Connection5) {
                                http2Connection5.writeBytesMaximum += j;
                                http2Connection5.notifyAll();
                            }
                            return true;
                        }
                        Http2Stream stream = http2Connection5.getStream(i4);
                        if (stream != null) {
                            synchronized (stream) {
                                stream.writeBytesMaximum += j;
                                if (j > 0) {
                                    stream.notifyAll();
                                }
                                break;
                            }
                            return true;
                        }
                        return true;
                    } catch (Exception e) {
                        logger.fine(Http2.frameLog(true, i4, medium, 8, i2));
                        throw e;
                    }
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
        }
    }

    public final void readData(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, final int i3) throws IOException {
        int i4;
        boolean z;
        boolean z2;
        if (i3 == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
            return;
        }
        final boolean z3 = true;
        if ((i2 & 1) == 0) {
            z3 = false;
        }
        if ((i2 & 32) != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
            return;
        }
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        final int iLengthWithoutPadding = Companion.lengthWithoutPadding(i, i2, i4);
        RealBufferedSource realBufferedSource = this.source;
        final Http2Connection http2Connection = (Http2Connection) readerRunnable.this$0;
        if (i3 != 0 && (i3 & 1) == 0) {
            final Buffer buffer = new Buffer();
            long j = iLengthWithoutPadding;
            realBufferedSource.require(j);
            realBufferedSource.read(buffer, j);
            TaskQueue.execute$default(http2Connection.pushQueue, http2Connection.connectionName + '[' + i3 + "] onData", 0L, new Function0(i3, buffer, iLengthWithoutPadding, z3) { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda4
                public final /* synthetic */ int f$1;
                public final /* synthetic */ Buffer f$2;
                public final /* synthetic */ int f$3;

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Http2Connection http2Connection2 = this.f$0;
                    int i5 = this.f$1;
                    Buffer buffer2 = this.f$2;
                    int i6 = this.f$3;
                    try {
                        http2Connection2.pushObserver.getClass();
                        buffer2.skip(i6);
                        http2Connection2.writer.rstStream(i5, ErrorCode.CANCEL);
                        synchronized (http2Connection2) {
                            http2Connection2.currentPushRequests.remove(Integer.valueOf(i5));
                        }
                    } catch (IOException unused) {
                    }
                    return Unit.INSTANCE;
                }
            }, 6);
        } else {
            Http2Stream stream = http2Connection.getStream(i3);
            if (stream == null) {
                ((Http2Connection) readerRunnable.this$0).writeSynResetLater$okhttp(i3, ErrorCode.PROTOCOL_ERROR);
                long j2 = iLengthWithoutPadding;
                ((Http2Connection) readerRunnable.this$0).updateConnectionFlowControl$okhttp(j2);
                realBufferedSource.skip(j2);
            } else {
                TimeZone timeZone = _UtilJvmKt.UTC;
                Http2Stream.FramingSource framingSource = stream.source;
                long j3 = iLengthWithoutPadding;
                framingSource.getClass();
                long j4 = j3;
                while (true) {
                    Http2Stream http2Stream = Http2Stream.this;
                    if (j4 <= 0) {
                        TimeZone timeZone2 = _UtilJvmKt.UTC;
                        http2Stream.connection.updateConnectionFlowControl$okhttp(j3);
                        Http2Stream.this.connection.flowControlListener.getClass();
                        break;
                    }
                    synchronized (http2Stream) {
                        z = framingSource.finished;
                        z2 = framingSource.readBuffer.size + j4 > framingSource.maxByteCount;
                    }
                    if (z2) {
                        realBufferedSource.skip(j4);
                        Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        break;
                    }
                    if (z) {
                        realBufferedSource.skip(j4);
                        break;
                    }
                    long j5 = realBufferedSource.read(framingSource.receiveBuffer, j4);
                    if (j5 == -1) {
                        throw new EOFException();
                    }
                    j4 -= j5;
                    Http2Stream http2Stream2 = Http2Stream.this;
                    synchronized (http2Stream2) {
                        try {
                            if (framingSource.closed) {
                                framingSource.receiveBuffer.clear();
                            } else {
                                Buffer buffer2 = framingSource.readBuffer;
                                boolean z4 = buffer2.size == 0;
                                buffer2.writeAll(framingSource.receiveBuffer);
                                if (z4) {
                                    http2Stream2.notifyAll();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                if (z3) {
                    stream.receiveHeaders(Headers.EMPTY, true);
                }
            }
        }
        this.source.skip(i4);
    }

    public final List readHeaderBlock(int i, int i2, int i3, int i4) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.padding = i2;
        continuationSource.flags = i3;
        continuationSource.streamId = i4;
        Hpack.Reader reader = this.hpackReader;
        RealBufferedSource realBufferedSource = reader.source;
        while (!realBufferedSource.exhausted()) {
            byte b = realBufferedSource.readByte();
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            int i5 = b & 255;
            if (i5 == 128) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("index == 0");
                return null;
            }
            if ((b & 128) == 128) {
                int i6 = reader.readInt(i5, 127);
                int i7 = i6 - 1;
                if (i7 >= 0) {
                    Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                    if (i7 <= headerArr.length - 1) {
                        reader.addHeader(headerArr[i7]);
                    }
                }
                int length = reader.nextHeaderIndex + 1 + (i7 - Hpack.STATIC_HEADER_TABLE.length);
                if (length >= 0) {
                    Header[] headerArr2 = reader.dynamicTable;
                    if (length < headerArr2.length) {
                        Header header = headerArr2[length];
                        header.getClass();
                        reader.addHeader(header);
                    }
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i6, "Header index too large "));
                return null;
            }
            if (i5 == 64) {
                Header[] headerArr3 = Hpack.STATIC_HEADER_TABLE;
                ByteString byteString = reader.readByteString();
                Hpack.checkLowercase(byteString);
                reader.insertIntoDynamicTable(new Header(byteString, reader.readByteString()));
            } else if ((b & 64) == 64) {
                reader.insertIntoDynamicTable(new Header(reader.getName(reader.readInt(i5, 63) - 1), reader.readByteString()));
            } else if ((b & 32) == 32) {
                int i8 = reader.readInt(i5, 31);
                reader.maxDynamicTableByteCount = i8;
                if (i8 < 0 || i8 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + reader.maxDynamicTableByteCount);
                }
                int i9 = reader.dynamicTableByteCount;
                if (i8 < i9) {
                    if (i8 == 0) {
                        Header[] headerArr4 = reader.dynamicTable;
                        ArraysKt.fill(0, headerArr4.length, null, headerArr4);
                        reader.nextHeaderIndex = reader.dynamicTable.length - 1;
                        reader.headerCount = 0;
                        reader.dynamicTableByteCount = 0;
                    } else {
                        reader.evictToRecoverBytes(i9 - i8);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                Header[] headerArr5 = Hpack.STATIC_HEADER_TABLE;
                ByteString byteString2 = reader.readByteString();
                Hpack.checkLowercase(byteString2);
                reader.addHeader(new Header(byteString2, reader.readByteString()));
            } else {
                reader.addHeader(new Header(reader.getName(reader.readInt(i5, 15) - 1), reader.readByteString()));
            }
        }
        ArrayList arrayList = reader.headerList;
        List list = CollectionsKt.toList(arrayList);
        arrayList.clear();
        reader.headerListByteCount = 0L;
        return list;
    }

    public final void readHeaders(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws Throwable {
        int i4;
        int i5;
        Http2Connection http2Connection;
        if (i3 == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
            return;
        }
        boolean z = false;
        boolean z2 = true;
        if ((i2 & 1) == 0) {
            z2 = false;
        }
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        if ((i2 & 32) != 0) {
            RealBufferedSource realBufferedSource = this.source;
            realBufferedSource.readInt();
            realBufferedSource.readByte();
            byte[] bArr2 = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            i5 = i - 5;
        } else {
            i5 = i;
        }
        List headerBlock = readHeaderBlock(Companion.lengthWithoutPadding(i5, i2, i4), i4, i2, i3);
        Http2Connection http2Connection2 = (Http2Connection) readerRunnable.this$0;
        if (i3 != 0 && (i3 & 1) == 0) {
            z = true;
        }
        if (z) {
            TaskQueue.execute$default(http2Connection2.pushQueue, http2Connection2.connectionName + '[' + i3 + "] onHeaders", 0L, new Http2Connection$$ExternalSyntheticLambda5(http2Connection2, i3, headerBlock, z2), 6);
            return;
        }
        synchronized (http2Connection2) {
            try {
                Http2Stream stream = http2Connection2.getStream(i3);
                if (stream != null) {
                    stream.receiveHeaders(_UtilJvmKt.toHeaders(headerBlock), z2);
                    return;
                }
                if (http2Connection2.isShutdown) {
                    return;
                }
                if (i3 <= http2Connection2.lastGoodStreamId) {
                    return;
                }
                if (i3 % 2 == http2Connection2.nextStreamId % 2) {
                    return;
                }
                http2Connection = http2Connection2;
                try {
                    Http2Stream http2Stream = new Http2Stream(i3, http2Connection, false, z2, _UtilJvmKt.toHeaders(headerBlock));
                    http2Connection.lastGoodStreamId = i3;
                    http2Connection.streams.put(Integer.valueOf(i3), http2Stream);
                    TaskQueue.execute$default(http2Connection.taskRunner.newQueue(), http2Connection.connectionName + '[' + i3 + "] onStream", 0L, new Url$$ExternalSyntheticLambda1(http2Connection, http2Stream, (byte) 7), 6);
                    return;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                http2Connection = http2Connection2;
            }
            Throwable th3 = th;
            throw th3;
        }
    }

    public final void readPushPromise(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
            return;
        }
        byte b = 0;
        if ((i2 & 8) != 0) {
            byte b2 = this.source.readByte();
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            i4 = b2 & 255;
        } else {
            i4 = 0;
        }
        int i5 = this.source.readInt() & Integer.MAX_VALUE;
        List headerBlock = readHeaderBlock(Companion.lengthWithoutPadding(i - 4, i2, i4), i4, i2, i3);
        Http2Connection http2Connection = (Http2Connection) readerRunnable.this$0;
        synchronized (http2Connection) {
            if (http2Connection.currentPushRequests.contains(Integer.valueOf(i5))) {
                http2Connection.writeSynResetLater$okhttp(i5, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            http2Connection.currentPushRequests.add(Integer.valueOf(i5));
            TaskQueue.execute$default(http2Connection.pushQueue, http2Connection.connectionName + '[' + i5 + "] onRequest", 0L, new Http2Connection$$ExternalSyntheticLambda5(http2Connection, i5, headerBlock, b), 6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ContinuationSource implements Source {
        public int flags;
        public int left;
        public int padding;
        public final RealBufferedSource source;
        public int streamId;

        public ContinuationSource(RealBufferedSource realBufferedSource) {
            this.source = realBufferedSource;
        }

        @Override // okio.Source
        public final long read(Buffer buffer, long j) throws IOException {
            int i;
            int i2;
            buffer.getClass();
            do {
                int i3 = this.left;
                RealBufferedSource realBufferedSource = this.source;
                if (i3 == 0) {
                    realBufferedSource.skip(this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) == 0) {
                        i = this.streamId;
                        int medium = _UtilCommonKt.readMedium(realBufferedSource);
                        this.left = medium;
                        int i4 = realBufferedSource.readByte() & 255;
                        this.flags = realBufferedSource.readByte() & 255;
                        Logger logger = Http2Reader.logger;
                        if (logger.isLoggable(Level.FINE)) {
                            ByteString byteString = Http2.CONNECTION_PREFACE;
                            logger.fine(Http2.frameLog(true, this.streamId, medium, i4, this.flags));
                        }
                        i2 = realBufferedSource.readInt() & Integer.MAX_VALUE;
                        this.streamId = i2;
                        if (i4 != 9) {
                            throw new IOException(i4 + " != TYPE_CONTINUATION");
                        }
                    }
                } else {
                    long j2 = realBufferedSource.read(buffer, Math.min(j, i3));
                    if (j2 != -1) {
                        this.left -= (int) j2;
                        return j2;
                    }
                }
                return -1L;
            } while (i2 == i);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("TYPE_CONTINUATION streamId changed");
            return 0L;
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.source.source.timeout();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }
}
