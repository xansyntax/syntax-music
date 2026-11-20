package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.screens.settings.DarkMode;
import com.metrolist.music.ui.screens.settings.ThemeScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderDefaults$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ long f$6;
    public final /* synthetic */ int f$7;

    public /* synthetic */ SliderDefaults$$ExternalSyntheticLambda3(SliderDefaults sliderDefaults, MutableInteractionSourceImpl mutableInteractionSourceImpl, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i) {
        this.f$0 = sliderDefaults;
        this.f$1 = mutableInteractionSourceImpl;
        this.f$3 = modifier;
        this.f$4 = sliderColors;
        this.f$5 = z;
        this.f$6 = j;
        this.f$7 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$7;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Object obj5 = this.f$1;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                ((SliderDefaults) obj6).m332ThumbHwbPF3A((MutableInteractionSourceImpl) obj5, (Modifier) obj4, (SliderColors) obj3, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                ThemeScreenKt.m1512ThemeControlsyrwZFoE((DarkMode) obj6, (Function1) obj5, this.f$5, (Function1) obj4, this.f$6, (Function1) obj3, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }

    public /* synthetic */ SliderDefaults$$ExternalSyntheticLambda3(DarkMode darkMode, Function1 function1, boolean z, Function1 function2, long j, Function1 function3, int i) {
        this.f$0 = darkMode;
        this.f$1 = function1;
        this.f$5 = z;
        this.f$3 = function2;
        this.f$6 = j;
        this.f$4 = function3;
        this.f$7 = i;
    }
}
