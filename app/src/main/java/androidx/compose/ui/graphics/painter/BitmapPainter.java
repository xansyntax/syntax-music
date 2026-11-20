package androidx.compose.ui.graphics.painter;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import coil3.size.SizeKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapPainter extends Painter {
    public float alpha;
    public BlendModeColorFilter colorFilter;
    public boolean filterQuality = true;
    public final ImageBitmap image;
    public final long size;
    public final long srcSize;

    public BitmapPainter(ImageBitmap imageBitmap, long j) {
        int i;
        this.image = imageBitmap;
        this.srcSize = j;
        int i2 = (int) (j >> 32);
        if (i2 >= 0 && (i = (int) (4294967295L & j)) >= 0) {
            AndroidImageBitmap androidImageBitmap = (AndroidImageBitmap) imageBitmap;
            if (i2 <= androidImageBitmap.bitmap.getWidth() && i <= androidImageBitmap.bitmap.getHeight()) {
                this.size = j;
                this.alpha = 1.0f;
                return;
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
        throw null;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter = blendModeColorFilter;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) obj;
        return Intrinsics.areEqual(this.image, bitmapPainter.image) && IntOffset.m804equalsimpl0(0L, 0L) && IntSize.m810equalsimpl0(this.srcSize, bitmapPainter.srcSize) && this.filterQuality == bitmapPainter.filterQuality;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public final long mo573getIntrinsicSizeNHjbRc() {
        return SizeKt.m876toSizeozmzZPI(this.size);
    }

    public final int hashCode() {
        return Integer.hashCode(this.filterQuality ? 1 : 0) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.image.hashCode() * 31, 31, 0L), 31, this.srcSize);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        DrawScope.m544drawImageAZ2fEMs$default(layoutNodeDrawScope, this.image, this.srcSize, (((long) Math.round(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)))) & 4294967295L), this.alpha, this.colorFilter, this.filterQuality ? 1 : 0, 328);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        String strM807toStringimpl = IntOffset.m807toStringimpl(0L);
        String strM811toStringimpl = IntSize.m811toStringimpl(this.srcSize);
        boolean z = this.filterQuality;
        if (z == 0) {
            str = "None";
        } else if (z == 1) {
            str = "Low";
        } else if (z == 2) {
            str = "Medium";
        } else {
            str = z == 3 ? "High" : "Unknown";
        }
        StringBuilder sb = new StringBuilder("BitmapPainter(image=");
        sb.append(this.image);
        sb.append(", srcOffset=");
        sb.append(strM807toStringimpl);
        sb.append(", srcSize=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, strM811toStringimpl, ", filterQuality=", str, ")");
    }
}
