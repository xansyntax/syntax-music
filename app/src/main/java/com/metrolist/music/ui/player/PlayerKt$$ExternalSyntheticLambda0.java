package com.metrolist.music.ui.player;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.unit.Dp;
import com.metrolist.music.ui.component.BottomSheetState;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ BottomSheetState f$0;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda0(BottomSheetState bottomSheetState, byte b) {
        this.$r8$classId = b;
        this.f$0 = bottomSheetState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        BottomSheetState bottomSheetState = this.f$0;
        switch (b) {
            case 0:
                return Boolean.valueOf(bottomSheetState.getProgress() > 0.02f);
            case 1:
                bottomSheetState.expandSoft();
                return unit;
            case 2:
                float fM1456getValueD9Ej5fM = bottomSheetState.m1456getValueD9Ej5fM();
                Comparable comparable = bottomSheetState.animatable.lowerBound;
                comparable.getClass();
                return Boolean.valueOf(Dp.m796equalsimpl0(fM1456getValueD9Ej5fM, ((Dp) comparable).value));
            case 3:
                return Boolean.valueOf(Dp.m796equalsimpl0(bottomSheetState.m1456getValueD9Ej5fM(), bottomSheetState.collapsedBound));
            case 4:
                float fM1456getValueD9Ej5fM2 = bottomSheetState.m1456getValueD9Ej5fM();
                Comparable comparable2 = bottomSheetState.animatable.upperBound;
                return Boolean.valueOf((comparable2 instanceof Dp) && Float.compare(fM1456getValueD9Ej5fM2, ((Dp) comparable2).value) == 0);
            case 5:
                Animatable animatable = bottomSheetState.animatable;
                Comparable comparable3 = animatable.upperBound;
                comparable3.getClass();
                float f = (((Dp) comparable3).value - ((Dp) animatable.getValue()).value) + CropImageView.DEFAULT_ASPECT_RATIO;
                Comparable comparable4 = animatable.upperBound;
                comparable4.getClass();
                return Float.valueOf(1.0f - (f / ((((Dp) comparable4).value - bottomSheetState.collapsedBound) + CropImageView.DEFAULT_ASPECT_RATIO)));
            case 6:
                return Boolean.valueOf(bottomSheetState.isExpanded());
            case 7:
                bottomSheetState.expandSoft();
                return unit;
            case 8:
                bottomSheetState.collapseSoft();
                return unit;
            case 9:
                return Boolean.valueOf(bottomSheetState.isExpanded());
            case 10:
                bottomSheetState.expandSoft();
                return unit;
            default:
                bottomSheetState.collapseSoft();
                return unit;
        }
    }
}
