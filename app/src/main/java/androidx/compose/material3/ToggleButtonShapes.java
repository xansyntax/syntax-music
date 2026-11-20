package androidx.compose.material3;

import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ToggleButtonShapes {
    public final Shape checkedShape;
    public final Shape pressedShape;
    public final Shape shape;

    public ToggleButtonShapes(Shape shape, Shape shape2, Shape shape3) {
        this.shape = shape;
        this.pressedShape = shape2;
        this.checkedShape = shape3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ToggleButtonShapes)) {
            return false;
        }
        ToggleButtonShapes toggleButtonShapes = (ToggleButtonShapes) obj;
        return Intrinsics.areEqual(this.shape, toggleButtonShapes.shape) && Intrinsics.areEqual(this.pressedShape, toggleButtonShapes.pressedShape) && Intrinsics.areEqual(this.checkedShape, toggleButtonShapes.checkedShape);
    }

    public final int hashCode() {
        return this.checkedShape.hashCode() + ((this.pressedShape.hashCode() + (this.shape.hashCode() * 31)) * 31);
    }
}
