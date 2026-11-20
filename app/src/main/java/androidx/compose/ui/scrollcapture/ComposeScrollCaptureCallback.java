package androidx.compose.ui.scrollcapture;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda0;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.unit.IntRect;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.playback.MusicService;
import com.yalantis.ucrop.view.CropImageView;
import java.util.function.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {
    public final AndroidComposeView composeView;
    public final ContextScope coroutineScope;
    public final ScrollCapture listener;
    public final SemanticsNode node;
    public final RelativeScroller scrollTracker;
    public final IntRect viewportBoundsInWindow;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public Object L$0;
        public IntRect L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass2(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ComposeScrollCaptureCallback.this.onScrollCaptureImageRequest(null, null, this);
        }
    }

    public ComposeScrollCaptureCallback(SemanticsNode semanticsNode, IntRect intRect, ContextScope contextScope, ScrollCapture scrollCapture, AndroidComposeView androidComposeView) {
        this.node = semanticsNode;
        this.viewportBoundsInWindow = intRect;
        this.listener = scrollCapture;
        this.composeView = androidComposeView;
        this.coroutineScope = new ContextScope(contextScope.coroutineContext.plus(DisableAnimationMotionDurationScale.INSTANCE));
        this.scrollTracker = new RelativeScroller(intRect.getHeight(), new MusicService.AnonymousClass14(this, null, (byte) 1));
    }

    public final void onScrollCaptureEnd(Runnable runnable) {
        AwaitKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, null, new SliderState.AnonymousClass2(this, runnable, null, (byte) 28), 2);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, IntRect intRect, ContinuationImpl continuationImpl) {
        AnonymousClass2 anonymousClass2;
        int i;
        int i2;
        ScrollCaptureSession scrollCaptureSession2;
        int i3;
        IntRect intRect2;
        int i4;
        int iCoerceIn;
        int iCoerceIn2;
        int i5;
        int i6;
        Canvas canvasLockHardwareCanvas;
        if (continuationImpl instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuationImpl;
            int i7 = anonymousClass2.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i7 - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuationImpl);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuationImpl);
        }
        Object obj = anonymousClass2.result;
        int i8 = anonymousClass2.label;
        RelativeScroller relativeScroller = this.scrollTracker;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            i = intRect.top;
            i2 = intRect.bottom;
            anonymousClass2.L$0 = scrollCaptureSession;
            anonymousClass2.L$1 = intRect;
            anonymousClass2.I$0 = i;
            anonymousClass2.I$1 = i2;
            anonymousClass2.label = 1;
            if (i > i2) {
                relativeScroller.getClass();
                throw new IllegalArgumentException(("Expected min=" + i + " ≤ max=" + i2).toString());
            }
            int i9 = i2 - i;
            int i10 = relativeScroller.viewportSize;
            if (i9 > i10) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(i9, i10, "Expected range (", ") to be ≤ viewportSize="));
                return null;
            }
            Object objScrollBy = relativeScroller.scrollBy((((i9 / 2) + i) - (i10 / 2)) - relativeScroller.scrollAmount, anonymousClass2);
            Object obj2 = Unit.INSTANCE;
            if (objScrollBy != coroutineSingletons) {
                objScrollBy = obj2;
            }
            if (objScrollBy == coroutineSingletons) {
                obj2 = objScrollBy;
            }
            if (obj2 != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i8 == 1) {
            int i11 = anonymousClass2.I$1;
            int i12 = anonymousClass2.I$0;
            IntRect intRect3 = anonymousClass2.L$1;
            ScrollCaptureSession scrollCaptureSession3 = (ScrollCaptureSession) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            i = i12;
            intRect = intRect3;
            i2 = i11;
            scrollCaptureSession = scrollCaptureSession3;
        } else {
            if (i8 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i3 = anonymousClass2.I$1;
            i4 = anonymousClass2.I$0;
            intRect2 = anonymousClass2.L$1;
            scrollCaptureSession2 = (ScrollCaptureSession) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        iCoerceIn = UuidKt.coerceIn(i4 - MathKt.roundToInt(relativeScroller.scrollAmount), 0, relativeScroller.viewportSize);
        iCoerceIn2 = UuidKt.coerceIn(i3 - MathKt.roundToInt(relativeScroller.scrollAmount), 0, relativeScroller.viewportSize);
        i5 = intRect2.left;
        i6 = intRect2.right;
        if (iCoerceIn == iCoerceIn2) {
            return IntRect.Zero;
        }
        canvasLockHardwareCanvas = scrollCaptureSession2.getSurface().lockHardwareCanvas();
        try {
            canvasLockHardwareCanvas.save();
            canvasLockHardwareCanvas.translate(-i5, -iCoerceIn);
            IntRect intRect4 = this.viewportBoundsInWindow;
            canvasLockHardwareCanvas.translate(-intRect4.left, -intRect4.top);
            this.composeView.getRootView().draw(canvasLockHardwareCanvas);
            int iRoundToInt = MathKt.roundToInt(relativeScroller.scrollAmount);
            return new IntRect(i5, iCoerceIn + iRoundToInt, i6, iCoerceIn2 + iRoundToInt);
        } finally {
            scrollCaptureSession2.getSurface().unlockCanvasAndPost(canvasLockHardwareCanvas);
        }
        SaversKt$$ExternalSyntheticLambda2 saversKt$$ExternalSyntheticLambda2 = new SaversKt$$ExternalSyntheticLambda2((byte) 3);
        anonymousClass2.L$0 = scrollCaptureSession;
        anonymousClass2.L$1 = intRect;
        anonymousClass2.I$0 = i;
        anonymousClass2.I$1 = i2;
        anonymousClass2.label = 2;
        if (Stack.getMonotonicFrameClock(anonymousClass2.getContext()).withFrameNanos(saversKt$$ExternalSyntheticLambda2, anonymousClass2) != coroutineSingletons) {
            scrollCaptureSession2 = scrollCaptureSession;
            i3 = i2;
            intRect2 = intRect;
            i4 = i;
            iCoerceIn = UuidKt.coerceIn(i4 - MathKt.roundToInt(relativeScroller.scrollAmount), 0, relativeScroller.viewportSize);
            iCoerceIn2 = UuidKt.coerceIn(i3 - MathKt.roundToInt(relativeScroller.scrollAmount), 0, relativeScroller.viewportSize);
            i5 = intRect2.left;
            i6 = intRect2.right;
            if (iCoerceIn == iCoerceIn2) {
                return IntRect.Zero;
            }
            canvasLockHardwareCanvas = scrollCaptureSession2.getSurface().lockHardwareCanvas();
            canvasLockHardwareCanvas.save();
            canvasLockHardwareCanvas.translate(-i5, -iCoerceIn);
            IntRect intRect5 = this.viewportBoundsInWindow;
            canvasLockHardwareCanvas.translate(-intRect5.left, -intRect5.top);
            this.composeView.getRootView().draw(canvasLockHardwareCanvas);
            int iRoundToInt2 = MathKt.roundToInt(relativeScroller.scrollAmount);
            return new IntRect(i5, iCoerceIn + iRoundToInt2, i6, iCoerceIn2 + iRoundToInt2);
        }
        return coroutineSingletons;
    }

    public final void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer consumer) {
        consumer.accept(ColorKt.toAndroidRect(this.viewportBoundsInWindow));
    }

    public final void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.scrollTracker.scrollAmount = CropImageView.DEFAULT_ASPECT_RATIO;
        ((ParcelableSnapshotMutableState) this.listener.scrollCaptureInProgress$delegate).setValue(Boolean.TRUE);
        runnable.run();
    }

    public final void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer consumer) {
        StandaloneCoroutine standaloneCoroutineLaunch$default = AwaitKt.launch$default(this.coroutineScope, null, null, new InnerTube$feedback$2(this, scrollCaptureSession, rect, consumer, (Continuation) null, (byte) 7), 3);
        standaloneCoroutineLaunch$default.invokeOnCompletion(new DiskLruCache$$ExternalSyntheticLambda0((byte) 4, cancellationSignal));
        cancellationSignal.setOnCancelListener(new HandwritingGestureApi34$$ExternalSyntheticLambda0((byte) 1, standaloneCoroutineLaunch$default));
    }
}
