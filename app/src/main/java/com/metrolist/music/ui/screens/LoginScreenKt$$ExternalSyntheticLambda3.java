package com.metrolist.music.ui.screens;

import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$4$2$1;
import com.metrolist.music.ui.screens.recognition.RecognitionHistoryScreenKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.screens.settings.AboutScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.utils.AppBarKt;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeEffectNode;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KFunction;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LoginScreenKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda3(NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$ContentSettingsKt$$ExternalSyntheticLambda75(Object obj, Object obj2) {
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            NavHostController navHostController = this.f$0;
            boolean zChangedInstance = gapComposer.changedInstance(navHostController);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$1 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 15);
                gapComposer.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$1);
                objRememberedValue = browseScreenKt$BrowseScreen$3$1$1;
            }
            Function0 function0 = (Function0) objRememberedValue;
            boolean zChangedInstance2 = gapComposer.changedInstance(navHostController);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new HazeEffectNode.AnonymousClass1(0, navHostController, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MenuKt.IconButton(function0, (Function0) ((KFunction) objRememberedValue2), null, false, null, null, AiSettingsKt.f569lambda$729563376, gapComposer, 1572864);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        byte b2 = 13;
        byte b3 = 4;
        NavHostController navHostController = this.f$0;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    NavHostController navHostController2 = this.f$0;
                    boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$1 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController2, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 3);
                        gapComposer.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$1);
                        objRememberedValue = browseScreenKt$BrowseScreen$3$1$1;
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    boolean zChangedInstance2 = gapComposer.changedInstance(navHostController2);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, navHostController2, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 0);
                        gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                        objRememberedValue2 = loginScreenKt$LoginScreen$1$3$2$1;
                    }
                    MenuKt.IconButton(function0, (Function0) ((KFunction) objRememberedValue2), null, false, null, null, AlbumScreenKt.lambda$377225021, gapComposer, 1572864);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    NavHostController navHostController3 = this.f$0;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(navHostController3);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$2 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController3, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 1);
                        gapComposer2.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$2);
                        objRememberedValue3 = browseScreenKt$BrowseScreen$3$1$2;
                    }
                    Function0 function1 = (Function0) objRememberedValue3;
                    boolean zChangedInstance4 = gapComposer2.changedInstance(navHostController3);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, navHostController3, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 2);
                        gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                        objRememberedValue4 = homeScreenKt$HomeScreen$8$1;
                    }
                    MenuKt.IconButton(function1, (Function0) ((KFunction) objRememberedValue4), null, false, null, null, AlbumScreenKt.f326lambda$567951166, gapComposer2, 1572864);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    NavHostController navHostController4 = this.f$0;
                    boolean zChangedInstance5 = gapComposer3.changedInstance(navHostController4);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$3 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController4, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 0);
                        gapComposer3.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$3);
                        objRememberedValue5 = browseScreenKt$BrowseScreen$3$1$3;
                    }
                    Function0 function2 = (Function0) objRememberedValue5;
                    boolean zChangedInstance6 = gapComposer3.changedInstance(navHostController4);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue6 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, navHostController4, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 10);
                        gapComposer3.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                        objRememberedValue6 = homeScreenKt$HomeScreen$8$2;
                    }
                    MenuKt.IconButton(function2, (Function0) ((KFunction) objRememberedValue6), null, false, null, null, AlbumScreenKt.lambda$905043766, gapComposer3, 1572864);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    MenuKt.m1493TopAppBarGHTll3U(AlbumScreenKt.lambda$1929878894, null, Expect_jvmKt.rememberComposableLambda(-1856309588, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController, b3), gapComposer4), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer4, 390, 250);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    boolean zChangedInstance7 = gapComposer5.changedInstance(navHostController);
                    Object objRememberedValue7 = gapComposer5.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new MainActivity$$ExternalSyntheticLambda2(navHostController, b2);
                        gapComposer5.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function3 = (Function0) objRememberedValue7;
                    boolean zChangedInstance8 = gapComposer5.changedInstance(navHostController);
                    Object objRememberedValue8 = gapComposer5.rememberedValue();
                    if (zChangedInstance8 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 14);
                        gapComposer5.updateRememberedValue(objRememberedValue8);
                    }
                    MenuKt.IconButton(function3, (Function0) objRememberedValue8, null, false, null, null, AlbumScreenKt.f297lambda$1034653490, gapComposer5, 1572864);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    NavHostController navHostController5 = this.f$0;
                    boolean zChangedInstance9 = gapComposer6.changedInstance(navHostController5);
                    Object objRememberedValue9 = gapComposer6.rememberedValue();
                    if (zChangedInstance9 || objRememberedValue9 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$4 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController5, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 2);
                        gapComposer6.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$4);
                        objRememberedValue9 = browseScreenKt$BrowseScreen$3$1$4;
                    }
                    Function0 function4 = (Function0) objRememberedValue9;
                    boolean zChangedInstance10 = gapComposer6.changedInstance(navHostController5);
                    Object objRememberedValue10 = gapComposer6.rememberedValue();
                    if (zChangedInstance10 || objRememberedValue10 == neverEqualPolicy) {
                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$2 = new LoginScreenKt$LoginScreen$1$3$2$1(0, navHostController5, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 10);
                        gapComposer6.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$2);
                        objRememberedValue10 = loginScreenKt$LoginScreen$1$3$2$2;
                    }
                    MenuKt.IconButton(function4, (Function0) ((KFunction) objRememberedValue10), null, false, null, null, AlbumScreenKt.f335lambda$904858260, gapComposer6, 1572864);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    NavHostController navHostController6 = this.f$0;
                    boolean zChangedInstance11 = gapComposer7.changedInstance(navHostController6);
                    Object objRememberedValue11 = gapComposer7.rememberedValue();
                    if (zChangedInstance11 || objRememberedValue11 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$5 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController6, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 4);
                        gapComposer7.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$5);
                        objRememberedValue11 = browseScreenKt$BrowseScreen$3$1$5;
                    }
                    Function0 function5 = (Function0) objRememberedValue11;
                    boolean zChangedInstance12 = gapComposer7.changedInstance(navHostController6);
                    Object objRememberedValue12 = gapComposer7.rememberedValue();
                    if (zChangedInstance12 || objRememberedValue12 == neverEqualPolicy) {
                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$3 = new LoginScreenKt$LoginScreen$1$3$2$1(0, navHostController6, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 11);
                        gapComposer7.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$3);
                        objRememberedValue12 = loginScreenKt$LoginScreen$1$3$2$3;
                    }
                    MenuKt.IconButton(function5, (Function0) ((KFunction) objRememberedValue12), null, false, null, null, AlbumScreenKt.lambda$1229573561, gapComposer7, 1572864);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    NavHostController navHostController7 = this.f$0;
                    boolean zChangedInstance13 = gapComposer8.changedInstance(navHostController7);
                    Object objRememberedValue13 = gapComposer8.rememberedValue();
                    if (zChangedInstance13 || objRememberedValue13 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$6 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController7, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 5);
                        gapComposer8.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$6);
                        objRememberedValue13 = browseScreenKt$BrowseScreen$3$1$6;
                    }
                    Function0 function6 = (Function0) objRememberedValue13;
                    boolean zChangedInstance14 = gapComposer8.changedInstance(navHostController7);
                    Object objRememberedValue14 = gapComposer8.rememberedValue();
                    if (zChangedInstance14 || objRememberedValue14 == neverEqualPolicy) {
                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$4 = new LoginScreenKt$LoginScreen$1$3$2$1(0, navHostController7, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 13);
                        gapComposer8.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$4);
                        objRememberedValue14 = loginScreenKt$LoginScreen$1$3$2$4;
                    }
                    MenuKt.IconButton(function6, (Function0) ((KFunction) objRememberedValue14), null, false, null, null, AlbumScreenKt.lambda$1651009048, gapComposer8, 1572864);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    NavHostController navHostController8 = this.f$0;
                    boolean zChangedInstance15 = gapComposer9.changedInstance(navHostController8);
                    Object objRememberedValue15 = gapComposer9.rememberedValue();
                    if (zChangedInstance15 || objRememberedValue15 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$7 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController8, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 6);
                        gapComposer9.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$7);
                        objRememberedValue15 = browseScreenKt$BrowseScreen$3$1$7;
                    }
                    Function0 function7 = (Function0) objRememberedValue15;
                    boolean zChangedInstance16 = gapComposer9.changedInstance(navHostController8);
                    Object objRememberedValue16 = gapComposer9.rememberedValue();
                    if (zChangedInstance16 || objRememberedValue16 == neverEqualPolicy) {
                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$5 = new LoginScreenKt$LoginScreen$1$3$2$1(0, navHostController8, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 23);
                        gapComposer9.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$5);
                        objRememberedValue16 = loginScreenKt$LoginScreen$1$3$2$5;
                    }
                    MenuKt.IconButton(function7, (Function0) ((KFunction) objRememberedValue16), null, false, null, null, AlbumScreenKt.lambda$1345079618, gapComposer9, 1572864);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    NavHostController navHostController9 = this.f$0;
                    boolean zChangedInstance17 = gapComposer10.changedInstance(navHostController9);
                    Object objRememberedValue17 = gapComposer10.rememberedValue();
                    if (zChangedInstance17 || objRememberedValue17 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$8 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController9, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 7);
                        gapComposer10.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$8);
                        objRememberedValue17 = browseScreenKt$BrowseScreen$3$1$8;
                    }
                    Function0 function8 = (Function0) objRememberedValue17;
                    boolean zChangedInstance18 = gapComposer10.changedInstance(navHostController9);
                    Object objRememberedValue18 = gapComposer10.rememberedValue();
                    if (zChangedInstance18 || objRememberedValue18 == neverEqualPolicy) {
                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$6 = new LoginScreenKt$LoginScreen$1$3$2$1(0, navHostController9, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 24);
                        gapComposer10.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$6);
                        objRememberedValue18 = loginScreenKt$LoginScreen$1$3$2$6;
                    }
                    MenuKt.IconButton(function8, (Function0) ((KFunction) objRememberedValue18), null, false, null, null, ArtistItemsScreenKt.f345lambda$263324921, gapComposer10, 1572864);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    NavHostController navHostController10 = this.f$0;
                    boolean zChangedInstance19 = gapComposer11.changedInstance(navHostController10);
                    Object objRememberedValue19 = gapComposer11.rememberedValue();
                    if (zChangedInstance19 || objRememberedValue19 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$9 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController10, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 8);
                        gapComposer11.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$9);
                        objRememberedValue19 = browseScreenKt$BrowseScreen$3$1$9;
                    }
                    Function0 function9 = (Function0) objRememberedValue19;
                    boolean zChangedInstance20 = gapComposer11.changedInstance(navHostController10);
                    Object objRememberedValue20 = gapComposer11.rememberedValue();
                    if (zChangedInstance20 || objRememberedValue20 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$1 = new ArtistScreenKt$ArtistScreen$4$2$1(0, navHostController10, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 8);
                        gapComposer11.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$1);
                        objRememberedValue20 = artistScreenKt$ArtistScreen$4$2$1;
                    }
                    MenuKt.IconButton(function9, (Function0) ((KFunction) objRememberedValue20), null, false, null, null, ArtistItemsScreenKt.lambda$1994861503, gapComposer11, 1572864);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    NavHostController navHostController11 = this.f$0;
                    boolean zChangedInstance21 = gapComposer12.changedInstance(navHostController11);
                    Object objRememberedValue21 = gapComposer12.rememberedValue();
                    if (zChangedInstance21 || objRememberedValue21 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$10 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController11, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 9);
                        gapComposer12.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$10);
                        objRememberedValue21 = browseScreenKt$BrowseScreen$3$1$10;
                    }
                    Function0 function10 = (Function0) objRememberedValue21;
                    boolean zChangedInstance22 = gapComposer12.changedInstance(navHostController11);
                    Object objRememberedValue22 = gapComposer12.rememberedValue();
                    if (zChangedInstance22 || objRememberedValue22 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$2 = new ArtistScreenKt$ArtistScreen$4$2$1(0, navHostController11, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 0);
                        gapComposer12.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$2);
                        objRememberedValue22 = artistScreenKt$ArtistScreen$4$2$2;
                    }
                    MenuKt.IconButton(function10, (Function0) ((KFunction) objRememberedValue22), null, false, null, null, ArtistItemsScreenKt.lambda$27455767, gapComposer12, 1572864);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    NavHostController navHostController12 = this.f$0;
                    boolean zChangedInstance23 = gapComposer13.changedInstance(navHostController12);
                    Object objRememberedValue23 = gapComposer13.rememberedValue();
                    if (zChangedInstance23 || objRememberedValue23 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$11 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController12, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 10);
                        gapComposer13.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$11);
                        objRememberedValue23 = browseScreenKt$BrowseScreen$3$1$11;
                    }
                    Function0 function11 = (Function0) objRememberedValue23;
                    boolean zChangedInstance24 = gapComposer13.changedInstance(navHostController12);
                    Object objRememberedValue24 = gapComposer13.rememberedValue();
                    if (zChangedInstance24 || objRememberedValue24 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$3 = new ArtistScreenKt$ArtistScreen$4$2$1(0, navHostController12, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 22);
                        gapComposer13.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$3);
                        objRememberedValue24 = artistScreenKt$ArtistScreen$4$2$3;
                    }
                    MenuKt.IconButton(function11, (Function0) ((KFunction) objRememberedValue24), null, false, null, null, ArtistItemsScreenKt.f343lambda$2002008381, gapComposer13, 1572864);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    boolean zChangedInstance25 = gapComposer14.changedInstance(navHostController);
                    Object objRememberedValue25 = gapComposer14.rememberedValue();
                    if (zChangedInstance25 || objRememberedValue25 == neverEqualPolicy) {
                        objRememberedValue25 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, b3);
                        gapComposer14.updateRememberedValue(objRememberedValue25);
                    }
                    Function0 function12 = (Function0) objRememberedValue25;
                    boolean zChangedInstance26 = gapComposer14.changedInstance(navHostController);
                    Object objRememberedValue26 = gapComposer14.rememberedValue();
                    if (zChangedInstance26 || objRememberedValue26 == neverEqualPolicy) {
                        objRememberedValue26 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 5);
                        gapComposer14.updateRememberedValue(objRememberedValue26);
                    }
                    MenuKt.IconButton(function12, (Function0) objRememberedValue26, null, false, null, null, RecognitionHistoryScreenKt.lambda$555061016, gapComposer14, 1572864);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 14:
                ((Integer) obj2).getClass();
                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 15:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    MenuKt.m1493TopAppBarGHTll3U(RecognitionHistoryScreenKt.f416lambda$1556280156, null, Expect_jvmKt.rememberComposableLambda(-1083940510, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController, (byte) 16), gapComposer15), Expect_jvmKt.rememberComposableLambda(-763117799, new HomeScreenKt$$ExternalSyntheticLambda43(navHostController, b3), gapComposer15), CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer15, 3462, 242);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    boolean zChangedInstance27 = gapComposer16.changedInstance(navHostController);
                    Object objRememberedValue27 = gapComposer16.rememberedValue();
                    if (zChangedInstance27 || objRememberedValue27 == neverEqualPolicy) {
                        objRememberedValue27 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 6);
                        gapComposer16.updateRememberedValue(objRememberedValue27);
                    }
                    Function0 function13 = (Function0) objRememberedValue27;
                    boolean zChangedInstance28 = gapComposer16.changedInstance(navHostController);
                    Object objRememberedValue28 = gapComposer16.rememberedValue();
                    if (zChangedInstance28 || objRememberedValue28 == neverEqualPolicy) {
                        objRememberedValue28 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 7);
                        gapComposer16.updateRememberedValue(objRememberedValue28);
                    }
                    MenuKt.IconButton(function13, (Function0) objRememberedValue28, null, false, null, null, RecognitionHistoryScreenKt.f425lambda$932939772, gapComposer16, 1572864);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    boolean zChangedInstance29 = gapComposer17.changedInstance(navHostController);
                    Object objRememberedValue29 = gapComposer17.rememberedValue();
                    if (zChangedInstance29 || objRememberedValue29 == neverEqualPolicy) {
                        objRememberedValue29 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 9);
                        gapComposer17.updateRememberedValue(objRememberedValue29);
                    }
                    CardKt.IconButton((Function0) objRememberedValue29, null, false, null, null, LocalSearchScreenKt.lambda$1822886447, gapComposer17, 1572864, 62);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    boolean zChangedInstance30 = gapComposer18.changedInstance(navHostController);
                    Object objRememberedValue30 = gapComposer18.rememberedValue();
                    if (zChangedInstance30 || objRememberedValue30 == neverEqualPolicy) {
                        objRememberedValue30 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 12);
                        gapComposer18.updateRememberedValue(objRememberedValue30);
                    }
                    CardKt.IconButton((Function0) objRememberedValue30, null, false, null, null, LocalSearchScreenKt.lambda$1397505380, gapComposer18, 1572864, 62);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    NavHostController navHostController13 = this.f$0;
                    boolean zChangedInstance31 = gapComposer19.changedInstance(navHostController13);
                    Object objRememberedValue31 = gapComposer19.rememberedValue();
                    if (zChangedInstance31 || objRememberedValue31 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$12 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController13, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 11);
                        gapComposer19.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$12);
                        objRememberedValue31 = browseScreenKt$BrowseScreen$3$1$12;
                    }
                    Function0 function14 = (Function0) objRememberedValue31;
                    boolean zChangedInstance32 = gapComposer19.changedInstance(navHostController13);
                    Object objRememberedValue32 = gapComposer19.rememberedValue();
                    if (zChangedInstance32 || objRememberedValue32 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass1 = new HazeEffectNode.AnonymousClass1(0, navHostController13, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 2);
                        gapComposer19.updateRememberedValue(anonymousClass1);
                        objRememberedValue32 = anonymousClass1;
                    }
                    MenuKt.IconButton(function14, (Function0) ((KFunction) objRememberedValue32), null, false, null, null, AiSettingsKt.f469lambda$1348719338, gapComposer19, 1572864);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 20:
                ((Integer) obj2).getClass();
                AboutScreenKt.AboutScreen(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 21:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    boolean zChangedInstance33 = gapComposer20.changedInstance(navHostController);
                    Object objRememberedValue33 = gapComposer20.rememberedValue();
                    if (zChangedInstance33 || objRememberedValue33 == neverEqualPolicy) {
                        objRememberedValue33 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, b2);
                        gapComposer20.updateRememberedValue(objRememberedValue33);
                    }
                    CardKt.IconButton((Function0) objRememberedValue33, null, false, null, null, AiSettingsKt.lambda$513898058, gapComposer20, 1572864, 62);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 22:
                ((Integer) obj2).getClass();
                AiSettingsKt.AiSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 23:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    NavHostController navHostController14 = this.f$0;
                    boolean zChangedInstance34 = gapComposer21.changedInstance(navHostController14);
                    Object objRememberedValue34 = gapComposer21.rememberedValue();
                    if (zChangedInstance34 || objRememberedValue34 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$13 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController14, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 12);
                        gapComposer21.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$13);
                        objRememberedValue34 = browseScreenKt$BrowseScreen$3$1$13;
                    }
                    Function0 function15 = (Function0) objRememberedValue34;
                    boolean zChangedInstance35 = gapComposer21.changedInstance(navHostController14);
                    Object objRememberedValue35 = gapComposer21.rememberedValue();
                    if (zChangedInstance35 || objRememberedValue35 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass2 = new HazeEffectNode.AnonymousClass1(0, navHostController14, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 3);
                        gapComposer21.updateRememberedValue(anonymousClass2);
                        objRememberedValue35 = anonymousClass2;
                    }
                    MenuKt.IconButton(function15, (Function0) ((KFunction) objRememberedValue35), null, false, null, null, AiSettingsKt.lambda$832661446, gapComposer21, 1572864);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 24:
                ((Integer) obj2).getClass();
                AiSettingsKt.AndroidAutoSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 25:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    NavHostController navHostController15 = this.f$0;
                    boolean zChangedInstance36 = gapComposer22.changedInstance(navHostController15);
                    Object objRememberedValue36 = gapComposer22.rememberedValue();
                    if (zChangedInstance36 || objRememberedValue36 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$14 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController15, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 13);
                        gapComposer22.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$14);
                        objRememberedValue36 = browseScreenKt$BrowseScreen$3$1$14;
                    }
                    Function0 function16 = (Function0) objRememberedValue36;
                    boolean zChangedInstance37 = gapComposer22.changedInstance(navHostController15);
                    Object objRememberedValue37 = gapComposer22.rememberedValue();
                    if (zChangedInstance37 || objRememberedValue37 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass3 = new HazeEffectNode.AnonymousClass1(0, navHostController15, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 4);
                        gapComposer22.updateRememberedValue(anonymousClass3);
                        objRememberedValue37 = anonymousClass3;
                    }
                    MenuKt.IconButton(function16, (Function0) ((KFunction) objRememberedValue37), null, false, null, null, AiSettingsKt.f533lambda$2141510846, gapComposer22, 1572864);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 3) != 2)) {
                    NavHostController navHostController16 = this.f$0;
                    boolean zChangedInstance38 = gapComposer23.changedInstance(navHostController16);
                    Object objRememberedValue38 = gapComposer23.rememberedValue();
                    if (zChangedInstance38 || objRememberedValue38 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$15 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController16, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 14);
                        gapComposer23.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$15);
                        objRememberedValue38 = browseScreenKt$BrowseScreen$3$1$15;
                    }
                    Function0 function17 = (Function0) objRememberedValue38;
                    boolean zChangedInstance39 = gapComposer23.changedInstance(navHostController16);
                    Object objRememberedValue39 = gapComposer23.rememberedValue();
                    if (zChangedInstance39 || objRememberedValue39 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass4 = new HazeEffectNode.AnonymousClass1(0, navHostController16, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 5);
                        gapComposer23.updateRememberedValue(anonymousClass4);
                        objRememberedValue39 = anonymousClass4;
                    }
                    MenuKt.IconButton(function17, (Function0) ((KFunction) objRememberedValue39), null, false, null, null, AiSettingsKt.f474lambda$14070390, gapComposer23, 1572864);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 27:
                return invoke$com$metrolist$music$ui$screens$settings$ContentSettingsKt$$ExternalSyntheticLambda75(obj, obj2);
            case 28:
                ((Integer) obj2).getClass();
                AiSettingsKt.ContentSettings(navHostController, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            default:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 3) != 2)) {
                    NavHostController navHostController17 = this.f$0;
                    boolean zChangedInstance40 = gapComposer24.changedInstance(navHostController17);
                    Object objRememberedValue40 = gapComposer24.rememberedValue();
                    if (zChangedInstance40 || objRememberedValue40 == neverEqualPolicy) {
                        BrowseScreenKt$BrowseScreen$3$1$1 browseScreenKt$BrowseScreen$3$1$16 = new BrowseScreenKt$BrowseScreen$3$1$1(0, navHostController17, NavHostController.class, "navigateUp", "navigateUp()Z", 8, (byte) 16);
                        gapComposer24.updateRememberedValue(browseScreenKt$BrowseScreen$3$1$16);
                        objRememberedValue40 = browseScreenKt$BrowseScreen$3$1$16;
                    }
                    Function0 function18 = (Function0) objRememberedValue40;
                    boolean zChangedInstance41 = gapComposer24.changedInstance(navHostController17);
                    Object objRememberedValue41 = gapComposer24.rememberedValue();
                    if (zChangedInstance41 || objRememberedValue41 == neverEqualPolicy) {
                        HazeEffectNode.AnonymousClass1 anonymousClass5 = new HazeEffectNode.AnonymousClass1(0, navHostController17, AppBarKt.class, "backToMain", "backToMain(Landroidx/navigation/NavController;)V", 1, (byte) 7);
                        gapComposer24.updateRememberedValue(anonymousClass5);
                        objRememberedValue41 = anonymousClass5;
                    }
                    MenuKt.IconButton(function18, (Function0) ((KFunction) objRememberedValue41), null, false, null, null, AiSettingsKt.f585lambda$964305174, gapComposer24, 1572864);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda3(NavHostController navHostController, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
    }
}
