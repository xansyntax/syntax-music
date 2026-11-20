package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt;
import com.metrolist.music.viewmodels.HistoryViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HistoryScreenKt$HistoryScreen$4$1$1$2$4$3 implements Function3 {
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongItem $song;
    public final /* synthetic */ HistoryViewModel $viewModel;

    public HistoryScreenKt$HistoryScreen$4$1$1$2$4$3(HistoryViewModel historyViewModel, MenuState menuState, SongItem songItem) {
        this.$r8$classId = (byte) 0;
        this.$viewModel = historyViewModel;
        this.$menuState = menuState;
        this.$song = songItem;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object obj4;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        final HistoryViewModel historyViewModel = this.$viewModel;
        boolean z = false;
        final byte b2 = 1;
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
                    boolean zChanged = gapComposer.changed(menuState);
                    SongItem songItem = this.$song;
                    boolean zChangedInstance = zChanged | gapComposer.changedInstance(songItem) | gapComposer.changedInstance(historyViewModel);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        obj4 = objRememberedValue;
                        HistoryScreenKt$HistoryScreen$4$1$1$2$4$1$1 historyScreenKt$HistoryScreen$4$1$1$2$4$1$1 = new HistoryScreenKt$HistoryScreen$4$1$1$2$4$1$1(b2, songItem, menuState, historyViewModel);
                        gapComposer.updateRememberedValue(historyScreenKt$HistoryScreen$4$1$1$2$4$1$1);
                        obj4 = historyScreenKt$HistoryScreen$4$1$1$2$4$1$1;
                    }
                    CardKt.IconButton((Function0) obj4, null, false, null, null, AlbumScreenKt.lambda$696152853, gapComposer, 1572864, 62);
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
                    MenuState menuState2 = this.$menuState;
                    boolean zChanged2 = gapComposer2.changed(menuState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 14);
                        gapComposer2.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                        objRememberedValue2 = homeScreenKt$HomeScreen$8$1;
                    }
                    Function0 function0 = (Function0) ((KFunction) objRememberedValue2);
                    boolean zChangedInstance2 = gapComposer2.changedInstance(historyViewModel);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                        final byte b3 = z ? (byte) 1 : (byte) 0;
                        objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.screens.HistoryScreenKt$HistoryScreen$4$1$1$2$4$1$1$1$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                HistoryViewModel historyViewModel2 = historyViewModel;
                                switch (b4) {
                                    case 0:
                                        historyViewModel2.fetchRemoteHistory();
                                        break;
                                    default:
                                        historyViewModel2.fetchRemoteHistory();
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.$song, function0, (Function0) objRememberedValue3, gapComposer2, 0, 0);
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
                    MenuState menuState3 = this.$menuState;
                    boolean zChanged3 = gapComposer3.changed(menuState3);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue4 == neverEqualPolicy) {
                        HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$2 = new HomeScreenKt$HomeScreen$8$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 15);
                        gapComposer3.updateRememberedValue(homeScreenKt$HomeScreen$8$2);
                        objRememberedValue4 = homeScreenKt$HomeScreen$8$2;
                    }
                    Function0 function1 = (Function0) ((KFunction) objRememberedValue4);
                    boolean zChangedInstance3 = gapComposer3.changedInstance(historyViewModel);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new Function0() { // from class: com.metrolist.music.ui.screens.HistoryScreenKt$HistoryScreen$4$1$1$2$4$1$1$1$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                HistoryViewModel historyViewModel2 = historyViewModel;
                                switch (b4) {
                                    case 0:
                                        historyViewModel2.fetchRemoteHistory();
                                        break;
                                    default:
                                        historyViewModel2.fetchRemoteHistory();
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.$song, function1, (Function0) objRememberedValue5, gapComposer3, 0, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ HistoryScreenKt$HistoryScreen$4$1$1$2$4$3(byte b, SongItem songItem, MenuState menuState, HistoryViewModel historyViewModel) {
        this.$r8$classId = b;
        this.$song = songItem;
        this.$menuState = menuState;
        this.$viewModel = historyViewModel;
    }
}
