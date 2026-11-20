package com.github.ajalt.colormath.model;

import com.github.ajalt.colormath.WhitePointColorSpace;
import com.google.common.math.IntMath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface RGBColorSpace extends WhitePointColorSpace {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class GammaTransferFunctions implements TransferFunctions {
        public final double gamma;

        public GammaTransferFunctions(double d) {
            this.gamma = d;
        }

        @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
        public final float eotf(float f) {
            return (float) IntMath.spow(f, this.gamma);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GammaTransferFunctions) && Double.compare(this.gamma, ((GammaTransferFunctions) obj).gamma) == 0;
        }

        public final int hashCode() {
            return Double.hashCode(this.gamma);
        }

        @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
        public final float oetf(float f) {
            return (float) IntMath.spow(f, 1.0d / this.gamma);
        }

        public final String toString() {
            return "GammaTransferFunctions(gamma=" + this.gamma + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface TransferFunctions {
        float eotf(float f);

        float oetf(float f);
    }

    float[] getMatrixFromXyz();

    float[] getMatrixToXyz();

    TransferFunctions getTransferFunctions();

    RGB invoke(float f, float f2, float f3, float f4);
}
