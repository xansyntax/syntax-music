package androidx.media3.exoplayer.video.spherical;

import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlayerImpl;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraMotionRenderer extends BaseRenderer {
    public final DecoderInputBuffer buffer;
    public long lastTimestampUs;
    public ExoPlayerImpl.FrameMetadataListener listener;
    public final ParsableByteArray scratch;

    public CameraMotionRenderer() {
        super(6);
        this.buffer = new DecoderInputBuffer(1);
        this.scratch = new ParsableByteArray();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final String getName() {
        return "CameraMotionRenderer";
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void handleMessage(int i, Object obj) {
        if (i == 8) {
            this.listener = (ExoPlayerImpl.FrameMetadataListener) obj;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onDisabled() {
        ExoPlayerImpl.FrameMetadataListener frameMetadataListener = this.listener;
        if (frameMetadataListener != null) {
            frameMetadataListener.onCameraMotionReset();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onPositionReset(long j, boolean z, boolean z2) {
        this.lastTimestampUs = Long.MIN_VALUE;
        ExoPlayerImpl.FrameMetadataListener frameMetadataListener = this.listener;
        if (frameMetadataListener != null) {
            frameMetadataListener.onCameraMotionReset();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void render(long j, long j2) {
        float[] fArr;
        while (!hasReadStreamToEnd() && this.lastTimestampUs < 100000 + j) {
            DecoderInputBuffer decoderInputBuffer = this.buffer;
            decoderInputBuffer.clear();
            WeakCache weakCache = this.formatHolder;
            weakCache.clear();
            if (readSource(weakCache, decoderInputBuffer, 0) != -4 || decoderInputBuffer.getFlag(4)) {
                return;
            }
            long j3 = decoderInputBuffer.timeUs;
            this.lastTimestampUs = j3;
            boolean z = j3 < this.lastResetPositionUs;
            if (this.listener != null && !z) {
                decoderInputBuffer.flip();
                ByteBuffer byteBuffer = decoderInputBuffer.data;
                String str = Util.DEVICE_DEBUG_INFO;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    byte[] bArrArray = byteBuffer.array();
                    int iLimit = byteBuffer.limit();
                    ParsableByteArray parsableByteArray = this.scratch;
                    parsableByteArray.reset(bArrArray, iLimit);
                    parsableByteArray.setPosition(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i = 0; i < 3; i++) {
                        fArr2[i] = Float.intBitsToFloat(parsableByteArray.readLittleEndianInt());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.listener.onCameraMotion();
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final int supportsFormat(Format format) {
        return "application/x-camera-motion".equals(format.sampleMimeType) ? BaseRenderer.create(4, 0, 0, 0) : BaseRenderer.create(0, 0, 0, 0);
    }
}
