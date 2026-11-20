package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.DeflaterSink;
import okio.InflaterSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageDeflater implements Closeable {
    public final /* synthetic */ byte $r8$classId;
    public final Buffer deflatedBytes;
    public Object deflater;
    public Closeable deflaterSink;
    public final boolean noContextTakeover;

    public MessageDeflater(byte b, boolean z) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.noContextTakeover = z;
                this.deflatedBytes = new Buffer();
                break;
            default:
                this.noContextTakeover = z;
                Buffer buffer = new Buffer();
                this.deflatedBytes = buffer;
                Deflater deflater = new Deflater(-1, true);
                this.deflater = deflater;
                this.deflaterSink = new DeflaterSink(buffer, deflater);
                break;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                ((DeflaterSink) this.deflaterSink).close();
                break;
            default:
                InflaterSource inflaterSource = (InflaterSource) this.deflaterSink;
                if (inflaterSource != null) {
                    inflaterSource.close();
                }
                this.deflaterSink = null;
                this.deflater = null;
                break;
        }
    }
}
