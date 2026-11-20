package androidx.compose.foundation.gestures;

import android.view.ViewTreeObserver;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Velocity;
import coil3.RealImageLoader;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.Method;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic {
    public FlingBehavior flingBehavior;
    public boolean isFlinging;
    public final ScrollableNode$$ExternalSyntheticLambda0 isScrollableNodeAttached;
    public NestedScrollDispatcher nestedScrollDispatcher;
    public final ScrollableNode onScrollChangedDispatcher;
    public Orientation orientation;
    public AndroidEdgeEffectOverscrollEffect overscrollEffect;
    public boolean reverseDirection;
    public ScrollableState scrollableState;
    public byte latestScrollSource = 1;
    public ScrollScope outerStateScope = ScrollableKt.NoOpScrollScope;
    public final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new ScrollingLogic$nestedScrollScope$1(this);
    public final ScrollingLogic$$ExternalSyntheticLambda0 performScrollForOverscroll = new ScrollingLogic$$ExternalSyntheticLambda0(this);

    public ScrollingLogic(ScrollableState scrollableState, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, NestedScrollDispatcher nestedScrollDispatcher, ScrollableNode scrollableNode, ScrollableNode$$ExternalSyntheticLambda0 scrollableNode$$ExternalSyntheticLambda0) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.onScrollChangedDispatcher = scrollableNode;
        this.isScrollableNodeAttached = scrollableNode$$ExternalSyntheticLambda0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    public final Object m101doFlingAnimationQWom1Mo(long j, ContinuationImpl continuationImpl) throws Throwable {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        ScrollingLogic scrollingLogic;
        Throwable th;
        Ref$LongRef ref$LongRef;
        if (continuationImpl instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuationImpl;
            int i = scrollingLogic$doFlingAnimation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuationImpl);
            }
        } else {
            scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuationImpl);
        }
        Object obj = scrollingLogic$doFlingAnimation$1.result;
        int i2 = scrollingLogic$doFlingAnimation$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$LongRef = scrollingLogic$doFlingAnimation$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                scrollingLogic = this;
                scrollingLogic.isFlinging = false;
                return new Velocity(ref$LongRef.element);
            } catch (Throwable th2) {
                th = th2;
                scrollingLogic = this;
                scrollingLogic.isFlinging = false;
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.element = j;
        this.isFlinging = true;
        try {
            MutatePriority mutatePriority = MutatePriority.Default;
            scrollingLogic = this;
            try {
                ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(scrollingLogic, ref$LongRef2, j, null);
                scrollingLogic$doFlingAnimation$1.L$0 = ref$LongRef2;
                scrollingLogic$doFlingAnimation$1.label = 1;
                Object objScroll = scrollingLogic.scroll(mutatePriority, scrollingLogic$doFlingAnimation$2, scrollingLogic$doFlingAnimation$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objScroll == coroutineSingletons) {
                    return coroutineSingletons;
                }
                ref$LongRef = ref$LongRef2;
                scrollingLogic.isFlinging = false;
                return new Velocity(ref$LongRef.element);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                scrollingLogic.isFlinging = false;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            scrollingLogic = this;
        }
    }

    public final boolean getShouldDispatchOverscroll() {
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward() || ((androidEdgeEffectOverscrollEffect = this.overscrollEffect) != null && androidEdgeEffectOverscrollEffect.isInProgress());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0035  */
    /* JADX WARN: Code duplicated, block: B:21:0x0042 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x000d  */
    /* JADX WARN: Code duplicated, block: B:9:0x0014  */
    /* JADX INFO: renamed from: onScrollStopped-BMRW4eQ, reason: not valid java name */
    public final Object m102onScrollStoppedBMRW4eQ(long j, boolean z, SuspendLambda suspendLambda) {
        int i;
        long jM818copyOhffZ5M$default;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        CoroutineSingletons coroutineSingletons;
        Object objInvokeSuspend;
        Unit unit = Unit.INSTANCE;
        if (z) {
            FlingBehavior flingBehavior = this.flingBehavior;
            BorderKt$$ExternalSyntheticLambda1 borderKt$$ExternalSyntheticLambda1 = AbstractScrollableNodeKt.CanDragCalculation;
            if (!(flingBehavior instanceof DefaultFlingBehavior)) {
                if (this.orientation == Orientation.Horizontal) {
                    i = 1;
                } else {
                    i = 2;
                }
                jM818copyOhffZ5M$default = Velocity.m818copyOhffZ5M$default(j, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, i);
                ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
                androidEdgeEffectOverscrollEffect = this.overscrollEffect;
                coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (androidEdgeEffectOverscrollEffect == null && getShouldDispatchOverscroll()) {
                    Object objM30applyToFlingBMRW4eQ = androidEdgeEffectOverscrollEffect.m30applyToFlingBMRW4eQ(jM818copyOhffZ5M$default, scrollingLogic$onScrollStopped$performFling$1, suspendLambda);
                    if (objM30applyToFlingBMRW4eQ == coroutineSingletons) {
                        return objM30applyToFlingBMRW4eQ;
                    }
                } else {
                    ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$2 = new ScrollingLogic$onScrollStopped$performFling$1(this, suspendLambda);
                    scrollingLogic$onScrollStopped$performFling$2.J$0 = jM818copyOhffZ5M$default;
                    objInvokeSuspend = scrollingLogic$onScrollStopped$performFling$2.invokeSuspend(unit);
                    if (objInvokeSuspend == coroutineSingletons) {
                        return objInvokeSuspend;
                    }
                }
            }
        } else {
            if (this.orientation == Orientation.Horizontal) {
                i = 1;
            } else {
                i = 2;
            }
            jM818copyOhffZ5M$default = Velocity.m818copyOhffZ5M$default(j, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, i);
            ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$3 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
            androidEdgeEffectOverscrollEffect = this.overscrollEffect;
            coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (androidEdgeEffectOverscrollEffect == null) {
                ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$4 = new ScrollingLogic$onScrollStopped$performFling$1(this, suspendLambda);
                scrollingLogic$onScrollStopped$performFling$4.J$0 = jM818copyOhffZ5M$default;
                objInvokeSuspend = scrollingLogic$onScrollStopped$performFling$4.invokeSuspend(unit);
                if (objInvokeSuspend == coroutineSingletons) {
                    return objInvokeSuspend;
                }
            } else {
                ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$5 = new ScrollingLogic$onScrollStopped$performFling$1(this, suspendLambda);
                scrollingLogic$onScrollStopped$performFling$5.J$0 = jM818copyOhffZ5M$default;
                objInvokeSuspend = scrollingLogic$onScrollStopped$performFling$5.invokeSuspend(unit);
                if (objInvokeSuspend == coroutineSingletons) {
                    return objInvokeSuspend;
                }
            }
        }
        return unit;
    }

    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m103performScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        NestedScrollNode nestedScrollNode = this.nestedScrollDispatcher.nestedScrollNode;
        NestedScrollNode parentNestedScrollNode$ui = nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
        long jMo178onPreScrollOzD1aCk = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.mo178onPreScrollOzD1aCk(i, j) : 0L;
        long jM438minusMKHz9U = Offset.m438minusMKHz9U(j, jMo178onPreScrollOzD1aCk);
        long jM104reverseIfNeededMKHz9U = m104reverseIfNeededMKHz9U(m106toOffsettuRUvjQ(scrollScope.scrollBy(m105toFloatk4lQ0M(m104reverseIfNeededMKHz9U(this.orientation == Orientation.Horizontal ? Offset.m433copydBAh8RU$default(jM438minusMKHz9U, CropImageView.DEFAULT_ASPECT_RATIO, 1) : Offset.m433copydBAh8RU$default(jM438minusMKHz9U, CropImageView.DEFAULT_ASPECT_RATIO, 2))))));
        ScrollableNode scrollableNode = this.onScrollChangedDispatcher;
        if (scrollableNode.isAttached) {
            ViewTreeObserver viewTreeObserver = ((AndroidComposeView) HitTestResultKt.requireOwner(scrollableNode)).getViewTreeObserver();
            try {
                Method declaredMethod = AndroidComposeView.dispatchOnScrollChangedMethod;
                if (declaredMethod == null) {
                    declaredMethod = viewTreeObserver.getClass().getDeclaredMethod("dispatchOnScrollChanged", null);
                    declaredMethod.setAccessible(true);
                    AndroidComposeView.dispatchOnScrollChangedMethod = declaredMethod;
                }
                declaredMethod.invoke(viewTreeObserver, null);
            } catch (Exception unused) {
            }
        }
        long jM438minusMKHz9U2 = Offset.m438minusMKHz9U(jM438minusMKHz9U, jM104reverseIfNeededMKHz9U);
        NestedScrollNode nestedScrollNode2 = this.nestedScrollDispatcher.nestedScrollNode;
        NestedScrollNode parentNestedScrollNode$ui2 = nestedScrollNode2 != null ? nestedScrollNode2.getParentNestedScrollNode$ui() : null;
        return Offset.m439plusMKHz9U(Offset.m439plusMKHz9U(jMo178onPreScrollOzD1aCk, jM104reverseIfNeededMKHz9U), parentNestedScrollNode$ui2 != null ? parentNestedScrollNode$ui2.mo100onPostScrollDzOQY0M(i, jM104reverseIfNeededMKHz9U, jM438minusMKHz9U2) : 0L);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1.0f) : f;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m104reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m440timestuRUvjQ(j, -1.0f) : j;
    }

    public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, new RealImageLoader.AnonymousClass2(this, function2, null, (byte) 13), continuationImpl);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m105toFloatk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m106toOffsettuRUvjQ(float f) {
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            return 0L;
        }
        if (this.orientation == Orientation.Horizontal) {
            return (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L);
        }
        return (((long) Float.floatToRawIntBits(f)) & 4294967295L) | (Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO) << 32);
    }
}
