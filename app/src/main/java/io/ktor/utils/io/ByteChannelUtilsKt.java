package io.ktor.utils.io;

import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001b\u0010\u000b\u001a\u00020\u0003*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/utils/io/ByteChannel;", "Lkotlinx/coroutines/Job;", "job", "", "attachJob", "(Lio/ktor/utils/io/ByteChannel;Lkotlinx/coroutines/Job;)V", "Lio/ktor/utils/io/ChannelJob;", "(Lio/ktor/utils/io/ByteChannel;Lio/ktor/utils/io/ChannelJob;)V", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/WriterJob;", "writerJob", "attachWriterJob", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/WriterJob;)V", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteChannelUtilsKt {
    public static final void attachJob(ByteChannel byteChannel, Job job) {
        byteChannel.getClass();
        job.getClass();
        job.invokeOnCompletion(true, true, new ByteChannelUtilsKt$$ExternalSyntheticLambda1(byteChannel, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachJob$lambda$0(ByteChannel byteChannel, Throwable th) {
        if (th != null) {
            byteChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }

    public static final void attachWriterJob(ByteReadChannel byteReadChannel, WriterJob writerJob) {
        byteReadChannel.getClass();
        writerJob.getClass();
        ByteReadChannel channel = writerJob.getChannel();
        ByteChannel byteChannel = channel instanceof ByteChannel ? (ByteChannel) channel : null;
        if (byteChannel != null) {
            byteChannel.invokeOnClose$ktor_io(new PingPongKt$$ExternalSyntheticLambda0((byte) 2, (Object) byteReadChannel));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachWriterJob$lambda$0(ByteReadChannel byteReadChannel, Throwable th) {
        if (th != null) {
            byteReadChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }

    public static final void attachJob(ByteChannel byteChannel, ChannelJob channelJob) {
        byteChannel.getClass();
        channelJob.getClass();
        attachJob(byteChannel, channelJob.getJob());
    }
}
