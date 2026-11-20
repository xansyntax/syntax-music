package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import io.ktor.util.cio.ByteBufferPoolKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SectionReader implements TsPayloadReader {
    public int bytesRead;
    public final SectionPayloadReader reader;
    public final ParsableByteArray sectionData = new ParsableByteArray(32);
    public boolean sectionSyntaxIndicator;
    public int totalSectionLength;
    public boolean waitingForPayloadStart;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.reader = sectionPayloadReader;
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void consume(int i, ParsableByteArray parsableByteArray) {
        int unsignedByte;
        boolean z = (i & 1) != 0;
        if (z) {
            unsignedByte = parsableByteArray.position + parsableByteArray.readUnsignedByte();
        } else {
            unsignedByte = -1;
        }
        if (this.waitingForPayloadStart) {
            if (!z) {
                return;
            }
            this.waitingForPayloadStart = false;
            parsableByteArray.setPosition(unsignedByte);
            this.bytesRead = 0;
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i2 = this.bytesRead;
            ParsableByteArray parsableByteArray2 = this.sectionData;
            if (i2 < 3) {
                if (i2 == 0) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    parsableByteArray.setPosition(parsableByteArray.position - 1);
                    if (unsignedByte2 == 255) {
                        this.waitingForPayloadStart = true;
                        return;
                    }
                }
                int iMin = Math.min(parsableByteArray.bytesLeft(), 3 - this.bytesRead);
                parsableByteArray.readBytes(parsableByteArray2.data, this.bytesRead, iMin);
                int i3 = this.bytesRead + iMin;
                this.bytesRead = i3;
                if (i3 == 3) {
                    parsableByteArray2.setPosition(0);
                    parsableByteArray2.setLimit(3);
                    parsableByteArray2.skipBytes(1);
                    int unsignedByte3 = parsableByteArray2.readUnsignedByte();
                    int unsignedByte4 = parsableByteArray2.readUnsignedByte();
                    this.sectionSyntaxIndicator = (unsignedByte3 & 128) != 0;
                    int i4 = (((unsignedByte3 & 15) << 8) | unsignedByte4) + 3;
                    this.totalSectionLength = i4;
                    byte[] bArr = parsableByteArray2.data;
                    if (bArr.length < i4) {
                        parsableByteArray2.ensureCapacity(Math.min(ByteBufferPoolKt.DEFAULT_BUFFER_SIZE, Math.max(i4, bArr.length * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(parsableByteArray.bytesLeft(), this.totalSectionLength - this.bytesRead);
                parsableByteArray.readBytes(parsableByteArray2.data, this.bytesRead, iMin2);
                int i5 = this.bytesRead + iMin2;
                this.bytesRead = i5;
                int i6 = this.totalSectionLength;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.sectionSyntaxIndicator) {
                        parsableByteArray2.setLimit(i6);
                    } else {
                        if (Util.crc32(0, i6, -1, parsableByteArray2.data) != 0) {
                            this.waitingForPayloadStart = true;
                            return;
                        }
                        parsableByteArray2.setLimit(this.totalSectionLength - 4);
                    }
                    parsableByteArray2.setPosition(0);
                    this.reader.consume(parsableByteArray2);
                    this.bytesRead = 0;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.reader.init(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.waitingForPayloadStart = true;
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void seek() {
        this.waitingForPayloadStart = true;
    }
}
