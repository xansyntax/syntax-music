package androidx.compose.ui.platform;

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
public final class WrappedComposition$setContent$1$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ WrappedComposition this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WrappedComposition$setContent$1$2$1$1(WrappedComposition wrappedComposition, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = wrappedComposition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        WrappedComposition wrappedComposition = this.this$0;
        switch (b) {
            case 0:
                return new WrappedComposition$setContent$1$2$1$1(wrappedComposition, continuation, (byte) 0);
            default:
                return new WrappedComposition$setContent$1$2$1$1(wrappedComposition, continuation, (byte) 1);
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
        return ((WrappedComposition$setContent$1$2$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        byte b = this.$r8$classId;
        WrappedComposition wrappedComposition = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    AndroidComposeView androidComposeView = wrappedComposition.owner;
                    this.label = true;
                    Object objBoundsUpdatesEventLoop$ui = androidComposeView.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui(this);
                    if (objBoundsUpdatesEventLoop$ui != coroutineSingletons) {
                        objBoundsUpdatesEventLoop$ui = unit;
                    }
                    if (objBoundsUpdatesEventLoop$ui == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    AndroidComposeView androidComposeView2 = wrappedComposition.owner;
                    this.label = true;
                    Object objBoundsUpdatesEventLoop$ui2 = androidComposeView2.contentCaptureManager.boundsUpdatesEventLoop$ui(this);
                    if (objBoundsUpdatesEventLoop$ui2 != coroutineSingletons) {
                        objBoundsUpdatesEventLoop$ui2 = unit;
                    }
                    if (objBoundsUpdatesEventLoop$ui2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
        }
    }
}
