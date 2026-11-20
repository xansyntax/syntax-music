package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.material3.TooltipStateImpl;
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
public final class BasicTooltipKt$anchorSemantics$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TooltipStateImpl $state;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasicTooltipKt$anchorSemantics$1$1$1(TooltipStateImpl tooltipStateImpl, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$state = tooltipStateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new BasicTooltipKt$anchorSemantics$1$1$1(this.$state, continuation, (byte) 0);
            case 1:
                BasicTooltipKt$anchorSemantics$1$1$1 basicTooltipKt$anchorSemantics$1$1$1 = new BasicTooltipKt$anchorSemantics$1$1$1(this.$state, continuation, (byte) 1);
                basicTooltipKt$anchorSemantics$1$1$1.label = ((Boolean) obj).booleanValue();
                return basicTooltipKt$anchorSemantics$1$1$1;
            default:
                return new BasicTooltipKt$anchorSemantics$1$1$1(this.$state, continuation, (byte) 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((BasicTooltipKt$anchorSemantics$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                ((BasicTooltipKt$anchorSemantics$1$1$1) create(bool, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            default:
                return ((BasicTooltipKt$anchorSemantics$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        TooltipStateImpl tooltipStateImpl = this.$state;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (tooltipStateImpl.show(MutatePriority.Default, this) == coroutineSingletons) {
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
            case 1:
                ResultKt.throwOnFailure(obj);
                if (!this.label) {
                    tooltipStateImpl.dismiss();
                }
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (tooltipStateImpl.show(MutatePriority.UserInput, this) == coroutineSingletons) {
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
