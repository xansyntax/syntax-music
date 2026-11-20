package io.ktor.utils.io.core;

import com.yalantis.ucrop.BuildConfig;
import io.ktor.http.ContentType;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.io.Buffer;
import kotlinx.io.RealSource;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0016*\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a%\u0010\u001e\u001a\u00020\u001d*\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010 \u001a\u00020\u001d*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b \u0010!\u001a+\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"*\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b$\u0010%\u001a+\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"*\u00020&2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b$\u0010'\u001a\u0013\u0010(\u001a\u00020\u001d*\u00020\u0005H\u0007¢\u0006\u0004\b(\u0010)\"\u0017\u0010*\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u001b\u00101\u001a\u00020\u0016*\u00020\u00058F¢\u0006\f\u0012\u0004\b0\u0010)\u001a\u0004\b.\u0010/*\u001a\b\u0007\u0010\u0006\"\u00020\u00052\u00020\u0005B\f\b2\u0012\b\b3\u0012\u0004\b\b(4¨\u00065"}, d2 = {"", "array", "", "offset", "length", "Lkotlinx/io/Source;", "ByteReadPacket", "([BII)Lkotlinx/io/Source;", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "Lkotlinx/io/Buffer;", "Sink", "(Lio/ktor/utils/io/pool/ObjectPool;)Lkotlinx/io/Buffer;", "()Lkotlinx/io/Buffer;", "out", "readAvailable", "(Lkotlinx/io/Source;Lkotlinx/io/Buffer;)I", "copy", "(Lkotlinx/io/Source;)Lkotlinx/io/Source;", "", "readShortLittleEndian", "(Lkotlinx/io/Source;)S", "", "count", "discard", "(Lkotlinx/io/Source;J)J", "Lkotlin/Function1;", "", "block", "", "takeWhile", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)V", "readFully", "(Lkotlinx/io/Source;[BII)V", "T", "function", "preview", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/io/Sink;", "(Lkotlinx/io/Sink;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", BuildConfig.BUILD_TYPE, "(Lkotlinx/io/Source;)V", "ByteReadPacketEmpty", "Lkotlinx/io/Source;", "getByteReadPacketEmpty", "()Lkotlinx/io/Source;", "getRemaining", "(Lkotlinx/io/Source;)J", "getRemaining$annotations", "remaining", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "Use Source instead", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteReadPacketKt {
    private static final Source ByteReadPacketEmpty = new Buffer();

    public static final Source ByteReadPacket(byte[] bArr, int i, int i2) {
        bArr.getClass();
        Buffer buffer = new Buffer();
        buffer.write(bArr, i, i2 + i);
        return buffer;
    }

    public static /* synthetic */ Source ByteReadPacket$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return ByteReadPacket(bArr, i, i2);
    }

    @Deprecated
    public static final Buffer Sink(ObjectPool<?> objectPool) {
        objectPool.getClass();
        return new Buffer();
    }

    @Deprecated
    public static final Source copy(Source source) {
        source.getClass();
        return source.peek();
    }

    public static final long discard(Source source, long j) {
        source.getClass();
        source.request(j);
        long jMin = Math.min(j, getRemaining(source));
        source.getBuffer().skip(jMin);
        return jMin;
    }

    public static /* synthetic */ long discard$default(Source source, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return discard(source, j);
    }

    public static final Source getByteReadPacketEmpty() {
        return ByteReadPacketEmpty;
    }

    public static final long getRemaining(Source source) {
        source.getClass();
        return source.getBuffer().sizeMut;
    }

    public static final <T> T preview(Source source, Function1 function1) {
        source.getClass();
        function1.getClass();
        RealSource realSourcePeek = source.getBuffer().peek();
        try {
            T t = (T) function1.invoke(realSourcePeek);
            StringsKt__IndentKt.closeFinally(realSourcePeek, null);
            return t;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(realSourcePeek, th);
                throw th2;
            }
        }
    }

    public static final int readAvailable(Source source, Buffer buffer) {
        source.getClass();
        buffer.getClass();
        long j = source.getBuffer().sizeMut;
        buffer.transferFrom(source);
        return (int) j;
    }

    public static final void readFully(Source source, byte[] bArr, int i, int i2) throws EOFException {
        source.getClass();
        bArr.getClass();
        Utf8Kt.readTo(source, bArr, i, i2 + i);
    }

    public static /* synthetic */ void readFully$default(Source source, byte[] bArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(source, bArr, i, i2);
    }

    public static final short readShortLittleEndian(Source source) {
        source.getClass();
        Buffer buffer = source.getBuffer();
        buffer.getClass();
        return Short.reverseBytes(buffer.readShort());
    }

    @Deprecated
    public static final void release(Source source) throws Exception {
        source.getClass();
        source.close();
    }

    public static final void takeWhile(Source source, Function1 function1) {
        source.getClass();
        function1.getClass();
        while (!source.exhausted() && ((Boolean) function1.invoke(source.getBuffer())).booleanValue()) {
        }
    }

    @Deprecated
    public static final Buffer Sink() {
        return new Buffer();
    }

    public static final <T> T preview(Sink sink, Function1 function1) {
        sink.getClass();
        function1.getClass();
        RealSource realSourcePeek = sink.getBuffer().peek();
        try {
            T t = (T) function1.invoke(realSourcePeek);
            StringsKt__IndentKt.closeFinally(realSourcePeek, null);
            return t;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(realSourcePeek, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public static /* synthetic */ void ByteReadPacket$annotations() {
    }

    public static /* synthetic */ void getRemaining$annotations(Source source) {
    }
}
