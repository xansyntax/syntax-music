package coil3.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Trace;
import android.util.Size;
import android.util.SizeF;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.BackHandlerInfo;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda3;
import androidx.activity.compose.ComposeBackHandler;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2;
import androidx.compose.foundation.lazy.LazyListScrollPosition;
import androidx.compose.foundation.lazy.grid.DefaultLazyGridCacheWindow;
import androidx.compose.foundation.lazy.grid.GridSlotCache;
import androidx.compose.foundation.lazy.grid.LazyGridBeyondBoundsState;
import androidx.compose.foundation.lazy.grid.LazyGridCacheWindowPrefetchStrategy;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazySemanticsKt$rememberLazyGridSemanticState$1$1;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.CachedItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.StickyHeaderBringIntoViewSpec;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement$Companion;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerState$scrollToPage$2;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.CrossStatus;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion;
import androidx.compose.material3.SliderKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.carousel.Keyline;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.tooling.ReaderTraceBuilder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.DataPointAtTime;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.core.provider.RequestExecutor$ReplyRunnable;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSessionImpl$1;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import androidx.palette.graphics.ColorCutQuantizer;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
import androidx.room.RoomExternalOperationElement;
import androidx.room.TransactionElement;
import androidx.room.TransactionExecutor;
import androidx.room.util.ForeignKeyWithSequence;
import androidx.room.util.TableInfo;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.Image;
import coil3.memory.RealStrongMemoryCache;
import coil3.network.SourceResponseBody;
import coil3.network.internal.UtilsKt$readBuffer$1;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import coil3.util.UtilsKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda57;
import com.metrolist.music.utils.DataStoreKt$dataStore$2$2;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty0;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.Okio__OkioKt;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UtilsKt {
    public static final void BackHandler(boolean z, Function0 function0, Composer composer, int i, int i2) {
        boolean z2;
        int i3;
        boolean z3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-361453782);
        int i4 = i2 & 1;
        byte b = 2;
        if (i4 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = i | (gapComposer.changed(z2) ? 4 : 2);
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        byte b2 = 0;
        byte b3 = 1;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 19) != 18)) {
            boolean z4 = i4 != 0 ? true : z2;
            Object current = LocalNavigationEventDispatcherOwner.getCurrent(gapComposer);
            if (current == null) {
                gapComposer.startReplaceGroup(535274673);
                current = LocalOnBackPressedDispatcherOwner.getCurrent(gapComposer);
            } else {
                gapComposer.startReplaceGroup(535271790);
            }
            gapComposer.end(false);
            if (current == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.");
                return;
            }
            boolean zChanged = gapComposer.changed(current);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                NavigationEventDispatcherOwner navigationEventDispatcherOwner = current instanceof NavigationEventDispatcherOwner ? (NavigationEventDispatcherOwner) current : null;
                NavigationEventDispatcher navigationEventDispatcher = navigationEventDispatcherOwner != null ? navigationEventDispatcherOwner.getNavigationEventDispatcher() : null;
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = current instanceof OnBackPressedDispatcherOwner ? (OnBackPressedDispatcherOwner) current : null;
                objRememberedValue = new BackHandlerDispatcherCompat(navigationEventDispatcher, onBackPressedDispatcherOwner != null ? onBackPressedDispatcherOwner.getOnBackPressedDispatcher() : null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            BackHandlerDispatcherCompat backHandlerDispatcherCompat = (BackHandlerDispatcherCompat) objRememberedValue;
            long j = gapComposer.compositeKeyHashCode;
            boolean zChanged2 = gapComposer.changed(backHandlerDispatcherCompat) | gapComposer.changed(j);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            Object obj = objRememberedValue2;
            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                ComposeBackHandler composeBackHandler = new ComposeBackHandler(new BackHandlerInfo(j, current));
                composeBackHandler.currentOnBackCompleted = new ScrollKt$$ExternalSyntheticLambda0(b);
                gapComposer.updateRememberedValue(composeBackHandler);
                obj = composeBackHandler;
            }
            ComposeBackHandler composeBackHandler2 = (ComposeBackHandler) obj;
            gapComposer.startReplaceGroup(-585307852);
            boolean zChangedInstance = gapComposer.changedInstance(composeBackHandler2) | ((i3 & 112) == 32);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(composeBackHandler2, function0, b3);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.SideEffect((Function0) objRememberedValue3, gapComposer);
            Boolean boolValueOf = Boolean.valueOf(z4);
            int i5 = i3 & 14;
            boolean zChangedInstance2 = (i5 == 4) | gapComposer.changedInstance(composeBackHandler2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new SliderKt$$ExternalSyntheticLambda8(composeBackHandler2, z4, b3);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            LifecyclesKt.LifecycleStartEffect(boolValueOf, composeBackHandler2, null, (Function1) objRememberedValue4, gapComposer, i5);
            boolean zChangedInstance3 = gapComposer.changedInstance(backHandlerDispatcherCompat) | gapComposer.changedInstance(composeBackHandler2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new BackHandlerKt$$ExternalSyntheticLambda2(backHandlerDispatcherCompat, composeBackHandler2, b2);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Stack.DisposableEffect(backHandlerDispatcherCompat, composeBackHandler2, (Function1) objRememberedValue5, gapComposer);
            gapComposer.end(false);
            z3 = z4;
        } else {
            gapComposer.skipToGroupEnd();
            z3 = z2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BackHandlerKt$$ExternalSyntheticLambda3(z3, function0, i, i2, (byte) 0);
        }
    }

    /* JADX INFO: renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m890DpSizeYgX7TsA(float f, float f2) {
        return (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    public static final ErrorResult ErrorResult(ImageRequest imageRequest, Throwable th) {
        Image image;
        if (th instanceof NullRequestDataException) {
            Function1 function1 = imageRequest.fallbackFactory;
            ImageRequest.Defaults defaults = imageRequest.defaults;
            image = (Image) function1.invoke(imageRequest);
            if (image == null) {
                image = (Image) defaults.fallbackFactory.invoke(imageRequest);
            }
            if (image == null && (image = (Image) imageRequest.errorFactory.invoke(imageRequest)) == null) {
                image = (Image) defaults.errorFactory.invoke(imageRequest);
            }
        } else {
            image = (Image) imageRequest.errorFactory.invoke(imageRequest);
            if (image == null) {
                image = (Image) imageRequest.defaults.errorFactory.invoke(imageRequest);
            }
        }
        return new ErrorResult(image, imageRequest, th);
    }

    /* JADX WARN: Code duplicated, block: B:211:0x02fd  */
    public static final void LazyGrid(Modifier modifier, final LazyGridState lazyGridState, final GridSlotCache gridSlotCache, final PaddingValues paddingValues, final boolean z, final FlingBehavior flingBehavior, final boolean z2, final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, final Arrangement$Vertical arrangement$Vertical, final Arrangement$Horizontal arrangement$Horizontal, final LazyLayoutCacheWindow lazyLayoutCacheWindow, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        boolean z3;
        GapComposer gapComposer;
        boolean z4;
        Object obj;
        final LazyGridState lazyGridState2;
        GapComposer gapComposer2;
        int i5;
        KProperty0 kProperty0;
        byte b;
        Modifier modifierLazyLayoutBeyondBoundsModifier;
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(-225647110);
        if ((i & 6) == 0) {
            i3 = (gapComposer3.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer3.changed(lazyGridState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? gapComposer3.changed(gridSlotCache) : gapComposer3.changedInstance(gridSlotCache) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer3.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer3.changed(false) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer3.changed(z) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer3.changed(flingBehavior) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer3.changed(z2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer3.changed(androidEdgeEffectOverscrollEffect) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer3.changed(arrangement$Vertical) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        int i6 = i3;
        if ((i2 & 6) == 0) {
            i4 = (gapComposer3.changed(arrangement$Horizontal) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer3.changed(lazyLayoutCacheWindow) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer3.changedInstance(function1) ? 256 : 128;
        }
        if (gapComposer3.shouldExecute(i6 & 1, ((i6 & 306783379) == 306783378 && (i4 & 147) == 146) ? false : true)) {
            gapComposer3.startDefaults();
            if ((i & 1) != 0 && !gapComposer3.getDefaultsInvalid()) {
                gapComposer3.skipToGroupEnd();
            }
            gapComposer3.endDefaults();
            int i7 = i6 >> 3;
            int i8 = i7 & 14;
            int i9 = i8 | ((i4 >> 3) & 112);
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer3);
            byte b2 = 6;
            boolean z5 = (((i9 & 14) ^ 6) > 4 && gapComposer3.changed(lazyGridState)) || (i9 & 6) == 4;
            Object objRememberedValue = gapComposer3.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z5 || objRememberedValue == neverEqualPolicy) {
                NeverEqualPolicy neverEqualPolicy2 = NeverEqualPolicy.INSTANCE$1;
                MainActivity$$ExternalSyntheticLambda29 mainActivity$$ExternalSyntheticLambda29 = new MainActivity$$ExternalSyntheticLambda29(mutableStateRememberUpdatedState, (byte) 2);
                EmojiProcessor emojiProcessor = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                objRememberedValue = new DataStoreKt$dataStore$2$2(new DerivedSnapshotState(new Recomposer$$ExternalSyntheticLambda6(new DerivedSnapshotState(mainActivity$$ExternalSyntheticLambda29, neverEqualPolicy2), lazyGridState, b2), neverEqualPolicy2), State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 2);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            final KProperty0 kProperty1 = (KProperty0) objRememberedValue;
            int i10 = i8 | ((i6 >> 9) & 112);
            boolean z6 = ((((i10 & 14) ^ 6) > 4 && gapComposer3.changed(lazyGridState)) || (i10 & 6) == 4) | ((((i10 & 112) ^ 48) > 32 && gapComposer3.changed(false)) || (i10 & 48) == 32);
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            if (z6 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.grid.LazySemanticsKt$rememberLazyGridSemanticState$1$1
                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final CollectionInfo collectionInfo() {
                        return new CollectionInfo(-1, -1);
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final int getContentPadding() {
                        LazyGridState lazyGridState3 = lazyGridState;
                        return (-lazyGridState3.getLayoutInfo().viewportStartOffset) + lazyGridState3.getLayoutInfo().afterContentPadding;
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final float getMaxScrollOffset() {
                        LazyGridState lazyGridState3 = lazyGridState;
                        int firstVisibleItemIndex = lazyGridState3.getFirstVisibleItemIndex();
                        int firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                        return lazyGridState3.getCanScrollForward() ? (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset + 100.0f : (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset;
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final float getScrollOffset() {
                        LazyGridState lazyGridState3 = lazyGridState;
                        return (lazyGridState3.getFirstVisibleItemIndex() * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + lazyGridState3.getFirstVisibleItemScrollOffset();
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final int getViewport() {
                        LazyGridState lazyGridState3 = lazyGridState;
                        return (int) (lazyGridState3.getLayoutInfo().orientation == Orientation.Vertical ? lazyGridState3.getLayoutInfo().m168getViewportSizeYbymL2g() & 4294967295L : lazyGridState3.getLayoutInfo().m168getViewportSizeYbymL2g() >> 32);
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final Object scrollToItem(int i11, PagerState$scrollToPage$2 pagerState$scrollToPage$2) {
                        Object objScrollToItem$default = LazyGridState.scrollToItem$default(lazyGridState, i11, pagerState$scrollToPage$2);
                        return objScrollToItem$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objScrollToItem$default : Unit.INSTANCE;
                    }
                };
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            LazySemanticsKt$rememberLazyGridSemanticState$1$1 lazySemanticsKt$rememberLazyGridSemanticState$1$1 = (LazySemanticsKt$rememberLazyGridSemanticState$1$1) objRememberedValue2;
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue3);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
            final GraphicsContext graphicsContext = (GraphicsContext) gapComposer3.consume(CompositionLocalsKt.LocalGraphicsContext);
            boolean zBooleanValue = ((Boolean) gapComposer3.consume(CompositionLocalsKt.LocalProvidableScrollCaptureInProgress)).booleanValue();
            int i11 = i6 & 112;
            boolean z7 = (i11 == 32) | ((i4 & 112) == 32);
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (z7 || objRememberedValue4 == neverEqualPolicy) {
                lazyGridState.getClass();
                if (!(lazyLayoutCacheWindow instanceof DefaultLazyGridCacheWindow) && lazyLayoutCacheWindow == null) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                } else {
                    LazyGridCacheWindowPrefetchStrategy lazyGridCacheWindowPrefetchStrategy = new LazyGridCacheWindowPrefetchStrategy(lazyLayoutCacheWindow);
                    objRememberedValue4 = lazyGridCacheWindowPrefetchStrategy;
                    gapComposer3.updateRememberedValue(objRememberedValue4);
                }
            }
            final LazyGridCacheWindowPrefetchStrategy lazyGridCacheWindowPrefetchStrategy2 = (LazyGridCacheWindowPrefetchStrategy) objRememberedValue4;
            boolean zChanged = (i11 == 32) | gapComposer3.changed(lazyGridCacheWindowPrefetchStrategy2);
            Object objRememberedValue5 = gapComposer3.rememberedValue();
            if (zChanged || objRememberedValue5 == neverEqualPolicy) {
                lazyGridState.getClass();
                lazyGridCacheWindowPrefetchStrategy2.getClass();
                objRememberedValue5 = new LazyLayoutPrefetchState(new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridCacheWindowPrefetchStrategy2, lazyGridState, (byte) 22));
                gapComposer3.updateRememberedValue(objRememberedValue5);
            }
            final LazyLayoutPrefetchState lazyLayoutPrefetchState = (LazyLayoutPrefetchState) objRememberedValue5;
            final CachedItem.NoKey noKey = !zBooleanValue ? StickyItemsPlacement$Companion.StickToTopPlacement : null;
            int i12 = (i6 & 524272) | ((i4 << 18) & 3670016) | ((i6 >> 6) & 29360128);
            boolean z8 = ((((i12 & 896) ^ 384) > 256 && gapComposer3.changed(gridSlotCache)) || (i12 & 384) == 256) | ((((i12 & 112) ^ 48) > 32 && gapComposer3.changed(lazyGridState)) || (i12 & 48) == 32) | ((((i12 & 7168) ^ 3072) > 2048 && gapComposer3.changed(paddingValues)) || (i12 & 3072) == 2048);
            if (((57344 & i12) ^ 24576) > 16384 && gapComposer3.changed(false)) {
                z4 = true;
            } else if ((i12 & 24576) == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean zChanged2 = ((((i12 & 29360128) ^ 12582912) > 8388608 && gapComposer3.changed(arrangement$Vertical)) || (i12 & 12582912) == 8388608) | z8 | z4 | ((((458752 & i12) ^ 196608) > 131072 && gapComposer3.changed(z)) || (i12 & 196608) == 131072) | ((((i12 & 3670016) ^ 1572864) > 1048576 && gapComposer3.changed(arrangement$Horizontal)) || (i12 & 1572864) == 1048576) | gapComposer3.changed(graphicsContext) | gapComposer3.changed(lazyLayoutPrefetchState) | gapComposer3.changed(lazyGridCacheWindowPrefetchStrategy2);
            Object objRememberedValue6 = gapComposer3.rememberedValue();
            if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                lazyGridState2 = lazyGridState;
                gapComposer2 = gapComposer3;
                i5 = 32;
                obj = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                    /* JADX WARN: Code duplicated, block: B:145:0x03b7  */
                    /* JADX WARN: Code duplicated, block: B:185:0x0455  */
                    /* JADX WARN: Code duplicated, block: B:187:0x045c  */
                    /* JADX WARN: Code duplicated, block: B:188:0x045f  */
                    /* JADX WARN: Code duplicated, block: B:190:0x0466  */
                    /* JADX WARN: Code duplicated, block: B:191:0x046a  */
                    /* JADX WARN: Code duplicated, block: B:196:0x047e  */
                    /* JADX WARN: Code duplicated, block: B:198:0x0484 A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:204:0x04b3  */
                    /* JADX WARN: Code duplicated, block: B:208:0x04c0  */
                    /* JADX WARN: Code duplicated, block: B:209:0x04c3  */
                    /* JADX WARN: Code duplicated, block: B:211:0x04c7 A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:250:0x0576 A[LOOP:8: B:233:0x0524->B:250:0x0576, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:253:0x0582  */
                    /* JADX WARN: Code duplicated, block: B:256:0x058b  */
                    /* JADX WARN: Code duplicated, block: B:259:0x0596  */
                    /* JADX WARN: Code duplicated, block: B:261:0x059c A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:278:0x05fb  */
                    /* JADX WARN: Code duplicated, block: B:283:0x060e  */
                    /* JADX WARN: Code duplicated, block: B:285:0x0612 A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:288:0x0618  */
                    /* JADX WARN: Code duplicated, block: B:290:0x0623  */
                    /* JADX WARN: Code duplicated, block: B:292:0x062d A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:298:0x0647  */
                    /* JADX WARN: Code duplicated, block: B:299:0x064f  */
                    /* JADX WARN: Code duplicated, block: B:301:0x0658  */
                    /* JADX WARN: Code duplicated, block: B:303:0x065e  */
                    /* JADX WARN: Code duplicated, block: B:307:0x066a  */
                    /* JADX WARN: Code duplicated, block: B:310:0x0672  */
                    /* JADX WARN: Code duplicated, block: B:311:0x0674  */
                    /* JADX WARN: Code duplicated, block: B:314:0x067b  */
                    /* JADX WARN: Code duplicated, block: B:315:0x067e  */
                    /* JADX WARN: Code duplicated, block: B:317:0x0681 A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:322:0x0691 A[LOOP:14: B:321:0x068f->B:322:0x0691, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:325:0x06ad  */
                    /* JADX WARN: Code duplicated, block: B:327:0x06b3  */
                    /* JADX WARN: Code duplicated, block: B:330:0x06ba  */
                    /* JADX WARN: Code duplicated, block: B:333:0x06c8 A[LOOP:15: B:332:0x06c6->B:333:0x06c8, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:336:0x06d9 A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:337:0x06db  */
                    /* JADX WARN: Code duplicated, block: B:338:0x06e3  */
                    /* JADX WARN: Code duplicated, block: B:340:0x06ea A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:341:0x06ec  */
                    /* JADX WARN: Code duplicated, block: B:344:0x0703 A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:345:0x0705 A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:350:0x071c A[LOOP:17: B:349:0x071a->B:350:0x071c, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:352:0x0728 A[LOOP:16: B:348:0x070a->B:352:0x0728, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:355:0x0734  */
                    /* JADX WARN: Code duplicated, block: B:357:0x073b  */
                    /* JADX WARN: Code duplicated, block: B:359:0x074a  */
                    /* JADX WARN: Code duplicated, block: B:363:0x076a A[LOOP:20: B:360:0x074c->B:363:0x076a, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:366:0x0776  */
                    /* JADX WARN: Code duplicated, block: B:368:0x078e A[LOOP:22: B:367:0x078c->B:368:0x078e, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:372:0x07ac A[LOOP:23: B:371:0x07aa->B:372:0x07ac, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:375:0x07e9  */
                    /* JADX WARN: Code duplicated, block: B:377:0x07f9 A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:378:0x07fb  */
                    /* JADX WARN: Code duplicated, block: B:380:0x07ff  */
                    /* JADX WARN: Code duplicated, block: B:383:0x0819  */
                    /* JADX WARN: Code duplicated, block: B:384:0x081b  */
                    /* JADX WARN: Code duplicated, block: B:386:0x081e  */
                    /* JADX WARN: Code duplicated, block: B:388:0x0825 A[LOOP:18: B:387:0x0823->B:388:0x0825, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:390:0x083a  */
                    /* JADX WARN: Code duplicated, block: B:394:0x086a A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:397:0x086f  */
                    /* JADX WARN: Code duplicated, block: B:400:0x089c  */
                    /* JADX WARN: Code duplicated, block: B:401:0x089f  */
                    /* JADX WARN: Code duplicated, block: B:404:0x08a9 A[LOOP:19: B:403:0x08a7->B:404:0x08a9, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:463:0x04bc A[EDGE_INSN: B:463:0x04bc->B:206:0x04bc BREAK  A[LOOP:6: B:194:0x047a->B:205:0x04b5], SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:471:0x0589 A[EDGE_INSN: B:471:0x0589->B:255:0x0589 BREAK  A[LOOP:8: B:233:0x0524->B:250:0x0576], SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:483:0x072d A[EDGE_INSN: B:483:0x072d->B:353:0x072d BREAK  A[LOOP:16: B:348:0x070a->B:352:0x0728], SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:487:0x076d A[EDGE_INSN: B:487:0x076d->B:364:0x076d BREAK  A[LOOP:20: B:360:0x074c->B:363:0x076a], SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:492:0x0642 A[ADDED_TO_REGION, EDGE_INSN: B:492:0x0642->B:296:0x0642 BREAK  A[LOOP:24: B:289:0x0621->B:295:0x0637], REMOVE, SYNTHETIC] */
                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
                    /* JADX INFO: renamed from: measure-0kLqBqw */
                    public final MeasureResult mo159measure0kLqBqw(LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, long j) {
                        LazyGridSlots lazyGridSlots;
                        float fMo112getSpacingD9Ej5fM;
                        int lineIndexOfItem;
                        int firstVisibleItemScrollOffset;
                        int i13;
                        int i14;
                        int i15;
                        int i16;
                        LazyGridMeasuredLine lazyGridMeasuredLine;
                        int i17;
                        LazyGridMeasuredLine lazyGridMeasuredLine2;
                        int i18;
                        int i19;
                        int[] iArr;
                        int i20;
                        int i21;
                        ArrayList arrayList;
                        int i22;
                        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider;
                        int i23;
                        List list;
                        int i24;
                        float f;
                        List arrayList2;
                        int[] iArr2;
                        int i25;
                        List arrayList3;
                        int i26;
                        int size;
                        int i27;
                        int i28;
                        LazyGridMeasuredLine lazyGridMeasuredLine3;
                        long j2;
                        int iM792constrainWidthK40F9xA;
                        int iM783getMaxHeightimpl;
                        int i29;
                        List listPlus;
                        long j3;
                        int i30;
                        boolean z9;
                        int size2;
                        int i31;
                        int length;
                        boolean z10;
                        ArrayList arrayList4;
                        ArrayList arrayList5;
                        int size3;
                        int size4;
                        int mainAxisSizeWithSpacings;
                        int i32;
                        int size5;
                        int i33;
                        LazyGridMeasuredItem[] lazyGridMeasuredItemArrPosition;
                        int length2;
                        int i34;
                        int mainAxisSizeWithSpacings2;
                        int i35;
                        ArrayList arrayList6;
                        int i36;
                        LazyGridMeasuredLine lazyGridMeasuredLine4;
                        int iM791constrainHeightK40F9xA;
                        int i37;
                        List listApplyStickyItems;
                        boolean z11;
                        Orientation orientation;
                        int size6;
                        int i38;
                        int i39;
                        LazyGridMeasureResult lazyGridMeasureResult;
                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1;
                        SubcomposeMeasureScope subcomposeMeasureScope;
                        long jM173getMinSizeToFitDisappearingItemsYbymL2g;
                        int i40;
                        int i41;
                        int size7;
                        int i42;
                        int size8;
                        int[] iArr3;
                        int i43;
                        int[] iArr4;
                        int[] iArr5;
                        int i44;
                        int i45;
                        int i46;
                        LazyGridMeasuredItem[] lazyGridMeasuredItemArrPosition2;
                        int length3;
                        int i47;
                        int i48;
                        int i49;
                        int i50;
                        int[] iArr6;
                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1;
                        LazyGridMeasuredItem lazyGridMeasuredItem;
                        int i51;
                        LazyGridMeasuredItem[] lazyGridMeasuredItemArr;
                        LazyGridMeasuredItem lazyGridMeasuredItem2;
                        SubcomposeMeasureScope subcomposeMeasureScope2 = lazyLayoutMeasureScopeImpl.subcomposeMeasureScope;
                        LazyGridState lazyGridState3 = lazyGridState2;
                        lazyGridState3.measurementScopeInvalidator.getValue();
                        boolean z12 = lazyGridState3.hasLookaheadOccurred || subcomposeMeasureScope2.isLookingAhead();
                        Orientation orientation2 = Orientation.Horizontal;
                        Orientation orientation3 = Orientation.Vertical;
                        boolean z13 = z;
                        ImageKt.m44checkScrollableContainerConstraintsK40F9xA(j, z13 ? orientation3 : orientation2);
                        PaddingValues paddingValues2 = paddingValues;
                        int iMo75roundToPx0680j_4 = z13 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo123calculateLeftPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                        int iMo75roundToPx0680j_5 = z13 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo124calculateRightPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                        int iMo75roundToPx0680j_6 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo125calculateTopPaddingD9Ej5fM());
                        int iMo75roundToPx0680j_7 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo122calculateBottomPaddingD9Ej5fM()) + iMo75roundToPx0680j_6;
                        int i52 = iMo75roundToPx0680j_4 + iMo75roundToPx0680j_5;
                        int i53 = z13 ? iMo75roundToPx0680j_7 : i52;
                        int i54 = z13 ? iMo75roundToPx0680j_6 : !z13 ? iMo75roundToPx0680j_4 : iMo75roundToPx0680j_5;
                        int i55 = i53 - i54;
                        long jM793offsetNN6EwU = ConstraintsKt.m793offsetNN6EwU(-i52, -iMo75roundToPx0680j_7, j);
                        LazyGridItemProviderImpl lazyGridItemProviderImpl = (LazyGridItemProviderImpl) kProperty1.invoke();
                        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider2 = lazyGridItemProviderImpl.intervalContent.spanLayoutProvider;
                        GridSlotCache gridSlotCache2 = gridSlotCache;
                        if (gridSlotCache2.cachedSizes != null && Constraints.m778equalsimpl0(gridSlotCache2.cachedConstraints, jM793offsetNN6EwU) && gridSlotCache2.cachedDensity == subcomposeMeasureScope2.getDensity()) {
                            lazyGridSlots = gridSlotCache2.cachedSizes;
                            lazyGridSlots.getClass();
                        } else {
                            gridSlotCache2.cachedConstraints = jM793offsetNN6EwU;
                            gridSlotCache2.cachedDensity = subcomposeMeasureScope2.getDensity();
                            LazyGridSlots lazyGridSlots2 = (LazyGridSlots) gridSlotCache2.calculation.invoke(lazyLayoutMeasureScopeImpl, new Constraints(jM793offsetNN6EwU));
                            gridSlotCache2.cachedSizes = lazyGridSlots2;
                            lazyGridSlots = lazyGridSlots2;
                        }
                        int length4 = lazyGridSlots.sizes.length;
                        if (length4 != lazyGridSpanLayoutProvider2.slotsPerLine) {
                            lazyGridSpanLayoutProvider2.slotsPerLine = length4;
                            ArrayList arrayList7 = lazyGridSpanLayoutProvider2.buckets;
                            arrayList7.clear();
                            arrayList7.add(new LazyGridSpanLayoutProvider.Bucket(0, 0));
                            lazyGridSpanLayoutProvider2.lastLineIndex = 0;
                            lazyGridSpanLayoutProvider2.lastLineStartItemIndex = 0;
                            lazyGridSpanLayoutProvider2.lastLineStartKnownSpan = 0;
                            lazyGridSpanLayoutProvider2.cachedBucketIndex = -1;
                            lazyGridSpanLayoutProvider2.cachedBucket.clear();
                        }
                        Arrangement$Horizontal arrangement$Horizontal2 = arrangement$Horizontal;
                        Arrangement$Vertical arrangement$Vertical2 = arrangement$Vertical;
                        if (z13) {
                            if (arrangement$Vertical2 == null) {
                                throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                            }
                            fMo112getSpacingD9Ej5fM = arrangement$Vertical2.mo112getSpacingD9Ej5fM();
                        } else {
                            if (arrangement$Horizontal2 == null) {
                                throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement when isVertical == false");
                            }
                            fMo112getSpacingD9Ej5fM = arrangement$Horizontal2.mo112getSpacingD9Ej5fM();
                        }
                        int iMo75roundToPx0680j_8 = subcomposeMeasureScope2.mo75roundToPx0680j_4(fMo112getSpacingD9Ej5fM);
                        int itemCount = lazyGridItemProviderImpl.getItemCount();
                        int iM783getMaxHeightimpl2 = z13 ? Constraints.m783getMaxHeightimpl(j) - iMo75roundToPx0680j_7 : Constraints.m784getMaxWidthimpl(j) - i52;
                        LazyGridSlots lazyGridSlots3 = lazyGridSlots;
                        int i56 = i54;
                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$2 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(lazyGridItemProviderImpl, lazyLayoutMeasureScopeImpl, iMo75roundToPx0680j_8, lazyGridState2, z, i56, i55, (((long) iMo75roundToPx0680j_4) << 32) | (((long) iMo75roundToPx0680j_6) & 4294967295L));
                        LazyGridItemProviderImpl lazyGridItemProviderImpl2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$2.itemProvider;
                        StatusLine statusLine = lazyGridItemProviderImpl2.keyIndexMap;
                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(z, lazyGridSlots3, itemCount, iMo75roundToPx0680j_8, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$2, lazyGridSpanLayoutProvider2);
                        BackHandlerKt$$ExternalSyntheticLambda2 backHandlerKt$$ExternalSyntheticLambda2 = new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridSpanLayoutProvider2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, (byte) 23);
                        ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0 = new ScrollState$$ExternalSyntheticLambda0((byte) 15, lazyGridSpanLayoutProvider2);
                        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1;
                        try {
                            int firstVisibleItemIndex = lazyGridState3.getFirstVisibleItemIndex();
                            LazyListScrollPosition lazyListScrollPosition = lazyGridState3.scrollPosition;
                            int iFindIndexByKey = LazyLayoutKt.findIndexByKey(firstVisibleItemIndex, lazyGridItemProviderImpl, lazyListScrollPosition.lastKnownFirstItemKey);
                            if (firstVisibleItemIndex != iFindIndexByKey) {
                                lazyListScrollPosition.index$delegate.setIntValue(iFindIndexByKey);
                                lazyListScrollPosition.nearestRangeState.update(firstVisibleItemIndex);
                            }
                            if (iFindIndexByKey < itemCount || itemCount <= 0) {
                                lineIndexOfItem = lazyGridSpanLayoutProvider2.getLineIndexOfItem(iFindIndexByKey);
                                firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                            } else {
                                lineIndexOfItem = lazyGridSpanLayoutProvider2.getLineIndexOfItem(itemCount - 1);
                                firstVisibleItemScrollOffset = 0;
                            }
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            MutableIntList mutableIntListCalculateLazyLayoutPinnedIndices = LazyLayoutKt.calculateLazyLayoutPinnedIndices(lazyGridItemProviderImpl, lazyGridState3.pinnedItems, lazyGridState3.beyondBoundsInfo);
                            float fFloatValue = (subcomposeMeasureScope2.isLookingAhead() || !z12) ? lazyGridState3.scrollToBeConsumed : ((Number) ((AnimationState) lazyGridState3._lazyLayoutScrollDeltaBetweenPasses.referenceQueue).value$delegate.getValue()).floatValue();
                            LazyLayoutItemAnimator lazyLayoutItemAnimator = lazyGridState3.itemAnimator;
                            boolean zIsLookingAhead = subcomposeMeasureScope2.isLookingAhead();
                            LazyGridMeasureResult lazyGridMeasureResult2 = lazyGridState3.approachLayoutInfo;
                            MutableState mutableState = lazyGridState3.placementScopeInvalidator;
                            if (i56 < 0) {
                                InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
                            }
                            if (i55 < 0) {
                                InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
                            }
                            EmptyMap emptyMap = EmptyMap.INSTANCE;
                            boolean z14 = z;
                            int i57 = lineIndexOfItem;
                            CoroutineScope coroutineScope2 = coroutineScope;
                            GraphicsContext graphicsContext2 = graphicsContext;
                            LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                            LazyGridCacheWindowPrefetchStrategy lazyGridCacheWindowPrefetchStrategy3 = lazyGridCacheWindowPrefetchStrategy2;
                            EmptyList emptyList = EmptyList.INSTANCE;
                            if (itemCount <= 0) {
                                int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jM793offsetNN6EwU);
                                int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jM793offsetNN6EwU);
                                lazyLayoutItemAnimator.onMeasured(0, iM786getMinWidthimpl, iM785getMinHeightimpl, new ArrayList(), statusLine, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$2, z14, zIsLookingAhead, length4, z12, 0, 0, coroutineScope2, graphicsContext2, true);
                                if (!zIsLookingAhead) {
                                    long jM173getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                    if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g2, 0L)) {
                                        iM786getMinWidthimpl = ConstraintsKt.m792constrainWidthK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 >> 32), jM793offsetNN6EwU);
                                        iM785getMinHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L), jM793offsetNN6EwU);
                                    }
                                }
                                subcomposeMeasureScope = subcomposeMeasureScope2;
                                lazyGridMeasureResult = new LazyGridMeasureResult(null, 0, false, CropImageView.DEFAULT_ASPECT_RATIO, subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(iM786getMinWidthimpl + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(iM785getMinHeightimpl + iMo75roundToPx0680j_7, j), emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 16)), CropImageView.DEFAULT_ASPECT_RATIO, false, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda2, scrollState$$ExternalSyntheticLambda0, 0, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, emptyList, -i56, iM783getMaxHeightimpl2 + i55, 0, z14 ? orientation3 : orientation2, i55, iMo75roundToPx0680j_8);
                                lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                            } else {
                                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$2;
                                BackHandlerKt$$ExternalSyntheticLambda2 backHandlerKt$$ExternalSyntheticLambda3 = backHandlerKt$$ExternalSyntheticLambda2;
                                int iRound = Math.round(fFloatValue);
                                int i58 = firstVisibleItemScrollOffset - iRound;
                                if (i57 == 0 && i58 < 0) {
                                    iRound += i58;
                                    i58 = 0;
                                }
                                ArrayDeque arrayDeque = new ArrayDeque();
                                int i59 = -i56;
                                float f2 = fFloatValue;
                                int i60 = i59 + (iMo75roundToPx0680j_8 < 0 ? iMo75roundToPx0680j_8 : 0);
                                int i61 = i58 + i60;
                                while (i61 < 0 && i57 > 0) {
                                    MutableState mutableState2 = mutableState;
                                    int i62 = i57 - 1;
                                    BackHandlerKt$$ExternalSyntheticLambda2 backHandlerKt$$ExternalSyntheticLambda4 = backHandlerKt$$ExternalSyntheticLambda3;
                                    LazyGridMeasuredLine andMeasure = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.getAndMeasure(i62);
                                    i57 = i62;
                                    arrayDeque.add(0, andMeasure);
                                    i61 += andMeasure.mainAxisSizeWithSpacings;
                                    mutableState = mutableState2;
                                    backHandlerKt$$ExternalSyntheticLambda3 = backHandlerKt$$ExternalSyntheticLambda4;
                                }
                                MutableState mutableState3 = mutableState;
                                BackHandlerKt$$ExternalSyntheticLambda2 backHandlerKt$$ExternalSyntheticLambda5 = backHandlerKt$$ExternalSyntheticLambda3;
                                if (i61 < i60) {
                                    iRound -= i60 - i61;
                                    i61 = i60;
                                }
                                int i63 = iRound;
                                int i64 = i61 - i60;
                                int i65 = iM783getMaxHeightimpl2 + i55;
                                int i66 = i65 < 0 ? 0 : i65;
                                int i67 = -i64;
                                int i68 = i57;
                                int i69 = 0;
                                boolean z15 = false;
                                while (i69 < arrayDeque.size) {
                                    if (i67 >= i66) {
                                        arrayDeque.removeAt(i69);
                                        z15 = true;
                                    } else {
                                        i68++;
                                        i67 += ((LazyGridMeasuredLine) arrayDeque.get(i69)).mainAxisSizeWithSpacings;
                                        i69++;
                                    }
                                }
                                int i70 = i64;
                                boolean z16 = z15;
                                int i71 = i68;
                                while (true) {
                                    if (i71 >= itemCount || (i67 >= i66 && i67 > 0 && !arrayDeque.isEmpty())) {
                                        i13 = i70;
                                        break;
                                    }
                                    int i72 = i66;
                                    LazyGridMeasuredLine andMeasure2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.getAndMeasure(i71);
                                    int i73 = i71;
                                    int i74 = andMeasure2.mainAxisSizeWithSpacings;
                                    LazyGridMeasuredItem[] lazyGridMeasuredItemArr2 = andMeasure2.items;
                                    i13 = i70;
                                    if (lazyGridMeasuredItemArr2.length == 0) {
                                        break;
                                    }
                                    i67 += i74;
                                    if (i67 > i60) {
                                        arrayDeque.addLast(andMeasure2);
                                        i70 = i13;
                                    } else {
                                        if (lazyGridMeasuredItemArr2.length == 0) {
                                            PathKt$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
                                            return null;
                                        }
                                        if (lazyGridMeasuredItemArr2[lazyGridMeasuredItemArr2.length - 1].index != itemCount - 1) {
                                            i70 = i13 - i74;
                                            i57 = i73 + 1;
                                            z16 = true;
                                        } else {
                                            arrayDeque.addLast(andMeasure2);
                                            i70 = i13;
                                        }
                                    }
                                    i71 = i73 + 1;
                                    i66 = i72;
                                }
                                if (i67 < iM783getMaxHeightimpl2) {
                                    int i75 = iM783getMaxHeightimpl2 - i67;
                                    i16 = i13 - i75;
                                    int i76 = i67 + i75;
                                    while (i16 < i56 && i57 > 0) {
                                        int i77 = i57 - 1;
                                        LazyGridMeasuredLine andMeasure3 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.getAndMeasure(i77);
                                        arrayDeque.add(0, andMeasure3);
                                        i16 += andMeasure3.mainAxisSizeWithSpacings;
                                        i75 = i75;
                                        i57 = i77;
                                    }
                                    i15 = i63 + i75;
                                    if (i16 < 0) {
                                        i15 += i16;
                                        i14 = i76 + i16;
                                        i16 = 0;
                                    } else {
                                        i14 = i76;
                                    }
                                } else {
                                    i14 = i67;
                                    i15 = i63;
                                    i16 = i13;
                                }
                                float f3 = (Integer.signum(Math.round(f2)) != Integer.signum(i15) || Math.abs(Math.round(f2)) < Math.abs(i15)) ? f2 : i15;
                                float f4 = f2 - f3;
                                float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
                                if (zIsLookingAhead && i15 > i63 && f4 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f5 = (i15 - i63) + f4;
                                }
                                float f6 = f5;
                                if (i16 < 0) {
                                    InlineClassHelperKt.throwIllegalArgumentException("negative initial offset");
                                }
                                int i78 = -i16;
                                LazyGridMeasuredLine lazyGridMeasuredLine5 = (LazyGridMeasuredLine) arrayDeque.firstOrNull();
                                if (lazyGridMeasuredLine5 != null) {
                                    LazyGridMeasuredItem[] lazyGridMeasuredItemArr3 = lazyGridMeasuredLine5.items;
                                    lazyGridMeasuredLine = lazyGridMeasuredLine5;
                                    LazyGridMeasuredItem lazyGridMeasuredItem3 = lazyGridMeasuredItemArr3.length == 0 ? null : lazyGridMeasuredItemArr3[0];
                                    i17 = lazyGridMeasuredItem3 != null ? lazyGridMeasuredItem3.index : 0;
                                    lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque.lastOrNull();
                                    if (lazyGridMeasuredLine2 != null) {
                                        lazyGridMeasuredItemArr = lazyGridMeasuredLine2.items;
                                        i18 = i56;
                                        if (lazyGridMeasuredItemArr.length == 0) {
                                            lazyGridMeasuredItem2 = null;
                                        } else {
                                            lazyGridMeasuredItem2 = lazyGridMeasuredItemArr[lazyGridMeasuredItemArr.length - 1];
                                        }
                                        i19 = lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.index : 0;
                                        iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                        i20 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                        i21 = i16;
                                        arrayList = null;
                                        i22 = 0;
                                        while (true) {
                                            lazyGridSpanLayoutProvider = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.spanLayoutProvider;
                                            if (i22 < i20) {
                                                break;
                                            }
                                            int i79 = i20;
                                            i51 = iArr[i22];
                                            if (i51 < 0 && i51 < i17) {
                                                int i80 = lazyGridSpanLayoutProvider.slotsPerLine;
                                                int iSpanOf = lazyGridSpanLayoutProvider.spanOf(i51);
                                                LazyGridMeasuredItem lazyGridMeasuredItemM166getAndMeasurem8Kt_7k = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3.m166getAndMeasurem8Kt_7k(i51, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.m167childConstraintsJhjzzOo$foundation(0, iSpanOf), 0, iSpanOf, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3.defaultMainAxisSpacing);
                                                ArrayList arrayList8 = arrayList == null ? new ArrayList() : arrayList;
                                                arrayList8.add(lazyGridMeasuredItemM166getAndMeasurem8Kt_7k);
                                                arrayList = arrayList8;
                                            }
                                            i22++;
                                            i20 = i79;
                                            i17 = i17;
                                        }
                                        i23 = i17;
                                        if (arrayList == null) {
                                            list = emptyList;
                                        } else {
                                            list = arrayList;
                                        }
                                        if (zIsLookingAhead || lazyGridMeasureResult2 == null) {
                                            i24 = i19;
                                            f = f3;
                                            arrayList2 = null;
                                        } else {
                                            List list2 = lazyGridMeasureResult2.visibleItemsInfo;
                                            if (list2.isEmpty()) {
                                                i24 = i19;
                                                f = f3;
                                                arrayList2 = null;
                                            } else {
                                                int size9 = list2.size();
                                                while (true) {
                                                    size9--;
                                                    if (-1 >= size9) {
                                                        lazyGridMeasuredItem = null;
                                                        break;
                                                    }
                                                    if (((LazyGridMeasuredItem) list2.get(size9)).index > i19 && (size9 == 0 || ((LazyGridMeasuredItem) list2.get(size9 - 1)).index <= i19)) {
                                                        lazyGridMeasuredItem = (LazyGridMeasuredItem) list2.get(size9);
                                                        break;
                                                    }
                                                }
                                                LazyGridMeasuredItem lazyGridMeasuredItem4 = (LazyGridMeasuredItem) CollectionsKt.last(list2);
                                                LazyGridMeasuredLine lazyGridMeasuredLine6 = (LazyGridMeasuredLine) CollectionsKt.lastOrNull(arrayDeque);
                                                int i81 = lazyGridMeasuredLine6 != null ? lazyGridMeasuredLine6.index + 1 : 0;
                                                if (lazyGridMeasuredItem != null) {
                                                    int i82 = lazyGridMeasuredItem.index;
                                                    i24 = i19;
                                                    int iMin = Math.min(lazyGridMeasuredItem4.index, itemCount - 1);
                                                    if (i82 <= iMin) {
                                                        arrayList2 = null;
                                                        while (true) {
                                                            if (arrayList2 != null) {
                                                                f = f3;
                                                                int size10 = arrayList2.size();
                                                                list = list;
                                                                int i83 = 0;
                                                                while (true) {
                                                                    if (i83 < size10) {
                                                                        int i84 = i83;
                                                                        LazyGridMeasuredItem[] lazyGridMeasuredItemArr4 = ((LazyGridMeasuredLine) arrayList2.get(i83)).items;
                                                                        List list3 = arrayList2;
                                                                        int length5 = lazyGridMeasuredItemArr4.length;
                                                                        int i85 = 0;
                                                                        while (true) {
                                                                            if (i85 < length5) {
                                                                                int i86 = i85;
                                                                                if (lazyGridMeasuredItemArr4[i86].index == i82) {
                                                                                    arrayList2 = list3;
                                                                                } else {
                                                                                    i85 = i86 + 1;
                                                                                }
                                                                            } else {
                                                                                i83 = i84 + 1;
                                                                                arrayList2 = list3;
                                                                            }
                                                                        }
                                                                    }
                                                                    if (i82 != iMin) {
                                                                        break;
                                                                    }
                                                                    i82++;
                                                                    list = list;
                                                                    f3 = f;
                                                                }
                                                            } else {
                                                                list = list;
                                                                f = f3;
                                                            }
                                                            List list4 = arrayList2;
                                                            arrayList2 = list4 == null ? new ArrayList() : list4;
                                                            LazyGridMeasuredLine andMeasure4 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.getAndMeasure(i81);
                                                            i81++;
                                                            arrayList2.add(andMeasure4);
                                                            if (i82 != iMin) {
                                                                break;
                                                                break;
                                                            }
                                                            i82++;
                                                            list = list;
                                                            f3 = f;
                                                        }
                                                    }
                                                } else {
                                                    i24 = i19;
                                                }
                                                f = f3;
                                                arrayList2 = null;
                                            }
                                        }
                                        if (arrayList2 == null) {
                                            arrayList2 = emptyList;
                                        }
                                        iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                        i25 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                        arrayList3 = null;
                                        i26 = 0;
                                        while (i26 < i25) {
                                            i49 = iArr2[i26];
                                            if (i24 + 1 <= i49 || i49 >= itemCount) {
                                                i50 = i25;
                                                iArr6 = iArr2;
                                            } else {
                                                if (zIsLookingAhead) {
                                                    int size11 = arrayList2.size();
                                                    i50 = i25;
                                                    int i87 = 0;
                                                    while (true) {
                                                        if (i87 < size11) {
                                                            int i88 = i87;
                                                            LazyGridMeasuredItem[] lazyGridMeasuredItemArr5 = ((LazyGridMeasuredLine) arrayList2.get(i87)).items;
                                                            iArr6 = iArr2;
                                                            int length6 = lazyGridMeasuredItemArr5.length;
                                                            int i89 = 0;
                                                            while (true) {
                                                                if (i89 < length6) {
                                                                    int i90 = i89;
                                                                    if (lazyGridMeasuredItemArr5[i90].index != i49) {
                                                                        i89 = i90 + 1;
                                                                    }
                                                                } else {
                                                                    i87 = i88 + 1;
                                                                    iArr2 = iArr6;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    i50 = i25;
                                                }
                                                iArr6 = iArr2;
                                                int i91 = lazyGridSpanLayoutProvider.slotsPerLine;
                                                int iSpanOf2 = lazyGridSpanLayoutProvider.spanOf(i49);
                                                lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                                LazyGridMeasuredItem lazyGridMeasuredItemM166getAndMeasurem8Kt_7k2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1.m166getAndMeasurem8Kt_7k(i49, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.m167childConstraintsJhjzzOo$foundation(0, iSpanOf2), 0, iSpanOf2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3.defaultMainAxisSpacing);
                                                if (arrayList3 == null) {
                                                    arrayList3 = new ArrayList();
                                                }
                                                arrayList3.add(lazyGridMeasuredItemM166getAndMeasurem8Kt_7k2);
                                                i26++;
                                                i25 = i50;
                                                iArr2 = iArr6;
                                                lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1;
                                            }
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                            i26++;
                                            i25 = i50;
                                            iArr2 = iArr6;
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1;
                                        }
                                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$4 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                        if (arrayList3 == null) {
                                            arrayList3 = emptyList;
                                        }
                                        if (i18 <= 0 || iMo75roundToPx0680j_8 < 0) {
                                            size = arrayDeque.getSize();
                                            LazyGridMeasuredLine lazyGridMeasuredLine7 = lazyGridMeasuredLine;
                                            i27 = i21;
                                            i28 = 0;
                                            while (i28 < size) {
                                                int i92 = ((LazyGridMeasuredLine) arrayDeque.get(i28)).mainAxisSizeWithSpacings;
                                                if (i27 != 0 || i92 > i27 || i28 == arrayDeque.getSize() - 1) {
                                                    break;
                                                }
                                                i27 -= i92;
                                                i28++;
                                                lazyGridMeasuredLine7 = (LazyGridMeasuredLine) arrayDeque.get(i28);
                                            }
                                            i21 = i27;
                                            lazyGridMeasuredLine3 = lazyGridMeasuredLine7;
                                        } else {
                                            lazyGridMeasuredLine3 = lazyGridMeasuredLine;
                                        }
                                        if (z14) {
                                            iM792constrainWidthK40F9xA = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                                            j2 = jM793offsetNN6EwU;
                                        } else {
                                            j2 = jM793offsetNN6EwU;
                                            iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(i14, j2);
                                        }
                                        if (z14) {
                                            iM783getMaxHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA(i14, j2);
                                        } else {
                                            iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j2);
                                        }
                                        i29 = iM783getMaxHeightimpl;
                                        listPlus = arrayDeque;
                                        if (!arrayList2.isEmpty()) {
                                            listPlus = CollectionsKt.plus((Iterable) arrayList2, (Collection) arrayDeque);
                                        }
                                        j3 = j2;
                                        if (z14) {
                                            i30 = i29;
                                        } else {
                                            i30 = iM792constrainWidthK40F9xA;
                                        }
                                        if (i14 < Math.min(i30, iM783getMaxHeightimpl2)) {
                                            z9 = true;
                                        } else {
                                            z9 = false;
                                        }
                                        if (z9 && i78 != 0) {
                                            InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
                                        }
                                        size2 = listPlus.size();
                                        i31 = 0;
                                        length = 0;
                                        while (i31 < size2) {
                                            length += ((LazyGridMeasuredLine) listPlus.get(i31)).items.length;
                                            i31++;
                                            z9 = z9;
                                        }
                                        z10 = z9;
                                        arrayList4 = new ArrayList(length);
                                        if (z10) {
                                            if (list.isEmpty() || !arrayList3.isEmpty()) {
                                                InlineClassHelperKt.throwIllegalArgumentException("no items");
                                            }
                                            size8 = listPlus.size();
                                            iArr3 = new int[size8];
                                            for (i43 = 0; i43 < size8; i43++) {
                                                iArr3[i43] = ((LazyGridMeasuredLine) listPlus.get(i43)).mainAxisSize;
                                            }
                                            iArr4 = new int[size8];
                                            if (z14) {
                                                if (arrangement$Vertical2 != null) {
                                                    throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement");
                                                }
                                                arrangement$Vertical2.arrange(lazyLayoutMeasureScopeImpl, i30, iArr3, iArr4);
                                                iArr5 = iArr4;
                                            } else {
                                                if (arrangement$Horizontal2 != null) {
                                                    throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement");
                                                }
                                                iArr5 = iArr4;
                                                arrangement$Horizontal2.arrange(lazyLayoutMeasureScopeImpl, i30, iArr3, LayoutDirection.Ltr, iArr5);
                                            }
                                            IntRange indices = ArraysKt.getIndices(iArr5);
                                            i44 = indices.last;
                                            i45 = indices.step;
                                            if ((i45 > 0 && i44 >= 0) || (i45 < 0 && i44 <= 0)) {
                                                i46 = 0;
                                                while (true) {
                                                    lazyGridMeasuredItemArrPosition2 = ((LazyGridMeasuredLine) listPlus.get(i46)).position(iArr5[i46], iM792constrainWidthK40F9xA, i29);
                                                    length3 = lazyGridMeasuredItemArrPosition2.length;
                                                    i47 = i45;
                                                    i48 = 0;
                                                    while (i48 < length3) {
                                                        int i93 = i48;
                                                        arrayList4.add(lazyGridMeasuredItemArrPosition2[i93]);
                                                        i48 = i93 + 1;
                                                    }
                                                    if (i46 == i44) {
                                                        break;
                                                    }
                                                    i46 += i47;
                                                    i45 = i47;
                                                }
                                            }
                                            arrayList5 = arrayList4;
                                        } else {
                                            arrayList5 = arrayList4;
                                            i23 = i23;
                                            size3 = list.size() - 1;
                                            if (size3 >= 0) {
                                                mainAxisSizeWithSpacings2 = i78;
                                                while (true) {
                                                    i35 = size3 - 1;
                                                    LazyGridMeasuredItem lazyGridMeasuredItem5 = (LazyGridMeasuredItem) list.get(size3);
                                                    mainAxisSizeWithSpacings2 -= lazyGridMeasuredItem5.getMainAxisSizeWithSpacings();
                                                    lazyGridMeasuredItem5.position(mainAxisSizeWithSpacings2, 0, iM792constrainWidthK40F9xA, i29);
                                                    arrayList5.add(lazyGridMeasuredItem5);
                                                    if (i35 < 0) {
                                                        break;
                                                    }
                                                    size3 = i35;
                                                }
                                            }
                                            size4 = listPlus.size();
                                            mainAxisSizeWithSpacings = i78;
                                            i32 = 0;
                                            while (i32 < size4) {
                                                int i94 = size4;
                                                LazyGridMeasuredLine lazyGridMeasuredLine8 = (LazyGridMeasuredLine) listPlus.get(i32);
                                                int i95 = i32;
                                                lazyGridMeasuredItemArrPosition = lazyGridMeasuredLine8.position(mainAxisSizeWithSpacings, iM792constrainWidthK40F9xA, i29);
                                                int i96 = mainAxisSizeWithSpacings;
                                                i34 = 0;
                                                for (length2 = lazyGridMeasuredItemArrPosition.length; i34 < length2; length2 = length2) {
                                                    arrayList5.add(lazyGridMeasuredItemArrPosition[i34]);
                                                    i34++;
                                                }
                                                mainAxisSizeWithSpacings = i96 + lazyGridMeasuredLine8.mainAxisSizeWithSpacings;
                                                i32 = i95 + 1;
                                                size4 = i94;
                                            }
                                            i33 = 0;
                                            for (size5 = arrayList3.size(); i33 < size5; size5 = size5) {
                                                LazyGridMeasuredItem lazyGridMeasuredItem6 = (LazyGridMeasuredItem) arrayList3.get(i33);
                                                lazyGridMeasuredItem6.position(mainAxisSizeWithSpacings, 0, iM792constrainWidthK40F9xA, i29);
                                                arrayList5.add(lazyGridMeasuredItem6);
                                                mainAxisSizeWithSpacings += lazyGridMeasuredItem6.getMainAxisSizeWithSpacings();
                                                i33++;
                                            }
                                        }
                                        float f7 = f;
                                        arrayList6 = arrayList5;
                                        int i97 = i14;
                                        lazyLayoutItemAnimator.onMeasured((int) f7, iM792constrainWidthK40F9xA, i29, arrayList6, statusLine, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$4, z14, zIsLookingAhead, length4, z12, i21, i97, coroutineScope2, graphicsContext2, true);
                                        int i98 = i18;
                                        if (zIsLookingAhead) {
                                            i36 = itemCount;
                                            lazyGridMeasuredLine4 = lazyGridMeasuredLine3;
                                        } else {
                                            jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                            lazyGridMeasuredLine4 = lazyGridMeasuredLine3;
                                            if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                                if (z14) {
                                                    i40 = i29;
                                                } else {
                                                    i40 = iM792constrainWidthK40F9xA;
                                                }
                                                iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32)), j3);
                                                iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(i29, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L)), j3);
                                                if (z14) {
                                                    i41 = iM791constrainHeightK40F9xA;
                                                } else {
                                                    i41 = iM792constrainWidthK40F9xA;
                                                }
                                                if (i41 != i40) {
                                                    size7 = arrayList6.size();
                                                    for (i42 = 0; i42 < size7; i42++) {
                                                        LazyGridMeasuredItem lazyGridMeasuredItem7 = (LazyGridMeasuredItem) arrayList6.get(i42);
                                                        lazyGridMeasuredItem7.mainAxisLayoutSize = i41;
                                                        lazyGridMeasuredItem7.maxMainAxisOffset = lazyGridMeasuredItem7.afterContentPadding + i41;
                                                    }
                                                }
                                            }
                                            int i99 = iM792constrainWidthK40F9xA;
                                            lazyGridItemProviderImpl2.intervalContent.getClass();
                                            i37 = i24;
                                            int i100 = iM791constrainHeightK40F9xA;
                                            listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i23, i37, arrayList6, IntListKt.EmptyIntList, i98, i99, i100, z14, new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$4, (byte) 24));
                                            if (i37 == i36 - 1 || i97 > iM783getMaxHeightimpl2) {
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            MeasureResult measureResultLayout = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i99 + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(i100 + iMo75roundToPx0680j_7, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState3, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 1));
                                            List listUpdatedVisibleItems = LazyLayoutKt.updatedVisibleItems(i23, i37, arrayList6, listApplyStickyItems);
                                            if (z14) {
                                                orientation = orientation3;
                                            } else {
                                                orientation = orientation2;
                                            }
                                            size6 = listApplyStickyItems.size();
                                            i39 = 0;
                                            for (i38 = 0; i38 < size6; i38++) {
                                                i39 += ((LazyGridMeasuredItem) listApplyStickyItems.get(i38)).mainAxisSize;
                                            }
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                                            subcomposeMeasureScope = subcomposeMeasureScope2;
                                            lazyGridMeasureResult = new LazyGridMeasureResult(lazyGridMeasuredLine4, i21, z11, f7, measureResultLayout, f6, z16, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda5, scrollState$$ExternalSyntheticLambda0, i39, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, listUpdatedVisibleItems, i59, i65, i36, orientation, i55, iMo75roundToPx0680j_8);
                                        }
                                        i36 = itemCount;
                                        iM791constrainHeightK40F9xA = i29;
                                        int i910 = iM792constrainWidthK40F9xA;
                                        lazyGridItemProviderImpl2.intervalContent.getClass();
                                        i37 = i24;
                                        int i101 = iM791constrainHeightK40F9xA;
                                        listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i23, i37, arrayList6, IntListKt.EmptyIntList, i98, i910, i101, z14, new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$4, (byte) 24));
                                        if (i37 == i36 - 1) {
                                            z11 = true;
                                        } else {
                                            z11 = true;
                                        }
                                        MeasureResult measureResultLayout2 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i910 + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(i101 + iMo75roundToPx0680j_7, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState3, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 1));
                                        List listUpdatedVisibleItems2 = LazyLayoutKt.updatedVisibleItems(i23, i37, arrayList6, listApplyStickyItems);
                                        if (z14) {
                                            orientation = orientation3;
                                        } else {
                                            orientation = orientation2;
                                        }
                                        size6 = listApplyStickyItems.size();
                                        i39 = 0;
                                        while (i38 < size6) {
                                            i39 += ((LazyGridMeasuredItem) listApplyStickyItems.get(i38)).mainAxisSize;
                                        }
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                                        subcomposeMeasureScope = subcomposeMeasureScope2;
                                        lazyGridMeasureResult = new LazyGridMeasureResult(lazyGridMeasuredLine4, i21, z11, f7, measureResultLayout2, f6, z16, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda5, scrollState$$ExternalSyntheticLambda0, i39, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, listUpdatedVisibleItems2, i59, i65, i36, orientation, i55, iMo75roundToPx0680j_8);
                                    } else {
                                        i18 = i56;
                                    }
                                    iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                    i20 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                    i21 = i16;
                                    arrayList = null;
                                    i22 = 0;
                                    while (true) {
                                        lazyGridSpanLayoutProvider = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.spanLayoutProvider;
                                        if (i22 < i20) {
                                            break;
                                            break;
                                        }
                                        int i710 = i20;
                                        i51 = iArr[i22];
                                        if (i51 < 0) {
                                        }
                                        i22++;
                                        i20 = i710;
                                        i17 = i17;
                                    }
                                    i23 = i17;
                                    if (arrayList == null) {
                                        list = emptyList;
                                    } else {
                                        list = arrayList;
                                    }
                                    if (zIsLookingAhead) {
                                        i24 = i19;
                                        f = f3;
                                        arrayList2 = null;
                                    } else {
                                        i24 = i19;
                                        f = f3;
                                        arrayList2 = null;
                                    }
                                    if (arrayList2 == null) {
                                        arrayList2 = emptyList;
                                    }
                                    iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                    i25 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                    arrayList3 = null;
                                    i26 = 0;
                                    while (i26 < i25) {
                                        i49 = iArr2[i26];
                                        if (i24 + 1 <= i49) {
                                            i50 = i25;
                                            iArr6 = iArr2;
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                        } else {
                                            i50 = i25;
                                            iArr6 = iArr2;
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                        }
                                        i26++;
                                        i25 = i50;
                                        iArr2 = iArr6;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1;
                                    }
                                    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$5 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                    if (arrayList3 == null) {
                                        arrayList3 = emptyList;
                                    }
                                    if (i18 <= 0) {
                                        size = arrayDeque.getSize();
                                        LazyGridMeasuredLine lazyGridMeasuredLine9 = lazyGridMeasuredLine;
                                        i27 = i21;
                                        i28 = 0;
                                        while (i28 < size) {
                                            int i911 = ((LazyGridMeasuredLine) arrayDeque.get(i28)).mainAxisSizeWithSpacings;
                                            if (i27 != 0) {
                                                break;
                                            }
                                            break;
                                        }
                                        i21 = i27;
                                        lazyGridMeasuredLine3 = lazyGridMeasuredLine9;
                                    } else {
                                        size = arrayDeque.getSize();
                                        LazyGridMeasuredLine lazyGridMeasuredLine10 = lazyGridMeasuredLine;
                                        i27 = i21;
                                        i28 = 0;
                                        while (i28 < size) {
                                            int i912 = ((LazyGridMeasuredLine) arrayDeque.get(i28)).mainAxisSizeWithSpacings;
                                            if (i27 != 0) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                        }
                                        i21 = i27;
                                        lazyGridMeasuredLine3 = lazyGridMeasuredLine10;
                                    }
                                    if (z14) {
                                        iM792constrainWidthK40F9xA = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                                        j2 = jM793offsetNN6EwU;
                                    } else {
                                        j2 = jM793offsetNN6EwU;
                                        iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(i14, j2);
                                    }
                                    if (z14) {
                                        iM783getMaxHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA(i14, j2);
                                    } else {
                                        iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j2);
                                    }
                                    i29 = iM783getMaxHeightimpl;
                                    listPlus = arrayDeque;
                                    if (!arrayList2.isEmpty()) {
                                        listPlus = CollectionsKt.plus((Iterable) arrayList2, (Collection) arrayDeque);
                                    }
                                    j3 = j2;
                                    if (z14) {
                                        i30 = i29;
                                    } else {
                                        i30 = iM792constrainWidthK40F9xA;
                                    }
                                    if (i14 < Math.min(i30, iM783getMaxHeightimpl2)) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    if (z9) {
                                        InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
                                    }
                                    size2 = listPlus.size();
                                    i31 = 0;
                                    length = 0;
                                    while (i31 < size2) {
                                        length += ((LazyGridMeasuredLine) listPlus.get(i31)).items.length;
                                        i31++;
                                        z9 = z9;
                                    }
                                    z10 = z9;
                                    arrayList4 = new ArrayList(length);
                                    if (z10) {
                                        if (list.isEmpty()) {
                                            InlineClassHelperKt.throwIllegalArgumentException("no items");
                                        } else {
                                            InlineClassHelperKt.throwIllegalArgumentException("no items");
                                        }
                                        size8 = listPlus.size();
                                        iArr3 = new int[size8];
                                        while (i43 < size8) {
                                            iArr3[i43] = ((LazyGridMeasuredLine) listPlus.get(i43)).mainAxisSize;
                                        }
                                        iArr4 = new int[size8];
                                        if (z14) {
                                            if (arrangement$Vertical2 != null) {
                                                throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement");
                                            }
                                            arrangement$Vertical2.arrange(lazyLayoutMeasureScopeImpl, i30, iArr3, iArr4);
                                            iArr5 = iArr4;
                                        } else {
                                            if (arrangement$Horizontal2 != null) {
                                                throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement");
                                            }
                                            iArr5 = iArr4;
                                            arrangement$Horizontal2.arrange(lazyLayoutMeasureScopeImpl, i30, iArr3, LayoutDirection.Ltr, iArr5);
                                        }
                                        IntRange indices2 = ArraysKt.getIndices(iArr5);
                                        i44 = indices2.last;
                                        i45 = indices2.step;
                                        if (i45 > 0) {
                                            i46 = 0;
                                            while (true) {
                                                lazyGridMeasuredItemArrPosition2 = ((LazyGridMeasuredLine) listPlus.get(i46)).position(iArr5[i46], iM792constrainWidthK40F9xA, i29);
                                                length3 = lazyGridMeasuredItemArrPosition2.length;
                                                i47 = i45;
                                                i48 = 0;
                                                while (i48 < length3) {
                                                    int i913 = i48;
                                                    arrayList4.add(lazyGridMeasuredItemArrPosition2[i913]);
                                                    i48 = i913 + 1;
                                                }
                                                if (i46 == i44) {
                                                    break;
                                                    break;
                                                }
                                                i46 += i47;
                                                i45 = i47;
                                            }
                                        } else {
                                            i46 = 0;
                                            while (true) {
                                                lazyGridMeasuredItemArrPosition2 = ((LazyGridMeasuredLine) listPlus.get(i46)).position(iArr5[i46], iM792constrainWidthK40F9xA, i29);
                                                length3 = lazyGridMeasuredItemArrPosition2.length;
                                                i47 = i45;
                                                i48 = 0;
                                                while (i48 < length3) {
                                                    int i914 = i48;
                                                    arrayList4.add(lazyGridMeasuredItemArrPosition2[i914]);
                                                    i48 = i914 + 1;
                                                }
                                                if (i46 == i44) {
                                                    break;
                                                    break;
                                                }
                                                i46 += i47;
                                                i45 = i47;
                                            }
                                        }
                                        arrayList5 = arrayList4;
                                    } else {
                                        arrayList5 = arrayList4;
                                        i23 = i23;
                                        size3 = list.size() - 1;
                                        if (size3 >= 0) {
                                            mainAxisSizeWithSpacings2 = i78;
                                            while (true) {
                                                i35 = size3 - 1;
                                                LazyGridMeasuredItem lazyGridMeasuredItem8 = (LazyGridMeasuredItem) list.get(size3);
                                                mainAxisSizeWithSpacings2 -= lazyGridMeasuredItem8.getMainAxisSizeWithSpacings();
                                                lazyGridMeasuredItem8.position(mainAxisSizeWithSpacings2, 0, iM792constrainWidthK40F9xA, i29);
                                                arrayList5.add(lazyGridMeasuredItem8);
                                                if (i35 < 0) {
                                                    break;
                                                    break;
                                                }
                                                size3 = i35;
                                            }
                                        }
                                        size4 = listPlus.size();
                                        mainAxisSizeWithSpacings = i78;
                                        i32 = 0;
                                        while (i32 < size4) {
                                            int i915 = size4;
                                            LazyGridMeasuredLine lazyGridMeasuredLine11 = (LazyGridMeasuredLine) listPlus.get(i32);
                                            int i916 = i32;
                                            lazyGridMeasuredItemArrPosition = lazyGridMeasuredLine11.position(mainAxisSizeWithSpacings, iM792constrainWidthK40F9xA, i29);
                                            int i917 = mainAxisSizeWithSpacings;
                                            i34 = 0;
                                            while (i34 < length2) {
                                                arrayList5.add(lazyGridMeasuredItemArrPosition[i34]);
                                                i34++;
                                            }
                                            mainAxisSizeWithSpacings = i917 + lazyGridMeasuredLine11.mainAxisSizeWithSpacings;
                                            i32 = i916 + 1;
                                            size4 = i915;
                                        }
                                        i33 = 0;
                                        while (i33 < size5) {
                                            LazyGridMeasuredItem lazyGridMeasuredItem9 = (LazyGridMeasuredItem) arrayList3.get(i33);
                                            lazyGridMeasuredItem9.position(mainAxisSizeWithSpacings, 0, iM792constrainWidthK40F9xA, i29);
                                            arrayList5.add(lazyGridMeasuredItem9);
                                            mainAxisSizeWithSpacings += lazyGridMeasuredItem9.getMainAxisSizeWithSpacings();
                                            i33++;
                                        }
                                    }
                                    float f8 = f;
                                    arrayList6 = arrayList5;
                                    int i918 = i14;
                                    lazyLayoutItemAnimator.onMeasured((int) f8, iM792constrainWidthK40F9xA, i29, arrayList6, statusLine, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$5, z14, zIsLookingAhead, length4, z12, i21, i918, coroutineScope2, graphicsContext2, true);
                                    int i919 = i18;
                                    if (zIsLookingAhead) {
                                        jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                        lazyGridMeasuredLine4 = lazyGridMeasuredLine3;
                                        if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                            if (z14) {
                                                i40 = i29;
                                            } else {
                                                i40 = iM792constrainWidthK40F9xA;
                                            }
                                            iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32)), j3);
                                            iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(i29, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L)), j3);
                                            if (z14) {
                                                i41 = iM791constrainHeightK40F9xA;
                                            } else {
                                                i41 = iM792constrainWidthK40F9xA;
                                            }
                                            if (i41 != i40) {
                                                size7 = arrayList6.size();
                                                while (i42 < size7) {
                                                    LazyGridMeasuredItem lazyGridMeasuredItem10 = (LazyGridMeasuredItem) arrayList6.get(i42);
                                                    lazyGridMeasuredItem10.mainAxisLayoutSize = i41;
                                                    lazyGridMeasuredItem10.maxMainAxisOffset = lazyGridMeasuredItem10.afterContentPadding + i41;
                                                }
                                            }
                                        }
                                        int i9110 = iM792constrainWidthK40F9xA;
                                        lazyGridItemProviderImpl2.intervalContent.getClass();
                                        i37 = i24;
                                        int i102 = iM791constrainHeightK40F9xA;
                                        listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i23, i37, arrayList6, IntListKt.EmptyIntList, i919, i9110, i102, z14, new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$5, (byte) 24));
                                        if (i37 == i36 - 1) {
                                            z11 = true;
                                        } else {
                                            z11 = true;
                                        }
                                        MeasureResult measureResultLayout3 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i9110 + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(i102 + iMo75roundToPx0680j_7, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState3, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 1));
                                        List listUpdatedVisibleItems3 = LazyLayoutKt.updatedVisibleItems(i23, i37, arrayList6, listApplyStickyItems);
                                        if (z14) {
                                            orientation = orientation3;
                                        } else {
                                            orientation = orientation2;
                                        }
                                        size6 = listApplyStickyItems.size();
                                        i39 = 0;
                                        while (i38 < size6) {
                                            i39 += ((LazyGridMeasuredItem) listApplyStickyItems.get(i38)).mainAxisSize;
                                        }
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                                        subcomposeMeasureScope = subcomposeMeasureScope2;
                                        lazyGridMeasureResult = new LazyGridMeasureResult(lazyGridMeasuredLine4, i21, z11, f8, measureResultLayout3, f6, z16, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda5, scrollState$$ExternalSyntheticLambda0, i39, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, listUpdatedVisibleItems3, i59, i65, i36, orientation, i55, iMo75roundToPx0680j_8);
                                    } else {
                                        i36 = itemCount;
                                        lazyGridMeasuredLine4 = lazyGridMeasuredLine3;
                                    }
                                    i36 = itemCount;
                                    iM791constrainHeightK40F9xA = i29;
                                    int i9111 = iM792constrainWidthK40F9xA;
                                    lazyGridItemProviderImpl2.intervalContent.getClass();
                                    i37 = i24;
                                    int i103 = iM791constrainHeightK40F9xA;
                                    listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i23, i37, arrayList6, IntListKt.EmptyIntList, i919, i9111, i103, z14, new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$5, (byte) 24));
                                    if (i37 == i36 - 1) {
                                        z11 = true;
                                    } else {
                                        z11 = true;
                                    }
                                    MeasureResult measureResultLayout4 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i9111 + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(i103 + iMo75roundToPx0680j_7, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState3, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 1));
                                    List listUpdatedVisibleItems4 = LazyLayoutKt.updatedVisibleItems(i23, i37, arrayList6, listApplyStickyItems);
                                    if (z14) {
                                        orientation = orientation3;
                                    } else {
                                        orientation = orientation2;
                                    }
                                    size6 = listApplyStickyItems.size();
                                    i39 = 0;
                                    while (i38 < size6) {
                                        i39 += ((LazyGridMeasuredItem) listApplyStickyItems.get(i38)).mainAxisSize;
                                    }
                                    lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                    lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyGridMeasureResult = new LazyGridMeasureResult(lazyGridMeasuredLine4, i21, z11, f8, measureResultLayout4, f6, z16, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda5, scrollState$$ExternalSyntheticLambda0, i39, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, listUpdatedVisibleItems4, i59, i65, i36, orientation, i55, iMo75roundToPx0680j_8);
                                } else {
                                    lazyGridMeasuredLine = lazyGridMeasuredLine5;
                                }
                                lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque.lastOrNull();
                                if (lazyGridMeasuredLine2 != null) {
                                    lazyGridMeasuredItemArr = lazyGridMeasuredLine2.items;
                                    i18 = i56;
                                    if (lazyGridMeasuredItemArr.length == 0) {
                                        lazyGridMeasuredItem2 = null;
                                    } else {
                                        lazyGridMeasuredItem2 = lazyGridMeasuredItemArr[lazyGridMeasuredItemArr.length - 1];
                                    }
                                    if (lazyGridMeasuredItem2 != null) {
                                    }
                                    iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                    i20 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                    i21 = i16;
                                    arrayList = null;
                                    i22 = 0;
                                    while (true) {
                                        lazyGridSpanLayoutProvider = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.spanLayoutProvider;
                                        if (i22 < i20) {
                                            break;
                                            break;
                                        }
                                        int i711 = i20;
                                        i51 = iArr[i22];
                                        if (i51 < 0) {
                                        }
                                        i22++;
                                        i20 = i711;
                                        i17 = i17;
                                    }
                                    i23 = i17;
                                    if (arrayList == null) {
                                        list = emptyList;
                                    } else {
                                        list = arrayList;
                                    }
                                    if (zIsLookingAhead) {
                                        i24 = i19;
                                        f = f3;
                                        arrayList2 = null;
                                    } else {
                                        i24 = i19;
                                        f = f3;
                                        arrayList2 = null;
                                    }
                                    if (arrayList2 == null) {
                                        arrayList2 = emptyList;
                                    }
                                    iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                    i25 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                    arrayList3 = null;
                                    i26 = 0;
                                    while (i26 < i25) {
                                        i49 = iArr2[i26];
                                        if (i24 + 1 <= i49) {
                                            i50 = i25;
                                            iArr6 = iArr2;
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                        } else {
                                            i50 = i25;
                                            iArr6 = iArr2;
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                        }
                                        i26++;
                                        i25 = i50;
                                        iArr2 = iArr6;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1;
                                    }
                                    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$6 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                    if (arrayList3 == null) {
                                        arrayList3 = emptyList;
                                    }
                                    if (i18 <= 0) {
                                        size = arrayDeque.getSize();
                                        LazyGridMeasuredLine lazyGridMeasuredLine12 = lazyGridMeasuredLine;
                                        i27 = i21;
                                        i28 = 0;
                                        while (i28 < size) {
                                            int i9112 = ((LazyGridMeasuredLine) arrayDeque.get(i28)).mainAxisSizeWithSpacings;
                                            if (i27 != 0) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                        }
                                        i21 = i27;
                                        lazyGridMeasuredLine3 = lazyGridMeasuredLine12;
                                    } else {
                                        size = arrayDeque.getSize();
                                        LazyGridMeasuredLine lazyGridMeasuredLine13 = lazyGridMeasuredLine;
                                        i27 = i21;
                                        i28 = 0;
                                        while (i28 < size) {
                                            int i9113 = ((LazyGridMeasuredLine) arrayDeque.get(i28)).mainAxisSizeWithSpacings;
                                            if (i27 != 0) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                        }
                                        i21 = i27;
                                        lazyGridMeasuredLine3 = lazyGridMeasuredLine13;
                                    }
                                    if (z14) {
                                        iM792constrainWidthK40F9xA = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                                        j2 = jM793offsetNN6EwU;
                                    } else {
                                        j2 = jM793offsetNN6EwU;
                                        iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(i14, j2);
                                    }
                                    if (z14) {
                                        iM783getMaxHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA(i14, j2);
                                    } else {
                                        iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j2);
                                    }
                                    i29 = iM783getMaxHeightimpl;
                                    listPlus = arrayDeque;
                                    if (!arrayList2.isEmpty()) {
                                        listPlus = CollectionsKt.plus((Iterable) arrayList2, (Collection) arrayDeque);
                                    }
                                    j3 = j2;
                                    if (z14) {
                                        i30 = i29;
                                    } else {
                                        i30 = iM792constrainWidthK40F9xA;
                                    }
                                    if (i14 < Math.min(i30, iM783getMaxHeightimpl2)) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    if (z9) {
                                        InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
                                    }
                                    size2 = listPlus.size();
                                    i31 = 0;
                                    length = 0;
                                    while (i31 < size2) {
                                        length += ((LazyGridMeasuredLine) listPlus.get(i31)).items.length;
                                        i31++;
                                        z9 = z9;
                                    }
                                    z10 = z9;
                                    arrayList4 = new ArrayList(length);
                                    if (z10) {
                                        if (list.isEmpty()) {
                                            InlineClassHelperKt.throwIllegalArgumentException("no items");
                                        } else {
                                            InlineClassHelperKt.throwIllegalArgumentException("no items");
                                        }
                                        size8 = listPlus.size();
                                        iArr3 = new int[size8];
                                        while (i43 < size8) {
                                            iArr3[i43] = ((LazyGridMeasuredLine) listPlus.get(i43)).mainAxisSize;
                                        }
                                        iArr4 = new int[size8];
                                        if (z14) {
                                            if (arrangement$Vertical2 != null) {
                                                throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement");
                                            }
                                            arrangement$Vertical2.arrange(lazyLayoutMeasureScopeImpl, i30, iArr3, iArr4);
                                            iArr5 = iArr4;
                                        } else {
                                            if (arrangement$Horizontal2 != null) {
                                                throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement");
                                            }
                                            iArr5 = iArr4;
                                            arrangement$Horizontal2.arrange(lazyLayoutMeasureScopeImpl, i30, iArr3, LayoutDirection.Ltr, iArr5);
                                        }
                                        IntRange indices3 = ArraysKt.getIndices(iArr5);
                                        i44 = indices3.last;
                                        i45 = indices3.step;
                                        if (i45 > 0) {
                                            i46 = 0;
                                            while (true) {
                                                lazyGridMeasuredItemArrPosition2 = ((LazyGridMeasuredLine) listPlus.get(i46)).position(iArr5[i46], iM792constrainWidthK40F9xA, i29);
                                                length3 = lazyGridMeasuredItemArrPosition2.length;
                                                i47 = i45;
                                                i48 = 0;
                                                while (i48 < length3) {
                                                    int i9114 = i48;
                                                    arrayList4.add(lazyGridMeasuredItemArrPosition2[i9114]);
                                                    i48 = i9114 + 1;
                                                }
                                                if (i46 == i44) {
                                                    break;
                                                    break;
                                                }
                                                i46 += i47;
                                                i45 = i47;
                                            }
                                        } else {
                                            i46 = 0;
                                            while (true) {
                                                lazyGridMeasuredItemArrPosition2 = ((LazyGridMeasuredLine) listPlus.get(i46)).position(iArr5[i46], iM792constrainWidthK40F9xA, i29);
                                                length3 = lazyGridMeasuredItemArrPosition2.length;
                                                i47 = i45;
                                                i48 = 0;
                                                while (i48 < length3) {
                                                    int i9115 = i48;
                                                    arrayList4.add(lazyGridMeasuredItemArrPosition2[i9115]);
                                                    i48 = i9115 + 1;
                                                }
                                                if (i46 == i44) {
                                                    break;
                                                    break;
                                                }
                                                i46 += i47;
                                                i45 = i47;
                                            }
                                        }
                                        arrayList5 = arrayList4;
                                    } else {
                                        arrayList5 = arrayList4;
                                        i23 = i23;
                                        size3 = list.size() - 1;
                                        if (size3 >= 0) {
                                            mainAxisSizeWithSpacings2 = i78;
                                            while (true) {
                                                i35 = size3 - 1;
                                                LazyGridMeasuredItem lazyGridMeasuredItem11 = (LazyGridMeasuredItem) list.get(size3);
                                                mainAxisSizeWithSpacings2 -= lazyGridMeasuredItem11.getMainAxisSizeWithSpacings();
                                                lazyGridMeasuredItem11.position(mainAxisSizeWithSpacings2, 0, iM792constrainWidthK40F9xA, i29);
                                                arrayList5.add(lazyGridMeasuredItem11);
                                                if (i35 < 0) {
                                                    break;
                                                    break;
                                                }
                                                size3 = i35;
                                            }
                                        }
                                        size4 = listPlus.size();
                                        mainAxisSizeWithSpacings = i78;
                                        i32 = 0;
                                        while (i32 < size4) {
                                            int i9116 = size4;
                                            LazyGridMeasuredLine lazyGridMeasuredLine14 = (LazyGridMeasuredLine) listPlus.get(i32);
                                            int i9117 = i32;
                                            lazyGridMeasuredItemArrPosition = lazyGridMeasuredLine14.position(mainAxisSizeWithSpacings, iM792constrainWidthK40F9xA, i29);
                                            int i9118 = mainAxisSizeWithSpacings;
                                            i34 = 0;
                                            while (i34 < length2) {
                                                arrayList5.add(lazyGridMeasuredItemArrPosition[i34]);
                                                i34++;
                                            }
                                            mainAxisSizeWithSpacings = i9118 + lazyGridMeasuredLine14.mainAxisSizeWithSpacings;
                                            i32 = i9117 + 1;
                                            size4 = i9116;
                                        }
                                        i33 = 0;
                                        while (i33 < size5) {
                                            LazyGridMeasuredItem lazyGridMeasuredItem12 = (LazyGridMeasuredItem) arrayList3.get(i33);
                                            lazyGridMeasuredItem12.position(mainAxisSizeWithSpacings, 0, iM792constrainWidthK40F9xA, i29);
                                            arrayList5.add(lazyGridMeasuredItem12);
                                            mainAxisSizeWithSpacings += lazyGridMeasuredItem12.getMainAxisSizeWithSpacings();
                                            i33++;
                                        }
                                    }
                                    float f9 = f;
                                    arrayList6 = arrayList5;
                                    int i9119 = i14;
                                    lazyLayoutItemAnimator.onMeasured((int) f9, iM792constrainWidthK40F9xA, i29, arrayList6, statusLine, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$6, z14, zIsLookingAhead, length4, z12, i21, i9119, coroutineScope2, graphicsContext2, true);
                                    int i9120 = i18;
                                    if (zIsLookingAhead) {
                                        jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                        lazyGridMeasuredLine4 = lazyGridMeasuredLine3;
                                        if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                            if (z14) {
                                                i40 = i29;
                                            } else {
                                                i40 = iM792constrainWidthK40F9xA;
                                            }
                                            iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32)), j3);
                                            iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(i29, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L)), j3);
                                            if (z14) {
                                                i41 = iM791constrainHeightK40F9xA;
                                            } else {
                                                i41 = iM792constrainWidthK40F9xA;
                                            }
                                            if (i41 != i40) {
                                                size7 = arrayList6.size();
                                                while (i42 < size7) {
                                                    LazyGridMeasuredItem lazyGridMeasuredItem13 = (LazyGridMeasuredItem) arrayList6.get(i42);
                                                    lazyGridMeasuredItem13.mainAxisLayoutSize = i41;
                                                    lazyGridMeasuredItem13.maxMainAxisOffset = lazyGridMeasuredItem13.afterContentPadding + i41;
                                                }
                                            }
                                        }
                                        int i91110 = iM792constrainWidthK40F9xA;
                                        lazyGridItemProviderImpl2.intervalContent.getClass();
                                        i37 = i24;
                                        int i104 = iM791constrainHeightK40F9xA;
                                        listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i23, i37, arrayList6, IntListKt.EmptyIntList, i9120, i91110, i104, z14, new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$6, (byte) 24));
                                        if (i37 == i36 - 1) {
                                            z11 = true;
                                        } else {
                                            z11 = true;
                                        }
                                        MeasureResult measureResultLayout5 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i91110 + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(i104 + iMo75roundToPx0680j_7, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState3, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 1));
                                        List listUpdatedVisibleItems5 = LazyLayoutKt.updatedVisibleItems(i23, i37, arrayList6, listApplyStickyItems);
                                        if (z14) {
                                            orientation = orientation3;
                                        } else {
                                            orientation = orientation2;
                                        }
                                        size6 = listApplyStickyItems.size();
                                        i39 = 0;
                                        while (i38 < size6) {
                                            i39 += ((LazyGridMeasuredItem) listApplyStickyItems.get(i38)).mainAxisSize;
                                        }
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                                        subcomposeMeasureScope = subcomposeMeasureScope2;
                                        lazyGridMeasureResult = new LazyGridMeasureResult(lazyGridMeasuredLine4, i21, z11, f9, measureResultLayout5, f6, z16, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda5, scrollState$$ExternalSyntheticLambda0, i39, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, listUpdatedVisibleItems5, i59, i65, i36, orientation, i55, iMo75roundToPx0680j_8);
                                    } else {
                                        i36 = itemCount;
                                        lazyGridMeasuredLine4 = lazyGridMeasuredLine3;
                                    }
                                    i36 = itemCount;
                                    iM791constrainHeightK40F9xA = i29;
                                    int i91111 = iM792constrainWidthK40F9xA;
                                    lazyGridItemProviderImpl2.intervalContent.getClass();
                                    i37 = i24;
                                    int i105 = iM791constrainHeightK40F9xA;
                                    listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i23, i37, arrayList6, IntListKt.EmptyIntList, i9120, i91111, i105, z14, new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$6, (byte) 24));
                                    if (i37 == i36 - 1) {
                                        z11 = true;
                                    } else {
                                        z11 = true;
                                    }
                                    MeasureResult measureResultLayout6 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i91111 + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(i105 + iMo75roundToPx0680j_7, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState3, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 1));
                                    List listUpdatedVisibleItems6 = LazyLayoutKt.updatedVisibleItems(i23, i37, arrayList6, listApplyStickyItems);
                                    if (z14) {
                                        orientation = orientation3;
                                    } else {
                                        orientation = orientation2;
                                    }
                                    size6 = listApplyStickyItems.size();
                                    i39 = 0;
                                    while (i38 < size6) {
                                        i39 += ((LazyGridMeasuredItem) listApplyStickyItems.get(i38)).mainAxisSize;
                                    }
                                    lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                    lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyGridMeasureResult = new LazyGridMeasureResult(lazyGridMeasuredLine4, i21, z11, f9, measureResultLayout6, f6, z16, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda5, scrollState$$ExternalSyntheticLambda0, i39, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, listUpdatedVisibleItems6, i59, i65, i36, orientation, i55, iMo75roundToPx0680j_8);
                                } else {
                                    i18 = i56;
                                }
                                iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                i20 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                i21 = i16;
                                arrayList = null;
                                i22 = 0;
                                while (true) {
                                    lazyGridSpanLayoutProvider = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2.spanLayoutProvider;
                                    if (i22 < i20) {
                                        break;
                                        break;
                                    }
                                    int i712 = i20;
                                    i51 = iArr[i22];
                                    if (i51 < 0) {
                                    }
                                    i22++;
                                    i20 = i712;
                                    i17 = i17;
                                }
                                i23 = i17;
                                if (arrayList == null) {
                                    list = emptyList;
                                } else {
                                    list = arrayList;
                                }
                                if (zIsLookingAhead) {
                                    i24 = i19;
                                    f = f3;
                                    arrayList2 = null;
                                } else {
                                    i24 = i19;
                                    f = f3;
                                    arrayList2 = null;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = emptyList;
                                }
                                iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                i25 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                arrayList3 = null;
                                i26 = 0;
                                while (i26 < i25) {
                                    i49 = iArr2[i26];
                                    if (i24 + 1 <= i49) {
                                        i50 = i25;
                                        iArr6 = iArr2;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                    } else {
                                        i50 = i25;
                                        iArr6 = iArr2;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                    }
                                    i26++;
                                    i25 = i50;
                                    iArr2 = iArr6;
                                    lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1;
                                }
                                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$7 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$3;
                                if (arrayList3 == null) {
                                    arrayList3 = emptyList;
                                }
                                if (i18 <= 0) {
                                    size = arrayDeque.getSize();
                                    LazyGridMeasuredLine lazyGridMeasuredLine15 = lazyGridMeasuredLine;
                                    i27 = i21;
                                    i28 = 0;
                                    while (i28 < size) {
                                        int i91112 = ((LazyGridMeasuredLine) arrayDeque.get(i28)).mainAxisSizeWithSpacings;
                                        if (i27 != 0) {
                                            break;
                                            break;
                                        }
                                        break;
                                        break;
                                    }
                                    i21 = i27;
                                    lazyGridMeasuredLine3 = lazyGridMeasuredLine15;
                                } else {
                                    size = arrayDeque.getSize();
                                    LazyGridMeasuredLine lazyGridMeasuredLine16 = lazyGridMeasuredLine;
                                    i27 = i21;
                                    i28 = 0;
                                    while (i28 < size) {
                                        int i91113 = ((LazyGridMeasuredLine) arrayDeque.get(i28)).mainAxisSizeWithSpacings;
                                        if (i27 != 0) {
                                            break;
                                            break;
                                        }
                                        break;
                                        break;
                                    }
                                    i21 = i27;
                                    lazyGridMeasuredLine3 = lazyGridMeasuredLine16;
                                }
                                if (z14) {
                                    iM792constrainWidthK40F9xA = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                                    j2 = jM793offsetNN6EwU;
                                } else {
                                    j2 = jM793offsetNN6EwU;
                                    iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(i14, j2);
                                }
                                if (z14) {
                                    iM783getMaxHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA(i14, j2);
                                } else {
                                    iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j2);
                                }
                                i29 = iM783getMaxHeightimpl;
                                listPlus = arrayDeque;
                                if (!arrayList2.isEmpty()) {
                                    listPlus = CollectionsKt.plus((Iterable) arrayList2, (Collection) arrayDeque);
                                }
                                j3 = j2;
                                if (z14) {
                                    i30 = i29;
                                } else {
                                    i30 = iM792constrainWidthK40F9xA;
                                }
                                if (i14 < Math.min(i30, iM783getMaxHeightimpl2)) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                if (z9) {
                                    InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
                                }
                                size2 = listPlus.size();
                                i31 = 0;
                                length = 0;
                                while (i31 < size2) {
                                    length += ((LazyGridMeasuredLine) listPlus.get(i31)).items.length;
                                    i31++;
                                    z9 = z9;
                                }
                                z10 = z9;
                                arrayList4 = new ArrayList(length);
                                if (z10) {
                                    if (list.isEmpty()) {
                                        InlineClassHelperKt.throwIllegalArgumentException("no items");
                                    } else {
                                        InlineClassHelperKt.throwIllegalArgumentException("no items");
                                    }
                                    size8 = listPlus.size();
                                    iArr3 = new int[size8];
                                    while (i43 < size8) {
                                        iArr3[i43] = ((LazyGridMeasuredLine) listPlus.get(i43)).mainAxisSize;
                                    }
                                    iArr4 = new int[size8];
                                    if (z14) {
                                        if (arrangement$Vertical2 != null) {
                                            throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement");
                                        }
                                        arrangement$Vertical2.arrange(lazyLayoutMeasureScopeImpl, i30, iArr3, iArr4);
                                        iArr5 = iArr4;
                                    } else {
                                        if (arrangement$Horizontal2 != null) {
                                            throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement");
                                        }
                                        iArr5 = iArr4;
                                        arrangement$Horizontal2.arrange(lazyLayoutMeasureScopeImpl, i30, iArr3, LayoutDirection.Ltr, iArr5);
                                    }
                                    IntRange indices4 = ArraysKt.getIndices(iArr5);
                                    i44 = indices4.last;
                                    i45 = indices4.step;
                                    if (i45 > 0) {
                                        i46 = 0;
                                        while (true) {
                                            lazyGridMeasuredItemArrPosition2 = ((LazyGridMeasuredLine) listPlus.get(i46)).position(iArr5[i46], iM792constrainWidthK40F9xA, i29);
                                            length3 = lazyGridMeasuredItemArrPosition2.length;
                                            i47 = i45;
                                            i48 = 0;
                                            while (i48 < length3) {
                                                int i91114 = i48;
                                                arrayList4.add(lazyGridMeasuredItemArrPosition2[i91114]);
                                                i48 = i91114 + 1;
                                            }
                                            if (i46 == i44) {
                                                break;
                                                break;
                                            }
                                            i46 += i47;
                                            i45 = i47;
                                        }
                                    } else {
                                        i46 = 0;
                                        while (true) {
                                            lazyGridMeasuredItemArrPosition2 = ((LazyGridMeasuredLine) listPlus.get(i46)).position(iArr5[i46], iM792constrainWidthK40F9xA, i29);
                                            length3 = lazyGridMeasuredItemArrPosition2.length;
                                            i47 = i45;
                                            i48 = 0;
                                            while (i48 < length3) {
                                                int i91115 = i48;
                                                arrayList4.add(lazyGridMeasuredItemArrPosition2[i91115]);
                                                i48 = i91115 + 1;
                                            }
                                            if (i46 == i44) {
                                                break;
                                                break;
                                            }
                                            i46 += i47;
                                            i45 = i47;
                                        }
                                    }
                                    arrayList5 = arrayList4;
                                } else {
                                    arrayList5 = arrayList4;
                                    i23 = i23;
                                    size3 = list.size() - 1;
                                    if (size3 >= 0) {
                                        mainAxisSizeWithSpacings2 = i78;
                                        while (true) {
                                            i35 = size3 - 1;
                                            LazyGridMeasuredItem lazyGridMeasuredItem14 = (LazyGridMeasuredItem) list.get(size3);
                                            mainAxisSizeWithSpacings2 -= lazyGridMeasuredItem14.getMainAxisSizeWithSpacings();
                                            lazyGridMeasuredItem14.position(mainAxisSizeWithSpacings2, 0, iM792constrainWidthK40F9xA, i29);
                                            arrayList5.add(lazyGridMeasuredItem14);
                                            if (i35 < 0) {
                                                break;
                                                break;
                                            }
                                            size3 = i35;
                                        }
                                    }
                                    size4 = listPlus.size();
                                    mainAxisSizeWithSpacings = i78;
                                    i32 = 0;
                                    while (i32 < size4) {
                                        int i91116 = size4;
                                        LazyGridMeasuredLine lazyGridMeasuredLine17 = (LazyGridMeasuredLine) listPlus.get(i32);
                                        int i91117 = i32;
                                        lazyGridMeasuredItemArrPosition = lazyGridMeasuredLine17.position(mainAxisSizeWithSpacings, iM792constrainWidthK40F9xA, i29);
                                        int i91118 = mainAxisSizeWithSpacings;
                                        i34 = 0;
                                        while (i34 < length2) {
                                            arrayList5.add(lazyGridMeasuredItemArrPosition[i34]);
                                            i34++;
                                        }
                                        mainAxisSizeWithSpacings = i91118 + lazyGridMeasuredLine17.mainAxisSizeWithSpacings;
                                        i32 = i91117 + 1;
                                        size4 = i91116;
                                    }
                                    i33 = 0;
                                    while (i33 < size5) {
                                        LazyGridMeasuredItem lazyGridMeasuredItem15 = (LazyGridMeasuredItem) arrayList3.get(i33);
                                        lazyGridMeasuredItem15.position(mainAxisSizeWithSpacings, 0, iM792constrainWidthK40F9xA, i29);
                                        arrayList5.add(lazyGridMeasuredItem15);
                                        mainAxisSizeWithSpacings += lazyGridMeasuredItem15.getMainAxisSizeWithSpacings();
                                        i33++;
                                    }
                                }
                                float f10 = f;
                                arrayList6 = arrayList5;
                                int i91119 = i14;
                                lazyLayoutItemAnimator.onMeasured((int) f10, iM792constrainWidthK40F9xA, i29, arrayList6, statusLine, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$7, z14, zIsLookingAhead, length4, z12, i21, i91119, coroutineScope2, graphicsContext2, true);
                                int i9121 = i18;
                                if (zIsLookingAhead) {
                                    jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                    lazyGridMeasuredLine4 = lazyGridMeasuredLine3;
                                    if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                        if (z14) {
                                            i40 = i29;
                                        } else {
                                            i40 = iM792constrainWidthK40F9xA;
                                        }
                                        iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32)), j3);
                                        iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(i29, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L)), j3);
                                        if (z14) {
                                            i41 = iM791constrainHeightK40F9xA;
                                        } else {
                                            i41 = iM792constrainWidthK40F9xA;
                                        }
                                        if (i41 != i40) {
                                            size7 = arrayList6.size();
                                            while (i42 < size7) {
                                                LazyGridMeasuredItem lazyGridMeasuredItem16 = (LazyGridMeasuredItem) arrayList6.get(i42);
                                                lazyGridMeasuredItem16.mainAxisLayoutSize = i41;
                                                lazyGridMeasuredItem16.maxMainAxisOffset = lazyGridMeasuredItem16.afterContentPadding + i41;
                                            }
                                        }
                                    }
                                    int i911110 = iM792constrainWidthK40F9xA;
                                    lazyGridItemProviderImpl2.intervalContent.getClass();
                                    i37 = i24;
                                    int i106 = iM791constrainHeightK40F9xA;
                                    listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i23, i37, arrayList6, IntListKt.EmptyIntList, i9121, i911110, i106, z14, new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$7, (byte) 24));
                                    if (i37 == i36 - 1) {
                                        z11 = true;
                                    } else {
                                        z11 = true;
                                    }
                                    MeasureResult measureResultLayout7 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i911110 + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(i106 + iMo75roundToPx0680j_7, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState3, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 1));
                                    List listUpdatedVisibleItems7 = LazyLayoutKt.updatedVisibleItems(i23, i37, arrayList6, listApplyStickyItems);
                                    if (z14) {
                                        orientation = orientation3;
                                    } else {
                                        orientation = orientation2;
                                    }
                                    size6 = listApplyStickyItems.size();
                                    i39 = 0;
                                    while (i38 < size6) {
                                        i39 += ((LazyGridMeasuredItem) listApplyStickyItems.get(i38)).mainAxisSize;
                                    }
                                    lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                    lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyGridMeasureResult = new LazyGridMeasureResult(lazyGridMeasuredLine4, i21, z11, f10, measureResultLayout7, f6, z16, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda5, scrollState$$ExternalSyntheticLambda0, i39, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, listUpdatedVisibleItems7, i59, i65, i36, orientation, i55, iMo75roundToPx0680j_8);
                                } else {
                                    i36 = itemCount;
                                    lazyGridMeasuredLine4 = lazyGridMeasuredLine3;
                                }
                                i36 = itemCount;
                                iM791constrainHeightK40F9xA = i29;
                                int i911111 = iM792constrainWidthK40F9xA;
                                lazyGridItemProviderImpl2.intervalContent.getClass();
                                i37 = i24;
                                int i107 = iM791constrainHeightK40F9xA;
                                listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i23, i37, arrayList6, IntListKt.EmptyIntList, i9121, i911111, i107, z14, new BackHandlerKt$$ExternalSyntheticLambda2(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$7, (byte) 24));
                                if (i37 == i36 - 1) {
                                    z11 = true;
                                } else {
                                    z11 = true;
                                }
                                MeasureResult measureResultLayout8 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i911111 + i52, j), ConstraintsKt.m791constrainHeightK40F9xA(i107 + iMo75roundToPx0680j_7, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState3, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 1));
                                List listUpdatedVisibleItems8 = LazyLayoutKt.updatedVisibleItems(i23, i37, arrayList6, listApplyStickyItems);
                                if (z14) {
                                    orientation = orientation3;
                                } else {
                                    orientation = orientation2;
                                }
                                size6 = listApplyStickyItems.size();
                                i39 = 0;
                                while (i38 < size6) {
                                    i39 += ((LazyGridMeasuredItem) listApplyStickyItems.get(i38)).mainAxisSize;
                                }
                                lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                lazyGridKt$rememberLazyGridMeasurePolicy$1$1 = this;
                                subcomposeMeasureScope = subcomposeMeasureScope2;
                                lazyGridMeasureResult = new LazyGridMeasureResult(lazyGridMeasuredLine4, i21, z11, f10, measureResultLayout8, f6, z16, coroutineScope2, lazyLayoutMeasureScopeImpl, length4, backHandlerKt$$ExternalSyntheticLambda5, scrollState$$ExternalSyntheticLambda0, i39, lazyLayoutPrefetchState2, lazyGridCacheWindowPrefetchStrategy3, listUpdatedVisibleItems8, i59, i65, i36, orientation, i55, iMo75roundToPx0680j_8);
                            }
                            lazyGridState3.applyMeasureResult$foundation(lazyGridMeasureResult, subcomposeMeasureScope.isLookingAhead(), false);
                            LazyGridCacheWindowPrefetchStrategy lazyGridCacheWindowPrefetchStrategy4 = lazyGridCacheWindowPrefetchStrategy2;
                            LazyGridCacheWindowPrefetchStrategy lazyGridCacheWindowPrefetchStrategy5 = lazyGridCacheWindowPrefetchStrategy4 instanceof CacheWindowLogic ? lazyGridCacheWindowPrefetchStrategy4 : null;
                            if (lazyGridCacheWindowPrefetchStrategy5 == null) {
                                return lazyGridMeasureResult;
                            }
                            List list5 = lazyGridMeasureResult.visibleItemsInfo;
                            Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
                            try {
                                if (lazyGridCacheWindowPrefetchStrategy5.hasValidBounds() && !list5.isEmpty()) {
                                    LazyGridMeasuredItem lazyGridMeasuredItem17 = (LazyGridMeasuredItem) CollectionsKt.first(list5);
                                    Orientation orientation4 = lazyGridMeasureResult.orientation;
                                    int i108 = orientation4 == orientation3 ? lazyGridMeasuredItem17.row : lazyGridMeasuredItem17.column;
                                    LazyGridMeasuredItem lazyGridMeasuredItem18 = (LazyGridMeasuredItem) CollectionsKt.last(list5);
                                    int i109 = orientation4 == orientation3 ? lazyGridMeasuredItem18.row : lazyGridMeasuredItem18.column;
                                    int i110 = lazyGridCacheWindowPrefetchStrategy5.getPerLaneCacheWindowStartIndex()[0];
                                    while (i110 < i108) {
                                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$3 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$3.getAndMeasure(i110);
                                        i110++;
                                        lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$3;
                                    }
                                    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$4 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$2;
                                    int i111 = i109 + 1;
                                    int i112 = lazyGridCacheWindowPrefetchStrategy5.getPerLaneCacheWindowEndItemIndex()[0];
                                    if (i111 <= i112) {
                                        while (true) {
                                            lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$4.getAndMeasure(i111);
                                            if (i111 == i112) {
                                                break;
                                            }
                                            i111++;
                                        }
                                    }
                                }
                                return lazyGridMeasureResult;
                            } finally {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                z3 = z;
                kProperty0 = kProperty1;
                gapComposer2.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue6;
                z3 = z;
                gapComposer2 = gapComposer3;
                i5 = 32;
                lazyGridState2 = lazyGridState;
                kProperty0 = kProperty1;
            }
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy = (LazyLayoutMeasurePolicy) obj;
            boolean z9 = i11 == i5;
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (z9 || objRememberedValue7 == neverEqualPolicy) {
                b = 1;
                objRememberedValue7 = new ThumbnailKt$$ExternalSyntheticLambda3(lazyGridState2, b);
                gapComposer2.updateRememberedValue(objRememberedValue7);
            } else {
                b = 1;
            }
            StickyHeaderBringIntoViewSpec stickyHeaderBringIntoViewSpecRememberLazyLayoutBringIntoViewSpec = LazyLayoutKt.rememberLazyLayoutBringIntoViewSpec((i6 >> 12) & 126, gapComposer2, (Function0) objRememberedValue7, z3);
            Orientation orientation = z3 ? Orientation.Vertical : Orientation.Horizontal;
            if (z2) {
                gapComposer2.startReplaceGroup(-624995557);
                byte b3 = (((i8 ^ 6) <= 4 || !gapComposer2.changed(lazyGridState2)) && (i7 & 6) != 4) ? (byte) 0 : b;
                Object objRememberedValue8 = gapComposer2.rememberedValue();
                if (b3 != 0 || objRememberedValue8 == neverEqualPolicy) {
                    objRememberedValue8 = new LazyGridBeyondBoundsState(lazyGridState2);
                    gapComposer2.updateRememberedValue(objRememberedValue8);
                }
                modifierLazyLayoutBeyondBoundsModifier = LazyLayoutKt.lazyLayoutBeyondBoundsModifier((LazyGridBeyondBoundsState) objRememberedValue8, lazyGridState2.beyondBoundsInfo, orientation);
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-624699352);
                gapComposer2.end(false);
                modifierLazyLayoutBeyondBoundsModifier = Modifier.Companion.$$INSTANCE;
            }
            modifier2 = modifier;
            gapComposer = gapComposer2;
            LazyLayoutKt.LazyLayout(kProperty0, ImageKt.scrollableArea(LazyLayoutKt.lazyLayoutItemAnimator(LazyLayoutKt.lazyLayoutSemantics(modifier2.then(lazyGridState2.remeasurementModifier).then(lazyGridState2.awaitLayoutModifier), kProperty0, lazySemanticsKt$rememberLazyGridSemanticState$1$1, orientation, z2).then(modifierLazyLayoutBeyondBoundsModifier), lazyGridState2.itemAnimator), lazyGridState2, orientation, androidEdgeEffectOverscrollEffect, z2, flingBehavior, lazyGridState2.internalInteractionSource, stickyHeaderBringIntoViewSpecRememberLazyLayoutBringIntoViewSpec), lazyLayoutPrefetchState, lazyLayoutMeasurePolicy, gapComposer, 0);
        } else {
            modifier2 = modifier;
            z3 = z;
            gapComposer = gapComposer3;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z10 = z3;
            final Modifier modifier3 = modifier2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    UtilsKt.LazyGrid(modifier3, lazyGridState, gridSlotCache, paddingValues, z10, flingBehavior, z2, androidEdgeEffectOverscrollEffect, arrangement$Vertical, arrangement$Horizontal, lazyLayoutCacheWindow, function1, (Composer) obj2, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: addPointerInputChange-0AR0LA0, reason: not valid java name */
    public static final void m891addPointerInputChange0AR0LA0(VelocityTracker velocityTracker, PointerInputChange pointerInputChange, long j) {
        RealStrongMemoryCache realStrongMemoryCache = velocityTracker.platformVelocityTracker;
        VelocityTracker1D velocityTracker1D = (VelocityTracker1D) realStrongMemoryCache.cache;
        VelocityTracker1D velocityTracker1D2 = (VelocityTracker1D) realStrongMemoryCache.weakMemoryCache;
        boolean zChangedToDownIgnoreConsumed = PointerIconKt.changedToDownIgnoreConsumed(pointerInputChange);
        long j2 = pointerInputChange.uptimeMillis;
        if (zChangedToDownIgnoreConsumed) {
            DataPointAtTime[] dataPointAtTimeArr = velocityTracker1D2.samples;
            ArraysKt.fill(0, dataPointAtTimeArr.length, null, dataPointAtTimeArr);
            velocityTracker1D2.index = 0;
            DataPointAtTime[] dataPointAtTimeArr2 = velocityTracker1D.samples;
            ArraysKt.fill(0, dataPointAtTimeArr2.length, null, dataPointAtTimeArr2);
            velocityTracker1D.index = 0;
            realStrongMemoryCache.initialMaxSize = 0L;
        }
        if (!PointerIconKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            List historical = pointerInputChange.getHistorical();
            int i = 0;
            for (int size = historical.size(); i < size; size = size) {
                HistoricalChange historicalChange = (HistoricalChange) historical.get(i);
                realStrongMemoryCache.m857addPositionUv8p0NA(historicalChange.uptimeMillis, Offset.m439plusMKHz9U(historicalChange.originalEventPosition, j));
                i++;
            }
            realStrongMemoryCache.m857addPositionUv8p0NA(j2, Offset.m439plusMKHz9U(pointerInputChange.originalEventPosition, j));
        }
        if (PointerIconKt.changedToUpIgnoreConsumed(pointerInputChange) && j2 - realStrongMemoryCache.initialMaxSize > 40) {
            DataPointAtTime[] dataPointAtTimeArr3 = velocityTracker1D2.samples;
            ArraysKt.fill(0, dataPointAtTimeArr3.length, null, dataPointAtTimeArr3);
            velocityTracker1D2.index = 0;
            DataPointAtTime[] dataPointAtTimeArr4 = velocityTracker1D.samples;
            ArraysKt.fill(0, dataPointAtTimeArr4.length, null, dataPointAtTimeArr4);
            velocityTracker1D.index = 0;
            realStrongMemoryCache.initialMaxSize = 0L;
        }
        realStrongMemoryCache.initialMaxSize = j2;
    }

    public static final Selection adjustToBoundaries(MediaSessionImpl$1 mediaSessionImpl$1, SelectionAdjustment$Companion selectionAdjustment$Companion) {
        CrossStatus crossStatus = mediaSessionImpl$1.getCrossStatus();
        GapBuffer gapBuffer = (GapBuffer) mediaSessionImpl$1.this$0;
        boolean z = crossStatus == CrossStatus.CROSSED;
        return new Selection(anchorOnBoundary(gapBuffer, z, true, selectionAdjustment$Companion), anchorOnBoundary(gapBuffer, z, false, selectionAdjustment$Companion), z);
    }

    public static final Selection.AnchorInfo anchorOnBoundary(GapBuffer gapBuffer, boolean z, boolean z2, SelectionAdjustment$Companion selectionAdjustment$Companion) {
        long jTextRange;
        long j;
        int i = z2 ? gapBuffer.capacity : gapBuffer.gapStart;
        switch (selectionAdjustment$Companion.$r8$classId) {
            case 1:
                String str = ((TextLayoutResult) gapBuffer.buffer).layoutInput.text.text;
                jTextRange = TextRangeKt.TextRange(BasicTextKt.findParagraphStart(str, i), BasicTextKt.findParagraphEnd(str, i));
                break;
            default:
                jTextRange = ((TextLayoutResult) gapBuffer.buffer).m736getWordBoundaryjx7JFs(i);
                break;
        }
        if (z ^ z2) {
            int i2 = TextRange.$r8$clinit;
            j = jTextRange >> 32;
        } else {
            int i3 = TextRange.$r8$clinit;
            j = 4294967295L & jTextRange;
        }
        return gapBuffer.anchorForOffset((int) j);
    }

    public static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return SQLite.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return SQLite.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i2, "negative size: "));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.runtime.tooling.ReaderTraceBuilder, androidx.media3.extractor.flv.TagPayloadReader] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [androidx.compose.runtime.composer.gapbuffer.GapAnchor] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Integer] */
    public static final List buildTrace(SlotWriter slotWriter, Integer num, int i, Integer num2) {
        int iParent;
        int iGroupKey;
        MutableObjectList mutableObjectList;
        if (slotWriter.closed || slotWriter.getSize$runtime() == 0) {
            return EmptyList.INSTANCE;
        }
        ?? readerTraceBuilder = new ReaderTraceBuilder((byte) 1, slotWriter);
        if (num2 != null) {
            iParent = num2.intValue();
        } else {
            iParent = slotWriter.parent;
            if (iParent < 0) {
                iParent = slotWriter.parent(i, slotWriter.groups);
            }
        }
        if (num == 0) {
            int iSlotIndex = slotWriter.currentSlot - slotWriter.slotIndex(slotWriter.groupIndexToAddress(i), slotWriter.groups);
            MutableIntObjectMap mutableIntObjectMap = slotWriter.deferredSlotWrites;
            num = Integer.valueOf(iSlotIndex + ((mutableIntObjectMap == null || (mutableObjectList = (MutableObjectList) mutableIntObjectMap.get(i)) == null) ? 0 : mutableObjectList._size));
        }
        int iGroupIndexToAddress = slotWriter.groupIndexToAddress(i) * 5;
        int[] iArr = slotWriter.groups;
        if (iGroupIndexToAddress < iArr.length) {
            iGroupKey = slotWriter.groupKey(i);
        } else {
            int iParent2 = iParent >= 0 ? slotWriter.parent(iParent, iArr) : iParent;
            iGroupKey = slotWriter.groupKey(iParent);
            int i2 = iParent;
            iParent = iParent2;
            i = i2;
        }
        while (i >= 0) {
            readerTraceBuilder.processEdge(iGroupKey, (slotWriter.groups[(slotWriter.groupIndexToAddress(i) * 5) + 1] & 536870912) != 0 ? slotWriter.groupObjectKey(i) : Composer.Companion.Empty, slotWriter.sourceInformationOf$runtime(i), num);
            num = slotWriter.anchor(i);
            if (iParent >= 0) {
                int iParent3 = slotWriter.parent(iParent, slotWriter.groups);
                iGroupKey = slotWriter.groupKey(iParent);
                int i3 = iParent;
                iParent = iParent3;
                i = i3;
            } else {
                i = iParent;
            }
        }
        return (ArrayList) readerTraceBuilder.output;
    }

    public static final Bundle bundleOf(Pair... pairArr) {
        Bundle bundle = new Bundle(pairArr.length);
        for (Pair pair : pairArr) {
            String str = (String) pair.first;
            Object obj = pair.second;
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else if (obj instanceof Object[]) {
                Class<?> componentType = obj.getClass().getComponentType();
                componentType.getClass();
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(str, (Parcelable[]) obj);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(str, (String[]) obj);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(str, (CharSequence[]) obj);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Illegal value array type ", componentType.getCanonicalName(), " for key \"", str, 34);
                        return null;
                    }
                    bundle.putSerializable(str, (Serializable) obj);
                }
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof IBinder) {
                bundle.putBinder(str, (IBinder) obj);
            } else if (obj instanceof Size) {
                bundle.putSize(str, (Size) obj);
            } else {
                if (!(obj instanceof SizeF)) {
                    DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Illegal value type ", obj.getClass().getCanonicalName(), " for key \"", str, 34);
                    return null;
                }
                bundle.putSizeF(str, (SizeF) obj);
            }
        }
        return bundle;
    }

    public static final Selection.AnchorInfo changeOffset(Selection.AnchorInfo anchorInfo, GapBuffer gapBuffer, int i) {
        return new Selection.AnchorInfo(((TextLayoutResult) gapBuffer.buffer).getBidiRunDirection(i), i, anchorInfo.selectableId);
    }

    public static void checkArgument(String str, int i, int i2, boolean z) {
        if (z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(SQLite.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static void checkElementIndex(int i, int i2) {
        String strLenientFormat;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strLenientFormat = SQLite.lenientFormat("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i2, "negative size: "));
                    return;
                }
                strLenientFormat = SQLite.lenientFormat("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strLenientFormat);
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m(str);
    }

    public static void checkPositionIndex(int i, int i2) {
        if (i < 0 || i > i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(badPositionIndex(i, i2, "index"));
        }
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        String strBadPositionIndex;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strBadPositionIndex = badPositionIndex(i, i3, "start index");
            } else {
                strBadPositionIndex = (i2 < 0 || i2 > i3) ? badPositionIndex(i2, i3, "end index") : SQLite.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strBadPositionIndex);
        }
    }

    public static void checkState(boolean z) {
        if (z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m();
    }

    public static final Object compatTransactionCoroutineExecute(RoomDatabase roomDatabase, Continuation continuation, Function1 function1) {
        if (roomDatabase.inCompatibilityMode() && roomDatabase.isOpenInternal$room_runtime() && roomDatabase.inTransaction()) {
            return function1.invoke(continuation);
        }
        return continuation.getContext().get(RoomExternalOperationElement.INSTANCE) == null ? function1.invoke(continuation) : withTransactionContext(roomDatabase, continuation, function1);
    }

    public static Intent createMediaButtonIntentInternal(Context context, int i, Bundle bundle, String str, Class cls) {
        checkArgument(isSupportedKeyCode(i));
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setData(MediaLibrarySessionImpl.createSessionUri(str));
        intent.setComponent(new ComponentName(context, (Class<?>) cls));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i));
        return intent;
    }

    public static final long currentAbsoluteScrollOffset(PagerState pagerState) {
        return MathKt.roundToLong(pagerState.getCurrentPageOffsetFraction() * pagerState.getPageSizeWithSpacing$foundation()) + (((long) pagerState.getCurrentPage()) * ((long) pagerState.getPageSizeWithSpacing$foundation()));
    }

    public static final float dot(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        for (int i = 0; i < length; i++) {
            f += fArr[i] * fArr2[i];
        }
        return f;
    }

    public static final float dragGestureDelta(PagerState pagerState) {
        return pagerState.getLayoutInfo().orientation == Orientation.Horizontal ? Float.intBitsToFloat((int) (pagerState.m180getUpDownDifferenceF1C5BW0$foundation() >> 32)) : Float.intBitsToFloat((int) (pagerState.m180getUpDownDifferenceF1C5BW0$foundation() & 4294967295L));
    }

    public static final Integer findSubcompositionContextGroup$lambda$0$scanGroup(SlotReader slotReader, CompositionContext compositionContext, int i, int i2) {
        Integer numFindSubcompositionContextGroup$lambda$0$scanGroup;
        int[] iArr = slotReader.groups;
        while (true) {
            if (i >= i2) {
                return null;
            }
            int i3 = iArr[(i * 5) + 3] + i;
            if (slotReader.hasMark(i) && slotReader.groupKey(i) == 206 && Intrinsics.areEqual(slotReader.objectKey(i, iArr), ComposerKt.reference)) {
                Object objGroupGet = slotReader.groupGet(i, 0);
                RememberObserverHolder rememberObserverHolder = objGroupGet instanceof RememberObserverHolder ? (RememberObserverHolder) objGroupGet : null;
                RememberObserver wrapped = rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null;
                GapComposer.CompositionContextHolder compositionContextHolder = wrapped instanceof GapComposer.CompositionContextHolder ? (GapComposer.CompositionContextHolder) wrapped : null;
                if (compositionContextHolder != null && compositionContextHolder.ref == compositionContext) {
                    return Integer.valueOf(i);
                }
            }
            if (slotReader.containsMark(i) && (numFindSubcompositionContextGroup$lambda$0$scanGroup = findSubcompositionContextGroup$lambda$0$scanGroup(slotReader, compositionContext, i + 1, i3)) != null) {
                return Integer.valueOf(numFindSubcompositionContextGroup$lambda$0$scanGroup.intValue());
            }
            i = i3;
        }
    }

    public static final SavedStateRegistryOwner get(View view) {
        view.getClass();
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_saved_state_registry_owner);
            SavedStateRegistryOwner savedStateRegistryOwner = tag instanceof SavedStateRegistryOwner ? (SavedStateRegistryOwner) tag : null;
            if (savedStateRegistryOwner != null) {
                return savedStateRegistryOwner;
            }
            Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return null;
    }

    public static String getNameForNavigator$navigation_common_release(Class cls) {
        LinkedHashMap linkedHashMap = NavigatorProvider.annotationNames;
        String strValue = (String) linkedHashMap.get(cls);
        if (strValue == null) {
            Navigator.Name name = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
            strValue = name != null ? name.value() : null;
            if (strValue == null || strValue.length() <= 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) "No @Navigator.Name annotation found for ".concat(cls.getSimpleName()));
                return null;
            }
            linkedHashMap.put(cls, strValue);
        }
        strValue.getClass();
        return strValue;
    }

    public static final long getPositionInRoot(DrawResult drawResult) {
        DragEvent dragEvent = (DragEvent) drawResult.block;
        float x = dragEvent.getX();
        float y = dragEvent.getY();
        return (((long) Float.floatToRawIntBits(x)) << 32) | (((long) Float.floatToRawIntBits(y)) & 4294967295L);
    }

    public static boolean isNotTrailingByte(byte b) {
        return b > -65;
    }

    public static boolean isPunctuation$ui_text(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    public static final boolean isScrollingForward(PagerState pagerState, float f) {
        pagerState.getLayoutInfo().getClass();
        return !(((pagerState.isNotGestureAction$foundation() ? -f : dragGestureDelta(pagerState)) > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : ((pagerState.isNotGestureAction$foundation() ? -f : dragGestureDelta(pagerState)) == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : -1)) > 0);
    }

    public static boolean isSupportedKeyCode(int i) {
        return i == 87 || i == 88 || i == 86 || i == 90 || i == 89 || i == 85;
    }

    public static final Keyline lerp(Keyline keyline, Keyline keyline2, float f) {
        return new Keyline(LifecyclesKt.lerp(keyline.size, keyline2.size, f), LifecyclesKt.lerp(keyline.offset, keyline2.offset, f), LifecyclesKt.lerp(keyline.unadjustedOffset, keyline2.unadjustedOffset, f), f < 0.5f ? keyline.isFocal : keyline2.isFocal, f < 0.5f ? keyline.isAnchor : keyline2.isAnchor, (f < 0.5f ? keyline : keyline2).isPivot, LifecyclesKt.lerp(keyline.cutoff, keyline2.cutoff, f));
    }

    public static List moveGroup(SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3) {
        List list;
        boolean z4;
        int iGroupSize = slotWriter.groupSize(i);
        int i2 = i + iGroupSize;
        int iDataIndex = slotWriter.dataIndex(slotWriter.groupIndexToAddress(i), slotWriter.groups);
        int iDataIndex2 = slotWriter.dataIndex(slotWriter.groupIndexToAddress(i2), slotWriter.groups);
        int i3 = iDataIndex2 - iDataIndex;
        boolean z5 = i >= 0 && (slotWriter.groups[(slotWriter.groupIndexToAddress(i) * 5) + 1] & 201326592) != 0;
        slotWriter2.insertGroups(iGroupSize);
        slotWriter2.insertSlots(i3, slotWriter2.currentGroup);
        if (slotWriter.groupGapStart < i2) {
            slotWriter.moveGroupGapTo(i2);
        }
        if (slotWriter.slotsGapStart < iDataIndex2) {
            slotWriter.moveSlotGapTo(iDataIndex2, i2);
        }
        int[] iArr = slotWriter2.groups;
        int i4 = slotWriter2.currentGroup;
        int i5 = i4 * 5;
        ArraysKt.copyInto(i5, i * 5, i2 * 5, slotWriter.groups, iArr);
        Object[] objArr = slotWriter2.slots;
        int i6 = slotWriter2.currentSlot;
        System.arraycopy(slotWriter.slots, iDataIndex, objArr, i6, i3);
        int i7 = slotWriter2.parent;
        iArr[i5 + 2] = i7;
        int i8 = i4 - i;
        int i9 = i4 + iGroupSize;
        int iDataIndex3 = i6 - slotWriter2.dataIndex(i4, iArr);
        int i10 = slotWriter2.slotsGapOwner;
        int i11 = slotWriter2.slotsGapLen;
        int length = objArr.length;
        boolean z6 = z5;
        int i12 = i10;
        int i13 = i4;
        while (i13 < i9) {
            if (i13 != i4) {
                int i14 = (i13 * 5) + 2;
                iArr[i14] = iArr[i14] + i8;
            }
            int[] iArr2 = iArr;
            iArr2[(i13 * 5) + 4] = SlotWriter.dataIndexToDataAnchor(slotWriter2.dataIndex(i13, iArr) + iDataIndex3, i12 < i13 ? 0 : slotWriter2.slotsGapStart, i11, length);
            if (i13 == i12) {
                i12++;
            }
            i13++;
            i4 = i4;
            iArr = iArr2;
        }
        int[] iArr3 = iArr;
        slotWriter2.slotsGapOwner = i12;
        int iLocationOf = SlotTableKt.locationOf(slotWriter.anchors, i, slotWriter.getSize$runtime());
        int iLocationOf2 = SlotTableKt.locationOf(slotWriter.anchors, i2, slotWriter.getSize$runtime());
        if (iLocationOf < iLocationOf2) {
            ArrayList arrayList = slotWriter.anchors;
            ArrayList arrayList2 = new ArrayList(iLocationOf2 - iLocationOf);
            for (int i15 = iLocationOf; i15 < iLocationOf2; i15++) {
                GapAnchor gapAnchor = (GapAnchor) arrayList.get(i15);
                gapAnchor.location += i8;
                arrayList2.add(gapAnchor);
            }
            slotWriter2.anchors.addAll(SlotTableKt.locationOf(slotWriter2.anchors, slotWriter2.currentGroup, slotWriter2.getSize$runtime()), arrayList2);
            arrayList.subList(iLocationOf, iLocationOf2).clear();
            list = arrayList2;
        } else {
            list = EmptyList.INSTANCE;
        }
        if (!list.isEmpty()) {
            HashMap map = slotWriter.sourceInformationMap;
            HashMap map2 = slotWriter2.sourceInformationMap;
            if (map != null && map2 != null) {
                int size = list.size();
                for (int i16 = 0; i16 < size; i16++) {
                }
            }
        }
        int i17 = slotWriter2.parent;
        slotWriter2.sourceInformationOf$runtime(i7);
        int iParent = slotWriter.parent(i, slotWriter.groups);
        if (!z3) {
            z4 = false;
        } else if (z) {
            boolean z7 = iParent >= 0;
            if (z7) {
                slotWriter.startGroup();
                slotWriter.advanceBy(iParent - slotWriter.currentGroup);
                slotWriter.startGroup();
            }
            slotWriter.advanceBy(i - slotWriter.currentGroup);
            boolean zRemoveGroup = slotWriter.removeGroup();
            if (z7) {
                slotWriter.skipToGroupEnd();
                slotWriter.endGroup();
                slotWriter.skipToGroupEnd();
                slotWriter.endGroup();
            }
            z4 = zRemoveGroup;
        } else {
            boolean zRemoveGroups = slotWriter.removeGroups(i, iGroupSize);
            slotWriter.removeSlots(iDataIndex, i3, i - 1);
            z4 = zRemoveGroups;
        }
        if (z4) {
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        int i18 = slotWriter2.nodeCount;
        int i19 = iArr3[i5 + 1];
        slotWriter2.nodeCount = i18 + ((1073741824 & i19) != 0 ? 1 : i19 & 67108863);
        if (z2) {
            slotWriter2.currentGroup = i9;
            slotWriter2.currentSlot = i6 + i3;
        }
        if (z6) {
            slotWriter2.updateContainsMark(i7);
        }
        return list;
    }

    public static final void polyFitLeastSquares(float[] fArr, float[] fArr2, int i, float[] fArr3) {
        if (i == 0) {
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalArgumentException("At least one point must be provided");
        }
        int i2 = 2 >= i ? i - 1 : 2;
        int i3 = i2 + 1;
        float[][] fArr4 = new float[i3][];
        for (int i4 = 0; i4 < i3; i4++) {
            fArr4[i4] = new float[i];
        }
        for (int i5 = 0; i5 < i; i5++) {
            fArr4[0][i5] = 1.0f;
            for (int i6 = 1; i6 < i3; i6++) {
                fArr4[i6][i5] = fArr4[i6 - 1][i5] * fArr[i5];
            }
        }
        float[][] fArr5 = new float[i3][];
        for (int i7 = 0; i7 < i3; i7++) {
            fArr5[i7] = new float[i];
        }
        float[][] fArr6 = new float[i3][];
        for (int i8 = 0; i8 < i3; i8++) {
            fArr6[i8] = new float[i3];
        }
        int i9 = 0;
        while (i9 < i3) {
            float[] fArr7 = fArr5[i9];
            float[] fArr8 = fArr4[i9];
            fArr8.getClass();
            fArr7.getClass();
            System.arraycopy(fArr8, 0, fArr7, 0, i);
            for (int i10 = 0; i10 < i9; i10++) {
                float[] fArr9 = fArr5[i10];
                float fDot = dot(fArr7, fArr9);
                for (int i11 = 0; i11 < i; i11++) {
                    fArr7[i11] = fArr7[i11] - (fArr9[i11] * fDot);
                }
            }
            float fSqrt = (float) Math.sqrt(dot(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f = 1.0f / fSqrt;
            for (int i12 = 0; i12 < i; i12++) {
                fArr7[i12] = fArr7[i12] * f;
            }
            float[] fArr10 = fArr6[i9];
            int i13 = 0;
            while (i13 < i3) {
                fArr10[i13] = i13 < i9 ? CropImageView.DEFAULT_ASPECT_RATIO : dot(fArr7, fArr4[i13]);
                i13++;
            }
            i9++;
        }
        for (int i14 = i2; -1 < i14; i14--) {
            float fDot2 = dot(fArr5[i14], fArr2);
            float[] fArr11 = fArr6[i14];
            int i15 = i14 + 1;
            if (i15 <= i2) {
                int i16 = i2;
                while (true) {
                    fDot2 -= fArr11[i16] * fArr3[i16];
                    if (i16 != i15) {
                        i16--;
                    }
                }
            }
            fArr3[i14] = fDot2 / fArr11[i14];
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readBuffer(SourceResponseBody sourceResponseBody, ContinuationImpl continuationImpl) {
        UtilsKt$readBuffer$1 utilsKt$readBuffer$1;
        SourceResponseBody sourceResponseBody2;
        Throwable th;
        Buffer buffer;
        if (continuationImpl instanceof UtilsKt$readBuffer$1) {
            utilsKt$readBuffer$1 = (UtilsKt$readBuffer$1) continuationImpl;
            int i = utilsKt$readBuffer$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                utilsKt$readBuffer$1.label = i - Integer.MIN_VALUE;
            } else {
                utilsKt$readBuffer$1 = new UtilsKt$readBuffer$1(continuationImpl);
            }
        } else {
            utilsKt$readBuffer$1 = new UtilsKt$readBuffer$1(continuationImpl);
        }
        Object obj = utilsKt$readBuffer$1.result;
        int i2 = utilsKt$readBuffer$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            buffer = utilsKt$readBuffer$1.L$3;
            sourceResponseBody2 = utilsKt$readBuffer$1.L$1;
            try {
                ResultKt.throwOnFailure(obj);
                StringsKt__IndentKt.closeFinally(sourceResponseBody2, null);
                return buffer;
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    StringsKt__IndentKt.closeFinally(sourceResponseBody2, th);
                    throw th3;
                }
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            Buffer buffer2 = new Buffer();
            utilsKt$readBuffer$1.L$1 = sourceResponseBody;
            utilsKt$readBuffer$1.L$3 = buffer2;
            utilsKt$readBuffer$1.label = 1;
            sourceResponseBody.source.readAll(buffer2);
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (unit == coroutineSingletons) {
                return coroutineSingletons;
            }
            sourceResponseBody2 = sourceResponseBody;
            buffer = buffer2;
            StringsKt__IndentKt.closeFinally(sourceResponseBody2, null);
            return buffer;
        } catch (Throwable th4) {
            sourceResponseBody2 = sourceResponseBody;
            th = th4;
            throw th;
        }
    }

    public static final List readForeignKeyFieldMappings(SQLiteStatement sQLiteStatement) {
        int iColumnIndexOf = LifecyclesKt.columnIndexOf(sQLiteStatement, "id");
        int iColumnIndexOf2 = LifecyclesKt.columnIndexOf(sQLiteStatement, "seq");
        int iColumnIndexOf3 = LifecyclesKt.columnIndexOf(sQLiteStatement, "from");
        int iColumnIndexOf4 = LifecyclesKt.columnIndexOf(sQLiteStatement, "to");
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        while (sQLiteStatement.step()) {
            listBuilderCreateListBuilder.add(new ForeignKeyWithSequence((int) sQLiteStatement.getLong(iColumnIndexOf), (int) sQLiteStatement.getLong(iColumnIndexOf2), sQLiteStatement.getText(iColumnIndexOf3), sQLiteStatement.getText(iColumnIndexOf4)));
        }
        return CollectionsKt.sorted(CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder));
    }

    public static final TableInfo.Index readIndex(SQLiteConnection sQLiteConnection, String str, boolean z) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int iColumnIndexOf = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "seqno");
            int iColumnIndexOf2 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "cid");
            int iColumnIndexOf3 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int iColumnIndexOf4 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "desc");
            if (iColumnIndexOf != -1 && iColumnIndexOf2 != -1 && iColumnIndexOf3 != -1 && iColumnIndexOf4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (sQLiteStatementPrepare.step()) {
                    if (((int) sQLiteStatementPrepare.getLong(iColumnIndexOf2)) >= 0) {
                        int i = (int) sQLiteStatementPrepare.getLong(iColumnIndexOf);
                        String text = sQLiteStatementPrepare.getText(iColumnIndexOf3);
                        String str2 = sQLiteStatementPrepare.getLong(iColumnIndexOf4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i), text);
                        linkedHashMap2.put(Integer.valueOf(i), str2);
                    }
                }
                List listSortedWith = CollectionsKt.sortedWith(linkedHashMap.entrySet(), new ColorCutQuantizer.AnonymousClass1((byte) 1));
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSortedWith, 10));
                Iterator it = listSortedWith.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List list = CollectionsKt.toList(arrayList);
                List listSortedWith2 = CollectionsKt.sortedWith(linkedHashMap2.entrySet(), new ColorCutQuantizer.AnonymousClass1((byte) 2));
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSortedWith2, 10));
                Iterator it2 = listSortedWith2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                TableInfo.Index index = new TableInfo.Index(str, z, list, CollectionsKt.toList(arrayList2));
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                return index;
            }
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public static final Object runBlockingUninterruptible(Function2 function2) {
        Thread.interrupted();
        return AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new DownloadUtil.AnonymousClass2((Object) function2, (Continuation) null, (byte) 6));
    }

    public static boolean sniff(DefaultExtractorInput defaultExtractorInput, boolean z) {
        int i;
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        boolean z2 = true;
        while (true) {
            parsableByteArray.reset(8);
            if (!defaultExtractorInput.peekFully(parsableByteArray.data, 0, 8, true)) {
                break;
            }
            long unsignedInt = parsableByteArray.readUnsignedInt();
            int i2 = parsableByteArray.readInt();
            if (unsignedInt != 1) {
                i = 8;
            } else {
                if (!defaultExtractorInput.peekFully(parsableByteArray.data, 8, 8, true)) {
                    break;
                }
                unsignedInt = parsableByteArray.readUnsignedLongToLong();
                i = 16;
            }
            long j = i;
            if (unsignedInt < j) {
                break;
            }
            int i3 = (int) (unsignedInt - j);
            if (z2) {
                if (i2 != 1718909296 || i3 < 8) {
                    break;
                }
                parsableByteArray.reset(4);
                defaultExtractorInput.peekFully(parsableByteArray.data, 0, 4, false);
                if (parsableByteArray.readInt() != 1751476579) {
                    break;
                }
                if (!z) {
                    return true;
                }
                defaultExtractorInput.advancePeekPosition(i3 - 4, false);
                z2 = false;
            } else {
                if (i2 == 1836086884) {
                    return true;
                }
                if (i3 != 0) {
                    defaultExtractorInput.advancePeekPosition(i3, false);
                }
            }
        }
        return false;
    }

    public static int toActivityTransitResId(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static final ExtractedText toExtractedText(TextFieldValue textFieldValue) {
        ExtractedText extractedText = new ExtractedText();
        String str = textFieldValue.annotatedString.text;
        extractedText.text = str;
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = str.length();
        extractedText.partialStartOffset = -1;
        long j = textFieldValue.selection;
        extractedText.selectionStart = TextRange.m744getMinimpl(j);
        extractedText.selectionEnd = TextRange.m743getMaximpl(j);
        extractedText.flags = !StringsKt.contains$default(textFieldValue.annotatedString.text, '\n') ? 1 : 0;
        return extractedText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.runtime.tooling.ReaderTraceBuilder, androidx.media3.extractor.flv.TagPayloadReader] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public static final ArrayList traceForGroup(SlotReader slotReader, int i, Integer num) {
        ?? readerTraceBuilder = new ReaderTraceBuilder((byte) 0, slotReader);
        i = slotReader.parent(i);
        GapAnchor gapAnchorAnchor = slotReader.anchor(i);
        while (i >= 0) {
            readerTraceBuilder.processEdge(slotReader.groupKey(i), slotReader.hasObjectKey(i) ? slotReader.objectKey(i, slotReader.groups) : Composer.Companion.Empty, slotReader.table.sourceInformationOf(i), num);
            if (i >= 0) {
                GapAnchor gapAnchor = gapAnchorAnchor;
                gapAnchorAnchor = slotReader.anchor(i);
                i = slotReader.parent(i);
                num = gapAnchor;
            } else {
                num = gapAnchorAnchor;
            }
        }
        return (ArrayList) readerTraceBuilder.output;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Selection.AnchorInfo updateSelectionBoundary(final MediaSessionImpl$1 mediaSessionImpl$1, final GapBuffer gapBuffer, Selection.AnchorInfo anchorInfo) {
        CrossStatus crossStatus;
        int i = gapBuffer.gapStart;
        int i2 = gapBuffer.capacity;
        boolean z = mediaSessionImpl$1.val$callOnPlayerInteractionFinished;
        final int i3 = z ? i2 : i;
        TextLayoutResult textLayoutResult = (TextLayoutResult) gapBuffer.buffer;
        int i4 = gapBuffer.gapEnd;
        HomeScreenKt$$ExternalSyntheticLambda57 homeScreenKt$$ExternalSyntheticLambda57 = new HomeScreenKt$$ExternalSyntheticLambda57(gapBuffer, i3, (byte) 1);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        final Lazy lazy = ResultKt.lazy(lazyThreadSafetyMode, homeScreenKt$$ExternalSyntheticLambda57);
        final int i5 = z ? i : i2;
        Lazy lazy2 = ResultKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                GapBuffer gapBuffer2 = gapBuffer;
                TextLayoutResult textLayoutResult2 = (TextLayoutResult) gapBuffer2.buffer;
                int iIntValue = ((Number) lazy.getValue()).intValue();
                MediaSessionImpl$1 mediaSessionImpl$2 = mediaSessionImpl$1;
                boolean z2 = mediaSessionImpl$2.val$callOnPlayerInteractionFinished;
                boolean z3 = mediaSessionImpl$2.getCrossStatus() == CrossStatus.CROSSED;
                int i6 = i3;
                long jM736getWordBoundaryjx7JFs = textLayoutResult2.m736getWordBoundaryjx7JFs(i6);
                MultiParagraph multiParagraph = textLayoutResult2.multiParagraph;
                int i7 = TextRange.$r8$clinit;
                int lineStart = (int) (jM736getWordBoundaryjx7JFs >> 32);
                int i8 = multiParagraph.lineCount;
                if (multiParagraph.getLineForOffset(lineStart) != iIntValue) {
                    lineStart = iIntValue >= i8 ? textLayoutResult2.getLineStart(i8 - 1) : textLayoutResult2.getLineStart(iIntValue);
                }
                int lineEnd = (int) (jM736getWordBoundaryjx7JFs & 4294967295L);
                if (multiParagraph.getLineForOffset(lineEnd) != iIntValue) {
                    lineEnd = iIntValue >= i8 ? multiParagraph.getLineEnd(i8 - 1, false) : multiParagraph.getLineEnd(iIntValue, false);
                }
                int i9 = i5;
                if (lineStart == i9) {
                    return gapBuffer2.anchorForOffset(lineEnd);
                }
                if (lineEnd == i9) {
                    return gapBuffer2.anchorForOffset(lineStart);
                }
                if (!(z2 ^ z3) ? i6 >= lineStart : i6 > lineEnd) {
                    lineStart = lineEnd;
                }
                return gapBuffer2.anchorForOffset(lineStart);
            }
        });
        if (1 != anchorInfo.selectableId) {
            return (Selection.AnchorInfo) lazy2.getValue();
        }
        if (i3 == i4) {
            return anchorInfo;
        }
        if (((Number) lazy.getValue()).intValue() != textLayoutResult.multiParagraph.getLineForOffset(i4)) {
            return (Selection.AnchorInfo) lazy2.getValue();
        }
        int i6 = anchorInfo.offset;
        long jM736getWordBoundaryjx7JFs = textLayoutResult.m736getWordBoundaryjx7JFs(i6);
        if (i4 != -1) {
            if (i3 != i4) {
                CrossStatus crossStatus2 = CrossStatus.CROSSED;
                if (i2 < i) {
                    crossStatus = CrossStatus.NOT_CROSSED;
                } else {
                    crossStatus = i2 > i ? crossStatus2 : CrossStatus.COLLAPSED;
                }
                if (((z ? 1 : 0) ^ (crossStatus != crossStatus2 ? (byte) 0 : (byte) 1)) == 0) {
                }
            }
            return gapBuffer.anchorForOffset(i3);
        }
        int i7 = TextRange.$r8$clinit;
        return (i6 == ((int) (jM736getWordBoundaryjx7JFs >> 32)) || i6 == ((int) (jM736getWordBoundaryjx7JFs & 4294967295L))) ? (Selection.AnchorInfo) lazy2.getValue() : gapBuffer.anchorForOffset(i3);
    }

    public static final ViewModel viewModel(ClassReference classReference, ViewModelStoreOwner viewModelStoreOwner, ViewModelProvider$Factory viewModelProvider$Factory, CreationExtras creationExtras, Composer composer) {
        if (viewModelProvider$Factory == null) {
            viewModelProvider$Factory = ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner);
        }
        viewModelProvider$Factory.getClass();
        creationExtras.getClass();
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        viewModelStore.getClass();
        Dispatcher dispatcher = new Dispatcher(viewModelStore, viewModelProvider$Factory, creationExtras);
        String qualifiedName = classReference.getQualifiedName();
        if (qualifiedName != null) {
            return dispatcher.getViewModel$lifecycle_viewmodel(classReference, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName));
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Local and anonymous classes can not be ViewModels");
        return null;
    }

    public static final Object withTransactionContext(RoomDatabase roomDatabase, Continuation continuation, Function1 function1) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(function1, null);
        TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.Key);
        CoroutineDispatcher coroutineDispatcher = transactionElement != null ? transactionElement.transactionDispatcher : null;
        if (coroutineDispatcher != null) {
            return AwaitKt.withContext(coroutineDispatcher, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, continuation);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        try {
            TransactionExecutor transactionExecutor = roomDatabase.internalTransactionExecutor;
            if (transactionExecutor != null) {
                transactionExecutor.execute(new RequestExecutor$ReplyRunnable(cancellableContinuationImpl, roomDatabase, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1));
                return cancellableContinuationImpl.getResult();
            }
            Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
            throw null;
        } catch (RejectedExecutionException e) {
            cancellableContinuationImpl.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
    }

    public boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture.Listener listener, AbstractResolvableFuture.Listener listener2) {
        synchronized (abstractResolvableFuture) {
            try {
                if (abstractResolvableFuture.listeners != listener) {
                    return false;
                }
                abstractResolvableFuture.listeners = listener2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
        synchronized (abstractResolvableFuture) {
            try {
                if (abstractResolvableFuture.value != obj) {
                    return false;
                }
                abstractResolvableFuture.value = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2) {
        synchronized (abstractResolvableFuture) {
            try {
                if (abstractResolvableFuture.waiters != waiter) {
                    return false;
                }
                abstractResolvableFuture.waiters = waiter2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void putNext(AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2) {
        waiter.next = waiter2;
    }

    public void putThread(AbstractResolvableFuture.Waiter waiter, Thread thread) {
        waiter.thread = thread;
    }

    public static void checkNotNull(Object obj) {
        obj.getClass();
    }

    public static void checkState(String str, boolean z) {
        if (z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(str);
    }

    public static void checkArgument(String str, boolean z) {
        if (z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(str);
    }

    public static void checkArgument(String str, int i, boolean z) {
        if (z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(SQLite.lenientFormat(str, Integer.valueOf(i)));
    }

    public static void checkArgument(long j, String str, boolean z) {
        if (z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(SQLite.lenientFormat(str, Long.valueOf(j)));
    }

    public static void checkArgument(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(SQLite.lenientFormat(str, obj));
    }

    public static void checkArgument(boolean z) {
        if (z) {
            return;
        }
        Path$$ExternalSyntheticBUOutline0.m();
    }
}
