package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Ac3Extractor implements Extractor {
    public final Ac3Reader reader = new Ac3Reader("audio/ac3");
    public final ParsableByteArray sampleData = new ParsableByteArray(2786);
    public boolean startedPacket;

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.reader.createTracks(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
        extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        ParsableByteArray parsableByteArray = this.sampleData;
        int i = extractorInput.read(parsableByteArray.data, 0, 2786);
        if (i == -1) {
            return -1;
        }
        parsableByteArray.setPosition(0);
        parsableByteArray.setLimit(i);
        boolean z = this.startedPacket;
        Ac3Reader ac3Reader = this.reader;
        if (!z) {
            ac3Reader.timeUs = 0L;
            this.startedPacket = true;
        }
        ac3Reader.consume(parsableByteArray);
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        this.startedPacket = false;
        this.reader.seek();
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        DefaultExtractorInput defaultExtractorInput;
        int ac3SyncframeSize;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i = 0;
        while (true) {
            defaultExtractorInput = (DefaultExtractorInput) extractorInput;
            defaultExtractorInput.peekFully(parsableByteArray.data, 0, 10, false);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt24() != 4801587) {
                break;
            }
            parsableByteArray.skipBytes(3);
            int synchSafeInt = parsableByteArray.readSynchSafeInt();
            i += synchSafeInt + 10;
            defaultExtractorInput.advancePeekPosition(synchSafeInt, false);
        }
        defaultExtractorInput.peekBufferPosition = 0;
        defaultExtractorInput.advancePeekPosition(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            defaultExtractorInput.peekFully(parsableByteArray.data, 0, 6, false);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedShort() != 2935) {
                defaultExtractorInput.peekBufferPosition = 0;
                i3++;
                if (i3 - i >= 8192) {
                    break;
                }
                defaultExtractorInput.advancePeekPosition(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                byte[] bArr = parsableByteArray.data;
                if (bArr.length < 6) {
                    ac3SyncframeSize = -1;
                } else if (((bArr[5] & 248) >> 3) > 10) {
                    ac3SyncframeSize = ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2;
                } else {
                    byte b = bArr[4];
                    ac3SyncframeSize = AacUtil.getAc3SyncframeSize((b & 192) >> 6, b & 63);
                }
                if (ac3SyncframeSize == -1) {
                    break;
                }
                defaultExtractorInput.advancePeekPosition(ac3SyncframeSize - 6, false);
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
