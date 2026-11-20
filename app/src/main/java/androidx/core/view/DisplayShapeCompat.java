package androidx.core.view;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DisplayShapeCompat {
    public final ImplBase mImpl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ImplBase {
        public final int mDisplayHeight;
        public final String mDisplayShapeSpec;
        public final int mDisplayWidth;

        public ImplBase(String str, int i, int i2) {
            this.mDisplayShapeSpec = str;
            this.mDisplayWidth = i;
            this.mDisplayHeight = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImplBase)) {
                return false;
            }
            ImplBase implBase = (ImplBase) obj;
            return this.mDisplayShapeSpec.equals(implBase.mDisplayShapeSpec) && this.mDisplayWidth == implBase.mDisplayWidth && this.mDisplayHeight == implBase.mDisplayHeight;
        }

        public final int hashCode() {
            Integer numValueOf = Integer.valueOf(this.mDisplayWidth);
            Integer numValueOf2 = Integer.valueOf(this.mDisplayHeight);
            Float fValueOf = Float.valueOf(1.0f);
            return Objects.hash(this.mDisplayShapeSpec, numValueOf, numValueOf2, fValueOf, 0, 0, 0, fValueOf);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("DisplayShapeCompat{ spec=");
            sb.append(Integer.valueOf(this.mDisplayShapeSpec.hashCode()));
            sb.append(" displayWidth=");
            sb.append(this.mDisplayWidth);
            sb.append(" displayHeight=");
            return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.mDisplayHeight, " physicalPixelDisplaySizeRatio=1.0 rotation=0 offsetX=0 offsetY=0 scale=1.0}");
        }
    }

    static {
        new DisplayShapeCompat("", 0, 0);
    }

    public DisplayShapeCompat(String str, int i, int i2) {
        this.mImpl = new ImplBase(str, i, i2);
    }

    public static DisplayShapeCompat create(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        String string;
        if (z) {
            int i7 = i / 2;
            int i8 = i2 / 2;
            StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i8, "M0,", " A", i7, ",");
            sbM3m.append(i8);
            sbM3m.append(" 0 1,1 ");
            sbM3m.append(i);
            sbM3m.append(",");
            sbM3m.append(i8);
            sbM3m.append(" A");
            sbM3m.append(i7);
            sbM3m.append(",");
            sbM3m.append(i8);
            sbM3m.append(" 0 1,1 0,");
            sbM3m.append(i8);
            sbM3m.append(" Z");
            string = sbM3m.toString();
        } else {
            StringBuilder sb = new StringBuilder("M ");
            int iMin = Math.min(i / 2, i2 / 2);
            int iMin2 = Math.min(iMin, i3);
            int iMin3 = Math.min(iMin, i4);
            int iMin4 = Math.min(iMin, i5);
            int iMin5 = Math.min(iMin, i6);
            sb.append(iMin2);
            sb.append(",0 L ");
            sb.append(i - iMin3);
            sb.append(",0");
            if (iMin3 > 0) {
                sb.append(" A ");
                sb.append(iMin3);
                sb.append(",");
                sb.append(iMin3);
                sb.append(" 0 0,1 ");
                sb.append(i);
                sb.append(",");
                sb.append(iMin3);
            }
            sb.append(" L ");
            sb.append(i);
            sb.append(",");
            sb.append(i2 - iMin4);
            if (iMin4 > 0) {
                sb.append(" A ");
                sb.append(iMin4);
                sb.append(",");
                sb.append(iMin4);
                sb.append(" 0 0,1 ");
                sb.append(i - iMin4);
                sb.append(",");
                sb.append(i2);
            }
            sb.append(" L ");
            sb.append(iMin5);
            sb.append(",");
            sb.append(i2);
            if (iMin5 > 0) {
                sb.append(" A ");
                sb.append(iMin5);
                sb.append(",");
                sb.append(iMin5);
                sb.append(" 0 0,1 0,");
                sb.append(i2 - iMin5);
            }
            if (iMin2 > 0) {
                sb.append(" L 0,");
                sb.append(iMin2);
                sb.append(" A ");
                sb.append(iMin2);
                sb.append(",");
                sb.append(iMin2);
                sb.append(" 0 0,1 ");
                sb.append(iMin2);
                sb.append(",0");
            }
            sb.append(" Z");
            string = sb.toString();
        }
        return new DisplayShapeCompat(string, i, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DisplayShapeCompat) {
            return this.mImpl.equals(((DisplayShapeCompat) obj).mImpl);
        }
        return false;
    }

    public final int hashCode() {
        return this.mImpl.hashCode();
    }

    public final String toString() {
        return this.mImpl.toString();
    }
}
