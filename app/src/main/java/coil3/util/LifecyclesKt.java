package coil3.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.display.DisplayManager;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import android.view.Display;
import androidx.activity.compose.ActivityResultLauncherHolder;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableFloatList;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.DefaultFlingBehavior;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.grid.DefaultLazyGridCacheWindow;
import androidx.compose.foundation.lazy.grid.GridCells$Adaptive;
import androidx.compose.foundation.lazy.grid.GridCells$Fixed;
import androidx.compose.foundation.lazy.grid.GridSlotCache;
import androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.pager.MeasuredPage;
import androidx.compose.foundation.pager.PagerLazyLayoutItemProvider;
import androidx.compose.foundation.pager.PagerMeasureResult;
import androidx.compose.foundation.pager.PagerSnapDistanceMaxPages;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.carousel.CarouselPageSize;
import androidx.compose.material3.carousel.CarouselPagerState;
import androidx.compose.material3.carousel.CarouselState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.scrollcapture.RelativeScroller;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.datastore.preferences.protobuf.ByteString$LiteralByteString;
import androidx.emoji2.text.EmojiProcessor;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda0;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$createFlow$2;
import androidx.room.RoomDatabase;
import androidx.room.TriggerBasedInvalidationTracker;
import androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkResponse;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda5;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.SetBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.Cache;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LifecyclesKt implements SegmentFinder {
    public static AndroidCanvas canvas;
    public static CanvasDrawScope canvasDrawScope;
    public static AndroidImageBitmap imageBitmap;

    /* JADX INFO: renamed from: coil3.util.LifecyclesKt$awaitStarted$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Lifecycle L$0;
        public Ref$ObjectRef L$1;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LifecyclesKt.awaitStarted(null, this);
        }
    }

    /* JADX INFO: renamed from: Carousel-cJHQLPU, reason: not valid java name */
    public static final void m882CarouselcJHQLPU(final CarouselState carouselState, Function2 function2, PaddingValues paddingValues, Modifier modifier, float f, SnapFlingBehavior snapFlingBehavior, boolean z, final ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        SnapFlingBehavior snapFlingBehavior2;
        boolean z2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2077912500);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(carouselState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(modifier) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changed(f) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            snapFlingBehavior2 = snapFlingBehavior;
            i2 |= gapComposer.changed(snapFlingBehavior2) ? 8388608 : 4194304;
        } else {
            snapFlingBehavior2 = snapFlingBehavior;
        }
        if ((100663296 & i) == 0) {
            z2 = z;
            i2 |= gapComposer.changed(z2) ? 67108864 : 33554432;
        } else {
            z2 = z;
        }
        if ((805306368 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if (gapComposer.shouldExecute(i2 & 1, (306783379 & i2) != 306783378)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(-143525276);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalLayoutDirection;
            float fCalculateStartPadding = OffsetKt.calculateStartPadding(paddingValues, (LayoutDirection) gapComposer.consume(staticProvidableCompositionLocal));
            gapComposer.end(false);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = CompositionLocalsKt.LocalDensity;
            float fMo81toPx0680j_4 = ((Density) gapComposer.consume(staticProvidableCompositionLocal2)).mo81toPx0680j_4(fCalculateStartPadding);
            gapComposer.startReplaceGroup(-1907957079);
            float fCalculateEndPadding = OffsetKt.calculateEndPadding(paddingValues, (LayoutDirection) gapComposer.consume(staticProvidableCompositionLocal));
            gapComposer.end(false);
            float fMo81toPx0680j_5 = ((Density) gapComposer.consume(staticProvidableCompositionLocal2)).mo81toPx0680j_4(fCalculateEndPadding);
            boolean z3 = (i2 & 896) == 256;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z3 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new CarouselPageSize(function2, fMo81toPx0680j_4, fMo81toPx0680j_5);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final CarouselPageSize carouselPageSize = (CarouselPageSize) objRememberedValue;
            boolean zChanged = gapComposer.changed(carouselPageSize);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new SnapPosition() { // from class: androidx.compose.material3.carousel.KeylineSnapPositionKt$KeylineSnapPosition$1
                    @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
                    public final int position(int i3, int i4) {
                        return SQLite.getSnapPositionOffset(carouselPageSize.getStrategyState(), i3, i4);
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            SnapPosition snapPosition = (SnapPosition) objRememberedValue2;
            boolean zChanged2 = gapComposer.changed(carouselState) | gapComposer.changed(carouselPageSize);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new BringIntoViewSpec() { // from class: androidx.compose.material3.carousel.KeylineSnapPositionKt$CarouselBringIntoViewSpec$1
                    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
                    public final float calculateScrollDistance(float f2, float f3, float f4) {
                        CarouselPagerState carouselPagerState = carouselState.pagerState;
                        PagerMeasureResult layoutInfo = carouselPagerState.getLayoutInfo();
                        MeasuredPage measuredPage = (MeasuredPage) CollectionsKt.firstOrNull(layoutInfo.visiblePagesInfo);
                        if (measuredPage == null) {
                            return super.calculateScrollDistance(f2, f3, f4);
                        }
                        int i3 = measuredPage.index;
                        int i4 = layoutInfo.pageSize + layoutInfo.pageSpacing;
                        if (i4 <= 0) {
                            return super.calculateScrollDistance(f2, f3, f4);
                        }
                        int iCoerceIn = UuidKt.coerceIn(MathKt.roundToInt(((f2 - measuredPage.offset) / i4) + i3), 0, carouselPagerState.getPageCount() - 1);
                        return (((iCoerceIn - i3) * i4) + measuredPage.offset) - SQLite.getSnapPositionOffset(carouselPageSize.getStrategyState(), iCoerceIn, carouselPagerState.getPageCount());
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) objRememberedValue3;
            gapComposer.startReplaceGroup(273463146);
            CarouselPagerState carouselPagerState = carouselState.pagerState;
            PaddingValuesImpl paddingValuesImplM128PaddingValuesa9UjIt4$default = OffsetKt.m128PaddingValuesa9UjIt4$default(CropImageView.DEFAULT_ASPECT_RATIO, paddingValues.mo125calculateTopPaddingD9Ej5fM(), CropImageView.DEFAULT_ASPECT_RATIO, paddingValues.mo122calculateBottomPaddingD9Ej5fM(), 5);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new TextKt$$ExternalSyntheticLambda0((byte) 15);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            MathKt.m1872HorizontalPagerIOMxRjY(carouselPagerState, SemanticsModifierKt.semantics(modifier, false, (Function1) objRememberedValue4), paddingValuesImplM128PaddingValuesa9UjIt4$default, carouselPageSize, 2, f, null, snapFlingBehavior2, z2, null, snapPosition, null, bringIntoViewSpec, Expect_jvmKt.rememberComposableLambda(-344838159, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Integer num = (Integer) obj2;
                    final int iIntValue = num.intValue();
                    int iIntValue2 = ((Integer) obj4).intValue();
                    GapComposer gapComposer2 = (GapComposer) ((Composer) obj3);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                    if (objRememberedValue5 == neverEqualPolicy2) {
                        objRememberedValue5 = new CarouselItemDrawInfoImpl();
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl = (CarouselItemDrawInfoImpl) objRememberedValue5;
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy2) {
                        objRememberedValue6 = new CarouselItemScopeImpl(carouselItemDrawInfoImpl);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    CarouselItemScopeImpl carouselItemScopeImpl = (CarouselItemScopeImpl) objRememberedValue6;
                    Object objRememberedValue7 = gapComposer2.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy2) {
                        objRememberedValue7 = new Shape() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$2$clipShape$1$1
                            @Override // androidx.compose.ui.graphics.Shape
                            /* JADX INFO: renamed from: createOutline-Pq9zytI */
                            public final ColorKt mo56createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
                                return new Outline$Rectangle(carouselItemDrawInfoImpl.getMaskRect());
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue7);
                    }
                    final CarouselKt$Carousel$2$clipShape$1$1 carouselKt$Carousel$2$clipShape$1$1 = (CarouselKt$Carousel$2$clipShape$1$1) objRememberedValue7;
                    CarouselPageSize carouselPageSize2 = carouselPageSize;
                    boolean zChanged3 = gapComposer2.changed(carouselPageSize2);
                    Object objRememberedValue8 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue8 == neverEqualPolicy2) {
                        objRememberedValue8 = new SliderState$$ExternalSyntheticLambda0((byte) 29, carouselPageSize2);
                        gapComposer2.updateRememberedValue(objRememberedValue8);
                    }
                    final Function0 function0 = (Function0) objRememberedValue8;
                    final boolean z4 = false;
                    final CarouselState carouselState2 = carouselState;
                    Modifier modifierLayout = RulerKt.layout(Modifier.Companion.$$INSTANCE, new Function3() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj5, Object obj6, Object obj7) {
                            long jM776copyZbe2FdA;
                            MeasureScope measureScope = (MeasureScope) obj5;
                            Measurable measurable = (Measurable) obj6;
                            Constraints constraints = (Constraints) obj7;
                            final Strategy strategy = (Strategy) function0.invoke();
                            boolean z5 = strategy.isValid;
                            EmptyMap emptyMap = EmptyMap.INSTANCE;
                            if (!z5) {
                                return measureScope.layout(0, 0, emptyMap, new TextKt$$ExternalSyntheticLambda0((byte) 16));
                            }
                            final boolean z6 = measureScope.getLayoutDirection() == LayoutDirection.Rtl;
                            float itemMainAxisSize = strategy.getItemMainAxisSize();
                            final boolean z7 = z4;
                            if (z7) {
                                jM776copyZbe2FdA = Constraints.m776copyZbe2FdA(Constraints.m786getMinWidthimpl(constraints.value), Constraints.m784getMaxWidthimpl(constraints.value), MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize));
                            } else {
                                long j = constraints.value;
                                jM776copyZbe2FdA = Constraints.m776copyZbe2FdA(MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize), Constraints.m785getMinHeightimpl(j), Constraints.m783getMaxHeightimpl(j));
                            }
                            final Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(jM776copyZbe2FdA);
                            final CarouselState carouselState3 = carouselState2;
                            int currentPage = carouselState3.pagerState.getCurrentPage();
                            final int i3 = iIntValue;
                            final float fAbs = 1.0f / (Math.abs(i3 - currentPage) + 1);
                            int i4 = placeableMo598measureBRTryo0.width;
                            final float f2 = i4;
                            int i5 = placeableMo598measureBRTryo0.height;
                            final float f3 = i5;
                            final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl2 = carouselItemDrawInfoImpl;
                            final Shape shape = carouselKt$Carousel$2$clipShape$1$1;
                            return measureScope.layout(i4, i5, emptyMap, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj8) {
                                    float fLerp;
                                    int i6;
                                    float f4;
                                    KeylineList keylineList;
                                    Keyline keyline;
                                    Keyline keyline2;
                                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj8;
                                    Strategy strategy2 = strategy;
                                    float itemMainAxisSize2 = strategy2.getItemMainAxisSize();
                                    float f5 = strategy2.itemSpacing;
                                    float f6 = itemMainAxisSize2 + f5;
                                    CarouselPagerState carouselPagerState2 = carouselState3.pagerState;
                                    float currentPageOffsetFraction = ((carouselPagerState2.getCurrentPageOffsetFraction() * f6) + (carouselPagerState2.getCurrentPage() * f6)) - SQLite.getSnapPositionOffset(strategy2, carouselPagerState2.getCurrentPage(), carouselPagerState2.getPageCount());
                                    float pageCount = carouselPagerState2.getPageCount();
                                    float f7 = 1.0f;
                                    float itemMainAxisSize3 = (((pageCount - 1.0f) * f5) + (strategy2.getItemMainAxisSize() * pageCount)) - strategy2.availableSpace;
                                    float f8 = CropImageView.DEFAULT_ASPECT_RATIO;
                                    if (itemMainAxisSize3 < CropImageView.DEFAULT_ASPECT_RATIO) {
                                        itemMainAxisSize3 = 0.0f;
                                    }
                                    if (currentPageOffsetFraction == strategy2.cachedScrollOffset && itemMainAxisSize3 == strategy2.cachedMaxScrollOffset && (keylineList = strategy2.cachedKeylineList) != null) {
                                        f4 = 0.0f;
                                    } else {
                                        List listListOf = strategy2.endKeylineSteps;
                                        List list = strategy2.startKeylineSteps;
                                        float fMax = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, currentPageOffsetFraction);
                                        float f9 = strategy2.startShiftDistance;
                                        float fMax2 = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, itemMainAxisSize3 - strategy2.endShiftDistance);
                                        if (f9 > fMax || fMax > fMax2) {
                                            float fLerp2 = DatabaseDao_Impl.AnonymousClass17.lerp(1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f9, fMax);
                                            MutableFloatList mutableFloatList = strategy2.startShiftPoints;
                                            if (fMax > fMax2) {
                                                fLerp2 = DatabaseDao_Impl.AnonymousClass17.lerp(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, fMax2, itemMainAxisSize3, fMax);
                                                mutableFloatList = strategy2.endShiftPoints;
                                                if (fMax2 < 0.01f && list.size() == 2 && listListOf.size() == 2) {
                                                    List list2 = strategy2.lastStartAndEndKeylineListSteps;
                                                    if (list2 == null) {
                                                        listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new KeylineList[]{CollectionsKt.last(list), CollectionsKt.last(listListOf)});
                                                        strategy2.lastStartAndEndKeylineListSteps = listListOf;
                                                    } else {
                                                        listListOf = list2;
                                                    }
                                                }
                                            } else {
                                                listListOf = list;
                                            }
                                            float f10 = mutableFloatList.get(0);
                                            int size = listListOf.size();
                                            int i7 = 1;
                                            while (true) {
                                                if (i7 >= size) {
                                                    fLerp = 0.0f;
                                                    i6 = 0;
                                                    i7 = 0;
                                                    break;
                                                }
                                                float f11 = mutableFloatList.get(i7);
                                                if (fLerp2 <= f11) {
                                                    i6 = i7 - 1;
                                                    fLerp = DatabaseDao_Impl.AnonymousClass17.lerp(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, f10, f11, fLerp2);
                                                    break;
                                                }
                                                i7++;
                                                f10 = f11;
                                            }
                                            KeylineList keylineList2 = (KeylineList) listListOf.get(i6);
                                            KeylineList keylineList3 = (KeylineList) listListOf.get(i7);
                                            ArrayList arrayList = new ArrayList(keylineList2.$$delegate_0.size());
                                            int size2 = keylineList2.$$delegate_0.size();
                                            int i8 = 0;
                                            while (i8 < size2) {
                                                arrayList.add(UtilsKt.lerp(keylineList2.get(i8), keylineList3.get(i8), fLerp));
                                                i8++;
                                                f8 = f8;
                                            }
                                            f4 = f8;
                                            keylineList = new KeylineList(arrayList);
                                        } else {
                                            keylineList = strategy2.defaultKeylines;
                                            f4 = 0.0f;
                                        }
                                        strategy2.cachedScrollOffset = currentPageOffsetFraction;
                                        strategy2.cachedMaxScrollOffset = itemMainAxisSize3;
                                        strategy2.cachedKeylineList = keylineList;
                                    }
                                    float itemMainAxisSize4 = ((strategy2.getItemMainAxisSize() / 2.0f) + (i3 * (strategy2.getItemMainAxisSize() + f5))) - currentPageOffsetFraction;
                                    int size3 = keylineList.$$delegate_0.size() - 1;
                                    if (size3 < 0) {
                                        keyline = (Keyline) CollectionsKt.first((List) keylineList);
                                        break;
                                    }
                                    while (true) {
                                        int i9 = size3 - 1;
                                        keyline = keylineList.get(size3);
                                        if (keyline.unadjustedOffset < itemMainAxisSize4) {
                                            break;
                                        }
                                        if (i9 < 0) {
                                            keyline = (Keyline) CollectionsKt.first((List) keylineList);
                                            break;
                                        }
                                        size3 = i9;
                                    }
                                    int size4 = keylineList.$$delegate_0.size();
                                    int i10 = 0;
                                    while (true) {
                                        if (i10 >= size4) {
                                            keyline2 = null;
                                            break;
                                        }
                                        keyline2 = keylineList.get(i10);
                                        if (keyline2.unadjustedOffset >= itemMainAxisSize4) {
                                            break;
                                        }
                                        i10++;
                                    }
                                    if (keyline2 == null) {
                                        keyline2 = (Keyline) CollectionsKt.last(keylineList);
                                    }
                                    if (!Intrinsics.areEqual(keyline, keyline2)) {
                                        float f12 = keyline2.unadjustedOffset;
                                        float f13 = keyline.unadjustedOffset;
                                        f7 = (itemMainAxisSize4 - f13) / (f12 - f13);
                                    }
                                    Keyline keylineLerp = UtilsKt.lerp(keyline, keyline2, f7);
                                    float f14 = keylineLerp.size;
                                    boolean zEquals = keyline.equals(keyline2);
                                    final boolean z8 = z7;
                                    float f15 = f2;
                                    float itemMainAxisSize5 = z8 ? f15 / 2.0f : strategy2.getItemMainAxisSize() / 2.0f;
                                    float f16 = f3;
                                    float itemMainAxisSize6 = z8 ? strategy2.getItemMainAxisSize() / 2.0f : f16 / 2.0f;
                                    float f17 = z8 ? f15 / 2.0f : f14 / 2.0f;
                                    float f18 = z8 ? f14 / 2.0f : f16 / 2.0f;
                                    float f19 = itemMainAxisSize5 - f17;
                                    float f20 = itemMainAxisSize6 - f18;
                                    float f21 = itemMainAxisSize5 + f17;
                                    float f22 = itemMainAxisSize6 + f18;
                                    CarouselItemDrawInfoImpl carouselItemDrawInfoImpl3 = carouselItemDrawInfoImpl2;
                                    carouselItemDrawInfoImpl3.sizeState$delegate.setFloatValue(f14);
                                    carouselItemDrawInfoImpl3.minSizeState$delegate.setFloatValue(strategy2.minItemSize);
                                    carouselItemDrawInfoImpl3.maxSizeState$delegate.setFloatValue(strategy2.maxItemSize);
                                    carouselItemDrawInfoImpl3.maskLeftState$delegate.setFloatValue(f19);
                                    carouselItemDrawInfoImpl3.maskTopState$delegate.setFloatValue(f20);
                                    carouselItemDrawInfoImpl3.maskRightState$delegate.setFloatValue(f21);
                                    carouselItemDrawInfoImpl3.maskBottomState$delegate.setFloatValue(f22);
                                    final boolean z9 = (f19 == f4 && f20 == f4 && f21 == f15 && f22 == f16) ? false : true;
                                    final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                                    float f23 = keylineLerp.offset - itemMainAxisSize4;
                                    ref$FloatRef.element = f23;
                                    if (zEquals) {
                                        ref$FloatRef.element = ((itemMainAxisSize4 - keylineLerp.unadjustedOffset) / f14) + f23;
                                    }
                                    final Shape shape2 = shape;
                                    final boolean z10 = z6;
                                    placementScope.placeWithLayer(placeableMo598measureBRTryo0, 0, 0, fAbs, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj9) {
                                            ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj9;
                                            reusableGraphicsLayerScope.setClip(z9);
                                            reusableGraphicsLayerScope.setShape(shape2);
                                            boolean z11 = z8;
                                            Ref$FloatRef ref$FloatRef2 = ref$FloatRef;
                                            if (z11) {
                                                reusableGraphicsLayerScope.setTranslationY(ref$FloatRef2.element);
                                            } else {
                                                float f24 = ref$FloatRef2.element;
                                                if (z10) {
                                                    f24 = -f24;
                                                }
                                                reusableGraphicsLayerScope.setTranslationX(f24);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    });
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierLayout);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    composableLambdaImpl.invoke(carouselItemScopeImpl, num, gapComposer2, Integer.valueOf(iIntValue2 & 112));
                    gapComposer2.end(true);
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (57344 & i2) | ((i2 >> 3) & 458752) | (29360128 & i2) | (i2 & 234881024), 11840);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SliderDefaults$$ExternalSyntheticLambda8(carouselState, function2, paddingValues, modifier, f, snapFlingBehavior, z, composableLambdaImpl, i);
        }
    }

    public static DensityImpl Density$default() {
        return new DensityImpl(1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: HorizontalMultiBrowseCarousel-3tcCNu0, reason: not valid java name */
    public static final void m883HorizontalMultiBrowseCarousel3tcCNu0(final CarouselState carouselState, final Modifier modifier, final float f, SnapFlingBehavior snapFlingBehavior, boolean z, float f2, float f3, PaddingValues paddingValues, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i) {
        final SnapFlingBehavior snapFlingBehavior2;
        final boolean z2;
        final float f4;
        final float f5;
        final PaddingValues paddingValues2;
        final float f6;
        final float f7;
        boolean z3;
        SnapFlingBehavior snapFlingBehaviorFlingBehavior;
        int i2;
        PaddingValues paddingValuesImpl;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-221490402);
        int i3 = i | (gapComposer.changedInstance(carouselState) ? 4 : 2) | 115023872;
        if (gapComposer.shouldExecute(i3 & 1, (306783379 & i3) != 306783378)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                f6 = 40.0f;
                f7 = 56.0f;
                z3 = true;
                snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(carouselState.pagerState, new PagerSnapDistanceMaxPages(), ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5), gapComposer, 0, 20);
                i2 = i3 & (-57345);
                paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-57345);
                snapFlingBehaviorFlingBehavior = snapFlingBehavior;
                z3 = z;
                f6 = f2;
                f7 = f3;
                paddingValuesImpl = paddingValues;
            }
            gapComposer.endDefaults();
            final Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            boolean zChanged = gapComposer.changed(density) | gapComposer.changedInstance(carouselState);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        int i4;
                        float fFloatValue = ((Float) obj).floatValue();
                        float fFloatValue2 = ((Float) obj2).floatValue();
                        Density density2 = density;
                        float fMo81toPx0680j_4 = density2.mo81toPx0680j_4(320.0f);
                        int iIntValue = ((Number) ((Function0) carouselState.pagerState.pageCountState.getValue()).invoke()).intValue();
                        float fMo81toPx0680j_5 = density2.mo81toPx0680j_4(f6);
                        float fMo81toPx0680j_6 = density2.mo81toPx0680j_4(f7);
                        if (fFloatValue == CropImageView.DEFAULT_ASPECT_RATIO || fMo81toPx0680j_4 == CropImageView.DEFAULT_ASPECT_RATIO) {
                            return KeylineList.Empty;
                        }
                        int[] iArr = {1};
                        int[] iArr2 = {1, 0};
                        float fMin = Math.min(fMo81toPx0680j_4, fFloatValue);
                        float fCoerceIn = UuidKt.coerceIn(fMin / 3.0f, fMo81toPx0680j_5, fMo81toPx0680j_6);
                        float f8 = (fMin + fCoerceIn) / 2.0f;
                        if (fFloatValue < fMo81toPx0680j_5 * 2.0f) {
                            iArr = new int[]{0};
                        }
                        int iMax = Math.max(1, (int) Math.floor(((fFloatValue - (ArraysKt.maxOrThrow(iArr2) * f8)) - (ArraysKt.maxOrThrow(iArr) * fMo81toPx0680j_6)) / fMin));
                        int iCeil = (int) Math.ceil(fFloatValue / fMin);
                        int i5 = (iCeil - iMax) + 1;
                        int[] iArr3 = new int[i5];
                        for (int i6 = 0; i6 < i5; i6++) {
                            iArr3[i6] = iCeil - i6;
                        }
                        float fMo81toPx0680j_7 = density2.mo81toPx0680j_4(10.0f);
                        Arrangement arrangementFindLowestCostArrangement = FileSystemsKt.findLowestCostArrangement(fFloatValue, fFloatValue2, fCoerceIn, fMo81toPx0680j_5, fMo81toPx0680j_6, iArr, f8, iArr2, fMin, iArr3);
                        if (arrangementFindLowestCostArrangement != null) {
                            int i7 = arrangementFindLowestCostArrangement.largeCount;
                            int i8 = arrangementFindLowestCostArrangement.mediumCount;
                            int i9 = arrangementFindLowestCostArrangement.smallCount;
                            if (i7 + i8 + i9 > iIntValue) {
                                for (int i10 = ((i7 + i8) + i9) - iIntValue; i10 > 0; i10--) {
                                    if (i9 > 0) {
                                        i9--;
                                    } else if (i8 > 1) {
                                        i8--;
                                    }
                                }
                                arrangementFindLowestCostArrangement = FileSystemsKt.findLowestCostArrangement(fFloatValue, fFloatValue2, fCoerceIn, fMo81toPx0680j_5, fMo81toPx0680j_6, new int[]{i9}, f8, new int[]{i8}, fMin, iArr3);
                            }
                        }
                        if (arrangementFindLowestCostArrangement == null) {
                            return KeylineList.Empty;
                        }
                        RelativeScroller relativeScroller = new RelativeScroller();
                        relativeScroller.add(fMo81toPx0680j_7, true);
                        int i11 = arrangementFindLowestCostArrangement.largeCount;
                        for (int i12 = 0; i12 < i11; i12++) {
                            relativeScroller.add(arrangementFindLowestCostArrangement.largeSize, false);
                        }
                        int i13 = arrangementFindLowestCostArrangement.mediumCount;
                        for (int i14 = 0; i14 < i13; i14++) {
                            relativeScroller.add(arrangementFindLowestCostArrangement.mediumSize, false);
                        }
                        int i15 = arrangementFindLowestCostArrangement.smallCount;
                        for (int i16 = 0; i16 < i15; i16++) {
                            relativeScroller.add(arrangementFindLowestCostArrangement.smallSize, false);
                        }
                        relativeScroller.add(fMo81toPx0680j_7, true);
                        Object obj3 = relativeScroller.scrollBy;
                        ArrayList arrayList = (ArrayList) obj3;
                        int i17 = relativeScroller.viewportSize;
                        if (i17 < 0) {
                            i4 = -1;
                        } else {
                            while (i17 < arrayList.size() - 1) {
                                int i18 = i17 + 1;
                                if (((KeylineListScopeImpl$TmpKeyline) arrayList.get(i18)).size != relativeScroller.scrollAmount) {
                                    break;
                                }
                                i17 = i18;
                            }
                            i4 = i17;
                        }
                        int i19 = relativeScroller.viewportSize;
                        float f9 = relativeScroller.scrollAmount;
                        return new KeylineList(RelativeScroller.createKeylinesWithPivot(i19, f9 / 2.0f, i19, i4, f9, fFloatValue, fFloatValue2, (ArrayList) obj3));
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            m882CarouselcJHQLPU(carouselState, (Function2) objRememberedValue, paddingValuesImpl, modifier, f, snapFlingBehaviorFlingBehavior, z3, composableLambdaImpl, gapComposer, (i2 & 14) | 907766832);
            snapFlingBehavior2 = snapFlingBehaviorFlingBehavior;
            z2 = z3;
            f4 = f6;
            f5 = f7;
            paddingValues2 = paddingValuesImpl;
        } else {
            gapComposer.skipToGroupEnd();
            snapFlingBehavior2 = snapFlingBehavior;
            z2 = z;
            f4 = f2;
            f5 = f3;
            paddingValues2 = paddingValues;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(modifier, f, snapFlingBehavior2, z2, f4, f5, paddingValues2, composableLambdaImpl, i) { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                public final /* synthetic */ Modifier f$2;
                public final /* synthetic */ float f$3;
                public final /* synthetic */ SnapFlingBehavior f$4;
                public final /* synthetic */ boolean f$5;
                public final /* synthetic */ float f$6;
                public final /* synthetic */ float f$7;
                public final /* synthetic */ PaddingValues f$8;
                public final /* synthetic */ ComposableLambdaImpl f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(805309881);
                    LifecyclesKt.m883HorizontalMultiBrowseCarousel3tcCNu0(this.f$0, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0182  */
    /* JADX WARN: Code duplicated, block: B:102:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:105:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x0070  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:44:0x008a  */
    /* JADX WARN: Code duplicated, block: B:45:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x009b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x0101  */
    /* JADX WARN: Code duplicated, block: B:74:0x0105  */
    /* JADX WARN: Code duplicated, block: B:75:0x010c  */
    /* JADX WARN: Code duplicated, block: B:77:0x010f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0116  */
    /* JADX WARN: Code duplicated, block: B:81:0x0123  */
    /* JADX WARN: Code duplicated, block: B:83:0x0131 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x0133  */
    /* JADX WARN: Code duplicated, block: B:86:0x0141  */
    /* JADX WARN: Code duplicated, block: B:88:0x0144  */
    /* JADX WARN: Code duplicated, block: B:92:0x016e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0174  */
    /* JADX WARN: Code duplicated, block: B:99:0x0180 A[ADDED_TO_REGION] */
    public static final void LazyHorizontalGrid(final GridCells$Fixed gridCells$Fixed, final Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, Arrangement$Horizontal arrangement$Horizontal, Arrangement$Vertical arrangement$Vertical, FlingBehavior flingBehavior, boolean z, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, LazyLayoutCacheWindow lazyLayoutCacheWindow, final Function1 function1, Composer composer, final int i, final int i2) {
        LazyGridState lazyGridState2;
        PaddingValues paddingValues2;
        FlingBehavior flingBehavior2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z3;
        GapComposer gapComposer;
        final Arrangement$Horizontal arrangement$Horizontal2;
        final Arrangement$Vertical arrangement$Vertical2;
        final LazyLayoutCacheWindow lazyLayoutCacheWindow2;
        final LazyGridState lazyGridStateRememberLazyGridState;
        final PaddingValues paddingValues3;
        final FlingBehavior flingBehavior3;
        final boolean z4;
        final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i9;
        PaddingValues paddingValuesImpl;
        int i10;
        int i11;
        FlingBehavior flingBehavior4;
        int i12;
        PaddingValues paddingValues4;
        boolean z5;
        FlingBehavior flingBehavior5;
        Arrangement$Horizontal arrangement$Horizontal3;
        LazyLayoutCacheWindow lazyLayoutCacheWindow3;
        Arrangement$Vertical arrangement$Vertical3;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect3;
        DecayAnimationSpecImpl decayAnimationSpecImplRememberSplineBasedDecay;
        boolean zChanged;
        Object objRememberedValue;
        boolean z6;
        Object objRememberedValue2;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1090398840);
        int i13 = (gapComposer2.changed(gridCells$Fixed) ? 4 : 2) | i | (gapComposer2.changed(modifier) ? 32 : 16);
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                lazyGridState2 = lazyGridState;
                int i14 = gapComposer2.changed(lazyGridState2) ? 256 : 128;
                i13 |= i14;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i13 |= i14;
        } else {
            lazyGridState2 = lazyGridState;
        }
        int i15 = i2 & 8;
        if (i15 == 0) {
            if ((i & 3072) == 0) {
                paddingValues2 = paddingValues;
                i13 |= gapComposer2.changed(paddingValues2) ? 2048 : 1024;
            }
            int i16 = i13 | 1662976;
            if ((i2 & 128) == 0) {
                flingBehavior2 = flingBehavior;
                int i17 = gapComposer2.changed(flingBehavior2) ? 8388608 : 4194304;
                i3 = i16 | i17;
                i4 = i2 & 256;
                if (i4 != 0) {
                    i6 = i3 | 100663296;
                    z2 = z;
                } else {
                    z2 = z;
                    if (gapComposer2.changed(z2)) {
                        i5 = 67108864;
                    } else {
                        i5 = 33554432;
                    }
                    i6 = i3 | i5;
                }
                i7 = i6 | WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                i8 = (gapComposer2.changedInstance(function1) ? 32 : 16) | 6;
                if ((i7 & 306783379) == 306783378 || (i8 & 19) != 18) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer2.shouldExecute(i7 & 1, z3)) {
                    gapComposer2.startDefaults();
                    i9 = i & 1;
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (i9 != 0 || gapComposer2.getDefaultsInvalid()) {
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                            i7 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i15 != 0) {
                            paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                        } else {
                            paddingValuesImpl = paddingValues2;
                        }
                        Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                        i10 = i7 & (-458753);
                        Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                        i11 = i7;
                        if ((i2 & 128) != 0) {
                            decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                            zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (zChanged || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            flingBehavior4 = (DefaultFlingBehavior) objRememberedValue;
                            i10 = i11 & (-29818881);
                        } else {
                            flingBehavior4 = flingBehavior2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                        i12 = i10 & (-1879048193);
                        paddingValues4 = paddingValuesImpl;
                        z5 = true;
                        flingBehavior5 = flingBehavior4;
                        arrangement$Horizontal3 = arrangement$End$1;
                        lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                        arrangement$Vertical3 = arrangement$Top$1;
                        androidEdgeEffectOverscrollEffect3 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                    } else {
                        gapComposer2.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i7 &= -897;
                        }
                        int i18 = i7 & (-458753);
                        if ((i2 & 128) != 0) {
                            i18 = i7 & (-29818881);
                        }
                        int i19 = i18 & (-1879048193);
                        arrangement$Horizontal3 = arrangement$Horizontal;
                        androidEdgeEffectOverscrollEffect3 = androidEdgeEffectOverscrollEffect;
                        lazyLayoutCacheWindow3 = lazyLayoutCacheWindow;
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                        flingBehavior5 = flingBehavior2;
                        z5 = true;
                        paddingValues4 = paddingValues2;
                        i12 = i19;
                        arrangement$Vertical3 = arrangement$Vertical;
                    }
                    boolean z7 = z2;
                    gapComposer2.endDefaults();
                    int i20 = (i12 & 14) | 48;
                    z6 = ((((i20 & 14) ^ 6) <= 4 && gapComposer2.changed(gridCells$Fixed)) || (i20 & 6) == 4) ? z5 : false;
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (z6 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Fixed, arrangement$Vertical3, (byte) 8));
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    GridSlotCache gridSlotCache = (GridSlotCache) objRememberedValue2;
                    int i21 = i12 >> 3;
                    gapComposer = gapComposer2;
                    Arrangement$Vertical arrangement$Vertical4 = arrangement$Vertical3;
                    UtilsKt.LazyGrid(modifier, lazyGridStateRememberLazyGridState, gridSlotCache, paddingValues4, false, flingBehavior5, z7, androidEdgeEffectOverscrollEffect3, arrangement$Vertical4, arrangement$Horizontal3, lazyLayoutCacheWindow3, function1, gapComposer, (i21 & 29360128) | (i21 & 14) | 196608 | (i21 & 112) | (i12 & 7168) | 24576 | (3670016 & i21) | 805306368, 48 | ((i8 << 3) & 896));
                    paddingValues3 = paddingValues4;
                    flingBehavior3 = flingBehavior5;
                    z4 = z7;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect3;
                    arrangement$Vertical2 = arrangement$Vertical4;
                    arrangement$Horizontal2 = arrangement$Horizontal3;
                    lazyLayoutCacheWindow2 = lazyLayoutCacheWindow3;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    arrangement$Horizontal2 = arrangement$Horizontal;
                    arrangement$Vertical2 = arrangement$Vertical;
                    lazyLayoutCacheWindow2 = lazyLayoutCacheWindow;
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                    paddingValues3 = paddingValues2;
                    flingBehavior3 = flingBehavior2;
                    z4 = z2;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifier, lazyGridStateRememberLazyGridState, paddingValues3, arrangement$Horizontal2, arrangement$Vertical2, flingBehavior3, z4, androidEdgeEffectOverscrollEffect2, lazyLayoutCacheWindow2, function1, (Composer) obj, iUpdateChangedFlags, i2);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            flingBehavior2 = flingBehavior;
            i3 = i16 | i17;
            i4 = i2 & 256;
            if (i4 != 0) {
                i6 = i3 | 100663296;
                z2 = z;
            } else {
                z2 = z;
                if (gapComposer2.changed(z2)) {
                    i5 = 67108864;
                } else {
                    i5 = 33554432;
                }
                i6 = i3 | i5;
            }
            i7 = i6 | WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            i8 = (gapComposer2.changedInstance(function1) ? 32 : 16) | 6;
            if ((i7 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer2.shouldExecute(i7 & 1, z3)) {
                gapComposer2.startDefaults();
                i9 = i & 1;
                NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                if (i9 != 0) {
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                        i7 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i15 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    } else {
                        paddingValuesImpl = paddingValues2;
                    }
                    Arrangement$End$1 arrangement$End$2 = OffsetKt.Start;
                    i10 = i7 & (-458753);
                    Arrangement$Top$1 arrangement$Top$2 = OffsetKt.Top;
                    i11 = i7;
                    if ((i2 & 128) != 0) {
                        decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                        zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        flingBehavior4 = (DefaultFlingBehavior) objRememberedValue;
                        i10 = i11 & (-29818881);
                    } else {
                        flingBehavior4 = flingBehavior2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect2 = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    i12 = i10 & (-1879048193);
                    paddingValues4 = paddingValuesImpl;
                    z5 = true;
                    flingBehavior5 = flingBehavior4;
                    arrangement$Horizontal3 = arrangement$End$2;
                    lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                    arrangement$Vertical3 = arrangement$Top$2;
                    androidEdgeEffectOverscrollEffect3 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect2;
                } else {
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                        i7 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i15 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    } else {
                        paddingValuesImpl = paddingValues2;
                    }
                    Arrangement$End$1 arrangement$End$3 = OffsetKt.Start;
                    i10 = i7 & (-458753);
                    Arrangement$Top$1 arrangement$Top$3 = OffsetKt.Top;
                    i11 = i7;
                    if ((i2 & 128) != 0) {
                        decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                        zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        flingBehavior4 = (DefaultFlingBehavior) objRememberedValue;
                        i10 = i11 & (-29818881);
                    } else {
                        flingBehavior4 = flingBehavior2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect3 = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    i12 = i10 & (-1879048193);
                    paddingValues4 = paddingValuesImpl;
                    z5 = true;
                    flingBehavior5 = flingBehavior4;
                    arrangement$Horizontal3 = arrangement$End$3;
                    lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                    arrangement$Vertical3 = arrangement$Top$3;
                    androidEdgeEffectOverscrollEffect3 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect3;
                }
                boolean z8 = z2;
                gapComposer2.endDefaults();
                int i22 = (i12 & 14) | 48;
                if (((i22 & 14) ^ 6) <= 4) {
                }
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (z6) {
                    objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Fixed, arrangement$Vertical3, (byte) 8));
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Fixed, arrangement$Vertical3, (byte) 8));
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                GridSlotCache gridSlotCache2 = (GridSlotCache) objRememberedValue2;
                int i23 = i12 >> 3;
                gapComposer = gapComposer2;
                Arrangement$Vertical arrangement$Vertical5 = arrangement$Vertical3;
                UtilsKt.LazyGrid(modifier, lazyGridStateRememberLazyGridState, gridSlotCache2, paddingValues4, false, flingBehavior5, z8, androidEdgeEffectOverscrollEffect3, arrangement$Vertical5, arrangement$Horizontal3, lazyLayoutCacheWindow3, function1, gapComposer, (i23 & 29360128) | (i23 & 14) | 196608 | (i23 & 112) | (i12 & 7168) | 24576 | (3670016 & i23) | 805306368, 48 | ((i8 << 3) & 896));
                paddingValues3 = paddingValues4;
                flingBehavior3 = flingBehavior5;
                z4 = z8;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect3;
                arrangement$Vertical2 = arrangement$Vertical5;
                arrangement$Horizontal2 = arrangement$Horizontal3;
                lazyLayoutCacheWindow2 = lazyLayoutCacheWindow3;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                arrangement$Horizontal2 = arrangement$Horizontal;
                arrangement$Vertical2 = arrangement$Vertical;
                lazyLayoutCacheWindow2 = lazyLayoutCacheWindow;
                lazyGridStateRememberLazyGridState = lazyGridState2;
                paddingValues3 = paddingValues2;
                flingBehavior3 = flingBehavior2;
                z4 = z2;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifier, lazyGridStateRememberLazyGridState, paddingValues3, arrangement$Horizontal2, arrangement$Vertical2, flingBehavior3, z4, androidEdgeEffectOverscrollEffect2, lazyLayoutCacheWindow2, function1, (Composer) obj, iUpdateChangedFlags, i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i13 |= 3072;
        paddingValues2 = paddingValues;
        int i110 = i13 | 1662976;
        if ((i2 & 128) == 0) {
            flingBehavior2 = flingBehavior;
            if (gapComposer2.changed(flingBehavior2)) {
            }
            i3 = i110 | i17;
            i4 = i2 & 256;
            if (i4 != 0) {
                i6 = i3 | 100663296;
                z2 = z;
            } else {
                z2 = z;
                if (gapComposer2.changed(z2)) {
                    i5 = 67108864;
                } else {
                    i5 = 33554432;
                }
                i6 = i3 | i5;
            }
            i7 = i6 | WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            i8 = (gapComposer2.changedInstance(function1) ? 32 : 16) | 6;
            if ((i7 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer2.shouldExecute(i7 & 1, z3)) {
                gapComposer2.startDefaults();
                i9 = i & 1;
                NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                if (i9 != 0) {
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                        i7 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i15 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    } else {
                        paddingValuesImpl = paddingValues2;
                    }
                    Arrangement$End$1 arrangement$End$4 = OffsetKt.Start;
                    i10 = i7 & (-458753);
                    Arrangement$Top$1 arrangement$Top$4 = OffsetKt.Top;
                    i11 = i7;
                    if ((i2 & 128) != 0) {
                        decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                        zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        flingBehavior4 = (DefaultFlingBehavior) objRememberedValue;
                        i10 = i11 & (-29818881);
                    } else {
                        flingBehavior4 = flingBehavior2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect4 = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    i12 = i10 & (-1879048193);
                    paddingValues4 = paddingValuesImpl;
                    z5 = true;
                    flingBehavior5 = flingBehavior4;
                    arrangement$Horizontal3 = arrangement$End$4;
                    lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                    arrangement$Vertical3 = arrangement$Top$4;
                    androidEdgeEffectOverscrollEffect3 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect4;
                } else {
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                        i7 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i15 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    } else {
                        paddingValuesImpl = paddingValues2;
                    }
                    Arrangement$End$1 arrangement$End$5 = OffsetKt.Start;
                    i10 = i7 & (-458753);
                    Arrangement$Top$1 arrangement$Top$5 = OffsetKt.Top;
                    i11 = i7;
                    if ((i2 & 128) != 0) {
                        decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                        zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        flingBehavior4 = (DefaultFlingBehavior) objRememberedValue;
                        i10 = i11 & (-29818881);
                    } else {
                        flingBehavior4 = flingBehavior2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect5 = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    i12 = i10 & (-1879048193);
                    paddingValues4 = paddingValuesImpl;
                    z5 = true;
                    flingBehavior5 = flingBehavior4;
                    arrangement$Horizontal3 = arrangement$End$5;
                    lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                    arrangement$Vertical3 = arrangement$Top$5;
                    androidEdgeEffectOverscrollEffect3 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect5;
                }
                boolean z9 = z2;
                gapComposer2.endDefaults();
                int i24 = (i12 & 14) | 48;
                if (((i24 & 14) ^ 6) <= 4) {
                }
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (z6) {
                    objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Fixed, arrangement$Vertical3, (byte) 8));
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Fixed, arrangement$Vertical3, (byte) 8));
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                GridSlotCache gridSlotCache3 = (GridSlotCache) objRememberedValue2;
                int i25 = i12 >> 3;
                gapComposer = gapComposer2;
                Arrangement$Vertical arrangement$Vertical6 = arrangement$Vertical3;
                UtilsKt.LazyGrid(modifier, lazyGridStateRememberLazyGridState, gridSlotCache3, paddingValues4, false, flingBehavior5, z9, androidEdgeEffectOverscrollEffect3, arrangement$Vertical6, arrangement$Horizontal3, lazyLayoutCacheWindow3, function1, gapComposer, (i25 & 29360128) | (i25 & 14) | 196608 | (i25 & 112) | (i12 & 7168) | 24576 | (3670016 & i25) | 805306368, 48 | ((i8 << 3) & 896));
                paddingValues3 = paddingValues4;
                flingBehavior3 = flingBehavior5;
                z4 = z9;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect3;
                arrangement$Vertical2 = arrangement$Vertical6;
                arrangement$Horizontal2 = arrangement$Horizontal3;
                lazyLayoutCacheWindow2 = lazyLayoutCacheWindow3;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                arrangement$Horizontal2 = arrangement$Horizontal;
                arrangement$Vertical2 = arrangement$Vertical;
                lazyLayoutCacheWindow2 = lazyLayoutCacheWindow;
                lazyGridStateRememberLazyGridState = lazyGridState2;
                paddingValues3 = paddingValues2;
                flingBehavior3 = flingBehavior2;
                z4 = z2;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifier, lazyGridStateRememberLazyGridState, paddingValues3, arrangement$Horizontal2, arrangement$Vertical2, flingBehavior3, z4, androidEdgeEffectOverscrollEffect2, lazyLayoutCacheWindow2, function1, (Composer) obj, iUpdateChangedFlags, i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        flingBehavior2 = flingBehavior;
        i3 = i110 | i17;
        i4 = i2 & 256;
        if (i4 != 0) {
            i6 = i3 | 100663296;
            z2 = z;
        } else {
            z2 = z;
            if (gapComposer2.changed(z2)) {
                i5 = 67108864;
            } else {
                i5 = 33554432;
            }
            i6 = i3 | i5;
        }
        i7 = i6 | WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        i8 = (gapComposer2.changedInstance(function1) ? 32 : 16) | 6;
        if ((i7 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (gapComposer2.shouldExecute(i7 & 1, z3)) {
            gapComposer2.startDefaults();
            i9 = i & 1;
            NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
            if (i9 != 0) {
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                    i7 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i15 != 0) {
                    paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                } else {
                    paddingValuesImpl = paddingValues2;
                }
                Arrangement$End$1 arrangement$End$6 = OffsetKt.Start;
                i10 = i7 & (-458753);
                Arrangement$Top$1 arrangement$Top$6 = OffsetKt.Top;
                i11 = i7;
                if ((i2 & 128) != 0) {
                    decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                    zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    flingBehavior4 = (DefaultFlingBehavior) objRememberedValue;
                    i10 = i11 & (-29818881);
                } else {
                    flingBehavior4 = flingBehavior2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect6 = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                i12 = i10 & (-1879048193);
                paddingValues4 = paddingValuesImpl;
                z5 = true;
                flingBehavior5 = flingBehavior4;
                arrangement$Horizontal3 = arrangement$End$6;
                lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                arrangement$Vertical3 = arrangement$Top$6;
                androidEdgeEffectOverscrollEffect3 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect6;
            } else {
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                    i7 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i15 != 0) {
                    paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                } else {
                    paddingValuesImpl = paddingValues2;
                }
                Arrangement$End$1 arrangement$End$7 = OffsetKt.Start;
                i10 = i7 & (-458753);
                Arrangement$Top$1 arrangement$Top$7 = OffsetKt.Top;
                i11 = i7;
                if ((i2 & 128) != 0) {
                    decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                    zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    flingBehavior4 = (DefaultFlingBehavior) objRememberedValue;
                    i10 = i11 & (-29818881);
                } else {
                    flingBehavior4 = flingBehavior2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect7 = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                i12 = i10 & (-1879048193);
                paddingValues4 = paddingValuesImpl;
                z5 = true;
                flingBehavior5 = flingBehavior4;
                arrangement$Horizontal3 = arrangement$End$7;
                lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                arrangement$Vertical3 = arrangement$Top$7;
                androidEdgeEffectOverscrollEffect3 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect7;
            }
            boolean z10 = z2;
            gapComposer2.endDefaults();
            int i26 = (i12 & 14) | 48;
            if (((i26 & 14) ^ 6) <= 4) {
            }
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (z6) {
                objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Fixed, arrangement$Vertical3, (byte) 8));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Fixed, arrangement$Vertical3, (byte) 8));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            GridSlotCache gridSlotCache4 = (GridSlotCache) objRememberedValue2;
            int i27 = i12 >> 3;
            gapComposer = gapComposer2;
            Arrangement$Vertical arrangement$Vertical7 = arrangement$Vertical3;
            UtilsKt.LazyGrid(modifier, lazyGridStateRememberLazyGridState, gridSlotCache4, paddingValues4, false, flingBehavior5, z10, androidEdgeEffectOverscrollEffect3, arrangement$Vertical7, arrangement$Horizontal3, lazyLayoutCacheWindow3, function1, gapComposer, (i27 & 29360128) | (i27 & 14) | 196608 | (i27 & 112) | (i12 & 7168) | 24576 | (3670016 & i27) | 805306368, 48 | ((i8 << 3) & 896));
            paddingValues3 = paddingValues4;
            flingBehavior3 = flingBehavior5;
            z4 = z10;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect3;
            arrangement$Vertical2 = arrangement$Vertical7;
            arrangement$Horizontal2 = arrangement$Horizontal3;
            lazyLayoutCacheWindow2 = lazyLayoutCacheWindow3;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            arrangement$Horizontal2 = arrangement$Horizontal;
            arrangement$Vertical2 = arrangement$Vertical;
            lazyLayoutCacheWindow2 = lazyLayoutCacheWindow;
            lazyGridStateRememberLazyGridState = lazyGridState2;
            paddingValues3 = paddingValues2;
            flingBehavior3 = flingBehavior2;
            z4 = z2;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifier, lazyGridStateRememberLazyGridState, paddingValues3, arrangement$Horizontal2, arrangement$Vertical2, flingBehavior3, z4, androidEdgeEffectOverscrollEffect2, lazyLayoutCacheWindow2, function1, (Composer) obj, iUpdateChangedFlags, i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0063  */
    /* JADX WARN: Code duplicated, block: B:30:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x009d  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00bb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:59:0x0131  */
    /* JADX WARN: Code duplicated, block: B:62:0x0148  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    public static final void LazyVerticalGrid(final GridCells$Adaptive gridCells$Adaptive, Modifier modifier, LazyGridState lazyGridState, final PaddingValues paddingValues, Arrangement$Vertical arrangement$Vertical, Arrangement$Horizontal arrangement$Horizontal, FlingBehavior flingBehavior, boolean z, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, LazyLayoutCacheWindow lazyLayoutCacheWindow, final Function1 function1, Composer composer, final int i, final int i2) {
        final LazyGridState lazyGridStateRememberLazyGridState;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z2;
        final Modifier modifier2;
        final Arrangement$Vertical arrangement$Vertical2;
        final Arrangement$Horizontal arrangement$Horizontal2;
        final FlingBehavior flingBehavior2;
        final boolean z3;
        final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2;
        final LazyLayoutCacheWindow lazyLayoutCacheWindow2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i7;
        DecayAnimationSpecImpl decayAnimationSpecImplRememberSplineBasedDecay;
        boolean zChanged;
        Object objRememberedValue;
        LazyLayoutCacheWindow lazyLayoutCacheWindow3;
        Modifier modifier3;
        Arrangement$Horizontal arrangement$Horizontal3;
        Arrangement$Vertical arrangement$Vertical3;
        int i8;
        boolean z4;
        boolean z5;
        Object objRememberedValue2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1784484862);
        int i9 = i | (gapComposer.changed(gridCells$Adaptive) ? 4 : 2) | 48;
        if ((i2 & 4) == 0) {
            lazyGridStateRememberLazyGridState = lazyGridState;
            int i10 = gapComposer.changed(lazyGridStateRememberLazyGridState) ? 256 : 128;
            int i11 = i9 | i10;
            if (gapComposer.changed(paddingValues)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i4 = i11 | i3 | 374956032;
            if (gapComposer.changedInstance(function1)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i6 = i5 | 6;
            if ((306783379 & i4) == 306783378 || (i6 & 19) != 18) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z2)) {
                gapComposer.startDefaults();
                i7 = i & 1;
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (i7 != 0 || gapComposer.getDefaultsInvalid()) {
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer);
                        i4 &= -897;
                    }
                    Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer);
                    zChanged = gapComposer.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                    lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                    modifier3 = Modifier.Companion.$$INSTANCE;
                    arrangement$Horizontal3 = arrangement$End$1;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                    arrangement$Vertical3 = arrangement$Top$1;
                    flingBehavior2 = (DefaultFlingBehavior) objRememberedValue;
                    i8 = i4 & (-1908867073);
                    z4 = true;
                } else {
                    gapComposer.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    modifier3 = modifier;
                    arrangement$Horizontal3 = arrangement$Horizontal;
                    flingBehavior2 = flingBehavior;
                    lazyLayoutCacheWindow3 = lazyLayoutCacheWindow;
                    arrangement$Vertical3 = arrangement$Vertical;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                    i8 = i4 & (-1908867073);
                    z4 = z;
                }
                gapComposer.endDefaults();
                int i12 = (i8 & 14) | 48;
                z5 = (((i12 & 14) ^ 6) <= 4 && gapComposer.changed(gridCells$Adaptive)) || (i12 & 6) == 4;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z5 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Adaptive, arrangement$Horizontal3, (byte) 7));
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                modifier2 = modifier3;
                z3 = z4;
                UtilsKt.LazyGrid(modifier2, lazyGridStateRememberLazyGridState, (GridSlotCache) objRememberedValue2, paddingValues, true, flingBehavior2, z3, androidEdgeEffectOverscrollEffect2, arrangement$Vertical3, arrangement$Horizontal3, lazyLayoutCacheWindow3, function1, gapComposer, (i8 & 7168) | ((i8 >> 3) & 112) | 196614 | 12607488, ((i6 << 3) & 896) | 54);
                arrangement$Vertical2 = arrangement$Vertical3;
                arrangement$Horizontal2 = arrangement$Horizontal3;
                lazyLayoutCacheWindow2 = lazyLayoutCacheWindow3;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                arrangement$Vertical2 = arrangement$Vertical;
                arrangement$Horizontal2 = arrangement$Horizontal;
                flingBehavior2 = flingBehavior;
                z3 = z;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                lazyLayoutCacheWindow2 = lazyLayoutCacheWindow;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2(modifier2, lazyGridStateRememberLazyGridState, paddingValues, arrangement$Vertical2, arrangement$Horizontal2, flingBehavior2, z3, androidEdgeEffectOverscrollEffect2, lazyLayoutCacheWindow2, function1, i, i2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda0
                    public final /* synthetic */ Modifier f$1;
                    public final /* synthetic */ LazyLayoutCacheWindow f$10;
                    public final /* synthetic */ Function1 f$11;
                    public final /* synthetic */ short f$14;
                    public final /* synthetic */ LazyGridState f$2;
                    public final /* synthetic */ PaddingValues f$3;
                    public final /* synthetic */ Arrangement$Vertical f$5;
                    public final /* synthetic */ Arrangement$Horizontal f$6;
                    public final /* synthetic */ FlingBehavior f$7;
                    public final /* synthetic */ boolean f$8;
                    public final /* synthetic */ AndroidEdgeEffectOverscrollEffect f$9;

                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.f$14 = i2;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                        LifecyclesKt.LazyVerticalGrid(this.f$0, this.f$1, this.f$2, this.f$3, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, (Composer) obj, iUpdateChangedFlags, this.f$14);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        lazyGridStateRememberLazyGridState = lazyGridState;
        int i13 = i9 | i10;
        if (gapComposer.changed(paddingValues)) {
            i3 = 2048;
        } else {
            i3 = 1024;
        }
        i4 = i13 | i3 | 374956032;
        if (gapComposer.changedInstance(function1)) {
            i5 = 32;
        } else {
            i5 = 16;
        }
        i6 = i5 | 6;
        if ((306783379 & i4) == 306783378) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (gapComposer.shouldExecute(i4 & 1, z2)) {
            gapComposer.startDefaults();
            i7 = i & 1;
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (i7 != 0) {
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer);
                    i4 &= -897;
                }
                Arrangement$Top$1 arrangement$Top$2 = OffsetKt.Top;
                Arrangement$End$1 arrangement$End$2 = OffsetKt.Start;
                decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer);
                zChanged = gapComposer.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect2 = OverscrollKt.rememberOverscrollEffect(gapComposer);
                lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                modifier3 = Modifier.Companion.$$INSTANCE;
                arrangement$Horizontal3 = arrangement$End$2;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect2;
                arrangement$Vertical3 = arrangement$Top$2;
                flingBehavior2 = (DefaultFlingBehavior) objRememberedValue;
                i8 = i4 & (-1908867073);
                z4 = true;
            } else {
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer);
                    i4 &= -897;
                }
                Arrangement$Top$1 arrangement$Top$3 = OffsetKt.Top;
                Arrangement$End$1 arrangement$End$3 = OffsetKt.Start;
                decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer);
                zChanged = gapComposer.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect3 = OverscrollKt.rememberOverscrollEffect(gapComposer);
                lazyLayoutCacheWindow3 = DefaultLazyGridCacheWindow.INSTANCE;
                modifier3 = Modifier.Companion.$$INSTANCE;
                arrangement$Horizontal3 = arrangement$End$3;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect3;
                arrangement$Vertical3 = arrangement$Top$3;
                flingBehavior2 = (DefaultFlingBehavior) objRememberedValue;
                i8 = i4 & (-1908867073);
                z4 = true;
            }
            gapComposer.endDefaults();
            int i14 = (i8 & 14) | 48;
            if (((i14 & 14) ^ 6) <= 4) {
            }
            objRememberedValue2 = gapComposer.rememberedValue();
            if (z5) {
                objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Adaptive, arrangement$Horizontal3, (byte) 7));
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new GridSlotCache(new ButtonKt$$ExternalSyntheticLambda1(gridCells$Adaptive, arrangement$Horizontal3, (byte) 7));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            modifier2 = modifier3;
            z3 = z4;
            UtilsKt.LazyGrid(modifier2, lazyGridStateRememberLazyGridState, (GridSlotCache) objRememberedValue2, paddingValues, true, flingBehavior2, z3, androidEdgeEffectOverscrollEffect2, arrangement$Vertical3, arrangement$Horizontal3, lazyLayoutCacheWindow3, function1, gapComposer, (i8 & 7168) | ((i8 >> 3) & 112) | 196614 | 12607488, ((i6 << 3) & 896) | 54);
            arrangement$Vertical2 = arrangement$Vertical3;
            arrangement$Horizontal2 = arrangement$Horizontal3;
            lazyLayoutCacheWindow2 = lazyLayoutCacheWindow3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            arrangement$Vertical2 = arrangement$Vertical;
            arrangement$Horizontal2 = arrangement$Horizontal;
            flingBehavior2 = flingBehavior;
            z3 = z;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            lazyLayoutCacheWindow2 = lazyLayoutCacheWindow;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(modifier2, lazyGridStateRememberLazyGridState, paddingValues, arrangement$Vertical2, arrangement$Horizontal2, flingBehavior2, z3, androidEdgeEffectOverscrollEffect2, lazyLayoutCacheWindow2, function1, i, i2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda0
                public final /* synthetic */ Modifier f$1;
                public final /* synthetic */ LazyLayoutCacheWindow f$10;
                public final /* synthetic */ Function1 f$11;
                public final /* synthetic */ short f$14;
                public final /* synthetic */ LazyGridState f$2;
                public final /* synthetic */ PaddingValues f$3;
                public final /* synthetic */ Arrangement$Vertical f$5;
                public final /* synthetic */ Arrangement$Horizontal f$6;
                public final /* synthetic */ FlingBehavior f$7;
                public final /* synthetic */ boolean f$8;
                public final /* synthetic */ AndroidEdgeEffectOverscrollEffect f$9;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f$14 = i2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    LifecyclesKt.LazyVerticalGrid(this.f$0, this.f$1, this.f$2, this.f$3, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, (Composer) obj, iUpdateChangedFlags, this.f$14);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void LifecycleStartEffect(Boolean bool, Object obj, LifecycleOwner lifecycleOwner, Function1 function1, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(696924721);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(bool) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(obj) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                lifecycleOwner = (LifecycleOwner) gapComposer.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
            } else {
                gapComposer.skipToGroupEnd();
            }
            int i3 = i2 & (-897);
            gapComposer.endDefaults();
            boolean zChanged = gapComposer.changed(bool) | gapComposer.changed(obj) | gapComposer.changed(lifecycleOwner);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, gapComposer, (i3 >> 3) & 896);
        } else {
            gapComposer.skipToGroupEnd();
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LifecycleEffectKt$$ExternalSyntheticLambda0(bool, obj, lifecycleOwner2, function1, i, (byte) 0);
        }
    }

    public static final void LifecycleStartEffectImpl(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Function1 function1, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(228371534);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(lifecycleStartStopEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean zChangedInstance = gapComposer.changedInstance(lifecycleStartStopEffectScope) | ((i2 & 896) == 256) | gapComposer.changedInstance(lifecycleOwner);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new UtilsKt$$ExternalSyntheticLambda0((Object) lifecycleOwner, (Object) lifecycleStartStopEffectScope, (Object) function1, (byte) 26);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.DisposableEffect(lifecycleOwner, lifecycleStartStopEffectScope, (Function1) objRememberedValue, gapComposer);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 14, i, (Object) lifecycleOwner, (Object) lifecycleStartStopEffectScope, (Object) function1);
        }
    }

    public static final void PredictiveBackHandler(boolean z, Function2 function2, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1818896922);
        byte b = 2;
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changedInstance(function2) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            SQLite.PredictiveBackHandler(z, function2, gapComposer, i2 & 126, 0);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HttpRequestRetryConfig$$ExternalSyntheticLambda5(z, function2, i, b);
        }
    }

    /* JADX INFO: renamed from: add-impl, reason: not valid java name */
    public static final void m884addimpl(MutableIntList mutableIntList, int i) {
        if (mutableIntList._size == 0 || !(mutableIntList.get(0) == i || mutableIntList.get(mutableIntList._size - 1) == i)) {
            int i2 = mutableIntList._size;
            mutableIntList.add(i);
            while (i2 > 0) {
                int i3 = ((i2 + 1) >>> 1) - 1;
                int i4 = mutableIntList.get(i3);
                if (i <= i4) {
                    break;
                }
                mutableIntList.set(i2, i4);
                i2 = i3;
            }
            mutableIntList.set(i2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0077  */
    /* JADX WARN: Code duplicated, block: B:35:0x0086  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitStarted(Lifecycle lifecycle, ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Lifecycle lifecycle2;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        LifecycleObserver lifecycleObserver;
        LifecycleObserver lifecycleObserver2;
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
        Unit unit = Unit.INSTANCE;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$ObjectRef = anonymousClass1.L$1;
            lifecycle2 = anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                lifecycleObserver2 = (LifecycleObserver) ref$ObjectRef.element;
                if (lifecycleObserver2 != null) {
                    lifecycle2.removeObserver(lifecycleObserver2);
                }
                return unit;
            } catch (Throwable th2) {
                th = th2;
                lifecycleObserver = (LifecycleObserver) ref$ObjectRef.element;
                if (lifecycleObserver != null) {
                    lifecycle2.removeObserver(lifecycleObserver);
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        if (((LifecycleRegistry) lifecycle).state.compareTo(Lifecycle.State.STARTED) >= 0) {
            return unit;
        }
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        try {
            anonymousClass1.L$0 = lifecycle;
            anonymousClass1.L$1 = ref$ObjectRef2;
            anonymousClass1.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(anonymousClass1));
            cancellableContinuationImpl.initCancellability();
            DefaultLifecycleObserver defaultLifecycleObserver = new DefaultLifecycleObserver() { // from class: coil3.util.LifecyclesKt$awaitStarted$2$1
                @Override // androidx.lifecycle.DefaultLifecycleObserver
                public final void onStart(LifecycleOwner lifecycleOwner) {
                    cancellableContinuationImpl.resumeWith(Unit.INSTANCE);
                }
            };
            ref$ObjectRef2.element = defaultLifecycleObserver;
            lifecycle.addObserver(defaultLifecycleObserver);
            Object result = cancellableContinuationImpl.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (result == coroutineSingletons) {
                return coroutineSingletons;
            }
            lifecycle2 = lifecycle;
            ref$ObjectRef = ref$ObjectRef2;
            lifecycleObserver2 = (LifecycleObserver) ref$ObjectRef.element;
            if (lifecycleObserver2 != null) {
                lifecycle2.removeObserver(lifecycleObserver2);
            }
            return unit;
        } catch (Throwable th3) {
            lifecycle2 = lifecycle;
            ref$ObjectRef = ref$ObjectRef2;
            th = th3;
            lifecycleObserver = (LifecycleObserver) ref$ObjectRef.element;
            if (lifecycleObserver != null) {
                lifecycle2.removeObserver(lifecycleObserver);
            }
            throw th;
        }
    }

    public static final ArrayList calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - ((i2 - 1) * i3);
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static final void checkElementIndex$runtime(int i, int i2) {
        if (i < 0 || i >= i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "index: ", ", size: "));
        }
    }

    public static final void checkPositionIndex$runtime(int i, int i2) {
        if (i < 0 || i > i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "index: ", ", size: "));
        }
    }

    public static final void checkRangeIndexes$runtime(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m3m(i, "fromIndex: ", ", toIndex: ", i2, ", size: "), i3);
        } else {
            if (i <= i2) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "fromIndex: ", " > toIndex: "));
        }
    }

    public static void closeFileDescriptor(FileDescriptor fileDescriptor) {
        try {
            Os.close(fileDescriptor);
        } catch (ErrnoException e) {
            Log.e("ExifInterfaceUtils", "Error closing fd.", e);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x003e A[RETURN] */
    public static final int columnIndexOf(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        int columnCount = sQLiteStatement.getColumnCount();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= columnCount) {
                i2 = -1;
                break;
            }
            if (str.equals(sQLiteStatement.getColumnName(i2))) {
                break;
            }
            i2++;
        }
        if (i2 >= 0) {
            return i2;
        }
        String strM = Format$$ExternalSyntheticOutline0.m('`', "`", str);
        int columnCount2 = sQLiteStatement.getColumnCount();
        while (i < columnCount2) {
            if (strM.equals(sQLiteStatement.getColumnName(i))) {
                if (i >= 0) {
                    return i;
                }
                return -1;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            return i;
        }
        return -1;
    }

    /* JADX INFO: renamed from: contains-Uv8p0NA, reason: not valid java name */
    public static final boolean m885containsUv8p0NA(DragAndDropNode dragAndDropNode, long j) {
        if (!dragAndDropNode.node.isAttached) {
            return false;
        }
        InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) HitTestResultKt.requireLayoutNode(dragAndDropNode).nodes.innerCoordinator;
        if (!innerNodeCoordinator.tail.isAttached) {
            return false;
        }
        long jMo606localToRootMKHz9U = innerNodeCoordinator.mo606localToRootMKHz9U(0L);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jMo606localToRootMKHz9U >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo606localToRootMKHz9U & 4294967295L));
        long j2 = dragAndDropNode.size;
        float f = ((int) (j2 >> 32)) + fIntBitsToFloat;
        float f2 = ((int) (j2 & 4294967295L)) + fIntBitsToFloat2;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j >> 32));
        if (fIntBitsToFloat > fIntBitsToFloat3 || fIntBitsToFloat3 > f) {
            return false;
        }
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & 4294967295L));
        return fIntBitsToFloat2 <= fIntBitsToFloat4 && fIntBitsToFloat4 <= f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] convertToLongArray(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static void copy(ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[8192];
        while (i > 0) {
            int iMin = Math.min(i, 8192);
            int i2 = byteOrderedDataInputStream.read(bArr, 0, iMin);
            if (i2 != iMin) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Failed to copy the given amount of bytes from the inputstream to the output stream.");
                return;
            } else {
                i -= i2;
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    public static final FlowUtil$createFlow$$inlined$map$1 createFlow(RoomDatabase roomDatabase, boolean z, String[] strArr, Function1 function1) {
        Pair pair;
        roomDatabase.getClass();
        InvalidationTracker invalidationTracker = roomDatabase.getInvalidationTracker();
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        IntMath.throwIfClosed(invalidationTracker.database);
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = invalidationTracker.implementation;
        triggerBasedInvalidationTracker.getClass();
        SetBuilder setBuilder = new SetBuilder();
        byte b = 0;
        for (String str : strArr2) {
            LinkedHashMap linkedHashMap = triggerBasedInvalidationTracker.viewTables;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Set set = (Set) linkedHashMap.get(lowerCase);
            if (set != null) {
                setBuilder.addAll(set);
            } else {
                setBuilder.add(str);
            }
        }
        String[] strArr3 = (String[]) CharsKt.build(setBuilder).toArray(new String[0]);
        int length = strArr3.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArr3[i];
            LinkedHashMap linkedHashMap2 = triggerBasedInvalidationTracker.tableIdLookup;
            String lowerCase2 = str2.toLowerCase(Locale.ROOT);
            lowerCase2.getClass();
            Integer num = (Integer) linkedHashMap2.get(lowerCase2);
            if (num == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("There is no table with name ".concat(str2));
                pair = null;
                String[] strArr4 = (String[]) pair.first;
                int[] iArr2 = (int[]) pair.second;
                strArr4.getClass();
                iArr2.getClass();
                Continuation continuation = null;
                return new FlowUtil$createFlow$$inlined$map$1(StateFlowKt.buffer$default(new DownloadUtil$getDownload$$inlined$map$1(new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(new SyncUtils.AnonymousClass3(invalidationTracker, continuation, (byte) 4), new SafeFlow(b, new NavHostKt$NavHost$29$1((Object) triggerBasedInvalidationTracker, (Object) iArr2, (Object) strArr4, continuation, (byte) 5))), new InvalidationTracker$createFlow$2(invalidationTracker, continuation, b), (byte) 5), -1), roomDatabase, z, function1);
            }
            iArr[i] = num.intValue();
        }
        pair = new Pair(strArr3, iArr);
        String[] strArr5 = (String[]) pair.first;
        int[] iArr3 = (int[]) pair.second;
        strArr5.getClass();
        iArr3.getClass();
        Continuation continuation2 = null;
        return new FlowUtil$createFlow$$inlined$map$1(StateFlowKt.buffer$default(new DownloadUtil$getDownload$$inlined$map$1(new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(new SyncUtils.AnonymousClass3(invalidationTracker, continuation2, (byte) 4), new SafeFlow(b, new NavHostKt$NavHost$29$1((Object) triggerBasedInvalidationTracker, (Object) iArr3, (Object) strArr5, continuation2, (byte) 5))), new InvalidationTracker$createFlow$2(invalidationTracker, continuation2, b), (byte) 5), -1), roomDatabase, z, function1);
    }

    public static boolean doesDisplaySupportDolbyVision(Context context) {
        Display.HdrCapabilities hdrCapabilities;
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null || !display.isHdr() || (hdrCapabilities = display.getHdrCapabilities()) == null) {
            return false;
        }
        for (int i : hdrCapabilities.getSupportedHdrTypes()) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    public static final void drawLayer(DrawScope drawScope, GraphicsLayer graphicsLayer) {
        boolean z;
        Canvas canvas2;
        float f;
        androidx.compose.ui.graphics.Canvas canvas3 = drawScope.getDrawContext().getCanvas();
        GraphicsLayer graphicsLayer2 = (GraphicsLayer) drawScope.getDrawContext().mMetadataRepo;
        GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
        if (graphicsLayer.isReleased) {
            return;
        }
        long j = graphicsLayer.roundRectOutlineTopLeft;
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas3);
        boolean zIsHardwareAccelerated = nativeCanvas.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            long j2 = graphicsLayer.topLeft;
            float f2 = (int) (j2 >> 32);
            float f3 = f2 - graphicsLayer.outsetLeft;
            float f4 = (int) (j2 & 4294967295L);
            float f5 = f4 - graphicsLayer.outsetTop;
            long j3 = graphicsLayer.size;
            float f6 = f2 + ((int) (j3 >> 32)) + graphicsLayer.outsetRight;
            float f7 = f4 + ((int) (j3 & 4294967295L)) + graphicsLayer.outsetBottom;
            float alpha = graphicsLayerImpl.getAlpha();
            BlendModeColorFilter colorFilter = graphicsLayerImpl.getColorFilter();
            int iMo560getBlendMode0nO6VwU = graphicsLayerImpl.mo560getBlendMode0nO6VwU();
            if (alpha >= 1.0f && iMo560getBlendMode0nO6VwU == 3 && colorFilter == null) {
                canvas2 = nativeCanvas;
                if (graphicsLayerImpl.mo561getCompositingStrategyke2Ky5w() != 1) {
                    canvas2.save();
                    f = f3;
                    nativeCanvas = canvas2;
                }
                nativeCanvas.translate(f, f5);
                Matrix matrixCalculateMatrix = graphicsLayerImpl.calculateMatrix();
                matrixCalculateMatrix.preTranslate(graphicsLayer.outsetLeft, graphicsLayer.outsetTop);
                nativeCanvas.concat(matrixCalculateMatrix);
                graphicsLayer.roundRectOutlineTopLeft = Offset.m438minusMKHz9U(graphicsLayer.roundRectOutlineTopLeft, (((long) Float.floatToRawIntBits(graphicsLayer.outsetTop)) & 4294967295L) | (((long) Float.floatToRawIntBits(graphicsLayer.outsetLeft)) << 32));
            } else {
                canvas2 = nativeCanvas;
            }
            AndroidPaint androidPaintPaint = graphicsLayer.softwareLayerPaint;
            if (androidPaintPaint == null) {
                androidPaintPaint = ColorKt.Paint();
                graphicsLayer.softwareLayerPaint = androidPaintPaint;
            }
            androidPaintPaint.setAlpha(alpha);
            androidPaintPaint.m463setBlendModes9anfk8(iMo560getBlendMode0nO6VwU);
            androidPaintPaint.setColorFilter(colorFilter);
            Paint paint = androidPaintPaint.internalPaint;
            f = f3;
            nativeCanvas = canvas2;
            nativeCanvas.saveLayer(f, f5, f6, f7, paint);
            nativeCanvas.translate(f, f5);
            Matrix matrixCalculateMatrix2 = graphicsLayerImpl.calculateMatrix();
            matrixCalculateMatrix2.preTranslate(graphicsLayer.outsetLeft, graphicsLayer.outsetTop);
            nativeCanvas.concat(matrixCalculateMatrix2);
            graphicsLayer.roundRectOutlineTopLeft = Offset.m438minusMKHz9U(graphicsLayer.roundRectOutlineTopLeft, (((long) Float.floatToRawIntBits(graphicsLayer.outsetTop)) & 4294967295L) | (((long) Float.floatToRawIntBits(graphicsLayer.outsetLeft)) << 32));
        }
        graphicsLayer.configureOutlineAndClip();
        if (!graphicsLayerImpl.getHasDisplayList()) {
            try {
                graphicsLayer.impl.record(graphicsLayer.density, graphicsLayer.layoutDirection, graphicsLayer, graphicsLayer.clipDrawBlock);
            } catch (Throwable unused) {
            }
        }
        boolean z2 = graphicsLayerImpl.getShadowElevation() > CropImageView.DEFAULT_ASPECT_RATIO;
        if (z2) {
            canvas3.enableZ();
        }
        boolean z3 = !zIsHardwareAccelerated && graphicsLayer.clip;
        if (z3) {
            canvas3.save();
            ColorKt outline = graphicsLayer.getOutline();
            if (outline instanceof Outline$Rectangle) {
                Rect rect = ((Outline$Rectangle) outline).rect;
                canvas3.mo453clipRectN_I0leg(rect.left, rect.top, rect.right, rect.bottom, 1);
            } else if (outline instanceof Outline$Rounded) {
                AndroidPath androidPathPath = graphicsLayer.roundRectClipPath;
                if (androidPathPath != null) {
                    androidPathPath.rewind();
                } else {
                    androidPathPath = AndroidPath_androidKt.Path();
                    graphicsLayer.roundRectClipPath = androidPathPath;
                }
                AndroidPath.addRoundRect$default(androidPathPath, ((Outline$Rounded) outline).roundRect);
                canvas3.mo452clipPathmtrdDE(androidPathPath);
            } else {
                if (!(outline instanceof Outline$Generic)) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                canvas3.mo452clipPathmtrdDE(((Outline$Generic) outline).path);
            }
        }
        if (graphicsLayer2 != null) {
            Cache.RealCacheRequest realCacheRequest = graphicsLayer2.childDependenciesTracker;
            if (!realCacheRequest.done) {
                InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) realCacheRequest.body;
            if (mutableScatterSet != null) {
                mutableScatterSet.add(graphicsLayer);
            } else if (((GraphicsLayer) realCacheRequest.editor) != null) {
                MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                MutableScatterSet mutableScatterSet3 = new MutableScatterSet();
                GraphicsLayer graphicsLayer3 = (GraphicsLayer) realCacheRequest.editor;
                graphicsLayer3.getClass();
                mutableScatterSet3.add(graphicsLayer3);
                mutableScatterSet3.add(graphicsLayer);
                realCacheRequest.body = mutableScatterSet3;
                realCacheRequest.editor = null;
            } else {
                realCacheRequest.editor = graphicsLayer;
            }
            MutableScatterSet mutableScatterSet4 = (MutableScatterSet) realCacheRequest.this$0;
            if (mutableScatterSet4 != null) {
                z = !mutableScatterSet4.remove(graphicsLayer);
            } else if (((GraphicsLayer) realCacheRequest.cacheOut) != graphicsLayer) {
                z = true;
            } else {
                realCacheRequest.cacheOut = null;
                z = false;
            }
            if (z) {
                graphicsLayer.parentLayerUsages++;
            }
        }
        if (((AndroidCanvas) canvas3).internalCanvas.isHardwareAccelerated()) {
            graphicsLayerImpl.draw(canvas3);
        } else {
            CanvasDrawScope canvasDrawScope2 = graphicsLayer.softwareDrawScope;
            if (canvasDrawScope2 == null) {
                canvasDrawScope2 = new CanvasDrawScope();
                graphicsLayer.softwareDrawScope = canvasDrawScope2;
            }
            EmojiProcessor emojiProcessor = canvasDrawScope2.drawContext;
            Density density = graphicsLayer.density;
            LayoutDirection layoutDirection = graphicsLayer.layoutDirection;
            long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(graphicsLayer.size);
            Density density2 = emojiProcessor.getDensity();
            LayoutDirection layoutDirection2 = emojiProcessor.getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvas4 = emojiProcessor.getCanvas();
            long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
            GraphicsLayer graphicsLayer4 = (GraphicsLayer) emojiProcessor.mMetadataRepo;
            emojiProcessor.setDensity(density);
            emojiProcessor.setLayoutDirection(layoutDirection);
            emojiProcessor.setCanvas(canvas3);
            emojiProcessor.m832setSizeuvyYCjk(jM876toSizeozmzZPI);
            emojiProcessor.mMetadataRepo = graphicsLayer;
            canvas3.save();
            try {
                graphicsLayer.drawWithChildTracking(canvasDrawScope2);
                canvas3.restore();
                emojiProcessor.setDensity(density2);
                emojiProcessor.setLayoutDirection(layoutDirection2);
                emojiProcessor.setCanvas(canvas4);
                emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
                emojiProcessor.mMetadataRepo = graphicsLayer4;
            } catch (Throwable th) {
                canvas3.restore();
                emojiProcessor.setDensity(density2);
                emojiProcessor.setLayoutDirection(layoutDirection2);
                emojiProcessor.setCanvas(canvas4);
                emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
                emojiProcessor.mMetadataRepo = graphicsLayer4;
                throw th;
            }
        }
        if (z3) {
            canvas3.restore();
        }
        if (z2) {
            canvas3.disableZ();
        }
        if (!zIsHardwareAccelerated) {
            nativeCanvas.restore();
        }
        graphicsLayer.roundRectOutlineTopLeft = j;
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        char c;
        int length = str.length();
        if (str == str2) {
            return true;
        }
        if (length == str2.length()) {
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                char cCharAt2 = str2.charAt(i);
                if (cCharAt == cCharAt2 || ((c = (char) ((cCharAt | ' ') - 97)) < 26 && c == ((char) ((cCharAt2 | ' ') - 97)))) {
                }
            }
            return true;
        }
        return false;
    }

    public static String escapeBytes(ByteString$LiteralByteString byteString$LiteralByteString) {
        StringBuilder sb = new StringBuilder(byteString$LiteralByteString.size());
        for (int i = 0; i < byteString$LiteralByteString.size(); i++) {
            byte bByteAt = byteString$LiteralByteString.byteAt(i);
            if (bByteAt == 34) {
                sb.append("\\\"");
            } else if (bByteAt == 39) {
                sb.append("\\'");
            } else if (bByteAt != 92) {
                switch (bByteAt) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bByteAt < 32 || bByteAt > 126) {
                            sb.append('\\');
                            sb.append((char) (((bByteAt >>> 6) & 3) + 48));
                            sb.append((char) (((bByteAt >>> 3) & 7) + 48));
                            sb.append((char) ((bByteAt & 7) + 48));
                        } else {
                            sb.append((char) bByteAt);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static final float fastCbrt(float f) {
        float fIntBitsToFloat = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(f)) & 8589934591L) / 3)) + 709952852);
        float f2 = fIntBitsToFloat - ((fIntBitsToFloat - (f / (fIntBitsToFloat * fIntBitsToFloat))) * 0.33333334f);
        return f2 - ((f2 - (f / (f2 * f2))) * 0.33333334f);
    }

    /* JADX INFO: renamed from: getAndMeasure-G5IdpRk, reason: not valid java name */
    public static final MeasuredPage m886getAndMeasureG5IdpRk(LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, int i2, MutableIntObjectMap mutableIntObjectMap) {
        List list;
        Object key = pagerLazyLayoutItemProvider.getKey(i);
        List list2 = (List) mutableIntObjectMap.get(i);
        if (list2 != null) {
            list = list2;
        } else {
            List listCompose = lazyLayoutMeasureScopeImpl.compose(i);
            int size = listCompose.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(((Measurable) listCompose.get(i3)).mo598measureBRTryo0(j));
            }
            mutableIntObjectMap.set(i, arrayList);
            list = arrayList;
        }
        return new MeasuredPage(i, i2, list, j2, key, orientation, horizontal, vertical, layoutDirection);
    }

    public static Object getParcelable(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return BundleCompat$Api33Impl.getParcelable(bundle, str, cls);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static final int lerp(float f, int i, int i2) {
        return i + ((int) Math.round(((double) (i2 - i)) * ((double) f)));
    }

    public static final NavOptions navOptions(Function1 function1) {
        int i;
        boolean z;
        boolean z2;
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        function1.invoke(navOptionsBuilder);
        boolean z3 = navOptionsBuilder.launchSingleTop;
        boolean z4 = navOptionsBuilder.restoreState;
        String str = navOptionsBuilder.popUpToRoute;
        NavOptions.Builder builder = navOptionsBuilder.builder;
        if (str != null) {
            z = navOptionsBuilder.inclusive;
            z2 = navOptionsBuilder.saveState;
            builder.popUpToRoute = str;
            i = -1;
        } else {
            i = navOptionsBuilder.popUpToId;
            z = navOptionsBuilder.inclusive;
            z2 = navOptionsBuilder.saveState;
            builder.popUpToRoute = null;
        }
        boolean z5 = z2;
        boolean z6 = z;
        int i2 = i;
        String str2 = builder.popUpToRoute;
        int i3 = builder.enterAnim;
        if (str2 == null) {
            return new NavOptions(z3, z4, i2, z6, z5, i3, builder.exitAnim);
        }
        int i4 = builder.exitAnim;
        int i5 = NavDestination.$r8$clinit;
        NavOptions navOptions = new NavOptions(z3, z4, "android-app://androidx.navigation/".concat(str2).hashCode(), z6, z5, i3, i4);
        navOptions.popUpToRoute = str2;
        return navOptions;
    }

    public static final int offsetOnMainAxis(LazyGridMeasuredItem lazyGridMeasuredItem, Orientation orientation) {
        return (int) (orientation == Orientation.Vertical ? lazyGridMeasuredItem.offset & 4294967295L : lazyGridMeasuredItem.offset >> 32);
    }

    /* JADX INFO: renamed from: putStringList-impl, reason: not valid java name */
    public static final void m887putStringListimpl(Bundle bundle, String str, List list) {
        bundle.putStringArrayList(str, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
    }

    public static NetworkResponse readFrom(RealBufferedSource realBufferedSource) {
        int i = Integer.parseInt(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
        long j = Long.parseLong(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
        long j2 = Long.parseLong(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = Integer.parseInt(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
        for (int i3 = 0; i3 < i2; i3++) {
            String utf8LineStrict = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            int iIndexOf$default = StringsKt.indexOf$default(utf8LineStrict, ':', 0, 6);
            if (iIndexOf$default == -1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) "Unexpected header: ".concat(utf8LineStrict));
                return null;
            }
            String string = StringsKt.trim(utf8LineStrict.substring(0, iIndexOf$default)).toString();
            String strSubstring = utf8LineStrict.substring(iIndexOf$default + 1);
            String lowerCase = string.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Object arrayList = linkedHashMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lowerCase, arrayList);
            }
            ((List) arrayList).add(strSubstring);
        }
        return new NetworkResponse(i, j, j2, new NetworkHeaders(MapsKt__MapsKt.toMap(linkedHashMap)), null, null);
    }

    public static Object readTypedObject(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static final ManagedActivityResultLauncher rememberLauncherForActivityResult(ActivityResultContract activityResultContract, Function1 function1, Composer composer, int i) {
        ActivityResultContract activityResultContract2;
        Stack.rememberUpdatedState(activityResultContract, composer);
        MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function1, composer);
        Object[] objArr = new Object[0];
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new ScrollKt$$ExternalSyntheticLambda0((byte) 1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        String str = (String) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer, 48);
        ActivityResultRegistryOwner activityResultRegistryOwner = (ActivityResultRegistryOwner) gapComposer.consume(LocalActivityResultRegistryOwner.LocalComposition);
        if (activityResultRegistryOwner == null) {
            gapComposer.startReplaceGroup(1213380307);
            Object baseContext = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof ActivityResultRegistryOwner) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            activityResultRegistryOwner = (ActivityResultRegistryOwner) baseContext;
        } else {
            gapComposer.startReplaceGroup(1213379439);
        }
        gapComposer.end(false);
        if (activityResultRegistryOwner == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
            return null;
        }
        ActivityResultRegistry activityResultRegistry = activityResultRegistryOwner.getActivityResultRegistry();
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new ActivityResultLauncherHolder();
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) objRememberedValue2;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new ManagedActivityResultLauncher(activityResultLauncherHolder);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) objRememberedValue3;
        boolean zChangedInstance = gapComposer.changedInstance(activityResultLauncherHolder) | gapComposer.changedInstance(activityResultRegistry) | gapComposer.changed(str) | gapComposer.changedInstance(activityResultContract) | gapComposer.changed(mutableStateRememberUpdatedState);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
            activityResultContract2 = activityResultContract;
            objRememberedValue4 = new AlbumMenuKt$$ExternalSyntheticLambda40(activityResultLauncherHolder, activityResultRegistry, str, activityResultContract2, mutableStateRememberUpdatedState);
            gapComposer.updateRememberedValue(objRememberedValue4);
        } else {
            activityResultContract2 = activityResultContract;
        }
        Function1 function2 = (Function1) objRememberedValue4;
        boolean zChanged = gapComposer.changed(activityResultRegistry) | gapComposer.changed(str) | gapComposer.changed(activityResultContract2);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue5 == neverEqualPolicy) {
            objRememberedValue5 = new DisposableEffectImpl(function2);
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        return managedActivityResultLauncher;
    }

    public static final int sizeOnMainAxis(LazyGridMeasuredItem lazyGridMeasuredItem, Orientation orientation) {
        return (int) (orientation == Orientation.Vertical ? lazyGridMeasuredItem.size & 4294967295L : lazyGridMeasuredItem.size >> 32);
    }

    public static boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr.length >= bArr2.length) {
            for (int i = 0; i < bArr2.length; i++) {
                if (bArr[i] == bArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: takeMax-impl, reason: not valid java name */
    public static final int m888takeMaximpl(MutableIntList mutableIntList) {
        int i;
        int i2 = mutableIntList._size;
        int i3 = mutableIntList.get(0);
        while (mutableIntList._size != 0 && mutableIntList.get(0) == i3) {
            mutableIntList.set(0, mutableIntList.last());
            mutableIntList.removeAt(mutableIntList._size - 1);
            int i4 = mutableIntList._size;
            int i5 = i4 >>> 1;
            int i6 = 0;
            while (i6 < i5) {
                int i7 = mutableIntList.get(i6);
                int i8 = (i6 + 1) * 2;
                int i9 = i8 - 1;
                int i10 = mutableIntList.get(i9);
                if (i8 < i4 && (i = mutableIntList.get(i8)) > i10) {
                    if (i <= i7) {
                        break;
                    }
                    mutableIntList.set(i6, i);
                    mutableIntList.set(i8, i7);
                    i6 = i8;
                } else {
                    if (i10 <= i7) {
                        break;
                    }
                    mutableIntList.set(i6, i10);
                    mutableIntList.set(i9, i7);
                    i6 = i9;
                }
            }
        }
        return i3;
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (isUpperCase(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (isUpperCase(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String toUpperCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (c >= 'a' && c <= 'z') {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static Bundle unparcelWithClassLoader(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(LifecyclesKt.class.getClassLoader());
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m889updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM742getLengthimpl;
        int iM744getMinimpl = TextRange.m744getMinimpl(j);
        int iM743getMaximpl = TextRange.m743getMaximpl(j);
        if ((TextRange.m744getMinimpl(j2) < TextRange.m743getMaximpl(j)) && (TextRange.m744getMinimpl(j) < TextRange.m743getMaximpl(j2))) {
            if ((TextRange.m744getMinimpl(j2) <= TextRange.m744getMinimpl(j)) && (TextRange.m743getMaximpl(j) <= TextRange.m743getMaximpl(j2))) {
                iM744getMinimpl = TextRange.m744getMinimpl(j2);
                iM743getMaximpl = iM744getMinimpl;
            } else {
                if ((TextRange.m744getMinimpl(j) <= TextRange.m744getMinimpl(j2)) && (TextRange.m743getMaximpl(j2) <= TextRange.m743getMaximpl(j))) {
                    iM742getLengthimpl = TextRange.m742getLengthimpl(j2);
                } else {
                    int iM744getMinimpl2 = TextRange.m744getMinimpl(j2);
                    if (iM744getMinimpl >= TextRange.m743getMaximpl(j2) || iM744getMinimpl2 > iM744getMinimpl) {
                        iM743getMaximpl = TextRange.m744getMinimpl(j2);
                    } else {
                        iM744getMinimpl = TextRange.m744getMinimpl(j2);
                        iM742getLengthimpl = TextRange.m742getLengthimpl(j2);
                    }
                }
                iM743getMaximpl -= iM742getLengthimpl;
            }
        } else if (iM743getMaximpl > TextRange.m744getMinimpl(j2)) {
            iM744getMinimpl -= TextRange.m742getLengthimpl(j2);
            iM742getLengthimpl = TextRange.m742getLengthimpl(j2);
            iM743getMaximpl -= iM742getLengthimpl;
        }
        return TextRangeKt.TextRange(iM744getMinimpl, iM743getMaximpl);
    }

    public static void writeTo(NetworkResponse networkResponse, RealBufferedSink realBufferedSink) {
        realBufferedSink.writeDecimalLong(networkResponse.code);
        realBufferedSink.writeByte(10);
        realBufferedSink.writeDecimalLong(networkResponse.requestMillis);
        realBufferedSink.writeByte(10);
        realBufferedSink.writeDecimalLong(networkResponse.responseMillis);
        realBufferedSink.writeByte(10);
        Set<Map.Entry> setEntrySet = networkResponse.headers.data.entrySet();
        Iterator it = setEntrySet.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((List) ((Map.Entry) it.next()).getValue()).size();
        }
        realBufferedSink.writeDecimalLong(size);
        realBufferedSink.writeByte(10);
        for (Map.Entry entry : setEntrySet) {
            for (String str : (List) entry.getValue()) {
                realBufferedSink.writeUtf8((String) entry.getKey());
                realBufferedSink.writeUtf8(ServerSentEventKt.COLON);
                realBufferedSink.writeUtf8(str);
                realBufferedSink.writeByte(10);
            }
        }
    }

    public static void writeTypedObject(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public abstract void hide();

    public abstract int next(int i);

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int i) {
        return next(i);
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int i) {
        int next = next(i);
        if (next == -1 || next(next) == -1) {
            return -1;
        }
        return next;
    }

    public abstract int previous(int i);

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int i) {
        int iPrevious = previous(i);
        if (iPrevious == -1 || previous(iPrevious) == -1) {
            return -1;
        }
        return iPrevious;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int i) {
        return previous(i);
    }

    public abstract void setAppearanceLightNavigationBars(boolean z);

    public abstract void setAppearanceLightStatusBars(boolean z);

    public abstract void setSystemBarsBehavior();

    public abstract void show();

    public static final float lerp(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }
}
