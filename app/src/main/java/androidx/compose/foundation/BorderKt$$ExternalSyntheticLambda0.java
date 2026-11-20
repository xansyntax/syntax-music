package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import com.metrolist.music.ui.component.DialogKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BorderKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ BorderKt$$ExternalSyntheticLambda0(Brush brush, long j, long j2, DrawStyle drawStyle) {
        this.$r8$classId = (byte) 0;
        this.f$0 = brush;
        this.f$1 = j;
        this.f$2 = j2;
        this.f$3 = drawStyle;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$3;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                DrawScope.m549drawRectAsUm42w$default(layoutNodeDrawScope, (Brush) obj3, this.f$1, this.f$2, CropImageView.DEFAULT_ASPECT_RATIO, (DrawStyle) obj2, null, 0, 104);
                break;
            case 1:
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                DialogKt.m1471drawAuralysMarkRIQooxk(drawScope, this.f$1, this.f$2, ((Number) ((State) obj3).getValue()).floatValue(), 1.0f, ((Number) ((State) obj2).getValue()).floatValue());
                break;
            default:
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                DialogKt.m1471drawAuralysMarkRIQooxk(drawScope2, this.f$1, this.f$2, ((Number) ((Animatable) obj3).getValue()).floatValue(), ((Number) ((Animatable) obj2).getValue()).floatValue(), CropImageView.DEFAULT_ASPECT_RATIO);
                break;
        }
        return unit;
    }

    public /* synthetic */ BorderKt$$ExternalSyntheticLambda0(long j, long j2, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$1 = j;
        this.f$2 = j2;
        this.f$0 = obj;
        this.f$3 = obj2;
    }
}
