package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.NestedPrefetchScopeImpl;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.runtime.Latch;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.unit.Constraints;
import androidx.core.provider.CallbackWrapper;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.extractor.PositionHolder;
import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import androidx.tracing.TraceApi29Impl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.Duration;
import kotlin.time.MonotonicTimeSource;
import kotlin.time.TimeSource$Monotonic$ValueTimeMark;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PrefetchHandleProvider$HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle {
    public long availableTimeNanos;
    public long elapsedTimeNanos;
    public boolean hasResolvedNestedPrefetches;
    public final int index;
    public boolean isApplied;
    public boolean isCanceled;
    public boolean isMeasured;
    public boolean isUrgent;
    public Object keyUsedForComposition;
    public NestedPrefetchController nestedPrefetchController;
    public final Function1 onItemPremeasured;
    public boolean pauseRequested;
    public SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition;
    public SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
    public final EmojiProcessor prefetchMetrics;
    public Constraints premeasureConstraints;
    public long startTime = MonotonicTimeSource.read();
    public final /* synthetic */ Latch this$0;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NestedPrefetchController {
        public boolean executedNestedPrefetch;
        public int requestIndex;
        public final List[] requestsByState;
        public int stateIndex;
        public final List states;

        public NestedPrefetchController(List list) {
            this.states = list;
            this.requestsByState = new List[list.size()];
            if (list.isEmpty()) {
                InlineClassHelperKt.throwIllegalArgumentException("NestedPrefetchController shouldn't be created with no states");
            }
        }
    }

    public PrefetchHandleProvider$HandleAndRequestImpl(Latch latch, int i, EmojiProcessor emojiProcessor, Function1 function1) {
        this.this$0 = latch;
        this.index = i;
        this.prefetchMetrics = emojiProcessor;
        this.onItemPremeasured = function1;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
    public final void cancel() {
        if (this.isCanceled) {
            return;
        }
        this.isCanceled = true;
        cleanUp();
    }

    public final void cleanUp() {
        SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
        if (pausedPrecomposition != null) {
            pausedPrecomposition.cancel();
        }
        this.pausedPrecomposition = null;
        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
        if (precomposedSlotHandle != null) {
            precomposedSlotHandle.dispose();
        }
        this.precomposeHandle = null;
        this.nestedPrefetchController = null;
    }

    public final boolean execute(PositionHolder positionHolder) {
        boolean zExecuteRequest;
        if (!this.this$0._isOpen) {
            return false;
        }
        if (this.isUrgent) {
            Trace.beginSection("compose:lazy:prefetch:execute:urgent");
            try {
                zExecuteRequest = executeRequest(positionHolder);
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            zExecuteRequest = executeRequest(positionHolder);
        }
        TraceApi29Impl.traceValue(-1L, "compose:lazy:prefetch:execute:item");
        return zExecuteRequest;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01d1  */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    public final boolean executeRequest(PositionHolder positionHolder) {
        ?? r12;
        int i = this.index;
        long j = i;
        TraceApi29Impl.traceValue(j, "compose:lazy:prefetch:execute:item");
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) ((LazyLayoutItemContentFactory) this.this$0.lock).itemProvider.invoke();
        if (!this.isCanceled) {
            int itemCount = lazyLayoutItemProvider.getItemCount();
            if (i >= 0 && i < itemCount) {
                Object key = lazyLayoutItemProvider.getKey(i);
                Object obj = this.keyUsedForComposition;
                if (obj != null && !key.equals(obj)) {
                    cleanUp();
                    return false;
                }
                Object contentType = lazyLayoutItemProvider.getContentType(i);
                EmojiProcessor emojiProcessor = this.prefetchMetrics;
                Averages averages = (Averages) emojiProcessor.mGlyphChecker;
                if (emojiProcessor.mMetadataRepo != contentType || averages == null) {
                    MutableScatterMap mutableScatterMap = (MutableScatterMap) emojiProcessor.mSpanFactory;
                    Object obj2 = mutableScatterMap.get(contentType);
                    Object obj3 = obj2;
                    if (obj2 == null) {
                        Averages averages2 = new Averages();
                        averages2.nestedPrefetchCount = -1;
                        mutableScatterMap.set(contentType, averages2);
                        obj3 = averages2;
                    }
                    averages = (Averages) obj3;
                    emojiProcessor.mMetadataRepo = contentType;
                    emojiProcessor.mGlyphChecker = averages;
                }
                isComposed();
                long jAvailableTimeNanos = positionHolder.availableTimeNanos();
                this.availableTimeNanos = jAvailableTimeNanos;
                this.startTime = MonotonicTimeSource.read();
                this.elapsedTimeNanos = 0L;
                TraceApi29Impl.traceValue(jAvailableTimeNanos, "compose:lazy:prefetch:available_time_nanos");
                if (!isComposed()) {
                    if (shouldExecute(this.availableTimeNanos, averages.resumeTimeNanos + averages.pauseTimeNanos)) {
                        Trace.beginSection("compose:lazy:prefetch:compose");
                        try {
                            performPausableComposition(key, contentType, averages);
                            Trace.endSection();
                        } catch (Throwable th) {
                            Trace.endSection();
                            throw th;
                        }
                    }
                    if (!isComposed()) {
                        return true;
                    }
                }
                if (this.pausedPrecomposition != null) {
                    if (!shouldExecute(this.availableTimeNanos, averages.applyTimeNanos)) {
                        return true;
                    }
                    Trace.beginSection("compose:lazy:prefetch:apply");
                    try {
                        SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
                        if (pausedPrecomposition == null) {
                            throw new IllegalArgumentException("Nothing to apply!");
                        }
                        this.precomposeHandle = pausedPrecomposition.apply();
                        this.pausedPrecomposition = null;
                        this.isApplied = true;
                        Trace.endSection();
                        updateElapsedAndAvailableTime();
                        averages.applyTimeNanos = Averages.calculateAverageTime(this.elapsedTimeNanos, averages.applyTimeNanos);
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
                if (!this.hasResolvedNestedPrefetches) {
                    if (this.availableTimeNanos <= r13) {
                        return true;
                    }
                    Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                    try {
                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
                        if (precomposedSlotHandle == null) {
                            throw Fragment$5$$ExternalSyntheticOutline0.m("Should precompose before resolving nested prefetch states");
                        }
                        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        precomposedSlotHandle.traverseDescendants(new NavGraphNavigator$$ExternalSyntheticLambda0(ref$ObjectRef, (byte) 2));
                        List list = (List) ref$ObjectRef.element;
                        this.nestedPrefetchController = list != null ? new NestedPrefetchController(list) : null;
                        this.hasResolvedNestedPrefetches = true;
                        Trace.endSection();
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
                NestedPrefetchController nestedPrefetchController = this.nestedPrefetchController;
                if (nestedPrefetchController != null) {
                    int i2 = averages.nestedPrefetchCount;
                    boolean z = this.isUrgent;
                    List[] listArr = nestedPrefetchController.requestsByState;
                    int i3 = nestedPrefetchController.stateIndex;
                    List list2 = nestedPrefetchController.states;
                    if (i3 < list2.size()) {
                        if (PrefetchHandleProvider$HandleAndRequestImpl.this.isCanceled) {
                            InlineClassHelperKt.throwIllegalStateException("Should not execute nested prefetch on canceled request");
                        }
                        Trace.beginSection("compose:lazy:prefetch:update_nested_prefetch_count");
                        try {
                            int size = list2.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                ((LazyLayoutPrefetchState) list2.get(i4)).realizedNestedPrefetchCount = i2;
                            }
                            Trace.endSection();
                            Trace.beginSection("compose:lazy:prefetch:nested");
                            while (nestedPrefetchController.stateIndex < list2.size()) {
                                try {
                                    if (listArr[nestedPrefetchController.stateIndex] == null) {
                                        if (positionHolder.availableTimeNanos() <= r13) {
                                            Trace.endSection();
                                            return true;
                                        }
                                        int i5 = nestedPrefetchController.stateIndex;
                                        LazyLayoutPrefetchState lazyLayoutPrefetchState = (LazyLayoutPrefetchState) list2.get(i5);
                                        Function1 function1 = lazyLayoutPrefetchState.onNestedPrefetch;
                                        LazyLayoutPrefetchState.NestedPrefetchScopeImpl nestedPrefetchScopeImpl = lazyLayoutPrefetchState.new NestedPrefetchScopeImpl(lazyLayoutPrefetchState.realizedNestedPrefetchCount);
                                        function1.invoke(nestedPrefetchScopeImpl);
                                        ArrayList arrayList = nestedPrefetchScopeImpl._requests;
                                        lazyLayoutPrefetchState.lastNumberOfNestedPrefetchItems = arrayList.size();
                                        listArr[i5] = arrayList;
                                    }
                                    List list3 = listArr[nestedPrefetchController.stateIndex];
                                    list3.getClass();
                                    while (nestedPrefetchController.requestIndex < list3.size()) {
                                        PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl = (PrefetchHandleProvider$HandleAndRequestImpl) list3.get(nestedPrefetchController.requestIndex);
                                        if (z) {
                                            PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl2 = prefetchHandleProvider$HandleAndRequestImpl != null ? prefetchHandleProvider$HandleAndRequestImpl : null;
                                            if (prefetchHandleProvider$HandleAndRequestImpl2 != null) {
                                                r12 = 1;
                                                prefetchHandleProvider$HandleAndRequestImpl2.isUrgent = true;
                                            } else {
                                                r12 = 1;
                                            }
                                        } else {
                                            r12 = 1;
                                        }
                                        nestedPrefetchController.executedNestedPrefetch = r12;
                                        if (prefetchHandleProvider$HandleAndRequestImpl.execute(positionHolder)) {
                                            Trace.endSection();
                                            return r12;
                                        }
                                        nestedPrefetchController.requestIndex += r12;
                                    }
                                    nestedPrefetchController.requestIndex = 0;
                                    nestedPrefetchController.stateIndex++;
                                } catch (Throwable th4) {
                                    Trace.endSection();
                                    throw th4;
                                }
                            }
                            Trace.endSection();
                        } catch (Throwable th5) {
                            Trace.endSection();
                            throw th5;
                        }
                    }
                }
                NestedPrefetchController nestedPrefetchController2 = this.nestedPrefetchController;
                if (nestedPrefetchController2 != null && nestedPrefetchController2.executedNestedPrefetch) {
                    updateElapsedAndAvailableTime();
                    TraceApi29Impl.traceValue(j, "compose:lazy:prefetch:execute:item");
                    NestedPrefetchController nestedPrefetchController3 = this.nestedPrefetchController;
                    if (nestedPrefetchController3 != null) {
                        nestedPrefetchController3.executedNestedPrefetch = false;
                    }
                }
                Constraints constraints = this.premeasureConstraints;
                if (!this.isMeasured && constraints != null) {
                    if (!shouldExecute(this.availableTimeNanos, averages.measureTimeNanos)) {
                        return true;
                    }
                    Trace.beginSection("compose:lazy:prefetch:measure");
                    try {
                        long j2 = constraints.value;
                        if (this.isCanceled) {
                            InlineClassHelperKt.throwIllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()");
                        }
                        if (this.isMeasured) {
                            InlineClassHelperKt.throwIllegalArgumentException("Request was already measured!");
                        }
                        this.isMeasured = true;
                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle2 = this.precomposeHandle;
                        if (precomposedSlotHandle2 == null) {
                            throw Fragment$5$$ExternalSyntheticOutline0.m("performComposition() must be called before performMeasure()");
                        }
                        int placeablesCount = precomposedSlotHandle2.getPlaceablesCount();
                        for (int i6 = 0; i6 < placeablesCount; i6++) {
                            precomposedSlotHandle2.mo614premeasure0kLqBqw(i6, j2);
                        }
                        Trace.endSection();
                        updateElapsedAndAvailableTime();
                        averages.measureTimeNanos = Averages.calculateAverageTime(this.elapsedTimeNanos, averages.measureTimeNanos);
                        Function1 function2 = this.onItemPremeasured;
                        if (function2 != null) {
                            function2.invoke(this);
                        }
                    } catch (Throwable th6) {
                        Trace.endSection();
                        throw th6;
                    }
                }
                NestedPrefetchController nestedPrefetchController4 = this.nestedPrefetchController;
                if (this.isMeasured && this.hasResolvedNestedPrefetches && nestedPrefetchController4 != null) {
                    List list4 = nestedPrefetchController4.states;
                    int size2 = list4.size();
                    int iMin = Integer.MAX_VALUE;
                    for (int i7 = 0; i7 < size2; i7++) {
                        iMin = Math.min(iMin, ((LazyLayoutPrefetchState) list4.get(i7)).idealNestedPrefetchCount);
                    }
                    if (iMin == Integer.MAX_VALUE) {
                        iMin = 0;
                    }
                    int i8 = averages.nestedPrefetchCount;
                    averages.nestedPrefetchCount = i8 == -1 ? iMin : ((i8 * 3) + iMin) / 4;
                    int size3 = list4.size();
                    int iMin2 = Integer.MAX_VALUE;
                    for (int i9 = 0; i9 < size3; i9++) {
                        iMin2 = Math.min(iMin2, ((LazyLayoutPrefetchState) list4.get(i9)).lastNumberOfNestedPrefetchItems);
                    }
                    if (iMin2 == Integer.MAX_VALUE) {
                        iMin2 = 0;
                    }
                    if (iMin2 < iMin) {
                        averages.measureTimeNanos = 0L;
                    }
                }
                return false;
            }
        }
        cleanUp();
        return false;
    }

    public final boolean isComposed() {
        SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition;
        return this.isApplied || ((pausedPrecomposition = this.pausedPrecomposition) != null && pausedPrecomposition.isComplete());
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
    public final void markAsUrgent() {
        this.isUrgent = true;
    }

    public final void performPausableComposition(Object obj, Object obj2, Averages averages) {
        SubcomposeLayoutState.PausedPrecomposition callbackWrapper;
        SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
        byte b = 1;
        if (pausedPrecomposition == null) {
            Latch latch = this.this$0;
            Function2 content = ((LazyLayoutItemContentFactory) latch.lock).getContent(this.index, obj, obj2);
            LayoutNodeSubcompositionsState state = ((SubcomposeLayoutState) latch.awaiters).getState();
            byte b2 = 9;
            if (state.root.isAttached$1()) {
                state.precompose(obj, content, true);
                callbackWrapper = new CallbackWrapper(state, obj, b2);
            } else {
                callbackWrapper = new WeakCache(state, obj, b2);
            }
            pausedPrecomposition = callbackWrapper;
            this.pausedPrecomposition = pausedPrecomposition;
            this.keyUsedForComposition = obj;
        }
        this.pauseRequested = false;
        while (!pausedPrecomposition.isComplete() && !this.pauseRequested) {
            pausedPrecomposition.resume(new TextLinkScope$$ExternalSyntheticLambda10(this, averages, b));
        }
        updateElapsedAndAvailableTime();
        boolean z = this.pauseRequested;
        long j = this.elapsedTimeNanos;
        if (z) {
            averages.pauseTimeNanos = Averages.calculateAverageTime(j, averages.pauseTimeNanos);
        } else {
            averages.resumeTimeNanos = Averages.calculateAverageTime(j, averages.resumeTimeNanos);
        }
    }

    public final boolean shouldExecute(long j, long j2) {
        if (this.isUrgent) {
            j2 = 0;
        }
        return j > j2;
    }

    public final String toString() {
        Constraints constraints = this.premeasureConstraints;
        boolean zIsComposed = isComposed();
        boolean z = this.isMeasured;
        boolean z2 = this.isCanceled;
        StringBuilder sb = new StringBuilder("HandleAndRequestImpl { index = ");
        sb.append(this.index);
        sb.append(", constraints = ");
        sb.append(constraints);
        sb.append(", isComposed = ");
        Fragment$5$$ExternalSyntheticOutline0.m(sb, zIsComposed, ", isMeasured = ", z, ", isCanceled = ");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, z2, " }");
    }

    public final void updateElapsedAndAvailableTime() {
        long j = MonotonicTimeSource.read();
        long jM1895minus6eNON_k = TimeSource$Monotonic$ValueTimeMark.m1895minus6eNON_k(j, this.startTime);
        long j2 = jM1895minus6eNON_k >> 1;
        Path.Companion companion = Duration.Companion;
        if ((((int) jM1895minus6eNON_k) & 1) != 0) {
            if (j2 > 9223372036854L) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = j2 < -9223372036854L ? Long.MIN_VALUE : j2 * 1000000;
            }
        }
        this.elapsedTimeNanos = j2;
        long j3 = this.availableTimeNanos - j2;
        this.availableTimeNanos = j3;
        this.startTime = j;
        TraceApi29Impl.traceValue(j3, "compose:lazy:prefetch:available_time_nanos");
    }
}
