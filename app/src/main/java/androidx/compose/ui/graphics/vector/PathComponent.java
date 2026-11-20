package androidx.compose.ui.graphics.vector;

import android.graphics.Path;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PathComponent extends VNode {
    public AndroidPath _tmpPath;
    public Brush fill;
    public boolean isTrimPathDirty;
    public final AndroidPath path;
    public final Lazy pathMeasure$delegate;
    public AndroidPath renderPath;
    public Brush stroke;
    public float strokeLineWidth;
    public Stroke strokeStyle;
    public float trimPathOffset;
    public float trimPathStart;
    public float fillAlpha = 1.0f;
    public List pathData = EmptyList.INSTANCE;
    public float strokeAlpha = 1.0f;
    public int strokeLineCap = 0;
    public int strokeLineJoin = 0;
    public float strokeLineMiter = 4.0f;
    public float trimPathEnd = 1.0f;
    public boolean isPathDirty = true;
    public boolean isStrokeDirty = true;

    public PathComponent() {
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        this.path = androidPathPath;
        this.renderPath = androidPathPath;
        this.pathMeasure$delegate = ResultKt.lazy(LazyThreadSafetyMode.NONE, new TextKt$$ExternalSyntheticLambda3((byte) 19));
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        DrawScope drawScope2;
        Stroke stroke;
        if (this.isPathDirty) {
            PathParserKt.toPath(this.pathData, this.path);
            updateRenderPath();
        } else if (this.isTrimPathDirty) {
            updateRenderPath();
        }
        this.isPathDirty = false;
        this.isTrimPathDirty = false;
        Brush brush = this.fill;
        if (brush != null) {
            drawScope2 = drawScope;
            DrawScope.m547drawPathGBMwjPU$default(drawScope2, this.renderPath, brush, this.fillAlpha, null, 56);
        } else {
            drawScope2 = drawScope;
        }
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            Stroke stroke2 = this.strokeStyle;
            if (this.isStrokeDirty || stroke2 == null) {
                Stroke stroke3 = new Stroke(this.strokeLineWidth, this.strokeLineMiter, this.strokeLineCap, this.strokeLineJoin, 16);
                this.strokeStyle = stroke3;
                this.isStrokeDirty = false;
                stroke = stroke3;
            } else {
                stroke = stroke2;
            }
            DrawScope.m547drawPathGBMwjPU$default(drawScope2, this.renderPath, brush2, this.strokeAlpha, stroke, 48);
        }
    }

    public final String toString() {
        return this.path.toString();
    }

    public final void updateRenderPath() {
        float f = this.trimPathStart;
        AndroidPath androidPath = this.path;
        if (f == CropImageView.DEFAULT_ASPECT_RATIO && this.trimPathEnd == 1.0f) {
            this.renderPath = androidPath;
            return;
        }
        AndroidPath androidPath2 = this.renderPath;
        if (androidPath2 != androidPath) {
            int i = androidPath2.internalPath.getFillType() == Path.FillType.EVEN_ODD ? 1 : 0;
            this.renderPath.rewind();
            this.renderPath.m471setFillTypeoQ8Xj4U(i);
        } else {
            this.renderPath = AndroidPath_androidKt.Path();
        }
        Lazy lazy = this.pathMeasure$delegate;
        ((AndroidPathMeasure) lazy.getValue()).setPath(androidPath);
        float length = ((AndroidPathMeasure) lazy.getValue()).internalPathMeasure.getLength();
        float f2 = this.trimPathStart;
        float f3 = this.trimPathOffset;
        float f4 = ((f2 + f3) % 1.0f) * length;
        float f5 = ((this.trimPathEnd + f3) % 1.0f) * length;
        if (f4 <= f5) {
            ((AndroidPathMeasure) lazy.getValue()).getSegment(f4, f5, this.renderPath);
            return;
        }
        AndroidPath androidPathPath = this._tmpPath;
        if (androidPathPath == null) {
            androidPathPath = AndroidPath_androidKt.Path();
            this._tmpPath = androidPathPath;
        }
        androidPathPath.reset();
        ((AndroidPathMeasure) lazy.getValue()).getSegment(f4, length, androidPathPath);
        AndroidPath.m469addPathUv8p0NA$default(this.renderPath, androidPathPath);
        androidPathPath.reset();
        ((AndroidPathMeasure) lazy.getValue()).getSegment(CropImageView.DEFAULT_ASPECT_RATIO, f5, androidPathPath);
        AndroidPath.m469addPathUv8p0NA$default(this.renderPath, androidPathPath);
    }
}
