package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.MpegAudioUtil$Header;
import androidx.media3.extractor.TrackOutput;
import coil3.util.UtilsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MpegAudioReader implements ElementaryStreamReader {
    public final String containerMimeType;
    public String formatId;
    public int frameBytesRead;
    public long frameDurationUs;
    public int frameSize;
    public boolean hasOutputFormat;
    public final MpegAudioUtil$Header header;
    public final ParsableByteArray headerScratch;
    public final String language;
    public boolean lastByteWasFF;
    public TrackOutput output;
    public final int roleFlags;
    public byte state = 0;
    public long timeUs;

    public MpegAudioReader(String str, int i, String str2) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.headerScratch = parsableByteArray;
        parsableByteArray.data[0] = -1;
        this.header = new MpegAudioUtil$Header();
        this.timeUs = -9223372036854775807L;
        this.language = str;
        this.roleFlags = i;
        this.containerMimeType = str2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void consume(ParsableByteArray parsableByteArray) {
        this.output.getClass();
        while (parsableByteArray.bytesLeft() > 0) {
            byte b = this.state;
            ParsableByteArray parsableByteArray2 = this.headerScratch;
            if (b == 0) {
                byte[] bArr = parsableByteArray.data;
                int i = parsableByteArray.position;
                int i2 = parsableByteArray.limit;
                while (true) {
                    if (i >= i2) {
                        parsableByteArray.setPosition(i2);
                        break;
                    }
                    byte b2 = bArr[i];
                    boolean z = (b2 & 255) == 255;
                    boolean z2 = this.lastByteWasFF && (b2 & 224) == 224;
                    this.lastByteWasFF = z;
                    if (z2) {
                        parsableByteArray.setPosition(i + 1);
                        this.lastByteWasFF = false;
                        parsableByteArray2.data[1] = bArr[i];
                        this.frameBytesRead = 2;
                        this.state = (byte) 1;
                        break;
                    }
                    i++;
                }
            } else if (b == 1) {
                int iMin = Math.min(parsableByteArray.bytesLeft(), 4 - this.frameBytesRead);
                parsableByteArray.readBytes(parsableByteArray2.data, this.frameBytesRead, iMin);
                int i3 = this.frameBytesRead + iMin;
                this.frameBytesRead = i3;
                if (i3 >= 4) {
                    parsableByteArray2.setPosition(0);
                    int i4 = parsableByteArray2.readInt();
                    MpegAudioUtil$Header mpegAudioUtil$Header = this.header;
                    if (mpegAudioUtil$Header.setForHeaderData(i4)) {
                        this.frameSize = mpegAudioUtil$Header.frameSize;
                        if (!this.hasOutputFormat) {
                            this.frameDurationUs = (((long) mpegAudioUtil$Header.samplesPerFrame) * 1000000) / ((long) mpegAudioUtil$Header.sampleRate);
                            Format.Builder builder = new Format.Builder();
                            builder.id = this.formatId;
                            builder.containerMimeType = MimeTypes.normalizeMimeType(this.containerMimeType);
                            builder.sampleMimeType = MimeTypes.normalizeMimeType(mpegAudioUtil$Header.mimeType);
                            builder.maxInputSize = 4096;
                            builder.channelCount = mpegAudioUtil$Header.channels;
                            builder.sampleRate = mpegAudioUtil$Header.sampleRate;
                            builder.language = this.language;
                            builder.roleFlags = this.roleFlags;
                            this.output.format(new Format(builder));
                            this.hasOutputFormat = true;
                        }
                        parsableByteArray2.setPosition(0);
                        this.output.sampleData(4, parsableByteArray2);
                        this.state = (byte) 2;
                    } else {
                        this.frameBytesRead = 0;
                        this.state = (byte) 1;
                    }
                }
            } else {
                if (b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return;
                }
                int iMin2 = Math.min(parsableByteArray.bytesLeft(), this.frameSize - this.frameBytesRead);
                this.output.sampleData(iMin2, parsableByteArray);
                int i5 = this.frameBytesRead + iMin2;
                this.frameBytesRead = i5;
                if (i5 >= this.frameSize) {
                    UtilsKt.checkState(this.timeUs != -9223372036854775807L);
                    this.output.sampleMetadata(this.timeUs, 1, this.frameSize, 0, null);
                    this.timeUs += this.frameDurationUs;
                    this.frameBytesRead = 0;
                    this.state = (byte) 0;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        trackIdGenerator.maybeThrowUninitializedError();
        this.formatId = trackIdGenerator.formatId;
        trackIdGenerator.maybeThrowUninitializedError();
        this.output = extractorOutput.track(trackIdGenerator.trackId, 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetStarted(int i, long j) {
        this.timeUs = j;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void seek() {
        this.state = (byte) 0;
        this.frameBytesRead = 0;
        this.lastByteWasFF = false;
        this.timeUs = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetFinished(boolean z) {
    }
}
