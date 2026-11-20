package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.SongMenuKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3 implements Function3 {
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $song$delegate;

    public /* synthetic */ HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3(MenuState menuState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$song$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.$song$delegate;
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
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changed(mutableState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new Http2Connection.ReaderRunnable(menuState, mutableState, (byte) 8);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, AlbumScreenKt.lambda$787406454, gapComposer, 1572864, 62);
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
                    List list = HomeScreenKt.DailyDiscoverMessages;
                    Song song = (Song) mutableState.getValue();
                    song.getClass();
                    MenuState menuState2 = this.$menuState;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 18);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    SongMenuKt.SongMenu(song, null, null, null, (Function0) ((KFunction) objRememberedValue2), false, gapComposer2, 0, 46);
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
                    List list2 = HomeScreenKt.DailyDiscoverMessages;
                    Song song2 = (Song) mutableState.getValue();
                    song2.getClass();
                    MenuState menuState3 = this.$menuState;
                    boolean zChanged3 = gapComposer3.changed(menuState3);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 19);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    SongMenuKt.SongMenu(song2, null, null, null, (Function0) ((KFunction) objRememberedValue3), false, gapComposer3, 0, 46);
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
                    List list3 = HomeScreenKt.DailyDiscoverMessages;
                    Song song3 = (Song) mutableState.getValue();
                    song3.getClass();
                    MenuState menuState4 = this.$menuState;
                    boolean zChanged4 = gapComposer4.changed(menuState4);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new HomeScreenKt$HomeScreen$8$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 28);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    SongMenuKt.SongMenu(song3, null, null, null, (Function0) ((KFunction) objRememberedValue4), false, gapComposer4, 0, 46);
                }
                break;
            default:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    List list4 = HomeScreenKt.DailyDiscoverMessages;
                    Song song4 = (Song) mutableState.getValue();
                    song4.getClass();
                    MenuState menuState5 = this.$menuState;
                    boolean zChanged5 = gapComposer5.changed(menuState5);
                    Object objRememberedValue5 = gapComposer5.rememberedValue();
                    if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new HomeScreenKt$HomeScreen$8$1(0, menuState5, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 29);
                        gapComposer5.updateRememberedValue(objRememberedValue5);
                    }
                    SongMenuKt.SongMenu(song4, null, null, null, (Function0) ((KFunction) objRememberedValue5), false, gapComposer5, 0, 46);
                }
                break;
        }
        return unit;
    }
}
