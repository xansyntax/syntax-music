package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$ColorSaver$2 implements Function1 {
    public static final SaversKt$ColorSaver$2 INSTANCE = new SaversKt$ColorSaver$2();

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
            return new Color(ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified));
        }
        obj.getClass();
        return new Color(((long) ((Integer) obj).intValue()) << 32);
    }
}
