package io.ktor.utils.io;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/BufferedByteWriteChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "", "flushWriteBuffer", "()V", "close", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface BufferedByteWriteChannel extends ByteWriteChannel {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getAutoFlush(BufferedByteWriteChannel bufferedByteWriteChannel) {
            return BufferedByteWriteChannel.super.getAutoFlush();
        }
    }

    void close();

    void flushWriteBuffer();
}
