package androidx.compose.foundation.lazy.grid;

import androidx.collection.internal.Lock;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyListScrollPosition;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListState$scrollToItem$2;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.pager.PagerState$remeasurementModifier$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.provider.CallbackWrapper;
import com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda3;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridState implements ScrollableState {
    public static final CallbackWrapper Saver = SaverKt.listSaver(new ScrollState$$ExternalSyntheticLambda3(5), new OffsetKt$$ExternalSyntheticLambda0(17));
    public final WeakCache _lazyLayoutScrollDeltaBetweenPasses;
    public LazyGridMeasureResult approachLayoutInfo;
    public final ParcelableSnapshotMutableState canScrollBackward$delegate;
    public final ParcelableSnapshotMutableState canScrollForward$delegate;
    public boolean hasLookaheadOccurred;
    public final SynchronizedLazyImpl prefetchScope$delegate;
    public LayoutNode remeasurement;
    public final PagerState$remeasurementModifier$1 remeasurementModifier;
    public final LazyListScrollPosition scrollPosition;
    public float scrollToBeConsumed;
    public final ParcelableSnapshotMutableState layoutInfoState = new ParcelableSnapshotMutableState(LazyGridStateKt.EmptyLazyGridLayoutInfo, NeverEqualPolicy.INSTANCE);
    public final MutableInteractionSourceImpl internalInteractionSource = new MutableInteractionSourceImpl();
    public final DefaultScrollableState scrollableState = new DefaultScrollableState(new ScrollState$$ExternalSyntheticLambda0(16, this));
    public final boolean prefetchingEnabled = true;
    public final AwaitFirstLayoutModifier awaitLayoutModifier = new AwaitFirstLayoutModifier();
    public final LazyLayoutItemAnimator itemAnimator = new LazyLayoutItemAnimator();
    public final LazyLayoutBeyondBoundsInfo beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo((byte) 0);
    public final LazyLayoutPinnedItemList pinnedItems = new LazyLayoutPinnedItemList();
    public final MutableState placementScopeInvalidator = LazyLayoutKt.m175constructorimpl$default();
    public final MutableState measurementScopeInvalidator = LazyLayoutKt.m175constructorimpl$default();

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public MutatePriority L$0;
        public SuspendLambda L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyGridState.this.scroll(null, null, this);
        }
    }

    public LazyGridState(int i, int i2) {
        this.scrollPosition = new LazyListScrollPosition(i, i2, (byte) 1);
        byte b = 2;
        this.remeasurementModifier = new PagerState$remeasurementModifier$1(this, b);
        this.prefetchScope$delegate = new SynchronizedLazyImpl(new ThumbnailKt$$ExternalSyntheticLambda3(this, b));
        Boolean bool = Boolean.FALSE;
        this.canScrollForward$delegate = Stack.mutableStateOf$default(bool);
        this.canScrollBackward$delegate = Stack.mutableStateOf$default(bool);
        this._lazyLayoutScrollDeltaBetweenPasses = new WeakCache((byte) 4);
    }

    public static Object animateScrollToItem$default(LazyGridState lazyGridState, int i, SuspendLambda suspendLambda) {
        lazyGridState.getClass();
        Object objScroll = lazyGridState.scroll(MutatePriority.Default, new LazyListState.AnonymousClass2((ScrollableState) lazyGridState, i, (Continuation) null, (byte) 1), suspendLambda);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }

    public static Object scrollToItem$default(LazyGridState lazyGridState, int i, SuspendLambda suspendLambda) {
        lazyGridState.getClass();
        Object objScroll = lazyGridState.scroll(MutatePriority.Default, new LazyListState$scrollToItem$2(lazyGridState, i, null, (byte) 1), suspendLambda);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00df  */
    public final void applyMeasureResult$foundation(LazyGridMeasureResult lazyGridMeasureResult, boolean z, boolean z2) {
        Object obj;
        LazyLayoutPrefetchState lazyLayoutPrefetchState = lazyGridMeasureResult.prefetchState;
        LazyGridMeasuredLine lazyGridMeasuredLine = lazyGridMeasureResult.firstVisibleLine;
        int i = lazyGridMeasureResult.firstVisibleLineScrollOffset;
        if (lazyLayoutPrefetchState != null) {
            lazyLayoutPrefetchState.idealNestedPrefetchCount = lazyGridMeasureResult.visibleItemsInfo.size();
        }
        int i2 = 0;
        LazyListScrollPosition lazyListScrollPosition = this.scrollPosition;
        WeakCache weakCache = this._lazyLayoutScrollDeltaBetweenPasses;
        LazyGridMeasuredItem lazyGridMeasuredItem = null;
        boolean z3 = true;
        if (!z && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = lazyGridMeasureResult;
            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                if (((Number) ((AnimationState) weakCache.referenceQueue).value$delegate.getValue()).floatValue() != CropImageView.DEFAULT_ASPECT_RATIO) {
                    z3 = false;
                }
                if (!z3 && i == lazyListScrollPosition.scrollOffset$delegate.getIntValue() && lazyGridMeasuredLine != null) {
                    LazyGridMeasuredItem[] lazyGridMeasuredItemArr = lazyGridMeasuredLine.items;
                    if (lazyGridMeasuredItemArr.length != 0) {
                        lazyGridMeasuredItem = lazyGridMeasuredItemArr[0];
                    }
                    if (lazyGridMeasuredItem != null && lazyGridMeasuredItem.index == lazyListScrollPosition.index$delegate.getIntValue()) {
                        weakCache.stop$foundation();
                    }
                }
                return;
            } finally {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }
        if (z) {
            LazyGridCacheWindowPrefetchStrategy prefetchStrategy = getPrefetchStrategy();
            if (!(prefetchStrategy instanceof LazyGridCacheWindowPrefetchStrategy)) {
                prefetchStrategy = null;
            }
            if (prefetchStrategy != null) {
                prefetchStrategy.setHasLookaheadOccurred();
            }
            this.hasLookaheadOccurred = true;
        }
        this.scrollToBeConsumed -= lazyGridMeasureResult.consumedScroll;
        this.layoutInfoState.setValue(lazyGridMeasureResult);
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(((lazyGridMeasuredLine != null ? lazyGridMeasuredLine.index : 0) == 0 && i == 0) ? false : true));
        this.canScrollForward$delegate.setValue(Boolean.valueOf(lazyGridMeasureResult.canScrollForward));
        if (z2) {
            lazyListScrollPosition.getClass();
            if (i < CropImageView.DEFAULT_ASPECT_RATIO) {
                InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
            }
            lazyListScrollPosition.scrollOffset$delegate.setIntValue(i);
        } else {
            lazyListScrollPosition.getClass();
            if (lazyGridMeasuredLine != null) {
                LazyGridMeasuredItem[] lazyGridMeasuredItemArr2 = lazyGridMeasuredLine.items;
                LazyGridMeasuredItem lazyGridMeasuredItem2 = lazyGridMeasuredItemArr2.length == 0 ? null : lazyGridMeasuredItemArr2[0];
                if (lazyGridMeasuredItem2 != null) {
                    obj = lazyGridMeasuredItem2.key;
                } else {
                    obj = null;
                }
            } else {
                obj = null;
            }
            lazyListScrollPosition.lastKnownFirstItemKey = obj;
            if (lazyListScrollPosition.hadFirstNotEmptyLayout || lazyGridMeasureResult.totalItemsCount > 0) {
                lazyListScrollPosition.hadFirstNotEmptyLayout = true;
                if (i < CropImageView.DEFAULT_ASPECT_RATIO) {
                    InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative (" + i + ")");
                }
                if (lazyGridMeasuredLine != null) {
                    LazyGridMeasuredItem[] lazyGridMeasuredItemArr3 = lazyGridMeasuredLine.items;
                    lazyGridMeasuredItem = lazyGridMeasuredItemArr3.length != 0 ? lazyGridMeasuredItemArr3[0] : null;
                    if (lazyGridMeasuredItem != null) {
                        i2 = lazyGridMeasuredItem.index;
                    }
                }
                lazyListScrollPosition.update(i2, i);
            }
            LazyGridCacheWindowPrefetchStrategy prefetchStrategy2 = getPrefetchStrategy();
            if (prefetchStrategy2 != null && this.prefetchingEnabled) {
                LazyGridState$prefetchScope$2$1 lazyGridState$prefetchScope$2$1 = (LazyGridState$prefetchScope$2$1) this.prefetchScope$delegate.getValue();
                WeakCache weakCache2 = prefetchStrategy2.cacheWindowScope;
                weakCache2.values = lazyGridMeasureResult;
                weakCache2.referenceQueue = lazyGridState$prefetchScope$2$1;
                prefetchStrategy2.$$delegate_0.onVisibleItemsUpdated(weakCache2);
            }
        }
        if (z) {
            weakCache.updateScrollDeltaForApproach$foundation(lazyGridMeasureResult.scrollBackAmount, lazyGridMeasureResult.density, lazyGridMeasureResult.coroutineScope);
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.index$delegate.getIntValue();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.scrollOffset$delegate.getIntValue();
    }

    public final LazyGridMeasureResult getLayoutInfo() {
        return (LazyGridMeasureResult) this.layoutInfoState.getValue();
    }

    public final LazyGridCacheWindowPrefetchStrategy getPrefetchStrategy() {
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            LazyGridCacheWindowPrefetchStrategy lazyGridCacheWindowPrefetchStrategy = ((LazyGridMeasureResult) this.layoutInfoState.getValue()).prefetchStrategy;
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            if (lazyGridCacheWindowPrefetchStrategy == null) {
                return null;
            }
            return lazyGridCacheWindowPrefetchStrategy;
        } catch (Throwable th) {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
    
        if (r6.scrollableState.scroll(r7, r8, r0) == r5) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Function2 function3;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.layoutInfoState.getValue() == LazyGridStateKt.EmptyLazyGridLayoutInfo) {
                anonymousClass1.L$0 = mutatePriority;
                anonymousClass1.L$1 = (SuspendLambda) function2;
                anonymousClass1.label = 1;
                if (this.awaitLayoutModifier.waitForFirstLayout(anonymousClass1) != obj2) {
                }
            }
            function3 = function2;
            function3 = function2;
            return obj2;
        }
        if (i2 == 1) {
            Function2 function4 = (Function2) anonymousClass1.L$1;
            mutatePriority = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            function3 = function4;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        function3 = function2;
        function3 = function2;
        function3 = function2;
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
    }

    public final void snapToItemIndexInternal$foundation(int i, boolean z, int i2) {
        LazyListScrollPosition lazyListScrollPosition = this.scrollPosition;
        if (lazyListScrollPosition.index$delegate.getIntValue() != i || lazyListScrollPosition.scrollOffset$delegate.getIntValue() != 0) {
            LazyLayoutItemAnimator lazyLayoutItemAnimator = this.itemAnimator;
            lazyLayoutItemAnimator.releaseAnimations();
            lazyLayoutItemAnimator.keyIndexMap = null;
            lazyLayoutItemAnimator.firstVisibleIndex = -1;
            LazyGridCacheWindowPrefetchStrategy prefetchStrategy = getPrefetchStrategy();
            LazyGridCacheWindowPrefetchStrategy lazyGridCacheWindowPrefetchStrategy = prefetchStrategy instanceof CacheWindowLogic ? prefetchStrategy : null;
            if (lazyGridCacheWindowPrefetchStrategy != null) {
                lazyGridCacheWindowPrefetchStrategy.resetStrategy();
            }
        }
        lazyListScrollPosition.update(i, 0);
        lazyListScrollPosition.lastKnownFirstItemKey = null;
        LayoutNode layoutNode = this.remeasurement;
        if (layoutNode != null) {
            layoutNode.forceRemeasure();
        }
    }
}
