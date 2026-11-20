package sh.calvin.reorderable;

import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DraggableKt$draggable$3$2$1$1$2 extends Lambda implements Function0 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ MutableState $dragInteractionStart$delegate;
    public final /* synthetic */ MutableState $dragStarted$delegate;
    public final /* synthetic */ Function0 $onDragStopped;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DraggableKt$draggable$3$2$1$1$2(Function0 function0, MutableState mutableState, CoroutineScope coroutineScope, MutableState mutableState2, byte b) {
        super(0);
        this.$r8$classId = b;
        this.$onDragStopped = function0;
        this.$dragInteractionStart$delegate = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$dragStarted$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.$onDragStopped;
        CoroutineScope coroutineScope = this.$coroutineScope;
        MutableState mutableState = this.$dragInteractionStart$delegate;
        MutableState mutableState2 = this.$dragStarted$delegate;
        switch (b) {
            case 0:
                DragInteraction$Start dragInteraction$Start = (DragInteraction$Start) mutableState.getValue();
                if (dragInteraction$Start != null) {
                    AwaitKt.launch$default(coroutineScope, null, null, new DraggableKt$draggable$3$1$1$1$1$1(dragInteraction$Start, null, (byte) 2), 3);
                }
                if (((Boolean) mutableState2.getValue()).booleanValue()) {
                    function0.invoke();
                }
                mutableState2.setValue(Boolean.FALSE);
                break;
            default:
                DragInteraction$Start dragInteraction$Start2 = (DragInteraction$Start) mutableState.getValue();
                if (dragInteraction$Start2 != null) {
                    AwaitKt.launch$default(coroutineScope, null, null, new DraggableKt$draggable$3$1$1$1$1$1(dragInteraction$Start2, null, (byte) 3), 3);
                }
                if (((Boolean) mutableState2.getValue()).booleanValue()) {
                    function0.invoke();
                }
                mutableState2.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }
}
