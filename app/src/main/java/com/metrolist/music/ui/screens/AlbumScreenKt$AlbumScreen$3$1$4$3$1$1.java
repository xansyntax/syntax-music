package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.SongMenuKt;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$4$2$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumScreenKt$AlbumScreen$3$1$4$3$1$1 implements Function0 {
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Song $song;

    public /* synthetic */ AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(MenuState menuState, Song song, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$song = song;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Song song = this.$song;
        MenuState menuState = this.$menuState;
        switch (b) {
            case 0:
                menuState.show(new ComposableLambdaImpl(true, -2022751994, new AnonymousClass1(song, menuState, (byte) 0)));
                break;
            case 1:
                menuState.show(new ComposableLambdaImpl(true, -224764253, new AnonymousClass1(song, menuState, (byte) 3)));
                break;
            case 2:
                menuState.show(new ComposableLambdaImpl(true, -1843444705, new AnonymousClass1(song, menuState, (byte) 6)));
                break;
            case 3:
                menuState.show(new ComposableLambdaImpl(true, -1339622870, new AnonymousClass1(song, menuState, (byte) 8)));
                break;
            case 4:
                menuState.show(new ComposableLambdaImpl(true, -52167483, new AnonymousClass1(song, menuState, (byte) 10)));
                break;
            case 5:
                menuState.show(new ComposableLambdaImpl(true, -290216385, new AnonymousClass1(song, menuState, (byte) 12)));
                break;
            case 6:
                menuState.show(new ComposableLambdaImpl(true, 1463200198, new AnonymousClass1(song, menuState, (byte) 13)));
                break;
            default:
                menuState.show(new ComposableLambdaImpl(true, -673005749, new AnonymousClass1(song, menuState, (byte) 14)));
                break;
        }
        return unit;
    }

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$3$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Function3 {
        public final /* synthetic */ MenuState $menuState;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Song $song;

        public /* synthetic */ AnonymousClass1(Song song, MenuState menuState, byte b) {
            this.$r8$classId = b;
            this.$song = song;
            this.$menuState = menuState;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            byte b = this.$r8$classId;
            MenuState menuState = this.$menuState;
            Song song = this.$song;
            Unit unit = Unit.INSTANCE;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            byte b2 = 1;
            switch (b) {
                case 0:
                    Composer composer = (Composer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer = (GapComposer) composer;
                    if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        MenuState menuState2 = this.$menuState;
                        boolean zChanged = gapComposer.changed(menuState2);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 4);
                            gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                            objRememberedValue = homeScreenKt$HomeScreen$8$1;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue), false, gapComposer, 0, 46);
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
                        MenuState menuState3 = this.$menuState;
                        boolean zChanged2 = gapComposer2.changed(menuState3);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 14);
                            gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                            objRememberedValue2 = loginScreenKt$LoginScreen$1$3$2$1;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue2), false, gapComposer2, 0, 46);
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
                        MenuState menuState4 = this.$menuState;
                        boolean zChanged3 = gapComposer3.changed(menuState4);
                        Object objRememberedValue3 = gapComposer3.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                            ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$1 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 9);
                            gapComposer3.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$1);
                            objRememberedValue3 = artistScreenKt$ArtistScreen$4$2$1;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue3), false, gapComposer3, 0, 46);
                    }
                    break;
                case 3:
                    Composer composer4 = (Composer) obj2;
                    int iIntValue4 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer4 = (GapComposer) composer4;
                    if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        MenuState menuState5 = this.$menuState;
                        boolean zChanged4 = gapComposer4.changed(menuState5);
                        Object objRememberedValue4 = gapComposer4.rememberedValue();
                        if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                            ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$2 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState5, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 10);
                            gapComposer4.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$2);
                            objRememberedValue4 = artistScreenKt$ArtistScreen$4$2$2;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue4), false, gapComposer4, 0, 46);
                    }
                    break;
                case 4:
                    Composer composer5 = (Composer) obj2;
                    int iIntValue5 = ((Number) obj3).intValue();
                    ((RowScope) obj).getClass();
                    GapComposer gapComposer5 = (GapComposer) composer5;
                    if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                        gapComposer5.skipToGroupEnd();
                    } else {
                        boolean zChanged5 = gapComposer5.changed(menuState) | gapComposer5.changed(song);
                        Object objRememberedValue5 = gapComposer5.rememberedValue();
                        if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(menuState, song, b2);
                            gapComposer5.updateRememberedValue(objRememberedValue5);
                        }
                        CardKt.IconButton((Function0) objRememberedValue5, null, false, null, null, ArtistItemsScreenKt.f346lambda$742881513, gapComposer5, 1572864, 62);
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
                        MenuState menuState6 = this.$menuState;
                        boolean zChanged6 = gapComposer6.changed(menuState6);
                        Object objRememberedValue6 = gapComposer6.rememberedValue();
                        if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                            ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$3 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState6, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 20);
                            gapComposer6.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$3);
                            objRememberedValue6 = artistScreenKt$ArtistScreen$4$2$3;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue6), false, gapComposer6, 0, 46);
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
                        MenuState menuState7 = this.$menuState;
                        boolean zChanged7 = gapComposer7.changed(menuState7);
                        Object objRememberedValue7 = gapComposer7.rememberedValue();
                        if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                            ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$4 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState7, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 21);
                            gapComposer7.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$4);
                            objRememberedValue7 = artistScreenKt$ArtistScreen$4$2$4;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue7), false, gapComposer7, 0, 46);
                    }
                    break;
                case 7:
                    Composer composer8 = (Composer) obj2;
                    int iIntValue8 = ((Number) obj3).intValue();
                    ((RowScope) obj).getClass();
                    GapComposer gapComposer8 = (GapComposer) composer8;
                    if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                        gapComposer8.skipToGroupEnd();
                    } else {
                        boolean zChanged8 = gapComposer8.changed(menuState) | gapComposer8.changed(song);
                        Object objRememberedValue8 = gapComposer8.rememberedValue();
                        if (zChanged8 || objRememberedValue8 == neverEqualPolicy) {
                            objRememberedValue8 = new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(menuState, song, (byte) 2);
                            gapComposer8.updateRememberedValue(objRememberedValue8);
                        }
                        CardKt.IconButton((Function0) objRememberedValue8, null, false, null, null, ArtistItemsScreenKt.f350lambda$913587669, gapComposer8, 1572864, 62);
                    }
                    break;
                case 8:
                    Composer composer9 = (Composer) obj2;
                    int iIntValue9 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer9 = (GapComposer) composer9;
                    if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                        gapComposer9.skipToGroupEnd();
                    } else {
                        MenuState menuState8 = this.$menuState;
                        boolean zChanged9 = gapComposer9.changed(menuState8);
                        Object objRememberedValue9 = gapComposer9.rememberedValue();
                        if (zChanged9 || objRememberedValue9 == neverEqualPolicy) {
                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState8, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 8);
                            gapComposer9.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                            objRememberedValue9 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue9), false, gapComposer9, 0, 46);
                    }
                    break;
                case 9:
                    Composer composer10 = (Composer) obj2;
                    int iIntValue10 = ((Number) obj3).intValue();
                    ((RowScope) obj).getClass();
                    GapComposer gapComposer10 = (GapComposer) composer10;
                    if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                        gapComposer10.skipToGroupEnd();
                    } else {
                        boolean zChanged10 = gapComposer10.changed(menuState) | gapComposer10.changed(song);
                        Object objRememberedValue10 = gapComposer10.rememberedValue();
                        if (zChanged10 || objRememberedValue10 == neverEqualPolicy) {
                            objRememberedValue10 = new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(menuState, song, (byte) 3);
                            gapComposer10.updateRememberedValue(objRememberedValue10);
                        }
                        CardKt.IconButton((Function0) objRememberedValue10, null, false, null, null, LibraryScreenKt.lambda$623940510, gapComposer10, 1572864, 62);
                    }
                    break;
                case 10:
                    Composer composer11 = (Composer) obj2;
                    int iIntValue11 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer11 = (GapComposer) composer11;
                    if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                        gapComposer11.skipToGroupEnd();
                    } else {
                        MenuState menuState9 = this.$menuState;
                        boolean zChanged11 = gapComposer11.changed(menuState9);
                        Object objRememberedValue11 = gapComposer11.rememberedValue();
                        if (zChanged11 || objRememberedValue11 == neverEqualPolicy) {
                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$2 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState9, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 9);
                            gapComposer11.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$2);
                            objRememberedValue11 = autoPlaylistScreenKt$AutoPlaylistScreen$12$2;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue11), false, gapComposer11, 0, 46);
                    }
                    break;
                case 11:
                    Composer composer12 = (Composer) obj2;
                    int iIntValue12 = ((Number) obj3).intValue();
                    ((RowScope) obj).getClass();
                    GapComposer gapComposer12 = (GapComposer) composer12;
                    if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                        gapComposer12.skipToGroupEnd();
                    } else {
                        boolean zChanged12 = gapComposer12.changed(menuState) | gapComposer12.changed(song);
                        Object objRememberedValue12 = gapComposer12.rememberedValue();
                        if (zChanged12 || objRememberedValue12 == neverEqualPolicy) {
                            objRememberedValue12 = new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(menuState, song, (byte) 4);
                            gapComposer12.updateRememberedValue(objRememberedValue12);
                        }
                        CardKt.IconButton((Function0) objRememberedValue12, null, false, null, null, LibraryScreenKt.f379lambda$68880943, gapComposer12, 1572864, 62);
                    }
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    Composer composer13 = (Composer) obj2;
                    int iIntValue13 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer13 = (GapComposer) composer13;
                    if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                        gapComposer13.skipToGroupEnd();
                    } else {
                        MenuState menuState10 = this.$menuState;
                        boolean zChanged13 = gapComposer13.changed(menuState10);
                        Object objRememberedValue13 = gapComposer13.rememberedValue();
                        if (zChanged13 || objRememberedValue13 == neverEqualPolicy) {
                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$3 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState10, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 10);
                            gapComposer13.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$3);
                            objRememberedValue13 = autoPlaylistScreenKt$AutoPlaylistScreen$12$3;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue13), false, gapComposer13, 0, 46);
                    }
                    break;
                case 13:
                    Composer composer14 = (Composer) obj2;
                    int iIntValue14 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer14 = (GapComposer) composer14;
                    if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                        gapComposer14.skipToGroupEnd();
                    } else {
                        MenuState menuState11 = this.$menuState;
                        boolean zChanged14 = gapComposer14.changed(menuState11);
                        Object objRememberedValue14 = gapComposer14.rememberedValue();
                        if (zChanged14 || objRememberedValue14 == neverEqualPolicy) {
                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$4 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState11, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 12);
                            gapComposer14.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$4);
                            objRememberedValue14 = autoPlaylistScreenKt$AutoPlaylistScreen$12$4;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue14), true, gapComposer14, 196608, 14);
                    }
                    break;
                default:
                    Composer composer15 = (Composer) obj2;
                    int iIntValue15 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer15 = (GapComposer) composer15;
                    if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                        gapComposer15.skipToGroupEnd();
                    } else {
                        MenuState menuState12 = this.$menuState;
                        boolean zChanged15 = gapComposer15.changed(menuState12);
                        Object objRememberedValue15 = gapComposer15.rememberedValue();
                        if (zChanged15 || objRememberedValue15 == neverEqualPolicy) {
                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$5 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState12, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 21);
                            gapComposer15.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$5);
                            objRememberedValue15 = autoPlaylistScreenKt$AutoPlaylistScreen$12$5;
                        }
                        SongMenuKt.SongMenu(this.$song, null, null, null, (Function0) ((KFunction) objRememberedValue15), false, gapComposer15, 0, 46);
                    }
                    break;
            }
            return unit;
        }

        public /* synthetic */ AnonymousClass1(MenuState menuState, Song song, byte b) {
            this.$r8$classId = b;
            this.$menuState = menuState;
            this.$song = song;
        }
    }
}
