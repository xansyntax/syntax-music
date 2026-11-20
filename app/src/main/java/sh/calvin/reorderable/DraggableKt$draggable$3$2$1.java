package sh.calvin.reorderable;

import androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.ViewConfiguration;
import com.metrolist.music.ui.component.AppNavigationKt$NavLongPress$1$1$1;
import com.metrolist.music.ui.screens.Screens;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DraggableKt$draggable$3$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $coroutineScope;
    public final /* synthetic */ Object $dragGestureDetector;
    public final /* synthetic */ Object $dragInteractionStart$delegate;
    public final /* synthetic */ MutableState $dragStarted$delegate;
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ Function2 $onDrag;
    public final /* synthetic */ Object $onDragStarted;
    public final /* synthetic */ Function0 $onDragStopped;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DraggableKt$draggable$3$2$1(MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, ViewConfiguration viewConfiguration, HapticFeedback hapticFeedback, Function0 function0, Function0 function1, Function2 function2, Screens screens, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.L$0 = mutableInteractionSourceImpl;
        this.$enabled = z;
        this.$dragGestureDetector = viewConfiguration;
        this.$onDragStarted = hapticFeedback;
        this.$onDragStopped = function0;
        this.$dragInteractionStart$delegate = function1;
        this.$onDrag = function2;
        this.$coroutineScope = screens;
        this.$dragStarted$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$coroutineScope;
        Object obj3 = this.$dragInteractionStart$delegate;
        Object obj4 = this.$onDragStarted;
        Object obj5 = this.$dragGestureDetector;
        switch (b) {
            case 0:
                Function0 function0 = this.$onDragStopped;
                DraggableKt$draggable$3$2$1 draggableKt$draggable$3$2$1 = new DraggableKt$draggable$3$2$1(this.$enabled, (DragGestureDetector$Press) obj5, this.$onDrag, (Function1) obj4, this.$dragStarted$delegate, (CoroutineScope) obj2, (MutableState) obj3, function0, continuation);
                draggableKt$draggable$3$2$1.L$0 = obj;
                return draggableKt$draggable$3$2$1;
            case 1:
                return new DraggableKt$draggable$3$2$1((MutableInteractionSourceImpl) this.L$0, this.$enabled, (ViewConfiguration) obj5, (HapticFeedback) obj4, this.$onDragStopped, (Function0) obj3, this.$onDrag, (Screens) obj2, this.$dragStarted$delegate, continuation, (byte) 1);
            default:
                return new DraggableKt$draggable$3$2$1((MutableInteractionSourceImpl) this.L$0, this.$enabled, (ViewConfiguration) obj5, (HapticFeedback) obj4, this.$onDragStopped, (Function0) obj3, this.$onDrag, (Screens) obj2, this.$dragStarted$delegate, continuation, (byte) 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((DraggableKt$draggable$3$2$1) create((PointerInputScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((DraggableKt$draggable$3$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((DraggableKt$draggable$3$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0111  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objDetectDragGestures;
        byte b = this.$r8$classId;
        Object obj2 = this.$coroutineScope;
        Object obj3 = this.$dragInteractionStart$delegate;
        Object obj4 = this.$onDragStarted;
        Object obj5 = this.$dragGestureDetector;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    if (this.$enabled) {
                        CoroutineScope coroutineScope = (CoroutineScope) obj2;
                        MutableState mutableState = (MutableState) obj3;
                        MutableState mutableState2 = this.$dragStarted$delegate;
                        DraggableKt$draggable$3$1$1 draggableKt$draggable$3$1$1 = new DraggableKt$draggable$3$1$1((Function1) obj4, mutableState2, coroutineScope, mutableState);
                        Function0 function0 = this.$onDragStopped;
                        DraggableKt$draggable$3$2$1$1$2 draggableKt$draggable$3$2$1$1$2 = new DraggableKt$draggable$3$2$1$1$2(function0, mutableState, coroutineScope, mutableState2, (byte) 0);
                        DraggableKt$draggable$3$2$1$1$2 draggableKt$draggable$3$2$1$1$3 = new DraggableKt$draggable$3$2$1$1$2(function0, mutableState, coroutineScope, mutableState2, (byte) 1);
                        this.label = true;
                        byte b2 = ((DragGestureDetector$Press) obj5).$r8$classId;
                        Function2 function2 = this.$onDrag;
                        switch (b2) {
                            case 0:
                                objDetectDragGestures = ScrollableKt.detectDragGestures(pointerInputScope, draggableKt$draggable$3$1$1, draggableKt$draggable$3$2$1$1$2, draggableKt$draggable$3$2$1$1$3, function2, this);
                                if (objDetectDragGestures != coroutineSingletons) {
                                    objDetectDragGestures = unit;
                                }
                                break;
                            default:
                                objDetectDragGestures = ScrollableKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(draggableKt$draggable$3$1$1, draggableKt$draggable$3$2$1$1$2, draggableKt$draggable$3$2$1$1$3, function2, null), this);
                                if (objDetectDragGestures != coroutineSingletons) {
                                    objDetectDragGestures = unit;
                                }
                                if (objDetectDragGestures != coroutineSingletons) {
                                    objDetectDragGestures = unit;
                                }
                                break;
                        }
                        if (objDetectDragGestures == coroutineSingletons) {
                            return coroutineSingletons;
                        }
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
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    SharedFlowImpl sharedFlowImpl = ((MutableInteractionSourceImpl) this.L$0).interactions;
                    Screens screens = (Screens) obj2;
                    AppNavigationKt$NavLongPress$1$1$1 appNavigationKt$NavLongPress$1$1$1 = new AppNavigationKt$NavLongPress$1$1$1(ref$BooleanRef, this.$enabled, (ViewConfiguration) obj5, (HapticFeedback) obj4, this.$onDragStopped, (Function0) obj3, this.$onDrag, screens, this.$dragStarted$delegate, null, (byte) 1);
                    this.label = true;
                    if (StateFlowKt.collectLatest(sharedFlowImpl, appNavigationKt$NavLongPress$1$1$1, this) == coroutineSingletons) {
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
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                    SharedFlowImpl sharedFlowImpl2 = ((MutableInteractionSourceImpl) this.L$0).interactions;
                    Screens screens2 = (Screens) obj2;
                    AppNavigationKt$NavLongPress$1$1$1 appNavigationKt$NavLongPress$1$1$2 = new AppNavigationKt$NavLongPress$1$1$1(ref$BooleanRef2, this.$enabled, (ViewConfiguration) obj5, (HapticFeedback) obj4, this.$onDragStopped, (Function0) obj3, this.$onDrag, screens2, this.$dragStarted$delegate, null, (byte) 0);
                    this.label = true;
                    if (StateFlowKt.collectLatest(sharedFlowImpl2, appNavigationKt$NavLongPress$1$1$2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$3$2$1(boolean z, DragGestureDetector$Press dragGestureDetector$Press, Function2 function2, Function1 function1, MutableState mutableState, CoroutineScope coroutineScope, MutableState mutableState2, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$enabled = z;
        this.$dragGestureDetector = dragGestureDetector$Press;
        this.$onDrag = function2;
        this.$onDragStarted = function1;
        this.$dragStarted$delegate = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$dragInteractionStart$delegate = mutableState2;
        this.$onDragStopped = function0;
    }
}
