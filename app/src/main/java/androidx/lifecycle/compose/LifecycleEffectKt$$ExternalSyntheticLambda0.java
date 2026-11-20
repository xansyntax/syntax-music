package androidx.lifecycle.compose;

import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.LifecycleOwner;
import coil3.util.LifecyclesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LifecycleEffectKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, Object obj4, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Object obj3 = this.f$3;
        Object obj4 = this.f$2;
        Unit unit = Unit.INSTANCE;
        int i = this.f$4;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                LifecyclesKt.LifecycleStartEffect((Boolean) obj5, this.f$1, (LifecycleOwner) obj4, (Function1) obj3, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                Icons$Filled.WrappedAnchor((TooltipStateImpl) obj5, (MutableState) this.f$1, (Modifier) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i) | 1;
                ((ComposableLambdaImpl) obj5).invoke(this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
