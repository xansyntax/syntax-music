package androidx.media3.extractor;

import androidx.media3.container.ObuParser$NotYetImplementedException;
import androidx.media3.container.ObuParser$Obu;
import androidx.media3.container.ObuParser$SequenceHeader;
import coil3.size.Size;
import coil3.util.HardwareBitmapService;
import coil3.util.UtilsKt;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VorbisUtil$Mode implements HardwareBitmapService {
    public final boolean blockFlag;

    public VorbisUtil$Mode(ObuParser$SequenceHeader obuParser$SequenceHeader, ObuParser$Obu obuParser$Obu) throws ObuParser$NotYetImplementedException {
        int i = obuParser$Obu.type;
        ByteBuffer byteBuffer = obuParser$Obu.payload;
        UtilsKt.checkArgument(i == 6 || i == 3);
        int iMin = Math.min(4, byteBuffer.remaining());
        byte[] bArr = new byte[iMin];
        byteBuffer.asReadOnlyBuffer().get(bArr);
        VorbisBitArray vorbisBitArray = new VorbisBitArray(bArr, iMin);
        if (obuParser$SequenceHeader.reducedStillPictureHeader) {
            throw new ObuParser$NotYetImplementedException();
        }
        if (vorbisBitArray.readBit()) {
            this.blockFlag = false;
            return;
        }
        int bits = vorbisBitArray.readBits(2);
        boolean bit = vorbisBitArray.readBit();
        if (obuParser$SequenceHeader.decoderModelInfoPresentFlag) {
            throw new ObuParser$NotYetImplementedException();
        }
        if (!bit) {
            this.blockFlag = true;
            return;
        }
        boolean bit2 = (bits == 3 || bits == 0) ? true : vorbisBitArray.readBit();
        vorbisBitArray.skipBit();
        if (!obuParser$SequenceHeader.seqForceScreenContentTools) {
            throw new ObuParser$NotYetImplementedException();
        }
        if (vorbisBitArray.readBit()) {
            if (!obuParser$SequenceHeader.seqForceIntegerMv) {
                throw new ObuParser$NotYetImplementedException();
            }
            vorbisBitArray.skipBit();
        }
        if (obuParser$SequenceHeader.frameIdNumbersPresentFlag) {
            throw new ObuParser$NotYetImplementedException();
        }
        if (bits != 3) {
            vorbisBitArray.skipBit();
        }
        vorbisBitArray.skipBits(obuParser$SequenceHeader.orderHintBits);
        if (bits != 2 && bits != 0 && !bit2) {
            vorbisBitArray.skipBits(3);
        }
        this.blockFlag = ((bits == 3 || bits == 0) ? 255 : vorbisBitArray.readBits(8)) != 0;
    }

    @Override // coil3.util.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        return this.blockFlag;
    }

    @Override // coil3.util.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        return this.blockFlag;
    }

    public /* synthetic */ VorbisUtil$Mode(boolean z) {
        this.blockFlag = z;
    }
}
