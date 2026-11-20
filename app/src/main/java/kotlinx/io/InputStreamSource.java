package kotlinx.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InputStreamSource implements RawSource {
    public final InputStream input;

    public InputStreamSource(InputStream inputStream) {
        this.input = inputStream;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.input.close();
    }

    @Override // kotlinx.io.RawSource
    public final long readAtMostTo(Buffer buffer, long j) {
        buffer.getClass();
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount (", ") < 0"));
            return 0L;
        }
        Segment segmentWritableSegment = buffer.writableSegment(1);
        byte[] bArr = segmentWritableSegment.data;
        int i = segmentWritableSegment.limit;
        long j2 = this.input.read(bArr, i, (int) Math.min(j, bArr.length - i));
        int i2 = j2 == -1 ? 0 : (int) j2;
        if (i2 == 1) {
            segmentWritableSegment.limit += i2;
            buffer.sizeMut += (long) i2;
            return j2;
        }
        if (i2 < 0 || i2 > segmentWritableSegment.getRemainingCapacity()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i2, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
            return 0L;
        }
        if (i2 != 0) {
            segmentWritableSegment.limit += i2;
            buffer.sizeMut += (long) i2;
            return j2;
        }
        if (Utf8Kt.isEmpty(segmentWritableSegment)) {
            buffer.recycleTail();
        }
        return j2;
    }

    public final String toString() {
        return "RawSource(" + this.input + ')';
    }
}
