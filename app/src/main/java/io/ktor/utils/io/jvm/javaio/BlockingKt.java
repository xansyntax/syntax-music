package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000b\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/Job;", "parent", "Ljava/io/InputStream;", "toInputStream", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/coroutines/Job;)Ljava/io/InputStream;", "asInputStream", "Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/io/OutputStream;", "toOutputStream", "(Lio/ktor/utils/io/ByteWriteChannel;)Ljava/io/OutputStream;", "asOutputStream", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/coroutines/Job;)Ljava/io/OutputStream;", "", "FLUSH_THRESHOLD", "J", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BlockingKt {
    private static final long FLUSH_THRESHOLD = 1048576;

    public static final InputStream asInputStream(ByteReadChannel byteReadChannel, Job job) {
        byteReadChannel.getClass();
        job.getClass();
        return new ByteChannelInputStream(byteReadChannel, job);
    }

    public static final OutputStream asOutputStream(ByteWriteChannel byteWriteChannel, Job job) {
        byteWriteChannel.getClass();
        job.getClass();
        return new ByteChannelOutputStream(byteWriteChannel, job);
    }

    public static final InputStream toInputStream(ByteReadChannel byteReadChannel, Job job) {
        byteReadChannel.getClass();
        return new ByteChannelInputStream(byteReadChannel, job);
    }

    public static /* synthetic */ InputStream toInputStream$default(ByteReadChannel byteReadChannel, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return toInputStream(byteReadChannel, job);
    }

    public static final OutputStream toOutputStream(ByteWriteChannel byteWriteChannel) {
        byteWriteChannel.getClass();
        return new ByteChannelOutputStream(byteWriteChannel, null);
    }
}
