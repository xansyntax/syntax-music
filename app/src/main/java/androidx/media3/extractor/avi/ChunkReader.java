package androidx.media3.extractor.avi;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import coil3.util.UtilsKt;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChunkReader {
    public final int alternativeChunkId;
    public int bytesRemainingInCurrentChunk;
    public int chunkCount;
    public final int chunkId;
    public int currentChunkIndex;
    public int currentChunkSize;
    public final long durationUs;
    public long firstIndexChunkOffset;
    public int indexChunkCount;
    public int indexSize;
    public int[] keyFrameIndices;
    public long[] keyFrameOffsets;
    public final AviStreamHeaderChunk streamHeaderChunk;
    public final TrackOutput trackOutput;

    public ChunkReader(int i, AviStreamHeaderChunk aviStreamHeaderChunk, TrackOutput trackOutput) {
        int i2 = aviStreamHeaderChunk.length;
        this.streamHeaderChunk = aviStreamHeaderChunk;
        int trackType = aviStreamHeaderChunk.getTrackType();
        boolean z = true;
        if (trackType != 1 && trackType != 2) {
            z = false;
        }
        UtilsKt.checkArgument(z);
        int i3 = (((i % 10) + 48) << 8) | ((i / 10) + 48);
        this.chunkId = (trackType == 2 ? 1667497984 : 1651965952) | i3;
        long j = ((long) aviStreamHeaderChunk.scale) * 1000000;
        long j2 = aviStreamHeaderChunk.rate;
        String str = Util.DEVICE_DEBUG_INFO;
        this.durationUs = Util.scaleLargeValue(i2, j, j2, RoundingMode.DOWN);
        this.trackOutput = trackOutput;
        this.alternativeChunkId = trackType == 2 ? i3 | 1650720768 : -1;
        this.firstIndexChunkOffset = -1L;
        this.keyFrameOffsets = new long[512];
        this.keyFrameIndices = new int[512];
        this.chunkCount = i2;
    }

    public final SeekPoint getSeekPoint(int i) {
        return new SeekPoint((this.durationUs / ((long) this.chunkCount)) * ((long) this.keyFrameIndices[i]), this.keyFrameOffsets[i]);
    }

    public final SeekMap.SeekPoints getSeekPoints(long j) {
        if (this.indexSize == 0) {
            SeekPoint seekPoint = new SeekPoint(0L, this.firstIndexChunkOffset);
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        int i = (int) (j / (this.durationUs / ((long) this.chunkCount)));
        int iBinarySearchFloor = Util.binarySearchFloor(this.keyFrameIndices, i, true, true);
        if (this.keyFrameIndices[iBinarySearchFloor] == i) {
            SeekPoint seekPoint2 = getSeekPoint(iBinarySearchFloor);
            return new SeekMap.SeekPoints(seekPoint2, seekPoint2);
        }
        SeekPoint seekPoint3 = getSeekPoint(iBinarySearchFloor);
        int i2 = iBinarySearchFloor + 1;
        return i2 < this.keyFrameOffsets.length ? new SeekMap.SeekPoints(seekPoint3, getSeekPoint(i2)) : new SeekMap.SeekPoints(seekPoint3, seekPoint3);
    }
}
