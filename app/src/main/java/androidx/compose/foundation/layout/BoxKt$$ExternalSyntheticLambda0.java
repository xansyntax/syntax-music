package androidx.compose.foundation.layout;

import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BoxKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ byte f$1;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ BoxKt$$ExternalSyntheticLambda0(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        byte b2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                BoxKt.Box((Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(b2 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                CardKt.OnPlatformWindowBoundsChange((Function0) obj3, (Composer) obj, Stack.updateChangedFlags(b2 | 1));
                break;
        }
        return unit;
    }
}
