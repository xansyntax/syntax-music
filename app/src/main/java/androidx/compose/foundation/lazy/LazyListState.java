package androidx.compose.foundation.lazy;

import androidx.collection.internal.Lock;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.grid.LazyGridMeasureResult;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.pager.PagerScrollScopeKt$LazyLayoutScrollScope$1;
import androidx.compose.foundation.pager.PagerState$remeasurementModifier$1;
import androidx.compose.material3.SegmentedButtonContentMeasurePolicy;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.unit.Density;
import androidx.core.provider.CallbackWrapper;
import androidx.tracing.TraceApi29Impl;
import com.metrolist.music.recognition.RecognitionForegroundService;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListState implements ScrollableState {
    public static final CallbackWrapper Saver = SaverKt.listSaver(new ScrollState$$ExternalSyntheticLambda3(3), new OffsetKt$$ExternalSyntheticLambda0(14));
    public final WeakCache _lazyLayoutScrollDeltaBetweenPasses;
    public LazyListMeasureResult approachLayoutInfo;
    public final AwaitFirstLayoutModifier awaitLayoutModifier;
    public final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    public final ParcelableSnapshotMutableState canScrollBackward$delegate;
    public final ParcelableSnapshotMutableState canScrollForward$delegate;
    public boolean executeRequestsInHighPriorityMode;
    public boolean hasLookaheadOccurred;
    public final MutableInteractionSourceImpl internalInteractionSource;
    public final LazyLayoutItemAnimator itemAnimator;
    public final ParcelableSnapshotMutableState layoutInfoState;
    public final MutableState measurementScopeInvalidator;
    public final LazyLayoutPinnedItemList pinnedItems;
    public final MutableState placementScopeInvalidator;
    public final LazyListState$prefetchScope$1 prefetchScope;
    public final LazyLayoutPrefetchState prefetchState;
    public final DefaultLazyListPrefetchStrategy prefetchStrategy;
    public final boolean prefetchingEnabled;
    public LayoutNode remeasurement;
    public final PagerState$remeasurementModifier$1 remeasurementModifier;
    public final LazyListScrollPosition scrollPosition;
    public float scrollToBeConsumed;
    public final DefaultScrollableState scrollableState;
    public boolean skipItemPlacementAnimation;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyListState.this.animateScrollToItem(0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$scroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00281 extends ContinuationImpl {
        public MutatePriority L$0;
        public SuspendLambda L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00281(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyListState.this.scroll(null, null, this);
        }
    }

    public LazyListState(int i, int i2) {
        DefaultLazyListPrefetchStrategy defaultLazyListPrefetchStrategy = new DefaultLazyListPrefetchStrategy();
        defaultLazyListPrefetchStrategy.indexToPrefetch = -1;
        defaultLazyListPrefetchStrategy.previousPassItemCount = -1;
        this.prefetchStrategy = defaultLazyListPrefetchStrategy;
        this.scrollPosition = new LazyListScrollPosition(i, i2, (byte) 0);
        this.layoutInfoState = new ParcelableSnapshotMutableState(LazyListStateKt.EmptyLazyListMeasureResult, NeverEqualPolicy.INSTANCE);
        this.internalInteractionSource = new MutableInteractionSourceImpl();
        this.scrollableState = new DefaultScrollableState(new ScrollState$$ExternalSyntheticLambda0((byte) 14, this));
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new PagerState$remeasurementModifier$1(this, (byte) 1);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo((byte) 0);
        this.prefetchState = new LazyLayoutPrefetchState(new TimePickerKt$$ExternalSyntheticLambda36(this, i));
        this.prefetchScope = new LazyListState$prefetchScope$1(this);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        this.measurementScopeInvalidator = LazyLayoutKt.m175constructorimpl$default();
        Boolean bool = Boolean.FALSE;
        this.canScrollForward$delegate = Stack.mutableStateOf$default(bool);
        this.canScrollBackward$delegate = Stack.mutableStateOf$default(bool);
        this.placementScopeInvalidator = LazyLayoutKt.m175constructorimpl$default();
        this._lazyLayoutScrollDeltaBetweenPasses = new WeakCache((byte) 4);
    }

    public static Object scrollToItem$default(LazyListState lazyListState, int i, ContinuationImpl continuationImpl) {
        lazyListState.getClass();
        Object objScroll = lazyListState.scroll(MutatePriority.Default, new LazyListState$scrollToItem$2(lazyListState, i, null, (byte) 0), continuationImpl);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, kotlin.Unit] */
    public final Object animateScrollToItem(int i, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        Continuation continuation2 = null;
        byte b = 0;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                this.skipItemPlacementAnimation = true;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, i, continuation2, b);
                anonymousClass1.label = 1;
                Object objScroll = scroll(MutatePriority.Default, anonymousClass2, anonymousClass1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objScroll == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i3 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.skipItemPlacementAnimation = false;
            this = Unit.INSTANCE;
            return this;
        } catch (Throwable th) {
            this.skipItemPlacementAnimation = false;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void applyMeasureResult$foundation(LazyListMeasureResult lazyListMeasureResult, boolean z, boolean z2) {
        List list = lazyListMeasureResult.visibleItemsInfo;
        int i = lazyListMeasureResult.totalItemsCount;
        int i2 = lazyListMeasureResult.firstVisibleItemScrollOffset;
        LazyListMeasuredItem lazyListMeasuredItem = lazyListMeasureResult.firstVisibleItem;
        this.prefetchState.idealNestedPrefetchCount = list.size();
        WeakCache weakCache = this._lazyLayoutScrollDeltaBetweenPasses;
        LazyListScrollPosition lazyListScrollPosition = this.scrollPosition;
        if (!z && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = lazyListMeasureResult;
            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                if (!(((Number) ((AnimationState) weakCache.referenceQueue).value$delegate.getValue()).floatValue() == CropImageView.DEFAULT_ASPECT_RATIO) && lazyListMeasuredItem != null && lazyListMeasuredItem.index == lazyListScrollPosition.index$delegate.getIntValue() && i2 == lazyListScrollPosition.scrollOffset$delegate.getIntValue()) {
                    weakCache.stop$foundation();
                }
                return;
            } finally {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }
        DefaultLazyListPrefetchStrategy defaultLazyListPrefetchStrategy = this.prefetchStrategy;
        if (z) {
            CacheWindowLogic cacheWindowLogic = defaultLazyListPrefetchStrategy instanceof CacheWindowLogic ? (CacheWindowLogic) defaultLazyListPrefetchStrategy : null;
            if (cacheWindowLogic != null) {
                cacheWindowLogic.setHasLookaheadOccurred();
            }
            this.hasLookaheadOccurred = true;
        }
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(((lazyListMeasuredItem != null ? lazyListMeasuredItem.index : 0) == 0 && i2 == 0) ? false : true));
        this.canScrollForward$delegate.setValue(Boolean.valueOf(lazyListMeasureResult.canScrollForward));
        this.scrollToBeConsumed -= lazyListMeasureResult.consumedScroll;
        this.layoutInfoState.setValue(lazyListMeasureResult);
        if (z2) {
            lazyListScrollPosition.getClass();
            if (i2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
            }
            lazyListScrollPosition.scrollOffset$delegate.setIntValue(i2);
        } else {
            LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) CollectionsKt.firstOrNull(list);
            LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(list);
            TraceApi29Impl.traceValue(lazyListMeasuredItem2 != null ? lazyListMeasuredItem2.index : -1L, "firstVisibleItem:index");
            TraceApi29Impl.traceValue(lazyListMeasuredItem3 != null ? lazyListMeasuredItem3.index : -1L, "lastVisibleItem:index");
            lazyListScrollPosition.getClass();
            lazyListScrollPosition.lastKnownFirstItemKey = lazyListMeasuredItem != null ? lazyListMeasuredItem.key : null;
            if (lazyListScrollPosition.hadFirstNotEmptyLayout || i > 0) {
                lazyListScrollPosition.hadFirstNotEmptyLayout = true;
                if (i2 < r6) {
                    InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
                }
                lazyListScrollPosition.update(lazyListMeasuredItem != null ? lazyListMeasuredItem.index : 0, i2);
            }
            if (this.prefetchingEnabled) {
                int i3 = defaultLazyListPrefetchStrategy.indexToPrefetch;
                boolean z3 = defaultLazyListPrefetchStrategy.wasScrollingForward;
                if (i3 != -1 && !list.isEmpty() && i3 != DefaultLazyListPrefetchStrategy.calculateIndexToPrefetch(lazyListMeasureResult, z3)) {
                    defaultLazyListPrefetchStrategy.indexToPrefetch = -1;
                    LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = defaultLazyListPrefetchStrategy.currentPrefetchHandle;
                    if (prefetchHandle != null) {
                        prefetchHandle.cancel();
                    }
                    defaultLazyListPrefetchStrategy.currentPrefetchHandle = null;
                }
                int i4 = defaultLazyListPrefetchStrategy.previousPassItemCount;
                if (i4 != -1 && defaultLazyListPrefetchStrategy.previousPassDelta != r6 && i4 != i && !list.isEmpty()) {
                    int iCalculateIndexToPrefetch = DefaultLazyListPrefetchStrategy.calculateIndexToPrefetch(lazyListMeasureResult, defaultLazyListPrefetchStrategy.previousPassDelta < 0);
                    if (iCalculateIndexToPrefetch >= 0 && iCalculateIndexToPrefetch < i) {
                        defaultLazyListPrefetchStrategy.indexToPrefetch = iCalculateIndexToPrefetch;
                        defaultLazyListPrefetchStrategy.currentPrefetchHandle = LazyListState$prefetchScope$1.schedulePrefetch$default(this.prefetchScope, iCalculateIndexToPrefetch);
                    }
                }
                defaultLazyListPrefetchStrategy.previousPassItemCount = i;
            }
        }
        if (z) {
            weakCache.updateScrollDeltaForApproach$foundation(lazyListMeasureResult.scrollBackAmount, lazyListMeasureResult.density, lazyListMeasureResult.coroutineScope);
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

    public final LazyListMeasureResult getLayoutInfo() {
        return (LazyListMeasureResult) this.layoutInfoState.getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final void notifyPrefetchOnScroll(float f, LazyListMeasureResult lazyListMeasureResult) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        if (this.prefetchingEnabled) {
            boolean zIsEmpty = lazyListMeasureResult.visibleItemsInfo.isEmpty();
            DefaultLazyListPrefetchStrategy defaultLazyListPrefetchStrategy = this.prefetchStrategy;
            if (!zIsEmpty) {
                boolean z = f < CropImageView.DEFAULT_ASPECT_RATIO;
                int iCalculateIndexToPrefetch = DefaultLazyListPrefetchStrategy.calculateIndexToPrefetch(lazyListMeasureResult, z);
                if (iCalculateIndexToPrefetch >= 0 && iCalculateIndexToPrefetch < lazyListMeasureResult.totalItemsCount) {
                    if (iCalculateIndexToPrefetch != defaultLazyListPrefetchStrategy.indexToPrefetch) {
                        if (defaultLazyListPrefetchStrategy.wasScrollingForward != z) {
                            defaultLazyListPrefetchStrategy.indexToPrefetch = -1;
                            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3 = defaultLazyListPrefetchStrategy.currentPrefetchHandle;
                            if (prefetchHandle3 != null) {
                                prefetchHandle3.cancel();
                            }
                            defaultLazyListPrefetchStrategy.currentPrefetchHandle = null;
                        }
                        defaultLazyListPrefetchStrategy.wasScrollingForward = z;
                        defaultLazyListPrefetchStrategy.indexToPrefetch = iCalculateIndexToPrefetch;
                        defaultLazyListPrefetchStrategy.currentPrefetchHandle = LazyListState$prefetchScope$1.schedulePrefetch$default(this.prefetchScope, iCalculateIndexToPrefetch);
                    }
                    List list = lazyListMeasureResult.visibleItemsInfo;
                    if (z) {
                        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) CollectionsKt.last(list);
                        if (((lazyListMeasuredItem.offset + lazyListMeasuredItem.size) + lazyListMeasureResult.mainAxisItemSpacing) - lazyListMeasureResult.viewportEndOffset < (-f) && (prefetchHandle2 = defaultLazyListPrefetchStrategy.currentPrefetchHandle) != null) {
                            prefetchHandle2.markAsUrgent();
                        }
                    } else if (lazyListMeasureResult.viewportStartOffset - ((LazyListMeasuredItem) CollectionsKt.first(list)).offset < f && (prefetchHandle = defaultLazyListPrefetchStrategy.currentPrefetchHandle) != null) {
                        prefetchHandle.markAsUrgent();
                    }
                }
            }
            defaultLazyListPrefetchStrategy.previousPassDelta = f;
        }
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
        C00281 c00281;
        Function2 function3;
        if (continuationImpl instanceof C00281) {
            c00281 = (C00281) continuationImpl;
            int i = c00281.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00281.label = i - Integer.MIN_VALUE;
            } else {
                c00281 = new C00281(continuationImpl);
            }
        } else {
            c00281 = new C00281(continuationImpl);
        }
        Object obj = c00281.result;
        int i2 = c00281.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.layoutInfoState.getValue() == LazyListStateKt.EmptyLazyListMeasureResult) {
                c00281.L$0 = mutatePriority;
                c00281.L$1 = (SuspendLambda) function2;
                c00281.label = 1;
                if (this.awaitLayoutModifier.waitForFirstLayout(c00281) != obj2) {
                }
            }
            function3 = function2;
            function3 = function2;
            return obj2;
        }
        if (i2 == 1) {
            Function2 function4 = (Function2) c00281.L$1;
            mutatePriority = c00281.L$0;
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
        c00281.L$0 = null;
        c00281.L$1 = null;
        c00281.label = 2;
    }

    public final void snapToItemIndexInternal$foundation(int i, boolean z, int i2) {
        LazyListScrollPosition lazyListScrollPosition = this.scrollPosition;
        if (lazyListScrollPosition.index$delegate.getIntValue() != i || lazyListScrollPosition.scrollOffset$delegate.getIntValue() != i2) {
            LazyLayoutItemAnimator lazyLayoutItemAnimator = this.itemAnimator;
            lazyLayoutItemAnimator.releaseAnimations();
            lazyLayoutItemAnimator.keyIndexMap = null;
            lazyLayoutItemAnimator.firstVisibleIndex = -1;
            Object obj = this.prefetchStrategy;
            CacheWindowLogic cacheWindowLogic = obj instanceof CacheWindowLogic ? (CacheWindowLogic) obj : null;
            if (cacheWindowLogic != null) {
                cacheWindowLogic.resetStrategy();
            }
        }
        lazyListScrollPosition.update(i, i2);
        lazyListScrollPosition.lastKnownFirstItemKey = null;
        if (!z) {
            LazyLayoutKt.m176invalidateScopeimpl(this.measurementScopeInvalidator);
            return;
        }
        LayoutNode layoutNode = this.remeasurement;
        if (layoutNode != null) {
            layoutNode.forceRemeasure();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public int $index;
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object L$0;
        public boolean label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Animatable animatable, int i, SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 2;
            this.L$0 = animatable;
            this.$index = i;
            this.this$0 = segmentedButtonContentMeasurePolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((ScrollableState) obj2, this.$index, continuation, (byte) 0);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 1:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2((ScrollableState) obj2, this.$index, continuation, (byte) 1);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                case 2:
                    return new AnonymousClass2((Animatable) this.L$0, this.$index, (SegmentedButtonContentMeasurePolicy) obj2, continuation);
                default:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2((RecognitionForegroundService) obj2, continuation);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Object obj2 = this.this$0;
            byte b2 = 1;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (z) {
                        if (z) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    LazyListState lazyListState = (LazyListState) obj2;
                    PagerScrollScopeKt$LazyLayoutScrollScope$1 pagerScrollScopeKt$LazyLayoutScrollScope$1 = new PagerScrollScopeKt$LazyLayoutScrollScope$1((ScrollScope) this.L$0, lazyListState, b2);
                    int i2 = this.$index;
                    Density density = ((LazyListMeasureResult) lazyListState.layoutInfoState.getValue()).density;
                    this.label = true;
                    return LazyLayoutKt.animateScrollToItem(pagerScrollScopeKt$LazyLayoutScrollScope$1, i2, 100, density, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    LazyGridState lazyGridState = (LazyGridState) obj2;
                    boolean z2 = this.label;
                    if (z2) {
                        if (z2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    PagerScrollScopeKt$LazyLayoutScrollScope$1 pagerScrollScopeKt$LazyLayoutScrollScope$2 = new PagerScrollScopeKt$LazyLayoutScrollScope$1((ScrollScope) this.L$0, lazyGridState, (byte) 2);
                    int i3 = this.$index;
                    CallbackWrapper callbackWrapper = LazyGridState.Saver;
                    int i4 = ((LazyGridMeasureResult) lazyGridState.layoutInfoState.getValue()).slotsPerLine * 100;
                    Density density2 = ((LazyGridMeasureResult) lazyGridState.layoutInfoState.getValue()).density;
                    this.label = true;
                    return LazyLayoutKt.animateScrollToItem(pagerScrollScopeKt$LazyLayoutScrollScope$2, i3, i4, density2, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    boolean z3 = this.label;
                    if (z3) {
                        if (z3) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = (Animatable) this.L$0;
                    Integer num = new Integer(this.$index);
                    AnimationSpec animationSpec = ((SegmentedButtonContentMeasurePolicy) obj2).animationSpec;
                    this.label = true;
                    return Animatable.animateTo$default(animatable, num, animationSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    RecognitionForegroundService recognitionForegroundService = (RecognitionForegroundService) obj2;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        i = 0;
                    } else {
                        if (!z4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        i = this.$index;
                        ResultKt.throwOnFailure(obj);
                    }
                    while (AwaitKt.isActive(coroutineScope)) {
                        int i5 = RecognitionForegroundService.$r8$clinit;
                        recognitionForegroundService.getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("pulse_frame", i).apply();
                        recognitionForegroundService.updateAllWidgets();
                        i = (i + 1) % 4;
                        this.L$0 = coroutineScope;
                        this.$index = i;
                        this.label = true;
                        if (AwaitKt.delay(600L, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(ScrollableState scrollableState, int i, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = scrollableState;
            this.$index = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RecognitionForegroundService recognitionForegroundService, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 3;
            this.this$0 = recognitionForegroundService;
        }
    }
}
