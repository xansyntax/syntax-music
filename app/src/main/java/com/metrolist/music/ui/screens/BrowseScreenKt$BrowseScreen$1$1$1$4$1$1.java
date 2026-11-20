package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.YouTubeAlbumMenuKt;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$4$2$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BrowseScreenKt$BrowseScreen$1$1$1$4$1$1 implements Function0 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ YTItem $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BrowseScreenKt$BrowseScreen$1$1$1$4$1$1(byte b, YTItem yTItem, MenuState menuState, CoroutineScope coroutineScope) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$item = yTItem;
        this.$coroutineScope = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = this.$coroutineScope;
        YTItem yTItem = this.$item;
        MenuState menuState = this.$menuState;
        switch (b) {
            case 0:
                menuState.show(new ComposableLambdaImpl(true, 1419540519, new AnonymousClass1((byte) 0, yTItem, menuState, coroutineScope)));
                break;
            default:
                menuState.show(new ComposableLambdaImpl(true, -29750081, new AnonymousClass1((byte) 2, yTItem, menuState, coroutineScope)));
                break;
        }
        return unit;
    }

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.BrowseScreenKt$BrowseScreen$1$1$1$4$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Function3 {
        public final /* synthetic */ CoroutineScope $coroutineScope;
        public final /* synthetic */ YTItem $item;
        public final /* synthetic */ MenuState $menuState;
        public final /* synthetic */ byte $r8$classId;

        public AnonymousClass1(MenuState menuState, YTItem yTItem, CoroutineScope coroutineScope) {
            this.$r8$classId = (byte) 3;
            this.$menuState = menuState;
            this.$item = yTItem;
            this.$coroutineScope = coroutineScope;
        }

        /* JADX WARN: Code duplicated, block: B:257:0x081e  */
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            YTItem yTItem = this.$item;
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
                    } else if (yTItem == null) {
                        gapComposer.startReplaceGroup(1284931822);
                        gapComposer.end(false);
                    } else if (yTItem instanceof AlbumItem) {
                        gapComposer.startReplaceGroup(1283730014);
                        AlbumItem albumItem = (AlbumItem) yTItem;
                        MenuState menuState = this.$menuState;
                        boolean zChanged = gapComposer.changed(menuState);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 7);
                            gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                            objRememberedValue = homeScreenKt$HomeScreen$8$1;
                        }
                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem, (Function0) ((KFunction) objRememberedValue), gapComposer, 0);
                        gapComposer.end(false);
                    } else if (yTItem instanceof PlaylistItem) {
                        gapComposer.startReplaceGroup(1284111655);
                        PlaylistItem playlistItem = (PlaylistItem) yTItem;
                        MenuState menuState2 = this.$menuState;
                        boolean zChanged2 = gapComposer.changed(menuState2);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 8);
                            gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                            objRememberedValue2 = homeScreenKt$HomeScreen$8$2;
                        }
                        YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue2), null, gapComposer, 0, 50);
                        gapComposer.end(false);
                    } else if (yTItem instanceof ArtistItem) {
                        gapComposer.startReplaceGroup(1284572160);
                        ArtistItem artistItem = (ArtistItem) yTItem;
                        MenuState menuState3 = this.$menuState;
                        boolean zChanged3 = gapComposer.changed(menuState3);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$3 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 9);
                            gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$8$3);
                            objRememberedValue3 = homeScreenKt$HomeScreen$8$3;
                        }
                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem, (Function0) ((KFunction) objRememberedValue3), gapComposer, 0);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(1284931822);
                        gapComposer.end(false);
                    }
                    return unit;
                case 1:
                    Composer composer2 = (Composer) obj2;
                    int iIntValue2 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                        if (yTItem != null) {
                            if (yTItem instanceof SongItem) {
                                gapComposer2.startReplaceGroup(1769054651);
                                SongItem songItem = (SongItem) yTItem;
                                MenuState menuState4 = this.$menuState;
                                boolean zChanged4 = gapComposer2.changed(menuState4);
                                Object objRememberedValue4 = gapComposer2.rememberedValue();
                                if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 17);
                                    gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                    objRememberedValue4 = loginScreenKt$LoginScreen$1$3$2$1;
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItem, (Function0) ((KFunction) objRememberedValue4), null, gapComposer2, 0, 4);
                                gapComposer2.end(false);
                            } else if (yTItem instanceof AlbumItem) {
                                gapComposer2.startReplaceGroup(1769401045);
                                AlbumItem albumItem2 = (AlbumItem) yTItem;
                                MenuState menuState5 = this.$menuState;
                                boolean zChanged5 = gapComposer2.changed(menuState5);
                                Object objRememberedValue5 = gapComposer2.rememberedValue();
                                if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$2 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState5, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 18);
                                    gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$2);
                                    objRememberedValue5 = loginScreenKt$LoginScreen$1$3$2$2;
                                }
                                YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue5), gapComposer2, 0);
                                gapComposer2.end(false);
                            } else if (yTItem instanceof ArtistItem) {
                                gapComposer2.startReplaceGroup(1769754135);
                                ArtistItem artistItem2 = (ArtistItem) yTItem;
                                MenuState menuState6 = this.$menuState;
                                boolean zChanged6 = gapComposer2.changed(menuState6);
                                Object objRememberedValue6 = gapComposer2.rememberedValue();
                                if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$3 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState6, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 19);
                                    gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$3);
                                    objRememberedValue6 = loginScreenKt$LoginScreen$1$3$2$3;
                                }
                                YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem2, (Function0) ((KFunction) objRememberedValue6), gapComposer2, 0);
                                gapComposer2.end(false);
                            } else if (yTItem instanceof PlaylistItem) {
                                gapComposer2.startReplaceGroup(1770109922);
                                PlaylistItem playlistItem2 = (PlaylistItem) yTItem;
                                MenuState menuState7 = this.$menuState;
                                boolean zChanged7 = gapComposer2.changed(menuState7);
                                Object objRememberedValue7 = gapComposer2.rememberedValue();
                                if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$4 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState7, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 20);
                                    gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$4);
                                    objRememberedValue7 = loginScreenKt$LoginScreen$1$3$2$4;
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem2, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue7), null, gapComposer2, 0, 50);
                                gapComposer2.end(false);
                            } else if (yTItem instanceof PodcastItem) {
                                gapComposer2.startReplaceGroup(1770546929);
                                PlaylistItem playlistItemAsPlaylistItem = ((PodcastItem) yTItem).asPlaylistItem();
                                MenuState menuState8 = this.$menuState;
                                boolean zChanged8 = gapComposer2.changed(menuState8);
                                Object objRememberedValue8 = gapComposer2.rememberedValue();
                                if (zChanged8 || objRememberedValue8 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$5 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState8, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 21);
                                    gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$5);
                                    objRememberedValue8 = loginScreenKt$LoginScreen$1$3$2$5;
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue8), null, gapComposer2, 0, 50);
                                gapComposer2.end(false);
                            } else if (yTItem instanceof EpisodeItem) {
                                gapComposer2.startReplaceGroup(1770997390);
                                SongItem songItemAsSongItem = ((EpisodeItem) yTItem).asSongItem();
                                MenuState menuState9 = this.$menuState;
                                boolean zChanged9 = gapComposer2.changed(menuState9);
                                Object objRememberedValue9 = gapComposer2.rememberedValue();
                                if (zChanged9 || objRememberedValue9 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$6 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState9, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 22);
                                    gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$6);
                                    objRememberedValue9 = loginScreenKt$LoginScreen$1$3$2$6;
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem, (Function0) ((KFunction) objRememberedValue9), null, gapComposer2, 0, 4);
                                gapComposer2.end(false);
                            }
                        }
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 57066149, false);
                    }
                    gapComposer2.skipToGroupEnd();
                    return unit;
                case 2:
                    Composer composer3 = (Composer) obj2;
                    int iIntValue3 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer3 = (GapComposer) composer3;
                    if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                        if (yTItem != null) {
                            if (yTItem instanceof SongItem) {
                                gapComposer3.startReplaceGroup(-1521284928);
                                SongItem songItem2 = (SongItem) yTItem;
                                MenuState menuState10 = this.$menuState;
                                boolean zChanged10 = gapComposer3.changed(menuState10);
                                Object objRememberedValue10 = gapComposer3.rememberedValue();
                                if (zChanged10 || objRememberedValue10 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$7 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState10, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 25);
                                    gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$7);
                                    objRememberedValue10 = loginScreenKt$LoginScreen$1$3$2$7;
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItem2, (Function0) ((KFunction) objRememberedValue10), null, gapComposer3, 0, 4);
                                gapComposer3.end(false);
                            } else if (yTItem instanceof AlbumItem) {
                                gapComposer3.startReplaceGroup(-1520938534);
                                AlbumItem albumItem3 = (AlbumItem) yTItem;
                                MenuState menuState11 = this.$menuState;
                                boolean zChanged11 = gapComposer3.changed(menuState11);
                                Object objRememberedValue11 = gapComposer3.rememberedValue();
                                if (zChanged11 || objRememberedValue11 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$8 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState11, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 26);
                                    gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$8);
                                    objRememberedValue11 = loginScreenKt$LoginScreen$1$3$2$8;
                                }
                                YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem3, (Function0) ((KFunction) objRememberedValue11), gapComposer3, 0);
                                gapComposer3.end(false);
                            } else if (yTItem instanceof ArtistItem) {
                                gapComposer3.startReplaceGroup(-1520585444);
                                ArtistItem artistItem3 = (ArtistItem) yTItem;
                                MenuState menuState12 = this.$menuState;
                                boolean zChanged12 = gapComposer3.changed(menuState12);
                                Object objRememberedValue12 = gapComposer3.rememberedValue();
                                if (zChanged12 || objRememberedValue12 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$9 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState12, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 27);
                                    gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$9);
                                    objRememberedValue12 = loginScreenKt$LoginScreen$1$3$2$9;
                                }
                                YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem3, (Function0) ((KFunction) objRememberedValue12), gapComposer3, 0);
                                gapComposer3.end(false);
                            } else if (yTItem instanceof PlaylistItem) {
                                gapComposer3.startReplaceGroup(-1520229657);
                                PlaylistItem playlistItem3 = (PlaylistItem) yTItem;
                                MenuState menuState13 = this.$menuState;
                                boolean zChanged13 = gapComposer3.changed(menuState13);
                                Object objRememberedValue13 = gapComposer3.rememberedValue();
                                if (zChanged13 || objRememberedValue13 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$10 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState13, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 28);
                                    gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$10);
                                    objRememberedValue13 = loginScreenKt$LoginScreen$1$3$2$10;
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem3, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue13), null, gapComposer3, 0, 50);
                                gapComposer3.end(false);
                            } else if (yTItem instanceof PodcastItem) {
                                gapComposer3.startReplaceGroup(-1519792650);
                                PlaylistItem playlistItemAsPlaylistItem2 = ((PodcastItem) yTItem).asPlaylistItem();
                                MenuState menuState14 = this.$menuState;
                                boolean zChanged14 = gapComposer3.changed(menuState14);
                                Object objRememberedValue14 = gapComposer3.rememberedValue();
                                if (zChanged14 || objRememberedValue14 == neverEqualPolicy) {
                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$11 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState14, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 29);
                                    gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$11);
                                    objRememberedValue14 = loginScreenKt$LoginScreen$1$3$2$11;
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem2, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue14), null, gapComposer3, 0, 50);
                                gapComposer3.end(false);
                            } else if (yTItem instanceof EpisodeItem) {
                                gapComposer3.startReplaceGroup(-1519342189);
                                SongItem songItemAsSongItem2 = ((EpisodeItem) yTItem).asSongItem();
                                MenuState menuState15 = this.$menuState;
                                boolean zChanged15 = gapComposer3.changed(menuState15);
                                Object objRememberedValue15 = gapComposer3.rememberedValue();
                                if (zChanged15 || objRememberedValue15 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$1 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState15, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                    gapComposer3.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$1);
                                    objRememberedValue15 = artistScreenKt$ArtistScreen$4$2$1;
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem2, (Function0) ((KFunction) objRememberedValue15), null, gapComposer3, 0, 4);
                                gapComposer3.end(false);
                            }
                        }
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer3, 1474946816, false);
                    }
                    gapComposer3.skipToGroupEnd();
                    return unit;
                case 3:
                    Composer composer4 = (Composer) obj2;
                    int iIntValue4 = ((Number) obj3).intValue();
                    ((RowScope) obj).getClass();
                    GapComposer gapComposer4 = (GapComposer) composer4;
                    if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                        MenuState menuState16 = this.$menuState;
                        boolean zChanged16 = gapComposer4.changed(menuState16) | gapComposer4.changedInstance(yTItem);
                        CoroutineScope coroutineScope = this.$coroutineScope;
                        boolean zChangedInstance = zChanged16 | gapComposer4.changedInstance(coroutineScope);
                        Object objRememberedValue16 = gapComposer4.rememberedValue();
                        if (zChangedInstance || objRememberedValue16 == neverEqualPolicy) {
                            objRememberedValue16 = new BrowseScreenKt$BrowseScreen$1$1$1$4$1$1(b2, yTItem, menuState16, coroutineScope);
                            gapComposer4.updateRememberedValue(objRememberedValue16);
                        }
                        CardKt.IconButton((Function0) objRememberedValue16, null, false, null, null, ArtistItemsScreenKt.lambda$1099964723, gapComposer4, 1572864, 62);
                    } else {
                        gapComposer4.skipToGroupEnd();
                    }
                    return unit;
                case 4:
                    Composer composer5 = (Composer) obj2;
                    int iIntValue5 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer5 = (GapComposer) composer5;
                    if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                        if (yTItem != null) {
                            if (yTItem instanceof SongItem) {
                                gapComposer5.startReplaceGroup(1271839322);
                                SongItem songItem3 = (SongItem) yTItem;
                                MenuState menuState17 = this.$menuState;
                                boolean zChanged17 = gapComposer5.changed(menuState17);
                                Object objRememberedValue17 = gapComposer5.rememberedValue();
                                if (zChanged17 || objRememberedValue17 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$2 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState17, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 2);
                                    gapComposer5.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$2);
                                    objRememberedValue17 = artistScreenKt$ArtistScreen$4$2$2;
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItem3, (Function0) ((KFunction) objRememberedValue17), null, gapComposer5, 0, 4);
                                gapComposer5.end(false);
                            } else if (yTItem instanceof AlbumItem) {
                                gapComposer5.startReplaceGroup(1272209524);
                                AlbumItem albumItem4 = (AlbumItem) yTItem;
                                MenuState menuState18 = this.$menuState;
                                boolean zChanged18 = gapComposer5.changed(menuState18);
                                Object objRememberedValue18 = gapComposer5.rememberedValue();
                                if (zChanged18 || objRememberedValue18 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$3 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState18, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 3);
                                    gapComposer5.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$3);
                                    objRememberedValue18 = artistScreenKt$ArtistScreen$4$2$3;
                                }
                                YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem4, (Function0) ((KFunction) objRememberedValue18), gapComposer5, 0);
                                gapComposer5.end(false);
                            } else if (yTItem instanceof ArtistItem) {
                                gapComposer5.startReplaceGroup(1272586422);
                                ArtistItem artistItem4 = (ArtistItem) yTItem;
                                MenuState menuState19 = this.$menuState;
                                boolean zChanged19 = gapComposer5.changed(menuState19);
                                Object objRememberedValue19 = gapComposer5.rememberedValue();
                                if (zChanged19 || objRememberedValue19 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$4 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState19, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 4);
                                    gapComposer5.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$4);
                                    objRememberedValue19 = artistScreenKt$ArtistScreen$4$2$4;
                                }
                                YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem4, (Function0) ((KFunction) objRememberedValue19), gapComposer5, 0);
                                gapComposer5.end(false);
                            } else if (yTItem instanceof PlaylistItem) {
                                gapComposer5.startReplaceGroup(1272966141);
                                PlaylistItem playlistItem4 = (PlaylistItem) yTItem;
                                MenuState menuState20 = this.$menuState;
                                boolean zChanged20 = gapComposer5.changed(menuState20);
                                Object objRememberedValue20 = gapComposer5.rememberedValue();
                                if (zChanged20 || objRememberedValue20 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$5 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState20, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 5);
                                    gapComposer5.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$5);
                                    objRememberedValue20 = artistScreenKt$ArtistScreen$4$2$5;
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem4, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue20), null, gapComposer5, 0, 50);
                                gapComposer5.end(false);
                            } else if (yTItem instanceof PodcastItem) {
                                gapComposer5.startReplaceGroup(1273430924);
                                PlaylistItem playlistItemAsPlaylistItem3 = ((PodcastItem) yTItem).asPlaylistItem();
                                MenuState menuState21 = this.$menuState;
                                boolean zChanged21 = gapComposer5.changed(menuState21);
                                Object objRememberedValue21 = gapComposer5.rememberedValue();
                                if (zChanged21 || objRememberedValue21 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$6 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState21, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 6);
                                    gapComposer5.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$6);
                                    objRememberedValue21 = artistScreenKt$ArtistScreen$4$2$6;
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem3, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue21), null, gapComposer5, 0, 50);
                                gapComposer5.end(false);
                            } else if (yTItem instanceof EpisodeItem) {
                                gapComposer5.startReplaceGroup(1273909037);
                                SongItem songItemAsSongItem3 = ((EpisodeItem) yTItem).asSongItem();
                                MenuState menuState22 = this.$menuState;
                                boolean zChanged22 = gapComposer5.changed(menuState22);
                                Object objRememberedValue22 = gapComposer5.rememberedValue();
                                if (zChanged22 || objRememberedValue22 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$7 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState22, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 7);
                                    gapComposer5.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$7);
                                    objRememberedValue22 = artistScreenKt$ArtistScreen$4$2$7;
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem3, (Function0) ((KFunction) objRememberedValue22), null, gapComposer5, 0, 4);
                                gapComposer5.end(false);
                            }
                        }
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer5, 1287952942, false);
                    }
                    gapComposer5.skipToGroupEnd();
                    return unit;
                default:
                    Composer composer6 = (Composer) obj2;
                    int iIntValue6 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer6 = (GapComposer) composer6;
                    if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                        if (yTItem != null) {
                            if (yTItem instanceof SongItem) {
                                gapComposer6.startReplaceGroup(854573083);
                                SongItem songItem4 = (SongItem) yTItem;
                                MenuState menuState23 = this.$menuState;
                                boolean zChanged23 = gapComposer6.changed(menuState23);
                                Object objRememberedValue23 = gapComposer6.rememberedValue();
                                if (zChanged23 || objRememberedValue23 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$8 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState23, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 14);
                                    gapComposer6.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$8);
                                    objRememberedValue23 = artistScreenKt$ArtistScreen$4$2$8;
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItem4, (Function0) ((KFunction) objRememberedValue23), null, gapComposer6, 0, 4);
                                gapComposer6.end(false);
                            } else if (yTItem instanceof AlbumItem) {
                                gapComposer6.startReplaceGroup(855086133);
                                AlbumItem albumItem5 = (AlbumItem) yTItem;
                                MenuState menuState24 = this.$menuState;
                                boolean zChanged24 = gapComposer6.changed(menuState24);
                                Object objRememberedValue24 = gapComposer6.rememberedValue();
                                if (zChanged24 || objRememberedValue24 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$9 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState24, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 15);
                                    gapComposer6.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$9);
                                    objRememberedValue24 = artistScreenKt$ArtistScreen$4$2$9;
                                }
                                YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem5, (Function0) ((KFunction) objRememberedValue24), gapComposer6, 0);
                                gapComposer6.end(false);
                            } else if (yTItem instanceof ArtistItem) {
                                gapComposer6.startReplaceGroup(855605879);
                                ArtistItem artistItem5 = (ArtistItem) yTItem;
                                MenuState menuState25 = this.$menuState;
                                boolean zChanged25 = gapComposer6.changed(menuState25);
                                Object objRememberedValue25 = gapComposer6.rememberedValue();
                                if (zChanged25 || objRememberedValue25 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$10 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState25, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 16);
                                    gapComposer6.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$10);
                                    objRememberedValue25 = artistScreenKt$ArtistScreen$4$2$10;
                                }
                                YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem5, (Function0) ((KFunction) objRememberedValue25), gapComposer6, 0);
                                gapComposer6.end(false);
                            } else if (yTItem instanceof PlaylistItem) {
                                gapComposer6.startReplaceGroup(856129190);
                                PlaylistItem playlistItem5 = (PlaylistItem) yTItem;
                                MenuState menuState26 = this.$menuState;
                                boolean zChanged26 = gapComposer6.changed(menuState26);
                                Object objRememberedValue26 = gapComposer6.rememberedValue();
                                if (zChanged26 || objRememberedValue26 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$11 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState26, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 17);
                                    gapComposer6.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$11);
                                    objRememberedValue26 = artistScreenKt$ArtistScreen$4$2$11;
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem5, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue26), null, gapComposer6, 0, 50);
                                gapComposer6.end(false);
                            } else if (yTItem instanceof PodcastItem) {
                                gapComposer6.startReplaceGroup(856760629);
                                PlaylistItem playlistItemAsPlaylistItem4 = ((PodcastItem) yTItem).asPlaylistItem();
                                MenuState menuState27 = this.$menuState;
                                boolean zChanged27 = gapComposer6.changed(menuState27);
                                Object objRememberedValue27 = gapComposer6.rememberedValue();
                                if (zChanged27 || objRememberedValue27 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$12 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState27, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 18);
                                    gapComposer6.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$12);
                                    objRememberedValue27 = artistScreenKt$ArtistScreen$4$2$12;
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem4, null, this.$coroutineScope, (Function0) ((KFunction) objRememberedValue27), null, gapComposer6, 0, 50);
                                gapComposer6.end(false);
                            } else if (yTItem instanceof EpisodeItem) {
                                gapComposer6.startReplaceGroup(857404654);
                                SongItem songItemAsSongItem4 = ((EpisodeItem) yTItem).asSongItem();
                                MenuState menuState28 = this.$menuState;
                                boolean zChanged28 = gapComposer6.changed(menuState28);
                                Object objRememberedValue28 = gapComposer6.rememberedValue();
                                if (zChanged28 || objRememberedValue28 == neverEqualPolicy) {
                                    ArtistScreenKt$ArtistScreen$4$2$1 artistScreenKt$ArtistScreen$4$2$13 = new ArtistScreenKt$ArtistScreen$4$2$1(0, menuState28, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 19);
                                    gapComposer6.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$13);
                                    objRememberedValue28 = artistScreenKt$ArtistScreen$4$2$13;
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem4, (Function0) ((KFunction) objRememberedValue28), null, gapComposer6, 0, 4);
                                gapComposer6.end(false);
                            }
                        }
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer6, 1551587453, false);
                    }
                    gapComposer6.skipToGroupEnd();
                    return unit;
            }
        }

        public /* synthetic */ AnonymousClass1(byte b, YTItem yTItem, MenuState menuState, CoroutineScope coroutineScope) {
            this.$r8$classId = b;
            this.$item = yTItem;
            this.$menuState = menuState;
            this.$coroutineScope = coroutineScope;
        }
    }
}
