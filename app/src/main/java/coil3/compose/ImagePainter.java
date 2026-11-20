package coil3.compose;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.emoji2.text.EmojiProcessor;
import coil3.Image;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImagePainter extends Painter {
    public final Image image;

    public ImagePainter(Image image) {
        this.image = image;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo573getIntrinsicSizeNHjbRc() {
        Image image = this.image;
        int width = image.getWidth();
        float f = width > 0 ? width : Float.NaN;
        int height = image.getHeight();
        return (((long) Float.floatToRawIntBits(height > 0 ? height : Float.NaN)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        Image image = this.image;
        int width = image.getWidth();
        float fIntBitsToFloat = width > 0 ? Float.intBitsToFloat((int) (layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc() >> 32)) / width : 1.0f;
        int height = image.getHeight();
        float fIntBitsToFloat2 = height > 0 ? Float.intBitsToFloat((int) (layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) / height : 1.0f;
        EmojiProcessor emojiProcessor = layoutNodeDrawScope.canvasDrawScope.drawContext;
        long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
        emojiProcessor.getCanvas().save();
        try {
            ((DrawResult) emojiProcessor.mSpanFactory).m403scale0AR0LA0(fIntBitsToFloat, fIntBitsToFloat2, 0L);
            image.draw(AndroidCanvas_androidKt.getNativeCanvas(layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas()));
        } finally {
            IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
        }
    }
}
