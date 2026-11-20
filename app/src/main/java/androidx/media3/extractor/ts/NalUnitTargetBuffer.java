package androidx.media3.extractor.ts;

import coil3.util.UtilsKt;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NalUnitTargetBuffer {
    public boolean isCompleted;
    public boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    public final short targetType;

    /* JADX WARN: Multi-variable type inference failed */
    public NalUnitTargetBuffer(int i) {
        this.targetType = i;
        byte[] bArr = new byte[131];
        this.nalData = bArr;
        bArr[2] = 1;
    }

    public final void appendToNalUnit(byte[] bArr, int i, int i2) {
        if (this.isFilling) {
            int i3 = i2 - i;
            byte[] bArrCopyOf = this.nalData;
            int length = bArrCopyOf.length;
            int i4 = this.nalLength + i3;
            if (length < i4) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i4 * 2);
                this.nalData = bArrCopyOf;
            }
            System.arraycopy(bArr, i, bArrCopyOf, this.nalLength, i3);
            this.nalLength += i3;
        }
    }

    public final boolean endNalUnit(int i) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= i;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }

    public final void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public final void startNalUnit(int i) {
        UtilsKt.checkState(!this.isFilling);
        boolean z = i == this.targetType;
        this.isFilling = z;
        if (z) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }
}
