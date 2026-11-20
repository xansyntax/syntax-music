package sh.calvin.reorderable;

import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DraggableKt$draggable$3$1$1 extends Lambda implements Function1 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ MutableState $dragInteractionStart$delegate;
    public final /* synthetic */ MutableState $dragStarted$delegate;
    public final /* synthetic */ Function $onDragStopped;
    public final /* synthetic */ byte $r8$classId = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$3$1$1(Function0 function0, MutableState mutableState, MutableState mutableState2, CoroutineScope coroutineScope) {
        super(1);
        this.$onDragStopped = function0;
        this.$dragStarted$delegate = mutableState;
        this.$dragInteractionStart$delegate = mutableState2;
        this.$coroutineScope = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Function function = this.$onDragStopped;
        final CoroutineScope coroutineScope = this.$coroutineScope;
        final MutableState mutableState = this.$dragInteractionStart$delegate;
        final MutableState mutableState2 = this.$dragStarted$delegate;
        switch (b) {
            case 0:
                ((DisposableEffectScope) obj).getClass();
                final Function0 function0 = (Function0) function;
                return new DisposableEffectResult() { // from class: sh.calvin.reorderable.DraggableKt$draggable$3$1$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        MutableState mutableState3 = mutableState2;
                        if (((Boolean) mutableState3.getValue()).booleanValue()) {
                            DragInteraction$Start dragInteraction$Start = (DragInteraction$Start) mutableState.getValue();
                            if (dragInteraction$Start != null) {
                                AwaitKt.launch$default(coroutineScope, null, null, new DraggableKt$draggable$3$1$1$1$1$1(dragInteraction$Start, null, (byte) 0), 3);
                            }
                            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                                function0.invoke();
                            }
                            mutableState3.setValue(Boolean.FALSE);
                        }
                    }
                };
            default:
                Offset offset = (Offset) obj;
                long j = offset.packedValue;
                mutableState2.setValue(Boolean.TRUE);
                DragInteraction$Start dragInteraction$Start = new DragInteraction$Start();
                AwaitKt.launch$default(coroutineScope, null, null, new DraggableKt$draggable$3$1$1$1$1$1(dragInteraction$Start, null, (byte) 1), 3);
                mutableState.setValue(dragInteraction$Start);
                ((Function1) function).invoke(offset);
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$3$1$1(Function1 function1, MutableState mutableState, CoroutineScope coroutineScope, MutableState mutableState2) {
        super(1);
        this.$onDragStopped = function1;
        this.$dragStarted$delegate = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$dragInteractionStart$delegate = mutableState2;
    }
}
