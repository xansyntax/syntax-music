package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TapGestureDetectorKt$detectTapGestures$2$1 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ CoroutineScope $$this$coroutineScope;
    public final /* synthetic */ Function1 $onDoubleTap;
    public final /* synthetic */ Function3 $onPress;
    public final /* synthetic */ Function1 $onTap;
    public final /* synthetic */ PressGestureScopeImpl $pressScope;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$detectTapGestures$2$1(CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, Function1 function1, Function3 function3, Function1 function2, Continuation continuation) {
        super(2, continuation);
        this.$$this$coroutineScope = coroutineScope;
        this.$pressScope = pressGestureScopeImpl;
        this.$onDoubleTap = function1;
        this.$onPress = function3;
        this.$onTap = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TapGestureDetectorKt$detectTapGestures$2$1 tapGestureDetectorKt$detectTapGestures$2$1 = new TapGestureDetectorKt$detectTapGestures$2$1(this.$$this$coroutineScope, this.$pressScope, this.$onDoubleTap, this.$onPress, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2$1.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TapGestureDetectorKt$detectTapGestures$2$1) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
            this.label = true;
            Object objProcessTapGesture = TapGestureDetectorKt.processTapGesture(pointerEventHandlerCoroutine, this.$$this$coroutineScope, this.$pressScope, this.$onDoubleTap, this.$onPress, this.$onTap, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objProcessTapGesture == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
