package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State f$0;
    public final /* synthetic */ State f$1;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda7(State state, State state2, byte b) {
        this.$r8$classId = b;
        this.f$0 = state;
        this.f$1 = state2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        State state = this.f$1;
        State state2 = this.f$0;
        switch (b) {
            case 0:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.setScaleX(((Number) state2.getValue()).floatValue());
                reusableGraphicsLayerScope.setScaleY(((Number) state2.getValue()).floatValue());
                reusableGraphicsLayerScope.setAlpha(((Number) state.getValue()).floatValue());
                return unit;
            case 1:
                DrawScope drawScope = (DrawScope) obj;
                float fMo81toPx0680j_4 = drawScope.mo81toPx0680j_4(2.0f);
                float f = fMo81toPx0680j_4 / 2.0f;
                DrawScope.m543drawCircleVaOC9Bg$default(drawScope, ((Color) state2.getValue()).value, drawScope.mo81toPx0680j_4(10.0f) - f, 0L, new Stroke(fMo81toPx0680j_4, CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 30), 0, 108);
                if (Dp.m795compareTo0680j_4(((Dp) state.getValue()).value, CropImageView.DEFAULT_ASPECT_RATIO) > 0) {
                    DrawScope.m543drawCircleVaOC9Bg$default(drawScope, ((Color) state2.getValue()).value, drawScope.mo81toPx0680j_4(((Dp) state.getValue()).value) - f, 0L, Fill.INSTANCE, 0, 108);
                }
                return unit;
            default:
                Density density = (Density) obj;
                density.getClass();
                float fMo81toPx0680j_5 = density.mo81toPx0680j_4((((54.0f - ((Dp) state2.getValue()).value) + CropImageView.DEFAULT_ASPECT_RATIO) - 4.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
                return new IntOffset(((long) MathKt.roundToInt((((Number) state.getValue()).floatValue() * fMo81toPx0680j_5) + density.mo81toPx0680j_4(2.0f))) << 32);
        }
    }
}
