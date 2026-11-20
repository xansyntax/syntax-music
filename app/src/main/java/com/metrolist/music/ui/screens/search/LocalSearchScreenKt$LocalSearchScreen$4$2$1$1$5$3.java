package com.metrolist.music.ui.screens.search;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.SongMenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$3 implements Function3 {
    public final /* synthetic */ LocalItem $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ Function0 $onDismiss;
    public final /* synthetic */ byte $r8$classId;

    public LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$3(MenuState menuState, LocalItem localItem, Function0 function0) {
        this.$r8$classId = (byte) 0;
        this.$menuState = menuState;
        this.$item = localItem;
        this.$onDismiss = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        LocalItem localItem = this.$item;
        Function0 function0 = this.$onDismiss;
        MenuState menuState = this.$menuState;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(localItem) | gapComposer.changed(function0) | gapComposer.changed(false);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$1$1(b2, localItem, menuState, function0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, LocalSearchScreenKt.f432lambda$578453558, gapComposer, 1572864, 62);
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
                    Song song = (Song) localItem;
                    boolean zChanged2 = gapComposer2.changed(function0) | gapComposer2.changed(menuState);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(function0, menuState, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    SongMenuKt.SongMenu(song, null, null, null, (Function0) objRememberedValue2, false, gapComposer2, 0, 14);
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
                    Song song2 = (Song) localItem;
                    boolean zChanged3 = gapComposer3.changed(function0) | gapComposer3.changed(menuState);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(function0, menuState, (byte) 2);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    SongMenuKt.SongMenu(song2, null, null, null, (Function0) objRememberedValue3, false, gapComposer3, 0, 14);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$3(byte b, LocalItem localItem, MenuState menuState, Function0 function0) {
        this.$r8$classId = b;
        this.$item = localItem;
        this.$onDismiss = function0;
        this.$menuState = menuState;
    }
}
