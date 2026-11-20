package kotlinx.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.io.EOFException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealSource implements Source {
    public final Buffer bufferField;
    public boolean closed;
    public final RawSource source;

    public RealSource(RawSource rawSource) {
        rawSource.getClass();
        this.source = rawSource;
        this.bufferField = new Buffer();
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        Buffer buffer = this.bufferField;
        buffer.skip(buffer.sizeMut);
    }

    @Override // kotlinx.io.Source
    public final boolean exhausted() {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Source is closed.");
            return false;
        }
        Buffer buffer = this.bufferField;
        return buffer.exhausted() && this.source.readAtMostTo(buffer, 8192L) == -1;
    }

    @Override // kotlinx.io.Source, kotlinx.io.Sink
    public final Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // kotlinx.io.Source
    public final RealSource peek() {
        if (!this.closed) {
            return new RealSource(new PeekSource(this));
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Source is closed.");
        return null;
    }

    @Override // kotlinx.io.RawSource
    public final long readAtMostTo(Buffer buffer, long j) {
        buffer.getClass();
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Source is closed.");
            return 0L;
        }
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
            return 0L;
        }
        Buffer buffer2 = this.bufferField;
        if (buffer2.sizeMut == 0 && this.source.readAtMostTo(buffer2, 8192L) == -1) {
            return -1L;
        }
        return buffer2.readAtMostTo(buffer, Math.min(j, buffer2.sizeMut));
    }

    @Override // kotlinx.io.Source
    public final byte readByte() throws EOFException {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // kotlinx.io.Source
    public final int readInt() throws EOFException {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // kotlinx.io.Source
    public final long readLong() throws EOFException {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // kotlinx.io.Source
    public final short readShort() throws EOFException {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // kotlinx.io.Source
    public final void readTo(RawSink rawSink, long j) throws EOFException {
        Buffer buffer = this.bufferField;
        rawSink.getClass();
        try {
            require(j);
            buffer.readTo(rawSink, j);
        } catch (EOFException e) {
            rawSink.write(buffer, buffer.sizeMut);
            throw e;
        }
    }

    @Override // kotlinx.io.Source
    public final boolean request(long j) {
        Buffer buffer;
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Source is closed.");
            return false;
        }
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
            return false;
        }
        do {
            buffer = this.bufferField;
            if (buffer.sizeMut >= j) {
                return true;
            }
        } while (this.source.readAtMostTo(buffer, 8192L) != -1);
        return false;
    }

    @Override // kotlinx.io.Source
    public final void require(long j) throws EOFException {
        if (!request(j)) {
            throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(j, "Source doesn't contain required number of bytes (", ")."));
        }
    }

    @Override // kotlinx.io.Source
    public final void skip(long j) throws EOFException {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Source is closed.");
            return;
        }
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
            return;
        }
        long j2 = j;
        while (j2 > 0) {
            Buffer buffer = this.bufferField;
            if (buffer.sizeMut == 0 && this.source.readAtMostTo(buffer, 8192L) == -1) {
                throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(j, "Source exhausted before skipping ", " bytes (only "), j2 - j, " bytes were skipped)."));
            }
            long jMin = Math.min(j2, buffer.sizeMut);
            buffer.skip(jMin);
            j2 -= jMin;
        }
    }

    public final String toString() {
        return "buffered(" + this.source + ')';
    }

    @Override // kotlinx.io.Source
    public final long transferTo(RawSink rawSink) {
        Buffer buffer;
        rawSink.getClass();
        long j = 0;
        while (true) {
            RawSource rawSource = this.source;
            buffer = this.bufferField;
            if (rawSource.readAtMostTo(buffer, 8192L) == -1) {
                break;
            }
            long jCompleteSegmentByteCount$kotlinx_io_core = buffer.completeSegmentByteCount$kotlinx_io_core();
            if (jCompleteSegmentByteCount$kotlinx_io_core > 0) {
                j += jCompleteSegmentByteCount$kotlinx_io_core;
                rawSink.write(buffer, jCompleteSegmentByteCount$kotlinx_io_core);
            }
        }
        long j2 = buffer.sizeMut;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        rawSink.write(buffer, j2);
        return j3;
    }

    @Override // kotlinx.io.Source
    public final int readAtMostTo(byte[] bArr, int i, int i2) {
        bArr.getClass();
        Utf8Kt.checkBounds(bArr.length, i, i2);
        Buffer buffer = this.bufferField;
        if (buffer.sizeMut == 0 && this.source.readAtMostTo(buffer, 8192L) == -1) {
            return -1;
        }
        return buffer.readAtMostTo(bArr, i, ((int) Math.min(i2 - i, buffer.sizeMut)) + i);
    }
}
