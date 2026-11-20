package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorVectorConverterKt$ColorToVector$1$1 implements Function1 {
    public static final ColorVectorConverterKt$ColorToVector$1$1 INSTANCE = new ColorVectorConverterKt$ColorToVector$1$1();

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        long jM479convertvNxB06k = Color.m479convertvNxB06k(((Color) obj).value, ColorSpaces.Oklab);
        return new AnimationVector4D(Color.m481getAlphaimpl(jM479convertvNxB06k), Color.m485getRedimpl(jM479convertvNxB06k), Color.m484getGreenimpl(jM479convertvNxB06k), Color.m482getBlueimpl(jM479convertvNxB06k));
    }
}
