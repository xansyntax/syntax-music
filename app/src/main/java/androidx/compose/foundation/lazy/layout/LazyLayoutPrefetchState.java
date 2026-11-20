package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Latch;
import androidx.compose.ui.unit.Constraints;
import androidx.emoji2.text.EmojiProcessor;
import androidx.tracing.TraceApi29Impl;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPrefetchState {
    public int lastNumberOfNestedPrefetchItems;
    public final Function1 onNestedPrefetch;
    public Latch prefetchHandleProvider;
    public final EmojiProcessor prefetchMetrics = new EmojiProcessor((byte) 3);
    public int realizedNestedPrefetchCount = -1;
    public int idealNestedPrefetchCount = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NestedPrefetchScopeImpl {
        public final ArrayList _requests = new ArrayList();
        public final int nestedPrefetchItemCount;

        public NestedPrefetchScopeImpl(int i) {
            this.nestedPrefetchItemCount = i;
        }

        public final void schedulePrecomposition(int i) {
            LazyLayoutPrefetchState lazyLayoutPrefetchState = LazyLayoutPrefetchState.this;
            Latch latch = lazyLayoutPrefetchState.prefetchHandleProvider;
            if (latch == null) {
                return;
            }
            this._requests.add(new PrefetchHandleProvider$HandleAndRequestImpl(latch, i, lazyLayoutPrefetchState.prefetchMetrics, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface PrefetchHandle {
        void cancel();

        void markAsUrgent();
    }

    public LazyLayoutPrefetchState(Function1 function1) {
        this.onNestedPrefetch = function1;
    }

    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-_EkL_-Y$foundation, reason: not valid java name */
    public final PrefetchHandle m177schedulePrecompositionAndPremeasure_EkL_Y$foundation(int i, long j, boolean z, Function1 function1) {
        Latch latch = this.prefetchHandleProvider;
        if (latch == null) {
            return DummyHandle.INSTANCE;
        }
        PrefetchScheduler prefetchScheduler = (PrefetchScheduler) latch.spareList;
        boolean z2 = prefetchScheduler instanceof AndroidPrefetchScheduler;
        PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl = new PrefetchHandleProvider$HandleAndRequestImpl(latch, i, this.prefetchMetrics, function1);
        prefetchHandleProvider$HandleAndRequestImpl.premeasureConstraints = new Constraints(j);
        if (!z2) {
            prefetchScheduler.schedulePrefetch(prefetchHandleProvider$HandleAndRequestImpl);
        } else if (z) {
            AndroidPrefetchScheduler androidPrefetchScheduler = (AndroidPrefetchScheduler) prefetchScheduler;
            androidPrefetchScheduler.prefetchRequests.add(new PriorityTask(1, prefetchHandleProvider$HandleAndRequestImpl));
            if (!androidPrefetchScheduler.prefetchScheduled) {
                androidPrefetchScheduler.prefetchScheduled = true;
                androidPrefetchScheduler.view.post(androidPrefetchScheduler);
            }
        } else {
            AndroidPrefetchScheduler androidPrefetchScheduler2 = (AndroidPrefetchScheduler) prefetchScheduler;
            androidPrefetchScheduler2.prefetchRequests.add(new PriorityTask(0, prefetchHandleProvider$HandleAndRequestImpl));
            if (!androidPrefetchScheduler2.prefetchScheduled) {
                androidPrefetchScheduler2.prefetchScheduled = true;
                androidPrefetchScheduler2.view.post(androidPrefetchScheduler2);
            }
        }
        TraceApi29Impl.traceValue(i, "compose:lazy:schedule_prefetch:index");
        return prefetchHandleProvider$HandleAndRequestImpl;
    }
}
