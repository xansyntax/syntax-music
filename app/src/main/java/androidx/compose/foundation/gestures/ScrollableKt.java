package androidx.compose.foundation.gestures;

import androidx.collection.internal.Lock;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.ViewConfiguration;
import coil3.RealImageLoader;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ScrollableKt {
    public static final BorderKt$$ExternalSyntheticLambda1 AlwaysDrag = new BorderKt$$ExternalSyntheticLambda1((byte) 21);
    public static final DecayAnimationSpecImpl NoOpDecayAnimationSpec = new DecayAnimationSpecImpl(new Lock((byte) 3));
    public static final ScrollableKt$NoOpScrollScope$1 NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();
    public static final OffsetKt$$ExternalSyntheticLambda0 NoOnReport = new OffsetKt$$ExternalSyntheticLambda0(1);

    public static final DefaultDraggableAnchors DraggableAnchors(Function1 function1) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        function1.invoke(draggableAnchorsConfig);
        float[] fArr = draggableAnchorsConfig.positions;
        ArrayList arrayList = draggableAnchorsConfig.keys;
        int size = arrayList.size();
        Okio__OkioKt.copyOfRangeToIndexCheck(size, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, 0, size);
        fArrCopyOfRange.getClass();
        return new DefaultDraggableAnchors(arrayList, fArrCopyOfRange);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object animateScrollBy(ScrollableState scrollableState, float f, FiniteAnimationSpec finiteAnimationSpec, ContinuationImpl continuationImpl) {
        ScrollExtensionsKt$animateScrollBy$1 scrollExtensionsKt$animateScrollBy$1;
        Ref$FloatRef ref$FloatRef;
        if (continuationImpl instanceof ScrollExtensionsKt$animateScrollBy$1) {
            scrollExtensionsKt$animateScrollBy$1 = (ScrollExtensionsKt$animateScrollBy$1) continuationImpl;
            int i = scrollExtensionsKt$animateScrollBy$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollExtensionsKt$animateScrollBy$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollExtensionsKt$animateScrollBy$1 = new ScrollExtensionsKt$animateScrollBy$1(continuationImpl);
            }
        } else {
            scrollExtensionsKt$animateScrollBy$1 = new ScrollExtensionsKt$animateScrollBy$1(continuationImpl);
        }
        Object obj = scrollExtensionsKt$animateScrollBy$1.result;
        int i2 = scrollExtensionsKt$animateScrollBy$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            Function2 scrollExtensionsKt$animateScrollBy$2 = new ScrollExtensionsKt$animateScrollBy$2(f, finiteAnimationSpec, ref$FloatRef2, null);
            scrollExtensionsKt$animateScrollBy$1.L$0 = ref$FloatRef2;
            scrollExtensionsKt$animateScrollBy$1.label = 1;
            Object objScroll = scrollableState.scroll(MutatePriority.Default, scrollExtensionsKt$animateScrollBy$2, scrollExtensionsKt$animateScrollBy$1);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objScroll == obj2) {
                return obj2;
            }
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$FloatRef = scrollExtensionsKt$animateScrollBy$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Float(ref$FloatRef.element);
    }

    public static final Object animateTo(NodeChain nodeChain, float f, AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1, DefaultDraggableAnchors defaultDraggableAnchors, Object obj, AnimationSpec animationSpec, SuspendLambda suspendLambda) {
        Object objAnimate;
        float fPositionOf = defaultDraggableAnchors.positionOf(obj);
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.element = Float.isNaN(((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue()) ? CropImageView.DEFAULT_ASPECT_RATIO : ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
        if (!Float.isNaN(fPositionOf)) {
            float f2 = ref$FloatRef.element;
            if (f2 != fPositionOf && (objAnimate = ArcSplineKt.animate(f2, fPositionOf, f, animationSpec, new ButtonKt$$ExternalSyntheticLambda1(anchoredDraggableState$anchoredDragScope$1, ref$FloatRef, (byte) 3), suspendLambda)) == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return objAnimate;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073 A[LOOP:0: B:22:0x0066->B:26:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x004e A[EDGE_INSN: B:31:0x004e->B:18:0x004e BREAK  A[LOOP:0: B:22:0x0066->B:26:0x0073], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:21:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitAllPointersUp(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r7, androidx.compose.ui.input.pointer.PointerEventPass r8, kotlin.coroutines.jvm.internal.BaseContinuationImpl r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2d
            androidx.compose.ui.input.pointer.PointerEventPass r7 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r8 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L5d
        L2d:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            r7 = 0
            return r7
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r9 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
            androidx.compose.ui.input.pointer.PointerEvent r9 = r9.currentEvent
            java.util.List r9 = r9.changes
            int r1 = r9.size()
            r4 = r2
        L42:
            if (r4 >= r1) goto L79
            java.lang.Object r5 = r9.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r5 = r5.pressed
            if (r5 == 0) goto L76
        L4e:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r7.awaitPointerEvent(r8, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r9 != r1) goto L5d
            return r1
        L5d:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r9 = r9.changes
            int r1 = r9.size()
            r4 = r2
        L66:
            if (r4 >= r1) goto L79
            java.lang.Object r5 = r9.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r5 = r5.pressed
            if (r5 == 0) goto L73
            goto L4e
        L73:
            int r4 = r4 + 1
            goto L66
        L76:
            int r4 = r4 + 1
            goto L42
        L79:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.awaitAllPointersUp(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    public static final Object awaitEachGesture(PointerInputScope pointerInputScope, Function2 function2, Continuation continuation) {
        Object objAwaitPointerEventScope = ((SuspendingPointerInputModifierNodeImpl) pointerInputScope).awaitPointerEventScope(new ForEachGestureKt$awaitEachGesture$2(continuation.getContext(), function2, null, (byte) 0), continuation);
        return objAwaitPointerEventScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cf A[LOOP:0: B:26:0x00ba->B:30:0x00cf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d8 A[EDGE_INSN: B:68:0x00d8->B:32:0x00d8 BREAK  A[LOOP:0: B:26:0x00ba->B:30:0x00cf], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x016c -> B:62:0x0172). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final java.lang.Object m85awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r18, long r19, int r21, androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0 r22, kotlin.coroutines.jvm.internal.BaseContinuationImpl r23) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m85awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, long, int, androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cd A[LOOP:0: B:26:0x00b8->B:30:0x00cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d6 A[EDGE_INSN: B:68:0x00d6->B:32:0x00d6 BREAK  A[LOOP:0: B:26:0x00b8->B:30:0x00cd], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x016a -> B:62:0x0170). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final java.lang.Object m86awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r18, long r19, androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda11 r21, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m86awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, long, androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda11, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX INFO: renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    public static final Object m87awaitLongPressOrCancellationrnUCldI(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, long j, BaseContinuationImpl baseContinuationImpl) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        Object obj;
        PointerInputChange pointerInputChange;
        Ref$BooleanRef ref$BooleanRef;
        if (baseContinuationImpl instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) baseContinuationImpl;
            int i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(baseContinuationImpl);
            }
        } else {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(baseContinuationImpl);
        }
        Object obj2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        int i2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                if (!m93isPointerUpDmW0f2w(SuspendingPointerInputModifierNodeImpl.this.currentEvent, j)) {
                    List list = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                    int size = list.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            obj = null;
                            break;
                        }
                        obj = list.get(i3);
                        if (PointerId.m590equalsimpl0(((PointerInputChange) obj).id, j)) {
                            break;
                        }
                        i3++;
                    }
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange != null) {
                        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                        ref$ObjectRef2.element = pointerInputChange;
                        long longPressTimeoutMillis = pointerEventHandlerCoroutine.getViewConfiguration().getLongPressTimeoutMillis();
                        Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                        Function2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(ref$BooleanRef2, ref$ObjectRef2, ref$ObjectRef, null);
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = pointerInputChange;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = ref$ObjectRef;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$2 = ref$BooleanRef2;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                        Object objWithTimeout = pointerEventHandlerCoroutine.withTimeout(longPressTimeoutMillis, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1);
                        Object obj3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objWithTimeout == obj3) {
                            return obj3;
                        }
                        ref$BooleanRef = ref$BooleanRef2;
                        j = ref$ObjectRef;
                    }
                }
                return null;
            }
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$BooleanRef = dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$2;
            Ref$ObjectRef ref$ObjectRef3 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
            pointerInputChange = dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj2);
            j = ref$ObjectRef3;
            if (ref$BooleanRef.element) {
                PointerInputChange pointerInputChange2 = (PointerInputChange) j.element;
                return pointerInputChange2 == null ? pointerInputChange : pointerInputChange2;
            }
            return null;
        } catch (PointerEventTimeoutCancellationException unused) {
            PointerInputChange pointerInputChange3 = (PointerInputChange) j.element;
            return pointerInputChange3 == null ? pointerInputChange : pointerInputChange3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cb A[LOOP:0: B:26:0x00b6->B:30:0x00cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d4 A[EDGE_INSN: B:68:0x00d4->B:32:0x00d4 BREAK  A[LOOP:0: B:26:0x00b6->B:30:0x00cb], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x015f -> B:62:0x0165). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final java.lang.Object m88awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r18, long r19, androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0 r21, kotlin.coroutines.jvm.internal.BaseContinuationImpl r22) {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m88awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, long, androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cf A[LOOP:0: B:26:0x00ba->B:30:0x00cf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d8 A[EDGE_INSN: B:68:0x00d8->B:32:0x00d8 BREAK  A[LOOP:0: B:26:0x00ba->B:30:0x00cf], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x016f -> B:62:0x0175). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final java.lang.Object m89awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r18, long r19, int r21, androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0 r22, kotlin.coroutines.jvm.internal.BaseContinuationImpl r23) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m89awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, long, int, androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b A[LOOP:0: B:23:0x0067->B:27:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x007f A[EDGE_INSN: B:54:0x007f->B:29:0x007f BREAK  A[LOOP:0: B:23:0x0067->B:27:0x007b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005a -> B:22:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: defaultAwaitDragOrCancellationImpl-rnUCldI, reason: not valid java name */
    public static final java.lang.Object m90defaultAwaitDragOrCancellationImplrnUCldI(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r12, long r13, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$defaultAwaitDragOrCancellationImpl$1
            if (r0 == 0) goto L13
            r0 = r15
            androidx.compose.foundation.gestures.DragGestureDetectorKt$defaultAwaitDragOrCancellationImpl$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$defaultAwaitDragOrCancellationImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$defaultAwaitDragOrCancellationImpl$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$defaultAwaitDragOrCancellationImpl$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.Ref$LongRef r12 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r13 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r15)
            r11 = r13
            r13 = r12
            r12 = r11
            goto L5d
        L2d:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r12)
            return r3
        L33:
            kotlin.ResultKt.throwOnFailure(r15)
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r15 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
            androidx.compose.ui.input.pointer.PointerEvent r15 = r15.currentEvent
            boolean r15 = m93isPointerUpDmW0f2w(r15, r13)
            if (r15 == 0) goto L42
            goto Lc2
        L42:
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r13
        L49:
            r0.L$0 = r12
            r0.L$1 = r15
            r0.label = r2
            androidx.compose.ui.input.pointer.PointerEventPass r13 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            java.lang.Object r13 = r12.awaitPointerEvent(r13, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r14 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r13 != r14) goto L5a
            return r14
        L5a:
            r11 = r15
            r15 = r13
            r13 = r11
        L5d:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
            java.util.List r14 = r15.changes
            int r1 = r14.size()
            r4 = 0
            r5 = r4
        L67:
            if (r5 >= r1) goto L7e
            java.lang.Object r6 = r14.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r7 = r7.id
            long r9 = r13.element
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m590equalsimpl0(r7, r9)
            if (r7 == 0) goto L7b
            goto L7f
        L7b:
            int r5 = r5 + 1
            goto L67
        L7e:
            r6 = r3
        L7f:
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L85
            r6 = r3
            goto Lb9
        L85:
            boolean r14 = androidx.compose.ui.input.pointer.PointerIconKt.changedToUpIgnoreConsumed(r6)
            if (r14 == 0) goto Lad
            java.util.List r14 = r15.changes
            int r15 = r14.size()
        L91:
            if (r4 >= r15) goto La2
            java.lang.Object r1 = r14.get(r4)
            r5 = r1
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r5 = r5.pressed
            if (r5 == 0) goto L9f
            goto La3
        L9f:
            int r4 = r4 + 1
            goto L91
        La2:
            r1 = r3
        La3:
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto La8
            goto Lb9
        La8:
            long r14 = r1.id
            r13.element = r14
            goto Lc3
        Lad:
            long r14 = androidx.compose.ui.input.pointer.PointerIconKt.positionChangeInternal(r6, r2)
            r4 = 0
            boolean r14 = androidx.compose.ui.geometry.Offset.m434equalsimpl0(r14, r4)
            if (r14 != 0) goto Lc3
        Lb9:
            if (r6 == 0) goto Lc2
            boolean r12 = r6.isConsumed()
            if (r12 != 0) goto Lc2
            return r6
        Lc2:
            return r3
        Lc3:
            r15 = r13
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m90defaultAwaitDragOrCancellationImplrnUCldI(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function2, Function2 function3, Continuation continuation) {
        Object objAwaitEachGesture = awaitEachGesture(pointerInputScope, new TapGestureDetectorKt$detectTapAndPress$2$1(new ScrollKt$$ExternalSyntheticLambda0((byte) 7), new CancellableContinuationImpl$$ExternalSyntheticLambda0(function1, (byte) 1), function3, function2, new AppBarKt$$ExternalSyntheticLambda8(function0, (byte) 1), (Continuation) null), continuation);
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objAwaitEachGesture != coroutineSingletons) {
            objAwaitEachGesture = unit;
        }
        return objAwaitEachGesture == coroutineSingletons ? objAwaitEachGesture : unit;
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function2, Function2 function3, Continuation continuation) {
        Object objAwaitEachGesture = awaitEachGesture(pointerInputScope, new TapGestureDetectorKt$detectTapAndPress$2$1((Object) function1, (Function) function3, (Function) function0, (Object) function2, (Continuation) null, (byte) 2), continuation);
        return objAwaitEachGesture == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: drag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m91dragjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r4, long r5, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.jvm.internal.BaseContinuationImpl r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2b
            kotlin.jvm.functions.Function1 r4 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            r7 = r4
            r4 = r5
            goto L44
        L2b:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r4)
            r4 = 0
            return r4
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
        L35:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r2
            java.lang.Object r8 = m90defaultAwaitDragOrCancellationImplrnUCldI(r4, r5, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r5) goto L44
            return r5
        L44:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L4b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L4b:
            boolean r5 = androidx.compose.ui.input.pointer.PointerIconKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L54
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L54:
            r7.invoke(r8)
            long r5 = r8.id
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m91dragjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, long, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0087  */
    /* JADX WARN: Code duplicated, block: B:28:0x0099 A[LOOP:0: B:24:0x0085->B:28:0x0099, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x009e A[EDGE_INSN: B:72:0x009e->B:30:0x009e BREAK  A[LOOP:0: B:24:0x0085->B:28:0x0099], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0077 -> B:23:0x007c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m92horizontalDragjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r17, long r18, kotlin.jvm.functions.Function1 r20, kotlin.coroutines.jvm.internal.BaseContinuationImpl r21) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m92horizontalDragjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, long, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m93isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        Object obj;
        List list = pointerEvent.changes;
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list.get(i);
            if (PointerId.m590equalsimpl0(((PointerInputChange) obj).id, j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null && pointerInputChange.pressed) {
            z = true;
        }
        return true ^ z;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m94pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return i == 2 ? viewConfiguration.getTouchSlop() * 0.0069444445f : viewConfiguration.getTouchSlop();
    }

    /* JADX INFO: renamed from: positionChangeInternal-wfG_k4k, reason: not valid java name */
    public static final long m95positionChangeInternalwfG_k4k(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, boolean z) {
        float fIntBitsToFloat;
        long jFloatToRawIntBits;
        long j;
        long j2 = indirectPointerInputChange.previousPosition;
        if (orientation != null) {
            int i = indirectPointerEventPrimaryDirectionalMotionAxis.value;
            if (i == 1) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            } else if (i == 2) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (j2 & 4294967295L));
            }
            if (orientation == Orientation.Horizontal) {
                long jFloatToRawIntBits2 = Float.floatToRawIntBits(fIntBitsToFloat);
                jFloatToRawIntBits = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                j = jFloatToRawIntBits2 << 32;
            } else {
                long jFloatToRawIntBits3 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat);
                j = jFloatToRawIntBits3 << 32;
            }
            j2 = j | (jFloatToRawIntBits & 4294967295L);
        }
        long jM438minusMKHz9U = Offset.m438minusMKHz9U(m96primaryAxisPosition_bfSUIo(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis), j2);
        if (z || !indirectPointerInputChange.isConsumed) {
            return jM438minusMKHz9U;
        }
        return 0L;
    }

    /* JADX INFO: renamed from: primaryAxisPosition-_bfSUIo, reason: not valid java name */
    public static final long m96primaryAxisPosition_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        float fIntBitsToFloat;
        long jFloatToRawIntBits;
        long j;
        if (orientation == null) {
            return indirectPointerInputChange.position;
        }
        int i = indirectPointerEventPrimaryDirectionalMotionAxis.value;
        if (i == 1) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.position >> 32));
        } else {
            if (i != 2) {
                return indirectPointerInputChange.position;
            }
            fIntBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.position & 4294967295L));
        }
        if (orientation == Orientation.Horizontal) {
            long jFloatToRawIntBits2 = Float.floatToRawIntBits(fIntBitsToFloat);
            jFloatToRawIntBits = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
            j = jFloatToRawIntBits2 << 32;
        } else {
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
            jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat);
            j = jFloatToRawIntBits3 << 32;
        }
        return j | (4294967295L & jFloatToRawIntBits);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x0453 -> B:92:0x0401). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x0491 -> B:165:0x0600). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x05ea -> B:162:0x05f1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:168:0x061a -> B:86:0x03da). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:178:0x0688 -> B:179:0x0691). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x024c -> B:32:0x0250). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x02ef -> B:32:0x0250). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0347 -> B:78:0x03b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x03a1 -> B:75:0x03a8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 18961. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static final java.lang.Object processDragGesture(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r28, androidx.compose.ui.input.pointer.PointerInputChange r29, androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0 r30, kotlinx.coroutines.CancellableContinuationImpl$$ExternalSyntheticLambda0 r31, kotlin.jvm.functions.Function2 r32, kotlin.jvm.functions.Function0 r33, androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8 r34, kotlin.coroutines.jvm.internal.BaseContinuationImpl r35) {
        /*
            Method dump skipped, instruction units count: 1896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.processDragGesture(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0, kotlinx.coroutines.CancellableContinuationImpl$$ExternalSyntheticLambda0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object restartable(Function0 function0, Function2 function2, ContinuationImpl continuationImpl) {
        AnchoredDraggableKt$restartable$1 anchoredDraggableKt$restartable$1;
        if (continuationImpl instanceof AnchoredDraggableKt$restartable$1) {
            anchoredDraggableKt$restartable$1 = (AnchoredDraggableKt$restartable$1) continuationImpl;
            int i = anchoredDraggableKt$restartable$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anchoredDraggableKt$restartable$1.label = i - Integer.MIN_VALUE;
            } else {
                anchoredDraggableKt$restartable$1 = new AnchoredDraggableKt$restartable$1(continuationImpl);
            }
        } else {
            anchoredDraggableKt$restartable$1 = new AnchoredDraggableKt$restartable$1(continuationImpl);
        }
        Object obj = anchoredDraggableKt$restartable$1.result;
        int i2 = anchoredDraggableKt$restartable$1.label;
        Continuation continuation = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                RealImageLoader.AnonymousClass2 anonymousClass2 = new RealImageLoader.AnonymousClass2(function0, function2, continuation, (byte) 7);
                anchoredDraggableKt$restartable$1.label = 1;
                Object objCoroutineScope = AwaitKt.coroutineScope(anonymousClass2, anchoredDraggableKt$restartable$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCoroutineScope == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (AnchoredDragFinishedSignal unused) {
        }
        return Unit.INSTANCE;
    }

    public static Modifier scrollable$default(TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 textFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1, Orientation orientation, boolean z, boolean z2, MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        return new ScrollableElement(textFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1, orientation, z, z2, mutableInteractionSourceImpl);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    public static final Object m97semanticsScrollByd4ec7I(ScrollingLogic scrollingLogic, long j, ContinuationImpl continuationImpl) {
        ScrollableKt$semanticsScrollBy$1 scrollableKt$semanticsScrollBy$1;
        Ref$FloatRef ref$FloatRef;
        ScrollingLogic scrollingLogic2;
        if (continuationImpl instanceof ScrollableKt$semanticsScrollBy$1) {
            scrollableKt$semanticsScrollBy$1 = (ScrollableKt$semanticsScrollBy$1) continuationImpl;
            int i = scrollableKt$semanticsScrollBy$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollableKt$semanticsScrollBy$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuationImpl);
            }
        } else {
            scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuationImpl);
        }
        Object obj = scrollableKt$semanticsScrollBy$1.result;
        int i2 = scrollableKt$semanticsScrollBy$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ref$FloatRef = new Ref$FloatRef();
            ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(scrollingLogic, j, ref$FloatRef, (Continuation) null);
            scrollableKt$semanticsScrollBy$1.L$0 = scrollingLogic;
            scrollableKt$semanticsScrollBy$1.L$1 = ref$FloatRef;
            scrollableKt$semanticsScrollBy$1.label = 1;
            Object objScroll = scrollingLogic.scroll(MutatePriority.Default, scrollableKt$semanticsScrollBy$2, scrollableKt$semanticsScrollBy$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objScroll == coroutineSingletons) {
                return coroutineSingletons;
            }
            scrollingLogic2 = scrollingLogic;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Ref$FloatRef ref$FloatRef2 = scrollableKt$semanticsScrollBy$1.L$1;
            ScrollingLogic scrollingLogic3 = scrollableKt$semanticsScrollBy$1.L$0;
            ResultKt.throwOnFailure(obj);
            ref$FloatRef = ref$FloatRef2;
            scrollingLogic2 = scrollingLogic3;
        }
        return new Offset(scrollingLogic2.m106toOffsettuRUvjQ(ref$FloatRef.element));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0088  */
    /* JADX WARN: Code duplicated, block: B:28:0x009c A[LOOP:0: B:24:0x0086->B:28:0x009c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x00a6 A[EDGE_INSN: B:72:0x00a6->B:30:0x00a6 BREAK  A[LOOP:0: B:24:0x0086->B:28:0x009c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0078 -> B:23:0x007d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: verticalDrag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m98verticalDragjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r17, long r18, kotlin.jvm.functions.Function1 r20, kotlin.coroutines.jvm.internal.BaseContinuationImpl r21) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m98verticalDragjO51t88(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, long, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }
}
