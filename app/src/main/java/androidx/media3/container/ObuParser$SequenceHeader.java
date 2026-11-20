package androidx.media3.container;

import androidx.media3.extractor.VorbisBitArray;
import coil3.util.UtilsKt;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ObuParser$SequenceHeader {
    public final boolean decoderModelInfoPresentFlag;
    public final boolean frameIdNumbersPresentFlag;
    public final boolean initialDisplayDelayPresentFlag;
    public final int orderHintBits;
    public final boolean reducedStillPictureHeader;
    public final boolean seqForceIntegerMv;
    public final boolean seqForceScreenContentTools;
    public final int seqProfile;

    public ObuParser$SequenceHeader(ObuParser$Obu obuParser$Obu) {
        boolean bit;
        boolean bit2;
        byte bits;
        byte bits2;
        byte bits3;
        int i = obuParser$Obu.type;
        ByteBuffer byteBuffer = obuParser$Obu.payload;
        boolean z = false;
        boolean bit3 = true;
        UtilsKt.checkArgument(i == 1);
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.asReadOnlyBuffer().get(bArr);
        VorbisBitArray vorbisBitArray = new VorbisBitArray(bArr, iRemaining);
        this.seqProfile = vorbisBitArray.readBits(3);
        vorbisBitArray.skipBit();
        boolean bit4 = vorbisBitArray.readBit();
        this.reducedStillPictureHeader = bit4;
        if (bit4) {
            vorbisBitArray.readBits(5);
            this.decoderModelInfoPresentFlag = false;
            this.initialDisplayDelayPresentFlag = false;
        } else {
            if (vorbisBitArray.readBit()) {
                vorbisBitArray.skipBits(64);
                if (vorbisBitArray.readBit()) {
                    int i2 = 0;
                    while (!vorbisBitArray.readBit()) {
                        i2++;
                    }
                    if (i2 < 32) {
                        vorbisBitArray.skipBits(i2);
                    }
                }
                boolean bit5 = vorbisBitArray.readBit();
                this.decoderModelInfoPresentFlag = bit5;
                if (bit5) {
                    vorbisBitArray.skipBits(47);
                }
            } else {
                this.decoderModelInfoPresentFlag = false;
            }
            this.initialDisplayDelayPresentFlag = vorbisBitArray.readBit();
            int bits4 = vorbisBitArray.readBits(5);
            for (int i3 = 0; i3 <= bits4; i3++) {
                vorbisBitArray.skipBits(12);
                if (i3 == 0) {
                    if (vorbisBitArray.readBits(5) > 7) {
                        vorbisBitArray.readBit();
                    }
                } else if (vorbisBitArray.readBits(5) > 7) {
                    vorbisBitArray.skipBit();
                }
                if (this.decoderModelInfoPresentFlag) {
                    vorbisBitArray.skipBit();
                }
                if (this.initialDisplayDelayPresentFlag && vorbisBitArray.readBit()) {
                    if (i3 == 0) {
                        vorbisBitArray.readBits(4);
                    } else {
                        vorbisBitArray.skipBits(4);
                    }
                }
            }
        }
        int bits5 = vorbisBitArray.readBits(4);
        int bits6 = vorbisBitArray.readBits(4);
        vorbisBitArray.skipBits(bits5 + 1);
        vorbisBitArray.skipBits(bits6 + 1);
        if (this.reducedStillPictureHeader) {
            this.frameIdNumbersPresentFlag = false;
            bit = false;
        } else {
            bit = vorbisBitArray.readBit();
            this.frameIdNumbersPresentFlag = bit;
        }
        if (bit) {
            vorbisBitArray.skipBits(4);
            vorbisBitArray.skipBits(3);
        }
        vorbisBitArray.skipBits(3);
        if (this.reducedStillPictureHeader) {
            this.seqForceIntegerMv = true;
            this.seqForceScreenContentTools = true;
            this.orderHintBits = 0;
        } else {
            vorbisBitArray.skipBits(4);
            boolean bit6 = vorbisBitArray.readBit();
            if (bit6) {
                vorbisBitArray.skipBits(2);
            }
            if (vorbisBitArray.readBit()) {
                this.seqForceScreenContentTools = true;
                bit2 = true;
            } else {
                bit2 = vorbisBitArray.readBit();
                this.seqForceScreenContentTools = bit2;
            }
            if (!bit2 || vorbisBitArray.readBit()) {
                this.seqForceIntegerMv = true;
            } else {
                this.seqForceIntegerMv = vorbisBitArray.readBit();
            }
            if (bit6) {
                this.orderHintBits = vorbisBitArray.readBits(3) + 1;
            } else {
                this.orderHintBits = 0;
            }
        }
        vorbisBitArray.skipBits(3);
        boolean bit7 = (this.seqProfile == 2 && vorbisBitArray.readBit()) ? vorbisBitArray.readBit() : false;
        boolean bit8 = this.seqProfile != 1 ? vorbisBitArray.readBit() : false;
        if (vorbisBitArray.readBit()) {
            bits2 = (byte) vorbisBitArray.readBits(8);
            bits3 = (byte) vorbisBitArray.readBits(8);
            bits = (byte) vorbisBitArray.readBits(8);
        } else {
            bits = 0;
            bits2 = 0;
            bits3 = 0;
        }
        if (bit8) {
            vorbisBitArray.skipBit();
        } else if (bits2 != 1 || bits3 != 13 || bits != 0) {
            vorbisBitArray.skipBit();
            int i4 = this.seqProfile;
            if (i4 == 0) {
                z = true;
            } else if (i4 == 1) {
                bit3 = false;
            } else if (bit7) {
                boolean bit9 = vorbisBitArray.readBit();
                bit3 = bit9 ? vorbisBitArray.readBit() : false;
                z = bit9;
            } else {
                bit3 = false;
                z = true;
            }
            if (z && bit3) {
                vorbisBitArray.readBits(2);
            }
        }
        vorbisBitArray.skipBit();
    }
}
