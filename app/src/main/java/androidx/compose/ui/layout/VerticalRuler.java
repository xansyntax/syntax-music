package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VerticalRuler {
    public final /* synthetic */ byte $r8$classId;
    public final Function2 calculate;

    public VerticalRuler(Function2 function2, byte b) {
        this.$r8$classId = b;
        this.calculate = function2;
    }

    public final float calculateCoordinate$ui(float f, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        switch (this.$r8$classId) {
            case 0:
                return Float.intBitsToFloat((int) (layoutCoordinates2.mo604localPositionOfR5De75A(layoutCoordinates, (((long) Float.floatToRawIntBits(((int) (layoutCoordinates.mo603getSizeYbymL2g() & 4294967295L)) / 2.0f)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)) >> 32));
            default:
                return Float.intBitsToFloat((int) (layoutCoordinates2.mo604localPositionOfR5De75A(layoutCoordinates, (((long) Float.floatToRawIntBits(f)) & 4294967295L) | (Float.floatToRawIntBits(((int) (layoutCoordinates.mo603getSizeYbymL2g() >> 32)) / 2.0f) << 32)) & 4294967295L));
        }
    }
}
