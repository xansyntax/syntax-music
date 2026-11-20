package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer getBuffer();

    InputStream inputStream();

    long readAll(Sink sink);

    String readString(Charset charset);

    boolean request(long j);

    int select(Options options);
}
