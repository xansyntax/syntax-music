package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FloatingActionButtonKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ Shape f$2;
    public final /* synthetic */ long f$3;
    public final /* synthetic */ long f$4;
    public final /* synthetic */ FloatingActionButtonElevation f$5;
    public final /* synthetic */ ComposableLambdaImpl f$7;
    public final /* synthetic */ int f$8;
    public final /* synthetic */ byte f$9;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ FloatingActionButtonKt$$ExternalSyntheticLambda0(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, ComposableLambdaImpl composableLambdaImpl, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = shape;
        this.f$3 = j;
        this.f$4 = j2;
        this.f$5 = floatingActionButtonElevation;
        this.f$7 = composableLambdaImpl;
        this.f$8 = i;
        this.f$9 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$8;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                CardKt.m265SmallFloatingActionButtonXz6DiA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$7, (Composer) obj, iUpdateChangedFlags, this.f$9);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CardKt.m259FloatingActionButtonXz6DiA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$7, (Composer) obj, iUpdateChangedFlags2, this.f$9);
                break;
        }
        return unit;
    }
}
