package com.materialkolor;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DynamicMaterialThemeKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ ColorScheme f$0;
    public final /* synthetic */ Shapes f$1;
    public final /* synthetic */ Typography f$2;
    public final /* synthetic */ Function2 f$3;

    public /* synthetic */ DynamicMaterialThemeKt$$ExternalSyntheticLambda1(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2 function2) {
        this.f$0 = colorScheme;
        this.f$1 = shapes;
        this.f$2 = typography;
        this.f$3 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MaterialThemeKt.MaterialTheme(this.f$0, this.f$1, this.f$2, this.f$3, gapComposer, 0);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                MaterialThemeKt.MaterialTheme(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ DynamicMaterialThemeKt$$ExternalSyntheticLambda1(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2 function2, int i) {
        this.f$0 = colorScheme;
        this.f$1 = shapes;
        this.f$2 = typography;
        this.f$3 = function2;
    }
}
