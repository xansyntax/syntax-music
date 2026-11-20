package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt$NoOpOnDragStarted$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DraggableKt$NoOpOnDragStarted$1(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        byte b2 = 3;
        switch (b) {
            case 0:
                long j = ((Offset) obj2).packedValue;
                new DraggableKt$NoOpOnDragStarted$1(b2, (Continuation) obj3, (byte) 0).invokeSuspend(unit);
                break;
            case 1:
                ((Number) obj2).floatValue();
                new DraggableKt$NoOpOnDragStarted$1(b2, (Continuation) obj3, (byte) 1).invokeSuspend(unit);
                break;
            case 2:
                long j2 = ((Offset) obj2).packedValue;
                new DraggableKt$NoOpOnDragStarted$1(b2, (Continuation) obj3, (byte) 2).invokeSuspend(unit);
                break;
            default:
                new DraggableKt$NoOpOnDragStarted$1(b2, (Continuation) obj3, b2).invokeSuspend(unit);
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
