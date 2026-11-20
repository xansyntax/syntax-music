package io.ktor.websocket.internals;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.pool.ObjectPool;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0006\u0010\n\u001a+\u0010\u0011\u001a\u00020\b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Ljava/util/zip/Deflater;", "", "data", "deflateFully", "(Ljava/util/zip/Deflater;[B)[B", "Ljava/util/zip/Inflater;", "inflateFully", "(Ljava/util/zip/Inflater;[B)[B", "", "maxOutputSize", "(Ljava/util/zip/Inflater;[BI)[B", "Lkotlinx/io/Sink;", "deflater", "Ljava/nio/ByteBuffer;", "buffer", "", "flush", "deflateTo", "(Lkotlinx/io/Sink;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Z)I", "PADDED_EMPTY_CHUNK", "[B", "EMPTY_CHUNK", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DeflaterUtilsKt {
    private static final byte[] PADDED_EMPTY_CHUNK = {0, 0, 0, -1, -1};
    private static final byte[] EMPTY_CHUNK = {0, 0, -1, -1};

    public static final byte[] deflateFully(Deflater deflater, byte[] bArr) {
        deflater.getClass();
        bArr.getClass();
        deflater.setInput(bArr);
        Buffer buffer = new Buffer();
        ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
        ByteBuffer byteBufferBorrow = ktorDefaultPool.borrow();
        try {
            ByteBuffer byteBuffer = byteBufferBorrow;
            while (!deflater.needsInput()) {
                deflateTo(buffer, deflater, byteBuffer, false);
            }
            do {
            } while (deflateTo(buffer, deflater, byteBuffer, true) != 0);
            ktorDefaultPool.recycle(byteBufferBorrow);
            if (BytePacketUtilsKt.endsWith(buffer, PADDED_EMPTY_CHUNK)) {
                return Utf8Kt.readByteArray(buffer, ((int) ByteReadPacketKt.getRemaining(buffer)) - EMPTY_CHUNK.length);
            }
            Buffer buffer2 = new Buffer();
            BytePacketBuilderKt.writePacket(buffer2, buffer);
            buffer2.writeByte((byte) 0);
            return Utf8Kt.readByteArrayImpl(buffer2, -1);
        } catch (Throwable th) {
            ktorDefaultPool.recycle(byteBufferBorrow);
            throw th;
        }
    }

    private static final int deflateTo(Sink sink, Deflater deflater, ByteBuffer byteBuffer, boolean z) {
        byteBuffer.clear();
        int iDeflate = z ? deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2) : deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        if (iDeflate == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + iDeflate);
        byteBuffer.flip();
        BytePacketBuilderExtensions_jvmKt.writeFully(sink, byteBuffer);
        return iDeflate;
    }

    public static final byte[] inflateFully(Inflater inflater, byte[] bArr, int i) {
        inflater.getClass();
        bArr.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("maxOutputSize should be >= 0");
            return null;
        }
        byte[] bArr2 = EMPTY_CHUNK;
        bArr2.getClass();
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        inflater.setInput(bArrCopyOf);
        Buffer buffer = new Buffer();
        ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
        ByteBuffer byteBufferBorrow = ktorDefaultPool.borrow();
        try {
            ByteBuffer byteBuffer = byteBufferBorrow;
            long jRemaining = 0;
            while (!inflater.finished()) {
                byteBuffer.clear();
                int iInflate = inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
                if (iInflate <= 0) {
                    if (inflater.needsDictionary()) {
                        throw new IOException("Inflater needs a preset dictionary");
                    }
                    if (inflater.needsInput()) {
                        break;
                    }
                    throw new IOException("Inflater made no progress; data probably corrupted");
                }
                byteBuffer.position(byteBuffer.position() + iInflate);
                byteBuffer.flip();
                jRemaining += (long) byteBuffer.remaining();
                if (jRemaining > i) {
                    throw new IOException("Inflated data exceeds limit: " + jRemaining + " > " + i);
                }
                BytePacketBuilderExtensions_jvmKt.writeFully(buffer, byteBuffer);
            }
            ktorDefaultPool.recycle(byteBufferBorrow);
            return Utf8Kt.readByteArrayImpl(buffer, -1);
        } catch (Throwable th) {
            ktorDefaultPool.recycle(byteBufferBorrow);
            throw th;
        }
    }

    public static final byte[] inflateFully(Inflater inflater, byte[] bArr) {
        inflater.getClass();
        bArr.getClass();
        return inflateFully(inflater, bArr, WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
    }
}
