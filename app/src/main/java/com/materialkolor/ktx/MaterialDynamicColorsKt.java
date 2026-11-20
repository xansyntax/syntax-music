package com.materialkolor.ktx;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import com.materialkolor.DynamicMaterialThemeState;
import com.materialkolor.MaterialKolors;
import com.materialkolor.dynamiccolor.MaterialDynamicColors;
import com.materialkolor.scheme.DynamicScheme;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Gz\u0002\b\u0005¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0006\u001a\u00020\u0007*\u00020\u00028Gz\u0002\b\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"m3Colors", "Lcom/materialkolor/dynamiccolor/MaterialDynamicColors;", "Lcom/materialkolor/DynamicMaterialThemeState;", "getM3Colors", "(Lcom/materialkolor/DynamicMaterialThemeState;Landroidx/compose/runtime/Composer;I)Lcom/materialkolor/dynamiccolor/MaterialDynamicColors;", "Landroidx/compose/runtime/Composable;", "colors", "Lcom/materialkolor/MaterialKolors;", "getColors", "(Lcom/materialkolor/DynamicMaterialThemeState;Landroidx/compose/runtime/Composer;I)Lcom/materialkolor/MaterialKolors;", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class MaterialDynamicColorsKt {
    public static final MaterialKolors getColors(DynamicMaterialThemeState dynamicMaterialThemeState, Composer composer, int i) {
        dynamicMaterialThemeState.getClass();
        DynamicScheme dynamicScheme = dynamicMaterialThemeState.getDynamicScheme(composer);
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(dynamicScheme);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            ((Boolean) dynamicMaterialThemeState.isAmoled$delegate.getValue()).booleanValue();
            dynamicScheme.getClass();
            objRememberedValue = new MaterialKolors();
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (MaterialKolors) objRememberedValue;
    }

    public static final MaterialDynamicColors getM3Colors(DynamicMaterialThemeState dynamicMaterialThemeState, Composer composer, int i) {
        dynamicMaterialThemeState.getClass();
        DynamicScheme dynamicScheme = dynamicMaterialThemeState.getDynamicScheme(composer);
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(dynamicScheme);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new MaterialDynamicColors();
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (MaterialDynamicColors) objRememberedValue;
    }
}
