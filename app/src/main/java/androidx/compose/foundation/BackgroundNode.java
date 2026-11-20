package androidx.compose.foundation;

import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode, SemanticsModifierNode {
    public float alpha;
    public Brush brush;
    public long color;
    public LayoutDirection lastLayoutDirection;
    public ColorKt lastOutline;
    public Shape lastShape;
    public long lastSize;
    public Shape shape;
    public ColorKt tmpOutline;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, this.shape);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        ColorKt colorKt;
        Brush brush;
        AndroidPath androidPath;
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        if (this.shape == ColorKt.RectangleShape) {
            if (!ULong.m1869equalsimpl0(this.color, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified))) {
                DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope, this.color, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 126);
            }
            Brush brush2 = this.brush;
            if (brush2 != null) {
                DrawScope.m549drawRectAsUm42w$default(layoutNodeDrawScope, brush2, 0L, 0L, this.alpha, null, null, 0, 118);
            }
        } else {
            if (Size.m447equalsimpl0(canvasDrawScope.mo556getSizeNHjbRc(), this.lastSize) && layoutNodeDrawScope.getLayoutDirection() == this.lastLayoutDirection && Intrinsics.areEqual(this.lastShape, this.shape)) {
                colorKt = this.lastOutline;
                colorKt.getClass();
            } else {
                HitTestResultKt.observeReads(this, new Recomposer$$ExternalSyntheticLambda6((Object) this, (Object) layoutNodeDrawScope, (byte) 3));
                colorKt = this.tmpOutline;
                this.tmpOutline = null;
            }
            this.lastOutline = colorKt;
            this.lastSize = canvasDrawScope.mo556getSizeNHjbRc();
            this.lastLayoutDirection = layoutNodeDrawScope.getLayoutDirection();
            this.lastShape = this.shape;
            colorKt.getClass();
            if (!ULong.m1869equalsimpl0(this.color, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified))) {
                ColorKt.m490drawOutlinewDX37Ww$default(layoutNodeDrawScope, colorKt, this.color);
            }
            Brush brush3 = this.brush;
            if (brush3 != null) {
                float f = this.alpha;
                boolean z = colorKt instanceof Outline$Rectangle;
                Fill fill = Fill.INSTANCE;
                if (z) {
                    Rect rect = ((Outline$Rectangle) colorKt).rect;
                    float f2 = rect.left;
                    layoutNodeDrawScope.mo538drawRectAsUm42w(brush3, (4294967295L & ((long) Float.floatToRawIntBits(rect.top))) | (Float.floatToRawIntBits(f2) << 32), ColorKt.size(rect), f, fill, null, 3);
                } else {
                    if (colorKt instanceof Outline$Rounded) {
                        Outline$Rounded outline$Rounded = (Outline$Rounded) colorKt;
                        androidPath = outline$Rounded.roundRectPath;
                        if (androidPath != null) {
                            brush = brush3;
                        } else {
                            brush = brush3;
                            RoundRect roundRect = outline$Rounded.roundRect;
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRect.bottomLeftCornerRadius >> 32));
                            float f3 = roundRect.left;
                            layoutNodeDrawScope.mo540drawRoundRectZuiqVtQ(brush, (((long) Float.floatToRawIntBits(roundRect.top)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32), (((long) Float.floatToRawIntBits(roundRect.getWidth())) << 32) | (((long) Float.floatToRawIntBits(roundRect.getHeight())) & 4294967295L), (4294967295L & ((long) Float.floatToRawIntBits(fIntBitsToFloat))) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32), f, fill);
                        }
                    } else if (!(colorKt instanceof Outline$Generic)) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return;
                    } else {
                        brush = brush3;
                        androidPath = ((Outline$Generic) colorKt).path;
                    }
                    layoutNodeDrawScope.mo536drawPathGBMwjPU(androidPath, brush, f, fill, 3);
                }
            }
        }
        layoutNodeDrawScope.drawContent();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean isImportantForBounds() {
        return false;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        this.lastSize = 9205357640488583168L;
        this.lastLayoutDirection = null;
        this.lastOutline = null;
        this.lastShape = null;
        HitTestResultKt.invalidateDraw(this);
    }
}
