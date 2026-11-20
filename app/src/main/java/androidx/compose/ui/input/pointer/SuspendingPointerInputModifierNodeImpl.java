package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import coil3.network.HttpException;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import sh.calvin.reorderable.ReorderableLazyCollectionState$onDragStop$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements PointerInputScope, Density, PointerInputModifierNode {
    public PointerInputEventHandler _pointerInputEventHandler;
    public long boundsSize;
    public PointerEvent currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
    public final MutableVector dispatchingPointerHandlers;
    public Object key1;
    public Object key2;
    public PointerEvent lastPointerEvent;
    public final MutableVector pointerHandlers;
    public final MutableVector pointerHandlersLock;
    public StandaloneCoroutine pointerInputJob;

    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler) {
        this.key1 = obj;
        this.key2 = obj2;
        this._pointerInputEventHandler = pointerInputEventHandler;
        MutableVector mutableVector = new MutableVector(new PointerEventHandlerCoroutine[16]);
        this.pointerHandlers = mutableVector;
        this.pointerHandlersLock = mutableVector;
        this.dispatchingPointerHandlers = new MutableVector(new PointerEventHandlerCoroutine[16]);
        this.boundsSize = 0L;
    }

    public final Object awaitPointerEventScope(Function2 function2, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl);
        synchronized (this.pointerHandlersLock) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            new SafeContinuation(Okio__OkioKt.intercepted(Okio__OkioKt.createCoroutineUnintercepted(pointerEventHandlerCoroutine, pointerEventHandlerCoroutine, function2))).resumeWith(Unit.INSTANCE);
        }
        cancellableContinuationImpl.invokeOnCancellation(new CallsKt$await$2$1((byte) 6, pointerEventHandlerCoroutine));
        return cancellableContinuationImpl.getResult();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004c A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x000d, B:13:0x001b, B:14:0x0020, B:17:0x0023, B:20:0x002f, B:22:0x0037, B:24:0x003b, B:25:0x0040, B:26:0x0043, B:28:0x004c, B:30:0x0054, B:32:0x0058), top: B:41:0x000d }] */
    public final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        Object[] objArr;
        int i;
        int i2;
        PointerEventHandlerCoroutine pointerEventHandlerCoroutine;
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        synchronized (this.pointerHandlersLock) {
            MutableVector mutableVector = this.dispatchingPointerHandlers;
            mutableVector.addAll(mutableVector.size, this.pointerHandlers);
        }
        try {
            int iOrdinal = pointerEventPass.ordinal();
            if (iOrdinal == 0) {
                MutableVector mutableVector2 = this.dispatchingPointerHandlers;
                objArr = mutableVector2.content;
                i = mutableVector2.size;
                for (i2 = 0; i2 < i; i2++) {
                    pointerEventHandlerCoroutine = (PointerEventHandlerCoroutine) objArr[i2];
                    if (pointerEventPass != pointerEventHandlerCoroutine.awaitPass && (cancellableContinuationImpl = pointerEventHandlerCoroutine.pointerAwaiter) != null) {
                        pointerEventHandlerCoroutine.pointerAwaiter = null;
                        cancellableContinuationImpl.resumeWith(pointerEvent);
                    }
                }
            } else if (iOrdinal == 1) {
                MutableVector mutableVector3 = this.dispatchingPointerHandlers;
                int i3 = mutableVector3.size - 1;
                Object[] objArr2 = mutableVector3.content;
                if (i3 < objArr2.length) {
                    while (i3 >= 0) {
                        PointerEventHandlerCoroutine pointerEventHandlerCoroutine2 = (PointerEventHandlerCoroutine) objArr2[i3];
                        if (pointerEventPass == pointerEventHandlerCoroutine2.awaitPass && (cancellableContinuationImpl2 = pointerEventHandlerCoroutine2.pointerAwaiter) != null) {
                            pointerEventHandlerCoroutine2.pointerAwaiter = null;
                            cancellableContinuationImpl2.resumeWith(pointerEvent);
                        }
                        i3--;
                    }
                }
            } else {
                if (iOrdinal != 2) {
                    throw new HttpException();
                }
                MutableVector mutableVector4 = this.dispatchingPointerHandlers;
                objArr = mutableVector4.content;
                i = mutableVector4.size;
                while (i2 < i) {
                    pointerEventHandlerCoroutine = (PointerEventHandlerCoroutine) objArr[i2];
                    if (pointerEventPass != pointerEventHandlerCoroutine.awaitPass) {
                    }
                }
            }
            this.dispatchingPointerHandlers.clear();
        } catch (Throwable th) {
            this.dispatchingPointerHandlers.clear();
            throw th;
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return HitTestResultKt.requireLayoutNode(this).density.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return HitTestResultKt.requireLayoutNode(this).density.getFontScale();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent == null) {
            return;
        }
        List list = pointerEvent.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((PointerInputChange) list.get(i)).pressed) {
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    PointerInputChange pointerInputChange = (PointerInputChange) list.get(i2);
                    long j = pointerInputChange.id;
                    long j2 = pointerInputChange.position;
                    long j3 = pointerInputChange.uptimeMillis;
                    float f = pointerInputChange.pressure;
                    boolean z = pointerInputChange.pressed;
                    arrayList.add(new PointerInputChange(j, j3, j2, false, f, j3, j2, z, z, pointerInputChange.type, 0L, 1.0f, 0L));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList, null);
                this.currentEvent = pointerEvent2;
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
                this.lastPointerEvent = null;
                return;
            }
        }
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.boundsSize = j;
        if (pointerEventPass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        Continuation continuation = null;
        if (this.pointerInputJob == null) {
            this.pointerInputJob = AwaitKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new ArtistViewModel.AnonymousClass1(this, continuation, (byte) 3), 1);
        }
        dispatchPointerEvent(pointerEvent, pointerEventPass);
        List list = pointerEvent.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!PointerIconKt.changedToUpIgnoreConsumed((PointerInputChange) list.get(i))) {
                this.lastPointerEvent = pointerEvent;
            }
        }
        pointerEvent = null;
        this.lastPointerEvent = pointerEvent;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    public final void resetPointerInputHandler() {
        StandaloneCoroutine standaloneCoroutine = this.pointerInputJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancelInternal(new PointerInputResetException("Pointer input was reset", (byte) 0));
            this.pointerInputJob = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PointerEventHandlerCoroutine implements Density, Continuation {
        public final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;
        public PointerEventPass awaitPass = PointerEventPass.Main;
        public final CancellableContinuationImpl completion;
        public CancellableContinuationImpl pointerAwaiter;

        public PointerEventHandlerCoroutine(CancellableContinuationImpl cancellableContinuationImpl) {
            this.$$delegate_0 = SuspendingPointerInputModifierNodeImpl.this;
            this.completion = cancellableContinuationImpl;
        }

        public final Object awaitPointerEvent(PointerEventPass pointerEventPass, BaseContinuationImpl baseContinuationImpl) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(baseContinuationImpl));
            cancellableContinuationImpl.initCancellability();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = cancellableContinuationImpl;
            return cancellableContinuationImpl.getResult();
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            return EmptyCoroutineContext.INSTANCE;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public final long m593getExtendedTouchPaddingNHjbRc() {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            long jMo82toSizeXkaWNTQ = suspendingPointerInputModifierNodeImpl.mo82toSizeXkaWNTQ(HitTestResultKt.requireLayoutNode(suspendingPointerInputModifierNodeImpl).viewConfiguration.mo649getMinimumTouchTargetSizeMYxV2XQ());
            long j = suspendingPointerInputModifierNodeImpl.boundsSize;
            return (((long) Float.floatToRawIntBits(Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Float.intBitsToFloat((int) (jMo82toSizeXkaWNTQ >> 32)) - ((int) (j >> 32))) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Float.intBitsToFloat((int) (jMo82toSizeXkaWNTQ & 4294967295L)) - ((int) (j & 4294967295L))) / 2.0f)) & 4294967295L);
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        public final ViewConfiguration getViewConfiguration() {
            return HitTestResultKt.requireLayoutNode(SuspendingPointerInputModifierNodeImpl.this).viewConfiguration;
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object obj) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (suspendingPointerInputModifierNodeImpl.pointerHandlersLock) {
                suspendingPointerInputModifierNodeImpl.pointerHandlers.remove(this);
            }
            this.completion.resumeWith(obj);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public final int mo74roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo74roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public final int mo75roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo75roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public final float mo76toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo76toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo77toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo77toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public final long mo79toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo79toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public final float mo80toPxR2X_6o(long j) {
            return this.$$delegate_0.mo80toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public final float mo81toPx0680j_4(float f) {
            return this.$$delegate_0.getDensity() * f;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public final long mo82toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo82toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public final long mo83toSp0xMU5do(float f) {
            return this.$$delegate_0.mo83toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final long mo84toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo84toSpkPz2Gy4(f);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object withTimeout(long j, Function2 function2, BaseContinuationImpl baseContinuationImpl) {
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1;
            Throwable th;
            StandaloneCoroutine standaloneCoroutine;
            CancellableContinuationImpl cancellableContinuationImpl;
            if (baseContinuationImpl instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) baseContinuationImpl;
                int i = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label = i - Integer.MIN_VALUE;
                } else {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, baseContinuationImpl);
                }
            } else {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, baseContinuationImpl);
            }
            Object objInvoke = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.result;
            int i2 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                standaloneCoroutine = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.L$0;
                try {
                    ResultKt.throwOnFailure(objInvoke);
                    standaloneCoroutine.cancel(CancelTimeoutCancellationException.INSTANCE);
                    return objInvoke;
                } catch (Throwable th2) {
                    th = th2;
                    standaloneCoroutine.cancel(CancelTimeoutCancellationException.INSTANCE);
                    throw th;
                }
            }
            ResultKt.throwOnFailure(objInvoke);
            if (j <= 0 && (cancellableContinuationImpl = this.pointerAwaiter) != null) {
                cancellableContinuationImpl.resumeWith(new Result.Failure(new PointerEventTimeoutCancellationException(j)));
            }
            StandaloneCoroutine standaloneCoroutineLaunch$default = AwaitKt.launch$default(SuspendingPointerInputModifierNodeImpl.this.getCoroutineScope(), null, null, new ReorderableLazyCollectionState$onDragStop$1(j, this, (Continuation) null), 3);
            try {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.L$0 = standaloneCoroutineLaunch$default;
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label = 1;
                objInvoke = function2.invoke(this, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1);
                Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objInvoke == obj) {
                    return obj;
                }
                standaloneCoroutine = standaloneCoroutineLaunch$default;
                standaloneCoroutine.cancel(CancelTimeoutCancellationException.INSTANCE);
                return objInvoke;
            } catch (Throwable th3) {
                th = th3;
                standaloneCoroutine = standaloneCoroutineLaunch$default;
                standaloneCoroutine.cancel(CancelTimeoutCancellationException.INSTANCE);
                throw th;
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object withTimeoutOrNull(long j, Function2 function2, ContinuationImpl continuationImpl) {
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1;
            if (continuationImpl instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) continuationImpl;
                int i = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label = i - Integer.MIN_VALUE;
                } else {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, continuationImpl);
                }
            } else {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, continuationImpl);
            }
            Object obj = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.result;
            int i2 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label;
            try {
                if (i2 != 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label = 1;
                Object objWithTimeout = withTimeout(j, function2, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objWithTimeout == obj2 ? obj2 : objWithTimeout;
            } catch (PointerEventTimeoutCancellationException unused) {
                return null;
            }
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo78toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo78toDpu2uoSUM(i);
        }
    }
}
