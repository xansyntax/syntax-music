package com.materialkolor;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DynamicMaterialThemeKt$$ExternalSyntheticLambda0 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ FiniteAnimationSpec f$0;

    public /* synthetic */ DynamicMaterialThemeKt$$ExternalSyntheticLambda0(FiniteAnimationSpec finiteAnimationSpec, byte b) {
        this.$r8$classId = b;
        this.f$0 = finiteAnimationSpec;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        FiniteAnimationSpec finiteAnimationSpec = this.f$0;
        Transition.Segment segment = (Transition.Segment) obj;
        Composer composer = (Composer) obj2;
        ((Integer) obj3).intValue();
        switch (b) {
            case 0:
                segment.getClass();
                GapComposer gapComposer = (GapComposer) composer;
                gapComposer.startReplaceGroup(-641306765);
                gapComposer.end(false);
                break;
            default:
                segment.getClass();
                GapComposer gapComposer2 = (GapComposer) composer;
                gapComposer2.startReplaceGroup(-621048072);
                gapComposer2.end(false);
                break;
        }
        return finiteAnimationSpec;
    }
}
