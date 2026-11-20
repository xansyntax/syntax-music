package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
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
public final /* synthetic */ class IconButtonKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Function2 f$6;
    public final /* synthetic */ int f$7;
    public final /* synthetic */ byte f$8;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda7(Function0 function0, Modifier modifier, boolean z, IconButtonColors iconButtonColors, Shape shape, Function2 function2, int i, int i2) {
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$3 = iconButtonColors;
        this.f$5 = shape;
        this.f$6 = function2;
        this.f$7 = i;
        this.f$8 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$7;
        Object obj3 = this.f$5;
        Object obj4 = this.f$3;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                CardKt.IconButton((Function0) obj5, this.f$1, this.f$2, (IconButtonColors) obj4, (Shape) obj3, this.f$6, (Composer) obj, iUpdateChangedFlags, this.f$8);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CrossfadeKt.AnimatedVisibility(this.f$2, this.f$1, (EnterTransitionImpl) obj5, (ExitTransitionImpl) obj4, (String) obj3, (ComposableLambdaImpl) this.f$6, (Composer) obj, iUpdateChangedFlags2, this.f$8);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda7(boolean z, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, String str, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$2 = z;
        this.f$1 = modifier;
        this.f$0 = enterTransitionImpl;
        this.f$3 = exitTransitionImpl;
        this.f$5 = str;
        this.f$6 = composableLambdaImpl;
        this.f$7 = i;
        this.f$8 = i2;
    }
}
