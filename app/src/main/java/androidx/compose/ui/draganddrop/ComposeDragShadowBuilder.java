package androidx.compose.ui.draganddrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeDragShadowBuilder extends View.DragShadowBuilder {
    public final long decorationSize;
    public final DensityImpl density;
    public final Function1 drawDragDecoration;

    public ComposeDragShadowBuilder(DensityImpl densityImpl, long j, Function1 function1) {
        this.density = densityImpl;
        this.decorationSize = j;
        this.drawDragDecoration = function1;
    }

    @Override // android.view.View.DragShadowBuilder
    public final void onDrawShadow(Canvas canvas) {
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.internalCanvas = canvas;
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
        Density density = drawParams.density;
        LayoutDirection layoutDirection = drawParams.layoutDirection;
        androidx.compose.ui.graphics.Canvas canvas3 = drawParams.canvas;
        long j = drawParams.size;
        drawParams.density = this.density;
        drawParams.layoutDirection = LayoutDirection.Ltr;
        drawParams.canvas = androidCanvas;
        drawParams.size = this.decorationSize;
        androidCanvas.save();
        this.drawDragDecoration.invoke(canvasDrawScope);
        androidCanvas.restore();
        drawParams.density = density;
        drawParams.layoutDirection = layoutDirection;
        drawParams.canvas = canvas3;
        drawParams.size = j;
    }

    @Override // android.view.View.DragShadowBuilder
    public final void onProvideShadowMetrics(Point point, Point point2) {
        long j = this.decorationSize;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        DensityImpl densityImpl = this.density;
        point.set(densityImpl.mo75roundToPx0680j_4(densityImpl.mo77toDpu2uoSUM(fIntBitsToFloat)), densityImpl.mo75roundToPx0680j_4(densityImpl.mo77toDpu2uoSUM(Float.intBitsToFloat((int) (j & 4294967295L)))));
        point2.set(point.x / 2, point.y / 2);
    }
}
