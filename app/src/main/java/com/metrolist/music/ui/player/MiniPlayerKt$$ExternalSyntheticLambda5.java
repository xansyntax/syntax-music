package com.metrolist.music.ui.player;

import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MiniPlayerKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ ProgressState f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda5(long j, ProgressState progressState, long j2) {
        this.f$0 = j;
        this.f$1 = progressState;
        this.f$2 = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ProgressState progressState = this.f$1;
        switch (b) {
            case 0:
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.getClass();
                DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope, this.f$0, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 126);
                float progress = progressState.getProgress();
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)) * progress;
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L));
                DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope, this.f$2, 0L, (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fIntBitsToFloat2))), CropImageView.DEFAULT_ASPECT_RATIO, 0, 122);
                break;
            default:
                LayoutNodeDrawScope layoutNodeDrawScope2 = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope2.getClass();
                float progress2 = progressState.getProgress();
                DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope2, this.f$0, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 126);
                CanvasDrawScope canvasDrawScope2 = layoutNodeDrawScope2.canvasDrawScope;
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (canvasDrawScope2.mo556getSizeNHjbRc() >> 32)) * progress2;
                float fIntBitsToFloat4 = Float.intBitsToFloat((int) (canvasDrawScope2.mo556getSizeNHjbRc() & 4294967295L));
                DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope2, this.f$2, 0L, (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fIntBitsToFloat4))), CropImageView.DEFAULT_ASPECT_RATIO, 0, 122);
                break;
        }
        return unit;
    }

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda5(ProgressState progressState, long j, long j2) {
        this.f$1 = progressState;
        this.f$0 = j;
        this.f$2 = j2;
    }
}
