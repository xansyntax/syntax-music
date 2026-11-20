package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Dp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChipElevation$animateElevation$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Animatable $animatable;
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ Interaction $interaction;
    public final /* synthetic */ MutableState $lastInteraction$delegate;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ float $target;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChipElevation$animateElevation$2$1(Animatable animatable, float f, boolean z, Interaction interaction, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z;
        this.$interaction = interaction;
        this.$lastInteraction$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ChipElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.$interaction, this.$lastInteraction$delegate, continuation, (byte) 0);
            default:
                return new ChipElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.$interaction, this.$lastInteraction$delegate, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((ChipElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if (r6.snapTo(r13, r12) == r5) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (androidx.compose.material3.internal.ElevationKt.m367animateElevationrAjV9yQ(r6, r7, r13, r11, r12) == r5) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
    
        if (r6.snapTo(r13, r12) == r5) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
    
        if (androidx.compose.material3.internal.ElevationKt.m367animateElevationrAjV9yQ(r6, r7, r13, r11, r12) == r5) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return r5;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.$enabled;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Animatable animatable = this.$animatable;
        float f = this.$target;
        MutableState mutableState = this.$lastInteraction$delegate;
        Interaction interaction = this.$interaction;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Dp.m796equalsimpl0(((Dp) animatable.targetValue$delegate.getValue()).value, f)) {
                        return unit;
                    }
                    if (!z) {
                        Dp dp = new Dp(f);
                        this.label = (byte) 1;
                    } else {
                        Interaction interaction2 = (Interaction) mutableState.getValue();
                        this.label = (byte) 2;
                    }
                    break;
                } else {
                    if (b2 != 1 && b2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                mutableState.setValue(interaction);
                return unit;
            default:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Dp.m796equalsimpl0(((Dp) animatable.targetValue$delegate.getValue()).value, f)) {
                        return unit;
                    }
                    if (!z) {
                        Dp dp2 = new Dp(f);
                        this.label = (byte) 1;
                    } else {
                        Interaction interaction3 = (Interaction) mutableState.getValue();
                        this.label = (byte) 2;
                    }
                    break;
                } else {
                    if (b3 != 1 && b3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                mutableState.setValue(interaction);
                return unit;
        }
    }
}
