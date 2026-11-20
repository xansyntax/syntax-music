package androidx.media3.extractor.mkv;

import androidx.media3.extractor.ExtractorInput;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VarintReader {
    public static final long[] VARINT_LENGTH_MASKS = {128, 64, 32, 16, 8, 4, 2, 1};
    public int length;
    public final byte[] scratch = new byte[8];
    public boolean state;

    public static long assembleVarint(int i, boolean z, byte[] bArr) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~VARINT_LENGTH_MASKS[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    public final long readUnsignedVarint(ExtractorInput extractorInput, boolean z, boolean z2, int i) {
        int i2;
        boolean z3 = this.state;
        byte[] bArr = this.scratch;
        if (!z3) {
            if (!extractorInput.readFully(bArr, 0, 1, z)) {
                return -1L;
            }
            int i3 = bArr[0] & 255;
            int i4 = 0;
            while (true) {
                if (i4 >= 8) {
                    i2 = -1;
                    break;
                }
                if ((VARINT_LENGTH_MASKS[i4] & ((long) i3)) != 0) {
                    i2 = i4 + 1;
                    break;
                }
                i4++;
            }
            this.length = i2;
            if (i2 == -1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No valid varint length mask found");
                return 0L;
            }
            this.state = true;
        }
        int i5 = this.length;
        if (i5 > i) {
            this.state = false;
            return -2L;
        }
        if (i5 != 1) {
            extractorInput.readFully(bArr, 1, i5 - 1);
        }
        this.state = false;
        return assembleVarint(this.length, z2, bArr);
    }
}
