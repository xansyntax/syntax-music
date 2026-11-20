package androidx.room;

import android.app.PendingIntent;
import androidx.compose.material3.SliderState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InvalidationTracker$createFlow$2 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InvalidationTracker$createFlow$2(Object obj, Continuation continuation, byte b) {
        super(3, continuation);
        this.$r8$classId = b;
        this.this$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws PendingIntent.CanceledException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.this$0;
        switch (b) {
            case 0:
                new InvalidationTracker$createFlow$2((InvalidationTracker) obj4, (Continuation) obj3, (byte) 0).invokeSuspend(unit);
                break;
            case 1:
                new InvalidationTracker$createFlow$2((Ref$BooleanRef) obj4, (Continuation) obj3, (byte) 1).invokeSuspend(unit);
                break;
            default:
                ((Number) obj2).floatValue();
                new InvalidationTracker$createFlow$2((SliderState) obj4, (Continuation) obj3, (byte) 2).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PendingIntent.CanceledException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ((InvalidationTracker) obj2).flowCount.decrementAndGet();
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                ((Ref$BooleanRef) obj2).element = true;
                break;
            default:
                ResultKt.throwOnFailure(obj);
                ((SliderState) obj2).gestureEndAction.invoke();
                break;
        }
        return unit;
    }
}
