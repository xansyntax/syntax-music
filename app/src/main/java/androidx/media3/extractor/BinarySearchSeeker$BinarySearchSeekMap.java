package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BinarySearchSeeker$BinarySearchSeekMap implements SeekMap {
    public final long approxBytesPerFrame;
    public final long ceilingBytePosition;
    public final long ceilingTimePosition;
    public final long durationUs;
    public final long floorBytePosition;
    public final BinarySearchSeeker$SeekTimestampConverter seekTimestampConverter;

    public BinarySearchSeeker$BinarySearchSeekMap(BinarySearchSeeker$SeekTimestampConverter binarySearchSeeker$SeekTimestampConverter, long j, long j2, long j3, long j4, long j5) {
        this.seekTimestampConverter = binarySearchSeeker$SeekTimestampConverter;
        this.durationUs = j;
        this.ceilingTimePosition = j2;
        this.floorBytePosition = j3;
        this.ceilingBytePosition = j4;
        this.approxBytesPerFrame = j5;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        SeekPoint seekPoint = new SeekPoint(j, BinarySearchSeeker$SeekOperationParams.calculateNextSearchBytePosition(this.seekTimestampConverter.timeUsToTargetTime(j), 0L, this.ceilingTimePosition, this.floorBytePosition, this.ceilingBytePosition, this.approxBytesPerFrame));
        return new SeekMap.SeekPoints(seekPoint, seekPoint);
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }
}
