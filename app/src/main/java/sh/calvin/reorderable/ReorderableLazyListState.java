package sh.calvin.reorderable;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListState$prefetchScope$1;
import androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.sqlite.SQLite;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeSourceNode;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyListState {
    public final LayoutDirection layoutDirection;
    public final MutableState onMoveState;
    public final CoroutineScope scope;
    public final float scrollThreshold;
    public final AbsolutePixelPadding scrollThresholdPadding;
    public final Scroller scroller;
    public final Function2 shouldItemMove;
    public final LazyListState$prefetchScope$1 state;
    public final ScrollMoveMode scrollMoveMode = ScrollMoveMode.SWAP;
    public final MutexImpl onMoveStateMutex = new MutexImpl();
    public final ParcelableSnapshotMutableState draggingItemKey$delegate = Stack.mutableStateOf$default(null);
    public final DerivedSnapshotState isAnyItemDragging$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ReorderableLazyCollectionState$layoutInfoFlow$1(this, 1));
    public final ParcelableSnapshotMutableState draggingItemDraggedDelta$delegate = Stack.mutableStateOf$default(new Offset(0));
    public final ParcelableSnapshotMutableState draggingItemInitialOffset$delegate = Stack.mutableStateOf$default(new IntOffset(0));
    public final ParcelableSnapshotMutableState oldDraggingItemIndex$delegate = Stack.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState predictedDraggingItemOffset$delegate = Stack.mutableStateOf$default(null);
    public long draggingItemHandleOffset = 0;
    public final HashSet reorderableKeys = new HashSet();
    public final ParcelableSnapshotMutableState previousDraggingItemKey$delegate = Stack.mutableStateOf$default(null);
    public final Animatable previousDraggingItemOffset = new Animatable(new Offset(0), ArcSplineKt.OffsetToVector, (Object) null, 12);
    public final SafeFlow layoutInfoFlow = Stack.snapshotFlow(new ReorderableLazyCollectionState$layoutInfoFlow$1(this, 0));

    public ReorderableLazyListState(LazyListState$prefetchScope$1 lazyListState$prefetchScope$1, CoroutineScope coroutineScope, MutableState mutableState, float f, AbsolutePixelPadding absolutePixelPadding, Scroller scroller, LayoutDirection layoutDirection, Function2 function2) {
        this.state = lazyListState$prefetchScope$1;
        this.scope = coroutineScope;
        this.onMoveState = mutableState;
        this.scrollThreshold = f;
        this.scrollThresholdPadding = absolutePixelPadding;
        this.scroller = scroller;
        this.layoutDirection = layoutDirection;
        this.shouldItemMove = function2;
    }

    public static ReorderableLazyListKt$toLazyCollectionItemInfo$1 findTargetItem$default(final ReorderableLazyListState reorderableLazyListState, final Rect rect, ArrayList arrayList, Scroller.Direction direction, ReorderableLazyCollectionState$onDrag$targetItem$1 reorderableLazyCollectionState$onDrag$targetItem$1, int i) {
        if ((i & 4) != 0) {
            direction = Scroller.Direction.FORWARD;
        }
        final Function1 function1 = reorderableLazyCollectionState$onDrag$targetItem$1;
        if ((i & 8) != 0) {
            function1 = ReorderableLazyCollectionState$findTargetItem$1.INSTANCE;
        }
        Function1 function2 = new Function1() { // from class: sh.calvin.reorderable.ReorderableLazyCollectionState$findTargetItem$targetItemFunc$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj;
                reorderableLazyListKt$toLazyCollectionItemInfo$1.getClass();
                long jM1920getOffsetnOccac = reorderableLazyListKt$toLazyCollectionItemInfo$1.m1920getOffsetnOccac();
                Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(SizeKt.Offset((int) (jM1920getOffsetnOccac >> 32), (int) (jM1920getOffsetnOccac & 4294967295L)), SizeKt.m876toSizeozmzZPI(reorderableLazyListKt$toLazyCollectionItemInfo$1.m1921getSizeYbymL2g()));
                ReorderableLazyListState reorderableLazyListState2 = this.this$0;
                return Boolean.valueOf(((Boolean) reorderableLazyListState2.shouldItemMove.invoke(rect, rectM896Recttz77jQw)).booleanValue() && reorderableLazyListState2.reorderableKeys.contains(reorderableLazyListKt$toLazyCollectionItemInfo$1.$this_toLazyCollectionItemInfo.key) && ((Boolean) function1.invoke(reorderableLazyListKt$toLazyCollectionItemInfo$1)).booleanValue());
            }
        };
        int iOrdinal = direction.ordinal();
        Object obj = null;
        if (iOrdinal == 0) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                Object objPrevious = listIterator.previous();
                if (((Boolean) function2.invoke(objPrevious)).booleanValue()) {
                    obj = objPrevious;
                    break;
                }
            }
            return (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj;
        }
        if (iOrdinal != 1) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            if (((Boolean) function2.invoke(obj2)).booleanValue()) {
                obj = obj2;
                break;
            }
        }
        return (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj;
    }

    public final ReorderableLazyListKt$toLazyCollectionItemInfo$1 getDraggingItemLayoutInfo() {
        Object value = this.draggingItemKey$delegate.getValue();
        Object obj = null;
        if (value == null) {
            return null;
        }
        ArrayList visibleItemsInfo = this.state.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i = 0;
        while (i < size) {
            Object obj2 = visibleItemsInfo.get(i);
            i++;
            if (((ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj2).$this_toLazyCollectionItemInfo.key.equals(value)) {
                obj = obj2;
                break;
            }
        }
        return (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj;
    }

    /* JADX INFO: renamed from: getDraggingItemOffset-F1C5BW0$reorderable_release, reason: not valid java name */
    public final long m1922getDraggingItemOffsetF1C5BW0$reorderable_release() {
        long jM1920getOffsetnOccac;
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 draggingItemLayoutInfo = getDraggingItemLayoutInfo();
        if (draggingItemLayoutInfo == null) {
            return 0L;
        }
        int i = draggingItemLayoutInfo.$this_toLazyCollectionItemInfo.index;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.oldDraggingItemIndex$delegate;
        Integer num = (Integer) parcelableSnapshotMutableState.getValue();
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.predictedDraggingItemOffset$delegate;
        if (num == null || i != num.intValue() || ((Integer) parcelableSnapshotMutableState.getValue()) == null) {
            parcelableSnapshotMutableState.setValue(null);
            parcelableSnapshotMutableState2.setValue(null);
            jM1920getOffsetnOccac = draggingItemLayoutInfo.m1920getOffsetnOccac();
        } else {
            IntOffset intOffset = (IntOffset) parcelableSnapshotMutableState2.getValue();
            jM1920getOffsetnOccac = intOffset != null ? intOffset.packedValue : draggingItemLayoutInfo.m1920getOffsetnOccac();
        }
        long j = ((Offset) this.draggingItemDraggedDelta$delegate.getValue()).packedValue;
        long j2 = ((IntOffset) this.draggingItemInitialOffset$delegate.getValue()).packedValue;
        long jM1924reverseAxisIfNecessaryMKHz9U = m1924reverseAxisIfNecessaryMKHz9U(Offset.m438minusMKHz9U(SizeKt.Offset((int) (j2 >> 32), (int) (j2 & 4294967295L)), SizeKt.Offset((int) (jM1920getOffsetnOccac >> 32), (int) (jM1920getOffsetnOccac & 4294967295L))));
        m1925x5650483a(jM1924reverseAxisIfNecessaryMKHz9U);
        return Offset.m439plusMKHz9U(j, jM1924reverseAxisIfNecessaryMKHz9U);
    }

    public final Orientation getOrientation$reorderable_release() {
        return ((LazyListMeasureResult) this.state.getLayoutInfo().delegate).orientation;
    }

    public final boolean isAnyItemDragging() {
        return ((Boolean) this.isAnyItemDragging$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02b5, code lost:
    
        if (r7.index > r11.index) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02c2, code lost:
    
        if (r7.index < r11.index) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02c4, code lost:
    
        r0 = kotlinx.coroutines.AwaitKt.launch$default(r9.scope, null, null, new sh.calvin.reorderable.ReorderableLazyCollectionState$onDrag$1(r9, r1, r12, null, (byte) 1), 3);
        r15.unlock(null);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 2;
        r1 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02e4, code lost:
    
        if (r0.join(r2) != r1) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02e7, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02e8, code lost:
    
        r15.unlock(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02eb, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
    
        if (r11.index == r12.$this_toLazyCollectionItemInfo.index) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0096, code lost:
    
        if (r11.index == r3.this$0.getFirstVisibleItemIndex()) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0098, code lost:
    
        r15.unlock(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009b, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object moveDraggingItemToEnd(Scroller.Direction direction, ContinuationImpl continuationImpl) {
        ReorderableLazyCollectionState$moveDraggingItemToEnd$1 reorderableLazyCollectionState$moveDraggingItemToEnd$1;
        ReorderableLazyListState reorderableLazyListState;
        Scroller.Direction direction2;
        CollectionScrollPadding collectionScrollPadding;
        CoroutineSingletons coroutineSingletons;
        LazyListState$prefetchScope$1 lazyListState$prefetchScope$1;
        ArrayList arrayList;
        Scroller.Direction direction3;
        Object obj;
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1;
        Object objPrevious;
        LazyListState$prefetchScope$1 lazyListState$prefetchScope$2;
        ArrayList arrayList2;
        Orientation orientation;
        if (continuationImpl instanceof ReorderableLazyCollectionState$moveDraggingItemToEnd$1) {
            reorderableLazyCollectionState$moveDraggingItemToEnd$1 = (ReorderableLazyCollectionState$moveDraggingItemToEnd$1) continuationImpl;
            int i = reorderableLazyCollectionState$moveDraggingItemToEnd$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                reorderableLazyCollectionState$moveDraggingItemToEnd$1.label = i - Integer.MIN_VALUE;
            } else {
                reorderableLazyCollectionState$moveDraggingItemToEnd$1 = new ReorderableLazyCollectionState$moveDraggingItemToEnd$1(this, continuationImpl);
            }
        } else {
            reorderableLazyCollectionState$moveDraggingItemToEnd$1 = new ReorderableLazyCollectionState$moveDraggingItemToEnd$1(this, continuationImpl);
        }
        Object obj2 = reorderableLazyCollectionState$moveDraggingItemToEnd$1.result;
        int i2 = reorderableLazyCollectionState$moveDraggingItemToEnd$1.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            reorderableLazyCollectionState$moveDraggingItemToEnd$1.L$0 = this;
            reorderableLazyCollectionState$moveDraggingItemToEnd$1.L$1 = direction;
            reorderableLazyCollectionState$moveDraggingItemToEnd$1.label = 1;
            if (this.onMoveStateMutex.lock(reorderableLazyCollectionState$moveDraggingItemToEnd$1) == coroutineSingletons2) {
                return coroutineSingletons2;
            }
            reorderableLazyListState = this;
            direction2 = direction;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            direction2 = reorderableLazyCollectionState$moveDraggingItemToEnd$1.L$1;
            ReorderableLazyListState reorderableLazyListState2 = reorderableLazyCollectionState$moveDraggingItemToEnd$1.L$0;
            ResultKt.throwOnFailure(obj2);
            reorderableLazyListState = reorderableLazyListState2;
        }
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 draggingItemLayoutInfo = reorderableLazyListState.getDraggingItemLayoutInfo();
        LazyListState$prefetchScope$1 lazyListState$prefetchScope$3 = reorderableLazyListState.state;
        MutexImpl mutexImpl = reorderableLazyListState.onMoveStateMutex;
        if (draggingItemLayoutInfo == null) {
            mutexImpl.unlock(null);
            return unit;
        }
        LazyListMeasuredItem lazyListMeasuredItem = draggingItemLayoutInfo.$this_toLazyCollectionItemInfo;
        int iOrdinal = direction2.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$2 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) CollectionsKt.lastOrNull(lazyListState$prefetchScope$3.getLayoutInfo().getVisibleItemsInfo());
            if (reorderableLazyListKt$toLazyCollectionItemInfo$2 != null) {
            }
            long jM1924reverseAxisIfNecessaryMKHz9U = reorderableLazyListState.m1924reverseAxisIfNecessaryMKHz9U(reorderableLazyListState.m1922getDraggingItemOffsetF1C5BW0$reorderable_release());
            reorderableLazyListState.m1925x5650483a(jM1924reverseAxisIfNecessaryMKHz9U);
            long jM1920getOffsetnOccac = draggingItemLayoutInfo.m1920getOffsetnOccac();
            long jM439plusMKHz9U = Offset.m439plusMKHz9U(SizeKt.Offset((int) (jM1920getOffsetnOccac >> 32), (int) (jM1920getOffsetnOccac & 4294967295L)), jM1924reverseAxisIfNecessaryMKHz9U);
            long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(draggingItemLayoutInfo.m1921getSizeYbymL2g());
            Rect rectM895Rect0a9Yr6o = IntMath.m895Rect0a9Yr6o(jM439plusMKHz9U, SizeKt.Offset(Float.intBitsToFloat((int) (jM876toSizeozmzZPI >> 32)) + Offset.m436getXimpl(jM439plusMKHz9U), Float.intBitsToFloat((int) (jM876toSizeozmzZPI & 4294967295L)) + Offset.m437getYimpl(jM439plusMKHz9U)));
            int iOrdinal2 = reorderableLazyListState.scrollMoveMode.ordinal();
            if (iOrdinal2 != 0) {
                if (iOrdinal2 != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                int iOrdinal3 = reorderableLazyListState.getOrientation$reorderable_release().ordinal();
                if (iOrdinal3 == 0) {
                    orientation = Orientation.Horizontal;
                } else {
                    if (iOrdinal3 != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    orientation = Orientation.Vertical;
                }
                int iOrdinal4 = orientation.ordinal();
                if (iOrdinal4 == 0) {
                    rectM895Rect0a9Yr6o = Rect.copy$default(rectM895Rect0a9Yr6o, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 5);
                } else {
                    if (iOrdinal4 != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    rectM895Rect0a9Yr6o = Rect.copy$default(rectM895Rect0a9Yr6o, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 10);
                }
            }
            Rect rect = rectM895Rect0a9Yr6o;
            ConnectionPool layoutInfo = lazyListState$prefetchScope$3.getLayoutInfo();
            AbsolutePixelPadding absolutePixelPadding = reorderableLazyListState.scrollThresholdPadding;
            absolutePixelPadding.getClass();
            int iOrdinal5 = ((LazyListMeasureResult) layoutInfo.delegate).orientation.ordinal();
            if (iOrdinal5 == 0) {
                collectionScrollPadding = new CollectionScrollPadding(absolutePixelPadding.top, absolutePixelPadding.bottom);
            } else {
                if (iOrdinal5 != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                collectionScrollPadding = new CollectionScrollPadding(absolutePixelPadding.start, absolutePixelPadding.end);
            }
            ScrollAreaOffsets scrollAreaOffsets = layoutInfo.getScrollAreaOffsets(collectionScrollPadding);
            float f = scrollAreaOffsets.start;
            float f2 = scrollAreaOffsets.end;
            int iOrdinal6 = ((LazyListMeasureResult) layoutInfo.delegate).orientation.ordinal();
            if (iOrdinal6 == 0) {
                coroutineSingletons = coroutineSingletons2;
                lazyListState$prefetchScope$1 = lazyListState$prefetchScope$3;
                ArrayList visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
                arrayList = new ArrayList();
                int size = visibleItemsInfo.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj3 = visibleItemsInfo.get(i3);
                    i3++;
                    ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$3 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj3;
                    ArrayList arrayList3 = visibleItemsInfo;
                    int i4 = size;
                    if (((int) (reorderableLazyListKt$toLazyCollectionItemInfo$3.m1920getOffsetnOccac() & 4294967295L)) >= f) {
                        if (((int) (reorderableLazyListKt$toLazyCollectionItemInfo$3.m1921getSizeYbymL2g() & 4294967295L)) + ((int) (reorderableLazyListKt$toLazyCollectionItemInfo$3.m1920getOffsetnOccac() & 4294967295L)) <= f2) {
                            arrayList.add(obj3);
                        }
                    }
                    visibleItemsInfo = arrayList3;
                    size = i4;
                }
            } else if (iOrdinal6 == 1) {
                ArrayList visibleItemsInfo2 = layoutInfo.getVisibleItemsInfo();
                arrayList = new ArrayList();
                int size2 = visibleItemsInfo2.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj4 = visibleItemsInfo2.get(i5);
                    i5++;
                    ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$4 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj4;
                    CoroutineSingletons coroutineSingletons3 = coroutineSingletons2;
                    if (((int) (reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac() >> 32)) >= f) {
                        lazyListState$prefetchScope$2 = lazyListState$prefetchScope$3;
                        arrayList2 = visibleItemsInfo2;
                        if (((int) (reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac() >> 32)) + ((int) (reorderableLazyListKt$toLazyCollectionItemInfo$4.m1921getSizeYbymL2g() >> 32)) <= f2) {
                            arrayList.add(obj4);
                        }
                    } else {
                        lazyListState$prefetchScope$2 = lazyListState$prefetchScope$3;
                        arrayList2 = visibleItemsInfo2;
                    }
                    lazyListState$prefetchScope$3 = lazyListState$prefetchScope$2;
                    visibleItemsInfo2 = arrayList2;
                    coroutineSingletons2 = coroutineSingletons3;
                }
                coroutineSingletons = coroutineSingletons2;
                lazyListState$prefetchScope$1 = lazyListState$prefetchScope$3;
            } else {
                coroutineSingletons = coroutineSingletons2;
                lazyListState$prefetchScope$1 = lazyListState$prefetchScope$3;
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                arrayList = null;
            }
            if (arrayList.isEmpty()) {
                arrayList = lazyListState$prefetchScope$1.getLayoutInfo().getVisibleItemsInfo();
            }
            ArrayList arrayList4 = arrayList;
            int iOrdinal7 = direction2.ordinal();
            if (iOrdinal7 == 0) {
                direction3 = Scroller.Direction.FORWARD;
            } else {
                if (iOrdinal7 != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                direction3 = Scroller.Direction.BACKWARD;
            }
            ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1FindTargetItem$default = findTargetItem$default(reorderableLazyListState, rect, arrayList4, direction3, null, 8);
            if (reorderableLazyListKt$toLazyCollectionItemInfo$1FindTargetItem$default == null) {
                ReorderableCollectionItemScopeImpl$draggableHandle$1$1$1 reorderableCollectionItemScopeImpl$draggableHandle$1$1$1 = new ReorderableCollectionItemScopeImpl$draggableHandle$1$1$1(reorderableLazyListState, draggingItemLayoutInfo, (byte) 1);
                int iOrdinal8 = direction2.ordinal();
                if (iOrdinal8 == 0) {
                    int size3 = arrayList4.size();
                    int i6 = 0;
                    do {
                        if (i6 >= size3) {
                            obj = null;
                            break;
                        }
                        obj = arrayList4.get(i6);
                        i6++;
                    } while (!((Boolean) reorderableCollectionItemScopeImpl$draggableHandle$1$1$1.invoke(obj)).booleanValue());
                    reorderableLazyListKt$toLazyCollectionItemInfo$1 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj;
                } else {
                    if (iOrdinal8 != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    ListIterator listIterator = arrayList4.listIterator(arrayList4.size());
                    do {
                        if (!listIterator.hasPrevious()) {
                            objPrevious = null;
                            break;
                        }
                        objPrevious = listIterator.previous();
                    } while (!((Boolean) reorderableCollectionItemScopeImpl$draggableHandle$1$1$1.invoke(objPrevious)).booleanValue());
                    reorderableLazyListKt$toLazyCollectionItemInfo$1 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) objPrevious;
                }
                reorderableLazyListKt$toLazyCollectionItemInfo$1FindTargetItem$default = reorderableLazyListKt$toLazyCollectionItemInfo$1;
            }
            ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$5 = reorderableLazyListKt$toLazyCollectionItemInfo$1FindTargetItem$default;
            if (reorderableLazyListKt$toLazyCollectionItemInfo$5 == null) {
                mutexImpl.unlock(null);
                return unit;
            }
            LazyListMeasuredItem lazyListMeasuredItem2 = reorderableLazyListKt$toLazyCollectionItemInfo$5.$this_toLazyCollectionItemInfo;
            int iOrdinal9 = direction2.ordinal();
            if (iOrdinal9 != 0) {
                if (iOrdinal9 != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0139  */
    /* JADX WARN: Code duplicated, block: B:60:0x013a A[Catch: all -> 0x0043, PHI: r0 r1 r2 r3
      0x013a: PHI (r0v9 sh.calvin.reorderable.ReorderableLazyListState) = (r0v6 sh.calvin.reorderable.ReorderableLazyListState), (r0v16 sh.calvin.reorderable.ReorderableLazyListState) binds: [B:58:0x0137, B:23:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x013a: PHI (r1v9 kotlinx.coroutines.sync.Mutex) = (r1v19 kotlinx.coroutines.sync.Mutex), (r1v20 kotlinx.coroutines.sync.Mutex) binds: [B:58:0x0137, B:23:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x013a: PHI (r2v6 sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1) = 
      (r2v3 sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1)
      (r2v27 sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1)
     binds: [B:58:0x0137, B:23:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x013a: PHI (r3v9 ??) = (r3v19 ??), (r3v18 ??) binds: [B:58:0x0137, B:23:0x0059] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0043, blocks: (B:15:0x003e, B:67:0x01ab, B:22:0x0056, B:60:0x013a, B:62:0x0144, B:64:0x018b, B:63:0x0182, B:25:0x0068, B:57:0x010d), top: B:74:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0144 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:15:0x003e, B:67:0x01ab, B:22:0x0056, B:60:0x013a, B:62:0x0144, B:64:0x018b, B:63:0x0182, B:25:0x0068, B:57:0x010d), top: B:74:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0182 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:15:0x003e, B:67:0x01ab, B:22:0x0056, B:60:0x013a, B:62:0x0144, B:64:0x018b, B:63:0x0182, B:25:0x0068, B:57:0x010d), top: B:74:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a8, code lost:
    
        if (kotlinx.coroutines.AwaitKt.withTimeout(1000, r2, r4) == r12) goto L66;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object, sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1] */
    /* JADX WARN: Type inference failed for: r5v24, types: [sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object moveItems(ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1, ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$2, ContinuationImpl continuationImpl) throws Throwable {
        ReorderableLazyCollectionState$moveItems$1 reorderableLazyCollectionState$moveItems$1;
        Mutex mutex;
        ?? r1;
        ReorderableLazyListState reorderableLazyListState;
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$3;
        ?? r2;
        Mutex mutex2;
        ?? r3;
        Mutex mutex3;
        Function4 function4;
        CoroutineScope coroutineScope;
        LazyListMeasuredItem lazyListMeasuredItem;
        LazyListMeasuredItem lazyListMeasuredItem2;
        ?? r4;
        Mutex mutex4;
        IntOffset intOffset;
        ReorderableLazyListState reorderableLazyListState2 = this;
        ?? r5 = reorderableLazyListKt$toLazyCollectionItemInfo$1;
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$4 = reorderableLazyListKt$toLazyCollectionItemInfo$2;
        if (continuationImpl instanceof ReorderableLazyCollectionState$moveItems$1) {
            reorderableLazyCollectionState$moveItems$1 = (ReorderableLazyCollectionState$moveItems$1) continuationImpl;
            int i = reorderableLazyCollectionState$moveItems$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                reorderableLazyCollectionState$moveItems$1.label = i - Integer.MIN_VALUE;
            } else {
                reorderableLazyCollectionState$moveItems$1 = new ReorderableLazyCollectionState$moveItems$1(reorderableLazyListState2, continuationImpl);
            }
        } else {
            reorderableLazyCollectionState$moveItems$1 = new ReorderableLazyCollectionState$moveItems$1(reorderableLazyListState2, continuationImpl);
        }
        Object obj = reorderableLazyCollectionState$moveItems$1.result;
        int i2 = reorderableLazyCollectionState$moveItems$1.label;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (r5.$this_toLazyCollectionItemInfo.index != reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo.index) {
                            mutex = reorderableLazyListState2.onMoveStateMutex;
                            reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                            reorderableLazyCollectionState$moveItems$1.L$1 = r5;
                            reorderableLazyCollectionState$moveItems$1.L$2 = reorderableLazyListKt$toLazyCollectionItemInfo$4;
                            reorderableLazyCollectionState$moveItems$1.L$3 = mutex;
                            reorderableLazyCollectionState$moveItems$1.label = 1;
                            if (mutex.lock(reorderableLazyCollectionState$moveItems$1) != coroutineSingletons) {
                            }
                            r1 = r5;
                            return coroutineSingletons;
                        }
                        return unit;
                    }
                    if (i2 == 1) {
                        Mutex mutex5 = reorderableLazyCollectionState$moveItems$1.L$3;
                        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$5 = reorderableLazyCollectionState$moveItems$1.L$2;
                        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$6 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) reorderableLazyCollectionState$moveItems$1.L$1;
                        ReorderableLazyListState reorderableLazyListState3 = reorderableLazyCollectionState$moveItems$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        reorderableLazyListKt$toLazyCollectionItemInfo$4 = reorderableLazyListKt$toLazyCollectionItemInfo$5;
                        r1 = reorderableLazyListKt$toLazyCollectionItemInfo$6;
                        mutex = mutex5;
                        reorderableLazyListState2 = reorderableLazyListState3;
                    } else {
                        if (i2 == 2) {
                            Mutex mutex6 = reorderableLazyCollectionState$moveItems$1.L$3;
                            reorderableLazyListKt$toLazyCollectionItemInfo$3 = reorderableLazyCollectionState$moveItems$1.L$2;
                            ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$7 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) reorderableLazyCollectionState$moveItems$1.L$1;
                            reorderableLazyListState = reorderableLazyCollectionState$moveItems$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            mutex2 = mutex6;
                            r2 = reorderableLazyListKt$toLazyCollectionItemInfo$7;
                            r3 = r2;
                            reorderableLazyListKt$toLazyCollectionItemInfo$4 = reorderableLazyListKt$toLazyCollectionItemInfo$3;
                            reorderableLazyListState2 = reorderableLazyListState;
                            mutex3 = mutex2;
                            reorderableLazyListState2.oldDraggingItemIndex$delegate.setValue(new Integer(r3.$this_toLazyCollectionItemInfo.index));
                            function4 = (Function4) reorderableLazyListState2.onMoveState.getValue();
                            coroutineScope = reorderableLazyListState2.scope;
                            lazyListMeasuredItem = r3.$this_toLazyCollectionItemInfo;
                            lazyListMeasuredItem2 = reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo;
                            reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                            reorderableLazyCollectionState$moveItems$1.L$1 = r3;
                            reorderableLazyCollectionState$moveItems$1.L$2 = reorderableLazyListKt$toLazyCollectionItemInfo$4;
                            reorderableLazyCollectionState$moveItems$1.L$3 = mutex3;
                            reorderableLazyCollectionState$moveItems$1.label = 3;
                            mutex4 = mutex3;
                            r4 = r3;
                            if (function4.invoke(coroutineScope, lazyListMeasuredItem, lazyListMeasuredItem2, reorderableLazyCollectionState$moveItems$1) != coroutineSingletons) {
                                if (reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo.index > r4.$this_toLazyCollectionItemInfo.index) {
                                    long jM1920getOffsetnOccac = reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac();
                                    long jM1921getSizeYbymL2g = reorderableLazyListKt$toLazyCollectionItemInfo$4.m1921getSizeYbymL2g();
                                    long jIntOffset = SQLite.IntOffset(((int) (jM1920getOffsetnOccac >> 32)) + ((int) (jM1921getSizeYbymL2g >> 32)), ((int) (jM1920getOffsetnOccac & 4294967295L)) + ((int) (jM1921getSizeYbymL2g & 4294967295L)));
                                    long jM1921getSizeYbymL2g2 = r4.m1921getSizeYbymL2g();
                                    intOffset = new IntOffset(SQLite.IntOffset(((int) (jIntOffset >> 32)) - ((int) (jM1921getSizeYbymL2g2 >> 32)), ((int) (jIntOffset & 4294967295L)) - ((int) (4294967295L & jM1921getSizeYbymL2g2))));
                                } else {
                                    intOffset = new IntOffset(reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac());
                                }
                                reorderableLazyListState2.predictedDraggingItemOffset$delegate.setValue(intOffset);
                                HazeSourceNode.AnonymousClass1 anonymousClass1 = new HazeSourceNode.AnonymousClass1(reorderableLazyListState2, continuation, (byte) 9);
                                reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                                reorderableLazyCollectionState$moveItems$1.L$1 = mutex4;
                                reorderableLazyCollectionState$moveItems$1.L$2 = null;
                                reorderableLazyCollectionState$moveItems$1.L$3 = null;
                                reorderableLazyCollectionState$moveItems$1.label = 4;
                                r5 = mutex4;
                            }
                            r1 = r5;
                            return coroutineSingletons;
                        }
                        if (i2 == 3) {
                            Mutex mutex7 = reorderableLazyCollectionState$moveItems$1.L$3;
                            ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$8 = reorderableLazyCollectionState$moveItems$1.L$2;
                            ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$9 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) reorderableLazyCollectionState$moveItems$1.L$1;
                            ReorderableLazyListState reorderableLazyListState4 = reorderableLazyCollectionState$moveItems$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            r4 = reorderableLazyListKt$toLazyCollectionItemInfo$9;
                            reorderableLazyListKt$toLazyCollectionItemInfo$4 = reorderableLazyListKt$toLazyCollectionItemInfo$8;
                            reorderableLazyListState2 = reorderableLazyListState4;
                            mutex4 = mutex7;
                            if (reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo.index > r4.$this_toLazyCollectionItemInfo.index) {
                                long jM1920getOffsetnOccac2 = reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac();
                                long jM1921getSizeYbymL2g3 = reorderableLazyListKt$toLazyCollectionItemInfo$4.m1921getSizeYbymL2g();
                                long jIntOffset2 = SQLite.IntOffset(((int) (jM1920getOffsetnOccac2 >> 32)) + ((int) (jM1921getSizeYbymL2g3 >> 32)), ((int) (jM1920getOffsetnOccac2 & 4294967295L)) + ((int) (jM1921getSizeYbymL2g3 & 4294967295L)));
                                long jM1921getSizeYbymL2g4 = r4.m1921getSizeYbymL2g();
                                intOffset = new IntOffset(SQLite.IntOffset(((int) (jIntOffset2 >> 32)) - ((int) (jM1921getSizeYbymL2g4 >> 32)), ((int) (jIntOffset2 & 4294967295L)) - ((int) (4294967295L & jM1921getSizeYbymL2g4))));
                            } else {
                                intOffset = new IntOffset(reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac());
                            }
                            reorderableLazyListState2.predictedDraggingItemOffset$delegate.setValue(intOffset);
                            HazeSourceNode.AnonymousClass1 anonymousClass2 = new HazeSourceNode.AnonymousClass1(reorderableLazyListState2, continuation, (byte) 9);
                            reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                            reorderableLazyCollectionState$moveItems$1.L$1 = mutex4;
                            reorderableLazyCollectionState$moveItems$1.L$2 = null;
                            reorderableLazyCollectionState$moveItems$1.L$3 = null;
                            reorderableLazyCollectionState$moveItems$1.label = 4;
                            r5 = mutex4;
                        } else {
                            if (i2 != 4) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            Mutex mutex8 = (Mutex) reorderableLazyCollectionState$moveItems$1.L$1;
                            reorderableLazyListState2 = reorderableLazyCollectionState$moveItems$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            r5 = mutex8;
                        }
                    }
                    reorderableLazyListState2.oldDraggingItemIndex$delegate.setValue(null);
                    reorderableLazyListState2.predictedDraggingItemOffset$delegate.setValue(null);
                    r5.unlock(null);
                    return unit;
                    r1 = r5;
                    boolean zIsAnyItemDragging = reorderableLazyListState2.isAnyItemDragging();
                    LazyListState$prefetchScope$1 lazyListState$prefetchScope$1 = reorderableLazyListState2.state;
                    if (!zIsAnyItemDragging) {
                        mutex.unlock(null);
                        return unit;
                    }
                    int i3 = r1.$this_toLazyCollectionItemInfo.index;
                    LazyListState lazyListState = lazyListState$prefetchScope$1.this$0;
                    LazyListState lazyListState2 = lazyListState$prefetchScope$1.this$0;
                    if (i3 == lazyListState.getFirstVisibleItemIndex() || reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo.index == lazyListState2.getFirstVisibleItemIndex()) {
                        int firstVisibleItemIndex = lazyListState2.getFirstVisibleItemIndex();
                        int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
                        reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                        reorderableLazyCollectionState$moveItems$1.L$1 = r1;
                        reorderableLazyCollectionState$moveItems$1.L$2 = reorderableLazyListKt$toLazyCollectionItemInfo$4;
                        reorderableLazyCollectionState$moveItems$1.L$3 = mutex;
                        reorderableLazyCollectionState$moveItems$1.label = 2;
                        byte b = 0;
                        if (lazyListState2.scrollableState.isScrollInProgress()) {
                            AwaitKt.launch$default(((LazyListMeasureResult) lazyListState2.layoutInfoState.getValue()).coroutineScope, null, null, new LazyListState$requestScrollToItem$1(lazyListState2, continuation, b), 3);
                        }
                        lazyListState2.snapToItemIndexInternal$foundation(firstVisibleItemIndex, false, firstVisibleItemScrollOffset);
                        if (unit != coroutineSingletons) {
                            reorderableLazyListState = reorderableLazyListState2;
                            reorderableLazyListKt$toLazyCollectionItemInfo$3 = reorderableLazyListKt$toLazyCollectionItemInfo$4;
                            r2 = r1;
                            mutex2 = mutex;
                            r3 = r2;
                            reorderableLazyListKt$toLazyCollectionItemInfo$4 = reorderableLazyListKt$toLazyCollectionItemInfo$3;
                            reorderableLazyListState2 = reorderableLazyListState;
                            mutex3 = mutex2;
                            reorderableLazyListState2.oldDraggingItemIndex$delegate.setValue(new Integer(r3.$this_toLazyCollectionItemInfo.index));
                            function4 = (Function4) reorderableLazyListState2.onMoveState.getValue();
                            coroutineScope = reorderableLazyListState2.scope;
                            lazyListMeasuredItem = r3.$this_toLazyCollectionItemInfo;
                            lazyListMeasuredItem2 = reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo;
                            reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                            reorderableLazyCollectionState$moveItems$1.L$1 = r3;
                            reorderableLazyCollectionState$moveItems$1.L$2 = reorderableLazyListKt$toLazyCollectionItemInfo$4;
                            reorderableLazyCollectionState$moveItems$1.L$3 = mutex3;
                            reorderableLazyCollectionState$moveItems$1.label = 3;
                            mutex4 = mutex3;
                            r4 = r3;
                            if (function4.invoke(coroutineScope, lazyListMeasuredItem, lazyListMeasuredItem2, reorderableLazyCollectionState$moveItems$1) != coroutineSingletons) {
                                if (reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo.index > r4.$this_toLazyCollectionItemInfo.index) {
                                    long jM1920getOffsetnOccac3 = reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac();
                                    long jM1921getSizeYbymL2g5 = reorderableLazyListKt$toLazyCollectionItemInfo$4.m1921getSizeYbymL2g();
                                    long jIntOffset3 = SQLite.IntOffset(((int) (jM1920getOffsetnOccac3 >> 32)) + ((int) (jM1921getSizeYbymL2g5 >> 32)), ((int) (jM1920getOffsetnOccac3 & 4294967295L)) + ((int) (jM1921getSizeYbymL2g5 & 4294967295L)));
                                    long jM1921getSizeYbymL2g6 = r4.m1921getSizeYbymL2g();
                                    intOffset = new IntOffset(SQLite.IntOffset(((int) (jIntOffset3 >> 32)) - ((int) (jM1921getSizeYbymL2g6 >> 32)), ((int) (jIntOffset3 & 4294967295L)) - ((int) (4294967295L & jM1921getSizeYbymL2g6))));
                                } else {
                                    intOffset = new IntOffset(reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac());
                                }
                                reorderableLazyListState2.predictedDraggingItemOffset$delegate.setValue(intOffset);
                                HazeSourceNode.AnonymousClass1 anonymousClass3 = new HazeSourceNode.AnonymousClass1(reorderableLazyListState2, continuation, (byte) 9);
                                reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                                reorderableLazyCollectionState$moveItems$1.L$1 = mutex4;
                                reorderableLazyCollectionState$moveItems$1.L$2 = null;
                                reorderableLazyCollectionState$moveItems$1.L$3 = null;
                                reorderableLazyCollectionState$moveItems$1.label = 4;
                                r5 = mutex4;
                            }
                        }
                    } else {
                        Mutex mutex9 = mutex;
                        r3 = r1;
                        mutex3 = mutex9;
                        reorderableLazyListState2.oldDraggingItemIndex$delegate.setValue(new Integer(r3.$this_toLazyCollectionItemInfo.index));
                        function4 = (Function4) reorderableLazyListState2.onMoveState.getValue();
                        coroutineScope = reorderableLazyListState2.scope;
                        lazyListMeasuredItem = r3.$this_toLazyCollectionItemInfo;
                        lazyListMeasuredItem2 = reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo;
                        reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                        reorderableLazyCollectionState$moveItems$1.L$1 = r3;
                        reorderableLazyCollectionState$moveItems$1.L$2 = reorderableLazyListKt$toLazyCollectionItemInfo$4;
                        reorderableLazyCollectionState$moveItems$1.L$3 = mutex3;
                        reorderableLazyCollectionState$moveItems$1.label = 3;
                        mutex4 = mutex3;
                        r4 = r3;
                        if (function4.invoke(coroutineScope, lazyListMeasuredItem, lazyListMeasuredItem2, reorderableLazyCollectionState$moveItems$1) != coroutineSingletons) {
                            if (reorderableLazyListKt$toLazyCollectionItemInfo$4.$this_toLazyCollectionItemInfo.index > r4.$this_toLazyCollectionItemInfo.index) {
                                long jM1920getOffsetnOccac4 = reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac();
                                long jM1921getSizeYbymL2g7 = reorderableLazyListKt$toLazyCollectionItemInfo$4.m1921getSizeYbymL2g();
                                long jIntOffset4 = SQLite.IntOffset(((int) (jM1920getOffsetnOccac4 >> 32)) + ((int) (jM1921getSizeYbymL2g7 >> 32)), ((int) (jM1920getOffsetnOccac4 & 4294967295L)) + ((int) (jM1921getSizeYbymL2g7 & 4294967295L)));
                                long jM1921getSizeYbymL2g8 = r4.m1921getSizeYbymL2g();
                                intOffset = new IntOffset(SQLite.IntOffset(((int) (jIntOffset4 >> 32)) - ((int) (jM1921getSizeYbymL2g8 >> 32)), ((int) (jIntOffset4 & 4294967295L)) - ((int) (4294967295L & jM1921getSizeYbymL2g8))));
                            } else {
                                intOffset = new IntOffset(reorderableLazyListKt$toLazyCollectionItemInfo$4.m1920getOffsetnOccac());
                            }
                            reorderableLazyListState2.predictedDraggingItemOffset$delegate.setValue(intOffset);
                            HazeSourceNode.AnonymousClass1 anonymousClass4 = new HazeSourceNode.AnonymousClass1(reorderableLazyListState2, continuation, (byte) 9);
                            reorderableLazyCollectionState$moveItems$1.L$0 = reorderableLazyListState2;
                            reorderableLazyCollectionState$moveItems$1.L$1 = mutex4;
                            reorderableLazyCollectionState$moveItems$1.L$2 = null;
                            reorderableLazyCollectionState$moveItems$1.L$3 = null;
                            reorderableLazyCollectionState$moveItems$1.label = 4;
                            r5 = mutex4;
                        }
                    }
                    r1 = r5;
                    return coroutineSingletons;
                } catch (Throwable th) {
                    th = th;
                    r5 = mutex;
                    r5.unlock(null);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (CancellationException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: onDragStart-d-4ec7I$reorderable_release, reason: not valid java name */
    public final Object m1923onDragStartd4ec7I$reorderable_release(Object obj, long j, ContinuationImpl continuationImpl) {
        ReorderableLazyCollectionState$onDragStart$1 reorderableLazyCollectionState$onDragStart$1;
        Object obj2;
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1;
        long j2;
        if (continuationImpl instanceof ReorderableLazyCollectionState$onDragStart$1) {
            reorderableLazyCollectionState$onDragStart$1 = (ReorderableLazyCollectionState$onDragStart$1) continuationImpl;
            int i = reorderableLazyCollectionState$onDragStart$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                reorderableLazyCollectionState$onDragStart$1.label = i - Integer.MIN_VALUE;
            } else {
                reorderableLazyCollectionState$onDragStart$1 = new ReorderableLazyCollectionState$onDragStart$1(this, continuationImpl);
            }
        } else {
            reorderableLazyCollectionState$onDragStart$1 = new ReorderableLazyCollectionState$onDragStart$1(this, continuationImpl);
        }
        Object obj3 = reorderableLazyCollectionState$onDragStart$1.result;
        int i2 = reorderableLazyCollectionState$onDragStart$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            LazyListState$prefetchScope$1 lazyListState$prefetchScope$1 = this.state;
            ArrayList visibleItemsInfo = lazyListState$prefetchScope$1.getLayoutInfo().getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            int i3 = 0;
            do {
                if (i3 >= size) {
                    obj2 = null;
                    break;
                }
                obj2 = visibleItemsInfo.get(i3);
                i3++;
            } while (!((ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj2).$this_toLazyCollectionItemInfo.key.equals(obj));
            reorderableLazyListKt$toLazyCollectionItemInfo$1 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj2;
            if (reorderableLazyListKt$toLazyCollectionItemInfo$1 != null) {
                long jM1920getOffsetnOccac = reorderableLazyListKt$toLazyCollectionItemInfo$1.m1920getOffsetnOccac();
                int iOrdinal = getOrientation$reorderable_release().ordinal();
                if (iOrdinal == 0) {
                    j2 = jM1920getOffsetnOccac & 4294967295L;
                } else {
                    if (iOrdinal != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    j2 = jM1920getOffsetnOccac >> 32;
                }
                int i4 = (int) j2;
                if (i4 < 0) {
                    SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7);
                    reorderableLazyCollectionState$onDragStart$1.L$0 = this;
                    reorderableLazyCollectionState$onDragStart$1.L$1 = obj;
                    reorderableLazyCollectionState$onDragStart$1.L$3 = reorderableLazyListKt$toLazyCollectionItemInfo$1;
                    reorderableLazyCollectionState$onDragStart$1.J$0 = j;
                    reorderableLazyCollectionState$onDragStart$1.label = 1;
                    Object objAnimateScrollBy = ScrollableKt.animateScrollBy(lazyListState$prefetchScope$1.this$0, i4, springSpecSpring$default, reorderableLazyCollectionState$onDragStart$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimateScrollBy == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        j = reorderableLazyCollectionState$onDragStart$1.J$0;
        ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$2 = reorderableLazyCollectionState$onDragStart$1.L$3;
        obj = reorderableLazyCollectionState$onDragStart$1.L$1;
        ReorderableLazyListState reorderableLazyListState = reorderableLazyCollectionState$onDragStart$1.L$0;
        ResultKt.throwOnFailure(obj3);
        reorderableLazyListKt$toLazyCollectionItemInfo$1 = reorderableLazyListKt$toLazyCollectionItemInfo$2;
        this = reorderableLazyListState;
        this.draggingItemKey$delegate.setValue(obj);
        this.draggingItemInitialOffset$delegate.setValue(new IntOffset(reorderableLazyListKt$toLazyCollectionItemInfo$1.m1920getOffsetnOccac()));
        this.draggingItemHandleOffset = j;
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: reverseAxisIfNecessary-MK-Hz9U, reason: not valid java name */
    public final long m1924reverseAxisIfNecessaryMKHz9U(long j) {
        ((LazyListMeasureResult) this.state.getLayoutInfo().delegate).getClass();
        int iOrdinal = getOrientation$reorderable_release().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return 0L;
            }
            int iOrdinal2 = this.layoutDirection.ordinal();
            if (iOrdinal2 != 0) {
                if (iOrdinal2 != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return 0L;
                }
                Orientation orientation = Orientation.Horizontal;
                orientation.getClass();
                int iOrdinal3 = orientation.ordinal();
                if (iOrdinal3 == 0) {
                    return SizeKt.Offset(Offset.m436getXimpl(j), -Offset.m437getYimpl(j));
                }
                if (iOrdinal3 == 1) {
                    return SizeKt.Offset(-Offset.m436getXimpl(j), Offset.m437getYimpl(j));
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return 0L;
            }
        }
        return j;
    }

    /* JADX INFO: renamed from: reverseAxisWithLayoutDirectionIfLazyVerticalStaggeredGridRtlFix-MK-Hz9U, reason: not valid java name */
    public final long m1925x5650483a(long j) {
        int iOrdinal = this.layoutDirection.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return j;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return 0L;
    }
}
