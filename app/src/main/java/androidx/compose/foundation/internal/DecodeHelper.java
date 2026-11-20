package androidx.compose.foundation.internal;

import android.os.Parcel;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import com.google.common.math.IntMath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DecodeHelper {
    public Parcel parcel;

    /* JADX INFO: renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public long m109decodeColor0d7_KjU() {
        long j = this.parcel.readLong();
        long j2 = 63 & j;
        return j2 < 16 ? j : (j & (-64)) | (j2 + 1);
    }

    /* JADX INFO: renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public long m110decodeTextUnitXSAIIZE() {
        long j;
        Parcel parcel = this.parcel;
        byte b = parcel.readByte();
        if (b == 1) {
            j = 4294967296L;
        } else {
            j = b == 2 ? 8589934592L : 0L;
        }
        return TextUnitType.m816equalsimpl0(j, 0L) ? IntMath.pack(0L, Float.NaN) : IntMath.pack(j, parcel.readFloat());
    }

    public void encode(byte b) {
        this.parcel.writeByte(b);
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public void m111encodeR2X_6o(long j) {
        long jM813getTypeUIouoOA = TextUnit.m813getTypeUIouoOA(j);
        byte b = 0;
        if (!TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 0L)) {
            if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 4294967296L)) {
                b = 1;
            } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 8589934592L)) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j), 0L)) {
            return;
        }
        encode(TextUnit.m814getValueimpl(j));
    }

    public void encode(float f) {
        this.parcel.writeFloat(f);
    }
}
