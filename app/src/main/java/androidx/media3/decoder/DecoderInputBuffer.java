package androidx.media3.decoder;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format;
import androidx.media3.common.MediaLibraryInfo;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DecoderInputBuffer extends Buffer {
    public final byte bufferReplacementMode;
    public final CryptoInfo cryptoInfo = new CryptoInfo();
    public ByteBuffer data;
    public Format format;
    public ByteBuffer supplementalData;
    public long timeUs;
    public boolean waitingForKeys;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InsufficientCapacityException extends IllegalStateException {
    }

    static {
        MediaLibraryInfo.registerModule("media3.decoder");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DecoderInputBuffer(int i) {
        this.bufferReplacementMode = i;
    }

    public void clear() {
        this.flags = 0;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.waitingForKeys = false;
    }

    public final ByteBuffer createReplacementByteBuffer(int i) {
        byte b = this.bufferReplacementMode;
        if (b == 1) {
            return ByteBuffer.allocate(i);
        }
        if (b == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.data;
        throw new InsufficientCapacityException(IntIntPair$$ExternalSyntheticOutline0.m(byteBuffer == null ? 0 : byteBuffer.capacity(), "Buffer too small (", " < ", i, ")"));
    }

    public final void ensureSpaceForWrite(int i) {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            this.data = createReplacementByteBuffer(i);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (iCapacity >= i2) {
            this.data = byteBuffer;
            return;
        }
        ByteBuffer byteBufferCreateReplacementByteBuffer = createReplacementByteBuffer(i2);
        byteBufferCreateReplacementByteBuffer.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferCreateReplacementByteBuffer.put(byteBuffer);
        }
        this.data = byteBufferCreateReplacementByteBuffer;
    }

    public final void flip() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }
}
