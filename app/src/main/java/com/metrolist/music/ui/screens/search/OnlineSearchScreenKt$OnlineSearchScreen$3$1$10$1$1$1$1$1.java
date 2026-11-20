package com.metrolist.music.ui.screens.search;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.component.MenuState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1 implements Function0 {
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ Function0 $onDismiss;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(MenuState menuState, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$onDismiss = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.$onDismiss;
        MenuState menuState = this.$menuState;
        switch (b) {
            case 0:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 1:
                function0.invoke();
                menuState.setVisible(false);
                break;
            case 2:
                function0.invoke();
                menuState.setVisible(false);
                break;
            case 3:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 4:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 5:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 6:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 7:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 8:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 9:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 10:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case 11:
                menuState.setVisible(false);
                function0.invoke();
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                menuState.setVisible(false);
                function0.invoke();
                break;
            default:
                menuState.setVisible(false);
                function0.invoke();
                break;
        }
        return unit;
    }

    public /* synthetic */ OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$1$1$1$1$1(Function0 function0, MenuState menuState, byte b) {
        this.$r8$classId = b;
        this.$onDismiss = function0;
        this.$menuState = menuState;
    }
}
