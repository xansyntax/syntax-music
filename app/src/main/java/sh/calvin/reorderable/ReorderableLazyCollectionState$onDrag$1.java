package sh.calvin.reorderable;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyCollectionState$onDrag$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ReorderableLazyListKt$toLazyCollectionItemInfo$1 $draggingItem;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ReorderableLazyListKt$toLazyCollectionItemInfo$1 $targetItem;
    public boolean label;
    public final /* synthetic */ ReorderableLazyListState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReorderableLazyCollectionState$onDrag$1(ReorderableLazyListState reorderableLazyListState, ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1, ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = reorderableLazyListState;
        this.$draggingItem = reorderableLazyListKt$toLazyCollectionItemInfo$1;
        this.$targetItem = reorderableLazyListKt$toLazyCollectionItemInfo$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ReorderableLazyCollectionState$onDrag$1(this.this$0, this.$draggingItem, this.$targetItem, continuation, (byte) 0);
            default:
                return new ReorderableLazyCollectionState$onDrag$1(this.this$0, this.$draggingItem, this.$targetItem, continuation, (byte) 1);
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
        return ((ReorderableLazyCollectionState$onDrag$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1 = this.$targetItem;
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$2 = this.$draggingItem;
        ReorderableLazyListState reorderableLazyListState = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return reorderableLazyListState.moveItems(reorderableLazyListKt$toLazyCollectionItemInfo$2, reorderableLazyListKt$toLazyCollectionItemInfo$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return reorderableLazyListState.moveItems(reorderableLazyListKt$toLazyCollectionItemInfo$2, reorderableLazyListKt$toLazyCollectionItemInfo$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
