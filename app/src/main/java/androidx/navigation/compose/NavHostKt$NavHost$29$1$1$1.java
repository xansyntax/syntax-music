package androidx.navigation.compose;

import androidx.compose.animation.core.MutatorMutex;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.SeekableTransitionState$snapTo$2;
import androidx.compose.animation.core.Transition;
import androidx.navigation.NavBackStackEntry;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostKt$NavHost$29$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ NavBackStackEntry $backStackEntry;
    public final /* synthetic */ SeekableTransitionState $transitionState;
    public final /* synthetic */ float $value;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$29$1$1$1(float f, SeekableTransitionState seekableTransitionState, NavBackStackEntry navBackStackEntry, Continuation continuation) {
        super(2, continuation);
        this.$value = f;
        this.$transitionState = seekableTransitionState;
        this.$backStackEntry = navBackStackEntry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NavHostKt$NavHost$29$1$1$1(this.$value, this.$transitionState, this.$backStackEntry, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((NavHostKt$NavHost$29$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objMutate$default;
        byte b = this.label;
        Unit unit = Unit.INSTANCE;
        SeekableTransitionState seekableTransitionState = this.$transitionState;
        float f = this.$value;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
                this.label = (byte) 1;
                if (seekableTransitionState.seekTo(f, seekableTransitionState.targetState$delegate.getValue(), this) != coroutineSingletons) {
                }
            }
            return coroutineSingletons;
        }
        if (b != 1) {
            if (b == 2) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            this.label = (byte) 2;
            Transition transition = seekableTransitionState.transition;
            if (transition == null) {
                objMutate$default = unit;
            } else {
                Object value = seekableTransitionState.currentState$delegate.getValue();
                NavBackStackEntry navBackStackEntry = this.$backStackEntry;
                if ((Intrinsics.areEqual(value, navBackStackEntry) && Intrinsics.areEqual(seekableTransitionState.targetState$delegate.getValue(), navBackStackEntry)) || (objMutate$default = MutatorMutex.mutate$default(seekableTransitionState.mutatorMutex, new SeekableTransitionState$snapTo$2(seekableTransitionState, navBackStackEntry, transition, null, (byte) 0), this)) != coroutineSingletons) {
                    objMutate$default = unit;
                }
            }
            if (objMutate$default == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return unit;
    }
}
