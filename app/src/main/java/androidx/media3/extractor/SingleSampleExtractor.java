package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import coil3.util.UtilsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleSampleExtractor implements Extractor {
    public ExtractorOutput extractorOutput;
    public final int fileSignature;
    public final int fileSignatureLength;
    public final String sampleMimeType;
    public int size;
    public byte state;
    public TrackOutput trackOutput;

    public SingleSampleExtractor(int i, int i2, String str) {
        this.fileSignature = i;
        this.fileSignatureLength = i2;
        this.sampleMimeType = str;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        TrackOutput trackOutputTrack = extractorOutput.track(1024, 4);
        this.trackOutput = trackOutputTrack;
        Format.Builder builder = new Format.Builder();
        String str = this.sampleMimeType;
        builder.containerMimeType = MimeTypes.normalizeMimeType(str);
        builder.sampleMimeType = MimeTypes.normalizeMimeType(str);
        Format$$ExternalSyntheticOutline0.m(builder, trackOutputTrack);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(new SingleSampleSeekMap());
        this.state = (byte) 1;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        byte b = this.state;
        if (b != 1) {
            if (b == 2) {
                return -1;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
            return 0;
        }
        TrackOutput trackOutput = this.trackOutput;
        trackOutput.getClass();
        int iSampleData = trackOutput.sampleData((DataReader) extractorInput, 1024, true);
        if (iSampleData != -1) {
            this.size += iSampleData;
            return 0;
        }
        this.state = (byte) 2;
        this.trackOutput.sampleMetadata(0L, 1, this.size, 0, null);
        this.size = 0;
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        if (j == 0 || this.state == 1) {
            this.state = (byte) 1;
            this.size = 0;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        int i = this.fileSignatureLength;
        int i2 = this.fileSignature;
        UtilsKt.checkState((i2 == -1 || i == -1) ? false : true);
        ParsableByteArray parsableByteArray = new ParsableByteArray(i);
        ((DefaultExtractorInput) extractorInput).peekFully(parsableByteArray.data, 0, i, false);
        return parsableByteArray.readUnsignedShort() == i2;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
