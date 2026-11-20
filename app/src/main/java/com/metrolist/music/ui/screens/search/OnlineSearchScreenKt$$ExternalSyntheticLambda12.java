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
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda30;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OnlineSearchScreenKt$$ExternalSyntheticLambda12 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;
    public final /* synthetic */ YTItem f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ CoroutineScope f$3;

    public /* synthetic */ OnlineSearchScreenKt$$ExternalSyntheticLambda12(MenuState menuState, YTItem yTItem, Function0 function0, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 0;
        this.f$0 = menuState;
        this.f$1 = yTItem;
        this.f$2 = function0;
        this.f$3 = coroutineScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        final Function0 function0 = this.f$2;
        final MenuState menuState = this.f$0;
        YTItem yTItem = this.f$1;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object[] objArr = 0;
        final byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    MenuState menuState2 = this.f$0;
                    boolean zChanged = gapComposer.changed(menuState2);
                    YTItem yTItem2 = this.f$1;
                    boolean zChangedInstance = zChanged | gapComposer.changedInstance(yTItem2);
                    Function0 function1 = this.f$2;
                    boolean zChanged2 = zChangedInstance | gapComposer.changed(function1);
                    CoroutineScope coroutineScope = this.f$3;
                    boolean zChangedInstance2 = gapComposer.changedInstance(coroutineScope) | zChanged2;
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue == neverEqualPolicy) {
                        AlarmSettingsKt$$ExternalSyntheticLambda30 alarmSettingsKt$$ExternalSyntheticLambda30 = new AlarmSettingsKt$$ExternalSyntheticLambda30(menuState2, yTItem2, function1, coroutineScope, (byte) 5);
                        gapComposer.updateRememberedValue(alarmSettingsKt$$ExternalSyntheticLambda30);
                        objRememberedValue = alarmSettingsKt$$ExternalSyntheticLambda30;
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, LocalSearchScreenKt.f433lambda$651962542, gapComposer, 1572864, 62);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    if (yTItem != null) {
                        if (yTItem instanceof SongItem) {
                            gapComposer2.startReplaceGroup(-1691682601);
                            SongItem songItem = (SongItem) yTItem;
                            boolean zChanged3 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                                final Object[] objArr2 = objArr == true ? 1 : 0;
                                objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b3 = objArr2;
                                        Unit unit2 = Unit.INSTANCE;
                                        Function0 function2 = function0;
                                        MenuState menuState3 = menuState;
                                        switch (b3) {
                                            case 0:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 1:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 2:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 3:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 4:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 5:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 6:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 7:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 8:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 9:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 10:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            default:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            YouTubeSongMenuKt.YouTubeSongMenu(songItem, (Function0) objRememberedValue2, null, gapComposer2, 0, 4);
                            gapComposer2.end(false);
                        } else if (yTItem instanceof AlbumItem) {
                            gapComposer2.startReplaceGroup(-1691132847);
                            AlbumItem albumItem = (AlbumItem) yTItem;
                            boolean zChanged4 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                                objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b3 = b2;
                                        Unit unit2 = Unit.INSTANCE;
                                        Function0 function2 = function0;
                                        MenuState menuState3 = menuState;
                                        switch (b3) {
                                            case 0:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 1:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 2:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 3:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 4:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 5:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 6:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 7:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 8:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 9:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 10:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            default:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem, (Function0) objRememberedValue3, gapComposer2, 0);
                            gapComposer2.end(false);
                        } else if (yTItem instanceof ArtistItem) {
                            gapComposer2.startReplaceGroup(-1690576397);
                            ArtistItem artistItem = (ArtistItem) yTItem;
                            boolean zChanged5 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                            Object objRememberedValue4 = gapComposer2.rememberedValue();
                            if (zChanged5 || objRememberedValue4 == neverEqualPolicy) {
                                final byte b3 = 2;
                                objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b4 = b3;
                                        Unit unit2 = Unit.INSTANCE;
                                        Function0 function2 = function0;
                                        MenuState menuState3 = menuState;
                                        switch (b4) {
                                            case 0:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 1:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 2:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 3:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 4:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 5:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 6:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 7:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 8:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 9:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 10:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            default:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer2.updateRememberedValue(objRememberedValue4);
                            }
                            YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem, (Function0) objRememberedValue4, gapComposer2, 0);
                            gapComposer2.end(false);
                        } else {
                            boolean z = yTItem instanceof PlaylistItem;
                            CoroutineScope coroutineScope2 = this.f$3;
                            if (z) {
                                gapComposer2.startReplaceGroup(-1690017126);
                                PlaylistItem playlistItem = (PlaylistItem) yTItem;
                                boolean zChanged6 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                                Object objRememberedValue5 = gapComposer2.rememberedValue();
                                if (zChanged6 || objRememberedValue5 == neverEqualPolicy) {
                                    final byte b4 = 3;
                                    objRememberedValue5 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b5 = b4;
                                            Unit unit2 = Unit.INSTANCE;
                                            Function0 function2 = function0;
                                            MenuState menuState3 = menuState;
                                            switch (b5) {
                                                case 0:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 1:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 2:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 3:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 4:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 5:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 6:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 7:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 8:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 9:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 10:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                default:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    };
                                    gapComposer2.updateRememberedValue(objRememberedValue5);
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, null, coroutineScope2, (Function0) objRememberedValue5, null, gapComposer2, 0, 50);
                                gapComposer2.end(false);
                            } else if (yTItem instanceof PodcastItem) {
                                gapComposer2.startReplaceGroup(-1689372791);
                                PlaylistItem playlistItemAsPlaylistItem = ((PodcastItem) yTItem).asPlaylistItem();
                                boolean zChanged7 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                                Object objRememberedValue6 = gapComposer2.rememberedValue();
                                if (zChanged7 || objRememberedValue6 == neverEqualPolicy) {
                                    final byte b5 = 4;
                                    objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b6 = b5;
                                            Unit unit2 = Unit.INSTANCE;
                                            Function0 function2 = function0;
                                            MenuState menuState3 = menuState;
                                            switch (b6) {
                                                case 0:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 1:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 2:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 3:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 4:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 5:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 6:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 7:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 8:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 9:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 10:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                default:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    };
                                    gapComposer2.updateRememberedValue(objRememberedValue6);
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem, null, coroutineScope2, (Function0) objRememberedValue6, null, gapComposer2, 0, 50);
                                gapComposer2.end(false);
                            } else if (yTItem instanceof EpisodeItem) {
                                gapComposer2.startReplaceGroup(-1688715126);
                                SongItem songItemAsSongItem = ((EpisodeItem) yTItem).asSongItem();
                                boolean zChanged8 = gapComposer2.changed(menuState) | gapComposer2.changed(function0);
                                Object objRememberedValue7 = gapComposer2.rememberedValue();
                                if (zChanged8 || objRememberedValue7 == neverEqualPolicy) {
                                    final byte b6 = 5;
                                    objRememberedValue7 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b7 = b6;
                                            Unit unit2 = Unit.INSTANCE;
                                            Function0 function2 = function0;
                                            MenuState menuState3 = menuState;
                                            switch (b7) {
                                                case 0:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 1:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 2:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 3:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 4:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 5:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 6:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 7:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 8:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 9:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 10:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                default:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    };
                                    gapComposer2.updateRememberedValue(objRememberedValue7);
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem, (Function0) objRememberedValue7, null, gapComposer2, 0, 4);
                                gapComposer2.end(false);
                            }
                        }
                    }
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 1607998362, false);
                }
                gapComposer2.skipToGroupEnd();
                return unit;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    if (yTItem != null) {
                        if (yTItem instanceof SongItem) {
                            gapComposer3.startReplaceGroup(-526756528);
                            SongItem songItem2 = (SongItem) yTItem;
                            boolean zChanged9 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue8 = gapComposer3.rememberedValue();
                            if (zChanged9 || objRememberedValue8 == neverEqualPolicy) {
                                final byte b7 = 6;
                                objRememberedValue8 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b8 = b7;
                                        Unit unit2 = Unit.INSTANCE;
                                        Function0 function2 = function0;
                                        MenuState menuState3 = menuState;
                                        switch (b8) {
                                            case 0:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 1:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 2:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 3:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 4:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 5:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 6:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 7:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 8:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 9:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 10:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            default:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer3.updateRememberedValue(objRememberedValue8);
                            }
                            YouTubeSongMenuKt.YouTubeSongMenu(songItem2, (Function0) objRememberedValue8, null, gapComposer3, 0, 4);
                            gapComposer3.end(false);
                        } else if (yTItem instanceof AlbumItem) {
                            gapComposer3.startReplaceGroup(-526242486);
                            AlbumItem albumItem2 = (AlbumItem) yTItem;
                            boolean zChanged10 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue9 = gapComposer3.rememberedValue();
                            if (zChanged10 || objRememberedValue9 == neverEqualPolicy) {
                                final byte b8 = 7;
                                objRememberedValue9 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b9 = b8;
                                        Unit unit2 = Unit.INSTANCE;
                                        Function0 function2 = function0;
                                        MenuState menuState3 = menuState;
                                        switch (b9) {
                                            case 0:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 1:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 2:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 3:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 4:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 5:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 6:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 7:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 8:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 9:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 10:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            default:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer3.updateRememberedValue(objRememberedValue9);
                            }
                            YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem2, (Function0) objRememberedValue9, gapComposer3, 0);
                            gapComposer3.end(false);
                        } else if (yTItem instanceof ArtistItem) {
                            gapComposer3.startReplaceGroup(-525721748);
                            ArtistItem artistItem2 = (ArtistItem) yTItem;
                            boolean zChanged11 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                            Object objRememberedValue10 = gapComposer3.rememberedValue();
                            if (zChanged11 || objRememberedValue10 == neverEqualPolicy) {
                                final byte b9 = 8;
                                objRememberedValue10 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b10 = b9;
                                        Unit unit2 = Unit.INSTANCE;
                                        Function0 function2 = function0;
                                        MenuState menuState3 = menuState;
                                        switch (b10) {
                                            case 0:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 1:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 2:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 3:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 4:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 5:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 6:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 7:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 8:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 9:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            case 10:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                            default:
                                                menuState3.setVisible(false);
                                                function2.invoke();
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer3.updateRememberedValue(objRememberedValue10);
                            }
                            YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem2, (Function0) objRememberedValue10, gapComposer3, 0);
                            gapComposer3.end(false);
                        } else {
                            boolean z2 = yTItem instanceof PlaylistItem;
                            CoroutineScope coroutineScope3 = this.f$3;
                            if (z2) {
                                gapComposer3.startReplaceGroup(-525198313);
                                PlaylistItem playlistItem2 = (PlaylistItem) yTItem;
                                boolean zChanged12 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                                Object objRememberedValue11 = gapComposer3.rememberedValue();
                                if (zChanged12 || objRememberedValue11 == neverEqualPolicy) {
                                    final byte b10 = 9;
                                    objRememberedValue11 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b11 = b10;
                                            Unit unit2 = Unit.INSTANCE;
                                            Function0 function2 = function0;
                                            MenuState menuState3 = menuState;
                                            switch (b11) {
                                                case 0:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 1:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 2:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 3:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 4:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 5:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 6:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 7:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 8:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 9:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 10:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                default:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    };
                                    gapComposer3.updateRememberedValue(objRememberedValue11);
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem2, null, coroutineScope3, (Function0) objRememberedValue11, null, gapComposer3, 0, 50);
                                gapComposer3.end(false);
                            } else if (yTItem instanceof PodcastItem) {
                                gapComposer3.startReplaceGroup(-524593658);
                                PlaylistItem playlistItemAsPlaylistItem2 = ((PodcastItem) yTItem).asPlaylistItem();
                                boolean zChanged13 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                                Object objRememberedValue12 = gapComposer3.rememberedValue();
                                if (zChanged13 || objRememberedValue12 == neverEqualPolicy) {
                                    final byte b11 = 10;
                                    objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b12 = b11;
                                            Unit unit2 = Unit.INSTANCE;
                                            Function0 function2 = function0;
                                            MenuState menuState3 = menuState;
                                            switch (b12) {
                                                case 0:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 1:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 2:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 3:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 4:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 5:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 6:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 7:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 8:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 9:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 10:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                default:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    };
                                    gapComposer3.updateRememberedValue(objRememberedValue12);
                                }
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItemAsPlaylistItem2, null, coroutineScope3, (Function0) objRememberedValue12, null, gapComposer3, 0, 50);
                                gapComposer3.end(false);
                            } else if (yTItem instanceof EpisodeItem) {
                                gapComposer3.startReplaceGroup(-523975549);
                                SongItem songItemAsSongItem2 = ((EpisodeItem) yTItem).asSongItem();
                                boolean zChanged14 = gapComposer3.changed(menuState) | gapComposer3.changed(function0);
                                Object objRememberedValue13 = gapComposer3.rememberedValue();
                                if (zChanged14 || objRememberedValue13 == neverEqualPolicy) {
                                    final byte b12 = 11;
                                    objRememberedValue13 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda18
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b13 = b12;
                                            Unit unit2 = Unit.INSTANCE;
                                            Function0 function2 = function0;
                                            MenuState menuState3 = menuState;
                                            switch (b13) {
                                                case 0:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 1:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 2:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 3:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 4:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 5:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 6:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 7:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 8:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 9:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                case 10:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                                default:
                                                    menuState3.setVisible(false);
                                                    function2.invoke();
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    };
                                    gapComposer3.updateRememberedValue(objRememberedValue13);
                                }
                                YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem2, (Function0) objRememberedValue13, null, gapComposer3, 0, 4);
                                gapComposer3.end(false);
                            }
                        }
                    }
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer3, 121555901, false);
                }
                gapComposer3.skipToGroupEnd();
                return unit;
        }
    }

    public /* synthetic */ OnlineSearchScreenKt$$ExternalSyntheticLambda12(YTItem yTItem, MenuState menuState, Function0 function0, CoroutineScope coroutineScope, byte b) {
        this.$r8$classId = b;
        this.f$1 = yTItem;
        this.f$0 = menuState;
        this.f$2 = function0;
        this.f$3 = coroutineScope;
    }
}
