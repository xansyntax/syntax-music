package com.metrolist.music.ui.component;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GlassComponentsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Brush f$0;

    public /* synthetic */ GlassComponentsKt$$ExternalSyntheticLambda0(Brush brush, byte b) {
        this.$r8$classId = b;
        this.f$0 = brush;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                DrawScope.m549drawRectAsUm42w$default(drawScope, this.f$0, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 126);
                break;
            case 1:
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                DrawScope.m549drawRectAsUm42w$default(drawScope2, this.f$0, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 126);
                break;
            default:
                DrawScope drawScope3 = (DrawScope) obj;
                drawScope3.getClass();
                DrawScope.m549drawRectAsUm42w$default(drawScope3, this.f$0, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 126);
                break;
        }
        return unit;
    }
}
