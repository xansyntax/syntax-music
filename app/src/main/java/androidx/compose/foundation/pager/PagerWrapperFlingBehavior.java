package androidx.compose.foundation.pager;

import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PagerWrapperFlingBehavior implements FlingBehavior {
    public final SnapFlingBehavior originalFlingBehavior;
    public final PagerState pagerState;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerWrapperFlingBehavior.this.performFling(null, CropImageView.DEFAULT_ASPECT_RATIO, this);
        }
    }

    public PagerWrapperFlingBehavior(SnapFlingBehavior snapFlingBehavior, PagerState pagerState) {
        this.originalFlingBehavior = snapFlingBehavior;
        this.pagerState = pagerState;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
        }
        Object objPerformFling = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objPerformFling);
            ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0 = new ScrollState$$ExternalSyntheticLambda0(this, scrollScope, (byte) 20);
            anonymousClass1.label = 1;
            objPerformFling = this.originalFlingBehavior.performFling(scrollScope, f, scrollState$$ExternalSyntheticLambda0, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objPerformFling == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objPerformFling);
        }
        float fFloatValue = ((Number) objPerformFling).floatValue();
        PagerState pagerState = this.pagerState;
        if (pagerState.getCurrentPageOffsetFraction() != CropImageView.DEFAULT_ASPECT_RATIO && Math.abs(pagerState.getCurrentPageOffsetFraction()) < 0.001d) {
            int currentPage = pagerState.getCurrentPage();
            if (pagerState.scrollableState.isScrollInProgress()) {
                AwaitKt.launch$default(((PagerMeasureResult) pagerState.pagerLayoutInfoState.getValue()).coroutineScope, null, null, new PagerState$requestScrollToPage$1(pagerState, null, (byte) 0), 3);
            }
            pagerState.snapToItem$foundation(currentPage, CropImageView.DEFAULT_ASPECT_RATIO, false);
        } else {
            new Float(pagerState.getCurrentPageOffsetFraction());
        }
        return new Float(fFloatValue);
    }
}
