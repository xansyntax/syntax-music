package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AbstractClickableNode$handlePressInteractionStart$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableInteractionSourceImpl $interactionSource;
    public final /* synthetic */ PressInteraction.Press $press;
    public final /* synthetic */ byte $r8$classId;
    public byte label;
    public final /* synthetic */ AbstractClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractClickableNode$handlePressInteractionStart$1$1(MutableInteractionSourceImpl mutableInteractionSourceImpl, PressInteraction.Press press, AbstractClickableNode abstractClickableNode, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$interactionSource = mutableInteractionSourceImpl;
        this.$press = press;
        this.this$0 = abstractClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new AbstractClickableNode$handlePressInteractionStart$1$1(this.$interactionSource, this.$press, this.this$0, continuation, (byte) 0);
            default:
                return new AbstractClickableNode$handlePressInteractionStart$1$1(this.$interactionSource, this.$press, this.this$0, continuation, (byte) 1);
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
        return ((AbstractClickableNode$handlePressInteractionStart$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r3.emit(r9, r10) == r6) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        if (r3.emit(r9, r10) == r6) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        AbstractClickableNode abstractClickableNode = this.this$0;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.$interactionSource;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        PressInteraction.Press press = this.$press;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = Clickable_androidKt.TapIndicationDelay;
                    this.label = (byte) 1;
                    if (AwaitKt.delay(j, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b2 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (b2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                abstractClickableNode.indirectPointerPressInteraction = press;
                return unit;
                this.label = (byte) 2;
                break;
            default:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j2 = Clickable_androidKt.TapIndicationDelay;
                    this.label = (byte) 1;
                    if (AwaitKt.delay(j2, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (b3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                abstractClickableNode.pressInteraction = press;
                return unit;
                this.label = (byte) 2;
                break;
        }
    }
}
