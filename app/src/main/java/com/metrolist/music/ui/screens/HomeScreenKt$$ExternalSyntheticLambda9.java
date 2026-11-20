package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
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
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import dev.chrisbanes.haze.HazeEffectNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda9 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ HapticFeedback f$0;
    public final /* synthetic */ MenuState f$1;
    public final /* synthetic */ YTItem f$2;
    public final /* synthetic */ CoroutineScope f$3;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda9(HapticFeedback hapticFeedback, MenuState menuState, YTItem yTItem, CoroutineScope coroutineScope, byte b) {
        this.$r8$classId = b;
        this.f$0 = hapticFeedback;
        this.f$1 = menuState;
        this.f$2 = yTItem;
        this.f$3 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        final CoroutineScope coroutineScope = this.f$3;
        final YTItem yTItem = this.f$2;
        final MenuState menuState = this.f$1;
        HapticFeedback hapticFeedback = this.f$0;
        final byte b2 = 1;
        final byte b3 = 0;
        switch (b) {
            case 0:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, 1983281962, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b4 = b3;
                        Unit unit2 = Unit.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        YTItem yTItem2 = yTItem;
                        switch (b4) {
                            case 0:
                                Composer composer = (Composer) obj2;
                                int iIntValue = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer = (GapComposer) composer;
                                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                    boolean z = yTItem2 instanceof SongItem;
                                    MenuState menuState2 = menuState;
                                    if (z) {
                                        gapComposer.startReplaceGroup(-1912054519);
                                        SongItem songItem = (SongItem) yTItem2;
                                        boolean zChanged = gapComposer.changed(menuState2);
                                        Object objRememberedValue = gapComposer.rememberedValue();
                                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 4);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                            objRememberedValue = loginScreenKt$LoginScreen$1$3$2$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem, (Function0) ((KFunction) objRememberedValue), null, gapComposer, 0, 4);
                                        gapComposer.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer.startReplaceGroup(-1911731933);
                                        AlbumItem albumItem = (AlbumItem) yTItem2;
                                        boolean zChanged2 = gapComposer.changed(menuState2);
                                        Object objRememberedValue2 = gapComposer.rememberedValue();
                                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$2 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 5);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$2);
                                            objRememberedValue2 = loginScreenKt$LoginScreen$1$3$2$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem, (Function0) ((KFunction) objRememberedValue2), gapComposer, 0);
                                        gapComposer.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer.startReplaceGroup(-1911402651);
                                        ArtistItem artistItem = (ArtistItem) yTItem2;
                                        boolean zChanged3 = gapComposer.changed(menuState2);
                                        Object objRememberedValue3 = gapComposer.rememberedValue();
                                        if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$3 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 6);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$3);
                                            objRememberedValue3 = loginScreenKt$LoginScreen$1$3$2$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem, (Function0) ((KFunction) objRememberedValue3), gapComposer, 0);
                                        gapComposer.end(false);
                                    } else {
                                        boolean z2 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        if (z2) {
                                            gapComposer.startReplaceGroup(-1911071075);
                                            PlaylistItem playlistItem = (PlaylistItem) yTItem2;
                                            boolean zChanged4 = gapComposer.changed(menuState2);
                                            Object objRememberedValue4 = gapComposer.rememberedValue();
                                            if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$4 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 7);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$4);
                                                objRememberedValue4 = loginScreenKt$LoginScreen$1$3$2$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, null, coroutineScope2, (Function0) ((KFunction) objRememberedValue4), null, gapComposer, 0, 50);
                                            gapComposer.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer.startReplaceGroup(-1910670772);
                                            PlaylistItem playlistItemAsPlaylistItem = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged5 = gapComposer.changed(menuState2);
                                            Object objRememberedValue5 = gapComposer.rememberedValue();
                                            if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$5 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 8);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$5);
                                                objRememberedValue5 = loginScreenKt$LoginScreen$1$3$2$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem, null, coroutineScope2, (Function0) ((KFunction) objRememberedValue5), null, gapComposer, 0, 50);
                                            gapComposer.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1031510659, false);
                                            }
                                            gapComposer.startReplaceGroup(-1910256612);
                                            SongItem songItemAsSongItem = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged6 = gapComposer.changed(menuState2);
                                            Object objRememberedValue6 = gapComposer.rememberedValue();
                                            if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$6 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 9);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$6);
                                                objRememberedValue6 = loginScreenKt$LoginScreen$1$3$2$6;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem, (Function0) ((KFunction) objRememberedValue6), null, gapComposer, 0, 4);
                                            gapComposer.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer.skipToGroupEnd();
                                }
                                return unit2;
                            case 1:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue2 = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    boolean z3 = yTItem2 instanceof SongItem;
                                    MenuState menuState3 = menuState;
                                    if (z3) {
                                        gapComposer2.startReplaceGroup(256979046);
                                        SongItem songItem2 = (SongItem) yTItem2;
                                        boolean zChanged7 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                                        if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 22);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                                            objRememberedValue7 = homeScreenKt$HomeScreen$8$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem2, (Function0) ((KFunction) objRememberedValue7), null, gapComposer2, 0, 4);
                                        gapComposer2.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer2.startReplaceGroup(257658752);
                                        AlbumItem albumItem2 = (AlbumItem) yTItem2;
                                        boolean zChanged8 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                                        if (zChanged8 || objRememberedValue8 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 23);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                                            objRememberedValue8 = homeScreenKt$HomeScreen$8$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue8), gapComposer2, 0);
                                        gapComposer2.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer2.startReplaceGroup(258345154);
                                        ArtistItem artistItem2 = (ArtistItem) yTItem2;
                                        boolean zChanged9 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                                        if (zChanged9 || objRememberedValue9 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$3 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 24);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$3);
                                            objRememberedValue9 = homeScreenKt$HomeScreen$8$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem2, (Function0) ((KFunction) objRememberedValue9), gapComposer2, 0);
                                        gapComposer2.end(false);
                                    } else {
                                        boolean z4 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope3 = coroutineScope;
                                        if (z4) {
                                            gapComposer2.startReplaceGroup(259035710);
                                            PlaylistItem playlistItem2 = (PlaylistItem) yTItem2;
                                            boolean zChanged10 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue10 = gapComposer2.rememberedValue();
                                            if (zChanged10 || objRememberedValue10 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$4 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 25);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$4);
                                                objRememberedValue10 = homeScreenKt$HomeScreen$8$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem2, null, coroutineScope3, (Function0) ((KFunction) objRememberedValue10), null, gapComposer2, 0, 50);
                                            gapComposer2.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer2.startReplaceGroup(259852653);
                                            PlaylistItem playlistItemAsPlaylistItem2 = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged11 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue11 = gapComposer2.rememberedValue();
                                            if (zChanged11 || objRememberedValue11 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$5 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 26);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$5);
                                                objRememberedValue11 = homeScreenKt$HomeScreen$8$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem2, null, coroutineScope3, (Function0) ((KFunction) objRememberedValue11), null, gapComposer2, 0, 50);
                                            gapComposer2.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 1532310264, false);
                                            }
                                            gapComposer2.startReplaceGroup(260681593);
                                            SongItem songItemAsSongItem2 = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged12 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue12 = gapComposer2.rememberedValue();
                                            if (zChanged12 || objRememberedValue12 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$6 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 27);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$6);
                                                objRememberedValue12 = homeScreenKt$HomeScreen$8$6;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem2, (Function0) ((KFunction) objRememberedValue12), null, gapComposer2, 0, 4);
                                            gapComposer2.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return unit2;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue3 = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                    boolean z5 = yTItem2 instanceof SongItem;
                                    MenuState menuState4 = menuState;
                                    if (z5) {
                                        gapComposer3.startReplaceGroup(1610222546);
                                        SongItem songItem3 = (SongItem) yTItem2;
                                        boolean zChanged13 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue13 = gapComposer3.rememberedValue();
                                        if (zChanged13 || objRememberedValue13 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 25);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                                            objRememberedValue13 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem3, (Function0) ((KFunction) objRememberedValue13), null, gapComposer3, 0, 4);
                                        gapComposer3.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer3.startReplaceGroup(1610449900);
                                        AlbumItem albumItem3 = (AlbumItem) yTItem2;
                                        boolean zChanged14 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue14 = gapComposer3.rememberedValue();
                                        if (zChanged14 || objRememberedValue14 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$2 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 26);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$2);
                                            objRememberedValue14 = autoPlaylistScreenKt$AutoPlaylistScreen$12$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem3, (Function0) ((KFunction) objRememberedValue14), gapComposer3, 0);
                                        gapComposer3.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer3.startReplaceGroup(1610683950);
                                        ArtistItem artistItem3 = (ArtistItem) yTItem2;
                                        boolean zChanged15 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue15 = gapComposer3.rememberedValue();
                                        if (zChanged15 || objRememberedValue15 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$3 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 27);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$3);
                                            objRememberedValue15 = autoPlaylistScreenKt$AutoPlaylistScreen$12$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem3, (Function0) ((KFunction) objRememberedValue15), gapComposer3, 0);
                                        gapComposer3.end(false);
                                    } else {
                                        boolean z6 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope4 = coroutineScope;
                                        if (z6) {
                                            gapComposer3.startReplaceGroup(1610920077);
                                            PlaylistItem playlistItem3 = (PlaylistItem) yTItem2;
                                            boolean zChanged16 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue16 = gapComposer3.rememberedValue();
                                            if (zChanged16 || objRememberedValue16 == neverEqualPolicy) {
                                                AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$4 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 28);
                                                gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$4);
                                                objRememberedValue16 = autoPlaylistScreenKt$AutoPlaylistScreen$12$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem3, null, coroutineScope4, (Function0) ((KFunction) objRememberedValue16), null, gapComposer3, 0, 50);
                                            gapComposer3.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer3.startReplaceGroup(1611218204);
                                            PlaylistItem playlistItemAsPlaylistItem3 = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged17 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue17 = gapComposer3.rememberedValue();
                                            if (zChanged17 || objRememberedValue17 == neverEqualPolicy) {
                                                AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$5 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 29);
                                                gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$5);
                                                objRememberedValue17 = autoPlaylistScreenKt$AutoPlaylistScreen$12$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem3, null, coroutineScope4, (Function0) ((KFunction) objRememberedValue17), null, gapComposer3, 0, 50);
                                            gapComposer3.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer3, 1437415814, false);
                                            }
                                            gapComposer3.startReplaceGroup(1611530405);
                                            SongItem songItemAsSongItem3 = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged18 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue18 = gapComposer3.rememberedValue();
                                            if (zChanged18 || objRememberedValue18 == neverEqualPolicy) {
                                                HazeEffectNode.AnonymousClass1 anonymousClass1 = new HazeEffectNode.AnonymousClass1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                                gapComposer3.updateRememberedValue(anonymousClass1);
                                                objRememberedValue18 = anonymousClass1;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem3, (Function0) ((KFunction) objRememberedValue18), null, gapComposer3, 0, 4);
                                            gapComposer3.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer3.skipToGroupEnd();
                                }
                                return unit2;
                        }
                    }
                }));
                break;
            case 1:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, -588348991, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b4 = b2;
                        Unit unit2 = Unit.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        YTItem yTItem2 = yTItem;
                        switch (b4) {
                            case 0:
                                Composer composer = (Composer) obj2;
                                int iIntValue = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer = (GapComposer) composer;
                                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                    boolean z = yTItem2 instanceof SongItem;
                                    MenuState menuState2 = menuState;
                                    if (z) {
                                        gapComposer.startReplaceGroup(-1912054519);
                                        SongItem songItem = (SongItem) yTItem2;
                                        boolean zChanged = gapComposer.changed(menuState2);
                                        Object objRememberedValue = gapComposer.rememberedValue();
                                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 4);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                            objRememberedValue = loginScreenKt$LoginScreen$1$3$2$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem, (Function0) ((KFunction) objRememberedValue), null, gapComposer, 0, 4);
                                        gapComposer.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer.startReplaceGroup(-1911731933);
                                        AlbumItem albumItem = (AlbumItem) yTItem2;
                                        boolean zChanged2 = gapComposer.changed(menuState2);
                                        Object objRememberedValue2 = gapComposer.rememberedValue();
                                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$2 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 5);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$2);
                                            objRememberedValue2 = loginScreenKt$LoginScreen$1$3$2$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem, (Function0) ((KFunction) objRememberedValue2), gapComposer, 0);
                                        gapComposer.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer.startReplaceGroup(-1911402651);
                                        ArtistItem artistItem = (ArtistItem) yTItem2;
                                        boolean zChanged3 = gapComposer.changed(menuState2);
                                        Object objRememberedValue3 = gapComposer.rememberedValue();
                                        if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$3 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 6);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$3);
                                            objRememberedValue3 = loginScreenKt$LoginScreen$1$3$2$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem, (Function0) ((KFunction) objRememberedValue3), gapComposer, 0);
                                        gapComposer.end(false);
                                    } else {
                                        boolean z2 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        if (z2) {
                                            gapComposer.startReplaceGroup(-1911071075);
                                            PlaylistItem playlistItem = (PlaylistItem) yTItem2;
                                            boolean zChanged4 = gapComposer.changed(menuState2);
                                            Object objRememberedValue4 = gapComposer.rememberedValue();
                                            if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$4 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 7);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$4);
                                                objRememberedValue4 = loginScreenKt$LoginScreen$1$3$2$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, null, coroutineScope2, (Function0) ((KFunction) objRememberedValue4), null, gapComposer, 0, 50);
                                            gapComposer.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer.startReplaceGroup(-1910670772);
                                            PlaylistItem playlistItemAsPlaylistItem = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged5 = gapComposer.changed(menuState2);
                                            Object objRememberedValue5 = gapComposer.rememberedValue();
                                            if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$5 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 8);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$5);
                                                objRememberedValue5 = loginScreenKt$LoginScreen$1$3$2$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem, null, coroutineScope2, (Function0) ((KFunction) objRememberedValue5), null, gapComposer, 0, 50);
                                            gapComposer.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1031510659, false);
                                            }
                                            gapComposer.startReplaceGroup(-1910256612);
                                            SongItem songItemAsSongItem = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged6 = gapComposer.changed(menuState2);
                                            Object objRememberedValue6 = gapComposer.rememberedValue();
                                            if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$6 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 9);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$6);
                                                objRememberedValue6 = loginScreenKt$LoginScreen$1$3$2$6;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem, (Function0) ((KFunction) objRememberedValue6), null, gapComposer, 0, 4);
                                            gapComposer.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer.skipToGroupEnd();
                                }
                                return unit2;
                            case 1:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue2 = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    boolean z3 = yTItem2 instanceof SongItem;
                                    MenuState menuState3 = menuState;
                                    if (z3) {
                                        gapComposer2.startReplaceGroup(256979046);
                                        SongItem songItem2 = (SongItem) yTItem2;
                                        boolean zChanged7 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                                        if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 22);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                                            objRememberedValue7 = homeScreenKt$HomeScreen$8$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem2, (Function0) ((KFunction) objRememberedValue7), null, gapComposer2, 0, 4);
                                        gapComposer2.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer2.startReplaceGroup(257658752);
                                        AlbumItem albumItem2 = (AlbumItem) yTItem2;
                                        boolean zChanged8 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                                        if (zChanged8 || objRememberedValue8 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 23);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                                            objRememberedValue8 = homeScreenKt$HomeScreen$8$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue8), gapComposer2, 0);
                                        gapComposer2.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer2.startReplaceGroup(258345154);
                                        ArtistItem artistItem2 = (ArtistItem) yTItem2;
                                        boolean zChanged9 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                                        if (zChanged9 || objRememberedValue9 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$3 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 24);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$3);
                                            objRememberedValue9 = homeScreenKt$HomeScreen$8$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem2, (Function0) ((KFunction) objRememberedValue9), gapComposer2, 0);
                                        gapComposer2.end(false);
                                    } else {
                                        boolean z4 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope3 = coroutineScope;
                                        if (z4) {
                                            gapComposer2.startReplaceGroup(259035710);
                                            PlaylistItem playlistItem2 = (PlaylistItem) yTItem2;
                                            boolean zChanged10 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue10 = gapComposer2.rememberedValue();
                                            if (zChanged10 || objRememberedValue10 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$4 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 25);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$4);
                                                objRememberedValue10 = homeScreenKt$HomeScreen$8$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem2, null, coroutineScope3, (Function0) ((KFunction) objRememberedValue10), null, gapComposer2, 0, 50);
                                            gapComposer2.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer2.startReplaceGroup(259852653);
                                            PlaylistItem playlistItemAsPlaylistItem2 = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged11 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue11 = gapComposer2.rememberedValue();
                                            if (zChanged11 || objRememberedValue11 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$5 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 26);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$5);
                                                objRememberedValue11 = homeScreenKt$HomeScreen$8$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem2, null, coroutineScope3, (Function0) ((KFunction) objRememberedValue11), null, gapComposer2, 0, 50);
                                            gapComposer2.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 1532310264, false);
                                            }
                                            gapComposer2.startReplaceGroup(260681593);
                                            SongItem songItemAsSongItem2 = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged12 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue12 = gapComposer2.rememberedValue();
                                            if (zChanged12 || objRememberedValue12 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$6 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 27);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$6);
                                                objRememberedValue12 = homeScreenKt$HomeScreen$8$6;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem2, (Function0) ((KFunction) objRememberedValue12), null, gapComposer2, 0, 4);
                                            gapComposer2.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return unit2;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue3 = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                    boolean z5 = yTItem2 instanceof SongItem;
                                    MenuState menuState4 = menuState;
                                    if (z5) {
                                        gapComposer3.startReplaceGroup(1610222546);
                                        SongItem songItem3 = (SongItem) yTItem2;
                                        boolean zChanged13 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue13 = gapComposer3.rememberedValue();
                                        if (zChanged13 || objRememberedValue13 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 25);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                                            objRememberedValue13 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem3, (Function0) ((KFunction) objRememberedValue13), null, gapComposer3, 0, 4);
                                        gapComposer3.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer3.startReplaceGroup(1610449900);
                                        AlbumItem albumItem3 = (AlbumItem) yTItem2;
                                        boolean zChanged14 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue14 = gapComposer3.rememberedValue();
                                        if (zChanged14 || objRememberedValue14 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$2 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 26);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$2);
                                            objRememberedValue14 = autoPlaylistScreenKt$AutoPlaylistScreen$12$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem3, (Function0) ((KFunction) objRememberedValue14), gapComposer3, 0);
                                        gapComposer3.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer3.startReplaceGroup(1610683950);
                                        ArtistItem artistItem3 = (ArtistItem) yTItem2;
                                        boolean zChanged15 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue15 = gapComposer3.rememberedValue();
                                        if (zChanged15 || objRememberedValue15 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$3 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 27);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$3);
                                            objRememberedValue15 = autoPlaylistScreenKt$AutoPlaylistScreen$12$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem3, (Function0) ((KFunction) objRememberedValue15), gapComposer3, 0);
                                        gapComposer3.end(false);
                                    } else {
                                        boolean z6 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope4 = coroutineScope;
                                        if (z6) {
                                            gapComposer3.startReplaceGroup(1610920077);
                                            PlaylistItem playlistItem3 = (PlaylistItem) yTItem2;
                                            boolean zChanged16 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue16 = gapComposer3.rememberedValue();
                                            if (zChanged16 || objRememberedValue16 == neverEqualPolicy) {
                                                AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$4 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 28);
                                                gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$4);
                                                objRememberedValue16 = autoPlaylistScreenKt$AutoPlaylistScreen$12$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem3, null, coroutineScope4, (Function0) ((KFunction) objRememberedValue16), null, gapComposer3, 0, 50);
                                            gapComposer3.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer3.startReplaceGroup(1611218204);
                                            PlaylistItem playlistItemAsPlaylistItem3 = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged17 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue17 = gapComposer3.rememberedValue();
                                            if (zChanged17 || objRememberedValue17 == neverEqualPolicy) {
                                                AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$5 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 29);
                                                gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$5);
                                                objRememberedValue17 = autoPlaylistScreenKt$AutoPlaylistScreen$12$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem3, null, coroutineScope4, (Function0) ((KFunction) objRememberedValue17), null, gapComposer3, 0, 50);
                                            gapComposer3.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer3, 1437415814, false);
                                            }
                                            gapComposer3.startReplaceGroup(1611530405);
                                            SongItem songItemAsSongItem3 = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged18 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue18 = gapComposer3.rememberedValue();
                                            if (zChanged18 || objRememberedValue18 == neverEqualPolicy) {
                                                HazeEffectNode.AnonymousClass1 anonymousClass1 = new HazeEffectNode.AnonymousClass1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                                gapComposer3.updateRememberedValue(anonymousClass1);
                                                objRememberedValue18 = anonymousClass1;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem3, (Function0) ((KFunction) objRememberedValue18), null, gapComposer3, 0, 4);
                                            gapComposer3.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer3.skipToGroupEnd();
                                }
                                return unit2;
                        }
                    }
                }));
                break;
            default:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                final byte b4 = 2;
                menuState.show(new ComposableLambdaImpl(true, 582500689, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b5 = b4;
                        Unit unit2 = Unit.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        YTItem yTItem2 = yTItem;
                        switch (b5) {
                            case 0:
                                Composer composer = (Composer) obj2;
                                int iIntValue = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer = (GapComposer) composer;
                                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                    boolean z = yTItem2 instanceof SongItem;
                                    MenuState menuState2 = menuState;
                                    if (z) {
                                        gapComposer.startReplaceGroup(-1912054519);
                                        SongItem songItem = (SongItem) yTItem2;
                                        boolean zChanged = gapComposer.changed(menuState2);
                                        Object objRememberedValue = gapComposer.rememberedValue();
                                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 4);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                            objRememberedValue = loginScreenKt$LoginScreen$1$3$2$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem, (Function0) ((KFunction) objRememberedValue), null, gapComposer, 0, 4);
                                        gapComposer.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer.startReplaceGroup(-1911731933);
                                        AlbumItem albumItem = (AlbumItem) yTItem2;
                                        boolean zChanged2 = gapComposer.changed(menuState2);
                                        Object objRememberedValue2 = gapComposer.rememberedValue();
                                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$2 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 5);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$2);
                                            objRememberedValue2 = loginScreenKt$LoginScreen$1$3$2$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem, (Function0) ((KFunction) objRememberedValue2), gapComposer, 0);
                                        gapComposer.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer.startReplaceGroup(-1911402651);
                                        ArtistItem artistItem = (ArtistItem) yTItem2;
                                        boolean zChanged3 = gapComposer.changed(menuState2);
                                        Object objRememberedValue3 = gapComposer.rememberedValue();
                                        if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                            LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$3 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 6);
                                            gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$3);
                                            objRememberedValue3 = loginScreenKt$LoginScreen$1$3$2$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem, (Function0) ((KFunction) objRememberedValue3), gapComposer, 0);
                                        gapComposer.end(false);
                                    } else {
                                        boolean z2 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        if (z2) {
                                            gapComposer.startReplaceGroup(-1911071075);
                                            PlaylistItem playlistItem = (PlaylistItem) yTItem2;
                                            boolean zChanged4 = gapComposer.changed(menuState2);
                                            Object objRememberedValue4 = gapComposer.rememberedValue();
                                            if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$4 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 7);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$4);
                                                objRememberedValue4 = loginScreenKt$LoginScreen$1$3$2$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, null, coroutineScope2, (Function0) ((KFunction) objRememberedValue4), null, gapComposer, 0, 50);
                                            gapComposer.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer.startReplaceGroup(-1910670772);
                                            PlaylistItem playlistItemAsPlaylistItem = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged5 = gapComposer.changed(menuState2);
                                            Object objRememberedValue5 = gapComposer.rememberedValue();
                                            if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$5 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 8);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$5);
                                                objRememberedValue5 = loginScreenKt$LoginScreen$1$3$2$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem, null, coroutineScope2, (Function0) ((KFunction) objRememberedValue5), null, gapComposer, 0, 50);
                                            gapComposer.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1031510659, false);
                                            }
                                            gapComposer.startReplaceGroup(-1910256612);
                                            SongItem songItemAsSongItem = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged6 = gapComposer.changed(menuState2);
                                            Object objRememberedValue6 = gapComposer.rememberedValue();
                                            if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                                                LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$6 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 9);
                                                gapComposer.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$6);
                                                objRememberedValue6 = loginScreenKt$LoginScreen$1$3$2$6;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem, (Function0) ((KFunction) objRememberedValue6), null, gapComposer, 0, 4);
                                            gapComposer.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer.skipToGroupEnd();
                                }
                                return unit2;
                            case 1:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue2 = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    boolean z3 = yTItem2 instanceof SongItem;
                                    MenuState menuState3 = menuState;
                                    if (z3) {
                                        gapComposer2.startReplaceGroup(256979046);
                                        SongItem songItem2 = (SongItem) yTItem2;
                                        boolean zChanged7 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                                        if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 22);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                                            objRememberedValue7 = homeScreenKt$HomeScreen$8$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem2, (Function0) ((KFunction) objRememberedValue7), null, gapComposer2, 0, 4);
                                        gapComposer2.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer2.startReplaceGroup(257658752);
                                        AlbumItem albumItem2 = (AlbumItem) yTItem2;
                                        boolean zChanged8 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                                        if (zChanged8 || objRememberedValue8 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 23);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                                            objRememberedValue8 = homeScreenKt$HomeScreen$8$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) ((KFunction) objRememberedValue8), gapComposer2, 0);
                                        gapComposer2.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer2.startReplaceGroup(258345154);
                                        ArtistItem artistItem2 = (ArtistItem) yTItem2;
                                        boolean zChanged9 = gapComposer2.changed(menuState3);
                                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                                        if (zChanged9 || objRememberedValue9 == neverEqualPolicy) {
                                            HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$3 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 24);
                                            gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$3);
                                            objRememberedValue9 = homeScreenKt$HomeScreen$8$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem2, (Function0) ((KFunction) objRememberedValue9), gapComposer2, 0);
                                        gapComposer2.end(false);
                                    } else {
                                        boolean z4 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope3 = coroutineScope;
                                        if (z4) {
                                            gapComposer2.startReplaceGroup(259035710);
                                            PlaylistItem playlistItem2 = (PlaylistItem) yTItem2;
                                            boolean zChanged10 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue10 = gapComposer2.rememberedValue();
                                            if (zChanged10 || objRememberedValue10 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$4 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 25);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$4);
                                                objRememberedValue10 = homeScreenKt$HomeScreen$8$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem2, null, coroutineScope3, (Function0) ((KFunction) objRememberedValue10), null, gapComposer2, 0, 50);
                                            gapComposer2.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer2.startReplaceGroup(259852653);
                                            PlaylistItem playlistItemAsPlaylistItem2 = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged11 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue11 = gapComposer2.rememberedValue();
                                            if (zChanged11 || objRememberedValue11 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$5 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 26);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$5);
                                                objRememberedValue11 = homeScreenKt$HomeScreen$8$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem2, null, coroutineScope3, (Function0) ((KFunction) objRememberedValue11), null, gapComposer2, 0, 50);
                                            gapComposer2.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 1532310264, false);
                                            }
                                            gapComposer2.startReplaceGroup(260681593);
                                            SongItem songItemAsSongItem2 = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged12 = gapComposer2.changed(menuState3);
                                            Object objRememberedValue12 = gapComposer2.rememberedValue();
                                            if (zChanged12 || objRememberedValue12 == neverEqualPolicy) {
                                                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$6 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 27);
                                                gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$6);
                                                objRememberedValue12 = homeScreenKt$HomeScreen$8$6;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem2, (Function0) ((KFunction) objRememberedValue12), null, gapComposer2, 0, 4);
                                            gapComposer2.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return unit2;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue3 = ((Integer) obj3).intValue();
                                ((ColumnScopeInstance) obj).getClass();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                    boolean z5 = yTItem2 instanceof SongItem;
                                    MenuState menuState4 = menuState;
                                    if (z5) {
                                        gapComposer3.startReplaceGroup(1610222546);
                                        SongItem songItem3 = (SongItem) yTItem2;
                                        boolean zChanged13 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue13 = gapComposer3.rememberedValue();
                                        if (zChanged13 || objRememberedValue13 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 25);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                                            objRememberedValue13 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                                        }
                                        YouTubeSongMenuKt.YouTubeSongMenu(songItem3, (Function0) ((KFunction) objRememberedValue13), null, gapComposer3, 0, 4);
                                        gapComposer3.end(false);
                                    } else if (yTItem2 instanceof AlbumItem) {
                                        gapComposer3.startReplaceGroup(1610449900);
                                        AlbumItem albumItem3 = (AlbumItem) yTItem2;
                                        boolean zChanged14 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue14 = gapComposer3.rememberedValue();
                                        if (zChanged14 || objRememberedValue14 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$2 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 26);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$2);
                                            objRememberedValue14 = autoPlaylistScreenKt$AutoPlaylistScreen$12$2;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem3, (Function0) ((KFunction) objRememberedValue14), gapComposer3, 0);
                                        gapComposer3.end(false);
                                    } else if (yTItem2 instanceof ArtistItem) {
                                        gapComposer3.startReplaceGroup(1610683950);
                                        ArtistItem artistItem3 = (ArtistItem) yTItem2;
                                        boolean zChanged15 = gapComposer3.changed(menuState4);
                                        Object objRememberedValue15 = gapComposer3.rememberedValue();
                                        if (zChanged15 || objRememberedValue15 == neverEqualPolicy) {
                                            AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$3 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 27);
                                            gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$3);
                                            objRememberedValue15 = autoPlaylistScreenKt$AutoPlaylistScreen$12$3;
                                        }
                                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem3, (Function0) ((KFunction) objRememberedValue15), gapComposer3, 0);
                                        gapComposer3.end(false);
                                    } else {
                                        boolean z6 = yTItem2 instanceof PlaylistItem;
                                        CoroutineScope coroutineScope4 = coroutineScope;
                                        if (z6) {
                                            gapComposer3.startReplaceGroup(1610920077);
                                            PlaylistItem playlistItem3 = (PlaylistItem) yTItem2;
                                            boolean zChanged16 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue16 = gapComposer3.rememberedValue();
                                            if (zChanged16 || objRememberedValue16 == neverEqualPolicy) {
                                                AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$4 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 28);
                                                gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$4);
                                                objRememberedValue16 = autoPlaylistScreenKt$AutoPlaylistScreen$12$4;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem3, null, coroutineScope4, (Function0) ((KFunction) objRememberedValue16), null, gapComposer3, 0, 50);
                                            gapComposer3.end(false);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            gapComposer3.startReplaceGroup(1611218204);
                                            PlaylistItem playlistItemAsPlaylistItem3 = ((PodcastItem) yTItem2).asPlaylistItem();
                                            boolean zChanged17 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue17 = gapComposer3.rememberedValue();
                                            if (zChanged17 || objRememberedValue17 == neverEqualPolicy) {
                                                AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$5 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 29);
                                                gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$5);
                                                objRememberedValue17 = autoPlaylistScreenKt$AutoPlaylistScreen$12$5;
                                            }
                                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem3, null, coroutineScope4, (Function0) ((KFunction) objRememberedValue17), null, gapComposer3, 0, 50);
                                            gapComposer3.end(false);
                                        } else {
                                            if (!(yTItem2 instanceof EpisodeItem)) {
                                                throw Format$$ExternalSyntheticOutline0.m(gapComposer3, 1437415814, false);
                                            }
                                            gapComposer3.startReplaceGroup(1611530405);
                                            SongItem songItemAsSongItem3 = ((EpisodeItem) yTItem2).asSongItem();
                                            boolean zChanged18 = gapComposer3.changed(menuState4);
                                            Object objRememberedValue18 = gapComposer3.rememberedValue();
                                            if (zChanged18 || objRememberedValue18 == neverEqualPolicy) {
                                                HazeEffectNode.AnonymousClass1 anonymousClass1 = new HazeEffectNode.AnonymousClass1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                                gapComposer3.updateRememberedValue(anonymousClass1);
                                                objRememberedValue18 = anonymousClass1;
                                            }
                                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem3, (Function0) ((KFunction) objRememberedValue18), null, gapComposer3, 0, 4);
                                            gapComposer3.end(false);
                                        }
                                    }
                                } else {
                                    gapComposer3.skipToGroupEnd();
                                }
                                return unit2;
                        }
                    }
                }));
                break;
        }
        return unit;
    }
}
