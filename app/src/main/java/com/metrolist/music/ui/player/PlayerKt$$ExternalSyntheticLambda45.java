package com.metrolist.music.ui.player;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda45 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda45(int i, Function0 function0, boolean z) {
        this.$r8$classId = (byte) 3;
        this.f$1 = z;
        this.f$0 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                int iIntValue = num.intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MenuKt.Lyrics(this.f$0, OffsetKt.m137paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), this.f$1, null, gapComposer, 48);
                }
                break;
            case 1:
                int iIntValue2 = num.intValue();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ScrimKt.RadioButton(this.f$1, this.f$0, null, false, null, gapComposer2, 0);
                }
                break;
            case 2:
                int iIntValue3 = num.intValue();
                GapComposer gapComposer3 = (GapComposer) composer;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    ScrimKt.RadioButton(this.f$1, this.f$0, null, false, null, gapComposer3, 0);
                }
                break;
            default:
                num.getClass();
                EqScreenKt.NoEqualizationItem(Stack.updateChangedFlags(1), composer, this.f$0, this.f$1);
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda45(byte b, Function0 function0, boolean z) {
        this.$r8$classId = b;
        this.f$1 = z;
        this.f$0 = function0;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda45(boolean z, Function0 function0) {
        this.$r8$classId = (byte) 0;
        this.f$0 = function0;
        this.f$1 = z;
    }
}
