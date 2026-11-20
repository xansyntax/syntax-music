package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import coil3.util.UtilsKt;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultOggSeeker implements OggSeeker {
    public long end;
    public long endGranule;
    public final OggPageHeader pageHeader;
    public final long payloadEndPosition;
    public final long payloadStartPosition;
    public long positionBeforeSeekToEnd;
    public long start;
    public long startGranule;
    public byte state;
    public final StreamReader streamReader;
    public long targetGranule;
    public long totalGranules;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OggSeekMap implements SeekMap {
        public OggSeekMap() {
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long getDurationUs() {
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            return (defaultOggSeeker.totalGranules * 1000000) / ((long) defaultOggSeeker.streamReader.sampleRate);
        }

        @Override // androidx.media3.extractor.SeekMap
        public final SeekMap.SeekPoints getSeekPoints(long j) {
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            long j2 = (((long) defaultOggSeeker.streamReader.sampleRate) * j) / 1000000;
            long j3 = defaultOggSeeker.payloadStartPosition;
            BigInteger bigIntegerValueOf = BigInteger.valueOf(j2);
            long j4 = defaultOggSeeker.payloadEndPosition;
            SeekPoint seekPoint = new SeekPoint(j, Util.constrainValue((bigIntegerValueOf.multiply(BigInteger.valueOf(j4 - j3)).divide(BigInteger.valueOf(defaultOggSeeker.totalGranules)).longValue() + j3) - 30000, defaultOggSeeker.payloadStartPosition, j4 - 1));
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean isSeekable() {
            return true;
        }
    }

    public DefaultOggSeeker(StreamReader streamReader, long j, long j2, long j3, long j4, boolean z) {
        UtilsKt.checkArgument(j >= 0 && j2 > j);
        this.streamReader = streamReader;
        this.payloadStartPosition = j;
        this.payloadEndPosition = j2;
        if (j3 == j2 - j || z) {
            this.totalGranules = j4;
            this.state = (byte) 4;
        } else {
            this.state = (byte) 0;
        }
        this.pageHeader = new OggPageHeader();
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public final SeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c2  */
    @Override // androidx.media3.extractor.ogg.OggSeeker
    public final long read(ExtractorInput extractorInput) throws IOException {
        long j;
        long jConstrainValue;
        byte b = this.state;
        long j2 = this.payloadEndPosition;
        OggPageHeader oggPageHeader = this.pageHeader;
        if (b == 0) {
            long position = extractorInput.getPosition();
            this.positionBeforeSeekToEnd = position;
            this.state = (byte) 1;
            long j3 = j2 - 65307;
            if (j3 > position) {
                return j3;
            }
        } else if (b != 1) {
            if (b == 2) {
                if (this.start == this.end) {
                    jConstrainValue = -1;
                } else {
                    long position2 = extractorInput.getPosition();
                    if (oggPageHeader.skipToNextPage(extractorInput, this.end)) {
                        oggPageHeader.populate(extractorInput, false);
                        extractorInput.resetPeekPosition();
                        long j4 = this.targetGranule;
                        long j5 = oggPageHeader.granulePosition;
                        long j6 = j4 - j5;
                        j = 2;
                        int i = oggPageHeader.headerSize + oggPageHeader.bodySize;
                        if (0 > j6 || j6 >= 72000) {
                            if (j6 < 0) {
                                this.end = position2;
                                this.endGranule = j5;
                            } else {
                                this.start = extractorInput.getPosition() + ((long) i);
                                this.startGranule = oggPageHeader.granulePosition;
                            }
                            long j7 = this.end;
                            long j8 = this.start;
                            if (j7 - j8 < 100000) {
                                this.end = j8;
                                jConstrainValue = j8;
                            } else {
                                long position3 = extractorInput.getPosition() - (((long) i) * (j6 <= 0 ? 2L : 1L));
                                long j9 = this.end;
                                long j10 = this.start;
                                jConstrainValue = Util.constrainValue((((j9 - j10) * j6) / (this.endGranule - this.startGranule)) + position3, j10, j9 - 1);
                            }
                        } else {
                            jConstrainValue = -1;
                        }
                    } else {
                        jConstrainValue = this.start;
                        if (jConstrainValue == position2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("No ogg page can be found.");
                            return 0L;
                        }
                    }
                    if (jConstrainValue != -1) {
                        return jConstrainValue;
                    }
                    this.state = (byte) 3;
                }
                j = 2;
                if (jConstrainValue != -1) {
                    return jConstrainValue;
                }
                this.state = (byte) 3;
            } else {
                if (b != 3) {
                    if (b == 4) {
                        return -1L;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return 0L;
                }
                j = 2;
            }
            while (true) {
                oggPageHeader.skipToNextPage(extractorInput, -1L);
                oggPageHeader.populate(extractorInput, false);
                if (oggPageHeader.granulePosition > this.targetGranule) {
                    extractorInput.resetPeekPosition();
                    this.state = (byte) 4;
                    return -(this.startGranule + j);
                }
                extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
                this.start = extractorInput.getPosition();
                this.startGranule = oggPageHeader.granulePosition;
            }
        }
        oggPageHeader.type = (short) 0;
        oggPageHeader.granulePosition = 0L;
        oggPageHeader.pageSegmentCount = (short) 0;
        oggPageHeader.headerSize = 0;
        oggPageHeader.bodySize = 0;
        if (!oggPageHeader.skipToNextPage(extractorInput, -1L)) {
            throw new EOFException();
        }
        oggPageHeader.populate(extractorInput, false);
        extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
        long j11 = oggPageHeader.granulePosition;
        while ((oggPageHeader.type & 4) != 4 && oggPageHeader.skipToNextPage(extractorInput, -1L) && extractorInput.getPosition() < j2 && oggPageHeader.populate(extractorInput, true)) {
            try {
                extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
                j11 = oggPageHeader.granulePosition;
            } catch (EOFException unused) {
            }
        }
        this.totalGranules = j11;
        this.state = (byte) 4;
        return this.positionBeforeSeekToEnd;
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public final void startSeek(long j) {
        this.targetGranule = Util.constrainValue(j, 0L, this.totalGranules - 1);
        this.state = (byte) 2;
        this.start = this.payloadStartPosition;
        this.end = this.payloadEndPosition;
        this.startGranule = 0L;
        this.endGranule = this.totalGranules;
    }
}
