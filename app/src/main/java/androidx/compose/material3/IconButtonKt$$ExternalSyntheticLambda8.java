package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IconButtonKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Function f$6;
    public final /* synthetic */ int f$7;

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda8(Modifier modifier, Function0 function0, boolean z, Shape shape, IconButtonColors iconButtonColors, Function2 function2, int i) {
        this.f$0 = modifier;
        this.f$1 = function0;
        this.f$2 = z;
        this.f$3 = shape;
        this.f$4 = iconButtonColors;
        this.f$6 = function2;
        this.f$7 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$7;
        Function function = this.f$6;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Object obj5 = this.f$1;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                CardKt.IconButtonImpl((Modifier) obj6, (Function0) obj5, this.f$2, (Shape) obj4, (IconButtonColors) obj3, (Function2) function, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CrossfadeKt.AnimatedVisibility(this.f$2, (Modifier) obj6, (EnterTransitionImpl) obj5, (ExitTransitionImpl) obj4, (String) obj3, (ComposableLambdaImpl) function, (Composer) obj, iUpdateChangedFlags2);
                break;
            case 2:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i | 1);
                ContextMenuUiKt.ContextMenuItem((String) obj4, this.f$2, (ContextMenuColors) obj3, (Modifier) obj6, (Function3) function, (Function0) obj5, (Composer) obj, iUpdateChangedFlags3);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(i | 1);
                Icons$Filled.TooltipPopup((PopupPositionProvider) obj6, (TooltipStateImpl) obj5, (CoroutineScope) obj4, this.f$2, (MutableState) obj3, (ComposableLambdaImpl) function, (Composer) obj, iUpdateChangedFlags4);
                break;
        }
        return unit;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda8(PopupPositionProvider popupPositionProvider, TooltipStateImpl tooltipStateImpl, CoroutineScope coroutineScope, boolean z, MutableState mutableState, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = popupPositionProvider;
        this.f$1 = tooltipStateImpl;
        this.f$3 = coroutineScope;
        this.f$2 = z;
        this.f$4 = mutableState;
        this.f$6 = composableLambdaImpl;
        this.f$7 = i;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda8(String str, boolean z, ContextMenuColors contextMenuColors, Modifier modifier, Function3 function3, Function0 function0, int i) {
        this.f$3 = str;
        this.f$2 = z;
        this.f$4 = contextMenuColors;
        this.f$0 = modifier;
        this.f$6 = function3;
        this.f$1 = function0;
        this.f$7 = i;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda8(boolean z, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, String str, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$2 = z;
        this.f$0 = modifier;
        this.f$1 = enterTransitionImpl;
        this.f$3 = exitTransitionImpl;
        this.f$4 = str;
        this.f$6 = composableLambdaImpl;
        this.f$7 = i;
    }
}
