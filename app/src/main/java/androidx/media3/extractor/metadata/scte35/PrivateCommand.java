package androidx.media3.extractor.metadata.scte35;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCommand extends SpliceCommand {
    public final /* synthetic */ byte $r8$classId;
    public final long identifier;
    public final long ptsAdjustment;

    public PrivateCommand(byte b, long j, long j2) {
        this.$r8$classId = b;
        switch (b) {
            case 2:
                this.ptsAdjustment = j;
                this.identifier = j2;
                break;
            default:
                this.ptsAdjustment = j2;
                this.identifier = j;
                break;
        }
    }

    public static long parseSpliceTime(long j, ParsableByteArray parsableByteArray) {
        long unsignedByte = parsableByteArray.readUnsignedByte();
        if ((128 & unsignedByte) != 0) {
            return 8589934591L & ((((unsignedByte & 1) << 32) | parsableByteArray.readUnsignedInt()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb = new StringBuilder("SCTE-35 PrivateCommand { ptsAdjustment=");
                sb.append(this.ptsAdjustment);
                sb.append(", identifier= ");
                return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.identifier, " }");
            case 1:
                StringBuilder sb2 = new StringBuilder("SCTE-35 SpliceInsertCommand { programSplicePts=");
                sb2.append(this.ptsAdjustment);
                sb2.append(", programSplicePlaybackPositionUs= ");
                return IntIntPair$$ExternalSyntheticOutline0.m(sb2, this.identifier, " }");
            default:
                StringBuilder sb3 = new StringBuilder("SCTE-35 TimeSignalCommand { ptsTime=");
                sb3.append(this.ptsAdjustment);
                sb3.append(", playbackPositionUs= ");
                return IntIntPair$$ExternalSyntheticOutline0.m(sb3, this.identifier, " }");
        }
    }

    public PrivateCommand(long j, long j2, List list) {
        this.$r8$classId = (byte) 1;
        this.ptsAdjustment = j;
        this.identifier = j2;
        Collections.unmodifiableList(list);
    }
}
