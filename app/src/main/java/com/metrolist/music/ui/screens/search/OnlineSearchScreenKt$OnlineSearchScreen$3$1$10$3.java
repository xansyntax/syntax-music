package com.metrolist.music.ui.screens.search;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
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
import com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$7$1$1$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$3 implements Function3 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ YTItem $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ Function0 $onDismiss;
    public final /* synthetic */ byte $r8$classId;

    public OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$3(MenuState menuState, YTItem yTItem, Function0 function0, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 0;
        this.$menuState = menuState;
        this.$item = yTItem;
        this.$onDismiss = function0;
        this.$coroutineScope = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        MenuState menuState = this.$menuState;
        Function0 function0 = this.$onDismiss;
        YTItem yTItem = this.$item;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    MenuState menuState2 = this.$menuState;
                    boolean zChanged = gapComposer.changed(menuState2);
                    YTItem yTItem2 = this.$item;
                    boolean zChangedInstance = zChanged | gapComposer.changedInstance(yTItem2);
                    Function0 function1 = this.$onDismiss;
                    boolean zChanged2 = zChangedInstance | gapComposer.changed(function1);
                    CoroutineScope coroutineScope = this.$coroutineScope;
                    boolean zChangedInstance2 = gapComposer.changedInstance(coroutineScope) | zChanged2;
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue == neverEqualPolicy) {
                        QueueKt$Queue$5$4$1$1$7$1$1$1 queueKt$Queue$5$4$1$1$7$1$1$1 = new QueueKt$Queue$5$4$1$1$7$1$1$1(menuState2, (Object) yTItem2, (Object) function1, (Object) coroutineScope, (byte) 5);
                        gapComposer.updateRememberedValue(queueKt$Queue$5$4$1$1$7$1$1$1);
                        objRememberedValue = queueKt$Queue$5$4$1$1$7$1$1$1;
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, LocalSearchScreenKt.lambda$315531498, gapComposer, 1572864, 62);
                } else {
                    gapComposer.skipToGroupEnd();
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
                            gapComposer2.startReplaceGroup(283167193);
                            SongItem songItem = (SongItem) yTItem;
                            boolean zChanged3 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            YouTubeSongMenuKt.YouTubeSongMenu(songItem, (Function0) objRememberedValue2, null, gapComposer2, 0, 4);
                            gapComposer2.end(false);
                        } else if (yTItem instanceof AlbumItem) {
                            gapComposer2.startReplaceGroup(283681235);
                            AlbumItem albumItem = (AlbumItem) yTItem;
                            boolean zChanged4 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                                objRememberedValue3 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 3);
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem, (Function0) objRememberedValue3, gapComposer2, 0);
                            gapComposer2.end(false);
                        } else if (yTItem instanceof ArtistItem) {
                            gapComposer2.startReplaceGroup(284201973);
                            ArtistItem artistItem = (ArtistItem) yTItem;
                            boolean zChanged5 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue4 = gapComposer2.rememberedValue();
                            if (zChanged5 || objRememberedValue4 == neverEqualPolicy) {
                                objRememberedValue4 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 4);
                                gapComposer2.updateRememberedValue(objRememberedValue4);
                            }
                            YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem, (Function0) objRememberedValue4, gapComposer2, 0);
                            gapComposer2.end(false);
                        } else if (yTItem instanceof PlaylistItem) {
                            gapComposer2.startReplaceGroup(284725408);
                            PlaylistItem playlistItem = (PlaylistItem) yTItem;
                            boolean zChanged6 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue5 = gapComposer2.rememberedValue();
                            if (zChanged6 || objRememberedValue5 == neverEqualPolicy) {
                                objRememberedValue5 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 5);
                                gapComposer2.updateRememberedValue(objRememberedValue5);
                            }
                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, null, this.$coroutineScope, (Function0) objRememberedValue5, null, gapComposer2, 0, 50);
                            gapComposer2.end(false);
                        } else if (yTItem instanceof PodcastItem) {
                            gapComposer2.startReplaceGroup(285330063);
                            PlaylistItem playlistItemAsPlaylistItem = ((PodcastItem) yTItem).asPlaylistItem();
                            boolean zChanged7 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue6 = gapComposer2.rememberedValue();
                            if (zChanged7 || objRememberedValue6 == neverEqualPolicy) {
                                objRememberedValue6 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 6);
                                gapComposer2.updateRememberedValue(objRememberedValue6);
                            }
                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem, null, this.$coroutineScope, (Function0) objRememberedValue6, null, gapComposer2, 0, 50);
                            gapComposer2.end(false);
                        } else if (yTItem instanceof EpisodeItem) {
                            gapComposer2.startReplaceGroup(285948172);
                            SongItem songItemAsSongItem = ((EpisodeItem) yTItem).asSongItem();
                            boolean zChanged8 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue7 = gapComposer2.rememberedValue();
                            if (zChanged8 || objRememberedValue7 == neverEqualPolicy) {
                                objRememberedValue7 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 7);
                                gapComposer2.updateRememberedValue(objRememberedValue7);
                            }
                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem, (Function0) objRememberedValue7, null, gapComposer2, 0, 4);
                            gapComposer2.end(false);
                        }
                    }
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer2, -545054188, false);
                }
                gapComposer2.skipToGroupEnd();
                return unit;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    if (yTItem != null) {
                        if (yTItem instanceof SongItem) {
                            gapComposer3.startReplaceGroup(-746320320);
                            SongItem songItem2 = (SongItem) yTItem;
                            boolean zChanged9 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue8 = gapComposer3.rememberedValue();
                            if (zChanged9 || objRememberedValue8 == neverEqualPolicy) {
                                objRememberedValue8 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 8);
                                gapComposer3.updateRememberedValue(objRememberedValue8);
                            }
                            YouTubeSongMenuKt.YouTubeSongMenu(songItem2, (Function0) objRememberedValue8, null, gapComposer3, 0, 4);
                            gapComposer3.end(false);
                        } else if (yTItem instanceof AlbumItem) {
                            gapComposer3.startReplaceGroup(-745841990);
                            AlbumItem albumItem2 = (AlbumItem) yTItem;
                            boolean zChanged10 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue9 = gapComposer3.rememberedValue();
                            if (zChanged10 || objRememberedValue9 == neverEqualPolicy) {
                                objRememberedValue9 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 9);
                                gapComposer3.updateRememberedValue(objRememberedValue9);
                            }
                            YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) objRememberedValue9, gapComposer3, 0);
                            gapComposer3.end(false);
                        } else if (yTItem instanceof ArtistItem) {
                            gapComposer3.startReplaceGroup(-745356964);
                            ArtistItem artistItem2 = (ArtistItem) yTItem;
                            boolean zChanged11 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue10 = gapComposer3.rememberedValue();
                            if (zChanged11 || objRememberedValue10 == neverEqualPolicy) {
                                objRememberedValue10 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 10);
                                gapComposer3.updateRememberedValue(objRememberedValue10);
                            }
                            YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem2, (Function0) objRememberedValue10, gapComposer3, 0);
                            gapComposer3.end(false);
                        } else if (yTItem instanceof PlaylistItem) {
                            gapComposer3.startReplaceGroup(-744869365);
                            PlaylistItem playlistItem2 = (PlaylistItem) yTItem;
                            boolean zChanged12 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue11 = gapComposer3.rememberedValue();
                            if (zChanged12 || objRememberedValue11 == neverEqualPolicy) {
                                objRememberedValue11 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 11);
                                gapComposer3.updateRememberedValue(objRememberedValue11);
                            }
                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem2, null, this.$coroutineScope, (Function0) objRememberedValue11, null, gapComposer3, 0, 50);
                            gapComposer3.end(false);
                        } else if (yTItem instanceof PodcastItem) {
                            gapComposer3.startReplaceGroup(-744304390);
                            PlaylistItem playlistItemAsPlaylistItem2 = ((PodcastItem) yTItem).asPlaylistItem();
                            boolean zChanged13 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue12 = gapComposer3.rememberedValue();
                            if (zChanged13 || objRememberedValue12 == neverEqualPolicy) {
                                objRememberedValue12 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 12);
                                gapComposer3.updateRememberedValue(objRememberedValue12);
                            }
                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem2, null, this.$coroutineScope, (Function0) objRememberedValue12, null, gapComposer3, 0, 50);
                            gapComposer3.end(false);
                        } else if (yTItem instanceof EpisodeItem) {
                            gapComposer3.startReplaceGroup(-743725837);
                            SongItem songItemAsSongItem2 = ((EpisodeItem) yTItem).asSongItem();
                            boolean zChanged14 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue13 = gapComposer3.rememberedValue();
                            if (zChanged14 || objRememberedValue13 == neverEqualPolicy) {
                                objRememberedValue13 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(menuState, function0, (byte) 13);
                                gapComposer3.updateRememberedValue(objRememberedValue13);
                            }
                            YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem2, (Function0) objRememberedValue13, null, gapComposer3, 0, 4);
                            gapComposer3.end(false);
                        }
                    }
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer3, -993905527, false);
                }
                gapComposer3.skipToGroupEnd();
                return unit;
        }
    }

    public /* synthetic */ OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$3(YTItem yTItem, MenuState menuState, Function0 function0, CoroutineScope coroutineScope, byte b) {
        this.$r8$classId = b;
        this.$item = yTItem;
        this.$menuState = menuState;
        this.$onDismiss = function0;
        this.$coroutineScope = coroutineScope;
    }
}
