package androidx.compose.ui.graphics.colorspace;

import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda1 implements DoubleFunction {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Rgb f$0;

    public /* synthetic */ Rgb$$ExternalSyntheticLambda1(Rgb rgb, byte b) {
        this.$r8$classId = b;
        this.f$0 = rgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        byte b = this.$r8$classId;
        Rgb rgb = this.f$0;
        switch (b) {
            case 0:
                return UuidKt.coerceIn(rgb.oetfOrig.invoke(d), rgb.min, rgb.max);
            default:
                return rgb.eotfOrig.invoke(UuidKt.coerceIn(d, rgb.min, rgb.max));
        }
    }
}
