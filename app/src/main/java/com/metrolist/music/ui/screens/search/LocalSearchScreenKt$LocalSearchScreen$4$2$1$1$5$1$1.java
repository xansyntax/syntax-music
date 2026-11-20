package com.metrolist.music.ui.screens.search;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.ui.component.MenuState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$1$1 implements Function0 {
    public final /* synthetic */ LocalItem $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ Function0 $onDismiss;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$1$1(byte b, LocalItem localItem, MenuState menuState, Function0 function0) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$item = localItem;
        this.$onDismiss = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.$onDismiss;
        LocalItem localItem = this.$item;
        MenuState menuState = this.$menuState;
        byte b2 = 1;
        switch (b) {
            case 0:
                menuState.show(new ComposableLambdaImpl(true, 1982073403, new LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$3(b2, localItem, menuState, function0)));
                break;
            default:
                menuState.show(new ComposableLambdaImpl(true, 1932880470, new LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$3((byte) 2, localItem, menuState, function0)));
                break;
        }
        return unit;
    }
}
