package okhttp3.internal.ws;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.network.sockets.DatagramKt;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import okio.ByteString;
import okio.InflaterSource;
import okio.RealBufferedSource;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocketReader implements Closeable {
    public boolean closed;
    public final RealWebSocket frameCallback;
    public long frameLength;
    public boolean isControlFrame;
    public boolean isFinalFrame;
    public MessageDeflater messageInflater;
    public final boolean noContextTakeover;
    public int opcode;
    public final boolean perMessageDeflate;
    public boolean readingCompressedMessage;
    public boolean receivedCloseFrame;
    public final RealBufferedSource source;
    public final Buffer controlFrameBuffer = new Buffer();
    public final Buffer messageFrameBuffer = new Buffer();
    public final byte[] maskKey = null;

    public WebSocketReader(RealBufferedSource realBufferedSource, RealWebSocket realWebSocket, boolean z, boolean z2) {
        this.source = realBufferedSource;
        this.frameCallback = realWebSocket;
        this.perMessageDeflate = z;
        this.noContextTakeover = z2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        MessageDeflater messageDeflater = this.messageInflater;
        if (messageDeflater != null) {
            _UtilCommonKt.closeQuietly(messageDeflater);
        }
        _UtilCommonKt.closeQuietly(this.source);
    }

    public final void processNextFrame() throws IOException {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return;
        }
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
            return;
        }
        int i = this.opcode;
        if (i != 1 && i != 2) {
            TimeZone timeZone = _UtilJvmKt.UTC;
            String hexString = Integer.toHexString(i);
            hexString.getClass();
            throw new ProtocolException("Unknown opcode: ".concat(hexString));
        }
        while (!this.receivedCloseFrame) {
            long j = this.frameLength;
            Buffer buffer = this.messageFrameBuffer;
            if (j > 0) {
                this.source.readFully(buffer, j);
            }
            if (this.isFinalFrame) {
                if (this.readingCompressedMessage) {
                    MessageDeflater messageDeflater = this.messageInflater;
                    if (messageDeflater == null) {
                        messageDeflater = new MessageDeflater((byte) 1, this.noContextTakeover);
                        this.messageInflater = messageDeflater;
                    }
                    Buffer buffer2 = messageDeflater.deflatedBytes;
                    if (buffer2.size != 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
                        return;
                    }
                    Inflater inflater = (Inflater) messageDeflater.deflater;
                    if (inflater == null) {
                        inflater = new Inflater(true);
                        messageDeflater.deflater = inflater;
                    }
                    InflaterSource inflaterSource = (InflaterSource) messageDeflater.deflaterSink;
                    if (inflaterSource == null) {
                        inflaterSource = new InflaterSource(new RealBufferedSource(buffer2), inflater);
                        messageDeflater.deflaterSink = inflaterSource;
                    }
                    if (messageDeflater.noContextTakeover) {
                        inflater.reset();
                    }
                    buffer2.writeAll(buffer);
                    buffer2.writeInt(DatagramKt.MAX_DATAGRAM_SIZE);
                    long bytesRead = inflater.getBytesRead() + buffer2.size;
                    do {
                        inflaterSource.readOrInflate(buffer, Long.MAX_VALUE);
                        if (inflater.getBytesRead() >= bytesRead) {
                            break;
                        }
                    } while (!inflater.finished());
                    if (inflater.getBytesRead() < bytesRead) {
                        buffer2.clear();
                        inflaterSource.close();
                        messageDeflater.deflaterSink = null;
                        messageDeflater.deflater = null;
                    }
                }
                RealWebSocket realWebSocket = this.frameCallback;
                WebSocketListener webSocketListener = realWebSocket.listener;
                if (i == 1) {
                    webSocketListener.onMessage(realWebSocket, buffer.readUtf8());
                    return;
                }
                ByteString byteString = buffer.readByteString(buffer.size);
                byteString.getClass();
                webSocketListener.onMessage(realWebSocket, byteString);
                return;
            }
            while (!this.receivedCloseFrame) {
                readHeader();
                if (!this.isControlFrame) {
                    break;
                } else {
                    readControlFrame();
                }
            }
            if (this.opcode != 0) {
                int i2 = this.opcode;
                TimeZone timeZone2 = _UtilJvmKt.UTC;
                String hexString2 = Integer.toHexString(i2);
                hexString2.getClass();
                throw new ProtocolException("Expected continuation opcode. Got: ".concat(hexString2));
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
    }

    public final void readControlFrame() throws ProtocolException, EOFException {
        String utf8;
        short s;
        String strM;
        long j = this.frameLength;
        if (j > 0) {
            this.source.readFully(this.controlFrameBuffer, j);
        }
        switch (this.opcode) {
            case 8:
                Buffer buffer = this.controlFrameBuffer;
                long j2 = buffer.size;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    s = buffer.readShort();
                    utf8 = this.controlFrameBuffer.readUtf8();
                    if (s < 1000 || s >= 5000) {
                        strM = IntIntPair$$ExternalSyntheticOutline0.m(s, "Code must be in range [1000,5000): ");
                    } else {
                        strM = ((1004 > s || s >= 1007) && (1015 > s || s >= 3000)) ? null : IntIntPair$$ExternalSyntheticOutline0.m((int) s, "Code ", " is reserved and may not be used.");
                    }
                    if (strM != null) {
                        throw new ProtocolException(strM);
                    }
                } else {
                    utf8 = "";
                    s = 1005;
                }
                RealWebSocket realWebSocket = this.frameCallback;
                if (s == -1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
                    return;
                }
                synchronized (realWebSocket) {
                    if (realWebSocket.receivedCloseCode != -1) {
                        throw new IllegalStateException("already closed");
                    }
                    realWebSocket.receivedCloseCode = s;
                    realWebSocket.receivedCloseReason = utf8;
                }
                realWebSocket.listener.onClosing(realWebSocket, s, utf8);
                this.receivedCloseFrame = true;
                return;
            case 9:
                RealWebSocket realWebSocket2 = this.frameCallback;
                Buffer buffer2 = this.controlFrameBuffer;
                ByteString byteString = buffer2.readByteString(buffer2.size);
                synchronized (realWebSocket2) {
                    try {
                        byteString.getClass();
                        if (!realWebSocket2.failed && (!realWebSocket2.enqueuedClose || !realWebSocket2.messageAndCloseQueue.isEmpty())) {
                            realWebSocket2.pongQueue.add(byteString);
                            realWebSocket2.runWriter();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            case 10:
                RealWebSocket realWebSocket3 = this.frameCallback;
                Buffer buffer3 = this.controlFrameBuffer;
                ByteString byteString2 = buffer3.readByteString(buffer3.size);
                synchronized (realWebSocket3) {
                    byteString2.getClass();
                    realWebSocket3.awaitingPong = false;
                }
                return;
            default:
                int i = this.opcode;
                TimeZone timeZone = _UtilJvmKt.UTC;
                String hexString = Integer.toHexString(i);
                hexString.getClass();
                throw new ProtocolException("Unknown control opcode: ".concat(hexString));
        }
    }

    public final void readHeader() throws IOException {
        boolean z;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        RealBufferedSource realBufferedSource = this.source;
        Buffer buffer = realBufferedSource.bufferField;
        Source source = realBufferedSource.source;
        if (this.receivedCloseFrame) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
            return;
        }
        long jTimeoutNanos = source.timeout().timeoutNanos();
        source.timeout().clearTimeout();
        try {
            byte b = realBufferedSource.readByte();
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            source.timeout().timeout(jTimeoutNanos, timeUnit);
            int i = b & 15;
            this.opcode = i;
            int i2 = 0;
            boolean z2 = (b & 128) != 0;
            this.isFinalFrame = z2;
            boolean z3 = (b & 8) != 0;
            this.isControlFrame = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (b & 64) != 0;
            if (i == 1 || i == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.readingCompressedMessage = z;
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((b & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((b & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            byte b2 = realBufferedSource.readByte();
            boolean z5 = (b2 & 128) != 0;
            if (z5) {
                throw new ProtocolException("Server-sent frames must not be masked.");
            }
            long j = b2 & 127;
            this.frameLength = j;
            if (j == 126) {
                j = realBufferedSource.readShort() & 65535;
                this.frameLength = j;
            } else if (j == 127) {
                realBufferedSource.require(8L);
                j = buffer.readLong();
                this.frameLength = j;
                if (j < 0) {
                    long j2 = this.frameLength;
                    TimeZone timeZone = _UtilJvmKt.UTC;
                    String hexString = Long.toHexString(j2);
                    hexString.getClass();
                    throw new ProtocolException("Frame length 0x" + hexString + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && j > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (!z5) {
                return;
            }
            byte[] bArr2 = this.maskKey;
            bArr2.getClass();
            try {
                realBufferedSource.require(bArr2.length);
                buffer.readFully(bArr2);
            } catch (EOFException e) {
                while (true) {
                    long j3 = buffer.size;
                    if (j3 <= 0) {
                        throw e;
                    }
                    int i3 = buffer.read(bArr2, i2, (int) j3);
                    if (i3 == -1) {
                        throw new AssertionError();
                    }
                    i2 += i3;
                }
            }
        } catch (Throwable th) {
            source.timeout().timeout(jTimeoutNanos, timeUnit);
            throw th;
        }
    }
}
