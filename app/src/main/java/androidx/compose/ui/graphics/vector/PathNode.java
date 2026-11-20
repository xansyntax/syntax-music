package androidx.compose.ui.graphics.vector;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PathNode {
    public final boolean isCurve;
    public final boolean isQuad;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ArcTo extends PathNode {
        public final float arcStartX;
        public final float arcStartY;
        public final float horizontalEllipseRadius;
        public final boolean isMoreThanHalf;
        public final boolean isPositiveArc;
        public final float theta;
        public final float verticalEllipseRadius;

        public ArcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            super(3);
            this.horizontalEllipseRadius = f;
            this.verticalEllipseRadius = f2;
            this.theta = f3;
            this.isMoreThanHalf = z;
            this.isPositiveArc = z2;
            this.arcStartX = f4;
            this.arcStartY = f5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArcTo)) {
                return false;
            }
            ArcTo arcTo = (ArcTo) obj;
            return Float.compare(this.horizontalEllipseRadius, arcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, arcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, arcTo.theta) == 0 && this.isMoreThanHalf == arcTo.isMoreThanHalf && this.isPositiveArc == arcTo.isPositiveArc && Float.compare(this.arcStartX, arcTo.arcStartX) == 0 && Float.compare(this.arcStartY, arcTo.arcStartY) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.arcStartY) + IntIntPair$$ExternalSyntheticOutline0.m(this.arcStartX, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.theta, IntIntPair$$ExternalSyntheticOutline0.m(this.verticalEllipseRadius, Float.hashCode(this.horizontalEllipseRadius) * 31, 31), 31), this.isMoreThanHalf, 31), this.isPositiveArc, 31), 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ArcTo(horizontalEllipseRadius=", this.horizontalEllipseRadius, ", verticalEllipseRadius=", this.verticalEllipseRadius, ", theta=");
            sbM.append(this.theta);
            sbM.append(", isMoreThanHalf=");
            sbM.append(this.isMoreThanHalf);
            sbM.append(", isPositiveArc=");
            sbM.append(this.isPositiveArc);
            sbM.append(", arcStartX=");
            sbM.append(this.arcStartX);
            sbM.append(", arcStartY=");
            sbM.append(this.arcStartY);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Close extends PathNode {
        public static final Close INSTANCE = new Close(3);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CurveTo extends PathNode {
        public final float x1;
        public final float x2;
        public final float x3;
        public final float y1;
        public final float y2;
        public final float y3;

        public CurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            super(2);
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
            this.x3 = f5;
            this.y3 = f6;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CurveTo)) {
                return false;
            }
            CurveTo curveTo = (CurveTo) obj;
            return Float.compare(this.x1, curveTo.x1) == 0 && Float.compare(this.y1, curveTo.y1) == 0 && Float.compare(this.x2, curveTo.x2) == 0 && Float.compare(this.y2, curveTo.y2) == 0 && Float.compare(this.x3, curveTo.x3) == 0 && Float.compare(this.y3, curveTo.y3) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.y3) + IntIntPair$$ExternalSyntheticOutline0.m(this.x3, IntIntPair$$ExternalSyntheticOutline0.m(this.y2, IntIntPair$$ExternalSyntheticOutline0.m(this.x2, IntIntPair$$ExternalSyntheticOutline0.m(this.y1, Float.hashCode(this.x1) * 31, 31), 31), 31), 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("CurveTo(x1=", this.x1, ", y1=", this.y1, ", x2=");
            sbM.append(this.x2);
            sbM.append(", y2=");
            sbM.append(this.y2);
            sbM.append(", x3=");
            sbM.append(this.x3);
            sbM.append(", y3=");
            sbM.append(this.y3);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class HorizontalTo extends PathNode {
        public final float x;

        public HorizontalTo(float f) {
            super(3);
            this.x = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HorizontalTo) && Float.compare(this.x, ((HorizontalTo) obj).x) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.x);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("HorizontalTo(x=", this.x, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LineTo extends PathNode {
        public final float x;
        public final float y;

        public LineTo(float f, float f2) {
            super(3);
            this.x = f;
            this.y = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LineTo)) {
                return false;
            }
            LineTo lineTo = (LineTo) obj;
            return Float.compare(this.x, lineTo.x) == 0 && Float.compare(this.y, lineTo.y) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        public final String toString() {
            return "LineTo(x=" + this.x + ", y=" + this.y + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MoveTo extends PathNode {
        public final float x;
        public final float y;

        public MoveTo(float f, float f2) {
            super(3);
            this.x = f;
            this.y = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MoveTo)) {
                return false;
            }
            MoveTo moveTo = (MoveTo) obj;
            return Float.compare(this.x, moveTo.x) == 0 && Float.compare(this.y, moveTo.y) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        public final String toString() {
            return "MoveTo(x=" + this.x + ", y=" + this.y + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class QuadTo extends PathNode {
        public final float x1;
        public final float x2;
        public final float y1;
        public final float y2;

        public QuadTo(float f, float f2, float f3, float f4) {
            super(1);
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuadTo)) {
                return false;
            }
            QuadTo quadTo = (QuadTo) obj;
            return Float.compare(this.x1, quadTo.x1) == 0 && Float.compare(this.y1, quadTo.y1) == 0 && Float.compare(this.x2, quadTo.x2) == 0 && Float.compare(this.y2, quadTo.y2) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.y2) + IntIntPair$$ExternalSyntheticOutline0.m(this.x2, IntIntPair$$ExternalSyntheticOutline0.m(this.y1, Float.hashCode(this.x1) * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("QuadTo(x1=", this.x1, ", y1=", this.y1, ", x2=");
            sbM.append(this.x2);
            sbM.append(", y2=");
            sbM.append(this.y2);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ReflectiveCurveTo extends PathNode {
        public final float x1;
        public final float x2;
        public final float y1;
        public final float y2;

        public ReflectiveCurveTo(float f, float f2, float f3, float f4) {
            super(2);
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveCurveTo)) {
                return false;
            }
            ReflectiveCurveTo reflectiveCurveTo = (ReflectiveCurveTo) obj;
            return Float.compare(this.x1, reflectiveCurveTo.x1) == 0 && Float.compare(this.y1, reflectiveCurveTo.y1) == 0 && Float.compare(this.x2, reflectiveCurveTo.x2) == 0 && Float.compare(this.y2, reflectiveCurveTo.y2) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.y2) + IntIntPair$$ExternalSyntheticOutline0.m(this.x2, IntIntPair$$ExternalSyntheticOutline0.m(this.y1, Float.hashCode(this.x1) * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ReflectiveCurveTo(x1=", this.x1, ", y1=", this.y1, ", x2=");
            sbM.append(this.x2);
            sbM.append(", y2=");
            sbM.append(this.y2);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ReflectiveQuadTo extends PathNode {
        public final float x;
        public final float y;

        public ReflectiveQuadTo(float f, float f2) {
            super(1);
            this.x = f;
            this.y = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveQuadTo)) {
                return false;
            }
            ReflectiveQuadTo reflectiveQuadTo = (ReflectiveQuadTo) obj;
            return Float.compare(this.x, reflectiveQuadTo.x) == 0 && Float.compare(this.y, reflectiveQuadTo.y) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        public final String toString() {
            return "ReflectiveQuadTo(x=" + this.x + ", y=" + this.y + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeArcTo extends PathNode {
        public final float arcStartDx;
        public final float arcStartDy;
        public final float horizontalEllipseRadius;
        public final boolean isMoreThanHalf;
        public final boolean isPositiveArc;
        public final float theta;
        public final float verticalEllipseRadius;

        public RelativeArcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            super(3);
            this.horizontalEllipseRadius = f;
            this.verticalEllipseRadius = f2;
            this.theta = f3;
            this.isMoreThanHalf = z;
            this.isPositiveArc = z2;
            this.arcStartDx = f4;
            this.arcStartDy = f5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeArcTo)) {
                return false;
            }
            RelativeArcTo relativeArcTo = (RelativeArcTo) obj;
            return Float.compare(this.horizontalEllipseRadius, relativeArcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, relativeArcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, relativeArcTo.theta) == 0 && this.isMoreThanHalf == relativeArcTo.isMoreThanHalf && this.isPositiveArc == relativeArcTo.isPositiveArc && Float.compare(this.arcStartDx, relativeArcTo.arcStartDx) == 0 && Float.compare(this.arcStartDy, relativeArcTo.arcStartDy) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.arcStartDy) + IntIntPair$$ExternalSyntheticOutline0.m(this.arcStartDx, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.theta, IntIntPair$$ExternalSyntheticOutline0.m(this.verticalEllipseRadius, Float.hashCode(this.horizontalEllipseRadius) * 31, 31), 31), this.isMoreThanHalf, 31), this.isPositiveArc, 31), 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("RelativeArcTo(horizontalEllipseRadius=", this.horizontalEllipseRadius, ", verticalEllipseRadius=", this.verticalEllipseRadius, ", theta=");
            sbM.append(this.theta);
            sbM.append(", isMoreThanHalf=");
            sbM.append(this.isMoreThanHalf);
            sbM.append(", isPositiveArc=");
            sbM.append(this.isPositiveArc);
            sbM.append(", arcStartDx=");
            sbM.append(this.arcStartDx);
            sbM.append(", arcStartDy=");
            sbM.append(this.arcStartDy);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeCurveTo extends PathNode {
        public final float dx1;
        public final float dx2;
        public final float dx3;
        public final float dy1;
        public final float dy2;
        public final float dy3;

        public RelativeCurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            super(2);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
            this.dx3 = f5;
            this.dy3 = f6;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeCurveTo)) {
                return false;
            }
            RelativeCurveTo relativeCurveTo = (RelativeCurveTo) obj;
            return Float.compare(this.dx1, relativeCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeCurveTo.dy2) == 0 && Float.compare(this.dx3, relativeCurveTo.dx3) == 0 && Float.compare(this.dy3, relativeCurveTo.dy3) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy3) + IntIntPair$$ExternalSyntheticOutline0.m(this.dx3, IntIntPair$$ExternalSyntheticOutline0.m(this.dy2, IntIntPair$$ExternalSyntheticOutline0.m(this.dx2, IntIntPair$$ExternalSyntheticOutline0.m(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31), 31), 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("RelativeCurveTo(dx1=", this.dx1, ", dy1=", this.dy1, ", dx2=");
            sbM.append(this.dx2);
            sbM.append(", dy2=");
            sbM.append(this.dy2);
            sbM.append(", dx3=");
            sbM.append(this.dx3);
            sbM.append(", dy3=");
            sbM.append(this.dy3);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeHorizontalTo extends PathNode {
        public final float dx;

        public RelativeHorizontalTo(float f) {
            super(3);
            this.dx = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeHorizontalTo) && Float.compare(this.dx, ((RelativeHorizontalTo) obj).dx) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.dx);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("RelativeHorizontalTo(dx=", this.dx, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeLineTo extends PathNode {
        public final float dx;
        public final float dy;

        public RelativeLineTo(float f, float f2) {
            super(3);
            this.dx = f;
            this.dy = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeLineTo)) {
                return false;
            }
            RelativeLineTo relativeLineTo = (RelativeLineTo) obj;
            return Float.compare(this.dx, relativeLineTo.dx) == 0 && Float.compare(this.dy, relativeLineTo.dy) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        public final String toString() {
            return "RelativeLineTo(dx=" + this.dx + ", dy=" + this.dy + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeMoveTo extends PathNode {
        public final float dx;
        public final float dy;

        public RelativeMoveTo(float f, float f2) {
            super(3);
            this.dx = f;
            this.dy = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeMoveTo)) {
                return false;
            }
            RelativeMoveTo relativeMoveTo = (RelativeMoveTo) obj;
            return Float.compare(this.dx, relativeMoveTo.dx) == 0 && Float.compare(this.dy, relativeMoveTo.dy) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        public final String toString() {
            return "RelativeMoveTo(dx=" + this.dx + ", dy=" + this.dy + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeQuadTo extends PathNode {
        public final float dx1;
        public final float dx2;
        public final float dy1;
        public final float dy2;

        public RelativeQuadTo(float f, float f2, float f3, float f4) {
            super(1);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeQuadTo)) {
                return false;
            }
            RelativeQuadTo relativeQuadTo = (RelativeQuadTo) obj;
            return Float.compare(this.dx1, relativeQuadTo.dx1) == 0 && Float.compare(this.dy1, relativeQuadTo.dy1) == 0 && Float.compare(this.dx2, relativeQuadTo.dx2) == 0 && Float.compare(this.dy2, relativeQuadTo.dy2) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy2) + IntIntPair$$ExternalSyntheticOutline0.m(this.dx2, IntIntPair$$ExternalSyntheticOutline0.m(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("RelativeQuadTo(dx1=", this.dx1, ", dy1=", this.dy1, ", dx2=");
            sbM.append(this.dx2);
            sbM.append(", dy2=");
            sbM.append(this.dy2);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeReflectiveCurveTo extends PathNode {
        public final float dx1;
        public final float dx2;
        public final float dy1;
        public final float dy2;

        public RelativeReflectiveCurveTo(float f, float f2, float f3, float f4) {
            super(2);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveCurveTo)) {
                return false;
            }
            RelativeReflectiveCurveTo relativeReflectiveCurveTo = (RelativeReflectiveCurveTo) obj;
            return Float.compare(this.dx1, relativeReflectiveCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeReflectiveCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeReflectiveCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeReflectiveCurveTo.dy2) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy2) + IntIntPair$$ExternalSyntheticOutline0.m(this.dx2, IntIntPair$$ExternalSyntheticOutline0.m(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("RelativeReflectiveCurveTo(dx1=", this.dx1, ", dy1=", this.dy1, ", dx2=");
            sbM.append(this.dx2);
            sbM.append(", dy2=");
            sbM.append(this.dy2);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeReflectiveQuadTo extends PathNode {
        public final float dx;
        public final float dy;

        public RelativeReflectiveQuadTo(float f, float f2) {
            super(1);
            this.dx = f;
            this.dy = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveQuadTo)) {
                return false;
            }
            RelativeReflectiveQuadTo relativeReflectiveQuadTo = (RelativeReflectiveQuadTo) obj;
            return Float.compare(this.dx, relativeReflectiveQuadTo.dx) == 0 && Float.compare(this.dy, relativeReflectiveQuadTo.dy) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        public final String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.dx + ", dy=" + this.dy + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RelativeVerticalTo extends PathNode {
        public final float dy;

        public RelativeVerticalTo(float f) {
            super(3);
            this.dy = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeVerticalTo) && Float.compare(this.dy, ((RelativeVerticalTo) obj).dy) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("RelativeVerticalTo(dy=", this.dy, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class VerticalTo extends PathNode {
        public final float y;

        public VerticalTo(float f) {
            super(3);
            this.y = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VerticalTo) && Float.compare(this.y, ((VerticalTo) obj).y) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.y);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("VerticalTo(y=", this.y, ")");
        }
    }

    public PathNode(int i) {
        boolean z = (i & 1) == 0;
        boolean z2 = (i & 2) == 0;
        this.isCurve = z;
        this.isQuad = z2;
    }
}
