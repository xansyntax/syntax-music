package androidx.media3.extractor.text;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda20;
import coil3.util.UtilsKt;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SubtitleTranscodingTrackOutput implements TrackOutput {
    public Format currentFormat;
    public SubtitleParser currentSubtitleParser;
    public final TrackOutput delegate;
    public boolean shouldSuppressParsingErrors;
    public final CueDecoder subtitleParserFactory;
    public int sampleDataStart = 0;
    public int sampleDataEnd = 0;
    public byte[] sampleData = Util.EMPTY_BYTE_ARRAY;
    public final ParsableByteArray parsableScratch = new ParsableByteArray();

    public SubtitleTranscodingTrackOutput(TrackOutput trackOutput, CueDecoder cueDecoder) {
        this.delegate = trackOutput;
        this.subtitleParserFactory = cueDecoder;
    }

    public final void ensureSampleDataCapacity(int i) {
        int length = this.sampleData.length;
        int i2 = this.sampleDataEnd;
        if (length - i2 >= i) {
            return;
        }
        int i3 = i2 - this.sampleDataStart;
        int iMax = Math.max(i3 * 2, i + i3);
        byte[] bArr = this.sampleData;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.sampleDataStart, bArr2, 0, i3);
        this.sampleDataStart = 0;
        this.sampleDataEnd = i3;
        this.sampleData = bArr2;
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void format(Format format) {
        format.sampleMimeType.getClass();
        String str = format.sampleMimeType;
        UtilsKt.checkArgument(MimeTypes.getTrackType(str) == 3);
        boolean zEquals = format.equals(this.currentFormat);
        CueDecoder cueDecoder = this.subtitleParserFactory;
        if (!zEquals) {
            this.currentFormat = format;
            this.currentSubtitleParser = cueDecoder.supportsFormat(format) ? cueDecoder.create(format) : null;
        }
        SubtitleParser subtitleParser = this.currentSubtitleParser;
        TrackOutput trackOutput = this.delegate;
        if (subtitleParser == null) {
            trackOutput.format(format);
            return;
        }
        Format.Builder builderBuildUpon = format.buildUpon();
        builderBuildUpon.sampleMimeType = MimeTypes.normalizeMimeType("application/x-media3-cues");
        builderBuildUpon.codecs = str;
        builderBuildUpon.subsampleOffsetUs = Long.MAX_VALUE;
        builderBuildUpon.cueReplacementBehavior = cueDecoder.getCueReplacementBehavior(format);
        Format$$ExternalSyntheticOutline0.m(builderBuildUpon, trackOutput);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        if (this.currentSubtitleParser == null) {
            this.delegate.sampleData(parsableByteArray, i, i2);
            return;
        }
        ensureSampleDataCapacity(i);
        parsableByteArray.readBytes(this.sampleData, this.sampleDataEnd, i);
        this.sampleDataEnd += i;
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int sampleData$1(DataReader dataReader, int i, boolean z) throws EOFException {
        if (this.currentSubtitleParser == null) {
            return this.delegate.sampleData$1(dataReader, i, z);
        }
        ensureSampleDataCapacity(i);
        int i2 = dataReader.read(this.sampleData, this.sampleDataEnd, i);
        if (i2 != -1) {
            this.sampleDataEnd += i2;
            return i2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        int i4;
        if (this.currentSubtitleParser == null) {
            this.delegate.sampleMetadata(j, i, i2, i3, cryptoData);
            return;
        }
        UtilsKt.checkArgument("DRM on subtitles is not supported", cryptoData == null);
        int i5 = (this.sampleDataEnd - i3) - i2;
        try {
            i4 = i5;
            try {
                this.currentSubtitleParser.parse(this.sampleData, i4, i2, SubtitleParser.OutputOptions.ALL, new MediaSessionStub$$ExternalSyntheticLambda20(this, j, i));
            } catch (RuntimeException e) {
                e = e;
                RuntimeException runtimeException = e;
                if (!this.shouldSuppressParsingErrors) {
                    throw runtimeException;
                }
                Log.w("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", runtimeException);
            }
        } catch (RuntimeException e2) {
            e = e2;
            i4 = i5;
        }
        int i6 = i4 + i2;
        this.sampleDataStart = i6;
        if (i6 == this.sampleDataEnd) {
            this.sampleDataStart = 0;
            this.sampleDataEnd = 0;
        }
    }
}
