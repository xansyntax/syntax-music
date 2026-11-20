package androidx.compose.material3.carousel;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.core.provider.CallbackWrapper;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CarouselState implements ScrollableState {
    public static final CallbackWrapper Saver = SaverKt.listSaver(new ScrollState$$ExternalSyntheticLambda3(23), new TextKt$$ExternalSyntheticLambda0((byte) 18));
    public final CarouselPagerState pagerState;

    public CarouselState(int i, float f, Function0 function0) {
        this.pagerState = new CarouselPagerState(i, f, function0);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return this.pagerState.scrollableState.dispatchRawDelta(f);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.pagerState.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        Object objScroll$suspendImpl = PagerState.scroll$suspendImpl(this.pagerState, mutatePriority, function2, continuationImpl);
        return objScroll$suspendImpl == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll$suspendImpl : Unit.INSTANCE;
    }
}
