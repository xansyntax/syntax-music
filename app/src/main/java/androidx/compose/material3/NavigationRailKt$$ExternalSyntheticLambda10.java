package androidx.compose.material3;

import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavigationRailKt$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ NavigationRailKt$$ExternalSyntheticLambda10(byte b, Function0 function0, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$1;
        boolean z = this.f$0;
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
        switch (b) {
            case 0:
                reusableGraphicsLayerScope.setAlpha(z ? 1.0f : ((Number) function0.invoke()).floatValue());
                break;
            default:
                reusableGraphicsLayerScope.setClip(!z && ((Boolean) function0.invoke()).booleanValue());
                break;
        }
        return unit;
    }
}
