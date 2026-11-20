package androidx.media3.exoplayer.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import androidx.core.view.DisplayCompat;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import coil3.util.UtilsKt;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapFactoryImageDecoder extends SimpleDecoder {
    public final Context context;
    public final int maxOutputSize;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.image.BitmapFactoryImageDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends DecoderOutputBuffer {
        public Bitmap bitmap;

        public AnonymousClass1() {
        }

        @Override // androidx.media3.decoder.DecoderOutputBuffer
        public final void clear() {
            this.bitmap = null;
            this.flags = 0;
            this.timeUs = 0L;
            this.shouldBeSkipped = false;
        }

        @Override // androidx.media3.decoder.DecoderOutputBuffer
        public final void release() {
            BitmapFactoryImageDecoder.this.releaseOutputBuffer(this);
        }
    }

    public BitmapFactoryImageDecoder(Context context) {
        super(new DecoderInputBuffer[1], new AnonymousClass1[1]);
        this.context = context;
        this.maxOutputSize = -1;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderOutputBuffer createOutputBuffer() {
        return new AnonymousClass1();
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderException decode(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z) {
        AnonymousClass1 anonymousClass1 = (AnonymousClass1) decoderOutputBuffer;
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        byteBuffer.getClass();
        UtilsKt.checkState(byteBuffer.hasArray());
        UtilsKt.checkArgument(byteBuffer.arrayOffset() == 0);
        try {
            int iMax = this.maxOutputSize;
            if (iMax == -1) {
                Context context = this.context;
                if (context != null) {
                    Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
                    int i = currentDisplayModeSize.x;
                    int i2 = currentDisplayModeSize.y;
                    Format format = decoderInputBuffer.format;
                    if (format != null) {
                        int i3 = format.tileCountHorizontal;
                        if (i3 != -1) {
                            i *= i3;
                        }
                        int i4 = format.tileCountVertical;
                        if (i4 != -1) {
                            i2 *= i4;
                        }
                    }
                    iMax = (Math.max(i, i2) * 2) - 1;
                } else {
                    iMax = 4096;
                }
            }
            anonymousClass1.bitmap = DisplayCompat.decode(byteBuffer.array(), byteBuffer.remaining(), iMax);
            anonymousClass1.timeUs = decoderInputBuffer.timeUs;
            return null;
        } catch (ParserException e) {
            return new ImageDecoderException("Could not decode image data with BitmapFactory.", e);
        } catch (IOException e2) {
            return new ImageDecoderException(e2);
        }
    }
}
