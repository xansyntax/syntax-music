package com.metrolist.music.ui.screens.library;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$4$2$1;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3 implements Function3 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ LocalItem $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(LocalItem localItem, CoroutineScope coroutineScope, MenuState menuState, byte b) {
        this.$r8$classId = b;
        this.$item = localItem;
        this.$coroutineScope = coroutineScope;
        this.$menuState = menuState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        final MenuState menuState = this.$menuState;
        final CoroutineScope coroutineScope = this.$coroutineScope;
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
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(localItem) | gapComposer.changedInstance(coroutineScope);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        final byte b3 = z ? (byte) 1 : (byte) 0;
                        objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                CoroutineScope coroutineScope2 = coroutineScope;
                                LocalItem localItem2 = localItem;
                                MenuState menuState2 = menuState;
                                switch (b4) {
                                    case 0:
                                        menuState2.show(new ComposableLambdaImpl(true, 1673719112, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState2, (byte) 2)));
                                        break;
                                    default:
                                        menuState2.show(new ComposableLambdaImpl(true, 2053796996, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState2, (byte) 4)));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, LibraryScreenKt.f378lambda$653225796, gapComposer, 1572864, 62);
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
                    Playlist playlist = (Playlist) localItem;
                    MenuState menuState2 = this.$menuState;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$1 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 24);
                        gapComposer2.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$1);
                        objRememberedValue2 = artistScreenKt$ArtistScreen$4$2$1;
                    }
                    AlbumMenuKt.PlaylistMenu(playlist, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue2), null, null, null, gapComposer2, 0);
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
                    Playlist playlist2 = (Playlist) localItem;
                    MenuState menuState3 = this.$menuState;
                    boolean zChanged3 = gapComposer3.changed(menuState3);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$2 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 27);
                        gapComposer3.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$2);
                        objRememberedValue3 = artistScreenKt$ArtistScreen$4$2$2;
                    }
                    AlbumMenuKt.PlaylistMenu(playlist2, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue3), null, null, null, gapComposer3, 0);
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
                    Artist artist = (Artist) localItem;
                    MenuState menuState4 = this.$menuState;
                    boolean zChanged4 = gapComposer4.changed(menuState4);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                        gapComposer4.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                        objRememberedValue4 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                    }
                    AlbumMenuKt.ArtistMenu(artist, coroutineScope, (Function0) ((KFunction) objRememberedValue4), gapComposer4, 0);
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
                    Artist artist2 = (Artist) localItem;
                    MenuState menuState5 = this.$menuState;
                    boolean zChanged5 = gapComposer5.changed(menuState5);
                    Object objRememberedValue5 = gapComposer5.rememberedValue();
                    if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$2 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState5, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 2);
                        gapComposer5.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$2);
                        objRememberedValue5 = autoPlaylistScreenKt$AutoPlaylistScreen$12$2;
                    }
                    AlbumMenuKt.ArtistMenu(artist2, coroutineScope, (Function0) ((KFunction) objRememberedValue5), gapComposer5, 0);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    boolean zChanged6 = gapComposer6.changed(menuState) | gapComposer6.changedInstance(localItem) | gapComposer6.changedInstance(coroutineScope);
                    Object objRememberedValue6 = gapComposer6.rememberedValue();
                    if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                CoroutineScope coroutineScope2 = coroutineScope;
                                LocalItem localItem2 = localItem;
                                MenuState menuState6 = menuState;
                                switch (b4) {
                                    case 0:
                                        menuState6.show(new ComposableLambdaImpl(true, 1673719112, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState6, (byte) 2)));
                                        break;
                                    default:
                                        menuState6.show(new ComposableLambdaImpl(true, 2053796996, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState6, (byte) 4)));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer6.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.IconButton((Function0) objRememberedValue6, null, false, null, null, LibraryScreenKt.f375lambda$273147912, gapComposer6, 1572864, 62);
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
                    Playlist playlist3 = (Playlist) localItem;
                    MenuState menuState6 = this.$menuState;
                    boolean zChanged7 = gapComposer7.changed(menuState6);
                    Object objRememberedValue7 = gapComposer7.rememberedValue();
                    if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$3 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState6, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 3);
                        gapComposer7.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$3);
                        objRememberedValue7 = autoPlaylistScreenKt$AutoPlaylistScreen$12$3;
                    }
                    AlbumMenuKt.PlaylistMenu(playlist3, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue7), null, null, null, gapComposer7, 0);
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
                    Artist artist3 = (Artist) localItem;
                    MenuState menuState7 = this.$menuState;
                    boolean zChanged8 = gapComposer8.changed(menuState7);
                    Object objRememberedValue8 = gapComposer8.rememberedValue();
                    if (zChanged8 || objRememberedValue8 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$4 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState7, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 5);
                        gapComposer8.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$4);
                        objRememberedValue8 = autoPlaylistScreenKt$AutoPlaylistScreen$12$4;
                    }
                    AlbumMenuKt.ArtistMenu(artist3, coroutineScope, (Function0) ((KFunction) objRememberedValue8), gapComposer8, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(MenuState menuState, LocalItem localItem, CoroutineScope coroutineScope, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$item = localItem;
        this.$coroutineScope = coroutineScope;
    }
}
