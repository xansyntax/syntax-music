package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.scheme.DynamicScheme;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2021$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ColorSpec2021 f$0;

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda13(ColorSpec2021 colorSpec2021, byte b) {
        this.$r8$classId = b;
        this.f$0 = colorSpec2021;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        ColorSpec2021 colorSpec2021 = this.f$0;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (b) {
            case 0:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.primaryContainer(), colorSpec2021.primary(), 10.0d, TonePolarity.NEARER, false, null, 32);
            case 1:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.tertiaryFixed(), colorSpec2021.tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true, null, 32);
            case 2:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.tertiaryFixed(), colorSpec2021.tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true, null, 32);
            case 3:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.primaryContainer(), colorSpec2021.primary(), 10.0d, TonePolarity.NEARER, false, null, 32);
            case 4:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.primaryFixed(), colorSpec2021.primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true, null, 32);
            case 5:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.tertiaryContainer(), colorSpec2021.tertiary(), 10.0d, TonePolarity.NEARER, false, null, 32);
            case 6:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.secondaryContainer(), colorSpec2021.secondary(), 10.0d, TonePolarity.NEARER, false, null, 32);
            case 7:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.errorContainer(), colorSpec2021.error(), 10.0d, TonePolarity.NEARER, false, null, 32);
            case 8:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.tertiaryContainer(), colorSpec2021.tertiary(), 10.0d, TonePolarity.NEARER, false, null, 32);
            case 9:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.errorContainer(), colorSpec2021.error(), 10.0d, TonePolarity.NEARER, false, null, 32);
            case 10:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.secondaryFixed(), colorSpec2021.secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true, null, 32);
            case 11:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.primaryFixed(), colorSpec2021.primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true, null, 32);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.secondaryFixed(), colorSpec2021.secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true, null, 32);
            default:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2021.secondaryContainer(), colorSpec2021.secondary(), 10.0d, TonePolarity.NEARER, false, null, 32);
        }
    }
}
