package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.MutableTransform;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.google.common.math.IntMath;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ short f$10;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Function1 f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ int f$9;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ SliderKt$$ExternalSyntheticLambda4(Transition transition, Function1 function1, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, Function2 function2, MutableTransform mutableTransform, boolean z, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.$r8$classId = (byte) 1;
        this.f$0 = transition;
        this.f$3 = function1;
        this.f$1 = modifier;
        this.f$4 = enterTransitionImpl;
        this.f$5 = exitTransitionImpl;
        this.f$6 = function2;
        this.f$7 = mutableTransform;
        this.f$2 = z;
        this.f$8 = composableLambdaImpl;
        this.f$9 = i;
        this.f$10 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$9;
        Object obj3 = this.f$8;
        Object obj4 = this.f$7;
        Object obj5 = this.f$6;
        Object obj6 = this.f$5;
        Object obj7 = this.f$4;
        Object obj8 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                SliderKt.Slider((SliderState) obj8, this.f$1, this.f$2, this.f$3, (Function0) obj7, (SliderColors) obj6, (MutableInteractionSourceImpl) obj5, (Function3) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, iUpdateChangedFlags, this.f$10);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CrossfadeKt.AnimatedEnterExitImpl((Transition) obj8, this.f$3, this.f$1, (EnterTransitionImpl) obj7, (ExitTransitionImpl) obj6, (Function2) obj5, (MutableTransform) obj4, this.f$2, (ComposableLambdaImpl) obj3, (Composer) obj, iUpdateChangedFlags2, this.f$10);
                break;
            case 2:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i | 1);
                IntMath.LazyColumn(this.f$1, (LazyListState) obj8, (PaddingValues) obj7, (Arrangement$Vertical) obj6, (Alignment.Horizontal) obj5, (FlingBehavior) obj4, this.f$2, (AndroidEdgeEffectOverscrollEffect) obj3, this.f$3, (Composer) obj, iUpdateChangedFlags3, this.f$10);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(i | 1);
                IntMath.LazyRow(this.f$1, (LazyListState) obj8, (PaddingValues) obj7, (Arrangement$Horizontal) obj6, (Alignment.Vertical) obj5, (FlingBehavior) obj4, this.f$2, (AndroidEdgeEffectOverscrollEffect) obj3, this.f$3, (Composer) obj, iUpdateChangedFlags4, this.f$10);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ SliderKt$$ExternalSyntheticLambda4(SliderState sliderState, Modifier modifier, boolean z, Function1 function1, Function0 function0, SliderColors sliderColors, MutableInteractionSourceImpl mutableInteractionSourceImpl, Function3 function3, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = sliderState;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$3 = function1;
        this.f$4 = function0;
        this.f$5 = sliderColors;
        this.f$6 = mutableInteractionSourceImpl;
        this.f$7 = function3;
        this.f$8 = composableLambdaImpl;
        this.f$9 = i;
        this.f$10 = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ SliderKt$$ExternalSyntheticLambda4(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, Object obj, Object obj2, FlingBehavior flingBehavior, boolean z, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Function1 function1, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$1 = modifier;
        this.f$0 = lazyListState;
        this.f$4 = paddingValues;
        this.f$5 = obj;
        this.f$6 = obj2;
        this.f$7 = flingBehavior;
        this.f$2 = z;
        this.f$8 = androidEdgeEffectOverscrollEffect;
        this.f$3 = function1;
        this.f$9 = i;
        this.f$10 = i2;
    }
}
