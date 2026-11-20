package androidx.media3.extractor.ts;

import androidx.media3.extractor.BinarySearchSeeker$BinarySearchSeekMap;
import androidx.media3.extractor.BinarySearchSeeker$SeekOperationParams;
import androidx.media3.extractor.BinarySearchSeeker$SeekTimestampConverter;
import androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult;
import androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PsBinarySearchSeeker {
    public final int minimumSearchRange;
    public final BinarySearchSeeker$BinarySearchSeekMap seekMap;
    public BinarySearchSeeker$SeekOperationParams seekOperationParams;
    public final BinarySearchSeeker$TimestampSeeker timestampSeeker;

    public PsBinarySearchSeeker(BinarySearchSeeker$SeekTimestampConverter binarySearchSeeker$SeekTimestampConverter, BinarySearchSeeker$TimestampSeeker binarySearchSeeker$TimestampSeeker, long j, long j2, long j3, long j4, long j5, int i) {
        this.timestampSeeker = binarySearchSeeker$TimestampSeeker;
        this.minimumSearchRange = i;
        this.seekMap = new BinarySearchSeeker$BinarySearchSeekMap(binarySearchSeeker$SeekTimestampConverter, j, j2, j3, j4, j5);
    }

    public static int peekIntAtPosition(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int seekToPosition(ExtractorInput extractorInput, long j, PositionHolder positionHolder) {
        if (j == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.position = j;
        return 1;
    }

    public final int handlePendingSeek(ExtractorInput extractorInput, PositionHolder positionHolder) {
        while (true) {
            BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams = this.seekOperationParams;
            binarySearchSeeker$SeekOperationParams.getClass();
            long j = binarySearchSeeker$SeekOperationParams.floorBytePosition;
            long j2 = binarySearchSeeker$SeekOperationParams.ceilingBytePosition;
            long j3 = binarySearchSeeker$SeekOperationParams.nextSearchBytePosition;
            long j4 = j2 - j;
            long j5 = this.minimumSearchRange;
            BinarySearchSeeker$TimestampSeeker binarySearchSeeker$TimestampSeeker = this.timestampSeeker;
            if (j4 <= j5) {
                this.seekOperationParams = null;
                binarySearchSeeker$TimestampSeeker.onSeekFinished();
                return seekToPosition(extractorInput, j, positionHolder);
            }
            long position = j3 - extractorInput.getPosition();
            if (position < 0 || position > 262144) {
                return seekToPosition(extractorInput, j3, positionHolder);
            }
            extractorInput.skipFully((int) position);
            extractorInput.resetPeekPosition();
            BinarySearchSeeker$TimestampSearchResult binarySearchSeeker$TimestampSearchResultSearchForTimestamp = binarySearchSeeker$TimestampSeeker.searchForTimestamp(extractorInput, binarySearchSeeker$SeekOperationParams.targetTimePosition);
            int i = binarySearchSeeker$TimestampSearchResultSearchForTimestamp.type;
            long j6 = binarySearchSeeker$TimestampSearchResultSearchForTimestamp.timestampToUpdate;
            long j7 = binarySearchSeeker$TimestampSearchResultSearchForTimestamp.bytePositionToUpdate;
            if (i == -3) {
                this.seekOperationParams = null;
                binarySearchSeeker$TimestampSeeker.onSeekFinished();
                return seekToPosition(extractorInput, j3, positionHolder);
            }
            if (i == -2) {
                binarySearchSeeker$SeekOperationParams.floorTimePosition = j6;
                binarySearchSeeker$SeekOperationParams.floorBytePosition = j7;
                binarySearchSeeker$SeekOperationParams.nextSearchBytePosition = BinarySearchSeeker$SeekOperationParams.calculateNextSearchBytePosition(binarySearchSeeker$SeekOperationParams.targetTimePosition, j6, binarySearchSeeker$SeekOperationParams.ceilingTimePosition, j7, binarySearchSeeker$SeekOperationParams.ceilingBytePosition, binarySearchSeeker$SeekOperationParams.approxBytesPerFrame);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Invalid case");
                        return 0;
                    }
                    long position2 = j7 - extractorInput.getPosition();
                    if (position2 >= 0 && position2 <= 262144) {
                        extractorInput.skipFully((int) position2);
                    }
                    this.seekOperationParams = null;
                    binarySearchSeeker$TimestampSeeker.onSeekFinished();
                    return seekToPosition(extractorInput, j7, positionHolder);
                }
                binarySearchSeeker$SeekOperationParams.ceilingTimePosition = j6;
                binarySearchSeeker$SeekOperationParams.ceilingBytePosition = j7;
                binarySearchSeeker$SeekOperationParams.nextSearchBytePosition = BinarySearchSeeker$SeekOperationParams.calculateNextSearchBytePosition(binarySearchSeeker$SeekOperationParams.targetTimePosition, binarySearchSeeker$SeekOperationParams.floorTimePosition, j6, binarySearchSeeker$SeekOperationParams.floorBytePosition, j7, binarySearchSeeker$SeekOperationParams.approxBytesPerFrame);
            }
        }
    }

    public final void setSeekTargetUs(long j) {
        BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams = this.seekOperationParams;
        if (binarySearchSeeker$SeekOperationParams == null || binarySearchSeeker$SeekOperationParams.seekTimeUs != j) {
            BinarySearchSeeker$BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap = this.seekMap;
            this.seekOperationParams = new BinarySearchSeeker$SeekOperationParams(j, binarySearchSeeker$BinarySearchSeekMap.seekTimestampConverter.timeUsToTargetTime(j), binarySearchSeeker$BinarySearchSeekMap.ceilingTimePosition, binarySearchSeeker$BinarySearchSeekMap.floorBytePosition, binarySearchSeeker$BinarySearchSeekMap.ceilingBytePosition, binarySearchSeeker$BinarySearchSeekMap.approxBytesPerFrame);
        }
    }
}
