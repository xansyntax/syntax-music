package com.metrolist.music.ui.menu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.BottomSheetState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaMetadata f$0;
    public final /* synthetic */ BottomSheetState f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda0(MediaMetadata mediaMetadata, BottomSheetState bottomSheetState, Function0 function0, Function0 function1, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaMetadata;
        this.f$1 = bottomSheetState;
        this.f$2 = function0;
        this.f$3 = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                QueueMenuKt.QueueMenu(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                PlayerMenuKt.PlayerMenu(this.f$0, this.f$1, Boolean.FALSE, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(1);
                QueueMenuKt.QueueMenu(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags3);
                break;
        }
        return unit;
    }
}
