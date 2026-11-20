package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import com.metrolist.music.ui.component.AppNavigationKt;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IconButtonKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Function f$7;

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda1(List list, String str, Function2 function2, Modifier modifier, boolean z, Function0 function0, Function0 function1, int i) {
        this.f$3 = list;
        this.f$4 = str;
        this.f$5 = function2;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$0 = function0;
        this.f$7 = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function function = this.f$7;
        Object obj3 = this.f$5;
        Object obj4 = this.f$4;
        Object obj5 = this.f$3;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(12582913);
                CardKt.OutlinedIconButton(this.f$0, this.f$1, this.f$2, (Shape) obj5, (IconButtonColors) obj4, (BorderStroke) obj3, (ComposableLambdaImpl) function, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                AppNavigationKt.AppNavigationRail((List) obj5, (String) obj4, (Function2) obj3, this.f$1, this.f$2, this.f$0, (Function0) function, (Composer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(1769473);
                com.metrolist.music.ui.component.MenuKt.LibrarySearchHeader(this.f$2, (String) obj5, (Function1) obj4, this.f$0, (SoftwareKeyboardController) obj3, this.f$1, (ComposableLambdaImpl) function, (Composer) obj, iUpdateChangedFlags3);
                break;
        }
        return unit;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda1(Function0 function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, BorderStroke borderStroke, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$3 = shape;
        this.f$4 = iconButtonColors;
        this.f$5 = borderStroke;
        this.f$7 = composableLambdaImpl;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda1(boolean z, String str, Function1 function1, Function0 function0, SoftwareKeyboardController softwareKeyboardController, Modifier modifier, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$2 = z;
        this.f$3 = str;
        this.f$4 = function1;
        this.f$0 = function0;
        this.f$5 = softwareKeyboardController;
        this.f$1 = modifier;
        this.f$7 = composableLambdaImpl;
    }
}
