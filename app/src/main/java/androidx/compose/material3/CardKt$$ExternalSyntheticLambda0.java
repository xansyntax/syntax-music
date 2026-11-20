package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CardKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ ComposableLambdaImpl f$5;
    public final /* synthetic */ byte f$7;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CardKt$$ExternalSyntheticLambda0(int i, ComposableLambdaImpl composableLambdaImpl, ComposableLambdaImpl composableLambdaImpl2, Function2 function2, Function2 function3, WindowInsets windowInsets, Function2 function4, int i2) {
        this.f$7 = i;
        this.f$5 = composableLambdaImpl;
        this.f$0 = composableLambdaImpl2;
        this.f$1 = function2;
        this.f$2 = function3;
        this.f$3 = windowInsets;
        this.f$4 = function4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Object obj5 = this.f$2;
        Object obj6 = this.f$1;
        Object obj7 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                CardKt.OutlinedCard((Modifier) obj7, (Shape) obj6, (CardColors) obj5, (CardElevation) obj4, (BorderStroke) obj3, this.f$5, (Composer) obj, Stack.updateChangedFlags(196615), this.f$7);
                break;
            case 1:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj7;
                Function2 function2 = (Function2) obj6;
                Function2 function3 = (Function2) obj5;
                MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) obj4;
                Function2 function4 = (Function2) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ScrimKt.m318ScaffoldLayoutFMILGgc(this.f$7, this.f$5, composableLambdaImpl, function2, function3, mutableWindowInsets, function4, gapComposer, 0);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                ScrimKt.m318ScaffoldLayoutFMILGgc(this.f$7, this.f$5, (ComposableLambdaImpl) obj7, (Function2) obj6, (Function2) obj5, (WindowInsets) obj4, (Function2) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CardKt$$ExternalSyntheticLambda0(int i, ComposableLambdaImpl composableLambdaImpl, ComposableLambdaImpl composableLambdaImpl2, Function2 function2, Function2 function3, MutableWindowInsets mutableWindowInsets, Function2 function4) {
        this.f$7 = i;
        this.f$5 = composableLambdaImpl;
        this.f$0 = composableLambdaImpl2;
        this.f$1 = function2;
        this.f$2 = function3;
        this.f$3 = mutableWindowInsets;
        this.f$4 = function4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CardKt$$ExternalSyntheticLambda0(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$0 = modifier;
        this.f$1 = shape;
        this.f$2 = cardColors;
        this.f$3 = cardElevation;
        this.f$4 = borderStroke;
        this.f$5 = composableLambdaImpl;
        this.f$7 = i2;
    }
}
