package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Latch;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.core.view.insets.SystemBarStateMonitor;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WindowRecomposer_androidKt {
    public static final MutableScatterMap animationScale;

    static {
        long[] jArr = ScatterMapKt.EmptyGroup;
        animationScale = new MutableScatterMap();
    }

    public static final CompositionContext getCompositionContext(View view) {
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }

    public static final Recomposer getWindowRecomposer(View view) {
        CoroutineContext coroutineContext;
        final PausableMonotonicFrameClock pausableMonotonicFrameClock;
        byte b;
        if (!view.isAttachedToWindow()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot locate windowRecomposer; View " + view + " is not attached to a window");
        }
        Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
        while (parentOrViewTreeDisjointParent instanceof View) {
            View view2 = (View) parentOrViewTreeDisjointParent;
            if (view2.getId() == 16908290) {
                break;
            }
            parentOrViewTreeDisjointParent = view2.getParent();
            view = view2;
        }
        CompositionContext compositionContext = getCompositionContext(view);
        Continuation continuation = null;
        if (compositionContext != null) {
            if (compositionContext instanceof Recomposer) {
                return (Recomposer) compositionContext;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("root viewTreeParentCompositionContext is not a Recomposer");
            return null;
        }
        ((WindowRecomposerFactory$Companion$$ExternalSyntheticLambda0) WindowRecomposerPolicy.factory.get()).getClass();
        CoroutineContext coroutineContext2 = EmptyCoroutineContext.INSTANCE;
        SynchronizedLazyImpl synchronizedLazyImpl = AndroidUiDispatcher.Main$delegate;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            coroutineContext = (CoroutineContext) AndroidUiDispatcher.Main$delegate.getValue();
        } else {
            coroutineContext = (CoroutineContext) AndroidUiDispatcher.currentThread.get();
            if (coroutineContext == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("no AndroidUiDispatcher for this thread");
                return null;
            }
        }
        CoroutineContext coroutineContextPlus = coroutineContext.plus(coroutineContext2);
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) coroutineContextPlus.get(NeverEqualPolicy.$$INSTANCE);
        if (monotonicFrameClock != null) {
            pausableMonotonicFrameClock = new PausableMonotonicFrameClock(monotonicFrameClock);
            Latch latch = pausableMonotonicFrameClock.latch;
            synchronized (latch.lock) {
                latch._isOpen = false;
            }
        } else {
            pausableMonotonicFrameClock = null;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        CoroutineContext motionDurationScaleImpl = (MotionDurationScale) coroutineContextPlus.get(Alignment.Companion.$$INSTANCE);
        if (motionDurationScaleImpl == null) {
            motionDurationScaleImpl = new MotionDurationScaleImpl(view.getContext().getApplicationContext());
            ref$ObjectRef.element = motionDurationScaleImpl;
        }
        if (pausableMonotonicFrameClock != null) {
            coroutineContext2 = pausableMonotonicFrameClock;
        }
        CoroutineContext coroutineContextPlus2 = coroutineContextPlus.plus(coroutineContext2).plus(motionDurationScaleImpl);
        final Recomposer recomposer = new Recomposer(coroutineContextPlus2);
        synchronized (recomposer.stateLock) {
            b = 1;
            recomposer.frameClockPaused = true;
        }
        final ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(coroutineContextPlus2);
        LifecycleOwner lifecycleOwner = ViewModelKt.get(view);
        Lifecycle lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
        if (lifecycle == null) {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("ViewTreeLifecycleOwner not found from " + view);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return null;
        }
        view.addOnAttachStateChangeListener(new SystemBarStateMonitor.AnonymousClass3(view, recomposer, b));
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            public abstract /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                CancellableContinuation cancellableContinuationDeriveStateLocked = null;
                switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                    case 1:
                        AwaitKt.launch$default(contextScopeCoroutineScope, null, CoroutineStart.UNDISPATCHED, new InnerTube$feedback$2(ref$ObjectRef, recomposer, lifecycleOwner2, this, (Continuation) null, (byte) 6), 1);
                        return;
                    case 2:
                        PausableMonotonicFrameClock pausableMonotonicFrameClock2 = pausableMonotonicFrameClock;
                        if (pausableMonotonicFrameClock2 != null) {
                            pausableMonotonicFrameClock2.resume();
                        }
                        Recomposer recomposer2 = recomposer;
                        synchronized (recomposer2.stateLock) {
                            if (recomposer2.frameClockPaused) {
                                recomposer2.frameClockPaused = false;
                                cancellableContinuationDeriveStateLocked = recomposer2.deriveStateLocked();
                            }
                            break;
                        }
                        if (cancellableContinuationDeriveStateLocked != null) {
                            ((CancellableContinuationImpl) cancellableContinuationDeriveStateLocked).resumeWith(Unit.INSTANCE);
                            return;
                        }
                        return;
                    case 3:
                        Recomposer recomposer3 = recomposer;
                        synchronized (recomposer3.stateLock) {
                            recomposer3.frameClockPaused = true;
                        }
                        return;
                    case 4:
                        recomposer.cancel();
                        return;
                    case 5:
                    case 6:
                    case 7:
                        return;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return;
                }
            }
        });
        view.setTag(R.id.androidx_compose_ui_view_composition_context, recomposer);
        GlobalScope globalScope = GlobalScope.INSTANCE;
        Handler handler = view.getHandler();
        int i = HandlerDispatcherKt.$r8$clinit;
        view.addOnAttachStateChangeListener(new StandardMenuPopup.AnonymousClass2((byte) 4, AwaitKt.launch$default(globalScope, new HandlerContext(handler, "windowRecomposer cleanup", false).immediate, null, new SliderState.AnonymousClass2(recomposer, view, continuation, (byte) 27), 2)));
        return recomposer;
    }
}
