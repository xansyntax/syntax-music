package androidx.media3.extractor.ogg;

import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StreamReader {
    public long currentGranule;
    public ExtractorOutput extractorOutput;
    public boolean formatSet;
    public long lengthOfReadPacket;
    public OggSeeker oggSeeker;
    public long payloadStartPosition;
    public int sampleRate;
    public boolean seekMapSet;
    public byte state;
    public long targetGranule;
    public TrackOutput trackOutput;
    public final OggPacket oggPacket = new OggPacket();
    public CallbackWrapper setupData = new CallbackWrapper((byte) 24, false);

    public void onSeekEnd(long j) {
        this.currentGranule = j;
    }

    public long preparePayload(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        if (bArr[0] != -1) {
            return -1L;
        }
        int i = (bArr[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            parsableByteArray.skipBytes(4);
            parsableByteArray.readUtf8EncodedLong();
        }
        int frameBlockSizeSamplesFromKey = AacUtil.readFrameBlockSizeSamplesFromKey(i, parsableByteArray);
        parsableByteArray.setPosition(0);
        return frameBlockSizeSamplesFromKey;
    }

    public abstract boolean readHeaders(ParsableByteArray parsableByteArray, long j, CallbackWrapper callbackWrapper);

    public void reset(boolean z) {
        if (z) {
            this.setupData = new CallbackWrapper((byte) 24, false);
            this.payloadStartPosition = 0L;
            this.state = (byte) 0;
        } else {
            this.state = (byte) 1;
        }
        this.targetGranule = -1L;
        this.currentGranule = 0L;
    }
}
