package com.metrolist.music.ui.component;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.metrolist.music.constants.DimensionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ItemsKt$ListItem$2$1 implements Function1 {
    public final /* synthetic */ long $listDividerColor;

    public ItemsKt$ListItem$2$1(long j) {
        this.$listDividerColor = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DrawScope drawScope = (DrawScope) obj;
        drawScope.getClass();
        SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
        float fMo81toPx0680j_4 = drawScope.mo81toPx0680j_4(80.0f);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) - 0.5f;
        drawScope.mo535drawLineNGM6Ib0(this.$listDividerColor, (((long) Float.floatToRawIntBits(fMo81toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L), (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))) << 32), drawScope.mo81toPx0680j_4(1.0f), (496 & 16) != 0 ? 0 : 0, 3);
        return Unit.INSTANCE;
    }
}
