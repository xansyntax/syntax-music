package com.metrolist.music.ui.screens;

import com.metrolist.music.ui.component.MenuState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda120 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda120(MenuState menuState, byte b) {
        this.$r8$classId = b;
        this.f$0 = menuState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MenuState menuState = this.f$0;
        switch (b) {
            case 0:
                menuState.setVisible(false);
                break;
            case 1:
                menuState.setVisible(false);
                break;
            case 2:
                menuState.setVisible(false);
                break;
            case 3:
                menuState.setVisible(false);
                break;
            default:
                menuState.setVisible(false);
                break;
        }
        return unit;
    }
}
