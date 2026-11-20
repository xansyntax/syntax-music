package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.YouTubeAlbumMenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccountScreenKt$AccountScreen$1$1$8$1$1 implements Function0 {
    public final /* synthetic */ HapticFeedback $haptic;
    public final /* synthetic */ AlbumItem $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AccountScreenKt$AccountScreen$1$1$8$1$1(HapticFeedback hapticFeedback, MenuState menuState, AlbumItem albumItem, byte b) {
        this.$r8$classId = b;
        this.$haptic = hapticFeedback;
        this.$menuState = menuState;
        this.$item = albumItem;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        final AlbumItem albumItem = this.$item;
        final MenuState menuState = this.$menuState;
        HapticFeedback hapticFeedback = this.$haptic;
        final byte b2 = 1;
        final byte b3 = 0;
        switch (b) {
            case 0:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, -327044126, new Function3() { // from class: com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$8$1$1.1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b4 = b3;
                        Unit unit2 = Unit.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        AlbumItem albumItem2 = albumItem;
                        switch (b4) {
                            case 0:
                                Composer composer = (Composer) obj2;
                                int iIntValue = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer = (GapComposer) composer;
                                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    MenuState menuState2 = menuState;
                                    boolean zChanged = gapComposer.changed(menuState2);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                        gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                                        objRememberedValue = homeScreenKt$HomeScreen$8$1;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue), gapComposer, 0);
                                }
                                break;
                            case 1:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue2 = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    MenuState menuState3 = menuState;
                                    boolean zChanged2 = gapComposer2.changed(menuState3);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 5);
                                        gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                                        objRememberedValue2 = homeScreenKt$HomeScreen$8$2;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue2), gapComposer2, 0);
                                }
                                break;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue3 = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    MenuState menuState4 = menuState;
                                    boolean zChanged3 = gapComposer3.changed(menuState4);
                                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 12);
                                        gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                        objRememberedValue3 = loginScreenKt$LoginScreen$1$3$2$1;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue3), gapComposer3, 0);
                                }
                                break;
                        }
                        return unit2;
                    }
                }));
                break;
            case 1:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, -463891721, new Function3() { // from class: com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$8$1$1.1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b4 = b2;
                        Unit unit2 = Unit.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        AlbumItem albumItem2 = albumItem;
                        switch (b4) {
                            case 0:
                                Composer composer = (Composer) obj2;
                                int iIntValue = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer = (GapComposer) composer;
                                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    MenuState menuState2 = menuState;
                                    boolean zChanged = gapComposer.changed(menuState2);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                        gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                                        objRememberedValue = homeScreenKt$HomeScreen$8$1;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue), gapComposer, 0);
                                }
                                break;
                            case 1:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue2 = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    MenuState menuState3 = menuState;
                                    boolean zChanged2 = gapComposer2.changed(menuState3);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 5);
                                        gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                                        objRememberedValue2 = homeScreenKt$HomeScreen$8$2;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue2), gapComposer2, 0);
                                }
                                break;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue3 = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    MenuState menuState4 = menuState;
                                    boolean zChanged3 = gapComposer3.changed(menuState4);
                                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 12);
                                        gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                        objRememberedValue3 = loginScreenKt$LoginScreen$1$3$2$1;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue3), gapComposer3, 0);
                                }
                                break;
                        }
                        return unit2;
                    }
                }));
                break;
            default:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                final byte b4 = 2;
                menuState.show(new ComposableLambdaImpl(true, -2027138563, new Function3() { // from class: com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$8$1$1.1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b5 = b4;
                        Unit unit2 = Unit.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        AlbumItem albumItem2 = albumItem;
                        switch (b5) {
                            case 0:
                                Composer composer = (Composer) obj2;
                                int iIntValue = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer = (GapComposer) composer;
                                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    MenuState menuState2 = menuState;
                                    boolean zChanged = gapComposer.changed(menuState2);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                        gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                                        objRememberedValue = homeScreenKt$HomeScreen$8$1;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue), gapComposer, 0);
                                }
                                break;
                            case 1:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue2 = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    MenuState menuState3 = menuState;
                                    boolean zChanged2 = gapComposer2.changed(menuState3);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 5);
                                        gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                                        objRememberedValue2 = homeScreenKt$HomeScreen$8$2;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue2), gapComposer2, 0);
                                }
                                break;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue3 = ((Number) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    MenuState menuState4 = menuState;
                                    boolean zChanged3 = gapComposer3.changed(menuState4);
                                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 12);
                                        gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                        objRememberedValue3 = loginScreenKt$LoginScreen$1$3$2$1;
                                    }
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue3), gapComposer3, 0);
                                }
                                break;
                        }
                        return unit2;
                    }
                }));
                break;
        }
        return unit;
    }
}
