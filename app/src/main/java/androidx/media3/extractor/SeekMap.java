package androidx.media3.extractor;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.avi.AviExtractor;
import androidx.media3.extractor.avi.ChunkReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SeekMap {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = seekPoint;
            this.second = seekPoint2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SeekPoints.class != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            return this.first.equals(seekPoints.first) && this.second.equals(seekPoints.second);
        }

        public final int hashCode() {
            return this.second.hashCode() + (this.first.hashCode() * 31);
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("[");
            SeekPoint seekPoint = this.first;
            sb.append(seekPoint);
            SeekPoint seekPoint2 = this.second;
            if (seekPoint.equals(seekPoint2)) {
                str = "";
            } else {
                str = ", " + seekPoint2;
            }
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, str, "]");
        }
    }

    long getDurationUs();

    SeekPoints getSeekPoints(long j);

    default boolean isEstimated() {
        return false;
    }

    boolean isSeekable();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class Unseekable implements SeekMap {
        public final /* synthetic */ byte $r8$classId;
        public final long durationUs;
        public final Object startSeekPoints;

        public Unseekable(long j, long j2) {
            this.$r8$classId = (byte) 0;
            this.durationUs = j;
            SeekPoint seekPoint = j2 == 0 ? SeekPoint.START : new SeekPoint(0L, j2);
            this.startSeekPoints = new SeekPoints(seekPoint, seekPoint);
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long getDurationUs() {
            switch (this.$r8$classId) {
                case 0:
                    return this.durationUs;
                case 1:
                    return ((FlacStreamMetadata) this.startSeekPoints).getDurationUs();
                default:
                    return this.durationUs;
            }
        }

        @Override // androidx.media3.extractor.SeekMap
        public final SeekPoints getSeekPoints(long j) {
            byte b = this.$r8$classId;
            int i = 1;
            Object obj = this.startSeekPoints;
            switch (b) {
                case 0:
                    return (SeekPoints) obj;
                case 1:
                    FlacStreamMetadata flacStreamMetadata = (FlacStreamMetadata) obj;
                    flacStreamMetadata.seekTable.getClass();
                    CallbackWrapper callbackWrapper = flacStreamMetadata.seekTable;
                    long[] jArr = (long[]) callbackWrapper.mCallback;
                    long[] jArr2 = (long[]) callbackWrapper.mExecutor;
                    int iBinarySearchFloor = Util.binarySearchFloor(jArr, Util.constrainValue((((long) flacStreamMetadata.sampleRate) * j) / 1000000, 0L, flacStreamMetadata.totalSamples - 1), false);
                    long j2 = iBinarySearchFloor == -1 ? 0L : jArr[iBinarySearchFloor];
                    long j3 = iBinarySearchFloor != -1 ? jArr2[iBinarySearchFloor] : 0L;
                    int i2 = flacStreamMetadata.sampleRate;
                    long j4 = (j2 * 1000000) / ((long) i2);
                    long j5 = this.durationUs;
                    SeekPoint seekPoint = new SeekPoint(j4, j3 + j5);
                    if (j4 == j || iBinarySearchFloor == jArr.length - 1) {
                        return new SeekPoints(seekPoint, seekPoint);
                    }
                    int i3 = iBinarySearchFloor + 1;
                    return new SeekPoints(seekPoint, new SeekPoint((jArr[i3] * 1000000) / ((long) i2), j5 + jArr2[i3]));
                default:
                    AviExtractor aviExtractor = (AviExtractor) obj;
                    SeekPoints seekPoints = aviExtractor.chunkReaders[0].getSeekPoints(j);
                    while (true) {
                        ChunkReader[] chunkReaderArr = aviExtractor.chunkReaders;
                        if (i >= chunkReaderArr.length) {
                            return seekPoints;
                        }
                        SeekPoints seekPoints2 = chunkReaderArr[i].getSeekPoints(j);
                        if (seekPoints2.first.position < seekPoints.first.position) {
                            seekPoints = seekPoints2;
                        }
                        i++;
                    }
                    break;
            }
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean isSeekable() {
            switch (this.$r8$classId) {
                case 0:
                    return false;
                case 1:
                    return true;
                default:
                    return true;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Unseekable(long j) {
            this(j, 0L);
            this.$r8$classId = (byte) 0;
        }

        public /* synthetic */ Unseekable(Object obj, long j, byte b) {
            this.$r8$classId = b;
            this.startSeekPoints = obj;
            this.durationUs = j;
        }
    }
}
