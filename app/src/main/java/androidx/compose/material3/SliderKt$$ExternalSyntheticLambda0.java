package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderKt$$ExternalSyntheticLambda0 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableInteractionSourceImpl f$0;
    public final /* synthetic */ SliderColors f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ SliderKt$$ExternalSyntheticLambda0(MutableInteractionSourceImpl mutableInteractionSourceImpl, SliderColors sliderColors, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableInteractionSourceImpl;
        this.f$1 = sliderColors;
        this.f$2 = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Composer composer = (Composer) obj2;
        ((Integer) obj3).getClass();
        switch (b) {
            case 0:
                SliderDefaults.INSTANCE.m331Thumb9LiSoMs(this.f$0, null, this.f$1, this.f$2, 0L, composer, 196608);
                break;
            default:
                SliderDefaults.INSTANCE.m331Thumb9LiSoMs(this.f$0, null, this.f$1, this.f$2, 0L, composer, 196608);
                break;
        }
        return unit;
    }
}
