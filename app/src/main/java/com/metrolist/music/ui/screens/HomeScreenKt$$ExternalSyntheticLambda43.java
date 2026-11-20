package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavHostController;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.recognition.RecognitionHistoryScreenKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda11;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda43 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda43(NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        NavHostController navHostController = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(companion, gapComposer, 6);
                    String strStringResource = MathKt.stringResource(R.string.mood_and_genres, gapComposer);
                    boolean zChangedInstance = gapComposer.changedInstance(navHostController);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 19);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    MenuKt.NavigationTitle(strStringResource, modifierM1473hairlineBottomiJQMabo, null, null, (Function0) objRememberedValue, null, gapComposer, 0, 44);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Modifier modifierM1473hairlineBottomiJQMabo2 = DialogKt.m1473hairlineBottomiJQMabo(companion, gapComposer2, 6);
                    String strStringResource2 = MathKt.stringResource(R.string.your_shows, gapComposer2);
                    boolean zChangedInstance2 = gapComposer2.changedInstance(navHostController);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 16);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    MenuKt.NavigationTitle(strStringResource2, modifierM1473hairlineBottomiJQMabo2, null, null, (Function0) objRememberedValue2, null, gapComposer2, 0, 44);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Modifier modifierM1473hairlineBottomiJQMabo3 = DialogKt.m1473hairlineBottomiJQMabo(companion, gapComposer3, 6);
                    String strStringResource3 = MathKt.stringResource(R.string.episodes_for_later, gapComposer3);
                    boolean zChangedInstance3 = gapComposer3.changedInstance(navHostController);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 18);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    MenuKt.NavigationTitle(strStringResource3, modifierM1473hairlineBottomiJQMabo3, null, null, (Function0) objRememberedValue3, null, gapComposer3, 0, 44);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    boolean zChangedInstance4 = gapComposer4.changedInstance(navHostController);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 20);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    ListenTogetherScreenKt.SettingsLinkCard((Function0) objRememberedValue4, gapComposer4, 0);
                }
                break;
            default:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    boolean zChangedInstance5 = gapComposer5.changedInstance(navHostController);
                    Object objRememberedValue5 = gapComposer5.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 8);
                        gapComposer5.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.IconButton((Function0) objRememberedValue5, null, false, null, null, RecognitionHistoryScreenKt.f422lambda$810156361, gapComposer5, 1572864, 62);
                }
                break;
        }
        return unit;
    }
}
