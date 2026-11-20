package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.RawSourceChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.io.RawSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannel", "(Ljava/nio/channels/ReadableByteChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/io/RawSource;", "asSource", "(Ljava/nio/channels/ReadableByteChannel;)Lkotlinx/io/RawSource;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReadingKt {
    public static final RawSource asSource(ReadableByteChannel readableByteChannel) {
        readableByteChannel.getClass();
        return new ReadableByteChannelSource(readableByteChannel);
    }

    public static final ByteReadChannel toByteReadChannel(ReadableByteChannel readableByteChannel, CoroutineContext coroutineContext) {
        readableByteChannel.getClass();
        coroutineContext.getClass();
        return new RawSourceChannel(asSource(readableByteChannel), coroutineContext);
    }

    public static ByteReadChannel toByteReadChannel$default(ReadableByteChannel readableByteChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            coroutineContext = DefaultIoScheduler.INSTANCE;
        }
        return toByteReadChannel(readableByteChannel, coroutineContext);
    }
}
