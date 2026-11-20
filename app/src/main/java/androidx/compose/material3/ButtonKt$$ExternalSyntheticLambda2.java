package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ButtonKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ int f$10;
    public final /* synthetic */ short f$11;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$9;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda2(ComposableLambdaImpl composableLambdaImpl, Function0 function0, Modifier modifier, Function2 function2, Function2 function3, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, int i, int i2) {
        this.f$3 = composableLambdaImpl;
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$4 = function2;
        this.f$6 = function3;
        this.f$2 = z;
        this.f$9 = menuItemColors;
        this.f$7 = paddingValues;
        this.f$10 = i;
        this.f$11 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$10;
        Object obj3 = this.f$7;
        Object obj4 = this.f$6;
        Object obj5 = this.f$4;
        Object obj6 = this.f$9;
        Object obj7 = this.f$3;
        Object obj8 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                CardKt.OutlinedButton((Function0) obj8, this.f$1, this.f$2, (Shape) obj7, (ButtonColors) obj5, (BorderStroke) obj4, (PaddingValues) obj3, (Function3) obj6, (Composer) obj, iUpdateChangedFlags, this.f$11);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CardKt.DropdownMenuItem((ComposableLambdaImpl) obj7, (Function0) obj8, this.f$1, (Function2) obj5, (Function2) obj4, this.f$2, (MenuItemColors) obj6, (PaddingValues) obj3, (Composer) obj, iUpdateChangedFlags2, this.f$11);
                break;
            case 2:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i | 1);
                CardKt.Button((Function0) obj8, (ButtonShapes) obj7, this.f$1, this.f$2, (ButtonColors) obj5, (ButtonElevation) obj4, (PaddingValues) obj3, (ComposableLambdaImpl) obj6, (Composer) obj, iUpdateChangedFlags3, this.f$11);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(i | 1);
                com.metrolist.music.ui.component.MenuKt.ListItem(this.f$1, (String) obj8, (String) obj7, (Function3) obj6, (ComposableLambdaImpl) obj5, (Function3) obj4, (Boolean) obj3, this.f$2, (Composer) obj, iUpdateChangedFlags4, this.f$11);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda2(Modifier modifier, String str, String str2, Function3 function3, ComposableLambdaImpl composableLambdaImpl, Function3 function4, Boolean bool, boolean z, int i, int i2) {
        this.f$1 = modifier;
        this.f$0 = str;
        this.f$3 = str2;
        this.f$9 = function3;
        this.f$4 = composableLambdaImpl;
        this.f$6 = function4;
        this.f$7 = bool;
        this.f$2 = z;
        this.f$10 = i;
        this.f$11 = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda2(Function0 function0, ButtonShapes buttonShapes, Modifier modifier, boolean z, ButtonColors buttonColors, ButtonElevation buttonElevation, PaddingValues paddingValues, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$0 = function0;
        this.f$3 = buttonShapes;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$4 = buttonColors;
        this.f$6 = buttonElevation;
        this.f$7 = paddingValues;
        this.f$9 = composableLambdaImpl;
        this.f$10 = i;
        this.f$11 = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda2(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, BorderStroke borderStroke, PaddingValues paddingValues, Function3 function3, int i, int i2) {
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$3 = shape;
        this.f$4 = buttonColors;
        this.f$6 = borderStroke;
        this.f$7 = paddingValues;
        this.f$9 = function3;
        this.f$10 = i;
        this.f$11 = i2;
    }
}
