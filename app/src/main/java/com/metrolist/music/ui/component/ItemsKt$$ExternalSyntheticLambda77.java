package com.metrolist.music.ui.component;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda77 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda77(String str, boolean z, boolean z2, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = z;
        this.f$2 = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((BoxWithConstraintsScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    MenuKt.LocalThumbnail(this.f$0, this.f$1, this.f$2, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer)), Modifier.Companion.$$INSTANCE, true, false, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer, 1769472);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((BoxWithConstraintsScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                    MenuKt.LocalThumbnail(this.f$0, this.f$1, this.f$2, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer2)), Modifier.Companion.$$INSTANCE, false, true, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2, 1769472);
                }
                break;
        }
        return unit;
    }
}
