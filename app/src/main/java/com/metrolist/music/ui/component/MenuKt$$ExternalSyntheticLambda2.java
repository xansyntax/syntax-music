package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Material3MenuItemData f$0;

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda2(Material3MenuItemData material3MenuItemData) {
        this.f$0 = material3MenuItemData;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Material3MenuItemData material3MenuItemData = this.f$0;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                int iIntValue = num.intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    material3MenuItemData.title.invoke(gapComposer, 0);
                }
                break;
            default:
                num.getClass();
                MenuKt.Material3MenuItemRow(material3MenuItemData, composer, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda2(Material3MenuItemData material3MenuItemData, int i) {
        this.f$0 = material3MenuItemData;
    }
}
