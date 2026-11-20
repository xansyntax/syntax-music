package androidx.media3.extractor.ogg;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import coil3.util.UtilsKt;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OggPacket {
    public boolean populated;
    public int segmentCount;
    public final OggPageHeader pageHeader = new OggPageHeader();
    public final ParsableByteArray packetArray = new ParsableByteArray(new byte[65025], 0);
    public int currentSegmentIndex = -1;

    public final int calculatePacketSize(int i) {
        int i2;
        int i3 = 0;
        this.segmentCount = 0;
        do {
            int i4 = this.segmentCount;
            int i5 = i + i4;
            OggPageHeader oggPageHeader = this.pageHeader;
            if (i5 >= oggPageHeader.pageSegmentCount) {
                break;
            }
            int[] iArr = oggPageHeader.laces;
            this.segmentCount = i4 + 1;
            i2 = iArr[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final boolean populate(ExtractorInput extractorInput) {
        int i;
        UtilsKt.checkState(extractorInput != null);
        boolean z = this.populated;
        ParsableByteArray parsableByteArray = this.packetArray;
        if (z) {
            this.populated = false;
            parsableByteArray.reset(0);
        }
        while (!this.populated) {
            int i2 = this.currentSegmentIndex;
            OggPageHeader oggPageHeader = this.pageHeader;
            if (i2 < 0) {
                if (oggPageHeader.skipToNextPage(extractorInput, -1L) && oggPageHeader.populate(extractorInput, true)) {
                    int iCalculatePacketSize = oggPageHeader.headerSize;
                    if ((oggPageHeader.type & 1) == 1 && parsableByteArray.limit == 0) {
                        iCalculatePacketSize += calculatePacketSize(0);
                        i = this.segmentCount;
                    } else {
                        i = 0;
                    }
                    try {
                        extractorInput.skipFully(iCalculatePacketSize);
                        this.currentSegmentIndex = i;
                        i2 = i;
                    } catch (EOFException unused) {
                    }
                }
                return false;
            }
            int iCalculatePacketSize2 = calculatePacketSize(i2);
            int i3 = this.currentSegmentIndex + this.segmentCount;
            if (iCalculatePacketSize2 > 0) {
                parsableByteArray.ensureCapacity(parsableByteArray.limit + iCalculatePacketSize2);
                try {
                    extractorInput.readFully(parsableByteArray.data, parsableByteArray.limit, iCalculatePacketSize2);
                    parsableByteArray.setLimit(parsableByteArray.limit + iCalculatePacketSize2);
                    this.populated = oggPageHeader.laces[i3 + (-1)] != 255;
                } catch (EOFException unused2) {
                    return false;
                }
            }
            if (i3 == oggPageHeader.pageSegmentCount) {
                i3 = -1;
            }
            this.currentSegmentIndex = i3;
        }
        return true;
    }
}
