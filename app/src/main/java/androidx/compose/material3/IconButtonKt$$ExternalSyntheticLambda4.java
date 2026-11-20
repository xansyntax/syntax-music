package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
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
public final /* synthetic */ class IconButtonKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Function2 f$7;
    public final /* synthetic */ int f$8;

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda4(ComposableLambdaImpl composableLambdaImpl, ComposableLambdaImpl composableLambdaImpl2, ComposableLambdaImpl composableLambdaImpl3, Function2 function2, boolean z, Function0 function0, Function0 function1, int i) {
        this.f$7 = composableLambdaImpl;
        this.f$1 = composableLambdaImpl2;
        this.f$3 = composableLambdaImpl3;
        this.f$4 = function2;
        this.f$2 = z;
        this.f$0 = function0;
        this.f$5 = function1;
        this.f$8 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Function2 function2 = this.f$7;
        Unit unit = Unit.INSTANCE;
        int i = this.f$8;
        Object obj3 = this.f$5;
        Object obj4 = this.f$4;
        Object obj5 = this.f$1;
        Object obj6 = this.f$3;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                CardKt.SurfaceIconButton(this.f$0, (Modifier) obj5, this.f$2, (Shape) obj6, (IconButtonColors) obj4, (BorderStroke) obj3, (ComposableLambdaImpl) function2, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CardKt.NavigationRailItemLayout((ComposableLambdaImpl) function2, (ComposableLambdaImpl) obj5, (ComposableLambdaImpl) obj6, (Function2) obj4, this.f$2, this.f$0, (Function0) obj3, (Composer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i | 1);
                com.metrolist.music.ui.component.MenuKt.IconButton(this.f$0, (Function0) obj6, (Modifier) obj5, this.f$2, (IconButtonColors) obj4, (MutableInteractionSourceImpl) obj3, this.f$7, (Composer) obj, iUpdateChangedFlags3);
                break;
        }
        return unit;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda4(Function0 function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, BorderStroke borderStroke, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$3 = shape;
        this.f$4 = iconButtonColors;
        this.f$5 = borderStroke;
        this.f$7 = composableLambdaImpl;
        this.f$8 = i;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda4(Function0 function0, Function0 function1, Modifier modifier, boolean z, IconButtonColors iconButtonColors, MutableInteractionSourceImpl mutableInteractionSourceImpl, Function2 function2, int i) {
        this.f$0 = function0;
        this.f$3 = function1;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$4 = iconButtonColors;
        this.f$5 = mutableInteractionSourceImpl;
        this.f$7 = function2;
        this.f$8 = i;
    }
}
