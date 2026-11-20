package androidx.compose.material3;

import androidx.compose.foundation.shape.DpCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.LazyValueHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShapesKt {
    static {
        new LazyValueHolder(new TextKt$$ExternalSyntheticLambda3((byte) 8));
    }

    public static RoundedCornerShape end$default(RoundedCornerShape roundedCornerShape) {
        DpCornerSize dpCornerSize = ShapeDefaults.CornerNone;
        return RoundedCornerShape.copy$default(roundedCornerShape, dpCornerSize, null, null, dpCornerSize, 6);
    }

    /* JADX INFO: renamed from: fromToken-CLvlw10, reason: not valid java name */
    public static final Shape m325fromTokenCLvlw10(Shapes shapes, int i) {
        if (i == 1) {
            return shapes.extraLarge;
        }
        if (i == 2) {
            return shapes.extraLargeIncreased;
        }
        if (i == 0) {
            return shapes.extraExtraLarge;
        }
        if (i == 3) {
            return top$default(shapes.extraLarge);
        }
        if (i == 4) {
            return shapes.extraSmall;
        }
        if (i == 5) {
            return top$default(shapes.extraSmall);
        }
        if (i == 6) {
            return RoundedCornerShapeKt.CircleShape;
        }
        if (i == 7) {
            return shapes.large;
        }
        if (i == 9) {
            return shapes.largeIncreased;
        }
        if (i == 8) {
            return end$default(shapes.large);
        }
        if (i == 11) {
            return top$default(shapes.large);
        }
        if (i == 12) {
            return shapes.medium;
        }
        if (i != 13) {
            if (i == 14) {
                return shapes.small;
            }
            if (i == 10) {
                return start$default(shapes.large);
            }
        }
        return ColorKt.RectangleShape;
    }

    public static final Shape getValue(int i, Composer composer) {
        return m325fromTokenCLvlw10(((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).shapes, i);
    }

    public static RoundedCornerShape start$default(RoundedCornerShape roundedCornerShape) {
        DpCornerSize dpCornerSize = ShapeDefaults.CornerNone;
        return RoundedCornerShape.copy$default(roundedCornerShape, null, dpCornerSize, dpCornerSize, null, 9);
    }

    public static RoundedCornerShape top$default(RoundedCornerShape roundedCornerShape) {
        DpCornerSize dpCornerSize = ShapeDefaults.CornerNone;
        return RoundedCornerShape.copy$default(roundedCornerShape, null, null, dpCornerSize, dpCornerSize, 3);
    }
}
