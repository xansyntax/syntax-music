package com.metrolist.music.ui.screens.library;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$4$2$1;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6 implements Function3 {
    public final /* synthetic */ LocalItem $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(LocalItem localItem, MenuState menuState, byte b) {
        this.$r8$classId = b;
        this.$item = localItem;
        this.$menuState = menuState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        final MenuState menuState = this.$menuState;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        final LocalItem localItem = this.$item;
        final byte b2 = 1;
        boolean z = false;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(localItem);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        final byte b3 = z ? (byte) 1 : (byte) 0;
                        objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                LocalItem localItem2 = localItem;
                                MenuState menuState2 = menuState;
                                switch (b4) {
                                    case 0:
                                        menuState2.show(new ComposableLambdaImpl(true, 84536029, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState2, (byte) 5)));
                                        break;
                                    default:
                                        menuState2.show(new ComposableLambdaImpl(true, -1739043682, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState2, (byte) 2)));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, LibraryScreenKt.f367lambda$1098905367, gapComposer, 1572864, 62);
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
                    Album album = (Album) localItem;
                    MenuState menuState2 = this.$menuState;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$1 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 25);
                        gapComposer2.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$1);
                        objRememberedValue2 = artistScreenKt$ArtistScreen$4$2$1;
                    }
                    AlbumMenuKt.AlbumMenu(album, (Function0) ((KFunction) objRememberedValue2), gapComposer2, 0);
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
                    Album album2 = (Album) localItem;
                    MenuState menuState3 = this.$menuState;
                    boolean zChanged3 = gapComposer3.changed(menuState3);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$2 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 26);
                        gapComposer3.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$2);
                        objRememberedValue3 = artistScreenKt$ArtistScreen$4$2$2;
                    }
                    AlbumMenuKt.AlbumMenu(album2, (Function0) ((KFunction) objRememberedValue3), gapComposer3, 0);
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
                    boolean zChanged4 = gapComposer4.changed(menuState) | gapComposer4.changedInstance(localItem);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                LocalItem localItem2 = localItem;
                                MenuState menuState4 = menuState;
                                switch (b4) {
                                    case 0:
                                        menuState4.show(new ComposableLambdaImpl(true, 84536029, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState4, (byte) 5)));
                                        break;
                                    default:
                                        menuState4.show(new ComposableLambdaImpl(true, -1739043682, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState4, (byte) 2)));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.IconButton((Function0) objRememberedValue4, null, false, null, null, LibraryScreenKt.lambda$1372482218, gapComposer4, 1572864, 62);
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
                    Song song = (Song) localItem;
                    MenuState menuState4 = this.$menuState;
                    boolean zChanged5 = gapComposer5.changed(menuState4);
                    Object objRememberedValue5 = gapComposer5.rememberedValue();
                    if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 28);
                        gapComposer5.updateRememberedValue(objRememberedValue5);
                    }
                    SongMenuKt.SongMenu(song, null, null, null, (Function0) ((KFunction) objRememberedValue5), false, gapComposer5, 0, 46);
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
                    Song song2 = (Song) localItem;
                    MenuState menuState5 = this.$menuState;
                    boolean zChanged6 = gapComposer6.changed(menuState5);
                    Object objRememberedValue6 = gapComposer6.rememberedValue();
                    if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState5, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 29);
                        gapComposer6.updateRememberedValue(objRememberedValue6);
                    }
                    SongMenuKt.SongMenu(song2, null, null, null, (Function0) ((KFunction) objRememberedValue6), false, gapComposer6, 0, 46);
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
                    Song song3 = (Song) localItem;
                    MenuState menuState6 = this.$menuState;
                    boolean zChanged7 = gapComposer7.changed(menuState6);
                    Object objRememberedValue7 = gapComposer7.rememberedValue();
                    if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState6, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 4);
                        gapComposer7.updateRememberedValue(objRememberedValue7);
                    }
                    SongMenuKt.SongMenu(song3, null, null, null, (Function0) ((KFunction) objRememberedValue7), false, gapComposer7, 0, 46);
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
                    Album album3 = (Album) localItem;
                    MenuState menuState7 = this.$menuState;
                    boolean zChanged8 = gapComposer8.changed(menuState7);
                    Object objRememberedValue8 = gapComposer8.rememberedValue();
                    if (zChanged8 || objRememberedValue8 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState7, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 6);
                        gapComposer8.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                        objRememberedValue8 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                    }
                    AlbumMenuKt.AlbumMenu(album3, (Function0) ((KFunction) objRememberedValue8), gapComposer8, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(MenuState menuState, LocalItem localItem, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$item = localItem;
    }
}
