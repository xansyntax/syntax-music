package sh.calvin.reorderable;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListState$prefetchScope$1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.sqlite.SQLite;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableCollectionItemScopeImpl$draggableHandle$1 extends Lambda implements Function3 {
    public final /* synthetic */ DragGestureDetector$Press $dragGestureDetector;
    public final /* synthetic */ Function1 $onDragStarted;
    public final /* synthetic */ Function0 $onDragStopped;
    public final /* synthetic */ ReorderableCollectionItemScopeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReorderableCollectionItemScopeImpl$draggableHandle$1(ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl, DragGestureDetector$Press dragGestureDetector$Press, Function1 function1, Function0 function0) {
        super(3);
        this.this$0 = reorderableCollectionItemScopeImpl;
        this.$dragGestureDetector = dragGestureDetector$Press;
        this.$onDragStarted = function1;
        this.$onDragStopped = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Modifier modifier = (Modifier) obj;
        ((Number) obj3).intValue();
        final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl = this.this$0;
        final ReorderableLazyListState reorderableLazyListState = reorderableCollectionItemScopeImpl.reorderableLazyCollectionState;
        modifier.getClass();
        GapComposer gapComposer = (GapComposer) ((Composer) obj2);
        gapComposer.startReplaceGroup(231415144);
        gapComposer.startReplaceGroup(-1020090083);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Stack.mutableStateOf$default(new Offset(0L));
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        gapComposer.end(false);
        gapComposer.startReplaceGroup(-1020087938);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = Stack.mutableStateOf$default(new IntSize(0L));
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) objRememberedValue2;
        gapComposer.end(false);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (objRememberedValue3 == neverEqualPolicy) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(Stack.createCompositionCoroutineScope(gapComposer));
            gapComposer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue3 = compositionScopedCoroutineScopeCanceller;
        }
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).coroutineScope;
        gapComposer.startReplaceGroup(-1020083824);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (objRememberedValue4 == neverEqualPolicy) {
            objRememberedValue4 = new ReorderableCollectionItemScopeImpl$draggableHandle$1$1$1(mutableState, mutableState2, (byte) 0);
            gapComposer.updateRememberedValue(objRememberedValue4);
        }
        gapComposer.end(false);
        Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(modifier, (Function1) objRememberedValue4);
        final boolean z = true;
        if (!((Boolean) SnapshotStateKt__DerivedStateKt.derivedStateOf(new ScrollerKt$rememberScroller$3$1(reorderableCollectionItemScopeImpl.key, reorderableLazyListState, (byte) 2)).getValue()).booleanValue() && reorderableLazyListState.isAnyItemDragging()) {
            z = false;
        }
        gapComposer.startReplaceGroup(-1020069521);
        boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | gapComposer.changed(reorderableCollectionItemScopeImpl);
        final Function1 function1 = this.$onDragStarted;
        boolean zChanged = zChangedInstance | gapComposer.changed(function1);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue5 == neverEqualPolicy) {
            Function1 function2 = new Function1() { // from class: sh.calvin.reorderable.ReorderableCollectionItemScopeImpl$draggableHandle$1$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    Offset offset = (Offset) obj4;
                    long j = offset.packedValue;
                    AwaitKt.launch$default(coroutineScope, null, null, new DataStoreKt$get$2((Object) reorderableCollectionItemScopeImpl, (Object) mutableState, (Object) mutableState2, (Continuation) null, (byte) 28), 3);
                    function1.invoke(offset);
                    return Unit.INSTANCE;
                }
            };
            gapComposer.updateRememberedValue(function2);
            objRememberedValue5 = function2;
        }
        final Function1 function3 = (Function1) objRememberedValue5;
        gapComposer.end(false);
        gapComposer.startReplaceGroup(-1020052768);
        boolean zChanged2 = gapComposer.changed(reorderableCollectionItemScopeImpl);
        Function0 function0 = this.$onDragStopped;
        boolean zChanged3 = zChanged2 | gapComposer.changed(function0);
        Object objRememberedValue6 = gapComposer.rememberedValue();
        if (zChanged3 || objRememberedValue6 == neverEqualPolicy) {
            objRememberedValue6 = new ScrollerKt$rememberScroller$3$1(reorderableCollectionItemScopeImpl, function0, z);
            gapComposer.updateRememberedValue(objRememberedValue6);
        }
        final Function0 function4 = (Function0) objRememberedValue6;
        gapComposer.end(false);
        gapComposer.startReplaceGroup(-1020048579);
        boolean zChanged4 = gapComposer.changed(reorderableCollectionItemScopeImpl);
        Object objRememberedValue7 = gapComposer.rememberedValue();
        if (zChanged4 || objRememberedValue7 == neverEqualPolicy) {
            objRememberedValue7 = new Function2() { // from class: sh.calvin.reorderable.ReorderableCollectionItemScopeImpl$draggableHandle$1$4$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    CollectionScrollPadding collectionScrollPadding;
                    long jM439plusMKHz9U;
                    long jIntOffset;
                    boolean z2;
                    boolean zStart$reorderable_release;
                    ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1FindTargetItem$default;
                    Object obj6;
                    PointerInputChange pointerInputChange = (PointerInputChange) obj4;
                    long j = ((Offset) obj5).packedValue;
                    pointerInputChange.getClass();
                    pointerInputChange.consume();
                    ReorderableLazyListState reorderableLazyListState2 = reorderableCollectionItemScopeImpl.reorderableLazyCollectionState;
                    MutexImpl mutexImpl = reorderableLazyListState2.onMoveStateMutex;
                    Scroller scroller = reorderableLazyListState2.scroller;
                    LazyListState$prefetchScope$1 lazyListState$prefetchScope$1 = reorderableLazyListState2.state;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = reorderableLazyListState2.draggingItemDraggedDelta$delegate;
                    parcelableSnapshotMutableState.setValue(new Offset(Offset.m439plusMKHz9U(((Offset) parcelableSnapshotMutableState.getValue()).packedValue, j)));
                    ReorderableLazyListKt$toLazyCollectionItemInfo$1 draggingItemLayoutInfo = reorderableLazyListState2.getDraggingItemLayoutInfo();
                    if (draggingItemLayoutInfo != null) {
                        long jM1924reverseAxisIfNecessaryMKHz9U = reorderableLazyListState2.m1924reverseAxisIfNecessaryMKHz9U(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release());
                        reorderableLazyListState2.m1925x5650483a(jM1924reverseAxisIfNecessaryMKHz9U);
                        long jM1920getOffsetnOccac = draggingItemLayoutInfo.m1920getOffsetnOccac();
                        long jM439plusMKHz9U2 = Offset.m439plusMKHz9U(SizeKt.Offset((int) (jM1920getOffsetnOccac >> 32), (int) (jM1920getOffsetnOccac & 4294967295L)), jM1924reverseAxisIfNecessaryMKHz9U);
                        long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(draggingItemLayoutInfo.m1921getSizeYbymL2g());
                        long jOffset = SizeKt.Offset(Float.intBitsToFloat((int) (jM876toSizeozmzZPI >> 32)) + Offset.m436getXimpl(jM439plusMKHz9U2), Float.intBitsToFloat((int) (jM876toSizeozmzZPI & 4294967295L)) + Offset.m437getYimpl(jM439plusMKHz9U2));
                        ConnectionPool layoutInfo = lazyListState$prefetchScope$1.getLayoutInfo();
                        AbsolutePixelPadding absolutePixelPadding = reorderableLazyListState2.scrollThresholdPadding;
                        absolutePixelPadding.getClass();
                        int iOrdinal = ((LazyListMeasureResult) layoutInfo.delegate).orientation.ordinal();
                        if (iOrdinal == 0) {
                            collectionScrollPadding = new CollectionScrollPadding(absolutePixelPadding.top, absolutePixelPadding.bottom);
                        } else {
                            if (iOrdinal != 1) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            collectionScrollPadding = new CollectionScrollPadding(absolutePixelPadding.start, absolutePixelPadding.end);
                        }
                        ScrollAreaOffsets scrollAreaOffsets = layoutInfo.getScrollAreaOffsets(collectionScrollPadding);
                        float f = scrollAreaOffsets.start;
                        float f2 = scrollAreaOffsets.end;
                        ((LazyListMeasureResult) lazyListState$prefetchScope$1.getLayoutInfo().delegate).getClass();
                        boolean z3 = reorderableLazyListState2.layoutDirection == LayoutDirection.Rtl && reorderableLazyListState2.getOrientation$reorderable_release() == Orientation.Horizontal;
                        if (z3) {
                            jM439plusMKHz9U = Offset.m438minusMKHz9U(jOffset, reorderableLazyListState2.draggingItemHandleOffset);
                        } else {
                            if (z3) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            jM439plusMKHz9U = Offset.m439plusMKHz9U(jM439plusMKHz9U2, reorderableLazyListState2.draggingItemHandleOffset);
                        }
                        Orientation orientation$reorderable_release = reorderableLazyListState2.getOrientation$reorderable_release();
                        int i = -((LazyListMeasureResult) lazyListState$prefetchScope$1.getLayoutInfo().delegate).viewportStartOffset;
                        int iOrdinal2 = orientation$reorderable_release.ordinal();
                        if (iOrdinal2 == 0) {
                            jIntOffset = SQLite.IntOffset(0, i);
                        } else {
                            if (iOrdinal2 != 1) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            jIntOffset = SQLite.IntOffset(i, 0);
                        }
                        long jM439plusMKHz9U3 = Offset.m439plusMKHz9U(jM439plusMKHz9U, SizeKt.Offset((int) (jIntOffset >> 32), (int) (jIntOffset & 4294967295L)));
                        float fM1881getAxis3MmeM6k = HexFormatKt.m1881getAxis3MmeM6k(jM439plusMKHz9U3, reorderableLazyListState2.getOrientation$reorderable_release()) - f;
                        if (fM1881getAxis3MmeM6k < CropImageView.DEFAULT_ASPECT_RATIO) {
                            fM1881getAxis3MmeM6k = 0.0f;
                        }
                        float fM1881getAxis3MmeM6k2 = f2 - HexFormatKt.m1881getAxis3MmeM6k(jM439plusMKHz9U3, reorderableLazyListState2.getOrientation$reorderable_release());
                        if (fM1881getAxis3MmeM6k2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                            fM1881getAxis3MmeM6k2 = 0.0f;
                        }
                        float f3 = reorderableLazyListState2.scrollThreshold;
                        if (fM1881getAxis3MmeM6k < f3) {
                            zStart$reorderable_release = scroller.start$reorderable_release(Scroller.Direction.BACKWARD, (1.0f - UuidKt.coerceIn((fM1881getAxis3MmeM6k + f3) / (f3 * 2.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f)) * 10.0f, new ReorderableLazyCollectionState$layoutInfoFlow$1(reorderableLazyListState2, (byte) 2), new ReorderableLazyCollectionState$onDrag$isScrollingStarted$2(reorderableLazyListState2, null, (byte) 0));
                            z2 = true;
                        } else if (fM1881getAxis3MmeM6k2 < f3) {
                            z2 = true;
                            zStart$reorderable_release = scroller.start$reorderable_release(Scroller.Direction.FORWARD, (1.0f - UuidKt.coerceIn((fM1881getAxis3MmeM6k2 + f3) / (f3 * 2.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f)) * 10.0f, new ReorderableLazyCollectionState$layoutInfoFlow$1(reorderableLazyListState2, (byte) 3), new ReorderableLazyCollectionState$onDrag$isScrollingStarted$2(reorderableLazyListState2, null, (byte) 1));
                        } else {
                            z2 = true;
                            AwaitKt.launch$default(scroller.scope, null, null, new Scroller$start$3(scroller, null, (byte) 1), 3);
                            zStart$reorderable_release = false;
                        }
                        if (mutexImpl.tryLock()) {
                            StandaloneCoroutine standaloneCoroutine = scroller.programmaticScrollJob;
                            if ((standaloneCoroutine != null && standaloneCoroutine.isActive() == z2) || zStart$reorderable_release || (reorderableLazyListKt$toLazyCollectionItemInfo$1FindTargetItem$default = ReorderableLazyListState.findTargetItem$default(reorderableLazyListState2, IntMath.m895Rect0a9Yr6o(jM439plusMKHz9U2, jOffset), lazyListState$prefetchScope$1.getLayoutInfo().getVisibleItemsInfo(), null, new ReorderableLazyCollectionState$onDrag$targetItem$1((byte) 0, draggingItemLayoutInfo), 4)) == null) {
                                obj6 = null;
                            } else {
                                obj6 = null;
                                AwaitKt.launch$default(reorderableLazyListState2.scope, null, null, new ReorderableLazyCollectionState$onDrag$1(reorderableLazyListState2, draggingItemLayoutInfo, reorderableLazyListKt$toLazyCollectionItemInfo$1FindTargetItem$default, null, (byte) 0), 3);
                            }
                            mutexImpl.unlock(obj6);
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            gapComposer.updateRememberedValue(objRememberedValue7);
        }
        final Function2 function5 = (Function2) objRememberedValue7;
        gapComposer.end(false);
        modifierOnGloballyPositioned.getClass();
        function3.getClass();
        function4.getClass();
        function5.getClass();
        final DragGestureDetector$Press dragGestureDetector$Press = this.$dragGestureDetector;
        Modifier modifierThen = modifierOnGloballyPositioned.then(new ComposedModifier(new Function3() { // from class: sh.calvin.reorderable.DraggableKt$draggable$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj4, Object obj5, Object obj6) {
                Boolean bool;
                Modifier modifier2 = (Modifier) obj4;
                ((Number) obj6).intValue();
                modifier2.getClass();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj5);
                gapComposer2.startReplaceGroup(1321786060);
                Object objRememberedValue8 = gapComposer2.rememberedValue();
                NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                if (objRememberedValue8 == neverEqualPolicy2) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(Stack.createCompositionCoroutineScope(gapComposer2));
                    gapComposer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                    objRememberedValue8 = compositionScopedCoroutineScopeCanceller2;
                }
                CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue8).coroutineScope;
                gapComposer2.startReplaceGroup(-98757340);
                Object objRememberedValue9 = gapComposer2.rememberedValue();
                if (objRememberedValue9 == neverEqualPolicy2) {
                    objRememberedValue9 = Stack.mutableStateOf$default(null);
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                }
                MutableState mutableState3 = (MutableState) objRememberedValue9;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(-98754771);
                Object objRememberedValue10 = gapComposer2.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy2) {
                    objRememberedValue10 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue10);
                }
                MutableState mutableState4 = (MutableState) objRememberedValue10;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(-98752375);
                boolean zChangedInstance2 = gapComposer2.changedInstance(coroutineScope2) | gapComposer2.changed((Object) null);
                Function0 function6 = function4;
                boolean zChanged5 = zChangedInstance2 | gapComposer2.changed(function6);
                Object objRememberedValue11 = gapComposer2.rememberedValue();
                if (zChanged5 || objRememberedValue11 == neverEqualPolicy2) {
                    objRememberedValue11 = new DraggableKt$draggable$3$1$1(function6, mutableState4, mutableState3, coroutineScope2);
                    gapComposer2.updateRememberedValue(objRememberedValue11);
                }
                gapComposer2.end(false);
                ReorderableLazyListState reorderableLazyListState2 = reorderableLazyListState;
                Stack.DisposableEffect(reorderableLazyListState2, (Function1) objRememberedValue11, gapComposer2);
                boolean z2 = z;
                Boolean boolValueOf = Boolean.valueOf(z2);
                gapComposer2.startReplaceGroup(-98737076);
                boolean zChanged6 = gapComposer2.changed(z2);
                DragGestureDetector$Press dragGestureDetector$Press2 = dragGestureDetector$Press;
                boolean zChanged7 = gapComposer2.changed((Object) null) | zChanged6 | gapComposer2.changedInstance(dragGestureDetector$Press2) | gapComposer2.changedInstance(coroutineScope2);
                Function1 function7 = function3;
                boolean zChanged8 = zChanged7 | gapComposer2.changed(function7) | gapComposer2.changed(function6);
                Function2 function8 = function5;
                boolean zChanged9 = zChanged8 | gapComposer2.changed(function8);
                Object objRememberedValue12 = gapComposer2.rememberedValue();
                if (zChanged9 || objRememberedValue12 == neverEqualPolicy2) {
                    bool = boolValueOf;
                    DraggableKt$draggable$3$2$1 draggableKt$draggable$3$2$1 = new DraggableKt$draggable$3$2$1(z, dragGestureDetector$Press2, function8, function7, mutableState4, coroutineScope2, mutableState3, function6, null);
                    gapComposer2.updateRememberedValue(draggableKt$draggable$3$2$1);
                    objRememberedValue12 = draggableKt$draggable$3$2$1;
                } else {
                    bool = boolValueOf;
                }
                gapComposer2.end(false);
                PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
                Modifier modifierThen2 = modifier2.then(new SuspendPointerInputElement(reorderableLazyListState2, bool, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objRememberedValue12), 4));
                gapComposer2.end(false);
                return modifierThen2;
            }
        }));
        gapComposer.end(false);
        return modifierThen;
    }
}
