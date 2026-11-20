package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PsDurationReader {
    public final /* synthetic */ byte $r8$classId;
    public long durationUs;
    public long firstScrValue;
    public boolean isDurationRead;
    public boolean isFirstScrValueRead;
    public boolean isLastScrValueRead;
    public long lastScrValue;
    public final ParsableByteArray packetBuffer;
    public final TimestampAdjuster scrTimestampAdjuster;

    public PsDurationReader(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.scrTimestampAdjuster = new TimestampAdjuster(0L);
                this.firstScrValue = -9223372036854775807L;
                this.lastScrValue = -9223372036854775807L;
                this.durationUs = -9223372036854775807L;
                this.packetBuffer = new ParsableByteArray();
                break;
            default:
                this.scrTimestampAdjuster = new TimestampAdjuster(0L);
                this.firstScrValue = -9223372036854775807L;
                this.lastScrValue = -9223372036854775807L;
                this.durationUs = -9223372036854775807L;
                this.packetBuffer = new ParsableByteArray();
                break;
        }
    }

    public static int peekIntAtPosition(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static long readScrValueFromPack(ParsableByteArray parsableByteArray) {
        int i = parsableByteArray.position;
        if (parsableByteArray.bytesLeft() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        parsableByteArray.readBytes(bArr, 0, 9);
        parsableByteArray.setPosition(i);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = b;
        long j2 = b2;
        return ((j2 & 3) << 13) | ((((long) bArr[1]) & 255) << 20) | ((j & 3) << 28) | (((56 & j) >> 3) << 30) | (((j2 & 248) >> 3) << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
    }

    public final void finishReadDuration(ExtractorInput extractorInput) {
        byte b = this.$r8$classId;
        ParsableByteArray parsableByteArray = this.packetBuffer;
        switch (b) {
            case 0:
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                parsableByteArray.reset(bArr, bArr.length);
                this.isDurationRead = true;
                extractorInput.resetPeekPosition();
                break;
            default:
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                parsableByteArray.reset(bArr2, bArr2.length);
                this.isDurationRead = true;
                extractorInput.resetPeekPosition();
                break;
        }
    }
}
