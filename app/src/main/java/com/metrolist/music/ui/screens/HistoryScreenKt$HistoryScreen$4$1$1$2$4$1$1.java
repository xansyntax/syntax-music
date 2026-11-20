package com.metrolist.music.ui.screens;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.viewmodels.HistoryViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HistoryScreenKt$HistoryScreen$4$1$1$2$4$1$1 implements Function0 {
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongItem $song;
    public final /* synthetic */ HistoryViewModel $viewModel;

    public /* synthetic */ HistoryScreenKt$HistoryScreen$4$1$1$2$4$1$1(byte b, SongItem songItem, MenuState menuState, HistoryViewModel historyViewModel) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$song = songItem;
        this.$viewModel = historyViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        HistoryViewModel historyViewModel = this.$viewModel;
        SongItem songItem = this.$song;
        MenuState menuState = this.$menuState;
        byte b2 = 1;
        switch (b) {
            case 0:
                menuState.show(new ComposableLambdaImpl(true, -1074086888, new HistoryScreenKt$HistoryScreen$4$1$1$2$4$3(b2, songItem, menuState, historyViewModel)));
                break;
            default:
                menuState.show(new ComposableLambdaImpl(true, 1497383433, new HistoryScreenKt$HistoryScreen$4$1$1$2$4$3((byte) 2, songItem, menuState, historyViewModel)));
                break;
        }
        return unit;
    }
}
