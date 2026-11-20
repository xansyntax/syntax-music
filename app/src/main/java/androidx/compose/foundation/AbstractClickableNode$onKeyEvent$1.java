package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
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
public final class AbstractClickableNode$onKeyEvent$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ PressInteraction.Press $press;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ AbstractClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractClickableNode$onKeyEvent$1(AbstractClickableNode abstractClickableNode, PressInteraction.Press press, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = abstractClickableNode;
        this.$press = press;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        PressInteraction.Press press = this.$press;
        AbstractClickableNode abstractClickableNode = this.this$0;
        switch (b) {
            case 0:
                return new AbstractClickableNode$onKeyEvent$1(abstractClickableNode, press, continuation, (byte) 0);
            case 1:
                return new AbstractClickableNode$onKeyEvent$1(abstractClickableNode, press, continuation, (byte) 1);
            case 2:
                return new AbstractClickableNode$onKeyEvent$1(abstractClickableNode, press, continuation, (byte) 2);
            default:
                return new AbstractClickableNode$onKeyEvent$1(abstractClickableNode, press, continuation, (byte) 3);
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
            case 1:
                break;
            case 2:
                break;
        }
        return ((AbstractClickableNode$onKeyEvent$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PressInteraction.Press press = this.$press;
        AbstractClickableNode abstractClickableNode = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                MutableInteractionSourceImpl mutableInteractionSourceImpl = abstractClickableNode.interactionSource;
                if (mutableInteractionSourceImpl == null) {
                    return unit;
                }
                this.label = true;
                return mutableInteractionSourceImpl.emit(press, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = abstractClickableNode.interactionSource;
                if (mutableInteractionSourceImpl2 == null) {
                    return unit;
                }
                PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                this.label = true;
                return mutableInteractionSourceImpl2.emit(cancel, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 2:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                MutableInteractionSourceImpl mutableInteractionSourceImpl3 = abstractClickableNode.interactionSource;
                if (mutableInteractionSourceImpl3 == null) {
                    return unit;
                }
                PressInteraction.Cancel cancel2 = new PressInteraction.Cancel(press);
                this.label = true;
                return mutableInteractionSourceImpl3.emit(cancel2, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                MutableInteractionSourceImpl mutableInteractionSourceImpl4 = abstractClickableNode.interactionSource;
                if (mutableInteractionSourceImpl4 == null) {
                    return unit;
                }
                PressInteraction.Release release = new PressInteraction.Release(press);
                this.label = true;
                return mutableInteractionSourceImpl4.emit(release, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
