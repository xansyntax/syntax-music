package coil3.fetch;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import coil3.UriKt;
import coil3.decode.ByteBufferMetadata;
import coil3.decode.DataSource;
import coil3.decode.SourceImageSource;
import coil3.intercept.EngineInterceptor;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.size.Size;
import coil3.util.Utils_androidKt;
import java.nio.ByteBuffer;
import kotlin.math.MathKt;
import okio.Buffer;
import okio.RealBufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawableFetcher implements Fetcher {
    public final /* synthetic */ byte $r8$classId;
    public final Object data;
    public final Options options;

    public /* synthetic */ DrawableFetcher(Object obj, Options options, byte b) {
        this.$r8$classId = b;
        this.data = obj;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    public final Object fetch(EngineInterceptor.C00531 c00531) {
        byte b = this.$r8$classId;
        DataSource dataSource = DataSource.MEMORY;
        Options options = this.options;
        Object obj = this.data;
        switch (b) {
            case 0:
                Drawable bitmapDrawable = (Drawable) obj;
                Bitmap.Config[] configArr = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
                boolean z = bitmapDrawable instanceof VectorDrawable;
                if (z) {
                    bitmapDrawable = new BitmapDrawable(options.context.getResources(), MathKt.convertToBitmap(bitmapDrawable, ImageRequests_androidKt.getBitmapConfig(options), options.size, options.scale, (Size) UriKt.getExtra(options, ImageRequestsKt.maxBitmapSizeKey), options.precision == Precision.INEXACT));
                }
                return new ImageFetchResult(UriKt.asImage(bitmapDrawable), z, dataSource);
            case 1:
                Buffer buffer = new Buffer();
                byte[] bArr = (byte[]) obj;
                bArr.getClass();
                buffer.write(bArr, 0, bArr.length);
                return new SourceFetchResult(new SourceImageSource(buffer, options.fileSystem, null), null, dataSource);
            default:
                final ByteBuffer byteBuffer = (ByteBuffer) obj;
                return new SourceFetchResult(new SourceImageSource(new RealBufferedSource(new Source(byteBuffer) { // from class: coil3.fetch.ByteBufferFetcherKt$asSource$1
                    public final ByteBuffer buffer;
                    public final int len;

                    {
                        ByteBuffer byteBufferSlice = byteBuffer.slice();
                        this.buffer = byteBufferSlice;
                        this.len = byteBufferSlice.capacity();
                    }

                    @Override // okio.Source
                    public final long read(Buffer buffer2, long j) {
                        ByteBuffer byteBuffer2 = this.buffer;
                        int iPosition = byteBuffer2.position();
                        int i = this.len;
                        if (iPosition == i) {
                            return -1L;
                        }
                        int iPosition2 = (int) (((long) byteBuffer2.position()) + j);
                        if (iPosition2 <= i) {
                            i = iPosition2;
                        }
                        byteBuffer2.limit(i);
                        return buffer2.write(byteBuffer2);
                    }

                    @Override // okio.Source
                    public final Timeout timeout() {
                        return Timeout.NONE;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                    }
                }), options.fileSystem, new ByteBufferMetadata(byteBuffer)), null, dataSource);
        }
    }
}
