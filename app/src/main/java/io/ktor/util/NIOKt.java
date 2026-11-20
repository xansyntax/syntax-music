package io.ktor.util;

import io.ktor.http.ContentDisposition;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0013¨\u0006\u0014"}, d2 = {"Ljava/nio/ByteBuffer;", "destination", "", "limit", "moveTo", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)I", "", "moveToByteArray", "(Ljava/nio/ByteBuffer;)[B", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "", "decodeString", "(Ljava/nio/ByteBuffer;Ljava/nio/charset/Charset;)Ljava/lang/String;", ContentDisposition.Parameters.Size, "copy", "(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/pool/ObjectPool;I)Ljava/nio/ByteBuffer;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NIOKt {
    public static final ByteBuffer copy(ByteBuffer byteBuffer, ObjectPool<ByteBuffer> objectPool, int i) {
        byteBuffer.getClass();
        objectPool.getClass();
        ByteBuffer byteBufferBorrow = objectPool.borrow();
        byteBufferBorrow.limit(i);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.getClass();
        moveTo$default(byteBufferSlice, byteBufferBorrow, 0, 2, null);
        byteBufferBorrow.flip();
        return byteBufferBorrow;
    }

    public static /* synthetic */ ByteBuffer copy$default(ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = byteBuffer.remaining();
        }
        return copy(byteBuffer, i);
    }

    public static final String decodeString(ByteBuffer byteBuffer, Charset charset) {
        byteBuffer.getClass();
        charset.getClass();
        String string = charset.decode(byteBuffer).toString();
        string.getClass();
        return string;
    }

    public static /* synthetic */ String decodeString$default(ByteBuffer byteBuffer, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeString(byteBuffer, charset);
    }

    public static final int moveTo(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        byteBuffer.getClass();
        byteBuffer2.getClass();
        int iMin = Math.min(i, Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
        if (iMin == byteBuffer.remaining()) {
            byteBuffer2.put(byteBuffer);
            return iMin;
        }
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer2.put(byteBuffer);
        byteBuffer.limit(iLimit);
        return iMin;
    }

    public static /* synthetic */ int moveTo$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return moveTo(byteBuffer, byteBuffer2, i);
    }

    public static final byte[] moveToByteArray(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static /* synthetic */ ByteBuffer copy$default(ByteBuffer byteBuffer, ObjectPool objectPool, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        return copy(byteBuffer, objectPool, i);
    }

    public static final ByteBuffer copy(ByteBuffer byteBuffer, int i) {
        byteBuffer.getClass();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.getClass();
        byteBufferAllocate.getClass();
        moveTo$default(byteBufferSlice, byteBufferAllocate, 0, 2, null);
        byteBufferAllocate.clear();
        return byteBufferAllocate;
    }
}
