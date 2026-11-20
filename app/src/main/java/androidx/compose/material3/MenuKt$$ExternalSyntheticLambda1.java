package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ ComposableLambdaImpl f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ Modifier f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Function f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ int f$9;

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda1(ComposableLambdaImpl composableLambdaImpl, Function0 function0, Modifier modifier, Function2 function2, Function2 function3, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, int i) {
        this.f$0 = composableLambdaImpl;
        this.f$1 = function0;
        this.f$2 = modifier;
        this.f$3 = function2;
        this.f$4 = function3;
        this.f$5 = z;
        this.f$6 = menuItemColors;
        this.f$7 = paddingValues;
        this.f$9 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$9;
        Object obj3 = this.f$7;
        Object obj4 = this.f$6;
        Function function = this.f$4;
        Object obj5 = this.f$3;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                MenuKt.DropdownMenuItemContent(this.f$0, this.f$1, this.f$2, (Function2) obj5, (Function2) function, this.f$5, (MenuItemColors) obj4, (PaddingValues) obj3, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                SliderKt.SliderImpl(this.f$2, (SliderState) obj5, this.f$5, (Function1) function, this.f$1, (MutableInteractionSourceImpl) obj4, (Function3) obj3, this.f$0, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda1(Modifier modifier, SliderState sliderState, boolean z, Function1 function1, Function0 function0, MutableInteractionSourceImpl mutableInteractionSourceImpl, Function3 function3, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$2 = modifier;
        this.f$3 = sliderState;
        this.f$5 = z;
        this.f$4 = function1;
        this.f$1 = function0;
        this.f$6 = mutableInteractionSourceImpl;
        this.f$7 = function3;
        this.f$0 = composableLambdaImpl;
        this.f$9 = i;
    }
}
