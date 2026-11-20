package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumScreenKt$AlbumScreen$3$1$4$3 implements Function3 {
    public final /* synthetic */ MutableState $inSelectMode$delegate;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ Function1 $onCheckedChange;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $selection;
    public final /* synthetic */ Song $song;

    public /* synthetic */ AlbumScreenKt$AlbumScreen$3$1$4$3(List list, Song song, Function1 function1, MenuState menuState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$selection = list;
        this.$song = song;
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
        Song song = this.$song;
        MenuState menuState = this.$menuState;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(-915471658);
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changed(song);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(menuState, song, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, AlbumScreenKt.f307lambda$1503141254, gapComposer, 1572864, 62);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-915739312);
                    CardKt.Checkbox(list.contains(song.song.id), this.$onCheckedChange, null, false, null, gapComposer, 0);
                    gapComposer.end(false);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else if (!TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState)) {
                    gapComposer2.startReplaceGroup(1057436221);
                    boolean zChanged2 = gapComposer2.changed(menuState) | gapComposer2.changed(song);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(menuState, song, (byte) 5);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.IconButton((Function0) objRememberedValue2, null, false, null, null, TopPlaylistScreenKt.f386lambda$1333982029, gapComposer2, 1572864, 62);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(1057147363);
                    CardKt.Checkbox(list.contains(song.song.id), this.$onCheckedChange, null, false, null, gapComposer2, 0);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else if (!TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState)) {
                    gapComposer3.startReplaceGroup(1448267654);
                    boolean zChanged3 = gapComposer3.changed(menuState) | gapComposer3.changed(song);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(menuState, song, (byte) 6);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, TopPlaylistScreenKt.lambda$1974366418, gapComposer3, 1572864, 62);
                    gapComposer3.end(false);
                } else {
                    gapComposer3.startReplaceGroup(1448002077);
                    CardKt.Checkbox(list.contains(song.song.id), this.$onCheckedChange, null, false, null, gapComposer3, 0);
                    gapComposer3.end(false);
                }
                break;
            default:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else if (!TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState)) {
                    gapComposer4.startReplaceGroup(1229170813);
                    boolean zChanged4 = gapComposer4.changed(menuState) | gapComposer4.changed(song);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1(menuState, song, (byte) 7);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.IconButton((Function0) objRememberedValue4, null, false, null, null, TopPlaylistScreenKt.lambda$1945374039, gapComposer4, 1572864, 62);
                    gapComposer4.end(false);
                } else {
                    gapComposer4.startReplaceGroup(1228882916);
                    CardKt.Checkbox(list.contains(song.song.id), this.$onCheckedChange, null, false, null, gapComposer4, 0);
                    gapComposer4.end(false);
                }
                break;
        }
        return unit;
    }
}
