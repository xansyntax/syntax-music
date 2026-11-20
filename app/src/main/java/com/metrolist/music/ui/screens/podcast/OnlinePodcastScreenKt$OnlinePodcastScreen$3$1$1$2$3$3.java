package com.metrolist.music.ui.screens.podcast;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3 implements Function3 {
    public final /* synthetic */ EpisodeItem $episode;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;

    public OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3(MenuState menuState, EpisodeItem episodeItem) {
        this.$r8$classId = (byte) 0;
        this.$menuState = menuState;
        this.$episode = episodeItem;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        EpisodeItem episodeItem = this.$episode;
        byte b2 = 16;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MenuState menuState = this.$menuState;
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(episodeItem);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new Http2Connection.ReaderRunnable(menuState, episodeItem, b2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, OnlinePodcastScreenKt.lambda$704364238, gapComposer, 1572864, 62);
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
                    SongItem songItemAsSongItem = episodeItem.asSongItem();
                    MenuState menuState2 = this.$menuState;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 23);
                        gapComposer2.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                        objRememberedValue2 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem, (Function0) ((KFunction) objRememberedValue2), null, gapComposer2, 0, 4);
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
                    SongItem songItemAsSongItem2 = episodeItem.asSongItem();
                    MenuState menuState3 = this.$menuState;
                    boolean zChanged3 = gapComposer3.changed(menuState3);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$2 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 24);
                        gapComposer3.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$2);
                        objRememberedValue3 = autoPlaylistScreenKt$AutoPlaylistScreen$12$2;
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(songItemAsSongItem2, (Function0) ((KFunction) objRememberedValue3), null, gapComposer3, 0, 4);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3(EpisodeItem episodeItem, MenuState menuState, byte b) {
        this.$r8$classId = b;
        this.$episode = episodeItem;
        this.$menuState = menuState;
    }
}
