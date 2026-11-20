package sh.calvin.reorderable;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyCollectionState$onDragStop$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ long $startOffset;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReorderableLazyCollectionState$onDragStop$1(long j, SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, Continuation continuation) {
        super(2, continuation);
        this.$startOffset = j;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.this$0;
        long j = this.$startOffset;
        switch (b) {
            case 0:
                return new ReorderableLazyCollectionState$onDragStop$1((ReorderableLazyListState) obj2, j, continuation);
            default:
                return new ReorderableLazyCollectionState$onDragStop$1(j, (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj2, continuation);
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
        return ((ReorderableLazyCollectionState$onDragStop$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(8, r17) == r8) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b7, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, null, null, r17, 12) == r8) goto L33;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        long j = this.$startOffset;
        switch (b) {
            case 0:
                ReorderableLazyListState reorderableLazyListState = (ReorderableLazyListState) obj2;
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = reorderableLazyListState.previousDraggingItemOffset;
                    Offset offset = new Offset(j);
                    this.label = (byte) 1;
                    if (animatable.snapTo(offset, this) != coroutineSingletons) {
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
                reorderableLazyListState.previousDraggingItemKey$delegate.setValue(null);
                return unit;
                Animatable animatable2 = reorderableLazyListState.previousDraggingItemOffset;
                Offset offset2 = new Offset(0L);
                SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new Offset((((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L)), 1);
                this.label = (byte) 2;
                break;
            default:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = (byte) 1;
                    if (AwaitKt.delay(j - 8, this) != coroutineSingletons) {
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
                CancellableContinuationImpl cancellableContinuationImpl = ((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj2).pointerAwaiter;
                if (cancellableContinuationImpl == null) {
                    return unit;
                }
                cancellableContinuationImpl.resumeWith(new Result.Failure(new PointerEventTimeoutCancellationException(j)));
                return unit;
                this.label = (byte) 2;
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReorderableLazyCollectionState$onDragStop$1(ReorderableLazyListState reorderableLazyListState, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = reorderableLazyListState;
        this.$startOffset = j;
    }
}
