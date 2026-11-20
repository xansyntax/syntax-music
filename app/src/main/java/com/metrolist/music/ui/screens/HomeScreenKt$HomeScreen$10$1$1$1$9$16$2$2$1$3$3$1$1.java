package com.metrolist.music.ui.screens;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.ui.component.MenuState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3$1$1 implements Function0 {
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongItem $song;

    public /* synthetic */ HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3$1$1(MenuState menuState, SongItem songItem, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$song = songItem;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SongItem songItem = this.$song;
        MenuState menuState = this.$menuState;
        switch (b) {
            case 0:
                menuState.show(new ComposableLambdaImpl(true, 1254781194, new HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3(songItem, menuState, (byte) 6)));
                break;
            case 1:
                menuState.show(new ComposableLambdaImpl(true, -1555786772, new HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3(songItem, menuState, (byte) 2)));
                break;
            default:
                menuState.show(new ComposableLambdaImpl(true, -12457714, new HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3(songItem, menuState, (byte) 7)));
                break;
        }
        return unit;
    }
}
