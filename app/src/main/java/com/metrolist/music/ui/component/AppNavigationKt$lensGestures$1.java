package com.metrolist.music.ui.component;

import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppNavigationKt$lensGestures$1 implements PointerInputEventHandler {
    public final /* synthetic */ LensController $c;
    public final /* synthetic */ float $itemW;

    /* JADX INFO: renamed from: com.metrolist.music.ui.component.AppNavigationKt$lensGestures$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2 {
        public final /* synthetic */ LensController $c;
        public final /* synthetic */ float $itemW;
        public /* synthetic */ Object L$0;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LensController lensController, float f, Continuation continuation) {
            super(2, continuation);
            this.$c = lensController;
            this.$itemW = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$c, this.$itemW, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = true;
                Object objLensGesture = AppNavigationKt.lensGesture(pointerEventHandlerCoroutine, this.$c, this.$itemW, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objLensGesture == coroutineSingletons) {
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

    public AppNavigationKt$lensGestures$1(LensController lensController, float f) {
        this.$c = lensController;
        this.$itemW = f;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(this.$c, this.$itemW, null), continuation);
        return objAwaitEachGesture == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitEachGesture : Unit.INSTANCE;
    }
}
