package androidx.compose.material3;

import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.carousel.CarouselState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import coil3.util.LifecyclesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderDefaults$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$10;
    public final /* synthetic */ Modifier f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Function2 f$6;
    public final /* synthetic */ Function3 f$7;
    public final /* synthetic */ float f$9;

    public /* synthetic */ SliderDefaults$$ExternalSyntheticLambda8(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, int i) {
        this.f$0 = sliderDefaults;
        this.f$1 = sliderState;
        this.f$3 = modifier;
        this.f$4 = z;
        this.f$5 = sliderColors;
        this.f$6 = function2;
        this.f$7 = function3;
        this.f$9 = f;
        this.f$10 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$10;
        Object obj3 = this.f$5;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                ((SliderDefaults) obj5).m334TrackmnvyFg4((SliderState) obj4, this.f$3, this.f$4, (SliderColors) obj3, this.f$6, this.f$7, this.f$9, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                LifecyclesKt.m882CarouselcJHQLPU((CarouselState) obj5, this.f$6, (PaddingValues) obj4, this.f$3, this.f$9, (SnapFlingBehavior) obj3, this.f$4, (ComposableLambdaImpl) this.f$7, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }

    public /* synthetic */ SliderDefaults$$ExternalSyntheticLambda8(CarouselState carouselState, Function2 function2, PaddingValues paddingValues, Modifier modifier, float f, SnapFlingBehavior snapFlingBehavior, boolean z, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = carouselState;
        this.f$6 = function2;
        this.f$1 = paddingValues;
        this.f$3 = modifier;
        this.f$9 = f;
        this.f$5 = snapFlingBehavior;
        this.f$4 = z;
        this.f$7 = composableLambdaImpl;
        this.f$10 = i;
    }
}
