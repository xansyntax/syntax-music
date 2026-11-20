package com.metrolist.music.ui.player;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda15;
import androidx.compose.material3.SliderKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda50 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda50(boolean z, long j, PullToRefreshStateImpl pullToRefreshStateImpl) {
        this.f$0 = z;
        this.f$2 = j;
        this.f$1 = pullToRefreshStateImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$1;
        long j = this.f$2;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                State state = (State) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((SliderState) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, z ? 18.0f : 12.0f);
                    boolean zChanged = gapComposer.changed(z) | gapComposer.changed(state);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new SliderKt$$ExternalSyntheticLambda8(z, state, (byte) 4);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierClip = ClipKt.clip(ColorKt.graphicsLayer(modifierM151size3ABfNKs, (Function1) objRememberedValue), RoundedCornerShapeKt.CircleShape);
                    if (z) {
                        j = -4294967296L;
                    }
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(modifierClip, j, ColorKt.RectangleShape), gapComposer, 0);
                }
                break;
            default:
                PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    CrossfadeKt.Crossfade(Boolean.valueOf(z), null, CardKt.m272valueyDoVZcs(3, gapComposer2), null, Expect_jvmKt.rememberComposableLambda(-2064098104, new ChipKt$$ExternalSyntheticLambda15(j, pullToRefreshStateImpl), gapComposer2), gapComposer2, 24576, 10);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda50(boolean z, AnimateAsState animateAsState, long j) {
        this.f$0 = z;
        this.f$1 = animateAsState;
        this.f$2 = j;
    }
}
