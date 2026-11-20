package com.metrolist.music.ui.screens.settings;

import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.BrowseScreenKt$BrowseScreen$3$1$1;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt;
import com.metrolist.music.ui.utils.AppBarKt;
import dev.chrisbanes.haze.HazeEffectNode;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KFunction;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThemeScreenKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;

    public /* synthetic */ ThemeScreenKt$$ExternalSyntheticLambda1(NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        NavHostController navHostController = this.f$0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChangedInstance = gapComposer.changedInstance(navHostController);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 25);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, AiSettingsKt.lambda$588638110, gapComposer, 1572864, 62);
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                AiSettingsKt.PlayerSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 2:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    NavHostController navHostController2 = this.f$0;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(navHostController2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$1 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController2, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 17);
                        gapComposer2.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$1);
                        objRememberedValue2 = browseScreenKt$BrowseScreen$3$1$1;
                    }
                    Function0 function0 = (Function0) objRememberedValue2;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(navHostController2);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass1 = new HazeEffectNode.AnonymousClass1(0, navHostController2, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 8);
                        gapComposer2.updateRememberedValue(anonymousClass1);
                        objRememberedValue3 = anonymousClass1;
                    }
                    MenuKt.IconButton(function0, (Function0) ((KFunction) objRememberedValue3), null, false, null, null, AiSettingsKt.f532lambda$2135816270, gapComposer2, 1572864);
                }
                break;
            case 3:
                ((Integer) obj2).getClass();
                AiSettingsKt.PrivacySettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 4:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    NavHostController navHostController3 = this.f$0;
                    boolean zChangedInstance4 = gapComposer3.changedInstance(navHostController3);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$2 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController3, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 18);
                        gapComposer3.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$2);
                        objRememberedValue4 = browseScreenKt$BrowseScreen$3$1$2;
                    }
                    Function0 function1 = (Function0) objRememberedValue4;
                    boolean zChangedInstance5 = gapComposer3.changedInstance(navHostController3);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass2 = new HazeEffectNode.AnonymousClass1(0, navHostController3, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 9);
                        gapComposer3.updateRememberedValue(anonymousClass2);
                        objRememberedValue5 = anonymousClass2;
                    }
                    MenuKt.IconButton(function1, (Function0) ((KFunction) objRememberedValue5), null, false, null, null, AiSettingsKt.f544lambda$338141846, gapComposer3, 1572864);
                }
                break;
            case 5:
                ((Integer) obj2).getClass();
                RomanizationSettingsKt.RomanizationSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 6:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    NavHostController navHostController4 = this.f$0;
                    boolean zChangedInstance6 = gapComposer4.changedInstance(navHostController4);
                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue6 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$3 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController4, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 19);
                        gapComposer4.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$3);
                        objRememberedValue6 = browseScreenKt$BrowseScreen$3$1$3;
                    }
                    Function0 function2 = (Function0) objRememberedValue6;
                    boolean zChangedInstance7 = gapComposer4.changedInstance(navHostController4);
                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue7 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass3 = new HazeEffectNode.AnonymousClass1(0, navHostController4, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 10);
                        gapComposer4.updateRememberedValue(anonymousClass3);
                        objRememberedValue7 = anonymousClass3;
                    }
                    MenuKt.IconButton(function2, (Function0) ((KFunction) objRememberedValue7), null, false, null, null, AiSettingsKt.f536lambda$247273481, gapComposer4, 1572864);
                }
                break;
            case 7:
                ((Integer) obj2).getClass();
                AiSettingsKt.StorageSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 8:
                ((Integer) obj2).getClass();
                AiSettingsKt.StorageSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 9:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    NavHostController navHostController5 = this.f$0;
                    boolean zChangedInstance8 = gapComposer5.changedInstance(navHostController5);
                    Object objRememberedValue8 = gapComposer5.rememberedValue();
                    if (zChangedInstance8 || objRememberedValue8 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$4 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController5, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 20);
                        gapComposer5.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$4);
                        objRememberedValue8 = browseScreenKt$BrowseScreen$3$1$4;
                    }
                    Function0 function3 = (Function0) objRememberedValue8;
                    boolean zChangedInstance9 = gapComposer5.changedInstance(navHostController5);
                    Object objRememberedValue9 = gapComposer5.rememberedValue();
                    if (zChangedInstance9 || objRememberedValue9 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass4 = new HazeEffectNode.AnonymousClass1(0, navHostController5, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 11);
                        gapComposer5.updateRememberedValue(anonymousClass4);
                        objRememberedValue9 = anonymousClass4;
                    }
                    MenuKt.IconButton(function3, (Function0) ((KFunction) objRememberedValue9), null, false, null, null, AiSettingsKt.f515lambda$1976435316, gapComposer5, 1572864);
                }
                break;
            case 10:
                ((Integer) obj2).getClass();
                AiSettingsKt.StorageSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 11:
                ((Integer) obj2).getClass();
                AiSettingsKt.StorageSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Integer) obj2).getClass();
                ThemeScreenKt.ThemeScreen(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 13:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    NavHostController navHostController6 = this.f$0;
                    boolean zChangedInstance10 = gapComposer6.changedInstance(navHostController6);
                    Object objRememberedValue10 = gapComposer6.rememberedValue();
                    if (zChangedInstance10 || objRememberedValue10 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$5 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController6, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 21);
                        gapComposer6.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$5);
                        objRememberedValue10 = browseScreenKt$BrowseScreen$3$1$5;
                    }
                    Function0 function4 = (Function0) objRememberedValue10;
                    boolean zChangedInstance11 = gapComposer6.changedInstance(navHostController6);
                    Object objRememberedValue11 = gapComposer6.rememberedValue();
                    if (zChangedInstance11 || objRememberedValue11 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass5 = new HazeEffectNode.AnonymousClass1(0, navHostController6, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 12);
                        gapComposer6.updateRememberedValue(anonymousClass5);
                        objRememberedValue11 = anonymousClass5;
                    }
                    MenuKt.IconButton(function4, (Function0) ((KFunction) objRememberedValue11), null, false, null, null, AiSettingsKt.f578lambda$879011257, gapComposer6, 1572864);
                }
                break;
            case 14:
                ((Integer) obj2).getClass();
                AiSettingsKt.UpdaterScreen(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 15:
                ((Integer) obj2).getClass();
                LastFMSettingsKt.DiscordSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 16:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    NavHostController navHostController7 = this.f$0;
                    boolean zChangedInstance12 = gapComposer7.changedInstance(navHostController7);
                    Object objRememberedValue12 = gapComposer7.rememberedValue();
                    if (zChangedInstance12 || objRememberedValue12 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$6 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController7, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 22);
                        gapComposer7.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$6);
                        objRememberedValue12 = browseScreenKt$BrowseScreen$3$1$6;
                    }
                    Function0 function5 = (Function0) objRememberedValue12;
                    boolean zChangedInstance13 = gapComposer7.changedInstance(navHostController7);
                    Object objRememberedValue13 = gapComposer7.rememberedValue();
                    if (zChangedInstance13 || objRememberedValue13 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass6 = new HazeEffectNode.AnonymousClass1(0, navHostController7, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 13);
                        gapComposer7.updateRememberedValue(anonymousClass6);
                        objRememberedValue13 = anonymousClass6;
                    }
                    MenuKt.IconButton(function5, (Function0) ((KFunction) objRememberedValue13), null, false, null, null, LastFMSettingsKt.f617lambda$2005383561, gapComposer7, 1572864);
                }
                break;
            case 17:
                ((Integer) obj2).getClass();
                LastFMSettingsKt.DiscordSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 18:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    NavHostController navHostController8 = this.f$0;
                    boolean zChangedInstance14 = gapComposer8.changedInstance(navHostController8);
                    Object objRememberedValue14 = gapComposer8.rememberedValue();
                    if (zChangedInstance14 || objRememberedValue14 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$7 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController8, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 23);
                        gapComposer8.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$7);
                        objRememberedValue14 = browseScreenKt$BrowseScreen$3$1$7;
                    }
                    Function0 function6 = (Function0) objRememberedValue14;
                    boolean zChangedInstance15 = gapComposer8.changedInstance(navHostController8);
                    Object objRememberedValue15 = gapComposer8.rememberedValue();
                    if (zChangedInstance15 || objRememberedValue15 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass7 = new HazeEffectNode.AnonymousClass1(0, navHostController8, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 14);
                        gapComposer8.updateRememberedValue(anonymousClass7);
                        objRememberedValue15 = anonymousClass7;
                    }
                    MenuKt.IconButton(function6, (Function0) ((KFunction) objRememberedValue15), null, false, null, null, LastFMSettingsKt.lambda$236129495, gapComposer8, 1572864);
                }
                break;
            case 19:
                ((Integer) obj2).getClass();
                LastFMSettingsKt.IntegrationScreen(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 20:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    NavHostController navHostController9 = this.f$0;
                    boolean zChangedInstance16 = gapComposer9.changedInstance(navHostController9);
                    Object objRememberedValue16 = gapComposer9.rememberedValue();
                    if (zChangedInstance16 || objRememberedValue16 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$8 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController9, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 24);
                        gapComposer9.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$8);
                        objRememberedValue16 = browseScreenKt$BrowseScreen$3$1$8;
                    }
                    Function0 function7 = (Function0) objRememberedValue16;
                    boolean zChangedInstance17 = gapComposer9.changedInstance(navHostController9);
                    Object objRememberedValue17 = gapComposer9.rememberedValue();
                    if (zChangedInstance17 || objRememberedValue17 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass8 = new HazeEffectNode.AnonymousClass1(0, navHostController9, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 15);
                        gapComposer9.updateRememberedValue(anonymousClass8);
                        objRememberedValue17 = anonymousClass8;
                    }
                    MenuKt.IconButton(function7, (Function0) ((KFunction) objRememberedValue17), null, false, null, null, LastFMSettingsKt.lambda$506681907, gapComposer9, 1572864);
                }
                break;
            case 21:
                ((Integer) obj2).getClass();
                LastFMSettingsKt.LastFMSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 22:
                ((Integer) obj2).getClass();
                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 23:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    NavHostController navHostController10 = this.f$0;
                    boolean zChangedInstance18 = gapComposer10.changedInstance(navHostController10);
                    Object objRememberedValue18 = gapComposer10.rememberedValue();
                    if (zChangedInstance18 || objRememberedValue18 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$9 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController10, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 25);
                        gapComposer10.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$9);
                        objRememberedValue18 = browseScreenKt$BrowseScreen$3$1$9;
                    }
                    Function0 function8 = (Function0) objRememberedValue18;
                    boolean zChangedInstance19 = gapComposer10.changedInstance(navHostController10);
                    Object objRememberedValue19 = gapComposer10.rememberedValue();
                    if (zChangedInstance19 || objRememberedValue19 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass9 = new HazeEffectNode.AnonymousClass1(0, navHostController10, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 16);
                        gapComposer10.updateRememberedValue(anonymousClass9);
                        objRememberedValue19 = anonymousClass9;
                    }
                    MenuKt.IconButton(function8, (Function0) ((KFunction) objRememberedValue19), null, false, null, null, LastFMSettingsKt.lambda$1371291819, gapComposer10, 1572864);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ ThemeScreenKt$$ExternalSyntheticLambda1(NavHostController navHostController, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
    }
}
