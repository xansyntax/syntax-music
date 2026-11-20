package sh.calvin.reorderable;

import androidx.compose.foundation.interaction.DragInteraction$Start;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DraggableKt$draggable$3$1$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ DragInteraction$Start $it;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DraggableKt$draggable$3$1$1$1$1$1(DragInteraction$Start dragInteraction$Start, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$it = dragInteraction$Start;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        DragInteraction$Start dragInteraction$Start = this.$it;
        switch (b) {
            case 0:
                return new DraggableKt$draggable$3$1$1$1$1$1(dragInteraction$Start, continuation, (byte) 0);
            case 1:
                return new DraggableKt$draggable$3$1$1$1$1$1(dragInteraction$Start, continuation, (byte) 1);
            case 2:
                return new DraggableKt$draggable$3$1$1$1$1$1(dragInteraction$Start, continuation, (byte) 2);
            default:
                return new DraggableKt$draggable$3$1$1$1$1$1(dragInteraction$Start, continuation, (byte) 3);
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
                ((DraggableKt$draggable$3$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 1:
                ((DraggableKt$draggable$3$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 2:
                ((DraggableKt$draggable$3$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((DraggableKt$draggable$3$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                break;
            case 2:
                ResultKt.throwOnFailure(obj);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                break;
        }
        return unit;
    }
}
