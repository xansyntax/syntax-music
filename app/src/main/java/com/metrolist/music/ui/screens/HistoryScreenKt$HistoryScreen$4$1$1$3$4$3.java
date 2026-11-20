package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HistoryScreenKt$HistoryScreen$4$1$1$3$4$3 implements Function3 {
    public final /* synthetic */ Object $event;
    public final /* synthetic */ MutableState $inSelectMode$delegate;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ Function1 $onCheckedChange;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $selection;

    public /* synthetic */ HistoryScreenKt$HistoryScreen$4$1$1$3$4$3(List list, Object obj, Function1 function1, MenuState menuState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$selection = list;
        this.$event = obj;
        this.$onCheckedChange = function1;
        this.$menuState = menuState;
        this.$inSelectMode$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        List list = this.$selection;
        MutableState mutableState = this.$inSelectMode$delegate;
        Object obj4 = this.$event;
        MenuState menuState = this.$menuState;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                EventWithSong eventWithSong = (EventWithSong) obj4;
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else if (!AlbumScreenKt.HistoryScreen$lambda$4(mutableState)) {
                    gapComposer.startReplaceGroup(-262589713);
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changed(eventWithSong);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new Http2Connection.ReaderRunnable(menuState, eventWithSong, (byte) 6);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, AlbumScreenKt.lambda$1278110230, gapComposer, 1572864, 62);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-262887747);
                    CardKt.Checkbox(list.contains(Long.valueOf(eventWithSong.event.id)), this.$onCheckedChange, null, false, null, gapComposer, 0);
                    gapComposer.end(false);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Number) obj3).intValue();
                SongItem songItem = (SongItem) obj4;
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else if (!TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState)) {
                    gapComposer2.startReplaceGroup(824543590);
                    boolean zChanged2 = gapComposer2.changed(menuState) | gapComposer2.changedInstance(songItem);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3$1$1(menuState, songItem, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.IconButton((Function0) objRememberedValue2, null, false, null, null, TopPlaylistScreenKt.lambda$302097178, gapComposer2, 1572864, 62);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(824264156);
                    CardKt.Checkbox(((SnapshotStateList) list).contains(songItem.id), this.$onCheckedChange, null, false, null, gapComposer2, 0);
                    gapComposer2.end(false);
                }
                break;
        }
        return unit;
    }
}
