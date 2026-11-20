package androidx.media3.extractor.amr;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.mp3.ConstantBitrateSeeker;
import com.metrolist.music.recognition.VibraSignature;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AmrExtractor implements Extractor {
    public static final byte[] amrSignatureNb;
    public static final byte[] amrSignatureWb;
    public static final int[] frameSizeBytesByTypeNb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] frameSizeBytesByTypeWb = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    public int currentSampleBytesRemaining;
    public int currentSampleSize;
    public long currentSampleTimeUs;
    public TrackOutput currentTrackOutput;
    public ExtractorOutput extractorOutput;
    public boolean hasOutputFormat;
    public boolean isSeekInProgress;
    public boolean isWideBand;
    public int numSamplesWithSameSize;
    public TrackOutput realTrackOutput;
    public SeekMap seekMap;
    public long seekTimeUs;
    public final DiscardingTrackOutput skippingTrackOutput;
    public long timeOffsetUs;
    public final byte[] scratch = new byte[1];
    public int firstSampleSize = -1;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        Charset charset = StandardCharsets.UTF_8;
        amrSignatureNb = "#!AMR\n".getBytes(charset);
        amrSignatureWb = "#!AMR-WB\n".getBytes(charset);
    }

    public AmrExtractor() {
        DiscardingTrackOutput discardingTrackOutput = new DiscardingTrackOutput();
        this.skippingTrackOutput = discardingTrackOutput;
        this.currentTrackOutput = discardingTrackOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        TrackOutput trackOutputTrack = extractorOutput.track(0, 1);
        this.realTrackOutput = trackOutputTrack;
        this.currentTrackOutput = trackOutputTrack;
        extractorOutput.endTracks();
    }

    public final int peekNextSampleSize(ExtractorInput extractorInput) throws ParserException {
        boolean z;
        extractorInput.resetPeekPosition();
        byte[] bArr = this.scratch;
        extractorInput.peekFully(bArr, 0, 1);
        byte b = bArr[0];
        if ((b & 131) > 0) {
            throw ParserException.createForMalformedContainer(null, "Invalid padding bits for frame header " + ((int) b));
        }
        int i = (b >> 3) & 15;
        if (i >= 0 && i <= 15 && (((z = this.isWideBand) && (i < 10 || i > 13)) || (!z && (i < 12 || i > 14)))) {
            return z ? frameSizeBytesByTypeWb[i] : frameSizeBytesByTypeNb[i];
        }
        StringBuilder sb = new StringBuilder("Illegal AMR ");
        sb.append(this.isWideBand ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.createForMalformedContainer(null, sb.toString());
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00e8 A[PHI: r4
      0x00e8: PHI (r4v1 androidx.media3.extractor.ExtractorInput) = (r4v0 androidx.media3.extractor.ExtractorInput), (r4v6 androidx.media3.extractor.ExtractorInput) binds: [B:52:0x00e6, B:55:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ff  */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        ExtractorInput extractorInput2;
        int iSampleData;
        int i;
        this.realTrackOutput.getClass();
        String str = Util.DEVICE_DEBUG_INFO;
        if (extractorInput.getPosition() == 0 && !readAmrHeader(extractorInput)) {
            throw ParserException.createForMalformedContainer(null, "Could not find AMR header.");
        }
        if (!this.hasOutputFormat) {
            this.hasOutputFormat = true;
            boolean z = this.isWideBand;
            String str2 = z ? "audio/amr-wb" : "audio/amr";
            String str3 = z ? "audio/amr-wb" : "audio/3gpp";
            int i2 = z ? VibraSignature.REQUIRED_SAMPLE_RATE : 8000;
            int i3 = z ? frameSizeBytesByTypeWb[8] : frameSizeBytesByTypeNb[7];
            TrackOutput trackOutput = this.realTrackOutput;
            Format.Builder builder = new Format.Builder();
            builder.containerMimeType = MimeTypes.normalizeMimeType(str2);
            builder.sampleMimeType = MimeTypes.normalizeMimeType(str3);
            builder.maxInputSize = i3;
            builder.channelCount = 1;
            builder.sampleRate = i2;
            Format$$ExternalSyntheticOutline0.m(builder, trackOutput);
        }
        int i4 = 0;
        if (this.currentSampleBytesRemaining == 0) {
            try {
                int iPeekNextSampleSize = peekNextSampleSize(extractorInput);
                this.currentSampleSize = iPeekNextSampleSize;
                this.currentSampleBytesRemaining = iPeekNextSampleSize;
                int i5 = this.firstSampleSize;
                if (i5 == -1) {
                    extractorInput.getPosition();
                    iPeekNextSampleSize = this.currentSampleSize;
                    this.firstSampleSize = iPeekNextSampleSize;
                    i5 = iPeekNextSampleSize;
                }
                if (i5 == iPeekNextSampleSize) {
                    this.numSamplesWithSameSize++;
                }
                SeekMap seekMap = this.seekMap;
                if (seekMap instanceof IndexSeekMap) {
                    IndexSeekMap indexSeekMap = (IndexSeekMap) seekMap;
                    long j = this.timeOffsetUs + this.currentSampleTimeUs + 20000;
                    long position = extractorInput.getPosition() + ((long) this.currentSampleSize);
                    LongArray longArray = indexSeekMap.timesUs;
                    int i6 = longArray.size;
                    if (i6 == 0 || j - longArray.get(i6 - 1) >= 100000) {
                        LongArray longArray2 = indexSeekMap.positions;
                        LongArray longArray3 = indexSeekMap.timesUs;
                        if (longArray3.size == 0 && j > 0) {
                            longArray2.add(0L);
                            longArray3.add(0L);
                        }
                        longArray2.add(position);
                        longArray3.add(j);
                    }
                    if (this.isSeekInProgress && Math.abs(this.seekTimeUs - j) < 20000) {
                        this.isSeekInProgress = false;
                        this.currentTrackOutput = this.realTrackOutput;
                    }
                }
                extractorInput2 = extractorInput;
                iSampleData = this.currentTrackOutput.sampleData((DataReader) extractorInput2, this.currentSampleBytesRemaining, true);
                if (iSampleData == -1) {
                    i4 = -1;
                } else {
                    i = this.currentSampleBytesRemaining - iSampleData;
                    this.currentSampleBytesRemaining = i;
                    if (i <= 0) {
                        this.currentTrackOutput.sampleMetadata(this.currentSampleTimeUs + this.timeOffsetUs, 1, this.currentSampleSize, 0, null);
                        this.currentSampleTimeUs += 20000;
                    }
                }
            } catch (EOFException unused) {
                extractorInput2 = extractorInput;
            }
        } else {
            extractorInput2 = extractorInput;
            iSampleData = this.currentTrackOutput.sampleData((DataReader) extractorInput2, this.currentSampleBytesRemaining, true);
            if (iSampleData == -1) {
                i4 = -1;
            } else {
                i = this.currentSampleBytesRemaining - iSampleData;
                this.currentSampleBytesRemaining = i;
                if (i <= 0) {
                    this.currentTrackOutput.sampleMetadata(this.currentSampleTimeUs + this.timeOffsetUs, 1, this.currentSampleSize, 0, null);
                    this.currentSampleTimeUs += 20000;
                }
            }
        }
        extractorInput2.getLength();
        if (this.seekMap == null) {
            SeekMap.Unseekable unseekable = new SeekMap.Unseekable(-9223372036854775807L);
            this.seekMap = unseekable;
            this.extractorOutput.seekMap(unseekable);
        }
        if (i4 == -1) {
            SeekMap seekMap2 = this.seekMap;
            if (seekMap2 instanceof IndexSeekMap) {
                long j2 = this.timeOffsetUs + this.currentSampleTimeUs;
                ((IndexSeekMap) seekMap2).durationUs = j2;
                this.extractorOutput.seekMap(seekMap2);
                this.realTrackOutput.durationUs(j2);
            }
        }
        return i4;
    }

    public final boolean readAmrHeader(ExtractorInput extractorInput) {
        extractorInput.resetPeekPosition();
        byte[] bArr = amrSignatureNb;
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.peekFully(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.isWideBand = false;
            extractorInput.skipFully(bArr.length);
            return true;
        }
        extractorInput.resetPeekPosition();
        byte[] bArr3 = amrSignatureWb;
        byte[] bArr4 = new byte[bArr3.length];
        extractorInput.peekFully(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.isWideBand = true;
        extractorInput.skipFully(bArr3.length);
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        this.currentSampleTimeUs = 0L;
        this.currentSampleSize = 0;
        this.currentSampleBytesRemaining = 0;
        this.seekTimeUs = j2;
        SeekMap seekMap = this.seekMap;
        if (!(seekMap instanceof IndexSeekMap)) {
            if (j == 0 || !(seekMap instanceof ConstantBitrateSeeker)) {
                this.timeOffsetUs = 0L;
                return;
            } else {
                ConstantBitrateSeeker constantBitrateSeeker = (ConstantBitrateSeeker) seekMap;
                this.timeOffsetUs = (Math.max(0L, j - constantBitrateSeeker.firstFrameBytePosition) * 8000000) / ((long) constantBitrateSeeker.bitrate$1);
                return;
            }
        }
        IndexSeekMap indexSeekMap = (IndexSeekMap) seekMap;
        LongArray longArray = indexSeekMap.timesUs;
        long j3 = longArray.size == 0 ? -9223372036854775807L : longArray.get(Util.binarySearchFloor(indexSeekMap.positions, j));
        this.timeOffsetUs = j3;
        if (Math.abs(this.seekTimeUs - j3) < 20000) {
            return;
        }
        this.isSeekInProgress = true;
        this.currentTrackOutput = this.skippingTrackOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        return readAmrHeader(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
