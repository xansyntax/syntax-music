package androidx.compose.material3;

import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$sliderTapModifier$1$1$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ MutableInteractionSourceImpl $interactionSource;
    public final /* synthetic */ SliderState $state;
    public /* synthetic */ long J$0;
    public /* synthetic */ Object L$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$sliderTapModifier$1$1$1(MutableInteractionSourceImpl mutableInteractionSourceImpl, SliderState sliderState, Continuation continuation) {
        super(3, continuation);
        this.$interactionSource = mutableInteractionSourceImpl;
        this.$state = sliderState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        long j = ((Offset) obj2).packedValue;
        SliderKt$sliderTapModifier$1$1$1 sliderKt$sliderTapModifier$1$1$1 = new SliderKt$sliderTapModifier$1$1$1(this.$interactionSource, this.$state, (Continuation) obj3);
        sliderKt$sliderTapModifier$1$1$1.L$0 = (PressGestureScopeImpl) obj;
        sliderKt$sliderTapModifier$1$1$1.J$0 = j;
        return sliderKt$sliderTapModifier$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        float intValue;
        byte b = this.label;
        PressInteraction.Press press = null;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.$interactionSource;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (b != 0) {
                if (b == 1) {
                    press = (PressInteraction.Press) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (b != 2) {
                        if (b != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        th = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            PressGestureScopeImpl pressGestureScopeImpl = (PressGestureScopeImpl) this.L$0;
            long j = this.J$0;
            PressInteraction.Press press2 = new PressInteraction.Press(j);
            try {
                mutableInteractionSourceImpl.tryEmit(press2);
                SliderState sliderState = this.$state;
                if (sliderState.isVertical()) {
                    intValue = Float.intBitsToFloat((int) (j & 4294967295L));
                } else {
                    intValue = sliderState.isRtl ? sliderState.totalWidth$delegate.getIntValue() - Float.intBitsToFloat((int) (j >> 32)) : Float.intBitsToFloat((int) (j >> 32));
                }
                sliderState.pressOffset$delegate.setFloatValue(intValue - sliderState.rawOffset$delegate.getFloatValue());
                this.L$0 = press2;
                this.label = (byte) 1;
                obj = pressGestureScopeImpl.tryAwaitRelease(this);
                if (obj != coroutineSingletons) {
                    press = press2;
                }
            } catch (Throwable th2) {
                th = th2;
                press = press2;
                if (press == null) {
                    throw th;
                }
                PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                this.L$0 = th;
                this.label = (byte) 3;
                if (mutableInteractionSourceImpl.emit(cancel, this) != coroutineSingletons) {
                    th = th;
                    throw th;
                }
            }
            return coroutineSingletons;
            mutableInteractionSourceImpl.tryEmit(((Boolean) obj).booleanValue() ? new PressInteraction.Release(press) : new PressInteraction.Cancel(press));
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
