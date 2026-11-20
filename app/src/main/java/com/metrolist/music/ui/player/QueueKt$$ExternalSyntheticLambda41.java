package com.metrolist.music.ui.player;

import androidx.compose.material3.SwitchColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.MenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda41 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Modifier f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ int f$6;
    public final /* synthetic */ byte f$7;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ QueueKt$$ExternalSyntheticLambda41(Integer num, MediaMetadata mediaMetadata, Modifier modifier, boolean z, boolean z2, Function3 function3, int i, int i2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = num;
        this.f$1 = mediaMetadata;
        this.f$2 = modifier;
        this.f$3 = z;
        this.f$4 = z2;
        this.f$5 = function3;
        this.f$6 = i;
        this.f$7 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$6;
        Object obj3 = this.f$5;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                QueueKt.QueueTrackRow((Integer) obj5, (MediaMetadata) obj4, this.f$2, this.f$3, this.f$4, (Function3) obj3, (Composer) obj, iUpdateChangedFlags, this.f$7);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                MenuKt.Switch(this.f$3, (Function1) obj5, this.f$2, (Function2) obj4, this.f$4, (SwitchColors) obj3, (Composer) obj, iUpdateChangedFlags2, this.f$7);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i | 1);
                MenuKt.Switch(this.f$3, (Function1) obj5, this.f$2, (Function2) obj4, this.f$4, (SwitchColors) obj3, (Composer) obj, iUpdateChangedFlags3, this.f$7);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ QueueKt$$ExternalSyntheticLambda41(boolean z, Function1 function1, Modifier modifier, Function2 function2, boolean z2, SwitchColors switchColors, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$3 = z;
        this.f$0 = function1;
        this.f$2 = modifier;
        this.f$1 = function2;
        this.f$4 = z2;
        this.f$5 = switchColors;
        this.f$6 = i;
        this.f$7 = i2;
    }
}
