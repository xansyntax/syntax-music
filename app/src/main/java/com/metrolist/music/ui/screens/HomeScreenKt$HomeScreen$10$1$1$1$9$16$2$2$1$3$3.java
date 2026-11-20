package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3 implements Function3 {
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongItem $song;

    public /* synthetic */ HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3(SongItem songItem, MenuState menuState, byte b) {
        this.$r8$classId = b;
        this.$song = songItem;
        this.$menuState = menuState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        MenuState menuState = this.$menuState;
        SongItem songItem = this.$song;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        boolean z = false;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(songItem);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3$1$1(menuState, songItem, z ? (byte) 1 : (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, AlbumScreenKt.f325lambda$511293314, gapComposer, 1572864, 62);
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
                    MenuState menuState2 = this.$menuState;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 11);
                        gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                        objRememberedValue2 = homeScreenKt$HomeScreen$8$1;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.$song, (Function0) ((KFunction) objRememberedValue2), null, gapComposer2, 0, 4);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    MenuState menuState3 = this.$menuState;
                    boolean zChanged3 = gapComposer3.changed(menuState3);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 12);
                        gapComposer3.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                        objRememberedValue3 = homeScreenKt$HomeScreen$8$2;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.$song, (Function0) ((KFunction) objRememberedValue3), null, gapComposer3, 0, 4);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    boolean zChanged4 = gapComposer4.changed(menuState) | gapComposer4.changedInstance(songItem);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3$1$1(menuState, songItem, b2);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.IconButton((Function0) objRememberedValue4, null, false, null, null, AlbumScreenKt.f315lambda$191138464, gapComposer4, 1572864, 62);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    MenuState menuState4 = this.$menuState;
                    boolean zChanged5 = gapComposer5.changed(menuState4);
                    Object objRememberedValue5 = gapComposer5.rememberedValue();
                    if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$3 = new HomeScreenKt$HomeScreen$8$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 13);
                        gapComposer5.updateRememberedValue(homeScreenKt$HomeScreen$8$3);
                        objRememberedValue5 = homeScreenKt$HomeScreen$8$3;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.$song, (Function0) ((KFunction) objRememberedValue5), null, gapComposer5, 0, 4);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    MenuState menuState5 = this.$menuState;
                    boolean zChanged6 = gapComposer6.changed(menuState5);
                    Object objRememberedValue6 = gapComposer6.rememberedValue();
                    if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$4 = new HomeScreenKt$HomeScreen$8$1(0, menuState5, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 20);
                        gapComposer6.updateRememberedValue(homeScreenKt$HomeScreen$8$4);
                        objRememberedValue6 = homeScreenKt$HomeScreen$8$4;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.$song, (Function0) ((KFunction) objRememberedValue6), null, gapComposer6, 0, 4);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    MenuState menuState6 = this.$menuState;
                    boolean zChanged7 = gapComposer7.changed(menuState6);
                    Object objRememberedValue7 = gapComposer7.rememberedValue();
                    if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$5 = new HomeScreenKt$HomeScreen$8$1(0, menuState6, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 21);
                        gapComposer7.updateRememberedValue(homeScreenKt$HomeScreen$8$5);
                        objRememberedValue7 = homeScreenKt$HomeScreen$8$5;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.$song, (Function0) ((KFunction) objRememberedValue7), null, gapComposer7, 0, 4);
                }
                break;
            default:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    MenuState menuState7 = this.$menuState;
                    boolean zChanged8 = gapComposer8.changed(menuState7);
                    Object objRememberedValue8 = gapComposer8.rememberedValue();
                    if (zChanged8 || objRememberedValue8 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState7, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 19);
                        gapComposer8.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                        objRememberedValue8 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.$song, (Function0) ((KFunction) objRememberedValue8), null, gapComposer8, 0, 4);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3(MenuState menuState, SongItem songItem, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$song = songItem;
    }
}
