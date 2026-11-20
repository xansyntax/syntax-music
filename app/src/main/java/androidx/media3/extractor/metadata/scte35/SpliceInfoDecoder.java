package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.text.CueDecoder;
import androidx.sqlite.SQLite;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SpliceInfoDecoder extends SQLite {
    public final ParsableByteArray sectionData = new ParsableByteArray();
    public final VorbisBitArray sectionHeader = new VorbisBitArray();
    public TimestampAdjuster timestampAdjuster;

    /* JADX WARN: Code duplicated, block: B:14:0x001a  */
    @Override // androidx.sqlite.SQLite
    public final Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        Metadata.Entry spliceNullCommand;
        long j;
        long j2;
        ParsableByteArray parsableByteArray = this.sectionData;
        VorbisBitArray vorbisBitArray = this.sectionHeader;
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null) {
            long j3 = metadataInputBuffer.subsampleOffsetUs;
            synchronized (timestampAdjuster) {
                j2 = timestampAdjuster.timestampOffsetUs;
            }
            if (j3 != j2) {
                TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.timeUs);
                this.timestampAdjuster = timestampAdjuster2;
                timestampAdjuster2.adjustSampleTimestamp(metadataInputBuffer.timeUs - metadataInputBuffer.subsampleOffsetUs);
            }
        } else {
            TimestampAdjuster timestampAdjuster3 = new TimestampAdjuster(metadataInputBuffer.timeUs);
            this.timestampAdjuster = timestampAdjuster3;
            timestampAdjuster3.adjustSampleTimestamp(metadataInputBuffer.timeUs - metadataInputBuffer.subsampleOffsetUs);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        parsableByteArray.reset(bArrArray, iLimit);
        vorbisBitArray.reset(bArrArray, iLimit);
        vorbisBitArray.skipBits(39);
        long bits = (((long) vorbisBitArray.readBits(1)) << 32) | ((long) vorbisBitArray.readBits(32));
        vorbisBitArray.skipBits(20);
        int bits2 = vorbisBitArray.readBits(12);
        int bits3 = vorbisBitArray.readBits(8);
        parsableByteArray.skipBytes(14);
        if (bits3 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (bits3 == 255) {
            long unsignedInt = parsableByteArray.readUnsignedInt();
            int i = bits2 - 4;
            parsableByteArray.readBytes(new byte[i], 0, i);
            spliceNullCommand = new PrivateCommand((byte) 0, unsignedInt, bits);
        } else if (bits3 == 4) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            ArrayList arrayList = new ArrayList(unsignedByte);
            for (int i2 = 0; i2 < unsignedByte; i2++) {
                parsableByteArray.readUnsignedInt();
                boolean z = (parsableByteArray.readUnsignedByte() & 128) != 0;
                ArrayList arrayList2 = new ArrayList();
                if (!z) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    boolean z2 = (unsignedByte2 & 64) != 0;
                    boolean z3 = (unsignedByte2 & 32) != 0;
                    if (z2) {
                        parsableByteArray.readUnsignedInt();
                    }
                    if (!z2) {
                        int unsignedByte3 = parsableByteArray.readUnsignedByte();
                        ArrayList arrayList3 = new ArrayList(unsignedByte3);
                        for (int i3 = 0; i3 < unsignedByte3; i3++) {
                            parsableByteArray.readUnsignedByte();
                            parsableByteArray.readUnsignedInt();
                            arrayList3.add(new CueDecoder((byte) 11));
                        }
                        arrayList2 = arrayList3;
                    }
                    if (z3) {
                        parsableByteArray.readUnsignedByte();
                        parsableByteArray.readUnsignedInt();
                    }
                    parsableByteArray.readUnsignedShort();
                    parsableByteArray.readUnsignedByte();
                    parsableByteArray.readUnsignedByte();
                }
                CueDecoder cueDecoder = new CueDecoder((byte) 12);
                Collections.unmodifiableList(arrayList2);
                arrayList.add(cueDecoder);
            }
            spliceNullCommand = new SpliceNullCommand();
            Collections.unmodifiableList(arrayList);
        } else if (bits3 == 5) {
            TimestampAdjuster timestampAdjuster4 = this.timestampAdjuster;
            parsableByteArray.readUnsignedInt();
            boolean z4 = (parsableByteArray.readUnsignedByte() & 128) != 0;
            List list = Collections.EMPTY_LIST;
            if (z4) {
                j = -9223372036854775807L;
            } else {
                int unsignedByte4 = parsableByteArray.readUnsignedByte();
                boolean z5 = (unsignedByte4 & 64) != 0;
                boolean z6 = (unsignedByte4 & 32) != 0;
                boolean z7 = (unsignedByte4 & 16) != 0;
                long spliceTime = (!z5 || z7) ? -9223372036854775807L : PrivateCommand.parseSpliceTime(bits, parsableByteArray);
                if (!z5) {
                    int unsignedByte5 = parsableByteArray.readUnsignedByte();
                    ArrayList arrayList4 = new ArrayList(unsignedByte5);
                    for (int i4 = 0; i4 < unsignedByte5; i4++) {
                        parsableByteArray.readUnsignedByte();
                        timestampAdjuster4.adjustTsTimestamp(!z7 ? PrivateCommand.parseSpliceTime(bits, parsableByteArray) : -9223372036854775807L);
                        arrayList4.add(new CueDecoder((byte) 10));
                    }
                    list = arrayList4;
                }
                if (z6) {
                    parsableByteArray.readUnsignedByte();
                    parsableByteArray.readUnsignedInt();
                }
                parsableByteArray.readUnsignedShort();
                parsableByteArray.readUnsignedByte();
                parsableByteArray.readUnsignedByte();
                j = spliceTime;
            }
            spliceNullCommand = new PrivateCommand(j, timestampAdjuster4.adjustTsTimestamp(j), list);
        } else if (bits3 != 6) {
            spliceNullCommand = null;
        } else {
            TimestampAdjuster timestampAdjuster5 = this.timestampAdjuster;
            long spliceTime2 = PrivateCommand.parseSpliceTime(bits, parsableByteArray);
            spliceNullCommand = new PrivateCommand((byte) 2, spliceTime2, timestampAdjuster5.adjustTsTimestamp(spliceTime2));
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
