package androidx.compose.material3;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderKt$CornerSizeAlignmentLine$1 extends FunctionReferenceImpl implements Function2 {
    public static final SliderKt$CornerSizeAlignmentLine$1 INSTANCE = new SliderKt$CornerSizeAlignmentLine$1(2, MathKt.class, "min", "min(II)I", 1);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(Math.min(((Number) obj).intValue(), ((Number) obj2).intValue()));
    }
}
