package kotlinx.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.io.EOFException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealSink implements Sink {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final RawSink sink;

    public RealSink(RawSink rawSink) {
        this.sink = rawSink;
    }

    @Override // kotlinx.io.RawSink, java.lang.AutoCloseable
    public final void close() throws Throwable {
        RawSink rawSink = this.sink;
        if (this.closed) {
            return;
        }
        Buffer buffer = this.bufferField;
        long j = buffer.sizeMut;
        if (j > 0) {
            rawSink.write(buffer, j);
        }
        th = null;
        try {
            rawSink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // kotlinx.io.RawSink, java.io.Flushable
    public final void flush() {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
            return;
        }
        Buffer buffer = this.bufferField;
        long j = buffer.sizeMut;
        RawSink rawSink = this.sink;
        if (j > 0) {
            rawSink.write(buffer, j);
        }
        rawSink.flush();
    }

    @Override // kotlinx.io.Sink
    public final Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // kotlinx.io.Sink
    public final void hintEmit() {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
            return;
        }
        Buffer buffer = this.bufferField;
        long jCompleteSegmentByteCount$kotlinx_io_core = buffer.completeSegmentByteCount$kotlinx_io_core();
        if (jCompleteSegmentByteCount$kotlinx_io_core > 0) {
            this.sink.write(buffer, jCompleteSegmentByteCount$kotlinx_io_core);
        }
    }

    public final String toString() {
        return "buffered(" + this.sink + ')';
    }

    @Override // kotlinx.io.Sink
    public final long transferFrom(RawSource rawSource) {
        rawSource.getClass();
        long j = 0;
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
            return 0L;
        }
        while (true) {
            long atMostTo = rawSource.readAtMostTo(this.bufferField, 8192L);
            if (atMostTo == -1) {
                return j;
            }
            j += atMostTo;
            hintEmit();
        }
    }

    @Override // kotlinx.io.Sink
    public final void write(RawSource rawSource, long j) throws EOFException {
        rawSource.getClass();
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
            return;
        }
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
            return;
        }
        long j2 = j;
        while (j2 > 0) {
            long atMostTo = rawSource.readAtMostTo(this.bufferField, j2);
            if (atMostTo == -1) {
                throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(j, "Source exhausted before reading ", " bytes from it (number of bytes read: "), j - j2, ")."));
            }
            j2 -= atMostTo;
            hintEmit();
        }
    }

    @Override // kotlinx.io.Sink
    public final void writeByte(byte b) {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
        } else {
            this.bufferField.writeByte(b);
            hintEmit();
        }
    }

    @Override // kotlinx.io.Sink
    public final void writeInt(int i) {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
        } else {
            this.bufferField.writeInt(i);
            hintEmit();
        }
    }

    @Override // kotlinx.io.Sink
    public final void writeLong(long j) {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
        } else {
            this.bufferField.writeLong(j);
            hintEmit();
        }
    }

    @Override // kotlinx.io.Sink
    public final void writeShort(short s) {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
        } else {
            this.bufferField.writeShort(s);
            hintEmit();
        }
    }

    @Override // kotlinx.io.Sink
    public final void write(byte[] bArr, int i, int i2) {
        bArr.getClass();
        if (!this.closed) {
            Utf8Kt.checkBounds(bArr.length, i, i2);
            this.bufferField.write(bArr, i, i2);
            hintEmit();
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
    }

    @Override // kotlinx.io.RawSink
    public final void write(Buffer buffer, long j) {
        buffer.getClass();
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Sink is closed.");
        } else if (j >= 0) {
            this.bufferField.write(buffer, j);
            hintEmit();
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
        }
    }
}
