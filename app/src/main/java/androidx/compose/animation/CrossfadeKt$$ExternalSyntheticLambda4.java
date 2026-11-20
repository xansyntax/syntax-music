package androidx.compose.animation;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MotionScheme;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.Typography;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupPositionProvider;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.screens.recognition.RecognitionScreenKt;
import com.metrolist.shazamkit.models.RecognitionResult;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CrossfadeKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ int f$5;

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda4(int i, Function0 function0, Function0 function1, Function0 function2, List list, String str, int i2) {
        this.$r8$classId = (byte) 5;
        this.f$5 = i;
        this.f$0 = function0;
        this.f$1 = function1;
        this.f$2 = function2;
        this.f$3 = list;
        this.f$4 = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        int i = this.f$5;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$2;
        Object obj6 = this.f$1;
        Object obj7 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                CrossfadeKt.Crossfade((TransitionInstance) obj7, (Modifier) obj6, (FiniteAnimationSpec) obj5, (Function1) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                ArcSplineKt.UpdateInitialAndTargetValues((Transition) obj7, (Transition.TransitionAnimationState) obj6, this.f$3, this.f$4, (FiniteAnimationSpec) obj5, (Composer) obj, iUpdateChangedFlags);
                break;
            case 2:
                ((Integer) obj2).getClass();
                OffsetKt.FlowRow((Modifier) obj6, (Arrangement$Horizontal) obj7, (Arrangement$Vertical) obj5, (FlowRowOverflow) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                MaterialThemeKt.MaterialTheme((ColorScheme) obj7, (MotionScheme) obj6, (Shapes) obj5, (Typography) obj4, (Function2) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                Icons$Filled.BasicTooltipBox((PopupPositionProvider) obj7, (ComposableLambdaImpl) obj3, (TooltipStateImpl) obj5, (Modifier) obj6, (ComposableLambdaImpl) obj4, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 5:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                AlbumMenuKt.AutoPlaylistMenu(this.f$5, (Function0) obj7, (Function0) obj6, (Function0) obj5, (List) obj4, (String) obj3, (Composer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).intValue();
                RecognitionScreenKt.SuccessState((RecognitionResult) obj7, (Function1) obj4, (Function0) obj6, (Function0) obj5, (Function1) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
        }
        return unit;
    }

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda4(Transition transition, Transition.TransitionAnimationState transitionAnimationState, Object obj, Object obj2, FiniteAnimationSpec finiteAnimationSpec, int i) {
        this.$r8$classId = (byte) 1;
        this.f$0 = transition;
        this.f$1 = transitionAnimationState;
        this.f$3 = obj;
        this.f$4 = obj2;
        this.f$2 = finiteAnimationSpec;
        this.f$5 = i;
    }

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda4(Modifier modifier, Arrangement$Horizontal arrangement$Horizontal, Arrangement$Vertical arrangement$Vertical, FlowRowOverflow flowRowOverflow, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.$r8$classId = (byte) 2;
        this.f$1 = modifier;
        this.f$0 = arrangement$Horizontal;
        this.f$2 = arrangement$Vertical;
        this.f$3 = flowRowOverflow;
        this.f$4 = composableLambdaImpl;
        this.f$5 = i;
    }

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda4(PopupPositionProvider popupPositionProvider, ComposableLambdaImpl composableLambdaImpl, TooltipStateImpl tooltipStateImpl, Modifier modifier, ComposableLambdaImpl composableLambdaImpl2, int i) {
        this.$r8$classId = (byte) 4;
        this.f$0 = popupPositionProvider;
        this.f$4 = composableLambdaImpl;
        this.f$2 = tooltipStateImpl;
        this.f$1 = modifier;
        this.f$3 = composableLambdaImpl2;
        this.f$5 = i;
    }

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda4(RecognitionResult recognitionResult, Function1 function1, Function0 function0, Function0 function2, Function1 function3, int i) {
        this.$r8$classId = (byte) 6;
        this.f$0 = recognitionResult;
        this.f$3 = function1;
        this.f$1 = function0;
        this.f$2 = function2;
        this.f$4 = function3;
        this.f$5 = i;
    }

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda4(Object obj, Object obj2, Object obj3, Object obj4, Function2 function2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = function2;
        this.f$5 = i;
    }
}
