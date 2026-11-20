package androidx.compose.material3;

import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonShapes {
    public final Shape pressedShape;
    public final Shape shape;

    public ButtonShapes(Shape shape, Shape shape2) {
        this.shape = shape;
        this.pressedShape = shape2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ButtonShapes)) {
            return false;
        }
        ButtonShapes buttonShapes = (ButtonShapes) obj;
        return Intrinsics.areEqual(this.shape, buttonShapes.shape) && Intrinsics.areEqual(this.pressedShape, buttonShapes.pressedShape);
    }

    public final int hashCode() {
        return this.pressedShape.hashCode() + (this.shape.hashCode() * 31);
    }
}
