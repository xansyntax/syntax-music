package okio;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class GzipSource implements Source {
    public final CRC32 crc;
    public final Inflater inflater;
    public final InflaterSource inflaterSource;
    public byte section;
    public final RealBufferedSource source;

    public GzipSource(BufferedSource bufferedSource) {
        bufferedSource.getClass();
        RealBufferedSource realBufferedSource = new RealBufferedSource(bufferedSource);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource(realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    public static void checkEqual(int i, int i2, String str) throws IOException {
        if (i2 == i) {
            return;
        }
        throw new IOException(str + ": actual 0x" + StringsKt.padStart(8, HexFormatKt.toHexString(i2)) + " != expected 0x" + StringsKt.padStart(8, HexFormatKt.toHexString(i)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        byte b;
        GzipSource gzipSource = this;
        RealBufferedSource realBufferedSource = gzipSource.source;
        Buffer buffer2 = realBufferedSource.bufferField;
        buffer.getClass();
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        byte b2 = gzipSource.section;
        CRC32 crc32 = gzipSource.crc;
        if (b2 == 0) {
            realBufferedSource.require(10L);
            byte b3 = buffer2.getByte(3L);
            boolean z = ((b3 >> 1) & 1) == 1;
            if (z) {
                gzipSource.updateCrc(buffer2, 0L, 10L);
            }
            checkEqual(8075, realBufferedSource.readShort(), "ID1ID2");
            realBufferedSource.skip(8L);
            if (((b3 >> 2) & 1) == 1) {
                realBufferedSource.require(2L);
                if (z) {
                    updateCrc(buffer2, 0L, 2L);
                }
                long shortLe = buffer2.readShortLe() & 65535;
                realBufferedSource.require(shortLe);
                if (z) {
                    updateCrc(buffer2, 0L, shortLe);
                }
                realBufferedSource.skip(shortLe);
            }
            if (((b3 >> 3) & 1) == 1) {
                long jIndexOf = realBufferedSource.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf == -1) {
                    throw new EOFException();
                }
                if (z) {
                    updateCrc(buffer2, 0L, jIndexOf + 1);
                }
                realBufferedSource.skip(jIndexOf + 1);
            }
            if (((b3 >> 4) & 1) == 1) {
                long jIndexOf2 = realBufferedSource.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    gzipSource = this;
                    gzipSource.updateCrc(buffer2, 0L, jIndexOf2 + 1);
                } else {
                    gzipSource = this;
                }
                realBufferedSource.skip(jIndexOf2 + 1);
            } else {
                gzipSource = this;
            }
            if (z) {
                checkEqual(realBufferedSource.readShortLe(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            gzipSource.section = (byte) 1;
            b2 = 1;
        }
        if (b2 == 1) {
            long j2 = buffer.size;
            long j3 = gzipSource.inflaterSource.read(buffer, j);
            if (j3 != -1) {
                gzipSource.updateCrc(buffer, j2, j3);
                return j3;
            }
            b = 2;
            gzipSource.section = (byte) 2;
            b2 = 2;
        } else {
            b = 2;
        }
        if (b2 == b) {
            checkEqual(realBufferedSource.readIntLe(), (int) crc32.getValue(), "CRC");
            checkEqual(realBufferedSource.readIntLe(), (int) gzipSource.inflater.getBytesWritten(), "ISIZE");
            gzipSource.section = (byte) 3;
            if (!realBufferedSource.exhausted()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.source.timeout();
    }

    public final void updateCrc(Buffer buffer, long j, long j2) {
        Segment segment = buffer.head;
        segment.getClass();
        while (true) {
            long j3 = segment.limit - segment.pos;
            if (j < j3) {
                break;
            }
            j -= j3;
            segment = segment.next;
            segment.getClass();
        }
        while (j2 > 0) {
            int i = (int) (((long) segment.pos) + j);
            int iMin = (int) Math.min(segment.limit - i, j2);
            this.crc.update(segment.data, i, iMin);
            j2 -= (long) iMin;
            segment = segment.next;
            segment.getClass();
            j = 0;
        }
    }
}
