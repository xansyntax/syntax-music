package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda25 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ int f$8;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda25(Transition transition, Modifier modifier, Function1 function1, Alignment alignment, Function1 function2, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$1 = transition;
        this.f$0 = modifier;
        this.f$2 = function1;
        this.f$3 = alignment;
        this.f$4 = function2;
        this.f$5 = composableLambdaImpl;
        this.f$8 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Object obj3 = this.f$5;
        Object obj4 = this.f$4;
        Object obj5 = this.f$3;
        Object obj6 = this.f$1;
        Unit unit = Unit.INSTANCE;
        int i = this.f$8;
        Object obj7 = this.f$2;
        Object obj8 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                TimePickerKt.PeriodToggleImpl((Modifier) obj8, (TimePickerState) obj6, (TimeInputColors) obj7, (MeasurePolicy) obj5, (RoundedCornerShape) obj4, (RoundedCornerShape) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                CrossfadeKt.AnimatedContent((Transition) obj6, (Modifier) obj8, (Function1) obj7, (Alignment) obj5, (Function1) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                CrossfadeKt.AnimatedVisibilityImpl((TransitionInstance) obj6, (Function1) obj7, (Modifier) obj8, (EnterTransitionImpl) obj5, (ExitTransitionImpl) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i) | 1;
                ((ComposableLambdaImpl) obj8).invoke(this.f$1, (Boolean) obj7, this.f$3, this.f$4, this.f$5, (Composer) obj, iUpdateChangedFlags);
                break;
        }
        return unit;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda25(TransitionInstance transitionInstance, Function1 function1, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$1 = transitionInstance;
        this.f$2 = function1;
        this.f$0 = modifier;
        this.f$3 = enterTransitionImpl;
        this.f$4 = exitTransitionImpl;
        this.f$5 = composableLambdaImpl;
        this.f$8 = i;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda25(ComposableLambdaImpl composableLambdaImpl, Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, int i) {
        this.f$0 = composableLambdaImpl;
        this.f$1 = obj;
        this.f$2 = bool;
        this.f$3 = obj2;
        this.f$4 = obj3;
        this.f$5 = obj4;
        this.f$8 = i;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda25(Modifier modifier, TimePickerState timePickerState, TimeInputColors timeInputColors, MeasurePolicy measurePolicy, RoundedCornerShape roundedCornerShape, RoundedCornerShape roundedCornerShape2, int i) {
        this.f$0 = modifier;
        this.f$1 = timePickerState;
        this.f$2 = timeInputColors;
        this.f$3 = measurePolicy;
        this.f$4 = roundedCornerShape;
        this.f$5 = roundedCornerShape2;
        this.f$8 = i;
    }
}
