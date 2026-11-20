package com.metrolist.music.ui.player;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.ui.component.MenuState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda34 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda34(MenuState menuState, List list, List list2, Function0 function0) {
        this.$r8$classId = (byte) 0;
        this.f$0 = menuState;
        this.f$1 = list;
        this.f$2 = list2;
        this.f$3 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                MenuState menuState = this.f$0;
                menuState.show(new ComposableLambdaImpl(true, -2114208975, new QueueKt$$ExternalSyntheticLambda42(menuState, this.f$1, this.f$2, this.f$3)));
                break;
            case 1:
                MenuState menuState2 = this.f$0;
                menuState2.show(new ComposableLambdaImpl(true, -818304326, new QueueKt$$ExternalSyntheticLambda42((byte) 1, menuState2, this.f$1, this.f$2, this.f$3)));
                break;
            case 2:
                MenuState menuState3 = this.f$0;
                menuState3.show(new ComposableLambdaImpl(true, -1153155541, new QueueKt$$ExternalSyntheticLambda42((byte) 2, menuState3, this.f$1, this.f$2, this.f$3)));
                break;
            default:
                MenuState menuState4 = this.f$0;
                menuState4.show(new ComposableLambdaImpl(true, -477729632, new QueueKt$$ExternalSyntheticLambda42((byte) 3, menuState4, this.f$1, this.f$2, this.f$3)));
                break;
        }
        return unit;
    }

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda34(byte b, MenuState menuState, List list, List list2, Function0 function0) {
        this.$r8$classId = b;
        this.f$0 = menuState;
        this.f$1 = list;
        this.f$3 = function0;
        this.f$2 = list2;
    }
}
