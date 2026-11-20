package androidx.compose.foundation.gestures;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.datastore.core.SimpleActor$offer$2;
import coil3.RealImageLoader$execute$result$1;
import coil3.compose.AsyncImagePainter;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TapGestureDetectorKt {
    public static final DraggableKt$NoOpOnDragStarted$1 NoPressGesture = new DraggableKt$NoOpOnDragStarted$1(3, null, 2);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends ContinuationImpl {
        public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
        public PointerEventPass L$1;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00221 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Function1 L$3;
        public Object L$4;
        public Object L$5;
        public Object L$6;
        public Object L$7;
        public Object L$8;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.processTapGesture(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00232 extends SuspendLambda implements Function2 {
        public final /* synthetic */ PointerInputChange $down;
        public final /* synthetic */ Function3 $onPress;
        public final /* synthetic */ PressGestureScopeImpl $pressScope;
        public final /* synthetic */ byte $r8$classId;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C00232(Function3 function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$onPress = function3;
            this.$pressScope = pressGestureScopeImpl;
            this.$down = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new C00232(this.$onPress, this.$pressScope, this.$down, continuation, (byte) 0);
                default:
                    return new C00232(this.$onPress, this.$pressScope, this.$down, continuation, (byte) 1);
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
            return ((C00232) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            PointerInputChange pointerInputChange = this.$down;
            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
            Function3 function3 = this.$onPress;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        Offset offset = new Offset(pointerInputChange.position);
                        this.label = true;
                        return function3.invoke(pressGestureScopeImpl, offset, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        Offset offset2 = new Offset(pointerInputChange.position);
                        this.label = true;
                        return function3.invoke(pressGestureScopeImpl, offset2, this) == coroutineSingletons ? coroutineSingletons : unit;
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ PressGestureScopeImpl $pressScope;
        public final /* synthetic */ byte $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
            switch (b) {
                case 0:
                    return new AnonymousClass3(pressGestureScopeImpl, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass3(pressGestureScopeImpl, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass3(pressGestureScopeImpl, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass3(pressGestureScopeImpl, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass3(pressGestureScopeImpl, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass3(pressGestureScopeImpl, continuation, (byte) 5);
                case 6:
                    return new AnonymousClass3(pressGestureScopeImpl, continuation, (byte) 6);
                default:
                    return new AnonymousClass3(pressGestureScopeImpl, continuation, (byte) 7);
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
                    ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 1:
                    ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 2:
                    ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 3:
                    ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 4:
                    ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 5:
                    ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 6:
                    ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl.release();
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl.cancel();
                    break;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl.release();
                    break;
                case 3:
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl.cancel();
                    break;
                case 4:
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl.release();
                    break;
                case 5:
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl.release();
                    break;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl.cancel();
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl.release();
                    break;
            }
            return unit;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00241 extends ContinuationImpl {
        public Ref$ObjectRef L$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForLongPress(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00252 extends ContinuationImpl {
        public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
        public PointerEventPass L$1;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0049 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0052  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0047 -> B:18:0x004a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r5, boolean r6, androidx.compose.ui.input.pointer.PointerEventPass r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2f
            boolean r5 = r0.Z$0
            androidx.compose.ui.input.pointer.PointerEventPass r6 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L4a
        L2f:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r5)
            r5 = 0
            return r5
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
        L39:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r2
            java.lang.Object r8 = r5.awaitPointerEvent(r7, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r1) goto L4a
            return r1
        L4a:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            boolean r1 = isChangedToDown$default(r8, r6)
            if (r1 == 0) goto L39
            java.util.List r5 = r8.changes
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, Continuation continuation, int i) {
        return awaitFirstDown(pointerEventHandlerCoroutine, (i & 1) != 0, (i & 2) != 0 ? PointerEventPass.Main : PointerEventPass.Initial, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x004c A[LOOP:0: B:19:0x004a->B:20:0x004c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x006b A[LOOP:1: B:22:0x005e->B:26:0x006b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0031 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003d -> B:18:0x0040). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L40
        L27:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            r7 = 0
            return r7
        L2e:
            kotlin.ResultKt.throwOnFailure(r8)
        L31:
            r0.L$0 = r7
            r0.label = r2
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            java.lang.Object r8 = r7.awaitPointerEvent(r8, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r1) goto L40
            return r1
        L40:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.util.List r1 = r8.changes
            int r3 = r1.size()
            r4 = 0
            r5 = r4
        L4a:
            if (r5 >= r3) goto L58
            java.lang.Object r6 = r1.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            r6.consume()
            int r5 = r5 + 1
            goto L4a
        L58:
            java.util.List r8 = r8.changes
            int r1 = r8.size()
        L5e:
            if (r4 >= r1) goto L6e
            java.lang.Object r3 = r8.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            boolean r3 = r3.pressed
            if (r3 == 0) goto L6b
            goto L31
        L6b:
            int r4 = r4 + 1
            goto L5e
        L6e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function3 function3, Function1 function2, Continuation continuation, int i) {
        Function1 function4 = (i & 1) != 0 ? null : function1;
        if ((i & 4) != 0) {
            function3 = NoPressGesture;
        }
        Object objCoroutineScope = AwaitKt.coroutineScope(new RealImageLoader$execute$result$1(pointerInputScope, function4, function3, (i & 8) != 0 ? null : function2, null, (byte) 2), continuation);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    public static boolean isChangedToDown$default(PointerEvent pointerEvent, boolean z) {
        List list = pointerEvent.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = (PointerInputChange) list.get(i);
            if (!(z ? PointerIconKt.changedToDown(pointerInputChange) : PointerIconKt.changedToDownIgnoreConsumed(pointerInputChange))) {
                return false;
            }
        }
        return true;
    }

    public static StandaloneCoroutine launchAwaitingReset$default(CoroutineScope coroutineScope, Job job, Function2 function2) {
        return AwaitKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AsyncImagePainter.AnonymousClass1(job, function2, null, (byte) 2), 1);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:102:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:104:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:106:0x03df  */
    /* JADX WARN: Code duplicated, block: B:109:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:26:0x018d  */
    /* JADX WARN: Code duplicated, block: B:27:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:29:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:32:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:34:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:37:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:40:0x0217  */
    /* JADX WARN: Code duplicated, block: B:43:0x023f  */
    /* JADX WARN: Code duplicated, block: B:46:0x024b  */
    /* JADX WARN: Code duplicated, block: B:48:0x024f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0254  */
    /* JADX WARN: Code duplicated, block: B:51:0x0258  */
    /* JADX WARN: Code duplicated, block: B:54:0x0263  */
    /* JADX WARN: Code duplicated, block: B:55:0x0273  */
    /* JADX WARN: Code duplicated, block: B:57:0x0287 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x0289 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x028b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0296  */
    /* JADX WARN: Code duplicated, block: B:64:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x02d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:70:0x02de  */
    /* JADX WARN: Code duplicated, block: B:72:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:73:0x0308  */
    /* JADX WARN: Code duplicated, block: B:75:0x030d  */
    /* JADX WARN: Code duplicated, block: B:78:0x032c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:80:0x0337  */
    /* JADX WARN: Code duplicated, block: B:83:0x0355  */
    /* JADX WARN: Code duplicated, block: B:86:0x0368  */
    /* JADX WARN: Code duplicated, block: B:89:0x038f  */
    /* JADX WARN: Code duplicated, block: B:92:0x039b  */
    /* JADX WARN: Code duplicated, block: B:94:0x039f  */
    /* JADX WARN: Code duplicated, block: B:96:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:98:0x03ae  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v20, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r25v1, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r5v26, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r5v30, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r9v2 */
    public static final Object processTapGesture(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, Function1 function1, Function3 function3, Function1 function2, BaseContinuationImpl baseContinuationImpl) {
        C00221 c00221;
        CoroutineScope coroutineScope2;
        PressGestureScopeImpl pressGestureScopeImpl2;
        Function1 function4;
        ?? r6;
        Function3 function5;
        Function1 function6;
        int i;
        Object objAwaitFirstDown$default;
        Function1 function7;
        PointerInputChange pointerInputChange;
        LongPressResult.Success success;
        StandaloneCoroutine standaloneCoroutineLaunch$default;
        Function3 function8;
        PressGestureScopeImpl pressGestureScopeImpl3;
        Object objWaitForLongPress;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2;
        Job job;
        PressGestureScopeImpl pressGestureScopeImpl4;
        CoroutineScope coroutineScope3;
        Function1 function9;
        Function1 function10;
        Function1 function11;
        Object objWaitForUpOrCancellation;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine3;
        CoroutineScope coroutineScope4;
        Function1 function12;
        PressGestureScopeImpl pressGestureScopeImpl5;
        Function1 function13;
        Function3 function14;
        Function1 function15;
        PointerInputChange pointerInputChange2;
        LongPressResult.Success success2;
        StandaloneCoroutine standaloneCoroutineLaunchAwaitingReset$default;
        Function3 function16;
        Function1 function17;
        StandaloneCoroutine standaloneCoroutine;
        Object objWithTimeoutOrNull;
        Function1 function18;
        CoroutineScope coroutineScope5;
        Function3 function19;
        Function1 function20;
        PointerInputChange pointerInputChange3;
        Job job2;
        LongPressResult longPressResult;
        Continuation continuation;
        CoroutineScope coroutineScope6;
        PressGestureScopeImpl pressGestureScopeImpl6;
        PointerInputChange pointerInputChange4;
        Continuation continuation2;
        StandaloneCoroutine standaloneCoroutineLaunch$default2;
        Function1 function21;
        Object objWaitForLongPress2;
        Job job3;
        PointerInputChange pointerInputChange5;
        Function1 function22;
        PointerInputChange pointerInputChange6;
        PressGestureScopeImpl pressGestureScopeImpl7;
        Function1 function23;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine4;
        Job job4;
        PointerInputChange pointerInputChange7;
        Function1 function24;
        CoroutineScope coroutineScope7;
        Function1 function25;
        Function1 function26;
        ?? r13;
        ?? r5;
        Function1 function27;
        LongPressResult longPressResult2;
        Object obj;
        Job job5;
        CoroutineScope coroutineScope8;
        ?? r7;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine;
        if (baseContinuationImpl instanceof C00221) {
            c00221 = (C00221) baseContinuationImpl;
            int i2 = c00221.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c00221.label = i2 - Integer.MIN_VALUE;
            } else {
                c00221 = new C00221(baseContinuationImpl);
            }
        } else {
            c00221 = new C00221(baseContinuationImpl);
        }
        Object objWaitForUpOrCancellation2 = c00221.result;
        int i3 = c00221.label;
        CoroutineStart coroutineStart = CoroutineStart.UNDISPATCHED;
        PointerEventPass pointerEventPass = PointerEventPass.Main;
        LongPressResult.Success success3 = LongPressResult.Success.INSTANCE;
        DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = NoPressGesture;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i3) {
            case 0:
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                c00221.L$0 = pointerEventHandlerCoroutine5;
                coroutineScope2 = coroutineScope;
                c00221.L$1 = coroutineScope2;
                pressGestureScopeImpl2 = pressGestureScopeImpl;
                c00221.L$2 = pressGestureScopeImpl2;
                function4 = function1;
                c00221.L$3 = function4;
                r6 = 0;
                c00221.L$4 = null;
                function5 = function3;
                c00221.L$5 = function5;
                function6 = function2;
                c00221.L$6 = function6;
                i = 1;
                c00221.label = 1;
                objAwaitFirstDown$default = awaitFirstDown$default(pointerEventHandlerCoroutine5, c00221, 3);
                if (objAwaitFirstDown$default != coroutineSingletons) {
                    function7 = null;
                    PointerInputChange pointerInputChange8 = (PointerInputChange) objAwaitFirstDown$default;
                    pointerInputChange8.consume();
                    pointerInputChange = pointerInputChange8;
                    success = success3;
                    standaloneCoroutineLaunch$default = AwaitKt.launch$default(coroutineScope2, r6, coroutineStart, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, r6, (byte) 0), i);
                    if (function5 != draggableKt$NoOpOnDragStarted$1) {
                        PressGestureScopeImpl pressGestureScopeImpl8 = pressGestureScopeImpl2;
                        ?? r25 = r6;
                        Function3 function28 = function5;
                        function8 = function28;
                        pressGestureScopeImpl3 = pressGestureScopeImpl8;
                        launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default, new C00232(function28, pressGestureScopeImpl8, pointerInputChange, r25, (byte) 0));
                    } else {
                        function8 = function5;
                        pressGestureScopeImpl3 = pressGestureScopeImpl2;
                    }
                    if (function7 == null) {
                        c00221.L$0 = pointerEventHandlerCoroutine5;
                        c00221.L$1 = coroutineScope2;
                        c00221.L$2 = pressGestureScopeImpl3;
                        c00221.L$3 = function4;
                        c00221.L$4 = function7;
                        c00221.L$5 = function8;
                        c00221.L$6 = function6;
                        c00221.L$7 = standaloneCoroutineLaunch$default;
                        c00221.label = 2;
                        objWaitForUpOrCancellation = waitForUpOrCancellation(pointerEventHandlerCoroutine5, pointerEventPass, c00221);
                        if (objWaitForUpOrCancellation != coroutineSingletons) {
                            pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine5;
                            job = standaloneCoroutineLaunch$default;
                            Function1 function29 = function7;
                            coroutineScope4 = coroutineScope2;
                            objWaitForUpOrCancellation2 = objWaitForUpOrCancellation;
                            function12 = function6;
                            pressGestureScopeImpl5 = pressGestureScopeImpl3;
                            function13 = function4;
                            function14 = function8;
                            function15 = function29;
                            pointerInputChange2 = (PointerInputChange) objWaitForUpOrCancellation2;
                            success2 = success;
                            if (pointerInputChange2 == null) {
                                standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 3));
                            } else {
                                pointerInputChange2.consume();
                                standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 4));
                            }
                            if (pointerInputChange2 != null) {
                                if (function13 == null) {
                                    c00221.L$0 = pointerEventHandlerCoroutine3;
                                    c00221.L$1 = coroutineScope4;
                                    c00221.L$2 = pressGestureScopeImpl5;
                                    c00221.L$3 = function13;
                                    c00221.L$4 = function15;
                                    c00221.L$5 = function14;
                                    c00221.L$6 = function12;
                                    c00221.L$7 = pointerInputChange2;
                                    c00221.L$8 = standaloneCoroutineLaunchAwaitingReset$default;
                                    c00221.label = 5;
                                    function16 = function14;
                                    function17 = function15;
                                    standaloneCoroutine = standaloneCoroutineLaunchAwaitingReset$default;
                                    objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange2, null), c00221);
                                    if (objWithTimeoutOrNull != coroutineSingletons) {
                                        function18 = function13;
                                        coroutineScope5 = coroutineScope4;
                                        function19 = function16;
                                        function20 = function12;
                                        pointerInputChange3 = pointerInputChange2;
                                        objWaitForUpOrCancellation2 = objWithTimeoutOrNull;
                                        job2 = standaloneCoroutine;
                                        pointerInputChange4 = (PointerInputChange) objWaitForUpOrCancellation2;
                                        if (pointerInputChange4 != null) {
                                            continuation2 = null;
                                            standaloneCoroutineLaunch$default2 = AwaitKt.launch$default(coroutineScope5, null, coroutineStart, new SimpleActor$offer$2(job2, pressGestureScopeImpl5, continuation2, (byte) 4), 1);
                                            if (function19 != draggableKt$NoOpOnDragStarted$1) {
                                                function21 = null;
                                                launchAwaitingReset$default(coroutineScope5, standaloneCoroutineLaunch$default2, new C00232(function19, pressGestureScopeImpl5, pointerInputChange4, continuation2, (byte) 1));
                                            } else {
                                                function21 = null;
                                            }
                                            if (function17 == null) {
                                                c00221.L$0 = coroutineScope5;
                                                c00221.L$1 = pressGestureScopeImpl5;
                                                c00221.L$2 = function18;
                                                c00221.L$3 = function20;
                                                c00221.L$4 = standaloneCoroutineLaunch$default2;
                                                c00221.L$5 = pointerInputChange3;
                                                c00221.L$6 = function21;
                                                c00221.L$7 = function21;
                                                c00221.L$8 = function21;
                                                c00221.label = 6;
                                                objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                                if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                                    PointerInputChange pointerInputChange9 = pointerInputChange3;
                                                    job4 = standaloneCoroutineLaunch$default2;
                                                    pointerInputChange7 = pointerInputChange9;
                                                    function24 = function20;
                                                    coroutineScope7 = coroutineScope5;
                                                    function25 = function18;
                                                    function26 = function21;
                                                    r5 = function26;
                                                    r13 = (PointerInputChange) objWaitForUpOrCancellation2;
                                                    if (r13 != 0) {
                                                        r13.consume();
                                                        launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                        function25.invoke(new Offset(r13.position));
                                                        return unit;
                                                    }
                                                    launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                    if (function24 != null) {
                                                        function24.invoke(new Offset(pointerInputChange7.position));
                                                        return unit;
                                                    }
                                                }
                                            } else {
                                                c00221.L$0 = pointerEventHandlerCoroutine3;
                                                c00221.L$1 = coroutineScope5;
                                                c00221.L$2 = pressGestureScopeImpl5;
                                                c00221.L$3 = function18;
                                                c00221.L$4 = function17;
                                                c00221.L$5 = function20;
                                                c00221.L$6 = standaloneCoroutineLaunch$default2;
                                                c00221.L$7 = pointerInputChange3;
                                                c00221.L$8 = r24;
                                                c00221.label = 7;
                                                objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                                if (objWaitForLongPress2 != coroutineSingletons) {
                                                    Function1 function30 = function20;
                                                    job3 = standaloneCoroutineLaunch$default2;
                                                    pointerInputChange5 = pointerInputChange4;
                                                    objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                                    function22 = function18;
                                                    pointerInputChange6 = pointerInputChange3;
                                                    pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                    function23 = function30;
                                                    pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                                    function27 = function21;
                                                    longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                                    if (Intrinsics.areEqual(longPressResult2, success2)) {
                                                        function17.invoke(new Offset(pointerInputChange5.position));
                                                        c00221.L$0 = coroutineScope5;
                                                        c00221.L$1 = pressGestureScopeImpl7;
                                                        c00221.L$2 = job3;
                                                        c00221.L$3 = function27;
                                                        c00221.L$4 = function27;
                                                        c00221.L$5 = function27;
                                                        c00221.L$6 = function27;
                                                        c00221.L$7 = function27;
                                                        c00221.L$8 = function27;
                                                        c00221.label = 8;
                                                        if (consumeUntilUp(pointerEventHandlerCoroutine4, c00221) != coroutineSingletons) {
                                                            job5 = job3;
                                                            coroutineScope8 = coroutineScope5;
                                                            r7 = function27;
                                                            launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                                                            return unit;
                                                        }
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                                            obj = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                return null;
                                                            }
                                                            obj = function27;
                                                        }
                                                        pointerInputChange7 = pointerInputChange6;
                                                        function24 = function23;
                                                        coroutineScope7 = coroutineScope5;
                                                        pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                        job4 = job3;
                                                        function25 = function22;
                                                        r5 = function27;
                                                        r13 = obj;
                                                        if (r13 != 0) {
                                                            r13.consume();
                                                            launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                            function25.invoke(new Offset(r13.position));
                                                            return unit;
                                                        }
                                                        launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                        if (function24 != null) {
                                                            function24.invoke(new Offset(pointerInputChange7.position));
                                                            return unit;
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (function20 != null) {
                                            function20.invoke(new Offset(pointerInputChange3.position));
                                            return unit;
                                        }
                                    }
                                } else if (function12 != null) {
                                    function12.invoke(new Offset(pointerInputChange2.position));
                                    return unit;
                                }
                            }
                            return unit;
                        }
                    } else {
                        c00221.L$0 = pointerEventHandlerCoroutine5;
                        c00221.L$1 = coroutineScope2;
                        c00221.L$2 = pressGestureScopeImpl3;
                        c00221.L$3 = function4;
                        c00221.L$4 = function7;
                        c00221.L$5 = function8;
                        c00221.L$6 = function6;
                        c00221.L$7 = pointerInputChange;
                        c00221.L$8 = standaloneCoroutineLaunch$default;
                        c00221.label = 3;
                        objWaitForLongPress = waitForLongPress(pointerEventHandlerCoroutine5, pointerEventPass, c00221);
                        if (objWaitForLongPress != coroutineSingletons) {
                            pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine5;
                            job = standaloneCoroutineLaunch$default;
                            pressGestureScopeImpl4 = pressGestureScopeImpl3;
                            coroutineScope3 = coroutineScope2;
                            objWaitForUpOrCancellation2 = objWaitForLongPress;
                            Function1 function31 = function7;
                            function9 = function4;
                            function10 = function6;
                            function11 = function31;
                            longPressResult = (LongPressResult) objWaitForUpOrCancellation2;
                            success2 = success;
                            if (!Intrinsics.areEqual(longPressResult, success2)) {
                                if (longPressResult instanceof LongPressResult.Released) {
                                    pointerInputChange2 = ((LongPressResult.Released) longPressResult).finalUpChange;
                                } else {
                                    if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                        return null;
                                    }
                                    pointerInputChange2 = null;
                                }
                                Function1 function32 = function9;
                                coroutineScope4 = coroutineScope3;
                                function13 = function32;
                                function12 = function10;
                                function14 = function8;
                                function15 = function11;
                                pressGestureScopeImpl5 = pressGestureScopeImpl4;
                                pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                                if (pointerInputChange2 == null) {
                                    standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 3));
                                } else {
                                    pointerInputChange2.consume();
                                    standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 4));
                                }
                                if (pointerInputChange2 != null) {
                                    if (function13 == null) {
                                        c00221.L$0 = pointerEventHandlerCoroutine3;
                                        c00221.L$1 = coroutineScope4;
                                        c00221.L$2 = pressGestureScopeImpl5;
                                        c00221.L$3 = function13;
                                        c00221.L$4 = function15;
                                        c00221.L$5 = function14;
                                        c00221.L$6 = function12;
                                        c00221.L$7 = pointerInputChange2;
                                        c00221.L$8 = standaloneCoroutineLaunchAwaitingReset$default;
                                        c00221.label = 5;
                                        function16 = function14;
                                        function17 = function15;
                                        standaloneCoroutine = standaloneCoroutineLaunchAwaitingReset$default;
                                        objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange2, null), c00221);
                                        if (objWithTimeoutOrNull != coroutineSingletons) {
                                            function18 = function13;
                                            coroutineScope5 = coroutineScope4;
                                            function19 = function16;
                                            function20 = function12;
                                            pointerInputChange3 = pointerInputChange2;
                                            objWaitForUpOrCancellation2 = objWithTimeoutOrNull;
                                            job2 = standaloneCoroutine;
                                            pointerInputChange4 = (PointerInputChange) objWaitForUpOrCancellation2;
                                            if (pointerInputChange4 != null) {
                                                continuation2 = null;
                                                standaloneCoroutineLaunch$default2 = AwaitKt.launch$default(coroutineScope5, null, coroutineStart, new SimpleActor$offer$2(job2, pressGestureScopeImpl5, continuation2, (byte) 4), 1);
                                                if (function19 != draggableKt$NoOpOnDragStarted$1) {
                                                    function21 = null;
                                                    launchAwaitingReset$default(coroutineScope5, standaloneCoroutineLaunch$default2, new C00232(function19, pressGestureScopeImpl5, pointerInputChange4, continuation2, (byte) 1));
                                                } else {
                                                    function21 = null;
                                                }
                                                if (function17 == null) {
                                                    c00221.L$0 = coroutineScope5;
                                                    c00221.L$1 = pressGestureScopeImpl5;
                                                    c00221.L$2 = function18;
                                                    c00221.L$3 = function20;
                                                    c00221.L$4 = standaloneCoroutineLaunch$default2;
                                                    c00221.L$5 = pointerInputChange3;
                                                    c00221.L$6 = function21;
                                                    c00221.L$7 = function21;
                                                    c00221.L$8 = function21;
                                                    c00221.label = 6;
                                                    objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                                    if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                                        PointerInputChange pointerInputChange10 = pointerInputChange3;
                                                        job4 = standaloneCoroutineLaunch$default2;
                                                        pointerInputChange7 = pointerInputChange10;
                                                        function24 = function20;
                                                        coroutineScope7 = coroutineScope5;
                                                        function25 = function18;
                                                        function26 = function21;
                                                        r5 = function26;
                                                        r13 = (PointerInputChange) objWaitForUpOrCancellation2;
                                                        if (r13 != 0) {
                                                            r13.consume();
                                                            launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                            function25.invoke(new Offset(r13.position));
                                                            return unit;
                                                        }
                                                        launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                        if (function24 != null) {
                                                            function24.invoke(new Offset(pointerInputChange7.position));
                                                            return unit;
                                                        }
                                                    }
                                                } else {
                                                    c00221.L$0 = pointerEventHandlerCoroutine3;
                                                    c00221.L$1 = coroutineScope5;
                                                    c00221.L$2 = pressGestureScopeImpl5;
                                                    c00221.L$3 = function18;
                                                    c00221.L$4 = function17;
                                                    c00221.L$5 = function20;
                                                    c00221.L$6 = standaloneCoroutineLaunch$default2;
                                                    c00221.L$7 = pointerInputChange3;
                                                    c00221.L$8 = r24;
                                                    c00221.label = 7;
                                                    objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                                    if (objWaitForLongPress2 != coroutineSingletons) {
                                                        Function1 function33 = function20;
                                                        job3 = standaloneCoroutineLaunch$default2;
                                                        pointerInputChange5 = pointerInputChange4;
                                                        objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                                        function22 = function18;
                                                        pointerInputChange6 = pointerInputChange3;
                                                        pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                        function23 = function33;
                                                        pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                                        function27 = function21;
                                                        longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                                        if (Intrinsics.areEqual(longPressResult2, success2)) {
                                                            function17.invoke(new Offset(pointerInputChange5.position));
                                                            c00221.L$0 = coroutineScope5;
                                                            c00221.L$1 = pressGestureScopeImpl7;
                                                            c00221.L$2 = job3;
                                                            c00221.L$3 = function27;
                                                            c00221.L$4 = function27;
                                                            c00221.L$5 = function27;
                                                            c00221.L$6 = function27;
                                                            c00221.L$7 = function27;
                                                            c00221.L$8 = function27;
                                                            c00221.label = 8;
                                                            if (consumeUntilUp(pointerEventHandlerCoroutine4, c00221) != coroutineSingletons) {
                                                                job5 = job3;
                                                                coroutineScope8 = coroutineScope5;
                                                                r7 = function27;
                                                                launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                                                                return unit;
                                                            }
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Released) {
                                                                obj = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                            } else {
                                                                if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                    return null;
                                                                }
                                                                obj = function27;
                                                            }
                                                            pointerInputChange7 = pointerInputChange6;
                                                            function24 = function23;
                                                            coroutineScope7 = coroutineScope5;
                                                            pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                            job4 = job3;
                                                            function25 = function22;
                                                            r5 = function27;
                                                            r13 = obj;
                                                            if (r13 != 0) {
                                                                r13.consume();
                                                                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                                function25.invoke(new Offset(r13.position));
                                                                return unit;
                                                            }
                                                            launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                            if (function24 != null) {
                                                                function24.invoke(new Offset(pointerInputChange7.position));
                                                                return unit;
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (function20 != null) {
                                                function20.invoke(new Offset(pointerInputChange3.position));
                                                return unit;
                                            }
                                        }
                                    } else if (function12 != null) {
                                        function12.invoke(new Offset(pointerInputChange2.position));
                                        return unit;
                                    }
                                }
                                return unit;
                            }
                            function11.invoke(new Offset(pointerInputChange.position));
                            c00221.L$0 = coroutineScope3;
                            c00221.L$1 = pressGestureScopeImpl4;
                            c00221.L$2 = job;
                            continuation = null;
                            c00221.L$3 = null;
                            c00221.L$4 = null;
                            c00221.L$5 = null;
                            c00221.L$6 = null;
                            c00221.L$7 = null;
                            c00221.L$8 = null;
                            c00221.label = 4;
                            if (consumeUntilUp(pointerEventHandlerCoroutine2, c00221) != coroutineSingletons) {
                                coroutineScope6 = coroutineScope3;
                                pressGestureScopeImpl6 = pressGestureScopeImpl4;
                                launchAwaitingReset$default(coroutineScope6, job, new AnonymousClass3(pressGestureScopeImpl6, continuation, (byte) 0));
                                return unit;
                            }
                        }
                    }
                }
                return coroutineSingletons;
            case 1:
                Function1 function34 = (Function1) c00221.L$6;
                Function3 function35 = (Function3) c00221.L$5;
                Function1 function36 = (Function1) c00221.L$4;
                Function1 function37 = c00221.L$3;
                PressGestureScopeImpl pressGestureScopeImpl9 = (PressGestureScopeImpl) c00221.L$2;
                CoroutineScope coroutineScope9 = (CoroutineScope) c00221.L$1;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine6 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00221.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                function5 = function35;
                pressGestureScopeImpl2 = pressGestureScopeImpl9;
                objAwaitFirstDown$default = objWaitForUpOrCancellation2;
                function7 = function36;
                function4 = function37;
                coroutineScope2 = coroutineScope9;
                r6 = 0;
                function6 = function34;
                pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine6;
                i = 1;
                PointerInputChange pointerInputChange11 = (PointerInputChange) objAwaitFirstDown$default;
                pointerInputChange11.consume();
                pointerInputChange = pointerInputChange11;
                success = success3;
                standaloneCoroutineLaunch$default = AwaitKt.launch$default(coroutineScope2, r6, coroutineStart, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, r6, (byte) 0), i);
                if (function5 != draggableKt$NoOpOnDragStarted$1) {
                    PressGestureScopeImpl pressGestureScopeImpl10 = pressGestureScopeImpl2;
                    ?? r26 = r6;
                    Function3 function210 = function5;
                    function8 = function210;
                    pressGestureScopeImpl3 = pressGestureScopeImpl10;
                    launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default, new C00232(function210, pressGestureScopeImpl10, pointerInputChange, r26, (byte) 0));
                } else {
                    function8 = function5;
                    pressGestureScopeImpl3 = pressGestureScopeImpl2;
                }
                if (function7 == null) {
                    c00221.L$0 = pointerEventHandlerCoroutine5;
                    c00221.L$1 = coroutineScope2;
                    c00221.L$2 = pressGestureScopeImpl3;
                    c00221.L$3 = function4;
                    c00221.L$4 = function7;
                    c00221.L$5 = function8;
                    c00221.L$6 = function6;
                    c00221.L$7 = standaloneCoroutineLaunch$default;
                    c00221.label = 2;
                    objWaitForUpOrCancellation = waitForUpOrCancellation(pointerEventHandlerCoroutine5, pointerEventPass, c00221);
                    if (objWaitForUpOrCancellation != coroutineSingletons) {
                        pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine5;
                        job = standaloneCoroutineLaunch$default;
                        Function1 function211 = function7;
                        coroutineScope4 = coroutineScope2;
                        objWaitForUpOrCancellation2 = objWaitForUpOrCancellation;
                        function12 = function6;
                        pressGestureScopeImpl5 = pressGestureScopeImpl3;
                        function13 = function4;
                        function14 = function8;
                        function15 = function211;
                        pointerInputChange2 = (PointerInputChange) objWaitForUpOrCancellation2;
                        success2 = success;
                        if (pointerInputChange2 == null) {
                            standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 3));
                        } else {
                            pointerInputChange2.consume();
                            standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 4));
                        }
                        if (pointerInputChange2 != null) {
                            if (function13 == null) {
                                c00221.L$0 = pointerEventHandlerCoroutine3;
                                c00221.L$1 = coroutineScope4;
                                c00221.L$2 = pressGestureScopeImpl5;
                                c00221.L$3 = function13;
                                c00221.L$4 = function15;
                                c00221.L$5 = function14;
                                c00221.L$6 = function12;
                                c00221.L$7 = pointerInputChange2;
                                c00221.L$8 = standaloneCoroutineLaunchAwaitingReset$default;
                                c00221.label = 5;
                                function16 = function14;
                                function17 = function15;
                                standaloneCoroutine = standaloneCoroutineLaunchAwaitingReset$default;
                                objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange2, null), c00221);
                                if (objWithTimeoutOrNull != coroutineSingletons) {
                                    function18 = function13;
                                    coroutineScope5 = coroutineScope4;
                                    function19 = function16;
                                    function20 = function12;
                                    pointerInputChange3 = pointerInputChange2;
                                    objWaitForUpOrCancellation2 = objWithTimeoutOrNull;
                                    job2 = standaloneCoroutine;
                                    pointerInputChange4 = (PointerInputChange) objWaitForUpOrCancellation2;
                                    if (pointerInputChange4 != null) {
                                        continuation2 = null;
                                        standaloneCoroutineLaunch$default2 = AwaitKt.launch$default(coroutineScope5, null, coroutineStart, new SimpleActor$offer$2(job2, pressGestureScopeImpl5, continuation2, (byte) 4), 1);
                                        if (function19 != draggableKt$NoOpOnDragStarted$1) {
                                            function21 = null;
                                            launchAwaitingReset$default(coroutineScope5, standaloneCoroutineLaunch$default2, new C00232(function19, pressGestureScopeImpl5, pointerInputChange4, continuation2, (byte) 1));
                                        } else {
                                            function21 = null;
                                        }
                                        if (function17 == null) {
                                            c00221.L$0 = coroutineScope5;
                                            c00221.L$1 = pressGestureScopeImpl5;
                                            c00221.L$2 = function18;
                                            c00221.L$3 = function20;
                                            c00221.L$4 = standaloneCoroutineLaunch$default2;
                                            c00221.L$5 = pointerInputChange3;
                                            c00221.L$6 = function21;
                                            c00221.L$7 = function21;
                                            c00221.L$8 = function21;
                                            c00221.label = 6;
                                            objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                            if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                                PointerInputChange pointerInputChange12 = pointerInputChange3;
                                                job4 = standaloneCoroutineLaunch$default2;
                                                pointerInputChange7 = pointerInputChange12;
                                                function24 = function20;
                                                coroutineScope7 = coroutineScope5;
                                                function25 = function18;
                                                function26 = function21;
                                                r5 = function26;
                                                r13 = (PointerInputChange) objWaitForUpOrCancellation2;
                                                if (r13 != 0) {
                                                    r13.consume();
                                                    launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                    function25.invoke(new Offset(r13.position));
                                                    return unit;
                                                }
                                                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                if (function24 != null) {
                                                    function24.invoke(new Offset(pointerInputChange7.position));
                                                    return unit;
                                                }
                                            }
                                        } else {
                                            c00221.L$0 = pointerEventHandlerCoroutine3;
                                            c00221.L$1 = coroutineScope5;
                                            c00221.L$2 = pressGestureScopeImpl5;
                                            c00221.L$3 = function18;
                                            c00221.L$4 = function17;
                                            c00221.L$5 = function20;
                                            c00221.L$6 = standaloneCoroutineLaunch$default2;
                                            c00221.L$7 = pointerInputChange3;
                                            c00221.L$8 = r24;
                                            c00221.label = 7;
                                            objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                            if (objWaitForLongPress2 != coroutineSingletons) {
                                                Function1 function38 = function20;
                                                job3 = standaloneCoroutineLaunch$default2;
                                                pointerInputChange5 = pointerInputChange4;
                                                objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                                function22 = function18;
                                                pointerInputChange6 = pointerInputChange3;
                                                pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                function23 = function38;
                                                pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                                function27 = function21;
                                                longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                                if (Intrinsics.areEqual(longPressResult2, success2)) {
                                                    function17.invoke(new Offset(pointerInputChange5.position));
                                                    c00221.L$0 = coroutineScope5;
                                                    c00221.L$1 = pressGestureScopeImpl7;
                                                    c00221.L$2 = job3;
                                                    c00221.L$3 = function27;
                                                    c00221.L$4 = function27;
                                                    c00221.L$5 = function27;
                                                    c00221.L$6 = function27;
                                                    c00221.L$7 = function27;
                                                    c00221.L$8 = function27;
                                                    c00221.label = 8;
                                                    if (consumeUntilUp(pointerEventHandlerCoroutine4, c00221) != coroutineSingletons) {
                                                        job5 = job3;
                                                        coroutineScope8 = coroutineScope5;
                                                        r7 = function27;
                                                        launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                                                        return unit;
                                                    }
                                                } else {
                                                    if (longPressResult2 instanceof LongPressResult.Released) {
                                                        obj = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                            return null;
                                                        }
                                                        obj = function27;
                                                    }
                                                    pointerInputChange7 = pointerInputChange6;
                                                    function24 = function23;
                                                    coroutineScope7 = coroutineScope5;
                                                    pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                    job4 = job3;
                                                    function25 = function22;
                                                    r5 = function27;
                                                    r13 = obj;
                                                    if (r13 != 0) {
                                                        r13.consume();
                                                        launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                        function25.invoke(new Offset(r13.position));
                                                        return unit;
                                                    }
                                                    launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                    if (function24 != null) {
                                                        function24.invoke(new Offset(pointerInputChange7.position));
                                                        return unit;
                                                    }
                                                }
                                            }
                                        }
                                    } else if (function20 != null) {
                                        function20.invoke(new Offset(pointerInputChange3.position));
                                        return unit;
                                    }
                                }
                            } else if (function12 != null) {
                                function12.invoke(new Offset(pointerInputChange2.position));
                                return unit;
                            }
                        }
                        return unit;
                    }
                } else {
                    c00221.L$0 = pointerEventHandlerCoroutine5;
                    c00221.L$1 = coroutineScope2;
                    c00221.L$2 = pressGestureScopeImpl3;
                    c00221.L$3 = function4;
                    c00221.L$4 = function7;
                    c00221.L$5 = function8;
                    c00221.L$6 = function6;
                    c00221.L$7 = pointerInputChange;
                    c00221.L$8 = standaloneCoroutineLaunch$default;
                    c00221.label = 3;
                    objWaitForLongPress = waitForLongPress(pointerEventHandlerCoroutine5, pointerEventPass, c00221);
                    if (objWaitForLongPress != coroutineSingletons) {
                        pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine5;
                        job = standaloneCoroutineLaunch$default;
                        pressGestureScopeImpl4 = pressGestureScopeImpl3;
                        coroutineScope3 = coroutineScope2;
                        objWaitForUpOrCancellation2 = objWaitForLongPress;
                        Function1 function39 = function7;
                        function9 = function4;
                        function10 = function6;
                        function11 = function39;
                        longPressResult = (LongPressResult) objWaitForUpOrCancellation2;
                        success2 = success;
                        if (!Intrinsics.areEqual(longPressResult, success2)) {
                            if (longPressResult instanceof LongPressResult.Released) {
                                pointerInputChange2 = ((LongPressResult.Released) longPressResult).finalUpChange;
                            } else {
                                if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                pointerInputChange2 = null;
                            }
                            Function1 function310 = function9;
                            coroutineScope4 = coroutineScope3;
                            function13 = function310;
                            function12 = function10;
                            function14 = function8;
                            function15 = function11;
                            pressGestureScopeImpl5 = pressGestureScopeImpl4;
                            pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                            if (pointerInputChange2 == null) {
                                standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 3));
                            } else {
                                pointerInputChange2.consume();
                                standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 4));
                            }
                            if (pointerInputChange2 != null) {
                                if (function13 == null) {
                                    c00221.L$0 = pointerEventHandlerCoroutine3;
                                    c00221.L$1 = coroutineScope4;
                                    c00221.L$2 = pressGestureScopeImpl5;
                                    c00221.L$3 = function13;
                                    c00221.L$4 = function15;
                                    c00221.L$5 = function14;
                                    c00221.L$6 = function12;
                                    c00221.L$7 = pointerInputChange2;
                                    c00221.L$8 = standaloneCoroutineLaunchAwaitingReset$default;
                                    c00221.label = 5;
                                    function16 = function14;
                                    function17 = function15;
                                    standaloneCoroutine = standaloneCoroutineLaunchAwaitingReset$default;
                                    objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange2, null), c00221);
                                    if (objWithTimeoutOrNull != coroutineSingletons) {
                                        function18 = function13;
                                        coroutineScope5 = coroutineScope4;
                                        function19 = function16;
                                        function20 = function12;
                                        pointerInputChange3 = pointerInputChange2;
                                        objWaitForUpOrCancellation2 = objWithTimeoutOrNull;
                                        job2 = standaloneCoroutine;
                                        pointerInputChange4 = (PointerInputChange) objWaitForUpOrCancellation2;
                                        if (pointerInputChange4 != null) {
                                            continuation2 = null;
                                            standaloneCoroutineLaunch$default2 = AwaitKt.launch$default(coroutineScope5, null, coroutineStart, new SimpleActor$offer$2(job2, pressGestureScopeImpl5, continuation2, (byte) 4), 1);
                                            if (function19 != draggableKt$NoOpOnDragStarted$1) {
                                                function21 = null;
                                                launchAwaitingReset$default(coroutineScope5, standaloneCoroutineLaunch$default2, new C00232(function19, pressGestureScopeImpl5, pointerInputChange4, continuation2, (byte) 1));
                                            } else {
                                                function21 = null;
                                            }
                                            if (function17 == null) {
                                                c00221.L$0 = coroutineScope5;
                                                c00221.L$1 = pressGestureScopeImpl5;
                                                c00221.L$2 = function18;
                                                c00221.L$3 = function20;
                                                c00221.L$4 = standaloneCoroutineLaunch$default2;
                                                c00221.L$5 = pointerInputChange3;
                                                c00221.L$6 = function21;
                                                c00221.L$7 = function21;
                                                c00221.L$8 = function21;
                                                c00221.label = 6;
                                                objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                                if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                                    PointerInputChange pointerInputChange13 = pointerInputChange3;
                                                    job4 = standaloneCoroutineLaunch$default2;
                                                    pointerInputChange7 = pointerInputChange13;
                                                    function24 = function20;
                                                    coroutineScope7 = coroutineScope5;
                                                    function25 = function18;
                                                    function26 = function21;
                                                    r5 = function26;
                                                    r13 = (PointerInputChange) objWaitForUpOrCancellation2;
                                                    if (r13 != 0) {
                                                        r13.consume();
                                                        launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                        function25.invoke(new Offset(r13.position));
                                                        return unit;
                                                    }
                                                    launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                    if (function24 != null) {
                                                        function24.invoke(new Offset(pointerInputChange7.position));
                                                        return unit;
                                                    }
                                                }
                                            } else {
                                                c00221.L$0 = pointerEventHandlerCoroutine3;
                                                c00221.L$1 = coroutineScope5;
                                                c00221.L$2 = pressGestureScopeImpl5;
                                                c00221.L$3 = function18;
                                                c00221.L$4 = function17;
                                                c00221.L$5 = function20;
                                                c00221.L$6 = standaloneCoroutineLaunch$default2;
                                                c00221.L$7 = pointerInputChange3;
                                                c00221.L$8 = r24;
                                                c00221.label = 7;
                                                objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                                if (objWaitForLongPress2 != coroutineSingletons) {
                                                    Function1 function311 = function20;
                                                    job3 = standaloneCoroutineLaunch$default2;
                                                    pointerInputChange5 = pointerInputChange4;
                                                    objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                                    function22 = function18;
                                                    pointerInputChange6 = pointerInputChange3;
                                                    pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                    function23 = function311;
                                                    pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                                    function27 = function21;
                                                    longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                                    if (Intrinsics.areEqual(longPressResult2, success2)) {
                                                        function17.invoke(new Offset(pointerInputChange5.position));
                                                        c00221.L$0 = coroutineScope5;
                                                        c00221.L$1 = pressGestureScopeImpl7;
                                                        c00221.L$2 = job3;
                                                        c00221.L$3 = function27;
                                                        c00221.L$4 = function27;
                                                        c00221.L$5 = function27;
                                                        c00221.L$6 = function27;
                                                        c00221.L$7 = function27;
                                                        c00221.L$8 = function27;
                                                        c00221.label = 8;
                                                        if (consumeUntilUp(pointerEventHandlerCoroutine4, c00221) != coroutineSingletons) {
                                                            job5 = job3;
                                                            coroutineScope8 = coroutineScope5;
                                                            r7 = function27;
                                                            launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                                                            return unit;
                                                        }
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                                            obj = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                return null;
                                                            }
                                                            obj = function27;
                                                        }
                                                        pointerInputChange7 = pointerInputChange6;
                                                        function24 = function23;
                                                        coroutineScope7 = coroutineScope5;
                                                        pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                        job4 = job3;
                                                        function25 = function22;
                                                        r5 = function27;
                                                        r13 = obj;
                                                        if (r13 != 0) {
                                                            r13.consume();
                                                            launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                            function25.invoke(new Offset(r13.position));
                                                            return unit;
                                                        }
                                                        launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                        if (function24 != null) {
                                                            function24.invoke(new Offset(pointerInputChange7.position));
                                                            return unit;
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (function20 != null) {
                                            function20.invoke(new Offset(pointerInputChange3.position));
                                            return unit;
                                        }
                                    }
                                } else if (function12 != null) {
                                    function12.invoke(new Offset(pointerInputChange2.position));
                                    return unit;
                                }
                            }
                            return unit;
                        }
                        function11.invoke(new Offset(pointerInputChange.position));
                        c00221.L$0 = coroutineScope3;
                        c00221.L$1 = pressGestureScopeImpl4;
                        c00221.L$2 = job;
                        continuation = null;
                        c00221.L$3 = null;
                        c00221.L$4 = null;
                        c00221.L$5 = null;
                        c00221.L$6 = null;
                        c00221.L$7 = null;
                        c00221.L$8 = null;
                        c00221.label = 4;
                        if (consumeUntilUp(pointerEventHandlerCoroutine2, c00221) != coroutineSingletons) {
                            coroutineScope6 = coroutineScope3;
                            pressGestureScopeImpl6 = pressGestureScopeImpl4;
                            launchAwaitingReset$default(coroutineScope6, job, new AnonymousClass3(pressGestureScopeImpl6, continuation, (byte) 0));
                            return unit;
                        }
                    }
                }
                return coroutineSingletons;
            case 2:
                job = (Job) c00221.L$7;
                function12 = (Function1) c00221.L$6;
                function14 = (Function3) c00221.L$5;
                function15 = (Function1) c00221.L$4;
                function13 = c00221.L$3;
                pressGestureScopeImpl5 = (PressGestureScopeImpl) c00221.L$2;
                CoroutineScope coroutineScope10 = (CoroutineScope) c00221.L$1;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine7 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00221.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine7;
                success = success3;
                coroutineScope4 = coroutineScope10;
                pointerInputChange2 = (PointerInputChange) objWaitForUpOrCancellation2;
                success2 = success;
                if (pointerInputChange2 == null) {
                    standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 3));
                } else {
                    pointerInputChange2.consume();
                    standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 4));
                }
                if (pointerInputChange2 != null) {
                    if (function13 == null) {
                        c00221.L$0 = pointerEventHandlerCoroutine3;
                        c00221.L$1 = coroutineScope4;
                        c00221.L$2 = pressGestureScopeImpl5;
                        c00221.L$3 = function13;
                        c00221.L$4 = function15;
                        c00221.L$5 = function14;
                        c00221.L$6 = function12;
                        c00221.L$7 = pointerInputChange2;
                        c00221.L$8 = standaloneCoroutineLaunchAwaitingReset$default;
                        c00221.label = 5;
                        function16 = function14;
                        function17 = function15;
                        standaloneCoroutine = standaloneCoroutineLaunchAwaitingReset$default;
                        objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange2, null), c00221);
                        if (objWithTimeoutOrNull != coroutineSingletons) {
                            function18 = function13;
                            coroutineScope5 = coroutineScope4;
                            function19 = function16;
                            function20 = function12;
                            pointerInputChange3 = pointerInputChange2;
                            objWaitForUpOrCancellation2 = objWithTimeoutOrNull;
                            job2 = standaloneCoroutine;
                            pointerInputChange4 = (PointerInputChange) objWaitForUpOrCancellation2;
                            if (pointerInputChange4 != null) {
                                continuation2 = null;
                                standaloneCoroutineLaunch$default2 = AwaitKt.launch$default(coroutineScope5, null, coroutineStart, new SimpleActor$offer$2(job2, pressGestureScopeImpl5, continuation2, (byte) 4), 1);
                                if (function19 != draggableKt$NoOpOnDragStarted$1) {
                                    function21 = null;
                                    launchAwaitingReset$default(coroutineScope5, standaloneCoroutineLaunch$default2, new C00232(function19, pressGestureScopeImpl5, pointerInputChange4, continuation2, (byte) 1));
                                } else {
                                    function21 = null;
                                }
                                if (function17 == null) {
                                    c00221.L$0 = coroutineScope5;
                                    c00221.L$1 = pressGestureScopeImpl5;
                                    c00221.L$2 = function18;
                                    c00221.L$3 = function20;
                                    c00221.L$4 = standaloneCoroutineLaunch$default2;
                                    c00221.L$5 = pointerInputChange3;
                                    c00221.L$6 = function21;
                                    c00221.L$7 = function21;
                                    c00221.L$8 = function21;
                                    c00221.label = 6;
                                    objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                    if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                        PointerInputChange pointerInputChange14 = pointerInputChange3;
                                        job4 = standaloneCoroutineLaunch$default2;
                                        pointerInputChange7 = pointerInputChange14;
                                        function24 = function20;
                                        coroutineScope7 = coroutineScope5;
                                        function25 = function18;
                                        function26 = function21;
                                        r5 = function26;
                                        r13 = (PointerInputChange) objWaitForUpOrCancellation2;
                                        if (r13 != 0) {
                                            r13.consume();
                                            launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                            function25.invoke(new Offset(r13.position));
                                            return unit;
                                        }
                                        launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                        if (function24 != null) {
                                            function24.invoke(new Offset(pointerInputChange7.position));
                                            return unit;
                                        }
                                    }
                                } else {
                                    c00221.L$0 = pointerEventHandlerCoroutine3;
                                    c00221.L$1 = coroutineScope5;
                                    c00221.L$2 = pressGestureScopeImpl5;
                                    c00221.L$3 = function18;
                                    c00221.L$4 = function17;
                                    c00221.L$5 = function20;
                                    c00221.L$6 = standaloneCoroutineLaunch$default2;
                                    c00221.L$7 = pointerInputChange3;
                                    c00221.L$8 = r24;
                                    c00221.label = 7;
                                    objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                    if (objWaitForLongPress2 != coroutineSingletons) {
                                        Function1 function312 = function20;
                                        job3 = standaloneCoroutineLaunch$default2;
                                        pointerInputChange5 = pointerInputChange4;
                                        objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                        function22 = function18;
                                        pointerInputChange6 = pointerInputChange3;
                                        pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                        function23 = function312;
                                        pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                        function27 = function21;
                                        longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                        if (Intrinsics.areEqual(longPressResult2, success2)) {
                                            function17.invoke(new Offset(pointerInputChange5.position));
                                            c00221.L$0 = coroutineScope5;
                                            c00221.L$1 = pressGestureScopeImpl7;
                                            c00221.L$2 = job3;
                                            c00221.L$3 = function27;
                                            c00221.L$4 = function27;
                                            c00221.L$5 = function27;
                                            c00221.L$6 = function27;
                                            c00221.L$7 = function27;
                                            c00221.L$8 = function27;
                                            c00221.label = 8;
                                            if (consumeUntilUp(pointerEventHandlerCoroutine4, c00221) != coroutineSingletons) {
                                                job5 = job3;
                                                coroutineScope8 = coroutineScope5;
                                                r7 = function27;
                                                launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                                                return unit;
                                            }
                                        } else {
                                            if (longPressResult2 instanceof LongPressResult.Released) {
                                                obj = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                            } else {
                                                if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                    return null;
                                                }
                                                obj = function27;
                                            }
                                            pointerInputChange7 = pointerInputChange6;
                                            function24 = function23;
                                            coroutineScope7 = coroutineScope5;
                                            pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                            job4 = job3;
                                            function25 = function22;
                                            r5 = function27;
                                            r13 = obj;
                                            if (r13 != 0) {
                                                r13.consume();
                                                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                function25.invoke(new Offset(r13.position));
                                                return unit;
                                            }
                                            launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                            if (function24 != null) {
                                                function24.invoke(new Offset(pointerInputChange7.position));
                                                return unit;
                                            }
                                        }
                                    }
                                }
                            } else if (function20 != null) {
                                function20.invoke(new Offset(pointerInputChange3.position));
                                return unit;
                            }
                        }
                        return coroutineSingletons;
                    }
                    if (function12 != null) {
                        function12.invoke(new Offset(pointerInputChange2.position));
                        return unit;
                    }
                }
                return unit;
            case 3:
                job = (Job) c00221.L$8;
                pointerInputChange = (PointerInputChange) c00221.L$7;
                function10 = (Function1) c00221.L$6;
                function8 = (Function3) c00221.L$5;
                function11 = (Function1) c00221.L$4;
                Function1 function40 = c00221.L$3;
                pressGestureScopeImpl4 = (PressGestureScopeImpl) c00221.L$2;
                coroutineScope3 = (CoroutineScope) c00221.L$1;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine8 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00221.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                success = success3;
                pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine8;
                function9 = function40;
                longPressResult = (LongPressResult) objWaitForUpOrCancellation2;
                success2 = success;
                if (!Intrinsics.areEqual(longPressResult, success2)) {
                    if (longPressResult instanceof LongPressResult.Released) {
                        pointerInputChange2 = ((LongPressResult.Released) longPressResult).finalUpChange;
                    } else {
                        if (!(longPressResult instanceof LongPressResult.Canceled)) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        pointerInputChange2 = null;
                    }
                    Function1 function313 = function9;
                    coroutineScope4 = coroutineScope3;
                    function13 = function313;
                    function12 = function10;
                    function14 = function8;
                    function15 = function11;
                    pressGestureScopeImpl5 = pressGestureScopeImpl4;
                    pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                    if (pointerInputChange2 == null) {
                        standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 3));
                    } else {
                        pointerInputChange2.consume();
                        standaloneCoroutineLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope4, job, new AnonymousClass3(pressGestureScopeImpl5, null, (byte) 4));
                    }
                    if (pointerInputChange2 != null) {
                        if (function13 == null) {
                            c00221.L$0 = pointerEventHandlerCoroutine3;
                            c00221.L$1 = coroutineScope4;
                            c00221.L$2 = pressGestureScopeImpl5;
                            c00221.L$3 = function13;
                            c00221.L$4 = function15;
                            c00221.L$5 = function14;
                            c00221.L$6 = function12;
                            c00221.L$7 = pointerInputChange2;
                            c00221.L$8 = standaloneCoroutineLaunchAwaitingReset$default;
                            c00221.label = 5;
                            function16 = function14;
                            function17 = function15;
                            standaloneCoroutine = standaloneCoroutineLaunchAwaitingReset$default;
                            objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange2, null), c00221);
                            if (objWithTimeoutOrNull != coroutineSingletons) {
                                function18 = function13;
                                coroutineScope5 = coroutineScope4;
                                function19 = function16;
                                function20 = function12;
                                pointerInputChange3 = pointerInputChange2;
                                objWaitForUpOrCancellation2 = objWithTimeoutOrNull;
                                job2 = standaloneCoroutine;
                                pointerInputChange4 = (PointerInputChange) objWaitForUpOrCancellation2;
                                if (pointerInputChange4 != null) {
                                    continuation2 = null;
                                    standaloneCoroutineLaunch$default2 = AwaitKt.launch$default(coroutineScope5, null, coroutineStart, new SimpleActor$offer$2(job2, pressGestureScopeImpl5, continuation2, (byte) 4), 1);
                                    if (function19 != draggableKt$NoOpOnDragStarted$1) {
                                        function21 = null;
                                        launchAwaitingReset$default(coroutineScope5, standaloneCoroutineLaunch$default2, new C00232(function19, pressGestureScopeImpl5, pointerInputChange4, continuation2, (byte) 1));
                                    } else {
                                        function21 = null;
                                    }
                                    if (function17 == null) {
                                        c00221.L$0 = coroutineScope5;
                                        c00221.L$1 = pressGestureScopeImpl5;
                                        c00221.L$2 = function18;
                                        c00221.L$3 = function20;
                                        c00221.L$4 = standaloneCoroutineLaunch$default2;
                                        c00221.L$5 = pointerInputChange3;
                                        c00221.L$6 = function21;
                                        c00221.L$7 = function21;
                                        c00221.L$8 = function21;
                                        c00221.label = 6;
                                        objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                        if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                            PointerInputChange pointerInputChange15 = pointerInputChange3;
                                            job4 = standaloneCoroutineLaunch$default2;
                                            pointerInputChange7 = pointerInputChange15;
                                            function24 = function20;
                                            coroutineScope7 = coroutineScope5;
                                            function25 = function18;
                                            function26 = function21;
                                            r5 = function26;
                                            r13 = (PointerInputChange) objWaitForUpOrCancellation2;
                                            if (r13 != 0) {
                                                r13.consume();
                                                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                function25.invoke(new Offset(r13.position));
                                                return unit;
                                            }
                                            launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                            if (function24 != null) {
                                                function24.invoke(new Offset(pointerInputChange7.position));
                                                return unit;
                                            }
                                        }
                                    } else {
                                        c00221.L$0 = pointerEventHandlerCoroutine3;
                                        c00221.L$1 = coroutineScope5;
                                        c00221.L$2 = pressGestureScopeImpl5;
                                        c00221.L$3 = function18;
                                        c00221.L$4 = function17;
                                        c00221.L$5 = function20;
                                        c00221.L$6 = standaloneCoroutineLaunch$default2;
                                        c00221.L$7 = pointerInputChange3;
                                        c00221.L$8 = r24;
                                        c00221.label = 7;
                                        objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                                        if (objWaitForLongPress2 != coroutineSingletons) {
                                            Function1 function314 = function20;
                                            job3 = standaloneCoroutineLaunch$default2;
                                            pointerInputChange5 = pointerInputChange4;
                                            objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                            function22 = function18;
                                            pointerInputChange6 = pointerInputChange3;
                                            pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                            function23 = function314;
                                            pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                            function27 = function21;
                                            longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                            if (Intrinsics.areEqual(longPressResult2, success2)) {
                                                function17.invoke(new Offset(pointerInputChange5.position));
                                                c00221.L$0 = coroutineScope5;
                                                c00221.L$1 = pressGestureScopeImpl7;
                                                c00221.L$2 = job3;
                                                c00221.L$3 = function27;
                                                c00221.L$4 = function27;
                                                c00221.L$5 = function27;
                                                c00221.L$6 = function27;
                                                c00221.L$7 = function27;
                                                c00221.L$8 = function27;
                                                c00221.label = 8;
                                                if (consumeUntilUp(pointerEventHandlerCoroutine4, c00221) != coroutineSingletons) {
                                                    job5 = job3;
                                                    coroutineScope8 = coroutineScope5;
                                                    r7 = function27;
                                                    launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                                                    return unit;
                                                }
                                            } else {
                                                if (longPressResult2 instanceof LongPressResult.Released) {
                                                    obj = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                } else {
                                                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                        return null;
                                                    }
                                                    obj = function27;
                                                }
                                                pointerInputChange7 = pointerInputChange6;
                                                function24 = function23;
                                                coroutineScope7 = coroutineScope5;
                                                pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                job4 = job3;
                                                function25 = function22;
                                                r5 = function27;
                                                r13 = obj;
                                                if (r13 != 0) {
                                                    r13.consume();
                                                    launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                                    function25.invoke(new Offset(r13.position));
                                                    return unit;
                                                }
                                                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                                if (function24 != null) {
                                                    function24.invoke(new Offset(pointerInputChange7.position));
                                                    return unit;
                                                }
                                            }
                                        }
                                    }
                                } else if (function20 != null) {
                                    function20.invoke(new Offset(pointerInputChange3.position));
                                    return unit;
                                }
                            }
                        } else if (function12 != null) {
                            function12.invoke(new Offset(pointerInputChange2.position));
                            return unit;
                        }
                    }
                    return unit;
                }
                function11.invoke(new Offset(pointerInputChange.position));
                c00221.L$0 = coroutineScope3;
                c00221.L$1 = pressGestureScopeImpl4;
                c00221.L$2 = job;
                continuation = null;
                c00221.L$3 = null;
                c00221.L$4 = null;
                c00221.L$5 = null;
                c00221.L$6 = null;
                c00221.L$7 = null;
                c00221.L$8 = null;
                c00221.label = 4;
                if (consumeUntilUp(pointerEventHandlerCoroutine2, c00221) != coroutineSingletons) {
                    coroutineScope6 = coroutineScope3;
                    pressGestureScopeImpl6 = pressGestureScopeImpl4;
                    launchAwaitingReset$default(coroutineScope6, job, new AnonymousClass3(pressGestureScopeImpl6, continuation, (byte) 0));
                    return unit;
                }
                return coroutineSingletons;
            case 4:
                job = (Job) c00221.L$2;
                pressGestureScopeImpl6 = (PressGestureScopeImpl) c00221.L$1;
                coroutineScope6 = (CoroutineScope) c00221.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                continuation = null;
                launchAwaitingReset$default(coroutineScope6, job, new AnonymousClass3(pressGestureScopeImpl6, continuation, (byte) 0));
                return unit;
            case 5:
                job2 = (Job) c00221.L$8;
                pointerInputChange3 = (PointerInputChange) c00221.L$7;
                function20 = (Function1) c00221.L$6;
                function19 = (Function3) c00221.L$5;
                Function1 function41 = (Function1) c00221.L$4;
                function18 = c00221.L$3;
                pressGestureScopeImpl5 = (PressGestureScopeImpl) c00221.L$2;
                coroutineScope5 = (CoroutineScope) c00221.L$1;
                pointerEventHandlerCoroutine3 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00221.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                pointerEventPass = pointerEventPass;
                success2 = success3;
                function17 = function41;
                pointerInputChange4 = (PointerInputChange) objWaitForUpOrCancellation2;
                if (pointerInputChange4 != null) {
                    continuation2 = null;
                    standaloneCoroutineLaunch$default2 = AwaitKt.launch$default(coroutineScope5, null, coroutineStart, new SimpleActor$offer$2(job2, pressGestureScopeImpl5, continuation2, (byte) 4), 1);
                    if (function19 != draggableKt$NoOpOnDragStarted$1) {
                        function21 = null;
                        launchAwaitingReset$default(coroutineScope5, standaloneCoroutineLaunch$default2, new C00232(function19, pressGestureScopeImpl5, pointerInputChange4, continuation2, (byte) 1));
                    } else {
                        function21 = null;
                    }
                    if (function17 == null) {
                        c00221.L$0 = coroutineScope5;
                        c00221.L$1 = pressGestureScopeImpl5;
                        c00221.L$2 = function18;
                        c00221.L$3 = function20;
                        c00221.L$4 = standaloneCoroutineLaunch$default2;
                        c00221.L$5 = pointerInputChange3;
                        c00221.L$6 = function21;
                        c00221.L$7 = function21;
                        c00221.L$8 = function21;
                        c00221.label = 6;
                        objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                        if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                            PointerInputChange pointerInputChange16 = pointerInputChange3;
                            job4 = standaloneCoroutineLaunch$default2;
                            pointerInputChange7 = pointerInputChange16;
                            function24 = function20;
                            coroutineScope7 = coroutineScope5;
                            function25 = function18;
                            function26 = function21;
                            r5 = function26;
                            r13 = (PointerInputChange) objWaitForUpOrCancellation2;
                            if (r13 != 0) {
                                r13.consume();
                                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                function25.invoke(new Offset(r13.position));
                                return unit;
                            }
                            launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                            if (function24 != null) {
                                function24.invoke(new Offset(pointerInputChange7.position));
                                return unit;
                            }
                        }
                    } else {
                        c00221.L$0 = pointerEventHandlerCoroutine3;
                        c00221.L$1 = coroutineScope5;
                        c00221.L$2 = pressGestureScopeImpl5;
                        c00221.L$3 = function18;
                        c00221.L$4 = function17;
                        c00221.L$5 = function20;
                        c00221.L$6 = standaloneCoroutineLaunch$default2;
                        c00221.L$7 = pointerInputChange3;
                        c00221.L$8 = r24;
                        c00221.label = 7;
                        objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine3, pointerEventPass, c00221);
                        if (objWaitForLongPress2 != coroutineSingletons) {
                            Function1 function315 = function20;
                            job3 = standaloneCoroutineLaunch$default2;
                            pointerInputChange5 = pointerInputChange4;
                            objWaitForUpOrCancellation2 = objWaitForLongPress2;
                            function22 = function18;
                            pointerInputChange6 = pointerInputChange3;
                            pressGestureScopeImpl7 = pressGestureScopeImpl5;
                            function23 = function315;
                            pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                            function27 = function21;
                            longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                            if (Intrinsics.areEqual(longPressResult2, success2)) {
                                function17.invoke(new Offset(pointerInputChange5.position));
                                c00221.L$0 = coroutineScope5;
                                c00221.L$1 = pressGestureScopeImpl7;
                                c00221.L$2 = job3;
                                c00221.L$3 = function27;
                                c00221.L$4 = function27;
                                c00221.L$5 = function27;
                                c00221.L$6 = function27;
                                c00221.L$7 = function27;
                                c00221.L$8 = function27;
                                c00221.label = 8;
                                if (consumeUntilUp(pointerEventHandlerCoroutine4, c00221) != coroutineSingletons) {
                                    job5 = job3;
                                    coroutineScope8 = coroutineScope5;
                                    r7 = function27;
                                    launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                                    return unit;
                                }
                            } else {
                                if (longPressResult2 instanceof LongPressResult.Released) {
                                    obj = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                } else {
                                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                        return null;
                                    }
                                    obj = function27;
                                }
                                pointerInputChange7 = pointerInputChange6;
                                function24 = function23;
                                coroutineScope7 = coroutineScope5;
                                pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                job4 = job3;
                                function25 = function22;
                                r5 = function27;
                                r13 = obj;
                                if (r13 != 0) {
                                    r13.consume();
                                    launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                                    function25.invoke(new Offset(r13.position));
                                    return unit;
                                }
                                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                                if (function24 != null) {
                                    function24.invoke(new Offset(pointerInputChange7.position));
                                    return unit;
                                }
                            }
                        }
                    }
                    return coroutineSingletons;
                }
                if (function20 != null) {
                    function20.invoke(new Offset(pointerInputChange3.position));
                    return unit;
                }
                return unit;
            case 6:
                pointerInputChange7 = (PointerInputChange) c00221.L$5;
                job4 = (Job) c00221.L$4;
                function24 = c00221.L$3;
                function25 = (Function1) c00221.L$2;
                pressGestureScopeImpl5 = (PressGestureScopeImpl) c00221.L$1;
                coroutineScope7 = (CoroutineScope) c00221.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                function26 = null;
                r5 = function26;
                r13 = (PointerInputChange) objWaitForUpOrCancellation2;
                if (r13 != 0) {
                    r13.consume();
                    launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                    function25.invoke(new Offset(r13.position));
                    return unit;
                }
                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                if (function24 != null) {
                    function24.invoke(new Offset(pointerInputChange7.position));
                    return unit;
                }
                return unit;
            case 7:
                pointerInputChange5 = (PointerInputChange) c00221.L$8;
                PointerInputChange pointerInputChange17 = (PointerInputChange) c00221.L$7;
                job3 = (Job) c00221.L$6;
                function23 = (Function1) c00221.L$5;
                Function1 function42 = (Function1) c00221.L$4;
                function22 = c00221.L$3;
                PressGestureScopeImpl pressGestureScopeImpl11 = (PressGestureScopeImpl) c00221.L$2;
                CoroutineScope coroutineScope11 = (CoroutineScope) c00221.L$1;
                pointerEventHandlerCoroutine4 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00221.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                function17 = function42;
                coroutineScope5 = coroutineScope11;
                pointerInputChange6 = pointerInputChange17;
                pressGestureScopeImpl7 = pressGestureScopeImpl11;
                success2 = success3;
                function27 = null;
                longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                if (Intrinsics.areEqual(longPressResult2, success2)) {
                    function17.invoke(new Offset(pointerInputChange5.position));
                    c00221.L$0 = coroutineScope5;
                    c00221.L$1 = pressGestureScopeImpl7;
                    c00221.L$2 = job3;
                    c00221.L$3 = function27;
                    c00221.L$4 = function27;
                    c00221.L$5 = function27;
                    c00221.L$6 = function27;
                    c00221.L$7 = function27;
                    c00221.L$8 = function27;
                    c00221.label = 8;
                    if (consumeUntilUp(pointerEventHandlerCoroutine4, c00221) != coroutineSingletons) {
                        job5 = job3;
                        coroutineScope8 = coroutineScope5;
                        r7 = function27;
                        launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                        return unit;
                    }
                    return coroutineSingletons;
                }
                if (longPressResult2 instanceof LongPressResult.Released) {
                    obj = ((LongPressResult.Released) longPressResult2).finalUpChange;
                } else {
                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    obj = function27;
                }
                pointerInputChange7 = pointerInputChange6;
                function24 = function23;
                coroutineScope7 = coroutineScope5;
                pressGestureScopeImpl5 = pressGestureScopeImpl7;
                job4 = job3;
                function25 = function22;
                r5 = function27;
                r13 = obj;
                if (r13 != 0) {
                    r13.consume();
                    launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 5));
                    function25.invoke(new Offset(r13.position));
                    return unit;
                }
                launchAwaitingReset$default(coroutineScope7, job4, new AnonymousClass3(pressGestureScopeImpl5, r5, (byte) 6));
                if (function24 != null) {
                    function24.invoke(new Offset(pointerInputChange7.position));
                    return unit;
                }
                return unit;
            case 8:
                job5 = (Job) c00221.L$2;
                pressGestureScopeImpl7 = (PressGestureScopeImpl) c00221.L$1;
                coroutineScope8 = (CoroutineScope) c00221.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                r7 = 0;
                launchAwaitingReset$default(coroutineScope8, job5, new AnonymousClass3(pressGestureScopeImpl7, r7, (byte) 7));
                return unit;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object waitForLongPress(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, PointerEventPass pointerEventPass, ContinuationImpl continuationImpl) {
        C00241 c00241;
        Ref$ObjectRef ref$ObjectRef;
        if (continuationImpl instanceof C00241) {
            c00241 = (C00241) continuationImpl;
            int i = c00241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00241.label = i - Integer.MIN_VALUE;
            } else {
                c00241 = new C00241(continuationImpl);
            }
        } else {
            c00241 = new C00241(continuationImpl);
        }
        Object obj = c00241.result;
        int i2 = c00241.label;
        Continuation continuation = null;
        byte b = 1;
        try {
            if (i2 == 0) {
                Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
                ref$ObjectRefM5m.element = LongPressResult.Canceled.INSTANCE;
                long longPressTimeoutMillis = pointerEventHandlerCoroutine.getViewConfiguration().getLongPressTimeoutMillis();
                Function2 forEachGestureKt$awaitEachGesture$2 = new ForEachGestureKt$awaitEachGesture$2(pointerEventPass, ref$ObjectRefM5m, continuation, b);
                c00241.L$0 = ref$ObjectRefM5m;
                c00241.label = 1;
                Object objWithTimeout = pointerEventHandlerCoroutine.withTimeout(longPressTimeoutMillis, forEachGestureKt$awaitEachGesture$2, c00241);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithTimeout == obj2) {
                    return obj2;
                }
                ref$ObjectRef = ref$ObjectRefM5m;
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ref$ObjectRef = c00241.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return ref$ObjectRef.element;
        } catch (PointerEventTimeoutCancellationException unused) {
            return LongPressResult.Success.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:30:0x008f  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cd A[LOOP:1: B:23:0x006e->B:44:0x00cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00ad -> B:13:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r17, androidx.compose.ui.input.pointer.PointerEventPass r18, kotlin.coroutines.jvm.internal.BaseContinuationImpl r19) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }
}
