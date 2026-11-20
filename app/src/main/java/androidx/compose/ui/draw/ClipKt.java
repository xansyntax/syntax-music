package androidx.compose.ui.draw;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerElement;
import androidx.compose.ui.graphics.LayerOutsets;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ClipKt {
    public static final Modifier alpha(Modifier modifier, float f) {
        return f == 1.0f ? modifier : modifier.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : f, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : true, LayerOutsets.Zero));
    }

    public static final Modifier clip(Modifier modifier, Shape shape) {
        return modifier.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : shape, (1048319 & 4096) != 0 ? false : true, LayerOutsets.Zero));
    }

    public static final Modifier clipToBounds(Modifier modifier) {
        return modifier.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : true, LayerOutsets.Zero));
    }

    public static final Modifier drawBehind(Modifier modifier, Function1 function1) {
        return modifier.then(new DrawBehindElement(function1));
    }

    public static final Modifier drawWithCache(Modifier modifier, Function1 function1) {
        return modifier.then(new DrawWithCacheElement(function1));
    }

    public static final Modifier drawWithContent(Modifier modifier, Function1 function1) {
        return modifier.then(new DrawWithContentElement(function1));
    }

    public static Modifier paint$default(Modifier modifier, Painter painter, ContentScale contentScale, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        if ((i & 16) != 0) {
            f = 1.0f;
        }
        return modifier.then(new PainterElement(painter, biasAlignment, contentScale, f, blendModeColorFilter));
    }

    public static final Modifier scale() {
        return Modifier.Companion.$$INSTANCE.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : 0.85f, (1048319 & 2) != 0 ? 1.0f : 0.85f, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero));
    }

    /* JADX INFO: renamed from: shadow-s4CzXII$default, reason: not valid java name */
    public static Modifier m399shadows4CzXII$default(Modifier modifier, float f, RoundedCornerShape roundedCornerShape, long j, long j2, int i) {
        boolean z = Dp.m795compareTo0680j_4(f, CropImageView.DEFAULT_ASPECT_RATIO) > 0;
        return (Dp.m795compareTo0680j_4(f, CropImageView.DEFAULT_ASPECT_RATIO) > 0 || z) ? modifier.then(new ShadowGraphicsLayerElement(f, roundedCornerShape, z, (i & 8) != 0 ? -72057594037927936L : j, (i & 16) == 0 ? j2 : -72057594037927936L)) : modifier;
    }
}
