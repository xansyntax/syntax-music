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
public final class AbstractClickableNode$handlePressInteractionStart$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableInteractionSourceImpl $interactionSource;
    public final /* synthetic */ PressInteraction.Press $press;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickableNode$handlePressInteractionStart$1$2(PressInteraction.Press press, MutableInteractionSourceImpl mutableInteractionSourceImpl, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.$press = press;
        this.$interactionSource = mutableInteractionSourceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        PressInteraction.Press press = this.$press;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.$interactionSource;
        switch (b) {
            case 0:
                return new AbstractClickableNode$handlePressInteractionStart$1$2(mutableInteractionSourceImpl, press, continuation, (byte) 0);
            case 1:
                return new AbstractClickableNode$handlePressInteractionStart$1$2(press, mutableInteractionSourceImpl, continuation);
            default:
                return new AbstractClickableNode$handlePressInteractionStart$1$2(mutableInteractionSourceImpl, press, continuation, (byte) 2);
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
        }
        return ((AbstractClickableNode$handlePressInteractionStart$1$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PressInteraction.Press press = this.$press;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.$interactionSource;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return mutableInteractionSourceImpl.emit(press, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    PressInteraction.Release release = new PressInteraction.Release(press);
                    this.label = true;
                    return mutableInteractionSourceImpl.emit(release, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return mutableInteractionSourceImpl.emit(press, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractClickableNode$handlePressInteractionStart$1$2(MutableInteractionSourceImpl mutableInteractionSourceImpl, PressInteraction.Press press, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$interactionSource = mutableInteractionSourceImpl;
        this.$press = press;
    }
}
