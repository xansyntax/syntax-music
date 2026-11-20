package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    @Override // okio.Sink, java.io.Flushable
    void flush();

    OutputStream outputStream();

    BufferedSink writeByte(int i);

    BufferedSink writeDecimalLong(long j);

    BufferedSink writeUtf8(String str);
}
