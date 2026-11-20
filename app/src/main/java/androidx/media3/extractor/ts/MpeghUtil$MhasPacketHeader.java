package androidx.media3.extractor.ts;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SniffFailure;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MpeghUtil$MhasPacketHeader implements SniffFailure {
    public final /* synthetic */ byte $r8$classId = 0;
    public long packetLabel;
    public int packetLength;
    public int packetType;

    public MpeghUtil$MhasPacketHeader(int i, int i2, long j) {
        this.packetType = i;
        this.packetLabel = j;
        this.packetLength = i2;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                StringBuilder sb = new StringBuilder("AtomSizeTooSmall{type=");
                sb.append(Util.toFourccString(this.packetType));
                sb.append(", size=");
                sb.append(this.packetLabel);
                sb.append(", minHeaderSize=");
                return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.packetLength, "}");
            default:
                return super.toString();
        }
    }

    public /* synthetic */ MpeghUtil$MhasPacketHeader() {
    }
}
