package io.ktor.util;

import io.ktor.utils.io.core.internal.ChunkBufferJvmKt;
import io.ktor.utils.io.core.internal.ChunkBufferKt;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.io.Buffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "Lkotlinx/io/Buffer;", "buffer", "", "read", "(Ljava/nio/channels/ReadableByteChannel;Lkotlinx/io/Buffer;)I", "Ljava/nio/channels/WritableByteChannel;", "write", "(Ljava/nio/channels/WritableByteChannel;Lkotlinx/io/Buffer;)I", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BufferViewJvmKt {
    public static final int read(ReadableByteChannel readableByteChannel, Buffer buffer) {
        readableByteChannel.getClass();
        buffer.getClass();
        if (ChunkBufferKt.getWriteRemaining(buffer) == 0) {
            return 0;
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ChunkBufferJvmKt.writeDirect(buffer, 1, new ByteChannelsKt$$ExternalSyntheticLambda0(ref$IntRef, readableByteChannel, (byte) 3));
        return ref$IntRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit read$lambda$0(Ref$IntRef ref$IntRef, ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        ref$IntRef.element = readableByteChannel.read(byteBuffer);
        return Unit.INSTANCE;
    }

    public static final int write(WritableByteChannel writableByteChannel, Buffer buffer) {
        writableByteChannel.getClass();
        buffer.getClass();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ChunkBufferJvmKt.readDirect(buffer, new ByteChannelsKt$$ExternalSyntheticLambda0(ref$IntRef, writableByteChannel, (byte) 2));
        return ref$IntRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit write$lambda$0(Ref$IntRef ref$IntRef, WritableByteChannel writableByteChannel, ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        ref$IntRef.element = writableByteChannel.write(byteBuffer);
        return Unit.INSTANCE;
    }
}
