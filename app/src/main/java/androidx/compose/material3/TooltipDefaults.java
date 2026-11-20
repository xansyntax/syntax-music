package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.Density;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TooltipDefaults {
    public static final float plainTooltipMaxWidth;

    static {
        UtilsKt.m890DpSizeYgX7TsA(16.0f, 8.0f);
        plainTooltipMaxWidth = 200.0f;
    }

    /* JADX INFO: renamed from: rememberTooltipPositionProvider-Hu5FAss, reason: not valid java name */
    public static TooltipPositionProviderImpl m360rememberTooltipPositionProviderHu5FAss(Composer composer) {
        PaddingValuesImpl paddingValuesImpl = TooltipKt.PlainTooltipContentPadding;
        GapComposer gapComposer = (GapComposer) composer;
        int iMo75roundToPx0680j_4 = ((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo75roundToPx0680j_4(4.0f);
        long jM715getContainerSizeYbymL2g = ((LazyWindowInfo) ((WindowInfo) gapComposer.consume(CompositionLocalsKt.LocalWindowInfo))).m715getContainerSizeYbymL2g();
        boolean zChanged = gapComposer.changed(iMo75roundToPx0680j_4) | gapComposer.changed(1) | gapComposer.changed(jM715getContainerSizeYbymL2g);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new TooltipPositionProviderImpl(iMo75roundToPx0680j_4, jM715getContainerSizeYbymL2g);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (TooltipPositionProviderImpl) objRememberedValue;
    }
}
