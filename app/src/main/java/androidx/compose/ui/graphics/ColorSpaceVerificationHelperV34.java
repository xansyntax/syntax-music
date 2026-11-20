package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSpaceVerificationHelperV34 {
    public static final ColorSpace obtainAndroidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Bt2020Hlg)) {
            return ColorSpace.get(ColorSpace.Named.BT2020_HLG);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Bt2020Pq)) {
            return ColorSpace.get(ColorSpace.Named.BT2020_PQ);
        }
        return null;
    }
}
