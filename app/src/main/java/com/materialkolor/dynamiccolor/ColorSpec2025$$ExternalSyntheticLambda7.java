package com.materialkolor.dynamiccolor;

import com.materialkolor.scheme.DynamicScheme;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2025$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ColorSpec2025 f$0;

    public /* synthetic */ ColorSpec2025$$ExternalSyntheticLambda7(ColorSpec2025 colorSpec2025, byte b) {
        this.$r8$classId = b;
        this.f$0 = colorSpec2025;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        DynamicScheme.Platform platform = DynamicScheme.Platform.WATCH;
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        ColorSpec2025 colorSpec2025 = this.f$0;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (b) {
            case 0:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform2) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return colorSpec2025.surfaceContainerHigh();
            case 1:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform2) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return null;
            case 2:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return new ToneDeltaPair(colorSpec2025.primaryContainer(), colorSpec2025.primaryDim(), 10.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
                }
                return null;
            case 3:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform2) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return null;
            case 4:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return new ToneDeltaPair(colorSpec2025.secondaryContainer(), colorSpec2025.secondaryDim(), 10.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
                }
                return null;
            case 5:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform2) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return null;
            case 6:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return new ToneDeltaPair(colorSpec2025.tertiaryContainer(), colorSpec2025.tertiaryDim(), 10.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
                }
                return null;
            default:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform2) {
                    return new ToneDeltaPair(colorSpec2025.secondaryContainer(), colorSpec2025.secondary(), 5.0d, TonePolarity.RELATIVE_LIGHTER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
                }
                return null;
        }
    }
}
