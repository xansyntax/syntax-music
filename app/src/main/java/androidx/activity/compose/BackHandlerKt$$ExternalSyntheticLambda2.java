package androidx.activity.compose;

import android.view.View;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.collection.internal.Lock;
import androidx.compose.animation.ZIndexModifierNode;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition$animateTo$1$1$1;
import androidx.compose.animation.core.Transition$animateTo$lambda$2$0$$inlined$onDispose$1;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.gestures.AnchoredDraggableNode;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.OffsetNode;
import androidx.compose.foundation.layout.OffsetPxNode;
import androidx.compose.foundation.layout.PaddingNode;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1;
import androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.spatial.ThrottledCallbacks;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackHandlerKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ BackHandlerKt$$ExternalSyntheticLambda2(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v0, types: [byte] */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82, types: [int] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 3;
        ?? r10 = 2;
        ?? r11 = 2;
        ?? r12 = 2;
        ?? r13 = 0;
        byte b3 = 1;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                BackHandlerDispatcherCompat backHandlerDispatcherCompat = (BackHandlerDispatcherCompat) obj3;
                ComposeBackHandler composeBackHandler = (ComposeBackHandler) obj2;
                backHandlerDispatcherCompat.addHandler(composeBackHandler);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(backHandlerDispatcherCompat, composeBackHandler, r13);
            case 1:
                BackHandlerDispatcherCompat backHandlerDispatcherCompat2 = (BackHandlerDispatcherCompat) obj3;
                ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) obj2;
                backHandlerDispatcherCompat2.addHandler(composePredictiveBackHandler);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(backHandlerDispatcherCompat2, composePredictiveBackHandler, b3);
            case 2:
                ((Placeable.PlacementScope) obj).place((Placeable) obj3, 0, 0, ((ZIndexModifierNode) obj2).zIndex);
                return unit;
            case 3:
                InfiniteTransition infiniteTransition = (InfiniteTransition) obj3;
                InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) obj2;
                infiniteTransition._animations.add(transitionAnimationState);
                infiniteTransition.refreshChildNeeded$delegate.setValue(Boolean.TRUE);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(infiniteTransition, transitionAnimationState, r10);
            case 4:
                AwaitKt.launch$default((CoroutineScope) obj3, null, CoroutineStart.UNDISPATCHED, new Transition$animateTo$1$1$1((Transition) obj2, null), 1);
                return new Transition$animateTo$lambda$2$0$$inlined$onDispose$1((byte) 0);
            case 5:
                Transition transition = (Transition) obj3;
                TransitionInstance transitionInstance = (TransitionInstance) obj2;
                transition._transitions.add(transitionInstance);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(transition, transitionInstance, b2);
            case 6:
                TagPayloadReader tagPayloadReader = (TagPayloadReader) obj3;
                ((SeekableTransitionState) tagPayloadReader).setSnapshotStateObserver$animation_core(new SnapshotStateObserver(new BackHandlerKt$$ExternalSyntheticLambda2(Thread.currentThread(), (CoroutineScope) obj2, (byte) 8)));
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1(r11, tagPayloadReader);
            case 7:
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1((Transition) obj3, (Transition.DeferredAnimation) obj2, (byte) 4);
            case 8:
                CoroutineScope coroutineScope = (CoroutineScope) obj2;
                Function0 function0 = (Function0) obj;
                if (obj3 == Thread.currentThread()) {
                    function0.invoke();
                } else {
                    AwaitKt.launch$default(coroutineScope, null, null, new AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2(function0, null, (byte) 1), 3);
                }
                return unit;
            case 9:
                Transition transition2 = (Transition) obj3;
                Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) obj2;
                transition2._animations.add(transitionAnimationState2);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(transition2, transitionAnimationState2, (byte) 5);
            case 10:
                ((MutableInteractionSourceImpl) obj3).tryEmit((PressInteraction.Cancel) obj2);
                return unit;
            case 11:
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                DrawScope.m547drawPathGBMwjPU$default(layoutNodeDrawScope, (AndroidPath) obj3, (Brush) obj2, CropImageView.DEFAULT_ASPECT_RATIO, null, 60);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                LayoutNodeDrawScope layoutNodeDrawScope2 = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope2.drawContent();
                DrawScope.m547drawPathGBMwjPU$default(layoutNodeDrawScope2, ((Outline$Generic) obj3).path, (Brush) obj2, CropImageView.DEFAULT_ASPECT_RATIO, null, 60);
                return unit;
            case 13:
                ((MutableInteractionSourceImpl) obj3).tryEmit((FocusInteraction) obj2);
                return unit;
            case 14:
                AnchoredDraggableNode anchoredDraggableNode = (AnchoredDraggableNode) obj3;
                AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) obj2;
                long j = ((DragEvent.DragDelta) obj).delta;
                long jM440timestuRUvjQ = anchoredDraggableNode.isReverseDirection$1() ? Offset.m440timestuRUvjQ(j, -1.0f) : Offset.m440timestuRUvjQ(j, 1.0f);
                anchoredDraggableState$anchoredDragScope$1.dragTo(anchoredDraggableNode.state.newOffsetForDelta$foundation(Float.intBitsToFloat((int) (anchoredDraggableNode.orientation == Orientation.Vertical ? jM440timestuRUvjQ & 4294967295L : jM440timestuRUvjQ >> 32))), CropImageView.DEFAULT_ASPECT_RATIO);
                return unit;
            case 15:
                ((LazyLayoutBeyondBoundsInfo) obj3).beyondBoundsItems.remove((ContentInViewNode.Request) obj2);
                return unit;
            case 16:
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) obj3;
                ScrollingLogic scrollingLogic = (ScrollingLogic) obj2;
                DragEvent.DragDelta dragDelta = (DragEvent.DragDelta) obj;
                float f = dragDelta.isIndirectPointerEvent ? -1.0f : 1.0f;
                long j2 = dragDelta.delta;
                scrollingLogic$nestedScrollScope$1.m107scrollByWithOverscrollOzD1aCk(1, Offset.m440timestuRUvjQ(scrollingLogic.orientation == Orientation.Horizontal ? Offset.m433copydBAh8RU$default(j2, CropImageView.DEFAULT_ASPECT_RATIO, 1) : Offset.m433copydBAh8RU$default(j2, CropImageView.DEFAULT_ASPECT_RATIO, 2), f));
                return unit;
            case 17:
                UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) obj3;
                ((Long) obj).getClass();
                float f2 = updatableAnimationState.value;
                updatableAnimationState.value = CropImageView.DEFAULT_ASPECT_RATIO;
                ((Function1) obj2).invoke(Float.valueOf(f2));
                return unit;
            case 18:
                OffsetNode offsetNode = (OffsetNode) obj3;
                Placeable placeable = (Placeable) obj2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                boolean z = offsetNode.rtlAware;
                float f3 = offsetNode.x;
                if (z) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, placementScope.mo75roundToPx0680j_4(f3), placementScope.mo75roundToPx0680j_4(offsetNode.y));
                } else {
                    placementScope.place(placeable, placementScope.mo75roundToPx0680j_4(f3), placementScope.mo75roundToPx0680j_4(offsetNode.y), CropImageView.DEFAULT_ASPECT_RATIO);
                }
                return unit;
            case 19:
                OffsetPxNode offsetPxNode = (OffsetPxNode) obj3;
                Placeable placeable2 = (Placeable) obj2;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                long j3 = ((IntOffset) offsetPxNode.offset.invoke(placementScope2)).packedValue;
                if (offsetPxNode.rtlAware) {
                    Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope2, placeable2, (int) (j3 >> 32), (int) (j3 & 4294967295L), null, 12);
                } else {
                    Placeable.PlacementScope.placeWithLayer$default(placementScope2, placeable2, (int) (j3 >> 32), (int) (j3 & 4294967295L), null, 12);
                }
                return unit;
            case 20:
                PaddingNode paddingNode = (PaddingNode) obj3;
                Placeable placeable3 = (Placeable) obj2;
                Placeable.PlacementScope placementScope3 = (Placeable.PlacementScope) obj;
                boolean z2 = paddingNode.rtlAware;
                float f4 = paddingNode.start;
                if (z2) {
                    Placeable.PlacementScope.placeRelative$default(placementScope3, placeable3, placementScope3.mo75roundToPx0680j_4(f4), placementScope3.mo75roundToPx0680j_4(paddingNode.top));
                } else {
                    placementScope3.place(placeable3, placementScope3.mo75roundToPx0680j_4(f4), placementScope3.mo75roundToPx0680j_4(paddingNode.top), CropImageView.DEFAULT_ASPECT_RATIO);
                }
                return unit;
            case 21:
                WindowInsetsHolder windowInsetsHolder = (WindowInsetsHolder) obj3;
                View view = (View) obj2;
                windowInsetsHolder.incrementAccessors(view);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(windowInsetsHolder, view, (byte) 6);
            case 22:
                LazyGridState lazyGridState = (LazyGridState) obj2;
                LazyLayoutPrefetchState.NestedPrefetchScopeImpl nestedPrefetchScopeImpl = (LazyLayoutPrefetchState.NestedPrefetchScopeImpl) obj;
                Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    int firstVisibleItemIndex = lazyGridState.getFirstVisibleItemIndex();
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    int i = nestedPrefetchScopeImpl.nestedPrefetchItemCount;
                    int i2 = i != -1 ? i : 2;
                    while (r13 < i2) {
                        nestedPrefetchScopeImpl.schedulePrecomposition(firstVisibleItemIndex + r13);
                        r13++;
                    }
                    return unit;
                } catch (Throwable th) {
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            case 23:
                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = (LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1) obj2;
                PriorityQueue lineConfiguration = ((LazyGridSpanLayoutProvider) obj3).getLineConfiguration(((Integer) obj).intValue());
                int i3 = lineConfiguration.size;
                List list = (List) lineConfiguration.array;
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                int i4 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    int i6 = (int) ((GridItemSpan) list.get(i5)).packedValue;
                    arrayList.add(new Pair(Integer.valueOf(i3), new Constraints(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m167childConstraintsJhjzzOo$foundation(i4, i6))));
                    i3++;
                    i4 += i6;
                }
                return arrayList;
            case 24:
                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = (LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1) obj3;
                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = (LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1) obj2;
                int iIntValue = ((Integer) obj).intValue();
                LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.spanLayoutProvider;
                int i7 = lazyGridSpanLayoutProvider.slotsPerLine;
                int iSpanOf = lazyGridSpanLayoutProvider.spanOf(iIntValue);
                return lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1.m166getAndMeasurem8Kt_7k(iIntValue, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.m167childConstraintsJhjzzOo$foundation(0, iSpanOf), 0, iSpanOf, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1.defaultMainAxisSpacing);
            case 25:
                AwaitFirstLayoutModifier.Node node = (AwaitFirstLayoutModifier.Node) obj3;
                AwaitFirstLayoutModifier awaitFirstLayoutModifier = (AwaitFirstLayoutModifier) obj2;
                ThrottledCallbacks.Entry entry = node.handle;
                if (entry != null) {
                    entry.unregister();
                }
                node.handle = null;
                CompletableDeferredImpl completableDeferredImpl = awaitFirstLayoutModifier.lock;
                if (completableDeferredImpl != null) {
                    completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(unit);
                }
                awaitFirstLayoutModifier.lock = null;
                return unit;
            case 26:
                LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) obj3;
                lazySaveableStateHolder.previouslyComposedKeys.minusAssign(obj2);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(lazySaveableStateHolder, obj2, (byte) 7);
            case 27:
                return new LazySaveableStateHolder((SaveableStateRegistry) obj3, (Map) obj, (SaveableStateHolder) obj2);
            case 28:
                ((Function1) obj3).invoke(Integer.valueOf(((EmojiProcessor) obj2).getLayoutInfo().pageSize));
                return unit;
            default:
                Placeable.PlacementScope placementScope4 = (Placeable.PlacementScope) obj;
                TextStreamsKt$$ExternalSyntheticLambda0 textStreamsKt$$ExternalSyntheticLambda0 = new TextStreamsKt$$ExternalSyntheticLambda0((ArrayList) obj2, r12);
                placementScope4.motionFrameOfReferencePlacement = true;
                textStreamsKt$$ExternalSyntheticLambda0.invoke(placementScope4);
                placementScope4.motionFrameOfReferencePlacement = false;
                ((MutableState) obj3).getValue();
                return unit;
        }
    }
}
