package androidx.compose.runtime;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.material3.AnalogTimePickerState;
import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$6$1$1$1$1;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.LookaheadCapablePlaceable.ResettableRulerScope;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.common.PlaybackParameters;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.ImageLoader$Builder;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.ProtocolKt;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.menu.LyricsMenuKt$$ExternalSyntheticLambda50;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda75;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel$2$page$1;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Cache;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GapComposer$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ GapComposer$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r7v10 */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Rect rect;
        int i;
        Rect bounds;
        Rect bounds2;
        byte b = this.$r8$classId;
        byte b2 = 8;
        byte b3 = 10;
        byte b4 = 3;
        byte b5 = 0;
        boolean z = false;
        byte b6 = 1;
        Integer num = 0;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj3;
                ChangeList changeList = (ChangeList) obj2;
                SlotReader slotReader = (SlotReader) obj;
                ComposerChangeListWriter composerChangeListWriter = gapComposer.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.changeList;
                try {
                    composerChangeListWriter.changeList = changeList;
                    SlotReader slotReader2 = gapComposer.reader;
                    int[] iArr = gapComposer.nodeCountOverrides;
                    MutableIntObjectMap mutableIntObjectMap = gapComposer.providerUpdates;
                    gapComposer.nodeCountOverrides = null;
                    gapComposer.providerUpdates = null;
                    try {
                        gapComposer.reader = slotReader;
                        boolean z2 = composerChangeListWriter.implicitRootStart;
                        try {
                            composerChangeListWriter.implicitRootStart = false;
                            gapComposer.invokeMovableContentLambda(null, null);
                            composerChangeListWriter.implicitRootStart = z2;
                            gapComposer.reader = slotReader2;
                            gapComposer.nodeCountOverrides = iArr;
                            gapComposer.providerUpdates = mutableIntObjectMap;
                            composerChangeListWriter.changeList = changeList2;
                            return unit;
                        } catch (Throwable th) {
                            composerChangeListWriter.implicitRootStart = z2;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        gapComposer.reader = slotReader2;
                        gapComposer.nodeCountOverrides = iArr;
                        gapComposer.providerUpdates = mutableIntObjectMap;
                        throw th2;
                    }
                } catch (Throwable th3) {
                    composerChangeListWriter.changeList = changeList2;
                    throw th3;
                }
            case 1:
                ContentInViewNode contentInViewNode = (ContentInViewNode) obj3;
                UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) obj2;
                BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) obj;
                LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo = contentInViewNode.bringIntoViewRequests;
                while (true) {
                    MutableVector mutableVector = lazyLayoutBeyondBoundsInfo.beyondBoundsItems;
                    int i2 = mutableVector.size;
                    if (i2 != 0) {
                        if (i2 == 0) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1("MutableVector is empty.");
                            return null;
                        }
                        Rect rect2 = (Rect) ((ContentInViewNode.Request) mutableVector.content[i2 - 1]).currentBounds.invoke();
                        if (rect2 == null ? true : ContentInViewNode.m57isMaxVisibleEQwtKw$default(contentInViewNode, rect2, 0L, 0L, 3)) {
                            MutableVector mutableVector2 = lazyLayoutBeyondBoundsInfo.beyondBoundsItems;
                            ((ContentInViewNode.Request) mutableVector2.removeAt(mutableVector2.size - 1)).continuation.resumeWith(unit);
                        }
                    }
                }
                if (contentInViewNode.trackingFocusedChild && (rect = (Rect) contentInViewNode.getFocusedRect.invoke()) != null && ContentInViewNode.m57isMaxVisibleEQwtKw$default(contentInViewNode, rect, 0L, 0L, 3)) {
                    contentInViewNode.trackingFocusedChild = false;
                }
                updatableAnimationState.value = contentInViewNode.m58calculateScrollDeltaI_oMVgE(bringIntoViewSpec, 0L);
                return unit;
            case 2:
                LazyListState lazyListState = (LazyListState) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) ((DerivedSnapshotState) obj3).getValue();
                return new LazyListItemProviderImpl(lazyListState, lazyListIntervalContent, (LazyItemScopeImpl) obj, new StatusLine((IntRange) lazyListState.scrollPosition.nearestRangeState.getValue(), lazyListIntervalContent));
            case 3:
                BringIntoViewResponderNode bringIntoViewResponderNode = (BringIntoViewResponderNode) obj3;
                Rect rectBringIntoView$localRect = BringIntoViewResponderNode.bringIntoView$localRect(bringIntoViewResponderNode, (NodeCoordinator) obj2, (ComponentRegistry$Builder$$ExternalSyntheticLambda2) obj);
                if (rectBringIntoView$localRect == null) {
                    return null;
                }
                ContentInViewNode contentInViewNode2 = bringIntoViewResponderNode.responder;
                if (IntSize.m810equalsimpl0(contentInViewNode2.viewportSize, -1L)) {
                    InlineClassHelperKt.throwIllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
                }
                return rectBringIntoView$localRect.m446translatek4lQ0M(contentInViewNode2.m62relocationOffsetfbGrOKE(rectBringIntoView$localRect, contentInViewNode2.m59getViewportSizeOrZeroYbymL2g$foundation(), 0L) ^ (-9223372034707292160L));
            case 4:
                SheetState sheetState = (SheetState) obj3;
                sheetState.showMotionSpec = (FiniteAnimationSpec) obj2;
                sheetState.hideMotionSpec = (FiniteAnimationSpec) obj;
                return unit;
            case 5:
                CoroutineScope coroutineScope = (CoroutineScope) obj2;
                SheetState sheetState2 = (SheetState) obj;
                if (((Boolean) ((SheetState) obj3).confirmValueChange.invoke(SheetValue.Expanded)).booleanValue()) {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState2, num, (byte) 4), 3);
                }
                return Boolean.TRUE;
            case 6:
                Density density = (Density) obj2;
                long selectorPos = TimePickerKt.getSelectorPos((AnalogTimePickerState) obj3);
                return Boolean.valueOf(((Rect) ((MutableState) obj).getValue()).m442containsk4lQ0M((((long) Float.floatToRawIntBits(density.mo81toPx0680j_4(DpOffset.m798getXD9Ej5fM(selectorPos)))) << 32) | (((long) Float.floatToRawIntBits(density.mo81toPx0680j_4(DpOffset.m799getYD9Ej5fM(selectorPos)))) & 4294967295L)));
            case 7:
                TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) obj3;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj2;
                MutableState mutableState = (MutableState) obj;
                if (tooltipStateImpl.isVisible()) {
                    AwaitKt.launch$default(coroutineScope2, null, null, new SyncUtils.AnonymousClass3(tooltipStateImpl, num, b4), 3);
                    mutableState.setValue(Boolean.FALSE);
                }
                return unit;
            case 8:
                GapAnchor gapAnchor = (GapAnchor) obj3;
                SlotWriter slotWriter = (SlotWriter) obj2;
                OperationErrorContext operationErrorContext = (OperationErrorContext) obj;
                if (gapAnchor != null) {
                    slotWriter.advanceBy(slotWriter.anchorIndex(gapAnchor) - slotWriter.currentGroup);
                }
                List listBuildTrace = UtilsKt.buildTrace(slotWriter, null, slotWriter.currentGroup, null);
                ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) CollectionsKt.lastOrNull(listBuildTrace);
                num = composeStackTraceFrame != null ? composeStackTraceFrame.groupOffset : 0;
                List listBuildStackTrace = operationErrorContext.buildStackTrace(num);
                List listPlus = listBuildStackTrace;
                if (num != 0 && !listBuildStackTrace.isEmpty()) {
                    listPlus = listBuildStackTrace;
                    ComposeStackTraceFrame composeStackTraceFrame2 = (ComposeStackTraceFrame) CollectionsKt.first(listBuildStackTrace);
                    List listDrop = CollectionsKt.drop(listBuildStackTrace, 1);
                    int i3 = composeStackTraceFrame2.groupKey;
                    Cache.RealCacheRequest realCacheRequest = composeStackTraceFrame2.sourceInfo;
                    composeStackTraceFrame2.getClass();
                    listPlus = CollectionsKt.plus((Iterable) listDrop, (Collection) CollectionsKt__IterablesKt.listOf(new ComposeStackTraceFrame(i3, realCacheRequest, num)));
                }
                listPlus = listBuildStackTrace;
                return new ComposeStackTrace(CollectionsKt.plus((Iterable) listPlus, (Collection) listBuildTrace), operationErrorContext.getSourceInformationEnabled());
            case 9:
                ((AwaiterQueue$Awaiter) obj3).cancel();
                AtomicInt atomicInt = (AtomicInt) ((ImageLoader$Builder) obj2).memoryCacheLazy;
                int i4 = ((Ref$IntRef) obj).element;
                do {
                    i = atomicInt.get();
                } while (!atomicInt.compareAndSet(i, ((i >>> 27) & 15) == i4 ? i - 1 : i));
                return unit;
            case 10:
                Function2 function2 = (Function2) obj3;
                VerticalRuler verticalRuler = (VerticalRuler) obj;
                LookaheadCapablePlaceable lookaheadCapablePlaceable = (LookaheadCapablePlaceable) ((Ref$ObjectRef) obj2).element;
                MutableScatterMap mutableScatterMap = lookaheadCapablePlaceable._rulerScopes;
                if (mutableScatterMap == null) {
                    long[] jArr = ScatterMapKt.EmptyGroup;
                    mutableScatterMap = new MutableScatterMap();
                    lookaheadCapablePlaceable._rulerScopes = mutableScatterMap;
                }
                Object resettableRulerScope = mutableScatterMap.get(verticalRuler);
                if (resettableRulerScope == null) {
                    resettableRulerScope = lookaheadCapablePlaceable.new ResettableRulerScope(verticalRuler);
                    mutableScatterMap.set(verticalRuler, resettableRulerScope);
                }
                LookaheadCapablePlaceable.ResettableRulerScope resettableRulerScope2 = (LookaheadCapablePlaceable.ResettableRulerScope) resettableRulerScope;
                resettableRulerScope2.coordinatesAccessed = false;
                function2.invoke(resettableRulerScope2, verticalRuler);
                return unit;
            case 11:
                NodeCoordinator nodeCoordinator = (NodeCoordinator) obj2;
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
                ((Function1) obj3).invoke(reusableGraphicsLayerScope);
                boolean zAreEqual = Intrinsics.areEqual(nodeCoordinator.lastShape, reusableGraphicsLayerScope.shape);
                b5 = nodeCoordinator.lastClip != reusableGraphicsLayerScope.clip ? (byte) 1 : (byte) 0;
                ColorKt colorKtMo56createOutlinePq9zytI = reusableGraphicsLayerScope.shape.mo56createOutlinePq9zytI(reusableGraphicsLayerScope.size, reusableGraphicsLayerScope.layoutDirection, reusableGraphicsLayerScope.graphicsDensity);
                reusableGraphicsLayerScope.outline = colorKtMo56createOutlinePq9zytI;
                boolean zAreEqual2 = Intrinsics.areEqual(nodeCoordinator.graphicsOutlineBoundsCache, colorKtMo56createOutlinePq9zytI != null ? colorKtMo56createOutlinePq9zytI.getBounds() : null);
                ref$BooleanRef.element = !zAreEqual2;
                if (!zAreEqual || b5 != 0 || !zAreEqual2) {
                    nodeCoordinator.lastShape = reusableGraphicsLayerScope.shape;
                    nodeCoordinator.lastClip = reusableGraphicsLayerScope.clip;
                    ColorKt colorKt = reusableGraphicsLayerScope.outline;
                    Rect rect3 = Rect.Zero;
                    if (colorKt == null || (bounds = colorKt.getBounds()) == null) {
                        bounds = rect3;
                    }
                    nodeCoordinator.graphicsOutlineBoundsCache = bounds;
                    ColorKt colorKt2 = reusableGraphicsLayerScope.outline;
                    if (colorKt2 != null && (bounds2 = colorKt2.getBounds()) != null) {
                        IntRect intRectRoundToIntRect = DatabaseDao_Impl.AnonymousClass17.roundToIntRect(bounds2);
                        rect3 = new Rect(intRectRoundToIntRect.left, intRectRoundToIntRect.top, intRectRoundToIntRect.right, intRectRoundToIntRect.bottom);
                    }
                    nodeCoordinator.lastOutlineBounds = rect3;
                    if (nodeCoordinator.wasLayerBlockInvoked && (b5 != 0 || (nodeCoordinator.lastClip && !zAreEqual))) {
                        nodeCoordinator.layoutNode.invalidateSemantics$ui();
                    }
                }
                nodeCoordinator.wasLayerBlockInvoked = true;
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                AbstractComposeView abstractComposeView = (AbstractComposeView) obj3;
                abstractComposeView.removeOnAttachStateChangeListener((StandardMenuPopup.AnonymousClass2) obj2);
                MathKt.getPoolingContainerListenerHolder(abstractComposeView).listeners.remove((ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0) obj);
                return unit;
            case 13:
                VelocityTracker velocityTracker = (VelocityTracker) obj3;
                float f = -Velocity.m820getYimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                velocityTracker.resetTracking();
                ((BottomSheetState) obj2).performFling(f, (Function0) obj);
                return unit;
            case 14:
                State state = (State) obj2;
                MutableState mutableState2 = (MutableState) obj;
                PersistentHashMap persistentHashMap = ((SnapshotStateMap) obj3).getReadable$runtime().map;
                int iIntValue = ((Number) state.getValue()).intValue() - 8;
                if (iIntValue < 0) {
                    iIntValue = 0;
                }
                int iIntValue2 = ((Number) state.getValue()).intValue() + 12;
                int size = ((List) mutableState2.getValue()).size() - 1;
                if (iIntValue2 > size) {
                    iIntValue2 = size;
                }
                Iterable intRange = new IntRange(iIntValue, iIntValue2, 1);
                if ((intRange instanceof Collection) && ((Collection) intRange).isEmpty()) {
                    z = true;
                } else {
                    Iterator it = intRange.iterator();
                    while (((IntProgressionIterator) it).hasNext) {
                        if (!persistentHashMap.containsKey(Integer.valueOf(((IntIterator) it).nextInt()))) {
                        }
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
            case 15:
                Function0 function0 = (Function0) obj3;
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                if (((Boolean) ((State) obj2).getValue()).booleanValue()) {
                    LyricsEntity lyricsEntity = (LyricsEntity) function0.invoke();
                    if (lyricsEntity != null) {
                        StateFlowImpl stateFlowImpl = LyricsTranslationHelper._status;
                        musicDatabase.query(new LyricsMenuKt$$ExternalSyntheticLambda50(LyricsEntity.copy$default(lyricsEntity, "", "", ""), b5));
                        LyricsTranslationHelper._clearTranslationsTrigger.tryEmit(unit);
                        StateFlowImpl stateFlowImpl2 = LyricsTranslationHelper._hasActiveTranslations;
                        Boolean bool = Boolean.FALSE;
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, bool);
                    }
                } else {
                    LyricsTranslationHelper._manualTrigger.tryEmit(unit);
                }
                return unit;
            case 16:
                MutableState mutableState3 = (MutableState) obj2;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                SongEntity songEntity = (SongEntity) ((Function0) obj3).invoke();
                if (songEntity != null) {
                    musicDatabase2.query(new SongMenuKt$$ExternalSyntheticLambda4(songEntity, mutableState3, b6));
                }
                return unit;
            case 17:
                ((PlayerConnection) obj3).getPlayerSafe().setPlaybackParameters(new PlaybackParameters(((ParcelableSnapshotMutableFloatState) obj2).getFloatValue(), (float) Math.pow(2.0d, ((ParcelableSnapshotMutableIntState) obj).getIntValue() / 12.0f)));
                return unit;
            case 18:
                ((ParcelableSnapshotMutableFloatState) obj2).setFloatValue(1.0f);
                ((ParcelableSnapshotMutableIntState) obj).setIntValue(0);
                ((Function0) obj3).invoke();
                return unit;
            case 19:
                Listentogether.UserInfo userInfo = (Listentogether.UserInfo) obj3;
                ((MutableState) obj2).setValue(userInfo.getUserId());
                ((MutableState) obj).setValue(userInfo.getUsername());
                return unit;
            case 20:
                ((MusicDatabase) obj3).query(new SongMenuKt$$ExternalSyntheticLambda4(obj2, obj, (byte) 7));
                return unit;
            case 21:
                ((Function0) obj3).invoke();
                ((Function0) obj2).invoke();
                ((Function0) obj).invoke();
                return unit;
            case 22:
                CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) obj2;
                ((Function0) obj3).invoke();
                String str = ((Song) obj).song.id;
                cachePlaylistViewModel.getClass();
                str.getClass();
                cachePlaylistViewModel.removeSongsFromCache(CollectionsKt__IterablesKt.listOf(str));
                return unit;
            case 23:
                Song song = (Song) obj3;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj2;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj;
                SongEntity songEntity2 = song.song;
                String str2 = songEntity2.inLibrary != null ? songEntity2.libraryRemoveToken : songEntity2.libraryAddToken;
                if (str2 != null) {
                    AwaitKt.launch$default(coroutineScope3, null, null, new LocalPlaylistViewModel$2$page$1(str2, num, (byte) 2), 3);
                }
                musicDatabase3.query(new SongMenuKt$$ExternalSyntheticLambda75(song, b5));
                return unit;
            case 24:
                ((Function0) obj3).invoke();
                ((MusicDatabase) obj2).query(new MimesKt$$ExternalSyntheticLambda0((byte) 1, (Event) obj));
                return unit;
            case 25:
                Song song2 = (Song) obj3;
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj2;
                Function0 function1 = (Function0) obj;
                SongEntity songEntity3 = song2.song;
                int i5 = songEntity3.duration;
                listenTogetherManager.suggestTrack(ProtocolKt.TrackInfo(songEntity3.id, songEntity3.title, CollectionsKt.joinToString$default(song2.getOrderedArtists(), ", ", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 13), 30), songEntity3.albumName, i5 > 0 ? ((long) i5) * 1000 : 180000L, songEntity3.thumbnailUrl, null));
                function1.invoke();
                return unit;
            case 26:
                ((Function0) obj3).invoke();
                ((BottomSheetPageState) obj2).show(new ComposableLambdaImpl(true, -1124797064, new ListItemKt$$ExternalSyntheticLambda17(b2, (Song) obj)));
                return unit;
            case 27:
                ((MusicDatabase) obj3).query(new SongMenuKt$$ExternalSyntheticLambda4((ArtistItem) obj2, (State) obj, b3));
                return unit;
            case 28:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/playlist?list=" + ((PlaylistItem) obj).id);
                ((Context) obj3).startActivity(Intent.createChooser(intent, null));
                ((Function0) obj2).invoke();
                return unit;
            default:
                ((Function0) obj3).invoke();
                ((BottomSheetPageState) obj2).show(new ComposableLambdaImpl(true, 581129960, new ListItemKt$$ExternalSyntheticLambda17(b3, (SongItem) obj)));
                return unit;
        }
    }

    public /* synthetic */ GapComposer$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
