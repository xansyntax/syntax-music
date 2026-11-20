package androidx.compose.material3.internal;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldImplKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ State f$0;
    public final /* synthetic */ TextFieldColors f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ TransitionInstance f$6;
    public final /* synthetic */ TextStyle f$7;
    public final /* synthetic */ TextStyle f$8;
    public final /* synthetic */ Function3 f$9;

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda1(Transition.TransitionAnimationState transitionAnimationState, TextFieldColors textFieldColors, boolean z, boolean z2, boolean z3, TransitionInstance transitionInstance, TextStyle textStyle, TextStyle textStyle2, Function3 function3) {
        this.f$0 = transitionAnimationState;
        this.f$1 = textFieldColors;
        this.f$2 = z;
        this.f$4 = z2;
        this.f$5 = z3;
        this.f$6 = transitionInstance;
        this.f$7 = textStyle;
        this.f$8 = textStyle2;
        this.f$9 = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Icons$Filled.DecoratedLabel(this.f$0, this.f$1, this.f$2, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, gapComposer, 0);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                Icons$Filled.DecoratedLabel(this.f$0, this.f$1, this.f$2, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda1(State state, TextFieldColors textFieldColors, boolean z, boolean z2, boolean z3, TransitionInstance transitionInstance, TextStyle textStyle, TextStyle textStyle2, Function3 function3, int i) {
        this.f$0 = state;
        this.f$1 = textFieldColors;
        this.f$2 = z;
        this.f$4 = z2;
        this.f$5 = z3;
        this.f$6 = transitionInstance;
        this.f$7 = textStyle;
        this.f$8 = textStyle2;
        this.f$9 = function3;
    }
}
