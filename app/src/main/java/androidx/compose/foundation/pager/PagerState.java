package androidx.compose.foundation.pager;

import androidx.collection.ObjectIntMapKt;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.emoji2.text.EmojiProcessor;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PagerState implements ScrollableState {
    public float accumulator;
    public PagerMeasureResult approachLayoutInfo;
    public final AwaitFirstLayoutModifier awaitLayoutModifier;
    public final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    public final PagerCacheWindowLogic cacheWindowLogic;
    public final ParcelableSnapshotMutableState canScrollBackward$delegate;
    public final ParcelableSnapshotMutableState canScrollForward$delegate;
    public Density density;
    public int firstVisiblePage;
    public int firstVisiblePageOffset;
    public boolean hasLookaheadOccurred;
    public final MutableInteractionSourceImpl internalInteractionSource;
    public final ParcelableSnapshotMutableState isLastScrollBackwardState;
    public final ParcelableSnapshotMutableState isLastScrollForwardState;
    public int latestPageSizeWithSpacing;
    public long maxScrollOffset;
    public final MutableState measurementScopeInvalidator;
    public long minScrollOffset;
    public final ParcelableSnapshotMutableState pagerLayoutInfoState;
    public final LazyLayoutPinnedItemList pinnedPages;
    public final MutableState placementScopeInvalidator;
    public final LazyLayoutPrefetchState prefetchState;
    public final boolean prefetchingEnabled;
    public float previousPassDelta;
    public final ParcelableSnapshotMutableIntState programmaticScrollTargetPage$delegate;
    public final ParcelableSnapshotMutableState remeasurement$delegate;
    public final PagerState$remeasurementModifier$1 remeasurementModifier;
    public final PagerScrollPosition scrollPosition;
    public final DefaultScrollableState scrollableState;
    public final ParcelableSnapshotMutableIntState settledPageState$delegate;
    public final ParcelableSnapshotMutableState upDownDifference$delegate;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public SpringSpec L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerState.this.animateScrollToPage(0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ AnimationSpec $animationSpec;
        public final /* synthetic */ int $targetPage;
        public final /* synthetic */ float $targetPageOffsetToSnappedPosition;
        public /* synthetic */ Object L$0;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(int i, float f, AnimationSpec animationSpec, Continuation continuation) {
            super(2, continuation);
            this.$targetPage = i;
            this.$targetPageOffsetToSnappedPosition = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = PagerState.this.new AnonymousClass3(this.$targetPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass3) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
        
            r10 = r2;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            boolean z = this.label;
            Unit unit = Unit.INSTANCE;
            if (z) {
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ScrollScope scrollScope = (ScrollScope) this.L$0;
            PagerState pagerState = PagerState.this;
            PagerScrollScopeKt$LazyLayoutScrollScope$1 pagerScrollScopeKt$LazyLayoutScrollScope$1 = new PagerScrollScopeKt$LazyLayoutScrollScope$1(scrollScope, pagerState, (byte) 0);
            this.label = true;
            PagerStateKt$UnitDensity$1 pagerStateKt$UnitDensity$1 = PagerStateKt.UnitDensity;
            int i2 = this.$targetPage;
            pagerState.programmaticScrollTargetPage$delegate.setIntValue(pagerState.coerceInPageRange(new Integer(i2).intValue()));
            byte b = i2 > pagerState.firstVisiblePage ? (byte) 1 : (byte) 0;
            int lastVisibleItemIndex = (pagerScrollScopeKt$LazyLayoutScrollScope$1.getLastVisibleItemIndex() - pagerState.firstVisiblePage) + 1;
            if (((b != 0 && i2 > pagerScrollScopeKt$LazyLayoutScrollScope$1.getLastVisibleItemIndex()) || (b == 0 && i2 < pagerState.firstVisiblePage)) && Math.abs(i2 - pagerState.firstVisiblePage) >= 3) {
                if (b != 0) {
                }
                pagerScrollScopeKt$LazyLayoutScrollScope$1.snapToItem(i);
            }
            Object objAnimate$default = ArcSplineKt.animate$default(CropImageView.DEFAULT_ASPECT_RATIO, pagerScrollScopeKt$LazyLayoutScrollScope$1.calculateDistanceTo(i2) + this.$targetPageOffsetToSnappedPosition, this.$animationSpec, new ButtonKt$$ExternalSyntheticLambda1(new Ref$FloatRef(), pagerScrollScopeKt$LazyLayoutScrollScope$1, (byte) 12), this, 4);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnimate$default != coroutineSingletons) {
                objAnimate$default = unit;
            }
            return objAnimate$default == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00291 extends ContinuationImpl {
        public PagerState L$0;
        public MutatePriority L$1;
        public SuspendLambda L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00291(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerState.scroll$suspendImpl(PagerState.this, null, null, this);
        }
    }

    public PagerState(int i, float f) {
        double d = f;
        if (-0.5d > d || d > 0.5d) {
            InlineClassHelperKt.throwIllegalArgumentException("currentPageOffsetFraction " + f + " is not within the range -0.5 to 0.5");
        }
        this.upDownDifference$delegate = Stack.mutableStateOf$default(new Offset(0L));
        this.scrollPosition = new PagerScrollPosition(i, f, this);
        this.firstVisiblePage = i;
        this.maxScrollOffset = Long.MAX_VALUE;
        final byte b = 0;
        this.scrollableState = new DefaultScrollableState(new Function1(this) { // from class: androidx.compose.foundation.pager.PagerState$$ExternalSyntheticLambda0
            public final /* synthetic */ PagerState f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r0v7 */
            /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Float] */
            /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Number] */
            /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.Long] */
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
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                PagerMeasureResult pagerMeasureResult;
                byte b2 = b;
                PagerMeasureResult pagerMeasureResult2 = null;
                PagerState pagerState = this.f$0;
                switch (b2) {
                    case 0:
                        ?? ValueOf = (Float) obj;
                        float fFloatValue = ValueOf.floatValue();
                        long jCurrentAbsoluteScrollOffset = UtilsKt.currentAbsoluteScrollOffset(pagerState);
                        float f2 = pagerState.accumulator + fFloatValue;
                        long jRoundToLong = MathKt.roundToLong(f2);
                        pagerState.accumulator = f2 - jRoundToLong;
                        if (Math.abs(fFloatValue) >= 1.0E-4f) {
                            long j = jCurrentAbsoluteScrollOffset + jRoundToLong;
                            long jCoerceIn = UuidKt.coerceIn(j, pagerState.minScrollOffset, pagerState.maxScrollOffset);
                            ?? r0 = j != jCoerceIn;
                            long j2 = jCoerceIn - jCurrentAbsoluteScrollOffset;
                            float f3 = j2;
                            pagerState.previousPassDelta = f3;
                            long jAbs = Math.abs(j2);
                            float pageSizeWithSpacing$foundation = CropImageView.DEFAULT_ASPECT_RATIO;
                            if (jAbs != 0) {
                                pagerState.isLastScrollForwardState.setValue(Boolean.valueOf(f3 > CropImageView.DEFAULT_ASPECT_RATIO));
                                pagerState.isLastScrollBackwardState.setValue(Boolean.valueOf(f3 < CropImageView.DEFAULT_ASPECT_RATIO));
                            }
                            int i2 = (int) j2;
                            int i3 = -i2;
                            PagerMeasureResult pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure = ((PagerMeasureResult) pagerState.pagerLayoutInfoState.getValue()).copyWithScrollDeltaWithoutRemeasure(i3);
                            if (pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure == null || (pagerMeasureResult = pagerState.approachLayoutInfo) == null) {
                                pagerMeasureResult2 = pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure;
                            } else {
                                PagerMeasureResult pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure2 = pagerMeasureResult.copyWithScrollDeltaWithoutRemeasure(i3);
                                if (pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure2 != null) {
                                    pagerState.approachLayoutInfo = pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure2;
                                    pagerMeasureResult2 = pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure;
                                }
                            }
                            if (pagerMeasureResult2 != null) {
                                pagerState.applyMeasureResult$foundation(pagerMeasureResult2, pagerState.hasLookaheadOccurred, true);
                                LazyLayoutKt.m176invalidateScopeimpl(pagerState.placementScopeInvalidator);
                            } else {
                                PagerScrollPosition pagerScrollPosition = pagerState.scrollPosition;
                                PagerState pagerState2 = pagerScrollPosition.state;
                                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = pagerScrollPosition.currentPageOffsetFraction$delegate;
                                if (pagerState2.getPageSizeWithSpacing$foundation() != 0) {
                                    pageSizeWithSpacing$foundation = i2 / pagerState2.getPageSizeWithSpacing$foundation();
                                }
                                parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() + pageSizeWithSpacing$foundation);
                                LayoutNode layoutNode = (LayoutNode) pagerState.remeasurement$delegate.getValue();
                                if (layoutNode != null) {
                                    layoutNode.forceRemeasure();
                                }
                            }
                            if (r0 != false) {
                                ValueOf = Long.valueOf(j2);
                            }
                            fFloatValue = ValueOf.floatValue();
                        }
                        return Float.valueOf(fFloatValue);
                    default:
                        LazyLayoutPrefetchState.NestedPrefetchScopeImpl nestedPrefetchScopeImpl = (LazyLayoutPrefetchState.NestedPrefetchScopeImpl) obj;
                        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            nestedPrefetchScopeImpl.schedulePrecomposition(pagerState.firstVisiblePage);
                            return Unit.INSTANCE;
                        } finally {
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        }
                }
            }
        });
        final byte b2 = 1;
        this.prefetchingEnabled = true;
        this.pagerLayoutInfoState = new ParcelableSnapshotMutableState(PagerStateKt.EmptyLayoutInfo, NeverEqualPolicy.INSTANCE);
        this.density = PagerStateKt.UnitDensity;
        this.internalInteractionSource = new MutableInteractionSourceImpl();
        this.programmaticScrollTargetPage$delegate = new ParcelableSnapshotMutableIntState(-1);
        this.settledPageState$delegate = new ParcelableSnapshotMutableIntState(i);
        EmojiProcessor emojiProcessor = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        new AtomicInt(0);
        SnapshotKt.currentSnapshot().getSnapshotId();
        ObjectIntMapKt.EmptyObjectIntMap.getClass();
        new AtomicInt(0);
        SnapshotKt.currentSnapshot().getSnapshotId();
        ObjectIntMapKt.EmptyObjectIntMap.getClass();
        LazyLayoutPrefetchState lazyLayoutPrefetchState = new LazyLayoutPrefetchState(new Function1(this) { // from class: androidx.compose.foundation.pager.PagerState$$ExternalSyntheticLambda0
            public final /* synthetic */ PagerState f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r0v7 */
            /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Float] */
            /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Number] */
            /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.Long] */
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
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                PagerMeasureResult pagerMeasureResult;
                byte b3 = b2;
                PagerMeasureResult pagerMeasureResult2 = null;
                PagerState pagerState = this.f$0;
                switch (b3) {
                    case 0:
                        ?? ValueOf = (Float) obj;
                        float fFloatValue = ValueOf.floatValue();
                        long jCurrentAbsoluteScrollOffset = UtilsKt.currentAbsoluteScrollOffset(pagerState);
                        float f2 = pagerState.accumulator + fFloatValue;
                        long jRoundToLong = MathKt.roundToLong(f2);
                        pagerState.accumulator = f2 - jRoundToLong;
                        if (Math.abs(fFloatValue) >= 1.0E-4f) {
                            long j = jCurrentAbsoluteScrollOffset + jRoundToLong;
                            long jCoerceIn = UuidKt.coerceIn(j, pagerState.minScrollOffset, pagerState.maxScrollOffset);
                            ?? r0 = j != jCoerceIn;
                            long j2 = jCoerceIn - jCurrentAbsoluteScrollOffset;
                            float f3 = j2;
                            pagerState.previousPassDelta = f3;
                            long jAbs = Math.abs(j2);
                            float pageSizeWithSpacing$foundation = CropImageView.DEFAULT_ASPECT_RATIO;
                            if (jAbs != 0) {
                                pagerState.isLastScrollForwardState.setValue(Boolean.valueOf(f3 > CropImageView.DEFAULT_ASPECT_RATIO));
                                pagerState.isLastScrollBackwardState.setValue(Boolean.valueOf(f3 < CropImageView.DEFAULT_ASPECT_RATIO));
                            }
                            int i2 = (int) j2;
                            int i3 = -i2;
                            PagerMeasureResult pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure = ((PagerMeasureResult) pagerState.pagerLayoutInfoState.getValue()).copyWithScrollDeltaWithoutRemeasure(i3);
                            if (pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure == null || (pagerMeasureResult = pagerState.approachLayoutInfo) == null) {
                                pagerMeasureResult2 = pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure;
                            } else {
                                PagerMeasureResult pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure2 = pagerMeasureResult.copyWithScrollDeltaWithoutRemeasure(i3);
                                if (pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure2 != null) {
                                    pagerState.approachLayoutInfo = pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure2;
                                    pagerMeasureResult2 = pagerMeasureResultCopyWithScrollDeltaWithoutRemeasure;
                                }
                            }
                            if (pagerMeasureResult2 != null) {
                                pagerState.applyMeasureResult$foundation(pagerMeasureResult2, pagerState.hasLookaheadOccurred, true);
                                LazyLayoutKt.m176invalidateScopeimpl(pagerState.placementScopeInvalidator);
                            } else {
                                PagerScrollPosition pagerScrollPosition = pagerState.scrollPosition;
                                PagerState pagerState2 = pagerScrollPosition.state;
                                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = pagerScrollPosition.currentPageOffsetFraction$delegate;
                                if (pagerState2.getPageSizeWithSpacing$foundation() != 0) {
                                    pageSizeWithSpacing$foundation = i2 / pagerState2.getPageSizeWithSpacing$foundation();
                                }
                                parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() + pageSizeWithSpacing$foundation);
                                LayoutNode layoutNode = (LayoutNode) pagerState.remeasurement$delegate.getValue();
                                if (layoutNode != null) {
                                    layoutNode.forceRemeasure();
                                }
                            }
                            if (r0 != false) {
                                ValueOf = Long.valueOf(j2);
                            }
                            fFloatValue = ValueOf.floatValue();
                        }
                        return Float.valueOf(fFloatValue);
                    default:
                        LazyLayoutPrefetchState.NestedPrefetchScopeImpl nestedPrefetchScopeImpl = (LazyLayoutPrefetchState.NestedPrefetchScopeImpl) obj;
                        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            nestedPrefetchScopeImpl.schedulePrecomposition(pagerState.firstVisiblePage);
                            return Unit.INSTANCE;
                        } finally {
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        }
                }
            }
        });
        this.prefetchState = lazyLayoutPrefetchState;
        this.cacheWindowLogic = new PagerCacheWindowLogic(new DrawResult((byte) 16, this), lazyLayoutPrefetchState, new PagerState$$ExternalSyntheticLambda2(this, (byte) 0));
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo((byte) 0);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.remeasurement$delegate = Stack.mutableStateOf$default(null);
        this.remeasurementModifier = new PagerState$remeasurementModifier$1(this, (byte) 0);
        ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
        this.pinnedPages = new LazyLayoutPinnedItemList();
        this.placementScopeInvalidator = LazyLayoutKt.m175constructorimpl$default();
        this.measurementScopeInvalidator = LazyLayoutKt.m175constructorimpl$default();
        Boolean bool = Boolean.FALSE;
        this.canScrollForward$delegate = Stack.mutableStateOf$default(bool);
        this.canScrollBackward$delegate = Stack.mutableStateOf$default(bool);
        this.isLastScrollForwardState = Stack.mutableStateOf$default(bool);
        this.isLastScrollBackwardState = Stack.mutableStateOf$default(bool);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        if (r9.scroll(r7, r8, r0) == r5) goto L24;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object scroll$suspendImpl(PagerState pagerState, MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        C00291 c00291;
        Function2 function3;
        if (continuationImpl instanceof C00291) {
            c00291 = (C00291) continuationImpl;
            int i = c00291.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00291.label = i - Integer.MIN_VALUE;
            } else {
                c00291 = pagerState.new C00291(continuationImpl);
            }
        } else {
            c00291 = pagerState.new C00291(continuationImpl);
        }
        Object obj = c00291.result;
        int i2 = c00291.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c00291.L$0 = pagerState;
            c00291.L$1 = mutatePriority;
            c00291.L$2 = (SuspendLambda) function2;
            c00291.label = 1;
            if (pagerState.awaitScrollDependencies(c00291) != obj2) {
            }
            function3 = function2;
            return obj2;
        }
        if (i2 == 1) {
            Function2 function4 = (Function2) c00291.L$2;
            mutatePriority = c00291.L$1;
            pagerState = c00291.L$0;
            ResultKt.throwOnFailure(obj);
            function3 = function4;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            pagerState = c00291.L$0;
            ResultKt.throwOnFailure(obj);
        }
        pagerState.programmaticScrollTargetPage$delegate.setIntValue(-1);
        return Unit.INSTANCE;
        function3 = function2;
        if (!pagerState.scrollableState.isScrollInProgress()) {
            pagerState.settledPageState$delegate.setIntValue(pagerState.getCurrentPage());
        }
        DefaultScrollableState defaultScrollableState = pagerState.scrollableState;
        c00291.L$0 = pagerState;
        c00291.L$1 = null;
        c00291.L$2 = null;
        c00291.label = 2;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object animateScrollToPage(int i, SpringSpec springSpec, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        int i2;
        SpringSpec springSpec2;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        int i4 = anonymousClass2.label;
        Unit unit = Unit.INSTANCE;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            if ((i != getCurrentPage() || getCurrentPageOffsetFraction() != CropImageView.DEFAULT_ASPECT_RATIO) && getPageCount() != 0) {
                anonymousClass2.L$0 = springSpec;
                anonymousClass2.I$0 = i;
                anonymousClass2.label = 1;
                if (awaitScrollDependencies(anonymousClass2) != obj2) {
                    i2 = i;
                    springSpec2 = springSpec;
                }
            }
        }
        if (i4 != 1) {
            if (i4 == 2) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i2 = anonymousClass2.I$0;
        SpringSpec springSpec3 = anonymousClass2.L$0;
        ResultKt.throwOnFailure(obj);
        springSpec2 = springSpec3;
        Function2 anonymousClass3 = new AnonymousClass3(coerceInPageRange(i2), getPageSizeWithSpacing$foundation() * CropImageView.DEFAULT_ASPECT_RATIO, springSpec2, null);
        anonymousClass2.L$0 = null;
        anonymousClass2.label = 2;
        return scroll(MutatePriority.Default, anonymousClass3, anonymousClass2) == obj2 ? obj2 : unit;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x010d A[Catch: all -> 0x0124, TryCatch #0 {all -> 0x0124, blocks: (B:46:0x00bb, B:49:0x00c4, B:52:0x00d1, B:54:0x00dd, B:62:0x0113, B:60:0x010d, B:57:0x00f5), top: B:78:0x00bb }] */
    public final void applyMeasureResult$foundation(PagerMeasureResult pagerMeasureResult, boolean z, boolean z2) {
        List list = pagerMeasureResult.visiblePagesInfo;
        int i = pagerMeasureResult.firstVisiblePageScrollOffset;
        MeasuredPage measuredPage = pagerMeasureResult.firstVisiblePage;
        MeasuredPage measuredPage2 = pagerMeasureResult.currentPage;
        float f = pagerMeasureResult.currentPageOffsetFraction;
        this.prefetchState.idealNestedPrefetchCount = list.size();
        this.latestPageSizeWithSpacing = pagerMeasureResult.pageSize + pagerMeasureResult.pageSpacing;
        if (!z && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = pagerMeasureResult;
            return;
        }
        boolean z3 = true;
        if (z) {
            this.hasLookaheadOccurred = true;
        }
        PagerCacheWindowLogic pagerCacheWindowLogic = this.cacheWindowLogic;
        boolean z4 = this.prefetchingEnabled;
        PagerScrollPosition pagerScrollPosition = this.scrollPosition;
        if (z2) {
            pagerScrollPosition.currentPageOffsetFraction$delegate.setFloatValue(f);
        } else {
            pagerScrollPosition.getClass();
            pagerScrollPosition.lastKnownCurrentPageKey = measuredPage2 != null ? measuredPage2.key : null;
            if (pagerScrollPosition.hadFirstNotEmptyLayout || !list.isEmpty()) {
                pagerScrollPosition.hadFirstNotEmptyLayout = true;
                int i2 = measuredPage2 != null ? measuredPage2.index : 0;
                pagerScrollPosition.currentPage$delegate.setIntValue(i2);
                pagerScrollPosition.nearestRangeState.update(i2);
                pagerScrollPosition.currentPageOffsetFraction$delegate.setFloatValue(f);
            }
            if (z4) {
                EmojiProcessor emojiProcessor = pagerCacheWindowLogic.cacheWindowScope;
                emojiProcessor.mMetadataRepo = pagerMeasureResult;
                emojiProcessor.mGlyphChecker = pagerCacheWindowLogic.state;
                pagerCacheWindowLogic.$$delegate_0.onVisibleItemsUpdated(emojiProcessor);
            }
        }
        this.pagerLayoutInfoState.setValue(pagerMeasureResult);
        this.canScrollForward$delegate.setValue(Boolean.valueOf(pagerMeasureResult.canScrollForward));
        if ((measuredPage != null ? measuredPage.index : 0) == 0 && i == 0) {
            z3 = false;
        }
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z3));
        if (measuredPage != null) {
            this.firstVisiblePage = measuredPage.index;
        }
        this.firstVisiblePageOffset = i;
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        if (z4) {
            try {
                if (pagerMeasureResult.beyondViewportPageCount < getPageCount() && Math.abs(this.previousPassDelta) > 0.5f) {
                    float f2 = this.previousPassDelta;
                    if (getLayoutInfo().orientation == Orientation.Vertical) {
                        if (Math.signum(f2) != Math.signum(-Float.intBitsToFloat((int) (m180getUpDownDifferenceF1C5BW0$foundation() & 4294967295L)))) {
                            if (isNotGestureAction$foundation()) {
                            }
                        }
                    } else if (Math.signum(f2) != Math.signum(-Float.intBitsToFloat((int) (m180getUpDownDifferenceF1C5BW0$foundation() >> 32)))) {
                        if (isNotGestureAction$foundation()) {
                        }
                    }
                    float f3 = this.previousPassDelta;
                    EmojiProcessor emojiProcessor2 = pagerCacheWindowLogic.cacheWindowScope;
                    emojiProcessor2.mMetadataRepo = pagerMeasureResult;
                    emojiProcessor2.mGlyphChecker = pagerCacheWindowLogic.state;
                    pagerCacheWindowLogic.$$delegate_0.onScroll(emojiProcessor2, -f3);
                }
            } catch (Throwable th) {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        }
        Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(pagerMeasureResult, getPageCount());
        long jCoerceIn = UuidKt.coerceIn(pagerMeasureResult.snapPosition.position(0, getPageCount()), 0, (int) (pagerMeasureResult.orientation == Orientation.Horizontal ? pagerMeasureResult.m179getViewportSizeYbymL2g() >> 32 : pagerMeasureResult.m179getViewportSizeYbymL2g() & 4294967295L));
        long j = this.maxScrollOffset;
        if (jCoerceIn > j) {
            jCoerceIn = j;
        }
        this.minScrollOffset = jCoerceIn;
    }

    public final Object awaitScrollDependencies(ContinuationImpl continuationImpl) {
        Object objWaitForFirstLayout;
        return (this.pagerLayoutInfoState.getValue() == PagerStateKt.EmptyLayoutInfo && (objWaitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout(continuationImpl)) == CoroutineSingletons.COROUTINE_SUSPENDED) ? objWaitForFirstLayout : Unit.INSTANCE;
    }

    public final int coerceInPageRange(int i) {
        if (getPageCount() > 0) {
            return UuidKt.coerceIn(i, 0, getPageCount() - 1);
        }
        return 0;
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

    public final int getCurrentPage() {
        return this.scrollPosition.currentPage$delegate.getIntValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.currentPageOffsetFraction$delegate.getFloatValue();
    }

    public final PagerMeasureResult getLayoutInfo() {
        return (PagerMeasureResult) this.pagerLayoutInfoState.getValue();
    }

    public abstract int getPageCount();

    public final int getPageSize$foundation() {
        return ((PagerMeasureResult) this.pagerLayoutInfoState.getValue()).pageSize;
    }

    public final int getPageSizeWithSpacing$foundation() {
        return ((PagerMeasureResult) this.pagerLayoutInfoState.getValue()).pageSpacing + getPageSize$foundation();
    }

    /* JADX INFO: renamed from: getUpDownDifference-F1C5BW0$foundation, reason: not valid java name */
    public final long m180getUpDownDifferenceF1C5BW0$foundation() {
        return ((Offset) this.upDownDifference$delegate.getValue()).packedValue;
    }

    public final boolean isNotGestureAction$foundation() {
        return ((int) Float.intBitsToFloat((int) (m180getUpDownDifferenceF1C5BW0$foundation() >> 32))) == 0 && ((int) Float.intBitsToFloat((int) (m180getUpDownDifferenceF1C5BW0$foundation() & 4294967295L))) == 0;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        return scroll$suspendImpl(this, mutatePriority, function2, continuationImpl);
    }

    public final void snapToItem$foundation(int i, float f, boolean z) {
        PagerScrollPosition pagerScrollPosition = this.scrollPosition;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = pagerScrollPosition.currentPage$delegate;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = pagerScrollPosition.currentPageOffsetFraction$delegate;
        if (parcelableSnapshotMutableIntState.getIntValue() != i || parcelableSnapshotMutableFloatState.getFloatValue() != f) {
            this.cacheWindowLogic.resetStrategy();
        }
        pagerScrollPosition.currentPage$delegate.setIntValue(i);
        pagerScrollPosition.nearestRangeState.update(i);
        parcelableSnapshotMutableFloatState.setFloatValue(f);
        pagerScrollPosition.lastKnownCurrentPageKey = null;
        if (!z) {
            LazyLayoutKt.m176invalidateScopeimpl(this.measurementScopeInvalidator);
            return;
        }
        LayoutNode layoutNode = (LayoutNode) this.remeasurement$delegate.getValue();
        if (layoutNode != null) {
            layoutNode.forceRemeasure();
        }
    }
}
